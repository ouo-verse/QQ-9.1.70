package com.qzone.business.lbsv2.business;

import com.qzone.business.lbsv2.business.protocol.QzoneReportLBSRequest;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public static void a(String str, long j3, String str2, int i3, int i16, String str3, int i17, int i18, String str4, String str5, String str6, String str7) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneReportLBSRequest(str, j3, str2, i3, i16, str3, i17, i18, str4, str5, str6, str7), null, null, 0));
    }
}
