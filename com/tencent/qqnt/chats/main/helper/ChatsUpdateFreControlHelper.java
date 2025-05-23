package com.tencent.qqnt.chats.main.helper;

import android.os.Handler;
import androidx.annotation.UiThread;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.MutableLiveData;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.core.uistate.a;
import com.tencent.qqnt.kernel.utils.n;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0002?\u0013B9\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00020\u001f\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\b\u0010\u000b\u001a\u00020\u0002H\u0007J\b\u0010\f\u001a\u00020\u0002H\u0007J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0007J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010)\u001a\u00060'R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010.R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010.R\u0018\u00103\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010.R\u0014\u00106\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010,R\u001b\u00109\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u00107\u001a\u0004\b5\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010;\u00a8\u0006@"}, d2 = {"Lcom/tencent/qqnt/chats/main/helper/ChatsUpdateFreControlHelper;", "", "", ReportConstant.COSTREPORT_PREFIX, "", "k", "Lcom/tencent/qqnt/chats/core/uistate/a$b;", "state", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", DomainData.DOMAIN_NAME, "t", "i", h.F, "o", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "uiHandler", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "b", "Landroidx/lifecycle/MutableLiveData;", "observer", "Lcom/tencent/qqnt/chats/core/a;", "c", "Lcom/tencent/qqnt/chats/core/a;", "chatsContext", "Lkotlin/Function1;", "Lcom/tencent/qqnt/chats/core/uievent/b;", "d", "Lkotlin/jvm/functions/Function1;", "sendEvent", "e", "J", "lastNotifyTimeInMills", "Lcom/tencent/qqnt/chats/main/helper/ChatsUpdateFreControlHelper$CacheRunnable;", "Lcom/tencent/qqnt/chats/main/helper/ChatsUpdateFreControlHelper$CacheRunnable;", "updateRunnable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isBackground", "Z", "isFirstUpdate", "isFirstResume", "j", "Lcom/tencent/qqnt/chats/core/uistate/a$b;", "cacheState", "isGuildUpdate", "l", "isAllowUpdate", "Lkotlin/Lazy;", "()Z", "isPad", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "enableAnimRun", "<init>", "(Landroid/os/Handler;Landroidx/lifecycle/MutableLiveData;Lcom/tencent/qqnt/chats/core/a;Lkotlin/jvm/functions/Function1;)V", "CacheRunnable", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsUpdateFreControlHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.qqnt.chats.core.uistate.b> observer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.core.a chatsContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<com.tencent.qqnt.chats.core.uievent.b, Unit> sendEvent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile long lastNotifyTimeInMills;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CacheRunnable updateRunnable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isBackground;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isFirstUpdate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstResume;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile a.b cacheState;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isGuildUpdate;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isAllowUpdate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isPad;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable enableAnimRun;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/main/helper/ChatsUpdateFreControlHelper$CacheRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lcom/tencent/qqnt/chats/core/uistate/a$b;", "d", "Lcom/tencent/qqnt/chats/core/uistate/a$b;", "getState", "()Lcom/tencent/qqnt/chats/core/uistate/a$b;", "a", "(Lcom/tencent/qqnt/chats/core/uistate/a$b;)V", "state", "<init>", "(Lcom/tencent/qqnt/chats/main/helper/ChatsUpdateFreControlHelper;)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public final class CacheRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private a.b state;

        public CacheRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatsUpdateFreControlHelper.this);
            }
        }

        public final void a(@Nullable a.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            } else {
                this.state = bVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            a.b bVar = this.state;
            if (bVar != null) {
                ChatsUpdateFreControlHelper chatsUpdateFreControlHelper = ChatsUpdateFreControlHelper.this;
                QLog.d("ChatsUpdateFreControlHelper", 1, "[CacheRunnable] run to update");
                this.state = null;
                chatsUpdateFreControlHelper.observer.setValue(bVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/main/helper/ChatsUpdateFreControlHelper$a;", "", "", "GROUP_NOTIFY_TIME", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.helper.ChatsUpdateFreControlHelper$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45034);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatsUpdateFreControlHelper(@NotNull Handler uiHandler, @NotNull MutableLiveData<com.tencent.qqnt.chats.core.uistate.b> observer, @NotNull com.tencent.qqnt.chats.core.a chatsContext, @NotNull Function1<? super com.tencent.qqnt.chats.core.uievent.b, Unit> sendEvent) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(uiHandler, "uiHandler");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(chatsContext, "chatsContext");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uiHandler, observer, chatsContext, sendEvent);
            return;
        }
        this.uiHandler = uiHandler;
        this.observer = observer;
        this.chatsContext = chatsContext;
        this.sendEvent = sendEvent;
        this.updateRunnable = new CacheRunnable();
        this.isBackground = new AtomicBoolean(false);
        this.isFirstUpdate = true;
        this.isFirstResume = true;
        this.isAllowUpdate = new AtomicBoolean(true);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Boolean>() { // from class: com.tencent.qqnt.chats.main.helper.ChatsUpdateFreControlHelper$isPad$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatsUpdateFreControlHelper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                com.tencent.qqnt.chats.core.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
                aVar = ChatsUpdateFreControlHelper.this.chatsContext;
                return Boolean.valueOf(bVar.isSplitViewMode(aVar.a()));
            }
        });
        this.isPad = lazy;
        this.enableAnimRun = new Runnable() { // from class: com.tencent.qqnt.chats.main.helper.b
            @Override // java.lang.Runnable
            public final void run() {
                ChatsUpdateFreControlHelper.j(ChatsUpdateFreControlHelper.this);
            }
        };
    }

    @WorkerThread
    private final void f(final a.b state) {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = 500 - (currentTimeMillis - this.lastNotifyTimeInMills);
        this.lastNotifyTimeInMills = currentTimeMillis;
        this.uiHandler.removeCallbacks(this.updateRunnable);
        if (state.f() && j3 > 0) {
            this.updateRunnable.a(state);
            this.uiHandler.postDelayed(this.updateRunnable, j3);
        } else {
            this.uiHandler.post(new Runnable() { // from class: com.tencent.qqnt.chats.main.helper.c
                @Override // java.lang.Runnable
                public final void run() {
                    ChatsUpdateFreControlHelper.g(ChatsUpdateFreControlHelper.this, state);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ChatsUpdateFreControlHelper this$0, a.b state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0.observer.setValue(state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ChatsUpdateFreControlHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isBackground.get()) {
            QLog.d("ChatsUpdateFreControlHelper", 1, "[enableAnimRun] not send when return background");
        } else {
            this$0.sendEvent.invoke(a.f.f355010a);
        }
    }

    private final long k() {
        if (this.isFirstResume) {
            this.isFirstResume = false;
            return 5000L;
        }
        return 1000L;
    }

    private final boolean l() {
        return ((Boolean) this.isPad.getValue()).booleanValue();
    }

    @WorkerThread
    private final boolean m(a.b state) {
        if (state.h() == this.isGuildUpdate && (this.isBackground.get() || !this.isAllowUpdate.get())) {
            QLog.d("ChatsUpdateFreControlHelper", 1, "[notifyDataChange] disallow when background: " + this.chatsContext.b() + ", isBg=" + this.isBackground.get() + ", isAllow=" + this.isAllowUpdate.get());
            a.b bVar = this.cacheState;
            if (bVar != null && !bVar.f()) {
                a.b bVar2 = new a.b(state.d(), state.b(), bVar.e(), bVar.f(), state.g());
                bVar2.j(bVar.h());
                bVar2.i(bVar.c());
                this.cacheState = bVar2;
            } else {
                this.cacheState = state;
            }
            return true;
        }
        if (state.h() != this.isGuildUpdate && state.f()) {
            QLog.d("ChatsUpdateFreControlHelper", 1, "[notifyDataChange] throw part update when data inconsistency: " + this.chatsContext.b());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ChatsUpdateFreControlHelper this$0, a.b state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0.observer.setValue(state);
    }

    private final void s() {
        if (this.isAllowUpdate.get() && !this.isBackground.get()) {
            a.b bVar = this.cacheState;
            if (bVar != null) {
                this.observer.setValue(bVar);
                this.cacheState = null;
                this.lastNotifyTimeInMills = (System.currentTimeMillis() - 500) + 80;
            }
            if (!l()) {
                this.uiHandler.removeCallbacks(this.enableAnimRun);
                this.uiHandler.postDelayed(this.enableAnimRun, k());
            }
        }
    }

    @UiThread
    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.uiHandler.removeCallbacksAndMessages(null);
        }
    }

    @UiThread
    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.isAllowUpdate.compareAndSet(true, false);
        }
    }

    @WorkerThread
    public final void o(@NotNull final a.b state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (m(state)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ChatsUpdateFreControlHelper", 2, "[notifyDataChange] try to update");
        }
        this.cacheState = null;
        if (!state.f()) {
            this.isGuildUpdate = state.h();
        }
        if (this.isFirstUpdate) {
            this.isFirstUpdate = false;
            n.f359273a.k(5);
            this.uiHandler.postAtFrontOfQueue(new Runnable() { // from class: com.tencent.qqnt.chats.main.helper.a
                @Override // java.lang.Runnable
                public final void run() {
                    ChatsUpdateFreControlHelper.p(ChatsUpdateFreControlHelper.this, state);
                }
            });
            return;
        }
        f(state);
    }

    @UiThread
    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (l()) {
                return;
            }
            this.isBackground.set(true);
            this.uiHandler.removeCallbacks(this.enableAnimRun);
            this.sendEvent.invoke(a.e.f355009a);
            QLog.d("ChatsUpdateFreControlHelper", 1, "[onBackground] call on control");
        }
    }

    @UiThread
    public final void r() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.cacheState != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("ChatsUpdateFreControlHelper", 1, "[onForeground] try update: " + z16);
        this.isBackground.set(false);
        s();
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.isAllowUpdate.compareAndSet(false, true);
            s();
        }
    }
}
