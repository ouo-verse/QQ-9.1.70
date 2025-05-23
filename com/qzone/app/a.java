package com.qzone.app;

import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqlive.common.api.AegisLogger;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.report.lp.LpReportInfoConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f44475a = l.a(R.string.jnq);

    /* renamed from: b, reason: collision with root package name */
    public static boolean f44476b = true;

    public static String a(int i3) {
        if (!QZoneConfigHelper.R0()) {
            return "";
        }
        if (i3 == 2) {
            return "blog";
        }
        if (i3 == 4) {
            return "photo";
        }
        if (i3 == 202) {
            return "share";
        }
        if (i3 == 311) {
            return LpReportInfoConfig.RESERVE_DELETE_FEED_TYPE_SHUOSHUO;
        }
        if (i3 == 334) {
            return "message";
        }
        if (i3 == 406) {
            return "storyvideo";
        }
        if (i3 != 7035) {
            return "";
        }
        return MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_FAV;
    }

    public static String b(int i3) {
        if (i3 == 1) {
            return "Mainpage";
        }
        if (i3 == 2) {
            return "Blog";
        }
        if (i3 == 4) {
            return "Photo";
        }
        if (i3 == 202) {
            return AegisLogger.SHARE;
        }
        if (i3 == 311) {
            return "Shuo";
        }
        if (i3 == 7035) {
            return "Favor";
        }
        if (i3 == 333) {
            return AegisLogger.GIFT;
        }
        if (i3 != 334) {
            return "";
        }
        return "Msg";
    }
}
