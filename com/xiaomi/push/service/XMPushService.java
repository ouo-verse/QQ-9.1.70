package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.bh;
import com.xiaomi.push.bm;
import com.xiaomi.push.bz;
import com.xiaomi.push.cc;
import com.xiaomi.push.cf;
import com.xiaomi.push.cp;
import com.xiaomi.push.de;
import com.xiaomi.push.df;
import com.xiaomi.push.dy;
import com.xiaomi.push.dz;
import com.xiaomi.push.eb;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.es;
import com.xiaomi.push.et;
import com.xiaomi.push.eu;
import com.xiaomi.push.ev;
import com.xiaomi.push.ex;
import com.xiaomi.push.ey;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fc;
import com.xiaomi.push.fi;
import com.xiaomi.push.fo;
import com.xiaomi.push.fp;
import com.xiaomi.push.fq;
import com.xiaomi.push.fs;
import com.xiaomi.push.fv;
import com.xiaomi.push.ge;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.hb;
import com.xiaomi.push.hf;
import com.xiaomi.push.hu;
import com.xiaomi.push.hz;
import com.xiaomi.push.ie;
import com.xiaomi.push.ii;
import com.xiaomi.push.io;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.av;
import com.xiaomi.push.service.n;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes28.dex */
public class XMPushService extends Service implements es {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f389492b = false;

    /* renamed from: a, reason: collision with other field name */
    private ContentObserver f24866a;

    /* renamed from: a, reason: collision with other field name */
    private ep f24868a;

    /* renamed from: a, reason: collision with other field name */
    private eq f24869a;

    /* renamed from: a, reason: collision with other field name */
    private ey f24871a;

    /* renamed from: a, reason: collision with other field name */
    private aa f24872a;

    /* renamed from: a, reason: collision with other field name */
    private ab f24873a;

    /* renamed from: a, reason: collision with other field name */
    private w f24874a;

    /* renamed from: a, reason: collision with other field name */
    private x f24875a;

    /* renamed from: a, reason: collision with other field name */
    private y f24876a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.ab f24877a;

    /* renamed from: a, reason: collision with other field name */
    private an f24878a;

    /* renamed from: a, reason: collision with other field name */
    private Object f24882a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f24885a = false;

    /* renamed from: a, reason: collision with root package name */
    private int f389493a = 0;

    /* renamed from: b, reason: collision with other field name */
    private int f24886b = 0;

    /* renamed from: a, reason: collision with other field name */
    private long f24865a = 0;

    /* renamed from: a, reason: collision with other field name */
    protected Class f24881a = XMJobService.class;

    /* renamed from: c, reason: collision with root package name */
    private int f389494c = -1;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.p f24880a = null;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.n f24879a = null;

    /* renamed from: a, reason: collision with other field name */
    Messenger f24867a = null;

    /* renamed from: a, reason: collision with other field name */
    private Collection<com.xiaomi.push.service.d> f24884a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<z> f24883a = new ArrayList<>();

    /* renamed from: a, reason: collision with other field name */
    private eu f24870a = new r();

    /* loaded from: classes28.dex */
    class a implements am.a {
        a() {
        }

        @Override // com.xiaomi.push.service.am.a
        public void a() {
            XMPushService.this.e();
            if (am.c().a() <= 0) {
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(new g(12, null));
            }
        }
    }

    /* loaded from: classes28.dex */
    class aa extends BroadcastReceiver {
        aa() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes28.dex */
    class ab extends BroadcastReceiver {
        ab() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f24885a) {
                XMPushService.this.f24885a = true;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class b extends j {

        /* renamed from: e, reason: collision with root package name */
        am.b f389509e;

        public b(am.b bVar) {
            super(9);
            this.f389509e = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            try {
                if (!XMPushService.this.m462c()) {
                    jz4.c.B("trying bind while the connection is not created, quit!");
                } else {
                    am c16 = am.c();
                    am.b bVar = this.f389509e;
                    am.b b16 = c16.b(bVar.f389612h, bVar.f389606b);
                    if (b16 == null) {
                        jz4.c.m("ignore bind because the channel " + this.f389509e.f389612h + " is removed ");
                    } else if (b16.f389617m == am.c.unbind) {
                        b16.k(am.c.binding, 0, 0, null, null);
                        XMPushService.this.f24868a.m(b16);
                        dz.f(XMPushService.this, b16);
                    } else {
                        jz4.c.m("trying duplicate bind, ingore! " + b16.f389617m);
                    }
                }
            } catch (Exception e16) {
                jz4.c.B("Meet error when trying to bind. " + e16);
                XMPushService.this.a(10, e16);
            } catch (Throwable unused) {
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "bind the client. " + this.f389509e.f389612h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public static class c extends j {

        /* renamed from: e, reason: collision with root package name */
        private final am.b f389511e;

        public c(am.b bVar) {
            super(12);
            this.f389511e = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            this.f389511e.k(am.c.unbind, 1, 21, null, null);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "bind time out. chid=" + this.f389511e.f389612h;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            return TextUtils.equals(((c) obj).f389511e.f389612h, this.f389511e.f389612h);
        }

        public int hashCode() {
            return this.f389511e.f389612h.hashCode();
        }
    }

    /* loaded from: classes28.dex */
    class d extends j {

        /* renamed from: e, reason: collision with root package name */
        private eb f389512e;

        public d(eb ebVar) {
            super(8);
            this.f389512e = ebVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.f24880a.a(this.f389512e);
            if (ak.a(this.f389512e)) {
                XMPushService.this.a(new at.a(), 15000L);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "receive a message.";
        }
    }

    /* loaded from: classes28.dex */
    public class e extends j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            if (XMPushService.this.m457a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            jz4.c.m("should not connect. quit the job.");
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "do reconnect..";
        }
    }

    /* loaded from: classes28.dex */
    class f implements z {
        f() {
        }

        @Override // com.xiaomi.push.service.XMPushService.z
        public void a() {
            bh.a(XMPushService.this.getApplicationContext());
        }
    }

    /* loaded from: classes28.dex */
    public class g extends j {

        /* renamed from: e, reason: collision with root package name */
        public int f389516e;

        /* renamed from: f, reason: collision with root package name */
        public Exception f389517f;

        g(int i3, Exception exc) {
            super(2);
            this.f389516e = i3;
            this.f389517f = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.a(this.f389516e, this.f389517f);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "disconnect the connection.";
        }
    }

    /* loaded from: classes28.dex */
    class h extends j {
        h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.c();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "Init Job";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class i extends j {

        /* renamed from: e, reason: collision with root package name */
        private Intent f389520e;

        public i(Intent intent) {
            super(15);
            this.f389520e = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.d(this.f389520e);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "Handle intent action = " + this.f389520e.getAction();
        }
    }

    /* loaded from: classes28.dex */
    public static abstract class j extends n.b {
        public j(int i3) {
            super(i3);
        }

        public abstract void a();

        public abstract String e();

        @Override // java.lang.Runnable
        public void run() {
            int i3 = this.f389756d;
            if (i3 != 4 && i3 != 8) {
                jz4.c.n(jz4.b.f411286a, e());
            }
            a();
        }
    }

    /* loaded from: classes28.dex */
    class k extends ContentObserver {
        k(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            super.onChange(z16);
            boolean m450g = XMPushService.this.m450g();
            jz4.c.m("SuperPowerMode:" + m450g);
            XMPushService.this.e();
            if (m450g) {
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(new g(24, null));
            } else {
                XMPushService.this.a(true);
            }
        }
    }

    /* loaded from: classes28.dex */
    class l extends j {
        public l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.f24879a.b();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "ask the job queue to quit";
        }
    }

    /* loaded from: classes28.dex */
    class m extends j {

        /* renamed from: e, reason: collision with root package name */
        private fc f389524e;

        public m(fc fcVar) {
            super(8);
            this.f389524e = fcVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.f24880a.c(this.f389524e);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "receive a message.";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class n implements av.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f389526a;

        n(j jVar) {
            this.f389526a = jVar;
        }

        @Override // com.xiaomi.push.service.av.a
        public void a() {
            XMPushService.this.a(this.f389526a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class o extends j {

        /* renamed from: e, reason: collision with root package name */
        boolean f389528e;

        public o(boolean z16) {
            super(4);
            this.f389528e = z16;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            if (XMPushService.this.m462c()) {
                try {
                    if (!this.f389528e) {
                        dz.a();
                    }
                    XMPushService.this.f24868a.A(this.f389528e);
                } catch (fi e16) {
                    jz4.c.q(e16);
                    XMPushService.this.a(10, e16);
                }
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "send ping..";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class p extends j {

        /* renamed from: e, reason: collision with root package name */
        am.b f389530e;

        public p(am.b bVar) {
            super(4);
            this.f389530e = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            try {
                this.f389530e.k(am.c.unbind, 1, 16, null, null);
                ep epVar = XMPushService.this.f24868a;
                am.b bVar = this.f389530e;
                epVar.o(bVar.f389612h, bVar.f389606b);
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(new b(this.f389530e), 300L);
            } catch (fi e16) {
                jz4.c.q(e16);
                XMPushService.this.a(10, e16);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "rebind the client. " + this.f389530e.f389612h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class q extends j {
        q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m457a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "reset the connection.";
        }
    }

    /* loaded from: classes28.dex */
    class r implements eu {
        r() {
        }

        @Override // com.xiaomi.push.eu
        public void a(fc fcVar) {
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(new m(fcVar));
        }

        @Override // com.xiaomi.push.eu
        public void b(eb ebVar) {
            if (ak.a(ebVar)) {
                at.a().d(ebVar.D(), SystemClock.elapsedRealtime(), XMPushService.this.m453a());
            }
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(new d(ebVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class s extends j {

        /* renamed from: e, reason: collision with root package name */
        am.b f389534e;

        /* renamed from: f, reason: collision with root package name */
        int f389535f;

        /* renamed from: h, reason: collision with root package name */
        String f389536h;

        /* renamed from: i, reason: collision with root package name */
        String f389537i;

        public s(am.b bVar, int i3, String str, String str2) {
            super(9);
            this.f389534e = bVar;
            this.f389535f = i3;
            this.f389536h = str;
            this.f389537i = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            if (this.f389534e.f389617m != am.c.unbind && XMPushService.this.f24868a != null) {
                try {
                    ep epVar = XMPushService.this.f24868a;
                    am.b bVar = this.f389534e;
                    epVar.o(bVar.f389612h, bVar.f389606b);
                } catch (fi e16) {
                    jz4.c.q(e16);
                    XMPushService.this.a(10, e16);
                }
            }
            this.f389534e.k(am.c.unbind, this.f389535f, 0, this.f389537i, this.f389536h);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String e() {
            return "unbind the channel. " + this.f389534e.f389612h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class t implements ex {
        t() {
        }

        @Override // com.xiaomi.push.ex
        /* renamed from: a */
        public boolean mo300a(fc fcVar) {
            return true;
        }
    }

    /* loaded from: classes28.dex */
    class u extends Handler {
        u() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                try {
                    int i3 = message.what;
                    if (i3 != 17) {
                        if (i3 == 18) {
                            Message obtain = Message.obtain((Handler) null, 0);
                            obtain.what = 18;
                            Bundle bundle = new Bundle();
                            bundle.putString("xmsf_region", ag.a(XMPushService.this.getApplicationContext()).b());
                            obtain.setData(bundle);
                            message.replyTo.send(obtain);
                        }
                    } else {
                        Object obj = message.obj;
                        if (obj != null) {
                            XMPushService.this.onStart((Intent) obj, 1);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes28.dex */
    class v extends eq {
        v(Map map, int i3, String str, et etVar) {
            super(map, i3, str, etVar);
        }

        @Override // com.xiaomi.push.eq
        public byte[] h() {
            try {
                cp cpVar = new cp();
                cpVar.j(ae.f().a());
                return cpVar.h();
            } catch (Exception e16) {
                jz4.c.m("getOBBString err: " + e16.toString());
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class x extends BroadcastReceiver {
        x() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.au.r();
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes28.dex */
    class y extends BroadcastReceiver {
        y() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            jz4.c.m("[HB] hold short heartbeat, " + hz.e(intent));
            if (intent != null && intent.getExtras() != null) {
                XMPushService.this.onStart(intent, 1);
            }
        }
    }

    /* loaded from: classes28.dex */
    public interface z {
        void a();
    }

    private void d() {
        com.xiaomi.push.x e16 = com.xiaomi.push.au.e();
        as.c(getApplicationContext()).f(e16);
        if (e16 != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("network changed,");
            sb5.append("[type: " + e16.e() + "[" + e16.h() + "], state: " + e16.c() + "/" + e16.b());
            jz4.c.n("XMPushService", sb5.toString());
            NetworkInfo.State c16 = e16.c();
            if (c16 == NetworkInfo.State.SUSPENDED || c16 == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            jz4.c.n("XMPushService", "network changed, no active network");
        }
        if (dy.e() != null) {
            dy.e().b();
        }
        fo.h(this);
        this.f24871a.E();
        if (com.xiaomi.push.au.t(this)) {
            if (m462c() && m449f()) {
                b(false);
            }
            if (!m462c() && !m463d()) {
                this.f24879a.c(1);
                a(new e());
            }
            cf.b(this).d();
        } else {
            a(new g(2, null));
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (m457a()) {
            if (Cdo.e()) {
                return;
            }
            Cdo.d(true);
            return;
        }
        Cdo.a();
    }

    /* renamed from: f, reason: collision with other method in class */
    private boolean m449f() {
        if (SystemClock.elapsedRealtime() - this.f24865a < 30000) {
            return false;
        }
        return com.xiaomi.push.au.w(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: collision with other method in class */
    public boolean m450g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
    }

    /* renamed from: i, reason: collision with other method in class */
    private boolean m452i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !ge.q(this) && !ge.k(getApplicationContext());
    }

    private boolean j() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i3 = this.f389493a;
        int i16 = this.f24886b;
        if (i3 > i16) {
            if (intValue >= i3 || intValue < i16) {
                return true;
            }
        } else if (i3 < i16 && intValue >= i3 && intValue < i16) {
            return true;
        }
        return false;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ah.d(this).m(gk.ForegroundServiceSwitch.a(), false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f24867a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        super.onCreate();
        jz4.c.k(getApplicationContext());
        ii.e(this);
        au b16 = av.b(this);
        if (b16 != null) {
            io.b(b16.f389670g);
        }
        r rVar = null;
        if (hz.j(getApplicationContext())) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("hb-alarm");
            baseHandlerThread.start();
            Handler handler = new Handler(baseHandlerThread.getLooper());
            this.f24874a = new w(this, rVar);
            ie.d(this, this.f24874a, new IntentFilter(com.xiaomi.push.service.r.f389788o), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler, 4);
            f389492b = true;
            handler.post(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PackageManager packageManager = XMPushService.this.getApplicationContext().getPackageManager();
                        ComponentName componentName = new ComponentName(XMPushService.this.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
                        if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                        }
                    } catch (Throwable th5) {
                        jz4.c.m("[Alarm] disable ping receiver may be failure. " + th5);
                    }
                }
            });
        }
        this.f24867a = new Messenger(new u());
        com.xiaomi.push.service.t.d(this);
        v vVar = new v(null, 5222, "xiaomi.com", null);
        this.f24869a = vVar;
        vVar.e(true);
        this.f24871a = new ey(this, this.f24869a);
        this.f24878a = m455a();
        Cdo.b(this);
        this.f24871a.i(this);
        this.f24880a = new com.xiaomi.push.service.p(this);
        this.f24877a = new com.xiaomi.push.service.ab(this);
        new ao().b();
        dy.f().j(this);
        this.f24879a = new com.xiaomi.push.service.n("Connection Controller Thread");
        am c16 = am.c();
        c16.o();
        c16.k(new a());
        if (k()) {
            h();
        }
        fs.a(this).d(new com.xiaomi.push.service.o(this), "UPLOADER_PUSH_CHANNEL");
        a(new fp(this));
        a(new bd(this));
        if (hz.j(this)) {
            a(new com.xiaomi.push.service.q());
            if (ge.j()) {
                a(new f());
            }
        }
        a(new h());
        this.f24884a.add(ay.c(this));
        if (m451h()) {
            this.f24875a = new x();
            ie.c(this, this.f24875a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, null);
            this.f24882a = com.xiaomi.push.au.i(this);
        }
        if (hz.j(getApplicationContext())) {
            this.f24873a = new ab();
            ie.d(this, this.f24873a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
            y yVar = new y();
            this.f24876a = yVar;
            ie.d(this, yVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f24866a = new k(new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f24866a);
                } catch (Throwable th5) {
                    jz4.c.B("register super-power-mode observer err:" + th5.getMessage());
                }
            }
            int[] m446a = m446a();
            if (m446a != null) {
                this.f24872a = new aa();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                ie.c(this, this.f24872a, intentFilter, null, null);
                this.f389493a = m446a[0];
                this.f24886b = m446a[1];
                jz4.c.m("falldown initialized: " + this.f389493a + "," + this.f24886b);
            }
        }
        bm.d(this, this.f24871a);
        bz.b(this, this.f24871a);
        String str = "";
        if (b16 != null) {
            try {
                if (!TextUtils.isEmpty(b16.f389664a) && (split = b16.f389664a.split("@")) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        cc.a(this);
        jz4.c.D("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.g.b(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        x xVar = this.f24875a;
        if (xVar != null) {
            a(xVar);
            this.f24875a = null;
        }
        Object obj = this.f24882a;
        if (obj != null) {
            com.xiaomi.push.au.s(this, obj);
            this.f24882a = null;
        }
        ab abVar = this.f24873a;
        if (abVar != null) {
            a(abVar);
            this.f24873a = null;
        }
        y yVar = this.f24876a;
        if (yVar != null) {
            a(yVar);
            this.f24876a = null;
        }
        aa aaVar = this.f24872a;
        if (aaVar != null) {
            a(aaVar);
            this.f24872a = null;
        }
        w wVar = this.f24874a;
        if (wVar != null) {
            a(wVar);
            this.f24874a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f24866a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f24866a);
            } catch (Throwable th5) {
                jz4.c.B("unregister super-power-mode err:" + th5.getMessage());
            }
        }
        this.f24884a.clear();
        this.f24879a.i();
        a(new j(2) { // from class: com.xiaomi.push.service.XMPushService.4
            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                if (XMPushService.this.f24868a != null) {
                    XMPushService.this.f24868a.v(15, null);
                    XMPushService.this.f24868a = null;
                }
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "disconnect for service destroy.";
            }
        });
        a(new l());
        am.c().o();
        am.c().j(this, 15);
        am.c().h();
        this.f24871a.x(this);
        ae.f().i();
        Cdo.a();
        i();
        bm.i(this, this.f24871a);
        bz.f(this, this.f24871a);
        super.onDestroy();
        jz4.c.m("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            jz4.c.B("onStart() with intent NULL");
        } else {
            try {
                String stringExtra = intent.getStringExtra(com.xiaomi.push.service.r.f389792s);
                String stringExtra2 = intent.getStringExtra(com.xiaomi.push.service.r.B);
                String stringExtra3 = intent.getStringExtra("mipush_app_package");
                if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && !"miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                    jz4.c.n("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), stringExtra, stringExtra2, stringExtra3));
                }
                jz4.c.n("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, intent = %s", intent.getAction(), stringExtra, stringExtra2, stringExtra3, hz.e(intent)));
            } catch (Throwable th5) {
                jz4.c.B("onStart() cause error: " + th5.getMessage());
                return;
            }
        }
        if (intent != null && intent.getAction() != null) {
            if (!"com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) && !"com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                    a(new i(intent));
                }
            } else if (this.f24879a.g()) {
                jz4.c.B("ERROR, the job controller is blocked.");
                am.c().j(this, 14);
                stopSelf();
            } else {
                a(new i(intent));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            jz4.c.z("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        onStart(intent, i16);
        if (hz.j(this)) {
            return 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public class w extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final Object f389541a;

        w() {
            this.f389541a = new Object();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                jz4.c.B("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f389541a) {
                try {
                    this.f389541a.notifyAll();
                } catch (Exception e16) {
                    jz4.c.m("[Alarm] notify lock. " + e16);
                }
            }
        }

        private void b(long j3) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                jz4.c.B("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f389541a) {
                try {
                    this.f389541a.wait(j3);
                } catch (InterruptedException e16) {
                    jz4.c.m("[Alarm] interrupt from waiting state. " + e16);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            jz4.c.z("[Alarm] heartbeat alarm has been triggered.");
            if (com.xiaomi.push.service.r.f389788o.equals(intent.getAction())) {
                if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                    jz4.c.z("[Alarm] Ping XMChannelService on timer");
                    try {
                        Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                        intent2.putExtra("time_stamp", System.currentTimeMillis());
                        intent2.setAction("com.xiaomi.push.timer");
                        com.xiaomi.push.service.a.i(context).j(intent2);
                        b(3000L);
                        jz4.c.m("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                return;
            }
            jz4.c.m("[Alarm] cancel the old ping timer");
            Cdo.a();
        }

        /* synthetic */ w(XMPushService xMPushService, r rVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(1:3)(1:37)|4|(2:29|(3:31|(1:33)(1:35)|34)(10:36|10|(1:12)|13|(1:15)|16|17|(1:19)|21|(2:23|24)(1:26)))(1:8)|9|10|(0)|13|(0)|16|17|(0)|21|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ed, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ee, code lost:
    
        jz4.c.q(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e7 A[Catch: Exception -> 0x00ed, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ed, blocks: (B:17:0x00e1, B:19:0x00e7), top: B:16:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        String str;
        com.xiaomi.push.bb.c().z();
        as.c(getApplicationContext()).d();
        ag a16 = ag.a(getApplicationContext());
        String b16 = a16.b();
        jz4.c.n("XMPushService", "region of cache is " + b16);
        String str2 = "";
        if (TextUtils.isEmpty(b16)) {
            String b17 = b();
            str = b17;
            b16 = hz.c(b17).name();
        } else {
            str = "";
        }
        boolean isEmpty = TextUtils.isEmpty(b16);
        String str3 = LocaleManager.MOBILE_COUNTRY_CODE_CN_STR;
        if (!isEmpty && com.xiaomi.push.n.China.name().equals(b16)) {
            a16.e(b16, true);
            a16.g(LocaleManager.MOBILE_COUNTRY_CODE_CN_STR, true);
        } else if (!TextUtils.isEmpty(b16)) {
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                str3 = "";
            } else {
                str2 = com.xiaomi.push.n.China.name();
            }
            a16.e(str2, true);
            a16.g(str3, true);
            b16 = str2;
        } else {
            b16 = com.xiaomi.push.n.China.name();
            jz4.c.p("XMPushService", "after check, appRegion is ", b16, ", countryCode=", str);
            if (com.xiaomi.push.n.China.name().equals(b16)) {
                eq.c("cn.app.chat.xiaomi.net");
            }
            a(b16);
            if (m451h()) {
                jz4.c.n("XMPushService", "-->postOnCreate(): try trigger connect now");
                j jVar = new j(11) { // from class: com.xiaomi.push.service.XMPushService.13
                    @Override // com.xiaomi.push.service.XMPushService.j
                    public void a() {
                        com.xiaomi.push.service.w.h(XMPushService.this);
                        if (com.xiaomi.push.au.t(XMPushService.this)) {
                            XMPushService.this.a(true);
                        }
                    }

                    @Override // com.xiaomi.push.service.XMPushService.j
                    public String e() {
                        return "prepare the mi push account.";
                    }
                };
                a(jVar);
                av.j(new n(jVar));
            }
            if (ii.f()) {
                this.f24878a.d(this);
            }
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            com.xiaomi.push.g.j(this, getApplicationInfo(), true);
            return;
        }
        str = str3;
        jz4.c.p("XMPushService", "after check, appRegion is ", b16, ", countryCode=", str);
        if (com.xiaomi.push.n.China.name().equals(b16)) {
        }
        a(b16);
        if (m451h()) {
        }
        if (ii.f()) {
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
        }
    }

    /* renamed from: h, reason: collision with other method in class */
    private boolean m451h() {
        boolean z16;
        String packageName = getPackageName();
        if ("com.xiaomi.xmsf".equals(packageName)) {
            jz4.c.m("current sdk expect region is cn");
            z16 = com.xiaomi.push.n.China.name().equals(ag.a(getApplicationContext()).b());
        } else {
            z16 = !ax.a(this).e(packageName);
        }
        if (!z16) {
            jz4.c.p("XMPushService", "-->isPushEnabled(): isEnabled=", Boolean.valueOf(z16), ", package=", packageName, ", region=", ag.a(getApplicationContext()).b());
        }
        return z16;
    }

    private String b() {
        String str;
        com.xiaomi.push.i.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        int i3 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            com.xiaomi.push.service.v c16 = com.xiaomi.push.service.v.c(this);
            String str2 = null;
            while (true) {
                if (!TextUtils.isEmpty(str2) && c16.a() != 0) {
                    str = a();
                    break;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = a();
                }
                try {
                    synchronized (obj) {
                        if (i3 < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(30000L);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i3++;
            }
        } else {
            str = LocaleManager.MOBILE_COUNTRY_CODE_CN_STR;
        }
        jz4.c.m("wait coutrycode :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " , count = " + i3);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ep epVar = this.f24868a;
        if (epVar != null && epVar.B()) {
            jz4.c.B("try to connect while connecting.");
            return;
        }
        ep epVar2 = this.f24868a;
        if (epVar2 != null && epVar2.D()) {
            jz4.c.B("try to connect while is connected.");
            return;
        }
        this.f24869a.j(com.xiaomi.push.au.j(this));
        g();
        if (this.f24868a == null) {
            am.c().i(this);
            c(false);
        }
    }

    private void g() {
        try {
            this.f24871a.k(this.f24870a, new t());
            this.f24871a.R();
            this.f24868a = this.f24871a;
        } catch (fi e16) {
            jz4.c.o("fail to create Slim connection", e16);
            this.f24871a.v(3, e16);
        }
    }

    private void i() {
        synchronized (this.f24883a) {
            this.f24883a.clear();
        }
    }

    /* renamed from: e, reason: collision with other method in class */
    public static boolean m448e() {
        return f389492b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m453a() {
        if (this.f389494c < 0) {
            this.f389494c = com.xiaomi.push.g.b(this, "com.xiaomi.xmsf");
        }
        return this.f389494c;
    }

    /* renamed from: a, reason: collision with other method in class */
    private int[] m446a() {
        String[] split;
        String f16 = ah.d(getApplicationContext()).f(gk.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(f16) && (split = f16.split(",")) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                int intValue = Integer.valueOf(split[1]).intValue();
                iArr[1] = intValue;
                int i3 = iArr[0];
                if (i3 >= 0 && i3 <= 23 && intValue >= 0 && intValue <= 23 && i3 != intValue) {
                    return iArr;
                }
            } catch (NumberFormatException e16) {
                jz4.c.B("parse falldown time range failure: " + e16);
            }
        }
        return null;
    }

    private void b(boolean z16) {
        this.f24865a = SystemClock.elapsedRealtime();
        if (!m462c()) {
            a(true);
        } else if (com.xiaomi.push.au.t(this)) {
            c(new o(z16));
        } else {
            c(new g(17, null));
            a(true);
        }
    }

    private String a() {
        String g16 = hz.g("ro.miui.region");
        return TextUtils.isEmpty(g16) ? hz.g("ro.product.locale.region") : g16;
    }

    private void b(Intent intent) {
        long j3;
        eb ebVar;
        String stringExtra = intent.getStringExtra(com.xiaomi.push.service.r.B);
        String stringExtra2 = intent.getStringExtra(com.xiaomi.push.service.r.F);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        am c16 = am.c();
        if (bundleExtra != null) {
            fb fbVar = (fb) a(new fb(bundleExtra), stringExtra, stringExtra2);
            if (fbVar == null) {
                return;
            } else {
                ebVar = eb.c(fbVar, c16.b(fbVar.m(), fbVar.q()).f389613i);
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j3 = Long.parseLong(intent.getStringExtra(com.xiaomi.push.service.r.f389789p));
                } catch (NumberFormatException unused) {
                    j3 = 0;
                }
                String stringExtra3 = intent.getStringExtra(com.xiaomi.push.service.r.f389790q);
                String stringExtra4 = intent.getStringExtra(com.xiaomi.push.service.r.f389791r);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                am.b b16 = c16.b(stringExtra5, String.valueOf(j3));
                if (b16 != null) {
                    eb ebVar2 = new eb();
                    try {
                        ebVar2.h(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    ebVar2.l("SECMSG", null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    ebVar2.j(j3, stringExtra3, stringExtra4);
                    ebVar2.k(intent.getStringExtra("ext_pkt_id"));
                    ebVar2.n(byteArrayExtra, b16.f389613i);
                    jz4.c.m("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    ebVar = ebVar2;
                }
            }
            ebVar = null;
        }
        if (ebVar != null) {
            c(new aw(this, ebVar));
        }
    }

    private static void a(String str) {
        if (com.xiaomi.push.n.China.name().equals(str)) {
            com.xiaomi.push.bb.n("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            com.xiaomi.push.bb.n("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            com.xiaomi.push.bb.n("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            com.xiaomi.push.bb.n("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            com.xiaomi.push.bb.n("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            com.xiaomi.push.bb.n("resolver.msg.xiaomi.net", "111.13.142.153:443");
            com.xiaomi.push.bb.n("resolver.msg.xiaomi.net", "111.202.1.252:443");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:172:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(Intent intent) {
        int i3;
        String d16;
        SharedPreferences sharedPreferences;
        am c16 = am.c();
        boolean z16 = true;
        int i16 = 0;
        if (!com.xiaomi.push.service.r.f389777d.equalsIgnoreCase(intent.getAction()) && !com.xiaomi.push.service.r.f389783j.equalsIgnoreCase(intent.getAction())) {
            if (com.xiaomi.push.service.r.f389782i.equalsIgnoreCase(intent.getAction())) {
                String stringExtra = intent.getStringExtra(com.xiaomi.push.service.r.B);
                String stringExtra2 = intent.getStringExtra(com.xiaomi.push.service.r.f389792s);
                String stringExtra3 = intent.getStringExtra(com.xiaomi.push.service.r.f389789p);
                jz4.c.m("Service called close channel chid = " + stringExtra2 + " res = " + am.b.e(stringExtra3));
                if (TextUtils.isEmpty(stringExtra2)) {
                    Iterator<String> it = c16.g(stringExtra).iterator();
                    while (it.hasNext()) {
                        a(it.next(), 2);
                    }
                    return;
                } else if (TextUtils.isEmpty(stringExtra3)) {
                    a(stringExtra2, 2);
                    return;
                } else {
                    a(stringExtra2, stringExtra3, 2, null, null);
                    return;
                }
            }
            if (com.xiaomi.push.service.r.f389778e.equalsIgnoreCase(intent.getAction())) {
                b(intent);
                return;
            }
            if (com.xiaomi.push.service.r.f389780g.equalsIgnoreCase(intent.getAction())) {
                c(intent);
                return;
            }
            if (com.xiaomi.push.service.r.f389779f.equalsIgnoreCase(intent.getAction())) {
                fc a16 = a(new fa(intent.getBundleExtra("ext_packet")), intent.getStringExtra(com.xiaomi.push.service.r.B), intent.getStringExtra(com.xiaomi.push.service.r.F));
                if (a16 != null) {
                    c(new aw(this, eb.c(a16, c16.b(a16.m(), a16.q()).f389613i)));
                    return;
                }
                return;
            }
            if (com.xiaomi.push.service.r.f389781h.equalsIgnoreCase(intent.getAction())) {
                fc a17 = a(new fq(intent.getBundleExtra("ext_packet")), intent.getStringExtra(com.xiaomi.push.service.r.B), intent.getStringExtra(com.xiaomi.push.service.r.F));
                if (a17 != null) {
                    c(new aw(this, eb.c(a17, c16.b(a17.m(), a17.q()).f389613i)));
                    return;
                }
                return;
            }
            if (com.xiaomi.push.service.r.f389784k.equals(intent.getAction())) {
                String stringExtra4 = intent.getStringExtra(com.xiaomi.push.service.r.f389792s);
                String stringExtra5 = intent.getStringExtra(com.xiaomi.push.service.r.f389789p);
                if (stringExtra4 != null) {
                    jz4.c.m("request reset connection from chid = " + stringExtra4);
                    am.b b16 = am.c().b(stringExtra4, stringExtra5);
                    if (b16 != null && b16.f389613i.equals(intent.getStringExtra(com.xiaomi.push.service.r.f389797x)) && b16.f389617m == am.c.binded) {
                        ep m454a = m454a();
                        if (m454a == null || !m454a.r(SystemClock.elapsedRealtime() - 15000)) {
                            c(new q());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            String str = null;
            r8 = null;
            am.b b17 = null;
            str = null;
            if (com.xiaomi.push.service.r.f389785l.equals(intent.getAction())) {
                String stringExtra6 = intent.getStringExtra(com.xiaomi.push.service.r.B);
                List<String> g16 = c16.g(stringExtra6);
                if (g16.isEmpty()) {
                    jz4.c.m("open channel should be called first before update info, pkg=" + stringExtra6);
                    return;
                }
                String stringExtra7 = intent.getStringExtra(com.xiaomi.push.service.r.f389792s);
                String stringExtra8 = intent.getStringExtra(com.xiaomi.push.service.r.f389789p);
                if (TextUtils.isEmpty(stringExtra7)) {
                    stringExtra7 = g16.get(0);
                }
                if (TextUtils.isEmpty(stringExtra8)) {
                    Collection<am.b> f16 = c16.f(stringExtra7);
                    if (f16 != null && !f16.isEmpty()) {
                        b17 = f16.iterator().next();
                    }
                } else {
                    b17 = c16.b(stringExtra7, stringExtra8);
                }
                if (b17 != null) {
                    if (intent.hasExtra(com.xiaomi.push.service.r.f389799z)) {
                        b17.f389610f = intent.getStringExtra(com.xiaomi.push.service.r.f389799z);
                    }
                    if (intent.hasExtra(com.xiaomi.push.service.r.A)) {
                        b17.f389611g = intent.getStringExtra(com.xiaomi.push.service.r.A);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!IECScreenReceiver.ACTION_SCREEN_ON.equals(intent.getAction()) && !IECScreenReceiver.ACTION_SCREEN_OFF.equals(intent.getAction())) {
                if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                    if (com.xiaomi.push.service.v.c(getApplicationContext()).d() && com.xiaomi.push.service.v.c(getApplicationContext()).a() == 0) {
                        jz4.c.m("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                        return;
                    }
                    final byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                    final String stringExtra9 = intent.getStringExtra("mipush_app_package");
                    boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                    final int intExtra = intent.getIntExtra("mipush_env_type", 1);
                    ax.a(this).h(stringExtra9);
                    if (booleanExtra && !"com.xiaomi.xmsf".equals(getPackageName())) {
                        c(new j(14) { // from class: com.xiaomi.push.service.XMPushService.2
                            @Override // com.xiaomi.push.service.XMPushService.j
                            public void a() {
                                av.g(XMPushService.this);
                                am.c().m("5");
                                io.b(intExtra);
                                XMPushService.this.f24869a.l(eq.b());
                                jz4.c.m("clear account and start registration. " + stringExtra9);
                                XMPushService.this.a(byteArrayExtra, stringExtra9);
                            }

                            @Override // com.xiaomi.push.service.XMPushService.j
                            public String e() {
                                return "clear account cache.";
                            }
                        });
                        return;
                    } else {
                        a(byteArrayExtra, stringExtra9);
                        return;
                    }
                }
                if (!"com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) && !"com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                    if (com.xiaomi.push.service.y.f389849a.equals(intent.getAction())) {
                        String stringExtra10 = intent.getStringExtra("uninstall_pkg_name");
                        if (stringExtra10 == null || TextUtils.isEmpty(stringExtra10.trim())) {
                            return;
                        }
                        try {
                            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(getPackageManager(), stringExtra10, 0);
                            if (packageInfo == null || packageInfo.applicationInfo == null || !ge.l(this, packageInfo.packageName)) {
                                z16 = false;
                            } else {
                                jz4.c.m("dual space's app uninstalled " + stringExtra10);
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        if ("com.xiaomi.channel".equals(stringExtra10) && !am.c().f("1").isEmpty() && z16) {
                            a("1", 0);
                            jz4.c.m("close the miliao channel as the app is uninstalled.");
                            return;
                        }
                        SharedPreferences sharedPreferences2 = getSharedPreferences("pref_registered_pkg_names", 0);
                        String string = sharedPreferences2.getString(stringExtra10, null);
                        if (TextUtils.isEmpty(string) || !z16) {
                            return;
                        }
                        SharedPreferences.Editor edit = sharedPreferences2.edit();
                        edit.remove(stringExtra10);
                        edit.commit();
                        if (com.xiaomi.push.service.x.T(this, stringExtra10)) {
                            com.xiaomi.push.service.x.X(this, stringExtra10);
                        }
                        com.xiaomi.push.service.x.x(this, stringExtra10);
                        com.xiaomi.push.service.e.f(getApplicationContext(), stringExtra10);
                        if (!m462c() || string == null) {
                            return;
                        }
                        try {
                            com.xiaomi.push.service.w.i(this, com.xiaomi.push.service.w.c(stringExtra10, string));
                            jz4.c.m("uninstall " + stringExtra10 + " msg sent");
                            return;
                        } catch (fi e16) {
                            jz4.c.B("Fail to send Message: " + e16.getMessage());
                            a(10, e16);
                            return;
                        }
                    }
                    if (com.xiaomi.push.service.y.f389850b.equals(intent.getAction())) {
                        String stringExtra11 = intent.getStringExtra("data_cleared_pkg_name");
                        if (TextUtils.isEmpty(stringExtra11)) {
                            return;
                        }
                        try {
                            sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                            if (sharedPreferences != null) {
                                try {
                                    str = sharedPreferences.getString(stringExtra11, null);
                                } catch (Throwable th5) {
                                    th = th5;
                                    jz4.c.m("Fail to get sp or appId : " + th);
                                    if (!TextUtils.isEmpty(str)) {
                                    }
                                    com.xiaomi.push.service.e.f(this, stringExtra11);
                                    if (hz.j(getApplicationContext())) {
                                    }
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            sharedPreferences = null;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            SharedPreferences.Editor edit2 = sharedPreferences.edit();
                            edit2.remove(stringExtra11);
                            edit2.commit();
                            if (com.xiaomi.push.service.x.T(this, stringExtra11)) {
                                com.xiaomi.push.service.x.X(this, stringExtra11);
                            }
                            com.xiaomi.push.service.x.x(this, stringExtra11);
                            a(stringExtra11, fv.e(com.xiaomi.push.service.w.m(stringExtra11, str)), true);
                        }
                        com.xiaomi.push.service.e.f(this, stringExtra11);
                        if (hz.j(getApplicationContext())) {
                            return;
                        }
                        bc.e(stringExtra11);
                        return;
                    }
                    if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                        String stringExtra12 = intent.getStringExtra(com.xiaomi.push.service.r.B);
                        int intExtra2 = intent.getIntExtra(com.xiaomi.push.service.r.C, -2);
                        if (TextUtils.isEmpty(stringExtra12)) {
                            return;
                        }
                        if (intExtra2 >= -1) {
                            com.xiaomi.push.service.x.z(this, stringExtra12, intExtra2, intent.getIntExtra(com.xiaomi.push.service.r.D, -1));
                            return;
                        } else {
                            com.xiaomi.push.service.x.B(this, stringExtra12, intent.getStringExtra(com.xiaomi.push.service.r.H), intent.getStringExtra(com.xiaomi.push.service.r.I));
                            return;
                        }
                    }
                    if ("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION".equals(intent.getAction())) {
                        String stringExtra13 = intent.getStringExtra(com.xiaomi.push.service.r.B);
                        if (TextUtils.isEmpty(stringExtra13)) {
                            return;
                        }
                        com.xiaomi.push.service.x.Q(this, stringExtra13);
                        return;
                    }
                    if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                        String stringExtra14 = intent.getStringExtra(com.xiaomi.push.service.r.B);
                        String stringExtra15 = intent.getStringExtra(com.xiaomi.push.service.r.G);
                        if (intent.hasExtra(com.xiaomi.push.service.r.E)) {
                            int intExtra3 = intent.getIntExtra(com.xiaomi.push.service.r.E, 0);
                            d16 = com.xiaomi.push.ad.d(stringExtra14 + intExtra3);
                            z16 = false;
                            i16 = intExtra3;
                        } else {
                            d16 = com.xiaomi.push.ad.d(stringExtra14);
                        }
                        if (TextUtils.isEmpty(stringExtra14) || !TextUtils.equals(stringExtra15, d16)) {
                            jz4.c.B("invalid notification for " + stringExtra14);
                            return;
                        }
                        if (z16) {
                            com.xiaomi.push.service.x.X(this, stringExtra14);
                            return;
                        } else {
                            com.xiaomi.push.service.x.R(this, stringExtra14, i16);
                            return;
                        }
                    }
                    if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                        String stringExtra16 = intent.getStringExtra("mipush_app_package");
                        if (!TextUtils.isEmpty(stringExtra16)) {
                            ax.a(this).d(stringExtra16);
                        }
                        if ("com.xiaomi.xmsf".equals(getPackageName())) {
                            return;
                        }
                        a(19, (Exception) null);
                        e();
                        stopSelf();
                        return;
                    }
                    if (!"com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) && !"com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                            String stringExtra17 = intent.getStringExtra("mipush_app_package");
                            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                            gj gjVar = new gj();
                            try {
                                fv.d(gjVar, byteArrayExtra2);
                                fs.a(this).e(gjVar, stringExtra17);
                                return;
                            } catch (hu e17) {
                                jz4.c.q(e17);
                                return;
                            }
                        }
                        if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                            jz4.c.m("[Alarm] Service called on timer");
                            if (m452i()) {
                                if (Cdo.e()) {
                                    jz4.c.m("enter falldown mode, stop alarm");
                                    Cdo.a();
                                }
                            } else {
                                Cdo.d(false);
                                if (m449f()) {
                                    b(false);
                                }
                            }
                            w wVar = this.f24874a;
                            if (wVar != null) {
                                wVar.a();
                                return;
                            }
                            return;
                        }
                        if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                            jz4.c.m("Service called on check alive.");
                            if (m449f()) {
                                b(false);
                                return;
                            }
                            return;
                        }
                        if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                            jz4.c.m("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                            Cdo.c(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                            return;
                        }
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            d();
                            return;
                        }
                        if ("miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                            a(intent);
                            return;
                        }
                        if ("com.xiaomi.xmsf.USE_INTELLIGENT_HB".equals(intent.getAction())) {
                            if (intent.getExtras() == null || (i3 = intent.getExtras().getInt("effectivePeriod", 0)) <= 0 || i3 > 604800) {
                                return;
                            }
                            as.c(getApplicationContext()).e(i3);
                            return;
                        }
                        if ("action_cr_config".equals(intent.getAction())) {
                            boolean booleanExtra2 = intent.getBooleanExtra("action_cr_event_switch", false);
                            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
                            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_perf_switch", false);
                            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
                            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_event_en", true);
                            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
                            kz4.a h16 = kz4.a.b().l(booleanExtra2).k(longExtra).o(booleanExtra3).n(longExtra2).i(com.xiaomi.push.an.b(getApplicationContext())).j(booleanExtra4).m(longExtra3).h(getApplicationContext());
                            if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                                return;
                            }
                            de.n(getApplicationContext(), h16);
                            return;
                        }
                        if (com.xiaomi.push.service.r.f389786m.equals(intent.getAction())) {
                            ar.b(getApplicationContext(), intent);
                            return;
                        } else {
                            if (com.xiaomi.push.service.r.f389787n.equals(intent.getAction())) {
                                String stringExtra18 = intent.getStringExtra("ext_downward_pkt_id");
                                if (TextUtils.isEmpty(stringExtra18)) {
                                    return;
                                }
                                at.a().f(stringExtra18, intent.getLongExtra("ext_app_receive_time", 0L));
                                return;
                            }
                            return;
                        }
                    }
                    String stringExtra19 = intent.getStringExtra("mipush_app_package");
                    byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                    String stringExtra20 = intent.getStringExtra("mipush_app_id");
                    String stringExtra21 = intent.getStringExtra("mipush_app_token");
                    if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        ax.a(this).f(stringExtra19);
                    }
                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        ax.a(this).i(stringExtra19);
                        ax.a(this).j(stringExtra19);
                    }
                    if (byteArrayExtra3 == null) {
                        az.b(this, stringExtra19, byteArrayExtra3, 70000003, "null payload");
                        return;
                    }
                    az.f(stringExtra19, byteArrayExtra3);
                    a(new com.xiaomi.push.service.s(this, stringExtra19, stringExtra20, stringExtra21, byteArrayExtra3));
                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                        if (this.f24875a == null) {
                            this.f24875a = new x();
                            ie.c(this, this.f24875a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, null);
                        }
                        if (this.f24882a == null) {
                            this.f24882a = com.xiaomi.push.au.i(this);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String stringExtra22 = intent.getStringExtra("mipush_app_package");
                byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                boolean booleanExtra5 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                if (aq.b(byteArrayExtra4, stringExtra22)) {
                    jz4.c.m("duplicate msg from: " + String.valueOf(stringExtra22));
                    return;
                }
                if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                    ax.a(this).b(stringExtra22);
                    if (hz.j(getApplicationContext())) {
                        bc.e(stringExtra22);
                    }
                }
                a(stringExtra22, byteArrayExtra4, booleanExtra5);
                return;
            }
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(intent.getAction())) {
                if (m452i()) {
                    return;
                }
                jz4.c.m("exit falldown mode, activate alarm.");
                e();
                if (m462c() || m463d()) {
                    return;
                }
                a(true);
                return;
            }
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(intent.getAction()) && m452i() && Cdo.e()) {
                jz4.c.m("enter falldown mode, stop alarm.");
                Cdo.a();
                return;
            }
            return;
        }
        String stringExtra23 = intent.getStringExtra(com.xiaomi.push.service.r.f389792s);
        if (TextUtils.isEmpty(intent.getStringExtra(com.xiaomi.push.service.r.f389797x))) {
            jz4.c.m("security is empty. ignore.");
            return;
        }
        if (!TextUtils.isEmpty(stringExtra23)) {
            boolean m445a = m445a(stringExtra23, intent);
            am.b a18 = a(stringExtra23, intent);
            if (!com.xiaomi.push.au.v(this)) {
                this.f24878a.h(this, a18, false, 2, null);
                return;
            }
            if (m462c()) {
                am.c cVar = a18.f389617m;
                if (cVar == am.c.unbind) {
                    c(new b(a18));
                    return;
                }
                if (m445a) {
                    c(new p(a18));
                    return;
                } else if (cVar == am.c.binding) {
                    jz4.c.m(String.format("the client is binding. %1$s %2$s.", a18.f389612h, am.b.e(a18.f389606b)));
                    return;
                } else {
                    if (cVar == am.c.binded) {
                        this.f24878a.h(this, a18, true, 0, null);
                        return;
                    }
                    return;
                }
            }
            a(true);
            return;
        }
        jz4.c.B("channel id is empty, do nothing!");
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(com.xiaomi.push.service.r.B);
        String stringExtra2 = intent.getStringExtra(com.xiaomi.push.service.r.F);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        fb[] fbVarArr = new fb[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i3 = 0; i3 < parcelableArrayExtra.length; i3++) {
            fb fbVar = new fb((Bundle) parcelableArrayExtra[i3]);
            fbVarArr[i3] = fbVar;
            fb fbVar2 = (fb) a(fbVar, stringExtra, stringExtra2);
            fbVarArr[i3] = fbVar2;
            if (fbVar2 == null) {
                return;
            }
        }
        am c16 = am.c();
        eb[] ebVarArr = new eb[length];
        for (int i16 = 0; i16 < length; i16++) {
            fb fbVar3 = fbVarArr[i16];
            ebVarArr[i16] = eb.c(fbVar3, c16.b(fbVar3.m(), fbVar3.q()).f389613i);
        }
        c(new com.xiaomi.push.service.c(this, ebVarArr));
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString(PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME);
        as.c(getApplicationContext()).g(string);
        bm.e(this, string);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a, reason: collision with other method in class */
    public void m456a() {
        if (SystemClock.elapsedRealtime() - this.f24865a >= ev.a() && com.xiaomi.push.au.w(this)) {
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final String str, final byte[] bArr, boolean z16) {
        Collection<am.b> f16 = am.c().f("5");
        if (f16.isEmpty()) {
            if (z16) {
                az.f(str, bArr);
            }
        } else if (f16.iterator().next().f389617m == am.c.binded) {
            a(new j(4) { // from class: com.xiaomi.push.service.XMPushService.3
                @Override // com.xiaomi.push.service.XMPushService.j
                public void a() {
                    try {
                        com.xiaomi.push.service.w.l(XMPushService.this, str, bArr);
                    } catch (fi e16) {
                        jz4.c.q(e16);
                        XMPushService.this.a(10, e16);
                    }
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                public String e() {
                    return "send mi push message";
                }
            });
        } else if (z16) {
            az.f(str, bArr);
        }
    }

    private void c(j jVar) {
        this.f24879a.e(jVar);
    }

    private void c(boolean z16) {
        try {
            if (ii.f()) {
                if (z16) {
                    if (hz.j(this)) {
                        Intent intent = new Intent("miui.intent.action.NETWORK_CONNECTED");
                        intent.addFlags(1073741824);
                        sendBroadcast(intent);
                    }
                    for (com.xiaomi.push.service.d dVar : (com.xiaomi.push.service.d[]) this.f24884a.toArray(new com.xiaomi.push.service.d[0])) {
                        dVar.a();
                    }
                    return;
                }
                if (hz.j(this)) {
                    Intent intent2 = new Intent("miui.intent.action.NETWORK_BLOCKED");
                    intent2.addFlags(1073741824);
                    sendBroadcast(intent2);
                }
            }
        } catch (Exception e16) {
            jz4.c.q(e16);
        }
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            az.b(this, str, bArr, 70000003, "null payload");
            jz4.c.m("register request without payload");
            return;
        }
        hb hbVar = new hb();
        try {
            fv.d(hbVar, bArr);
            if (hbVar.f389249a == gf.Registration) {
                hf hfVar = new hf();
                try {
                    fv.d(hfVar, hbVar.m381a());
                    a(new com.xiaomi.push.service.s(this, hbVar.b(), hfVar.b(), hfVar.c(), bArr));
                    df.a(getApplicationContext()).f(hbVar.b(), "E100003", hfVar.a(), 6002, null);
                } catch (hu e16) {
                    jz4.c.B("app register error. " + e16);
                    az.b(this, str, bArr, 70000003, " data action error.");
                }
            } else {
                az.b(this, str, bArr, 70000003, " registration action required.");
                jz4.c.m("register request with invalid payload");
            }
        } catch (hu e17) {
            jz4.c.B("app register fail. " + e17);
            az.b(this, str, bArr, 70000003, " data container error.");
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m461b() {
        try {
            Class<?> c16 = ii.c(this, "miui.os.Build");
            Field field = c16.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = c16.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = c16.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public an m459b() {
        return this.f24878a;
    }

    public void b(j jVar) {
        this.f24879a.d(jVar.f389756d, jVar);
    }

    @Override // com.xiaomi.push.es
    public void b(ep epVar) {
        dy.e().b(epVar);
        c(true);
        this.f24877a.b();
        if (!Cdo.e() && !m452i()) {
            jz4.c.m("reconnection successful, reactivate alarm.");
            Cdo.d(true);
        }
        Iterator<am.b> it = am.c().e().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (this.f24885a || !hz.j(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.ae.b(getApplicationContext()).g(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.6
            @Override // java.lang.Runnable
            public void run() {
                XMPushService.this.f24885a = true;
                try {
                    jz4.c.m("try to trigger the wifi digest broadcast.");
                    Object systemService = XMPushService.this.getApplicationContext().getSystemService("MiuiWifiService");
                    if (systemService != null) {
                        com.xiaomi.push.y.n(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m462c() {
        ep epVar = this.f24868a;
        return epVar != null && epVar.D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b, reason: collision with other method in class */
    public void m460b() {
        as.c(getApplicationContext()).u();
        Iterator it = new ArrayList(this.f24883a).iterator();
        while (it.hasNext()) {
            ((z) it.next()).a();
        }
    }

    private fc a(fc fcVar, String str, String str2) {
        am c16 = am.c();
        List<String> g16 = c16.g(str);
        if (g16.isEmpty()) {
            jz4.c.m("open channel should be called first before sending a packet, pkg=" + str);
            return null;
        }
        fcVar.v(str);
        String m3 = fcVar.m();
        if (TextUtils.isEmpty(m3)) {
            m3 = g16.get(0);
            fcVar.p(m3);
        }
        am.b b16 = c16.b(m3, fcVar.q());
        if (!m462c()) {
            jz4.c.m("drop a packet as the channel is not connected, chid=" + m3);
            return null;
        }
        if (b16 != null && b16.f389617m == am.c.binded) {
            if (TextUtils.equals(str2, b16.f389614j)) {
                return fcVar;
            }
            jz4.c.m("invalid session. " + str2);
            return null;
        }
        jz4.c.m("drop a packet as the channel is not opened, chid=" + m3);
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m445a(String str, Intent intent) {
        am.b b16 = am.c().b(str, intent.getStringExtra(com.xiaomi.push.service.r.f389789p));
        boolean z16 = false;
        if (b16 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(com.xiaomi.push.service.r.F);
        String stringExtra2 = intent.getStringExtra(com.xiaomi.push.service.r.f389797x);
        if (!TextUtils.isEmpty(b16.f389614j) && !TextUtils.equals(stringExtra, b16.f389614j)) {
            jz4.c.m("session changed. old session=" + b16.f389614j + ", new session=" + stringExtra + " chid = " + str);
            z16 = true;
        }
        if (stringExtra2.equals(b16.f389613i)) {
            return z16;
        }
        jz4.c.m("security changed. chid = " + str + " sechash = " + com.xiaomi.push.ad.b(stringExtra2));
        return true;
    }

    private am.b a(String str, Intent intent) {
        am.b b16 = am.c().b(str, intent.getStringExtra(com.xiaomi.push.service.r.f389789p));
        if (b16 == null) {
            b16 = new am.b(this);
        }
        b16.f389612h = intent.getStringExtra(com.xiaomi.push.service.r.f389792s);
        b16.f389606b = intent.getStringExtra(com.xiaomi.push.service.r.f389789p);
        b16.f389607c = intent.getStringExtra(com.xiaomi.push.service.r.f389795v);
        b16.f389605a = intent.getStringExtra(com.xiaomi.push.service.r.B);
        b16.f389610f = intent.getStringExtra(com.xiaomi.push.service.r.f389799z);
        b16.f389611g = intent.getStringExtra(com.xiaomi.push.service.r.A);
        b16.f389609e = intent.getBooleanExtra(com.xiaomi.push.service.r.f389798y, false);
        b16.f389613i = intent.getStringExtra(com.xiaomi.push.service.r.f389797x);
        b16.f389614j = intent.getStringExtra(com.xiaomi.push.service.r.F);
        b16.f389608d = intent.getStringExtra(com.xiaomi.push.service.r.f389796w);
        b16.f389615k = this.f24878a;
        b16.h((Messenger) intent.getParcelableExtra(com.xiaomi.push.service.r.J));
        b16.f389616l = getApplicationContext();
        am.c().l(b16);
        return b16;
    }

    public void a(String str, String str2, int i3, String str3, String str4) {
        am.b b16 = am.c().b(str, str2);
        if (b16 != null) {
            a(new s(b16, i3, str4, str3));
        }
        am.c().n(str, str2);
    }

    private void a(String str, int i3) {
        Collection<am.b> f16 = am.c().f(str);
        if (f16 != null) {
            for (am.b bVar : f16) {
                if (bVar != null) {
                    a(new s(bVar, i3, null, null));
                }
            }
        }
        am.c().m(str);
    }

    public void a(j jVar) {
        a(jVar, 0L);
    }

    public void a(j jVar, long j3) {
        try {
            this.f24879a.f(jVar, j3);
        } catch (IllegalStateException e16) {
            jz4.c.m("can't execute job err = " + e16.getMessage());
        }
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e16) {
                jz4.c.q(e16);
            }
        }
    }

    public void a(eb ebVar) {
        ep epVar = this.f24868a;
        if (epVar != null) {
            epVar.w(ebVar);
            return;
        }
        throw new fi("try send msg while connection is null.");
    }

    public void a(eb[] ebVarArr) {
        ep epVar = this.f24868a;
        if (epVar != null) {
            epVar.p(ebVarArr);
            return;
        }
        throw new fi("try send msg while connection is null.");
    }

    public void a(boolean z16) {
        this.f24877a.c(z16);
    }

    public void a(am.b bVar) {
        if (bVar != null) {
            long a16 = bVar.a();
            jz4.c.m("schedule rebind job in " + (a16 / 1000));
            a(new b(bVar), a16);
        }
    }

    public void a(int i3, Exception exc) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("disconnect ");
        sb5.append(hashCode());
        sb5.append(", ");
        ep epVar = this.f24868a;
        sb5.append(epVar == null ? null : Integer.valueOf(epVar.hashCode()));
        jz4.c.m(sb5.toString());
        ep epVar2 = this.f24868a;
        if (epVar2 != null) {
            epVar2.v(i3, exc);
            this.f24868a = null;
        }
        a(7);
        a(4);
        am.c().j(this, i3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m457a() {
        boolean t16 = com.xiaomi.push.au.t(this);
        boolean z16 = am.c().a() > 0;
        boolean z17 = !m461b();
        boolean m451h = m451h();
        boolean z18 = !m450g();
        boolean z19 = t16 && z16 && z17 && m451h && z18;
        if (!z19) {
            jz4.c.D(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(t16), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(m451h), Boolean.valueOf(z18)));
        }
        return z19;
    }

    /* renamed from: a, reason: collision with other method in class */
    public an m455a() {
        return new an();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            com.xiaomi.push.i.a();
            for (int i3 = 100; i3 > 0; i3--) {
                if (com.xiaomi.push.au.v(context)) {
                    jz4.c.m("network connectivity ok.");
                    return true;
                }
                try {
                    LockMethodProxy.sleep(100L);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public ep m454a() {
        return this.f24868a;
    }

    public void a(int i3) {
        this.f24879a.c(i3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m458a(int i3) {
        return this.f24879a.h(i3);
    }

    @Override // com.xiaomi.push.es
    public void a(ep epVar) {
        jz4.c.z("begin to connect...");
        dy.e().a(epVar);
    }

    @Override // com.xiaomi.push.es
    public void a(ep epVar, int i3, Exception exc) {
        dy.e().a(epVar, i3, exc);
        if (m452i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.es
    public void a(ep epVar, Exception exc) {
        dy.e().a(epVar, exc);
        c(false);
        if (m452i()) {
            return;
        }
        a(false);
    }

    public void a(z zVar) {
        synchronized (this.f24883a) {
            this.f24883a.add(zVar);
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m463d() {
        ep epVar = this.f24868a;
        return epVar != null && epVar.B();
    }
}
