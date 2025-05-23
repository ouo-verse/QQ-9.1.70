package com.tencent.icgame.common.ratelimit;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u001a\u0010\u001c\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u001a\u0010\u001f\u001a\u00020\u001e8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/icgame/common/ratelimit/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "enable", "Z", "b", "()Z", "frequency", "I", "d", "()I", "", "period", "J", "g", "()J", "minReqInterval", "f", "alertInterval", "a", "enableFrequencyFix", "c", "maxCheckInterval", "e", "Lcom/google/gson/JsonArray;", "whiteList", "Lcom/google/gson/JsonArray;", h.F, "()Lcom/google/gson/JsonArray;", "<init>", "(ZIJJJIILcom/google/gson/JsonArray;)V", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.icgame.common.ratelimit.c, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class RateLimitConfig {

    @SerializedName("alert_interval")
    private final long alertInterval;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_frequency_fix")
    private final int enableFrequencyFix;

    @SerializedName("frequency")
    private final int frequency;

    @SerializedName("max_check_interval")
    private final int maxCheckInterval;

    @SerializedName("min_req_interval")
    private final long minReqInterval;

    @SerializedName("period")
    private final long period;

    @SerializedName(MobileQQ.PREF_WHITE_LIST_KEY)
    @NotNull
    private final JsonArray whiteList;

    public RateLimitConfig() {
        this(false, 0, 0L, 0L, 0L, 0, 0, null, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getAlertInterval() {
        return this.alertInterval;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: c, reason: from getter */
    public final int getEnableFrequencyFix() {
        return this.enableFrequencyFix;
    }

    /* renamed from: d, reason: from getter */
    public final int getFrequency() {
        return this.frequency;
    }

    /* renamed from: e, reason: from getter */
    public final int getMaxCheckInterval() {
        return this.maxCheckInterval;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RateLimitConfig)) {
            return false;
        }
        RateLimitConfig rateLimitConfig = (RateLimitConfig) other;
        if (this.enable == rateLimitConfig.enable && this.frequency == rateLimitConfig.frequency && this.period == rateLimitConfig.period && this.minReqInterval == rateLimitConfig.minReqInterval && this.alertInterval == rateLimitConfig.alertInterval && this.enableFrequencyFix == rateLimitConfig.enableFrequencyFix && this.maxCheckInterval == rateLimitConfig.maxCheckInterval && Intrinsics.areEqual(this.whiteList, rateLimitConfig.whiteList)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getMinReqInterval() {
        return this.minReqInterval;
    }

    /* renamed from: g, reason: from getter */
    public final long getPeriod() {
        return this.period;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final JsonArray getWhiteList() {
        return this.whiteList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        boolean z16 = this.enable;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((((((((r06 * 31) + this.frequency) * 31) + androidx.fragment.app.a.a(this.period)) * 31) + androidx.fragment.app.a.a(this.minReqInterval)) * 31) + androidx.fragment.app.a.a(this.alertInterval)) * 31) + this.enableFrequencyFix) * 31) + this.maxCheckInterval) * 31) + this.whiteList.hashCode();
    }

    @NotNull
    public String toString() {
        return "RateLimitConfig(enable=" + this.enable + ", frequency=" + this.frequency + ", period=" + this.period + ", minReqInterval=" + this.minReqInterval + ", alertInterval=" + this.alertInterval + ", enableFrequencyFix=" + this.enableFrequencyFix + ", maxCheckInterval=" + this.maxCheckInterval + ", whiteList=" + this.whiteList + ")";
    }

    public RateLimitConfig(boolean z16, int i3, long j3, long j16, long j17, int i16, int i17, @NotNull JsonArray whiteList) {
        Intrinsics.checkNotNullParameter(whiteList, "whiteList");
        this.enable = z16;
        this.frequency = i3;
        this.period = j3;
        this.minReqInterval = j16;
        this.alertInterval = j17;
        this.enableFrequencyFix = i16;
        this.maxCheckInterval = i17;
        this.whiteList = whiteList;
    }

    public /* synthetic */ RateLimitConfig(boolean z16, int i3, long j3, long j16, long j17, int i16, int i17, JsonArray jsonArray, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? true : z16, (i18 & 2) != 0 ? 20 : i3, (i18 & 4) != 0 ? 5000L : j3, (i18 & 8) != 0 ? 500L : j16, (i18 & 16) != 0 ? MiniBoxNoticeInfo.MIN_5 : j17, (i18 & 32) != 0 ? 0 : i16, (i18 & 64) != 0 ? 1000 : i17, (i18 & 128) != 0 ? new JsonArray() : jsonArray);
    }
}
