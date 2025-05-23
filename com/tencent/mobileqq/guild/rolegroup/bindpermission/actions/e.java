package com.tencent.mobileqq.guild.rolegroup.bindpermission.actions;

import com.tencent.mobileqq.guild.rolegroup.adapters.previewavatar.a;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.GProRolePermission;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J.\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJJ\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/e;", "", "Lri1/a;", "error", "", "from", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/w;", "callback", "", "a", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "roleList", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/x;", "callBack", "b", "", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/previewavatar/a$b;", "previewMemberUIData", "", "total", "", "isEnd", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/y;", "Lkotlin/Function0;", "fetchHasPermissionUsersAgain", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f232387a = new e();

    e() {
    }

    public final void a(@NotNull ri1.a error, @NotNull String from, @NotNull w callback) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!error.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "handleCommonRequestResult from:" + from + " e:" + error;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.BindPermission.ActionUtil", 1, (String) it.next(), null);
            }
        } else {
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.rg.BindPermission.ActionUtil", 2, "handleCommonRequestResult from:" + from + " e:" + error);
            }
        }
        callback.a(error);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(@NotNull ri1.a error, @Nullable List<RoleGroupModel> roleList, @NotNull String from, @NotNull x callBack) {
        Integer num;
        int collectionSizeOrDefault;
        List<RoleLabelData> mutableList;
        String str;
        String str2;
        IGProGuildRoleInfo lvRole;
        boolean z16;
        IGProGuildRoleInfo lvRole2;
        int i3;
        GProRolePermission permission;
        String str3;
        String str4;
        Integer num2;
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        Unit unit = null;
        if (!error.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            if (roleList != null) {
                num2 = Integer.valueOf(roleList.size());
            } else {
                num2 = null;
            }
            String str5 = "handleFetchRolesResult from:" + from + " e:" + error + " size:" + num2;
            if (str5 instanceof String) {
                bVar.a().add(str5);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.BindPermission.ActionUtil", 1, (String) it.next(), null);
            }
            callBack.a(new ArrayList(), 0);
            return;
        }
        Logger.a d16 = Logger.f235387a.d();
        if (roleList != null) {
            num = Integer.valueOf(roleList.size());
        } else {
            num = null;
        }
        d16.i("Guild.rg.BindPermission.ActionUtil", 1, "handleFetchRolesResult from:" + from + " e:" + error + " size:" + num);
        if (roleList != null) {
            List<RoleGroupModel> list = roleList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (RoleGroupModel roleGroupModel : list) {
                String id5 = roleGroupModel.getId();
                String name = roleGroupModel.getName();
                int color = roleGroupModel.getColor() | (-16777216);
                int roleType = roleGroupModel.getRoleType();
                if (roleGroupModel.getIsLevelRole()) {
                    IGProGuildRoleInfo lvRole3 = roleGroupModel.getLvRole();
                    if (lvRole3 != null) {
                        str4 = lvRole3.getLevelSimpleDsc();
                    } else {
                        str4 = null;
                    }
                    if (str4 != null) {
                        Intrinsics.checkNotNullExpressionValue(str4, "it.lvRole?.levelSimpleDsc ?: \"\"");
                        str = str4;
                        if (roleGroupModel.getIsLevelRole()) {
                            IGProGuildRoleInfo lvRole4 = roleGroupModel.getLvRole();
                            if (lvRole4 != null) {
                                str3 = lvRole4.getLevelIconUrl();
                            } else {
                                str3 = null;
                            }
                            if (str3 != null) {
                                Intrinsics.checkNotNullExpressionValue(str3, "it.lvRole?.levelIconUrl ?: \"\"");
                                str2 = str3;
                                lvRole = roleGroupModel.getLvRole();
                                if (lvRole == null && (permission = lvRole.getPermission()) != null) {
                                    z16 = permission.getHasRolePermission();
                                } else {
                                    z16 = false;
                                }
                                lvRole2 = roleGroupModel.getLvRole();
                                if (lvRole2 != null) {
                                    i3 = lvRole2.getDisplayType();
                                } else {
                                    i3 = 0;
                                }
                                arrayList.add(new RoleLabelData(id5, color, name, roleType, str, str2, false, z16, i3, 64, null));
                            }
                        }
                        str2 = "";
                        lvRole = roleGroupModel.getLvRole();
                        if (lvRole == null) {
                        }
                        z16 = false;
                        lvRole2 = roleGroupModel.getLvRole();
                        if (lvRole2 != null) {
                        }
                        arrayList.add(new RoleLabelData(id5, color, name, roleType, str, str2, false, z16, i3, 64, null));
                    }
                }
                str = "";
                if (roleGroupModel.getIsLevelRole()) {
                }
                str2 = "";
                lvRole = roleGroupModel.getLvRole();
                if (lvRole == null) {
                }
                z16 = false;
                lvRole2 = roleGroupModel.getLvRole();
                if (lvRole2 != null) {
                }
                arrayList.add(new RoleLabelData(id5, color, name, roleType, str, str2, false, z16, i3, 64, null));
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
            callBack.a(mutableList, roleList.size());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            callBack.a(new ArrayList(), 0);
        }
    }

    public final void c(@NotNull ri1.a error, @NotNull List<a.b> previewMemberUIData, int total, boolean isEnd, @NotNull String from, @NotNull y callback, @NotNull Function0<Unit> fetchHasPermissionUsersAgain) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(previewMemberUIData, "previewMemberUIData");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(fetchHasPermissionUsersAgain, "fetchHasPermissionUsersAgain");
        if (!error.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "handleFetchUsersResult from:" + from + " error:" + error;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.BindPermission.ActionUtil", 1, (String) it.next(), null);
            }
            callback.a(new ArrayList(), 0);
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("Guild.rg.BindPermission.ActionUtil", 2, "handleFetchUsersResult from:" + from + " e:" + error + ", total:" + total + ", isEnd:" + isEnd + ", size:" + previewMemberUIData.size());
        }
        if (total == 0 && !isEnd) {
            fetchHasPermissionUsersAgain.invoke();
            callback.a(new ArrayList(), 0);
        } else {
            callback.a(previewMemberUIData, total);
        }
    }
}
