package com.tencent.superplayer.report;

import java.util.Map;

/* loaded from: classes26.dex */
public interface ISPReportProvider {
    float getAvgDropFrameRate();

    Map<String, String> getReportInfo();
}
