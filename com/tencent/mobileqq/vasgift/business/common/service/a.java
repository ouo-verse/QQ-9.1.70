package com.tencent.mobileqq.vasgift.business.common.service;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.qqgift.data.service.e;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vasgift.utils.m;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f311551a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vasgift.business.common.service.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C8934a extends TypeToken<List<e>> {
        C8934a() {
        }
    }

    a() {
    }

    public static synchronized a e() {
        a aVar;
        synchronized (a.class) {
            if (f311551a == null) {
                f311551a = new a();
            }
            aVar = f311551a;
        }
        return aVar;
    }

    private static SharedPreferences f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String account = peekAppRuntime.getAccount();
        if (account == null) {
            account = "noLogin";
        }
        return VasMMKV.getGiftPanel(peekAppRuntime.getApplicationContext(), account);
    }

    private boolean g(String str) {
        if (!m.a()) {
            return true;
        }
        if (System.currentTimeMillis() > d(str).longValue()) {
            return true;
        }
        return false;
    }

    private void i(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String str3 = "vas.gift.ab" + str;
            SharedPreferences f16 = f();
            try {
                f16.edit().putString(str3, str2);
                f16.edit().apply();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void l(String str, boolean z16) {
        String str2 = "vas.gift.package" + str;
        SharedPreferences f16 = f();
        try {
            f16.edit().putBoolean(str2, z16);
            f16.edit().apply();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void a(String str) {
        String str2 = "vas.gift.expire" + str;
        String str3 = "vas.gift.tab" + str;
        SharedPreferences f16 = f();
        try {
            f16.edit().remove(str2);
            f16.edit().remove(str3);
            f16.edit().apply();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public String b(String str) {
        try {
            return f().getString("vas.gift.ab" + str, "");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.List] */
    public synchronized List<e> c(String str) {
        ArrayList arrayList;
        String str2 = "vas.gift.tab" + str;
        SharedPreferences f16 = f();
        arrayList = new ArrayList();
        try {
            if (g(str)) {
                f16.edit().remove(str2);
                f16.edit().apply();
            } else {
                String string = f16.getString(str2, "");
                if (!TextUtils.isEmpty(string)) {
                    arrayList = (List) new Gson().fromJson(string, new C8934a().getType());
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return arrayList;
    }

    public Long d(String str) {
        long j3 = 0;
        try {
            j3 = f().getLong("vas.gift.expire" + str, 0L);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return Long.valueOf(j3);
    }

    public boolean h(String str) {
        try {
            return f().getBoolean("vas.gift.package" + str, false);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void j(String str, long j3) {
        String str2 = "vas.gift.expire" + str;
        SharedPreferences f16 = f();
        try {
            f16.edit().putLong(str2, j3);
            f16.edit().apply();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void k(String str, String str2, boolean z16) {
        i(str, str2);
        l(str, z16);
    }

    public synchronized void m(String str, long j3, List<e> list) {
        a(str);
        j(str, System.currentTimeMillis() + (j3 * 1000));
        if (list != null && !list.isEmpty()) {
            String str2 = "vas.gift.tab" + str;
            SharedPreferences f16 = f();
            try {
                f16.edit().putString(str2, new Gson().toJson(list));
                f16.edit().apply();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public synchronized void n(String str, List<d> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                String str2 = "vas.gift.tab" + str;
                SharedPreferences f16 = f();
                try {
                    List<e> c16 = c(str);
                    if (c16 != null && !c16.isEmpty()) {
                        for (d dVar : list) {
                            for (e eVar : c16) {
                                List<d> list2 = eVar.f264898e;
                                if (list2 != null && !list2.isEmpty()) {
                                    for (d dVar2 : eVar.f264898e) {
                                        if (dVar.f264874d == dVar2.f264874d) {
                                            dVar2.f264876e = dVar.f264876e;
                                            dVar2.f264878f = dVar.f264878f;
                                            dVar2.Q = dVar.Q;
                                            dVar2.R = dVar.R;
                                            dVar2.W = dVar.W;
                                            dVar2.Z = dVar.Z;
                                            dVar2.Y = dVar.Y;
                                            dVar2.X = dVar.X;
                                            dVar2.T = dVar.T;
                                            dVar2.C = dVar.C;
                                            dVar2.G = dVar.G;
                                            dVar2.f264881h = dVar.f264881h;
                                            dVar2.F = dVar.F;
                                            dVar2.f264883i = dVar.f264883i;
                                            dVar2.f264871a0 = dVar.f264871a0;
                                            dVar2.f264872b0 = dVar.f264872b0;
                                            if (dVar2.f264875d0) {
                                                dVar2.f264877e0 = dVar.f264877e0;
                                                dVar2.f264879f0 = dVar.f264879f0;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        f16.edit().putString(str2, new Gson().toJson(c16));
                        f16.edit().apply();
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
