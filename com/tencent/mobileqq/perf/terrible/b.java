package com.tencent.mobileqq.perf.terrible;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.perf.config.QQPerfConfigLoader;
import com.tencent.mobileqq.perf.terrible.c;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.LogWriterManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\b*\u00044DHL\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002R\u0012B\t\b\u0002\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010+\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00103\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010\u0016R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010\u0016R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000e0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010N\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/perf/terrible/b;", "", "", "B", "Lcom/tencent/mobileqq/perf/terrible/a;", "u", "", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "Landroid/os/HandlerThread;", "handlerThread", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/perf/terrible/b$b;", "listener", "t", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "c", "I", "oneSecondGcCount", "d", HippyTKDListViewAdapter.X, "()I", "setLastOneSecondGcCount", "(I)V", "lastOneSecondGcCount", "e", "oneSecondLogCount", "f", "y", "setLastOneSecondLogCount", "lastOneSecondLogCount", "Lcom/tencent/mobileqq/perf/terrible/c;", "g", "Lcom/tencent/mobileqq/perf/terrible/c;", "tenSeconds", tl.h.F, "tenMinutes", "i", "oneHour", "j", "Lcom/tencent/mobileqq/perf/terrible/a;", "total", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/perf/terrible/b$a;", "k", "Ljava/lang/ref/WeakReference;", "gcCounter", "com/tencent/mobileqq/perf/terrible/b$f", "l", "Lcom/tencent/mobileqq/perf/terrible/b$f;", "qLogCounter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "safeEnvCount", "", DomainData.DOMAIN_NAME, "J", "terribleControlEffectTime", "o", "lastQLogLevel", "Ljava/util/concurrent/CopyOnWriteArrayList;", "p", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "com/tencent/mobileqq/perf/terrible/b$h", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/perf/terrible/b$h;", "tenSecondsCollectFinished", "com/tencent/mobileqq/perf/terrible/b$g", "r", "Lcom/tencent/mobileqq/perf/terrible/b$g;", "tenMinutesCollectFinished", "com/tencent/mobileqq/perf/terrible/b$e", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/perf/terrible/b$e;", "oneHourCollectFinished", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f258047a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Handler handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int oneSecondGcCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int lastOneSecondGcCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int oneSecondLogCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int lastOneSecondLogCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.perf.terrible.c tenSeconds;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.perf.terrible.c tenMinutes;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.perf.terrible.c oneHour;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.perf.terrible.a total;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<a> gcCounter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final f qLogCounter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static int safeEnvCount;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static long terribleControlEffectTime;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static int lastQLogLevel;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<InterfaceC8212b> listeners;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final h tenSecondsCollectFinished;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final g tenMinutesCollectFinished;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final e oneHourCollectFinished;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/perf/terrible/b$a;", "", "", "finalize", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        protected final void finalize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.oneSecondGcCount++;
                b.gcCounter = new WeakReference(new a());
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/perf/terrible/b$b;", "", "Lcom/tencent/mobileqq/perf/terrible/a;", "oneSecondData", "", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.terrible.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC8212b {
        void a(@NotNull com.tencent.mobileqq.perf.terrible.a oneSecondData);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/perf/terrible/b$c", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends Handler {
        static IPatchRedirector $redirector_;

        c(Looper looper) {
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
            com.tencent.mobileqq.perf.terrible.a u16 = b.f258047a.u();
            Iterator it = b.listeners.iterator();
            while (it.hasNext()) {
                ((InterfaceC8212b) it.next()).a(u16);
            }
            b.tenSeconds.a(u16);
            b.total.a(u16);
            removeMessages(1);
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/perf/terrible/b$d", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "onProcessForeground", "onProcessBackground", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d extends com.tencent.mobileqq.perf.tracker.callback.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                Handler handler = b.handler;
                if (handler == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("handler");
                    handler = null;
                }
                handler.removeMessages(1);
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                Handler handler = b.handler;
                if (handler == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("handler");
                    handler = null;
                }
                handler.sendEmptyMessage(1);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/perf/terrible/b$e", "Lcom/tencent/mobileqq/perf/terrible/c$a;", "Lcom/tencent/mobileqq/perf/terrible/a;", "accumulatedData", "maxValue", "", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements c.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.terrible.c.a
        public void a(@NotNull com.tencent.mobileqq.perf.terrible.a accumulatedData, @NotNull com.tencent.mobileqq.perf.terrible.a maxValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) accumulatedData, (Object) maxValue);
                return;
            }
            Intrinsics.checkNotNullParameter(accumulatedData, "accumulatedData");
            Intrinsics.checkNotNullParameter(maxValue, "maxValue");
            QLog.i("EnvStateHistory", 1, "last 1 hour accumulatedData: " + accumulatedData + ", maxData: " + maxValue);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/perf/terrible/b$f", "Lcom/tencent/qphone/base/util/QLog$ILogCallback;", "", "p0", "p1", "", "onWriteLog", "", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class f implements QLog.ILogCallback {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qphone.base.util.QLog.ILogCallback
        public void onWriteLog(@Nullable String p06, @Nullable String p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.oneSecondLogCount++;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06, (Object) p16);
            }
        }

        @Override // com.tencent.qphone.base.util.QLog.ILogCallback
        public void onWriteLog(@Nullable String p06, @Nullable byte[] p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                b.oneSecondLogCount++;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) p06, (Object) p16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/perf/terrible/b$g", "Lcom/tencent/mobileqq/perf/terrible/c$a;", "Lcom/tencent/mobileqq/perf/terrible/a;", "accumulatedData", "maxValue", "", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class g implements c.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.terrible.c.a
        public void a(@NotNull com.tencent.mobileqq.perf.terrible.a accumulatedData, @NotNull com.tencent.mobileqq.perf.terrible.a maxValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) accumulatedData, (Object) maxValue);
                return;
            }
            Intrinsics.checkNotNullParameter(accumulatedData, "accumulatedData");
            Intrinsics.checkNotNullParameter(maxValue, "maxValue");
            QLog.i("EnvStateHistory", 1, "last 10 minutes accumulatedData: " + accumulatedData + ", maxData: " + maxValue);
            if (b.f258047a.B()) {
                com.tencent.mobileqq.perf.terrible.d dVar = com.tencent.mobileqq.perf.terrible.d.f258073a;
                dVar.a(accumulatedData.f(), "ten_minutes_log_count");
                dVar.a(accumulatedData.d(), "ten_minutes_gc_count");
                dVar.a(accumulatedData.e(), "ten_minutes_java_mem_ceil_count");
                int f16 = maxValue.f();
                dVar.a(f16, "ten_minutes_max_log_count");
                if (f16 > 200000) {
                    dVar.b("terrible log print.", f16);
                }
                int d16 = maxValue.d();
                dVar.a(d16, "ten_minutes_max_gc_count");
                if (d16 > 200) {
                    dVar.b("terrible gc occur.", f16);
                }
                dVar.a(maxValue.e(), "ten_minutes_max_java_mem_ceil_count");
            }
            b.oneHour.a(accumulatedData);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/perf/terrible/b$h", "Lcom/tencent/mobileqq/perf/terrible/c$a;", "Lcom/tencent/mobileqq/perf/terrible/a;", "accumulatedData", "maxValue", "", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class h implements c.a {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.terrible.c.a
        public void a(@NotNull com.tencent.mobileqq.perf.terrible.a accumulatedData, @NotNull com.tencent.mobileqq.perf.terrible.a maxValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) accumulatedData, (Object) maxValue);
                return;
            }
            Intrinsics.checkNotNullParameter(accumulatedData, "accumulatedData");
            Intrinsics.checkNotNullParameter(maxValue, "maxValue");
            b.tenMinutes.a(accumulatedData);
            if (!com.tencent.mobileqq.perf.terrible.f.f258078a.a(accumulatedData, maxValue) || b.safeEnvCount == 3) {
                int i3 = b.safeEnvCount;
                b.safeEnvCount = i3 - 1;
                if (i3 == 0) {
                    QLog.i("EnvStateHistory", 1, "is not TerribleEnv. QLog.useOldQLog()");
                    QLog.useOldQLog();
                    QLog.setManualLogLevel(b.lastQLogLevel);
                    long currentTimeMillis = System.currentTimeMillis() - b.terribleControlEffectTime;
                    if (b.f258047a.B()) {
                        com.tencent.mobileqq.perf.terrible.d.f258073a.a(currentTimeMillis, "terrible_control_time");
                        return;
                    }
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("EnvStateHistory", 1, "safeEnvCheck. rest count " + b.safeEnvCount);
                    return;
                }
                return;
            }
            b.terribleControlEffectTime = System.currentTimeMillis();
            QLog.i("EnvStateHistory", 1, "isTerribleEnv. QLog.useNewQLog()");
            QLog.useNewQLog();
            b.lastQLogLevel = QLog.getUIN_REPORTLOG_LEVEL();
            QLog.setManualLogLevel(1);
            b.safeEnvCount = 3;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44819);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f258047a = new b();
        lastOneSecondGcCount = -1;
        lastOneSecondLogCount = -1;
        tenSeconds = new com.tencent.mobileqq.perf.terrible.c(10);
        tenMinutes = new com.tencent.mobileqq.perf.terrible.c(60);
        oneHour = new com.tencent.mobileqq.perf.terrible.c(6);
        total = new com.tencent.mobileqq.perf.terrible.a(0, 0, 0, 7, null);
        qLogCounter = new f();
        safeEnvCount = -1;
        lastQLogLevel = QLog.getUIN_REPORTLOG_LEVEL();
        listeners = new CopyOnWriteArrayList<>();
        tenSecondsCollectFinished = new h();
        tenMinutesCollectFinished = new g();
        oneHourCollectFinished = new e();
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B() {
        if ((AppSetting.isDebugVersion() || AppSetting.isGrayVersion()) && Math.random() < QQPerfConfigLoader.f257603a.b().b().d()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.perf.terrible.a u() {
        try {
            return new com.tencent.mobileqq.perf.terrible.a(w(), z(), v());
        } catch (OutOfMemoryError unused) {
            return new com.tencent.mobileqq.perf.terrible.a(w(), z(), 1);
        }
    }

    private final int v() {
        MemoryUtil memoryUtil = MemoryUtil.f258173a;
        if (memoryUtil.q() / memoryUtil.h() > 0.95d) {
            return 1;
        }
        return 0;
    }

    private final int w() {
        int i3 = oneSecondGcCount;
        lastOneSecondGcCount = i3;
        oneSecondGcCount = 0;
        return i3;
    }

    private final int z() {
        int i3 = oneSecondLogCount;
        lastOneSecondLogCount = i3;
        oneSecondLogCount = 0;
        return i3;
    }

    public final void A(@NotNull HandlerThread handlerThread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) handlerThread);
            return;
        }
        Intrinsics.checkNotNullParameter(handlerThread, "handlerThread");
        tenSeconds.b(tenSecondsCollectFinished);
        tenMinutes.b(tenMinutesCollectFinished);
        oneHour.b(oneHourCollectFinished);
        gcCounter = new WeakReference<>(new a());
        LogWriterManager.setLogCallback(qLogCounter);
        if (handlerThread.getState() == Thread.State.NEW) {
            handlerThread.start();
        }
        handler = new c(handlerThread.getLooper());
        SceneTracker.f258213d.l(new d());
        if (SceneTracker.j()) {
            Handler handler2 = handler;
            if (handler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handler");
                handler2 = null;
            }
            handler2.sendEmptyMessage(1);
            QLog.i("EnvStateHistory", 1, "EnvStateHistory is inited.");
            return;
        }
        QLog.i("EnvStateHistory", 1, "now in background, EnvStateHistory init delay.");
    }

    public final void t(@NotNull InterfaceC8212b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<InterfaceC8212b> copyOnWriteArrayList = listeners;
        if (!copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.add(listener);
        }
    }

    public final int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return lastOneSecondGcCount;
    }

    public final int y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return lastOneSecondLogCount;
    }
}
