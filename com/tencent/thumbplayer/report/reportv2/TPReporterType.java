package com.tencent.thumbplayer.report.reportv2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes26.dex */
public class TPReporterType {
    public static final int TP_REPORTER_TYPE_LIVE = 1;
    public static final int TP_REPORTER_TYPE_PREPARE_FAIL = 2;
    public static final int TP_REPORTER_TYPE_VOD = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface ReporterType {
    }
}
