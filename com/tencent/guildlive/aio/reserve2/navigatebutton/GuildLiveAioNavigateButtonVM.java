package com.tencent.guildlive.aio.reserve2.navigatebutton;

import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.reserve2.busi.navigate.button.holder.GuildAIoNavigateButtonUIState;
import com.tencent.guild.aio.reserve2.holder.GuildReserve2UIState;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guildlive.aio.reserve2.navigatebar.GuildLiveNavigateBarUIState;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$LiveVideoScreenChange;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import qq0.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J&\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\"\u0010\u0013\u001a\u00020\b2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/guildlive/aio/reserve2/navigatebutton/GuildLiveAioNavigateButtonVM;", "Lpn0/a;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/holder/GuildReserve2UIState;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "topMsg", "bottomMsg", "latestMsg", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "videoScreenState", ReportConstant.COSTREPORT_PREFIX, "r", "t", "", "", "Lfr0/a;", "unreadCntInfo", "u", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", "p", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState$NavButtonUnreadCntText;", "f", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState$NavButtonUnreadCntText;", "mNavigateButtonUIState", "<init>", "()V", h.F, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveAioNavigateButtonVM extends pn0.a<qq0.b, GuildReserve2UIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildAIoNavigateButtonUIState.NavButtonUnreadCntText mNavigateButtonUIState = new GuildAIoNavigateButtonUIState.NavButtonUnreadCntText();

    private final void q(GuildMsgItem topMsg, GuildMsgItem bottomMsg, GuildMsgItem latestMsg) {
        Long l3;
        Long l16;
        Long l17;
        GuildLiveLogUtil.Companion companion = GuildLiveLogUtil.INSTANCE;
        if (topMsg != null) {
            l3 = Long.valueOf(topMsg.getMsgSeq());
        } else {
            l3 = null;
        }
        if (bottomMsg != null) {
            l16 = Long.valueOf(bottomMsg.getMsgSeq());
        } else {
            l16 = null;
        }
        if (latestMsg != null) {
            l17 = Long.valueOf(latestMsg.getMsgSeq());
        } else {
            l17 = null;
        }
        companion.e("GuildLiveAioNavigateButtonVM", "[handleMsgListScrollEvent], topMsgSeq = " + l3 + ", bottomMsgSeq = " + l16 + ", latestMsg = " + l17);
        GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCntText = this.mNavigateButtonUIState;
        navButtonUnreadCntText.f(bottomMsg);
        navButtonUnreadCntText.g(latestMsg);
        GuildAIoNavigateButtonUIState.NavButtonUnreadCntText.j(navButtonUnreadCntText, topMsg, false, 2, null);
        updateUI(navButtonUnreadCntText);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent("GuildAioDefaultReserve2Model"));
    }

    private final void s(int videoScreenState) {
        updateUI(new GuildLiveNavigateBarUIState.VideoScreenChange(videoScreenState));
    }

    private final void t() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.H(), new GuildLiveAioNavigateButtonVM$initNavigateInfo$1(this, null)), Dispatchers.getMain()), vmScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void u(Map<Integer, ? extends List<fr0.a>> unreadCntInfo) {
        boolean z16;
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
            String channelId = aVar2.getChannelId();
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (Intrinsics.areEqual(channelId, com.tencent.guild.aio.util.a.b(g16))) {
                int cnt = aVar2.getAllUnreadCnt().getCnt();
                boolean j3 = com.tencent.guild.aio.util.ex.a.j((com.tencent.aio.api.runtime.a) getMContext());
                if (j3) {
                    this.mNavigateButtonUIState.h(0);
                } else {
                    this.mNavigateButtonUIState.h(cnt);
                }
                QLog.i("GuildLiveAioNavigateButtonVM", 1, "onUnreadCountChange, cnt:" + cnt + ", guestMode:" + j3);
                if (cnt > 0) {
                    k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildMsgListIntent.GetAIOExtremalMsgEvent.f110408d);
                    GuildMsgItem guildMsgItem2 = null;
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
                    QLog.i("GuildLiveAioNavigateButtonVM", 1, "onUnreadCountChange, bottom:" + l3 + ", latestAIOMsg:" + l16);
                    GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCntText = this.mNavigateButtonUIState;
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
                    GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCntText2 = this.mNavigateButtonUIState;
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
                updateUI(this.mNavigateButtonUIState);
                return;
            }
        }
    }

    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildMsgListIntent.GuildMsgListScrollEvent) {
            GuildMsgListIntent.GuildMsgListScrollEvent guildMsgListScrollEvent = (GuildMsgListIntent.GuildMsgListScrollEvent) intent;
            q(guildMsgListScrollEvent.getAioTopMsg(), guildMsgListScrollEvent.getAioBottomMsg(), guildMsgListScrollEvent.getLatestAioMsg());
        } else if (intent instanceof GuildLiveOuterMsgIntent$LiveVideoScreenChange) {
            s(((GuildLiveOuterMsgIntent$LiveVideoScreenChange) intent).getVideoScreenState());
        } else if (intent instanceof GuildMsgListIntent.GuildInputBarHeightChangEvent) {
            updateUI(new GuildAIoNavigateButtonUIState.NavButtonPaddingBottom(((GuildMsgListIntent.GuildInputBarHeightChangEvent) intent).getHeight()));
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$LiveVideoScreenChange.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildInputBarHeightChangEvent.class).getQualifiedName()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull qq0.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.C11093b) {
            r();
        }
    }

    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        t();
    }
}
