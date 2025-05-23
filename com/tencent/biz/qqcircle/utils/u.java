package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qcircleshadow.lib.variation.HostEvilReportUtils;
import com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f92784a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f92785b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f92786c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(QCircleEvilReportInfo qCircleEvilReportInfo) {
        HostEvilReportUtils.doEvilReport(qCircleEvilReportInfo.system, qCircleEvilReportInfo.versiond, qCircleEvilReportInfo.uintyped, qCircleEvilReportInfo.appname, qCircleEvilReportInfo.appid, qCircleEvilReportInfo.subapp, qCircleEvilReportInfo.scene, qCircleEvilReportInfo.eviluind, qCircleEvilReportInfo.contentid, qCircleEvilReportInfo.buddyflag);
        QLog.d("QCircleInformUtils", 1, "report  success");
    }

    public static String b(String str) {
        try {
            return Long.toString((Long.parseLong(str) * 2) - 12345);
        } catch (Exception unused) {
            QLog.d("QCircleInformUtils", 1, "uin is error !");
            return null;
        }
    }
}
