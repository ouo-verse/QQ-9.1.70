package com.tencent.av.doodle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: d, reason: collision with root package name */
    private MySurfaceViewThread f73605d;

    /* renamed from: e, reason: collision with root package name */
    public long f73606e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class MySurfaceViewThread extends BaseThread {
        private boolean C = false;
        private boolean D = true;
        private SurfaceHolder E;
        private WeakReference<MySurfaceView> F;

        public MySurfaceViewThread(MySurfaceView mySurfaceView) {
            if (mySurfaceView != null) {
                this.E = mySurfaceView.getHolder();
            }
            this.F = new WeakReference<>(mySurfaceView);
        }

        public void d(boolean z16) {
            this.C = z16;
            if (QLog.isColorLevel()) {
                QLog.d("MySurfaceView", 2, "WL_DEBUG MySurfaceViewThread.setRunning running = " + z16);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            String str;
            StringBuilder sb5;
            WeakReference<MySurfaceView> weakReference = this.F;
            if (weakReference != null && weakReference.get() != null) {
                this.F.get().e(true);
            }
            while (this.C) {
                Canvas canvas = null;
                try {
                    try {
                        canvas = this.E.lockCanvas(null);
                        synchronized (this.E) {
                            WeakReference<MySurfaceView> weakReference2 = this.F;
                            if (weakReference2 != null && weakReference2.get() != null) {
                                if (this.D) {
                                    long elapsedRealtime = SystemClock.elapsedRealtime();
                                    long j3 = elapsedRealtime - this.F.get().f73606e;
                                    this.F.get().f73606e = elapsedRealtime;
                                    this.F.get().f(j3);
                                }
                                if (canvas != null) {
                                    this.F.get().b(canvas);
                                }
                            }
                        }
                        if (canvas != null) {
                            try {
                                this.E.unlockCanvasAndPost(canvas);
                            } catch (Exception e16) {
                                e = e16;
                                if (QLog.isColorLevel()) {
                                    str = "MySurfaceView";
                                    sb5 = new StringBuilder();
                                    sb5.append("WL_DEBUG run e = ");
                                    sb5.append(e);
                                    QLog.e(str, 2, sb5.toString());
                                }
                            }
                        }
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e("MySurfaceView", 2, "WL_DEBUG run e = " + e17);
                        }
                        if (canvas != null) {
                            try {
                                this.E.unlockCanvasAndPost(canvas);
                            } catch (Exception e18) {
                                e = e18;
                                if (QLog.isColorLevel()) {
                                    str = "MySurfaceView";
                                    sb5 = new StringBuilder();
                                    sb5.append("WL_DEBUG run e = ");
                                    sb5.append(e);
                                    QLog.e(str, 2, sb5.toString());
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    if (canvas != null) {
                        try {
                            this.E.unlockCanvasAndPost(canvas);
                        } catch (Exception e19) {
                            if (QLog.isColorLevel()) {
                                QLog.e("MySurfaceView", 2, "WL_DEBUG run e = " + e19);
                            }
                        }
                    }
                    throw th5;
                }
            }
            WeakReference<MySurfaceView> weakReference3 = this.F;
            if (weakReference3 != null && weakReference3.get() != null) {
                this.F.get().e(false);
            }
        }
    }

    public MySurfaceView(Context context) {
        super(context);
        this.f73606e = 0L;
        d(context);
    }

    private void d(Context context) {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setZOrderOnTop(true);
        holder.setFormat(-3);
    }

    protected abstract void b(Canvas canvas);

    public boolean c() {
        MySurfaceViewThread mySurfaceViewThread = this.f73605d;
        if (mySurfaceViewThread != null) {
            return mySurfaceViewThread.C;
        }
        return false;
    }

    protected abstract void e(boolean z16);

    protected abstract void f(long j3);

    protected void finalize() throws Throwable {
        try {
            g(false);
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        MySurfaceViewThread mySurfaceViewThread = this.f73605d;
        boolean z26 = true;
        if (mySurfaceViewThread != null && mySurfaceViewThread.C) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 != z16) {
            Throwable th5 = new Throwable("\u6253\u5370\u8c03\u7528\u6808");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setRunning, running[");
            sb5.append(z16);
            sb5.append("], mThread[");
            if (this.f73605d != null) {
                z18 = true;
            } else {
                z18 = false;
            }
            sb5.append(z18);
            sb5.append("], mThread.mRunning[");
            MySurfaceViewThread mySurfaceViewThread2 = this.f73605d;
            if (mySurfaceViewThread2 != null && mySurfaceViewThread2.C) {
                z19 = true;
            } else {
                z19 = false;
            }
            sb5.append(z19);
            sb5.append("]");
            QLog.w("MySurfaceView", 1, sb5.toString(), th5);
        }
        if (z16) {
            MySurfaceViewThread mySurfaceViewThread3 = this.f73605d;
            if (mySurfaceViewThread3 == null || !mySurfaceViewThread3.C) {
                MySurfaceViewThread mySurfaceViewThread4 = new MySurfaceViewThread(this);
                this.f73605d = mySurfaceViewThread4;
                mySurfaceViewThread4.d(true);
                this.f73605d.start();
                return;
            }
            return;
        }
        MySurfaceViewThread mySurfaceViewThread5 = this.f73605d;
        if (mySurfaceViewThread5 != null && mySurfaceViewThread5.C) {
            this.f73605d.d(false);
            if (this.f73605d != Thread.currentThread()) {
                while (z26) {
                    try {
                        this.f73605d.join();
                        z26 = false;
                    } catch (InterruptedException unused) {
                    }
                }
            }
            this.f73605d = null;
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("MySurfaceView", 2, "WL_DEBUG onWindowFocusChanged hasWindowFocus = " + z16);
        }
        if (!z16) {
            g(false);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f73606e = SystemClock.elapsedRealtime();
        Context context = getContext();
        boolean hasWindowFocus = hasWindowFocus();
        if (QLog.isColorLevel()) {
            QLog.d("MySurfaceView", 2, "WL_DEBUG surfaceCreated context = " + context.getClass().getName() + ", hasWindowFocus = " + hasWindowFocus);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Context context = getContext();
        if (QLog.isColorLevel()) {
            QLog.d("MySurfaceView", 2, "WL_DEBUG surfaceDestroyed context = " + context.getClass().getName());
        }
        if (!(context instanceof Activity)) {
            g(false);
        }
    }

    public MySurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f73606e = 0L;
        d(context);
    }

    public MySurfaceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f73606e = 0L;
        d(context);
    }
}
