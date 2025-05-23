package com.tencent.mobileqq.aio.msglist.helper;

import androidx.recyclerview.widget.AIORecycleView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0002\f\u0010B\u001b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/helper/d;", "", "", "scene", "", "i", "", "k", "j", "d", "g", "Landroidx/recyclerview/widget/AIORecycleView;", "a", "Landroidx/recyclerview/widget/AIORecycleView;", "recyclerView", "Lcom/tencent/mobileqq/aio/msglist/helper/d$b;", "b", "Lcom/tencent/mobileqq/aio/msglist/helper/d$b;", "getListener", "()Lcom/tencent/mobileqq/aio/msglist/helper/d$b;", "setListener", "(Lcom/tencent/mobileqq/aio/msglist/helper/d$b;)V", "listener", "", "c", "I", "cookie", "Ljava/lang/Boolean;", "shouldLockLayout", "<init>", "(Landroidx/recyclerview/widget/AIORecycleView;Lcom/tencent/mobileqq/aio/msglist/helper/d$b;)V", "e", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIORecycleView recyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b listener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile int cookie;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile Boolean shouldLockLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/helper/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.helper.d$a, reason: from kotlin metadata */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/helper/d$b;", "", "", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface b {
        void a();

        void b();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58957);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d(@NotNull AIORecycleView recyclerView, @Nullable b bVar) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView, (Object) bVar);
            return;
        }
        this.recyclerView = recyclerView;
        this.listener = bVar;
        this.cookie = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final long j3, final int i3, final d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("MsgListLockLayoutHelper", 1, "[delayLock] time up, delay=" + (System.currentTimeMillis() - j3));
        ThreadManagerV2.getUIHandlerV2().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.helper.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f(i3, this$0, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, d this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != this$0.cookie) {
            QLog.i("MsgListLockLayoutHelper", 1, "[delayLock] cookie mismatch, myCookie=" + i3 + ", cookie=" + this$0.cookie);
            return;
        }
        this$0.i("delay lock, delay=" + (System.currentTimeMillis() - j3) + " ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != this$0.cookie) {
            QLog.i("MsgListLockLayoutHelper", 1, "[delayUnlock] cookie mismatch, myCookie=" + i3 + ", cookie=" + this$0.cookie);
            return;
        }
        this$0.k("delay unlock");
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.i("MsgListLockLayoutHelper", 1, "[delayLock] wait to lock");
        final long currentTimeMillis = System.currentTimeMillis();
        final int i3 = this.cookie;
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.helper.b
            @Override // java.lang.Runnable
            public final void run() {
                d.e(currentTimeMillis, i3, this);
            }
        }, 16, null, true, 80L);
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            final int i3 = this.cookie;
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.helper.a
                @Override // java.lang.Runnable
                public final void run() {
                    d.h(i3, this);
                }
            }, 600L);
        }
    }

    public final synchronized boolean i(@NotNull String scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) scene)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (Intrinsics.areEqual(this.shouldLockLayout, Boolean.FALSE)) {
            QLog.i("MsgListLockLayoutHelper", 1, "[doLock] no need to lock, already unlocked, scene=" + scene);
            return false;
        }
        if (this.recyclerView.isLayoutSuppressed()) {
            QLog.i("MsgListLockLayoutHelper", 1, "[doLock] already locked, scene=" + scene);
            return false;
        }
        if (this.recyclerView.isComputingLayout()) {
            QLog.i("MsgListLockLayoutHelper", 1, "[doLock] can not lock, already inLayout scene=" + scene);
            return false;
        }
        this.recyclerView.suppressLayout(true);
        b bVar = this.listener;
        if (bVar != null) {
            bVar.a();
        }
        QLog.i("MsgListLockLayoutHelper", 1, "[doLock] start locking, scene=" + scene);
        return true;
    }

    public final synchronized void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        k("reset");
        this.cookie++;
        this.shouldLockLayout = null;
        QLog.i("MsgListLockLayoutHelper", 1, "[reset] shouldLockLayout set null");
    }

    public final synchronized void k(@NotNull String scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) scene);
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        Boolean bool = this.shouldLockLayout;
        Boolean bool2 = Boolean.FALSE;
        if (Intrinsics.areEqual(bool, bool2)) {
            QLog.i("MsgListLockLayoutHelper", 1, "[unlock] no need to unlock, scene=" + scene);
            return;
        }
        this.shouldLockLayout = bool2;
        if (this.recyclerView.isLayoutSuppressed()) {
            QLog.i("MsgListLockLayoutHelper", 1, "[unlock] stop locking, scene=" + scene);
            this.recyclerView.suppressLayout(false);
        } else {
            QLog.i("MsgListLockLayoutHelper", 1, "[unlock] already unlocked or not lock yet, scene=" + scene);
        }
        b bVar = this.listener;
        if (bVar != null) {
            bVar.b();
        }
    }
}
