package com.qzone.common.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    private static String f45874d = "ScreenObserver";

    /* renamed from: e, reason: collision with root package name */
    private static e f45875e;

    /* renamed from: f, reason: collision with root package name */
    private static Object f45876f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static List<b> f45877g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private static Method f45878h;

    /* renamed from: a, reason: collision with root package name */
    private Context f45879a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f45880b = false;

    /* renamed from: c, reason: collision with root package name */
    private a f45881c = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private String f45882a = null;

        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            this.f45882a = action;
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                if (e.f45877g == null || e.f45877g.size() <= 0) {
                    return;
                }
                Iterator it = e.f45877g.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).onScreenOn();
                }
                return;
            }
            if (!IECScreenReceiver.ACTION_SCREEN_OFF.equals(this.f45882a) || e.f45877g == null || e.f45877g.size() <= 0) {
                return;
            }
            Iterator it5 = e.f45877g.iterator();
            while (it5.hasNext()) {
                ((b) it5.next()).onScreenOff();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void onScreenOff();

        void onScreenOn();
    }

    e() {
        try {
            f45878h = PowerManager.class.getMethod("isScreenOn", new Class[0]);
        } catch (NoSuchMethodException e16) {
            QZLog.w(f45874d, "API < 7," + e16);
        }
    }

    public static e b() {
        if (f45875e == null) {
            synchronized (f45876f) {
                if (f45875e == null) {
                    f45875e = new e();
                }
            }
        }
        return f45875e;
    }

    private void g() {
        if (this.f45879a != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f45879a.registerReceiver(this.f45881c, intentFilter);
        }
    }

    public void c(Context context) {
        this.f45879a = context;
        g();
        this.f45880b = true;
    }

    public boolean d() {
        return this.f45880b;
    }

    public void e(b bVar) {
        f45877g.remove(bVar);
    }

    public void f(b bVar) {
        f45877g.add(bVar);
    }

    public void h() {
        Context context = this.f45879a;
        if (context != null) {
            context.unregisterReceiver(this.f45881c);
        }
    }
}
