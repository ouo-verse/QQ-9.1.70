package com.tencent.mobileqq.perf.replay.collect;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.perf.replay.collect.data.b;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J&\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\u0017\u001a\u00020\u0006R\u0017\u0010\u001c\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010 \u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/perf/replay/collect/a;", "", "", "sampleInterval", "", "restLoopCount", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "i", "Lcom/tencent/mobileqq/perf/replay/collect/data/b;", "k", "Lcom/tencent/mobileqq/perf/replay/collect/data/a;", "perfData", "d", "", "sum", "max", Element.ELEMENT_NAME_MIN, "count", "c", "", "f", "g", "e", "b", "Lcom/tencent/mobileqq/perf/replay/collect/data/a;", "getEMPTY_PERF_DATA", "()Lcom/tencent/mobileqq/perf/replay/collect/data/a;", "EMPTY_PERF_DATA", "Lcom/tencent/mobileqq/perf/replay/collect/data/b;", "getEMPTY_PERFORMANCE", "()Lcom/tencent/mobileqq/perf/replay/collect/data/b;", "EMPTY_PERFORMANCE", "Landroid/os/Handler;", "Landroid/os/Handler;", "mNormalHandler", "Lcom/tencent/mobileqq/perf/replay/collect/util/a;", "Lcom/tencent/mobileqq/perf/replay/collect/util/a;", "fpsListener", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257975a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.perf.replay.collect.data.a EMPTY_PERF_DATA;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b EMPTY_PERFORMANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Handler mNormalHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.perf.replay.collect.util.a fpsListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/perf/replay/collect/a$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.replay.collect.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class HandlerC8211a extends Handler {
        static IPatchRedirector $redirector_;

        HandlerC8211a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            if (msg2.what == 2) {
                Object obj = msg2.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.perf.replay.collect.data.PerfData");
                com.tencent.mobileqq.perf.replay.collect.data.a aVar = (com.tencent.mobileqq.perf.replay.collect.data.a) obj;
                QLog.i("PerformanceDataManager", 1, "handleMessage: " + msg2.what + " perfData: " + msg2.obj + " rest count: " + aVar.e());
                long currentTimeMillis = System.currentTimeMillis();
                a aVar2 = a.f257975a;
                aVar2.f(aVar);
                aVar2.g(aVar);
                QLog.i("PerformanceDataManager", 1, "collect perfData cost: " + (System.currentTimeMillis() - currentTimeMillis));
                aVar.q(aVar.e() + (-1));
                if (aVar.e() == 0) {
                    return;
                }
                sendMessageDelayed(Message.obtain(msg2), aVar.f());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34949);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f257975a = new a();
        EMPTY_PERF_DATA = new com.tencent.mobileqq.perf.replay.collect.data.a(0L, 0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, null, null, null, InitSkin.DRAWABLE_COUNT, null);
        EMPTY_PERFORMANCE = new b(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, null, null, null, 255, null);
        mNormalHandler = new HandlerC8211a(QQPerfHandlerThreadManager.INSTANCE.d().getLooper());
        fpsListener = new com.tencent.mobileqq.perf.replay.collect.util.a();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final double c(double sum, double max, double min, int count) {
        if (count > 2) {
            sum = (sum - max) - min;
            count -= 2;
        } else if (count == 0) {
            return 0.0d;
        }
        return sum / count;
    }

    private final b d(com.tencent.mobileqq.perf.replay.collect.data.a perfData) {
        double l3;
        b bVar = new b(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, null, null, null, 255, null);
        if (perfData != null) {
            a aVar = f257975a;
            double c16 = aVar.c(perfData.k(), perfData.a(), perfData.c(), perfData.h().size());
            double c17 = aVar.c(perfData.g(), perfData.b(), perfData.d(), perfData.j().size());
            if (perfData.i().size() == 0) {
                l3 = 0.0d;
            } else {
                l3 = perfData.l() / perfData.i().size();
            }
            return new b(perfData.a(), c16, l3, c17, perfData.b(), perfData.h(), perfData.i(), perfData.j());
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(com.tencent.mobileqq.perf.replay.collect.data.a perfData) {
        float g16 = CpuUtil.f258160a.g(Process.myPid());
        QLog.i("PerformanceDataManager", 1, " cpu Callback : " + g16);
        double d16 = (double) g16;
        perfData.s(perfData.k() + d16);
        perfData.h().put(Long.valueOf(System.currentTimeMillis()), Double.valueOf(d16));
        if (perfData.a() <= d16) {
            perfData.m(d16);
        }
        if (perfData.c() >= d16) {
            perfData.o(d16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(com.tencent.mobileqq.perf.replay.collect.data.a perfData) {
        double activeCount = Thread.activeCount();
        QLog.i("PerformanceDataManager", 1, " Thread.activeCount : " + activeCount);
        perfData.r(perfData.g() + activeCount);
        perfData.j().put(Long.valueOf(System.currentTimeMillis()), Double.valueOf(activeCount));
        if (perfData.b() <= activeCount) {
            perfData.n(activeCount);
        }
        if (perfData.d() >= activeCount) {
            perfData.p(activeCount);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean h(long j3, int i3) {
        return j(j3, i3, false, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final boolean i(long sampleInterval, int restLoopCount, boolean force) {
        if (f257975a.e()) {
            if (!force) {
                QLog.e("PerformanceDataManager", 1, "startMonitor failed. is Recording.");
                return false;
            }
            QLog.i("PerformanceDataManager", 1, "force stopMonitor. restartMonitor.");
            k();
        }
        com.tencent.mobileqq.perf.replay.collect.data.a aVar = new com.tencent.mobileqq.perf.replay.collect.data.a(sampleInterval, restLoopCount, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, null, null, null, 8188, null);
        Message message = new Message();
        message.what = 2;
        message.obj = aVar;
        mNormalHandler.sendMessageDelayed(message, aVar.f());
        com.tencent.mobileqq.perf.replay.collect.util.a aVar2 = fpsListener;
        aVar2.b(aVar);
        FPSCalculator.p().l(aVar2);
        return true;
    }

    public static /* synthetic */ boolean j(long j3, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            j3 = 500;
        }
        if ((i16 & 2) != 0) {
            i3 = 10;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return i(j3, i3, z16);
    }

    @JvmStatic
    @NotNull
    public static final b k() {
        a aVar = f257975a;
        if (!aVar.e()) {
            QLog.e("PerformanceDataManager", 1, "stopMonitor failed. not recording.");
            return EMPTY_PERFORMANCE;
        }
        mNormalHandler.removeMessages(2);
        FPSCalculator p16 = FPSCalculator.p();
        com.tencent.mobileqq.perf.replay.collect.util.a aVar2 = fpsListener;
        p16.r(aVar2);
        com.tencent.mobileqq.perf.replay.collect.data.a a16 = aVar2.a();
        aVar2.b(null);
        return aVar.d(a16);
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        boolean hasMessages = mNormalHandler.hasMessages(2);
        QLog.i("PerformanceDataManager", 1, "isRecording: " + hasMessages);
        return hasMessages;
    }
}
