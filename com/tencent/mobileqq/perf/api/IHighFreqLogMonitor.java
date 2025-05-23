package com.tencent.mobileqq.perf.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/perf/api/IHighFreqLogMonitor;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "start", "", "printStackForMainThread", "", "printStackForAllThread", "printHighFreqLogStack", "stop", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IHighFreqLogMonitor extends QRouteApi {
    void start(boolean printStackForMainThread, boolean printStackForAllThread, boolean printHighFreqLogStack);

    void stop();
}
