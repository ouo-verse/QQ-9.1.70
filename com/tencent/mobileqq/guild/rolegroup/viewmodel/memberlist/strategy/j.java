package com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy;

import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/j;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/memberlist/strategy/GuildBaseModifyRoleMemberStrategy;", "", "count", "", "isForce", "", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljy1/a;", "l", "Ljy1/a;", "viewModel", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;", "param", DomainData.DOMAIN_NAME, "I", "searchSourceId", "<init>", "(Ljy1/a;Lcom/tencent/mobileqq/guild/rolegroup/fragments/memberlist/GuildRoleMemberParamData;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class j extends GuildBaseModifyRoleMemberStrategy {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jy1.a viewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRoleMemberParamData param;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int searchSourceId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull jy1.a viewModel, @NotNull GuildRoleMemberParamData param, int i3) {
        super(viewModel, param);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(param, "param");
        this.viewModel = viewModel;
        this.param = param;
        this.searchSourceId = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(j this$0, int i3, String str, boolean z16, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(false);
        if (i3 != 0) {
            this$0.viewModel.d2(i3, str);
        } else {
            this$0.j(!z16);
            this$0.viewModel.u2(list);
        }
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as
    public void a(int count, boolean isForce) {
        k(true);
        ((IGPSService) ch.R0(IGPSService.class)).fetchNonRoleMemberList(this.param.getGuildId(), this.param.getSubChannelId(), this.param.getCategoryId(), this.param.getRoleGroupId(), count, isForce, new vh2.am() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.i
            @Override // vh2.am
            public final void a(int i3, String str, boolean z16, List list) {
                j.v(j.this, i3, str, z16, list);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.GuildBaseModifyRoleMemberStrategy
    /* renamed from: q, reason: from getter */
    public int getSearchSourceId() {
        return this.searchSourceId;
    }
}
