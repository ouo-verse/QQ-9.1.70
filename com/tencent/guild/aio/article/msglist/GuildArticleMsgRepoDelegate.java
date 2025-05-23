package com.tencent.guild.aio.article.msglist;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.article.data.GuildArticleMsgListCenter;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListEvent;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.util.x;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007*\u0002nq\u0018\u0000 v2\u00020\u0001:\u0001AB'\u0012\u0006\u0010W\u001a\u00020R\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010\\\u001a\u00020 \u0012\u0006\u0010^\u001a\u00020N\u00a2\u0006\u0004\bt\u0010uJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0016\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J\u0016\u0010\u001b\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0016\u0010\"\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0018H\u0002J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110$2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J\u0016\u0010'\u001a\u00020&2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J\u0016\u0010)\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110(H\u0002J \u0010-\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020&H\u0002J\u0018\u00101\u001a\u0002002\u0006\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020 H\u0002J\u0010\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0002J&\u00108\u001a\u00020\u00042\u0006\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020&2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0002J$\u0010<\u001a\u00020\u00162\f\u0010:\u001a\b\u0012\u0004\u0012\u00020 092\f\u0010;\u001a\b\u0012\u0004\u0012\u00020 09H\u0002J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020=H\u0016J\b\u0010@\u001a\u00020\u0004H\u0016J\b\u0010A\u001a\u00020\u0004H\u0016J\u0006\u0010B\u001a\u00020\u0004J\u0006\u0010C\u001a\u00020\u0004J\b\u0010D\u001a\u00020\u0004H\u0016J\u001e\u0010F\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010E\u001a\u00020&2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010I\u001a\u00020G2\u0006\u0010H\u001a\u00020GH\u0016J\b\u0010J\u001a\u00020\u0004H\u0016J\u0010\u0010K\u001a\u00020\u00042\u0006\u0010.\u001a\u00020 H\u0016J\u0018\u0010P\u001a\u00020\u00042\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020NH\u0016J\b\u0010Q\u001a\u00020\u0004H\u0016R\u0017\u0010W\u001a\u00020R8\u0006\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010<R\u0014\u0010^\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020 0g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010hR \u0010m\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010p\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010oR\u0014\u0010s\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010r\u00a8\u0006w"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgRepoDelegate;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/k;", "Lcom/tencent/guild/aio/article/data/h;", "result", "", "U", "b0", "a0", "d0", "c0", "T", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "n0", "o0", "e0", "Lcom/tencent/aio/data/msglist/a;", "msg", "k0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "u0", "", TabPreloadItem.TAB_NAME_MESSAGE, "m0", "l0", "y0", "oldMsgItem", "newMsgItem", "f0", "", "msgSeqList", "w0", "displayList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "v0", "", "M", "", "x0", "hasInsertReplayCountMsg", "displaySize", "commentCnt", "N", "msgSeq", "msgId", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "K", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "O", "firstPosition", "lastPosition", "msgItemList", "L", "", "curVisibleMsgSeqSet", "newVisibleMsgSeqSet", "J", "", "source", "i", "e", "a", ExifInterface.LATITUDE_SOUTH, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "c", com.tencent.luggage.wxa.c8.c.G, "z0", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "msgListWithOpType", DomainData.DOMAIN_NAME, "o", tl.h.F, "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "f", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "getMHost", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "mHost", "Lcom/tencent/guild/aio/article/data/GuildArticleMsgListCenter;", "g", "Lcom/tencent/guild/aio/article/data/GuildArticleMsgListCenter;", "mMsgListCenter", "mFirstUnreadMsgSeq", "Lkotlinx/coroutines/CoroutineScope;", "mRepoScope", "Laq0/a;", "j", "Laq0/a;", "mCombineMsgCenter", "Ljava/util/concurrent/atomic/AtomicBoolean;", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mHasReceivePushMsg", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "visibleMsgSeqSet", "Ljava/util/concurrent/ConcurrentHashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/concurrent/ConcurrentHashMap;", "backFillMsgMap", "com/tencent/guild/aio/article/msglist/GuildArticleMsgRepoDelegate$b", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgRepoDelegate$b;", "action", "com/tencent/guild/aio/article/msglist/GuildArticleMsgRepoDelegate$c", "Lcom/tencent/guild/aio/article/msglist/GuildArticleMsgRepoDelegate$c;", "mMsgListChangedObserver", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;Lcom/tencent/guild/aio/article/data/GuildArticleMsgListCenter;JLkotlinx/coroutines/CoroutineScope;)V", "p", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleMsgRepoDelegate extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgListRepo mHost;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildArticleMsgListCenter mMsgListCenter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long mFirstUnreadMsgSeq;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope mRepoScope;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final aq0.a mCombineMsgCenter;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean mHasReceivePushMsg;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArraySet<Long> visibleMsgSeqSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Long, Long> backFillMsgMap;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mMsgListChangedObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/article/msglist/GuildArticleMsgRepoDelegate$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildArticleMsgRepoDelegate.this.O(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/article/msglist/GuildArticleMsgRepoDelegate$c", "Ljava/util/Observer;", "Ljava/util/Observable;", "o", "", "arg", "", "update", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements Observer {
        c() {
        }

        @Override // java.util.Observer
        public void update(@Nullable Observable o16, @Nullable Object arg) {
            if (arg instanceof com.tencent.guild.aio.article.data.h) {
                GuildArticleMsgRepoDelegate.this.U((com.tencent.guild.aio.article.data.h) arg);
            }
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildArticleMsgRepoDelegate(@NotNull MsgListRepo mHost, @NotNull GuildArticleMsgListCenter mMsgListCenter, long j3, @NotNull CoroutineScope mRepoScope) {
        super(mHost);
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        Intrinsics.checkNotNullParameter(mMsgListCenter, "mMsgListCenter");
        Intrinsics.checkNotNullParameter(mRepoScope, "mRepoScope");
        this.mHost = mHost;
        this.mMsgListCenter = mMsgListCenter;
        this.mFirstUnreadMsgSeq = j3;
        this.mRepoScope = mRepoScope;
        this.mCombineMsgCenter = new aq0.a();
        this.mHasReceivePushMsg = new AtomicBoolean(false);
        this.visibleMsgSeqSet = new CopyOnWriteArraySet<>();
        this.backFillMsgMap = new ConcurrentHashMap<>();
        this.action = new b();
        this.mMsgListChangedObserver = new c();
    }

    private final boolean J(Set<Long> curVisibleMsgSeqSet, Set<Long> newVisibleMsgSeqSet) {
        if (curVisibleMsgSeqSet.size() == newVisibleMsgSeqSet.size() && curVisibleMsgSeqSet.containsAll(newVisibleMsgSeqSet)) {
            return false;
        }
        return true;
    }

    private final GuildMsgItem K(long msgSeq, long msgId) {
        return new GuildMsgItem(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createMsgItem(new ArrayList<>(), "", "", 0, 0, msgSeq, "", 0L, msgId).a());
    }

    private final void L(int firstPosition, int lastPosition, List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        GuildMsgItem guildMsgItem;
        QLog.d("GuildArticleMsgRepoDelegate", 1, "exposureVisibleMsgSeqList firstPosition = " + firstPosition + " lastPosition = " + lastPosition + " msgItemListSize = " + msgItemList.size());
        if (msgItemList.isEmpty()) {
            QLog.i("GuildArticleMsgRepoDelegate", 1, "[exposureVisibleMsgSeqList] msgItemList is empty!");
            return;
        }
        int i3 = firstPosition - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        int i16 = lastPosition + 1;
        if (i16 > msgItemList.size()) {
            i16 = msgItemList.size();
        }
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        for (int i17 = i3; i17 < i16; i17++) {
            com.tencent.aio.data.msglist.a aVar = msgItemList.get(i17);
            if (aVar instanceof GuildMsgItem) {
                guildMsgItem = (GuildMsgItem) aVar;
            } else {
                guildMsgItem = null;
            }
            if (guildMsgItem != null) {
                if (guildMsgItem.getMsgSeq() > 0) {
                    copyOnWriteArraySet.add(Long.valueOf(guildMsgItem.getMsgSeq()));
                }
                Long l3 = this.backFillMsgMap.get(Long.valueOf(aVar.getMsgId()));
                if (l3 != null && l3.longValue() > 0) {
                    if (l3.longValue() == aVar.getMsgSeq()) {
                        this.backFillMsgMap.remove(Long.valueOf(aVar.getMsgId()));
                    } else {
                        copyOnWriteArraySet.add(l3);
                    }
                }
                ReplyElement a16 = com.tencent.guild.api.data.msglist.a.a(guildMsgItem);
                if (a16 != null) {
                    Long l16 = a16.replayMsgSeq;
                    Intrinsics.checkNotNullExpressionValue(l16, "replyElement.replayMsgSeq");
                    if (l16.longValue() > 0) {
                        copyOnWriteArraySet.add(a16.replayMsgSeq);
                    }
                    Long l17 = a16.replayMsgRootSeq;
                    Intrinsics.checkNotNullExpressionValue(l17, "replyElement.replayMsgRootSeq");
                    if (l17.longValue() > 0) {
                        copyOnWriteArraySet.add(a16.replayMsgRootSeq);
                    }
                }
            }
        }
        if (copyOnWriteArraySet.isEmpty()) {
            QLog.d("GuildArticleMsgRepoDelegate", 1, "newVisibleMsgSeqSet empty!");
            return;
        }
        if (!J(this.visibleMsgSeqSet, copyOnWriteArraySet)) {
            QLog.d("GuildArticleMsgRepoDelegate", 1, "checkVisibleMsgSeqSetChanged false!");
            return;
        }
        this.visibleMsgSeqSet.clear();
        this.visibleMsgSeqSet.addAll(copyOnWriteArraySet);
        String str = "";
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.setCurOnScreenMsg(com.tencent.guild.api.msg.service.l.f112634a.d(d().g().r()), hashCode(), new ArrayList<>(this.visibleMsgSeqSet));
        }
        Iterator<T> it = this.visibleMsgSeqSet.iterator();
        while (it.hasNext()) {
            str = ((Object) str) + " msgSeq = " + ((Long) it.next());
        }
        QLog.d("GuildArticleMsgRepoDelegate", 1, "exposureMsg exposureVisibleMsgSeqList firstPosition = " + firstPosition + " lastPosition = " + lastPosition + " beginIndex = " + i3 + " endIndex = " + i16 + " visibleMsgSeqSetString = " + ((Object) str));
    }

    private final int M(List<? extends com.tencent.aio.data.msglist.a> displayList) {
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
            QLog.i("GuildArticleMsgRepoDelegate", 1, "getFirstLocalSendingMsgPos pos = " + size + ", seq: " + guildMsgItem.getMsgSeq() + ", id: " + guildMsgItem.getMsgId() + ", msgType: " + guildMsgItem.getMsgRecord().msgType + ", subMsgType: " + guildMsgItem.getMsgRecord().subMsgType + ", msgTime: " + guildMsgItem.getMsgRecord().msgTime + ", ");
            size2 = size + (-1);
        }
        QLog.i("GuildArticleMsgRepoDelegate", 1, "getFirstLocalSendingMsgPos pos = " + i3 + ", size = " + displayList.size());
        return i3;
    }

    private final int N(boolean hasInsertReplayCountMsg, int displaySize, int commentCnt) {
        if (this.mMsgListCenter.i() && this.mMsgListCenter.I()) {
            if (hasInsertReplayCountMsg) {
                return displaySize - 3;
            }
            return displaySize - 2;
        }
        return commentCnt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(final MsgIntent intent) {
        if (intent instanceof GuildMsgListIntent.ExposureVisibleMsgListEvent) {
            a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.article.msglist.s
                @Override // java.lang.Runnable
                public final void run() {
                    GuildArticleMsgRepoDelegate.P(GuildArticleMsgRepoDelegate.this, intent);
                }
            }, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(GuildArticleMsgRepoDelegate this$0, MsgIntent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        GuildMsgListIntent.ExposureVisibleMsgListEvent exposureVisibleMsgListEvent = (GuildMsgListIntent.ExposureVisibleMsgListEvent) intent;
        this$0.L(exposureVisibleMsgListEvent.getFirstPosition(), exposureVisibleMsgListEvent.getLastPosition(), exposureVisibleMsgListEvent.c());
    }

    private final void R(com.tencent.guild.aio.article.data.h result) {
        if (result.getIsSuccess() && (!result.b().isEmpty())) {
            d().e().h(new GuildArticleMsgListEvent.HideUnreadNavigateBubble());
            MsgList g16 = g();
            g16.clear();
            g16.addAll(result.b());
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            bVar.p(this.mHost, IMsgListRepository.MsgListRepoOpType.OtherOperation, g16, bVar.e("GuildArticleMsgRepoDelegate", "handleJumpToBottomMostResult"), com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(bVar, false, false, 2, null));
            return;
        }
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar2, this.mHost, IMsgListRepository.MsgListRepoOpType.OtherOperation, g(), bVar2.e("GuildArticleMsgRepoDelegate", "handleJumpToBottomMostResult"), null, 16, null);
    }

    private final void T(com.tencent.guild.aio.article.data.h result) {
        if (result.getIsSuccess() && (!result.b().isEmpty())) {
            MsgList g16 = g();
            g16.clear();
            g16.addAll(result.b());
        }
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        bVar.p(this.mHost, IMsgListRepository.MsgListRepoOpType.OtherOperation, g(), bVar.e("GuildArticleMsgRepoDelegate", "handleJumpToTopMostResult"), bVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(final com.tencent.guild.aio.article.data.h result) {
        int loadSource = result.getLoadSource();
        if (loadSource != 0) {
            if (loadSource != 1) {
                if (loadSource != 2) {
                    if (loadSource != 3) {
                        if (loadSource != 4) {
                            if (loadSource == 5) {
                                Dispatchers dispatchers = Dispatchers.INSTANCE;
                                if (zs.b.a(dispatchers).g()) {
                                    R(result);
                                    return;
                                } else {
                                    a.C11711a.b(zs.b.a(dispatchers), new Runnable() { // from class: com.tencent.guild.aio.article.msglist.r
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            GuildArticleMsgRepoDelegate.Z(GuildArticleMsgRepoDelegate.this, result);
                                        }
                                    }, null, 2, null);
                                    return;
                                }
                            }
                            return;
                        }
                        Dispatchers dispatchers2 = Dispatchers.INSTANCE;
                        if (zs.b.a(dispatchers2).g()) {
                            T(result);
                            return;
                        } else {
                            a.C11711a.b(zs.b.a(dispatchers2), new Runnable() { // from class: com.tencent.guild.aio.article.msglist.q
                                @Override // java.lang.Runnable
                                public final void run() {
                                    GuildArticleMsgRepoDelegate.Y(GuildArticleMsgRepoDelegate.this, result);
                                }
                            }, null, 2, null);
                            return;
                        }
                    }
                    a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.article.msglist.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildArticleMsgRepoDelegate.X(GuildArticleMsgRepoDelegate.this, result);
                        }
                    }, null, 2, null);
                    return;
                }
                a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.article.msglist.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildArticleMsgRepoDelegate.W(GuildArticleMsgRepoDelegate.this, result);
                    }
                }, null, 2, null);
                return;
            }
            d().e().h(new GuildArticleMsgListEvent.FirstPageMsgInitCompleted(result.getIsSuccess()));
            a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.article.msglist.n
                @Override // java.lang.Runnable
                public final void run() {
                    GuildArticleMsgRepoDelegate.V(GuildArticleMsgRepoDelegate.this, result);
                }
            }, null, 2, null);
            return;
        }
        b0(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(GuildArticleMsgRepoDelegate this$0, com.tencent.guild.aio.article.data.h result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        this$0.a0(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(GuildArticleMsgRepoDelegate this$0, com.tencent.guild.aio.article.data.h result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        this$0.d0(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(GuildArticleMsgRepoDelegate this$0, com.tencent.guild.aio.article.data.h result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        this$0.c0(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(GuildArticleMsgRepoDelegate this$0, com.tencent.guild.aio.article.data.h result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        this$0.T(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(GuildArticleMsgRepoDelegate this$0, com.tencent.guild.aio.article.data.h result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        this$0.R(result);
    }

    private final void a0(com.tencent.guild.aio.article.data.h result) {
        if (result.getIsSuccess() && (!result.b().isEmpty())) {
            MsgList g16 = g();
            g16.clear();
            g16.addAll(result.b());
            if (this.mMsgListCenter.j() == 1) {
                com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
                bVar.p(this.mHost, IMsgListRepository.MsgListRepoOpType.LoadFirst, g16, bVar.e("GuildArticleMsgRepoDelegate", "handleLoadFirstPageResult"), bVar.d());
                return;
            } else {
                if (this.mMsgListCenter.j() == 2) {
                    d().e().h(new GuildMsgNavigateEvent.GuildNavigateToMsgEvent("GuildArticleMsgRepoDelegate", this.mMsgListCenter.n()));
                    return;
                }
                return;
            }
        }
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar2, this.mHost, IMsgListRepository.MsgListRepoOpType.LoadFirst, g(), bVar2.e("GuildArticleMsgRepoDelegate", "handleLoadFirstPageResult"), null, 16, null);
    }

    private final void b0(com.tencent.guild.aio.article.data.h result) {
        MsgRecord msgRecord;
        if (result.getIsSuccess() && (!result.b().isEmpty())) {
            com.tencent.aio.data.msglist.a aVar = result.b().get(0);
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            msgRecord = ((GuildMsgItem) aVar).getMsgRecord();
        } else {
            msgRecord = null;
        }
        d().e().h(new GuildArticleMsgListEvent.MainMsgRecordInitCompleted(result.getIsSuccess(), msgRecord));
    }

    private final void c0(com.tencent.guild.aio.article.data.h result) {
        QLog.d("GuildArticleMsgRepoDelegate", 1, "handleLoadNextResult");
        if (result.getIsSuccess() && (true ^ result.b().isEmpty())) {
            MsgList g16 = g();
            g16.addAll(g16.size(), result.b());
            if (this.mHasReceivePushMsg.get() && this.mMsgListCenter.i()) {
                this.mHasReceivePushMsg.set(false);
                d().e().h(new GuildArticleMsgListEvent.HideUnreadNavigateBubble());
            }
        }
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, this.mHost, IMsgListRepository.MsgListRepoOpType.LoadNextPage, g(), bVar.e("GuildArticleMsgRepoDelegate", "handleLoadNextResult"), null, 16, null);
    }

    private final void d0(com.tencent.guild.aio.article.data.h result) {
        if (result.getIsSuccess() && (!result.b().isEmpty())) {
            g().addAll(0, result.b());
            p();
        }
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, this.mHost, IMsgListRepository.MsgListRepoOpType.LoadPrePage, g(), bVar.e("GuildArticleMsgRepoDelegate", "handleLoadPrePageResult"), null, 16, null);
    }

    private final void e0(FileTransNotifyInfo fileInfo) {
        if (fileInfo.fileDownType != 2) {
            return;
        }
        MsgList g16 = g();
        if ((!g16.isEmpty()) && g16.size() > 0) {
            Iterator<com.tencent.aio.data.msglist.a> it = g16.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int i16 = i3 + 1;
                com.tencent.aio.data.msglist.a iMsgItem = it.next();
                if (iMsgItem.getMsgId() == fileInfo.msgId) {
                    Intrinsics.checkNotNullExpressionValue(iMsgItem, "iMsgItem");
                    z0(iMsgItem, i3, fileInfo);
                    return;
                }
                i3 = i16;
            }
        }
    }

    private final boolean f0(com.tencent.aio.data.msglist.a oldMsgItem, com.tencent.aio.data.msglist.a newMsgItem) {
        if (newMsgItem.getMsgId() == oldMsgItem.getMsgId() && newMsgItem.getMsgSeq() != oldMsgItem.getMsgSeq()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(GuildArticleMsgRepoDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mMsgListCenter.G(this$0.mMsgListChangedObserver);
        this$0.mMsgListCenter.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(GuildArticleMsgRepoDelegate this$0) {
        Object lastOrNull;
        Long l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this$0.g());
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) lastOrNull;
        GuildArticleMsgListCenter guildArticleMsgListCenter = this$0.mMsgListCenter;
        if (aVar != null) {
            l3 = Long.valueOf(aVar.getMsgSeq());
        } else {
            l3 = null;
        }
        guildArticleMsgListCenter.s(l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(GuildArticleMsgRepoDelegate this$0) {
        Object firstOrNull;
        Long l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this$0.g());
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
        GuildArticleMsgListCenter guildArticleMsgListCenter = this$0.mMsgListCenter;
        if (aVar != null) {
            l3 = Long.valueOf(aVar.getMsgSeq());
        } else {
            l3 = null;
        }
        guildArticleMsgListCenter.t(l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(GuildArticleMsgRepoDelegate this$0, long j3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<com.tencent.aio.data.msglist.a> it = this$0.g().iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().getMsgSeq() == j3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            bVar.p(this$0.mHost, IMsgListRepository.MsgListRepoOpType.OtherOperation, this$0.g(), bVar.e("GuildArticleMsgRepoDelegate", "navigateToMsg"), bVar.f(j3));
        }
    }

    private final void k0(com.tencent.aio.data.msglist.a msg2) {
        String j3 = d().g().r().c().j();
        if (msg2 instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msg2;
            if (Intrinsics.areEqual(j3, guildMsgItem.getMsgRecord().peerUid) && u0(guildMsgItem.getMsgRecord())) {
                this.mMsgListCenter.v(msg2);
            }
        }
    }

    private final void l0(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String j3 = d().g().r().c().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : msgList) {
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) obj;
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            if (TextUtils.equals(((GuildMsgItem) aVar).getMsgRecord().peerUid, j3)) {
                arrayList.add(obj);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mMsgListCenter.L(arrayList);
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, this.mHost, IMsgListRepository.MsgListRepoOpType.LoadMessageUpdate, y0(arrayList), bVar.e("GuildArticleMsgRepoDelegate", "onMsgInfoListStatusUpdate"), null, 16, null);
        }
    }

    private final void m0(List<? extends com.tencent.aio.data.msglist.a> msgList) {
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
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
            if (!TextUtils.equals(guildMsgItem.getMsgRecord().peerUid, j3) || !u0(guildMsgItem.getMsgRecord())) {
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
            this.mHasReceivePushMsg.set(true);
            this.mMsgListCenter.B(msgList);
        }
    }

    private final void n0(FileTransNotifyInfo fileInfo) {
        e0(fileInfo);
        d().e().h(new GuildMsgSendEvent.RichMediaDownloadCompleteEvent(fileInfo));
    }

    private final void o0(FileTransNotifyInfo fileInfo) {
        e0(fileInfo);
        d().e().h(new GuildMsgSendEvent.RichMediaDownloadProgressEvent(fileInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object p0(GuildArticleMsgRepoDelegate guildArticleMsgRepoDelegate, com.tencent.aio.data.msglist.a aVar, Continuation continuation) {
        guildArticleMsgRepoDelegate.k0(aVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object q0(GuildArticleMsgRepoDelegate guildArticleMsgRepoDelegate, List list, Continuation continuation) {
        guildArticleMsgRepoDelegate.l0(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object r0(GuildArticleMsgRepoDelegate guildArticleMsgRepoDelegate, List list, Continuation continuation) {
        guildArticleMsgRepoDelegate.m0(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object s0(GuildArticleMsgRepoDelegate guildArticleMsgRepoDelegate, FileTransNotifyInfo fileTransNotifyInfo, Continuation continuation) {
        guildArticleMsgRepoDelegate.n0(fileTransNotifyInfo);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object t0(GuildArticleMsgRepoDelegate guildArticleMsgRepoDelegate, FileTransNotifyInfo fileTransNotifyInfo, Continuation continuation) {
        guildArticleMsgRepoDelegate.o0(fileTransNotifyInfo);
        return Unit.INSTANCE;
    }

    private final boolean u0(MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            if (msgElement.elementType == 7) {
                ReplyElement replyElement = msgElement.replyElement;
                if (replyElement == null) {
                    return false;
                }
                Long l3 = replyElement.replayMsgRootSeq;
                long m3 = this.mMsgListCenter.m();
                if (l3 == null || l3.longValue() != m3) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private final CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> v0(List<? extends com.tencent.aio.data.msglist.a> displayList) {
        List sortedWith;
        List sortedWith2;
        List plus;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = displayList.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) next;
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            MsgRecord msgRecord = ((GuildMsgItem) aVar).getMsgRecord();
            if (msgRecord.msgType == 9 || msgRecord.msgId == this.mMsgListCenter.k()) {
                z16 = true;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        int M = M(arrayList);
        if (M < 0 || M >= arrayList.size()) {
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new e());
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : sortedWith) {
                if (hashSet.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj).getMsgId()))) {
                    arrayList2.add(obj);
                }
            }
            return new CopyOnWriteArrayList<>(arrayList2);
        }
        sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(arrayList.subList(0, M), new d());
        plus = CollectionsKt___CollectionsKt.plus((Collection) sortedWith2, (Iterable) arrayList.subList(M, arrayList.size()));
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : plus) {
            if (hashSet2.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj2).getMsgId()))) {
                arrayList3.add(obj2);
            }
        }
        return new CopyOnWriteArrayList<>(arrayList3);
    }

    private final void w0(List<Long> msgSeqList) {
        List<Long> list = msgSeqList;
        if (!list.isEmpty()) {
            this.visibleMsgSeqSet.addAll(list);
            String str = "";
            uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
            if (gProGuildMsgService != null) {
                gProGuildMsgService.setCurOnScreenMsg(com.tencent.guild.api.msg.service.l.f112634a.d(d().g().r()), hashCode(), new ArrayList<>(this.visibleMsgSeqSet));
            }
            Iterator<T> it = this.visibleMsgSeqSet.iterator();
            while (it.hasNext()) {
                str = ((Object) str) + " msgSeq = " + ((Long) it.next());
            }
            QLog.d("GuildArticleMsgRepoDelegate", 1, "article exposureMsg tryToExposureBackFillMsg visibleMsgSeqSetString = " + ((Object) str));
        }
    }

    private final void x0(List<com.tencent.aio.data.msglist.a> displayList) {
        Object first;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) displayList);
        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) first;
        if (guildMsgItem.getMsgSeq() != this.mMsgListCenter.m()) {
            return;
        }
        boolean z16 = false;
        if (TextUtils.isEmpty(GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, "guild_article_is_main_empty_msg", null, 2, null))) {
            guildMsgItem.saveExtInfoToExtStr("guild_article_is_main_msg", "1");
            GuildMsgItem K = K(guildMsgItem.getMsgSeq(), 1L);
            K.saveExtInfoToExtStr("guild_article_is_main_empty_msg", "1");
            displayList.add(0, K);
        }
        com.tencent.aio.data.msglist.a aVar = displayList.get(1);
        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem2 = (GuildMsgItem) aVar;
        if (displayList.size() > 2) {
            com.tencent.aio.data.msglist.a aVar2 = displayList.get(2);
            Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            if (!TextUtils.isEmpty(GuildMsgItem.getExtInfoFromExtStr$default((GuildMsgItem) aVar2, "guild_article_is_main_reply_count_msg", null, 2, null))) {
                z16 = true;
            }
        }
        int N = N(z16, displayList.size(), (int) guildMsgItem2.getMsgRecord().commentCnt);
        if (N > 0) {
            if (z16) {
                com.tencent.aio.data.msglist.a aVar3 = displayList.get(2);
                Intrinsics.checkNotNull(aVar3, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                ((GuildMsgItem) aVar3).saveExtInfoToExtStr("guild_article_main_reply_count", String.valueOf(N));
                return;
            }
            GuildMsgItem K2 = K(guildMsgItem2.getMsgSeq(), 2L);
            K2.saveExtInfoToExtStr("guild_article_is_main_reply_count_msg", "1");
            K2.saveExtInfoToExtStr("guild_article_main_reply_count", String.valueOf(N));
            if (displayList.size() > 2) {
                displayList.add(2, K2);
            } else {
                displayList.add(K2);
            }
        }
    }

    private final List<com.tencent.aio.data.msglist.a> y0(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        MsgList g16 = g();
        if (g16.isEmpty()) {
            return g16;
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.aio.data.msglist.a aVar : msgList) {
            int size = g16.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (aVar.getMsgId() == g16.get(i3).getMsgId()) {
                    com.tencent.aio.data.msglist.a aVar2 = g16.get(i3);
                    Intrinsics.checkNotNullExpressionValue(aVar2, "displayList[i]");
                    if (f0(aVar2, aVar)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("GuildArticleMsgRepoDelegate", 1, "isBackFillMsg msgId = " + aVar.getMsgId() + " msgSeq = " + aVar.getMsgSeq());
                        }
                        this.backFillMsgMap.put(Long.valueOf(aVar.getMsgId()), Long.valueOf(aVar.getMsgSeq()));
                        arrayList.add(Long.valueOf(aVar.getMsgSeq()));
                    }
                    g16.set(i3, aVar);
                    if (aVar.getMsgId() == this.mMsgListCenter.k()) {
                        com.tencent.mvi.base.route.j e16 = d().e();
                        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                        e16.h(new GuildArticleMsgListEvent.MainMsgInfoUpdated(((GuildMsgItem) aVar).getMsgRecord()));
                    }
                }
            }
        }
        w0(arrayList);
        ArrayList arrayList2 = new ArrayList(g16);
        g16.clear();
        g16.addAll(arrayList2);
        return g16;
    }

    public final void Q() {
        this.mMsgListCenter.o();
    }

    public final void S() {
        this.mMsgListCenter.p();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void a() {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.article.msglist.j
            @Override // java.lang.Runnable
            public final void run() {
                GuildArticleMsgRepoDelegate.h0(GuildArticleMsgRepoDelegate.this);
            }
        }, null, 2, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void c() {
        ChannelAIOMsgService channelAIOMsgService = ChannelAIOMsgService.f112613a;
        Flow onEach = FlowKt.onEach(channelAIOMsgService.E(), new GuildArticleMsgRepoDelegate$registerNotification$1(this));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        FlowKt.launchIn(FlowKt.flowOn(onEach, zs.b.a(dispatchers)), this.mRepoScope);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.y(), new GuildArticleMsgRepoDelegate$registerNotification$2(this)), zs.b.a(dispatchers)), this.mRepoScope);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.x(), new GuildArticleMsgRepoDelegate$registerNotification$3(this)), zs.b.a(dispatchers)), this.mRepoScope);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.B(), new GuildArticleMsgRepoDelegate$registerNotification$4(this)), zs.b.a(dispatchers)), this.mRepoScope);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.C(), new GuildArticleMsgRepoDelegate$registerNotification$5(this)), zs.b.a(dispatchers)), this.mRepoScope);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void e() {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.article.msglist.l
            @Override // java.lang.Runnable
            public final void run() {
                GuildArticleMsgRepoDelegate.i0(GuildArticleMsgRepoDelegate.this);
            }
        }, null, 2, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void h(final long msgSeq) {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.article.msglist.k
            @Override // java.lang.Runnable
            public final void run() {
                GuildArticleMsgRepoDelegate.j0(GuildArticleMsgRepoDelegate.this, msgSeq);
            }
        }, null, 2, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.guild.aio.article.msglist.m
            @Override // java.lang.Runnable
            public final void run() {
                GuildArticleMsgRepoDelegate.g0(GuildArticleMsgRepoDelegate.this);
            }
        });
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void l(@NotNull com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        super.l(context, scope);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.ExposureVisibleMsgListEvent.class).getQualifiedName(), this.action);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l n(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l msgListWithOpType) {
        Intrinsics.checkNotNullParameter(msgListWithOpType, "msgListWithOpType");
        List<com.tencent.aio.data.msglist.a> c16 = msgListWithOpType.c();
        if (c16.isEmpty()) {
            return super.n(msgListWithOpType);
        }
        for (com.tencent.aio.data.msglist.a aVar : c16) {
            if (this.mFirstUnreadMsgSeq != 0) {
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                if (com.tencent.guild.api.data.msglist.a.b((GuildMsgItem) aVar) && aVar.getMsgSeq() == this.mFirstUnreadMsgSeq) {
                    ((GuildMsgItem) aVar).saveExtInfoToExtStr("guild_first_unread_msg_seq_json_key", "1");
                }
            }
        }
        CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> v06 = v0(c16);
        if (v06.isEmpty()) {
            return super.n(msgListWithOpType);
        }
        x0(v06);
        this.mCombineMsgCenter.g(v06);
        for (com.tencent.aio.data.msglist.a aVar2 : v06) {
            if (aVar2 instanceof GuildMsgItem) {
                ((GuildMsgItem) aVar2).saveExtInfoToExtStr("ban_convert_view_holder_type", "1");
            }
        }
        return super.n(new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l(v06, msgListWithOpType.d(), msgListWithOpType.b(), msgListWithOpType.a()));
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void o() {
        Object last;
        MsgList g16 = g();
        if ((!g16.isEmpty()) && this.mHost.E().d() != null) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) g16);
            long msgId = ((com.tencent.aio.data.msglist.a) last).getMsgId();
            com.tencent.aio.data.msglist.a d16 = this.mHost.E().d();
            Intrinsics.checkNotNull(d16);
            if (msgId == d16.getMsgId()) {
                com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
                bVar.p(this.mHost, IMsgListRepository.MsgListRepoOpType.OtherOperation, g(), bVar.e("GuildArticleMsgRepoDelegate", "navigateToBottom"), com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(bVar, false, false, 2, null));
            }
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void onDestroy() {
        super.onDestroy();
        this.mMsgListCenter.H(this.mMsgListChangedObserver);
        d().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.ExposureVisibleMsgListEvent.class).getQualifiedName(), this.action);
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.setCurOnScreenMsg(com.tencent.guild.api.msg.service.l.f112634a.d(d().g().r()), hashCode(), new ArrayList<>());
        }
    }

    public final void z0(@NotNull com.tencent.aio.data.msglist.a msg2, int pos, @NotNull FileTransNotifyInfo fileInfo) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        MsgRecord msgRecord = ((GuildMsgItem) msg2).getMsgRecord();
        int i3 = msgRecord.msgType;
        int i16 = 0;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 7) {
                    int size = msgRecord.elements.size();
                    while (i16 < size) {
                        if (msgRecord.elements.get(i16).elementId == fileInfo.msgElementId) {
                            if (msgRecord.elements.get(i16).videoElement != null) {
                                msgRecord.elements.get(i16).videoElement.transferStatus = Integer.valueOf(fileInfo.trasferStatus);
                                VideoElement videoElement = msgRecord.elements.get(i16).videoElement;
                                x xVar = x.f112474a;
                                MsgElement msgElement = msgRecord.elements.get(i16);
                                Intrinsics.checkNotNullExpressionValue(msgElement, "msgRecord.elements[i]");
                                videoElement.progress = Integer.valueOf(xVar.b(msgElement, 5, fileInfo.fileProgress));
                                d().e().h(new GuildArticleMsgListEvent.UpdateMsgItemState(pos));
                                return;
                            }
                            return;
                        }
                        i16++;
                    }
                    return;
                }
                return;
            }
            ArrayList<MsgElement> arrayList = msgRecord.elements;
            if (arrayList != null && arrayList.size() > 0) {
                int size2 = msgRecord.elements.size();
                while (i16 < size2) {
                    if (msgRecord.elements.get(i16).elementId == fileInfo.msgElementId) {
                        if (msgRecord.elements.get(i16).fileElement != null) {
                            msgRecord.elements.get(i16).fileElement.transferStatus = Integer.valueOf(fileInfo.trasferStatus);
                            FileElement fileElement = msgRecord.elements.get(i16).fileElement;
                            x xVar2 = x.f112474a;
                            MsgElement msgElement2 = msgRecord.elements.get(i16);
                            Intrinsics.checkNotNullExpressionValue(msgElement2, "msgRecord.elements[i]");
                            fileElement.progress = Integer.valueOf(xVar2.b(msgElement2, 3, fileInfo.fileProgress));
                            d().e().h(new GuildArticleMsgListEvent.UpdateMsgItemState(pos));
                            return;
                        }
                        return;
                    }
                    i16++;
                }
                return;
            }
            return;
        }
        ArrayList<MsgElement> arrayList2 = msgRecord.elements;
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size3 = msgRecord.elements.size();
            while (i16 < size3) {
                if (msgRecord.elements.get(i16).elementId == fileInfo.msgElementId) {
                    if (msgRecord.elements.get(i16).picElement != null) {
                        msgRecord.elements.get(i16).picElement.transferStatus = Integer.valueOf(fileInfo.trasferStatus);
                        PicElement picElement = msgRecord.elements.get(i16).picElement;
                        x xVar3 = x.f112474a;
                        MsgElement msgElement3 = msgRecord.elements.get(i16);
                        Intrinsics.checkNotNullExpressionValue(msgElement3, "msgRecord.elements[i]");
                        picElement.progress = Integer.valueOf(xVar3.b(msgElement3, 2, fileInfo.fileProgress));
                        d().e().h(new GuildArticleMsgListEvent.UpdateMsgItemState(pos));
                        return;
                    }
                    return;
                }
                i16++;
            }
        }
    }
}
