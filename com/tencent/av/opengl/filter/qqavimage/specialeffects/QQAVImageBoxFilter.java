package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageBoxFilter extends QQAVImageFilter {
    public static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D inputImageTexture;\nvarying vec2 textureCoordinate;\n\nuniform float imageWidth;                  //\u4ece\u5ba2\u6237\u7aef\u4f20\u5165\u7684\u56fe\u7247\u5bbd\u6570\u636e\nuniform float imageHeight;                 //\u4ece\u5ba2\u6237\u7aef\u4f20\u5165\u7684\u56fe\u7247\u9ad8\u6570\u636e\nvec2 clipTextureCoordinate;     \t //\u5f53\u524d\u5c4f\u5e55\u8fdb\u884c\u88c1\u526a\u7684\u533a\u57df\uff0c\u6bcf\u4e2a\u5bab\u683c\u4ee5\u8fd9\u4e2a\u533a\u57df\u8fdb\u884c\u7f29\u653e\nfloat in_zoom_times = 1.0;                //\u6bcf\u4e2a\u5bab\u683c\u5bf9clipTextureCoordinate\u7f29\u653e\u7684\u6bd4\u4f8b\nuniform float clipBoxNum;\t\t\t//\u6bcf\u6761\u8fb9\u5206\u5272\u7684\u6570\u91cf\uff0c\u4e5d\u5bab\u683c\u5c31\u662f3 \nvec2 eachBoxSize;\nuniform vec4 boxColor[16]; \n\n// \u8f6c\u6362\u4e3a\u7eb9\u7406\u8303\u56f4\nvec2 transForTexPosition(vec2 pos)\n{\n    return vec2(float(pos.x/imageWidth), float(pos.y/imageHeight));\n}\n \nvec2 getZoomPosition(vec2 src)\n{   \n    float dis = mod(src.x, eachBoxSize.x * imageWidth);\n    float zoom_x = clipTextureCoordinate.x + dis / in_zoom_times; \n    dis = mod(src.y , eachBoxSize.y * imageHeight);\n    float zoom_y = clipTextureCoordinate.y +  dis / in_zoom_times; \n    \n    return vec2(zoom_x, zoom_y);\n}\n\nvec4 getZoomColor(vec2 src)\n{\n    vec2 pos = getZoomPosition(src);\n\n    float _x = floor(pos.x);\n    float _y = floor(pos.y);\n\n    float u = pos.x - _x;\n    float v = pos.y - _y;\n    //\u53cc\u7ebf\u6027\u63d2\u503c\u91c7\u6837\n    vec4 data_00 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y))); \n\n    vec4 data_01 = texture2D(inputImageTexture, transForTexPosition(vec2(_x, _y + 1.))); \n\n    vec4 data_10 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1., _y))); \n\n    vec4 data_11 = texture2D(inputImageTexture, transForTexPosition(vec2(_x + 1., _y + 1.))); \n\n    return (1. - u) * (1. - v) * data_00 + (1. - u) * v * data_01 + u * (1. - v) * data_10 + u * v * data_11;\n\n}\n\nvec4 getShrinkColor(vec2 src)\n{\n\tvec2 uv = vec2(mod(src.x, eachBoxSize.x), mod(src.y, eachBoxSize.x));\n\tuv += 0.5 - in_zoom_times / 2.0;\n\tfloat shrinkScale = 1.0 / in_zoom_times;\n\tvec2 coordinate = (0.5 + -0.5 * shrinkScale +  uv * shrinkScale);\n        vec4 r = texture2D(inputImageTexture, coordinate);\n\treturn r;\n}\n\nvec4 getCurrentBoxColor(vec2 src)\n{\n\tint indexX = int(src.x /  eachBoxSize.x);\n\tint indexY = int(src.y /  eachBoxSize.y);\n\tint index = indexY * int(clipBoxNum) + indexX;\n\treturn boxColor[index];\n}\n\nvec4 getMixColor(vec4 frontColor, vec4 backColor)\n{\n\treturn vec4(mix(backColor.rgb, frontColor.rgb, frontColor.a * 0.5), \tfrontColor.a);\n}\n\nvoid main()\n{ \n\tif (clipBoxNum <= 1.0) {\n\t\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n\t\treturn;\n\t}\n  \teachBoxSize.x = 1.0 / clipBoxNum;\n\teachBoxSize.y = 1.0 / clipBoxNum;\n  \tin_zoom_times = 1.0 / clipBoxNum;\n\t//gl_FragColor = getZoomColor(gl_FragCoord.xy);  \t//\u53cc\u7ebf\u6027\u63d2\u503c\u7f29\u653e\n\tgl_FragColor = getShrinkColor(textureCoordinate.xy);  //\u7ebf\u6027\u7f29\u653e\n\n\t//boxColor[0] = vec4(1.0, 0.0, 0.0, 1.0);\n\t//gl_FragColor = getMixColor(getCurrentBoxColor(textureCoordinate), gl_FragColor);\n}";
    private int mBoxNumLocation;
    private int mCurrentBoxNum;
    private int mHeightLocation;
    private long mStartTimeMills;
    private int mWidthLocation;

    public QQAVImageBoxFilter() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", FRAGMENT_SHADER);
        super.setQQAVEffectType(1015);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDraw2(int i3, int i16) {
        long currentTimeMillis = (System.currentTimeMillis() - this.mStartTimeMills) % 10000;
        if (currentTimeMillis < 4000) {
            this.mCurrentBoxNum = 2;
        } else if (currentTimeMillis < 8000) {
            this.mCurrentBoxNum = 3;
        } else if (currentTimeMillis < 10000) {
            this.mCurrentBoxNum = 1;
        }
        setFloat(this.mBoxNumLocation, this.mCurrentBoxNum);
        super.onDraw2(i3, i16);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
        this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
        this.mBoxNumLocation = GLES20.glGetUniformLocation(getProgram(), "clipBoxNum");
        this.mStartTimeMills = System.currentTimeMillis();
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        setFloat(this.mWidthLocation, i3);
        setFloat(this.mHeightLocation, i16);
    }
}
