package com.tencent.qmethod.monitor.network;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qmethod/monitor/network/c;", "", "", "responseJson", "", "onSuccess", "", "errorCode", "errorMsg", "onFailure", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public interface c {
    void onFailure(int errorCode, @NotNull String errorMsg);

    void onSuccess(@NotNull String responseJson);
}
