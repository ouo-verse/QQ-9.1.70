package com.tencent.intervideo.nowproxy.customized_interface;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.NowEntryData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class CustomizedReport {
    static IPatchRedirector $redirector_;

    public CustomizedReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void onNowEntry(Bundle bundle, NowEntryData nowEntryData);

    public abstract void onReport(Bundle bundle);

    public abstract void setNowEntryData(NowEntryData nowEntryData);
}
