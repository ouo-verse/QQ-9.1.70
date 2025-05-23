package com.tencent.qqlive.common.api.impl;

import com.qzone.adapter.feedcomponent.qqlive.QZone2OriginalPkgNameUtil;
import com.qzone.module.feedcomponent.ui.qqlive.QZone1OriginalPkgNameUtil;
import com.qzone.module.feedcomponent.ui.qqlive.QZone1PostProguardPkgNameUtil;
import com.qzone.proxy.feedcomponent.qqlive.QZone3OriginalPkgNameUtil;
import com.tencent.biz.qqcircle.immersive.feed.live.QQCircleOriginalPkgNameUtil;
import com.tencent.biz.qqcircle.immersive.feed.live.x;
import com.tencent.mobileqq.qqlive.QQLiveOriginalPkgNameUtil;
import com.tencent.mobileqq.qqlive.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.OdOriginalPkgNameUtil;
import com.tencent.od.NowOriginalPkgNameUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.api.IQQLiveCrashReportApi;
import com.tencent.timi.game.TimiOriginalPkgNameUtil;
import et3.b;
import ye4.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QQLiveCrashReportApiImpl implements IQQLiveCrashReportApi {
    private static final int LEN_MAX_ALERT_MSG = 5120;
    private static final int LEN_PREFIX_MSG = 200;
    private static final String PROCESS_NAME_TROOPHOMEWORK = "com.tencent.mobileqq:troophomework";
    private static final String TAG = "QQLiveCrashReportApiImp";
    private static final String PKG_NAME_ORIGINAL_TIMI_GAME = TimiOriginalPkgNameUtil.getName();
    private static final String PKG_NAME_MIXED_TIMI_GAME = a.a();
    private static final String PKG_NAME_ORIGINAL_QQLIVE = QQLiveOriginalPkgNameUtil.getName();
    private static final String PKG_NAME_MIXED_QQLIVE = d.a();
    private static final String PKG_NAME_ORIGINAL_OD = OdOriginalPkgNameUtil.getName();
    private static final String PKG_NAME_MIXED_OD = tl3.a.a();
    private static final String PKG_NAME_ORIGINAL_NOW = NowOriginalPkgNameUtil.getName();
    private static final String PKG_NAME_MIXED_NOW = com.tencent.od.a.a();
    private static final String PKG_NAME_ORIGINAL_QQCIRCLE = QQCircleOriginalPkgNameUtil.getName();
    private static final String PKG_NAME_MIXED_QQCIRCLE = x.a();
    private static final String PKG_NAME_ORIGINAL_QZON1 = QZone1OriginalPkgNameUtil.getName();
    private static final String PKG_NAME_ORIGINAL_QZON2 = QZone2OriginalPkgNameUtil.getName();
    private static final String PKG_NAME_ORIGINAL_QZON3 = QZone3OriginalPkgNameUtil.getName();
    private static final String PKG_NAME_MIXED_QZON1 = QZone1PostProguardPkgNameUtil.getName();
    private static final String PKG_NAME_MIXED_QZON2 = f4.a.a();
    private static final String PKG_NAME_MIXED_QZON3 = w8.a.a();
    private static final int LEN_CRASH_MSG = 4920;

    @Override // com.tencent.qqlive.common.api.IQQLiveCrashReportApi
    public void reportCrash(b bVar) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        String str;
        if (PROCESS_NAME_TROOPHOMEWORK.equalsIgnoreCase(bVar.f397110e)) {
            return;
        }
        String str2 = bVar.f397108c;
        if (!str2.contains(PKG_NAME_ORIGINAL_TIMI_GAME) && !str2.contains(PKG_NAME_MIXED_TIMI_GAME)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!str2.contains(PKG_NAME_ORIGINAL_QQLIVE) && !str2.contains(PKG_NAME_MIXED_QQLIVE)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!str2.contains(PKG_NAME_ORIGINAL_OD) && !str2.contains(PKG_NAME_MIXED_OD)) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (!str2.contains(PKG_NAME_ORIGINAL_NOW) && !str2.contains(PKG_NAME_MIXED_NOW)) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (str2.contains(PKG_NAME_ORIGINAL_QQCIRCLE) && str2.contains(PKG_NAME_MIXED_QQCIRCLE)) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (!str2.contains(PKG_NAME_ORIGINAL_QZON1) && ((!str2.contains(PKG_NAME_MIXED_QZON1) || !str2.contains(PKG_NAME_ORIGINAL_QZON2)) && ((!str2.contains(PKG_NAME_MIXED_QZON2) || !str2.contains(PKG_NAME_ORIGINAL_QZON3)) && !str2.contains(PKG_NAME_MIXED_QZON3)))) {
            z27 = false;
        } else {
            z27 = true;
        }
        if (z16 || z17 || z18 || z19 || z26 || z27) {
            IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
            et3.a aVar = new et3.a(bVar.f397107b, bVar.f397110e, true);
            String str3 = "versionCode_" + bVar.f397111f + " crashType:" + bVar.f397106a + " crashAddress:" + bVar.f397107b + " crashStack:" + bVar.f397108c + " crashTime:" + bVar.f397109d;
            int length = str3.length();
            int i3 = LEN_CRASH_MSG;
            if (length > i3) {
                str3 = str3.substring(0, i3) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            if (z16) {
                iAegisLogApi.a(TAG, "timi_game_crash " + str3, aVar);
                str = "timi_game_crash";
                iAegisLogApi.reportEvent("timi_game_crash", bVar.f397110e, bVar.f397107b);
            } else if (z17) {
                iAegisLogApi.a(TAG, "qqlive_crash " + str3, aVar);
                str = "qqlive_crash";
            } else if (z26) {
                iAegisLogApi.a(TAG, "qqcircle_crash " + str3, aVar);
                str = "qqcircle_crash";
            } else if (z27) {
                iAegisLogApi.a(TAG, "qzone_crash " + str3, aVar);
                str = "qzone_crash";
            } else {
                iAegisLogApi.a(TAG, "now_od_crash " + str3, aVar);
                str = "now_od_crash";
            }
            iAegisLogApi.reportEvent(str, bVar.f397110e, bVar.f397107b);
        }
    }
}
