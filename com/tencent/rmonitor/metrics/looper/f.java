package com.tencent.rmonitor.metrics.looper;

import android.annotation.SuppressLint;
import android.app.Application;
import android.hardware.display.DisplayManager;
import com.tencent.bugly.common.looper.FrameManager;
import com.tencent.bugly.common.looper.IFrame;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.ThreadUtil;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.DropFrameResultMeta;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.metrics.looper.UIRefreshWatcher;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f implements IFrame, UIRefreshWatcher.b {
    private UIRefreshWatcher C;
    private boolean D;
    private g E;

    /* renamed from: d, reason: collision with root package name */
    private final long f365770d;

    /* renamed from: e, reason: collision with root package name */
    private long f365771e;

    /* renamed from: f, reason: collision with root package name */
    private long f365772f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f365773h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f365774i;

    /* renamed from: m, reason: collision with root package name */
    private final DropFrameResultMeta f365775m;

    public f() {
        this(true);
    }

    private void c(long j3, boolean z16) {
        long j16 = this.f365772f;
        if (j3 >= j16 && j16 != 0) {
            this.f365772f = j3;
            h(j3 - j16, z16);
        } else {
            this.f365772f = j3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0033, code lost:
    
        if (r0 > 62.0f) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long e() {
        float f16 = f();
        Logger.f365497g.i("RMonitor_looper_metric", "refreshRate: " + f16);
        float f17 = 58.0f;
        if (f16 >= 58.0f) {
            f17 = 62.0f;
        }
        f16 = f17;
        return 1.0E9f / f16;
    }

    @SuppressLint({"NewApi"})
    public static float f() {
        Application application = BaseInfo.app;
        if (application == null || !AndroidVersion.isOverJellyBeanMr1()) {
            return 60.0f;
        }
        try {
            DisplayManager displayManager = (DisplayManager) application.getSystemService("display");
            if (displayManager == null || displayManager.getDisplay(0) == null) {
                return 60.0f;
            }
            return displayManager.getDisplay(0).getRefreshRate();
        } catch (Exception e16) {
            Logger.f365497g.b("RMonitor_looper_metric", "getRefreshRate", e16);
            return 60.0f;
        }
    }

    private void h(long j3, boolean z16) {
        int i3;
        long j16;
        long j17 = j3 / 1000000;
        if (j17 > this.f365771e) {
            this.f365775m.suspendDuration += j17;
        }
        DropFrameResultMeta dropFrameResultMeta = this.f365775m;
        dropFrameResultMeta.totalDuration += j17;
        if (z16) {
            if (j3 > 16666667) {
                j16 = (j3 - 16666667) / 1000000;
                i3 = (int) (j3 / 16666667);
                long[] jArr = dropFrameResultMeta.refreshCount;
                if (i3 >= jArr.length) {
                    i3 = jArr.length - 1;
                }
            } else {
                i3 = 0;
                j16 = 0;
            }
            dropFrameResultMeta.hitchesDuration += j16;
            long[] jArr2 = dropFrameResultMeta.refreshCount;
            jArr2[i3] = jArr2[i3] + 1;
            long[] jArr3 = dropFrameResultMeta.refreshDuration;
            jArr3[i3] = jArr3[i3] + j17;
            g gVar = this.E;
            if (gVar != null) {
                gVar.a(this.f365772f, j17, j16);
            }
        }
    }

    @Override // com.tencent.rmonitor.metrics.looper.UIRefreshWatcher.b
    public void a() {
        this.D = true;
    }

    public void b(String str) {
        this.f365775m.reset();
        DropFrameResultMeta dropFrameResultMeta = this.f365775m;
        dropFrameResultMeta.scene = str;
        dropFrameResultMeta.timeStamp = System.currentTimeMillis();
    }

    public DropFrameResultMeta d() {
        return this.f365775m;
    }

    @Override // com.tencent.bugly.common.looper.IFrame
    @SuppressLint({"NewApi"})
    public void doFrame(long j3) {
        boolean z16;
        if (this.C != null) {
            z16 = this.D;
        } else {
            z16 = true;
        }
        c(j3, z16);
        this.D = false;
    }

    public boolean g() {
        return this.f365773h;
    }

    public void i() {
        if (!ThreadUtil.isInMainThread()) {
            Logger.f365497g.i("RMonitor_looper_metric", "pause, not in main looper");
            return;
        }
        if (this.f365773h && this.f365774i) {
            Logger.f365497g.d("RMonitor_looper_metric", "pause scene: " + this.f365775m.scene);
            this.f365774i = false;
            this.f365772f = 0L;
            FrameManager.INSTANCE.unRegister(this);
            return;
        }
        Logger.f365497g.d("RMonitor_looper_metric", "pause, isStarted: " + this.f365773h + ", isResumed: " + this.f365774i);
    }

    @Override // com.tencent.bugly.common.looper.IFrame
    public boolean isOpen() {
        if (this.f365773h && this.f365774i) {
            return true;
        }
        return false;
    }

    public void j() {
        if (!ThreadUtil.isInMainThread()) {
            Logger.f365497g.i("RMonitor_looper_metric", "resume, not in main looper");
            return;
        }
        if (this.f365773h && !this.f365774i) {
            Logger.f365497g.d("RMonitor_looper_metric", "resume scene: " + this.f365775m.scene);
            this.f365774i = true;
            this.f365772f = 0L;
            FrameManager.INSTANCE.register(this);
            return;
        }
        Logger.f365497g.d("RMonitor_looper_metric", "resume, isStarted: " + this.f365773h + ", isResumed: " + this.f365774i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(g gVar) {
        this.E = gVar;
    }

    @SuppressLint({"NewApi"})
    public boolean l(String str, long j3) {
        if (!AndroidVersion.isOverJellyBean()) {
            Logger.f365497g.i("RMonitor_looper_metric", "Build.VERSION.SDK_INT is to low.");
            return false;
        }
        if (!ThreadUtil.isInMainThread()) {
            Logger.f365497g.i("RMonitor_looper_metric", "start, not in main looper");
            return false;
        }
        if (this.f365773h) {
            Logger.f365497g.i("RMonitor_looper_metric", "start, has start before.");
            return false;
        }
        Logger.f365497g.d("RMonitor_looper_metric", "start scene: " + str);
        UIRefreshWatcher uIRefreshWatcher = this.C;
        if (uIRefreshWatcher != null) {
            uIRefreshWatcher.f(this);
        }
        this.f365771e = j3;
        this.f365772f = 0L;
        b(str);
        this.f365773h = true;
        this.f365774i = true;
        FrameManager.INSTANCE.register(this);
        return true;
    }

    @SuppressLint({"NewApi"})
    public void m() {
        if (!ThreadUtil.isInMainThread()) {
            Logger.f365497g.i("RMonitor_looper_metric", "stop, not in main looper");
            return;
        }
        if (!this.f365773h) {
            Logger.f365497g.d("RMonitor_looper_metric", "stop, not start yet.");
            return;
        }
        Logger.f365497g.d("RMonitor_looper_metric", "stop scene: " + this.f365775m.scene);
        UIRefreshWatcher uIRefreshWatcher = this.C;
        if (uIRefreshWatcher != null) {
            uIRefreshWatcher.i(this);
        }
        this.f365773h = false;
        this.f365774i = false;
        this.f365772f = 0L;
        FrameManager.INSTANCE.unRegister(this);
    }

    @SuppressLint({"NewApi"})
    public f(boolean z16) {
        this.f365771e = 200L;
        this.f365772f = 0L;
        this.f365773h = false;
        this.f365774i = false;
        this.f365775m = new DropFrameResultMeta();
        this.C = null;
        this.D = false;
        this.E = null;
        long e16 = e();
        this.f365770d = e16;
        Logger.f365497g.d("RMonitor_looper_metric", "frameRateInNanos: " + e16);
        if (AndroidVersion.isOverJellyBean() && z16) {
            this.C = UIRefreshWatcher.e();
        }
    }
}
