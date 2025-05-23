package com.tencent.qq.effect.engine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* loaded from: classes22.dex */
public class QEffectProto {
    static IPatchRedirector $redirector_;
    public String defImg;
    public List<QEffectData> eles;
    public int minVer;

    public QEffectProto() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
