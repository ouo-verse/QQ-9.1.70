package com.tencent.mobileqq.guild.rolegroup.model.repositories;

import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RolePermission;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0007J\u0016\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J$\u0010\u000e\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J$\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J$\u0010\u0011\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J$\u0010\u0012\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J$\u0010\u0013\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J$\u0010\u0014\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/t;", "", "", "", "myRoles", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "roleModels", "", tl.h.F, "", "g", "f", "j", "i", "k", "", "e", "a", "c", "b", "d", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t f232801a = new t();

    t() {
    }

    private final boolean a(List<String> myRoles, List<RoleGroupModel> roleModels) {
        for (RoleGroupModel roleGroupModel : roleModels) {
            if (myRoles.contains(roleGroupModel.getId()) && roleGroupModel.getRolePermission().getCanModifyRole()) {
                return true;
            }
        }
        if (myRoles.contains("5") || myRoles.contains("7")) {
            return true;
        }
        return false;
    }

    private final boolean b(List<String> myRoles, List<RoleGroupModel> roleModels) {
        for (RoleGroupModel roleGroupModel : roleModels) {
            if (myRoles.contains(roleGroupModel.getId()) && roleGroupModel.getRolePermission().getCanModifyAudioChannel()) {
                return true;
            }
        }
        return false;
    }

    private final boolean c(List<String> myRoles, List<RoleGroupModel> roleModels) {
        for (RoleGroupModel roleGroupModel : roleModels) {
            if (myRoles.contains(roleGroupModel.getId()) && roleGroupModel.getRolePermission().getCanCreateChannel()) {
                return true;
            }
        }
        return false;
    }

    private final boolean d(List<String> myRoles, List<RoleGroupModel> roleModels) {
        for (RoleGroupModel roleGroupModel : roleModels) {
            if (myRoles.contains(roleGroupModel.getId()) && roleGroupModel.getRolePermission().getCanSortRole()) {
                return true;
            }
        }
        return false;
    }

    private final int e(List<String> myRoles, List<RoleGroupModel> roleModels) {
        int i3 = 0;
        for (Object obj : roleModels) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (myRoles.contains(((RoleGroupModel) obj).getId())) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    private final boolean f(List<String> myRoles) {
        return myRoles.contains("2");
    }

    private final boolean g(List<String> myRoles) {
        return myRoles.contains("4");
    }

    @JvmStatic
    public static final void h(@NotNull List<String> myRoles, @NotNull List<RoleGroupModel> roleModels) {
        Intrinsics.checkNotNullParameter(myRoles, "myRoles");
        Intrinsics.checkNotNullParameter(roleModels, "roleModels");
        t tVar = f232801a;
        if (tVar.g(myRoles)) {
            tVar.j(roleModels);
        } else if (tVar.f(myRoles)) {
            tVar.i(roleModels);
        } else {
            tVar.k(myRoles, roleModels);
        }
    }

    private final void i(List<RoleGroupModel> roleModels) {
        boolean z16;
        for (RoleGroupModel roleGroupModel : roleModels) {
            RolePermission rolePermission = roleGroupModel.getRolePermission();
            if (!roleGroupModel.z() && !roleGroupModel.u() && !roleGroupModel.t()) {
                z16 = false;
            } else {
                z16 = true;
            }
            rolePermission.x(z16);
            roleGroupModel.getRolePermission().n(!roleGroupModel.v());
            roleGroupModel.getRolePermission().p(!roleGroupModel.v());
            roleGroupModel.getRolePermission().o(!roleGroupModel.v());
        }
    }

    private final void j(List<RoleGroupModel> roleModels) {
        boolean z16;
        for (RoleGroupModel roleGroupModel : roleModels) {
            RolePermission rolePermission = roleGroupModel.getRolePermission();
            if (!roleGroupModel.z() && !roleGroupModel.u() && !roleGroupModel.t()) {
                z16 = false;
            } else {
                z16 = true;
            }
            rolePermission.x(z16);
            roleGroupModel.getRolePermission().n(true);
            roleGroupModel.getRolePermission().p(true);
            roleGroupModel.getRolePermission().o(true);
        }
    }

    private final void k(List<String> myRoles, List<RoleGroupModel> roleModels) {
        boolean d16 = d(myRoles, roleModels);
        boolean a16 = a(myRoles, roleModels);
        boolean c16 = c(myRoles, roleModels);
        boolean b16 = b(myRoles, roleModels);
        if (!a16 && !d16 && !c16) {
            return;
        }
        int e16 = e(myRoles, roleModels);
        int i3 = 0;
        for (Object obj : roleModels) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RoleGroupModel roleGroupModel = (RoleGroupModel) obj;
            if (i3 > e16) {
                roleGroupModel.getRolePermission().x(d16);
                roleGroupModel.getRolePermission().n(a16);
                roleGroupModel.getRolePermission().p(c16);
                roleGroupModel.getRolePermission().o(c16);
                roleGroupModel.getRolePermission().o(b16);
            }
            i3 = i16;
        }
    }
}
