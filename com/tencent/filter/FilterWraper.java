package com.tencent.filter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FilterWraper extends BaseFilter {
    static IPatchRedirector $redirector_;
    private boolean available;
    protected String filterModel;
    protected long nativeObj;

    public FilterWraper(String str) {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.nativeObj = 0L;
        this.available = false;
        this.filterModel = str;
    }

    private void checkavailable() {
        if (this.available) {
        } else {
            throw new RuntimeException("use bad addr");
        }
    }

    private static native void nativeDispose(long j3);

    private static native int nativeGetOutputText(long j3);

    private static native long nativeInitialWithString(String str);

    private static native void nativeRenderContext(long j3, int i3, int i16, int i17);

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        if (this.available) {
            nativeDispose(this.nativeObj);
        }
        this.nativeObj = nativeInitialWithString(this.filterModel);
        this.available = true;
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void beforeRender(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.available) {
            nativeRenderContext(this.nativeObj, i3, i16, i17);
        }
        super.beforeRender(i3, i16, i17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void clearGLSL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.available) {
            nativeDispose(this.nativeObj);
            this.available = false;
        }
        super.clearGLSL();
    }

    @Override // com.tencent.filter.BaseFilter
    public boolean renderTexture(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        if (this.available) {
            return super.renderTexture(nativeGetOutputText(this.nativeObj), i16, i17);
        }
        return super.renderTexture(i3, i16, i17);
    }
}
