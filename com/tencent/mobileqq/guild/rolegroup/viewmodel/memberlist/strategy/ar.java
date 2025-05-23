package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildMemberSearchSourceId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/ar;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/GuildBaseBindPermissionMemberStrategy;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProRoleMemberListInfo;", "roleList", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "v", "", "count", "", "isForce", "", "a", "r", "Ljy1/a;", "l", "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", DomainData.DOMAIN_NAME, "Ljava/util/HashSet;", "mLoadedUserSet", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;)V", "o", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ar extends GuildBaseBindPermissionMemberStrategy {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jy1.a viewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRoleMemberParamData param;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<String> mLoadedUserSet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param) {
        super(viewModel, param);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
        this.viewModel = viewModel;
        this.param = param;
        this.mLoadedUserSet = new HashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ar this$0, int i3, String str, boolean z16, int i16, List roleList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(false);
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.rg..GuildViewChannelMemberWithRoleStrategy", 1, "fetchUnlivableUser " + i3 + ", " + str + ", " + z16 + ", " + i16);
        }
        if (i3 != 0) {
            this$0.viewModel.d2(i3, str);
            return;
        }
        this$0.l(i16);
        this$0.j(!z16);
        jy1.a aVar = this$0.viewModel;
        Intrinsics.checkNotNullExpressionValue(roleList, "roleList");
        aVar.t2(this$0.v(roleList));
    }

    private final List<IGProUserInfo> v(List<? extends IGProRoleMemberListInfo> roleList) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends IGProRoleMemberListInfo> it = roleList.iterator();
        while (it.hasNext()) {
            for (IGProUserInfo userInfo : it.next().getMemberList()) {
                if (!this.mLoadedUserSet.contains(userInfo.getTinyId()) && userInfo.getRobotType() == 0) {
                    Intrinsics.checkNotNullExpressionValue(userInfo, "userInfo");
                    arrayList.add(userInfo);
                    this.mLoadedUserSet.add(userInfo.getTinyId());
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as
    public void a(int count, boolean isForce) {
        k(true);
        ((IGPSService) ch.R0(IGPSService.class)).fetchMemberListWithRole(this.param.getGuildId(), this.param.getSubChannelId(), count, isForce, new vh2.ai() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.aq
            @Override // vh2.ai
            public final void a(int i3, String str, boolean z16, int i16, List list) {
                ar.u(ar.this, i3, str, z16, i16, list);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildBaseBindPermissionMemberStrategy
    public int r() {
        return GProGuildMemberSearchSourceId.CHANNEL_VISIBLE_MEMBER.ordinal();
    }
}
