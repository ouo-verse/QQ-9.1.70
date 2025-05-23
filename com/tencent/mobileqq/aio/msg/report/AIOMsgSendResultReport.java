package com.tencent.mobileqq.aio.msg.report;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.beacon.NTBeaconReport;
import com.tencent.qqnt.kernel.api.AIOSendMsgResultData;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002\u0016\u001cB\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001a0\u0019j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001a`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/msg/report/AIOMsgSendResultReport;", "", "", "g", "i", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "mr", "f", "d", "", "msgId", "", "success", "k", "Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData;", "result", "", "", "e", "l", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/aio/msg/report/AIOMsgSendResultReport$b;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "msgIdStatusMap", "<init>", "()V", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMsgSendResultReport {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<AIOMsgSendResultReport> f190190d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, b> msgIdStatusMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/report/AIOMsgSendResultReport$a;", "", "Lcom/tencent/mobileqq/aio/msg/report/AIOMsgSendResultReport;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/aio/msg/report/AIOMsgSendResultReport;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.report.AIOMsgSendResultReport$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final AIOMsgSendResultReport a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIOMsgSendResultReport) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (AIOMsgSendResultReport) AIOMsgSendResultReport.f190190d.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/report/AIOMsgSendResultReport$b;", "", "Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData;", "a", "Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData;", "()Lcom/tencent/qqnt/kernel/api/AIOSendMsgResultData;", "sendMsgResult", "", "b", "J", "getLastUpdateTime", "()J", "(J)V", WadlProxyConsts.LAST_UPDATE_TIME, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIOSendMsgResultData sendMsgResult;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long lastUpdateTime;

        public b(@NotNull MsgRecord msgRecord) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
            } else {
                this.sendMsgResult = new AIOSendMsgResultData(AIOSendMsgResultData.SendPhase.Send, msgRecord);
                this.lastUpdateTime = System.currentTimeMillis();
            }
        }

        @NotNull
        public final AIOSendMsgResultData a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIOSendMsgResultData) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.sendMsgResult;
        }

        public final void b(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
            } else {
                this.lastUpdateTime = j3;
            }
        }
    }

    static {
        Lazy<AIOMsgSendResultReport> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57543);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIOMsgSendResultReport$Companion$instance$2.INSTANCE);
        f190190d = lazy;
    }

    public /* synthetic */ AIOMsgSendResultReport(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    private final void d(MsgRecord mr5) {
        synchronized (this.msgIdStatusMap) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AIOMsgSendResultReport", 4, "[addRecord] msgId=" + mr5.msgId + " count=" + this.msgIdStatusMap.size());
            }
            b bVar = this.msgIdStatusMap.get(Long.valueOf(mr5.msgId));
            if (bVar != null) {
                bVar.b(System.currentTimeMillis());
            } else {
                this.msgIdStatusMap.put(Long.valueOf(mr5.msgId), new b(mr5));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final Map<String, String> e(AIOSendMsgResultData result) {
        HashMap hashMap = new HashMap();
        hashMap.put("param_send_type", result.f().getValue());
        hashMap.put("param_send_phase", result.e().getValue());
        hashMap.put("param_cost_time", String.valueOf(result.b()));
        hashMap.put("param_chat_type", String.valueOf(result.a()));
        hashMap.put("param_error_code", String.valueOf(result.c()));
        hashMap.put("param_msg_element_type", String.valueOf(result.d()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(MsgRecord mr5) {
        try {
            int i3 = mr5.sendStatus;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2 || i3 == 3) {
                        k(mr5.msgId, true);
                    }
                } else {
                    d(mr5);
                }
            } else {
                k(mr5.msgId, false);
            }
        } catch (Exception e16) {
            QLog.i("AIOMsgSendResultReport", 1, "[onMsgStatusChange], exc=" + e16);
        }
    }

    private final void g() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msg.report.a
            @Override // java.lang.Runnable
            public final void run() {
                AIOMsgSendResultReport.h(AIOMsgSendResultReport.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AIOMsgSendResultReport this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        this$0.j();
    }

    private final void i() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.w(), new AIOMsgSendResultReport$registerMsgSendNotification$1(this, null)), Dispatchers.getIO()), this.scope);
    }

    private final void j() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.q(), new AIOMsgSendResultReport$registerMsgStatusNotification$1(this, null)), Dispatchers.getIO()), this.scope);
    }

    private final void k(long msgId, boolean success) {
        int i3;
        synchronized (this.msgIdStatusMap) {
            b remove = this.msgIdStatusMap.remove(Long.valueOf(msgId));
            if (remove != null) {
                AIOSendMsgResultData a16 = remove.a();
                if (success) {
                    i3 = 0;
                } else {
                    i3 = -1;
                }
                a16.h(i3);
                l(remove.a());
                return;
            }
            QLog.i("AIOMsgSendResultReport", 1, "[removeAndReport] msg id not found, msgId=" + msgId);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void l(@NotNull AIOSendMsgResultData result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
            return;
        }
        Intrinsics.checkNotNullParameter(result, "result");
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOMsgSendResultReport", 4, "[report] result=" + result);
        }
        NTBeaconReport.j(null, "actNtAIOMsgSendResult", result.g(), e(result), false);
    }

    AIOMsgSendResultReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.scope = CoroutineScopeKt.MainScope();
        this.msgIdStatusMap = new HashMap<>();
        g();
    }
}
