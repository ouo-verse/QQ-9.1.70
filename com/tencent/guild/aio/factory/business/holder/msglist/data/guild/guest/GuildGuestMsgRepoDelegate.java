package com.tencent.guild.aio.factory.business.holder.msglist.data.guild.guest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.b;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.guest.GuildGuestMsgRepoDelegate;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgItem;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guild.api.msg.service.l;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0003W[_\u0018\u0000 e2\u00020\u0001:\u0001fB\u000f\u0012\u0006\u00101\u001a\u00020,\u00a2\u0006\u0004\bc\u0010dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u0010\u000f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001e\u0010\u0012\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0016\u0010\u0017\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0#2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0%H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016R\u0017\u00101\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010?\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\b\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010A\u001a\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010MR\u001e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u00104R\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010a\u00a8\u0006g"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/guest/GuildGuestMsgRepoDelegate;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/k;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "G", "", UserInfo.SEX_FEMALE, "J", "", "P", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "rsp", "I", "T", "", "source", "H", "U", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/concurrent/CopyOnWriteArrayList;", "list", "B", "L", "", "startTime", "K", "N", "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "b", "", "displayList", "k", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "msgListWithOpType", DomainData.DOMAIN_NAME, "c", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "f", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "getHost", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "host", "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "D", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setMTimerFlag", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "mTimerFlag", h.F, BdhLogUtil.LogTag.Tag_Conn, "()J", "setMGuestPullMsgIntervalServer", "(J)V", "mGuestPullMsgIntervalServer", "Lcom/tencent/guild/aio/msglist/welcome/GuildWelcomeMsgItem;", "Lkotlin/Lazy;", "E", "()Lcom/tencent/guild/aio/msglist/welcome/GuildWelcomeMsgItem;", "welcomeMsg", "Landroid/os/Handler;", "j", "Landroid/os/Handler;", "mTimerHandler", "Lcom/tencent/guild/aio/msglist/graytips/combine/c;", "Lcom/tencent/guild/aio/msglist/graytips/combine/c;", "mCombineGrayTipCenter", "Laq0/a;", "Laq0/a;", "mCombineMsgCenter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/msgservice/h;", "firstPageMsgListCache", "isLoadFirstPageFin", "Ljava/util/concurrent/atomic/AtomicLong;", "o", "Ljava/util/concurrent/atomic/AtomicLong;", "skeletonStartTime", "com/tencent/guild/aio/factory/business/holder/msglist/data/guild/guest/GuildGuestMsgRepoDelegate$d", "p", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/guest/GuildGuestMsgRepoDelegate$d;", "mActionR", "com/tencent/guild/aio/factory/business/holder/msglist/data/guild/guest/GuildGuestMsgRepoDelegate$c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/guest/GuildGuestMsgRepoDelegate$c;", "mAction", "com/tencent/guild/aio/factory/business/holder/msglist/data/guild/guest/GuildGuestMsgRepoDelegate$b", "r", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/guest/GuildGuestMsgRepoDelegate$b;", "firstScreenMsgChangedObserver", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;)V", ReportConstant.COSTREPORT_PREFIX, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildGuestMsgRepoDelegate extends k {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgListRepo host;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean mTimerFlag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mGuestPullMsgIntervalServer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy welcomeMsg;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mTimerHandler;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.graytips.combine.c mCombineGrayTipCenter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final aq0.a mCombineMsgCenter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> firstPageMsgListCache;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isLoadFirstPageFin;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicLong skeletonStartTime;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mActionR;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mAction;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b firstScreenMsgChangedObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/data/guild/guest/GuildGuestMsgRepoDelegate$b", "Ljava/util/Observer;", "Ljava/util/Observable;", "o", "", "arg", "", "update", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements Observer {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(GuildGuestMsgRepoDelegate this$0, Object obj) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.I(((b.C1185b) obj).b());
        }

        @Override // java.util.Observer
        public void update(@Nullable Observable o16, @Nullable final Object arg) {
            if (!(arg instanceof b.C1185b)) {
                return;
            }
            b.C1185b c1185b = (b.C1185b) arg;
            QLog.i("GuildGuestMsgRepoDelegate", 1, "update NotifyData type = " + c1185b.getType() + " channelId = " + c1185b.getChannelId() + " peerUid = " + GuildGuestMsgRepoDelegate.this.d().g().r().c().j());
            if (Intrinsics.areEqual(c1185b.getChannelId(), GuildGuestMsgRepoDelegate.this.d().g().r().c().j()) && c1185b.b() != null && c1185b.getType() == 2) {
                zs.a a16 = zs.b.a(Dispatchers.INSTANCE);
                final GuildGuestMsgRepoDelegate guildGuestMsgRepoDelegate = GuildGuestMsgRepoDelegate.this;
                a.C11711a.b(a16, new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.guest.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildGuestMsgRepoDelegate.b.b(GuildGuestMsgRepoDelegate.this, arg);
                    }
                }, null, 2, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/data/guild/guest/GuildGuestMsgRepoDelegate$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildGuestMsgRepoDelegate.this.F(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/data/guild/guest/GuildGuestMsgRepoDelegate$d", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.mvi.base.route.b {
        d() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return GuildGuestMsgRepoDelegate.this.G(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/data/guild/guest/GuildGuestMsgRepoDelegate$e", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            long j3;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 10) {
                if (GuildGuestMsgRepoDelegate.this.getMTimerFlag().get()) {
                    GuildGuestMsgRepoDelegate.this.Q();
                    if (!hasMessages(10)) {
                        if (GuildGuestMsgRepoDelegate.this.getMGuestPullMsgIntervalServer() > 0) {
                            j3 = GuildGuestMsgRepoDelegate.this.getMGuestPullMsgIntervalServer();
                        } else {
                            j3 = 5000;
                        }
                        sendEmptyMessageDelayed(10, j3);
                        return;
                    }
                    return;
                }
                return;
            }
            super.handleMessage(msg2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGuestMsgRepoDelegate(@NotNull MsgListRepo host) {
        super(host);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.mTimerFlag = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildWelcomeMsgItem>() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.guest.GuildGuestMsgRepoDelegate$welcomeMsg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildWelcomeMsgItem invoke() {
                return new GuildWelcomeMsgItem(new MsgRecord(), GuildGuestMsgRepoDelegate.this.d().g().r().c().j(), GuildGuestMsgRepoDelegate.this.d().g().r().c().f(), false, 8, null);
            }
        });
        this.welcomeMsg = lazy;
        this.mTimerHandler = new e(ThreadManagerV2.getQQCommonThreadLooper());
        this.mCombineGrayTipCenter = new com.tencent.guild.aio.msglist.graytips.combine.c();
        this.mCombineMsgCenter = new aq0.a();
        this.isLoadFirstPageFin = new AtomicBoolean(false);
        this.skeletonStartTime = new AtomicLong(0L);
        this.mActionR = new d();
        this.mAction = new c();
        this.firstScreenMsgChangedObserver = new b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if ((r1 instanceof com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgItem) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void B(CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> list) {
        Object first;
        Object first2;
        Object first3;
        GuildWelcomeMsgItem E = E();
        boolean z16 = true;
        if (list.size() <= 1) {
            if (list.size() == 1) {
                first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            }
            z16 = false;
        }
        E.setShowBottomLine(z16);
        if (!Intrinsics.areEqual(E().getChannelId(), d().g().r().c().j())) {
            E().setChannelId(d().g().r().c().j());
            E().setGuildId(d().g().r().c().f());
            E().init();
        }
        if (!list.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            if (!(first instanceof GuildWelcomeMsgItem)) {
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                if (((com.tencent.aio.data.msglist.a) first2).getMsgSeq() == 1) {
                    list.add(0, E());
                    return;
                }
                return;
            }
            return;
        }
        list.add(E());
    }

    private final GuildWelcomeMsgItem E() {
        return (GuildWelcomeMsgItem) this.welcomeMsg.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.OnSkeletonLastEnoughTime) {
            L();
        } else if (i3 instanceof GuildMsgListIntent.OnSkeletonShow) {
            K(((GuildMsgListIntent.OnSkeletonShow) i3).getStartTime());
        } else {
            pn0.b bVar = pn0.b.f426490a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k G(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GetLoadFirstPageFin) {
            return new i.e(this.isLoadFirstPageFin.get());
        }
        return pn0.b.f426490a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp, String source) {
        Object firstOrNull;
        Long l3;
        Object lastOrNull;
        if (rsp.d() && (!rsp.a().isEmpty())) {
            AIOParam g16 = d().g();
            Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g16);
            int size = rsp.a().size();
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
            QLog.i("GuildGuestMsgRepoDelegate", 1, "handleFirstPage, channelId = " + b16 + ", data size = " + size + ", firstSeq = " + l3 + " lastSeq = " + l16 + "}, source: " + source);
            MsgList M = this.host.M();
            M.clear();
            M.addAll(rsp.a());
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            bVar.p(this.host, IMsgListRepository.MsgListRepoOpType.LoadFirst, M, bVar.e("GuildGuestMsgRepoDelegate", "handleFirstPage"), bVar.b(false, false));
            long j3 = d().g().l().getLong("navigate_msg_seq", 0L);
            d().g().l().putLong("navigate_msg_seq", 0L);
            if (j3 != 0) {
                h(j3);
                return;
            }
            return;
        }
        B(this.host.M());
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        MsgListRepo msgListRepo = this.host;
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar2, msgListRepo, IMsgListRepository.MsgListRepoOpType.LoadFirst, msgListRepo.M(), bVar2.e("GuildGuestMsgRepoDelegate", "handleFirstPage"), null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildGuestMsgRepoDelegate", 1, "[handleFirstPageForFirstScreen], channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", succ = " + rsp.d() + ", data size = " + rsp.a().size());
        ao0.d.j(ao0.d.f26594a, rsp.a(), d(), false, 4, null);
        if (U()) {
            QLog.i("GuildGuestMsgRepoDelegate", 1, "[handleFirstPageForFirstScreen] skeletonDelayHide = true");
            this.firstPageMsgListCache = rsp;
        } else {
            T(rsp);
        }
    }

    private final void J() {
        com.tencent.guild.aio.factory.b e16 = com.tencent.guild.aio.util.ex.a.e(d());
        if (e16 == null) {
            return;
        }
        e16.f(this.firstScreenMsgChangedObserver);
        if (!Intrinsics.areEqual(e16.i(), d().g().r().c().j())) {
            return;
        }
        e16.k();
    }

    private final void K(long startTime) {
        if (!this.isLoadFirstPageFin.get()) {
            QLog.i("GuildGuestMsgRepoDelegate", 1, "handleOnSkeletonShow, startTime: " + startTime);
            this.skeletonStartTime.set(startTime);
        }
    }

    private final void L() {
        if (this.skeletonStartTime.get() > 0) {
            QLog.i("GuildGuestMsgRepoDelegate", 1, "handleSkeletonLastEnoughTime");
            this.skeletonStartTime.set(0L);
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(GuildGuestMsgRepoDelegate this$0, String source) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "$source");
        AIOParam g16 = this$0.d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildGuestMsgRepoDelegate", 1, "loadFirstPage, channelId = " + com.tencent.guild.aio.util.a.b(g16) + " source = " + source);
        com.tencent.guild.aio.factory.b e16 = com.tencent.guild.aio.util.ex.a.e(this$0.d());
        if (e16 != null) {
            e16.m();
        }
        ChannelAIOMsgService.f112613a.k(new com.tencent.aio.msgservice.c(this$0.d().g().r(), 15), new GuildGuestMsgRepoDelegate$loadFirstPage$1$1(source, this$0));
    }

    private final void N() {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.guest.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildGuestMsgRepoDelegate.O(GuildGuestMsgRepoDelegate.this);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(GuildGuestMsgRepoDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.firstPageMsgListCache != null) {
            AIOParam g16 = this$0.d().g();
            Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
            QLog.i("GuildGuestMsgRepoDelegate", 1, "[loadMsgFromCache] handleFirstPage. channelId: " + com.tencent.guild.aio.util.a.b(g16));
            com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar = this$0.firstPageMsgListCache;
            Intrinsics.checkNotNull(hVar);
            this$0.T(hVar);
        }
        this$0.firstPageMsgListCache = null;
    }

    private final boolean P() {
        return Intrinsics.areEqual(d().g().n(), com.tencent.guild.aio.factory.a.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        long j3;
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g16);
        AIOParam g17 = d().g();
        Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
        if (!iGuildChannelApi.isSelfGuest(b16, com.tencent.guild.aio.util.a.g(g17))) {
            return;
        }
        Contact contact = new Contact(4, d().g().r().c().j(), d().g().r().c().f());
        com.tencent.aio.data.msglist.a d16 = this.host.E().d();
        if (d16 != null) {
            j3 = d16.getMsgSeq();
        } else {
            j3 = 0;
        }
        final long j16 = j3;
        ((IMsgService) QRoute.api(IMsgService.class)).getGuestMsgByRange(contact, j16, 15, false, new Random().nextInt(), new IGuestMsgOperateCallback() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.guest.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, HashMap hashMap) {
                GuildGuestMsgRepoDelegate.R(j16, this, i3, str, arrayList, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(long j3, final GuildGuestMsgRepoDelegate this$0, int i3, String str, final ArrayList arrayList, HashMap hashMap) {
        long j16;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z17 = true;
        if (i3 == 0) {
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && ((MsgRecord) arrayList.get(0)).msgSeq > j3 && (this$0.host instanceof GuildMsgListRepo)) {
                if (QLog.isColorLevel()) {
                    QLog.i("GuildGuestMsgRepoDelegate", 2, "pullMsg result: msgList=" + arrayList.size());
                }
                a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.guest.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildGuestMsgRepoDelegate.S(GuildGuestMsgRepoDelegate.this, arrayList);
                    }
                }, null, 2, null);
            }
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            z17 = false;
        }
        if (!z17 && hashMap.containsKey(Long.valueOf(Long.parseLong(this$0.d().g().r().c().j())))) {
            Integer num = (Integer) hashMap.get(Long.valueOf(Long.parseLong(this$0.d().g().r().c().j())));
            if (num != null) {
                j16 = num.intValue();
            } else {
                j16 = 0;
            }
            this$0.mGuestPullMsgIntervalServer = j16;
            if (QLog.isColorLevel()) {
                QLog.i("GuildGuestMsgRepoDelegate", 2, "pullMsg interval from server: " + this$0.mGuestPullMsgIntervalServer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(GuildGuestMsgRepoDelegate this$0, ArrayList msgList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildMsgListRepo guildMsgListRepo = (GuildMsgListRepo) this$0.host;
        l lVar = l.f112634a;
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        guildMsgListRepo.X0(lVar.g(msgList));
    }

    private final void T(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildGuestMsgRepoDelegate", 1, "[realHandleFirstPageForFirstScreen], channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", succ = " + rsp.d() + ", data size = " + rsp.a().size());
        H(rsp, "from_first_screen");
        if (this.isLoadFirstPageFin.compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(r(), Dispatchers.getMain(), null, new GuildGuestMsgRepoDelegate$realHandleFirstPageForFirstScreen$1(this, null), 2, null);
            if (this.mTimerFlag.compareAndSet(false, true)) {
                QLog.i("GuildGuestMsgRepoDelegate", 1, "start GUEST_PULL_MSG_TIMER");
                if (!this.mTimerHandler.hasMessages(10)) {
                    this.mTimerHandler.sendEmptyMessageDelayed(10, 5000L);
                }
            }
        }
    }

    private final boolean U() {
        if (!P()) {
            return false;
        }
        return bo0.a.INSTANCE.a(this.skeletonStartTime.get());
    }

    /* renamed from: C, reason: from getter */
    public final long getMGuestPullMsgIntervalServer() {
        return this.mGuestPullMsgIntervalServer;
    }

    @NotNull
    /* renamed from: D, reason: from getter */
    public final AtomicBoolean getMTimerFlag() {
        return this.mTimerFlag;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        Object firstOrNull;
        ArrayList arrayList;
        boolean z16;
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (list) {
            com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a E = this.host.E();
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(list);
            E.f((com.tencent.aio.data.msglist.a) firstOrNull);
            CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> copyOnWriteArrayList = new CopyOnWriteArrayList<>(list);
            B(copyOnWriteArrayList);
            arrayList = new ArrayList();
            for (Object obj : copyOnWriteArrayList) {
                com.tencent.aio.data.msglist.a it = (com.tencent.aio.data.msglist.a) obj;
                MsgListRepo msgListRepo = this.host;
                Intrinsics.checkNotNull(msgListRepo, "null cannot be cast to non-null type com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ((GuildMsgListRepo) msgListRepo).k1(it);
                if ((it instanceof GuildMsgItem) && ((GuildMsgItem) it).getMsgRecord().msgType != 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    QLog.i("GuildGuestMsgRepoDelegate", 1, "beforeMsgAddToMemory, filter msg class = " + it.getClass() + ", seq = " + it.getMsgSeq());
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull final String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (Intrinsics.areEqual(source, "from_first_screen")) {
            com.tencent.guild.aio.factory.b e16 = com.tencent.guild.aio.util.ex.a.e(d());
            boolean z16 = false;
            if (e16 != null) {
                AIOParam g16 = d().g();
                Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
                if (e16.j(com.tencent.guild.aio.util.a.b(g16))) {
                    z16 = true;
                }
            }
            if (z16) {
                AIOParam g17 = d().g();
                Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
                QLog.i("GuildGuestMsgRepoDelegate", 1, "loadFirstPage, isLoadFirstScreenMsg channelId = " + com.tencent.guild.aio.util.a.b(g17));
                return;
            }
        }
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.guest.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildGuestMsgRepoDelegate.M(GuildGuestMsgRepoDelegate.this, source);
            }
        }, null, 2, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        Object firstOrNull;
        ArrayList arrayList;
        boolean z16;
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        synchronized (displayList) {
            com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a E = this.host.E();
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) displayList);
            E.f((com.tencent.aio.data.msglist.a) firstOrNull);
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : displayList) {
                if (hashSet.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj).getMsgId()))) {
                    arrayList2.add(obj);
                }
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(arrayList2);
            this.mCombineGrayTipCenter.b(copyOnWriteArrayList);
            this.mCombineMsgCenter.g(copyOnWriteArrayList);
            arrayList = new ArrayList();
            boolean z17 = false;
            for (Object obj2 : copyOnWriteArrayList) {
                com.tencent.aio.data.msglist.a it = (com.tencent.aio.data.msglist.a) obj2;
                MsgListRepo msgListRepo = this.host;
                Intrinsics.checkNotNull(msgListRepo, "null cannot be cast to non-null type com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ((GuildMsgListRepo) msgListRepo).k1(it);
                boolean z18 = it instanceof GuildWelcomeMsgItem;
                if ((it instanceof GuildMsgItem) && ((GuildMsgItem) it).getMsgRecord().msgType != 1 && (!z17 || !z18)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z18) {
                    z17 = true;
                }
                if (!z16) {
                    QLog.i("GuildGuestMsgRepoDelegate", 1, "beforeMsgToScreen, filter msg class = " + it.getClass() + ", seq = " + it.getMsgSeq());
                }
                if (z16) {
                    arrayList.add(obj2);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void l(@NotNull com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        super.l(context, scope);
        if (QLog.isColorLevel()) {
            QLog.i("GuildGuestMsgRepoDelegate", 2, "onCreate");
        }
        if (P()) {
            context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.OnSkeletonShow.class).getQualifiedName(), this.mAction);
            context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.OnSkeletonLastEnoughTime.class).getQualifiedName(), this.mAction);
        }
        context.e().j(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetLoadFirstPageFin.class).getQualifiedName(), this.mActionR);
        J();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l n(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l msgListWithOpType) {
        Long l3;
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgListWithOpType, "msgListWithOpType");
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l n3 = super.n(msgListWithOpType);
        Bundle a16 = msgListWithOpType.a();
        if (a16 != null) {
            l3 = Long.valueOf(a16.getLong("KEY_NAVIGATE_SEQ", -1L));
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() != -1) {
            Iterator<com.tencent.aio.data.msglist.a> it = n3.c().iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().getMsgSeq() == l3.longValue()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            }
        }
        i3 = -1;
        QLog.i("GuildGuestMsgRepoDelegate", 1, "beforeMsgToScreenWithIndex, pos = " + i3 + ", msgSeq = " + l3);
        if (i3 != -1) {
            com.tencent.aio.data.msglist.a aVar = n3.c().get(i3);
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            if (!com.tencent.guild.aio.util.ex.f.b((GuildMsgItem) aVar)) {
                return new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l(n3.c(), n3.d(), null, n3.a());
            }
        }
        return n3;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void onDestroy() {
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.i("GuildGuestMsgRepoDelegate", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.mTimerFlag.getAndSet(false);
        this.mTimerHandler.removeMessages(10);
        if (P()) {
            d().e().b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.mAction);
            d().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.OnSkeletonLastEnoughTime.class).getQualifiedName(), this.mAction);
            d().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.OnSkeletonShow.class).getQualifiedName(), this.mAction);
        }
        d().e().a(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetLoadFirstPageFin.class).getQualifiedName());
        com.tencent.guild.aio.factory.b e16 = com.tencent.guild.aio.util.ex.a.e(d());
        if (e16 != null) {
            e16.h(this.firstScreenMsgChangedObserver);
        }
        this.skeletonStartTime.set(0L);
        this.mCombineGrayTipCenter.c();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void c() {
    }
}
