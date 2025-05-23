package com.tencent.mobileqq.guild.rolegroup.model.repositories;

import com.tencent.mobileqq.guild.rolegroup.model.data.GuildTarget;
import com.tencent.mobileqq.guild.rolegroup.model.data.Permissions;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupListModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0002\u001a\u00020\u0001H\u0007J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J'\u0010\r\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J'\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0096\u0001J-\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00140\u0007H\u0096\u0001J%\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00140\u0007H\u0096\u0001J\u001f\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0096\u0001J\u001f\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u0019\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0096\u0001J\u0019\u0010!\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\u0013\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0001J-\u0010$\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00140\u0007H\u0096\u0001J;\u0010(\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J;\u0010+\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J;\u0010,\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001JC\u0010-\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00032\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J/\u0010.\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J-\u00100\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/r;", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "p", "", "guildId", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "roleGroup", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "callback", "", "i", "roleGroupId", "o", "whiteList", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;", "k", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/d;", "guildTarget", "tinyId", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/a;", "target", "c", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/c;", "fetchParam", tl.h.F, "g", "categoryId", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/c;", "getCategoryPermission", "channelId", "getChannelPermission", "getGuildPermission", "e", "f", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/b;", "addChannels", "removeChannels", "d", "addRoles", "removeRoles", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "l", "a", "roleGroupIds", "j", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class r implements IRoleGroupListRepository {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final r f232798e = new r();

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ IRoleGroupListRepository f232799d = s.a();

    r() {
    }

    @JvmStatic
    @NotNull
    public static final IRoleGroupListRepository p() {
        return f232798e;
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void a(@NotNull String guildId, @NotNull String roleGroupId, @NotNull RoleGroupModel roleGroup, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleGroupId, "roleGroupId");
        Intrinsics.checkNotNullParameter(roleGroup, "roleGroup");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.a(guildId, roleGroupId, roleGroup, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void b(@NotNull ChannelPermissionTarget target, @NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(addRoles, "addRoles");
        Intrinsics.checkNotNullParameter(removeRoles, "removeRoles");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.b(target, addRoles, removeRoles, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void c(@NotNull ChannelPermissionTarget target, @NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.c(target, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void d(@NotNull ChannelPermissionTargetForRole target, @NotNull List<String> addChannels, @NotNull List<String> removeChannels, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(addChannels, "addChannels");
        Intrinsics.checkNotNullParameter(removeChannels, "removeChannels");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.d(target, addChannels, removeChannels, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    @Nullable
    public RoleGroupModel e(@NotNull FetchRoleGroupParam fetchParam) {
        Intrinsics.checkNotNullParameter(fetchParam, "fetchParam");
        return this.f232799d.e(fetchParam);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void f(@NotNull String guildId, @NotNull String tinyId, @NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.f(guildId, tinyId, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void g(@NotNull FetchRoleGroupParam fetchParam, @NotNull com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> callback) {
        Intrinsics.checkNotNullParameter(fetchParam, "fetchParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.g(fetchParam, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    @NotNull
    public Permissions getCategoryPermission(@NotNull String guildId, @NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        return this.f232799d.getCategoryPermission(guildId, categoryId);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    @NotNull
    public Permissions getChannelPermission(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return this.f232799d.getChannelPermission(guildId, channelId);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    @NotNull
    public Permissions getGuildPermission(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return this.f232799d.getGuildPermission(guildId);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void h(@NotNull FetchRoleGroupParam fetchParam, @NotNull com.tencent.mobileqq.guild.base.repository.h<RoleGroupListModel> callback) {
        Intrinsics.checkNotNullParameter(fetchParam, "fetchParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.h(fetchParam, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void i(@NotNull String guildId, @NotNull RoleGroupModel roleGroup, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleGroup, "roleGroup");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.i(guildId, roleGroup, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void j(@NotNull String guildId, @NotNull List<String> roleGroupIds, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleGroupIds, "roleGroupIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.j(guildId, roleGroupIds, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void k(@NotNull String guildId, boolean whiteList, @NotNull com.tencent.mobileqq.guild.base.repository.h<RoleGroupListModel> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.k(guildId, whiteList, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void l(@NotNull GuildTarget guildTarget, @NotNull String tinyId, @NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(guildTarget, "guildTarget");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(addRoles, "addRoles");
        Intrinsics.checkNotNullParameter(removeRoles, "removeRoles");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.l(guildTarget, tinyId, addRoles, removeRoles, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void m(@NotNull String guildId, @NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(addRoles, "addRoles");
        Intrinsics.checkNotNullParameter(removeRoles, "removeRoles");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.m(guildId, addRoles, removeRoles, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void n(@NotNull GuildTarget guildTarget, @NotNull String tinyId, @NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback) {
        Intrinsics.checkNotNullParameter(guildTarget, "guildTarget");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.n(guildTarget, tinyId, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void o(@NotNull String guildId, @NotNull String roleGroupId, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleGroupId, "roleGroupId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f232799d.o(guildId, roleGroupId, callback);
    }
}
