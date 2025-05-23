package com.tencent.guild.aio.factory;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0001\u001fB\u0013\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b7\u00108J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010\u0011\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0006R\u0018\u0010!\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010)R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u00102R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00102R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/guild/aio/factory/GuildFirstScreenTask;", "", "Landroid/content/Context;", "ctx", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "f", "", "k", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "rsp", "j", "i", "", TabPreloadItem.TAB_NAME_MESSAGE, "r", "o", "Lcom/tencent/guild/aio/factory/b;", "helper", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "", "channelId", "l", "t", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Lcom/tencent/guild/aio/factory/b;", "firstScreenHelper", "b", "Ljava/lang/String;", "Ljava/lang/Object;", "c", "Ljava/lang/Object;", "latestDbMsgsCacheLock", "d", "Lcom/tencent/aio/msgservice/h;", "latestDbMsgsCache", "firstPageMsgListCacheLock", "firstPageMsgListCache", "Lkotlinx/coroutines/CoroutineScope;", "g", "Lkotlinx/coroutines/CoroutineScope;", "msgReceiveCorutine", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mReciveSelfChannelMsg", "mLoadFirstPageCalledFromRepo", "Z", "mHasInited", "<init>", "(Lcom/tencent/guild/aio/factory/b;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildFirstScreenTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b firstScreenHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object latestDbMsgsCacheLock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> latestDbMsgsCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object firstPageMsgListCacheLock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> firstPageMsgListCache;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CoroutineScope msgReceiveCorutine;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean mReciveSelfChannelMsg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean mLoadFirstPageCalledFromRepo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean mHasInited;

    public GuildFirstScreenTask() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void f(final Context ctx, final AIOParam aioParam) {
        final com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar;
        final com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar2;
        if (!this.mHasInited) {
            QLog.i("GuildFirstScreenTask", 1, "doPreParse. mHasInited = false, return.");
            return;
        }
        synchronized (this.firstPageMsgListCacheLock) {
            hVar = this.firstPageMsgListCache;
        }
        synchronized (this.latestDbMsgsCacheLock) {
            hVar2 = this.latestDbMsgsCache;
        }
        if (hVar != null || hVar2 != null) {
            a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFirstScreenTask.g(com.tencent.aio.msgservice.h.this, aioParam, ctx, hVar2);
                }
            }, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(com.tencent.aio.msgservice.h hVar, AIOParam aioParam, Context ctx, com.tencent.aio.msgservice.h hVar2) {
        Intrinsics.checkNotNullParameter(aioParam, "$aioParam");
        Intrinsics.checkNotNullParameter(ctx, "$ctx");
        if (hVar != null && (!hVar.a().isEmpty())) {
            QLog.i("GuildFirstScreenTask", 1, "doPreParse: firstPageMsgListCache size: " + hVar.a().size());
            ao0.d.f26594a.i(hVar.a(), aioParam, ctx, false);
            return;
        }
        if (hVar2 != null && (!hVar2.a().isEmpty()) && hVar2.a().size() >= 10) {
            QLog.i("GuildFirstScreenTask", 1, "doPreParse: latestDbMsgsCache size: " + hVar2.a().size());
            ao0.d.f26594a.i(hVar2.a().subList(hVar2.a().size() - 10, hVar2.a().size()), aioParam, ctx, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        boolean z16 = true;
        if (this.mLoadFirstPageCalledFromRepo.get()) {
            QLog.i("GuildFirstScreenTask", 1, "handleFirstPageMsgList: channelId: " + this.channelId + ", mLoadFirstPageCalledFromRepo = true, do nothing.");
            return;
        }
        QLog.i("GuildFirstScreenTask", 1, "handleFirstPageMsgList: channelId: " + this.channelId + ", dataSize: " + rsp.a().size());
        if (this.channelId.length() <= 0) {
            z16 = false;
        }
        if (z16) {
            synchronized (this.firstPageMsgListCacheLock) {
                this.firstPageMsgListCache = rsp;
                Unit unit = Unit.INSTANCE;
            }
            b bVar = this.firstScreenHelper;
            if (bVar != null) {
                bVar.l(2, this.channelId, rsp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        boolean z16;
        QLog.i("GuildFirstScreenTask", 1, "handleGetLatestDbMsgs: channelId: " + this.channelId + ", dataSize: " + rsp.a().size());
        if (this.channelId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            synchronized (this.latestDbMsgsCacheLock) {
                this.latestDbMsgsCache = rsp;
                Unit unit = Unit.INSTANCE;
            }
            b bVar = this.firstScreenHelper;
            if (bVar != null) {
                bVar.l(1, this.channelId, rsp);
            }
        }
    }

    private final boolean k(AIOParam aioParam) {
        boolean z16;
        long j3 = aioParam.l().getLong("navigate_msg_seq", 0L);
        if (j3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("GuildFirstScreenTask", 1, "hasNavigateSeq: seq: " + j3);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object p(GuildFirstScreenTask guildFirstScreenTask, List list, Continuation continuation) {
        guildFirstScreenTask.r(list);
        return Unit.INSTANCE;
    }

    private final void r(List<? extends com.tencent.aio.data.msglist.a> msgList) {
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
            if (!TextUtils.equals(guildMsgItem.getMsgRecord().peerUid, this.channelId) || guildMsgItem.getMsgRecord().msgType == 1) {
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
            QLog.i("GuildFirstScreenTask", 1, "onMsgReceiveMsg: channelId: " + this.channelId);
            this.mReciveSelfChannelMsg.getAndSet(true);
        }
    }

    public final void e() {
        if (CoroutineScopeKt.isActive(this.msgReceiveCorutine)) {
            try {
                CoroutineScopeKt.cancel$default(this.msgReceiveCorutine, null, 1, null);
            } catch (Exception e16) {
                QLog.i("GuildFirstScreenTask", 1, "corutineCancel e: " + e16);
            }
            QLog.i("GuildFirstScreenTask", 1, "corutineCancel");
        }
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    public final boolean l(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (!this.mReciveSelfChannelMsg.get()) {
            return Intrinsics.areEqual(channelId, this.channelId);
        }
        return false;
    }

    public final void m() {
        boolean z16;
        com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar;
        com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar2;
        b bVar;
        e();
        QLog.i("GuildFirstScreenTask", 1, "loadFirstScreenMsg : channelId: " + this.channelId);
        if (this.channelId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        synchronized (this.firstPageMsgListCacheLock) {
            hVar = this.firstPageMsgListCache;
        }
        synchronized (this.latestDbMsgsCacheLock) {
            hVar2 = this.latestDbMsgsCache;
        }
        if (hVar != null) {
            b bVar2 = this.firstScreenHelper;
            if (bVar2 != null) {
                bVar2.l(2, this.channelId, hVar);
                return;
            }
            return;
        }
        if (hVar2 != null && (bVar = this.firstScreenHelper) != null) {
            bVar.l(1, this.channelId, hVar2);
        }
    }

    public final void n(@NotNull Context ctx, @NotNull AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        QLog.i("GuildFirstScreenTask", 1, "onContextReady");
        f(ctx, aioParam);
    }

    public final void o(@NotNull AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        if (k(aioParam) || this.mHasInited) {
            return;
        }
        String j3 = aioParam.r().c().j();
        this.channelId = j3;
        QLog.i("GuildFirstScreenTask", 1, "onCreate: channelId: " + j3);
        ChannelAIOMsgService channelAIOMsgService = ChannelAIOMsgService.f112613a;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(channelAIOMsgService.y(), new GuildFirstScreenTask$onCreate$1(this)), zs.b.a(Dispatchers.INSTANCE)), this.msgReceiveCorutine);
        if (!((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(com.tencent.guild.aio.util.a.b(aioParam), com.tencent.guild.aio.util.a.g(aioParam))) {
            channelAIOMsgService.p(15, aioParam.r(), new Function1<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit>() { // from class: com.tencent.guild.aio.factory.GuildFirstScreenTask$onCreate$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar) {
                    invoke2(hVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    GuildFirstScreenTask.this.j(rsp);
                }
            });
        }
        channelAIOMsgService.k(new com.tencent.aio.msgservice.c(aioParam.r(), 15), new Function1<com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a>, Unit>() { // from class: com.tencent.guild.aio.factory.GuildFirstScreenTask$onCreate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                GuildFirstScreenTask.this.i(rsp);
            }
        });
        this.mHasInited = true;
    }

    public final void q() {
        QLog.i("GuildFirstScreenTask", 1, "onDestory: channelId: " + this.channelId);
        this.channelId = "";
        synchronized (this.latestDbMsgsCacheLock) {
            this.latestDbMsgsCache = null;
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.firstPageMsgListCacheLock) {
            this.firstPageMsgListCache = null;
        }
        this.mLoadFirstPageCalledFromRepo.getAndSet(false);
        e();
    }

    public final void s(@NotNull b helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        this.firstScreenHelper = helper;
    }

    public final void t() {
        QLog.i("GuildFirstScreenTask", 1, "setLoadFirstPageCalledFromRepo : channelId: " + this.channelId);
        this.mLoadFirstPageCalledFromRepo.getAndSet(true);
    }

    public GuildFirstScreenTask(@Nullable b bVar) {
        CompletableJob Job$default;
        this.firstScreenHelper = bVar;
        this.channelId = "";
        this.latestDbMsgsCacheLock = new Object();
        this.firstPageMsgListCacheLock = new Object();
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.msgReceiveCorutine = CoroutineScopeKt.CoroutineScope(Job$default.plus(Dispatchers.getDefault()));
        this.mReciveSelfChannelMsg = new AtomicBoolean(false);
        this.mLoadFirstPageCalledFromRepo = new AtomicBoolean(false);
    }

    public /* synthetic */ GuildFirstScreenTask(b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }
}
