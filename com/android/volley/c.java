package com.android.volley;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f31317a;

        /* renamed from: b, reason: collision with root package name */
        public String f31318b;

        /* renamed from: c, reason: collision with root package name */
        public long f31319c;

        /* renamed from: d, reason: collision with root package name */
        public long f31320d;

        /* renamed from: e, reason: collision with root package name */
        public long f31321e;

        /* renamed from: f, reason: collision with root package name */
        public long f31322f;

        /* renamed from: g, reason: collision with root package name */
        public Map<String, String> f31323g = Collections.emptyMap();

        /* renamed from: h, reason: collision with root package name */
        public List<e> f31324h;

        public boolean a() {
            return b(System.currentTimeMillis());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(long j3) {
            if (this.f31321e < j3) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(long j3) {
            if (this.f31322f < j3) {
                return true;
            }
            return false;
        }
    }

    void a(String str, boolean z16);

    void b(String str, a aVar);

    @Nullable
    a get(String str);

    void initialize();
}
