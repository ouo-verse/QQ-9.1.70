package com.tencent.autotemplate.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVTransitionAutomaticEffect extends TAVBaseAutomaticEffect {
    static IPatchRedirector $redirector_;

    @SerializedName("subTransitions")
    public List<TAVTransitionAutomaticEffect> subTransitions;

    public TAVTransitionAutomaticEffect(@NonNull String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public List<TAVTransitionAutomaticEffect> getSubTransitions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.subTransitions;
    }

    public boolean isFaceTransition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return TextUtils.equals(this.parameter.type, TAVBaseAutomaticEffect.TYPE_GRADIENT_FACE);
    }
}
