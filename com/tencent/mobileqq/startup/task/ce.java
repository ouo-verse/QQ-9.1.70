package com.tencent.mobileqq.startup.task;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.startup.step.ProcessInfoUtil;
import com.tencent.mobileqq.startup.task.ce;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.startup.task.NtTask;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0002\n\u000bB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/startup/task/ce;", "Lcom/tencent/qqnt/startup/task/NtTask;", "", "f", "Landroid/content/Context;", "context", TencentLocation.RUN_MODE, "<init>", "()V", "d", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ce extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f289829e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private static LinkedList<b> f289830f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\u0006\u0010\t\u001a\u00020\u0005R$\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/startup/task/ce$a;", "", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/startup/task/ce$b;", "listeners", "", "c", "listener", "b", "e", "", "<set-?>", "serviceStarted", "Z", "d", "()Z", "Ljava/util/LinkedList;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.task.ce$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        private final void c(LinkedList<b> listeners) {
            Iterator<T> it = listeners.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(LinkedList it) {
            Intrinsics.checkNotNullParameter(it, "$it");
            ce.INSTANCE.c(it);
        }

        @JvmStatic
        public final synchronized void b(@NotNull b listener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
                return;
            }
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (d()) {
                listener.a();
                return;
            }
            if (ce.f289830f == null) {
                ce.f289830f = new LinkedList();
            }
            LinkedList linkedList = ce.f289830f;
            Intrinsics.checkNotNull(linkedList);
            linkedList.add(listener);
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ce.f289829e;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        public final synchronized void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                ce.f289829e = true;
                final LinkedList linkedList = ce.f289830f;
                if (linkedList != null) {
                    ce.f289830f = null;
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.startup.task.cd
                        @Override // java.lang.Runnable
                        public final void run() {
                            ce.Companion.f(linkedList);
                        }
                    });
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/startup/task/ce$b;", "", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
        void a();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61661);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ce() {
        super(null, 1, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final synchronized void e(@NotNull b bVar) {
        synchronized (ce.class) {
            INSTANCE.b(bVar);
        }
    }

    private final void f() {
        if (MobileQQ.sProcessId != 4) {
            BaseApplicationImpl.sApplication.startService();
        }
        int i3 = MobileQQ.sProcessId;
        if (i3 == 7) {
            ProcessInfoUtil.g("com.tencent.mobileqq:tool");
        } else if (i3 == 11) {
            ProcessInfoUtil.g("com.tencent.mobileqq:miniapp");
        }
        if (MobileQQ.sProcessId == 1) {
            AppRuntime peekAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                peekAppRuntime.onGuardEvent(6, 0L, 0L);
                if (((QQAppInterface) peekAppRuntime).isAccLoginSuccess()) {
                    peekAppRuntime.start(false);
                } else {
                    com.tencent.mobileqq.startup.a.f289664e = 0L;
                }
            }
        }
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (f289829e) {
            QLog.d("NtStartupMonitor", 1, "StartServiceTask has been executed");
        } else {
            f();
            INSTANCE.e();
        }
    }
}
