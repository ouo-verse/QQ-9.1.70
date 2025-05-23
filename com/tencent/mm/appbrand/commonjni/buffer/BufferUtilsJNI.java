package com.tencent.mm.appbrand.commonjni.buffer;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.a9.b;
import com.tencent.luggage.wxa.a9.f;
import java.io.IOException;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public final class BufferUtilsJNI {
    private static final String TAG = "MicroMsg.AppBrandCommBinding.BufferUtilsJNI";

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public static final class BufferHolderJNI {
        public long address;
        public long length;

        /* JADX INFO: Access modifiers changed from: private */
        public void releaseInternal() {
            synchronized (this) {
                try {
                    if (this.address != 0) {
                        BufferUtilsJNI.nativeReleaseBufferHolder(this);
                    }
                } finally {
                    this.address = 0L;
                }
            }
        }

        public void finalize() throws Throwable {
            releaseInternal();
            super.finalize();
        }
    }

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public static final class FileDescriptorJNI {

        /* renamed from: fd, reason: collision with root package name */
        public int f151685fd;
        public long length;
        public long startOffset;
    }

    static {
        b.a("wxa-runtime-binding");
    }

    BufferUtilsJNI() {
    }

    public static BufferHolderJNI createBufferHolderFromFileDescriptor(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor == null) {
            return null;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptor = assetFileDescriptor.getParcelFileDescriptor();
            try {
                FileDescriptorJNI fileDescriptorJNI = new FileDescriptorJNI();
                fileDescriptorJNI.f151685fd = parcelFileDescriptor.detachFd();
                fileDescriptorJNI.startOffset = assetFileDescriptor.getStartOffset();
                fileDescriptorJNI.length = assetFileDescriptor.getLength();
                BufferHolderJNI nativeCreateBufferHolderFromFileDescriptor = nativeCreateBufferHolderFromFileDescriptor(fileDescriptorJNI);
                parcelFileDescriptor.close();
                return nativeCreateBufferHolderFromFileDescriptor;
            } finally {
            }
        } catch (IOException e16) {
            f.a(TAG, "createDirectByteBufferFromScriptFileDescriptor parse fd get exception:%s", e16);
            return null;
        }
    }

    private static native BufferHolderJNI nativeCreateBufferHolderFromFileDescriptor(FileDescriptorJNI fileDescriptorJNI);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeReleaseBufferHolder(BufferHolderJNI bufferHolderJNI);

    public static void releaseBufferHolder(BufferHolderJNI bufferHolderJNI) {
        if (bufferHolderJNI != null) {
            bufferHolderJNI.releaseInternal();
        }
    }
}
