package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SendMsgVerify {
    static IPatchRedirector $redirector_;
    public String clsName;
    public String cookie;

    /* renamed from: msg, reason: collision with root package name */
    @RecordForTest
    public MessageRecord f195864msg;
    public String msgContent;
    public String toServiceMsg;

    public SendMsgVerify() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
