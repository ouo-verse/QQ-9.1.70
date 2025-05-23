package com.tencent.tavsticker.model;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavsticker.log.TLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerTexture implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "TAVStickerTexture";
    private boolean frameAvailable;
    private final Object frameSyncObject;
    private int preferRotation;
    private boolean quitFlag;
    private SurfaceTexture surfaceTexture;
    private TextureInfo textureInfo;
    private Matrix textureMatrix;
    private int textureType;

    public TAVStickerTexture(TextureInfo textureInfo) {
        this.frameSyncObject = new Object();
        this.quitFlag = false;
        this.preferRotation = 0;
        this.textureInfo = textureInfo;
        SurfaceTexture surfaceTexture = new SurfaceTexture(textureInfo.textureID);
        this.surfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
        this.surfaceTexture.getTransformMatrix(new float[16]);
        this.preferRotation = 0;
    }

    public static void checkEglError(String str) throws RuntimeException {
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            TLog.e(TAG, str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            sb5.append(str);
            sb5.append(": EGL error: 0x");
            sb5.append(Integer.toHexString(eglGetError));
            z16 = true;
        }
        if (z16) {
            new RuntimeException("EGL error encountered (see log): " + ((Object) sb5)).printStackTrace();
        }
    }

    public static int createTexture(int i3, int i16, int i17) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i18 = iArr[0];
        GLES20.glBindTexture(i17, i18);
        checkEglError("glBindTexture mTextureID");
        GLES20.glTexParameterf(i17, 10241, 9729.0f);
        GLES20.glTexParameterf(i17, 10240, 9729.0f);
        GLES20.glTexParameteri(i17, 10242, 33071);
        GLES20.glTexParameteri(i17, 10243, 33071);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i3, i16, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glBindTexture(i17, 0);
        checkEglError("glTexParameter");
        return i18;
    }

    private void getRotationMatrix(Matrix matrix, int i3, float f16, float f17) {
        float f18;
        float f19;
        float f26;
        int i16 = i3 % 4;
        if (i16 < 0) {
            i16 += 4;
        }
        float f27 = -1.0f;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    f27 = 1.0f;
                    f26 = 1.0f;
                    f18 = 0.0f;
                    f16 = 0.0f;
                    f17 = 0.0f;
                    f19 = 0.0f;
                } else {
                    f17 = f16;
                    f19 = -1.0f;
                    f18 = 1.0f;
                    f16 = 0.0f;
                    f27 = 0.0f;
                }
            } else {
                f26 = -1.0f;
                f18 = 0.0f;
                f19 = 0.0f;
            }
            matrix.setValues(new float[]{f27, f18, f16, f19, f26, f17, 0.0f, 0.0f, 1.0f});
        }
        f16 = f17;
        f18 = -1.0f;
        f19 = 1.0f;
        f17 = 0.0f;
        f27 = 0.0f;
        f26 = f27;
        matrix.setValues(new float[]{f27, f18, f16, f19, f26, f17, 0.0f, 0.0f, 1.0f});
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
            getRotationMatrix(matrix2, i3, 1.0f, 1.0f);
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

    private void releaseTextureInfo() {
        TextureInfo textureInfo = this.textureInfo;
        if (textureInfo != null) {
            textureInfo.release();
            this.textureInfo = null;
        }
    }

    public boolean awaitNewImage() {
        return awaitNewImage(500L);
    }

    public int getPreferRotation() {
        return this.preferRotation;
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
    }

    public void releaseSurfaceTexture() {
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.surfaceTexture = null;
        }
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

    public void updateStickerTextureSize(int i3, int i16) {
        if (i3 > 0 && i16 > 0 && this.textureInfo != null) {
            this.surfaceTexture.setDefaultBufferSize(i3, i16);
            TextureInfo textureInfo = this.textureInfo;
            this.textureInfo = new TextureInfo(textureInfo.textureID, textureInfo.textureType, i3, i16, textureInfo.getTextureMatrix(), this.textureInfo.preferRotation);
        }
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
            checkEglError("before updateTexImage");
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture == null) {
                return false;
            }
            surfaceTexture.updateTexImage();
            this.textureInfo.setTextureMatrix(getTextureMatrix(this.surfaceTexture, this.preferRotation));
            return true;
        }
    }

    public TAVStickerTexture(int i3, int i16) {
        this(i3, i16, 36197, 0);
    }

    public TAVStickerTexture(int i3, int i16, int i17, int i18) {
        this(i3, i16, i17, i18, createTexture(i3, i16, i17));
    }

    public TAVStickerTexture(int i3, int i16, int i17, int i18, int i19) {
        this.frameSyncObject = new Object();
        this.quitFlag = false;
        this.preferRotation = 0;
        this.textureType = i17;
        SurfaceTexture surfaceTexture = new SurfaceTexture(i19);
        this.surfaceTexture = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(i3, i16);
        this.surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
        this.textureInfo = new TextureInfo(i19, i17, i3, i16, null, i18);
        this.preferRotation = i18;
    }
}
