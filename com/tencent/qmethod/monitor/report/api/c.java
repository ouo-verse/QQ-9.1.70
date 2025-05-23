package com.tencent.qmethod.monitor.report.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qmethod/monitor/report/api/c;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "sdkStartTime", "apiInvoke", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f343818c = new c();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String sdkStartTime = com.tencent.qmethod.pandoraex.core.collector.utils.a.a() + "_sdk_start_time";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String apiInvoke = com.tencent.qmethod.pandoraex.core.collector.utils.a.a() + "_api_invoke_analyse";

    c() {
    }

    @NotNull
    public final String a() {
        return apiInvoke;
    }

    @NotNull
    public final String b() {
        return sdkStartTime;
    }
}
