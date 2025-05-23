package com.vivo.push.sdk;

import android.content.Intent;
import android.os.Message;
import com.vivo.push.ab;
import com.vivo.push.util.g;
import com.vivo.push.util.u;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a extends ab {

    /* renamed from: c, reason: collision with root package name */
    private static a f387846c;

    /* renamed from: d, reason: collision with root package name */
    private String f387847d = "";

    a() {
    }

    public final String b() {
        return this.f387847d;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f387846c == null) {
                f387846c = new a();
            }
            aVar = f387846c;
        }
        return aVar;
    }

    @Override // com.vivo.push.ab
    public final void b(Message message) {
        Intent intent = (Intent) message.obj;
        if (intent != null && this.f387552a != null) {
            com.vivo.push.restructure.a.b bVar = new com.vivo.push.restructure.a.b(intent);
            try {
                u.d("CommandWorker", "received msg : ".concat(String.valueOf(bVar.a())));
                g.a().execute(new b(this, bVar));
                return;
            } catch (Exception e16) {
                u.a("CommandWorker", "handle message err : " + e16.getMessage());
                return;
            }
        }
        u.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.f387552a);
    }

    public final void a(String str) {
        this.f387847d = str;
    }

    public final void a(Intent intent) {
        if (intent != null && this.f387552a != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            a(obtain);
        } else {
            u.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.f387552a);
        }
    }
}
