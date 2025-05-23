package com.tencent.mobileqq.vip;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
class AioVipKeywordHelper$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ QQAppInterface f312707d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SessionInfo f312708e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f312709f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ ChatMessage f312710h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f312711i;
    final /* synthetic */ b this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        b bVar = this.this$0;
        if (bVar.f312918a != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AioVipKeywordHelper", 4, "keyword has been detected, message is ignored.");
            }
        } else {
            if (!bVar.f(this.f312707d, this.f312708e)) {
                return;
            }
            this.this$0.b(b.f312916l, this.f312709f.toLowerCase(), this.f312710h, this.f312711i, this.f312707d, this.f312708e);
        }
    }
}
