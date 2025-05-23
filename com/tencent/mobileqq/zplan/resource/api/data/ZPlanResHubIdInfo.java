package com.tencent.mobileqq.zplan.resource.api.data;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import hv4.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/resource/api/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appId", "b", com.heytap.mcssdk.a.a.f36102l, "c", MosaicConstants$JsProperty.PROP_ENV, "d", "Z", "e", "()Z", "useDirectDownloadUrl", "Lhv4/g;", "Lhv4/g;", "()Lhv4/g;", "resHubInfoDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLhv4/g;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.resource.api.data.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanResHubIdInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String appKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String env;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean useDirectDownloadUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final g resHubInfoDetail;

    public ZPlanResHubIdInfo(String appId, String appKey, String env, boolean z16, g resHubInfoDetail) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(resHubInfoDetail, "resHubInfoDetail");
        this.appId = appId;
        this.appKey = appKey;
        this.env = env;
        this.useDirectDownloadUrl = z16;
        this.resHubInfoDetail = resHubInfoDetail;
    }

    /* renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    /* renamed from: c, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* renamed from: d, reason: from getter */
    public final g getResHubInfoDetail() {
        return this.resHubInfoDetail;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getUseDirectDownloadUrl() {
        return this.useDirectDownloadUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.appId.hashCode() * 31) + this.appKey.hashCode()) * 31) + this.env.hashCode()) * 31;
        boolean z16 = this.useDirectDownloadUrl;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.resHubInfoDetail.hashCode();
    }

    public String toString() {
        return "ZPlanResHubIdInfo(appId=" + this.appId + ", appKey=" + this.appKey + ", env=" + this.env + ", useDirectDownloadUrl=" + this.useDirectDownloadUrl + ", resHubInfoDetail=" + this.resHubInfoDetail + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanResHubIdInfo)) {
            return false;
        }
        ZPlanResHubIdInfo zPlanResHubIdInfo = (ZPlanResHubIdInfo) other;
        return Intrinsics.areEqual(this.appId, zPlanResHubIdInfo.appId) && Intrinsics.areEqual(this.appKey, zPlanResHubIdInfo.appKey) && Intrinsics.areEqual(this.env, zPlanResHubIdInfo.env) && this.useDirectDownloadUrl == zPlanResHubIdInfo.useDirectDownloadUrl && Intrinsics.areEqual(this.resHubInfoDetail, zPlanResHubIdInfo.resHubInfoDetail);
    }
}
