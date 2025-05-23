package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f37437a = {"url", "app", "cosa", "rp"};

    /* renamed from: b, reason: collision with root package name */
    public Context f37438b;

    /* renamed from: c, reason: collision with root package name */
    public k f37439c;

    public j(Context context, k kVar) {
        this.f37438b = context;
        this.f37439c = kVar;
    }

    public static boolean a(String str) {
        for (String str2 : f37437a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00c0, code lost:
    
        if (com.huawei.hms.push.q.a(r6.f37438b, r6.f37439c.d(), r2).booleanValue() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
    
        if (r3 != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cc A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x0020, B:17:0x00c8, B:20:0x00cc, B:22:0x00d7, B:23:0x00e2, B:25:0x00dd, B:10:0x009d, B:12:0x00a5, B:33:0x0083, B:35:0x008b, B:27:0x0048, B:29:0x005e), top: B:2:0x0009, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        Intent parseUri;
        HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("enter launchExistApp cosa, appPackageName =");
            sb5.append(this.f37439c.d());
            sb5.append(",and msg.intentUri is ");
            sb5.append(this.f37439c.n());
            HMSLog.i("PushSelfShowLog", sb5.toString());
            Intent b16 = q.b(this.f37438b, this.f37439c.d());
            boolean z16 = false;
            if (this.f37439c.n() != null) {
                try {
                    parseUri = Intent.parseUri(this.f37439c.n(), 0);
                    parseUri.setSelector(null);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Intent.parseUri(msg.intentUri, 0), action:");
                    sb6.append(parseUri.getAction());
                    HMSLog.i("PushSelfShowLog", sb6.toString());
                    z16 = q.a(this.f37438b, this.f37439c.d(), parseUri).booleanValue();
                } catch (Exception e16) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("intentUri error.");
                    sb7.append(e16.toString());
                    HMSLog.w("PushSelfShowLog", sb7.toString());
                }
            } else {
                if (this.f37439c.a() != null) {
                    parseUri = new Intent(this.f37439c.a());
                }
                if (b16 != null) {
                    HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
                    return;
                }
                b16.setPackage(this.f37439c.d());
                if (z16) {
                    b16.addFlags(268435456);
                } else {
                    b16.setFlags(805437440);
                }
                this.f37438b.startActivity(b16);
                return;
            }
            b16 = parseUri;
            if (b16 != null) {
            }
        } catch (Exception e17) {
            HMSLog.e("PushSelfShowLog", "launch Cosa App exception." + e17.toString());
        }
    }

    public void c() {
        k kVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.f37438b != null && (kVar = this.f37439c) != null) {
            if ("app".equals(kVar.i())) {
                a();
                return;
            }
            if ("cosa".equals(this.f37439c.i())) {
                b();
                return;
            }
            if ("rp".equals(this.f37439c.i())) {
                HMSLog.w("PushSelfShowLog", this.f37439c.i() + " not support rich message.");
                return;
            }
            if ("url".equals(this.f37439c.i())) {
                HMSLog.w("PushSelfShowLog", this.f37439c.i() + " not support URL.");
                return;
            }
            HMSLog.d("PushSelfShowLog", this.f37439c.i() + " is not exist in hShowType");
            return;
        }
        HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
    }

    public final void a() {
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("enter launchApp, appPackageName =");
            sb5.append(this.f37439c.d());
            HMSLog.i("PushSelfShowLog", sb5.toString());
            if (q.c(this.f37438b, this.f37439c.d())) {
                b();
            }
        } catch (Exception e16) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e16.toString());
        }
    }
}
