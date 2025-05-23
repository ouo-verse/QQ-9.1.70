package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes18.dex */
public class al {
    public static void a(int i3, int i16, String str, String str2) {
        ReportController.o(null, "dc00898", "", "", "0X800BA49", "0X800BA49", i3, 0, String.valueOf(i16), "", str, str2);
    }

    public static void b(com.tencent.mobileqq.search.model.z zVar) {
        a(zVar.C, zVar.x(), zVar.getKeyword(), String.valueOf(zVar.getTitleSpans()));
    }
}
