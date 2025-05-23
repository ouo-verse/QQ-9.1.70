package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HSVColorChannelFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private int channelflag;

    /* renamed from: fh, reason: collision with root package name */
    private float f106449fh;
    private float flb;
    private float fld;
    private float frb;
    private float frd;

    /* renamed from: fs, reason: collision with root package name */
    private float f106450fs;

    /* renamed from: fv, reason: collision with root package name */
    private float f106451fv;

    public HSVColorChannelFilter() {
        super(BaseFilter.getFragmentShader(133));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f106449fh = 0.5f;
        this.f106450fs = 0.5f;
        this.f106451fv = 0.5f;
        this.flb = -1.0f;
        this.fld = -1.0f;
        this.frd = -1.0f;
        this.frb = -1.0f;
        this.channelflag = -1;
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        int i3 = this.channelflag;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        this.glslProgramShader = BaseFilter.getFragmentShader(133);
                    } else {
                        this.glslProgramShader = BaseFilter.getFragmentShader(132);
                    }
                } else {
                    this.glslProgramShader = BaseFilter.getFragmentShader(131);
                }
            } else {
                this.glslProgramShader = BaseFilter.getFragmentShader(130);
            }
        } else {
            this.glslProgramShader = BaseFilter.getFragmentShader(129);
        }
        addParam(new UniformParam.FloatParam("fh", this.f106449fh));
        addParam(new UniformParam.FloatParam("fs", this.f106450fs));
        addParam(new UniformParam.FloatParam("fv", this.f106451fv));
        addParam(new UniformParam.FloatParam("flb", this.flb));
        addParam(new UniformParam.FloatParam("fld", this.fld));
        addParam(new UniformParam.FloatParam("frd", this.frd));
        addParam(new UniformParam.FloatParam("frb", this.frb));
        addParam(new UniformParam.IntParam("channelflag", this.channelflag));
        super.applyFilterChain(z16, f16, f17);
    }

    int checkColorRange(double d16, double d17, double d18, double d19) {
        if (d16 < d17 && d17 < d18 && d18 < d19) {
            return 0;
        }
        if (d16 < d17 && d18 < d19 && d16 > d19) {
            return 1;
        }
        if (d16 > d19 && d17 < d18 && d18 < d19) {
            return 2;
        }
        if (d16 >= d17 || d17 >= d18 || d16 <= d19) {
            return -1;
        }
        if (d16 == 303.0d && d17 == 323.0d) {
            return -1;
        }
        return 3;
    }

    public void setInput(float f16, float f17, float f18, float f19, float f26, float f27, float f28) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Float.valueOf(f27), Float.valueOf(f28));
            return;
        }
        this.flb = f19 / 360.0f;
        this.fld = f26 / 360.0f;
        this.frd = f27 / 360.0f;
        this.frb = f28 / 360.0f;
        this.f106449fh = (f16 / 180.0f) * 0.5f;
        this.f106450fs = f17 / 100.0f;
        this.f106451fv = f18 / 100.0f;
        this.channelflag = checkColorRange(f19, f26, f27, f28);
        addParam(new UniformParam.FloatParam("fh", this.f106449fh));
        addParam(new UniformParam.FloatParam("fs", this.f106450fs));
        addParam(new UniformParam.FloatParam("fv", this.f106451fv));
        addParam(new UniformParam.FloatParam("flb", this.flb));
        addParam(new UniformParam.FloatParam("fld", this.fld));
        addParam(new UniformParam.FloatParam("frd", this.frd));
        addParam(new UniformParam.FloatParam("frb", this.frb));
        addParam(new UniformParam.IntParam("channelflag", this.channelflag));
        this.glslProgramShader = BaseFilter.getFragmentShader(133);
    }
}
