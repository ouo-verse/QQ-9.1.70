package com.tencent.thread.monitor.plugin.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0012R(\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00010\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/thread/monitor/plugin/manager/TaskInfo;", "", "task", "isSchedule", "", "(Ljava/lang/Object;Z)V", "callStack", "", "getCallStack", "()Ljava/lang/String;", "setCallStack", "(Ljava/lang/String;)V", "callThreadId", "", "getCallThreadId", "()J", "setCallThreadId", "(J)V", "()Z", "weakTask", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakTask", "()Ljava/lang/ref/WeakReference;", "setWeakTask", "(Ljava/lang/ref/WeakReference;)V", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class TaskInfo {
    static IPatchRedirector $redirector_;

    @NotNull
    private String callStack;
    private long callThreadId;
    private final boolean isSchedule;

    @NotNull
    private WeakReference<Object> weakTask;

    public TaskInfo(@NotNull Object task, boolean z16) {
        Intrinsics.checkNotNullParameter(task, "task");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, task, Boolean.valueOf(z16));
            return;
        }
        this.isSchedule = z16;
        this.weakTask = new WeakReference<>(task);
        this.callStack = ProxyManager.getStackString$default(false, 1, null);
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        this.callThreadId = currentThread.getId();
    }

    @NotNull
    public final String getCallStack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.callStack;
    }

    public final long getCallThreadId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.callThreadId;
    }

    @NotNull
    public final WeakReference<Object> getWeakTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (WeakReference) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.weakTask;
    }

    public final boolean isSchedule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isSchedule;
    }

    public final void setCallStack(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.callStack = str;
        }
    }

    public final void setCallThreadId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.callThreadId = j3;
        }
    }

    public final void setWeakTask(@NotNull WeakReference<Object> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference);
        } else {
            Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
            this.weakTask = weakReference;
        }
    }

    public /* synthetic */ TaskInfo(Object obj, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i3 & 2) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, this, obj, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
