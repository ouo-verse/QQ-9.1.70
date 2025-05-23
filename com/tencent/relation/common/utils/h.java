package com.tencent.relation.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.friend.utils.MMKForUinUid;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final h f364770a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28694);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f364770a = new h();
            }
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String b(String str) {
        return str + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static h d() {
        return a.f364770a;
    }

    public static SharedPreferences e(Context context, String str) {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, str, "common_mmkv_configurations");
        String str2 = "migrate_flag_" + str;
        if (!fromSpAdapter.getBoolean(str2, false)) {
            QMMKV.migrateToSpAdapter(context, str, "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean(str2, true).apply();
        }
        return fromSpAdapter;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return MMKForUinUid.b(b("has_shelf_qq_friend"), false);
    }

    public String f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        String a16 = a("uid_prefix_key_" + str);
        String c16 = MMKForUinUid.c(a16, "");
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101781", false) && QLog.isColorLevel()) {
            QLog.i("RelationNTMMKV", 2, "uin: " + str + " key: " + a16 + " uid:" + c16);
        }
        return c16;
    }

    public String g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return MMKForUinUid.c(a("uid_prefix_key_" + str), "");
    }

    public void h(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        String a16 = a("uid_prefix_key_" + str);
        String a17 = a("uid_prefix_key_" + str2);
        arrayList.add(a16);
        arrayList.add(a17);
        MMKForUinUid.j(arrayList);
    }

    public void i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        String a16 = a("uid_prefix_key_" + str);
        if (MMKForUinUid.a(a16)) {
            return;
        }
        MMKForUinUid.d(a16, str2);
        MMKForUinUid.d(a("uid_prefix_key_" + str2), str);
    }

    public static String a(String str) {
        return str;
    }
}
