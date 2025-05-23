package com.tencent.mobileqq.login.restart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.login.restart.ProcessPreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/login/restart/ProcessPreloadHelper;", "", "", "processName", "", "timeout", "Lcom/tencent/mobileqq/login/restart/r;", "listener", "", "f", "b", "Landroid/content/Context;", "context", "Landroid/content/BroadcastReceiver;", "receiver", tl.h.F, "j", "e", "d", "c", "i", "<init>", "()V", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ProcessPreloadHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ProcessPreloadHelper f242601a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\b\u001a\u00020\u0005R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/login/restart/ProcessPreloadHelper$a;", "", "", "timeout", "Lkotlin/Function0;", "", "block", "c", "b", "", "a", "Z", "isCanceled", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isCanceled;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(a this$0, Function0 block) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(block, "$block");
            if (!this$0.isCanceled) {
                block.invoke();
            }
        }

        public final void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.isCanceled = true;
            }
        }

        public final void c(int timeout, @NotNull final Function0<Unit> block) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, timeout, (Object) block);
            } else {
                Intrinsics.checkNotNullParameter(block, "block");
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.login.restart.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProcessPreloadHelper.a.d(ProcessPreloadHelper.a.this, block);
                    }
                }, timeout);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24233);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f242601a = new ProcessPreloadHelper();
        }
    }

    ProcessPreloadHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(String processName) {
        return "com.tencent.mobileqq.login.restart.preload.end." + processName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.tencent.mobileqq.login.restart.ProcessPreloadHelper$preloadProcess$1, T, android.content.BroadcastReceiver] */
    private final void f(final String processName, int timeout, final r listener) {
        if (!c.f242621a.a().l()) {
            QLog.i("ProcessRestartPreloadHelper", 1, "disable waiting process preload");
            if (listener != null) {
                listener.a(true);
                return;
            }
            return;
        }
        QLog.i("ProcessRestartPreloadHelper", 1, "preloadProcess processName=" + processName);
        final BaseApplication context = BaseApplication.getContext();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final a aVar = new a();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            if (Intrinsics.areEqual("main", processName)) {
                Intent intent = new Intent(context, (Class<?>) MainProcessPreloadReceiver.class);
                intent.setPackage(context.getPackageName());
                context.sendBroadcast(intent);
            } else if (Intrinsics.areEqual("account", processName)) {
                context.startService(new Intent(context, (Class<?>) AccountProcessPreloadService.class));
            }
            ?? r142 = new BroadcastReceiver(processName, aVar, objectRef, booleanRef, listener, context) { // from class: com.tencent.mobileqq.login.restart.ProcessPreloadHelper$preloadProcess$1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f242603a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ ProcessPreloadHelper.a f242604b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ Ref.ObjectRef<BroadcastReceiver> f242605c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Ref.BooleanRef f242606d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ r f242607e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ BaseApplication f242608f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f242603a = processName;
                    this.f242604b = aVar;
                    this.f242605c = objectRef;
                    this.f242606d = booleanRef;
                    this.f242607e = listener;
                    this.f242608f = context;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, processName, aVar, objectRef, booleanRef, listener, context);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context2, @Nullable Intent intent2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context2, (Object) intent2);
                        return;
                    }
                    QLog.i("ProcessRestartPreloadHelper", 1, "PreloadEndReceiver onReceiver processName=" + this.f242603a);
                    ProcessPreloadHelper.g(this.f242604b, this.f242605c, this.f242606d, this.f242607e, this.f242608f, true);
                }
            };
            ProcessPreloadHelper processPreloadHelper = f242601a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            processPreloadHelper.h(context, r142, processName);
            objectRef.element = r142;
            if (timeout > 0) {
                aVar.c(timeout, new Function0<Unit>(processName, aVar, objectRef, booleanRef, listener, context) { // from class: com.tencent.mobileqq.login.restart.ProcessPreloadHelper$preloadProcess$3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ BaseApplication $context;
                    final /* synthetic */ Ref.BooleanRef $hasCallbackResult;
                    final /* synthetic */ r $listener;
                    final /* synthetic */ Ref.ObjectRef<BroadcastReceiver> $preloadEndReceiver;
                    final /* synthetic */ ProcessPreloadHelper.a $preloadTimeout;
                    final /* synthetic */ String $processName;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$processName = processName;
                        this.$preloadTimeout = aVar;
                        this.$preloadEndReceiver = objectRef;
                        this.$hasCallbackResult = booleanRef;
                        this.$listener = listener;
                        this.$context = context;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, processName, aVar, objectRef, booleanRef, listener, context);
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
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        QLog.w("ProcessRestartPreloadHelper", 1, "preload process timeout, processName=" + this.$processName);
                        ProcessPreloadHelper.g(this.$preloadTimeout, this.$preloadEndReceiver, this.$hasCallbackResult, this.$listener, this.$context, false);
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e("ProcessRestartPreloadHelper", 1, "start service or broadcast error: ", e16);
            g(aVar, objectRef, booleanRef, listener, context, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(a aVar, Ref.ObjectRef<BroadcastReceiver> objectRef, Ref.BooleanRef booleanRef, r rVar, BaseApplication context, boolean z16) {
        aVar.b();
        BroadcastReceiver broadcastReceiver = objectRef.element;
        if (broadcastReceiver != null) {
            ProcessPreloadHelper processPreloadHelper = f242601a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            processPreloadHelper.j(context, broadcastReceiver);
            objectRef.element = null;
        }
        if (!booleanRef.element) {
            booleanRef.element = true;
            if (rVar != null) {
                rVar.a(z16);
            }
        }
    }

    private final void h(Context context, BroadcastReceiver receiver, String processName) {
        try {
            context.registerReceiver(receiver, new IntentFilter(b(processName)));
        } catch (Exception e16) {
            QLog.e("ProcessRestartPreloadHelper", 1, "registerPreloadEndReceiver error:", e16);
        }
    }

    private final void j(Context context, BroadcastReceiver receiver) {
        try {
            context.unregisterReceiver(receiver);
        } catch (Exception e16) {
            QLog.e("ProcessRestartPreloadHelper", 1, "unregisterPreloadEndReceiver error:", e16);
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            QLog.i("ProcessRestartPreloadHelper", 1, "onApplicationCreateEnd");
            i();
        }
    }

    public final void d(@Nullable r listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            f("account", 2000, listener);
        }
    }

    public final void e(@Nullable r listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            f("main", 2000, listener);
        }
    }

    public final void i() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        int i3 = MobileQQ.sProcessId;
        if (17 == i3) {
            str = "account";
        } else if (1 == i3) {
            str = "main";
        } else {
            return;
        }
        try {
            Intent intent = new Intent(b(str));
            intent.setPackage("com.tencent.mobileqq");
            BaseApplication.getContext().sendBroadcast(intent);
        } catch (Exception e16) {
            QLog.e("ProcessRestartPreloadHelper", 1, "send broadcast error: ", e16);
        }
    }
}
