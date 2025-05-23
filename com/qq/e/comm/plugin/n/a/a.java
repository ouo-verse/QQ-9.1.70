package com.qq.e.comm.plugin.n.a;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.k.af;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.c;
import com.qq.e.comm.util.GDTLogger;
import cooperation.qzone.util.PerfTracer;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static int f39666b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static int f39667c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static int f39668d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static int f39669e = 10;

    /* renamed from: f, reason: collision with root package name */
    public static int f39670f = 11;

    /* renamed from: g, reason: collision with root package name */
    public static int f39671g = 12;

    /* renamed from: a, reason: collision with root package name */
    String f39672a;

    /* renamed from: h, reason: collision with root package name */
    int f39673h = 100;

    /* renamed from: i, reason: collision with root package name */
    int f39674i = 1;

    /* renamed from: j, reason: collision with root package name */
    long f39675j;

    public a(String str, long j3) {
        this.f39672a = str;
        this.f39675j = j3;
        a();
        GDTLogger.d(":report url = " + this.f39672a);
    }

    private void a() {
        if (TextUtils.isEmpty(this.f39672a)) {
            return;
        }
        String aPPVersion = GDTADManager.getInstance().getAppStatus().getAPPVersion();
        if (!TextUtils.isEmpty(aPPVersion)) {
            this.f39672a = this.f39672a.replaceAll("__VERSION__", aPPVersion);
        }
        String c16 = c();
        if (!TextUtils.isEmpty(c16)) {
            this.f39672a = this.f39672a.replaceAll("__CLICK_LPP__", c16);
        }
        this.f39672a = this.f39672a.replaceAll("__OS_TYPE__", "2");
    }

    private long b() {
        return System.currentTimeMillis() - this.f39675j;
    }

    private String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            long j3 = this.f39675j;
            if (j3 <= 0) {
                j3 = System.currentTimeMillis();
            }
            jSONObject.put(PerfTracer.PARAM_CLICK_TIME, j3);
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void a(String str, int i3) {
        if (TextUtils.isEmpty(this.f39672a)) {
            return;
        }
        GDTLogger.d(":cur load url = " + str);
        int i16 = this.f39674i;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 4) {
                        if (i3 == f39666b) {
                            this.f39674i = 5;
                            a(4, b());
                            this.f39675j = System.currentTimeMillis();
                        } else if (i3 == f39670f) {
                            this.f39674i = 5;
                            a(7, b());
                        }
                    }
                } else if (i3 == f39669e || i3 == f39670f) {
                    this.f39674i = 5;
                    a(7, b());
                }
            } else if (i3 == f39667c) {
                this.f39674i = 3;
                a(3, b());
            } else if (i3 == f39668d) {
                this.f39674i = 4;
                if (!a(str)) {
                    a(4, b());
                }
            } else if (i3 == f39669e) {
                this.f39674i = 5;
                a(5, b());
            } else if (i3 == f39670f) {
                this.f39674i = 5;
                a(6, b());
            }
        } else if (i3 == f39666b) {
            if (a(str) && this.f39673h == 100) {
                this.f39673h = 101;
            }
            if (this.f39675j <= 0) {
                this.f39675j = System.currentTimeMillis();
            }
            this.f39674i = 2;
            a(102, b());
        }
        if (this.f39673h == 101) {
            if (i3 == f39666b && this.f39674i == 2) {
                a(1, b());
                this.f39673h = 102;
            } else if (i3 == f39671g || i3 == f39668d) {
                this.f39673h = 102;
                a(2, b());
            }
        }
    }

    public void a(int i3, long j3) {
        String str = this.f39672a;
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("__PAGE_ACTION_ID__", String.valueOf(i3)).replaceAll("__PAGE_TIME__", String.valueOf(j3));
        }
        GDTLogger.d(":report now,action is  " + i3);
        GDTLogger.d(":report time  " + j3);
        GDTLogger.d(":report last url " + str);
        af.a(str);
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URL(str).getHost();
            if (!host.contains("c.gdt.qq.com") && !host.contains("c.l.qq.com")) {
                if (!host.contains("ttc.gdt.qq.com")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static void a(int i3, long j3, String str) {
        a(i3, j3, str, Integer.MIN_VALUE);
    }

    public static void a(int i3, long j3, String str, int i16) {
        if (i3 == Integer.MIN_VALUE) {
            return;
        }
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        c cVar = new c();
        bVar.a(str);
        cVar.a("cost_time", Long.valueOf(System.currentTimeMillis() - j3));
        if (i16 != Integer.MIN_VALUE) {
            cVar.a("error_code", Integer.valueOf(i16));
        }
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }
}
