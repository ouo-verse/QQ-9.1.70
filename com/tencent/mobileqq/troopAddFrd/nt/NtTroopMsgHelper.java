package com.tencent.mobileqq.troopAddFrd.nt;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0002\u0010\u0014B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0002R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troopAddFrd/nt/NtTroopMsgHelper;", "", "", "g", "Lcom/tencent/qqnt/msg/d;", "msg", "", "isSend", "d", "", "troopUin", "Lcom/tencent/mobileqq/troopAddFrd/nt/NtTroopMsgHelper$b;", "listener", h.F, "f", "Lkotlinx/coroutines/CompletableJob;", "a", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "c", "J", "troopAioLastMsgSeq", "Lcom/tencent/mobileqq/troopAddFrd/nt/NtTroopMsgHelper$b;", "msgUpdateListener", "<init>", "()V", "e", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class NtTroopMsgHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CompletableJob job;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CoroutineScope scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile long troopAioLastMsgSeq;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b msgUpdateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troopAddFrd/nt/NtTroopMsgHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troopAddFrd.nt.NtTroopMsgHelper$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troopAddFrd/nt/NtTroopMsgHelper$b;", "", "Lcom/tencent/qqnt/msg/d;", "msg", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface b {
        void a(@NotNull com.tencent.qqnt.msg.d msg2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62654);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NtTroopMsgHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(com.tencent.qqnt.msg.d msg2, boolean z16) {
        TextElement textElement;
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        String str = msg2.a().peerUid;
        String str2 = msg2.a().senderUid;
        if (z16) {
            ArrayList<MsgElement> eleList = msg2.a().elements;
            Intrinsics.checkNotNullExpressionValue(eleList, "eleList");
            if (!(!eleList.isEmpty()) || (textElement = eleList.get(0).textElement) == null || (str2 = textElement.atNtUid) == null) {
                return;
            }
        }
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str2);
        if (TextUtils.isEmpty(uinFromUid)) {
            return;
        }
        int i3 = msg2.a().msgType;
        long j3 = msg2.a().msgTime;
        long j16 = msg2.a().msgSeq;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopBatchAddFriendService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026nt.MAIN\n                )");
        x troopBatchAddFriendMgr = ((ITroopBatchAddFriendService) runtimeService).getTroopBatchAddFriendMgr();
        if (troopBatchAddFriendMgr != null) {
            troopBatchAddFriendMgr.C(str, uinFromUid, i3, j3, j16);
        }
        if (QLog.isDebugVersion()) {
            QLog.d("NtTroopMsgHelper", 4, "handleAtOrReplyMsg,troopUin=" + str + ",memberUin=" + uinFromUid + ",msgSeq=" + j16);
        }
    }

    public final void d(@NotNull final com.tencent.qqnt.msg.d msg2, final boolean isSend) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, msg2, Boolean.valueOf(isSend));
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troopAddFrd.nt.a
                @Override // java.lang.Runnable
                public final void run() {
                    NtTroopMsgHelper.e(com.tencent.qqnt.msg.d.this, isSend);
                }
            }, 16, null, false);
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        CompletableJob completableJob = this.job;
        if (completableJob != null) {
            Job.DefaultImpls.cancel$default((Job) completableJob, (CancellationException) null, 1, (Object) null);
        }
        this.job = null;
        CoroutineScope coroutineScope = this.scope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        this.scope = null;
        this.msgUpdateListener = null;
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = SupervisorJob$default;
        if (SupervisorJob$default != null) {
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default);
            this.scope = CoroutineScope;
            if (CoroutineScope != null) {
                FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerReceiveMsgNotificationFlow(), new NtTroopMsgHelper$registerTroopAtReplyMeMsgListener$1$1$1(this, null)), Dispatchers.getIO()), CoroutineScope);
            }
        }
    }

    public final void h(@NotNull String troopUin, @NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.msgUpdateListener = listener;
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.job = SupervisorJob$default;
        if (SupervisorJob$default != null) {
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default);
            this.scope = CoroutineScope;
            if (CoroutineScope != null) {
                FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerReceiveMsgNotificationFlow(), new NtTroopMsgHelper$registerTroopMsgListenerInAio$1$1$1(troopUin, this, null)), Dispatchers.getIO()), CoroutineScope);
            }
            CoroutineScope coroutineScope = this.scope;
            if (coroutineScope != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NtTroopMsgHelper$registerTroopMsgListenerInAio$1$2(troopUin, this, null), 3, null);
            }
        }
    }
}
