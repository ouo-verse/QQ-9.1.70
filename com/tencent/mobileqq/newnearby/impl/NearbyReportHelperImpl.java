package com.tencent.mobileqq.newnearby.impl;

import android.os.Bundle;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.newnearby.INearbyCGIReporter;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.newnearby.servlet.ServletObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.protocol.nearbyControl$SyncKaiYangVerifyStateReq;
import com.tencent.mobileqq.protocol.nearbyReport$SsoReportNearbyReq;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyReportHelperImpl implements INearbyReportHelper {
    private static final String TAG = "NearbyReportHelperImpl";

    private static String getReportSelfUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getCurrentAccountUin();
        }
        return "";
    }

    public static void reportRequestLocation(boolean z16, boolean z17) {
        String currentAccountUin;
        Object obj;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("opername", "now#nearby#discover");
            jSONObject.put("module", "lbs");
            jSONObject.put("action", "get");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                currentAccountUin = "";
            } else {
                currentAccountUin = peekAppRuntime.getCurrentAccountUin();
            }
            jSONObject.put("fromuin", currentAccountUin);
            jSONObject.put("appid", String.valueOf(AppSetting.f()));
            jSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
            String str = "1";
            if (z16) {
                obj = "1";
            } else {
                obj = "0";
            }
            jSONObject.put("d5", obj);
            if (!z17) {
                str = "0";
            }
            jSONObject.put("d6", str);
            ((INearbyCGIReporter) QRoute.api(INearbyCGIReporter.class)).reportByJson(jSONObject);
        } catch (JSONException e16) {
            QLog.e(TAG, 2, "reportRequestLocation JSONException:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyReportHelper
    public void reportNearbyJubao(long j3, int i3) {
        nearbyReport$SsoReportNearbyReq nearbyreport_ssoreportnearbyreq = new nearbyReport$SsoReportNearbyReq();
        nearbyreport_ssoreportnearbyreq.tinyid.set(j3);
        nearbyreport_ssoreportnearbyreq.channelID.set(i3);
        com.tencent.mobileqq.newnearby.servlet.b.a(new a(), nearbyreport_ssoreportnearbyreq.toByteArray(), "trpc.nearby.nearby_report.nearby_report.SsoReportNearby");
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyReportHelper
    public void reportNearbyTicketShow(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("opername", "now#nearby#news_c2c");
            jSONObject.put("module", str);
            jSONObject.put("action", str2);
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            jSONObject.put("ts", valueOf);
            jSONObject.put("timestr", valueOf);
            jSONObject.put("fromuin", str3);
            jSONObject.put("touin", str4);
            jSONObject.put("appid", PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE);
            jSONObject.put("roomid", str5);
            ((INearbyCGIReporter) QRoute.api(INearbyCGIReporter.class)).reportByJson(jSONObject);
        } catch (JSONException e16) {
            QLog.e(TAG, 2, "reportNearbyTicketShow error:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyReportHelper
    public void reportNearbyVerifyDone() {
        com.tencent.mobileqq.newnearby.servlet.b.a(new b(), new MessageMicro<nearbyControl$SyncKaiYangVerifyStateReq>() { // from class: com.tencent.mobileqq.protocol.nearbyControl$SyncKaiYangVerifyStateReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], nearbyControl$SyncKaiYangVerifyStateReq.class);
        }.toByteArray(), "trpc.nearby.trpc_nearby_control.nearby_control.SsoSyncKaiYangVerifyState");
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyReportHelper
    public void reportTrendDetailCommentClick(AppInterface appInterface, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("opername", "now#nearby#trenddetail");
            jSONObject.put("module", "trenddetail_comment");
            jSONObject.put("action", "click");
            jSONObject.put("fromuin", appInterface.getCurrentAccountUin());
            jSONObject.put("touin", str);
            jSONObject.put("appid", String.valueOf(AppSetting.f()));
            jSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
            ((INearbyCGIReporter) QRoute.api(INearbyCGIReporter.class)).reportByJson(jSONObject);
        } catch (JSONException e16) {
            QLog.e(TAG, 2, "reportTrendDetailCommentClick JSONException:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyReportHelper
    public void reportTrendDetailExp(AppInterface appInterface, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("opername", "now#nearby#trenddetail");
            jSONObject.put("module", "overall_page");
            jSONObject.put("action", "view");
            jSONObject.put("fromuin", appInterface.getCurrentAccountUin());
            jSONObject.put("touin", str);
            jSONObject.put("appid", String.valueOf(AppSetting.f()));
            jSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
            ((INearbyCGIReporter) QRoute.api(INearbyCGIReporter.class)).reportByJson(jSONObject);
        } catch (JSONException e16) {
            QLog.e(TAG, 2, "reportTrendDetailExp JSONException:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyReportHelper
    public void reportTrendDetailLikeClick(AppInterface appInterface, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("opername", "now#nearby#trenddetail");
            jSONObject.put("module", "trenddetail_like");
            jSONObject.put("action", "click");
            jSONObject.put("fromuin", appInterface.getCurrentAccountUin());
            jSONObject.put("touin", str);
            jSONObject.put("appid", String.valueOf(AppSetting.f()));
            jSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
            ((INearbyCGIReporter) QRoute.api(INearbyCGIReporter.class)).reportByJson(jSONObject);
        } catch (JSONException e16) {
            QLog.e(TAG, 2, "reportTrendDetailLikeClick JSONException:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyReportHelper
    public void reportTrendDetailSafeReportClick(AppInterface appInterface, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("opername", "now#nearby#trenddetail");
            jSONObject.put("module", "trenddetail_safereport");
            jSONObject.put("action", "click");
            jSONObject.put("fromuin", appInterface.getCurrentAccountUin());
            jSONObject.put("touin", str);
            jSONObject.put("appid", String.valueOf(AppSetting.f()));
            jSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
            ((INearbyCGIReporter) QRoute.api(INearbyCGIReporter.class)).reportByJson(jSONObject);
        } catch (JSONException e16) {
            QLog.e(TAG, 2, "reportTrendDetailSafeReportClick JSONException:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyReportHelper
    public void reportTrendDetailShareClick(AppInterface appInterface, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("opername", "now#nearby#trenddetail");
            jSONObject.put("module", "trenddetail_share");
            jSONObject.put("action", "click");
            jSONObject.put("fromuin", appInterface.getCurrentAccountUin());
            jSONObject.put("touin", str);
            jSONObject.put("appid", String.valueOf(AppSetting.f()));
            jSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
            ((INearbyCGIReporter) QRoute.api(INearbyCGIReporter.class)).reportByJson(jSONObject);
        } catch (JSONException e16) {
            QLog.e(TAG, 2, "reportTrendDetailShareClick JSONException:" + e16.getMessage());
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends ServletObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0) {
                QLog.e(NearbyReportHelperImpl.TAG, 2, "reqNearbyReport SsoReportNearbyReq, errcode!=0");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b extends ServletObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0) {
                QLog.e(NearbyReportHelperImpl.TAG, 2, "reqNearbyReport SyncKaiYangVerifyStateReq, errcode!=0");
            }
        }
    }
}
