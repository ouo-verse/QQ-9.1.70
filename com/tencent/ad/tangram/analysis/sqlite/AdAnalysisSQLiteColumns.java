package com.tencent.ad.tangram.analysis.sqlite;

import android.provider.BaseColumns;

/* compiled from: P */
/* loaded from: classes3.dex */
final class AdAnalysisSQLiteColumns implements BaseColumns {
    public static final String COLUMN_NAME_EVENT = "event";
    public static final String COLUMN_NAME_STRATEGY = "strategy";
    public static final String COLUMN_NAME_TIME_MILLIS = "time_millis";
    public static final String COLUMN_NAME_UUID = "uuid";
    public static final String[] OLD_TABLE_NAMES = {"gdt_analysis_table", "gdt_analysis_table_v3"};
    public static final String TABLE_NAME = "gdt_analysis_table_v4";

    AdAnalysisSQLiteColumns() {
    }
}
