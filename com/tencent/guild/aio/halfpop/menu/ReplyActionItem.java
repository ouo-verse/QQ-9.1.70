package com.tencent.guild.aio.halfpop.menu;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.api.ark.IGuildArkApi;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/ReplyActionItem;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "", "I", "H", "K", "M", "isC2C", "O", "L", "N", "Lcom/tencent/common/app/AppInterface;", "J", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "t", "Landroid/view/View;", "view", "", UserInfo.SEX_FEMALE, "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "itemData", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/t$a;)V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class ReplyActionItem extends t {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyActionItem(@NotNull t.ItemData itemData) {
        super(itemData);
        Intrinsics.checkNotNullParameter(itemData, "itemData");
    }

    private final boolean H() {
        IGuildInfoUtilsApi iGuildInfoUtilsApi = (IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class);
        AppInterface J = J();
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = h().g();
        Intrinsics.checkNotNullExpressionValue(g18, "aioContext.aioParam");
        return iGuildInfoUtilsApi.canTalkinChannel(J, g17, com.tencent.guild.aio.util.a.b(g18));
    }

    private final boolean I() {
        ArkElement arkElement;
        Intrinsics.checkNotNullExpressionValue(i().getMsgRecord().elements, "data.msgRecord.elements");
        if (!(!r0.isEmpty()) || (arkElement = i().getMsgRecord().elements.get(0).arkElement) == null) {
            return false;
        }
        com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
        String str = arkElement.bytesData;
        Intrinsics.checkNotNullExpressionValue(str, "arkElement.bytesData");
        if (aVar.o(str)) {
            return ((IGuildArkApi) QRoute.api(IGuildArkApi.class)).canReply(aVar.d(), aVar.e(), aVar.f());
        }
        return false;
    }

    private final AppInterface J() {
        AppInterface appInterface = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface();
        Intrinsics.checkNotNullExpressionValue(appInterface, "api(IQQGuildUtilApi::class.java).appInterface()");
        return appInterface;
    }

    private final boolean K() {
        return com.tencent.guild.aio.util.ex.a.h(h());
    }

    private final boolean L() {
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        AIOParam g17 = h().g();
        Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
        if (!iGuildChannelApi.isNeedRealNameForGuest(b16, com.tencent.guild.aio.util.a.g(g17))) {
            return false;
        }
        return !((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isFaceAuthVerified();
    }

    private final boolean M() {
        IGuildInfoUtilsApi iGuildInfoUtilsApi = (IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class);
        AppInterface J = J();
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        return iGuildInfoUtilsApi.isHomePage(J, com.tencent.guild.aio.util.a.b(g16));
    }

    private final boolean N() {
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = h().g();
        Intrinsics.checkNotNullExpressionValue(g18, "aioContext.aioParam");
        int a16 = fo0.h.a(g17, com.tencent.guild.aio.util.a.b(g18));
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(h().g(), "aioContext.aioParam");
        return !companion.d(a16, com.tencent.guild.aio.util.a.g(r3));
    }

    private final boolean O(boolean isC2C) {
        if (isC2C) {
            return ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).isLimitingInC2C(com.tencent.guild.aio.util.ex.a.f(h()));
        }
        IGuildSpeakThresholdApi iGuildSpeakThresholdApi = (IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class);
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = h().g();
        Intrinsics.checkNotNullExpressionValue(g18, "aioContext.aioParam");
        return iGuildSpeakThresholdApi.isLimitingInChannel(g17, com.tencent.guild.aio.util.a.b(g18));
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("ReplyActionItem", 4, "onItemClick");
        j().Xg(new Function0<Unit>() { // from class: com.tencent.guild.aio.halfpop.menu.ReplyActionItem$onItemClick$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QLog.i("ReplyActionItem", 4, "trigger reply");
            }
        });
        h().e().h(new GuildMsgSendEvent.MsgOnClickReplyEvent(data));
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull GuildMsgItem data) {
        boolean z16;
        boolean z17;
        boolean O;
        Intrinsics.checkNotNullParameter(data, "data");
        if (C()) {
            return false;
        }
        boolean d16 = qr0.d.d(data);
        if (d16 && !I()) {
            QLog.i("ReplyActionItem", 1, "isArkMsg, and canReply=false");
            return false;
        }
        boolean H = H();
        boolean M = M();
        boolean K = K();
        if (!K && !H) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!K && N()) {
            z17 = true;
        } else {
            z17 = false;
        }
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        AIOParam g17 = h().g();
        Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
        boolean isSelfGuest = iGuildChannelApi.isSelfGuest(b16, com.tencent.guild.aio.util.a.g(g17));
        if (isSelfGuest) {
            O = L();
        } else {
            O = O(K);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ReplyActionItem", 2, "canTalk=" + H + " isHomeChannel=" + M + " isDirectMsg=" + K + " isMuting=" + z17 + " isGuest=" + isSelfGuest + " isSpeakThresholdLimiting=" + O + " isArkMsg=" + d16);
        }
        if (!M && !z16 && !z17 && !O) {
            if (MsgExtKt.U(data.getMsgRecord()) && G()) {
                return true;
            }
            QLog.i("ReplyActionItem", 4, "isSendSuccess=false");
        }
        return false;
    }
}
