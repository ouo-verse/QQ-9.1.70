package com.qzone.proxy.feedcomponent.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "a", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "()Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "originFeedData", "Lcom/qzone/proxy/feedcomponent/model/o;", "b", "Lcom/qzone/proxy/feedcomponent/model/o;", "()Lcom/qzone/proxy/feedcomponent/model/o;", "parsedFeedData", "<init>", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;Lcom/qzone/proxy/feedcomponent/model/o;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.proxy.feedcomponent.model.i, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class FrdHotVideoSubFeedInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final BusinessFeedData originFeedData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final ParsedFeedData parsedFeedData;

    public FrdHotVideoSubFeedInfo(BusinessFeedData originFeedData, ParsedFeedData parsedFeedData) {
        Intrinsics.checkNotNullParameter(originFeedData, "originFeedData");
        Intrinsics.checkNotNullParameter(parsedFeedData, "parsedFeedData");
        this.originFeedData = originFeedData;
        this.parsedFeedData = parsedFeedData;
    }

    /* renamed from: a, reason: from getter */
    public final BusinessFeedData getOriginFeedData() {
        return this.originFeedData;
    }

    /* renamed from: b, reason: from getter */
    public final ParsedFeedData getParsedFeedData() {
        return this.parsedFeedData;
    }

    public int hashCode() {
        return (this.originFeedData.hashCode() * 31) + this.parsedFeedData.hashCode();
    }

    public String toString() {
        return "FrdHotVideoSubFeedInfo(originFeedData=" + this.originFeedData + ", parsedFeedData=" + this.parsedFeedData + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrdHotVideoSubFeedInfo)) {
            return false;
        }
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = (FrdHotVideoSubFeedInfo) other;
        return Intrinsics.areEqual(this.originFeedData, frdHotVideoSubFeedInfo.originFeedData) && Intrinsics.areEqual(this.parsedFeedData, frdHotVideoSubFeedInfo.parsedFeedData);
    }
}
