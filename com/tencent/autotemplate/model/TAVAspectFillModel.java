package com.tencent.autotemplate.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CGSize;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVAspectFillModel {
    static IPatchRedirector $redirector_;

    @SerializedName("backgroundColor")
    public String backgroundColor;

    @SerializedName("renderSize")
    public CGSize renderSize;

    public TAVAspectFillModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
