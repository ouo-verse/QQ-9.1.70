package com.tencent.filter.ttpic;

import android.graphics.PointF;
import com.tencent.ads.data.AdParam;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class BlurHighRealFilter extends BaseFilter {
    private static String kPortraitBlurAreaFragmentShaderString = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float debug;\n uniform float inner;\n uniform float outer;\n uniform vec2 ellipse;\n uniform vec2 center;\n uniform vec3 line1;\n uniform vec3 line2;\n uniform float filterAdjustParam;\n void main() {\n     vec4 original = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 tempColor;\n     float fx = (textureCoordinate.x - center.x);\n     float fy = (textureCoordinate.y - center.y);\n     float dist = sqrt(fx * fx * ellipse.x + fy * fy * ellipse.y);\n     if (dist < inner) {\n         tempColor = original;\n     } else {\n         vec3 point = vec3(textureCoordinate.x, textureCoordinate.y, 1.0);\n         float value1 = dot(line1, point);\n         float value2 = dot(line2, point);\n         if (value1 >= 0.0 && value2 >= 0.0) {\n             tempColor = original;\n         } else {\n             vec4 blur = texture2D(inputImageTexture, textureCoordinate);\n             float lineAlpha = max(-value1 / 0.15, -value2 / 0.15);\n             float alpha = (dist - inner)/outer;\n             alpha = min(lineAlpha, alpha);\n             alpha = clamp(alpha, 0.0, 1.0);\n             tempColor = mix(original, blur, alpha);\n         }\n     }\n    gl_FragColor = mix(original,tempColor,filterAdjustParam);\n }\n";
    private float adjust;
    private float angle;
    private BaseFilter blurArea;
    private PointF center;
    private boolean circle;
    private float debug;
    private BaseFilter horizontal;
    private int previewHeight;
    private int previewWidth;
    private float radius;
    private float ratio;
    private BaseFilter vertical;

    public BlurHighRealFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.center = new PointF(0.5f, 0.5f);
        this.radius = 0.35f;
        this.ratio = 1.3333334f;
        this.angle = 0.0f;
        this.circle = false;
        this.debug = 0.0f;
        this.adjust = 0.0f;
        this.horizontal = null;
        this.vertical = null;
        this.blurArea = null;
    }

    private void setAngle(float f16) {
        float f17;
        float f18;
        double d16 = (float) ((f16 / 180.0f) * 3.141592653589793d);
        float[] fArr = {(float) Math.cos(d16), (float) Math.sin(d16), 0.0f};
        float[] fArr2 = {-((float) Math.sin(d16)), (float) Math.cos(d16), 0.0f};
        float[][] fArr3 = {fArr, fArr2, new float[]{0.0f, 0.0f, 1.0f}};
        if (this.circle) {
            f17 = 1.0f;
            f18 = 1.0f;
        } else {
            f17 = 0.9f;
            f18 = 1.5f;
        }
        float f19 = 1.0f / (f17 * f17);
        float f26 = 1.0f / (f18 * f18);
        float[] fArr4 = {f19, f26};
        float[] fArr5 = {0.0f, 0.0f};
        float[] fArr6 = fArr3[0];
        float f27 = (f19 * fArr6[0]) + (fArr6[1] * f26);
        fArr5[0] = f27;
        fArr5[1] = (fArr4[0] * fArr2[0]) + (f26 * fArr2[1]);
        fArr5[0] = Math.abs(f27);
        float abs = Math.abs(fArr5[1]);
        float f28 = this.ratio;
        fArr5[1] = abs * f28 * f28;
        BaseFilter baseFilter = this.blurArea;
        if (baseFilter != null) {
            baseFilter.addParam(new UniformParam.FloatsParam("ellipse", fArr5));
        }
        float[] fArr7 = {-0.3f, 1.0f, 0.0f};
        float[] fArr8 = fArr3[0];
        float f29 = fArr7[0];
        float[] fArr9 = fArr3[1];
        float[] fArr10 = fArr3[2];
        float[] fArr11 = {((-0.3f) * fArr8[0]) + (fArr8[1] * 1.0f) + (fArr8[2] * 0.0f), (fArr9[0] * f29) + (1.0f * fArr9[1]) + (fArr9[2] * 0.0f), (f29 * fArr10[0]) + (fArr7[1] * fArr10[1]) + (fArr10[2] * 0.0f)};
        float[] fArr12 = {0.3f, 1.0f, 0.0f};
        float f36 = fArr12[0] * fArr8[0];
        float f37 = fArr12[1];
        float f38 = f36 + (fArr8[1] * f37);
        float f39 = fArr12[2];
        float f46 = f38 + (fArr8[2] * f39);
        float f47 = fArr12[0];
        float f48 = (fArr9[0] * f47) + (f37 * fArr9[1]) + (fArr9[2] * f39);
        float[] fArr13 = {f46, f48, (f47 * fArr10[0]) + (fArr12[1] * fArr10[1]) + (f39 * fArr10[2])};
        float f49 = fArr11[0];
        PointF pointF = this.center;
        float f56 = pointF.x;
        float f57 = fArr11[1];
        float f58 = pointF.y;
        fArr11[2] = -((f49 * f56) + (f57 * f58));
        fArr13[2] = -((f46 * f56) + (f48 * f58));
        if (this.circle) {
            fArr11[0] = 0.0f;
            fArr11[1] = 0.0f;
            fArr11[2] = -0.15f;
            fArr13[0] = 0.0f;
            fArr13[1] = 0.0f;
            fArr13[2] = -0.15f;
        }
        BaseFilter baseFilter2 = this.blurArea;
        if (baseFilter2 != null) {
            baseFilter2.addParam(new UniformParam.FloatsParam("line1", fArr11));
            this.blurArea.addParam(new UniformParam.FloatsParam("line2", fArr13));
        }
        PointF pointF2 = this.center;
        float[] fArr14 = {pointF2.x, pointF2.y};
        BaseFilter baseFilter3 = this.blurArea;
        if (baseFilter3 != null) {
            baseFilter3.addParam(new UniformParam.FloatsParam("center", fArr14));
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        int i3;
        int i16 = (int) f16;
        this.previewWidth = i16;
        this.previewHeight = (int) f17;
        if (i16 != 0) {
            this.ratio = f17 / f16;
        }
        float round = Math.round(0.008333334f * f16);
        if (round >= 1.0f) {
            double d16 = round;
            int floor = (int) Math.floor(Math.sqrt(Math.pow(d16, 2.0d) * (-2.0d) * Math.log(0.00390625f * Math.sqrt(Math.pow(d16, 2.0d) * 6.283185307179586d))));
            i3 = floor + (floor % 2);
        } else {
            i3 = 0;
        }
        this.horizontal = new BaseFilter(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(i3, round, true));
        this.vertical = new BaseFilter(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(i3, round, false));
        this.blurArea = new BaseFilter(kPortraitBlurAreaFragmentShaderString);
        setNextFilter(this.horizontal, null);
        this.horizontal.setNextFilter(this.vertical, null);
        this.vertical.setNextFilter(this.blurArea, new int[]{this.srcTextureIndex});
        this.blurArea.addParam(new UniformParam.FloatParam("debug", this.debug));
        this.blurArea.addParam(new UniformParam.FloatParam("outer", 0.12f));
        this.blurArea.addParam(new UniformParam.FloatParam("inner", this.radius));
        this.blurArea.addParam(new UniformParam.FloatParam("filterAdjustParam", this.adjust));
        setAngle(this.angle);
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void beforeRender(int i3, int i16, int i17) {
        int i18;
        if (this.previewWidth != i16 || this.previewHeight != i17) {
            this.previewWidth = i16;
            this.previewHeight = i17;
            float round = Math.round(i16 * 0.008333334f);
            if (round >= 1.0f) {
                double d16 = round;
                int floor = (int) Math.floor(Math.sqrt(Math.pow(d16, 2.0d) * (-2.0d) * Math.log(0.00390625f * Math.sqrt(Math.pow(d16, 2.0d) * 6.283185307179586d))));
                i18 = floor + (floor % 2);
            } else {
                i18 = 0;
            }
            this.horizontal.updateFragmentShader(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(i18, round, true));
            this.horizontal.clearGLSLSelf();
            this.horizontal.apply();
            this.vertical.updateFragmentShader(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadius(i18, round, false));
            this.vertical.clearGLSLSelf();
            this.vertical.apply();
            setAngle(this.angle);
        }
    }

    public boolean needRender() {
        if (Math.abs(this.adjust) > 0.01f) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.filter.BaseFilter
    public void setAdjustParam(float f16) {
        this.adjust = f16;
        this.blurArea.addParam(new UniformParam.FloatParam("filterAdjustParam", f16));
    }

    @Override // com.tencent.filter.BaseFilter
    public void setParameterDic(Map<String, Object> map) {
        if (map.containsKey(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_CIRCLE)) {
            this.circle = ((Boolean) map.get(WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_CIRCLE)).booleanValue();
        }
        if (map.containsKey("debug")) {
            float floatValue = ((Float) map.get("debug")).floatValue();
            this.debug = floatValue;
            BaseFilter baseFilter = this.blurArea;
            if (baseFilter != null) {
                baseFilter.addParam(new UniformParam.FloatParam("debug", floatValue));
            }
        }
        if (map.containsKey("tx")) {
            this.center.x = ((Float) map.get("tx")).floatValue();
        }
        if (map.containsKey(AdParam.TY)) {
            this.center.y = ((Float) map.get(AdParam.TY)).floatValue();
        }
        if (map.containsKey("ratio")) {
            this.ratio = ((Float) map.get("ratio")).floatValue();
        }
        if (map.containsKey("radius")) {
            float floatValue2 = ((Float) map.get("radius")).floatValue();
            this.radius = floatValue2;
            BaseFilter baseFilter2 = this.blurArea;
            if (baseFilter2 != null) {
                baseFilter2.addParam(new UniformParam.FloatParam("inner", floatValue2));
            }
        }
        if (map.containsKey("angle")) {
            this.angle = ((Float) map.get("angle")).floatValue();
        }
        setAngle(this.angle);
    }
}
