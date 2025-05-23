package com.tencent.mobileqq.guild.message.notify;

import android.os.Handler;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.az;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.Summary;
import com.tencent.troopguild.api.ITroopGuildMsgApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "nickInfo", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildNotifyMsgRecvCB$onGroupGuildUpdate$1$1 extends Lambda implements Function1<TroopMemberNickInfo, Unit> {
    final /* synthetic */ AppRuntime $appRuntime;
    final /* synthetic */ GroupGuildNotifyInfo $notifyInfo;
    final /* synthetic */ Summary $summary;
    final /* synthetic */ GuildNotifyMsgRecvCB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildNotifyMsgRecvCB$onGroupGuildUpdate$1$1(Summary summary, GuildNotifyMsgRecvCB guildNotifyMsgRecvCB, GroupGuildNotifyInfo groupGuildNotifyInfo, AppRuntime appRuntime) {
        super(1);
        this.$summary = summary;
        this.this$0 = guildNotifyMsgRecvCB;
        this.$notifyInfo = groupGuildNotifyInfo;
        this.$appRuntime = appRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GroupGuildNotifyInfo notifyInfo, AppRuntime appRuntime, String memberName, Summary summary) {
        Intrinsics.checkNotNullParameter(notifyInfo, "$notifyInfo");
        Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
        Intrinsics.checkNotNullParameter(memberName, "$memberName");
        Message message = new Message();
        message.counter = 0;
        message.frienduin = notifyInfo.peer.peerUid;
        message.istroop = 1;
        byte[] bArr = summary.text;
        Intrinsics.checkNotNullExpressionValue(bArr, "summary.text");
        message.f203106msg = memberName + " " + new String(bArr, Charsets.UTF_8);
        message.msgtype = -1000;
        message.selfuin = appRuntime.getCurrentAccountUin();
        message.senderuin = String.valueOf(notifyInfo.senderUin);
        message.time = notifyInfo.timeStamp / ((long) 1000);
        if (notifyInfo.muteSwitch == 1) {
            az.d(true);
        } else {
            az.d(false);
        }
        ((ITroopGuildMsgApi) QRoute.api(ITroopGuildMsgApi.class)).saveTroopGuildPushMsgInfo(message, notifyInfo);
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).handleReceivedMessage(1, true, true, message, appRuntime);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
        invoke2(troopMemberNickInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
        Handler handler;
        String showName;
        byte[] bArr = this.$summary.senderRemark;
        Intrinsics.checkNotNullExpressionValue(bArr, "summary.senderRemark");
        final String str = new String(bArr, Charsets.UTF_8);
        if (troopMemberNickInfo != null && (showName = troopMemberNickInfo.getShowName()) != null) {
            str = showName;
        }
        handler = this.this$0.highPriorityHandler;
        if (handler != null) {
            final GroupGuildNotifyInfo groupGuildNotifyInfo = this.$notifyInfo;
            final AppRuntime appRuntime = this.$appRuntime;
            final Summary summary = this.$summary;
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.notify.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildNotifyMsgRecvCB$onGroupGuildUpdate$1$1.b(GroupGuildNotifyInfo.this, appRuntime, str, summary);
                }
            });
        }
    }
}
