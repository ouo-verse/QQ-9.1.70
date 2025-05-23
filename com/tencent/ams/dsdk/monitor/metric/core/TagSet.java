package com.tencent.ams.dsdk.monitor.metric.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TagSet {
    static IPatchRedirector $redirector_;
    public final String tagName;
    public final String tagValue;

    public TagSet(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.tagName = str;
            this.tagValue = str2;
        }
    }

    public static TagSet of(String str, String str2) {
        return new TagSet(str, str2);
    }
}
