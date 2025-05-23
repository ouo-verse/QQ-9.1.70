package com.tencent.mobileqq.qqlive.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
class SSORequestRecordHelper$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ k this$0;

    @Override // java.lang.Runnable
    public void run() {
        ConcurrentHashMap concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.this$0.c();
        concurrentHashMap = this.this$0.f273218b;
        concurrentHashMap.clear();
        this.this$0.f273217a = false;
    }
}
