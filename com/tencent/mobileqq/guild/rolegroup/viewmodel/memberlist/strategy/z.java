package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import jy1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vh2.cd;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0019\b\u0004\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J,\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/z;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/GuildBaseBindPermissionMemberStrategy;", "", "", "userListToAdd", "userListToRemove", "Ljy1/a$a;", "callback", "", "g", "Ljy1/a;", "l", "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;)V", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/d;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/aj;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class z extends GuildBaseBindPermissionMemberStrategy {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jy1.a viewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRoleMemberParamData param;

    public /* synthetic */ z(jy1.a aVar, GuildRoleMemberParamData guildRoleMemberParamData, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, guildRoleMemberParamData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(a.InterfaceC10621a callback, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.rg..GuildBaseBindPermissionMemberStrategy", 1, "modifyUserData code=" + i3 + " msg=" + str + " sec=" + iGProSecurityResult);
        }
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            callback.onSuccess();
        } else {
            callback.a(ri1.a.c(i3, str, iGProSecurityResult));
        }
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as
    public void g(@NotNull List<String> userListToAdd, @NotNull List<String> userListToRemove, @NotNull final a.InterfaceC10621a callback) {
        Intrinsics.checkNotNullParameter(userListToAdd, "userListToAdd");
        Intrinsics.checkNotNullParameter(userListToRemove, "userListToRemove");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IGPSService) ch.R0(IGPSService.class)).setChannelVisibleMemberList(this.param.getGuildId(), this.param.getSubChannelId(), userListToAdd, userListToRemove, new cd() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.y
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                z.u(a.InterfaceC10621a.this, i3, str, iGProSecurityResult);
            }
        });
    }

    z(jy1.a aVar, GuildRoleMemberParamData guildRoleMemberParamData) {
        super(aVar, guildRoleMemberParamData);
        this.viewModel = aVar;
        this.param = guildRoleMemberParamData;
    }
}
