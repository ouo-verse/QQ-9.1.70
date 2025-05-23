package com.tencent.autotemplate.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVVolumeRange {
    static IPatchRedirector $redirector_;

    @SerializedName("end")
    public float end;

    @SerializedName("start")
    public float start;

    public TAVVolumeRange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
