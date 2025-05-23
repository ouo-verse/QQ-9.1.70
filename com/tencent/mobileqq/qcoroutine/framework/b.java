package com.tencent.mobileqq.qcoroutine.framework;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0004J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u0004\"\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/b;", "", "", "i", "()Ljava/lang/Long;", "c", "b", "Lkotlinx/coroutines/Job;", "a", "_job", "", "j", "Ljava/lang/Long;", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Long;)V", "runStartTime", h.F, DomainData.DOMAIN_NAME, "startTime", "d", "k", "endTime", "Lkotlinx/coroutines/Job;", "f", "()Lkotlinx/coroutines/Job;", "l", "(Lkotlinx/coroutines/Job;)V", "job", "e", "J", "()J", "excuteTime", "<init>", "(J)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long runStartTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long startTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long endTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job job;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long excuteTime;

    public b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
        } else {
            this.excuteTime = j3;
        }
    }

    @Nullable
    public Job a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Job) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.job;
    }

    @Nullable
    public final Long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Long) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        Long l3 = this.endTime;
        if (l3 != null && this.startTime != null) {
            Intrinsics.checkNotNull(l3);
            long longValue = l3.longValue();
            Long l16 = this.startTime;
            Intrinsics.checkNotNull(l16);
            return Long.valueOf(longValue - l16.longValue());
        }
        return null;
    }

    @Nullable
    public final Long c() {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Long) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.runStartTime != null && (l3 = this.startTime) != null) {
            Intrinsics.checkNotNull(l3);
            long longValue = l3.longValue();
            Long l16 = this.runStartTime;
            Intrinsics.checkNotNull(l16);
            return Long.valueOf(longValue - l16.longValue());
        }
        return null;
    }

    @Nullable
    public final Long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Long) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.endTime;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.excuteTime;
    }

    @Nullable
    public final Job f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Job) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.job;
    }

    @Nullable
    public final Long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Long) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.runStartTime;
    }

    @Nullable
    public final Long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Long) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.startTime;
    }

    @Nullable
    public final Long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Long) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        Long l3 = this.runStartTime;
        if (l3 != null) {
            return Long.valueOf(l3.longValue() - this.excuteTime);
        }
        return null;
    }

    public void j(@NotNull Job _job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) _job);
        } else {
            Intrinsics.checkNotNullParameter(_job, "_job");
            this.job = _job;
        }
    }

    public final void k(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) l3);
        } else {
            this.endTime = l3;
        }
    }

    public final void l(@Nullable Job job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) job);
        } else {
            this.job = job;
        }
    }

    public final void m(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) l3);
        } else {
            this.runStartTime = l3;
        }
    }

    public final void n(@Nullable Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) l3);
        } else {
            this.startTime = l3;
        }
    }
}
