package com.tencent.av.zplan;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.e;
import com.tencent.av.service.i;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f77348a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f77349b = false;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f77350c = false;

    /* renamed from: d, reason: collision with root package name */
    private static com.tencent.av.service.e f77351d;

    /* renamed from: e, reason: collision with root package name */
    private static final List<d> f77352e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private static final ServiceConnection f77353f = new a();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.class) {
                QLog.d("VideoActionIPCHelper", 1, "VideoActionIPCHelper Service Connected");
                c.f77351d = e.a.j(iBinder);
                c.f77350c = true;
                c.f77348a = true;
                c.f77349b = true;
                c.k(iBinder);
                if (c.f77352e.size() > 0) {
                    Iterator it = c.f77352e.iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).onConnect();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (c.class) {
                QLog.d("VideoActionIPCHelper", 1, "VideoActionIPCHelper Service Disconnected");
                c.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements IBinder.DeathRecipient {
        b() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (c.class) {
                QLog.d("VideoActionIPCHelper", 1, "VideoActionIPCHelper binderDied");
                c.o();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.av.zplan.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0779c implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f77354a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f77355b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i f77356c;

        C0779c(String str, Bundle bundle, i iVar) {
            this.f77354a = str;
            this.f77355b = bundle;
            this.f77356c = iVar;
        }

        @Override // com.tencent.av.zplan.c.d
        public void onConnect() {
            c.j(this.f77354a, this.f77355b, this.f77356c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface d {
        void onConnect();
    }

    private static void i(d dVar) {
        f77352e.add(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(String str, Bundle bundle, i iVar) {
        try {
            QLog.d("VideoActionIPCHelper", 4, "VideoActionIPCHelper callZPlanAction " + str);
            com.tencent.av.service.e eVar = f77351d;
            if (eVar != null) {
                eVar.d2(str, bundle, iVar);
            }
        } catch (Throwable th5) {
            QLog.d("VideoActionIPCHelper", 1, "VideoActionIPCHelper callZPlanAction " + str + " error:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(IBinder iBinder) {
        try {
            iBinder.linkToDeath(new b(), 0);
        } catch (RemoteException e16) {
            o();
            QLog.e("VideoActionIPCHelper", 1, "VideoActionIPCHelper RemoteException\uff1a" + e16);
        }
    }

    public static boolean l() {
        return f77348a;
    }

    public static void m(String str, Bundle bundle, i iVar) {
        if (!f77350c) {
            QLog.d("VideoActionIPCHelper", 1, "Must use registerVideoActionIPCHelper before call onCallVideoAction");
        } else if (!f77349b) {
            QLog.d("VideoActionIPCHelper", 1, "delay to callVideoAction");
            i(new C0779c(str, bundle, iVar));
        } else {
            j(str, bundle, iVar);
        }
    }

    public static synchronized void n(Context context) {
        synchronized (c.class) {
            if (context != null) {
                if (!f77348a) {
                    QLog.d("VideoActionIPCHelper", 1, "VideoActionIPCHelper Register");
                    f77350c = true;
                    f77348a = context.bindService(new Intent(context, (Class<?>) AVServiceForQQ.class), f77353f, 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o() {
        f77350c = false;
        f77348a = false;
        f77349b = false;
        f77351d = null;
        f77352e.clear();
    }

    public static synchronized void p(Context context) {
        synchronized (c.class) {
            if (context != null) {
                if (f77348a) {
                    QLog.d("VideoActionIPCHelper", 1, "VideoActionIPCHelper unRegister");
                    context.unbindService(f77353f);
                    o();
                }
            }
        }
    }
}
