package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class t {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final MessageRecord f286336a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f286337b;

    public t(MessageRecord messageRecord, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageRecord, (Object) bArr);
        } else {
            this.f286336a = messageRecord;
            this.f286337b = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t a() {
        return new t(new MessageRecord(), null);
    }
}
