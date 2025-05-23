package com.tencent.open.business.viareport;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.g;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected static c f341115a;

    protected c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f341115a == null) {
                f341115a = new c();
            }
            cVar = f341115a;
        }
        return cVar;
    }

    public void b(int i3, String str, String str2, String str3, String str4, Long l3, int i16, int i17, String str5) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - l3.longValue();
        if (l3.longValue() == 0 || elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        StringBuffer stringBuffer = new StringBuffer("https://c.isdspeed.qq.com/code.cgi");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=");
        stringBuffer.append(i3);
        stringBuffer.append("&code=");
        stringBuffer.append(i16);
        stringBuffer.append("&time=");
        stringBuffer.append(elapsedRealtime);
        stringBuffer.append("&rate=");
        stringBuffer.append(i17);
        stringBuffer.append("&uin=");
        stringBuffer.append(str2);
        stringBuffer.append("&data=");
        ReportCenter.f().g(stringBuffer.toString(), "GET", g.h(String.valueOf(i3), String.valueOf(i16), String.valueOf(elapsedRealtime), String.valueOf(i17), str, str2, str3, str4, str5), true);
    }

    public void c(String str, String str2, String str3, String str4, String str5, Bundle bundle, String str6, boolean z16, boolean z17) {
        try {
            com.tencent.open.adapter.a.f().s(Integer.valueOf(str).intValue());
        } catch (Exception unused) {
        }
        String b16 = d.b();
        String valueOf = String.valueOf(com.tencent.open.adapter.a.f().l());
        if (!b16.equals(valueOf)) {
            ReportManager.i().l(b16, new b(), null, true, z17);
            d.j(valueOf);
        }
        b bVar = new b();
        bVar.f341105c = str4;
        bVar.f341103a = str2;
        bVar.f341108f = com.tencent.open.base.a.c(com.tencent.open.adapter.a.f().e());
        bVar.f341107e = str5;
        bVar.f341106d = str;
        bVar.f341104b = str3;
        bVar.f341109g = String.valueOf(System.currentTimeMillis());
        if (!TextUtils.isEmpty(str6)) {
            bVar.f341110h = str6;
        }
        if (QLog.isColorLevel()) {
            QLog.d("OpenSdkStatic", 2, "reprotInfo = " + bVar.toString());
        }
        ReportManager.i().l(valueOf, bVar, bundle, z16, z17);
    }

    public void d(String str, String str2, String str3, String str4, String str5, boolean z16, boolean z17) {
        c(str, str2, str3, str4, com.tencent.open.adapter.a.f().i(), null, str5, z16, z17);
    }

    public void e(String str, String str2, String str3, String str4, boolean z16) {
        c(str, str2, str3, str4, com.tencent.open.adapter.a.f().i(), null, "", z16, false);
    }
}
