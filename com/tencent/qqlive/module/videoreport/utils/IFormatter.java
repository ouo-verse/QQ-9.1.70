package com.tencent.qqlive.module.videoreport.utils;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IFormatter {
    Map<String, Object> formatElementParams(@NonNull List<ReportData> list, ReportData reportData);

    Map<String, Object> formatEvent(String str, Map<String, Object> map, Map<String, Object> map2);
}
