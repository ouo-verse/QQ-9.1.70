package com.tencent.beacon.d;

import java.util.Calendar;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f77813a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f77814b = false;

    /* renamed from: c, reason: collision with root package name */
    private String f77815c = "oth.str.mdt.qq.com";

    /* renamed from: d, reason: collision with root package name */
    private int f77816d = 360;

    /* renamed from: e, reason: collision with root package name */
    private int f77817e = 100;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, String> f77818f = null;

    /* renamed from: g, reason: collision with root package name */
    private boolean f77819g = false;

    /* renamed from: h, reason: collision with root package name */
    private e f77820h = new e(1);

    a() {
    }

    public static a a() {
        if (f77813a == null) {
            synchronized (a.class) {
                if (f77813a == null) {
                    f77813a = new a();
                }
            }
        }
        return f77813a;
    }

    public int b() {
        return this.f77816d;
    }

    public synchronized int c() {
        String str;
        Map<String, String> map = this.f77818f;
        if (map != null && (str = map.get("maxStrategyQueryOneDay")) != null && !str.trim().equals("")) {
            int i3 = this.f77817e;
            try {
                i3 = Integer.parseInt(str);
            } catch (Exception e16) {
                com.tencent.beacon.base.util.c.a(e16);
            }
            return i3;
        }
        return this.f77817e;
    }

    public e d() {
        return this.f77820h;
    }

    public synchronized boolean e() {
        Map<String, String> map = this.f77818f;
        boolean z16 = false;
        if (map == null || !"y".equalsIgnoreCase(map.get("zeroPeak"))) {
            return false;
        }
        if (Calendar.getInstance().get(11) == 0) {
            z16 = true;
        }
        return z16;
    }

    public void a(int i3) {
        this.f77816d = i3;
    }

    public synchronized void a(Map<String, String> map) {
        this.f77818f = map;
    }

    public String a(String str) {
        Map<String, String> a16;
        e eVar = this.f77820h;
        if (eVar == null || (a16 = eVar.a()) == null) {
            return null;
        }
        return a16.get(str);
    }
}
