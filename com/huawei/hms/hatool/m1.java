package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public class m1 {

    /* renamed from: b, reason: collision with root package name */
    private static m1 f37179b = new m1();

    /* renamed from: a, reason: collision with root package name */
    private a f37180a = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        String f37181a;

        /* renamed from: b, reason: collision with root package name */
        String f37182b;

        /* renamed from: c, reason: collision with root package name */
        long f37183c = 0;

        a() {
        }

        void a(long j3) {
            m1.this.f37180a.f37183c = j3;
        }

        void b(String str) {
            m1.this.f37180a.f37181a = str;
        }

        void a(String str) {
            m1.this.f37180a.f37182b = str;
        }
    }

    public static m1 d() {
        return f37179b;
    }

    public long b() {
        return this.f37180a.f37183c;
    }

    public String c() {
        return this.f37180a.f37181a;
    }

    public String a() {
        return this.f37180a.f37182b;
    }

    public void a(String str, String str2) {
        long b16 = b();
        String b17 = w0.b(str, str2);
        if (b17 == null || b17.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (b16 == 0) {
            b16 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - b16 <= 43200000) {
            return;
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String a16 = h0.a(b17, generateSecureRandomStr);
        this.f37180a.a(b16);
        this.f37180a.b(generateSecureRandomStr);
        this.f37180a.a(a16);
    }
}
