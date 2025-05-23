package com.tencent.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.view.RendererUtils;

/* loaded from: classes6.dex */
public abstract class CPUFilter extends BaseFilter {
    static IPatchRedirector $redirector_;

    public CPUFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mIsGPU = false;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected abstract QImage ApplyFilter(QImage qImage);

    @Override // com.tencent.filter.BaseFilter
    public void RenderProcess(int i3, int i16, int i17, int i18, int i19, int i26, double d16, Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Double.valueOf(d16), frame);
            return;
        }
        if (this.mIsPreviewFilter) {
            super.RenderProcess(i3, i16, i17, i18, i19, i26, d16, frame);
            return;
        }
        QImage saveTexture2QImage = RendererUtils.saveTexture2QImage(i3, i16, i17);
        QImage ApplyFilter = ApplyFilter(saveTexture2QImage);
        GLSLRender.nativeTextImage(ApplyFilter, i26);
        saveTexture2QImage.Dispose();
        if (saveTexture2QImage != ApplyFilter) {
            ApplyFilter.Dispose();
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.mIsPreviewFilter = z16;
        if (z16) {
            super.applyFilterChain(z16, f16, f17);
        }
    }

    public CPUFilter(int i3) {
        super(BaseFilter.getFragmentShader(i3));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mIsGPU = false;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }
}
