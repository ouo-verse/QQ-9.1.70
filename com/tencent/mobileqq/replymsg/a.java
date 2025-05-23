package com.tencent.mobileqq.replymsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<Long, ChatMessage> f281239d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f281240e;

    public a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f281239d = new ConcurrentHashMap<>();
            this.f281240e = qQAppInterface;
        }
    }

    public ChatMessage a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ChatMessage) iPatchRedirector.redirect((short) 3, (Object) this, j3);
        }
        return this.f281239d.get(Long.valueOf(j3));
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f281239d.clear();
        }
    }
}
