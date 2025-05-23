package com.tencent.mobileqq.debug.hodor.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J$\u0010\t\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/debug/hodor/api/IQQHodorPrefApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "collectNetFlowData", "", "url", "", "size", "", "source", "collectPerfInfo", "prefInfo", "", "", "flag", "collectTrackInfo", "trackInfo", "isHodorMode", "", "reportToHodor", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IQQHodorPrefApi extends QRouteApi {
    void collectNetFlowData(@NotNull String url, long size, @NotNull String source);

    void collectPerfInfo(@NotNull Map<String, ? extends Object> prefInfo, @NotNull String flag);

    void collectTrackInfo(@NotNull String trackInfo);

    boolean isHodorMode();

    void reportToHodor();
}
