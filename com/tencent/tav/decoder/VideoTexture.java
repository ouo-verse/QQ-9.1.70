package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import com.tencent.tav.coremedia.TextureInfo;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoTexture implements SurfaceTexture.OnFrameAvailableListener {
    private Filter copyFilter;
    private boolean frameAvailable;
    private final Object frameSyncObject;
    private int preferRotation;
    private boolean quitFlag;
    private RenderContext renderContext;
    public float scaleX;
    public float scaleY;
    private SurfaceTexture surfaceTexture;
    private TextureInfo textureInfo;
    private Matrix textureMatrix;
    private int textureType;

    public VideoTexture(TextureInfo textureInfo) {
        this.frameSyncObject = new Object();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.quitFlag = false;
        this.preferRotation = 0;
        this.textureInfo = textureInfo;
        SurfaceTexture surfaceTexture = new SurfaceTexture(textureInfo.textureID);
        this.surfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
        this.surfaceTexture.getTransformMatrix(new float[16]);
        this.preferRotation = 0;
    }

    private Matrix getTextureMatrix(SurfaceTexture surfaceTexture, int i3) {
        float[] fArr = new float[16];
        surfaceTexture.getTransformMatrix(fArr);
        float f16 = fArr[0];
        float f17 = fArr[4];
        float f18 = fArr[12];
        float f19 = fArr[1];
        float f26 = fArr[5];
        float f27 = fArr[13];
        Matrix matrix = new Matrix();
        Matrix matrix2 = new Matrix();
        if (i3 != 0) {
            DecoderUtils.getRotationMatrix(matrix2, i3, 1.0f, 1.0f);
        }
        if (((int) f16) == f16 && ((int) f19) == f19 && ((int) f17) == f17 && ((int) f26) == f26) {
            matrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
            if (i3 != 0) {
                matrix.preConcat(matrix2);
            }
        } else {
            matrix.setValues(new float[]{f16, f17, f18, f19, f26, f27, 0.0f, 0.0f, 1.0f});
        }
        if (i3 != 0) {
            Matrix matrix3 = new Matrix();
            matrix2.invert(matrix3);
            matrix.postConcat(matrix3);
        }
        return matrix;
    }

    private boolean isIdentity() {
        Matrix matrix = this.textureMatrix;
        if (matrix != null && !matrix.isIdentity()) {
            return false;
        }
        return true;
    }

    private boolean isOES() {
        if (this.textureType == 36197) {
            return true;
        }
        return false;
    }

    private void reflectLooper() {
        Class<?> cls;
        Class<?>[] declaredClasses = SurfaceTexture.class.getDeclaredClasses();
        int length = declaredClasses.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                cls = declaredClasses[i3];
                if (cls.getName().toLowerCase().contains("handler")) {
                    break;
                } else {
                    i3++;
                }
            } else {
                cls = null;
                break;
            }
        }
        if (cls == null) {
            return;
        }
        try {
            Object newInstance = cls.getConstructor(SurfaceTexture.class, Looper.class).newInstance(this.surfaceTexture, Looper.getMainLooper());
            Field declaredField = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
            declaredField.setAccessible(true);
            declaredField.set(this.surfaceTexture, newInstance);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void releaseFilter() {
        Filter filter = this.copyFilter;
        if (filter != null) {
            filter.release();
        }
    }

    private void releaseTextureInfo() {
        TextureInfo textureInfo = this.textureInfo;
        if (textureInfo != null) {
            textureInfo.release();
            this.textureInfo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean awaitNewImage() {
        return awaitNewImage(3000L);
    }

    public TextureInfo copyTexture() {
        if (this.copyFilter == null) {
            Filter filter = new Filter();
            this.copyFilter = filter;
            filter.setRendererWidth(this.renderContext.width());
            this.copyFilter.setRendererHeight(this.renderContext.height());
            this.copyFilter.setRenderForScreen(false);
        }
        Filter filter2 = this.copyFilter;
        TextureInfo textureInfo = this.textureInfo;
        return filter2.applyFilter(textureInfo, null, textureInfo.getTextureMatrix());
    }

    public int getPreferRotation() {
        return this.preferRotation;
    }

    public RenderContext getRenderContext() {
        return this.renderContext;
    }

    public TextureInfo getTextureInfo() {
        return this.textureInfo;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.frameSyncObject) {
            if (this.frameAvailable) {
                new RuntimeException("frameAvailable already set, frame could be dropped").printStackTrace();
            } else {
                this.frameAvailable = true;
                this.frameSyncObject.notifyAll();
            }
        }
    }

    public void quitIfWaiting() {
        synchronized (this.frameSyncObject) {
            this.quitFlag = true;
            this.frameSyncObject.notifyAll();
        }
    }

    public void release() {
        releaseTextureInfo();
        releaseSurfaceTexture();
        releaseFilter();
    }

    public void releaseSurfaceTexture() {
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.surfaceTexture = null;
        }
    }

    public void setRenderContext(RenderContext renderContext) {
        this.renderContext = renderContext;
    }

    public SurfaceTexture surfaceTexture() {
        return this.surfaceTexture;
    }

    public Matrix surfaceTextureMatrix() {
        if (isIdentity() && isOES()) {
            this.textureMatrix = getTextureMatrix(this.surfaceTexture, this.preferRotation);
        }
        return this.textureMatrix;
    }

    public boolean awaitNewImage(long j3) {
        int ceil = (int) Math.ceil((((float) j3) * 1.0f) / 50.0f);
        synchronized (this.frameSyncObject) {
            while (!this.frameAvailable && !this.quitFlag && ceil > 0) {
                ceil--;
                try {
                    this.frameSyncObject.wait(50L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
            this.frameAvailable = false;
            if (ceil == 0) {
                return false;
            }
            if (this.quitFlag) {
                this.quitFlag = false;
                return false;
            }
            RenderContext.checkEglError("before updateTexImage");
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture == null) {
                return false;
            }
            surfaceTexture.updateTexImage();
            Matrix textureMatrix = getTextureMatrix(this.surfaceTexture, this.preferRotation);
            if (VideoDecoder.FIX_DECODE_CROP_SIZE) {
                textureMatrix.postScale(this.scaleX, this.scaleY);
            }
            this.textureInfo.setTextureMatrix(textureMatrix);
            return true;
        }
    }

    public VideoTexture(int i3, int i16) {
        this(i3, i16, 36197, 0);
    }

    public VideoTexture(int i3, int i16, int i17, int i18) {
        this(i3, i16, i17, i18, RenderContext.createTexture(i17));
    }

    public VideoTexture(int i3, int i16, int i17, int i18, int i19) {
        this.frameSyncObject = new Object();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.quitFlag = false;
        this.preferRotation = 0;
        this.textureType = i17;
        SurfaceTexture surfaceTexture = new SurfaceTexture(i19);
        this.surfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
        this.textureInfo = new TextureInfo(i19, i17, i3, i16, null, i18);
        this.preferRotation = i18;
    }
}
