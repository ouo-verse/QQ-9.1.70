package com.tencent.mobileqq.guild.rolegroup.model.repositories;

import com.tencent.mobileqq.guild.rolegroup.model.data.GuildTarget;
import com.tencent.mobileqq.guild.rolegroup.model.data.Permissions;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupListModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u0000 02\u00020\u0001:\u00011J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H&J&\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H&J&\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H&J.\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H&J,\u0010\u0016\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H&JB\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H&J,\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\u0004H&J,\u0010\u001e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\u0004H&J$\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00140\u0004H&J:\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H&J:\u0010&\u001a\u00020\u00072\u0006\u0010 \u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H&J\u0010\u0010(\u001a\u00020'2\u0006\u0010\r\u001a\u00020\fH&J\u0018\u0010*\u001a\u00020'2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH&J\u0018\u0010,\u001a\u00020'2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH&J&\u0010.\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J:\u0010/\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H&\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/c;", "fetchParam", "Lcom/tencent/mobileqq/guild/base/repository/h;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;", "callback", "", tl.h.F, "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "g", "e", "", "guildId", "roleGroup", "", "i", "roleGroupId", "o", "a", "", "roleGroupIds", "j", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/d;", "guildTarget", "tinyId", "addRoles", "removeRoles", "l", DomainData.DOMAIN_NAME, "f", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/a;", "target", "c", "b", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/b;", "addChannels", "removeChannels", "d", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/c;", "getGuildPermission", "channelId", "getChannelPermission", "categoryId", "getCategoryPermission", "whiteList", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j4", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface IRoleGroupListRepository {

    /* renamed from: j4, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f232724a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository$Companion;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "b", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "realInstance", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f232724a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Lazy<IRoleGroupListRepository> realInstance;

        static {
            Lazy<IRoleGroupListRepository> lazy;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<IRoleGroupListRepository>() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository$Companion$realInstance$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final IRoleGroupListRepository invoke() {
                    return new q();
                }
            });
            realInstance = lazy;
        }

        Companion() {
        }

        @NotNull
        public final IRoleGroupListRepository a() {
            return realInstance.getValue();
        }
    }

    void a(@NotNull String guildId, @NotNull String roleGroupId, @NotNull RoleGroupModel roleGroup, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback);

    void b(@NotNull ChannelPermissionTarget target, @NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback);

    void c(@NotNull ChannelPermissionTarget target, @NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback);

    void d(@NotNull ChannelPermissionTargetForRole target, @NotNull List<String> addChannels, @NotNull List<String> removeChannels, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback);

    @Nullable
    RoleGroupModel e(@NotNull FetchRoleGroupParam fetchParam);

    void f(@NotNull String guildId, @NotNull String tinyId, @NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback);

    void g(@NotNull FetchRoleGroupParam fetchParam, @NotNull com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> callback);

    @NotNull
    Permissions getCategoryPermission(@NotNull String guildId, @NotNull String categoryId);

    @NotNull
    Permissions getChannelPermission(@NotNull String guildId, @NotNull String channelId);

    @NotNull
    Permissions getGuildPermission(@NotNull String guildId);

    void h(@NotNull FetchRoleGroupParam fetchParam, @NotNull com.tencent.mobileqq.guild.base.repository.h<RoleGroupListModel> callback);

    void i(@NotNull String guildId, @NotNull RoleGroupModel roleGroup, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback);

    void j(@NotNull String guildId, @NotNull List<String> roleGroupIds, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback);

    void k(@NotNull String guildId, boolean whiteList, @NotNull com.tencent.mobileqq.guild.base.repository.h<RoleGroupListModel> callback);

    void l(@NotNull GuildTarget guildTarget, @NotNull String tinyId, @NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback);

    void m(@NotNull String guildId, @NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback);

    void n(@NotNull GuildTarget guildTarget, @NotNull String tinyId, @NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback);

    void o(@NotNull String guildId, @NotNull String roleGroupId, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback);
}
