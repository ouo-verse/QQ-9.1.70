package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f387624a;

    /* renamed from: b, reason: collision with root package name */
    private String f387625b;

    /* renamed from: c, reason: collision with root package name */
    private String f387626c;

    public d(String str, String str2, Bundle bundle) {
        this.f387625b = str;
        this.f387626c = str2;
        this.f387624a = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d a(Intent intent) {
        String str;
        if (intent == null) {
            com.vivo.push.util.u.a("BundleWapper", "create error : intent is null");
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            str = extras.getString("client_pkgname");
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
            com.vivo.push.util.u.b("BundleWapper", "create warning: pkgName is null");
        }
        String str2 = intent.getPackage();
        if (TextUtils.isEmpty(str2)) {
            String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : null;
            if (TextUtils.isEmpty(packageName)) {
                com.vivo.push.util.u.b("BundleWapper", "create warning: targetPkgName is null");
            }
            str2 = packageName;
        }
        return new d(str, str2, extras);
    }

    public final int b(String str, int i3) {
        Bundle bundle = this.f387624a;
        return bundle == null ? i3 : bundle.getInt(str, i3);
    }

    public final ArrayList<String> c(String str) {
        Bundle bundle = this.f387624a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(str);
    }

    public final Serializable d(String str) {
        Bundle bundle = this.f387624a;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    public final boolean e(String str) {
        Bundle bundle = this.f387624a;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(str, false);
    }

    public final byte[] b(String str) {
        Bundle bundle = this.f387624a;
        if (bundle == null) {
            return null;
        }
        return bundle.getByteArray(str);
    }

    public final long b(String str, long j3) {
        Bundle bundle = this.f387624a;
        return bundle == null ? j3 : bundle.getLong(str, j3);
    }

    public final Bundle b() {
        return this.f387624a;
    }

    public final void a(String str, int i3) {
        if (this.f387624a == null) {
            this.f387624a = new Bundle();
        }
        this.f387624a.putInt(str, i3);
    }

    public final void a(String str, long j3) {
        if (this.f387624a == null) {
            this.f387624a = new Bundle();
        }
        this.f387624a.putLong(str, j3);
    }

    public final void a(String str, String str2) {
        if (this.f387624a == null) {
            this.f387624a = new Bundle();
        }
        this.f387624a.putString(str, str2);
    }

    public final void a(String str, byte[] bArr) {
        if (this.f387624a == null) {
            this.f387624a = new Bundle();
        }
        this.f387624a.putByteArray(str, bArr);
    }

    public final void a(String str, Serializable serializable) {
        if (this.f387624a == null) {
            this.f387624a = new Bundle();
        }
        this.f387624a.putSerializable(str, serializable);
    }

    public final void a(String str, boolean z16) {
        if (this.f387624a == null) {
            this.f387624a = new Bundle();
        }
        this.f387624a.putBoolean(str, z16);
    }

    public final void a(String str, ArrayList<String> arrayList) {
        if (this.f387624a == null) {
            this.f387624a = new Bundle();
        }
        this.f387624a.putStringArrayList(str, arrayList);
    }

    public final String a(String str) {
        Bundle bundle = this.f387624a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public final String a() {
        return this.f387625b;
    }
}
