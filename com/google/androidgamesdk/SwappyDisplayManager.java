package com.google.androidgamesdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SwappyDisplayManager implements DisplayManager.DisplayListener {

    /* renamed from: a, reason: collision with root package name */
    private long f34663a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f34664b;

    /* renamed from: c, reason: collision with root package name */
    private WindowManager f34665c;

    /* renamed from: d, reason: collision with root package name */
    private Display.Mode f34666d;

    /* compiled from: P */
    /* renamed from: com.google.androidgamesdk.SwappyDisplayManager$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f34667d;
        final /* synthetic */ SwappyDisplayManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            Window window = this.this$0.f34664b.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.preferredDisplayModeId = this.f34667d;
            window.setAttributes(attributes);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class LooperThread extends BaseThread {
        public Handler C;
        private Lock D;
        private Condition E;
        final /* synthetic */ SwappyDisplayManager this$0;

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.i("SwappyDisplayManager", "Starting looper thread");
            this.D.lock();
            Looper.prepare();
            this.C = new Handler();
            this.E.signal();
            this.D.unlock();
            Looper.loop();
            Log.i("SwappyDisplayManager", "Terminating looper thread");
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread
        public void start() {
            this.D.lock();
            super.start();
            try {
                this.E.await();
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            this.D.unlock();
        }
    }

    private boolean b() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29 && (i3 != 29 || Build.VERSION.PREVIEW_SDK_INT != 0)) {
            return false;
        }
        return true;
    }

    @TargetApi(23)
    private boolean c(Display.Mode mode) {
        if (mode.getPhysicalHeight() == this.f34666d.getPhysicalHeight() && mode.getPhysicalWidth() == this.f34666d.getPhysicalWidth()) {
            return true;
        }
        return false;
    }

    private void d(Display display) {
        Display.Mode[] supportedModes = display.getSupportedModes();
        int i3 = 0;
        for (Display.Mode mode : supportedModes) {
            if (c(mode)) {
                i3++;
            }
        }
        long[] jArr = new long[i3];
        int[] iArr = new int[i3];
        int i16 = 0;
        for (int i17 = 0; i17 < supportedModes.length; i17++) {
            if (c(supportedModes[i17])) {
                jArr[i16] = 1.0E9f / supportedModes[i17].getRefreshRate();
                iArr[i16] = supportedModes[i17].getModeId();
                i16++;
            }
        }
        nSetSupportedRefreshRates(this.f34663a, jArr, iArr);
    }

    private native void nOnRefreshRateChanged(long j3, long j16, long j17, long j18);

    private native void nSetSupportedRefreshRates(long j3, long[] jArr, int[] iArr);

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i3) {
        boolean z16;
        boolean z17;
        synchronized (this) {
            Display defaultDisplay = this.f34665c.getDefaultDisplay();
            float refreshRate = defaultDisplay.getRefreshRate();
            Display.Mode mode = defaultDisplay.getMode();
            boolean z18 = true;
            if (mode.getPhysicalWidth() != this.f34666d.getPhysicalWidth()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (mode.getPhysicalHeight() != this.f34666d.getPhysicalHeight()) {
                z17 = true;
            } else {
                z17 = false;
            }
            boolean z19 = z16 | z17;
            if (refreshRate == this.f34666d.getRefreshRate()) {
                z18 = false;
            }
            this.f34666d = mode;
            if (z19) {
                d(defaultDisplay);
            }
            if (b() && z18) {
                long j3 = 1.0E9f / refreshRate;
                nOnRefreshRateChanged(this.f34663a, j3, defaultDisplay.getAppVsyncOffsetNanos(), j3 - (this.f34665c.getDefaultDisplay().getPresentationDeadlineNanos() - 1000000));
            }
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i3) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i3) {
    }
}
