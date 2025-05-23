package com.vivo.push.b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class p extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f387588a;

    /* renamed from: b, reason: collision with root package name */
    private String f387589b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f387590c;

    /* renamed from: d, reason: collision with root package name */
    private long f387591d;

    /* renamed from: e, reason: collision with root package name */
    private InsideNotificationItem f387592e;

    /* renamed from: f, reason: collision with root package name */
    private String f387593f;

    /* renamed from: g, reason: collision with root package name */
    private String f387594g;

    /* renamed from: h, reason: collision with root package name */
    private Uri f387595h;

    /* renamed from: i, reason: collision with root package name */
    private String f387596i;

    /* renamed from: j, reason: collision with root package name */
    private Bundle f387597j;

    public p(String str, long j3, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f387588a = str;
        this.f387591d = j3;
        this.f387592e = insideNotificationItem;
    }

    public final void a(Uri uri) {
        this.f387595h = uri;
    }

    public final void b(String str) {
        this.f387593f = str;
    }

    public final void c(String str) {
        this.f387594g = str;
    }

    public final String d() {
        return this.f387588a;
    }

    public final long e() {
        return this.f387591d;
    }

    public final InsideNotificationItem f() {
        return this.f387592e;
    }

    public final String g() {
        return this.f387593f;
    }

    public final String h() {
        return this.f387594g;
    }

    public final String i() {
        return this.f387596i;
    }

    public final Uri j() {
        return this.f387595h;
    }

    public final Bundle k() {
        if (this.f387597j == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.f387597j);
        try {
            bundle.remove("command_type");
            bundle.remove("security_avoid_pull");
            bundle.remove("security_avoid_pull_rsa");
            bundle.remove("security_avoid_rsa_public_key");
            bundle.remove("security_avoid_rsa_public_key");
            bundle.remove("notify_action");
            bundle.remove("notify_componet_pkg");
            bundle.remove("notify_componet_class_name");
            bundle.remove("notification_v1");
            bundle.remove("command");
            bundle.remove("package_name");
            bundle.remove("method");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return bundle;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    private static Uri e(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("package_name", this.f387588a);
        dVar.a("notify_id", this.f387591d);
        dVar.a("notification_v1", com.vivo.push.util.v.b(this.f387592e));
        dVar.a("open_pkg_name", this.f387589b);
        dVar.a("open_pkg_name_encode", this.f387590c);
        dVar.a("notify_action", this.f387593f);
        dVar.a("notify_componet_pkg", this.f387594g);
        dVar.a("notify_componet_class_name", this.f387596i);
        Uri uri = this.f387595h;
        if (uri != null) {
            dVar.a("notify_uri_data", uri.toString());
        }
    }

    public final void d(String str) {
        this.f387596i = str;
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.f387588a = dVar.a("package_name");
        this.f387591d = dVar.b("notify_id", -1L);
        this.f387589b = dVar.a("open_pkg_name");
        this.f387590c = dVar.b("open_pkg_name_encode");
        this.f387593f = dVar.a("notify_action");
        this.f387594g = dVar.a("notify_componet_pkg");
        this.f387596i = dVar.a("notify_componet_class_name");
        String a16 = dVar.a("notification_v1");
        if (!TextUtils.isEmpty(a16)) {
            this.f387592e = com.vivo.push.util.v.a(a16);
        }
        InsideNotificationItem insideNotificationItem = this.f387592e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f387591d);
        }
        String a17 = dVar.a("notify_uri_data");
        if (!TextUtils.isEmpty(a17)) {
            this.f387595h = e(a17);
        }
        this.f387597j = dVar.b();
    }

    public p() {
        super(5);
    }
}
