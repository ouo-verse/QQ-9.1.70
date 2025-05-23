package com.tencent.av.opengl.filter.qqavimage.specialeffects;

import android.app.Application;
import android.opengl.GLES20;
import android.util.DisplayMetrics;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.sveffects.SdkContext;
import java.nio.FloatBuffer;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageWrongEraseFilter extends QQAVImageFilter {
    public static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D           inputImageTexture;\nvarying vec2                textureCoordinate;\nvec2    textureCoordinateUse;\nuniform float  imageWidth;\nuniform float  imageHeight;\nuniform float  u_time;\nuniform vec4 errorElement[10];\nuniform int errorNum;\nuniform int redIndex;//\u7ea2\u8272\u64e6\u9664index\nuniform int greenIndex;//\u7eff\u8272\u64e6\u9664index\nfloat  X;\nfloat  Y;\nfloat  Width;\nfloat  Height;\nvec4 color;\nuniform float waveHeight;\nuniform float noise; // \u968f\u673a\u6570\uff0c0 - 10\n\nfloat pi = 3.14159265359;\nfloat bbsm = 11.0;\n\nvec2 bbsopt(in vec2 a){\n    return fract(a*a*(1./bbsm))*bbsm;\n}\n\nvec2 mod1024(in vec2 a){\n    return fract(a*(1./0.3))*1411.;\n}\nvec4 hash(in vec2 pos){\n    vec2 a0 = mod1024(pos*pi);\n    vec2 a1 = bbsopt(a0);\n    vec2 a2 = a1.yx + bbsopt(a1);\n    vec2 a3 = a2.yx + bbsopt(a2);\n    return fract((a2.xyxy + a3.xxyy + a1.xyyx)*(1./bbsm));\n}\nvec3 rgbtohsv(vec3 rgb)\n{\n    float R = rgb.x;\n    float G = rgb.y;\n    float B = rgb.z;\n    vec3 hsv;\n    float max1 = max(R, max(G, B));\n    float min1 = min(R, min(G, B));\n    if (R == max1)\n    {\n        hsv.x = (G - B) / (max1 - min1);\n    }\n    if (G == max1)\n    {\n        hsv.x = 2.0 + (B - R) / (max1 - min1);\n    }\n    if (B == max1)\n    {\n        hsv.x = 4.0 + (R - G) / (max1 - min1);\n    }\n    hsv.x = hsv.x * 60.0;\n    if (hsv.x < 0.0)\n    {\n        hsv.x = hsv.x + 360.0;\n    }\n    hsv.z = max1;\n    hsv.y = (max1 - min1) / max1;\n    return hsv;\n}\n\nvec3 hsvtorgb(vec3 hsv)\n{\n    float R;\n    float G;\n    float B;\n    if (hsv.y == 0.0)\n    {\n        R = G = B = hsv.z;\n    }\n    else\n    {\n        hsv.x = hsv.x / 60.0;\n        int i = int(hsv.x);\n        float f = hsv.x - float(i);\n        float a = hsv.z * (1.0 - hsv.y);\n        float b = hsv.z * (1.0 - hsv.y * f);\n        float c = hsv.z * (1.0 - hsv.y * (1.0 - f));\n        if (i == 0)\n        {\n            R = hsv.z;\n            G = c;\n            B = a;\n        }\n        else if (i == 1)\n        {\n            R = b;\n            G = hsv.z;\n            B = a;\n        }\n        else if (i == 2)\n        {\n            R = a;\n            G = hsv.z;\n            B = c;\n        }\n        else if (i == 3)\n        {\n            R = a;\n            G = b;\n            B = hsv.z;\n        }\n        else if (i == 4)\n        {\n            R = c;\n            G = a;\n            B = hsv.z;\n        }\n        else\n        {\n            R = hsv.z;\n            G = a;\n            B = b;\n        }\n    }\n    return vec3(R, G, B);\n}\n\nvec4 getMixColor(vec4 backCol)\n{\n    vec3 backHSV = rgbtohsv(backCol.xyz);\n    backHSV.x = 0.0;\n    backHSV.y = 0.0;\n    vec3 rgb = hsvtorgb(backHSV);\n    return vec4(rgb, backCol.w);\n}\nfloat getSuperpositionColSingle(float col1, float col2)\n{\n    if (col1 < 0.5) {\n        return col1 * col2 / 0.5;\n    } else {\n        return 1.0 - (1.0 - col1) * (1.0 - col2) / 0.5;\n    }\n}\n//\u53e0\u52a0\u4e24\u4e2a\u989c\u8272\uff0c\u5bf9\u5e94ps\u91cc\u7684\u53e0\u52a0\u6df7\u5408\u6a21\u5f0f\nvec4 getSuperpositionCol(vec4 col1, vec4 col2)\n{\n    vec4 col;\n    col.x = getSuperpositionColSingle(col1.x, col2.x);\n    col.y = getSuperpositionColSingle(col1.y, col2.y);\n    col.z = getSuperpositionColSingle(col1.z, col2.z);\n    col.w = 1.0;\n    return col;\n}\nfloat getAddedColorLS(float col1, float col2)\n{\n    col1= col1*255.0;\n    col2= col2*255.0;\n    float color=255.0 -( ((255.0 - col1) * (255.0 - col2))/256.0);\n    return color/255.0;\n}\n//\u53e0\u52a0\u4e24\u4e2a\u989c\u8272\uff0c\u5bf9\u5e94ps\u91cc\u7684\u6ee4\u8272\nvec4 getSuperpositionColLS(vec4 col1, vec4 col2)\n{\n    vec4 col;\n    col.x = getAddedColorLS(col1.x, col2.x);\n    col.y = getAddedColorLS(col1.y, col2.y);\n    col.z = getAddedColorLS(col1.z, col2.z);\n    col.w = 1.0;\n    return col;\n}\nvec4 getErrorColor(sampler2D inputImageTexture,vec2 textureCoordinate)\n{\n    vec4 backColorBlue = texture2D(inputImageTexture,vec2((textureCoordinate.x+10.0/imageWidth), textureCoordinate.y));\n    backColorBlue = getMixColor(backColorBlue);\n    vec4 backColorRed = texture2D(inputImageTexture,vec2((textureCoordinate.x-10.0/imageWidth), textureCoordinate.y));\n    backColorRed = getMixColor(backColorRed);\n    vec4 colorFrontBlue = vec4(32.0 / 255.0, 22.0 / 255.0, 233.0 / 255.0, 1.0);\n    vec4 colorFrontRed = vec4(229.0 / 255.0, 23.0 / 255.0, 26.0 / 255.0, 1.0);\n    colorFrontBlue = getSuperpositionCol(backColorBlue, colorFrontBlue);\n    colorFrontRed = getSuperpositionCol(backColorRed, colorFrontRed);\n    return getSuperpositionColLS(colorFrontBlue, colorFrontRed);\n}\n\n\n\nfloat lumin( vec4 color ) { return dot( color, vec4( 0.0, 109.0 / 255.0, 1.0, 0.0 ) ); }\n\nvec4 filterByColor( vec4 color, vec4 filter )\n{\n    float lumOld = lumin( color );\n    color *= filter;\n    float lumNew = lumin( color );\n    \n    return color * ( lumOld / lumNew );\n}\n\nvec4 getColdColor(vec4 color)\n{\n    vec4 filterColorCold = vec4( 1.0, 1.1515, 1.33, 1.0 );\n    \n    vec4 colorCold = filterByColor( color, filterColorCold );\n    \n    return colorCold;\n}\nvec4 getLineColor(vec2 uv, vec4 srcColor)\n{\n    float y = mod(floor(uv.y * imageHeight / 4.0), 2.0);\n    vec4 colorLine;\n    vec4 origColor = srcColor ;//texture2D(inputImageTexture, uv);\n    if (y == 0.0) {\n        colorLine = vec4(origColor.r, 0.0, 0.0, 1.0);\n    } else {\n        colorLine = vec4(0.0, origColor.g, origColor.b, 1.0);\n    }\n    return colorLine;\n}\nfloat rng2(vec2 seed)\n{\n    return fract(sin(dot(seed * 12.0, vec2(127.1,311.7))) * 43758.5453123);\n}\nvec2 getBackColor( vec2 textureCoordinate)\n{\n    vec2 uv = textureCoordinate.xy;\n    float waveu = sin((uv.y + u_time/150.0) * 20.0) * 0.009;\n    return uv + vec2(waveu, 0);\n//    return texture2D(inputImageTexture, uv + vec2(waveu, 0));\n}\nvec4 getBackColorInOldTV(vec2 textureCoordinate)\n{\n    vec2 uv = textureCoordinate.xy;\n    float waveu = (cos((uv.y + u_time/50.0) * 5.0)+0.1)*(sin((uv.y + u_time/50.0) * 12.0) +0.1)* waveHeight;\n    float disX = waveu+ uv.x;\n    textureCoordinateUse=vec2(disX, uv.y);\n    if ((disX >-0.5/imageWidth && disX < 1.5/imageWidth)||(disX >1.0 && disX < 1.0+2.0/imageWidth)) {\n        return vec4(0.0, 0.0, 0.0, 1.0);\n    } else {\n        textureCoordinateUse=vec2(disX, uv.y);\n        return texture2D(inputImageTexture, textureCoordinateUse);\n    }\n    \n}\nvec4 getNoiseColor(vec2 textureCoordinate)\n{\n    vec2 fragCoord = vec2(textureCoordinate.x * imageWidth / 1.5, textureCoordinate.y * \timageHeight / 1.5);\n    vec2 scale = vec2(1.0 + noise, 1.0);\n    const int num = 2; //average multiple instances\n    \n    vec2 p = scale*floor(fragCoord.xy);\n    \n    vec4 c = vec4(0.0);\n    for(int i=0; i<num; i++) {\n        c+= hash(p+float(i*1024));\n    }\n    vec4 color = getBackColorInOldTV(textureCoordinate);\n    \n    return color + vec4(c.x,c.y,c.z,1.0) / 10.0;\n    \n}\n\nvec4 getOldTV(){\n    vec4 colorNoise = getNoiseColor(textureCoordinate);\n    vec4 color = texture2D(inputImageTexture, textureCoordinate);\n    vec4 coldColor  = getColdColor(colorNoise);//\u51b7\u5374\u6ee4\u955c\n    vec4 lineColor = getLineColor(textureCoordinate, coldColor);//\u6a21\u62df\u7535\u89c6\u7ebf\u6761\u6548\u679c\n    return vec4(mix(coldColor.rgb, lineColor.rgb, lineColor.a * 0.3), 1.0);\n}\nvoid main() {\n    bool colorFlag=true;\n    for(int i=0;i<errorNum;i++){\n        vec4 element=errorElement[i];\n        if(element.x==0.0){//\u4ece\u5de6\u8fb9\u5f00\u59cb\n            X=0.0;\n        }else{//\u4ece\u53f3\u8fb9\u5f00\u59cb\n            X=(1.0-element.z)*imageWidth;\n        }\n        Y=element.y*imageHeight;\n        Width=element.z*imageWidth;\n        Height=element.w;\n//\n        if(gl_FragCoord.x>X&&gl_FragCoord.x<X+Width&&gl_FragCoord.y>Y&&gl_FragCoord.y<Y+Height){\n            vec2 sinBackColor = getBackColor(textureCoordinate);\n            vec4 colorBack = texture2D(inputImageTexture, sinBackColor);\n            if (redIndex!=-1&&i == redIndex) {\n                color = getSuperpositionCol(colorBack, vec4(250.0 / 255.0, 0.0, 0.0, 1.0));\n            } else if (redIndex!=-1&&i == greenIndex) {\n                color = getSuperpositionCol(colorBack, vec4(25.0 / 255.0, 1.0, 1.0 / 255.0, 1.0));\n            } else {\n                color = getErrorColor(inputImageTexture, sinBackColor);\n            }\n            vec4 teleColor = getOldTV();\n            gl_FragColor=vec4(mix(color.rgb,teleColor.rgb,teleColor.a*0.3),1.0);\n            colorFlag=false;\n        }\n    }\n    if(colorFlag){\n        gl_FragColor=getOldTV();\n    }\n    \n}";
    private float mDensity;
    private DisplayMetrics mDisplay;
    private int mErrorElemArrayLocation;
    private int mErrorGreenLocation;
    private int mErrorNumLocation;
    private int mErrorRedLocation;
    private boolean mErrorTwo;
    private int mFrame;
    private int mHeightLocation;
    private int mNoise;
    private int mNoiseLocation;
    private Random mRandom;
    private long mStartTimeMills;
    private float mTime;
    private int mTimeLocation;
    private int mWaveHeightLocation;
    private int mWidthLocation;

    public QQAVImageWrongEraseFilter() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", FRAGMENT_SHADER);
        this.mErrorTwo = false;
        this.mFrame = 0;
        this.mDensity = 1.0f;
        super.setQQAVEffectType(1011);
        Application application = SdkContext.getInstance().getApplication();
        if (application != null) {
            this.mDisplay = application.getResources().getDisplayMetrics();
        }
        this.mRandom = new Random();
    }

    private void checkErrorElem(boolean z16) {
        int nextInt;
        int nextInt2;
        int nextInt3;
        int i3 = 0;
        if (z16) {
            int nextInt4 = this.mRandom.nextInt(2) + 1;
            int nextInt5 = this.mRandom.nextInt(2) + 1 + nextInt4;
            nextInt = nextInt5 + 6;
            float[] fArr = new float[nextInt * 4];
            while (i3 < nextInt4) {
                int i16 = i3 * 4;
                fArr[i16] = this.mRandom.nextInt(2);
                fArr[i16 + 1] = this.mRandom.nextInt(10) / 10.0f;
                fArr[i16 + 2] = 1.0f;
                fArr[i16 + 3] = this.mDensity * 50.0f;
                i3++;
            }
            while (nextInt4 < nextInt5) {
                int i17 = nextInt4 * 4;
                fArr[i17] = this.mRandom.nextInt(2);
                fArr[i17 + 1] = this.mRandom.nextInt(10) / 10.0f;
                fArr[i17 + 2] = getRandomWidthRate();
                fArr[i17 + 3] = this.mDensity * 35.0f;
                nextInt4++;
            }
            while (nextInt5 < nextInt) {
                int i18 = nextInt5 * 4;
                fArr[i18] = this.mRandom.nextInt(2);
                fArr[i18 + 1] = this.mRandom.nextInt(10) / 10.0f;
                fArr[i18 + 2] = getRandomWidthRate();
                fArr[i18 + 3] = getRandomHeight();
                nextInt5++;
            }
            setInteger(this.mErrorNumLocation, nextInt);
            setArrayVec4(this.mErrorElemArrayLocation, nextInt, fArr);
        } else {
            nextInt = this.mRandom.nextInt(11);
            setInteger(this.mErrorNumLocation, nextInt);
            float[] fArr2 = new float[nextInt * 4];
            while (i3 < nextInt) {
                int i19 = i3 * 4;
                fArr2[i19] = this.mRandom.nextInt(2);
                fArr2[i19 + 1] = this.mRandom.nextInt(10) / 10.0f;
                fArr2[i19 + 2] = getRandomWidthRate();
                fArr2[i19 + 3] = getRandomHeight();
                i3++;
            }
            setArrayVec4(this.mErrorElemArrayLocation, nextInt, fArr2);
        }
        if (nextInt > 0) {
            int nextInt6 = this.mRandom.nextInt(3);
            if (nextInt6 != 0) {
                if (nextInt6 != 1) {
                    if (nextInt6 != 2) {
                        nextInt2 = -1;
                        nextInt3 = -1;
                    } else {
                        nextInt3 = this.mRandom.nextInt(nextInt);
                        nextInt2 = -1;
                    }
                } else {
                    nextInt2 = this.mRandom.nextInt(nextInt);
                    nextInt3 = -1;
                }
            } else {
                nextInt2 = this.mRandom.nextInt(nextInt);
                nextInt3 = this.mRandom.nextInt(nextInt);
            }
            if (nextInt2 > -1) {
                setInteger(this.mErrorRedLocation, nextInt2);
            }
            if (nextInt3 > -1) {
                setInteger(this.mErrorGreenLocation, nextInt3);
            }
        }
    }

    private void clearError() {
        setInteger(this.mErrorNumLocation, 0);
    }

    private float getRandomHeight() {
        float f16;
        int nextInt = this.mRandom.nextInt(5);
        if (nextInt != 0) {
            if (nextInt != 1) {
                if (nextInt != 2) {
                    if (nextInt != 3) {
                        if (nextInt != 4) {
                            f16 = 0.0f;
                        } else {
                            f16 = 50.0f;
                        }
                    } else {
                        f16 = 35.0f;
                    }
                } else {
                    f16 = 25.0f;
                }
            } else {
                f16 = 20.0f;
            }
        } else {
            f16 = 10.0f;
        }
        return f16 * this.mDensity;
    }

    private float getRandomWidthRate() {
        int nextInt = this.mRandom.nextInt(7);
        if (nextInt >= 3) {
            return 1.0f;
        }
        if (nextInt != 0) {
            if (nextInt != 1) {
                if (nextInt != 2) {
                    if (nextInt != 3) {
                        return 0.0f;
                    }
                    return 0.7f;
                }
                return 0.6f;
            }
            return 0.4f;
        }
        return 0.2f;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0049  */
    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw2(int i3, int i16) {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTimeMills;
        if (currentTimeMillis > 3000 && currentTimeMillis < 3250) {
            checkErrorElem(true);
        } else {
            int i17 = this.mFrame + 1;
            this.mFrame = i17;
            if (i17 != 2 && i17 != 5) {
                if (i17 == 14) {
                    this.mFrame = 0;
                } else {
                    z16 = false;
                    if (!z16) {
                        if (!this.mErrorTwo) {
                            checkErrorElem(false);
                            if (this.mRandom.nextInt(10) > 6) {
                                this.mErrorTwo = true;
                            }
                        } else {
                            this.mErrorTwo = false;
                        }
                    } else {
                        clearError();
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        float f16 = this.mTime;
        if (f16 >= 0.0f) {
            this.mTime = f16 - 1.0f;
        } else {
            this.mTime = 1000000.0f;
        }
        setFloat(this.mTimeLocation, this.mTime);
        if (this.mTime % 100.0f < 4.0f) {
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
        this.mErrorElemArrayLocation = GLES20.glGetUniformLocation(getProgram(), "errorElement");
        this.mErrorNumLocation = GLES20.glGetUniformLocation(getProgram(), "errorNum");
        this.mTimeLocation = GLES20.glGetUniformLocation(getProgram(), "u_time");
        this.mErrorRedLocation = GLES20.glGetUniformLocation(getProgram(), "redIndex");
        this.mErrorGreenLocation = GLES20.glGetUniformLocation(getProgram(), "greenIndex");
        this.mNoiseLocation = GLES20.glGetUniformLocation(getProgram(), "noise");
        this.mWaveHeightLocation = GLES20.glGetUniformLocation(getProgram(), "waveHeight");
        this.mStartTimeMills = System.currentTimeMillis();
        this.mTime = 1000000.0f;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        setFloat(this.mWidthLocation, i3);
        float f16 = i16;
        setFloat(this.mHeightLocation, f16);
        this.mDensity = (f16 / r2.heightPixels) * this.mDisplay.density;
    }

    protected void setArrayVec4(final int i3, final int i16, final float[] fArr) {
        runOnDraw(new Runnable() { // from class: com.tencent.av.opengl.filter.qqavimage.specialeffects.QQAVImageWrongEraseFilter.1
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glUniform4fv(i3, i16, FloatBuffer.wrap(fArr));
            }
        });
    }
}
