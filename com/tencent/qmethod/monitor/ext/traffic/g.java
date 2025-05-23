package com.tencent.qmethod.monitor.ext.traffic;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/g;", "", "", "a", "I", "b", "()I", "matchType", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;", "()Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;", "matchRule", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "matchValue", "<init>", "(ILcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureRule;Ljava/lang/String;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int matchType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NetworkCaptureRule matchRule;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String matchValue;

    public g(int i3, @NotNull NetworkCaptureRule matchRule, @NotNull String matchValue) {
        Intrinsics.checkParameterIsNotNull(matchRule, "matchRule");
        Intrinsics.checkParameterIsNotNull(matchValue, "matchValue");
        this.matchType = i3;
        this.matchRule = matchRule;
        this.matchValue = matchValue;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final NetworkCaptureRule getMatchRule() {
        return this.matchRule;
    }

    /* renamed from: b, reason: from getter */
    public final int getMatchType() {
        return this.matchType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMatchValue() {
        return this.matchValue;
    }
}
