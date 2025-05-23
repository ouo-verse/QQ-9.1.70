package com.tencent.comic;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int f99265a = new Random().nextInt(1000) + 1;

    public static void a(AppRuntime appRuntime, int i3, int i16, int i17, int i18, String str, String... strArr) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3 + "|");
        sb5.append(i16 + "|");
        sb5.append(i17 + "|");
        sb5.append(i18 + "|");
        sb5.append(str);
        String[] strArr2 = new String[6];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(6, strArr.length));
        for (int i19 = 0; i19 < 6; i19++) {
            if (strArr2[i19] == null) {
                sb5.append("|");
            } else {
                sb5.append("|" + strArr2[i19]);
            }
        }
        BaseQQAppInterface baseQQAppInterface = appRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) appRuntime : null;
        if (QLog.isColorLevel()) {
            QLog.d("PluginPreloadReportUtils", 2, "hitrate: " + sb5.toString());
        }
        DcReportUtil.c(baseQQAppInterface, "sendtdbank|b_sng_qqvip_qqcomic|preloadhitrate", sb5.toString(), true);
    }

    public static void b(AppRuntime appRuntime, int i3, int i16, int i17, long j3, String... strArr) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3 + "|");
        sb5.append(i16 + "|");
        sb5.append(i17 + "|");
        sb5.append(j3);
        String[] strArr2 = new String[6];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(6, strArr.length));
        for (int i18 = 0; i18 < 6; i18++) {
            if (strArr2[i18] == null) {
                sb5.append("|");
            } else {
                sb5.append("|" + strArr2[i18]);
            }
        }
        BaseQQAppInterface baseQQAppInterface = appRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) appRuntime : null;
        if (QLog.isColorLevel()) {
            QLog.d("PluginPreloadReportUtils", 2, "procbekilled: " + sb5.toString());
        }
        DcReportUtil.c(baseQQAppInterface, "sendtdbank|b_sng_qqvip_qqcomic|procbekilled", sb5.toString(), true);
    }
}
