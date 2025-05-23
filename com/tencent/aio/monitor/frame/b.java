package com.tencent.aio.monitor.frame;

import android.view.Choreographer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.monitor.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aio/monitor/frame/b;", "Landroid/view/Choreographer$FrameCallback;", "", "a", "b", "", "frameTimeNanos", "doFrame", "Lcom/tencent/aio/monitor/c;", "d", "Lcom/tencent/aio/monitor/c;", "mMonitorArgs", "e", "Landroid/view/Choreographer$FrameCallback;", "mFrameCallback", "<init>", "(Lcom/tencent/aio/monitor/c;Landroid/view/Choreographer$FrameCallback;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b implements Choreographer.FrameCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c mMonitorArgs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Choreographer.FrameCallback mFrameCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0007R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/aio/monitor/frame/b$a;", "", "", "dropCount", "b", "Lcom/tencent/aio/monitor/c;", "monitorArgs", "", "c", "", "frameTimeNanos", "a", "d", "Lcom/tencent/aio/monitor/frame/a;", "Lcom/tencent/aio/monitor/frame/a;", "mDropFrameData", "J", "mLastFrameTime", "", UserInfo.SEX_FEMALE, "sVSyncIntervalNs", "sVsyncIntervalMs", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private static com.tencent.aio.monitor.frame.a mDropFrameData;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static long mLastFrameTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static float sVSyncIntervalNs;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static float sVsyncIntervalMs;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public static final a f69413e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45429);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                f69413e = new a();
                mDropFrameData = new com.tencent.aio.monitor.frame.a(6);
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        private final int b(int dropCount) {
            if (dropCount <= 0) {
                return 0;
            }
            int i3 = 1;
            if (dropCount != 1) {
                i3 = 4;
                if (dropCount <= 4) {
                    return 2;
                }
                if (dropCount <= 8) {
                    return 3;
                }
                if (dropCount > 15) {
                    return 5;
                }
            }
            return i3;
        }

        public final void a(long frameTimeNanos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, frameTimeNanos);
                return;
            }
            if (mDropFrameData.c() == 0) {
                mDropFrameData.g(frameTimeNanos);
            } else {
                int i3 = (int) ((((float) (frameTimeNanos - mLastFrameTime)) / sVSyncIntervalNs) - 1);
                int b16 = b(i3);
                com.tencent.aio.monitor.frame.a aVar = mDropFrameData;
                aVar.h(aVar.d() + 1);
                long[] a16 = mDropFrameData.a();
                a16[b16] = a16[b16] + 1;
                mDropFrameData.f(frameTimeNanos);
                if (i3 >= 2) {
                    com.tencent.aio.base.log.a.f69187b.d("FPSCollector", "catch drop frame: dropCount=" + i3);
                }
            }
            mLastFrameTime = frameTimeNanos;
        }

        public final void c(@NotNull c monitorArgs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) monitorArgs);
                return;
            }
            Intrinsics.checkNotNullParameter(monitorArgs, "monitorArgs");
            mDropFrameData.e();
            float b16 = monitorArgs.b();
            sVsyncIntervalMs = b16;
            sVSyncIntervalNs = 1000000 * b16;
        }

        public final void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            long millis = TimeUnit.NANOSECONDS.toMillis(mDropFrameData.b() - mDropFrameData.c());
            if (mDropFrameData.d() > 0 && millis > 100) {
                mDropFrameData.i(millis);
            }
            com.tencent.aio.base.log.a.f69187b.d("FPSCollector", "stop " + mDropFrameData);
        }
    }

    public b(@NotNull c mMonitorArgs, @NotNull Choreographer.FrameCallback mFrameCallback) {
        Intrinsics.checkNotNullParameter(mMonitorArgs, "mMonitorArgs");
        Intrinsics.checkNotNullParameter(mFrameCallback, "mFrameCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mMonitorArgs, (Object) mFrameCallback);
        } else {
            this.mMonitorArgs = mMonitorArgs;
            this.mFrameCallback = mFrameCallback;
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            a.f69413e.c(this.mMonitorArgs);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            a.f69413e.d();
            Choreographer.getInstance().removeFrameCallback(this);
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, frameTimeNanos);
            return;
        }
        a.f69413e.a(frameTimeNanos);
        this.mFrameCallback.doFrame(frameTimeNanos);
        Choreographer.getInstance().postFrameCallback(this);
    }
}
