package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageGaussianSelecterBlurFilter extends QQAVImageTwoPassTextureSamplingFilter {
    public static final String FRAGMENT_SHADER = "uniform sampler2D inputImageTexture;\n\nconst lowp int GAUSSIAN_SAMPLES = 9;\nuniform highp float aspectRatio;\n\nuniform highp float radius;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\tlowp vec3 sum = vec3(0.0);\n   highp vec2 blurCenter = vec2(0.50, 0.50);\n   lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n   highp vec2 textureCoordinateToUse = vec2((textureCoordinate.x), (textureCoordinate.y * aspectRatio + 0.5 - 0.5 * aspectRatio));   highp float dist = distance(blurCenter, textureCoordinateToUse);\n\t\n\tif (dist > radius)   {\n       sum += texture2D(inputImageTexture, blurCoordinates[0]).rgb * 0.05;\n       sum += texture2D(inputImageTexture, blurCoordinates[1]).rgb * 0.09;\n       sum += texture2D(inputImageTexture, blurCoordinates[2]).rgb * 0.12;\n       sum += texture2D(inputImageTexture, blurCoordinates[3]).rgb * 0.15;\n       sum += texture2D(inputImageTexture, blurCoordinates[4]).rgb * 0.18;\n       sum += texture2D(inputImageTexture, blurCoordinates[5]).rgb * 0.15;\n       sum += texture2D(inputImageTexture, blurCoordinates[6]).rgb * 0.12;\n       sum += texture2D(inputImageTexture, blurCoordinates[7]).rgb * 0.09;\n       sum += texture2D(inputImageTexture, blurCoordinates[8]).rgb * 0.05;\n\n     highp vec4 blurredImageColor = vec4(sum,fragColor.a);\n     \n     gl_FragColor = mix(fragColor, blurredImageColor, smoothstep(radius , 0.5, dist));    }   else    {\n\t    gl_FragColor = fragColor;\n    }}";
    public static final String VERTEX_SHADER = "attribute highp vec4 position;\nattribute highp vec4 inputTextureCoordinate;\n\nconst int GAUSSIAN_SAMPLES = 9;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n\n    // Calculate the positions for the blur\n    int multiplier = 0;\n    highp vec2 blurStep;\n    highp vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n\n    for (int i = 0; i < GAUSSIAN_SAMPLES; i++)\n    {\n        multiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n        // Blur in x (horizontal)\n        blurStep = float(multiplier) * singleStepOffset;\n        blurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n     }\n}";
    private float mAspectRatio;
    protected float mBlurSize;
    private PointF mCenter;
    protected float mRadius;

    public QQAVImageGaussianSelecterBlurFilter() {
        this(new PointF(0.5f, 0.5f), 2.0f, 0.34f);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter
    public float getHorizontalTexelOffsetRatio() {
        return this.mBlurSize;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter
    public float getVerticalTexelOffsetRatio() {
        return this.mBlurSize;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        setRadius(0.34f);
        setCenter(new PointF(0.5f, 0.5f));
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilterGroup, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        float f16 = i16 / i3;
        this.mAspectRatio = f16;
        updateUinformValue("aspectRatio", f16);
        super.onOutputSizeChanged(i3, i16);
    }

    public void setBlurSize(float f16) {
        this.mBlurSize = f16;
        runOnDraw(new Runnable() { // from class: com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageGaussianSelecterBlurFilter.1
            @Override // java.lang.Runnable
            public void run() {
                QQAVImageGaussianSelecterBlurFilter.this.initTexelOffsets();
            }
        });
    }

    public void setCenter(PointF pointF) {
        this.mCenter = pointF;
        updateUinformValue("blurCenter", pointF);
    }

    public void setRadius(float f16) {
        this.mRadius = f16;
        runOnDraw(new Runnable() { // from class: com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageGaussianSelecterBlurFilter.2
            @Override // java.lang.Runnable
            public void run() {
                QQAVImageGaussianSelecterBlurFilter qQAVImageGaussianSelecterBlurFilter = QQAVImageGaussianSelecterBlurFilter.this;
                qQAVImageGaussianSelecterBlurFilter.updateUinformValue("radius", qQAVImageGaussianSelecterBlurFilter.mRadius);
            }
        });
    }

    protected void updateUinformValue(String str, float f16) {
        for (int i3 = 0; i3 < this.mFilters.size(); i3++) {
            QQAVImageFilter qQAVImageFilter = this.mFilters.get(i3);
            qQAVImageFilter.setFloat(GLES20.glGetUniformLocation(qQAVImageFilter.getProgram(), str), f16);
        }
        runOnDraw(new Runnable() { // from class: com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageGaussianSelecterBlurFilter.3
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public QQAVImageGaussianSelecterBlurFilter(PointF pointF, float f16, float f17) {
        super(VERTEX_SHADER, FRAGMENT_SHADER, VERTEX_SHADER, FRAGMENT_SHADER);
        this.mBlurSize = 2.0f;
        super.setQQAVEffectType(1008);
        this.mCenter = pointF;
        this.mBlurSize = f16;
        this.mRadius = f17;
    }

    protected void updateUinformValue(String str, PointF pointF) {
        for (int i3 = 0; i3 < this.mFilters.size(); i3++) {
            QQAVImageFilter qQAVImageFilter = this.mFilters.get(i3);
            qQAVImageFilter.setPoint(GLES20.glGetUniformLocation(qQAVImageFilter.getProgram(), str), pointF);
        }
    }
}
