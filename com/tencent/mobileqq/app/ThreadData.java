package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/app/ThreadData;", "", "name", "", "status", "Ljava/lang/Thread$State;", "(Ljava/lang/String;Ljava/lang/Thread$State;)V", "getName", "()Ljava/lang/String;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Ljava/lang/Thread$State;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mqq_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final /* data */ class ThreadData {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String name;

    @NotNull
    private final Thread.State status;

    public ThreadData(@NotNull String name, @NotNull Thread.State status) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(status, "status");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) name, (Object) status);
        } else {
            this.name = name;
            this.status = status;
        }
    }

    public static /* synthetic */ ThreadData copy$default(ThreadData threadData, String str, Thread.State state, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = threadData.name;
        }
        if ((i3 & 2) != 0) {
            state = threadData.status;
        }
        return threadData.copy(str, state);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.name;
    }

    @NotNull
    public final Thread.State component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Thread.State) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.status;
    }

    @NotNull
    public final ThreadData copy(@NotNull String name, @NotNull Thread.State status) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ThreadData) iPatchRedirector.redirect((short) 6, (Object) this, (Object) name, (Object) status);
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(status, "status");
        return new ThreadData(name, status);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadData)) {
            return false;
        }
        ThreadData threadData = (ThreadData) other;
        if (Intrinsics.areEqual(this.name, threadData.name) && this.status == threadData.status) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.name;
    }

    @NotNull
    public final Thread.State getStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Thread.State) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.status;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return (this.name.hashCode() * 31) + this.status.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "ThreadData(name=" + this.name + ", status=" + this.status + ')';
    }
}
