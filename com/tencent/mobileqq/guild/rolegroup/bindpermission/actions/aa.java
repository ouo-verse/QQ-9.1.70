package com.tencent.mobileqq.guild.rolegroup.bindpermission.actions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0000*\u00020\u0001H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0000*\u00020\u0001H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0000*\u00020\u0001H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\f\u0010\t\u001a\u00020\u0000*\u00020\u0001H\u0000\u00a8\u0006\n"}, d2 = {"", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/PermissionSwitchStatus;", tl.h.F, "g", "c", "f", "a", "d", "b", "e", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class aa {
    @NotNull
    public static final PermissionSwitchStatus a(int i3) {
        if (i3 == 0) {
            return PermissionSwitchStatus.TYPE_PART;
        }
        return PermissionSwitchStatus.TYPE_ALL;
    }

    @NotNull
    public static final PermissionSwitchStatus b(int i3) {
        if (i3 == 2) {
            return PermissionSwitchStatus.TYPE_PART;
        }
        return PermissionSwitchStatus.TYPE_ALL;
    }

    @NotNull
    public static final PermissionSwitchStatus c(int i3) {
        if (i3 == 2) {
            return PermissionSwitchStatus.TYPE_PART;
        }
        return PermissionSwitchStatus.TYPE_ALL;
    }

    public static final int d(@NotNull PermissionSwitchStatus permissionSwitchStatus) {
        Intrinsics.checkNotNullParameter(permissionSwitchStatus, "<this>");
        if (permissionSwitchStatus == PermissionSwitchStatus.TYPE_PART) {
            return 0;
        }
        return 1;
    }

    public static final int e(@NotNull PermissionSwitchStatus permissionSwitchStatus) {
        Intrinsics.checkNotNullParameter(permissionSwitchStatus, "<this>");
        if (permissionSwitchStatus == PermissionSwitchStatus.TYPE_PART) {
            return 2;
        }
        return 1;
    }

    public static final int f(@NotNull PermissionSwitchStatus permissionSwitchStatus) {
        Intrinsics.checkNotNullParameter(permissionSwitchStatus, "<this>");
        if (permissionSwitchStatus == PermissionSwitchStatus.TYPE_PART) {
            return 2;
        }
        return 1;
    }

    public static final int g(@NotNull PermissionSwitchStatus permissionSwitchStatus) {
        Intrinsics.checkNotNullParameter(permissionSwitchStatus, "<this>");
        if (permissionSwitchStatus == PermissionSwitchStatus.TYPE_PART) {
            return 1;
        }
        return 0;
    }

    @NotNull
    public static final PermissionSwitchStatus h(int i3) {
        if (i3 == 1) {
            return PermissionSwitchStatus.TYPE_PART;
        }
        return PermissionSwitchStatus.TYPE_ALL;
    }
}
