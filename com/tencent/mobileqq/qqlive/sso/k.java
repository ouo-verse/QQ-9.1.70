package com.tencent.mobileqq.qqlive.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static volatile k f273216c;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f273217a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f273218b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61359);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f273216c = new k();
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273217a = false;
            this.f273218b = new ConcurrentHashMap<>();
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Set<Map.Entry<String, Integer>> entrySet = this.f273218b.entrySet();
        QLog.d("SSORequestRecordHelper", 4, "start---------------------------------------");
        for (Map.Entry<String, Integer> entry : entrySet) {
            QLog.d("SSORequestRecordHelper", 4, entry.getKey() + " " + entry.getValue());
        }
        QLog.d("SSORequestRecordHelper", 4, "end---------------------------------------");
    }
}
