package com.tencent.mobileqq.qmmkv.v2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/v2/a;", "Lcom/tencent/mobileqq/qmmkv/v2/j;", "", "mmapId", "", "mode", "", "withAccount", "Lcom/tencent/mobileqq/qmmkv/v2/e;", "c", "boundToAccount", "e", "d", "Z", "withoutAccount", "Lcom/tencent/mobileqq/qmmkv/v2/k;", "Lcom/tencent/mobileqq/qmmkv/v2/k;", "cache", "<init>", "(ZLcom/tencent/mobileqq/qmmkv/v2/k;)V", "library_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class a implements j {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean withoutAccount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final k cache;

    public a(boolean z16, @NotNull k cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.withoutAccount = z16;
        this.cache = cache;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.j
    @NotNull
    public e c(@NotNull String mmapId, int mode, boolean withAccount) {
        Intrinsics.checkNotNullParameter(mmapId, "mmapId");
        return this.cache.b(mmapId, this.cache.d(mmapId, !this.withoutAccount), mode);
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.j
    public boolean e(@NotNull String mmapId, boolean boundToAccount) {
        Intrinsics.checkNotNullParameter(mmapId, "mmapId");
        return this.cache.a(mmapId, this.cache.d(mmapId, !this.withoutAccount));
    }
}
