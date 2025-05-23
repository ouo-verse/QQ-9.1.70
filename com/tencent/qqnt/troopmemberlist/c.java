package com.tencent.qqnt.troopmemberlist;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/troopmemberlist/datasync/c;", "a", "Lcom/tencent/qqnt/troopmemberlist/datasync/c;", "b", "()Lcom/tencent/qqnt/troopmemberlist/datasync/c;", "syncData", "Lcom/tencent/qqnt/report/j;", "Lcom/tencent/qqnt/report/j;", "()Lcom/tencent/qqnt/report/j;", "report", "c", "Ljava/lang/String;", "getFrom", "()Ljava/lang/String;", "from", "<init>", "(Lcom/tencent/qqnt/troopmemberlist/datasync/c;Lcom/tencent/qqnt/report/j;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.troopmemberlist.datasync.c syncData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.report.j report;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String from;

    public c(@NotNull com.tencent.qqnt.troopmemberlist.datasync.c syncData, @NotNull com.tencent.qqnt.report.j report, @NotNull String from) {
        Intrinsics.checkNotNullParameter(syncData, "syncData");
        Intrinsics.checkNotNullParameter(report, "report");
        Intrinsics.checkNotNullParameter(from, "from");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, syncData, report, from);
            return;
        }
        this.syncData = syncData;
        this.report = report;
        this.from = from;
    }

    @NotNull
    public final com.tencent.qqnt.report.j a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.report.j) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.report;
    }

    @NotNull
    public final com.tencent.qqnt.troopmemberlist.datasync.c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.troopmemberlist.datasync.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.syncData;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.syncData, cVar.syncData) && Intrinsics.areEqual(this.report, cVar.report) && Intrinsics.areEqual(this.from, cVar.from)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (((this.syncData.hashCode() * 31) + this.report.hashCode()) * 31) + this.from.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.from;
    }
}
