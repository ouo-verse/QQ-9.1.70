package com.tencent.qqlive.superplayer.tools.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes22.dex */
public class TVKHandlerThreadPool {

    /* renamed from: c, reason: collision with root package name */
    private static volatile HandlerThread f345471c;

    /* renamed from: a, reason: collision with root package name */
    private Map<HandlerThread, Handler> f345472a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private int f345473b = 0;

    /* loaded from: classes22.dex */
    static class QuitRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        HandlerThread f345474d;

        @Override // java.lang.Runnable
        public void run() {
            TVKHandlerThreadPool.a().e(this.f345474d);
            d.d("TVKHandlerThreadPool", "handlerThread obtain:" + this.f345474d.getName() + "::quit");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static TVKHandlerThreadPool f345475a = new TVKHandlerThreadPool();
    }

    public static TVKHandlerThreadPool a() {
        return a.f345475a;
    }

    private static void b() {
        synchronized (TVKHandlerThreadPool.class) {
            if (f345471c == null) {
                f345471c = new BaseHandlerThread("TVK_ShareThreadPool");
                f345471c.start();
            } else if (!f345471c.isAlive()) {
                f345471c.start();
            }
            if (f345471c.getLooper() == null) {
                synchronized (TVKHandlerThreadPool.class) {
                    f345471c.quit();
                    f345471c = new BaseHandlerThread("TVK_ShareThreadPool");
                    f345471c.start();
                }
            }
        }
    }

    public HandlerThread c(String str, int i3) {
        HandlerThread tVKHandlerThread;
        if (!vt3.d.f443491z1.a().booleanValue()) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str);
            baseHandlerThread.start();
            return baseHandlerThread;
        }
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                str = "TVK_HandlerThreadPool";
            }
            Iterator<Map.Entry<HandlerThread, Handler>> it = this.f345472a.entrySet().iterator();
            if (it.hasNext()) {
                tVKHandlerThread = it.next().getKey();
                if (tVKHandlerThread != null) {
                    this.f345472a.get(tVKHandlerThread).removeCallbacksAndMessages(null);
                    this.f345472a.remove(tVKHandlerThread);
                    d.d("TVKHandlerThreadPool", "handlerThread obtain:" + tVKHandlerThread.getName());
                    tVKHandlerThread.setName(str);
                    tVKHandlerThread.setPriority(i3);
                    if (tVKHandlerThread.getLooper() == null) {
                        tVKHandlerThread.quit();
                        tVKHandlerThread = new TVKHandlerThread(str, i3);
                        tVKHandlerThread.start();
                        d.d("TVKHandlerThreadPool", "handlerThread obtain:" + str + " create");
                    }
                } else {
                    tVKHandlerThread = new TVKHandlerThread(str, i3);
                    tVKHandlerThread.start();
                    d.d("TVKHandlerThreadPool", "handlerThread obtain:" + str + " create");
                }
            } else {
                tVKHandlerThread = new TVKHandlerThread(str, i3);
                tVKHandlerThread.start();
                d.d("TVKHandlerThreadPool", "handlerThread create:" + str + " create");
            }
        }
        return tVKHandlerThread;
    }

    public HandlerThread d(String str) {
        b();
        synchronized (TVKHandlerThreadPool.class) {
            int i3 = this.f345473b;
            if (i3 >= 6) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                return c(str, 5);
            }
            this.f345473b = i3 + 1;
            d.d("TVKHandlerThreadPool", "handlerThread obtainShareThread mShareThreadCount:" + this.f345473b);
            return f345471c;
        }
    }

    public void e(HandlerThread handlerThread) {
        synchronized (this) {
            if (handlerThread != null) {
                if (handlerThread.isAlive()) {
                    handlerThread.quit();
                }
            }
            this.f345472a.remove(handlerThread);
        }
    }

    public void f(HandlerThread handlerThread, Handler handler) {
        if (handlerThread == null) {
            return;
        }
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        synchronized (TVKHandlerThreadPool.class) {
            if (handlerThread.equals(f345471c)) {
                this.f345473b--;
                d.d("TVKHandlerThreadPool", "handlerThread recycle mShareThreadCount:" + this.f345473b);
                return;
            }
            if (!vt3.d.f443491z1.a().booleanValue()) {
                handlerThread.quit();
                return;
            }
            synchronized (this) {
                if (!this.f345472a.containsKey(handlerThread) && this.f345472a.size() < 3) {
                    try {
                        this.f345472a.put(handlerThread, new Handler(handlerThread.getLooper()));
                        d.d("TVKHandlerThreadPool", "handlerThread obtain:" + handlerThread.getName() + "::recycle");
                    } catch (Exception unused) {
                        d.d("TVKHandlerThreadPool", "handlerThread exception,just:" + handlerThread.getName() + "::quit");
                        handlerThread.quit();
                    }
                } else {
                    d.d("TVKHandlerThreadPool", "handlerThread obtain:" + handlerThread.getName() + "::quit");
                    if (this.f345472a.containsKey(handlerThread)) {
                        this.f345472a.remove(handlerThread);
                    }
                    handlerThread.quit();
                }
            }
        }
    }
}
