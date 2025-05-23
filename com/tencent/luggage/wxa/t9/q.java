package com.tencent.luggage.wxa.t9;

import android.content.SharedPreferences;
import com.tencent.luggage.wxa.tn.g0;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f141130d = false;

    /* renamed from: a, reason: collision with root package name */
    public String f141131a = "";

    /* renamed from: b, reason: collision with root package name */
    public Map f141132b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f141133c = 0;

    public void a(int i3) {
        this.f141133c = i3;
        f141130d = true;
        SharedPreferences.Editor edit = g0.a(com.tencent.luggage.wxa.tn.z.c(), "system_config_prefs", 4).edit();
        edit.putInt("update_swip_back_status", i3);
        edit.commit();
        com.tencent.luggage.wxa.tn.w.g("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", Integer.valueOf(this.f141133c));
    }

    public void a(String str) {
        this.f141131a = str;
    }

    public void a(Map map) {
        this.f141132b = map;
    }

    public void a() {
        this.f141131a = "";
        this.f141132b = null;
    }
}
