package com.tencent.qimei.ai;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.as.a;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class i implements IAsyncQimeiListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f343038a;

    public i(e eVar) {
        this.f343038a = eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar);
        }
    }

    @Override // com.tencent.qimei.sdk.IAsyncQimeiListener
    public void onQimeiDispatch(Qimei qimei) {
        com.tencent.qimei.av.f fVar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qimei);
            return;
        }
        String str = this.f343038a.f343025d;
        synchronized (com.tencent.qimei.av.f.class) {
            Map<String, com.tencent.qimei.av.f> map = com.tencent.qimei.av.f.f343156m;
            fVar = map.get(str);
            if (fVar == null) {
                fVar = new com.tencent.qimei.av.f(str);
                map.put(str, fVar);
            }
        }
        if (fVar.f343163g != null) {
            String str2 = com.tencent.qimei.ar.a.a(fVar.f343157a).f343094b.f343139k;
            if (!TextUtils.isEmpty(str2)) {
                if (!str2.equals(com.tencent.qimei.u.a.c())) {
                    return;
                }
            } else if (!com.tencent.qimei.u.a.f()) {
                return;
            }
            fVar.f343159c = a.b.B.a(com.tencent.qimei.ar.d.a(com.tencent.qimei.ar.a.a(fVar.f343157a).f343094b.f343146r)).intValue();
            fVar.f343158b = a.b.C.a(com.tencent.qimei.ar.d.a(com.tencent.qimei.ar.a.a(fVar.f343157a).f343094b.f343146r)).intValue();
            fVar.f343160d = a.b.H.a(com.tencent.qimei.ar.d.a(com.tencent.qimei.ar.a.a(fVar.f343157a).f343094b.f343146r)).intValue();
            if (fVar.f343158b == 0 && fVar.f343159c == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.qimei.ad.c.a(com.tencent.qimei.av.f.f343155l, "hid close", new Object[0]);
            } else {
                com.tencent.qimei.t.a.a().a(fVar.f343160d * 1000, new com.tencent.qimei.av.c(fVar));
            }
        }
    }
}
