package com.tencent.mobileqq.aio.msglist;

import android.os.Bundle;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.service.AIOMsgServiceWithContext;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import defpackage.MsgListUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 I2\u00020\u0001:\u0001JB\u0017\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010F\u001a\u00020E\u00a2\u0006\u0004\bG\u0010HJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001e\u0010\f\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J&\u0010\u0011\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J.\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J.\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0012J*\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J2\u0010\u001f\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J*\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u0014\u0010\"\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0016\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007R2\u0010-\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030'0&j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030'`(8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00103\u001a\u00020.8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\"\u0010B\u001a\u00020;8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "Landroid/os/Bundle;", "extra", "", "r0", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "t0", "", "concurrentCount", "g0", "Ljava/util/concurrent/atomic/AtomicInteger;", "index", "Ljava/util/concurrent/CountDownLatch;", "countDownLatch", "m0", "", "source", "f0", "d0", "s0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "opType", "list", "from", "p0", "g", "n0", "d", "c", "l0", "newMsgItem", "oldMsgItem", "q0", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/msgrepo/g;", "Lkotlin/collections/ArrayList;", "l", "Ljava/util/ArrayList;", "k0", "()Ljava/util/ArrayList;", "msgRepoAbilityList", "Lcom/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext;", "i0", "()Lcom/tencent/mobileqq/aio/msg/service/AIOMsgServiceWithContext;", "aioMsgService", DomainData.DOMAIN_NAME, "I", "mMsgCount", "Ljava/lang/Runnable;", "o", "Ljava/lang/Runnable;", "threadCheckRunnable", "", "p", "J", "j0", "()J", "setLocationReqTime$aio_impl_release", "(J)V", "locationReqTime", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class BaseMsgRepo extends MsgListRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f190436r;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.aio.msglist.msgrepo.g<?>> msgRepoAbilityList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOMsgServiceWithContext aioMsgService;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int mMsgCount;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable threadCheckRunnable;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private long locationReqTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/BaseMsgRepo$a;", "", "", "threadCheckSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "threadCheckSwitch", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.BaseMsgRepo$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) BaseMsgRepo.f190436r.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58185);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(BaseMsgRepo$Companion$threadCheckSwitch$2.INSTANCE);
        f190436r = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMsgRepo(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
        } else {
            this.msgRepoAbilityList = new ArrayList<>();
            this.aioMsgService = new AIOMsgServiceWithContext(aioContext.c().requireContext());
        }
    }

    private final void d0() {
        if (!INSTANCE.b()) {
            return;
        }
        this.threadCheckRunnable = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.u
            @Override // java.lang.Runnable
            public final void run() {
                BaseMsgRepo.e0();
            }
        }, 16, null, true, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0() {
        QLog.i("BaseMsgRepo", 1, "[checkDisplayThread]: displayThread overtime 1s, trace is " + zs.b.a(Dispatchers.INSTANCE).e());
    }

    private final List<com.tencent.aio.data.msglist.a> f0(List<? extends com.tencent.aio.data.msglist.a> msgList, String source, Bundle extra) {
        List<com.tencent.aio.data.msglist.a> mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) msgList);
        Iterator<T> it = k0().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.msgrepo.g) it.next()).b(mutableList, source, extra);
        }
        return mutableList;
    }

    private final void g0(final List<? extends com.tencent.aio.data.msglist.a> msgList, int concurrentCount) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(msgList.size());
        int i3 = 1;
        if (1 <= concurrentCount) {
            while (true) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseMsgRepo.h0(BaseMsgRepo.this, msgList, atomicInteger, countDownLatch);
                    }
                }, 16, null, false);
                if (i3 == concurrentCount) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        m0(msgList, atomicInteger, countDownLatch);
        countDownLatch.await();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(BaseMsgRepo this$0, List msgList, AtomicInteger index, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgList, "$msgList");
        Intrinsics.checkNotNullParameter(index, "$index");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        this$0.m0(msgList, index, countDownLatch);
    }

    private final void m0(List<? extends com.tencent.aio.data.msglist.a> msgList, AtomicInteger index, CountDownLatch countDownLatch) {
        while (true) {
            int andIncrement = index.getAndIncrement();
            if (andIncrement >= msgList.size()) {
                return;
            }
            final com.tencent.aio.data.msglist.a aVar = msgList.get(andIncrement);
            if (aVar instanceof AIOMsgItem) {
                MsgListUtil.f24918a.n("BaseMsgRepo", "injectBusinessData-" + aVar.getMsgId(), QLog.isDevelopLevel(), new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.msglist.BaseMsgRepo$injectMsgWorker$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.aio.data.msglist.a.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            com.tencent.mobileqq.aio.msg.service.a.f190218a.b((AIOMsgItem) com.tencent.aio.data.msglist.a.this);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
            countDownLatch.countDown();
        }
    }

    public static /* synthetic */ void o0(BaseMsgRepo baseMsgRepo, List list, String str, IMsgListRepository.MsgListRepoOpType msgListRepoOpType, Bundle bundle, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                msgListRepoOpType = IMsgListRepository.MsgListRepoOpType.OtherOperation;
            }
            if ((i3 & 8) != 0) {
                bundle = null;
            }
            baseMsgRepo.n0(list, str, msgListRepoOpType, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyMsgChange");
    }

    private final void r0(Bundle extra) {
        long j3;
        long j16;
        if (extra != null) {
            j3 = extra.getLong("navigate_seq", 0L);
        } else {
            j3 = 0;
        }
        if (extra != null) {
            j16 = extra.getLong("navigate_id", 0L);
        } else {
            j16 = 0;
        }
        boolean z16 = false;
        if (extra != null) {
            z16 = extra.getBoolean("set_bottom", false);
        }
        if (j3 <= 0 && j16 <= 0) {
            if (z16) {
                QLog.i("BaseMsgRepo", 1, "[notifyInfo]: setBottom");
                return;
            } else {
                if (QLog.isDevelopLevel()) {
                    QLog.i("BaseMsgRepo", 4, "[notifyInfo]: refresh");
                    return;
                }
                return;
            }
        }
        QLog.i("BaseMsgRepo", 1, "[notifyInfo]: navigationSeq is " + j3 + ", navigationId is " + j16);
    }

    private final void s0() {
        Runnable runnable = this.threadCheckRunnable;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        this.threadCheckRunnable = null;
    }

    private final void t0(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        for (final com.tencent.aio.data.msglist.a aVar : msgList) {
            if (aVar instanceof AIOMsgItem) {
                MsgListUtil.f24918a.n("BaseMsgRepo", "injectBusinessData-" + aVar.getMsgId(), QLog.isDevelopLevel(), new Function0<Unit>() { // from class: com.tencent.mobileqq.aio.msglist.BaseMsgRepo$serialInject$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.aio.data.msglist.a.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            com.tencent.mobileqq.aio.msg.service.a.f190218a.b((AIOMsgItem) com.tencent.aio.data.msglist.a.this);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.Q();
        Iterator<T> it = k0().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.msgrepo.g) it.next()).j();
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Iterator<T> it = k0().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.msgrepo.g) it.next()).m(this.aioMsgService);
        }
        QLog.i("BaseMsgRepo", 1, "registerNotification");
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo, ws.a
    public void d(@NotNull IMsgListRepository.MsgListRepoOpType opType, @Nullable List<? extends com.tencent.aio.data.msglist.a> list, @Nullable Bundle extra) {
        Object last;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, opType, list, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(opType, "opType");
        r0(extra);
        super.d(opType, list, extra);
        if (list != null && list.size() != this.mMsgCount) {
            this.mMsgCount = list.size();
            AIOMsgItem aIOMsgItem = null;
            if (!list.isEmpty()) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                if (last instanceof AIOMsgItem) {
                    aIOMsgItem = (AIOMsgItem) last;
                }
            }
            D().e().h(new AIOMsgListEvent.MsgCountChange(aIOMsgItem));
        }
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo, ws.a
    public void g(@NotNull IMsgListRepository.MsgListRepoOpType opType, @Nullable List<? extends com.tencent.aio.data.msglist.a> list, @Nullable Bundle extra) {
        Object last;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, opType, list, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(opType, "opType");
        r0(extra);
        super.g(opType, list, extra);
        if (list != null && list.size() != this.mMsgCount) {
            this.mMsgCount = list.size();
            AIOMsgItem aIOMsgItem = null;
            if (!list.isEmpty()) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                if (last instanceof AIOMsgItem) {
                    aIOMsgItem = (AIOMsgItem) last;
                }
            }
            D().e().h(new AIOMsgListEvent.MsgCountChange(aIOMsgItem));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final AIOMsgServiceWithContext i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOMsgServiceWithContext) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.aioMsgService;
    }

    public final long j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.locationReqTime;
    }

    @NotNull
    protected ArrayList<com.tencent.mobileqq.aio.msglist.msgrepo.g<?>> k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msgRepoAbilityList;
    }

    public final void l0(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        int coerceIn;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) msgList);
            return;
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        d0();
        StopWatch i3 = new StopWatch("injectBusinessData", QLog.isColorLevel()).i();
        Iterator<T> it = k0().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.msgrepo.g) it.next()).c(msgList);
        }
        if (msgList.size() >= 6) {
            coerceIn = RangesKt___RangesKt.coerceIn(msgList.size() / 3, 1, 4);
            g0(msgList, coerceIn);
            i3.b("concurrent inject, c=" + coerceIn + " size=" + msgList.size());
        } else {
            t0(msgList);
            i3.b("serial inject, size=" + msgList.size());
        }
        Iterator<T> it5 = k0().iterator();
        while (it5.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.msgrepo.g) it5.next()).a(msgList);
        }
        s0();
    }

    public final void n0(@NotNull List<? extends com.tencent.aio.data.msglist.a> list, @NotNull String from, @NotNull IMsgListRepository.MsgListRepoOpType opType, @Nullable Bundle extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, list, from, opType, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(opType, "opType");
        if (QLog.isDevelopLevel()) {
            QLog.i("BaseMsgRepo", 4, "[notifyMsgChange]: from " + from);
        }
        d(opType, f0(list, from, extra), extra);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = k0().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.msgrepo.g) it.next()).k();
        }
        this.locationReqTime = 0L;
    }

    public final void p0(@NotNull IMsgListRepository.MsgListRepoOpType opType, @NotNull List<? extends com.tencent.aio.data.msglist.a> list, @Nullable Bundle extra, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, opType, list, extra, from);
            return;
        }
        Intrinsics.checkNotNullParameter(opType, "opType");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(from, "from");
        if (extra != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.locationReqTime = currentTimeMillis;
            extra.putLong("location_req_time", currentTimeMillis);
        }
        QLog.i("BaseMsgRepo", 1, "[notifyMsgChangeWithLocation]: from " + from + ", time= " + this.locationReqTime);
        g(opType, f0(list, from, extra), extra);
    }

    public final void q0(@NotNull com.tencent.aio.data.msglist.a newMsgItem, @NotNull com.tencent.aio.data.msglist.a oldMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) newMsgItem, (Object) oldMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        Intrinsics.checkNotNullParameter(oldMsgItem, "oldMsgItem");
        Iterator<T> it = k0().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.msgrepo.g) it.next()).l(newMsgItem, oldMsgItem);
        }
    }
}
