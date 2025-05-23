package com.tencent.mobileqq.splashad;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/splashad/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getSplashType", "()I", "splashType", "", "b", "J", "()J", "orderStartTime", "c", "orderEndTime", "<init>", "(IJJ)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int splashType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long orderStartTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long orderEndTime;

    public g(int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.splashType = i3;
        this.orderStartTime = j3;
        this.orderEndTime = j16;
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.orderEndTime;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.orderStartTime;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (this.splashType == gVar.splashType && this.orderStartTime == gVar.orderStartTime && this.orderEndTime == gVar.orderEndTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (((this.splashType * 31) + androidx.fragment.app.a.a(this.orderStartTime)) * 31) + androidx.fragment.app.a.a(this.orderEndTime);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "SplashAdData(splashType=" + this.splashType + ", orderStartTime=" + this.orderStartTime + ", orderEndTime=" + this.orderEndTime + ")";
    }
}
