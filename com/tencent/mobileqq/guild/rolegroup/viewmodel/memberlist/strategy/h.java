package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/h;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/x;", "", "count", "", "isForce", "", "a", "r", "Ljy1/a;", DomainData.DOMAIN_NAME, "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "o", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class h extends x {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jy1.a viewModel;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRoleMemberParamData param;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param) {
        super(viewModel, param, null);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
        this.viewModel = viewModel;
        this.param = param;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(h this$0, int i3, String str, boolean z16, byte[] bArr, List memberList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        this$0.k(false);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.rg..GuildBaseBindPermissionMemberStrategy", 1, "fetchUnspeakableUser " + i3 + ", " + str + ", " + z16 + ", " + bArr + ", " + memberList);
        }
        if (i3 != 0) {
            this$0.viewModel.d2(i3, str);
            return;
        }
        this$0.i(bArr);
        this$0.j(z16);
        this$0.viewModel.t2(memberList);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as
    public void a(int count, boolean isForce) {
        byte[] bArr;
        k(true);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        String guildId = this.param.getGuildId();
        String subChannelId = this.param.getSubChannelId();
        if (getCookie() != null) {
            Object cookie = getCookie();
            Intrinsics.checkNotNull(cookie, "null cannot be cast to non-null type kotlin.ByteArray");
            bArr = (byte[]) cookie;
        } else {
            bArr = new byte[0];
        }
        iGPSService.getChannelUnspeakableMemberList(guildId, subChannelId, count, bArr, new xh2.l() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.g
            @Override // xh2.l
            public final void a(int i3, String str, boolean z16, byte[] bArr2, List list) {
                h.w(h.this, i3, str, z16, bArr2, list);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildBaseBindPermissionMemberStrategy
    public int r() {
        return GProGuildMemberSearchSourceId.ADD_CHANNEL_SPEAK_SETTING_MEMBER.ordinal();
    }
}
