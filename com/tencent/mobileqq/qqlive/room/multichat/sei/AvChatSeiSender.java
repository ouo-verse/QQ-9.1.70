package com.tencent.mobileqq.qqlive.room.multichat.sei;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AvChatSeiSender extends a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.room.multichat.sei.AvChatSeiSender$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ AvChatSeiSender this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                AvChatSeiSender.a(null);
                throw null;
            }
        }
    }

    static /* bridge */ /* synthetic */ b a(AvChatSeiSender avChatSeiSender) {
        throw null;
    }
}
