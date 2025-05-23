package com.tencent.mobileqq.qqlive.api.monitor;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/monitor/ISuperPlayerTrafficFlowReporter;", "", "init", "", "onPlayerFirstFrameCome", "onPlayerPause", "unInit", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public interface ISuperPlayerTrafficFlowReporter {
    void init();

    void onPlayerFirstFrameCome();

    void onPlayerPause();

    void unInit();
}
