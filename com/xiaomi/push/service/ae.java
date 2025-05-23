package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.util.Base64;
import com.xiaomi.push.af;
import com.xiaomi.push.cn;
import com.xiaomi.push.cp;
import com.xiaomi.push.fn;
import com.xiaomi.push.ge;
import com.xiaomi.push.ii;
import com.xiaomi.push.in;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ae {

    /* renamed from: d, reason: collision with root package name */
    private static String f389569d;

    /* renamed from: e, reason: collision with root package name */
    private static ae f389570e = new ae();

    /* renamed from: a, reason: collision with root package name */
    private List<b> f389571a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private cn f389572b;

    /* renamed from: c, reason: collision with root package name */
    private af.c f389573c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a extends af.c {

        /* renamed from: a, reason: collision with root package name */
        boolean f389574a = false;

        a() {
        }

        @Override // com.xiaomi.push.af.c
        public void b() {
            try {
                cn n3 = cn.n(Base64.decode(com.xiaomi.push.bd.f(ii.b(), "https://resolver.msg.xiaomi.net/psc/?t=a", null), 10));
                if (n3 != null) {
                    ae.this.f389572b = n3;
                    this.f389574a = true;
                    ae.this.p();
                }
            } catch (Exception e16) {
                jz4.c.m("fetch config failure: " + e16.getMessage());
            }
        }

        @Override // com.xiaomi.push.af.c
        public void c() {
            b[] bVarArr;
            ae.this.f389573c = null;
            if (this.f389574a) {
                synchronized (ae.this) {
                    bVarArr = (b[]) ae.this.f389571a.toArray(new b[ae.this.f389571a.size()]);
                }
                for (b bVar : bVarArr) {
                    bVar.b(ae.this.f389572b);
                }
            }
        }
    }

    ae() {
    }

    public static ae f() {
        return f389570e;
    }

    public static synchronized String g() {
        String str;
        synchronized (ae.class) {
            if (f389569d == null) {
                SharedPreferences sharedPreferences = ii.b().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                f389569d = string;
                if (string == null) {
                    String h16 = ge.h(ii.b(), false);
                    f389569d = h16;
                    if (h16 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f389569d).commit();
                    }
                }
            }
            str = f389569d;
        }
        return str;
    }

    private void m() {
        if (this.f389572b == null) {
            o();
        }
    }

    private void n() {
        if (this.f389573c != null) {
            return;
        }
        a aVar = new a();
        this.f389573c = aVar;
        fn.a(aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o() {
        BufferedInputStream bufferedInputStream;
        Throwable th5;
        Exception e16;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(ii.b().openFileInput("XMCloudCfg"));
            } catch (Exception e17) {
                bufferedInputStream = null;
                e16 = e17;
            } catch (Throwable th6) {
                bufferedInputStream = null;
                th5 = th6;
                in.b(bufferedInputStream);
                throw th5;
            }
            try {
                this.f389572b = cn.r(com.xiaomi.push.ac.f(bufferedInputStream));
                bufferedInputStream.close();
            } catch (Exception e18) {
                e16 = e18;
                jz4.c.m("load config failure: " + e16.getMessage());
                in.b(bufferedInputStream);
                if (this.f389572b != null) {
                }
            }
            in.b(bufferedInputStream);
            if (this.f389572b != null) {
                this.f389572b = new cn();
            }
        } catch (Throwable th7) {
            th5 = th7;
            in.b(bufferedInputStream);
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        try {
            if (this.f389572b != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(ii.b().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c n3 = com.xiaomi.push.c.n(bufferedOutputStream);
                this.f389572b.e(n3);
                n3.q();
                bufferedOutputStream.close();
            }
        } catch (Exception e16) {
            jz4.c.m("save config failure: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        m();
        cn cnVar = this.f389572b;
        if (cnVar != null) {
            return cnVar.u();
        }
        return 0;
    }

    public cn c() {
        m();
        return this.f389572b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void i() {
        this.f389571a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(cp cpVar) {
        b[] bVarArr;
        if (cpVar.u() && cpVar.t() > a()) {
            n();
        }
        synchronized (this) {
            List<b> list = this.f389571a;
            bVarArr = (b[]) list.toArray(new b[list.size()]);
        }
        for (b bVar : bVarArr) {
            bVar.c(cpVar);
        }
    }

    public synchronized void k(b bVar) {
        this.f389571a.add(bVar);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class b {
        public void b(cn cnVar) {
        }

        public void c(cp cpVar) {
        }
    }
}
