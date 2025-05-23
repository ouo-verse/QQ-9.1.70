package com.tencent.mobileqq.guild.rolegroup.model.data;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.Desc;
import com.tencent.mobileqq.qqguildsdk.data.GProRolePermission;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.bh;
import com.tencent.mobileqq.qqguildsdk.data.ek;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b$\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0012B\u00a5\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000bj\b\u0012\u0004\u0012\u00020\u0010`\r\u00a2\u0006\u0004\b5\u00106J\u00a7\u0001\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000bj\b\u0012\u0004\u0012\u00020\u0010`\rH\u00c6\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0018\u001a\u0004\b&\u0010\u001a\"\u0004\b)\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0018\u001a\u0004\b \u0010\u001a\"\u0004\b+\u0010\u001cR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0018\u001a\u0004\b#\u0010\u001a\"\u0004\b-\u0010\u001cR2\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b.\u00100\"\u0004\b1\u00102R2\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010/\u001a\u0004\b*\u00100\"\u0004\b3\u00102R2\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000bj\b\u0012\u0004\u0012\u00020\u0010`\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010/\u001a\u0004\b,\u00100\"\u0004\b4\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/h;", "", "", "isAccessibleInList", "isAccessibleWhenCreate", "isAccessibleWhenAudioActivity", "isSortableInList", "canSortRole", "canModifyRole", "canCreateChannel", "canModifyAudioChannel", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "permissionsOfThisRole", "myPermissionsForThisRole", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/i;", "permissionTypeDescList", "a", "", "toString", "hashCode", "other", "equals", "Z", "j", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "b", "l", "p", "c", "k", "o", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HippyTKDListViewAdapter.X, "e", "f", "t", ReportConstant.COSTREPORT_PREFIX, "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, "r", "i", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "w", "(Ljava/util/ArrayList;)V", "u", "v", "<init>", "(ZZZZZZZZLjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.h, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RolePermission {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isAccessibleInList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isAccessibleWhenCreate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isAccessibleWhenAudioActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSortableInList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean canSortRole;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean canModifyRole;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean canCreateChannel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean canModifyAudioChannel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ArrayList<Integer> permissionsOfThisRole;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ArrayList<Integer> myPermissionsForThisRole;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ArrayList<RolePermissionDesc> permissionTypeDescList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J6\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/h$a;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/h;", "rolePermission", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/GProRolePermission;", "allowPermission", "", "Lcom/tencent/mobileqq/qqguildsdk/data/bv;", "descList", "Lcom/tencent/mobileqq/qqguildsdk/data/ek;", "permissionCategories", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.h$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final RolePermission a(@NotNull RolePermission rolePermission) {
            Intrinsics.checkNotNullParameter(rolePermission, "rolePermission");
            RolePermission b16 = RolePermission.b(rolePermission, false, false, false, false, false, false, false, false, null, null, null, 2047, null);
            b16.w(new ArrayList<>(rolePermission.i()));
            return b16;
        }

        @JvmStatic
        @NotNull
        public final RolePermission b(@NotNull IGProGuildRoleInfo roleInfo, @Nullable GProRolePermission allowPermission, @NotNull List<Desc> descList, @NotNull List<? extends ek> permissionCategories) {
            List<bh> c16;
            Intrinsics.checkNotNullParameter(roleInfo, "roleInfo");
            Intrinsics.checkNotNullParameter(descList, "descList");
            Intrinsics.checkNotNullParameter(permissionCategories, "permissionCategories");
            RolePermission rolePermission = new RolePermission(false, false, false, false, false, false, false, false, null, null, null, 2047, null);
            rolePermission.t(roleInfo.getPermission().a(70003));
            rolePermission.s(roleInfo.getPermission().a(70002));
            rolePermission.q(roleInfo.getPermission().a(20001));
            rolePermission.r(roleInfo.getPermission().a(20012));
            rolePermission.h().addAll(RolePermissionDesc.INSTANCE.c(descList, permissionCategories));
            Iterator<T> it = roleInfo.getPermission().c().iterator();
            while (it.hasNext()) {
                rolePermission.i().add(Integer.valueOf(((bh) it.next()).getId()));
            }
            if (allowPermission != null && (c16 = allowPermission.c()) != null) {
                Iterator<T> it5 = c16.iterator();
                while (it5.hasNext()) {
                    rolePermission.g().add(Integer.valueOf(((bh) it5.next()).getId()));
                }
            }
            return rolePermission;
        }

        Companion() {
        }
    }

    public RolePermission() {
        this(false, false, false, false, false, false, false, false, null, null, null, 2047, null);
    }

    public static /* synthetic */ RolePermission b(RolePermission rolePermission, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i3, Object obj) {
        return rolePermission.a((i3 & 1) != 0 ? rolePermission.isAccessibleInList : z16, (i3 & 2) != 0 ? rolePermission.isAccessibleWhenCreate : z17, (i3 & 4) != 0 ? rolePermission.isAccessibleWhenAudioActivity : z18, (i3 & 8) != 0 ? rolePermission.isSortableInList : z19, (i3 & 16) != 0 ? rolePermission.canSortRole : z26, (i3 & 32) != 0 ? rolePermission.canModifyRole : z27, (i3 & 64) != 0 ? rolePermission.canCreateChannel : z28, (i3 & 128) != 0 ? rolePermission.canModifyAudioChannel : z29, (i3 & 256) != 0 ? rolePermission.permissionsOfThisRole : arrayList, (i3 & 512) != 0 ? rolePermission.myPermissionsForThisRole : arrayList2, (i3 & 1024) != 0 ? rolePermission.permissionTypeDescList : arrayList3);
    }

    @NotNull
    public final RolePermission a(boolean isAccessibleInList, boolean isAccessibleWhenCreate, boolean isAccessibleWhenAudioActivity, boolean isSortableInList, boolean canSortRole, boolean canModifyRole, boolean canCreateChannel, boolean canModifyAudioChannel, @NotNull ArrayList<Integer> permissionsOfThisRole, @NotNull ArrayList<Integer> myPermissionsForThisRole, @NotNull ArrayList<RolePermissionDesc> permissionTypeDescList) {
        Intrinsics.checkNotNullParameter(permissionsOfThisRole, "permissionsOfThisRole");
        Intrinsics.checkNotNullParameter(myPermissionsForThisRole, "myPermissionsForThisRole");
        Intrinsics.checkNotNullParameter(permissionTypeDescList, "permissionTypeDescList");
        return new RolePermission(isAccessibleInList, isAccessibleWhenCreate, isAccessibleWhenAudioActivity, isSortableInList, canSortRole, canModifyRole, canCreateChannel, canModifyAudioChannel, permissionsOfThisRole, myPermissionsForThisRole, permissionTypeDescList);
    }

    /* renamed from: c, reason: from getter */
    public final boolean getCanCreateChannel() {
        return this.canCreateChannel;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getCanModifyAudioChannel() {
        return this.canModifyAudioChannel;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getCanModifyRole() {
        return this.canModifyRole;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RolePermission)) {
            return false;
        }
        RolePermission rolePermission = (RolePermission) other;
        if (this.isAccessibleInList == rolePermission.isAccessibleInList && this.isAccessibleWhenCreate == rolePermission.isAccessibleWhenCreate && this.isAccessibleWhenAudioActivity == rolePermission.isAccessibleWhenAudioActivity && this.isSortableInList == rolePermission.isSortableInList && this.canSortRole == rolePermission.canSortRole && this.canModifyRole == rolePermission.canModifyRole && this.canCreateChannel == rolePermission.canCreateChannel && this.canModifyAudioChannel == rolePermission.canModifyAudioChannel && Intrinsics.areEqual(this.permissionsOfThisRole, rolePermission.permissionsOfThisRole) && Intrinsics.areEqual(this.myPermissionsForThisRole, rolePermission.myPermissionsForThisRole) && Intrinsics.areEqual(this.permissionTypeDescList, rolePermission.permissionTypeDescList)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getCanSortRole() {
        return this.canSortRole;
    }

    @NotNull
    public final ArrayList<Integer> g() {
        return this.myPermissionsForThisRole;
    }

    @NotNull
    public final ArrayList<RolePermissionDesc> h() {
        return this.permissionTypeDescList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.isAccessibleInList;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isAccessibleWhenCreate;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        ?? r27 = this.isAccessibleWhenAudioActivity;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        ?? r28 = this.isSortableInList;
        int i27 = r28;
        if (r28 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        ?? r29 = this.canSortRole;
        int i29 = r29;
        if (r29 != 0) {
            i29 = 1;
        }
        int i36 = (i28 + i29) * 31;
        ?? r210 = this.canModifyRole;
        int i37 = r210;
        if (r210 != 0) {
            i37 = 1;
        }
        int i38 = (i36 + i37) * 31;
        ?? r211 = this.canCreateChannel;
        int i39 = r211;
        if (r211 != 0) {
            i39 = 1;
        }
        int i46 = (i38 + i39) * 31;
        boolean z17 = this.canModifyAudioChannel;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((((i46 + i3) * 31) + this.permissionsOfThisRole.hashCode()) * 31) + this.myPermissionsForThisRole.hashCode()) * 31) + this.permissionTypeDescList.hashCode();
    }

    @NotNull
    public final ArrayList<Integer> i() {
        return this.permissionsOfThisRole;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsAccessibleInList() {
        return this.isAccessibleInList;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsAccessibleWhenAudioActivity() {
        return this.isAccessibleWhenAudioActivity;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsAccessibleWhenCreate() {
        return this.isAccessibleWhenCreate;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsSortableInList() {
        return this.isSortableInList;
    }

    public final void n(boolean z16) {
        this.isAccessibleInList = z16;
    }

    public final void o(boolean z16) {
        this.isAccessibleWhenAudioActivity = z16;
    }

    public final void p(boolean z16) {
        this.isAccessibleWhenCreate = z16;
    }

    public final void q(boolean z16) {
        this.canCreateChannel = z16;
    }

    public final void r(boolean z16) {
        this.canModifyAudioChannel = z16;
    }

    public final void s(boolean z16) {
        this.canModifyRole = z16;
    }

    public final void t(boolean z16) {
        this.canSortRole = z16;
    }

    @NotNull
    public String toString() {
        return "RolePermission(isAccessibleInList=" + this.isAccessibleInList + ", isAccessibleWhenCreate=" + this.isAccessibleWhenCreate + ", isAccessibleWhenAudioActivity=" + this.isAccessibleWhenAudioActivity + ", isSortableInList=" + this.isSortableInList + ", canSortRole=" + this.canSortRole + ", canModifyRole=" + this.canModifyRole + ", canCreateChannel=" + this.canCreateChannel + ", canModifyAudioChannel=" + this.canModifyAudioChannel + ", permissionsOfThisRole=" + this.permissionsOfThisRole + ", myPermissionsForThisRole=" + this.myPermissionsForThisRole + ", permissionTypeDescList=" + this.permissionTypeDescList + ")";
    }

    public final void u(@NotNull ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.myPermissionsForThisRole = arrayList;
    }

    public final void v(@NotNull ArrayList<RolePermissionDesc> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.permissionTypeDescList = arrayList;
    }

    public final void w(@NotNull ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.permissionsOfThisRole = arrayList;
    }

    public final void x(boolean z16) {
        this.isSortableInList = z16;
    }

    public RolePermission(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, @NotNull ArrayList<Integer> permissionsOfThisRole, @NotNull ArrayList<Integer> myPermissionsForThisRole, @NotNull ArrayList<RolePermissionDesc> permissionTypeDescList) {
        Intrinsics.checkNotNullParameter(permissionsOfThisRole, "permissionsOfThisRole");
        Intrinsics.checkNotNullParameter(myPermissionsForThisRole, "myPermissionsForThisRole");
        Intrinsics.checkNotNullParameter(permissionTypeDescList, "permissionTypeDescList");
        this.isAccessibleInList = z16;
        this.isAccessibleWhenCreate = z17;
        this.isAccessibleWhenAudioActivity = z18;
        this.isSortableInList = z19;
        this.canSortRole = z26;
        this.canModifyRole = z27;
        this.canCreateChannel = z28;
        this.canModifyAudioChannel = z29;
        this.permissionsOfThisRole = permissionsOfThisRole;
        this.myPermissionsForThisRole = myPermissionsForThisRole;
        this.permissionTypeDescList = permissionTypeDescList;
    }

    public /* synthetic */ RolePermission(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? false : z18, (i3 & 8) != 0 ? false : z19, (i3 & 16) != 0 ? false : z26, (i3 & 32) != 0 ? false : z27, (i3 & 64) != 0 ? false : z28, (i3 & 128) == 0 ? z29 : false, (i3 & 256) != 0 ? new ArrayList() : arrayList, (i3 & 512) != 0 ? new ArrayList() : arrayList2, (i3 & 1024) != 0 ? new ArrayList() : arrayList3);
    }
}
