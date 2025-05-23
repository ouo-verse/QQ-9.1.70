package com.tencent.av.video.effect.core.qqavimage.beauty;

import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageBeautyGaussianBlurFilter extends QQAVImageTwoPassTextureSamplingFilter {
    private float mRadiusInPixels;

    public QQAVImageBeautyGaussianBlurFilter() {
        this(2.0f);
    }

    private String getGaussianBlurFragmentShader(int i3, float f16) {
        if (i3 < 1) {
            return QQAVImageFilter.NO_FILTER_FRAGMENT_SHADER;
        }
        int i16 = i3 + 1;
        float[] fArr = new float[i16];
        float f17 = 0.0f;
        for (int i17 = 0; i17 < i16; i17++) {
            double d16 = f16;
            float sqrt = (float) ((1.0d / Math.sqrt(Math.pow(d16, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i17, 2.0d)) / (Math.pow(d16, 2.0d) * 2.0d)));
            fArr[i17] = sqrt;
            if (i17 == 0) {
                f17 += sqrt;
            } else {
                f17 = (float) (f17 + (sqrt * 2.0d));
            }
        }
        for (int i18 = 0; i18 < i16; i18++) {
            fArr[i18] = fArr[i18] / f17;
        }
        int i19 = (i3 / 2) + (i3 % 2);
        int min = Math.min(i19, 7);
        String str = "uniform sampler2D inputImageTexture;\nuniform highp float texelWidthOffset;\nuniform highp float texelHeightOffset;\nvarying highp vec2 blurCoordinates[" + ((min * 2) + 1) + "];\nvoid main()\n{\n   lowp vec4 sum = vec4(0.0);\n   sum += texture2D(inputImageTexture, blurCoordinates[0]) * " + fArr[0] + ";\n";
        for (int i26 = 0; i26 < min; i26++) {
            int i27 = i26 * 2;
            int i28 = i27 + 1;
            int i29 = i27 + 2;
            float f18 = fArr[i28] + fArr[i29];
            str = (str + "   sum += texture2D(inputImageTexture, blurCoordinates[" + i28 + "]) * " + f18 + ";\n") + "   sum += texture2D(inputImageTexture, blurCoordinates[" + i29 + "]) * " + f18 + ";\n";
        }
        if (i19 > min) {
            str = str + "   highp vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n";
            while (min < i19) {
                int i36 = min * 2;
                int i37 = i36 + 1;
                float f19 = fArr[i37];
                int i38 = i36 + 2;
                float f26 = fArr[i38];
                float f27 = f19 + f26;
                float f28 = ((f19 * i37) + (f26 * i38)) / f27;
                str = (str + "   sum += texture2D(inputImageTexture, blurCoordinates[0] + singleStepOffset * " + f28 + ") * " + f27 + ";\n") + "   sum += texture2D(inputImageTexture, blurCoordinates[0] - singleStepOffset * " + f28 + ") * " + f27 + ";\n";
                min++;
            }
        }
        return (str + "   gl_FragColor = sum;\n") + "}\n";
    }

    private String getGaussianBlurVertexShader(int i3, float f16) {
        if (i3 < 1) {
            return "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
        }
        int i16 = i3 + 1;
        float[] fArr = new float[i16];
        float f17 = 0.0f;
        for (int i17 = 0; i17 < i16; i17++) {
            double d16 = f16;
            float sqrt = (float) ((1.0d / Math.sqrt(Math.pow(d16, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i17, 2.0d)) / (Math.pow(d16, 2.0d) * 2.0d)));
            fArr[i17] = sqrt;
            if (i17 == 0) {
                f17 += sqrt;
            } else {
                f17 = (float) (f17 + (sqrt * 2.0d));
            }
        }
        for (int i18 = 0; i18 < i16; i18++) {
            fArr[i18] = fArr[i18] / f17;
        }
        int min = Math.min((i3 / 2) + (i3 % 2), 7);
        float[] fArr2 = new float[min];
        for (int i19 = 0; i19 < min; i19++) {
            int i26 = i19 * 2;
            int i27 = i26 + 1;
            float f18 = fArr[i27];
            int i28 = i26 + 2;
            float f19 = fArr[i28];
            fArr2[i19] = ((f18 * i27) + (f19 * i28)) / (f18 + f19);
        }
        String str = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\nvarying vec2 blurCoordinates[" + ((min * 2) + 1) + "];\nvoid main()\n{\n   gl_Position = position;\n   vec2 singleStepOffset = vec2(texelWidthOffset, texelHeightOffset);\n   blurCoordinates[0] = inputTextureCoordinate.xy;\n";
        for (int i29 = 0; i29 < min; i29++) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("   blurCoordinates[");
            int i36 = i29 * 2;
            sb5.append(i36 + 1);
            sb5.append("] = inputTextureCoordinate.xy + singleStepOffset * ");
            sb5.append(fArr2[i29]);
            sb5.append(";\n   blurCoordinates[");
            sb5.append(i36 + 2);
            sb5.append("] = inputTextureCoordinate.xy - singleStepOffset * ");
            sb5.append(fArr2[i29]);
            sb5.append(";\n");
            str = sb5.toString();
        }
        return str + "}\n";
    }

    private void updateShader() {
        float f16 = this.mRadiusInPixels;
        if (f16 >= 1.0f) {
            int floor = (int) Math.floor(Math.sqrt(Math.pow(f16, 2.0d) * (-2.0d) * Math.log(0.00390625f * Math.sqrt(Math.pow(this.mRadiusInPixels, 2.0d) * 6.283185307179586d))));
            int i3 = floor + (floor % 2);
            if (this.mFilters != null) {
                for (int i16 = 0; i16 < this.mFilters.size(); i16++) {
                    this.mFilters.get(i16).destroy();
                }
                this.mFilters.clear();
            }
            addFilter(new QQAVImageFilter(getGaussianBlurVertexShader(i3, this.mRadiusInPixels), getGaussianBlurFragmentShader(i3, this.mRadiusInPixels)));
            addFilter(new QQAVImageFilter(getGaussianBlurVertexShader(i3, this.mRadiusInPixels), getGaussianBlurFragmentShader(i3, this.mRadiusInPixels)));
        }
    }

    public void setRadiusInPixels(float f16) {
        if (Math.round(f16) != this.mRadiusInPixels) {
            this.mRadiusInPixels = Math.round(f16);
            updateShader();
            runOnDraw(new Runnable() { // from class: com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyGaussianBlurFilter.1
                @Override // java.lang.Runnable
                public void run() {
                    if (((QQAVImageFilterGroup) QQAVImageBeautyGaussianBlurFilter.this).mFilters != null) {
                        for (int i3 = 0; i3 < ((QQAVImageFilterGroup) QQAVImageBeautyGaussianBlurFilter.this).mFilters.size(); i3++) {
                            ((QQAVImageFilter) ((QQAVImageFilterGroup) QQAVImageBeautyGaussianBlurFilter.this).mFilters.get(i3)).init();
                            ((QQAVImageFilter) ((QQAVImageFilterGroup) QQAVImageBeautyGaussianBlurFilter.this).mFilters.get(i3)).onOutputSizeChanged(((QQAVImageFilter) QQAVImageBeautyGaussianBlurFilter.this).mOutputWidth, ((QQAVImageFilter) QQAVImageBeautyGaussianBlurFilter.this).mOutputHeight);
                            QQAVImageBeautyGaussianBlurFilter qQAVImageBeautyGaussianBlurFilter = QQAVImageBeautyGaussianBlurFilter.this;
                            qQAVImageBeautyGaussianBlurFilter.onOutputSizeChanged(((QQAVImageFilter) qQAVImageBeautyGaussianBlurFilter).mOutputWidth, ((QQAVImageFilter) QQAVImageBeautyGaussianBlurFilter.this).mOutputHeight);
                        }
                    }
                }
            });
        }
    }

    public QQAVImageBeautyGaussianBlurFilter(float f16) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", QQAVImageFilter.NO_FILTER_FRAGMENT_SHADER, "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", QQAVImageFilter.NO_FILTER_FRAGMENT_SHADER);
        this.mRadiusInPixels = -1.0f;
        this.mRadiusInPixels = Math.round(f16);
        updateShader();
    }
}
