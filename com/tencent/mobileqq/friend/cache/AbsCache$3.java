package com.tencent.mobileqq.friend.cache;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ev;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import vc1.e;

/* compiled from: P */
/* loaded from: classes12.dex */
class AbsCache$3 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ e f211560d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Entity f211561e;
    final /* synthetic */ a this$0;

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
        map = this.this$0.f211587c;
        map.put(a16.toString(), this.f211560d);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("uid:");
        sb5.append(a16.toString());
        sb5.append(" size:");
        map2 = this.this$0.f211587c;
        sb5.append(map2.size());
        QLog.d("AbsCache", 1, sb5.toString());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(a16, this.this$0.d(this.f211561e)) { // from class: com.tencent.mobileqq.friend.cache.AbsCache$3.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ StringBuilder f211562d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f211563e;

            {
                this.f211562d = a16;
                this.f211563e = r7;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AbsCache$3.this, a16, Boolean.valueOf(r7));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Map map3;
                Map map4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    map3 = AbsCache$3.this.this$0.f211587c;
                    e eVar = (e) map3.get(this.f211562d.toString());
                    if (eVar == null) {
                        return;
                    }
                    eVar.a(this.f211563e);
                    map4 = AbsCache$3.this.this$0.f211587c;
                    map4.remove(this.f211562d.toString());
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }
}
