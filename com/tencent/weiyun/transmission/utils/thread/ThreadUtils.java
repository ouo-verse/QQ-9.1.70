package com.tencent.weiyun.transmission.utils.thread;

import android.os.Handler;
import android.os.Looper;
import android.util.Printer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ThreadUtils {
    static IPatchRedirector $redirector_;
    private static final WeakHashMap<Looper, PrinterWrapper> sLooperPrinters;
    private static Handler sMainHandler;
    private static Thread sMainThread;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class PrinterWrapper implements Printer {
        static IPatchRedirector $redirector_;
        private final AtomicBoolean mHasPendingPrinter;
        private final List<Printer> mPendingPrinters;
        private final List<Printer> mWrappedPrinters;

        PrinterWrapper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mWrappedPrinters = new ArrayList();
            this.mPendingPrinters = new LinkedList();
            this.mHasPendingPrinter = new AtomicBoolean(false);
        }

        public void add(Printer printer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) printer);
                return;
            }
            synchronized (this.mPendingPrinters) {
                this.mPendingPrinters.add(printer);
            }
            this.mHasPendingPrinter.set(true);
        }

        @Override // android.util.Printer
        public void println(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (this.mHasPendingPrinter.getAndSet(false)) {
                synchronized (this.mPendingPrinters) {
                    this.mWrappedPrinters.addAll(this.mPendingPrinters);
                    this.mPendingPrinters.clear();
                }
            }
            Iterator<Printer> it = this.mWrappedPrinters.iterator();
            while (it.hasNext()) {
                it.next().println(str);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11354);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sMainThread = Looper.getMainLooper().getThread();
        sMainHandler = new Handler(Looper.getMainLooper());
        sLooperPrinters = new WeakHashMap<>();
    }

    ThreadUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addLooperPrinter(Printer printer) {
        addLooperPrinter(Looper.myLooper(), printer);
    }

    public static Handler getMainHandler() {
        return sMainHandler;
    }

    public static boolean isMainThread() {
        if (sMainThread == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public static void post(Runnable runnable) {
        sMainHandler.post(runnable);
    }

    public static void postDelayed(Runnable runnable, long j3) {
        sMainHandler.postDelayed(runnable, j3);
    }

    public static void removeCallbacks(Runnable runnable) {
        sMainHandler.removeCallbacks(runnable);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public static void addLooperPrinter(Looper looper, Printer printer) {
        PrinterWrapper printerWrapper;
        if (looper != null) {
            WeakHashMap<Looper, PrinterWrapper> weakHashMap = sLooperPrinters;
            synchronized (weakHashMap) {
                printerWrapper = weakHashMap.get(looper);
                if (printerWrapper == null) {
                    printerWrapper = new PrinterWrapper();
                    weakHashMap.put(looper, printerWrapper);
                    looper.setMessageLogging(printerWrapper);
                }
            }
            printerWrapper.add(printer);
            return;
        }
        throw new RuntimeException("null looper");
    }
}
