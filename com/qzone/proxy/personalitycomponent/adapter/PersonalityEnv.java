package com.qzone.proxy.personalitycomponent.adapter;

import android.content.Context;
import android.os.Handler;
import android.util.Pair;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.misc.network.report.a;
import com.qzone.util.ar;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import vo.c;
import yo.d;
import yo.f;

/* loaded from: classes39.dex */
public class PersonalityEnv {
    public static void JumpFlowerVinePage(Context context) {
        c.j(context);
    }

    public static void JumpToVistorFromUserHome(Context context, String str) {
        c.T(context, LoginData.getInstance().getUin(), str);
        a.n();
    }

    public static void clickUnionVip(Context context, long j3) {
        d.d(f.j(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_HOME_URL, QzoneConfig.DEFAULT_UNION_VIP_HOME_URL), "{aid}", "jhan_dhyhzgj"), "{qua}", QZoneHelper.getQUA()), context, null);
        if (j3 == LoginData.getInstance().getUin()) {
            ClickReport.m(QZoneClickReport.SUB_ACTION_TYPE_LIVE_OS_NOT_SUPPORT, "2", "2");
        } else {
            ClickReport.m(QZoneClickReport.SUB_ACTION_TYPE_LIVE_OS_NOT_SUPPORT, "2", "3");
        }
    }

    public static int dpToPx(float f16) {
        return Math.round(f16 * ar.i());
    }

    public static Handler getBackgroundThreadHandler() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getHandler();
    }

    public static Pair<Integer, Integer> getGpsLocation() {
        LbsDataV2.GeoInfo t16 = i5.a.s().t();
        if (t16 != null && t16.gpsInfo != null) {
            return new Pair<>(Integer.valueOf(t16.gpsInfo.lat), Integer.valueOf(t16.gpsInfo.lon));
        }
        QZLog.e("QzoneWeatherWidget", 1, "weather widget click gps = null");
        return null;
    }

    public static long getLoginUin() {
        return LoginData.getInstance().getUin();
    }

    public static Handler getNormalThreadHandler() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.YellowVipThread).getHandler();
    }

    public static Handler getRealTimeThreadHandler() {
        return QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getHandler();
    }

    public static String replaceWithQua(String str) {
        return f.j(f.j(str, "{qua}", QUA.getQUA3()), "{QUA}", QUA.getQUA3());
    }

    public static void report(String str, String str2, String str3, int... iArr) {
        ClickReport.i(LoginData.getInstance().getUin(), str, str2, str3, false, iArr);
    }

    public static void reportUnionVipShow(long j3) {
        if (j3 == LoginData.getInstance().getUin()) {
            ClickReport.m(QZoneClickReport.SUB_ACTION_TYPE_LIVE_OS_NOT_SUPPORT, "1", "2");
        } else {
            ClickReport.m(QZoneClickReport.SUB_ACTION_TYPE_LIVE_OS_NOT_SUPPORT, "1", "3");
        }
    }

    public static void reportqbossClick(String str) {
        ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(str, "" + LoginData.getInstance().getUin());
    }

    public static int handleScheme(String str, Context context, String str2) {
        return d.e(str, context, str2, null);
    }

    public static void report(String str, String str2, String str3) {
        ClickReport.j(LoginData.getInstance().getUin(), "", "", "", false, str, str2, str3);
    }

    public static void report(String str, String str2, String str3, String str4) {
        ClickReport.j(LoginData.getInstance().getUin(), "", "", "", false, str, str2, str3, str4);
    }

    public static void report(String str, String str2, String str3, boolean z16) {
        ClickReport.q(str, str2, str3, z16);
    }
}
