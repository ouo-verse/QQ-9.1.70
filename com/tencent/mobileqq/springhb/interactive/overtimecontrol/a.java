package com.tencent.mobileqq.springhb.interactive.overtimecontrol;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.interactive.ui.InteractivePopManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/overtimecontrol/a;", "", "", "reason", "", "b", "", "interactiveConfig", "d", "tag", "c", "Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager;", "a", "Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager;", "interactivePopManager", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "(Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager;)V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final C8607a f289273c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InteractivePopManager interactivePopManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/overtimecontrol/a$a;", "", "", "TAG", "Ljava/lang/String;", "", "pagViewTrackDelay", "I", "popWindowTrackDelay", "what_delay_pag", "what_delay_pop", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.interactive.overtimecontrol.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private static final class C8607a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ C8607a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        C8607a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/springhb/interactive/overtimecontrol/a$b", "Landroid/os/Handler$Callback;", "Landroid/os/Message;", "msg", "", "handleMessage", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements Handler.Callback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int i3 = msg2.what;
            if (i3 == 2) {
                a.this.b("pagPlay");
                return true;
            }
            if (i3 == 1) {
                a.this.b("popShow");
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24487);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f289273c = new C8607a(null);
        }
    }

    public a(@NotNull InteractivePopManager interactivePopManager) {
        Intrinsics.checkNotNullParameter(interactivePopManager, "interactivePopManager");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) interactivePopManager);
        } else {
            this.interactivePopManager = interactivePopManager;
            this.handler = new Handler(Looper.getMainLooper(), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String reason) {
        QLog.d("OverTimeController", 1, "overTime dismiss!! " + reason);
        this.interactivePopManager.o("overTime");
    }

    public final void c(@Nullable String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag);
            return;
        }
        QLog.d("OverTimeController", 1, tag + " clearTracker");
        this.handler.removeCallbacksAndMessages(null);
    }

    public final void d(long interactiveConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, interactiveConfig);
            return;
        }
        c("begin");
        long j3 = interactiveConfig + 2000;
        QLog.d("OverTimeController", 1, "trackPagView " + j3);
        this.handler.sendEmptyMessageDelayed(2, j3);
    }
}
