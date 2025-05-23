package com.tencent.mobileqq.qqguildsdk.data;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/bg;", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "", "permissionType", "", "a", "", "getPermission", "", "toString", "Ljava/util/Set;", "permissions", "<init>", "(Ljava/util/Set;)V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class bg implements dx {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<Integer> permissions;

    public bg(@NotNull Set<Integer> permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.permissions = permissions;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dx
    public boolean a(int permissionType) {
        return this.permissions.contains(Integer.valueOf(permissionType));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.dx
    @NotNull
    public Set<Integer> getPermission() {
        return this.permissions;
    }

    @NotNull
    public String toString() {
        List sorted;
        sorted = CollectionsKt___CollectionsKt.sorted(this.permissions);
        return sorted.toString();
    }
}
