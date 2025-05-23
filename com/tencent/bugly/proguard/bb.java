package com.tencent.bugly.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bb extends BroadcastReceiver {

    /* renamed from: d, reason: collision with root package name */
    private static bb f98181d;

    /* renamed from: b, reason: collision with root package name */
    private Context f98183b;

    /* renamed from: c, reason: collision with root package name */
    private String f98184c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f98185e = true;

    /* renamed from: a, reason: collision with root package name */
    private IntentFilter f98182a = new IntentFilter();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
        }
    }

    public static synchronized bb a() {
        bb bbVar;
        synchronized (bb.class) {
            if (f98181d == null) {
                f98181d = new bb();
            }
            bbVar = f98181d;
        }
        return bbVar;
    }

    public final synchronized void a(String str) {
        if (!this.f98182a.hasAction(str)) {
            this.f98182a.addAction(str);
        }
        av.c("add action %s", str);
    }

    public final synchronized void a(Context context) {
        this.f98183b = context;
        ba.a(new Runnable() { // from class: com.tencent.bugly.proguard.bb.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    av.a(bb.f98181d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        bb.this.f98183b.registerReceiver(bb.f98181d, bb.this.f98182a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f98185e) {
                    this.f98185e = false;
                    return true;
                }
                String b16 = aj.b(this.f98183b);
                av.c("is Connect BC ".concat(String.valueOf(b16)), new Object[0]);
                av.a("network %s changed to %s", this.f98184c, String.valueOf(b16));
                if (b16 == null) {
                    this.f98184c = null;
                    return true;
                }
                String str = this.f98184c;
                this.f98184c = b16;
                long currentTimeMillis = System.currentTimeMillis();
                ak a16 = ak.a();
                aq a17 = aq.a();
                ai a18 = ai.a(context);
                if (a16 != null && a17 != null && a18 != null) {
                    if (!b16.equals(str) && currentTimeMillis - a17.a(be.f98207a) > 30000) {
                        av.a("try to upload crash on network changed.", new Object[0]);
                        be a19 = be.a();
                        if (a19 != null) {
                            a19.a(0L, false);
                        }
                        av.a("try to upload userinfo on network changed.", new Object[0]);
                        t.f98555b.c();
                    }
                    return true;
                }
                av.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
