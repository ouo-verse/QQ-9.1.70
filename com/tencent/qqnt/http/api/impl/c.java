package com.tencent.qqnt.http.api.impl;

import android.os.SystemClock;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b*\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0004R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R$\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R$\u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R$\u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R$\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b(\u0010\u0013\"\u0004\b!\u0010\u0015R$\u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b*\u0010\u0013\"\u0004\b\u001a\u0010\u0015\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/http/api/impl/c;", "", "", "stageName", "", "stageStartTime", "standardCallStartTime", "b", "(Ljava/lang/String;Ljava/lang/Long;J)Ljava/lang/String;", "l", "a", "J", "getCallStartTime", "()J", "e", "(J)V", "callStartTime", "Ljava/lang/Long;", "getAsyncCallStartTime", "()Ljava/lang/Long;", "c", "(Ljava/lang/Long;)V", "asyncCallStartTime", "getDnsStartTime", "i", "dnsStartTime", "d", "getDnsEndTime", tl.h.F, "dnsEndTime", "getConnectStartTime", "g", "connectStartTime", "f", "getSecureConnectStartTime", "k", "secureConnectStartTime", "getSecureConnectEndTime", "j", "secureConnectEndTime", "getConnectEndTime", "connectEndTime", "getCallEndTime", "callEndTime", "<init>", "()V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long callStartTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long asyncCallStartTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long dnsStartTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long dnsEndTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long connectStartTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long secureConnectStartTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long secureConnectEndTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long connectEndTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long callEndTime;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(String stageName, Long stageStartTime, long standardCallStartTime) {
        if (stageStartTime != null) {
            return "," + stageName + ContainerUtils.KEY_VALUE_DELIMITER + (stageStartTime.longValue() - standardCallStartTime);
        }
        return "";
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, (Object) this)).longValue();
        }
        if (this.callStartTime > 0) {
            return SystemClock.uptimeMillis() - this.callStartTime;
        }
        return -1L;
    }

    public final void c(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) l3);
        } else {
            this.asyncCallStartTime = l3;
        }
    }

    public final void d(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) l3);
        } else {
            this.callEndTime = l3;
        }
    }

    public final void e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.callStartTime = j3;
        }
    }

    public final void f(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) l3);
        } else {
            this.connectEndTime = l3;
        }
    }

    public final void g(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) l3);
        } else {
            this.connectStartTime = l3;
        }
    }

    public final void h(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) l3);
        } else {
            this.dnsEndTime = l3;
        }
    }

    public final void i(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) l3);
        } else {
            this.dnsStartTime = l3;
        }
    }

    public final void j(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) l3);
        } else {
            this.secureConnectEndTime = l3;
        }
    }

    public final void k(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) l3);
        } else {
            this.secureConnectStartTime = l3;
        }
    }

    @NotNull
    public final String l() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        Long l3 = this.asyncCallStartTime;
        if (l3 != null) {
            Intrinsics.checkNotNull(l3);
            j3 = l3.longValue();
        } else {
            j3 = this.callStartTime;
        }
        return "CallInfo(callStartCost=" + (j3 - this.callStartTime) + b("dnsStartCost", this.dnsStartTime, j3) + b("dnsEndCost", this.dnsEndTime, j3) + b("connectStartCost", this.connectStartTime, j3) + b("secureConnectStartCost", this.secureConnectStartTime, j3) + b("secureConnectEndCost", this.secureConnectEndTime, j3) + b("connectEndCost", this.connectEndTime, j3) + b("callEndCost", this.callEndTime, j3) + ")";
    }
}
