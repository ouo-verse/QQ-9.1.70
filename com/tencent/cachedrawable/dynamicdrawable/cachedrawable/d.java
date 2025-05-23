package com.tencent.cachedrawable.dynamicdrawable.cachedrawable;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0002\n\u000fB\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/d;", "Lcom/tencent/cachedrawable/dynamicdrawable/a;", "", "e", "g", tl.h.F, "c", "d", "Lcom/tencent/cachedrawable/dynamicdrawable/h;", "producer", "a", "", "Ljava/lang/String;", "sceneBusinessTag", "", "b", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "", "Z", "isPlay", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "producers", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "runnable", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/d$b;", "f", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/d$b;", "timeLineHandler", "<init>", "(Ljava/lang/String;)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class d implements com.tencent.cachedrawable.dynamicdrawable.a {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sceneBusinessTag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile Object lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isPlay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<com.tencent.cachedrawable.dynamicdrawable.h> producers;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable runnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b timeLineHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/d$a;", "", "", "DEFAULT_SCENE", "Ljava/lang/String;", "", "FRESH_TIME", "J", "LIVE_TIME", "", "MSG_UI_UPDATE", "I", "TAG", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.d$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
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
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/d$b;", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "Ljava/lang/Runnable;", "a", "Ljava/lang/Runnable;", "runnable", "", "b", "J", "getStopClock", "()J", "(J)V", "stopClock", "Landroid/os/Looper;", "looper", "<init>", "(Landroid/os/Looper;Ljava/lang/Runnable;)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public static final class b extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Runnable runnable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long stopClock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull Looper looper, @NotNull Runnable runnable) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper, (Object) runnable);
            } else {
                this.runnable = runnable;
                this.stopClock = SystemClock.uptimeMillis() + 10000;
            }
        }

        public final void a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                this.stopClock = j3;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 0) {
                this.runnable.run();
                if (this.stopClock > SystemClock.uptimeMillis() && !hasMessages(0)) {
                    sendEmptyMessageDelayed(0, 20L);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8676);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull String sceneBusinessTag) {
        Intrinsics.checkNotNullParameter(sceneBusinessTag, "sceneBusinessTag");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sceneBusinessTag);
            return;
        }
        this.sceneBusinessTag = sceneBusinessTag;
        this.lock = new Object();
        this.isPlay = true;
        this.producers = new CopyOnWriteArrayList<>();
        this.runnable = new Runnable() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f(d.this);
            }
        };
        Looper looper = com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.h.f99037a.e().getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "ThreadManager.timeLineThread.looper");
        this.timeLineHandler = new b(looper, this.runnable);
    }

    private final void e() {
        Iterator<com.tencent.cachedrawable.dynamicdrawable.h> it = this.producers.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
    }

    private final void g() {
        if (this.isPlay) {
            if (!this.timeLineHandler.hasMessages(0)) {
                this.timeLineHandler.sendEmptyMessage(0);
            }
            this.timeLineHandler.a(SystemClock.uptimeMillis() + 10000);
        }
    }

    private final void h() {
        try {
            Iterator<com.tencent.cachedrawable.dynamicdrawable.h> it = this.producers.iterator();
            while (it.hasNext()) {
                com.tencent.cachedrawable.dynamicdrawable.h next = it.next();
                if (next.c(SystemClock.uptimeMillis())) {
                    this.producers.remove(next);
                }
            }
        } catch (OutOfMemoryError e16) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("AnimTimeLine", Intrinsics.stringPlus("OutOfMemoryError : e ", e16));
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.a
    public void a(@NotNull com.tencent.cachedrawable.dynamicdrawable.h producer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) producer);
            return;
        }
        Intrinsics.checkNotNullParameter(producer, "producer");
        if (!this.producers.contains(producer)) {
            this.producers.add(producer);
        }
        synchronized (this.lock) {
            g();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void c() {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.sceneBusinessTag, "default", false, 2, null);
            if (startsWith$default) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("AnimTimeLine", "\u9ed8\u8ba4\u65f6\u95f4\u7ebf\u4e0d\u63d0\u4f9b \u65f6\u95f4\u7ebf\u5168\u5c40\u6682\u505c\u529f\u80fd\uff0c\u8bf7\u4f7f\u7528\u81ea\u5b9a\u4e49\u4e1a\u52a1 tag \u5bf9\u5e94\u7684\u65f6\u95f4\u7ebf");
                return;
            }
            synchronized (this.lock) {
                if (this.isPlay) {
                    this.timeLineHandler.removeMessages(0);
                    this.timeLineHandler.a(0L);
                    this.isPlay = false;
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public final void d() {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.sceneBusinessTag, "default", false, 2, null);
            if (startsWith$default) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("AnimTimeLine", "\u9ed8\u8ba4\u65f6\u95f4\u7ebf\u4e0d\u63d0\u4f9b \u65f6\u95f4\u7ebf\u5168\u5c40\u6682\u505c\u529f\u80fd\uff0c\u8bf7\u4f7f\u7528\u81ea\u5b9a\u4e49\u4e1a\u52a1 tag \u5bf9\u5e94\u7684\u65f6\u95f4\u7ebf");
                return;
            }
            synchronized (this.lock) {
                if (!this.isPlay) {
                    this.isPlay = true;
                    e();
                    g();
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
