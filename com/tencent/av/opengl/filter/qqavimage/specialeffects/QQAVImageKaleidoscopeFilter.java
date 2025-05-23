package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageKaleidoscopeFilter extends QQAVImageFilter {
    public static final String MIRROR_FRAGMENT_SHADER = "//\u4e07\u82b1\u7b52\nprecision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float angle;//\u65cb\u8f6c\u89d2\u5ea6\nuniform float imageWidth;//\u4ece\u5ba2\u6237\u7aef\u4f20\u5165\u7684\u56fe\u7247\u5bbd\u6570\u636e\nuniform float imageHeight;//\u4ece\u5ba2\u6237\u7aef\u4f20\u5165\u7684\u56fe\u7247\u9ad8\u6570\u636e\nuniform int yScaleDirection;\nuniform int videoRotate;\n\nfloat disX = 0.0;//\u504f\u79fb\u8ddd\u79bb\uff0c\u8fd9\u91cc\u8ba1\u7b97\u4e2d\u5fc3\u70b9\u52304\u5206\u4e4b\u4e00\u4e2d\u5fc3\u70b9\u7684\u8ddd\u79bb\nfloat disY = 0.0;\nfloat scale = 1.0;\nvec2 centerInFirst;\n\nvec2 transForTexPosition(vec2 pos)\n{\n    \treturn vec2(pos.x/imageWidth, pos.y/imageHeight);\n}\n\nvec2 getMirror(vec2 textureCoordinate)\n{\n\tvec2 textureCoordinateUse = textureCoordinate;\n\nif (videoRotate == 270) {//\u539f\u753b\u9762\u65cb\u8f6c\u4e86270\u5ea6\uff0c\u4ee5\u53f3\u8fb9\u7684x\u4e3a\u955c\u50cf\n\t\tif (textureCoordinateUse.x < 0.5) {\n            \t\ttextureCoordinateUse.x = 1.0 - textureCoordinateUse.x;\n        \t\t}\n\t} else {//\u5df2\u5de6\u8fb9\u7684x\u4e3a\u955c\u50cf\n\t\tif (textureCoordinateUse.x > 0.5) {\n           \t\t textureCoordinateUse.x = 1.0 - textureCoordinateUse.x;\n        \t\t}\n\t}\n\n\t\n       if (videoRotate == 90) {//\u539f\u753b\u9762\u65cb\u8f6c\u4e8690\u5ea6\uff0c\u5219\u4ee5\u4e0b\u8fb9\u7684y\u4e3a\u955c\u50cf\n\t\tif (textureCoordinateUse.y < 0.5) {\n            \t\ttextureCoordinateUse.y = 1.0 - textureCoordinateUse.y;\n        \t\t}\n       } else {//\u4ee5\u4e0a\u8fb9\u7684y\u4e3a\u955c\u50cf\n\t\tif (textureCoordinateUse.y > 0.5) {\n            \t\ttextureCoordinateUse.y = 1.0 - textureCoordinateUse.y;\n        \t\t}\n        }        \n    \treturn textureCoordinateUse;\n}\n\nvec2 getRotate(vec2 textureCoordinateUse, float angle)\n{\n\tvec2 pixTexture = vec2(textureCoordinateUse.x * imageWidth, textureCoordinateUse.y * imageHeight); \n\tfloat degree = radians(angle);//\u8f6c\u4e3a\u5f27\u5ea6\n\tfloat c = cos(degree);\n        float s = sin(degree);\n        vec2  temp;\n        temp.x = pixTexture.x * c - pixTexture.y * s;\n        temp.y = pixTexture.x * s + pixTexture.y * c;\n\treturn temp;\n}\n\nvoid checkDis()\n{\n\tvec2 centerAfterRotate = getRotate(vec2(0.5, 0.5), -angle);\n\tdisX = (centerAfterRotate.x - centerInFirst.x) / imageWidth;\n\tdisY = (centerAfterRotate.y - centerInFirst.y) / imageHeight;\n}\n \nvec2 getZoomPosition(vec2 src)\n{\n\tvec2 in_circle_pos = vec2(imageWidth / 2.0, imageHeight / 2.0);\n    \tfloat zoom_x = (src.x - in_circle_pos.x) / scale;\n    \tfloat zoom_y = (src.y - in_circle_pos.y) / scale;\n\tif (yScaleDirection == 0) {\n\t\treturn vec2(in_circle_pos.x + zoom_x, in_circle_pos.y + zoom_y);\n\t} else {\n\t\treturn vec2(in_circle_pos.x + zoom_x, in_circle_pos.y - zoom_y);\n\t}\n}\n\nvec4 getScaleColor(vec2 src)//\u53cc\u7ebf\u6027\u63d2\u503c\u91c7\u6837\n{\n    vec2 pos = getZoomPosition(src);\n\n    float _x = floor(pos.x);\n\n    float _y = floor(pos.y);\n\n    float u = pos.x - _x;\n    float v = pos.y - _y;\n\n    vec4 data_00 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y)));\n    vec4 data_01 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y + 1.0)));\n    vec4 data_10 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y)));\n    vec4 data_11 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1.0, _y + 1.0)));\n\n    return (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n}\n\nvoid checkScale( )\n{\n\tfloat degree = radians(angle);//\u8f6c\u4e3a\u5f27\u5ea6\n\tfloat c = abs(cos(degree));\n        float s = abs(sin(degree));\n\tvec2 size = vec2(imageWidth / 2.0, imageHeight / 2.0);\n\n\tfloat w = size.x * c + size.y * s; //x\u65b9\u5411\u5bf9\u89d2\u7ebf\u7684\u8ddd\u79bb\n\tfloat scaleX = w / imageWidth;\n\tfloat h = size.x * s + size.y * c; //y\u65b9\u5411\u5bf9\u89d2\u7ebf\u7684\u8ddd\u79bb\n\tfloat scaleY = h / imageHeight;\n\tscale = max(scaleX, scaleY);\n}\n\nvec4 getShrinkColor(vec2 src)\n{\n\tfloat shrinkScale = 1.0 / scale;\n\tvec2 uv = transForTexPosition(src);\n\tvec2 coordinate = (0.5 + -0.5 * shrinkScale +  uv * shrinkScale);\n\tif (yScaleDirection != 0) {\n\t\tcoordinate.y = 1.0 - coordinate.y;\n\t} \n        vec4 r = texture2D(inputImageTexture, coordinate);\n\treturn r;\n}\n\nvoid main()\n{\nif (videoRotate == 90) {\n\t\tcenterInFirst = vec2(imageWidth / 4.0, imageHeight / 4.0 * 3.0);\n\t} else if(videoRotate == 270) {\n\t\tcenterInFirst = vec2(imageWidth / 4.0 * 3.0, imageHeight / 4.0);\n\t} else {\n\t\tcenterInFirst = vec2(imageWidth / 4.0, imageHeight / 4.0);\n\t}\n\tcheckDis();//\u8ba1\u7b97\u504f\u79fb\u8ddd\u79bb\n\n\tcheckScale();//\u8ba1\u7b97\u7f29\u653e\u6bd4\u4f8b\uff0c\u8bd5\u5168\u5c4f\u5185\u5bb9\u6700\u5927\u5316\u663e\u793a\u57284\u5206\u4e4b\u4e00\u533a\u57df\n\n\tvec2 textureCoordinateUse = textureCoordinate;\n\t\n\ttextureCoordinateUse = getMirror(textureCoordinateUse);//\u955c\u50cf\u8f6c\u6362\n\ttextureCoordinateUse.x += disX;\n\ttextureCoordinateUse.y += disY;\n\n\tvec2 result = getRotate(textureCoordinateUse, angle);//\u65cb\u8f6c\u8f6c\u6362\n\t\n\t//\u7f29\u653e\u8f6c\u6362\n\tvec4 colorFront;\n\tif (scale > 1.0) {\n\t\tcolorFront = getScaleColor(result);\n\t} else {\n\t\tcolorFront = getShrinkColor(result);\n\t}\n\n\tgl_FragColor = colorFront;\n\n}";
    private int mAngleLocation;
    private int mHeightLocation;
    private float mRotateAngle;
    private int mVideoRotateLocation;
    private int mWidthLocation;
    private int mYScaleDirection;

    public QQAVImageKaleidoscopeFilter() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", MIRROR_FRAGMENT_SHADER);
        this.mRotateAngle = 29.4f;
        super.setQQAVEffectType(1009);
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
        this.mAngleLocation = GLES20.glGetUniformLocation(getProgram(), "angle");
        this.mYScaleDirection = GLES20.glGetUniformLocation(getProgram(), "yScaleDirection");
        this.mVideoRotateLocation = GLES20.glGetUniformLocation(getProgram(), "videoRotate");
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        setFloat(this.mWidthLocation, i3);
        setFloat(this.mHeightLocation, i16);
        setFloat(this.mAngleLocation, this.mRotateAngle);
    }
}
