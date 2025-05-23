package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ag {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    MessageRecord f116512a;

    /* renamed from: b, reason: collision with root package name */
    boolean f116513b;

    public ag(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, messageRecord, Boolean.valueOf(z16));
        } else {
            this.f116512a = messageRecord;
            this.f116513b = z16;
        }
    }
}
