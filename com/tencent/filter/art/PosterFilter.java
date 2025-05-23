package com.tencent.filter.art;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.oscarcamera.particlesystem.AttributeConst;
import java.util.Map;

/* loaded from: classes6.dex */
public class PosterFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private float edgeFactor;
    private int type;

    public PosterFilter(int i3) {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.edgeFactor = 1.0f;
            this.type = i3;
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        clearGLSL();
        if (z16) {
            this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
            setNextFilter(null, null);
        } else {
            this.glslProgramShader = BaseFilter.getFragmentShader(78);
            BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(77));
            setNextFilter(baseFilter2, null);
            BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(79));
            baseFilter2.setNextFilter(baseFilter3, null);
            BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(72));
            baseFilter4.addParam(new UniformParam.FloatParam("threshold", 0.0f));
            baseFilter3.setNextFilter(baseFilter4, null);
            BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(83));
            baseFilter4.setNextFilter(baseFilter5, null);
            BaseFilter baseFilter6 = new BaseFilter(BaseFilter.getFragmentShader(84));
            baseFilter6.addParam(new UniformParam.FloatParam("inv_2sigma2", 127.00195f));
            baseFilter6.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 8.0E-4f));
            baseFilter6.addParam(new UniformParam.FloatParam("edge_factor", this.edgeFactor));
            baseFilter5.setNextFilter(baseFilter6, new int[]{2});
            BaseFilter baseFilter7 = new BaseFilter(BaseFilter.getFragmentShader(85));
            baseFilter7.addParam(new UniformParam.FloatParam("par", 0.35f));
            baseFilter7.addParam(new UniformParam.FloatParam("par_b", 0.2f));
            if (this.type == 0) {
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.A, new float[]{1.0f, 1.0f, 1.0f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.B, new float[]{0.8666667f, 0.84705883f, 0.6666667f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorC", new float[]{0.87058824f, 0.30980393f, 0.16470589f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorD", new float[]{0.20392157f, 0.40784314f, 0.40784314f, 1.0f}));
            }
            if (this.type == 1) {
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.A, new float[]{0.8117647f, 0.9647059f, 0.9607843f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.B, new float[]{0.8627451f, 0.88235295f, 0.7921569f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorC", new float[]{0.827451f, 0.6901961f, 0.23529412f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorD", new float[]{0.44705883f, 0.40784314f, 0.31764707f, 1.0f}));
            }
            if (this.type == 2) {
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.A, new float[]{0.7411765f, 0.8627451f, 0.827451f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.B, new float[]{0.88235295f, 0.68235296f, 0.73333335f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorC", new float[]{0.6313726f, 0.52156866f, 0.6901961f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorD", new float[]{0.39607844f, 0.32941177f, 0.49803922f, 1.0f}));
            }
            if (this.type == 3) {
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.A, new float[]{0.9882353f, 0.99607843f, 0.88235295f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.B, new float[]{0.9882353f, 0.99607843f, 0.88235295f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorC", new float[]{0.85490197f, 0.7372549f, 0.4392157f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorD", new float[]{0.654902f, 0.45882353f, 0.47843137f, 1.0f}));
            }
            if (this.type == 4) {
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.A, new float[]{1.0f, 0.9529412f, 0.78431374f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.B, new float[]{1.0f, 0.9529412f, 0.78431374f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorC", new float[]{0.8f, 0.84313726f, 0.5372549f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorD", new float[]{0.0f, 0.3254902f, 0.3529412f, 1.0f}));
            }
            if (this.type == 5) {
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.A, new float[]{1.0f, 0.9137255f, 0.6862745f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam(AttributeConst.B, new float[]{1.0f, 0.9137255f, 0.6862745f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorC", new float[]{0.43529412f, 0.85490197f, 0.8901961f, 1.0f}));
                baseFilter7.addParam(new UniformParam.FloatsParam("colorD", new float[]{0.9647059f, 0.36078432f, 0.53333336f, 1.0f}));
            }
            baseFilter6.setNextFilter(baseFilter7, new int[]{4});
            if (GLES20.glGetString(7937).indexOf("NVIDIA Tegra") != -1) {
                baseFilter = new BaseFilter(BaseFilter.getFragmentShader(87));
            } else {
                baseFilter = new BaseFilter(BaseFilter.getFragmentShader(86));
                baseFilter.addParam(new UniformParam.IntParam("radius", 2));
            }
            baseFilter.addParam(new UniformParam.FloatParam("inv_2sigma", 4.4f));
            baseFilter7.setNextFilter(baseFilter, new int[]{4});
        }
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void setParameterDic(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            return;
        }
        if (map.containsKey("effectIndex")) {
            this.type = ((Integer) map.get("effectIndex")).intValue();
        }
        if (map.containsKey("detail")) {
            this.edgeFactor = ((Float) map.get("detail")).floatValue();
        }
    }
}
