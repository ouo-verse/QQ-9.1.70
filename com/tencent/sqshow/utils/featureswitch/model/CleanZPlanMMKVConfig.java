package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "limitFileSize", "J", "b", "()J", "limitCleanTime", "a", "<init>", "(JJ)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class CleanZPlanMMKVConfig {

    @SerializedName("limitCleanTime")
    private final long limitCleanTime;

    @SerializedName("limitFileSize")
    private final long limitFileSize;

    public CleanZPlanMMKVConfig() {
        this(0L, 0L, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getLimitCleanTime() {
        return this.limitCleanTime;
    }

    /* renamed from: b, reason: from getter */
    public final long getLimitFileSize() {
        return this.limitFileSize;
    }

    public int hashCode() {
        return (com.tencent.mobileqq.vas.banner.c.a(this.limitFileSize) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.limitCleanTime);
    }

    public String toString() {
        return "CleanZPlanMMKVConfig(limitFileSize=" + this.limitFileSize + ", limitCleanTime=" + this.limitCleanTime + ')';
    }

    public CleanZPlanMMKVConfig(long j3, long j16) {
        this.limitFileSize = j3;
        this.limitCleanTime = j16;
    }

    public /* synthetic */ CleanZPlanMMKVConfig(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 33554432L : j3, (i3 & 2) != 0 ? 86400000L : j16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CleanZPlanMMKVConfig)) {
            return false;
        }
        CleanZPlanMMKVConfig cleanZPlanMMKVConfig = (CleanZPlanMMKVConfig) other;
        return this.limitFileSize == cleanZPlanMMKVConfig.limitFileSize && this.limitCleanTime == cleanZPlanMMKVConfig.limitCleanTime;
    }
}
