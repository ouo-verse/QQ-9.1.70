package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageOldTVFilter extends QQAVImageFilter {
    public static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D           inputImageTexture;\nvarying vec2                textureCoordinate;\n\nvec2 textureCoordinateUse;\nuniform float  imageWidth;\nuniform float  imageHeight;\nuniform float  u_time;//\u968f\u673a\u6570\uff0c\u53ef\u4ee5\u628a\u5f53\u524d\u65f6\u95f4\u4f20\u8fdb\u6765\nuniform float noise; // \u968f\u673a\u6570\uff0c0 - 10\nuniform float waveHeight;\nfloat pi = 3.14159265359;\nfloat bbsm = 11.0;\n\nvec2 bbsopt(in vec2 a){\n    return fract(a*a*(1./bbsm))*bbsm;\n}\n\nvec2 mod1024(in vec2 a){\n    return fract(a*(1./0.3))*1411.;\n}\nvec4 hash(in vec2 pos){\n    vec2 a0 = mod1024(pos*pi);\n    vec2 a1 = bbsopt(a0);\n    vec2 a2 = a1.yx + bbsopt(a1);\n    vec2 a3 = a2.yx + bbsopt(a2);\n    return fract((a2.xyxy + a3.xxyy + a1.xyyx)*(1./bbsm));\n}\n\nvec4 getBackColor(sampler2D inputImageTexture, vec2 textureCoordinate)\n{\n    vec2 uv = textureCoordinate.xy;\n    float waveu = (cos((uv.y + u_time/50.0) * 5.0)+0.1)*(sin((uv.y + u_time/50.0) * 12.0) +0.1)* waveHeight;\n    float disX = waveu+ uv.x;\n    textureCoordinateUse=vec2(disX, uv.y);\n    if ((disX >-0.5/imageWidth && disX < 1.5/imageWidth)||(disX >1.0 && disX < 1.0+2.0/imageWidth)) {\n        return vec4(0.0, 0.0, 0.0, 1.0);\n    } else {\n        textureCoordinateUse=vec2(disX, uv.y);\n        return texture2D(inputImageTexture, textureCoordinateUse);\n    }\n    \n}\n\nvec4 getNoiseColor(vec2 textureCoordinate)\n{\n    vec2 fragCoord = vec2(textureCoordinate.x * imageWidth / 1.5, textureCoordinate.y * \timageHeight / 1.5);\n    vec2 scale = vec2(1.0 + noise, 1.0);\n    const int num = 2; //average multiple instances\n    \n    vec2 p = scale*floor(fragCoord.xy);\n    \n    vec4 c = vec4(0.0);\n    for(int i=0; i<num; i++) {\n        c+= hash(p+float(i*1024));\n    }\n    vec4 color = getBackColor(inputImageTexture, textureCoordinate);\n    \n    return color + vec4(c.x,c.y,c.z,1.0) / 10.0;\n    \n}\n\nfloat lumin( vec4 color ) { return dot( color, vec4( 0.0, 109.0 / 255.0, 1.0, 0.0 ) ); }\n\nvec4 filterByColor( vec4 color, vec4 filter )\n{\n    float lumOld = lumin( color );\n    color *= filter;\n    float lumNew = lumin( color );\n    \n    return color * ( lumOld / lumNew );\n}\n\nvec4 getColdColor(vec4 color)\n{\n    vec4 filterColorCold = vec4( 1.0, 1.1515, 1.33, 1.0 );\n    \n    vec4 colorCold = filterByColor( color, filterColorCold );\n    \n    return colorCold;\n}\n\nfloat rng2(vec2 seed)\n{\n    return fract(sin(dot(seed * 12.0, vec2(127.1,311.7))) * 43758.5453123);\n}\n\nvec4 getLineColor(vec2 uv, vec4 srcColor)\n{\n    float y = mod(floor(uv.y * imageHeight / 4.0), 2.0);\n    vec4 colorLine;\n    vec4 origColor = srcColor ;//texture2D(inputImageTexture, uv);\n    if (y == 0.0) {\n        colorLine = vec4(origColor.r, 0.0, 0.0, 1.0);\n    } else {\n        colorLine = vec4(0.0, origColor.g, origColor.b, 1.0);\n    }\n    return colorLine;\n}\n\nvec4 getOldTV(){\n    vec4 colorNoise = getNoiseColor(textureCoordinate);\n    vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    vec4 coldColor  = getColdColor(colorNoise);//\u51b7\u5374\u6ee4\u955c\n    vec4 lineColor = getLineColor(textureCoordinate, coldColor);//\u6a21\u62df\u7535\u89c6\u7ebf\u6761\u6548\u679c\n    return vec4(mix(coldColor.rgb, lineColor.rgb, lineColor.a * 0.3), 1.0);\n}\n\nvoid main() {\n    gl_FragColor=getOldTV();\n}";
    private int mHeightLocation;
    private int mNoise;
    private int mNoiseLocation;
    private int mTime;
    private int mTimeLocation;
    private int mWaveHeightLocation;
    private int mWidthLocation;

    public QQAVImageOldTVFilter() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", FRAGMENT_SHADER);
        super.setQQAVEffectType(1012);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDraw2(int i3, int i16) {
        int i17 = this.mTime;
        if (i17 >= 0) {
            this.mTime = i17 - 1;
        } else {
            this.mTime = 1000000;
        }
        setFloat(this.mTimeLocation, this.mTime);
        if (this.mTime % 100 < 4) {
            setFloat(this.mWaveHeightLocation, 0.87f);
        } else {
            setFloat(this.mWaveHeightLocation, 0.004f);
        }
        int i18 = this.mNoise;
        if (i18 < 10) {
            this.mNoise = i18 + 1;
        } else {
            this.mNoise = 0;
        }
        setFloat(this.mNoiseLocation, this.mNoise);
        super.onDraw2(i3, i16);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
        this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
        this.mTimeLocation = GLES20.glGetUniformLocation(getProgram(), "u_time");
        this.mNoiseLocation = GLES20.glGetUniformLocation(getProgram(), "noise");
        this.mWaveHeightLocation = GLES20.glGetUniformLocation(getProgram(), "waveHeight");
        this.mTime = 1000000;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        setFloat(this.mWidthLocation, i3);
        setFloat(this.mHeightLocation, i16);
    }
}
