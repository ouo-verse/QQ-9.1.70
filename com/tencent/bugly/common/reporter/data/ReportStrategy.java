package com.tencent.bugly.common.reporter.data;

import android.support.annotation.IntRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0003)*+B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010'\u001a\u00020(H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/bugly/common/reporter/data/ReportStrategy;", "", "()V", "alreadyRetryTimes", "", "getAlreadyRetryTimes", "()I", "setAlreadyRetryTimes", "(I)V", "connectTimeout", "getConnectTimeout", "setConnectTimeout", "needCache", "", "getNeedCache", "()Z", "setNeedCache", "(Z)V", "priority", "getPriority", "setPriority", "readTimeout", "getReadTimeout", "setReadTimeout", "retryStrategy", "Lcom/tencent/bugly/common/reporter/data/ReportStrategy$RetryStrategy;", "getRetryStrategy", "()Lcom/tencent/bugly/common/reporter/data/ReportStrategy$RetryStrategy;", "setRetryStrategy", "(Lcom/tencent/bugly/common/reporter/data/ReportStrategy$RetryStrategy;)V", "retryTimes", "getRetryTimes", "setRetryTimes", "uploadStrategy", "Lcom/tencent/bugly/common/reporter/data/ReportStrategy$UploadStrategy;", "getUploadStrategy", "()Lcom/tencent/bugly/common/reporter/data/ReportStrategy$UploadStrategy;", "setUploadStrategy", "(Lcom/tencent/bugly/common/reporter/data/ReportStrategy$UploadStrategy;)V", "toString", "", "Companion", "RetryStrategy", "UploadStrategy", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class ReportStrategy {
    public static final int DEFAULT_BACKOFF_RETRY_DURATION = 60000;
    public static final int DEFAULT_CONNECT_TIMEOUT = 30000;
    public static final int DEFAULT_READ_TIMEOUT = 30000;
    public static final int DEFAULT_RETRY_TIMES = 3;
    private int alreadyRetryTimes;
    private boolean needCache = true;

    @IntRange(from = 0, to = 4)
    private int priority = 2;
    private int connectTimeout = 30000;
    private int readTimeout = 30000;
    private int retryTimes = 3;

    @NotNull
    private RetryStrategy retryStrategy = RetryStrategy.RETRY_BACKOFF;

    @NotNull
    private UploadStrategy uploadStrategy = UploadStrategy.UPLOAD_WIFI;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/bugly/common/reporter/data/ReportStrategy$RetryStrategy;", "", "(Ljava/lang/String;I)V", "RETRY_IMMEDIATELY", "RETRY_BACKOFF", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public enum RetryStrategy {
        RETRY_IMMEDIATELY,
        RETRY_BACKOFF
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/bugly/common/reporter/data/ReportStrategy$UploadStrategy;", "", "(Ljava/lang/String;I)V", "UPLOAD_WIFI", "UPLOAD_ANY", "UPLOAD_NEXT_LAUNCH", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public enum UploadStrategy {
        UPLOAD_WIFI,
        UPLOAD_ANY,
        UPLOAD_NEXT_LAUNCH
    }

    public final int getAlreadyRetryTimes() {
        return this.alreadyRetryTimes;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final boolean getNeedCache() {
        return this.needCache;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    @NotNull
    public final RetryStrategy getRetryStrategy() {
        return this.retryStrategy;
    }

    public final int getRetryTimes() {
        return this.retryTimes;
    }

    @NotNull
    public final UploadStrategy getUploadStrategy() {
        return this.uploadStrategy;
    }

    public final void setAlreadyRetryTimes(int i3) {
        this.alreadyRetryTimes = i3;
    }

    public final void setConnectTimeout(int i3) {
        this.connectTimeout = i3;
    }

    public final void setNeedCache(boolean z16) {
        this.needCache = z16;
    }

    public final void setPriority(int i3) {
        this.priority = i3;
    }

    public final void setReadTimeout(int i3) {
        this.readTimeout = i3;
    }

    public final void setRetryStrategy(@NotNull RetryStrategy retryStrategy) {
        Intrinsics.checkParameterIsNotNull(retryStrategy, "<set-?>");
        this.retryStrategy = retryStrategy;
    }

    public final void setRetryTimes(int i3) {
        this.retryTimes = i3;
    }

    public final void setUploadStrategy(@NotNull UploadStrategy uploadStrategy) {
        Intrinsics.checkParameterIsNotNull(uploadStrategy, "<set-?>");
        this.uploadStrategy = uploadStrategy;
    }

    @NotNull
    public String toString() {
        return "ReportStrategy(needCache=" + this.needCache + ", priority=" + this.priority + ", connectTimeout=" + this.connectTimeout + ", readTimeout=" + this.readTimeout + ", retryTimes=" + this.retryTimes + ", retryStrategy=" + this.retryStrategy + ", uploadStrategy=" + this.uploadStrategy + ", alreadyRetryTimes=" + this.alreadyRetryTimes + ')';
    }
}
