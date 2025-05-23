package com.tencent.thumbplayer.report.reportv2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.report.v2.ITPReportInfoGetter;
import com.tencent.thumbplayer.event.TPPlayerEventInfo;

/* loaded from: classes26.dex */
public interface ITPReporter {
    void init(@NonNull Context context, @NonNull TPReporterInitParams tPReporterInitParams);

    void onEvent(int i3, TPPlayerEventInfo.BaseEventInfo baseEventInfo);

    void reset();

    void setPlayerInfoGetter(@Nullable ITPPlayerInfoGetter iTPPlayerInfoGetter);

    void setReportInfoGetter(@Nullable ITPReportInfoGetter iTPReportInfoGetter);
}
