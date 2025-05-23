package com.tencent.qimei.aa;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
@Deprecated
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static a f342885c;

    /* renamed from: d, reason: collision with root package name */
    public static byte[] f342886d;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f342887a;

    /* renamed from: b, reason: collision with root package name */
    public Lock f342888b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15636);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342886d = new byte[]{33, 94, 120, 74, PublicAccountH5AbilityPluginImpl.OPENIMG, 43, 35};
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f342888b = new ReentrantLock();
        Context e16 = com.tencent.qimei.ap.d.c().e();
        if (e16 != null) {
            this.f342887a = e16.getSharedPreferences("DENGTA_META", 0);
        }
    }
}
