package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/v;", "", "", "toString", "", "hashCode", "other", "", "equals", "enableBatchPreRequest", "Z", "a", "()Z", "", "validTimeSeconds", "J", "c", "()J", "perPageMaxCount", "I", "b", "()I", "<init>", "(ZJI)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.v, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanEmoticonTabCloudCacheRequestConfig {

    @SerializedName("enableBatchPreRequest")
    private final boolean enableBatchPreRequest;

    @SerializedName("perPageMaxCount")
    private final int perPageMaxCount;

    @SerializedName("validTimeSeconds")
    private final long validTimeSeconds;

    public ZPlanEmoticonTabCloudCacheRequestConfig() {
        this(false, 0L, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnableBatchPreRequest() {
        return this.enableBatchPreRequest;
    }

    /* renamed from: b, reason: from getter */
    public final int getPerPageMaxCount() {
        return this.perPageMaxCount;
    }

    /* renamed from: c, reason: from getter */
    public final long getValidTimeSeconds() {
        return this.validTimeSeconds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.enableBatchPreRequest;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + com.tencent.mobileqq.vas.banner.c.a(this.validTimeSeconds)) * 31) + this.perPageMaxCount;
    }

    public String toString() {
        return "ZPlanEmoticonTabCloudCacheRequestConfig(enableBatchPreRequest=" + this.enableBatchPreRequest + ", validTimeSeconds=" + this.validTimeSeconds + ", perPageMaxCount=" + this.perPageMaxCount + ')';
    }

    public ZPlanEmoticonTabCloudCacheRequestConfig(boolean z16, long j3, int i3) {
        this.enableBatchPreRequest = z16;
        this.validTimeSeconds = j3;
        this.perPageMaxCount = i3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanEmoticonTabCloudCacheRequestConfig)) {
            return false;
        }
        ZPlanEmoticonTabCloudCacheRequestConfig zPlanEmoticonTabCloudCacheRequestConfig = (ZPlanEmoticonTabCloudCacheRequestConfig) other;
        return this.enableBatchPreRequest == zPlanEmoticonTabCloudCacheRequestConfig.enableBatchPreRequest && this.validTimeSeconds == zPlanEmoticonTabCloudCacheRequestConfig.validTimeSeconds && this.perPageMaxCount == zPlanEmoticonTabCloudCacheRequestConfig.perPageMaxCount;
    }

    public /* synthetic */ ZPlanEmoticonTabCloudCacheRequestConfig(boolean z16, long j3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? 3600L : j3, (i16 & 4) != 0 ? 100 : i3);
    }
}
