package com.tencent.qne.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0017\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qne/util/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "success", "", "J", "getFetchSoTimeCost", "()J", "fetchSoTimeCost", "c", "fetchFromNet", "d", "getLoadSoTimeCost", "loadSoTimeCost", "<init>", "(ZJZJ)V", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final /* data */ class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean success;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long fetchSoTimeCost;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean fetchFromNet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long loadSoTimeCost;

    public d() {
        this(false, 0L, false, 0L, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this);
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.fetchFromNet;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.success;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (this.success == dVar.success && this.fetchSoTimeCost == dVar.fetchSoTimeCost && this.fetchFromNet == dVar.fetchFromNet && this.loadSoTimeCost == dVar.loadSoTimeCost) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        boolean z16 = this.success;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int a16 = ((r06 * 31) + androidx.fragment.app.a.a(this.fetchSoTimeCost)) * 31;
        boolean z17 = this.fetchFromNet;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((a16 + i3) * 31) + androidx.fragment.app.a.a(this.loadSoTimeCost);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "SoLoadStatus(success=" + this.success + ", fetchSoTimeCost=" + this.fetchSoTimeCost + ", fetchFromNet=" + this.fetchFromNet + ", loadSoTimeCost=" + this.loadSoTimeCost + ')';
    }

    public d(boolean z16, long j3, boolean z17, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17), Long.valueOf(j16));
            return;
        }
        this.success = z16;
        this.fetchSoTimeCost = j3;
        this.fetchFromNet = z17;
        this.loadSoTimeCost = j16;
    }

    public /* synthetic */ d(boolean z16, long j3, boolean z17, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? false : z17, (i3 & 8) != 0 ? 0L : j16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17), Long.valueOf(j16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
