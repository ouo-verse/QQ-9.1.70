package com.tencent.guild.aio.halfpop.menu;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.GuildSpeakParamsInfo;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.msg.MsgExtKt;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0011\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/z;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "", "J", "", "result", "", "I", QzoneIPCModule.RESULT_CODE, "L", "t", "Landroid/view/View;", "view", UserInfo.SEX_FEMALE, "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "itemData", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/t$a;)V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class z extends t {
    public z() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void I(int result) {
        switch (result) {
            case 200501:
            case 200502:
            case 200503:
                QQToast.makeText(v(), 1, R.string.f152681a2, 0).show();
                return;
            default:
                return;
        }
    }

    private final boolean J(GuildMsgItem data) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        int i3;
        String str = data.getMsgRecord().guildId;
        String str2 = data.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "data.msgRecord.channelId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProChannelInfo iGProChannelInfo = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProChannelInfo = iGPSService.getChannelInfo(str2);
        }
        if (iGProChannelInfo == null) {
            QLog.w("RecallActionItem", 1, "canShown, channelInfo is null, channel:" + str2);
            return ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isGuildOrChannelManager(str, str2);
        }
        if (iGProChannelInfo.getType() == 1) {
            i3 = 30001;
        } else if (iGProChannelInfo.getType() == 5) {
            i3 = 30004;
        } else if (iGProChannelInfo.getType() == 2) {
            i3 = 30003;
        } else if (iGProChannelInfo.getType() == 6) {
            i3 = 30006;
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return false;
        }
        Boolean hasTargetSecondaryPermission = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).hasTargetSecondaryPermission(i3, str, str2);
        Intrinsics.checkNotNullExpressionValue(hasTargetSecondaryPermission, "api(IQQGuildUtilApi::cla\u2026Type, guildId, channelId)");
        return hasTargetSecondaryPermission.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(GuildMsgItem data, z this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RecallActionItem", 4, "recall peerUid = " + data.getMsgRecord().peerUid + " msgId = " + data.getMsgRecord().msgId + "  msgSeq = " + data.getMsgRecord().msgSeq + " resultCode=" + i3 + " errorMsg=" + str);
        this$0.I(i3);
        this$0.L(data, i3);
    }

    private final void L(GuildMsgItem data, int resultCode) {
        if (!com.tencent.guild.aio.util.y.b(resultCode)) {
            Logger.f235387a.d().i("RecallActionItem", 1, "[onRecallMsg] not success");
            return;
        }
        IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
        String str = data.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "data.msgRecord.guildId");
        iQQGuildRouterApi.onRecallMsg(new GuildSpeakParamsInfo(str, data.getMsgRecord().channelId, null, 7), data.getMsgRecord().guildId, data.getMsgRecord().senderUid, R.string.f152691a3);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull final GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.b(view, data);
        QLog.i("RecallActionItem", 4, "onItemClick");
        GProContact gProContact = new GProContact(data.getMsgRecord().chatType, data.getMsgRecord().peerUid, data.getMsgRecord().guildId);
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.E(gProContact, data.getMsgId(), new IGuildOperateCallback() { // from class: com.tencent.guild.aio.halfpop.menu.y
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    z.K(GuildMsgItem.this, this, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.isWalletMsg()) {
            QLog.i("RecallActionItem", 1, "isWalletMsg");
            return false;
        }
        if (data.getMsgRecord().msgType == 1) {
            QLog.i("RecallActionItem", 1, "msgType == 1");
            return false;
        }
        boolean J = J(data);
        boolean z16 = !MsgExtKt.R(data.getMsgRecord());
        boolean isSelf = data.isSelf();
        if (!z16 && ((isSelf || J) && D())) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecallActionItem", 2, "canShown. isLocalOnly: " + z16 + ", isSelf: " + isSelf + ", canRevoke: " + J);
        }
        return false;
    }

    public /* synthetic */ z(t.ItemData itemData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new t.ItemData(R.drawable.qui_recall, R.string.f1649727_) : itemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@NotNull t.ItemData itemData) {
        super(itemData);
        Intrinsics.checkNotNullParameter(itemData, "itemData");
    }
}
