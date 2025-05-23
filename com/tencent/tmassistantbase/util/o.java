package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    protected static String f380492b = "NA";

    /* renamed from: a, reason: collision with root package name */
    protected Context f380493a;

    public o(Context context) {
        this.f380493a = context;
    }

    private String b() {
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            stringBuffer.append("NA");
        } else {
            stringBuffer.append(str);
        }
        stringBuffer.append("_");
        stringBuffer.append(Build.VERSION.SDK_INT);
        return stringBuffer.toString();
    }

    public static String c() {
        return "1002";
    }

    private int d() {
        if (h()) {
            return 0;
        }
        return this.f380493a.getResources().getDisplayMetrics().heightPixels;
    }

    private int e() {
        if (h()) {
            return 0;
        }
        return this.f380493a.getResources().getDisplayMetrics().widthPixels;
    }

    private int f() {
        return 0;
    }

    private String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(Build.BRAND));
        stringBuffer.append("_");
        stringBuffer.append(a(DeviceInfoMonitor.getModel()));
        return stringBuffer.toString();
    }

    private boolean h() {
        Context context = this.f380493a;
        if (context == null || context.getResources() == null || this.f380493a.getResources().getDisplayMetrics() == null) {
            return true;
        }
        return false;
    }

    public String a() {
        n nVar = new n();
        nVar.f380485c = c();
        nVar.f380486d = "";
        nVar.f380487e = f380492b;
        nVar.f380488f = b();
        nVar.f380490h = d();
        nVar.f380489g = e();
        nVar.f380491i = f();
        nVar.f380483a = g();
        nVar.f380484b = "1002";
        return nVar.a();
    }

    public static StringBuffer a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.isEmpty(str)) {
            stringBuffer.append("NA");
            return stringBuffer;
        }
        for (char c16 : str.toCharArray()) {
            if (c16 > ' ' && c16 != '/' && c16 != '_' && c16 != '&' && c16 != '|' && c16 != '-') {
                stringBuffer.append(c16);
            }
        }
        return stringBuffer;
    }
}
