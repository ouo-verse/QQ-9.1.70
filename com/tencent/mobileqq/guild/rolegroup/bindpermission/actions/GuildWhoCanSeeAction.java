package com.tencent.mobileqq.guild.rolegroup.bindpermission.actions;

import com.tencent.mobileqq.guild.rolegroup.model.repositories.ChannelPermissionTarget;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.ChannelPermissionType;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000bH\u0016J4\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\u0014H\u0016R\u0014\u0010\u0017\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/GuildWhoCanSeeAction;", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/z;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/PermissionSwitchStatus;", "a", "type", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/w;", "callback", "", "c", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/x;", "d", "", "", "addRoles", "removeRoles", "b", "", "cookieCache", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/y;", "e", "Ljava/lang/String;", "guildId", "channelId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildWhoCanSeeAction implements z {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    public GuildWhoCanSeeAction(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        this.channelId = channelId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(w callback, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        e eVar = e.f232387a;
        ri1.a e16 = ri1.a.e(i3, str, iGProSecurityResult);
        Intrinsics.checkNotNullExpressionValue(e16, "of(result, errMsg, security)");
        eVar.a(e16, NodeProps.VISIBLE, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(x callback, ri1.a error, List list) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(error, "error");
        e.f232387a.b(error, list, NodeProps.VISIBLE, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final GuildWhoCanSeeAction this$0, final y callback, final IGPSService service, int i3, String str, int i16, boolean z16, final byte[] bArr, List memberList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(service, "$service");
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        e eVar = e.f232387a;
        ri1.a e16 = ri1.a.e(i3, str, null);
        Intrinsics.checkNotNullExpressionValue(e16, "of(result, errMsg, null)");
        eVar.c(e16, f.a(memberList, this$0.guildId), i16, z16, NodeProps.VISIBLE, callback, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.GuildWhoCanSeeAction$fetchHasPermissionUsers$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildWhoCanSeeAction.this.e(service, bArr, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(w callback, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        e eVar = e.f232387a;
        ri1.a e16 = ri1.a.e(i3, str, iGProSecurityResult);
        Intrinsics.checkNotNullExpressionValue(e16, "of(result, errMsg, security)");
        eVar.a(e16, NodeProps.VISIBLE, callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z
    @NotNull
    public PermissionSwitchStatus a(@NotNull IGPSService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        IGProChannelInfo channelInfo = service.getChannelInfo(this.channelId);
        if (channelInfo != null) {
            return aa.c(channelInfo.getVisibleType());
        }
        return PermissionSwitchStatus.TYPE_ALL;
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z
    public void b(@NotNull IGPSService service, @NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull final w callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(addRoles, "addRoles");
        Intrinsics.checkNotNullParameter(removeRoles, "removeRoles");
        Intrinsics.checkNotNullParameter(callback, "callback");
        service.setChannelVisibleRoleList(this.guildId, this.channelId, addRoles, removeRoles, new cd() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.n
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                GuildWhoCanSeeAction.m(w.this, i3, str, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z
    public void c(@NotNull IGPSService service, @NotNull PermissionSwitchStatus type, @NotNull final w callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(callback, "callback");
        service.setChannelVisible(this.guildId, this.channelId, aa.f(type), new cd() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.q
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                GuildWhoCanSeeAction.j(w.this, i3, str, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z
    public void d(@NotNull IGPSService service, @NotNull final x callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().c(new ChannelPermissionTarget(this.guildId, this.channelId, ChannelPermissionType.ViewPermission), new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.o
            @Override // com.tencent.mobileqq.guild.base.repository.h
            public final void a(ri1.a aVar, Object obj) {
                GuildWhoCanSeeAction.k(x.this, aVar, (List) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z
    public void e(@NotNull final IGPSService service, @Nullable byte[] cookieCache, @NotNull final y callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = this.guildId;
        String str2 = this.channelId;
        if (cookieCache == null) {
            cookieCache = new byte[0];
        }
        service.getChannelVisibleMemberList(str, str2, 100, cookieCache, new xh2.o() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.p
            @Override // xh2.o
            public final void a(int i3, String str3, int i16, boolean z16, byte[] bArr, List list) {
                GuildWhoCanSeeAction.l(GuildWhoCanSeeAction.this, callback, service, i3, str3, i16, z16, bArr, list);
            }
        });
    }
}
