package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "tag", "Ljava/lang/String;", "()Ljava/lang/String;", "baseDexPaths", "<init>", "(JLjava/lang/String;)V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.a, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class DexConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String baseDexPaths;

    public DexConfig(long j3, @NotNull String baseDexPaths) {
        Intrinsics.checkNotNullParameter(baseDexPaths, "baseDexPaths");
        this.tag = j3;
        this.baseDexPaths = baseDexPaths;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBaseDexPaths() {
        return this.baseDexPaths;
    }

    /* renamed from: b, reason: from getter */
    public final long getTag() {
        return this.tag;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DexConfig)) {
            return false;
        }
        DexConfig dexConfig = (DexConfig) other;
        if (this.tag == dexConfig.tag && Intrinsics.areEqual(this.baseDexPaths, dexConfig.baseDexPaths)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.tag) * 31) + this.baseDexPaths.hashCode();
    }

    @NotNull
    public String toString() {
        return "DexConfig(tag=" + this.tag + ", baseDexPaths=" + this.baseDexPaths + ')';
    }
}
