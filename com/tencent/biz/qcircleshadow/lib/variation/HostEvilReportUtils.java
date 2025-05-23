package com.tencent.biz.qcircleshadow.lib.variation;

import android.os.Bundle;
import com.tencent.biz.subscribe.utils.a;
import com.tencent.qphone.base.util.QLog;
import h20.a;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostEvilReportUtils {
    public static void doEvilReport(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        a.b bVar = new a.b();
        bVar.f96249a = str;
        bVar.f96250b = str2;
        bVar.f96251c = str3;
        bVar.f96253e = str4;
        bVar.f96254f = str5;
        bVar.f96255g = str6;
        bVar.f96256h = str7;
        bVar.f96252d = str8;
        bVar.f96258j = str9;
        bVar.f96257i = str10;
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_more_button", true);
        bVar.f96268t = bundle;
        QLog.d("QCircleEvilReport", 1, "start report");
        a.c(MobileQQ.sMobileQQ, bVar);
        QLog.d("QCircleEvilReport", 1, "end report");
    }

    public static void doNewEvilReport(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        a.b bVar = new a.b();
        bVar.f404079a = str;
        bVar.f404080b = str2;
        bVar.f404081c = str3;
        bVar.f404084f = str4;
        bVar.f404085g = str5;
        bVar.f404086h = str6;
        bVar.f404087i = str7;
        bVar.f404082d = str8;
        bVar.f404083e = str9;
        bVar.f404088j = str10;
        bVar.f404091m = str11;
        bVar.f404089k = str12;
        bVar.f404099u = "4";
        bVar.f404093o = str13;
        h20.a.c(MobileQQ.sMobileQQ, bVar);
    }
}
