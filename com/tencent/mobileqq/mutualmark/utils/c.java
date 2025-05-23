package com.tencent.mobileqq.mutualmark.utils;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static final int f252290b = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getBeginnerTipsSetting().f252172a;

    /* renamed from: a, reason: collision with root package name */
    private final MMKVOptionEntity f252291a = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final c f252292a = new c();
    }

    c() {
    }

    public static String b(String str) {
        return "QQMutualMark_" + str + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static c d() {
        return a.f252292a;
    }

    public void a() {
        String b16 = b("intimate_elegant_page_x_key");
        this.f252291a.encodeInt(b16, this.f252291a.decodeInt(b16, 0) + 1);
    }

    public boolean c() {
        return this.f252291a.decodeBool(b("disable_interactive_switch"), true);
    }

    public int e(String str) {
        return this.f252291a.decodeInt(b(str), 0);
    }

    public int f() {
        return this.f252291a.decodeInt(b("intimate_elegant_page_x_key"), 0);
    }

    public boolean g() {
        return this.f252291a.decodeInt(b("intimate_elegant_page_x_key"), 0) <= f252290b;
    }

    public void h(String str, int i3) {
        this.f252291a.encodeInt(b(str), i3);
    }

    public void i(boolean z16) {
        this.f252291a.encodeBool(b("disable_interactive_switch"), z16);
    }
}
