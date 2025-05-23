package com.tencent.mobileqq.qmethodmonitor.pandoraevent;

import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.api.k;
import com.tencent.qmethod.pandoraex.api.p;
import com.tencent.qphone.base.util.QLog;
import ee2.b;
import ee2.d;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements k {

    /* renamed from: a, reason: collision with root package name */
    private static a f261917a;

    a() {
    }

    public static a b() {
        if (f261917a == null) {
            synchronized (a.class) {
                if (f261917a == null) {
                    f261917a = new a();
                }
            }
        }
        return f261917a;
    }

    @Override // com.tencent.qmethod.pandoraex.api.k
    public void a(p pVar) {
        String str = ee2.a.f396187e.get(pVar.f343921a);
        String str2 = ee2.a.f396186d.get(pVar.f343921a);
        QLog.d("PandoraEventCallBack", 1, "PandoraEventRecord{systemApi: " + pVar.f343921a + ", infoDesc: " + pVar.f343922b + ", infoName: " + str + ", infoType: " + str2 + ", eventScene: " + d.e() + "}");
        if (str2 != null && str != null) {
            if (str2.equals("C2-1") && TextUtils.isEmpty(pVar.f343922b) && !str.equals("C2-1-11")) {
                return;
            }
            PandoraEventReportHelper.c(new b.a().i(str2).f(str).g(ee2.a.f396183a.get(str)).h(d.c(str)).e(pVar.f343922b).d(he2.a.d()).a(1).c("").b(), true);
        }
    }
}
