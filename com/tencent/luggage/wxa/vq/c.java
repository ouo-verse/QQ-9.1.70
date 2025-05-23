package com.tencent.luggage.wxa.vq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.luggage.wxa.ar.x0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f143730a = false;

    /* renamed from: b, reason: collision with root package name */
    public static final List f143731b = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"com.tencent.xweb.remotedebug".equals(action)) {
                x0.f("UpdateReceiver", "onReceive, action not match, action:" + action);
                return;
            }
            String stringExtra = intent.getStringExtra("package_name");
            if (!XWalkEnvironment.getPackageName().equals(stringExtra)) {
                x0.f("UpdateReceiver", "onReceive, package name not match, packageName:" + stringExtra);
                return;
            }
            int intExtra = intent.getIntExtra("extra_action", 0);
            if (intExtra == 1) {
                x0.d("UpdateReceiver", "onReceive, remote debug started");
                c.c(intent.getStringExtra("extra_data"));
            } else if (intExtra == 2) {
                x0.d("UpdateReceiver", "onReceive, remote debug stopped");
                c.c();
            } else {
                x0.d("UpdateReceiver", "onReceive, invalid action code:" + intExtra);
            }
        }
    }

    public static void b(String str) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.xweb.remotedebug");
        intent.putExtra("extra_action", 1);
        intent.putExtra("extra_data", str);
        intent.putExtra("package_name", XWalkEnvironment.getPackageName());
        x0.d("XWebRemoteDebugBroadcastManager", "broadcastRemoteDebugStarted");
        XWalkEnvironment.getApplicationContext().sendBroadcast(intent);
    }

    public static synchronized void c(String str) {
        synchronized (c.class) {
            Iterator it = f143731b.iterator();
            while (it.hasNext()) {
                ((com.tencent.luggage.wxa.vq.a) it.next()).a(str);
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (c.class) {
            if (f143730a) {
                return;
            }
            try {
                XWalkEnvironment.convertContextToApplication(context).registerReceiver(new b(), new IntentFilter("com.tencent.xweb.remotedebug"));
                f143730a = true;
            } catch (Throwable th5) {
                x0.a("XWebRemoteDebugBroadcastManager", "init, registerReceiver error", th5);
            }
        }
    }

    public static synchronized void c() {
        synchronized (c.class) {
            Iterator it = f143731b.iterator();
            while (it.hasNext()) {
                ((com.tencent.luggage.wxa.vq.a) it.next()).a();
            }
        }
    }

    public static synchronized void a(Context context, com.tencent.luggage.wxa.vq.a aVar) {
        synchronized (c.class) {
            a(context);
            if (aVar == null) {
                return;
            }
            List list = f143731b;
            if (list.contains(aVar)) {
                return;
            }
            x0.d("XWebRemoteDebugBroadcastManager", "registerListener, listener: " + aVar);
            list.add(aVar);
        }
    }

    public static void b() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.xweb.remotedebug");
        intent.putExtra("extra_action", 2);
        intent.putExtra("package_name", XWalkEnvironment.getPackageName());
        x0.d("XWebRemoteDebugBroadcastManager", "broadcastRemoteDebugStopped");
        XWalkEnvironment.getApplicationContext().sendBroadcast(intent);
    }
}
