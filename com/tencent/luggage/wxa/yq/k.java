package com.tencent.luggage.wxa.yq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f146084a = false;

    /* renamed from: b, reason: collision with root package name */
    public static final List f146085b = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!IXWebBroadcastListener.UPDATE_ACTION.equals(action)) {
                x0.f("UpdateReceiver", "onReceive, action not match, action:" + action);
                return;
            }
            String stringExtra = intent.getStringExtra("package_name");
            if (!XWalkEnvironment.getPackageName().equals(stringExtra)) {
                x0.f("UpdateReceiver", "onReceive, package name not match, packageName:" + stringExtra);
                return;
            }
            String stringExtra2 = intent.getStringExtra("stage");
            if ("start".equals(stringExtra2)) {
                int intExtra = intent.getIntExtra("extra_data", 0);
                x0.d("UpdateReceiver", "update start, schedulerType:" + intExtra);
                k.d(intExtra);
                return;
            }
            if (IXWebBroadcastListener.STAGE_PROGRESSED.equals(stringExtra2)) {
                k.c(intent.getIntExtra("extra_data", 0));
                return;
            }
            if (IXWebBroadcastListener.STAGE_FINISHED.equals(stringExtra2)) {
                int intExtra2 = intent.getIntExtra("extra_data", 0);
                int intExtra3 = intent.getIntExtra("error_code", 0);
                x0.d("UpdateReceiver", "update finish, finishCode:" + intExtra2 + ", errorCode:" + intExtra3);
                k.b(intExtra2, intExtra3);
                return;
            }
            if (IXWebBroadcastListener.STAGE_MAINCFG_UPDATE.equals(stringExtra2)) {
                x0.d("UpdateReceiver", "update main config");
                k.c();
            } else if (IXWebBroadcastListener.STAGE_PLUGINCFG_UPDATE.equals(stringExtra2)) {
                x0.d("UpdateReceiver", "update plugin config");
                k.d();
            }
        }
    }

    public static synchronized void c(int i3) {
        synchronized (k.class) {
            Iterator it = f146085b.iterator();
            while (it.hasNext()) {
                ((IXWebBroadcastListener) it.next()).onUpdateProgressed(i3);
            }
        }
    }

    public static synchronized void d(int i3) {
        synchronized (k.class) {
            Iterator it = f146085b.iterator();
            while (it.hasNext()) {
                ((IXWebBroadcastListener) it.next()).onUpdateStart(i3);
            }
        }
    }

    public static synchronized void b(int i3, int i16) {
        synchronized (k.class) {
            Iterator it = f146085b.iterator();
            while (it.hasNext()) {
                ((IXWebBroadcastListener) it.next()).onUpdateFinished(i3, i16);
            }
        }
    }

    public static synchronized void c() {
        synchronized (k.class) {
            Iterator it = f146085b.iterator();
            while (it.hasNext()) {
                ((IXWebBroadcastListener) it.next()).onMainCfgUpdated();
            }
        }
    }

    public static synchronized void d() {
        synchronized (k.class) {
            Iterator it = f146085b.iterator();
            while (it.hasNext()) {
                ((IXWebBroadcastListener) it.next()).onPluginCfgUpdated();
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (k.class) {
            if (f146084a) {
                return;
            }
            try {
                XWalkEnvironment.convertContextToApplication(context).registerReceiver(new b(), new IntentFilter(IXWebBroadcastListener.UPDATE_ACTION));
                f146084a = true;
            } catch (Throwable th5) {
                x0.a("XWebBroadcastListenerManager", "init, registerReceiver error", th5);
            }
        }
    }

    public static synchronized void a(Context context, IXWebBroadcastListener iXWebBroadcastListener) {
        synchronized (k.class) {
            a(context);
            if (iXWebBroadcastListener == null) {
                return;
            }
            List list = f146085b;
            if (list.contains(iXWebBroadcastListener)) {
                return;
            }
            x0.d("XWebBroadcastListenerManager", "registerListener, listener: " + iXWebBroadcastListener);
            list.add(iXWebBroadcastListener);
        }
    }

    public static synchronized void a(IXWebBroadcastListener iXWebBroadcastListener) {
        synchronized (k.class) {
            if (iXWebBroadcastListener == null) {
                return;
            }
            List list = f146085b;
            if (list.contains(iXWebBroadcastListener)) {
                list.remove(iXWebBroadcastListener);
            }
        }
    }
}
