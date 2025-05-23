package com.tencent.mobileqq.settings.message;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelScanEndCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\f\u0010\n\u001a\u00020\t*\u00020\bH\u0007J3\u0010\u0011\u001a\u00020\t*\u00020\b2%\b\u0002\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH\u0007J\u0013\u0010\u0012\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/settings/message/ChatHistorySettingNTHelper;", "", "Lcom/tencent/qqnt/kernel/api/IKernelService;", "g", "Lcom/tencent/qqnt/kernel/api/aa;", tl.h.F, "Lcom/tencent/qqnt/kernel/api/af;", "i", "Landroidx/lifecycle/Lifecycle;", "", "f", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "callback", "e", "j", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", "d", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ChatHistorySettingNTHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ChatHistorySettingNTHelper f286950a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class a implements IOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f286951a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Boolean> continuation) {
            this.f286951a = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public final void onResult(int i3, String str) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            Continuation<Boolean> continuation = this.f286951a;
            Result.Companion companion = Result.INSTANCE;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            continuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class b implements IOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f286952a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f286953b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Ref.BooleanRef booleanRef, Continuation<? super Boolean> continuation) {
            this.f286952a = booleanRef;
            this.f286953b = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) booleanRef, (Object) continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public final void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            boolean z16 = true;
            QLog.d("ChatHistorySettingNTHelper", 1, " clearRecentContacts " + i3 + " errMsg " + str);
            Ref.BooleanRef booleanRef = this.f286952a;
            if (!booleanRef.element) {
                booleanRef.element = true;
                Continuation<Boolean> continuation = this.f286953b;
                Result.Companion companion = Result.INSTANCE;
                if (i3 != 0) {
                    z16 = false;
                }
                continuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032*\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "result", "", "<anonymous parameter 1>", "Ljava/util/ArrayList;", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class c implements IKernelScanEndCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f286954a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super Boolean> continuation) {
            this.f286954a = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelScanEndCallback
        public final void onResult(int i3, ArrayList<Long> arrayList) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) arrayList);
                return;
            }
            Continuation<Boolean> continuation = this.f286954a;
            Result.Companion companion = Result.INSTANCE;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            continuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60471);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f286950a = new ChatHistorySettingNTHelper();
        }
    }

    ChatHistorySettingNTHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object d(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.d("ChatHistorySettingNTHelper", 1, "clearALLChatCacheInfo");
        com.tencent.qqnt.kernel.api.af i3 = f286950a.i();
        if (i3 != null) {
            i3.clearAllChatCacheInfo(new a(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @JvmStatic
    public static final void e(@NotNull Lifecycle lifecycle, @Nullable Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new ChatHistorySettingNTHelper$clearRecentContacts$1(function1, null), 3, null);
    }

    @JvmStatic
    public static final void f(@NotNull Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new ChatHistorySettingNTHelper$delRecentList$1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new ChatHistorySettingNTHelper$delRecentList$2(null), 3, null);
    }

    private final IKernelService g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "");
        }
        return null;
    }

    private final com.tencent.qqnt.kernel.api.aa h() {
        IKernelService g16 = g();
        if (g16 != null) {
            return g16.getRecentContactService();
        }
        return null;
    }

    private final com.tencent.qqnt.kernel.api.af i() {
        IKernelService g16 = g();
        if (g16 != null) {
            return g16.getStorageCleanService();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        com.tencent.qqnt.kernel.api.aa h16 = f286950a.h();
        if (h16 != null) {
            h16.clearRecentContacts(new b(booleanRef, safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object k(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QLog.d("ChatHistorySettingNTHelper", 1, "startScan");
        com.tencent.qqnt.kernel.api.af i3 = f286950a.i();
        if (i3 != null) {
            i3.Z(new c(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
