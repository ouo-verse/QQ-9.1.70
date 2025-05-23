package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.highlight.BeforeNavigateToMsgEvent;
import com.tencent.guild.aio.msglist.reply.GuildUpdateReplyMsgOnMsgRevoke;
import com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgItem;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ws.a;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0002ei\u0018\u0000 y2\u00020\u0001:\u0001GB\u0017\u0012\u0006\u0010u\u001a\u00020;\u0012\u0006\u0010v\u001a\u00020=\u00a2\u0006\u0004\bw\u0010xJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0002J\u0016\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\u0016\u0010\u001f\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 H\u0002J\u0016\u0010#\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0016\u0010$\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0016\u0010%\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0016\u0010&\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010/\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J$\u00103\u001a\u00020\u00112\f\u00101\u001a\b\u0012\u0004\u0012\u00020\f002\f\u00102\u001a\b\u0012\u0004\u0012\u00020\f00H\u0002J\b\u00104\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020\u0004H\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\u0010\u00107\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0014\u00108\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tJ\u0014\u00109\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tJ\u0014\u0010:\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tJ\u0006\u0010<\u001a\u00020;J\u0006\u0010>\u001a\u00020=J\b\u0010?\u001a\u00020\u0004H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@H\u0016J\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00020D2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00020DH\u0016J\b\u0010G\u001a\u00020\u0004H\u0016J\b\u0010H\u001a\u00020\u0004H\u0016J\u0018\u0010K\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\fH\u0016J\b\u0010L\u001a\u00020\u0004H\u0016J\u0010\u0010M\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010N\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010O\u001a\u00020\u0004H\u0016J\u0006\u0010P\u001a\u00020\u0011R\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010VR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020\f0m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR \u0010t\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010s\u00a8\u0006z"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgListRepo;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "Lcom/tencent/aio/data/msglist/a;", "msg", "", "U0", "Lcom/tencent/aio/msgservice/h;", "rsp", "D0", "", TabPreloadItem.TAB_NAME_MESSAGE, "W0", "", "msgSeq", "m1", "it", "M0", "", ICustomDataEditor.NUMBER_PARAM_1, "oldMsgItem", "newMsgItem", "P0", "msgSeqList", "j1", "", "removeMsgSeq", "o1", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListIntent$GuildMsgListScrollEvent;", "event", "J0", "O0", "V0", "Lcom/tencent/aio/msgservice/c;", "req", "F0", "G0", "E0", "L0", "K0", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "A0", "l1", "", "firstPosition", "lastPosition", "msgItemList", "x0", "", "curVisibleMsgSeqSet", "newVisibleMsgSeqSet", "w0", "i1", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "c", "Y0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "X0", "c1", "Lcom/tencent/aio/api/runtime/a;", "y0", "Lkotlinx/coroutines/CoroutineScope;", "z0", "L", "", "source", "displayList", "k", "", "list", "b", "a", "e", "beginMsgSeq", "endMsgSeq", "f", "o", tl.h.F, "k1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "N0", "Ljava/lang/Object;", "l", "Ljava/lang/Object;", "msgSeqlock", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "aioBottomMsgSeq", DomainData.DOMAIN_NAME, "latestAioMsgSeq", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgProcessor;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgProcessor;", "msgProcessor", "Ljava/util/concurrent/atomic/AtomicLong;", "p", "Ljava/util/concurrent/atomic/AtomicLong;", "navigateSeq", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildAIOMsgEventDispatcher;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildAIOMsgEventDispatcher;", "aioMsgEventDispatcher", "com/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgListRepo$b", "r", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgListRepo$b;", "action", "com/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgListRepo$c", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgListRepo$c;", "beforeNavigateToMsgNotifier", "Ljava/util/concurrent/CopyOnWriteArraySet;", "t", "Ljava/util/concurrent/CopyOnWriteArraySet;", "visibleMsgSeqSet", "Ljava/util/concurrent/ConcurrentHashMap;", "u", "Ljava/util/concurrent/ConcurrentHashMap;", "backFillMsgMap", "aioContext", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "v", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMsgListRepo extends MsgListRepo {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Object msgSeqlock;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long aioBottomMsgSeq;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long latestAioMsgSeq;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildMsgProcessor msgProcessor;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicLong navigateSeq;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildAIOMsgEventDispatcher aioMsgEventDispatcher;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c beforeNavigateToMsgNotifier;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArraySet<Long> visibleMsgSeqSet;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Long, Long> backFillMsgMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgListRepo$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildMsgListRepo.this.A0(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgListRepo$c", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/v;", "", "msgSeq", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements v {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f110514a;

        c(com.tencent.aio.api.runtime.a aVar) {
            this.f110514a = aVar;
        }

        @Override // com.tencent.guild.aio.factory.business.holder.msglist.data.guild.v
        public void a(long msgSeq) {
            this.f110514a.e().h(new BeforeNavigateToMsgEvent("GuildMsgListRepo", msgSeq));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMsgListRepo(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.msgSeqlock = new Object();
        this.aioBottomMsgSeq = -1L;
        this.latestAioMsgSeq = -1L;
        this.msgProcessor = new GuildMsgProcessor(this);
        this.navigateSeq = new AtomicLong(0L);
        this.aioMsgEventDispatcher = new GuildAIOMsgEventDispatcher(aioContext, scope);
        this.action = new b();
        this.beforeNavigateToMsgNotifier = new c(aioContext);
        this.visibleMsgSeqSet = new CopyOnWriteArraySet<>();
        this.backFillMsgMap = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(final MsgIntent i3) {
        if (i3 instanceof GuildMsgNavigateEvent.GuildNavigateToMsgEvent) {
            GuildMsgNavigateEvent.GuildNavigateToMsgEvent guildNavigateToMsgEvent = (GuildMsgNavigateEvent.GuildNavigateToMsgEvent) i3;
            D().e().h(new BeforeNavigateToMsgEvent("GuildMsgListRepo", guildNavigateToMsgEvent.getMsgSeq()));
            A(guildNavigateToMsgEvent.getMsgSeq());
            return;
        }
        if (i3 instanceof GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent) {
            z();
            return;
        }
        if (i3 instanceof GuildMsgNavigateEvent.NotifyMsgFocusBottomEvent) {
            a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.g
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgListRepo.B0(GuildMsgListRepo.this);
                }
            }, null, 2, null);
            return;
        }
        if (i3 instanceof GuildMsgNavigateEvent.NavigateCompleteEvent) {
            i1();
            return;
        }
        if (i3 instanceof GuildMsgListIntent.ExposureVisibleMsgListEvent) {
            a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.h
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMsgListRepo.C0(GuildMsgListRepo.this, i3);
                }
            }, null, 2, null);
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GuildMsgListScrollEvent) {
            J0((GuildMsgListIntent.GuildMsgListScrollEvent) i3);
        } else if (i3 instanceof GuildMsgListIntent.LoadFirstPageFinEvent) {
            this.msgProcessor.j();
            D().e().h(GuildMsgListIntent.AfterLoadFirstPageFinEvent.f110403d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(GuildMsgListRepo this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.O0()) {
            QLog.i("GuildMsgListRepo", 1, "handleAction NotifyMsgFocusBottomEvent");
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            bVar.p(this$0, IMsgListRepository.MsgListRepoOpType.OtherOperation, this$0.M(), bVar.e("GuildMsgListRepo", "NotifyMsgFocusBottomEvent"), com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(bVar, false, false, 2, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(GuildMsgListRepo this$0, MsgIntent i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(i3, "$i");
        GuildMsgListIntent.ExposureVisibleMsgListEvent exposureVisibleMsgListEvent = (GuildMsgListIntent.ExposureVisibleMsgListEvent) i3;
        this$0.x0(exposureVisibleMsgListEvent.getFirstPosition(), exposureVisibleMsgListEvent.getLastPosition(), exposureVisibleMsgListEvent.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp, com.tencent.aio.data.msglist.a msg2) {
        QLog.i("GuildMsgListRepo", 1, "handleAddLocalSendMsg, succ = " + rsp.d() + ", data size = " + rsp.a().size());
        M().clear();
        M().addAll(rsp.a());
        M().add(msg2);
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        bVar.p(this, IMsgListRepository.MsgListRepoOpType.LoadSendMessage, M(), bVar.e("GuildMsgListRepo", "handleAddLocalSendMsg"), com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(bVar, false, false, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        Object firstOrNull;
        Long l3;
        Object lastOrNull;
        AIOParam g16 = D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgListRepo", 1, "handleBottomPage, channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", succ = " + rsp.d() + ", data size = " + rsp.a().size());
        if (rsp.d() && (!rsp.a().isEmpty())) {
            AIOParam g17 = D().g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g17);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
            Long l16 = null;
            if (aVar != null) {
                l3 = Long.valueOf(aVar.getMsgSeq());
            } else {
                l3 = null;
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) lastOrNull;
            if (aVar2 != null) {
                l16 = Long.valueOf(aVar2.getMsgSeq());
            }
            QLog.i("GuildMsgListRepo", 1, "handleBottomPage, channelId = " + b16 + ", firstSeq = " + l3 + " lastSeq = " + l16 + "}");
            M().addAll(rsp.a());
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, this, IMsgListRepository.MsgListRepoOpType.LoadNextPage, M(), bVar.e("GuildMsgListRepo", bVar.e("GuildMsgListRepo", "handleBottomPage")), null, 16, null);
            ao0.d.j(ao0.d.f26594a, rsp.a(), D(), false, 4, null);
            return;
        }
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar2, this, IMsgListRepository.MsgListRepoOpType.LoadNextPageFail, M(), bVar2.e("GuildMsgListRepo", bVar2.e("GuildMsgListRepo", "handleBottomPage")), null, 16, null);
    }

    private final boolean F0(com.tencent.aio.msgservice.c req) {
        boolean z16;
        if (D().g().l().getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        AIOParam g16 = D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgListRepo", 1, "handleDirectMsgFlag, channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", isDirectMsg: " + z16);
        if (!z16) {
            return false;
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.r(new com.tencent.aio.msgservice.f(req.a(), 0L, req.b(), true)), new GuildMsgListRepo$handleDirectMsgFlag$1(this, null)), Dispatchers.getMain()), J());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(final com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.m
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgListRepo.H0(GuildMsgListRepo.this, rsp);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(final GuildMsgListRepo this$0, com.tencent.aio.msgservice.h rsp) {
        Object firstOrNull;
        Long l3;
        Object lastOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        AIOParam g16 = this$0.D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgListRepo", 1, "[handleFirstPage], channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", succ = " + rsp.d() + ", data size = " + rsp.a().size());
        if (rsp.d() && (!rsp.a().isEmpty())) {
            AIOParam g17 = this$0.D().g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g17);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
            Long l16 = null;
            if (aVar != null) {
                l3 = Long.valueOf(aVar.getMsgSeq());
            } else {
                l3 = null;
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) lastOrNull;
            if (aVar2 != null) {
                l16 = Long.valueOf(aVar2.getMsgSeq());
            }
            QLog.i("GuildMsgListRepo", 1, "[handleFirstPage], channelId = " + b16 + ", firstSeq = " + l3 + " lastSeq = " + l16 + "}");
            MsgList M = this$0.M();
            M.clear();
            M.addAll(rsp.a());
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            bVar.p(this$0, IMsgListRepository.MsgListRepoOpType.LoadFirst, this$0.M(), bVar.e("GuildMsgListRepo", "handleFirstPage"), bVar.b(false, false));
            final long j3 = this$0.D().g().l().getLong("navigate_msg_seq", 0L);
            this$0.D().g().l().putLong("navigate_msg_seq", 0L);
            if (j3 != 0) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildMsgListRepo.I0(GuildMsgListRepo.this, j3);
                    }
                }, 100L);
            }
            ao0.d.j(ao0.d.f26594a, rsp.a(), this$0.D(), false, 4, null);
        } else {
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar2, this$0, IMsgListRepository.MsgListRepoOpType.LoadFirstPageFail, this$0.M(), bVar2.e("GuildMsgListRepo", "handleFirstPage"), null, 16, null);
        }
        this$0.D().e().h(GuildMsgListIntent.AfterLoadFirstPageFinEvent.f110403d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(GuildMsgListRepo this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h(j3);
    }

    private final void J0(GuildMsgListIntent.GuildMsgListScrollEvent event) {
        long j3;
        synchronized (this.msgSeqlock) {
            GuildMsgItem aioBottomMsg = event.getAioBottomMsg();
            long j16 = -1;
            if (aioBottomMsg != null) {
                j3 = aioBottomMsg.getMsgSeq();
            } else {
                j3 = -1;
            }
            this.aioBottomMsgSeq = j3;
            GuildMsgItem latestAioMsg = event.getLatestAioMsg();
            if (latestAioMsg != null) {
                j16 = latestAioMsg.getMsgSeq();
            }
            this.latestAioMsgSeq = j16;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        Object firstOrNull;
        Long l3;
        Object lastOrNull;
        Object firstOrNull2;
        Object firstOrNull3;
        Object firstOrNull4;
        AIOParam g16 = D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgListRepo", 1, "handleRangeResp, channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", succ = " + rsp.d() + ", data size = " + rsp.a().size());
        if (rsp.d() && (!rsp.a().isEmpty())) {
            AIOParam g17 = D().g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g17);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
            Long l16 = null;
            if (aVar != null) {
                l3 = Long.valueOf(aVar.getMsgSeq());
            } else {
                l3 = null;
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) lastOrNull;
            if (aVar2 != null) {
                l16 = Long.valueOf(aVar2.getMsgSeq());
            }
            QLog.i("GuildMsgListRepo", 1, "handleRangeResp, channelId = " + b16 + ", firstSeq = " + l3 + " lastSeq = " + l16 + "}");
            MsgList M = M();
            M.clear();
            M.addAll(rsp.a());
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) M);
            long j3 = 0;
            if (firstOrNull2 instanceof GuildWelcomeMsgItem) {
                firstOrNull4 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) rsp.a());
                com.tencent.aio.data.msglist.a aVar3 = (com.tencent.aio.data.msglist.a) firstOrNull4;
                if (aVar3 != null) {
                    j3 = aVar3.getMsgSeq();
                }
            } else {
                firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) M);
                com.tencent.aio.data.msglist.a aVar4 = (com.tencent.aio.data.msglist.a) firstOrNull3;
                if (aVar4 != null) {
                    j3 = aVar4.getMsgSeq();
                }
            }
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            bVar.p(this, IMsgListRepository.MsgListRepoOpType.LoadRangePage, M(), bVar.e("GuildMsgListRepo", "handleRangeResp"), bVar.f(j3));
            return;
        }
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a, this, IMsgListRepository.MsgListRepoOpType.LoadRangePageFail, M(), "handleRangeResp", null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        Object firstOrNull;
        Long l3;
        Object lastOrNull;
        AIOParam g16 = D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgListRepo", 1, "handleTopPage, channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", succ = " + rsp.d() + ", data size = " + rsp.a().size());
        if (rsp.d() && (!rsp.a().isEmpty())) {
            AIOParam g17 = D().g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g17);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
            Long l16 = null;
            if (aVar != null) {
                l3 = Long.valueOf(aVar.getMsgSeq());
            } else {
                l3 = null;
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) lastOrNull;
            if (aVar2 != null) {
                l16 = Long.valueOf(aVar2.getMsgSeq());
            }
            QLog.i("GuildMsgListRepo", 1, "handleTopPage, channelId = " + b16 + ", firstSeq = " + l3 + " lastSeq = " + l16 + "}");
            M().addAll(0, rsp.a());
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, this, IMsgListRepository.MsgListRepoOpType.LoadPrePage, M(), bVar.e("GuildMsgListRepo", "handleTopPage"), null, 16, null);
            ao0.d.j(ao0.d.f26594a, rsp.a(), D(), false, 4, null);
            return;
        }
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar2, this, IMsgListRepository.MsgListRepoOpType.LoadPrePageFail, M(), bVar2.e("GuildMsgListRepo", "handleTopPage"), null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(long msgSeq, com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> it) {
        boolean z16;
        Long l3;
        Object lastOrNull;
        Long l16;
        if (H() != null) {
            com.tencent.aio.data.msglist.a H = H();
            Intrinsics.checkNotNull(H);
            if (msgSeq < H.getMsgSeq()) {
                return;
            }
        }
        if (it.d() && (!it.a().isEmpty())) {
            int size = it.a().size() - 1;
            while (true) {
                if (-1 < size) {
                    if (it.a().get(size) instanceof GuildMsgItem) {
                        com.tencent.aio.data.msglist.a aVar = it.a().get(size);
                        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                        if (((GuildMsgItem) aVar).getMsgRecord().msgType != 1) {
                            AIOParam g16 = D().g();
                            Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
                            String b16 = com.tencent.guild.aio.util.a.b(g16);
                            com.tencent.aio.data.msglist.a H2 = H();
                            if (H2 != null) {
                                l3 = Long.valueOf(H2.getMsgSeq());
                            } else {
                                l3 = null;
                            }
                            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) it.a());
                            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) lastOrNull;
                            if (aVar2 != null) {
                                l16 = Long.valueOf(aVar2.getMsgSeq());
                            } else {
                                l16 = null;
                            }
                            QLog.i("GuildMsgListRepo", 1, "updateLastMsg, channelId = " + b16 + ",aioLastShowMsg old seq = " + l3 + ", new seq = " + l16);
                            E().i(it.a().get(size));
                            z16 = true;
                        }
                    }
                    size--;
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                QLog.i("GuildMsgListRepo", 1, "updateLastMsg, aioLastShowMsg = null");
                E().i(null);
            }
            D().e().h(new GuildMsgListIntent.GuildAioLastShowMsgLower(E().d()));
            a.C11505a.a(this, IMsgListRepository.MsgListRepoOpType.OtherOperation, null, null, 6, null);
        }
    }

    private final boolean O0() {
        boolean z16;
        boolean z17;
        synchronized (this.msgSeqlock) {
            long j3 = this.aioBottomMsgSeq;
            long j16 = this.latestAioMsgSeq;
            z16 = false;
            if (j3 == j16) {
                z17 = true;
            } else {
                z17 = false;
            }
            QLog.i("GuildMsgListRepo", 1, "isAtBottom: " + z17 + " aioBottomMsgSeq:" + j3 + " latestAioMsgSeq:" + j16);
            if (this.aioBottomMsgSeq == this.latestAioMsgSeq) {
                z16 = true;
            }
        }
        return z16;
    }

    private final boolean P0(com.tencent.aio.data.msglist.a oldMsgItem, com.tencent.aio.data.msglist.a newMsgItem) {
        if (newMsgItem.getMsgId() == oldMsgItem.getMsgId() && newMsgItem.getMsgSeq() != oldMsgItem.getMsgSeq()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(GuildMsgListRepo this$0) {
        Object lastOrNull;
        Long l3;
        Long l16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this$0.M());
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) lastOrNull;
        AIOParam g16 = this$0.D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        if (aVar != null) {
            l3 = Long.valueOf(aVar.getMsgSeq());
        } else {
            l3 = null;
        }
        if (aVar != null) {
            l16 = Long.valueOf(aVar.getMsgId());
        } else {
            l16 = null;
        }
        QLog.i("GuildMsgListRepo", 1, "loadBottomPage, channelId = " + b16 + ", bottomMsg seq = " + l3 + ", msgId = " + l16);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.i(new com.tencent.aio.msgservice.b(this$0.D().g().r(), aVar, 20)), new GuildMsgListRepo$loadNextPage$1$1(this$0, null)), zs.b.a(Dispatchers.INSTANCE)), this$0.J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(GuildMsgListRepo this$0) {
        Object firstOrNull;
        Object firstOrNull2;
        Long l3;
        Long l16;
        Long l17;
        Long l18;
        com.tencent.aio.data.msglist.a a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this$0.M());
        if (Intrinsics.areEqual(this$0.D().g().n(), com.tencent.guild.aio.factory.a.class.getName()) && (a16 = this$0.E().a()) != null) {
            firstOrNull = a16;
        }
        AIOParam g16 = this$0.D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this$0.M());
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull2;
        if (aVar != null) {
            l3 = Long.valueOf(aVar.getMsgSeq());
        } else {
            l3 = null;
        }
        com.tencent.aio.data.msglist.a a17 = this$0.E().a();
        if (a17 != null) {
            l16 = Long.valueOf(a17.getMsgSeq());
        } else {
            l16 = null;
        }
        com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) firstOrNull;
        if (aVar2 != null) {
            l17 = Long.valueOf(aVar2.getMsgSeq());
        } else {
            l17 = null;
        }
        if (aVar2 != null) {
            l18 = Long.valueOf(aVar2.getMsgId());
        } else {
            l18 = null;
        }
        QLog.i("GuildMsgListRepo", 1, "loadTopPage, channelId = " + b16 + ", msgDisplayList seq = " + l3 + ", aioFirstRecMsg seq = " + l16 + ", topLastMsg seq = " + l17 + ", msgId = " + l18);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.v(new com.tencent.aio.msgservice.g(this$0.D().g().r(), aVar2, 20)), new GuildMsgListRepo$loadPrePage$1$2(this$0, null)), zs.b.a(Dispatchers.INSTANCE)), this$0.J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(GuildMsgListRepo this$0) {
        Object last;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MsgList M = this$0.M();
        if ((!M.isEmpty()) && this$0.E().d() != null) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) M);
            long msgId = ((com.tencent.aio.data.msglist.a) last).getMsgId();
            com.tencent.aio.data.msglist.a d16 = this$0.E().d();
            Intrinsics.checkNotNull(d16);
            if (msgId == d16.getMsgId()) {
                com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
                bVar.p(this$0, IMsgListRepository.MsgListRepoOpType.OtherOperation, this$0.M(), bVar.e("GuildMsgListRepo", "navigateToBottom"), com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(bVar, false, false, 2, null));
                return;
            }
        }
        this$0.v("from_nav_to_bottom");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(GuildMsgListRepo this$0, long j3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.beforeNavigateToMsgNotifier;
        if (cVar != null) {
            cVar.a(j3);
        }
        AIOParam g16 = this$0.D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgListRepo", 1, "navigateToMsg, channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", msgSeq = " + j3);
        Iterator<com.tencent.aio.data.msglist.a> it = this$0.M().iterator();
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
            bVar.p(this$0, IMsgListRepository.MsgListRepoOpType.OtherOperation, this$0.M(), bVar.e("GuildMsgListRepo", "navigateToMsg"), bVar.f(j3));
            return;
        }
        long j16 = 30 + j3;
        if (this$0.E().d() != null) {
            com.tencent.aio.data.msglist.a d16 = this$0.E().d();
            Intrinsics.checkNotNull(d16);
            RangesKt___RangesKt.coerceAtMost(j16, d16.getMsgSeq());
        }
        this$0.y(j3, j16);
    }

    private final void U0(com.tencent.aio.data.msglist.a msg2) {
        String j3 = D().g().r().c().j();
        if ((msg2 instanceof GuildMsgItem) && TextUtils.equals(((GuildMsgItem) msg2).getMsgRecord().peerUid, j3)) {
            this.msgProcessor.h(msg2);
            return;
        }
        AIOParam g16 = D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgListRepo", 1, "onAddLocalSendMsg, current channelId: " + com.tencent.guild.aio.util.a.b(g16) + ", doesn't match. msgId: " + msg2.getMsgId());
    }

    private final void V0(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String j3 = D().g().r().c().j();
        ArrayList<com.tencent.aio.data.msglist.a> arrayList = new ArrayList();
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
            if (!TextUtils.equals(j3, guildMsgItem.getMsgRecord().peerUid) || guildMsgItem.getMsgRecord().msgType == 1) {
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
            for (com.tencent.aio.data.msglist.a aVar2 : arrayList) {
                long msgSeq = aVar2.getMsgSeq();
                Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                QLog.i("GuildMsgListRepo", 1, "onMsgInfoListAdd, msg uid = " + j3 + ", seq = " + msgSeq + ", type = " + ((GuildMsgItem) aVar2).getMsgRecord().msgType);
            }
            M().addAll(arrayList);
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, this, IMsgListRepository.MsgListRepoOpType.OtherOperation, M(), bVar.e("GuildMsgListRepo", "onMsgInfoListAdd"), null, 16, null);
        }
    }

    private final void W0(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String j3 = D().g().r().c().j();
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
            this.msgProcessor.k(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(GuildMsgListRepo this$0, com.tencent.aio.data.msglist.a aVar) {
        Long l3;
        Long l16;
        Object last;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIOParam g16 = this$0.D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        if (aVar != null) {
            l3 = Long.valueOf(aVar.getMsgSeq());
        } else {
            l3 = null;
        }
        if (aVar != null) {
            l16 = Long.valueOf(aVar.getMsgId());
        } else {
            l16 = null;
        }
        QLog.d("GuildMsgListRepo", 1, "msgEvent: onRealAddLocalSendMsg,  channelId = " + b16 + ", msg seq = " + l3 + ", msgId = " + l16);
        if (aVar == null) {
            return;
        }
        if (aVar instanceof GuildMsgItem) {
            AIOParam g17 = this$0.D().g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
            if (!Intrinsics.areEqual(com.tencent.guild.aio.util.a.b(g17), guildMsgItem.getMsgRecord().channelId)) {
                AIOParam g18 = this$0.D().g();
                Intrinsics.checkNotNullExpressionValue(g18, "context.aioParam");
                QLog.i("GuildMsgListRepo", 1, "onRealAddLocalSendMsg, current channelId: " + com.tencent.guild.aio.util.a.b(g18) + ", msgChannelId: " + guildMsgItem.getMsgRecord().channelId);
                return;
            }
        }
        if (!this$0.M().isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this$0.M());
            if (((com.tencent.aio.data.msglist.a) last).getMsgSeq() == aVar.getMsgSeq()) {
                this$0.M().add(aVar);
                com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
                bVar.p(this$0, IMsgListRepository.MsgListRepoOpType.LoadSendMessage, this$0.M(), bVar.e("GuildMsgListRepo", "onRealAddLocalSendMsg"), com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(bVar, false, false, 2, null));
                return;
            }
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.r(new com.tencent.aio.msgservice.f(this$0.D().g().r(), 0L, 15, true)), new GuildMsgListRepo$onRealAddLocalSendMsg$1$1(this$0, aVar, null)), zs.b.a(Dispatchers.INSTANCE)), this$0.J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(GuildMsgListRepo this$0, List msgList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgList, "$msgList");
        if (this$0.n1(msgList)) {
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, this$0, IMsgListRepository.MsgListRepoOpType.LoadMessageUpdate, this$0.M(), bVar.e("GuildMsgListRepo", "onRealMsgInfoListStatusUpdate"), null, 16, null);
        } else {
            QLog.i("GuildMsgListRepo", 1, "onMsgInfoListStatusUpdate, no need to notifyMsgChange");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0066, code lost:
    
        if (r5 != ((com.tencent.aio.data.msglist.a) r1).getMsgId()) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d1(GuildMsgListRepo this$0, List msgList) {
        Object first;
        Object last;
        Object first2;
        Object last2;
        Object first3;
        Object last3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgList, "$msgList");
        MsgList M = this$0.M();
        if (!M.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) msgList);
            long msgSeq = ((com.tencent.aio.data.msglist.a) first).getMsgSeq();
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) M);
            if (msgSeq != ((com.tencent.aio.data.msglist.a) last).getMsgSeq() + 1) {
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) msgList);
                long msgSeq2 = ((com.tencent.aio.data.msglist.a) first2).getMsgSeq();
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) M);
                if (msgSeq2 == ((com.tencent.aio.data.msglist.a) last2).getMsgSeq()) {
                    first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) msgList);
                    long msgId = ((com.tencent.aio.data.msglist.a) first3).getMsgId();
                    last3 = CollectionsKt___CollectionsKt.last((List<? extends Object>) M);
                }
                if (this$0.O0()) {
                    QLog.i("GuildMsgListRepo", 1, "onRealMsgReceive callLoadFirstPage");
                    this$0.v("from_receive_msg");
                    return;
                }
                QLog.i("GuildMsgListRepo", 1, "onRealMsgReceive not at bottom and not continuous");
                Iterator it = msgList.iterator();
                while (it.hasNext()) {
                    com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) it.next();
                    this$0.k1(aVar);
                    this$0.l1(aVar);
                }
                com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
                com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, this$0, IMsgListRepository.MsgListRepoOpType.LoadMessageReceive, this$0.M(), bVar.e("GuildMsgListRepo", "onRealMsgReceive"), null, 16, null);
                return;
            }
        }
        QLog.i("GuildMsgListRepo", 1, "onRealMsgReceive addMsg");
        M.addAll(msgList);
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        bVar2.p(this$0, IMsgListRepository.MsgListRepoOpType.LoadMessageReceive, this$0.M(), bVar2.e("GuildMsgListRepo", "onRealMsgReceive"), com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(bVar2, true, false, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object e1(GuildMsgListRepo guildMsgListRepo, com.tencent.aio.data.msglist.a aVar, Continuation continuation) {
        guildMsgListRepo.U0(aVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object f1(GuildMsgListRepo guildMsgListRepo, List list, Continuation continuation) {
        guildMsgListRepo.V0(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object g1(GuildMsgListRepo guildMsgListRepo, List list, Continuation continuation) {
        guildMsgListRepo.W0(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object h1(GuildMsgListRepo guildMsgListRepo, List list, Continuation continuation) {
        guildMsgListRepo.X0(list);
        return Unit.INSTANCE;
    }

    private final void i1() {
        QLog.d("GuildMsgListRepo", 1, "resetNavigateSeq");
        this.navigateSeq.set(0L);
    }

    private final void j1(List<Long> msgSeqList) {
        List<Long> list = msgSeqList;
        if (!list.isEmpty()) {
            this.visibleMsgSeqSet.addAll(list);
            String str = "";
            uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
            if (gProGuildMsgService != null) {
                gProGuildMsgService.setCurOnScreenMsg(com.tencent.guild.api.msg.service.l.f112634a.d(D().g().r()), hashCode(), new ArrayList<>(this.visibleMsgSeqSet));
            }
            Iterator<T> it = this.visibleMsgSeqSet.iterator();
            while (it.hasNext()) {
                str = ((Object) str) + " msgSeq = " + ((Long) it.next());
            }
            QLog.d("GuildMsgListRepo", 1, "exposureMsg tryToExposureBackFillMsg visibleMsgSeqSetString = " + ((Object) str));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (r2.getMsgSeq() > r11.getMsgSeq()) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l1(com.tencent.aio.data.msglist.a msg2) {
        Long l3;
        if ((msg2 instanceof GuildMsgItem) && ((GuildMsgItem) msg2).getMsgRecord().msgType != 1) {
            com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a E = E();
            Long l16 = null;
            if (E.b() != null) {
                com.tencent.aio.data.msglist.a b16 = E.b();
                Intrinsics.checkNotNull(b16);
            }
            com.tencent.aio.data.msglist.a b17 = E.b();
            if (b17 != null) {
                l3 = Long.valueOf(b17.getMsgSeq());
            } else {
                l3 = null;
            }
            QLog.i("GuildMsgListRepo", 1, "updateFirstAndLastShowMsg,aioFirstShowMsg = " + l3 + ", msg = " + msg2.getMsgSeq());
            E.g(msg2);
            if (E.d() != null) {
                com.tencent.aio.data.msglist.a d16 = E.d();
                Intrinsics.checkNotNull(d16);
                if (d16.getMsgSeq() >= msg2.getMsgSeq()) {
                    return;
                }
            }
            com.tencent.aio.data.msglist.a d17 = E.d();
            if (d17 != null) {
                l16 = Long.valueOf(d17.getMsgSeq());
            }
            QLog.i("GuildMsgListRepo", 1, "updateFirstAndLastShowMsg, aioLastShowMsg = " + l16 + ", msg = " + msg2.getMsgSeq());
            E.i(msg2);
        }
    }

    private final void m1(long msgSeq) {
        QLog.i("GuildMsgListRepo", 1, "updateLastMsg");
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.r(new com.tencent.aio.msgservice.f(D().g().r(), 0L, 3, true)), new GuildMsgListRepo$updateLastShowMsg$1(this, msgSeq, null)), zs.b.a(Dispatchers.INSTANCE)), J());
    }

    private final boolean n1(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Object firstOrNull;
        Long l3;
        Object lastOrNull;
        ArrayList arrayList;
        Iterator<? extends com.tencent.aio.data.msglist.a> it;
        int i3;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        int i16;
        MsgList M = M();
        int i17 = 0;
        if (M.isEmpty()) {
            return false;
        }
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        int size = msgList.size();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) msgList);
        com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
        Long l16 = null;
        if (aVar != null) {
            l3 = Long.valueOf(aVar.getMsgSeq());
        } else {
            l3 = null;
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) msgList);
        com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) lastOrNull;
        if (aVar2 != null) {
            l16 = Long.valueOf(aVar2.getMsgSeq());
        }
        int i18 = 1;
        QLog.i("GuildMsgListRepo", 1, "updateMsgInfo, msgSize: " + size + ", firstSeq = " + l3 + " lastSeq = " + l16 + "}");
        Iterator<? extends com.tencent.aio.data.msglist.a> it5 = msgList.iterator();
        boolean z16 = false;
        while (it5.hasNext()) {
            com.tencent.aio.data.msglist.a next = it5.next();
            if (com.tencent.guild.aio.factory.business.holder.msglist.j.f110625a.b(next)) {
                arrayList5.add(Long.valueOf(next.getMsgSeq()));
            }
            if ((next instanceof GuildMsgItem) && ((GuildMsgItem) next).getMsgRecord().msgType == i18) {
                com.tencent.aio.data.msglist.a H = H();
                if (H != null && next.getMsgId() == H.getMsgId()) {
                    i16 = i18;
                } else {
                    i16 = i17;
                }
                if (i16 != 0) {
                    m1(next.getMsgSeq());
                }
            }
            int size2 = M.size();
            int i19 = i17;
            while (i19 < size2) {
                if (next.getMsgId() == M.get(i19).getMsgId()) {
                    com.tencent.aio.data.msglist.a aVar3 = M.get(i19);
                    Intrinsics.checkNotNullExpressionValue(aVar3, "displayList[i]");
                    if (P0(aVar3, next)) {
                        if (QLog.isColorLevel()) {
                            arrayList3 = arrayList6;
                            QLog.d("GuildMsgListRepo", 1, "isBackFillMsg msgId = " + next.getMsgId() + " msgSeq = " + next.getMsgSeq());
                        } else {
                            arrayList3 = arrayList6;
                        }
                        this.backFillMsgMap.put(Long.valueOf(next.getMsgId()), Long.valueOf(next.getMsgSeq()));
                        arrayList7.add(Long.valueOf(next.getMsgSeq()));
                    } else {
                        arrayList3 = arrayList6;
                    }
                    com.tencent.guild.aio.factory.business.holder.msglist.j jVar = com.tencent.guild.aio.factory.business.holder.msglist.j.f110625a;
                    com.tencent.aio.data.msglist.a aVar4 = M.get(i19);
                    Intrinsics.checkNotNullExpressionValue(aVar4, "displayList[i]");
                    if (jVar.c(aVar4, true) && jVar.b(next) && (M.get(i19) instanceof GuildMsgItem)) {
                        com.tencent.aio.data.msglist.a aVar5 = M.get(i19);
                        Intrinsics.checkNotNull(aVar5, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                        arrayList4 = arrayList3;
                        arrayList4.add(((GuildMsgItem) aVar5).getMsgRecord());
                    } else {
                        arrayList4 = arrayList3;
                    }
                    com.tencent.aio.data.msglist.a aVar6 = M.get(i19);
                    Intrinsics.checkNotNull(aVar6, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                    GuildMsgItem guildMsgItem = (GuildMsgItem) next;
                    M.set(i19, ((GuildMsgItem) aVar6).cloneNewInstanceWithMsgRecord(guildMsgItem.getMsgRecord()));
                    if (QLog.isColorLevel()) {
                        QLog.i("GuildMsgListRepo", 1, "updateMsgInfo, msg = " + guildMsgItem.getSimpleDebugInfo());
                    }
                    if (guildMsgItem.getMsgRecord().msgType == 9) {
                        ReplyElement a16 = com.tencent.guild.api.data.msglist.a.a(guildMsgItem);
                        if (a16 != null) {
                            long msgSeq = next.getMsgSeq();
                            arrayList = arrayList7;
                            it = it5;
                            long msgId = next.getMsgId();
                            Long l17 = a16.replayMsgRootCommentCnt;
                            StringBuilder sb5 = new StringBuilder();
                            i3 = size2;
                            sb5.append("updateMsg: msgSeq = ");
                            sb5.append(msgSeq);
                            sb5.append(" msgId = ");
                            sb5.append(msgId);
                            sb5.append(" commentCount = ");
                            sb5.append(l17);
                            QLog.d("GuildMsgListRepo", 1, sb5.toString());
                        } else {
                            arrayList = arrayList7;
                            it = it5;
                            i3 = size2;
                        }
                        arrayList2 = arrayList4;
                    } else {
                        arrayList = arrayList7;
                        it = it5;
                        i3 = size2;
                        if (qr0.d.g(guildMsgItem)) {
                            arrayList2 = arrayList4;
                            QLog.d("GuildMsgListRepo", 1, "updateMsg: MKDMsg, msgSeq = " + next.getMsgSeq() + " msgId = " + next.getMsgId());
                            com.tencent.aio.data.msglist.a aVar7 = M.get(i19);
                            Intrinsics.checkNotNull(aVar7, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                            ((GuildMsgItem) aVar7).saveExtInfoToExtStr("GUILD_MARK_DOWN_UPDATE", "1");
                        } else {
                            arrayList2 = arrayList4;
                            if (com.tencent.guild.aio.util.ex.f.c(guildMsgItem)) {
                                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                                AIOParam g16 = D().g();
                                Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
                                simpleEventBus.dispatchEvent(new GuildMsgRevokeEvent(com.tencent.guild.aio.util.a.b(g16), next.getMsgId()));
                            }
                        }
                    }
                    z16 = true;
                } else {
                    arrayList = arrayList7;
                    it = it5;
                    i3 = size2;
                    arrayList2 = arrayList6;
                }
                i19++;
                it5 = it;
                arrayList6 = arrayList2;
                arrayList7 = arrayList;
                size2 = i3;
                i17 = 0;
                i18 = 1;
            }
        }
        ArrayList arrayList8 = arrayList6;
        ArrayList arrayList9 = arrayList7;
        ArrayList arrayList10 = new ArrayList(M);
        M.clear();
        M.addAll(arrayList10);
        if (!arrayList5.isEmpty()) {
            D().e().h(new GuildUpdateReplyMsgOnMsgRevoke(arrayList5));
            o1(arrayList5);
        }
        if (!arrayList8.isEmpty()) {
            ((IGuildRichMediaBrowserApi) QRoute.api(IGuildRichMediaBrowserApi.class)).onMsgRevoke(arrayList8);
        }
        j1(arrayList9);
        return z16;
    }

    private final void o1(List<Long> removeMsgSeq) {
        GuildMultiMsgManager a16 = GuildMultiMsgManager.INSTANCE.a();
        AIOParam g16 = D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(com.tencent.guild.aio.util.a.b(g16), com.tencent.guild.aio.util.ex.a.d(D()));
        if (!a16.i(dVar)) {
            return;
        }
        a16.l(dVar, removeMsgSeq);
        D().e().h(new GuildMsgListIntent.GuildMultiSelectCountChangeEvent());
    }

    private final boolean w0(Set<Long> curVisibleMsgSeqSet, Set<Long> newVisibleMsgSeqSet) {
        if (curVisibleMsgSeqSet.size() == newVisibleMsgSeqSet.size() && curVisibleMsgSeqSet.containsAll(newVisibleMsgSeqSet)) {
            return false;
        }
        return true;
    }

    private final void x0(int firstPosition, int lastPosition, List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        GuildMsgItem guildMsgItem;
        QLog.d("GuildMsgListRepo", 1, "exposureVisibleMsgSeqList firstPosition = " + firstPosition + " lastPosition = " + lastPosition + " msgItemListSize = " + msgItemList.size());
        if (msgItemList.isEmpty()) {
            QLog.i("GuildMsgListRepo", 1, "[exposureVisibleMsgSeqList] msgItemList is empty!");
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
                Long l3 = this.backFillMsgMap.get(Long.valueOf(guildMsgItem.getMsgId()));
                if (l3 != null && l3.longValue() > 0) {
                    if (l3.longValue() == guildMsgItem.getMsgSeq()) {
                        this.backFillMsgMap.remove(Long.valueOf(guildMsgItem.getMsgId()));
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
            QLog.d("GuildMsgListRepo", 1, "newVisibleMsgSeqSet empty!");
            return;
        }
        if (!w0(this.visibleMsgSeqSet, copyOnWriteArraySet)) {
            QLog.d("GuildMsgListRepo", 1, "checkVisibleMsgSeqSetChanged false!");
            return;
        }
        this.visibleMsgSeqSet.clear();
        this.visibleMsgSeqSet.addAll(copyOnWriteArraySet);
        String str = "";
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.setCurOnScreenMsg(com.tencent.guild.api.msg.service.l.f112634a.d(D().g().r()), hashCode(), new ArrayList<>(this.visibleMsgSeqSet));
        }
        Iterator<T> it = this.visibleMsgSeqSet.iterator();
        while (it.hasNext()) {
            str = ((Object) str) + " msgSeq = " + ((Long) it.next());
        }
        AIOParam g16 = D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.d("GuildMsgListRepo", 1, "exposureMsg exposureVisibleMsgSeqListpeerUid = " + com.tencent.guild.aio.util.a.b(g16) + "  firstPosition = " + firstPosition + " lastPosition = " + lastPosition + " beginIndex = " + i3 + " endIndex = " + i16 + " visibleMsgSeqSetString = " + ((Object) str));
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void L() {
        super.L();
        V(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.GuildNavigateToMsgEvent.class).getQualifiedName(), this.action);
        V(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent.class).getQualifiedName(), this.action);
        V(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.NotifyMsgFocusBottomEvent.class).getQualifiedName(), this.action);
        V(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.NavigateCompleteEvent.class).getQualifiedName(), this.action);
        V(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.ExposureVisibleMsgListEvent.class).getQualifiedName(), this.action);
        V(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.LoadFirstPageFinEvent.class).getQualifiedName(), this.action);
        V(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.action);
    }

    public final boolean N0() {
        if (this.navigateSeq.get() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void Q() {
        super.Q();
        if (QLog.isColorLevel()) {
            QLog.d("GuildMsgListRepo", 2, "GuildMsgListRepo Create");
        }
        this.navigateSeq.set(D().g().l().getLong("navigate_msg_seq", 0L));
        this.aioMsgEventDispatcher.h();
    }

    public final void X0(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        String j3 = D().g().r().c().j();
        ArrayList<com.tencent.aio.data.msglist.a> arrayList = new ArrayList();
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
            if (!TextUtils.equals(guildMsgItem.getMsgRecord().peerUid, j3) || guildMsgItem.getMsgRecord().msgType == 1) {
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
            for (com.tencent.aio.data.msglist.a aVar2 : arrayList) {
                long msgSeq = aVar2.getMsgSeq();
                Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                QLog.i("GuildMsgListRepo", 1, "onMsgReceive, msg uid = " + j3 + ", seq = " + msgSeq + ", type = " + ((GuildMsgItem) aVar2).getMsgRecord().msgType);
            }
            this.msgProcessor.l(arrayList);
        }
    }

    public final void Y0(@Nullable final com.tencent.aio.data.msglist.a msg2) {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.l
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgListRepo.Z0(GuildMsgListRepo.this, msg2);
            }
        }, null, 2, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void a() {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgListRepo.Q0(GuildMsgListRepo.this);
            }
        }, null, 2, null);
    }

    public final void a1(@NotNull final List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.j
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgListRepo.b1(GuildMsgListRepo.this, msgList);
            }
        }, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return list;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void c() {
        ChannelAIOMsgService channelAIOMsgService = ChannelAIOMsgService.f112613a;
        Flow onEach = FlowKt.onEach(channelAIOMsgService.E(), new GuildMsgListRepo$registerNotification$1(this));
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        FlowKt.launchIn(FlowKt.flowOn(onEach, zs.b.a(dispatchers)), J());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.y(), new GuildMsgListRepo$registerNotification$2(this)), zs.b.a(dispatchers)), J());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.x(), new GuildMsgListRepo$registerNotification$3(this)), zs.b.a(dispatchers)), J());
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.w(), new GuildMsgListRepo$registerNotification$4(this)), zs.b.a(dispatchers)), J());
    }

    public final void c1(@NotNull final List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.k
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgListRepo.d1(GuildMsgListRepo.this, msgList);
            }
        }, null, 2, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void e() {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgListRepo.R0(GuildMsgListRepo.this);
            }
        }, null, 2, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void f(long beginMsgSeq, long endMsgSeq) {
        AIOParam g16 = D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgListRepo", 1, "loadRangePage, channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", beginMsgSeq = " + beginMsgSeq + ", endMsgSeq = " + endMsgSeq);
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.u(new com.tencent.aio.msgservice.e(D().g().r(), Long.valueOf(beginMsgSeq), Long.valueOf(endMsgSeq))), new GuildMsgListRepo$loadRangePage$1(this, null)), zs.b.a(Dispatchers.INSTANCE)), J());
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void h(final long msgSeq) {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.i
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgListRepo.T0(GuildMsgListRepo.this, msgSeq);
            }
        }, null, 2, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        AIOParam g16 = D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgListRepo", 1, "loadFirstPage, channelId = " + com.tencent.guild.aio.util.a.b(g16));
        com.tencent.aio.msgservice.c cVar = new com.tencent.aio.msgservice.c(D().g().r(), 15);
        if (!F0(cVar)) {
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.j(cVar), new GuildMsgListRepo$loadFirstPage$1(this, null)), Dispatchers.getMain()), J());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        this.aioMsgEventDispatcher.c(displayList);
        return displayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0029, code lost:
    
        if (r1.getMsgSeq() > r11.getMsgSeq()) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k1(@NotNull com.tencent.aio.data.msglist.a msg2) {
        Long l3;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a E = E();
        Long l16 = null;
        if (E.a() != null) {
            com.tencent.aio.data.msglist.a a16 = E.a();
            Intrinsics.checkNotNull(a16);
        }
        com.tencent.aio.data.msglist.a c16 = E.c();
        if (c16 != null) {
            l3 = Long.valueOf(c16.getMsgSeq());
        } else {
            l3 = null;
        }
        QLog.i("GuildMsgListRepo", 1, "updateFirstAndLastRecMsg,aioLastRecMsg = " + l3 + ", msg = " + msg2.getMsgSeq());
        E.f(msg2);
        if (E.c() != null) {
            com.tencent.aio.data.msglist.a c17 = E.c();
            Intrinsics.checkNotNull(c17);
            if (c17.getMsgSeq() >= msg2.getMsgSeq()) {
                return;
            }
        }
        com.tencent.aio.data.msglist.a c18 = E.c();
        if (c18 != null) {
            l16 = Long.valueOf(c18.getMsgSeq());
        }
        QLog.i("GuildMsgListRepo", 1, "updateFirstAndLastRecMsg, aioLastRecMsg = " + l16 + ", msg = " + msg2.getMsgSeq());
        E.h(msg2);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void o() {
        AIOParam g16 = D().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgListRepo", 1, "navigateToBottom, channelId = " + com.tencent.guild.aio.util.a.b(g16));
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgListRepo.S0(GuildMsgListRepo.this);
            }
        }, null, 2, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void onDestroy() {
        super.onDestroy();
        QLog.d("GuildMsgListRepo", 2, "GuildMsgListRepo Destroy");
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.setCurOnScreenMsg(com.tencent.guild.api.msg.service.l.f112634a.d(D().g().r()), hashCode(), new ArrayList<>());
        }
        this.msgProcessor.i();
        D().e().b(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.GuildNavigateToMsgEvent.class).getQualifiedName(), this.action);
        D().e().b(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.GuildNavigateToAIOBottomEvent.class).getQualifiedName(), this.action);
        D().e().b(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.NotifyMsgFocusBottomEvent.class).getQualifiedName(), this.action);
        D().e().b(Reflection.getOrCreateKotlinClass(GuildMsgNavigateEvent.NavigateCompleteEvent.class).getQualifiedName(), this.action);
        D().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.ExposureVisibleMsgListEvent.class).getQualifiedName(), this.action);
        D().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.LoadFirstPageFinEvent.class).getQualifiedName(), this.action);
        D().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.action);
        this.aioMsgEventDispatcher.i();
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a y0() {
        return D();
    }

    @NotNull
    public final CoroutineScope z0() {
        return J();
    }
}
