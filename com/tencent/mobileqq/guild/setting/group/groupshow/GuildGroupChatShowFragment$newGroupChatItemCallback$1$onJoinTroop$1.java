package com.tencent.mobileqq.guild.setting.group.groupshow;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "needShow", "", "subTroopInfo", "Ltencent/trpcprotocol/TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
final class GuildGroupChatShowFragment$newGroupChatItemCallback$1$onJoinTroop$1 extends Lambda implements Function2<Boolean, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit> {
    final /* synthetic */ String $groupCode;
    final /* synthetic */ String $groupName;
    final /* synthetic */ Dialog $loadingDialog;
    final /* synthetic */ String $signature;
    final /* synthetic */ GuildGroupChatShowFragment this$0;
    final /* synthetic */ GuildGroupChatShowFragment$newGroupChatItemCallback$1 this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGroupChatShowFragment$newGroupChatItemCallback$1$onJoinTroop$1(Dialog dialog, GuildGroupChatShowFragment guildGroupChatShowFragment, String str, String str2, GuildGroupChatShowFragment$newGroupChatItemCallback$1 guildGroupChatShowFragment$newGroupChatItemCallback$1, String str3) {
        super(2);
        this.$loadingDialog = dialog;
        this.this$0 = guildGroupChatShowFragment;
        this.$groupCode = str;
        this.$signature = str2;
        this.this$1 = guildGroupChatShowFragment$newGroupChatItemCallback$1;
        this.$groupName = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildGroupChatShowFragment$newGroupChatItemCallback$1 this$0, String groupCode, String groupName, String troopUin, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(groupCode, "$groupCode");
        Intrinsics.checkNotNullParameter(groupName, "$groupName");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Logger.f235387a.d().i("GuildGroupChatShowFragment", 1, "joinTroop: " + troopUin + ", " + i3);
        if (i3 == 1) {
            this$0.b(groupCode, groupName);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp troopJoinQunAutoSwitch$RetrieveSubGroupRsp) {
        invoke(bool.booleanValue(), troopJoinQunAutoSwitch$RetrieveSubGroupRsp);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, @NotNull TroopJoinQunAutoSwitch$RetrieveSubGroupRsp subTroopInfo) {
        Intrinsics.checkNotNullParameter(subTroopInfo, "subTroopInfo");
        this.$loadingDialog.dismiss();
        Logger logger = Logger.f235387a;
        String str = this.$groupCode;
        logger.d().i("GuildGroupChatShowFragment", 1, "needShowSubTroopWithTroopId: " + str + ", " + z16);
        if (this.this$0.getContext() == null) {
            return;
        }
        if (z16) {
            ITroopJoinApi iTroopJoinApi = (ITroopJoinApi) QRoute.api(ITroopJoinApi.class);
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            iTroopJoinApi.showSwitchSubTroop(requireContext, this.$groupCode, subTroopInfo, 1016, "pg_sgrp_channel_feed");
            return;
        }
        com.tencent.mobileqq.troop.g gVar = new com.tencent.mobileqq.troop.g();
        String str2 = this.$groupCode;
        String str3 = this.$signature;
        gVar.f296167a = str2;
        gVar.f296169c = 1016;
        gVar.f296171e = str3;
        ITroopUtilApi iTroopUtilApi = (ITroopUtilApi) QRoute.api(ITroopUtilApi.class);
        Context context = this.this$0.getContext();
        final GuildGroupChatShowFragment$newGroupChatItemCallback$1 guildGroupChatShowFragment$newGroupChatItemCallback$1 = this.this$1;
        final String str4 = this.$groupCode;
        final String str5 = this.$groupName;
        iTroopUtilApi.joinTroop(context, gVar, new com.tencent.mobileqq.troop.f() { // from class: com.tencent.mobileqq.guild.setting.group.groupshow.f
            @Override // com.tencent.mobileqq.troop.f
            public final void a(String str6, int i3) {
                GuildGroupChatShowFragment$newGroupChatItemCallback$1$onJoinTroop$1.b(GuildGroupChatShowFragment$newGroupChatItemCallback$1.this, str4, str5, str6, i3);
            }
        });
    }
}
