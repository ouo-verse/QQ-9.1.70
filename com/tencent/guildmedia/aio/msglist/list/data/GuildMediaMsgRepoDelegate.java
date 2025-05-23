package com.tencent.guildmedia.aio.msglist.list.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.guild.aio.component.combinestyle.StyleGuildItemMsg;
import com.tencent.guild.aio.component.combinestyle.al;
import com.tencent.guild.aio.util.ex.e;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guildmedia.aio.msglist.GuildMediaItemViewHolderFactoryProvider;
import com.tencent.guildmedia.data.GuildMediaAIOLottieEvent;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.EssenceElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import tl.h;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 ;2\u00020\u0001:\u0001<B2\u0012\u0006\u0010+\u001a\u00020(\u0012!\u00103\u001a\u001d\u0012\u0013\u0012\u00110-\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00060,\u00a2\u0006\u0004\b9\u0010:J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0016J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\u0006J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015J\u0016\u0010\u0019\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0016\u0010\u001b\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0002J$\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00152\b\b\u0002\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0016\u0010%\u001a\u00020$2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0002J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0&2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0&H\u0002R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R/\u00103\u001a\u001d\u0012\u0013\u0012\u00110-\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00060,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u001aR\u0016\u00108\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/list/data/GuildMediaMsgRepoDelegate;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/k;", "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "l", "c", "", "Lcom/tencent/aio/data/msglist/a;", "list", "b", "", "displayList", "k", "msg", "P", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/guild/aio/component/combinestyle/StyleGuildItemMsg;", "data", "", "listIsAtBottom", BdhLogUtil.LogTag.Tag_Conn, TabPreloadItem.TAB_NAME_MESSAGE, "K", "J", "L", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "updateResult", "isLocal", "D", "I", "H", UserInfo.SEX_FEMALE, "", "G", "Ljava/util/concurrent/CopyOnWriteArrayList;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "f", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "host", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "seq", "g", "Lkotlin/jvm/functions/Function1;", "initFirstMsgSeqCb", h.F, "firstMsgSeq", "i", "Z", "showAioMsg", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;Lkotlin/jvm/functions/Function1;)V", "j", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaMsgRepoDelegate extends k {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final Lazy<IGuildMediaChannelApi> f113146k;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgListRepo host;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Long, Unit> initFirstMsgSeqCb;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long firstMsgSeq;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean showAioMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/list/data/GuildMediaMsgRepoDelegate$a;", "", "Lcom/tencent/mobileqq/guild/api/IGuildMediaChannelApi;", "iMediaChannelApi$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/api/IGuildMediaChannelApi;", "iMediaChannelApi", "", "INIT_MAX_SHOW_MSG_SIZE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guildmedia.aio.msglist.list.data.GuildMediaMsgRepoDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IGuildMediaChannelApi b() {
            return (IGuildMediaChannelApi) GuildMediaMsgRepoDelegate.f113146k.getValue();
        }

        Companion() {
        }
    }

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

    static {
        Lazy<IGuildMediaChannelApi> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGuildMediaChannelApi>() { // from class: com.tencent.guildmedia.aio.msglist.list.data.GuildMediaMsgRepoDelegate$Companion$iMediaChannelApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildMediaChannelApi invoke() {
                return (IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class);
            }
        });
        f113146k = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildMediaMsgRepoDelegate(@NotNull MsgListRepo host, @NotNull Function1<? super Long, Unit> initFirstMsgSeqCb) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(initFirstMsgSeqCb, "initFirstMsgSeqCb");
        this.host = host;
        this.initFirstMsgSeqCb = initFirstMsgSeqCb;
        this.firstMsgSeq = -1L;
        this.showAioMsg = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(GuildMediaMsgRepoDelegate this$0, IGProTopMsg topMsg) {
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
        QLog.d("GuildMediaMsgRepoDelegate", 4, "addEnterAnnounceGrayTipsToDisplay, msgSeq[" + guildMsgItem2.getMsgSeq() + "] msgId[" + guildMsgItem2.getMsgId() + "]");
        this$0.g().add((com.tencent.aio.data.msglist.a) guildMsgItem2);
        this$0.host.E().i(guildMsgItem2);
        this$0.host.E().k(guildMsgItem2);
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        bVar.p(this$0.host, IMsgListRepository.MsgListRepoOpType.OtherOperation, this$0.g(), bVar.e("GuildMediaMsgRepoDelegate", ""), com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(bVar, false, false, 2, null));
    }

    private final void D(GuildMsgItem msgItem, boolean updateResult, boolean isLocal) {
        List filterNotNull;
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> elements = msgItem.getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        if (!arrayList.isEmpty() && e.d(arrayList) && !I()) {
            QLog.i("GuildMediaMsgRepoDelegate", 1, "[checkToSendLottieEvent] send aio lottie event\uff0c msgId:" + msgItem.getMsgId());
            SimpleEventBus.getInstance().dispatchEvent(new GuildMediaAIOLottieEvent(msgItem, updateResult));
            if (isLocal) {
                H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void E(GuildMediaMsgRepoDelegate guildMediaMsgRepoDelegate, GuildMsgItem guildMsgItem, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        guildMediaMsgRepoDelegate.D(guildMsgItem, z16, z17);
    }

    private final List<com.tencent.aio.data.msglist.a> F(Collection<? extends com.tencent.aio.data.msglist.a> msgList) {
        List arrayList;
        boolean z16;
        boolean z17;
        if (!this.showAioMsg) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : msgList) {
                if (((com.tencent.aio.data.msglist.a) obj).getViewType() == com.tencent.mobileqq.guild.message.a.f230108a.c()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        }
        if (this.firstMsgSeq == -1) {
            arrayList = new ArrayList();
            for (Object obj2 : msgList) {
                if (GuildMediaItemViewHolderFactoryProvider.f113065a.c(((com.tencent.aio.data.msglist.a) obj2).getViewType())) {
                    arrayList.add(obj2);
                }
            }
            if (arrayList.isEmpty()) {
                this.firstMsgSeq = 0L;
                QLog.i("GuildMediaMsgRepoDelegate", 1, "filterMsgList, filterList.isEmpty()");
            } else if (arrayList.size() <= 10) {
                this.firstMsgSeq = ((com.tencent.aio.data.msglist.a) arrayList.get(0)).getMsgSeq();
                QLog.i("GuildMediaMsgRepoDelegate", 1, "filterMsgList, filterList.size <= INIT_MAX_SHOW_MSG_SIZE");
            } else {
                this.firstMsgSeq = ((com.tencent.aio.data.msglist.a) arrayList.get(arrayList.size() - 10)).getMsgSeq();
                arrayList = arrayList.subList(arrayList.size() - 10, arrayList.size());
                QLog.i("GuildMediaMsgRepoDelegate", 1, "filterMsgList, from index[" + (arrayList.size() - 10) + "]");
            }
            QLog.i("GuildMediaMsgRepoDelegate", 1, "filterMsgList, set firstMsgSeq[" + this.firstMsgSeq + "]");
            this.initFirstMsgSeqCb.invoke(Long.valueOf(this.firstMsgSeq));
        } else {
            arrayList = new ArrayList();
            for (Object obj3 : msgList) {
                com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj3;
                if (aVar.getMsgSeq() >= this.firstMsgSeq && GuildMediaItemViewHolderFactoryProvider.f113065a.c(aVar.getViewType())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj3);
                }
            }
        }
        return arrayList;
    }

    private final int G(List<? extends com.tencent.aio.data.msglist.a> displayList) {
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
            QLog.i("GuildMediaMsgRepoDelegate", 1, "getFirstLocalSendingMsgPos pos = " + size + ", seq: " + guildMsgItem.getMsgSeq() + ", id: " + guildMsgItem.getMsgId() + ", msgType: " + guildMsgItem.getMsgRecord().msgType + ", subMsgType: " + guildMsgItem.getMsgRecord().subMsgType + ", msgTime: " + guildMsgItem.getMsgRecord().msgTime + ", ");
            size2 = size + (-1);
        }
        QLog.i("GuildMediaMsgRepoDelegate", 1, "getFirstLocalSendingMsgPos pos = " + i3 + ", size = " + displayList.size());
        return i3;
    }

    private final void H() {
        d().e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildMediaMsgRepoDelegate", false, 2, null));
    }

    private final boolean I() {
        return INSTANCE.b().isLowDisplayMode();
    }

    private final void J(com.tencent.aio.data.msglist.a msg2) {
        if (!(msg2 instanceof GuildMsgItem)) {
            return;
        }
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        String str = ((GuildMsgItem) msg2).getMsgRecord().channelId;
        QLog.i("GuildMediaMsgRepoDelegate", 1, "[onAddLocalSendMsg] seq:" + msg2.getMsgSeq() + ", cid: " + b16 + ", msgCId: " + str);
        if (Intrinsics.areEqual(b16, str)) {
            BuildersKt__Builders_commonKt.launch$default(r(), Dispatchers.getMain(), null, new GuildMediaMsgRepoDelegate$onAddLocalSendMsg$1(this, msg2, null), 2, null);
        }
    }

    private final void K(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = msgList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) next;
            if (!(aVar instanceof GuildMsgItem) || !TextUtils.equals(((GuildMsgItem) aVar).getMsgRecord().peerUid, b16) || !e.g(aVar)) {
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
            BuildersKt__Builders_commonKt.launch$default(r(), Dispatchers.getMain(), null, new GuildMediaMsgRepoDelegate$onMsgInfoListStatusUpdate$3$1(arrayList, this, null), 2, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0045, code lost:
    
        if (r4.getMsgRecord().msgType != 1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void L(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String j3 = d().g().r().c().j();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = msgList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) next;
            if (aVar instanceof GuildMsgItem) {
                GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
                if (TextUtils.equals(j3, guildMsgItem.getMsgRecord().peerUid)) {
                }
            }
            z16 = false;
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            BuildersKt__Builders_commonKt.launch$default(r(), Dispatchers.getMain(), null, new GuildMediaMsgRepoDelegate$onMsgReceive$3$1(arrayList, this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object M(GuildMediaMsgRepoDelegate guildMediaMsgRepoDelegate, com.tencent.aio.data.msglist.a aVar, Continuation continuation) {
        guildMediaMsgRepoDelegate.J(aVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object N(GuildMediaMsgRepoDelegate guildMediaMsgRepoDelegate, List list, Continuation continuation) {
        guildMediaMsgRepoDelegate.K(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object O(GuildMediaMsgRepoDelegate guildMediaMsgRepoDelegate, List list, Continuation continuation) {
        guildMediaMsgRepoDelegate.L(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(GuildMediaMsgRepoDelegate this$0, com.tencent.aio.data.msglist.a msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        this$0.g().remove((Object) msg2);
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, this$0.host, IMsgListRepository.MsgListRepoOpType.OtherOperation, this$0.g(), bVar.e("GuildMediaMsgRepoDelegate", "removeMessage"), null, 16, null);
    }

    public final void A() {
        ArrayList<IGProTopMsg> topMsgList;
        Object lastOrNull;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildMediaMsgRepoDelegate", "[addEnterAnnounceGrayTipsToDisplay] " + this.showAioMsg + ", " + this.firstMsgSeq);
        }
        if (this.showAioMsg && this.firstMsgSeq == -1) {
            return;
        }
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        IGProChannelInfo c16 = com.tencent.guild.aio.util.a.c(g16);
        if (c16 != null && (topMsgList = c16.getTopMsgList()) != null) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) topMsgList);
            final IGProTopMsg iGProTopMsg = (IGProTopMsg) lastOrNull;
            if (iGProTopMsg != null) {
                a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guildmedia.aio.msglist.list.data.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildMediaMsgRepoDelegate.B(GuildMediaMsgRepoDelegate.this, iGProTopMsg);
                    }
                }, null, 2, null);
            }
        }
    }

    public final void C(@NotNull StyleGuildItemMsg data, boolean listIsAtBottom) {
        Intrinsics.checkNotNullParameter(data, "data");
        Logger.f235387a.d().d("GuildMediaMsgRepoDelegate", 1, "[addStyleGuildItemMsg] " + this.showAioMsg + ", " + this.firstMsgSeq);
        if (this.showAioMsg && this.firstMsgSeq == -1) {
            return;
        }
        al.b(this, this.host, data, listIsAtBottom);
    }

    public final void P(@NotNull final com.tencent.aio.data.msglist.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guildmedia.aio.msglist.list.data.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaMsgRepoDelegate.Q(GuildMediaMsgRepoDelegate.this, msg2);
            }
        }, null, 2, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return F(list);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void c() {
        ChannelAIOMsgService channelAIOMsgService = ChannelAIOMsgService.f112613a;
        Flow onEach = FlowKt.onEach(channelAIOMsgService.E(), new GuildMediaMsgRepoDelegate$registerNotification$1(this));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        FlowKt.launchIn(FlowKt.flowOn(onEach, zs.b.a(dispatchers)), r());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.y(), new GuildMediaMsgRepoDelegate$registerNotification$2(this)), zs.b.a(dispatchers)), r());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.x(), new GuildMediaMsgRepoDelegate$registerNotification$3(this)), zs.b.a(dispatchers)), r());
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        List sortedWith;
        CopyOnWriteArrayList copyOnWriteArrayList;
        List sortedWith2;
        List plus;
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        int G = G(displayList);
        if (G < 0 || G >= displayList.size()) {
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
            sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(displayList.subList(0, G), new b());
            plus = CollectionsKt___CollectionsKt.plus((Collection) sortedWith2, (Iterable) displayList.subList(G, displayList.size()));
            HashSet hashSet2 = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : plus) {
                if (hashSet2.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj2).getMsgId()))) {
                    arrayList2.add(obj2);
                }
            }
            copyOnWriteArrayList = new CopyOnWriteArrayList(arrayList2);
        }
        return R(new CopyOnWriteArrayList<>(F(copyOnWriteArrayList)));
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void l(@NotNull com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        super.l(context, scope);
        this.firstMsgSeq = vs0.a.a(context);
        this.showAioMsg = vs0.a.h(context);
    }

    private final CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> R(CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> displayList) {
        return displayList;
    }
}
