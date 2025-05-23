package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageShakeFilter extends QQAVImageFilter implements QQSpecialAVFilter.MusicWaveformShaker {
    public static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D      inputImageTexture;\nvarying vec2    textureCoordinate;\nuniform float imageWidth;//\u4ece\u5ba2\u6237\u7aef\u4f20\u5165\u7684\u56fe\u7247\u5bbd\u6570\u636e\nuniform float imageHeight;//\u4ece\u5ba2\u6237\u7aef\u4f20\u5165\u7684\u56fe\u7247\u9ad8\u6570\u636e\nuniform float scale;\nuniform int yScaleDirection;//Y\u8f74\u7f29\u653e\u65b9\u5411\uff0c\u9ed8\u8ba4Y\u8f74\u5411\u4e0a\uff0c\u5982\u679c\u4e0a\u5c42\u903b\u8f91\u5bfc\u81f4\u5411\u4e0b\uff0c\u8fd9\u91cc\u4f201\u6765\u533a\u5206\nuniform float maxScale;\n\nvec2 getZoomPosition(vec2 src)\n{\n\tvec2 in_circle_pos = vec2(imageWidth / 2.0, imageHeight / 2.0);\n    \tfloat zoom_x = (src.x - in_circle_pos.x) / scale;\n    \tfloat zoom_y = (src.y - in_circle_pos.y) / scale;\n\t\treturn vec2(in_circle_pos.x + zoom_x, in_circle_pos.y + zoom_y);\n}\n\nvec2 transForTexPosition(vec2 pos)\n{\n    \treturn vec2(pos.x/imageWidth, pos.y/imageHeight);\n}\n\nvec4 getZoomColor(vec2 src)//\u53cc\u7ebf\u6027\u63d2\u503c\u91c7\u6837\n{\n    vec2 pos = getZoomPosition(src);\n\n    float _x = floor(pos.x);\n\n    float _y = floor(pos.y);\n\n    float u = pos.x - _x;\n    float v = pos.y - _y;\n\n    vec4 data_00 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y)));\n    vec4 data_01 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y + 1.0)));\n    vec4 data_10 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y)));\n    vec4 data_11 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y + 1.0)));\n\n    return (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n}\n\nvoid main() {\nif (scale <= 1.0) {\n\t\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n\t\treturn;\n\t}\n\tfloat scaleDis = (scale - 1.0) / (maxScale - 1.0);\n\tfloat amountY = 0.02 * scale * scaleDis;\n    \tfloat amountX = 0.01 * scale * scaleDis;\nif (yScaleDirection != 0) {\n\t\tamountY = -amountY;\n\t}\tvec4 colR = getZoomColor(vec2((textureCoordinate.x - amountX)* imageWidth, (textureCoordinate.y - amountY) * imageHeight));\n\tvec4 colG = getZoomColor(vec2(textureCoordinate.x * imageWidth, textureCoordinate.y * imageHeight));\n\tvec4 colB = colG;\n\tgl_FragColor = vec4(colR.r, colG.g, colB.b, 1.0);\n}";
    private static final float MAX_SCALE = 1.3f;
    private int mHeightLocation;
    private int mMaxScaleLocation;
    private float mScale;
    private int mScaleLocation;
    private int mWidthLocation;
    private int mYScaleDirection;

    public QQAVImageShakeFilter() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", FRAGMENT_SHADER);
        super.setQQAVEffectType(1013);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDraw2(int i3, int i16) {
        setInteger(this.mYScaleDirection, 1);
        super.onDraw2(i3, i16);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
        this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
        this.mScaleLocation = GLES20.glGetUniformLocation(getProgram(), "scale");
        this.mYScaleDirection = GLES20.glGetUniformLocation(getProgram(), "yScaleDirection");
        this.mMaxScaleLocation = GLES20.glGetUniformLocation(getProgram(), "maxScale");
        setScale(1.0f);
        setFloat(this.mMaxScaleLocation, 1.3f);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        setFloat(this.mWidthLocation, i3);
        setFloat(this.mHeightLocation, i16);
    }

    @Override // com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformShaker
    public void setMusicScale(float f16) {
        setScale((f16 * 0.29999995f) + 1.0f);
    }

    public void setScale(float f16) {
        this.mScale = f16;
        setFloat(this.mScaleLocation, f16);
    }
}
