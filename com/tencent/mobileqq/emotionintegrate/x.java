package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class x extends r {
    static IPatchRedirector $redirector_;

    public x(String str, int i3) {
        super(str, i3, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
    }

    private String h() {
        SessionInfo sessionInfo = this.f205269c;
        if (sessionInfo != null) {
            return sessionInfo.f179559f;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emotionintegrate.r
    public List<MessageRecord> d(String str, int i3, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3));
        }
        return g(h(), this.f205267a, i3);
    }

    public List<MessageRecord> g(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3));
        }
        return this.f205276j.getMessageProxy(i3).b0(str, str2, 60);
    }

    public x(SessionInfo sessionInfo, String str, int i3) {
        super(sessionInfo, str, i3, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, sessionInfo, str, Integer.valueOf(i3));
    }
}
