package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.view.RendererUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HistogramsStrectchFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private float maxRatio;
    private float minRatio;

    public HistogramsStrectchFilter() {
        super(BaseFilter.getFragmentShader(32));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.minRatio = 0.001f;
            this.maxRatio = 0.999f;
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        addParam(new UniformParam.FloatParam("l_threshold", 0.1f));
        addParam(new UniformParam.FloatParam("h_threshold", 0.1f));
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void beforeRender(int i3, int i16, int i17) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        QImage saveTexture2QImage = RendererUtils.saveTexture2QImage(i3, i16, i17);
        int[] nativeGetArrayHistogram = saveTexture2QImage.nativeGetArrayHistogram();
        saveTexture2QImage.Dispose();
        int i26 = 0;
        for (int i27 = 0; i27 < 256; i27++) {
            i26 += nativeGetArrayHistogram[i27];
        }
        float f16 = i26;
        int i28 = (int) (this.minRatio * f16);
        int i29 = (int) (f16 * this.maxRatio);
        int i36 = 0;
        int i37 = 0;
        while (true) {
            if (i36 < 256) {
                i37 += nativeGetArrayHistogram[i36];
                if (i37 >= i28) {
                    int i38 = i36;
                    i36++;
                    i18 = i38;
                    break;
                }
                i36++;
            } else {
                i18 = 0;
                break;
            }
        }
        while (true) {
            if (i36 >= 256) {
                break;
            }
            i37 += nativeGetArrayHistogram[i36];
            if (i37 >= i29) {
                i19 = i36;
                break;
            }
            i36++;
        }
        addParam(new UniformParam.FloatParam("l_threshold", (float) (i18 / 255.0d)));
        addParam(new UniformParam.FloatParam("h_threshold", (float) (i19 / 255.0d)));
    }

    @Override // com.tencent.filter.BaseFilter
    public boolean renderTexture(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        return super.renderTexture(i3, i16, i17);
    }

    public HistogramsStrectchFilter(float f16, float f17) {
        super(BaseFilter.getFragmentShader(32));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.minRatio = f16;
            this.maxRatio = f17;
        }
    }
}
