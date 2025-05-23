package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    private static j f37138b;

    /* renamed from: a, reason: collision with root package name */
    private Context f37139a;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class a extends e0 {

        /* renamed from: a, reason: collision with root package name */
        String f37140a;

        /* renamed from: b, reason: collision with root package name */
        String f37141b;

        public a(String str, String str2) {
            this.f37140a = str;
            this.f37141b = str2;
        }

        @Override // com.huawei.hms.hatool.e0
        public String a() {
            return z.d(this.f37140a, this.f37141b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String b() {
            return z.g(this.f37140a, this.f37141b);
        }

        @Override // com.huawei.hms.hatool.e0
        public String c() {
            return z.j(this.f37140a, this.f37141b);
        }

        @Override // com.huawei.hms.hatool.e0
        public int d() {
            int i3;
            int i16 = 0;
            if (z.k(this.f37140a, this.f37141b)) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            int i17 = i3 | 0;
            if (z.e(this.f37140a, this.f37141b)) {
                i16 = 2;
            }
            return i17 | i16 | (z.h(this.f37140a, this.f37141b) ? 1 : 0);
        }

        @Override // com.huawei.hms.hatool.e0
        public String a(String str) {
            return SHA.sha256Encrypt(str);
        }
    }

    public static j a() {
        j jVar;
        synchronized (j.class) {
            if (f37138b == null) {
                f37138b = new j();
            }
            jVar = f37138b;
        }
        return jVar;
    }

    public String b(String str, String str2) {
        return i0.b(this.f37139a, str, str2);
    }

    public i c(String str, String str2) {
        return new a(str, str2).a(this.f37139a);
    }

    public String d(String str, String str2) {
        return f1.b(str, str2);
    }

    public Pair<String, String> e(String str, String str2) {
        if (z.f(str, str2)) {
            String p16 = s.c().b().p();
            String q16 = s.c().b().q();
            if (!TextUtils.isEmpty(p16) && !TextUtils.isEmpty(q16)) {
                return new Pair<>(p16, q16);
            }
            Pair<String, String> e16 = x0.e(this.f37139a);
            s.c().b().k((String) e16.first);
            s.c().b().l((String) e16.second);
            return e16;
        }
        return new Pair<>("", "");
    }

    public String f(String str, String str2) {
        return f1.a(str, str2);
    }

    public String a(String str, String str2) {
        return i0.a(this.f37139a, str, str2);
    }

    public String a(boolean z16) {
        if (!z16) {
            return "";
        }
        String e16 = q0.e();
        if (TextUtils.isEmpty(e16)) {
            e16 = d.a(this.f37139a, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(e16)) {
                e16 = UUID.randomUUID().toString().replace("-", "");
                d.b(this.f37139a, "global_v2", "uuid", e16);
            }
            q0.h(e16);
        }
        return e16;
    }

    public void a(Context context) {
        if (this.f37139a == null) {
            this.f37139a = context;
        }
    }
}
