package com.tencent.relation.common.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final MMKVOptionEntity f364771a;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final i f364772a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28697);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f364772a = new i();
            }
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f364771a = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        }
    }

    public static String a(String str) {
        return str + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static i c() {
        return a.f364772a;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f364771a.decodeBool(a("mmkv_relation_has_shield_transfer"), false);
    }

    public long d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).longValue();
        }
        return this.f364771a.decodeLong(a("mmkv_relation_one_way_friend_gray_tip_" + str), 0L);
    }

    public boolean e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        return this.f364771a.decodeBool(a("mmkv_relation_blacklist_" + str), false);
    }

    public boolean f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        return this.f364771a.decodeBool(a("mmkv_relation_black_or_blacked_" + str), false);
    }

    public boolean g(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3)).booleanValue();
        }
        if ((System.currentTimeMillis() - this.f364771a.decodeLong(a("mmkv_relation_profilecard_instep_bubble_key_" + str), 0L)) / 1000 < i3) {
            return true;
        }
        return false;
    }

    public boolean h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        String decodeString = this.f364771a.decodeString(a("mmkv_relation_region_config_key"), "");
        if (!TextUtils.isEmpty(decodeString) && decodeString.equals(str)) {
            return false;
        }
        return true;
    }

    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f364771a.encodeBool(a("mmkv_relation_has_shield_transfer"), z16);
        }
    }

    public void j(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Long.valueOf(j3));
            return;
        }
        this.f364771a.encodeLong(a("mmkv_relation_one_way_friend_gray_tip_" + str), j3);
    }

    public void k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f364771a.encodeLong(a("mmkv_relation_profilecard_instep_bubble_key_" + str), System.currentTimeMillis());
    }

    public void l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f364771a.encodeString(a("mmkv_relation_region_config_key"), str);
        }
    }

    public void m(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
            return;
        }
        this.f364771a.encodeBool(a("mmkv_relation_blacklist_" + str), z16);
    }

    public void n(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16));
            return;
        }
        this.f364771a.encodeBool(a("mmkv_relation_black_or_blacked_" + str), z16);
    }
}
