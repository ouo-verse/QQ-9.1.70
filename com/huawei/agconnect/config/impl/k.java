package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
class k extends j {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f36500a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f36501b;

    /* renamed from: c, reason: collision with root package name */
    private g f36502c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f36503d;

    /* renamed from: e, reason: collision with root package name */
    private final String f36504e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, String str) {
        super(context, str);
        this.f36500a = new HashMap();
        this.f36501b = new Object();
        this.f36503d = true;
        this.f36504e = str;
        try {
            String a16 = a("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138");
            String a17 = a("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C");
            String a18 = a("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B");
            String a19 = a("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD");
            if (a16 != null && a17 != null && a18 != null && a19 != null) {
                this.f36502c = new f(a16, a17, a18, a19);
            } else {
                this.f36503d = false;
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("SecurityResourcesReader", "Exception when reading the 'K&I' for 'Config'.");
            this.f36502c = null;
        }
    }

    private String a(String str) {
        return super.a(str, null);
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=" + this.f36503d + '}';
    }

    @Override // com.huawei.agconnect.config.impl.j, com.huawei.agconnect.config.impl.d
    public String a(String str, String str2) {
        if (!this.f36503d) {
            String a16 = a(str);
            return a16 != null ? a16 : str2;
        }
        if (this.f36502c == null) {
            Log.e("SecurityResourcesReader", "KEY is null return def directly");
            return str2;
        }
        synchronized (this.f36501b) {
            String str3 = this.f36500a.get(str);
            if (str3 != null) {
                return str3;
            }
            String a17 = a(str);
            if (a17 == null) {
                return str2;
            }
            String a18 = this.f36502c.a(a17, str2);
            this.f36500a.put(str, a18);
            return a18;
        }
    }
}
