package com.tencent.guild.aio.msglist.holder.component;

import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.msglist.holder.component.GuildBubbleAvatarComponent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/f;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lcom/tencent/guild/aio/msglist/holder/component/g;", "intent", "", "l", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "o", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lol3/b;", "handleIntent", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f extends t {
    /* JADX WARN: Multi-variable type inference failed */
    private final void l(g intent) {
        intent.b(new GuildBubbleAvatarComponent.ViewStyle(o((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(GuildMsgItem msgItem) {
        zo0.a b16;
        IGuildInfoUtilsApi iGuildInfoUtilsApi = (IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        boolean canTalkinChannel = iGuildInfoUtilsApi.canTalkinChannel(peekAppRuntime, g17, com.tencent.guild.aio.util.a.b(g18));
        IGPSService iGPSService = (IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        AIOParam g19 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g19, "mContext.aioParam");
        boolean isGuest = iGPSService.isGuest(com.tencent.guild.aio.util.a.g(g19));
        if (canTalkinChannel && isGuest) {
            QLog.i(FrameworkVM.TAG, 1, "canTalk && isGuest");
            return;
        }
        if (canTalkinChannel) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildBubbleAvatarLongClickEvent(msgItem));
            if (msgItem.getMsgRecord().fromAppid == GuildMsgItem.ROBOT_MSG_FLAG && (b16 = ap0.f.b(((com.tencent.aio.api.runtime.a) getMContext()).g().n())) != null) {
                b16.c(msgItem.getMsgRecord().senderUid);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(GuildMsgItem msgItem) {
        int i3;
        boolean z16;
        QLog.i(FrameworkVM.TAG, 1, "handleOnAvatarClick");
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        IGProChannelInfo c16 = com.tencent.guild.aio.util.a.c(g16);
        if (c16 != null) {
            i3 = c16.getType();
        } else {
            i3 = 1;
        }
        int i16 = 2;
        if (i3 == 2) {
            FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
            if (activity != null) {
                com.tencent.guild.aio.util.h.f112401a.B(activity, msgItem);
                return;
            }
            return;
        }
        if (msgItem.getMsgRecord().directMsgFlag == 1) {
            i16 = 6;
        }
        GuildProfileData ofTextTypeData = GuildProfileData.ofTextTypeData(msgItem.getMsgRecord().guildId, msgItem.getMsgRecord().peerUid, msgItem.getMsgRecord().senderUid, i16);
        ofTextTypeData.getExtras().putInt("key_source_from", 18);
        if (msgItem.getMsgRecord().fromAppid == GuildMsgItem.ROBOT_MSG_FLAG) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ofTextTypeData.getGuildBaseProfileData().y(true);
            ofTextTypeData.getGuildBaseProfileData().r(msgItem.getMsgRecord().peerUid);
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildProfileDialog(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), ofTextTypeData);
    }

    private final boolean o(com.tencent.aio.api.runtime.a aioContext) {
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        if (!com.tencent.guild.aio.util.a.k(g16) && !com.tencent.guild.aio.util.ex.a.h(aioContext)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildBubbleAvatarLongClickIntent) {
            m(((GuildBubbleAvatarLongClickIntent) intent).getMsgItem());
            return;
        }
        if (intent instanceof GuildBubbleAvatarClickIntent) {
            n(((GuildBubbleAvatarClickIntent) intent).getMsgItem());
        } else if (intent instanceof g) {
            l((g) intent);
        } else {
            super.handleIntent(intent);
        }
    }
}
