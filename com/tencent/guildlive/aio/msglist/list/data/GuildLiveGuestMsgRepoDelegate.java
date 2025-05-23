package com.tencent.guildlive.aio.msglist.list.data;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.msgservice.h;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guild.api.msg.service.l;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0006\u0010\u001a\u001a\u00020\u0004R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/guildlive/aio/msglist/list/data/GuildLiveGuestMsgRepoDelegate;", "Lcom/tencent/guildlive/aio/msglist/list/data/e;", "", "delayMillis", "", "T", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "rsp", "O", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "P", "", "E", "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "l", "c", "source", "i", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "V", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "j", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "host", "Ljava/util/concurrent/atomic/AtomicBoolean;", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "N", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setMTimerFlag", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "mTimerFlag", "Landroid/os/Handler;", "Landroid/os/Handler;", "mTimerHandler", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveGuestMsgRepoDelegate extends e {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgListRepo host;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean mTimerFlag;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Handler mTimerHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guildlive/aio/msglist/list/data/GuildLiveGuestMsgRepoDelegate$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 10) {
                if (GuildLiveGuestMsgRepoDelegate.this.getMTimerFlag().get()) {
                    GuildLiveGuestMsgRepoDelegate.this.Q();
                    GuildLiveGuestMsgRepoDelegate.U(GuildLiveGuestMsgRepoDelegate.this, 0L, 1, null);
                    return;
                }
                return;
            }
            super.handleMessage(msg2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildLiveGuestMsgRepoDelegate(@NotNull MsgListRepo host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.mTimerFlag = new AtomicBoolean(false);
        this.mTimerHandler = new b(ThreadManagerV2.getQQCommonThreadLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(h<com.tencent.aio.data.msglist.a> rsp) {
        String E = E();
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i(E, 1, "handleFirstPage, channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", succ = " + rsp.d() + ", data size = " + rsp.a().size());
        if (rsp.d() && (!rsp.a().isEmpty())) {
            MsgList M = this.host.M();
            M.clear();
            M.addAll(rsp.a());
        }
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        MsgListRepo msgListRepo = this.host;
        bVar.p(msgListRepo, IMsgListRepository.MsgListRepoOpType.LoadFirst, msgListRepo.M(), bVar.e("GLGuestMsgRepoDelegate", "handleFirstPage"), com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(bVar, false, false, 2, null));
    }

    private final void P(List<? extends GuildMsgItem> msgList) {
        String j3 = d().g().r().c().j();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = msgList.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            GuildMsgItem guildMsgItem = (GuildMsgItem) next;
            String str = guildMsgItem.getMsgRecord().peerUid;
            QLog.i(E(), 1, "onMsgReceive, msg uid = " + str + ", seq = " + guildMsgItem.getMsgSeq() + ", type = " + guildMsgItem.getMsgRecord().msgType);
            if (TextUtils.equals(str, j3) && guildMsgItem.getMsgRecord().msgType != 1) {
                z16 = true;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            this.host.M().addAll(arrayList);
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            MsgListRepo msgListRepo = this.host;
            bVar.p(msgListRepo, IMsgListRepository.MsgListRepoOpType.LoadMessageReceive, msgListRepo.M(), bVar.e("GLGuestMsgRepoDelegate", "onMsgReceive"), com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(bVar, true, false, 2, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        long coerceAtLeast;
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        AIOParam g17 = d().g();
        Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
        if (!iGuildChannelApi.isSelfGuest(b16, com.tencent.guild.aio.util.a.g(g17))) {
            return;
        }
        AIOParam g18 = d().g();
        Intrinsics.checkNotNullExpressionValue(g18, "context.aioParam");
        String b17 = com.tencent.guild.aio.util.a.b(g18);
        AIOParam g19 = d().g();
        Intrinsics.checkNotNullExpressionValue(g19, "context.aioParam");
        Contact contact = new Contact(4, b17, com.tencent.guild.aio.util.a.g(g19));
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(yr0.a.a(d()) - 1, 0L);
        com.tencent.aio.data.msglist.a d16 = this.host.E().d();
        if (d16 != null) {
            coerceAtLeast = d16.getMsgSeq();
        }
        final long j3 = coerceAtLeast;
        final boolean z16 = this.host instanceof GuildMsgListRepo;
        ((IMsgService) QRoute.api(IMsgService.class)).getGuestMsgByRange(contact, j3, 15, false, new Random().nextInt(), new IGuestMsgOperateCallback() { // from class: com.tencent.guildlive.aio.msglist.list.data.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, HashMap hashMap) {
                GuildLiveGuestMsgRepoDelegate.R(j3, z16, this, i3, str, arrayList, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(long j3, boolean z16, final GuildLiveGuestMsgRepoDelegate this$0, int i3, String str, final ArrayList arrayList, HashMap hashMap) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (y.b(i3)) {
            if (arrayList != null && !arrayList.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17 && ((MsgRecord) arrayList.get(0)).msgSeq > j3 && z16) {
                a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guildlive.aio.msglist.list.data.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildLiveGuestMsgRepoDelegate.S(GuildLiveGuestMsgRepoDelegate.this, arrayList);
                    }
                }, null, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(GuildLiveGuestMsgRepoDelegate this$0, ArrayList msgList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l lVar = l.f112634a;
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        this$0.P(lVar.g(msgList));
    }

    private final void T(long delayMillis) {
        Handler handler;
        Handler handler2 = this.mTimerHandler;
        boolean z16 = false;
        if (handler2 != null && handler2.hasMessages(10)) {
            z16 = true;
        }
        if (!z16 && (handler = this.mTimerHandler) != null) {
            handler.sendEmptyMessageDelayed(10, delayMillis);
        }
    }

    static /* synthetic */ void U(GuildLiveGuestMsgRepoDelegate guildLiveGuestMsgRepoDelegate, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 5000;
        }
        guildLiveGuestMsgRepoDelegate.T(j3);
    }

    @Override // com.tencent.guildlive.aio.msglist.list.data.e
    @NotNull
    public String E() {
        return "GLGuestMsgRepoDelegate" + hashCode();
    }

    @NotNull
    /* renamed from: N, reason: from getter */
    public final AtomicBoolean getMTimerFlag() {
        return this.mTimerFlag;
    }

    public final void V() {
        QLog.i(E(), 1, "[stopTimerPullMsg] ");
        Handler handler = this.mTimerHandler;
        if (handler != null) {
            handler.removeMessages(10);
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        String E = E();
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i(E, 1, "loadFirstPage, channelId = " + com.tencent.guild.aio.util.a.b(g16));
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.j(new com.tencent.aio.msgservice.c(d().g().r(), 15)), new GuildLiveGuestMsgRepoDelegate$loadFirstPage$1(this, null)), zs.b.a(Dispatchers.INSTANCE)), r());
    }

    @Override // com.tencent.guildlive.aio.msglist.list.data.e, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void l(@NotNull com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        super.l(context, scope);
        QLog.i(E(), 1, "[onCreate] ");
        if (this.mTimerFlag.compareAndSet(false, true)) {
            U(this, 0L, 1, null);
        }
    }

    @Override // com.tencent.guildlive.aio.msglist.list.data.e, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void onDestroy() {
        super.onDestroy();
        QLog.i(E(), 1, "[onDestroy] ");
        this.mTimerFlag.getAndSet(false);
        V();
    }

    @Override // com.tencent.guildlive.aio.msglist.list.data.e, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void c() {
    }
}
