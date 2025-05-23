package com.tencent.rmonitor.looper.provider;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rmonitor.base.thread.suspend.ThreadSuspend;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.g;
import com.tencent.rmonitor.looper.MonitorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J \u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0004J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J%\u0010#\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H&\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0011H&R\u0018\u0010)\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/rmonitor/looper/provider/d;", "Lcom/tencent/rmonitor/looper/provider/a;", "Landroid/os/Handler$Callback;", "Lcom/tencent/rmonitor/looper/c;", "monitorInfo", "", "t", ReportConstant.COSTREPORT_PREFIX, "", "what", HippyTKDListViewAdapter.X, "", "delay", "y", "w", "Lc14/a;", "callback", "", "l", DomainData.DOMAIN_NAME, "startTime", "g", "endTime", "duration", "f", "u", "Landroid/os/Message;", "msg", "handleMessage", "Landroid/os/Handler;", "r", "p", "", "Ljava/lang/StackTraceElement;", "stackTrace", "v", "(Lcom/tencent/rmonitor/looper/c;[Ljava/lang/StackTraceElement;)V", "isOverThreshold", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", "Landroid/os/Handler;", "stackThreadHandler", UserInfo.SEX_FEMALE, "Lc14/a;", "monitorCallBack", "G", "J", "lastStackRequestTime", "<init>", "()V", "H", "a", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public abstract class d extends a implements Handler.Callback {

    /* renamed from: E, reason: from kotlin metadata */
    private Handler stackThreadHandler;

    /* renamed from: F, reason: from kotlin metadata */
    private c14.a monitorCallBack;

    /* renamed from: G, reason: from kotlin metadata */
    private long lastStackRequestTime;

    private final void s(MonitorInfo monitorInfo) {
        q(monitorInfo, true);
        c14.a aVar = this.monitorCallBack;
        if (aVar != null) {
            aVar.a(monitorInfo);
        }
    }

    private final void t(MonitorInfo monitorInfo) {
        long j3;
        if (!u(monitorInfo)) {
            Logger.f365497g.d("RMonitor_looper_StackProvider", "handleCollectStart, deal msg not latest msg before trace, latest: " + this.lastStackRequestTime + ", deal: " + monitorInfo.getLastStackRequestTime());
            return;
        }
        d(monitorInfo);
        long currentTimeMillis = System.currentTimeMillis() - monitorInfo.getLastStackRequestTime();
        if (currentTimeMillis > getLagParam().f365685c) {
            long j16 = 5000 - currentTimeMillis;
            MonitorInfo d16 = monitorInfo.d();
            d16.t(Math.max(5000L, currentTimeMillis));
            d16.s(true);
            if (j16 <= 0) {
                s(d16);
                return;
            } else {
                y(2, d16, j16);
                return;
            }
        }
        Thread looperThread = getLooperThread();
        if (looperThread != null && looperThread.isAlive()) {
            try {
                if (o()) {
                    j3 = ThreadSuspend.c().g(looperThread);
                } else {
                    j3 = 0;
                }
                StackTraceElement[] stackTrace = looperThread.getStackTrace();
                if (j3 != 0) {
                    ThreadSuspend.c().f(j3);
                }
                if (u(monitorInfo)) {
                    Intrinsics.checkExpressionValueIsNotNull(stackTrace, "stackTrace");
                    v(monitorInfo, stackTrace);
                    y(1, monitorInfo, getLagParam().f365686d);
                    return;
                }
                Logger.f365497g.d("RMonitor_looper_StackProvider", "handleCollectStart, deal msg not latest msg after trace, latest: " + this.lastStackRequestTime + ", deal: " + monitorInfo.getLastStackRequestTime());
            } catch (Throwable th5) {
                Logger.f365497g.e("RMonitor_looper_StackProvider", "on trace fail for " + th5);
            }
        }
    }

    private final void w(int what, MonitorInfo monitorInfo) {
        Handler handler = this.stackThreadHandler;
        if (handler != null) {
            handler.removeMessages(what, monitorInfo);
        }
    }

    private final void x(int what, MonitorInfo monitorInfo) {
        Message obtain = Message.obtain();
        obtain.what = what;
        obtain.obj = monitorInfo;
        Handler handler = this.stackThreadHandler;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    private final void y(int what, MonitorInfo monitorInfo, long delay) {
        Message obtain = Message.obtain();
        obtain.what = what;
        obtain.obj = monitorInfo;
        Handler handler = this.stackThreadHandler;
        if (handler != null) {
            handler.sendMessageDelayed(obtain, delay);
        }
    }

    @Override // com.tencent.rmonitor.looper.provider.a
    public void f(@NotNull MonitorInfo monitorInfo, long endTime, long duration) {
        Intrinsics.checkParameterIsNotNull(monitorInfo, "monitorInfo");
        w(1, monitorInfo);
        if (duration >= getLagParam().f365684b) {
            d(monitorInfo);
            x(2, monitorInfo.d());
        } else {
            q(monitorInfo, false);
        }
        this.lastStackRequestTime = 0L;
    }

    @Override // com.tencent.rmonitor.looper.provider.a
    public void g(@NotNull MonitorInfo monitorInfo, long startTime) {
        Intrinsics.checkParameterIsNotNull(monitorInfo, "monitorInfo");
        this.lastStackRequestTime = monitorInfo.getLastStackRequestTime();
        p(monitorInfo);
        y(1, monitorInfo, getLagParam().f365686d);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        Object obj = msg2.obj;
        if (!(obj instanceof MonitorInfo)) {
            obj = null;
        }
        MonitorInfo monitorInfo = (MonitorInfo) obj;
        if (monitorInfo != null) {
            int i3 = msg2.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    s(monitorInfo);
                }
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                long b16 = g.b();
                t(monitorInfo);
                monitorInfo.b(uptimeMillis - msg2.getWhen(), g.b() - b16);
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.rmonitor.looper.provider.a
    public boolean l(@NotNull c14.a callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.monitorCallBack = callback;
        boolean z16 = true;
        try {
            Looper a16 = e.a(getLooperThread());
            if (a16 != null) {
                this.stackThreadHandler = new Handler(a16, this);
            } else {
                z16 = false;
            }
            return z16;
        } catch (Exception e16) {
            Logger.f365497g.e("RMonitor_looper_StackProvider", "prepare stack provider fail for exception {" + e16 + '}');
            return false;
        }
    }

    @Override // com.tencent.rmonitor.looper.provider.a
    public void n() {
        Handler handler = this.stackThreadHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.stackThreadHandler = null;
        e.g(getLooperThread());
        this.monitorCallBack = null;
    }

    public abstract void p(@NotNull MonitorInfo monitorInfo);

    public abstract void q(@NotNull MonitorInfo monitorInfo, boolean isOverThreshold);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: r, reason: from getter */
    public final Handler getStackThreadHandler() {
        return this.stackThreadHandler;
    }

    public final boolean u(@NotNull MonitorInfo monitorInfo) {
        Intrinsics.checkParameterIsNotNull(monitorInfo, "monitorInfo");
        long j3 = this.lastStackRequestTime;
        if (j3 != 0 && j3 == monitorInfo.getLastStackRequestTime()) {
            return true;
        }
        return false;
    }

    public abstract void v(@NotNull MonitorInfo monitorInfo, @NotNull StackTraceElement[] stackTrace);
}
