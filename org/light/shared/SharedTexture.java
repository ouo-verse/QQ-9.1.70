package org.light.shared;

import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.tencent.filter.GLSLRender;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.light.NativeBuffer;
import org.light.device.LightDeviceProperty;
import org.light.utils.LightGLUtils;
import org.light.utils.LightLogUtil;
import org.light.utils.SimpleRenderer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SharedTexture implements Parcelable {
    private static final String TAG = "SharedTexture";
    private ParcelFileDescriptor fenceFd;
    private HardwareBuffer hwb;
    private NativeBuffer nativeBuffer;
    private int originTextureId;
    private SimpleRenderer simpleRenderer;
    private int textureHeight;
    private int textureWidth;
    private static final ConcurrentHashMap<Integer, TexId> texMap = new ConcurrentHashMap<>();
    public static final Parcelable.Creator<SharedTexture> CREATOR = new Parcelable.Creator<SharedTexture>() { // from class: org.light.shared.SharedTexture.1
        @Override // android.os.Parcelable.Creator
        public SharedTexture createFromParcel(Parcel parcel) {
            return new SharedTexture(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SharedTexture[] newArray(int i3) {
            return new SharedTexture[i3];
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TexId {
        public AtomicLong refCnt;
        public int texId;

        public TexId(int i3, AtomicLong atomicLong) {
            this.texId = -1;
            new AtomicLong(0L);
            this.texId = i3;
            this.refCnt = atomicLong;
        }
    }

    public SharedTexture() {
        this.originTextureId = -1;
        this.textureWidth = 0;
        this.textureHeight = 0;
        this.nativeBuffer = null;
        this.simpleRenderer = null;
        this.hwb = null;
        this.fenceFd = null;
        if (ApiLevelHardwareBuffer()) {
            NativeBuffer.setFenceEnabled(true);
        }
    }

    public static boolean ApiLevelHardwareBuffer() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    private int acquireTexture() {
        int i3;
        ConcurrentHashMap<Integer, TexId> concurrentHashMap = texMap;
        synchronized (concurrentHashMap) {
            TexId texId = concurrentHashMap.get(Integer.valueOf(this.originTextureId));
            if (texId == null) {
                TexId texId2 = new TexId(LightGLUtils.createTexture(GLSLRender.GL_TEXTURE_2D), new AtomicLong(1L));
                concurrentHashMap.put(Integer.valueOf(this.originTextureId), texId2);
                texId = texId2;
            } else {
                texId.refCnt.getAndIncrement();
            }
            i3 = texId.texId;
        }
        return i3;
    }

    private void releaseTexture() {
        ConcurrentHashMap<Integer, TexId> concurrentHashMap = texMap;
        synchronized (concurrentHashMap) {
            int i3 = this.originTextureId;
            if (i3 > 0) {
                TexId texId = concurrentHashMap.get(Integer.valueOf(i3));
                if (texId != null && texId.refCnt.decrementAndGet() <= 0) {
                    concurrentHashMap.remove(Integer.valueOf(this.originTextureId));
                    LightGLUtils.deleteTexture(texId.texId);
                }
                this.originTextureId = -1;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        release();
    }

    public int getTexture() {
        if (ApiLevelHardwareBuffer() && this.hwb != null && this.originTextureId > 0) {
            try {
                NativeBuffer nativeBuffer = this.nativeBuffer;
                if (nativeBuffer != null) {
                    nativeBuffer.release();
                }
                this.nativeBuffer = new NativeBuffer(this.hwb);
                int acquireTexture = acquireTexture();
                this.nativeBuffer.bindTexture(acquireTexture);
                ParcelFileDescriptor parcelFileDescriptor = this.fenceFd;
                if (parcelFileDescriptor != null) {
                    this.nativeBuffer.waitFence(parcelFileDescriptor);
                    this.fenceFd.close();
                }
                this.fenceFd = null;
                return acquireTexture;
            } catch (Throwable th5) {
                LightLogUtil.e(TAG, "getTexture error:" + th5);
            }
        }
        return -1;
    }

    public void release() {
        try {
            HardwareBuffer hardwareBuffer = this.hwb;
            if (hardwareBuffer != null) {
                hardwareBuffer.close();
                this.hwb = null;
            }
            ParcelFileDescriptor parcelFileDescriptor = this.fenceFd;
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
                this.fenceFd = null;
            }
            SimpleRenderer simpleRenderer = this.simpleRenderer;
            if (simpleRenderer != null) {
                simpleRenderer.release();
                this.simpleRenderer = null;
            }
            NativeBuffer nativeBuffer = this.nativeBuffer;
            if (nativeBuffer != null) {
                nativeBuffer.release();
                this.nativeBuffer = null;
            }
            releaseTexture();
        } catch (Throwable th5) {
            LightLogUtil.e(TAG, "release error:" + th5);
        }
    }

    public void setTexture(int i3, int i16, int i17) {
        if (!ApiLevelHardwareBuffer()) {
            return;
        }
        try {
            if (this.originTextureId != i3) {
                releaseTexture();
            }
            this.originTextureId = i3;
            this.textureWidth = i16;
            this.textureHeight = i17;
            if (i3 <= 0) {
                return;
            }
            NativeBuffer nativeBuffer = this.nativeBuffer;
            if (nativeBuffer == null) {
                this.nativeBuffer = new NativeBuffer(i16, i17);
            } else {
                nativeBuffer.updateSize(i16, i17);
            }
            this.nativeBuffer.bindTexture(acquireTexture());
            this.hwb = this.nativeBuffer.getHardwareBuffer();
            if (this.simpleRenderer == null) {
                this.simpleRenderer = new SimpleRenderer();
            }
            this.simpleRenderer.setForHardwareBuffer(true);
            this.simpleRenderer.draw(this.originTextureId, this.nativeBuffer.getBindTexture(), i16, i17);
            ParcelFileDescriptor parcelFileDescriptor = this.fenceFd;
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
            this.fenceFd = this.nativeBuffer.createFence();
        } catch (Throwable th5) {
            LightLogUtil.e(TAG, "setTexture error:" + th5);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (!ApiLevelHardwareBuffer()) {
            return;
        }
        parcel.writeInt(this.originTextureId);
        parcel.writeInt(this.textureWidth);
        parcel.writeInt(this.textureHeight);
        parcel.writeParcelable(this.hwb, i3);
        parcel.writeParcelable(this.fenceFd, i3);
    }

    protected SharedTexture(Parcel parcel) {
        this.originTextureId = -1;
        this.textureWidth = 0;
        this.textureHeight = 0;
        this.nativeBuffer = null;
        this.simpleRenderer = null;
        this.hwb = null;
        this.fenceFd = null;
        if (ApiLevelHardwareBuffer()) {
            this.originTextureId = parcel.readInt();
            this.textureWidth = parcel.readInt();
            this.textureHeight = parcel.readInt();
            this.hwb = (HardwareBuffer) parcel.readParcelable(HardwareBuffer.class.getClassLoader());
            this.fenceFd = (ParcelFileDescriptor) parcel.readParcelable(ParcelFileDescriptor.class.getClassLoader());
        }
    }
}
