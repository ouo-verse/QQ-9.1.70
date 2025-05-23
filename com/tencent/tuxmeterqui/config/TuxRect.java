package com.tencent.tuxmeterqui.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxRect implements Serializable {
    static IPatchRedirector $redirector_;
    public float leftBottom;
    public float leftTop;
    public float rightBottom;
    public float rightTop;

    public TuxRect(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        this.leftTop = f16;
        this.rightTop = f17;
        this.leftBottom = f18;
        this.rightBottom = f19;
    }
}
