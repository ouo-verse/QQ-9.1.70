package com.tencent.mobileqq.qqguildsdk.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u000b\u0018\u0000 \u00042\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0086\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/GProRolePermission;", "", "", "Lcom/tencent/mobileqq/qqguildsdk/data/bh;", "c", "", "permissionType", "", "enable", "", "d", "a", "", "toString", "", "Ljava/util/List;", "mPermissions", "b", "Z", "()Z", "e", "(Z)V", "hasRolePermission", "<init>", "()V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GProRolePermission {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<bh> mPermissions = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasRolePermission;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ,\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/GProRolePermission$a;", "", "", "", "modifiablePermissions", "", "permissionTypes", "", "isActive", "Lcom/tencent/mobileqq/qqguildsdk/data/GProRolePermission;", "a", "<init>", "()V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqguildsdk.data.GProRolePermission$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ GProRolePermission b(Companion companion, List list, Set set, boolean z16, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z16 = true;
            }
            return companion.a(list, set, z16);
        }

        @NotNull
        public final GProRolePermission a(@NotNull List<Integer> modifiablePermissions, @NotNull Set<Integer> permissionTypes, boolean isActive) {
            Intrinsics.checkNotNullParameter(modifiablePermissions, "modifiablePermissions");
            Intrinsics.checkNotNullParameter(permissionTypes, "permissionTypes");
            GProRolePermission gProRolePermission = new GProRolePermission();
            Iterator<T> it = modifiablePermissions.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                gProRolePermission.d(intValue, permissionTypes.contains(Integer.valueOf(intValue)));
            }
            gProRolePermission.e(isActive);
            return gProRolePermission;
        }

        Companion() {
        }
    }

    public final boolean a(int permissionType) {
        List<bh> list = this.mPermissions;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((bh) it.next()).a().contains(Integer.valueOf(permissionType))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasRolePermission() {
        return this.hasRolePermission;
    }

    @NotNull
    public final List<bh> c() {
        return this.mPermissions;
    }

    public final void d(final int permissionType, boolean enable) {
        if (!enable) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.mPermissions, (Function1) new Function1<bh, Boolean>() { // from class: com.tencent.mobileqq.qqguildsdk.data.GProRolePermission$set$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull bh it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.getId() == permissionType);
                }
            });
        } else {
            this.mPermissions.add(new bh(permissionType, null, 2, 0 == true ? 1 : 0));
        }
    }

    public final void e(boolean z16) {
        this.hasRolePermission = z16;
    }

    @NotNull
    public String toString() {
        return this.mPermissions.toString();
    }
}
