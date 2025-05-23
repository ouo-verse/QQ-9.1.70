package com.tencent.mobileqq.friend.cache;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ev;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
class AbsCache$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ vc1.c f211550d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Object f211551e;
    final /* synthetic */ a this$0;

    /* JADX WARN: Type inference failed for: r1v5, types: [com.tencent.mobileqq.persistence.Entity] */
    @Override // java.lang.Runnable
    public void run() {
        Map map;
        Map map2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        StringBuilder a16 = ev.a();
        map = this.this$0.f211585a;
        map.put(a16.toString(), this.f211550d);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("uid:");
        sb5.append(a16.toString());
        sb5.append(" size:");
        map2 = this.this$0.f211585a;
        sb5.append(map2.size());
        QLog.d("AbsCache", 1, sb5.toString());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(a16, this.this$0.c(this.f211551e)) { // from class: com.tencent.mobileqq.friend.cache.AbsCache$1.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ StringBuilder f211552d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Entity f211553e;

            {
                this.f211552d = a16;
                this.f211553e = r9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AbsCache$1.this, a16, r9);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Map map3;
                Map map4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    map3 = AbsCache$1.this.this$0.f211585a;
                    vc1.c cVar = (vc1.c) map3.get(this.f211552d.toString());
                    if (cVar == null) {
                        return;
                    }
                    cVar.a(this.f211553e);
                    map4 = AbsCache$1.this.this$0.f211585a;
                    map4.remove(this.f211552d.toString());
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }
}
