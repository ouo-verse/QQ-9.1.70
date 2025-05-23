package com.tencent.mobileqq.guild.message.notify;

import android.os.Handler;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.notify.api.IGuildNotify;
import com.tencent.mobileqq.guild.message.s;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FirstViewGroupGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.Summary;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.b;
import com.tencent.qqnt.msg.data.h;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.troopguild.api.ITroopGuildInfoService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.group_pro_proto.common.common$Msg;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/message/notify/GuildNotifyMsgRecvCB;", "Lcom/tencent/qqnt/msg/api/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGuildNotifyInfo;", "notifyInfo", "", "e", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onRecvMsg", "", "byteArray", "b", "onGroupGuildUpdate", "Lcom/tencent/mobileqq/guild/base/a;", "Lcom/tencent/mobileqq/guild/message/api/IGuildMsgFactory;", "a", "Lcom/tencent/mobileqq/guild/base/a;", "guildMsgFactory", "Landroid/os/Handler;", "Landroid/os/Handler;", "highPriorityHandler", "<init>", "()V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildNotifyMsgRecvCB implements com.tencent.qqnt.msg.api.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.base.a<IGuildMsgFactory> guildMsgFactory = new GuildNotifyMsgRecvCB$special$$inlined$newAccountAwareServiceHolder$1(new Function1<IGuildMsgFactory, Unit>() { // from class: com.tencent.mobileqq.guild.message.notify.GuildNotifyMsgRecvCB$guildMsgFactory$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IGuildMsgFactory iGuildMsgFactory) {
            invoke2(iGuildMsgFactory);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull IGuildMsgFactory newAccountAwareServiceHolder) {
            Intrinsics.checkNotNullParameter(newAccountAwareServiceHolder, "$this$newAccountAwareServiceHolder");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildNotifyMsgRecvCB", 2, "onCreate " + newAccountAwareServiceHolder);
            }
        }
    }, new Function1<IGuildMsgFactory, Unit>() { // from class: com.tencent.mobileqq.guild.message.notify.GuildNotifyMsgRecvCB$guildMsgFactory$3
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IGuildMsgFactory iGuildMsgFactory) {
            invoke2(iGuildMsgFactory);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull IGuildMsgFactory newAccountAwareServiceHolder) {
            Intrinsics.checkNotNullParameter(newAccountAwareServiceHolder, "$this$newAccountAwareServiceHolder");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildNotifyMsgRecvCB", 2, "onDestroy " + newAccountAwareServiceHolder);
            }
        }
    });

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Handler highPriorityHandler;

    public GuildNotifyMsgRecvCB() {
        Logger.f235387a.d().i("GuildNotifyMsgRecvCB", 1, "GuildNotifyMsgRecvCB init");
    }

    private final boolean e(GroupGuildNotifyInfo notifyInfo) {
        boolean z16;
        boolean z17;
        TroopInfo troopInfo;
        ITroopGuildInfoService iTroopGuildInfoService;
        ITroopInfoService iTroopInfoService;
        String str = notifyInfo.peer.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "notifyInfo.peer.peerUid");
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            String str2 = notifyInfo.peer.guildId;
            Intrinsics.checkNotNullExpressionValue(str2, "notifyInfo.peer.guildId");
            if (str2.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17 && notifyInfo.channelId != 0) {
                String troopUin = notifyInfo.peer.peerUid;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null && (iTroopInfoService = (ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")) != null) {
                    troopInfo = iTroopInfoService.findTroopInfo(troopUin);
                } else {
                    troopInfo = null;
                }
                if (troopInfo == null) {
                    QLog.i("GuildNotifyMsgRecvCB", 1, "checkNotifyInfoParam troopUin:" + troopUin + " troopInfo == null");
                    return false;
                }
                AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime2 != null && (iTroopGuildInfoService = (ITroopGuildInfoService) peekAppRuntime2.getRuntimeService(ITroopGuildInfoService.class, "")) != null) {
                    Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                    String str3 = notifyInfo.peer.guildId;
                    Intrinsics.checkNotNullExpressionValue(str3, "notifyInfo.peer.guildId");
                    iTroopGuildInfoService.verifyTroopInfoGuildId(troopUin, str3);
                }
                return true;
            }
        }
        Contact contact = notifyInfo.peer;
        QLog.i("GuildNotifyMsgRecvCB", 1, "checkNotifyInfoParam troopUin:" + contact.peerUid + " guildId:" + contact.guildId + " channelId:" + notifyInfo.channelId);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(GuildNotifyMsgRecvCB this$0, GroupGuildNotifyInfo notifyInfo) {
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(notifyInfo, "$notifyInfo");
        if (!this$0.e(notifyInfo) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        Summary summary = notifyInfo.summary;
        QLog.i("GuildNotifyMsgRecvCB", 1, "checkNotifyInfoParam notifyInfo:" + notifyInfo);
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(notifyInfo.peer.peerUid, String.valueOf(notifyInfo.senderUin), "GuildNotifyMsgRecvCB", new GuildNotifyMsgRecvCB$onGroupGuildUpdate$1$1(summary, this$0, notifyInfo, peekAppRuntime));
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void a(@NotNull h hVar) {
        b.a.h(this, hVar);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void b(@NotNull byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        common$Msg common_msg = new common$Msg();
        common_msg.mergeFrom(byteArray);
        this.guildMsgFactory.getValue().getMessageProcessor(7).a(common_msg, Integer.valueOf(s.f230790e));
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onFirstViewGroupGuildMapping(@NotNull ArrayList<FirstViewGroupGuildInfo> arrayList) {
        b.a.a(this, arrayList);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGroupGuildUpdate(@NotNull final GroupGuildNotifyInfo notifyInfo) {
        Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
        if (this.highPriorityHandler == null) {
            this.highPriorityHandler = new Handler(ThreadManagerV2.getMSFHighPriorityThread().getLooper());
        }
        Handler handler = this.highPriorityHandler;
        Intrinsics.checkNotNull(handler);
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.notify.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildNotifyMsgRecvCB.f(GuildNotifyMsgRecvCB.this, notifyInfo);
            }
        });
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGuildMsgAbFlagChanged(@NotNull GuildMsgAbFlag guildMsgAbFlag) {
        b.a.c(this, guildMsgAbFlag);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvGroupGuildFlag(int i3) {
        b.a.d(this, i3);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvMsg(@NotNull ArrayList<MsgRecord> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGuildNotify.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IGuildNotify iGuildNotify = (IGuildNotify) runtimeService;
        for (MsgRecord msgRecord : msgList) {
            if (msgRecord.isOnlineMsg && msgRecord.chatType == 4) {
                iGuildNotify.handleNotifyGuildMessage(msgRecord);
            }
        }
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvUDCFlag(int i3) {
        b.a.f(this, i3);
    }
}
