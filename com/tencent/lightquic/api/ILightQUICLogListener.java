package com.tencent.lightquic.api;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/lightquic/api/ILightQUICLogListener;", "", "onLog", "", "level", "", "message", "", "onReport", AdMetricTag.Report.TYPE, "reportJson", "LightQUIC_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface ILightQUICLogListener {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public static final class DefaultImpls {
        public static void onLog(@NotNull ILightQUICLogListener iLightQUICLogListener, int i3, @NotNull String message) {
            Intrinsics.checkNotNullParameter(message, "message");
        }

        public static void onReport(@NotNull ILightQUICLogListener iLightQUICLogListener, int i3, @NotNull String reportJson) {
            Intrinsics.checkNotNullParameter(reportJson, "reportJson");
        }
    }

    void onLog(int level, @NotNull String message);

    void onReport(int reportType, @NotNull String reportJson);
}
