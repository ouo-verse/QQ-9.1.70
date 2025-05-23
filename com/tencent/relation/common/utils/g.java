package com.tencent.relation.common.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final MMKVOptionEntity f364768a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final g f364769a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28682);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f364769a = new g();
            }
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f364768a = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        }
    }

    public static String a(String str) {
        return str + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static g b() {
        return a.f364769a;
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            QLog.i("PartyRoomQMMKV", 1, "setSelfOpenId is invalid, openid is empty!");
        } else {
            this.f364768a.encodeString(a("mmkv_self_openid"), str);
        }
    }
}
