package com.tencent.guild.aio.reserve2.busi.navigate.bar.holder;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.msgservice.j;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.reserve2.busi.navigate.bar.holder.GuildAioNavigateBarVB;
import com.tencent.guild.aio.util.ex.f;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import er0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qq0.b;
import rr1.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\b\b*\u0001@\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001FB\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0016\u0010\u0014\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0016\u0010\u001c\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J.\u0010#\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\"\u001a\u00020!H\u0002J,\u0010(\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00162\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010%2\u0006\u0010*\u001a\u00020)H\u0002J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0002H\u0016J\b\u00101\u001a\u00020\u0006H\u0016J\u0014\u00102\u001a\u00020\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u0019R$\u00105\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006G"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/navigate/bar/holder/GuildAioNavigateBarVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/busi/navigate/bar/holder/GuildAioNavigateBarUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "scene", HippyTKDListViewAdapter.X, "Lrr1/i;", "notifyData", "B", "y", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/aio/msgservice/j;", "Ler0/a;", "rsp", "w", "t", "", "msgSeq", "v", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "topMsg", "bottomMsg", "latestMsg", "", "bForce", "G", "Ljava/util/ArrayList;", "Ler0/a$a;", "Lkotlin/collections/ArrayList;", "infoList", "D", "", "index", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "intent", "u", MosaicConstants$JsFunction.FUNC_ON_DESTROY, UserInfo.SEX_FEMALE, "d", "Ljava/util/ArrayList;", "mNavigationInfoList", "e", "J", "unreadCount", "f", "Z", "isInit", h.F, "isFirstPageMsgFin", "Lcom/tencent/aio/msgservice/j;", "pendingRsp", "com/tencent/guild/aio/reserve2/busi/navigate/bar/holder/GuildAioNavigateBarVM$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/reserve2/busi/navigate/bar/holder/GuildAioNavigateBarVM$b;", "mAction", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioNavigateBarVM extends com.tencent.aio.base.mvvm.b<qq0.b, GuildAioNavigateBarUIState> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long unreadCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isInit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstPageMsgFin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j<er0.a> pendingRsp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a.C10261a> mNavigationInfoList = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/reserve2/busi/navigate/bar/holder/GuildAioNavigateBarVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildAioNavigateBarVM.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void A(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String j3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j();
        ArrayList<com.tencent.aio.data.msglist.a> arrayList = new ArrayList();
        for (Object obj : msgList) {
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            String str = ((GuildMsgItem) aVar).getMsgRecord().peerUid;
            boolean equals = TextUtils.equals(str, j3);
            if (equals) {
                long msgSeq = aVar.getMsgSeq();
                GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
                QLog.i("GuildAioNavigateBarVM", 1, "onMsgInfoListStatusUpdate, msg uid = " + str + ", seq = " + msgSeq + ", type = " + guildMsgItem.getMsgRecord().msgType + ", subType = " + guildMsgItem.getMsgRecord().subMsgType);
            }
            if (equals) {
                arrayList.add(obj);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            boolean z16 = false;
            for (com.tencent.aio.data.msglist.a aVar2 : arrayList) {
                if ((aVar2 instanceof GuildMsgItem) && f.d((GuildMsgItem) aVar2) && D(aVar2.getMsgSeq(), this.mNavigationInfoList)) {
                    QLog.i("GuildAioNavigateBarVM", 1, "onMsgInfoListStatusUpdate remove seq = " + aVar2.getMsgSeq());
                    z16 = true;
                }
            }
            if (z16) {
                updateUI(new GuildAioNavigateBarUIState(this.mNavigationInfoList, this.unreadCount));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(i notifyData) {
        if (notifyData.f() == 1 && notifyData.d() == 2 && notifyData.a() == 3) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            QLog.i("GuildAioNavigateBarVM", 1, "onNotifyActiveChannel open, channelId = " + com.tencent.guild.aio.util.a.b(g16));
            if (this.isInit) {
                QLog.i("GuildAioNavigateBarVM", 1, "onNotifyActiveChannel already init");
                return;
            } else {
                this.isInit = true;
                s();
                return;
            }
        }
        if (notifyData.f() == 3 && notifyData.c() == 3 && notifyData.a() == 1) {
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            QLog.i("GuildAioNavigateBarVM", 1, "onNotifyActiveChannel pause, channelId = " + com.tencent.guild.aio.util.a.b(g17));
            this.mNavigationInfoList.clear();
            updateUI(new GuildAioNavigateBarUIState(this.mNavigationInfoList, this.unreadCount));
            this.isInit = false;
        }
    }

    private final a.C10261a C(int index) {
        if (this.mNavigationInfoList.isEmpty()) {
            return null;
        }
        boolean z16 = false;
        if (index >= 0 && index < this.mNavigationInfoList.size()) {
            z16 = true;
        }
        if (!z16) {
            return null;
        }
        return this.mNavigationInfoList.remove(index);
    }

    private final boolean D(long msgSeq, ArrayList<a.C10261a> infoList) {
        if (infoList != null) {
            Iterator<a.C10261a> it = infoList.iterator();
            while (it.hasNext()) {
                a.C10261a next = it.next();
                if (next.getMsgSeq() == msgSeq && next.getType() != GuildAioNavigateBarVB.Companion.GuildNavigateType.KUNREAD.ordinal()) {
                    return infoList.remove(next);
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GuildMsgListScrollEvent) {
            GuildMsgListIntent.GuildMsgListScrollEvent guildMsgListScrollEvent = (GuildMsgListIntent.GuildMsgListScrollEvent) i3;
            G(guildMsgListScrollEvent.getAioTopMsg(), guildMsgListScrollEvent.getAioBottomMsg(), guildMsgListScrollEvent.getLatestAioMsg(), false);
        } else if (i3 instanceof MFGestureListIntent.NotifyEvent) {
            B(((MFGestureListIntent.NotifyEvent) i3).getNotifyData());
        } else if (i3 instanceof GuildMsgListIntent.AfterLoadFirstPageFinEvent) {
            z();
        }
    }

    private final void G(GuildMsgItem topMsg, GuildMsgItem bottomMsg, GuildMsgItem latestMsg, boolean bForce) {
        long j3;
        if (this.mNavigationInfoList.isEmpty()) {
            return;
        }
        if (topMsg != null) {
            j3 = topMsg.getMsgSeq();
        } else {
            j3 = Long.MAX_VALUE;
        }
        boolean z16 = false;
        for (int size = this.mNavigationInfoList.size() - 1; -1 < size; size--) {
            a.C10261a c10261a = this.mNavigationInfoList.get(size);
            Intrinsics.checkNotNullExpressionValue(c10261a, "mNavigationInfoList[index]");
            a.C10261a c10261a2 = c10261a;
            if (c10261a2.getMsgSeq() >= j3 && bottomMsg != null && latestMsg != null && latestMsg.getMsgSeq() >= bottomMsg.getMsgSeq()) {
                QLog.i("GuildAioNavigateBarVM", 1, "updateNavigateInfoIfNeed, info = " + c10261a2 + ", topMsgSeq = " + j3 + ", bottomMsg = " + Long.valueOf(bottomMsg.getMsgSeq()) + ", latestAIOMsg = " + Long.valueOf(latestMsg.getMsgSeq()));
                this.mNavigationInfoList.remove(size);
                z16 = true;
            }
        }
        if (z16 || bForce) {
            updateUI(new GuildAioNavigateBarUIState(this.mNavigationInfoList, this.unreadCount));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        if (com.tencent.guild.aio.util.ex.a.j((com.tencent.aio.api.runtime.a) getMContext())) {
            return;
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.o(((com.tencent.aio.api.runtime.a) getMContext()).g().r()), new GuildAioNavigateBarVM$getGuildNavigationInfo$1(this, null)), Dispatchers.getMain()), vmScope());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t() {
        if (!this.mNavigationInfoList.isEmpty()) {
            a.C10261a c10261a = this.mNavigationInfoList.get(0);
            Intrinsics.checkNotNullExpressionValue(c10261a, "mNavigationInfoList[0]");
            C(0);
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            QLog.i("GuildAioNavigateBarVM", 1, "handleClickNavBar, channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", list size = " + this.mNavigationInfoList.size() + ", unreadCount = " + this.unreadCount);
            v(c10261a.getMsgSeq());
        }
        updateUI(new GuildAioNavigateBarUIState(this.mNavigationInfoList, this.unreadCount));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v(long msgSeq) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToMsgEvent("GuildAioDefaultReserve2Model", msgSeq));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void w(j<er0.a> rsp) {
        i.b bVar;
        Long l3;
        Long l16;
        Long l17;
        com.tencent.aio.data.msglist.a aVar;
        com.tencent.aio.data.msglist.a aVar2;
        GuildMsgItem guildMsgItem;
        com.tencent.aio.data.msglist.a aVar3;
        GuildMsgItem guildMsgItem2;
        Object obj;
        com.tencent.aio.data.msglist.a latestAIOMsg;
        com.tencent.aio.data.msglist.a bottomMsg;
        com.tencent.aio.data.msglist.a topMsg;
        boolean d16 = rsp.d();
        long firstUnreadSeq = rsp.a().getFirstUnreadSeq();
        long unreadCount = rsp.a().getUnreadCount();
        int size = rsp.a().b().size();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        QLog.i("GuildAioNavigateBarVM", 1, "handleNavigationBarData, succ = " + d16 + ", firstSeq = " + firstUnreadSeq + ", unreadCount = " + unreadCount + ",  data size = " + size + ", channelId = " + com.tencent.guild.aio.util.a.b(g16));
        if (rsp.d()) {
            F(rsp.a().b());
            this.unreadCount = rsp.a().getUnreadCount();
            if (rsp.a().getUnreadCount() > 0) {
                this.mNavigationInfoList.add(new a.C10261a(rsp.a().getFirstUnreadSeq(), GuildAioNavigateBarVB.Companion.GuildNavigateType.KUNREAD.ordinal()));
            }
        } else {
            this.mNavigationInfoList.clear();
        }
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildMsgListIntent.GetAIOExtremalMsgEvent.f110408d);
        GuildMsgItem guildMsgItem3 = null;
        if (k3 instanceof i.b) {
            bVar = (i.b) k3;
        } else {
            bVar = null;
        }
        if (bVar != null && (topMsg = bVar.getTopMsg()) != null) {
            l3 = Long.valueOf(topMsg.getMsgSeq());
        } else {
            l3 = null;
        }
        if (bVar != null && (bottomMsg = bVar.getBottomMsg()) != null) {
            l16 = Long.valueOf(bottomMsg.getMsgSeq());
        } else {
            l16 = null;
        }
        if (bVar != null && (latestAIOMsg = bVar.getLatestAIOMsg()) != null) {
            l17 = Long.valueOf(latestAIOMsg.getMsgSeq());
        } else {
            l17 = null;
        }
        QLog.i("GuildAioNavigateBarVM", 1, "handleNavigationBarData, topmsg = " + l3 + ", bottomMsg = " + l16 + ", latestAIOMsg = " + l17);
        if (bVar != null) {
            aVar = bVar.getTopMsg();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            BuildersKt__Builders_commonKt.launch$default(vmScope(), Dispatchers.getMain(), null, new GuildAioNavigateBarVM$handleNavigationBarData$1(this, null), 2, null);
            return;
        }
        if (bVar != null) {
            aVar2 = bVar.getTopMsg();
        } else {
            aVar2 = null;
        }
        if (aVar2 instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) aVar2;
        } else {
            guildMsgItem = null;
        }
        if (bVar != null) {
            aVar3 = bVar.getBottomMsg();
        } else {
            aVar3 = null;
        }
        if (aVar3 instanceof GuildMsgItem) {
            guildMsgItem2 = (GuildMsgItem) aVar3;
        } else {
            guildMsgItem2 = null;
        }
        if (bVar != null) {
            obj = bVar.getLatestAIOMsg();
        } else {
            obj = null;
        }
        if (obj instanceof GuildMsgItem) {
            guildMsgItem3 = (GuildMsgItem) obj;
        }
        G(guildMsgItem, guildMsgItem2, guildMsgItem3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(String scene) {
        boolean z16;
        if (this.pendingRsp == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("GuildAioNavigateBarVM", 1, "handlePendingNavigationBarData, scene = " + scene + ", pendingRsp is null = " + z16);
        j<er0.a> jVar = this.pendingRsp;
        if (jVar != null) {
            Intrinsics.checkNotNull(jVar);
            w(jVar);
            this.pendingRsp = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        this.isInit = true;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        QLog.i("GuildAioNavigateBarVM", 1, "initNavigateInfo, channelId = " + com.tencent.guild.aio.util.a.b(g16));
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.x(), new GuildAioNavigateBarVM$initNavigateInfo$1(this, null)), Dispatchers.getMain()), vmScope());
        s();
    }

    private final void z() {
        this.isFirstPageMsgFin = true;
        x("afterFirstPageFin");
    }

    public final void F(@NotNull List<a.C10261a> infoList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.mNavigationInfoList.clear();
        ArrayList arrayList = new ArrayList();
        for (Object obj : infoList) {
            a.C10261a c10261a = (a.C10261a) obj;
            if (c10261a.getType() != GuildAioNavigateBarVB.Companion.GuildNavigateType.KUNKNOWN.ordinal()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.i("GuildAioNavigateBarVM", 1, "setNavigationInfoList, filter seq = " + c10261a.getMsgSeq());
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        this.mNavigationInfoList.addAll(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17;
        com.tencent.mvi.base.route.j e18;
        super.onDestroy();
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        QLog.i("GuildAioNavigateBarVM", 1, "onDestroy, channelId = " + com.tencent.guild.aio.util.a.b(g16));
        com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar != null && (e18 = aVar.e()) != null) {
            e18.b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.mAction);
        }
        com.tencent.aio.api.runtime.a aVar2 = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar2 != null && (e17 = aVar2.e()) != null) {
            e17.b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.mAction);
        }
        com.tencent.aio.api.runtime.a aVar3 = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar3 != null && (e16 = aVar3.e()) != null) {
            e16.b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.AfterLoadFirstPageFinEvent.class).getQualifiedName(), this.mAction);
        }
        this.mNavigationInfoList.clear();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull qq0.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.a) {
            t();
        } else if (intent instanceof b.c) {
            v(((b.c) intent).getMsgSeq());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17;
        com.tencent.mvi.base.route.j e18;
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar != null && (e18 = aVar.e()) != null) {
            e18.d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.mAction);
        }
        com.tencent.aio.api.runtime.a aVar2 = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar2 != null && (e17 = aVar2.e()) != null) {
            e17.d(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.mAction);
        }
        com.tencent.aio.api.runtime.a aVar3 = (com.tencent.aio.api.runtime.a) getSafetyContext();
        if (aVar3 != null && (e16 = aVar3.e()) != null) {
            e16.d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.AfterLoadFirstPageFinEvent.class).getQualifiedName(), this.mAction);
        }
        y();
    }
}
