package com.tencent.guild.aio.reserve2.busi.navigate.button.holder;

import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.reserve2.busi.navigate.button.holder.GuildAIoNavigateButtonUIState;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import qq0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001!\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u00020\u00042\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J&\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAioNavigateButtonVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "", "", "", "Lfr0/a;", "unreadCntInfo", "r", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "topMsg", "bottomMsg", "latestMsg", "o", "Lcom/tencent/aio/data/msglist/a;", "aioLastShowMsg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState$NavButtonUnreadCntText;", "d", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState$NavButtonUnreadCntText;", "navButtonUnreadCnt", "com/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAioNavigateButtonVM$b", "e", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAioNavigateButtonVM$b;", "mAction", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioNavigateButtonVM extends com.tencent.aio.base.mvvm.b<qq0.b, GuildAIoNavigateButtonUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCnt = new GuildAIoNavigateButtonUIState.NavButtonUnreadCntText();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAioNavigateButtonVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildAioNavigateButtonVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof GuildMsgListIntent.GuildMsgListScrollEvent) {
            GuildMsgListIntent.GuildMsgListScrollEvent guildMsgListScrollEvent = (GuildMsgListIntent.GuildMsgListScrollEvent) intent;
            o(guildMsgListScrollEvent.getAioTopMsg(), guildMsgListScrollEvent.getAioBottomMsg(), guildMsgListScrollEvent.getLatestAioMsg());
        } else if (intent instanceof GuildMsgListIntent.GuildInputBarHeightChangEvent) {
            updateUI(new GuildAIoNavigateButtonUIState.NavButtonPaddingBottom(((GuildMsgListIntent.GuildInputBarHeightChangEvent) intent).getHeight()));
        } else if (intent instanceof GuildMsgListIntent.GuildAioLastShowMsgLower) {
            m(((GuildMsgListIntent.GuildAioLastShowMsgLower) intent).getAioLastShowMsg());
        }
    }

    private final void m(com.tencent.aio.data.msglist.a aioLastShowMsg) {
        Long l3;
        GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCntText = this.navButtonUnreadCnt;
        navButtonUnreadCntText.i((GuildMsgItem) aioLastShowMsg, true);
        GuildMsgItem mLatestAIOMsg = this.navButtonUnreadCnt.getMLatestAIOMsg();
        Long l16 = null;
        if (mLatestAIOMsg != null) {
            l3 = Long.valueOf(mLatestAIOMsg.getMsgSeq());
        } else {
            l3 = null;
        }
        if (aioLastShowMsg != null) {
            l16 = Long.valueOf(aioLastShowMsg.getMsgSeq());
        }
        QLog.i("GuildAioNavigateButtonVM", 1, "handleGuildAioLastShowMsgLower, old seq = " + l3 + ", new seq = " + l16);
        updateUI(navButtonUnreadCntText);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r4) == false) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void o(GuildMsgItem topMsg, GuildMsgItem bottomMsg, GuildMsgItem latestMsg) {
        Long l3;
        Long l16;
        Long l17;
        Long l18;
        Long l19;
        Long l26;
        Long l27;
        GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCntText = this.navButtonUnreadCnt;
        GuildMsgItem mAIOBottomMsg = navButtonUnreadCntText.getMAIOBottomMsg();
        if (mAIOBottomMsg != null) {
            l3 = Long.valueOf(mAIOBottomMsg.getMsgSeq());
        } else {
            l3 = null;
        }
        if (bottomMsg != null) {
            l16 = Long.valueOf(bottomMsg.getMsgSeq());
        } else {
            l16 = null;
        }
        if (Intrinsics.areEqual(l3, l16)) {
            GuildMsgItem mLatestAIOMsg = navButtonUnreadCntText.getMLatestAIOMsg();
            if (mLatestAIOMsg != null) {
                l26 = Long.valueOf(mLatestAIOMsg.getMsgSeq());
            } else {
                l26 = null;
            }
            if (latestMsg != null) {
                l27 = Long.valueOf(latestMsg.getMsgSeq());
            } else {
                l27 = null;
            }
        }
        if (QLog.isColorLevel()) {
            if (topMsg != null) {
                l17 = Long.valueOf(topMsg.getMsgSeq());
            } else {
                l17 = null;
            }
            if (bottomMsg != null) {
                l18 = Long.valueOf(bottomMsg.getMsgSeq());
            } else {
                l18 = null;
            }
            if (latestMsg != null) {
                l19 = Long.valueOf(latestMsg.getMsgSeq());
            } else {
                l19 = null;
            }
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            QLog.i("GuildAioNavigateButtonVM", 2, "handleMsgListScrollEvent, topMsgSeq = " + l17 + ", bottomMsgSeq = " + l18 + ", latestMsg = " + l19 + ", channelId = " + com.tencent.guild.aio.util.a.b(g16));
        }
        navButtonUnreadCntText.f(bottomMsg);
        navButtonUnreadCntText.g(latestMsg);
        GuildAIoNavigateButtonUIState.NavButtonUnreadCntText.j(navButtonUnreadCntText, topMsg, false, 2, null);
        updateUI(navButtonUnreadCntText);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent("GuildAioDefaultReserve2Model"));
    }

    private final void q() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.H(), new GuildAioNavigateButtonVM$initNavigateInfo$1(this, null)), Dispatchers.getMain()), vmScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void r(Map<Integer, ? extends List<fr0.a>> unreadCntInfo) {
        boolean z16;
        String str;
        i.b bVar;
        Long l3;
        Long l16;
        com.tencent.aio.data.msglist.a aVar;
        GuildMsgItem guildMsgItem;
        Object obj;
        com.tencent.aio.data.msglist.a latestAIOMsg;
        com.tencent.aio.data.msglist.a bottomMsg;
        List<fr0.a> list = unreadCntInfo.get(1);
        List<fr0.a> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        for (fr0.a aVar2 : list) {
            GuildMsgItem guildMsgItem2 = null;
            if (aVar2 != null) {
                str = aVar2.getChannelId();
            } else {
                str = null;
            }
            if (str != null) {
                String channelId = aVar2.getChannelId();
                AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                if (Intrinsics.areEqual(channelId, com.tencent.guild.aio.util.a.b(g16))) {
                    if (com.tencent.guild.aio.util.ex.a.j((com.tencent.aio.api.runtime.a) getMContext())) {
                        this.navButtonUnreadCnt.h(0);
                    } else {
                        this.navButtonUnreadCnt.h(aVar2.getAllUnreadCnt().getCnt());
                    }
                    int cnt = aVar2.getAllUnreadCnt().getCnt();
                    AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                    Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
                    QLog.i("GuildAioNavigateButtonVM", 1, "onUnreadCountChange, cnt = " + cnt + ", channelId = " + com.tencent.guild.aio.util.a.b(g17));
                    if (aVar2.getAllUnreadCnt().getCnt() > 0) {
                        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildMsgListIntent.GetAIOExtremalMsgEvent.f110408d);
                        if (k3 instanceof i.b) {
                            bVar = (i.b) k3;
                        } else {
                            bVar = null;
                        }
                        if (bVar != null && (bottomMsg = bVar.getBottomMsg()) != null) {
                            l3 = Long.valueOf(bottomMsg.getMsgSeq());
                        } else {
                            l3 = null;
                        }
                        if (bVar != null && (latestAIOMsg = bVar.getLatestAIOMsg()) != null) {
                            l16 = Long.valueOf(latestAIOMsg.getMsgSeq());
                        } else {
                            l16 = null;
                        }
                        QLog.i("GuildAioNavigateButtonVM", 1, "onUnreadCountChange, bottom = " + l3 + ", latestAIOMsg = " + l16);
                        GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCntText = this.navButtonUnreadCnt;
                        if (bVar != null) {
                            aVar = bVar.getBottomMsg();
                        } else {
                            aVar = null;
                        }
                        if (aVar instanceof GuildMsgItem) {
                            guildMsgItem = (GuildMsgItem) aVar;
                        } else {
                            guildMsgItem = null;
                        }
                        navButtonUnreadCntText.f(guildMsgItem);
                        GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCntText2 = this.navButtonUnreadCnt;
                        if (bVar != null) {
                            obj = bVar.getLatestAIOMsg();
                        } else {
                            obj = null;
                        }
                        if (obj instanceof GuildMsgItem) {
                            guildMsgItem2 = (GuildMsgItem) obj;
                        }
                        navButtonUnreadCntText2.g(guildMsgItem2);
                    }
                    updateUI(this.navButtonUnreadCnt);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull qq0.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.C11093b) {
            p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildInputBarHeightChangEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildAioLastShowMsgLower.class).getQualifiedName(), this.mAction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildInputBarHeightChangEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildAioLastShowMsgLower.class).getQualifiedName(), this.mAction);
        q();
    }
}
