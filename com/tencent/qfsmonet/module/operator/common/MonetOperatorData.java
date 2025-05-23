package com.tencent.qfsmonet.module.operator.common;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Keep
/* loaded from: classes22.dex */
public class MonetOperatorData {
    static IPatchRedirector $redirector_;
    private int mDataFormat;
    private String mInputName;

    public MonetOperatorData(@NonNull String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        } else {
            this.mInputName = str;
            this.mDataFormat = i3;
        }
    }

    public int getDataFormat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mDataFormat;
    }

    @NonNull
    public String getDataName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mInputName;
    }
}
