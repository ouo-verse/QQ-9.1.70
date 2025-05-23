package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public class o0 {

    /* renamed from: c, reason: collision with root package name */
    private static o0 f37188c;

    /* renamed from: a, reason: collision with root package name */
    private String f37189a;

    /* renamed from: b, reason: collision with root package name */
    private String f37190b;

    private String b(String str) {
        return f() ? AesGcmKS.encrypt("analytics_keystore", str) : n.b(str, e());
    }

    private String c() {
        String a16 = d.a(q0.i(), "Privacy_MY", "PrivacyData", "");
        if (!TextUtils.isEmpty(a16)) {
            return a(a16);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        c(b(generateSecureRandomStr));
        return generateSecureRandomStr;
    }

    public static o0 d() {
        if (f37188c == null) {
            g();
        }
        return f37188c;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f37190b)) {
            this.f37190b = new x().a();
        }
        return this.f37190b;
    }

    private boolean f() {
        return true;
    }

    private static synchronized void g() {
        synchronized (o0.class) {
            if (f37188c == null) {
                f37188c = new o0();
            }
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f37189a)) {
            this.f37189a = c();
        }
        return this.f37189a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
    
        if (f() != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str) {
        String decrypt = f() ? AesGcmKS.decrypt("analytics_keystore", str) : "";
        if (TextUtils.isEmpty(decrypt)) {
            v.c("hmsSdk", "deCrypt work key first");
            decrypt = n.a(str, e());
            if (TextUtils.isEmpty(decrypt)) {
                decrypt = EncryptUtil.generateSecureRandomStr(16);
                c(b(decrypt));
            } else if (f()) {
                c(b(decrypt));
                x.c();
            }
        }
        return decrypt;
    }

    private boolean c(String str) {
        v.c("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            v.c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        d.b(q0.i(), "Privacy_MY", "PrivacyData", str);
        d.b(q0.i(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    public void b() {
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        if (c(b(generateSecureRandomStr))) {
            this.f37189a = generateSecureRandomStr;
        }
    }
}
