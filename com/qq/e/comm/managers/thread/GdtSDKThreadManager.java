package com.qq.e.comm.managers.thread;

import android.os.Handler;
import android.os.HandlerThread;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class GdtSDKThreadManager {
    public static final int FILE = 3;
    public static final int NETWORK = 2;
    public static final int NORMAL = 1;

    /* renamed from: a, reason: collision with root package name */
    private static volatile GdtSDKThreadManager f38287a;

    /* renamed from: c, reason: collision with root package name */
    private static volatile Handler f38288c;

    /* renamed from: d, reason: collision with root package name */
    private static HandlerThread f38289d;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<GdtSDKThreadManagerAdapter> f38290b;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ThreadType {
    }

    public static GdtSDKThreadManager getInstance() {
        if (f38287a == null) {
            synchronized (GdtSDKThreadManager.class) {
                if (f38287a == null) {
                    f38287a = new GdtSDKThreadManager();
                }
            }
        }
        return f38287a;
    }

    public static Handler getSubThreadHandler() {
        if (f38288c == null) {
            synchronized (GdtSDKThreadManager.class) {
                if (f38288c == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread(Constants.GdtThreadConstants.SDK_SUB_THREAD, 0);
                    f38289d = baseHandlerThread;
                    try {
                        baseHandlerThread.start();
                    } catch (Throwable th5) {
                        GDTLogger.e("GdtSDKThreadManager:SUB_THREAD error", th5);
                    }
                    f38288c = new Handler(f38289d.getLooper());
                }
            }
        }
        return f38288c;
    }

    public final void runOnThread(int i3, Runnable runnable) {
        runOnThread(i3, runnable, 0L);
    }

    public final void setAdapter(WeakReference<GdtSDKThreadManagerAdapter> weakReference) {
        this.f38290b = weakReference;
    }

    public final void runOnThread(int i3, Runnable runnable, long j3) {
        WeakReference<GdtSDKThreadManagerAdapter> weakReference = this.f38290b;
        GdtSDKThreadManagerAdapter gdtSDKThreadManagerAdapter = weakReference != null ? weakReference.get() : null;
        if (gdtSDKThreadManagerAdapter != null) {
            gdtSDKThreadManagerAdapter.runOnThread(i3, runnable, j3);
        } else {
            GDTLogger.e("GdtSDKThreadManager:adapter is Null");
        }
    }
}
