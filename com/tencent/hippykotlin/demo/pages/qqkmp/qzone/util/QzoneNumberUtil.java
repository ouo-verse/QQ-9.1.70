package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util;

import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/util/QzoneNumberUtil;", "", "()V", "formatNumber", "", "number", "", "count", "", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneNumberUtil {
    public static final int $stable = 0;
    public static final QzoneNumberUtil INSTANCE = new QzoneNumberUtil();

    QzoneNumberUtil() {
    }

    public final String formatNumber(long count) {
        if (count < 0) {
            return "0";
        }
        if (count <= AppConstants.LBS_HELLO_UIN_LONGVALUE) {
            return String.valueOf(count);
        }
        if (count <= MiniAppReportManager.MAX_TIME_VALUE) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(((int) (count / 1000.0d)) / 10.0d);
            sb5.append('\u4e07');
            return sb5.toString();
        }
        if (count <= 99999999) {
            return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(new StringBuilder(), (int) (count / 10000), '\u4e07');
        }
        if (count <= 99999999999L) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(((int) (count / 1.0E7d)) / 10.0d);
            sb6.append('\u4ebf');
            return sb6.toString();
        }
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(new StringBuilder(), (int) (count / 100000000), '\u4ebf');
    }

    public final String formatNumber(int number) {
        return formatNumber(number);
    }
}
