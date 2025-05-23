package com.tencent.aio.runtime.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\f\u0010\rR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/aio/runtime/message/a;", "", "Lcom/tencent/mvi/base/route/j;", "vmMessenger", "", "actionCode", "Lcom/tencent/aio/runtime/message/b;", "action", "", "a", "(Lcom/tencent/mvi/base/route/j;Ljava/lang/String;Lcom/tencent/aio/runtime/message/b;)V", "b", "c", "(Lcom/tencent/mvi/base/route/j;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/aio/runtime/message/a$a;", "Ljava/util/concurrent/ConcurrentHashMap;", "map", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<j, C0657a> map;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f69828b;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\n\u0010\tJ\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R&\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/aio/runtime/message/a$a;", "Lcom/tencent/mvi/base/route/a;", "", "a", "", "actionCode", "Lcom/tencent/aio/runtime/message/b;", "messageAction", "b", "(Ljava/lang/String;Lcom/tencent/aio/runtime/message/b;)V", "c", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "call", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "actionMap", "Lcom/tencent/mvi/base/route/j;", "e", "Lcom/tencent/mvi/base/route/j;", "vmMessenger", "<init>", "(Lcom/tencent/mvi/base/route/j;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.runtime.message.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0657a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final ConcurrentHashMap<String, CopyOnWriteArrayList<b>> actionMap;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final j vmMessenger;

        public C0657a(@NotNull j vmMessenger) {
            Intrinsics.checkNotNullParameter(vmMessenger, "vmMessenger");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) vmMessenger);
                return;
            }
            this.vmMessenger = vmMessenger;
            this.actionMap = new ConcurrentHashMap<>();
            vmMessenger.d(Reflection.getOrCreateKotlinClass(ExternalCommIntent.class).getQualifiedName(), this);
        }

        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.vmMessenger.b(Reflection.getOrCreateKotlinClass(ExternalCommIntent.class).getQualifiedName(), this);
            }
        }

        public final void b(@NotNull String actionCode, @NotNull b messageAction) {
            CopyOnWriteArrayList<b> putIfAbsent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) actionCode, (Object) messageAction);
                return;
            }
            Intrinsics.checkNotNullParameter(actionCode, "actionCode");
            Intrinsics.checkNotNullParameter(messageAction, "messageAction");
            ConcurrentHashMap<String, CopyOnWriteArrayList<b>> concurrentHashMap = this.actionMap;
            CopyOnWriteArrayList<b> copyOnWriteArrayList = concurrentHashMap.get(actionCode);
            if (copyOnWriteArrayList == null && (putIfAbsent = concurrentHashMap.putIfAbsent(actionCode, (copyOnWriteArrayList = new CopyOnWriteArrayList<>()))) != null) {
                copyOnWriteArrayList = putIfAbsent;
            }
            copyOnWriteArrayList.addIfAbsent(messageAction);
        }

        public final void c(@NotNull String actionCode, @NotNull b messageAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionCode, (Object) messageAction);
                return;
            }
            Intrinsics.checkNotNullParameter(actionCode, "actionCode");
            Intrinsics.checkNotNullParameter(messageAction, "messageAction");
            CopyOnWriteArrayList<b> copyOnWriteArrayList = this.actionMap.get(actionCode);
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.remove(messageAction);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) i3);
                return;
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof ExternalCommIntent) {
                ExternalCommIntent externalCommIntent = (ExternalCommIntent) i3;
                String a16 = externalCommIntent.a();
                if (!this.actionMap.containsKey(a16)) {
                    com.tencent.aio.base.log.a.f69187b.d("ExternalCommCenter", this.vmMessenger + " emit " + a16 + ", but not register");
                    return;
                }
                CopyOnWriteArrayList<b> copyOnWriteArrayList = this.actionMap.get(a16);
                Intrinsics.checkNotNull(copyOnWriteArrayList);
                Intrinsics.checkNotNullExpressionValue(copyOnWriteArrayList, "actionMap[actionCode]!!");
                Iterator<T> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).a(externalCommIntent.b());
                }
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53553);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f69828b = new a();
            map = new ConcurrentHashMap<>();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public final void a(@NotNull j vmMessenger, @NotNull String actionCode, @NotNull b action) {
        C0657a putIfAbsent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, vmMessenger, actionCode, action);
            return;
        }
        Intrinsics.checkNotNullParameter(vmMessenger, "vmMessenger");
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        ConcurrentHashMap<j, C0657a> concurrentHashMap = map;
        C0657a c0657a = concurrentHashMap.get(vmMessenger);
        if (c0657a == null && (putIfAbsent = concurrentHashMap.putIfAbsent(vmMessenger, (c0657a = new C0657a(vmMessenger)))) != null) {
            c0657a = putIfAbsent;
        }
        c0657a.b(actionCode, action);
    }

    public final void b(@NotNull j vmMessenger, @NotNull String actionCode, @NotNull b action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, vmMessenger, actionCode, action);
            return;
        }
        Intrinsics.checkNotNullParameter(vmMessenger, "vmMessenger");
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(action, "action");
        C0657a c0657a = map.get(vmMessenger);
        if (c0657a != null) {
            c0657a.c(actionCode, action);
        }
    }

    public final void c(@NotNull j vmMessenger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) vmMessenger);
            return;
        }
        Intrinsics.checkNotNullParameter(vmMessenger, "vmMessenger");
        C0657a remove = map.remove(vmMessenger);
        if (remove != null) {
            remove.a();
        }
    }
}
