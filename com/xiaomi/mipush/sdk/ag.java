package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.xiaomi.push.au;
import com.xiaomi.push.bx;
import com.xiaomi.push.df;
import com.xiaomi.push.fv;
import com.xiaomi.push.gf;
import com.xiaomi.push.gg;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.hz;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ag {

    /* renamed from: l, reason: collision with root package name */
    private static ag f388022l = null;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f388023m = false;

    /* renamed from: n, reason: collision with root package name */
    private static final ArrayList<f> f388024n = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    private boolean f388025a;

    /* renamed from: b, reason: collision with root package name */
    private Context f388026b;

    /* renamed from: d, reason: collision with root package name */
    private Messenger f388028d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f388029e;

    /* renamed from: h, reason: collision with root package name */
    private long f388032h;

    /* renamed from: f, reason: collision with root package name */
    private List<Message> f388030f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private boolean f388031g = false;

    /* renamed from: i, reason: collision with root package name */
    private String f388033i = null;

    /* renamed from: j, reason: collision with root package name */
    private Intent f388034j = null;

    /* renamed from: k, reason: collision with root package name */
    private Integer f388035k = null;

    /* renamed from: c, reason: collision with root package name */
    private String f388027c = null;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message.what == 19) {
                String str = (String) message.obj;
                int i3 = message.arg1;
                synchronized (ac.class) {
                    if (ac.b(ag.this.f388026b).f(str)) {
                        if (ac.b(ag.this.f388026b).a(str) < 10) {
                            String str2 = "";
                            if (message.getData() != null) {
                                str2 = message.getData().getString("third_sync_reason");
                            }
                            v vVar = v.DISABLE_PUSH;
                            if (vVar.ordinal() == i3 && "syncing".equals(ac.b(ag.this.f388026b).c(vVar))) {
                                ag.this.F(str, vVar, true, null);
                            } else {
                                v vVar2 = v.ENABLE_PUSH;
                                if (vVar2.ordinal() == i3 && "syncing".equals(ac.b(ag.this.f388026b).c(vVar2))) {
                                    ag.this.F(str, vVar2, true, null);
                                } else {
                                    v vVar3 = v.UPLOAD_HUAWEI_TOKEN;
                                    if (vVar3.ordinal() == i3 && "syncing".equals(ac.b(ag.this.f388026b).c(vVar3))) {
                                        HashMap<String, String> e16 = com.xiaomi.mipush.sdk.f.e(ag.this.f388026b, com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_HUAWEI);
                                        e16.put("third_sync_reason", str2);
                                        ag.this.F(str, vVar3, false, e16);
                                    } else {
                                        v vVar4 = v.UPLOAD_FCM_TOKEN;
                                        if (vVar4.ordinal() == i3 && "syncing".equals(ac.b(ag.this.f388026b).c(vVar4))) {
                                            ag agVar = ag.this;
                                            agVar.F(str, vVar4, false, com.xiaomi.mipush.sdk.f.e(agVar.f388026b, com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FCM));
                                        } else {
                                            v vVar5 = v.UPLOAD_COS_TOKEN;
                                            if (vVar5.ordinal() == i3 && "syncing".equals(ac.b(ag.this.f388026b).c(vVar5))) {
                                                HashMap<String, String> e17 = com.xiaomi.mipush.sdk.f.e(ag.this.f388026b, com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_COS);
                                                e17.put("third_sync_reason", str2);
                                                ag.this.F(str, vVar5, false, e17);
                                            } else {
                                                v vVar6 = v.UPLOAD_FTOS_TOKEN;
                                                if (vVar6.ordinal() == i3 && "syncing".equals(ac.b(ag.this.f388026b).c(vVar6))) {
                                                    HashMap<String, String> e18 = com.xiaomi.mipush.sdk.f.e(ag.this.f388026b, com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FTOS);
                                                    e18.put("third_sync_reason", str2);
                                                    ag.this.F(str, vVar6, false, e18);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            ac.b(ag.this.f388026b).g(str);
                        } else {
                            ac.b(ag.this.f388026b).h(str);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b implements al.a {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c extends ContentObserver {
        c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            ag agVar = ag.this;
            agVar.f388035k = Integer.valueOf(com.xiaomi.push.service.v.c(agVar.f388026b).a());
            if (ag.this.f388035k.intValue() != 0) {
                ag.this.f388026b.getContentResolver().unregisterContentObserver(this);
                if (au.t(ag.this.f388026b)) {
                    ag.this.R();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class d implements ServiceConnection {
        d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (ag.this) {
                ag.this.f388028d = new Messenger(iBinder);
                ag.this.f388031g = false;
                Iterator it = ag.this.f388030f.iterator();
                while (it.hasNext()) {
                    try {
                        ag.this.f388028d.send((Message) it.next());
                    } catch (RemoteException e16) {
                        jz4.c.q(e16);
                    }
                }
                ag.this.f388030f.clear();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ag.this.f388028d = null;
            ag.this.f388031g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f388040a;

        static {
            int[] iArr = new int[v.values().length];
            f388040a = iArr;
            try {
                iArr[v.DISABLE_PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f388040a[v.ENABLE_PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f388040a[v.UPLOAD_HUAWEI_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f388040a[v.UPLOAD_FCM_TOKEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f388040a[v.UPLOAD_COS_TOKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f388040a[v.UPLOAD_FTOS_TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class f<T extends hq<T, ?>> {

        /* renamed from: a, reason: collision with root package name */
        T f388041a;

        /* renamed from: b, reason: collision with root package name */
        gf f388042b;

        /* renamed from: c, reason: collision with root package name */
        boolean f388043c;

        f() {
        }
    }

    ag(Context context) {
        this.f388025a = false;
        this.f388029e = null;
        this.f388026b = context.getApplicationContext();
        this.f388025a = U();
        f388023m = Y();
        this.f388029e = new a(Looper.getMainLooper());
        if (hz.j(context)) {
            al.a(new b());
        }
        Intent M = M();
        if (M != null) {
            O(M);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, v vVar, boolean z16, HashMap<String, String> hashMap) {
        he heVar;
        String str2 = str;
        if (s.c(this.f388026b).p() && au.t(this.f388026b)) {
            he heVar2 = new he();
            heVar2.a(true);
            Intent d16 = d();
            if (TextUtils.isEmpty(str)) {
                str2 = com.xiaomi.push.service.m.a();
                heVar2.a(str2);
                if (z16) {
                    heVar = new he(str2, true);
                } else {
                    heVar = null;
                }
                synchronized (ac.class) {
                    ac.b(this.f388026b).e(str2);
                }
            } else {
                heVar2.a(str2);
                if (z16) {
                    heVar = new he(str2, true);
                } else {
                    heVar = null;
                }
            }
            switch (e.f388040a[vVar.ordinal()]) {
                case 1:
                    gp gpVar = gp.DisablePushMessage;
                    heVar2.c(gpVar.f24750a);
                    heVar.c(gpVar.f24750a);
                    if (hashMap != null) {
                        heVar2.a(hashMap);
                        heVar.a(hashMap);
                    }
                    d16.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    gp gpVar2 = gp.EnablePushMessage;
                    heVar2.c(gpVar2.f24750a);
                    heVar.c(gpVar2.f24750a);
                    if (hashMap != null) {
                        heVar2.a(hashMap);
                        heVar.a(hashMap);
                    }
                    d16.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    heVar2.c(gp.ThirdPartyRegUpdate.f24750a);
                    if (hashMap != null) {
                        heVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            jz4.c.D("type:" + vVar + ", " + str2);
            heVar2.b(s.c(this.f388026b).d());
            heVar2.d(this.f388026b.getPackageName());
            gf gfVar = gf.Notification;
            y(heVar2, gfVar, false, null);
            if (z16) {
                heVar.b(s.c(this.f388026b).d());
                heVar.d(this.f388026b.getPackageName());
                Context context = this.f388026b;
                byte[] e16 = fv.e(ad.b(context, heVar, gfVar, false, context.getPackageName(), s.c(this.f388026b).d()));
                if (e16 != null) {
                    bx.f(this.f388026b.getPackageName(), this.f388026b, heVar, gfVar, e16.length);
                    d16.putExtra("mipush_payload", e16);
                    d16.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    d16.putExtra("mipush_app_id", s.c(this.f388026b).d());
                    d16.putExtra("mipush_app_token", s.c(this.f388026b).m());
                    T(d16);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = vVar.ordinal();
            obtain.obj = str2;
            obtain.arg1 = ordinal;
            if (hashMap != null && hashMap.get("third_sync_reason") != null) {
                Bundle bundle = new Bundle();
                bundle.putString("third_sync_reason", hashMap.get("third_sync_reason"));
                obtain.setData(bundle);
            }
            this.f388029e.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent M() {
        if (!"com.xiaomi.xmsf".equals(this.f388026b.getPackageName())) {
            return Q();
        }
        jz4.c.z("pushChannel xmsf create own channel");
        return Z();
    }

    private void O(Intent intent) {
        try {
            if (!hz.i() && Build.VERSION.SDK_INT >= 26) {
                X(intent);
            } else {
                this.f388026b.startService(intent);
            }
        } catch (Exception e16) {
            jz4.c.q(e16);
        }
    }

    private Intent Q() {
        if (J()) {
            jz4.c.z("pushChannel app start miui china channel");
            return V();
        }
        jz4.c.z("pushChannel app start  own channel");
        return Z();
    }

    private synchronized void S(int i3) {
        this.f388026b.getSharedPreferences("mipush_extra", 0).edit().putInt("service_boot_mode", i3).commit();
    }

    private void T(Intent intent) {
        boolean z16;
        int a16;
        ah d16 = ah.d(this.f388026b);
        int a17 = gk.ServiceBootMode.a();
        gg ggVar = gg.START;
        int a18 = d16.a(a17, ggVar.a());
        int a19 = a();
        gg ggVar2 = gg.BIND;
        if (a18 == ggVar2.a() && f388023m) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            a16 = ggVar2.a();
        } else {
            a16 = ggVar.a();
        }
        if (a16 != a19) {
            K(a16);
        }
        if (z16) {
            X(intent);
        } else {
            O(intent);
        }
    }

    private boolean U() {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(this.f388026b.getPackageManager(), "com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            if (packageInfo.versionCode < 105) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private Intent V() {
        Intent intent = new Intent();
        String packageName = this.f388026b.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", k());
        intent.putExtra("mipush_app_package", packageName);
        d0();
        return intent;
    }

    private synchronized void X(Intent intent) {
        if (this.f388031g) {
            Message e16 = e(intent);
            if (this.f388030f.size() >= 50) {
                this.f388030f.remove(0);
            }
            this.f388030f.add(e16);
            return;
        }
        if (this.f388028d == null) {
            this.f388026b.bindService(intent, new d(), 1);
            this.f388031g = true;
            this.f388030f.clear();
            this.f388030f.add(e(intent));
        } else {
            try {
                this.f388028d.send(e(intent));
            } catch (RemoteException unused) {
                this.f388028d = null;
                this.f388031g = false;
            }
        }
    }

    private boolean Y() {
        if (J()) {
            try {
                if (InstalledAppListMonitor.getPackageInfo(this.f388026b.getPackageManager(), "com.xiaomi.xmsf", 4).versionCode >= 108) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private Intent Z() {
        Intent intent = new Intent();
        String packageName = this.f388026b.getPackageName();
        e0();
        intent.setComponent(new ComponentName(this.f388026b, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    private synchronized int a() {
        return this.f388026b.getSharedPreferences("mipush_extra", 0).getInt("service_boot_mode", -1);
    }

    private boolean a0() {
        String packageName = this.f388026b.getPackageName();
        if (packageName.contains("miui") || packageName.contains("xiaomi") || (this.f388026b.getApplicationInfo().flags & 1) != 0) {
            return true;
        }
        return false;
    }

    private void c0() {
        this.f388032h = SystemClock.elapsedRealtime();
    }

    private Intent d() {
        if (J() && !"com.xiaomi.xmsf".equals(this.f388026b.getPackageName())) {
            return V();
        }
        return Z();
    }

    private void d0() {
        try {
            PackageManager packageManager = this.f388026b.getPackageManager();
            ComponentName componentName = new ComponentName(this.f388026b, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    private Message e(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    private void e0() {
        try {
            PackageManager packageManager = this.f388026b.getPackageManager();
            ComponentName componentName = new ComponentName(this.f388026b, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    public static synchronized ag h(Context context) {
        ag agVar;
        synchronized (ag.class) {
            if (f388022l == null) {
                f388022l = new ag(context);
            }
            agVar = f388022l;
        }
        return agVar;
    }

    private String k() {
        String str = this.f388033i;
        if (str != null) {
            return str;
        }
        try {
            if (InstalledAppListMonitor.getPackageInfo(this.f388026b.getPackageManager(), "com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f388033i = "com.xiaomi.push.service.XMPushService";
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception unused) {
        }
        this.f388033i = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    public final <T extends hq<T, ?>> void A(T t16, gf gfVar, boolean z16, boolean z17, gs gsVar, boolean z18) {
        B(t16, gfVar, z16, z17, gsVar, z18, this.f388026b.getPackageName(), s.c(this.f388026b).d());
    }

    public final <T extends hq<T, ?>> void B(T t16, gf gfVar, boolean z16, boolean z17, gs gsVar, boolean z18, String str, String str2) {
        C(t16, gfVar, z16, z17, gsVar, z18, str, str2, true);
    }

    public final <T extends hq<T, ?>> void C(T t16, gf gfVar, boolean z16, boolean z17, gs gsVar, boolean z18, String str, String str2, boolean z19) {
        D(t16, gfVar, z16, z17, gsVar, z18, str, str2, z19, true);
    }

    public final <T extends hq<T, ?>> void D(T t16, gf gfVar, boolean z16, boolean z17, gs gsVar, boolean z18, String str, String str2, boolean z19, boolean z26) {
        hb f16;
        if (z26 && !s.c(this.f388026b).s()) {
            if (z17) {
                x(t16, gfVar, z16);
                return;
            } else {
                jz4.c.m("drop the message before initialization.");
                return;
            }
        }
        if (z19) {
            f16 = ad.b(this.f388026b, t16, gfVar, z16, str, str2);
        } else {
            f16 = ad.f(this.f388026b, t16, gfVar, z16, str, str2);
        }
        if (gsVar != null) {
            f16.a(gsVar);
        }
        byte[] e16 = fv.e(f16);
        if (e16 == null) {
            jz4.c.m("send message fail, because msgBytes is null.");
            return;
        }
        bx.f(this.f388026b.getPackageName(), this.f388026b, t16, gfVar, e16.length);
        Intent d16 = d();
        d16.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        d16.putExtra("mipush_payload", e16);
        d16.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z18);
        T(d16);
    }

    public final void E(String str, v vVar, com.xiaomi.mipush.sdk.d dVar, String str2) {
        ac.b(this.f388026b).d(vVar, "syncing");
        HashMap<String, String> e16 = com.xiaomi.mipush.sdk.f.e(this.f388026b, dVar);
        e16.put("third_sync_reason", str2);
        F(str, vVar, false, e16);
    }

    public void G(String str, String str2) {
        Intent d16 = d();
        d16.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        d16.putExtra(com.xiaomi.push.service.r.B, this.f388026b.getPackageName());
        d16.putExtra(com.xiaomi.push.service.r.H, str);
        d16.putExtra(com.xiaomi.push.service.r.I, str2);
        T(d16);
    }

    public final void H(boolean z16) {
        I(z16, null);
    }

    public final void I(boolean z16, String str) {
        if (z16) {
            ac b16 = ac.b(this.f388026b);
            v vVar = v.DISABLE_PUSH;
            b16.d(vVar, "syncing");
            ac.b(this.f388026b).d(v.ENABLE_PUSH, "");
            F(str, vVar, true, null);
            return;
        }
        ac b17 = ac.b(this.f388026b);
        v vVar2 = v.ENABLE_PUSH;
        b17.d(vVar2, "syncing");
        ac.b(this.f388026b).d(v.DISABLE_PUSH, "");
        F(str, vVar2, true, null);
    }

    public boolean J() {
        if (this.f388025a && 1 == s.c(this.f388026b).a()) {
            return true;
        }
        return false;
    }

    public boolean K(int i3) {
        if (!s.c(this.f388026b).p()) {
            return false;
        }
        S(i3);
        he heVar = new he();
        heVar.a(com.xiaomi.push.service.m.a());
        heVar.b(s.c(this.f388026b).d());
        heVar.d(this.f388026b.getPackageName());
        heVar.c(gp.ClientABTest.f24750a);
        HashMap hashMap = new HashMap();
        heVar.f24813a = hashMap;
        hashMap.put("boot_mode", i3 + "");
        h(this.f388026b).y(heVar, gf.Notification, false, null);
        return true;
    }

    public final void N() {
        Intent d16 = d();
        d16.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        T(d16);
    }

    public boolean P() {
        if (!J() || !a0()) {
            return true;
        }
        if (this.f388035k == null) {
            Integer valueOf = Integer.valueOf(com.xiaomi.push.service.v.c(this.f388026b).a());
            this.f388035k = valueOf;
            if (valueOf.intValue() == 0) {
                this.f388026b.getContentResolver().registerContentObserver(com.xiaomi.push.service.v.c(this.f388026b).b(), false, new c(new Handler(Looper.getMainLooper())));
            }
        }
        if (this.f388035k.intValue() != 0) {
            return true;
        }
        return false;
    }

    public void R() {
        if (this.f388034j != null) {
            c0();
            T(this.f388034j);
            this.f388034j = null;
        }
    }

    public void W() {
        boolean z16;
        ArrayList<f> arrayList = f388024n;
        synchronized (arrayList) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                z16 = true;
            } else {
                z16 = false;
            }
            Iterator<f> it = arrayList.iterator();
            while (it.hasNext()) {
                f next = it.next();
                A(next.f388041a, next.f388042b, next.f388043c, false, null, true);
                if (!z16) {
                    try {
                        LockMethodProxy.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f388024n.clear();
        }
    }

    public long b() {
        return this.f388032h;
    }

    public void b0() {
        Intent d16 = d();
        d16.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        d16.putExtra(com.xiaomi.push.service.r.B, this.f388026b.getPackageName());
        d16.putExtra(com.xiaomi.push.service.r.G, com.xiaomi.push.ad.d(this.f388026b.getPackageName()));
        T(d16);
    }

    public void m() {
        O(d());
    }

    public void n(int i3) {
        o(i3, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i3, int i16) {
        Intent d16 = d();
        d16.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        d16.putExtra(com.xiaomi.push.service.r.B, this.f388026b.getPackageName());
        d16.putExtra(com.xiaomi.push.service.r.C, i3);
        d16.putExtra(com.xiaomi.push.service.r.D, i16);
        T(d16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i3, String str) {
        Intent d16 = d();
        d16.setAction("com.xiaomi.mipush.thirdparty");
        d16.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i3);
        d16.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        O(d16);
    }

    public void q(Context context) {
        if (hz.i()) {
            return;
        }
        q a16 = x.a(context);
        if (q.HUAWEI.equals(a16)) {
            E(null, v.UPLOAD_HUAWEI_TOKEN, com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_HUAWEI, "update");
        }
        if (q.OPPO.equals(a16)) {
            E(null, v.UPLOAD_COS_TOKEN, com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_COS, "update");
        }
        if (q.VIVO.equals(a16)) {
            E(null, v.UPLOAD_FTOS_TOKEN, com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FTOS, "update");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Intent intent) {
        intent.fillIn(d(), 24);
        T(intent);
    }

    public final void t(gj gjVar) {
        Intent d16 = d();
        byte[] e16 = fv.e(gjVar);
        if (e16 == null) {
            jz4.c.m("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        d16.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        d16.putExtra("mipush_payload", e16);
        O(d16);
    }

    public final void u(hf hfVar, boolean z16) {
        df.a(this.f388026b.getApplicationContext()).f(this.f388026b.getPackageName(), "E100003", hfVar.a(), 6001, null);
        this.f388034j = null;
        s.c(this.f388026b).f388093d = hfVar.a();
        Intent d16 = d();
        byte[] e16 = fv.e(ad.a(this.f388026b, hfVar, gf.Registration));
        if (e16 == null) {
            jz4.c.m("register fail, because msgBytes is null.");
            return;
        }
        d16.setAction("com.xiaomi.mipush.REGISTER_APP");
        d16.putExtra("mipush_app_id", s.c(this.f388026b).d());
        d16.putExtra("mipush_payload", e16);
        d16.putExtra("mipush_session", this.f388027c);
        d16.putExtra("mipush_env_chanage", z16);
        d16.putExtra("mipush_env_type", s.c(this.f388026b).a());
        if (au.t(this.f388026b) && P()) {
            c0();
            T(d16);
        } else {
            this.f388034j = d16;
        }
    }

    public final void v(hl hlVar) {
        byte[] e16 = fv.e(ad.a(this.f388026b, hlVar, gf.UnRegistration));
        if (e16 == null) {
            jz4.c.m("unregister fail, because msgBytes is null.");
            return;
        }
        Intent d16 = d();
        d16.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        d16.putExtra("mipush_app_id", s.c(this.f388026b).d());
        d16.putExtra("mipush_payload", e16);
        T(d16);
    }

    public final <T extends hq<T, ?>> void w(T t16, gf gfVar, gs gsVar) {
        y(t16, gfVar, !gfVar.equals(gf.Registration), gsVar);
    }

    public <T extends hq<T, ?>> void x(T t16, gf gfVar, boolean z16) {
        f fVar = new f();
        fVar.f388041a = t16;
        fVar.f388042b = gfVar;
        fVar.f388043c = z16;
        ArrayList<f> arrayList = f388024n;
        synchronized (arrayList) {
            arrayList.add(fVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    public final <T extends hq<T, ?>> void y(T t16, gf gfVar, boolean z16, gs gsVar) {
        A(t16, gfVar, z16, true, gsVar, true);
    }

    public final <T extends hq<T, ?>> void z(T t16, gf gfVar, boolean z16, gs gsVar, boolean z17) {
        A(t16, gfVar, z16, true, gsVar, z17);
    }
}
