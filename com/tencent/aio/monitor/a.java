package com.tencent.aio.monitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0004J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&R\"\u0010\u000e\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/aio/monitor/a;", "", "", h.F, "i", "a", "e", "f", "", "d", "J", "()J", "g", "(J)V", "mStartSampleTimeInMs", "Lcom/tencent/aio/monitor/sampler/a;", "Lcom/tencent/aio/monitor/sampler/a;", "c", "()Lcom/tencent/aio/monitor/sampler/a;", "setMStackSampler", "(Lcom/tencent/aio/monitor/sampler/a;)V", "mStackSampler", "", "Z", "mIsStarted", "Lcom/tencent/aio/monitor/c;", "Lcom/tencent/aio/monitor/c;", "b", "()Lcom/tencent/aio/monitor/c;", "mMonitorArgs", "<init>", "(Lcom/tencent/aio/monitor/c;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long mStartSampleTimeInMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected com.tencent.aio.monitor.sampler.a mStackSampler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsStarted;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mMonitorArgs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/monitor/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.monitor.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45412);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull c mMonitorArgs) {
        Intrinsics.checkNotNullParameter(mMonitorArgs, "mMonitorArgs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) mMonitorArgs);
        } else {
            this.mMonitorArgs = mMonitorArgs;
        }
    }

    protected final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.aio.base.log.a.f69187b.d("BaseMonitor", "checkStack " + currentTimeMillis);
        com.tencent.aio.monitor.sampler.a aVar = this.mStackSampler;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStackSampler");
        }
        List<String> k3 = aVar.k(this.mStartSampleTimeInMs, currentTimeMillis);
        if (!k3.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" ");
            sb5.append(" \r\n ");
            sb5.append(" \r\n ");
            com.tencent.aio.monitor.sampler.a aVar2 = this.mStackSampler;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStackSampler");
            }
            sb5.append(aVar2.j());
            sb5.append(" dropped time:");
            sb5.append(currentTimeMillis - this.mStartSampleTimeInMs);
            sb5.append(" ms ");
            sb5.append("******************************");
            sb5.append(" \r\n ");
            for (String str : k3) {
                sb5.append(" \r\n ");
                sb5.append(str);
            }
            com.tencent.aio.base.log.a aVar3 = com.tencent.aio.base.log.a.f69187b;
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "strBuilder.toString()");
            aVar3.d("BaseMonitor", sb6);
        }
    }

    @NotNull
    public final c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mMonitorArgs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.aio.monitor.sampler.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.monitor.sampler.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        com.tencent.aio.monitor.sampler.a aVar = this.mStackSampler;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStackSampler");
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Long) iPatchRedirector.redirect((short) 1, (Object) this)).longValue();
        }
        return this.mStartSampleTimeInMs;
    }

    public abstract void e();

    public abstract void f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.mStartSampleTimeInMs = j3;
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.mIsStarted) {
            return;
        }
        this.mIsStarted = true;
        this.mStartSampleTimeInMs = System.currentTimeMillis();
        com.tencent.aio.base.log.a.f69187b.d("BaseMonitor", "start " + this.mStartSampleTimeInMs);
        this.mStackSampler = new com.tencent.aio.monitor.sampler.a(this.mMonitorArgs.e(), this.mMonitorArgs.d(), this.mMonitorArgs.c());
        e();
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!this.mIsStarted) {
            return;
        }
        this.mIsStarted = false;
        com.tencent.aio.base.log.a.f69187b.d("BaseMonitor", "stop " + System.currentTimeMillis());
        a();
        com.tencent.aio.monitor.sampler.a aVar = this.mStackSampler;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStackSampler");
        }
        aVar.e();
        f();
    }
}
