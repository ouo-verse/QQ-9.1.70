package com.tencent.mobileqq.guild.rolegroup.model.data;

import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\b6\u00107J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u00040\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\u0014\u0010\u0013\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\rJ\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000bJ\u001c\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u0006\u0010\u0018\u001a\u00020\tJ\u0014\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019J\u0016\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\tJ\u0006\u0010!\u001a\u00020\tJ\b\u0010\"\u001a\u00020\u0002H\u0016R\u0017\u0010&\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010#\u001a\u0004\b$\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010(R0\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070*j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010,R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.0*j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010,R\u001d\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020.008F\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u001d\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007008F\u00a2\u0006\u0006\u001a\u0004\b4\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/data/j;", "", "", "tinyId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "j", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "targetRole", "", "e", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProRoleMemberListInfo;", "memberList", "", "kotlin.jvm.PlatformType", "f", "", "i", "gProRoleMemberListInfos", "d", "gProMemberList", "c", "roles", DomainData.DOMAIN_NAME, "l", "", "tinyIds", "", "k", "", "muteTimestamp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "toString", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "", "Ljava/util/Set;", "memberTinyIds", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "_roleIdToRoleModel", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/f;", "_roleIdToMemberListModel", "", "g", "()Ljava/util/Map;", "roleIdToMemberListModel", tl.h.F, "roleIdToRoleModel", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.model.data.j, reason: from toString */
/* loaded from: classes14.dex */
public final class RoleToMemberListModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> memberTinyIds;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedHashMap<String, RoleGroupModel> _roleIdToRoleModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedHashMap<String, f> _roleIdToMemberListModel;

    public RoleToMemberListModel(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.memberTinyIds = new HashSet();
        this._roleIdToRoleModel = new LinkedHashMap<>();
        this._roleIdToMemberListModel = new LinkedHashMap<>();
    }

    private final void e(IGProUserInfo user, RoleGroupModel targetRole) {
        Long longOrNull;
        long j3;
        for (Map.Entry<String, f> entry : this._roleIdToMemberListModel.entrySet()) {
            String key = entry.getKey();
            f value = entry.getValue();
            if (Intrinsics.areEqual(key, targetRole.getId())) {
                value.a(user);
                user.setUserType(targetRole.s() ? 1 : 0);
                Set<String> set = this.memberTinyIds;
                String tinyId = user.getTinyId();
                Intrinsics.checkNotNullExpressionValue(tinyId, "user.tinyId");
                set.add(tinyId);
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(key);
                if (longOrNull == null) {
                    IGProRoleManagementTag roleManagementTag = user.getRoleManagementTag();
                    if (roleManagementTag != null) {
                        longOrNull = Long.valueOf(roleManagementTag.getRoleId());
                    } else {
                        longOrNull = null;
                    }
                    if (longOrNull == null) {
                        j3 = 0;
                        user.setRoleManagementTag(j3, targetRole.getDisplayTagName(), targetRole.getColor());
                    }
                }
                j3 = longOrNull.longValue();
                user.setRoleManagementTag(j3, targetRole.getDisplayTagName(), targetRole.getColor());
            }
        }
    }

    private final List<IGProUserInfo> f(IGProRoleMemberListInfo memberList) {
        List<IGProUserInfo> memberList2 = memberList.getMemberList();
        Intrinsics.checkNotNullExpressionValue(memberList2, "memberList.memberList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : memberList2) {
            if (!this.memberTinyIds.contains(((IGProUserInfo) obj).getTinyId())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final IGProUserInfo j(String tinyId) {
        Iterator<Map.Entry<String, f>> it = this._roleIdToMemberListModel.entrySet().iterator();
        IGProUserInfo iGProUserInfo = null;
        while (it.hasNext() && (iGProUserInfo = it.next().getValue().f(tinyId)) == null) {
        }
        this.memberTinyIds.remove(tinyId);
        return iGProUserInfo;
    }

    public final void a() {
        RoleGroupModel d16 = RoleGroupModel.INSTANCE.d();
        if (!this._roleIdToMemberListModel.containsKey(d16.getId())) {
            this._roleIdToMemberListModel.put(d16.getId(), new f(d16, new ArrayList()));
        }
    }

    public final void b() {
        RoleGroupModel e16 = RoleGroupModel.INSTANCE.e();
        if (!this._roleIdToMemberListModel.containsKey(e16.getId())) {
            this._roleIdToMemberListModel.put(e16.getId(), new f(e16, new ArrayList()));
        }
    }

    public final synchronized void c(@NotNull IGProRoleMemberListInfo gProMemberList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(gProMemberList, "gProMemberList");
        RoleGroupModel.Companion companion = RoleGroupModel.INSTANCE;
        IGProGuildRoleInfo roleInfo = gProMemberList.getRoleInfo();
        Intrinsics.checkNotNullExpressionValue(roleInfo, "gProMemberList.roleInfo");
        RoleGroupModel b16 = companion.b(roleInfo);
        this._roleIdToRoleModel.put(b16.getId(), b16);
        List<IGProUserInfo> f16 = f(gProMemberList);
        f fVar = this._roleIdToMemberListModel.get(b16.getId());
        if (fVar == null) {
            this._roleIdToMemberListModel.put(b16.getId(), new f(b16, new ArrayList(f16)));
        } else {
            fVar.h(b16);
            fVar.d().addAll(f16);
        }
        Set<String> set = this.memberTinyIds;
        List<IGProUserInfo> list = f16;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((IGProUserInfo) it.next()).getTinyId());
        }
        set.addAll(arrayList);
    }

    public final synchronized void d(@NotNull List<? extends IGProRoleMemberListInfo> gProRoleMemberListInfos) {
        Intrinsics.checkNotNullParameter(gProRoleMemberListInfos, "gProRoleMemberListInfos");
        Iterator<T> it = gProRoleMemberListInfos.iterator();
        while (it.hasNext()) {
            c((IGProRoleMemberListInfo) it.next());
        }
    }

    @NotNull
    public final Map<String, f> g() {
        return this._roleIdToMemberListModel;
    }

    @NotNull
    public final Map<String, RoleGroupModel> h() {
        return this._roleIdToRoleModel;
    }

    public final int i() {
        return this.memberTinyIds.size();
    }

    public final synchronized boolean k(@NotNull Collection<String> tinyIds) {
        Set<String> set;
        Intrinsics.checkNotNullParameter(tinyIds, "tinyIds");
        set = CollectionsKt___CollectionsKt.toSet(tinyIds);
        Iterator<Map.Entry<String, f>> it = this._roleIdToMemberListModel.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().g(set);
        }
        return this.memberTinyIds.removeAll(set);
    }

    public final synchronized void l() {
        this._roleIdToMemberListModel.clear();
        this._roleIdToRoleModel.clear();
        this.memberTinyIds.clear();
    }

    public final synchronized boolean m(@NotNull String tinyId, long muteTimestamp) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Iterator<Map.Entry<String, f>> it = this._roleIdToMemberListModel.entrySet().iterator();
        while (it.hasNext()) {
            IGProUserInfo c16 = it.next().getValue().c(tinyId);
            if (c16 != null) {
                if (c16.getShutUpExpireTime() == muteTimestamp) {
                    return false;
                }
                c16.setShutUpExpireTime(muteTimestamp);
                return true;
            }
        }
        return false;
    }

    public final synchronized void n(@NotNull String tinyId, @NotNull List<RoleGroupModel> roles) {
        boolean z16;
        Object obj;
        boolean z17;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(roles, "roles");
        Iterator<T> it = roles.iterator();
        while (true) {
            z16 = false;
            if (it.hasNext()) {
                obj = it.next();
                RoleGroupModel roleGroupModel = (RoleGroupModel) obj;
                if (roleGroupModel.getIsHoist() && this._roleIdToMemberListModel.containsKey(roleGroupModel.getId())) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        RoleGroupModel roleGroupModel2 = (RoleGroupModel) obj;
        if (roleGroupModel2 == null) {
            roleGroupModel2 = RoleGroupModel.INSTANCE.d();
        }
        f fVar = this._roleIdToMemberListModel.get(roleGroupModel2.getId());
        if (fVar != null) {
            z16 = fVar.b(tinyId);
        }
        if (z16) {
            return;
        }
        IGProUserInfo j3 = j(tinyId);
        if (j3 != null) {
            e(j3, roleGroupModel2);
        }
    }

    @NotNull
    public String toString() {
        return "RoleToMemberListModel(roleIdToMemberListModel.size=" + g().size() + ", users.size=" + this.memberTinyIds.size() + ")";
    }
}
