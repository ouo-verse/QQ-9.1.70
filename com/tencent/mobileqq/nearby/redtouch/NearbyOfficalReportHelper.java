package com.tencent.mobileqq.nearby.redtouch;

import android.util.Log;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.im.oidb.cmd0x791.oidb_0x791$RedDotInfo;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyOfficalReportHelper {

    /* renamed from: a, reason: collision with root package name */
    public static NearbyOfficalReportHelper f253045a = new NearbyOfficalReportHelper();

    NearbyOfficalReportHelper() {
    }

    public static NearbyOfficalReportHelper a() {
        return f253045a;
    }

    public void b(final QQAppInterface qQAppInterface, final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                String str3;
                String str4;
                String str5;
                d k3 = ((TroopRedTouchManager) qQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).k();
                if (k3.f253078b > 0) {
                    String valueOf = String.valueOf(((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(qQAppInterface.getCurrentAccountUin(), INearbySPUtil.SP_KEY_SELF_GENDER, (Object) (-1)));
                    if (k3.f253080d > 0) {
                        str3 = "1";
                    } else {
                        str3 = "0";
                    }
                    if (k3.f253079c > 0) {
                        str4 = "1";
                    } else {
                        str4 = "0";
                    }
                    if (k3.f253077a > 1) {
                        str5 = "1";
                    } else {
                        str5 = "0";
                    }
                    ReportController.o(null, "dc00899", "grp_lbs", "", str, str2, 0, 0, valueOf, str3, str4, "");
                    Log.i(" NearbyRecommend", "reportLebaRedDotEvent op_name = " + str2 + " d1 = " + valueOf + " d2 = " + str3 + " d3 = " + str4 + " d4 = " + str5);
                }
            }
        }, 16, null, false);
    }

    public void c(QQAppInterface qQAppInterface, oidb_0x791$RedDotInfo oidb_0x791_reddotinfo) {
        b bVar = new b();
        bVar.b(oidb_0x791_reddotinfo);
        if (bVar.f253059c) {
            String valueOf = String.valueOf(((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(qQAppInterface.getCurrentAccountUin(), INearbySPUtil.SP_KEY_SELF_GENDER, (Object) (-1)));
            String valueOf2 = String.valueOf(bVar.f253061e);
            String valueOf3 = String.valueOf(bVar.f253060d);
            ReportController.o(null, "dc00899", "grp_lbs", "", "entry", "official_push_received", 0, 0, valueOf, valueOf2, valueOf3, "");
            Log.i(" NearbyRecommend", "reportLebaRedDotReceive op_name = official_push_receivedd1 = " + valueOf + " d2 = " + valueOf2 + " d3 = " + valueOf3);
        }
    }
}
