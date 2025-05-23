package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import java.util.List;
import jy1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wh2.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0007B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\u000e\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/v;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/GuildBaseBindPermissionMemberStrategy;", "", "count", "", "isForce", "", "a", "", "", "userListToAdd", "userListToRemove", "Ljy1/a$a;", "callback", "g", "r", "Ljy1/a;", "l", "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", DomainData.DOMAIN_NAME, "Z", "whiteList", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;Z)V", "o", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class v extends GuildBaseBindPermissionMemberStrategy {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jy1.a viewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRoleMemberParamData param;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final boolean whiteList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param, boolean z16) {
        super(viewModel, param);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
        this.viewModel = viewModel;
        this.param = param;
        this.whiteList = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(v this$0, int i3, String str, int i16, boolean z16, byte[] bArr, List memberList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        this$0.k(false);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.rg..GuildChannelSpeakRuleStrategy", 1, "fetchUserData white:" + this$0.whiteList + " " + i3 + " " + str + " total=" + i16 + " isEnd=" + z16 + " size=" + memberList.size());
        }
        if (i3 != 0) {
            this$0.viewModel.d2(i3, str);
            return;
        }
        this$0.i(bArr);
        this$0.j(z16);
        this$0.l(i16);
        this$0.viewModel.u2(memberList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(a.InterfaceC10621a callback, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.rg..GuildChannelSpeakRuleStrategy", 1, "modifyUserData code=" + i3 + " msg=" + str + " sec=" + iGProSecurityResult);
        }
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            callback.onSuccess();
        } else {
            callback.a(ri1.a.c(i3, str, iGProSecurityResult));
        }
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as
    public void a(int count, boolean isForce) {
        byte[] bArr;
        k(true);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        String guildId = this.param.getGuildId();
        boolean z16 = this.whiteList;
        if (getCookie() != null) {
            Object cookie = getCookie();
            Intrinsics.checkNotNull(cookie, "null cannot be cast to non-null type kotlin.ByteArray");
            bArr = (byte[]) cookie;
        } else {
            bArr = new byte[0];
        }
        iGPSService.fetchGuildSpeakableMemberList(guildId, z16, bArr, new xh2.p() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.t
            @Override // xh2.p
            public final void a(int i3, String str, int i16, boolean z17, byte[] bArr2, List list) {
                v.w(v.this, i3, str, i16, z17, bArr2, list);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as
    public void g(@NotNull List<String> userListToAdd, @NotNull List<String> userListToRemove, @NotNull final a.InterfaceC10621a callback) {
        Intrinsics.checkNotNullParameter(userListToAdd, "userListToAdd");
        Intrinsics.checkNotNullParameter(userListToRemove, "userListToRemove");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IGPSService) ch.R0(IGPSService.class)).modifyGuildSpeakableMemberList(this.param.getGuildId(), userListToAdd, userListToRemove, new dv() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.u
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                v.x(a.InterfaceC10621a.this, i3, str, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildBaseBindPermissionMemberStrategy
    public int r() {
        if (this.whiteList) {
            return GProGuildMemberSearchSourceId.GUILD_SPEAK_RULE_UNRESTRICTED_MEMBER.ordinal();
        }
        return GProGuildMemberSearchSourceId.ADD_GUILD_SPEAK_RULE_UNRESTRICTED_MEMBER.ordinal();
    }
}
