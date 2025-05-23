package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MirrorSpecialEffectImageFilter extends QQAVImageFilter {
    private static long CHANGE_ORIENTATION_TIME = 500;
    public static final String MIRROR_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\n//Android\u8fd9\u91cc\u4ece\u5c4f\u5e55\u5411\u5de6\u6a2a\u5c4f\u4e3a0\uff0c\u987a\u65f6\u9488\u4f9d\u6b21+90\uff0c\u56e0\u4e3a\u7eb9\u7406\u5750\u6807\u5e76\u6ca1\u6709\u53d8\u5316\uff0c\u8fd9\u91cc\u5bf9\u4e0d\u540c\u65b9\u5411\u505a\u5904\u7406\uff0c\u4f7f\u4e2d\u95f4\u5185\u5bb9\u5728\n//\u5de6\u8fb9\uff0c\u7136\u540e\u53f3\u8fb9\u505a\u955c\u50cf\nconst int ORIENTATION_0 = 1;\nconst int ORIENTATION_90 = 2;\nconst int ORIENTATION_180 = 3;\nconst int ORIENTATION_270 = 4;\nuniform int deviceOrientation;\n\nvoid main()\n{\n   highp vec2 textureCoordinateToUse = textureCoordinate;\n   if (deviceOrientation == ORIENTATION_0) {\n        if (textureCoordinateToUse.y < 0.5) {\n           textureCoordinateToUse.y = 1.0 - (textureCoordinateToUse.y + 0.25); \n        } else {\n           textureCoordinateToUse.y = textureCoordinateToUse.y - 0.25;\n        }\n   } else if (deviceOrientation == ORIENTATION_90) {\n        if (textureCoordinateToUse.x < 0.5) {\n           textureCoordinateToUse.x = textureCoordinateToUse.x + 0.25; \n        } else {\n           textureCoordinateToUse.x = 1.0 - (textureCoordinateToUse.x - 0.25);\n        }\n   } else if (deviceOrientation == ORIENTATION_180) {\n       if (textureCoordinateToUse.y < 0.5) {\n           textureCoordinateToUse.y = textureCoordinateToUse.y + 0.25; \n       } else {\n           textureCoordinateToUse.y = 1.0 - (textureCoordinateToUse.y - 0.25);\n       }\n   } else if (deviceOrientation == ORIENTATION_270) {\n        if (textureCoordinateToUse.x < 0.5) {\n           textureCoordinateToUse.x = 1.0 - (textureCoordinateToUse.x + 0.25); \n        } else {\n           textureCoordinateToUse.x = textureCoordinateToUse.x - 0.25;\n       }\n   } \n   gl_FragColor = texture2D(inputImageTexture, textureCoordinateToUse);\n}";
    private static final int ORIENTATION_0 = 1;
    private static final int ORIENTATION_180 = 3;
    private static final int ORIENTATION_270 = 4;
    private static final int ORIENTATION_90 = 2;
    private static final int ORIENTATION_UNSET = 0;
    private int mCurrentDeviceOrientation;
    protected int mDeviceOrientation;
    private int mDeviceOrientationLocation;
    private long mLastChangeOrientationTime;
    private int mMirrorType;

    public MirrorSpecialEffectImageFilter(int i3) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", MIRROR_FRAGMENT_SHADER);
        this.mLastChangeOrientationTime = 0L;
        this.mCurrentDeviceOrientation = 0;
        this.mMirrorType = 1006;
        super.setQQAVEffectType(i3);
        this.mMirrorType = i3;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDraw2(int i3, int i16) {
        int i17;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastChangeOrientationTime > CHANGE_ORIENTATION_TIME) {
            int i18 = this.mDeviceOrientation;
            if (i18 != 0) {
                i17 = 2;
                if (i18 != 90) {
                    if (i18 != 180) {
                        if (i18 == 270) {
                            i17 = 4;
                        }
                    } else {
                        i17 = 3;
                    }
                }
            } else {
                i17 = 1;
            }
            if (this.mCurrentDeviceOrientation != i17) {
                this.mLastChangeOrientationTime = currentTimeMillis;
                this.mCurrentDeviceOrientation = i17;
                setDeviceOrientation(i17);
            }
        }
        super.onDraw2(i3, i16);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mDeviceOrientationLocation = GLES20.glGetUniformLocation(getProgram(), "deviceOrientation");
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        setDeviceOrientation(2);
    }

    public void setDeviceOrientation(int i3) {
        if (this.mMirrorType == 1016) {
            int i16 = 2;
            if (i3 != 1) {
                if (i3 != 2) {
                    i16 = 4;
                    if (i3 != 3) {
                        if (i3 == 4) {
                            i3 = 1;
                        }
                    }
                }
                i3 = 3;
            }
            i3 = i16;
        }
        setInteger(this.mDeviceOrientationLocation, i3);
    }

    public void setOrientation(int i3) {
        this.mDeviceOrientation = i3;
    }
}
