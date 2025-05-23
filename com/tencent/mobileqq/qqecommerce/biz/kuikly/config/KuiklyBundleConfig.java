package com.tencent.mobileqq.qqecommerce.biz.kuikly.config;

import com.tencent.aegiskmm.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/config/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "resId", "", "b", "J", "getMinResVersion", "()J", "minResVersion", "<init>", "(Ljava/lang/String;J)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.config.a, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class KuiklyBundleConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String resId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long minResVersion;

    public KuiklyBundleConfig() {
        this(null, 0L, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getResId() {
        return this.resId;
    }

    public int hashCode() {
        return (this.resId.hashCode() * 31) + d.a(this.minResVersion);
    }

    public String toString() {
        return "KuiklyBundleConfig(resId=" + this.resId + ", minResVersion=" + this.minResVersion + ")";
    }

    public KuiklyBundleConfig(String resId, long j3) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        this.resId = resId;
        this.minResVersion = j3;
    }

    public /* synthetic */ KuiklyBundleConfig(String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0L : j3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KuiklyBundleConfig)) {
            return false;
        }
        KuiklyBundleConfig kuiklyBundleConfig = (KuiklyBundleConfig) other;
        return Intrinsics.areEqual(this.resId, kuiklyBundleConfig.resId) && this.minResVersion == kuiklyBundleConfig.minResVersion;
    }
}
