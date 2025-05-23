package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes2.dex */
public class p extends BaseThread {

    /* renamed from: a, reason: collision with root package name */
    public Context f37472a;

    /* renamed from: b, reason: collision with root package name */
    public k f37473b;

    public p(Context context, k kVar) {
        this.f37472a = context;
        this.f37473b = kVar;
    }

    public static Intent a(Context context, k kVar) {
        if (kVar == null) {
            return null;
        }
        Intent b16 = q.b(context, kVar.d());
        if (kVar.n() != null) {
            try {
                Intent parseUri = Intent.parseUri(kVar.n(), 0);
                parseUri.setSelector(null);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Intent.parseUri(msg.intentUri, 0), action:");
                sb5.append(parseUri.getAction());
                HMSLog.d("PushSelfShowLog", sb5.toString());
                return q.a(context, kVar.d(), parseUri).booleanValue() ? parseUri : b16;
            } catch (Exception e16) {
                HMSLog.w("PushSelfShowLog", "intentUri error," + e16.toString());
                return b16;
            }
        }
        if (kVar.a() != null) {
            Intent intent = new Intent(kVar.a());
            if (q.a(context, kVar.d(), intent).booleanValue()) {
                b16 = intent;
            }
        }
        b16.setPackage(kVar.d());
        return b16;
    }

    public final boolean b(Context context) {
        if ("cosa".equals(this.f37473b.i())) {
            return a(context);
        }
        return true;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (!b(this.f37472a) || b(this.f37472a, this.f37473b)) {
                return;
            }
            o.a(this.f37472a, this.f37473b);
        } catch (Exception e16) {
            HMSLog.e("PushSelfShowLog", e16.toString());
        }
    }

    public final boolean b(Context context, k kVar) {
        if (!"cosa".equals(kVar.i()) || a(context, kVar) != null) {
            return false;
        }
        HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    public final boolean a(Context context) {
        return q.c(context, this.f37473b.d());
    }
}
