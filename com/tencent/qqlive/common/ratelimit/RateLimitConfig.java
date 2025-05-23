package com.tencent.qqlive.common.ratelimit;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020\u001dH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqlive/common/ratelimit/RateLimitConfig;", "Ljava/io/Serializable;", "()V", "alertInterval", "", "getAlertInterval", "()J", "setAlertInterval", "(J)V", "enableFrequencyFix", "", "getEnableFrequencyFix", "()I", "setEnableFrequencyFix", "(I)V", "frequency", "getFrequency", "setFrequency", "maxCheckInterval", "getMaxCheckInterval", "setMaxCheckInterval", "minReqInterval", "getMinReqInterval", "setMinReqInterval", "period", "getPeriod", "setPeriod", "whiteList", "", "", "getWhiteList", "()Ljava/util/List;", "setWhiteList", "(Ljava/util/List;)V", "toString", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class RateLimitConfig implements Serializable {
    private int enableFrequencyFix;

    @Nullable
    private List<String> whiteList;
    private int frequency = 10;
    private long period = 5000;
    private long minReqInterval = 1500;
    private long alertInterval = MiniBoxNoticeInfo.MIN_5;
    private int maxCheckInterval = 500;

    public final long getAlertInterval() {
        return this.alertInterval;
    }

    public final int getEnableFrequencyFix() {
        return this.enableFrequencyFix;
    }

    public final int getFrequency() {
        return this.frequency;
    }

    public final int getMaxCheckInterval() {
        return this.maxCheckInterval;
    }

    public final long getMinReqInterval() {
        return this.minReqInterval;
    }

    public final long getPeriod() {
        return this.period;
    }

    @Nullable
    public final List<String> getWhiteList() {
        return this.whiteList;
    }

    public final void setAlertInterval(long j3) {
        this.alertInterval = j3;
    }

    public final void setEnableFrequencyFix(int i3) {
        this.enableFrequencyFix = i3;
    }

    public final void setFrequency(int i3) {
        this.frequency = i3;
    }

    public final void setMaxCheckInterval(int i3) {
        this.maxCheckInterval = i3;
    }

    public final void setMinReqInterval(long j3) {
        this.minReqInterval = j3;
    }

    public final void setPeriod(long j3) {
        this.period = j3;
    }

    public final void setWhiteList(@Nullable List<String> list) {
        this.whiteList = list;
    }

    @NotNull
    public String toString() {
        String[] strArr;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("RateLimitConfig{ frequency=");
        sb5.append(this.frequency);
        sb5.append(", period=");
        sb5.append(this.period);
        sb5.append(", minReqInterval=");
        sb5.append(this.minReqInterval);
        sb5.append(", alertInterval=");
        sb5.append(this.alertInterval);
        sb5.append(", enableFrequencyFix=");
        sb5.append(this.enableFrequencyFix);
        sb5.append(", maxCheckInterval=");
        sb5.append(this.maxCheckInterval);
        sb5.append(", whiteList=");
        List<String> list = this.whiteList;
        if (list != null) {
            Object[] array = list.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            strArr = (String[]) array;
        } else {
            strArr = null;
        }
        sb5.append(Arrays.toString(strArr));
        sb5.append('}');
        return sb5.toString();
    }
}
