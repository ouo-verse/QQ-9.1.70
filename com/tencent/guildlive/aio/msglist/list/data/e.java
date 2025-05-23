package com.tencent.guildlive.aio.msglist.list.data;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.component.combinestyle.StyleGuildItemMsg;
import com.tencent.guild.aio.component.combinestyle.al;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.msglist.GuildLivePushMsgItemViewHolderFactoryProvider;
import com.tencent.guildlive.aio.msglist.data.GuildLiveSecurityMsgItem;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.EssenceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 72\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010.\u001a\u00020+\u00a2\u0006\u0004\b5\u00106J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0002J \u0010\u0010\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0016\u0010\u0016\u001a\u00020\u00122\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\u000e\u0010$\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u000fJ\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020\rJ\u0006\u0010*\u001a\u00020\u000fR\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/list/data/e;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/k;", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "", "B", "displayList", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/CopyOnWriteArrayList;", "I", "list", "", "needCheck", "", "w", "y", "", "msgSeq", "Lcom/tencent/guildlive/aio/msglist/data/GuildLiveSecurityMsgItem;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "", "E", "c", "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "b", "k", "msg", UserInfo.SEX_FEMALE, "H", "Lcom/tencent/guild/aio/component/combinestyle/StyleGuildItemMsg;", "data", "listIsAtBottom", HippyTKDListViewAdapter.X, "u", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "f", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "host", "g", "Lcom/tencent/guildlive/aio/msglist/data/GuildLiveSecurityMsgItem;", "mSecurityMsg", h.F, "Ljava/lang/Boolean;", "mNeedAddSecurityMsgRes", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;)V", "i", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class e extends k {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgListRepo host;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildLiveSecurityMsgItem mSecurityMsg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean mNeedAddSecurityMsgRes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull MsgListRepo host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
    }

    private final GuildLiveSecurityMsgItem A(long msgSeq) {
        ArrayList arrayList = new ArrayList();
        QRouteApi api = QRoute.api(IMsgUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMsgUtilApi::class.java)");
        return new GuildLiveSecurityMsgItem(IMsgUtilApi.b.a((IMsgUtilApi) api, arrayList, "", "", com.tencent.mobileqq.guild.message.a.f230108a.b(), 0, msgSeq, null, System.currentTimeMillis(), 0L, 320, null).a());
    }

    private final List<com.tencent.aio.data.msglist.a> B(Collection<? extends com.tencent.aio.data.msglist.a> msgList) {
        boolean z16;
        long a16 = yr0.a.a(d());
        ArrayList arrayList = new ArrayList();
        for (Object obj : msgList) {
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
            if ((aVar.getMsgSeq() >= a16 || aVar.getViewType() == com.tencent.mobileqq.guild.message.a.f230108a.b()) && GuildLivePushMsgItemViewHolderFactoryProvider.f112780a.c(aVar.getViewType())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final int C(List<? extends com.tencent.aio.data.msglist.a> displayList) {
        int i3;
        int size = displayList.size();
        int size2 = displayList.size() - 1;
        while (true) {
            int i16 = size2;
            i3 = size;
            size = i16;
            if (-1 >= size) {
                break;
            }
            com.tencent.aio.data.msglist.a aVar = displayList.get(size);
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
            if (!guildMsgItem.isLocalSend() || guildMsgItem.getMsgRecord().sendStatus != 1) {
                break;
            }
            GuildLiveLogUtil.INSTANCE.e(E(), "getFirstLocalSendingMsgPos pos = " + size + ", seq: " + guildMsgItem.getMsgSeq() + ", id: " + guildMsgItem.getMsgId() + ", msgType: " + guildMsgItem.getMsgRecord().msgType + ", subMsgType: " + guildMsgItem.getMsgRecord().subMsgType + ", msgTime: " + guildMsgItem.getMsgRecord().msgTime + ", ");
            size2 = size + (-1);
        }
        GuildLiveLogUtil.INSTANCE.e(E(), "getFirstLocalSendingMsgPos pos = " + i3 + ", size = " + displayList.size());
        return i3;
    }

    private final int D(@NonNull List<? extends com.tencent.aio.data.msglist.a> list) {
        Long l3;
        MsgRecord msgRecord;
        GuildLiveSecurityMsgItem guildLiveSecurityMsgItem = this.mSecurityMsg;
        if (guildLiveSecurityMsgItem != null && (msgRecord = guildLiveSecurityMsgItem.getMsgRecord()) != null) {
            l3 = Long.valueOf(msgRecord.msgSeq);
        } else {
            l3 = null;
        }
        int size = list.size() - 1;
        if (size < 0) {
            return -1;
        }
        while (true) {
            int i3 = size - 1;
            com.tencent.aio.data.msglist.a aVar = list.get(size);
            if (aVar instanceof GuildMsgItem) {
                long j3 = ((GuildMsgItem) aVar).getMsgRecord().msgSeq - 1;
                if (l3 != null && j3 == l3.longValue()) {
                    return size;
                }
            }
            if (i3 < 0) {
                return -1;
            }
            size = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(e this$0, com.tencent.aio.data.msglist.a msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        this$0.g().remove((Object) msg2);
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, this$0.host, IMsgListRepository.MsgListRepoOpType.OtherOperation, this$0.g(), bVar.e("GuildLiveMsgRepoDelegate", "removeMessage"), null, 16, null);
    }

    private final CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> I(CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> displayList) {
        boolean z16;
        GuildLiveLogUtil.Companion companion = GuildLiveLogUtil.INSTANCE;
        String E = E();
        boolean z17 = true;
        if (this.mSecurityMsg == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        companion.c(E, "[updateMsgBeforeUpdateUI] " + z16);
        GuildLiveSecurityMsgItem guildLiveSecurityMsgItem = this.mSecurityMsg;
        if (guildLiveSecurityMsgItem == null || !displayList.contains(guildLiveSecurityMsgItem)) {
            if (this.mSecurityMsg != null) {
                z17 = false;
            }
            w(displayList, z17);
        }
        return displayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(e this$0, IGProTopMsg topMsg) {
        Object lastOrNull;
        GuildMsgItem guildMsgItem;
        long j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(topMsg, "$topMsg");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this$0.g());
        if (lastOrNull instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) lastOrNull;
        } else {
            guildMsgItem = null;
        }
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 8;
        msgElement.grayTipElement = new GrayTipElement(7, null, null, null, null, null, null, new EssenceElement(topMsg.getTopMsgOperatorTinyId(), topMsg.getTopMsgSeq(), 1), null, null, null, null, null, null, null);
        arrayList.add(msgElement);
        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) QRoute.api(IMsgUtilApi.class);
        if (guildMsgItem != null) {
            j3 = guildMsgItem.getMsgSeq();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        AIOParam g16 = this$0.d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        GuildMsgItem guildMsgItem2 = new GuildMsgItem(iMsgUtilApi.createMsgItem(arrayList, "", "", 5, 0, j16, com.tencent.guild.aio.util.a.b(g16), 0L, ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).generateMsgUniqueId()).a());
        QLog.d("GuildLiveMsgRepoDelegate", 4, "addEnterAnnounceGrayTipsToDisplay, msgSeq[" + guildMsgItem2.getMsgSeq() + "] msgId[" + guildMsgItem2.getMsgId() + "]");
        this$0.g().add((com.tencent.aio.data.msglist.a) guildMsgItem2);
        this$0.host.E().i(guildMsgItem2);
        this$0.host.E().k(guildMsgItem2);
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        bVar.p(this$0.host, IMsgListRepository.MsgListRepoOpType.OtherOperation, this$0.g(), bVar.e("GuildLiveMsgRepoDelegate", "addEnterAnnounceGrayTipsToDisplay"), com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(bVar, false, false, 2, null));
    }

    private final void w(CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> list, boolean needCheck) {
        long j3;
        if (needCheck && !y()) {
            GuildLiveLogUtil.INSTANCE.c(E(), "[addSecurityMsg] checkNeedAddSecurityMsg = false");
            return;
        }
        GuildLiveSecurityMsgItem guildLiveSecurityMsgItem = this.mSecurityMsg;
        if (guildLiveSecurityMsgItem != null) {
            j3 = guildLiveSecurityMsgItem.getMsgSeq();
        } else {
            j3 = -2;
        }
        if (j3 == -2) {
            this.mSecurityMsg = A(z(list));
        }
        int D = D(list);
        if (D == -1) {
            if (QLog.isColorLevel()) {
                GuildLiveLogUtil.INSTANCE.b(E(), "[addSecurityMsg] sec msg index is illegal");
                return;
            }
            return;
        }
        GuildLiveLogUtil.INSTANCE.c(E(), "[addSecurityMsg] index:" + D);
        list.add(D, this.mSecurityMsg);
    }

    private final boolean y() {
        if (!((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).hasFetchedRoomInfo()) {
            if (QLog.isColorLevel()) {
                GuildLiveLogUtil.INSTANCE.b(E(), "addSecurityMsg return, not fetched room info.");
            }
            return false;
        }
        if (this.mNeedAddSecurityMsgRes == null) {
            this.mNeedAddSecurityMsgRes = Boolean.valueOf(((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).needAddSecurityMsg());
        }
        if (QLog.isColorLevel()) {
            GuildLiveLogUtil.INSTANCE.b(E(), "addSecurityMsg  mNeedAddRes = " + this.mNeedAddSecurityMsgRes + ", mSecurityMsg = " + this.mSecurityMsg);
        }
        if (!Intrinsics.areEqual(this.mNeedAddSecurityMsgRes, Boolean.TRUE) && this.mSecurityMsg == null) {
            return false;
        }
        return true;
    }

    private final long z(List<? extends com.tencent.aio.data.msglist.a> list) {
        int i3;
        int size = list.size();
        if (size == 0) {
            return -2L;
        }
        if (size > 6) {
            i3 = (size - 6) + 1;
        } else {
            i3 = 0;
        }
        return list.get(i3).getMsgSeq() - 1;
    }

    @NotNull
    public String E() {
        return "GuildLiveMsgRepoDelegate" + hashCode();
    }

    public final void F(@NotNull final com.tencent.aio.data.msglist.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guildlive.aio.msglist.list.data.c
            @Override // java.lang.Runnable
            public final void run() {
                e.G(e.this, msg2);
            }
        }, null, 2, null);
    }

    public final void H() {
        this.mNeedAddSecurityMsgRes = null;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return B(list);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        List sortedWith;
        CopyOnWriteArrayList copyOnWriteArrayList;
        List<com.tencent.aio.data.msglist.a> sortedWith2;
        List sortedWith3;
        List plus;
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        int C = C(displayList);
        if (C < 0 || C >= displayList.size()) {
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(displayList, new c());
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : sortedWith) {
                if (hashSet.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj).getMsgId()))) {
                    arrayList.add(obj);
                }
            }
            copyOnWriteArrayList = new CopyOnWriteArrayList(arrayList);
        } else {
            sortedWith3 = CollectionsKt___CollectionsKt.sortedWith(displayList.subList(0, C), new b());
            plus = CollectionsKt___CollectionsKt.plus((Collection) sortedWith3, (Iterable) displayList.subList(C, displayList.size()));
            HashSet hashSet2 = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : plus) {
                if (hashSet2.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj2).getMsgId()))) {
                    arrayList2.add(obj2);
                }
            }
            copyOnWriteArrayList = new CopyOnWriteArrayList(arrayList2);
        }
        sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(I(new CopyOnWriteArrayList<>(B(copyOnWriteArrayList))), new d());
        zr0.a.f453068a.a(sortedWith2);
        return sortedWith2;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void l(@NotNull com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        super.l(context, scope);
        GuildLiveLogUtil.INSTANCE.e(E(), "[onCreate] ");
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void onDestroy() {
        super.onDestroy();
        GuildLiveLogUtil.INSTANCE.e(E(), "[onDestroy] ");
    }

    public final void u() {
        ArrayList<IGProTopMsg> topMsgList;
        Object lastOrNull;
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        IGProChannelInfo c16 = com.tencent.guild.aio.util.a.c(g16);
        if (c16 != null && (topMsgList = c16.getTopMsgList()) != null) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) topMsgList);
            final IGProTopMsg iGProTopMsg = (IGProTopMsg) lastOrNull;
            if (iGProTopMsg != null) {
                a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guildlive.aio.msglist.list.data.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.v(e.this, iGProTopMsg);
                    }
                }, null, 2, null);
            }
        }
    }

    public final void x(@NotNull StyleGuildItemMsg data, boolean listIsAtBottom) {
        Intrinsics.checkNotNullParameter(data, "data");
        al.b(this, this.host, data, listIsAtBottom);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void c() {
    }
}
