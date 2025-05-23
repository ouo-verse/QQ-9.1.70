package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageBulgeDistortionFilter extends QQAVImageFilter {
    public static final String BULGE_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform highp float aspectRatio;\nuniform highp vec2 center;\nuniform highp float radius;\nuniform highp float scale;\n\nvoid main()\n{\n    highp float radius2 = radius;\n    highp float v_aspectRatio = aspectRatio;\n    highp vec2 textureCoordinateToUse = textureCoordinate;\n    \n    if(v_aspectRatio > 1.00){\n        radius2 = radius * v_aspectRatio;\n        textureCoordinateToUse = vec2(textureCoordinate.x, (textureCoordinate.y * v_aspectRatio + 0.50 - 0.50 * v_aspectRatio));\n    } else {\n        v_aspectRatio = 1.00 / v_aspectRatio;\n        radius2 = radius * v_aspectRatio;\n        textureCoordinateToUse = vec2((textureCoordinate.x * v_aspectRatio + 0.50 - 0.50 * v_aspectRatio), textureCoordinate.y);\n    }\n    \n    highp float dist = distance(center, textureCoordinateToUse);\n    textureCoordinateToUse = textureCoordinate;\n\n    if (dist < radius2){\n        textureCoordinateToUse -= center;\n        highp float rangeRatio = radius * 2.00;\n        highp float percent = (rangeRatio * 0.50 * v_aspectRatio / dist) * (1.00-pow(1.00-(dist/radius2),1.00/scale));\n\n        textureCoordinateToUse = vec2(textureCoordinateToUse.x, textureCoordinateToUse.y) * percent;\n        textureCoordinateToUse += center;\n        highp vec4 tmpColor = texture2D(inputImageTexture, textureCoordinateToUse );\n        highp float blurRange = 0.02;\n        if (dist > (1.00 - blurRange) * radius2){\n            tmpColor.rgb *= 1.00 / blurRange - dist / (radius2 * blurRange) ;\n        }\n        gl_FragColor = tmpColor;    \n    } else{\n        gl_FragColor = vec4(0.0,0.0,0.0,1.0);\n    }\n}";
    private float mAspectRatio;
    private int mAspectRatioLocation;
    private PointF mCenter;
    private int mCenterLocation;
    private float mRadius;
    private int mRadiusLocation;
    private float mScale;
    private int mScaleLocation;

    public QQAVImageBulgeDistortionFilter() {
        this(0.4f, 3.0f, new PointF(0.5f, 0.5f));
    }

    private void setAspectRatio(float f16) {
        this.mAspectRatio = f16;
        setFloat(this.mAspectRatioLocation, f16);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mScaleLocation = GLES20.glGetUniformLocation(getProgram(), "scale");
        this.mRadiusLocation = GLES20.glGetUniformLocation(getProgram(), "radius");
        this.mCenterLocation = GLES20.glGetUniformLocation(getProgram(), "center");
        this.mAspectRatioLocation = GLES20.glGetUniformLocation(getProgram(), "aspectRatio");
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        setRadius(this.mRadius);
        setScale(this.mScale);
        setCenter(this.mCenter);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        float f16 = i16 / i3;
        this.mAspectRatio = f16;
        setAspectRatio(f16);
        super.onOutputSizeChanged(i3, i16);
    }

    public void setCenter(PointF pointF) {
        this.mCenter = pointF;
        setPoint(this.mCenterLocation, pointF);
    }

    public void setRadius(float f16) {
        this.mRadius = f16;
        setFloat(this.mRadiusLocation, f16);
    }

    public void setScale(float f16) {
        this.mScale = f16;
        setFloat(this.mScaleLocation, f16);
    }

    public QQAVImageBulgeDistortionFilter(float f16, float f17, PointF pointF) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", BULGE_FRAGMENT_SHADER);
        super.setQQAVEffectType(1007);
        this.mRadius = f16;
        this.mScale = f17;
        this.mCenter = pointF;
    }
}
