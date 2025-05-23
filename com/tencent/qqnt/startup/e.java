package com.tencent.qqnt.startup;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/startup/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/startup/parse/a;", "a", "Lcom/tencent/qqnt/startup/parse/a;", "()Lcom/tencent/qqnt/startup/parse/a;", "configStage", "Lcom/tencent/qqnt/startup/task/d;", "b", "Lcom/tencent/qqnt/startup/task/d;", "()Lcom/tencent/qqnt/startup/task/d;", "taskFactory", "<init>", "(Lcom/tencent/qqnt/startup/parse/a;Lcom/tencent/qqnt/startup/task/d;)V", "nt_startup_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.startup.parse.a configStage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.startup.task.d taskFactory;

    public e(@NotNull com.tencent.qqnt.startup.parse.a configStage, @NotNull com.tencent.qqnt.startup.task.d taskFactory) {
        Intrinsics.checkNotNullParameter(configStage, "configStage");
        Intrinsics.checkNotNullParameter(taskFactory, "taskFactory");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) configStage, (Object) taskFactory);
        } else {
            this.configStage = configStage;
            this.taskFactory = taskFactory;
        }
    }

    @NotNull
    public final com.tencent.qqnt.startup.parse.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.startup.parse.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.configStage;
    }

    @NotNull
    public final com.tencent.qqnt.startup.task.d b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.startup.task.d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.taskFactory;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        if (Intrinsics.areEqual(this.configStage, eVar.configStage) && Intrinsics.areEqual(this.taskFactory, eVar.taskFactory)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return (this.configStage.hashCode() * 31) + this.taskFactory.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "NtTaskConfig(configStage=" + this.configStage + ", taskFactory=" + this.taskFactory + ")";
    }
}
