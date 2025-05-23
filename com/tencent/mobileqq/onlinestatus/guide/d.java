package com.tencent.mobileqq.onlinestatus.guide;

import android.text.TextUtils;
import com.tencent.mobileqq.config.business.ai;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends e {

    /* renamed from: a, reason: collision with root package name */
    public c f255906a = new c();

    public Long e(AppRuntime appRuntime) {
        b bVar;
        String str;
        b bVar2;
        String str2;
        String str3;
        String str4;
        b bVar3;
        long j3;
        ai a16 = a();
        if (a16 != null && (bVar = a16.D) != null && bVar.f255901a > 0 && !TextUtils.isEmpty(bVar.f255903c)) {
            b bVar4 = a16.D;
            if (bVar4.f255902b > 0) {
                long j16 = bVar4.f255901a;
                if (d() && !a16.D.f255905e) {
                    QLog.i("StatusPanelHelper", 1, "getShowGuideStatusId not showInStudyMode guideStatusId=" + j16);
                    return null;
                }
                if (this.f255906a.c(appRuntime, j16)) {
                    QLog.i("StatusPanelHelper", 1, "getShowGuideStatusId has click guideStatusId=" + j16);
                    return null;
                }
                if (b(appRuntime) == j16) {
                    QLog.i("StatusPanelHelper", 1, "getShowGuideStatusId selfStatus == guideStatusId=" + j16);
                    this.f255906a.h(appRuntime, j16);
                    this.f255906a.f(appRuntime, j16);
                    return null;
                }
                long c16 = c();
                long d16 = this.f255906a.d(appRuntime, j16);
                if (c16 < d16) {
                    str = ",duration=";
                    bVar2 = bVar4;
                    str2 = "StatusPanelHelper";
                } else {
                    if (d16 > 0) {
                        str3 = ",duration=";
                        if (c16 - d16 > bVar4.f255902b) {
                            bVar2 = bVar4;
                            str2 = "StatusPanelHelper";
                            str = str3;
                        }
                    } else {
                        str3 = ",duration=";
                    }
                    if (d16 <= 0) {
                        str4 = str3;
                        bVar3 = bVar4;
                        j3 = d16;
                        this.f255906a.g(appRuntime, j16, c16);
                    } else {
                        str4 = str3;
                        bVar3 = bVar4;
                        j3 = d16;
                    }
                    QLog.i("StatusPanelHelper", 1, "checkAndSetGuide show guideStatusId=" + j16 + ",firstShowTime=" + j3 + ",serverTime=" + c16 + str4 + bVar3.f255902b);
                    return Long.valueOf(j16);
                }
                QLog.i(str2, 1, "checkAndSetGuide time error guideStatusId=" + j16 + ",firstShowTime=" + d16 + ",serverTime=" + c16 + str + bVar2.f255902b);
                return null;
            }
        }
        QLog.i("StatusPanelHelper", 1, "getShowGuideStatusId configBean error");
        return null;
    }
}
