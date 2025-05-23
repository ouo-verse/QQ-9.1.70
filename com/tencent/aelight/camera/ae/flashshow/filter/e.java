package com.tencent.aelight.camera.ae.flashshow.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.filter.shader.ShaderContentConstans;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.util.AlgoUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends VideoFilterBase {

    /* renamed from: e, reason: collision with root package name */
    private static final String f64332e = "e";

    /* renamed from: f, reason: collision with root package name */
    private static final double[] f64333f = {0.7200000286102295d, 0.0d};

    /* renamed from: g, reason: collision with root package name */
    static String f64334g = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float oneOverZ;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int blendMode;\nuniform vec2 canvasSize;\nuniform float alpha;\nuniform vec2 displacement;\nuniform sampler2D inputImageTexture4;\nuniform int displacementEnableLut; \nuniform sampler2D inputImageTexture5;\nuniform float useDisplacementMask; \n\n vec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 vOne = vec3(1.0, 1.0, 1.0);\n     vec3 vZero = vec3(0.0, 0.0, 0.0);\n     //revert pre multiply\n     if(texColor.a > 0.0){\n        texColor.rgb = texColor.rgb / texColor.a;\n     }\n     vec3 resultFore = texColor.rgb;\n     if (blendMode <= 1 || blendMode > 12){ //default, since used most, put on top\n\n     } else if (blendMode == 2) {  //multiply\n         resultFore = canvasColor.rgb * texColor.rgb;\n     } else if (blendMode == 3){    //screen\n         resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n     } else if (blendMode == 4){    //overlay\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (canvasColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (canvasColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (canvasColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 5){    //hardlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (texColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 6){    //softlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n         if (texColor.r >= 0.5) {\n             resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n         }\n     } else if (blendMode == 7){    //divide\n         resultFore = vOne;\n         if (texColor.r > 0.0) {\n             resultFore.r = canvasColor.r / texColor.r;\n         }\n         if (texColor.g > 0.0) {\n             resultFore.g = canvasColor.g / texColor.g;\n         }\n         if (texColor.b > 0.0) {\n             resultFore.b = canvasColor.b / texColor.b;\n         }\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 8){    //add\n         resultFore = canvasColor.rgb + texColor.rgb;\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 9){    //substract\n         resultFore = canvasColor.rgb - texColor.rgb;\n         resultFore = max(vZero, resultFore);\n     } else if (blendMode == 10){   //diff\n         resultFore = abs(canvasColor.rgb - texColor.rgb);\n     } else if (blendMode == 11){   //darken\n         resultFore = min(canvasColor.rgb, texColor.rgb);\n     } else if (blendMode == 12){   //lighten\n         resultFore = max(canvasColor.rgb, texColor.rgb);\n     }\n     //pre multiply for glBlendFunc\n     vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n     return resultColor;\n }\nvec4 lut(vec4 inputColor, sampler2D lutImage) {\n  highp float blueColor = inputColor.b * 63.0;\n  highp vec2 quad1; \n  quad1.y = floor(floor(blueColor) / 8.0);\n  quad1.x = floor(blueColor) - (quad1.y * 8.0);\n  highp vec2 quad2;\n  quad2.y = floor(ceil(blueColor) / 8.0);\n  quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n  highp vec2 texPos1;\n  texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  highp vec2 texPos2;\n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  lowp vec4 newColor1 = texture2D(lutImage, texPos1);\n  lowp vec4 newColor2 = texture2D(lutImage, texPos2);\n  return vec4(mix(newColor1.rgb, newColor2.rgb, fract(blueColor)), inputColor.a);\n}\n\nvoid main(void)\n{\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec2 offset = vec2(0.0);\n    float displacementMaskAlpha = 1.0; \n    if (useDisplacementMask > 0.5) {\n      vec4 lightnessColor = texture2D(inputImageTexture5, canvasCoordinate); \n      displacementMaskAlpha = lightnessColor.a; \n      if (displacementEnableLut == 1) {\n         lightnessColor = lut(lightnessColor, inputImageTexture4); \n      } \n      float lightness = dot(lightnessColor.rgb, vec3(0.3, 0.6, 0.1)) * 2.0 - 1.0;\n      offset = displacement * lightness; \n    }\n    vec4 texColor = texture2D(inputImageTexture2, (textureCoordinate + offset) / oneOverZ);\n    texColor.a = texColor.a * alpha;\n    vec4 stickerColor = blendColor(texColor, canvasColor);\n     if(stickerColor.a > 0.0){\n        stickerColor.rgb = stickerColor.rgb / stickerColor.a;\n     }\n    gl_FragColor = vec4(mix(canvasColor.rgb, stickerColor.rgb, stickerColor.a), canvasColor.a);\n}";

    /* renamed from: a, reason: collision with root package name */
    private int[] f64335a;

    /* renamed from: b, reason: collision with root package name */
    private int f64336b;

    /* renamed from: c, reason: collision with root package name */
    private int f64337c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f64338d;

    public e() {
        super(ShaderContentConstans.MCCOMMON_VERTEX_SHADER_DAT, f64334g);
        this.f64335a = new int[2];
        this.f64338d = false;
        this.f64336b = 150;
        this.f64337c = 150;
        this.dataPath = null;
        initParams();
    }

    private void c() {
        addParam(new UniformParam.TextureParam("inputImageTexture2", a("qqwink_watermark.png"), 33986));
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void ApplyGLSLFilter() {
        super.ApplyGLSLFilter();
        GlUtil.createEtcTexture(this.f64335a);
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void clearGLSLSelf() {
        super.clearGLSLSelf();
        this.f64338d = false;
        int[] iArr = this.f64335a;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
        synchronized (this) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.f64335a;
                if (i3 < iArr2.length) {
                    iArr2[i3] = 0;
                    i3++;
                }
            }
        }
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void initParams() {
        addParam(new UniformParam.IntParam(com.tencent.luggage.wxa.c8.c.W, 1));
        addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
        addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
        addParam(new UniformParam.IntParam("texNeedTransform", 1));
        addParam(new UniformParam.Float2fParam("canvasSize", 0.0f, 0.0f));
        addParam(new UniformParam.Float2fParam("texAnchor", 0.0f, 0.0f));
        addParam(new UniformParam.FloatParam("texScale", 1.0f));
        addParam(new UniformParam.FloatParam("texScaleX", 1.0f));
        addParam(new UniformParam.FloatParam("texScaleY", 1.0f));
        addParam(new UniformParam.Float3fParam("texRotate", 0.0f, 0.0f, 0.0f));
        addParam(new UniformParam.FloatParam(com.tencent.luggage.wxa.c8.c.f123400v, 1.0f));
        addParam(new UniformParam.Mat4Param("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0f, 4.0f, 10.0f)));
        addParam(new UniformParam.Float2fParam("displacement", 0.0f, 0.0f));
        addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
        addParam(new UniformParam.IntParam("displacementEnableLut", 0));
        addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33989));
        addParam(new UniformParam.FloatParam("useDisplacementMask", 0.0f));
        setPositions(GlUtil.EMPTY_POSITIONS);
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void updateVideoSize(int i3, int i16, double d16) {
        super.updateVideoSize(i3, i16, d16);
        addParam(new UniformParam.Float2fParam("canvasSize", i3, i16));
        b(f64333f);
        c();
    }

    public void b(double[] dArr) {
        if (dArr != null && dArr.length >= 2) {
            int i3 = this.width;
            double d16 = i3 / 720.0d;
            int i16 = this.height;
            int i17 = (int) (i16 * (1.0d - dArr[1]));
            setPositions(AlgoUtils.calPositions((int) (i3 * dArr[0]), i17, r13 + ((int) (this.f64336b * d16)), (int) (i17 - (this.f64337c * d16)), i3, i16));
            return;
        }
        setPositions(GlUtil.EMPTY_POSITIONS);
    }

    private int a(String str) {
        if (str != null && !this.f64338d) {
            Bitmap decodeSampledBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), str, 200, 200);
            if (BitmapUtils.isLegal(decodeSampledBitmapFromAssets)) {
                BenchUtil.benchStart("1normal loadTexture");
                try {
                    GlUtil.loadTexture(this.f64335a[0], decodeSampledBitmapFromAssets);
                } catch (Exception e16) {
                    LogUtils.e(f64332e, "1getNextFrame:loadTexture Exception:" + e16.getMessage());
                }
                this.f64338d = true;
                if (decodeSampledBitmapFromAssets != null) {
                    decodeSampledBitmapFromAssets.recycle();
                }
            }
        }
        return this.f64335a[0];
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase, com.tencent.aekit.openrender.internal.AEFilterI
    public void updatePreview(Object obj) {
    }
}
