package com.tencent.aio.monitor.sampler;

import android.os.Handler;
import com.tencent.aio.monitor.helper.HandlerThreadFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006*\u0001\n\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H&R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/aio/monitor/sampler/AbstractSampler;", "", "", "d", "e", "c", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "mSampleHandler", "com/tencent/aio/monitor/sampler/AbstractSampler$mSampleRunnable$1", "b", "Lcom/tencent/aio/monitor/sampler/AbstractSampler$mSampleRunnable$1;", "mSampleRunnable", "", "J", "mSampleInterval", "mSampleDelay", "<init>", "(JJ)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class AbstractSampler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Handler mSampleHandler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AbstractSampler$mSampleRunnable$1 mSampleRunnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long mSampleInterval;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long mSampleDelay;

    /* JADX WARN: Type inference failed for: r5v3, types: [com.tencent.aio.monitor.sampler.AbstractSampler$mSampleRunnable$1] */
    public AbstractSampler(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.mSampleInterval = j3;
        this.mSampleDelay = j16;
        this.mSampleHandler = HandlerThreadFactory.f69415b.a();
        this.mSampleRunnable = new Runnable() { // from class: com.tencent.aio.monitor.sampler.AbstractSampler$mSampleRunnable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AbstractSampler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Handler handler;
                long j17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                AbstractSampler.this.c();
                handler = AbstractSampler.this.mSampleHandler;
                j17 = AbstractSampler.this.mSampleInterval;
                handler.postDelayed(this, j17);
            }
        };
    }

    public abstract void c();

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSampleHandler.removeCallbacks(this.mSampleRunnable);
            this.mSampleHandler.postDelayed(this.mSampleRunnable, this.mSampleDelay);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mSampleHandler.removeCallbacks(this.mSampleRunnable);
        }
    }
}
