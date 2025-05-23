package com.qzone.album.util;

import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc04021;
import cooperation.qzone.report.lp.LpReportManager;

/* compiled from: P */
/* loaded from: classes39.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static long f44391a;

    /* renamed from: b, reason: collision with root package name */
    private static int f44392b;

    /* renamed from: c, reason: collision with root package name */
    private static int f44393c;

    /* renamed from: d, reason: collision with root package name */
    private static LpReportInfo_dc04021 f44394d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f44395e;

    public static void a() {
        boolean z16 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_PHOTO_LIST_VISIBLE_STATISTIC, 1) > 0;
        f44395e = z16;
        if (!z16) {
            f44394d = null;
            return;
        }
        if (f44394d == null) {
            f44394d = new LpReportInfo_dc04021();
        }
        f44391a = 0L;
        f44392b = 0;
        f44393c = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_PHOTO_LIST_VISIBLE_TIME_LIMIT, 500);
    }

    public static void b() {
        LpReportInfo_dc04021 lpReportInfo_dc04021;
        if (!f44395e || (lpReportInfo_dc04021 = f44394d) == null) {
            return;
        }
        lpReportInfo_dc04021.noCallback = (f44391a - lpReportInfo_dc04021.intimeCallback) - lpReportInfo_dc04021.delayCallback;
        LpReportManager.getInstance().reportToDC04021(f44394d, true, false);
        f44394d = null;
    }

    public static void c(int i3) {
        f44392b = i3;
    }
}
