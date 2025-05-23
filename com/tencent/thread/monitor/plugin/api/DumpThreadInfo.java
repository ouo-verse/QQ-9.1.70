package com.tencent.thread.monitor.plugin.api;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/thread/monitor/plugin/api/DumpThreadInfo;", "", MosaicConstants$JsProperty.PROP_THREAD, "Ljava/lang/Thread;", "stack", "", "Ljava/lang/StackTraceElement;", "(Ljava/lang/Thread;[Ljava/lang/StackTraceElement;)V", "getStack", "()[Ljava/lang/StackTraceElement;", "[Ljava/lang/StackTraceElement;", "getThread", "()Ljava/lang/Thread;", "toString", "", "plugincode_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class DumpThreadInfo {
    static IPatchRedirector $redirector_;

    @NotNull
    private final StackTraceElement[] stack;

    @NotNull
    private final Thread thread;

    public DumpThreadInfo(@NotNull Thread thread, @NotNull StackTraceElement[] stack) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(stack, "stack");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) thread, (Object) stack);
        } else {
            this.thread = thread;
            this.stack = stack;
        }
    }

    @NotNull
    public final StackTraceElement[] getStack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (StackTraceElement[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.stack;
    }

    @NotNull
    public final Thread getThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Thread) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.thread;
    }

    @NotNull
    public String toString() {
        boolean z16;
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        String str = this.thread.getId() + ", " + this.thread.getName() + ", " + this.thread.getState();
        if (this.stack.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (true ^ z16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(", \nrunningStack:\n");
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(this.stack, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            sb5.append(joinToString$default);
            return sb5.toString();
        }
        return str;
    }
}
