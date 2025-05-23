package com.tencent.mobileqq.guild.rolegroup.model.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bf;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.type.IPermissionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \n2\u00020\u0001:\u0001\u0007B-\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001b\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/c;", "", "", "permissionType", "", "k", "", "a", "j", "f", "e", "g", "c", "d", "i", tl.h.F, "", "toString", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "mGProPermission", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "guildId", "getChannelId", "channelId", "getCategoryId", "categoryId", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/dx;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.c, reason: from toString */
/* loaded from: classes14.dex */
public final class Permissions {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static Set<String> f232674f = new LinkedHashSet();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final dx list;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String gId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String categoryId;

    public Permissions(@NotNull dx mGProPermission, @NotNull String guildId, @NotNull String channelId, @NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(mGProPermission, "mGProPermission");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        this.list = mGProPermission;
        this.gId = guildId;
        this.channelId = channelId;
        this.categoryId = categoryId;
    }

    private final void k(int permissionType) {
        if (permissionType != 10001 || permissionType != 20001 || permissionType != 30001 || f232674f.contains(this.gId)) {
            return;
        }
        f232674f.add(this.gId);
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(this.gId);
        if (guildInfo == null) {
            return;
        }
        if (guildInfo.getUserType() == 2) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "rolePermission is False. However, who is owner " + getGId() + " permissionType:" + permissionType;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.GuildRolePermissionsModel", 1, (String) it.next(), null);
            }
        }
        if (guildInfo.getUserType() == 1) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            String str2 = "rolePermission is False. However, who is admin " + getGId() + " permissionType:" + permissionType;
            if (str2 instanceof String) {
                bVar2.a().add(str2);
            }
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.GuildRolePermissionsModel", 1, (String) it5.next(), null);
            }
        }
    }

    public final boolean a(int permissionType) {
        boolean a16 = this.list.a(permissionType);
        if (!a16) {
            k(permissionType);
        }
        return a16;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGId() {
        return this.gId;
    }

    public final boolean c() {
        if (!a(20005) && !a(20006) && !a(20007)) {
            return false;
        }
        return true;
    }

    public final boolean d() {
        if (!a(20001) && !a(20002) && !a(20003) && !a(20005) && !a(20006) && !a(20007) && !a(20010) && !a(20011) && !a(20012) && !a(20013) && !a(20014) && !a(20015)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[LOOP:1: B:42:0x00b1->B:54:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        ArrayList<Integer> arrayListOf;
        boolean z16;
        Set of5;
        boolean z17;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProCategoryChannelInfoList iGProCategoryChannelInfoList = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService == null) {
            return false;
        }
        long longOrDefault = Util.toLongOrDefault(this.gId, 0L);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(2);
        ArrayList<IGProCategoryChannelInfoList> categoryChannelInfoListByCategoryType = iGPSService.getCategoryChannelInfoListByCategoryType(longOrDefault, arrayListOf);
        if (categoryChannelInfoListByCategoryType != null) {
            Iterator<T> it = categoryChannelInfoListByCategoryType.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((IGProCategoryChannelInfoList) next).getCategoryType() == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    iGProCategoryChannelInfoList = next;
                    break;
                }
            }
            iGProCategoryChannelInfoList = iGProCategoryChannelInfoList;
        }
        if (iGProCategoryChannelInfoList == null) {
            Logger.f235387a.d().w("Guild.rg.GuildRolePermissionsModel", 1, "hasEditGroupChannelPermission(" + getGId() + ") can't get chatCategory");
            return false;
        }
        if (ch.m0(this.gId) || f()) {
            return true;
        }
        ArrayList<IGProChannel> channelInfoList = iGProCategoryChannelInfoList.getChannelInfoList();
        Intrinsics.checkNotNullExpressionValue(channelInfoList, "chatCategory.channelInfoList");
        if ((channelInfoList instanceof Collection) && channelInfoList.isEmpty()) {
            return false;
        }
        for (IGProChannel iGProChannel : channelInfoList) {
            if (iGProChannel.getIsChannelAdmin() == 1) {
                of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{1, 6});
                if (of5.contains(Integer.valueOf(iGProChannel.getChannelType()))) {
                    z16 = true;
                    if (!z16) {
                        return true;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return false;
    }

    public final boolean f() {
        if ((!a(20001) || !bf.f235464a.a()) && !a(20002) && !a(20003) && !a(20010) && !a(20014) && !a(20015)) {
            return false;
        }
        return true;
    }

    public final boolean g() {
        if (a(IPermissionType.MANAGE_BIND_GROUP) && a(IPermissionType.MANAGE_UNBIND_GROUP) && a(IPermissionType.MANAGE_SORT_GROUP)) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        if (!a(20001) && !a(20002) && !a(20003) && !a(20006) && !a(20007) && !a(20015) && !a(20011) && !a(70002) && !a(IPermissionType.MODIFY_CHANNEL_VIEW) && !a(IPermissionType.MODIFY_CHANNEL_SPEAK)) {
            return false;
        }
        return true;
    }

    public final boolean i() {
        if (!a(70001) && !a(70002) && !a(70003) && !a(IPermissionType.DELETE_ROLE) && !a(70005) && !a(IPermissionType.MODIFY_CHANNEL_VIEW) && !a(IPermissionType.MODIFY_CHANNEL_SPEAK)) {
            return false;
        }
        return true;
    }

    public final boolean j() {
        boolean z16;
        boolean z17;
        Set<Integer> permission = this.list.getPermission();
        IntRange intRange = new IntRange(20001, IPermissionType.MODIFY_WORLD_CHANNEL);
        if (!permission.isEmpty()) {
            if (!(permission instanceof Collection) || !permission.isEmpty()) {
                Iterator<T> it = permission.iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    int first = intRange.getFirst();
                    if (intValue <= intRange.getLast() && first <= intValue) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        z17 = false;
                        break;
                    }
                }
            }
            z17 = true;
            if (z17) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "Permissions(list=" + this.list + ", gId='" + this.gId + "', channelId='" + this.channelId + "', categoryId='" + this.categoryId + "')";
    }

    public /* synthetic */ Permissions(dx dxVar, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(dxVar, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3);
    }
}
