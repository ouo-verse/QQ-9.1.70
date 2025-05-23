package com.tencent.mobileqq.webview;

import com.tencent.mobileqq.activity.aio.s;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
class UrlSecurityCheckManager$2 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ WeakReference f313766d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ WeakReference f313767e;
    final /* synthetic */ f this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ListView listView = (ListView) this.f313766d.get();
        s sVar = (s) this.f313767e.get();
        if (listView != null && sVar != null) {
            this.this$0.f(listView, sVar);
        }
    }
}
