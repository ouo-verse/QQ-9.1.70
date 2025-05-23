package com.tencent.mobileqq.activity.home.chats.callbcak;

import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.chats.NtBasePartFrame;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e implements com.tencent.qqnt.chats.core.ui.listener.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    Conversation f183002a;

    /* renamed from: b, reason: collision with root package name */
    NtBasePartFrame f183003b;

    public e(Conversation conversation, NtBasePartFrame ntBasePartFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) conversation, (Object) ntBasePartFrame);
        } else {
            this.f183002a = conversation;
            this.f183003b = ntBasePartFrame;
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.listener.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f183003b.w();
            this.f183002a.handlePullRefresh();
        }
    }
}
