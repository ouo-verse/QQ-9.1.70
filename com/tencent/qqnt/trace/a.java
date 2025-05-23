package com.tencent.qqnt.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/trace/a;", "", "Lcom/tencent/qqnt/trace/a$a;", "listener", "", "a", "", "nodeName", "e", "key", "value", "g", "", "nodeTime", "f", "node", "b", "msg", "c", "d", "Ljava/lang/String;", "sessionId", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "<init>", "()V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f362326a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String sessionId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<InterfaceC9703a> listeners;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/trace/a$a;", "", "", "nodeName", "", "nodeTime", "", "b", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.trace.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC9703a {
        void b(@NotNull String nodeName, long nodeTime);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42583);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f362326a = new a();
        sessionId = "";
        listeners = new CopyOnWriteArrayList<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull InterfaceC9703a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<InterfaceC9703a> copyOnWriteArrayList = listeners;
        if (!copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.add(listener);
        }
    }

    public final long b(@NotNull String node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, (Object) node)).longValue();
        }
        Intrinsics.checkNotNullParameter(node, "node");
        return r.f362387a.findStream("AIO_PAGE").nodeTime(node);
    }

    public final void c(@NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.e("NTTraceManager", 1, "id=" + sessionId + " t=" + (System.currentTimeMillis() % 1000000) + " " + msg2 + "\n");
    }

    public final void d(@NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            c(msg2);
        }
    }

    public final void e(@NotNull String nodeName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) nodeName);
        } else {
            Intrinsics.checkNotNullParameter(nodeName, "nodeName");
            f(nodeName, System.currentTimeMillis());
        }
    }

    public final void f(@NotNull String nodeName, long nodeTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, nodeName, Long.valueOf(nodeTime));
            return;
        }
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        if (Intrinsics.areEqual("ITEM_CLICK", nodeName)) {
            r rVar = r.f362387a;
            rVar.findStream("AIO_PAGE").reset();
            rVar.findStream("AIO_PAGE").tagNode(nodeName, nodeTime);
            sessionId = String.valueOf(System.currentTimeMillis() % 100);
            c(nodeName + ", stream start---");
            return;
        }
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((InterfaceC9703a) it.next()).b(nodeName, nodeTime);
        }
        r rVar2 = r.f362387a;
        long currentTimeMillis = System.currentTimeMillis() - rVar2.findStream("AIO_PAGE").nodeTime("ITEM_CLICK");
        rVar2.findStream("AIO_PAGE").tagNode(nodeName, nodeTime);
        c(nodeName + ", " + currentTimeMillis);
        if (Intrinsics.areEqual("SHOW_LIST", nodeName)) {
            c(nodeName + ", stream end---");
        }
    }

    public final void g(@NotNull String nodeName, @NotNull String key, @NotNull Object value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, nodeName, key, value);
            return;
        }
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        f(nodeName, System.currentTimeMillis());
        r.f362387a.findStream("AIO_PAGE").addParam(key, value);
    }
}
