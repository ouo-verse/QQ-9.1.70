package com.tencent.ams.fusion.widget.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class LayerParams {
    static IPatchRedirector $redirector_;
    public int height;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f70536x;

    /* renamed from: y, reason: collision with root package name */
    public int f70537y;

    public LayerParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
