package com.tencent.mobileqq.qqecommerce.biz.kuikly.preload;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/RequestTimeType;", "a", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/RequestTimeType;", "b", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/RequestTimeType;", "requestTimeType", "", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/e;", "Ljava/util/List;", "()Ljava/util/List;", "requestList", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/RequestTimeType;Ljava/util/List;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.d, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class PreRequestData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final RequestTimeType requestTimeType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<PreRequestItem> requestList;

    public PreRequestData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final List<PreRequestItem> a() {
        return this.requestList;
    }

    /* renamed from: b, reason: from getter */
    public final RequestTimeType getRequestTimeType() {
        return this.requestTimeType;
    }

    public int hashCode() {
        return (this.requestTimeType.hashCode() * 31) + this.requestList.hashCode();
    }

    public String toString() {
        return "PreRequestData(requestTimeType=" + this.requestTimeType + ", requestList=" + this.requestList + ")";
    }

    public PreRequestData(RequestTimeType requestTimeType, List<PreRequestItem> requestList) {
        Intrinsics.checkNotNullParameter(requestTimeType, "requestTimeType");
        Intrinsics.checkNotNullParameter(requestList, "requestList");
        this.requestTimeType = requestTimeType;
        this.requestList = requestList;
    }

    public /* synthetic */ PreRequestData(RequestTimeType requestTimeType, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? RequestTimeType.TYPE_ONLY_DOWNLOAD : requestTimeType, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreRequestData)) {
            return false;
        }
        PreRequestData preRequestData = (PreRequestData) other;
        return this.requestTimeType == preRequestData.requestTimeType && Intrinsics.areEqual(this.requestList, preRequestData.requestList);
    }
}
