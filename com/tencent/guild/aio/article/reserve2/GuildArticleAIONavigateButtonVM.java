package com.tencent.guild.aio.article.reserve2;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListEvent;
import com.tencent.guild.aio.article.msglist.h;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.reserve2.busi.navigate.button.holder.GuildAIoNavigateButtonUIState;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import qq0.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u0007*\u0001,\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00011B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J&\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/guild/aio/article/reserve2/GuildArticleAIONavigateButtonVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "r", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "topMsg", "bottomMsg", "latestMsg", "o", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "intent", DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState$NavButtonUnreadCntText;", "d", "Lcom/tencent/guild/aio/reserve2/busi/navigate/button/holder/GuildAIoNavigateButtonUIState$NavButtonUnreadCntText;", "navButtonUnreadCnt", "", "e", "I", "mUnReadReplyCount", "", "f", "J", "mMainMsgSeq", h.F, "mLatestMsgSeq", "com/tencent/guild/aio/article/reserve2/GuildArticleAIONavigateButtonVM$b", "Lcom/tencent/guild/aio/article/reserve2/GuildArticleAIONavigateButtonVM$b;", "mAction", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleAIONavigateButtonVM extends com.tencent.aio.base.mvvm.b<qq0.b, GuildAIoNavigateButtonUIState> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mUnReadReplyCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mMainMsgSeq;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mLatestMsgSeq;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCnt = new GuildAIoNavigateButtonUIState.NavButtonUnreadCntText();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/article/reserve2/GuildArticleAIONavigateButtonVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildArticleAIONavigateButtonVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GuildMsgListScrollEvent) {
            GuildMsgListIntent.GuildMsgListScrollEvent guildMsgListScrollEvent = (GuildMsgListIntent.GuildMsgListScrollEvent) i3;
            o(guildMsgListScrollEvent.getAioTopMsg(), guildMsgListScrollEvent.getAioBottomMsg(), guildMsgListScrollEvent.getLatestAioMsg());
        } else if (i3 instanceof GuildMsgListIntent.GuildInputBarHeightChangEvent) {
            updateUI(new GuildAIoNavigateButtonUIState.NavButtonPaddingBottom(((GuildMsgListIntent.GuildInputBarHeightChangEvent) i3).getHeight()));
        } else if (i3 instanceof GuildArticleMsgListEvent.HideUnreadNavigateBubble) {
            m();
        }
    }

    private final void m() {
        if (this.mUnReadReplyCount != 0) {
            this.mUnReadReplyCount = 0;
            GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCntText = this.navButtonUnreadCnt;
            navButtonUnreadCntText.h(0);
            updateUI(navButtonUnreadCntText);
        }
    }

    private final void o(GuildMsgItem topMsg, GuildMsgItem bottomMsg, GuildMsgItem latestMsg) {
        long j3;
        boolean z16;
        Long l3;
        Long l16;
        Long l17;
        if (QLog.isDevelopLevel()) {
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
            QLog.i("GuildArticleAIONavigateButtonVM", 4, "handleMsgListScrollEvent, topMsgSeq = " + l3 + ", bottomMsgSeq = " + l16 + ", latestMsg = " + l17);
        }
        long j16 = this.mLatestMsgSeq;
        if (latestMsg != null) {
            j3 = latestMsg.getMsgSeq();
        } else {
            j3 = 0;
        }
        this.mLatestMsgSeq = Math.max(j16, j3);
        GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCntText = this.navButtonUnreadCnt;
        navButtonUnreadCntText.f(bottomMsg);
        navButtonUnreadCntText.g(latestMsg);
        GuildAIoNavigateButtonUIState.NavButtonUnreadCntText.j(navButtonUnreadCntText, topMsg, false, 2, null);
        if (bottomMsg != null && bottomMsg.getMsgSeq() == this.mLatestMsgSeq) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mUnReadReplyCount = 0;
            navButtonUnreadCntText.h(0);
        }
        updateUI(navButtonUnreadCntText);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        if (this.mUnReadReplyCount != 0) {
            this.mUnReadReplyCount = 0;
            GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCntText = this.navButtonUnreadCnt;
            navButtonUnreadCntText.h(0);
            updateUI(navButtonUnreadCntText);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent("GuildAioDefaultReserve2Model"));
    }

    private final void q() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.y(), new GuildArticleAIONavigateButtonVM$initNavigateInfo$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void r(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String j3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = msgList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) next;
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
            if (!TextUtils.equals(guildMsgItem.getMsgRecord().peerUid, j3) || !s(guildMsgItem.getMsgRecord())) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mUnReadReplyCount += arrayList.size();
            Iterator it5 = arrayList.iterator();
            if (it5.hasNext()) {
                Long valueOf = Long.valueOf(((com.tencent.aio.data.msglist.a) it5.next()).getMsgSeq());
                while (it5.hasNext()) {
                    Long valueOf2 = Long.valueOf(((com.tencent.aio.data.msglist.a) it5.next()).getMsgSeq());
                    if (valueOf.compareTo(valueOf2) < 0) {
                        valueOf = valueOf2;
                    }
                }
                this.mLatestMsgSeq = valueOf.longValue();
                GuildAIoNavigateButtonUIState.NavButtonUnreadCntText navButtonUnreadCntText = this.navButtonUnreadCnt;
                navButtonUnreadCntText.h(this.mUnReadReplyCount);
                updateUI(navButtonUnreadCntText);
                return;
            }
            throw new NoSuchElementException();
        }
    }

    private final boolean s(MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            if (msgElement.elementType == 7) {
                ReplyElement replyElement = msgElement.replyElement;
                if (replyElement == null) {
                    return false;
                }
                Long l3 = replyElement.replayMsgRootSeq;
                long j3 = this.mMainMsgSeq;
                if (l3 == null || l3.longValue() != j3) {
                    return false;
                }
                return true;
            }
        }
        return false;
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
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.class).getQualifiedName(), this.mAction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildInputBarHeightChangEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.HideUnreadNavigateBubble.class).getQualifiedName(), this.mAction);
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildArticleMsgListEvent.MainMsgSeqGet.f109918d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.guild.aio.article.msglist.GuildArticleMsgListResult.MainMsgSeqGetResult");
        this.mMainMsgSeq = ((h.c) k3).getMainMsgSeq();
        q();
    }
}
