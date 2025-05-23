package com.tencent.mobileqq.guild.rolegroup.model.data;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\t\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0002\u001a\u00020\u0000J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\rR4\u0010\u0014\u001a\"\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fj\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;", "", "a", "", "toString", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "Ljava/util/List;", "c", "()Ljava/util/List;", "lvRoles", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "kotlin.jvm.PlatformType", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "_roleGroupModels", "d", "roleGroupModels", "roleGroups", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.g, reason: from toString */
/* loaded from: classes14.dex */
public final class RoleGroupListModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IGProGuildRoleInfo> lvRoles;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<RoleGroupModel> _roleGroupModels;

    /* JADX WARN: Multi-variable type inference failed */
    public RoleGroupListModel(@NotNull String guildId, @NotNull List<RoleGroupModel> roleGroups, @NotNull List<? extends IGProGuildRoleInfo> lvRoles) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleGroups, "roleGroups");
        Intrinsics.checkNotNullParameter(lvRoles, "lvRoles");
        this.guildId = guildId;
        this.lvRoles = lvRoles;
        this._roleGroupModels = new ArrayList<>(roleGroups);
    }

    @NotNull
    public final RoleGroupListModel a() {
        boolean z16;
        String str = this.guildId;
        ArrayList<RoleGroupModel> arrayList = this._roleGroupModels;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((RoleGroupModel) obj).getRoleType() == 7) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                arrayList2.add(obj);
            }
        }
        return new RoleGroupListModel(str, new ArrayList(arrayList2), this.lvRoles);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final List<IGProGuildRoleInfo> c() {
        return this.lvRoles;
    }

    @NotNull
    public final List<RoleGroupModel> d() {
        return this._roleGroupModels;
    }

    @NotNull
    public String toString() {
        return "RoleGroupListModel(guildId='" + this.guildId + "', rolesCount=" + this._roleGroupModels.size() + " with " + this._roleGroupModels + ")";
    }

    public /* synthetic */ RoleGroupListModel(String str, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }
}
