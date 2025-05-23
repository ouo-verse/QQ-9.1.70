package com.tencent.qqperf.monitor.crash.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class o {

    /* renamed from: f, reason: collision with root package name */
    private static int f363240f;

    /* renamed from: g, reason: collision with root package name */
    private static LinkedList<o> f363241g = new LinkedList<>();

    /* renamed from: a, reason: collision with root package name */
    private SimpleDateFormat f363242a = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");

    /* renamed from: b, reason: collision with root package name */
    public long f363243b;

    /* renamed from: c, reason: collision with root package name */
    public String f363244c;

    /* renamed from: d, reason: collision with root package name */
    public String f363245d;

    /* renamed from: e, reason: collision with root package name */
    public int f363246e;

    public o(long j3, String str, String str2) {
        int length;
        this.f363246e = 0;
        this.f363243b = j3;
        this.f363244c = str;
        this.f363245d = str2;
        if (str == null) {
            length = 0;
        } else {
            length = str.getBytes().length;
        }
        this.f363246e = length + 19 + 1 + (str2 != null ? str2.getBytes().length : 0) + 1;
    }

    public static void a(String str, String str2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            o oVar = new o(System.currentTimeMillis(), str, str2);
            f363241g.add(oVar);
            f363240f += oVar.f363246e;
            while (f363240f > 15360 && f363241g.size() > 1) {
                f363240f -= f363241g.removeLast().f363246e;
            }
        }
    }

    public static String b() {
        StringBuilder sb5 = new StringBuilder(10);
        while (f363241g.size() > 0) {
            sb5.append(f363241g.removeLast().toString());
        }
        return sb5.toString();
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(this.f363242a.format(new Date(this.f363243b)));
        sb5.append(" ");
        sb5.append(this.f363244c);
        sb5.append(" ");
        sb5.append(this.f363245d);
        sb5.append("\n");
        return sb5.toString();
    }
}
