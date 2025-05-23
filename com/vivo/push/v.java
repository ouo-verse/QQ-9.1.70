package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private int f387935a;

    /* renamed from: b, reason: collision with root package name */
    private String f387936b;

    public v(int i3) {
        this.f387935a = -1;
        if (i3 >= 0) {
            this.f387935a = i3;
            return;
        }
        throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
    }

    private void e(d dVar) {
        dVar.a("command", this.f387935a);
        dVar.a("client_pkgname", this.f387936b);
        c(dVar);
    }

    public final String a() {
        return this.f387936b;
    }

    public final int b() {
        return this.f387935a;
    }

    protected abstract void c(d dVar);

    public boolean c() {
        return false;
    }

    protected abstract void d(d dVar);

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.f387936b = str;
    }

    public final void b(Intent intent) {
        d a16 = d.a(intent);
        if (a16 == null) {
            com.vivo.push.util.u.b("PushCommand", "bundleWapper is null");
            return;
        }
        a16.a("method", this.f387935a);
        e(a16);
        Bundle b16 = a16.b();
        if (b16 != null) {
            intent.putExtras(b16);
        }
    }

    public final void a(Intent intent) {
        d a16 = d.a(intent);
        if (a16 == null) {
            com.vivo.push.util.u.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a16);
        Bundle b16 = a16.b();
        if (b16 != null) {
            intent.putExtras(b16);
        }
    }

    public final void a(d dVar) {
        String a16 = x.a(this.f387935a);
        if (a16 == null) {
            a16 = "";
        }
        dVar.a("method", a16);
        e(dVar);
    }

    public final void b(d dVar) {
        String a16 = dVar.a();
        if (!TextUtils.isEmpty(a16)) {
            this.f387936b = a16;
        } else {
            this.f387936b = dVar.a("client_pkgname");
        }
        d(dVar);
    }
}
