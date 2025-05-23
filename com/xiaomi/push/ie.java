package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ie {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Handler f389405a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Handler f389406b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f389407c = new Object();

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i3) {
        return b(context, broadcastReceiver, intentFilter, null, i3);
    }

    public static Intent b(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, int i3) {
        return d(context, broadcastReceiver, intentFilter, str, f(), i3);
    }

    public static Intent c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return d(context, broadcastReceiver, intentFilter, str, handler, 2);
    }

    public static Intent d(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i3) {
        Intent registerReceiver;
        if (context != null && broadcastReceiver != null && intentFilter != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                registerReceiver = context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i3);
                return registerReceiver;
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        }
        return null;
    }

    public static Handler e() {
        if (f389406b == null) {
            synchronized (f389407c) {
                if (f389406b == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("receiver_task");
                    baseHandlerThread.start();
                    f389406b = new Handler(baseHandlerThread.getLooper());
                }
            }
        }
        return f389406b;
    }

    private static Handler f() {
        if (f389405a == null) {
            synchronized (ie.class) {
                if (f389405a == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("handle_receiver");
                    baseHandlerThread.start();
                    f389405a = new Handler(baseHandlerThread.getLooper());
                }
            }
        }
        return f389405a;
    }
}
