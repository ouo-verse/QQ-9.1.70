package com.tencent.guildlive.aio.reserve2.navigatebar;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.msgservice.j;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.reserve2.busi.navigate.bar.holder.GuildAioNavigateBarUIState;
import com.tencent.guild.aio.reserve2.busi.navigate.bar.holder.GuildAioNavigateBarVB;
import com.tencent.guild.aio.reserve2.holder.GuildReserve2UIState;
import com.tencent.guild.aio.util.ex.f;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guildlive.aio.reserve2.navigatebar.GuildLiveNavigateBarUIState;
import com.tencent.guildlive.api.intent.GuildLiveOuterMsgIntent$LiveVideoScreenChange;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import er0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import qq0.b;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0016\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J,\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016H\u0002J\u0016\u0010\u001c\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0016\u0010\u001d\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u000eH\u0016J\u0010\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0002H\u0016R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/guildlive/aio/reserve2/navigatebar/GuildLiveAioNavigateBarVM;", "Lpn0/a;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/holder/GuildReserve2UIState;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "topMsg", "", "bForce", "", BdhLogUtil.LogTag.Tag_Conn, "", "videoScreenState", "w", HippyTKDListViewAdapter.X, "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "y", "", "msgSeq", "Ljava/util/ArrayList;", "Ler0/a$a;", "Lkotlin/collections/ArrayList;", "infoList", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aio/msgservice/j;", "Ler0/a;", "rsp", "v", "B", ReportConstant.COSTREPORT_PREFIX, "u", "index", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "t", "f", "Ljava/util/ArrayList;", "mNavigationInfoList", h.F, "J", "mUnreadCount", "<init>", "()V", "i", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveAioNavigateBarVM extends pn0.a<qq0.b, GuildReserve2UIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a.C10261a> mNavigationInfoList = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mUnreadCount;

    private final boolean A(long msgSeq, ArrayList<a.C10261a> infoList) {
        if (infoList == null) {
            return false;
        }
        Iterator<a.C10261a> it = infoList.iterator();
        while (it.hasNext()) {
            a.C10261a next = it.next();
            if (next.getMsgSeq() == msgSeq && next.getType() != GuildAioNavigateBarVB.Companion.GuildNavigateType.KUNREAD.ordinal()) {
                return infoList.remove(next);
            }
        }
        return false;
    }

    private final void B(List<a.C10261a> infoList) {
        this.mNavigationInfoList.clear();
        this.mNavigationInfoList.addAll(infoList);
    }

    private final void C(GuildMsgItem topMsg, boolean bForce) {
        long j3;
        if (this.mNavigationInfoList.isEmpty()) {
            return;
        }
        if (topMsg != null) {
            j3 = topMsg.getMsgSeq();
        } else {
            j3 = Long.MAX_VALUE;
        }
        int size = this.mNavigationInfoList.size() - 1;
        boolean z16 = false;
        while (-1 < size) {
            a.C10261a c10261a = this.mNavigationInfoList.get(size);
            Intrinsics.checkNotNullExpressionValue(c10261a, "mNavigationInfoList[index]");
            a.C10261a c10261a2 = c10261a;
            if (c10261a2.getMsgSeq() < j3) {
                break;
            }
            GuildLiveLogUtil.INSTANCE.e("GLAioNavBarVM", "updateNavigateInfoIfNeed, info = " + c10261a2 + ", topMsgSeq = " + j3);
            this.mNavigationInfoList.remove(size);
            size += -1;
            z16 = true;
        }
        if (z16 || bForce) {
            updateUI(new GuildAioNavigateBarUIState(this.mNavigationInfoList, this.mUnreadCount));
        }
    }

    static /* synthetic */ void D(GuildLiveAioNavigateBarVM guildLiveAioNavigateBarVM, GuildMsgItem guildMsgItem, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        guildLiveAioNavigateBarVM.C(guildMsgItem, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        if (!this.mNavigationInfoList.isEmpty()) {
            a.C10261a c10261a = this.mNavigationInfoList.get(0);
            Intrinsics.checkNotNullExpressionValue(c10261a, "mNavigationInfoList[0]");
            z(0);
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            QLog.i("GLAioNavBarVM", 1, "handleClickNavBar, channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", list size = " + this.mNavigationInfoList.size() + ", unreadCount = " + this.mUnreadCount);
            u(c10261a.getMsgSeq());
        }
        updateUI(new GuildAioNavigateBarUIState(this.mNavigationInfoList, this.mUnreadCount));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u(long msgSeq) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToMsgEvent("GuildAioDefaultReserve2Model", msgSeq));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(j<er0.a> rsp) {
        i.b bVar;
        com.tencent.aio.data.msglist.a aVar;
        Object obj;
        long coerceAtLeast;
        boolean z16;
        ArrayList<a.C10261a> b16 = rsp.a().b();
        long firstUnreadSeq = rsp.a().getFirstUnreadSeq();
        long a16 = yr0.a.a((com.tencent.aio.api.runtime.a) getMContext());
        long unreadCount = rsp.a().getUnreadCount();
        GuildLiveLogUtil.INSTANCE.e("GLAioNavBarVM", "handleNavigationBarData, succ = " + rsp.d() + ", firstSeq = " + firstUnreadSeq + ", unreadCount = " + unreadCount + ",  data size = " + b16.size());
        this.mNavigationInfoList.clear();
        this.mUnreadCount = 0L;
        if (rsp.d()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : b16) {
                if (((a.C10261a) obj2).getMsgSeq() > a16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj2);
                }
            }
            B(arrayList);
            if (firstUnreadSeq < a16) {
                unreadCount = Math.max(0L, unreadCount - (a16 - firstUnreadSeq));
            }
            this.mUnreadCount = unreadCount;
            if (unreadCount > 0) {
                ArrayList<a.C10261a> arrayList2 = this.mNavigationInfoList;
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(firstUnreadSeq, a16);
                arrayList2.add(new a.C10261a(coerceAtLeast, GuildAioNavigateBarVB.Companion.GuildNavigateType.KUNREAD.ordinal()));
            }
        }
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildMsgListIntent.GetAIOExtremalMsgEvent.f110408d);
        GuildMsgItem guildMsgItem = null;
        if (k3 instanceof i.b) {
            bVar = (i.b) k3;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            aVar = bVar.getTopMsg();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            BuildersKt__Builders_commonKt.launch$default(vmScope(), Dispatchers.getMain(), null, new GuildLiveAioNavigateBarVM$handleNavigationBarData$1(this, null), 2, null);
            return;
        }
        if (bVar != null) {
            obj = bVar.getTopMsg();
        } else {
            obj = null;
        }
        if (obj instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) obj;
        }
        C(guildMsgItem, true);
    }

    private final void w(int videoScreenState) {
        updateUI(new GuildLiveNavigateBarUIState.VideoScreenChange(videoScreenState));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        ChannelAIOMsgService channelAIOMsgService = ChannelAIOMsgService.f112613a;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.x(), new GuildLiveAioNavigateBarVM$initNavigateInfo$1(this, null)), Dispatchers.getMain()), vmScope());
        if (!com.tencent.guild.aio.util.ex.a.j((com.tencent.aio.api.runtime.a) getMContext())) {
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.o(((com.tencent.aio.api.runtime.a) getMContext()).g().r()), new GuildLiveAioNavigateBarVM$initNavigateInfo$2(this, null)), Dispatchers.getMain()), vmScope());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void y(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String j3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j();
        ArrayList<com.tencent.aio.data.msglist.a> arrayList = new ArrayList();
        for (Object obj : msgList) {
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            String str = ((GuildMsgItem) aVar).getMsgRecord().peerUid;
            GuildLiveLogUtil.INSTANCE.e("GLAioNavBarVM", "onMsgInfoListStatusUpdate, msg uid = " + str + ", seq = " + aVar.getMsgSeq());
            if (TextUtils.equals(str, j3)) {
                arrayList.add(obj);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            boolean z16 = false;
            for (com.tencent.aio.data.msglist.a aVar2 : arrayList) {
                if ((aVar2 instanceof GuildMsgItem) && f.d((GuildMsgItem) aVar2) && A(aVar2.getMsgSeq(), this.mNavigationInfoList)) {
                    QLog.i("GLAioNavBarVM", 1, "onMsgInfoListStatusUpdate remove seq = " + aVar2.getMsgSeq());
                    z16 = true;
                }
            }
            if (z16) {
                this.mUnreadCount = this.mNavigationInfoList.size();
                updateUI(new GuildAioNavigateBarUIState(this.mNavigationInfoList, this.mUnreadCount));
            }
        }
    }

    private final a.C10261a z(int index) {
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

    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Long l3;
        Long l16;
        Long l17;
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildMsgListIntent.GuildMsgListScrollEvent) {
            GuildLiveLogUtil.Companion companion = GuildLiveLogUtil.INSTANCE;
            GuildMsgListIntent.GuildMsgListScrollEvent guildMsgListScrollEvent = (GuildMsgListIntent.GuildMsgListScrollEvent) intent;
            GuildMsgItem aioTopMsg = guildMsgListScrollEvent.getAioTopMsg();
            if (aioTopMsg != null) {
                l3 = Long.valueOf(aioTopMsg.getMsgSeq());
            } else {
                l3 = null;
            }
            GuildMsgItem aioBottomMsg = guildMsgListScrollEvent.getAioBottomMsg();
            if (aioBottomMsg != null) {
                l16 = Long.valueOf(aioBottomMsg.getMsgSeq());
            } else {
                l16 = null;
            }
            GuildMsgItem latestAioMsg = guildMsgListScrollEvent.getLatestAioMsg();
            if (latestAioMsg != null) {
                l17 = Long.valueOf(latestAioMsg.getMsgSeq());
            } else {
                l17 = null;
            }
            companion.e("GLAioNavBarVM", "handleIntentAction, topMsgSeq = " + l3 + ", bottomMsgSeq = " + l16 + ", latestMsg = " + l17);
            D(this, guildMsgListScrollEvent.getAioTopMsg(), false, 2, null);
            return;
        }
        if (intent instanceof GuildLiveOuterMsgIntent$LiveVideoScreenChange) {
            w(((GuildLiveOuterMsgIntent$LiveVideoScreenChange) intent).getVideoScreenState());
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveOuterMsgIntent$LiveVideoScreenChange.class).getQualifiedName()});
        return listOf;
    }

    @Override // pn0.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        this.mNavigationInfoList.clear();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull qq0.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.a) {
            s();
        } else if (intent instanceof b.c) {
            u(((b.c) intent).getMsgSeq());
        }
    }

    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        x();
    }
}
