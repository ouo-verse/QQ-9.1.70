package com.tencent.troopguild.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildAIOApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.troopguild.api.ITroopGuildMsgApi;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/troopguild/api/impl/TroopGuildMsgApiImpl;", "Lcom/tencent/troopguild/api/ITroopGuildMsgApi;", "Lcom/tencent/imcore/message/Message;", "msg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGuildNotifyInfo;", "notifyInfo", "", "saveTroopGuildPushMsgInfo", "", "isTroopGuildPushMsg", "", "pushType", "setPushPlace", "Landroid/content/Context;", "ctx", "Landroid/content/Intent;", "getTroopGuildPushMsgIntent", "<init>", "()V", "Companion", "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TroopGuildMsgApiImpl implements ITroopGuildMsgApi {

    @NotNull
    private static final String TAG = "TroopGuildMsgApiImpl";

    @Override // com.tencent.troopguild.api.ITroopGuildMsgApi
    @NotNull
    public Intent getTroopGuildPushMsgIntent(@NotNull Context ctx, @NotNull Message msg2) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ITroopGuildAIOApi iTroopGuildAIOApi = (ITroopGuildAIOApi) QRoute.api(ITroopGuildAIOApi.class);
        String str = msg2.frienduin;
        Intrinsics.checkNotNullExpressionValue(str, "msg.frienduin");
        Bundle bundle = new Bundle();
        bundle.putInt("key_source_from", 2);
        bundle.putString("key_guild_id", wo4.a.b(msg2));
        bundle.putString("key_channel_id", wo4.a.a(msg2));
        bundle.putString("key_troop_id", msg2.frienduin);
        bundle.putBoolean("selectGuildContainer", true);
        bundle.putBoolean("key_launched", false);
        Object obj = msg2.extObj;
        if (obj instanceof Serializable) {
            serializable = (Serializable) obj;
        } else {
            serializable = null;
        }
        bundle.putSerializable("PushMsgreportData", serializable);
        Unit unit = Unit.INSTANCE;
        return iTroopGuildAIOApi.getJumpToTroopGuildIntent(ctx, str, bundle);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildMsgApi
    public boolean isTroopGuildPushMsg(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return wo4.a.e(msg2);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildMsgApi
    public void saveTroopGuildPushMsgInfo(@NotNull Message msg2, @NotNull GroupGuildNotifyInfo notifyInfo) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
        String str = msg2.frienduin;
        Intrinsics.checkNotNullExpressionValue(str, "msg.frienduin");
        String str2 = notifyInfo.peer.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "notifyInfo.peer.guildId");
        msg2.extObj = new ITroopGuildMsgApi.MsgPushInfo(str, str2, String.valueOf(notifyInfo.channelId), notifyInfo.summary.oper.ordinal(), 0, 16, null);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildMsgApi
    public void setPushPlace(@NotNull Message msg2, int pushType) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        wo4.a.f(msg2, pushType);
    }
}
