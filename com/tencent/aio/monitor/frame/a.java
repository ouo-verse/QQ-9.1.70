package com.tencent.aio.monitor.frame;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0016\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u0012\u0010\fR\"\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0007\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\b\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tencent/aio/monitor/frame/a;", "", "", "e", "", "toString", "", "a", "J", "d", "()J", h.F, "(J)V", "mFrameCount", "b", "c", "g", "mFirstFrameTime", "f", "mFinalFrameTime", "", "[J", "()[J", "setMDropTimes", "([J)V", "mDropTimes", "getMScrollDurationMs", "i", "mScrollDurationMs", "", "rangeCount", "<init>", "(I)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long mFrameCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long mFirstFrameTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long mFinalFrameTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private long[] mDropTimes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mScrollDurationMs;

    public a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.mDropTimes = new long[i3];
        }
    }

    @NotNull
    public final long[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (long[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mDropTimes;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.mFinalFrameTime;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.mFirstFrameTime;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Long) iPatchRedirector.redirect((short) 1, (Object) this)).longValue();
        }
        return this.mFrameCount;
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.mFrameCount = 0L;
        this.mFirstFrameTime = 0L;
        int length = this.mDropTimes.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.mDropTimes[i3] = 0;
        }
        this.mFinalFrameTime = 0L;
        this.mScrollDurationMs = 0L;
    }

    public final void f(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.mFinalFrameTime = j3;
        }
    }

    public final void g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.mFirstFrameTime = j3;
        }
    }

    public final void h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.mFrameCount = j3;
        }
    }

    public final void i(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        } else {
            this.mScrollDurationMs = j3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("DropFrameData{frameCount=");
        sb5.append(this.mFrameCount);
        sb5.append(", dropTimes=");
        String arrays = Arrays.toString(this.mDropTimes);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        sb5.append(arrays);
        sb5.append(", scrollDurationMs=");
        sb5.append(this.mScrollDurationMs);
        sb5.append('}');
        return sb5.toString();
    }
}
