package com.tencent.qmethod.pandoraex.monitor;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.qmethod.pandoraex.core.ext.broadcast.ReceiverDispatchHelper;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReceiverMonitor {
    private static final String TAG = "ReceiverMonitor";

    ReceiverMonitor() {
    }

    public static Intent registerReceiver(Object obj, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "registerReceiver invoker, 2 params");
        if (!(obj instanceof Context)) {
            return (Intent) com.tencent.qmethod.pandoraex.core.t.b(obj, "registerReceiver", new Class[]{BroadcastReceiver.class, IntentFilter.class}, broadcastReceiver, intentFilter);
        }
        Context context = (Context) obj;
        return context.registerReceiver(broadcastReceiver, ReceiverDispatchHelper.p(context, broadcastReceiver, intentFilter, null));
    }

    public static void unregisterReceiver(Object obj, BroadcastReceiver broadcastReceiver) {
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "unregisterReceiver invoker");
        if (obj instanceof Context) {
            if (ReceiverDispatchHelper.s(broadcastReceiver)) {
                ((Context) obj).unregisterReceiver(broadcastReceiver);
                return;
            } else {
                com.tencent.qmethod.pandoraex.core.o.a(TAG, "ignore unregisterReceiver");
                return;
            }
        }
        com.tencent.qmethod.pandoraex.core.t.b(obj, "unregisterReceiver", new Class[]{BroadcastReceiver.class}, broadcastReceiver);
    }

    @SuppressLint({"NewApi"})
    public static Intent registerReceiver(Object obj, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i3) {
        Intent registerReceiver;
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "registerReceiver invoker, 3 params");
        if (obj instanceof Context) {
            Context context = (Context) obj;
            registerReceiver = context.registerReceiver(broadcastReceiver, ReceiverDispatchHelper.p(context, broadcastReceiver, intentFilter, null), i3);
            return registerReceiver;
        }
        return (Intent) com.tencent.qmethod.pandoraex.core.t.b(obj, "registerReceiver", new Class[]{BroadcastReceiver.class, IntentFilter.class, Integer.TYPE}, broadcastReceiver, intentFilter, Integer.valueOf(i3));
    }

    public static Intent registerReceiver(Object obj, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "registerReceiver invoker, 4 params");
        if (!(obj instanceof Context)) {
            return (Intent) com.tencent.qmethod.pandoraex.core.t.b(obj, "registerReceiver", new Class[]{BroadcastReceiver.class, IntentFilter.class, String.class, Handler.class}, broadcastReceiver, intentFilter, str, handler);
        }
        Context context = (Context) obj;
        return context.registerReceiver(broadcastReceiver, ReceiverDispatchHelper.p(context, broadcastReceiver, intentFilter, handler), str, handler);
    }

    @SuppressLint({"NewApi"})
    public static Intent registerReceiver(Object obj, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i3) {
        Intent registerReceiver;
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "registerReceiver invoker, 5 params");
        if (obj instanceof Context) {
            Context context = (Context) obj;
            registerReceiver = context.registerReceiver(broadcastReceiver, ReceiverDispatchHelper.p(context, broadcastReceiver, intentFilter, handler), str, handler, i3);
            return registerReceiver;
        }
        return (Intent) com.tencent.qmethod.pandoraex.core.t.b(obj, "registerReceiver", new Class[]{BroadcastReceiver.class, IntentFilter.class, String.class, Handler.class, Integer.TYPE}, broadcastReceiver, intentFilter, str, handler, Integer.valueOf(i3));
    }
}
