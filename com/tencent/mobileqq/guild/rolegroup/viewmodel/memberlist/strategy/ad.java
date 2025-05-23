package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/ad;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/q;", "", "count", "", "isForce", "", "a", "r", "Ljy1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ad extends q {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jy1.a viewModel;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRoleMemberParamData param;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param) {
        super(viewModel, param, null);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
        this.viewModel = viewModel;
        this.param = param;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ad this$0, int i3, String str, int i16, boolean z16, byte[] bArr, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(false);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.rg..GuildBaseBindPermissionMemberStrategy", 1, "fetchCanEditMapUser " + i3 + ", " + str + ", " + i16 + ", " + z16 + ", " + bArr + ", " + arrayList);
        }
        if (i3 != 0) {
            this$0.viewModel.d2(i3, str);
            return;
        }
        this$0.i(bArr);
        this$0.j(z16);
        this$0.viewModel.t2(arrayList);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as
    public void a(int count, boolean isForce) {
        byte[] bArr;
        k(true);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        String guildId = this.param.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "param.guildId");
        long parseLong = Long.parseLong(guildId);
        String subChannelId = this.param.getSubChannelId();
        Intrinsics.checkNotNullExpressionValue(subChannelId, "param.subChannelId");
        long parseLong2 = Long.parseLong(subChannelId);
        if (getCookie() != null) {
            Object cookie = getCookie();
            Intrinsics.checkNotNull(cookie, "null cannot be cast to non-null type kotlin.ByteArray");
            bArr = (byte[]) cookie;
        } else {
            bArr = new byte[0];
        }
        iGPSService.fetchChannelAuthControlMemberList(parseLong, parseLong2, count, bArr, 5, new wh2.ag() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.ac
            @Override // wh2.ag
            public final void onFetchChannelAbleMemberList(int i3, String str, int i16, boolean z16, byte[] bArr2, ArrayList arrayList) {
                ad.w(ad.this, i3, str, i16, z16, bArr2, arrayList);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildBaseBindPermissionMemberStrategy
    public int r() {
        return GProGuildMemberSearchSourceId.CHANNEL_ACTIVITY_SETTING_MEMBER.ordinal();
    }
}
