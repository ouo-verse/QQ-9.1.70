package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureFloatsParam;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class BeautysRealAutoFilter extends BaseFilter {
    private float[] coef;
    private final int[] curveStatic;
    private final int[] meituWhiten;
    private float opttype;
    private BaseFilter processfilter;
    private float radius;
    private float scale;
    private float skinFilter;
    private SmootfilterImpFilter smootfilter1;
    private SmootfilterImpFilter smootfilter2;
    private float smoothMag;
    private float whitenmag;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class SmootfilterImpFilter extends BaseFilter {
        private boolean needUpdate;
        private int previewHeight;
        private int previewWidth;
        private float radius;
        private boolean useforHorizontal;

        public SmootfilterImpFilter(boolean z16) {
            super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
            this.radius = 0.5f;
            this.needUpdate = true;
            this.useforHorizontal = z16;
        }

        private void generrateShader() {
            int i3;
            float round = Math.round(((this.radius * 10.0f) / 720.0f) * this.previewWidth);
            if (round >= 1.0f) {
                double d16 = round;
                int floor = (int) Math.floor(Math.sqrt(Math.pow(d16, 2.0d) * (-2.0d) * Math.log(0.00390625f * Math.sqrt(Math.pow(d16, 2.0d) * 6.283185307179586d))));
                i3 = floor + (floor % 2);
            } else {
                i3 = 0;
            }
            boolean z16 = this.useforHorizontal;
            updateFragmentShader(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadiusOpt1(i3, round, z16, z16));
            clearGLSLSelf();
            apply();
            this.needUpdate = false;
        }

        @Override // com.tencent.filter.BaseFilter
        public void applyFilterChain(boolean z16, float f16, float f17) {
            this.previewWidth = (int) f16;
            this.previewHeight = (int) f17;
            generrateShader();
            super.applyFilterChain(z16, f16, f17);
        }

        @Override // com.tencent.filter.BaseFilter
        public void beforeRender(int i3, int i16, int i17) {
            boolean z16;
            if (!this.needUpdate && this.previewWidth == i16 && this.previewHeight == i17) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.needUpdate = z16;
            if (z16) {
                this.previewWidth = i16;
                this.previewHeight = i17;
                generrateShader();
            }
        }

        public void updateRadius(float f16) {
            this.radius = f16;
            this.needUpdate = true;
        }
    }

    public BeautysRealAutoFilter() {
        super(BaseFilter.getFragmentShader(122));
        this.curveStatic = new int[]{0, 1, 3, 4, 6, 7, 9, 10, 12, 13, 15, 16, 18, 19, 21, 22, 24, 25, 27, 28, 30, 31, 33, 34, 36, 37, 39, 40, 42, 43, 45, 46, 47, 49, 50, 52, 53, 55, 56, 58, 59, 61, 62, 63, 65, 66, 68, 69, 71, 72, 73, 75, 76, 78, 79, 80, 82, 83, 85, 86, 87, 89, 90, 92, 93, 94, 96, 97, 98, 100, 101, 102, 104, 105, 106, 108, 109, 110, 112, 113, 114, 116, 117, 118, 119, 121, 122, 123, 125, 126, 127, 128, 130, 131, 132, 133, 134, 136, 137, 138, 139, 140, 142, 143, 144, 145, 146, 147, 149, 150, 151, 152, 153, 154, 155, 156, 157, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 181, 182, 183, 184, 185, 186, 187, 188, 188, 189, 190, 191, 192, 193, 193, 194, 195, 196, 197, 197, 198, 199, 200, 201, 201, 202, 203, 204, 204, 205, 206, 207, 207, 208, 209, 209, 210, 211, 211, 212, 213, 213, 214, 215, 215, 216, 217, 217, 218, 219, 219, 220, 221, 221, 222, 222, 223, 224, 224, 225, 226, 226, 227, 227, 228, 228, 229, 230, 230, 231, 231, 232, 232, 233, 234, 234, 235, 235, 236, 236, 237, 237, 238, 238, 239, 240, 240, 241, 241, 242, 242, 243, 243, 244, 244, 245, 245, 246, 246, 247, 247, 248, 248, 249, 249, 250, 250, 251, 251, 252, 252, 253, 253, 254, 254, 255};
        this.meituWhiten = new int[]{0, 1, 3, 4, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 28, 29, 31, 33, 34, 36, 38, 39, 41, 42, 44, 46, 47, 49, 51, 52, 54, 55, 57, 59, 60, 62, 64, 65, 67, 68, 70, 71, 73, 75, 76, 78, 79, 81, 82, 84, 86, 87, 89, 90, 92, 93, 95, 96, 98, 99, 101, 102, 104, 105, 107, 108, 110, 111, 113, 114, 116, 117, 119, 120, 121, 123, 124, 126, 127, 128, 130, 131, 133, 134, 135, 137, 138, 139, 141, 142, 143, 145, 146, 147, 149, 150, 151, 152, 154, 155, 156, 157, 159, 160, 161, 162, 164, 165, 166, 167, 168, 169, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 186, 187, 188, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 200, 201, 202, 203, 204, 205, 205, 206, 207, 208, 208, 209, 210, 211, 211, 212, 213, 214, 214, 215, 216, 216, 217, 218, 218, 219, 219, 220, 221, 221, 222, 223, 223, 224, 224, 225, 225, 226, 226, 227, 228, 228, 229, 229, 230, 230, 231, 231, 232, 232, 233, 233, 234, 234, 234, 235, 235, 236, 236, 237, 237, 237, 238, 238, 239, 239, 240, 240, 240, 241, 241, 241, 242, 242, 243, 243, 243, 244, 244, 244, 245, 245, 245, 246, 246, 246, 247, 247, 247, 248, 248, 248, 249, 249, 249, 250, 250, 250, 251, 251, 251, 252, 252, 252, 253, 253, 253, 254, 254, 254, 255};
        this.processfilter = null;
        this.smootfilter1 = null;
        this.smootfilter2 = null;
        this.radius = 0.5f;
        this.whitenmag = 0.0f;
        this.opttype = 1.0f;
        this.scale = 1.0f;
        this.coef = new float[7];
        this.skinFilter = 1.0f;
        this.smoothMag = 0.3f;
        setRadius(1.0f);
    }

    private void setRadius(float f16) {
        float max = Math.max(0.0f, Math.min(f16, 1.0f));
        this.radius = max;
        if (this.smootfilter2 != null) {
            this.smootfilter1.updateRadius(max);
            this.smootfilter2.updateRadius(this.radius);
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        if (isValid()) {
            super.applyFilterChain(z16, f16, f17);
            return;
        }
        addParam(new UniformParam.FloatsParam("levelMinimum", new float[]{0.04f, 0.04f, 0.04f}));
        addParam(new UniformParam.FloatsParam("levelMiddle", new float[]{1.0f, 1.0f, 1.0f}));
        addParam(new UniformParam.FloatsParam("levelMaximum", new float[]{0.96f, 0.96f, 0.96f}));
        addParam(new UniformParam.FloatsParam("minOutput", new float[]{0.0f, 0.0f, 0.0f}));
        addParam(new UniformParam.FloatsParam("maxOutput", new float[]{1.0f, 1.0f, 1.0f}));
        SmootfilterImpFilter smootfilterImpFilter = new SmootfilterImpFilter(true);
        this.smootfilter1 = smootfilterImpFilter;
        smootfilterImpFilter.updateRadius(this.radius);
        setNextFilter(this.smootfilter1, null);
        SmootfilterImpFilter smootfilterImpFilter2 = new SmootfilterImpFilter(false);
        this.smootfilter2 = smootfilterImpFilter2;
        smootfilterImpFilter2.updateRadius(this.radius);
        this.smootfilter1.setNextFilter(this.smootfilter2, null);
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(121));
        this.processfilter = baseFilter;
        baseFilter.addParam(new TextureFloatsParam("inputImageTexture2", this.curveStatic, 33986));
        this.processfilter.addParam(new TextureFloatsParam("inputImageTexture3", this.meituWhiten, 33987));
        this.processfilter.addParam(new UniformParam.FloatParam("whiten", this.whitenmag));
        this.processfilter.addParam(new UniformParam.FloatParam("opttype", this.opttype));
        this.processfilter.addParam(new UniformParam.FloatParam("skinFilter", this.skinFilter));
        this.processfilter.addParam(new UniformParam.FloatParam("smoothMag", this.smoothMag));
        this.smootfilter2.setNextFilter(this.processfilter, null);
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void setParameterDic(Map<String, Object> map) {
        if (map.containsKey("opttype")) {
            float floatValue = ((Float) map.get("opttype")).floatValue();
            this.opttype = floatValue;
            BaseFilter baseFilter = this.processfilter;
            if (baseFilter != null) {
                baseFilter.addParam(new UniformParam.FloatParam("opttype", floatValue));
            }
        }
        if (map.containsKey("whitenmag")) {
            float max = Math.max(0.0f, Math.min(((Float) map.get("whitenmag")).floatValue(), 1.0f));
            this.whitenmag = max;
            BaseFilter baseFilter2 = this.processfilter;
            if (baseFilter2 != null) {
                baseFilter2.addParam(new UniformParam.FloatParam("whiten", max));
            }
        }
        if (map.containsKey("scale")) {
            this.scale = ((Float) map.get("scale")).floatValue();
        }
        if (map.containsKey("radius")) {
            setRadius(((Float) map.get("radius")).floatValue());
        }
        if (map.containsKey("smoothMag")) {
            float floatValue2 = ((Float) map.get("smoothMag")).floatValue();
            this.smoothMag = floatValue2;
            BaseFilter baseFilter3 = this.processfilter;
            if (baseFilter3 != null) {
                baseFilter3.addParam(new UniformParam.FloatParam("smoothMag", floatValue2));
            }
        }
        if (map.containsKey("skinFilter")) {
            float floatValue3 = ((Float) map.get("skinFilter")).floatValue();
            this.skinFilter = floatValue3;
            BaseFilter baseFilter4 = this.processfilter;
            if (baseFilter4 != null) {
                baseFilter4.addParam(new UniformParam.FloatParam("skinFilter", floatValue3));
            }
        }
    }
}
