package com.tencent.thumbplayer.api.report.v2;

import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: classes26.dex */
public interface ITPReportInfoGetter {
    @Nullable
    Map<String, String> getInitExtendedReportInfo();

    @Nullable
    Map<String, String> getPeriodExtendedReportInfo();
}
