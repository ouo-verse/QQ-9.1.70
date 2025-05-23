package com.tencent.paysdk.vipauth;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.network.VipAuthRequestUtil;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends DefinitionAuthInternal {
    static IPatchRedirector $redirector_;

    public c(@NonNull @NotNull com.tencent.paysdk.api.c cVar) {
        super(cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        }
    }

    @Override // com.tencent.paysdk.vipauth.DefinitionAuthInternal, com.tencent.paysdk.network.c
    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
        } else {
            com.tencent.paysdk.log.c.b("LiveDefinitionAuthInternal", str);
            super.a(i3, str);
        }
    }

    @Override // com.tencent.paysdk.vipauth.DefinitionAuthInternal
    protected Map<String, Object> c(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module", "\u6e05\u6670\u5ea6\u9274\u6743");
        hashMap.put(ServiceConst.PARA_SESSION_ID, this.f342105e);
        hashMap.put("url", VipAuthRequestUtil.f342037c);
        hashMap.put(QCircleWeakNetReporter.KEY_COST, Long.valueOf(j3));
        hashMap.put("code", Integer.valueOf(i3));
        hashMap.put("pid", this.f342103c.c().c().d());
        hashMap.put("chid", this.f342103c.c().c().a());
        return hashMap;
    }

    @Override // com.tencent.paysdk.vipauth.DefinitionAuthInternal, com.tencent.paysdk.network.c
    public void onFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        com.tencent.paysdk.log.c.a("LiveDefinitionAuthInternal", "Definition auth failed:\n" + this.f342101a.toString());
        super.onFailed(i3);
    }
}
