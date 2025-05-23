package com.tencent.mobileqq.qqecommerce.biz.kuikly.config;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/config/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "requestFullConfigSwitch", "b", "I", "c", "()I", "requestFullConfigGapMim", "requestBundleConfigGapMin", "", "Ljava/util/List;", "()Ljava/util/List;", "bundleList", "<init>", "(ZIILjava/util/List;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.config.b, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class RequestConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean requestFullConfigSwitch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int requestFullConfigGapMim;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int requestBundleConfigGapMin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<String> bundleList;

    public RequestConfig() {
        this(false, 0, 0, null, 15, null);
    }

    public final List<String> a() {
        return this.bundleList;
    }

    /* renamed from: b, reason: from getter */
    public final int getRequestBundleConfigGapMin() {
        return this.requestBundleConfigGapMin;
    }

    /* renamed from: c, reason: from getter */
    public final int getRequestFullConfigGapMim() {
        return this.requestFullConfigGapMim;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getRequestFullConfigSwitch() {
        return this.requestFullConfigSwitch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.requestFullConfigSwitch;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((r06 * 31) + this.requestFullConfigGapMim) * 31) + this.requestBundleConfigGapMin) * 31) + this.bundleList.hashCode();
    }

    public String toString() {
        return "RequestConfig(requestFullConfigSwitch=" + this.requestFullConfigSwitch + ", requestFullConfigGapMim=" + this.requestFullConfigGapMim + ", requestBundleConfigGapMin=" + this.requestBundleConfigGapMin + ", bundleList=" + this.bundleList + ")";
    }

    public RequestConfig(boolean z16, int i3, int i16, List<String> bundleList) {
        Intrinsics.checkNotNullParameter(bundleList, "bundleList");
        this.requestFullConfigSwitch = z16;
        this.requestFullConfigGapMim = i3;
        this.requestBundleConfigGapMin = i16;
        this.bundleList = bundleList;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestConfig)) {
            return false;
        }
        RequestConfig requestConfig = (RequestConfig) other;
        return this.requestFullConfigSwitch == requestConfig.requestFullConfigSwitch && this.requestFullConfigGapMim == requestConfig.requestFullConfigGapMim && this.requestBundleConfigGapMin == requestConfig.requestBundleConfigGapMin && Intrinsics.areEqual(this.bundleList, requestConfig.bundleList);
    }

    public /* synthetic */ RequestConfig(boolean z16, int i3, int i16, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? 180 : i3, (i17 & 4) != 0 ? 10 : i16, (i17 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
