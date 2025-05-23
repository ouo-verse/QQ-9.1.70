package com.tencent.beacon.base.net.call;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.base.net.BodyType;
import com.tencent.beacon.base.net.HttpMethod;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f77753a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpMethod f77754b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, String> f77755c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, String> f77756d;

    /* renamed from: e, reason: collision with root package name */
    private final String f77757e;

    /* renamed from: f, reason: collision with root package name */
    private BodyType f77758f;

    /* renamed from: g, reason: collision with root package name */
    private String f77759g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f77760h;

    /* synthetic */ e(HttpMethod httpMethod, String str, Map map, BodyType bodyType, String str2, Map map2, byte[] bArr, String str3, d dVar) {
        this(httpMethod, str, map, bodyType, str2, map2, bArr, str3);
    }

    public static a b() {
        return new a();
    }

    public BodyType a() {
        return this.f77758f;
    }

    public byte[] c() {
        return this.f77760h;
    }

    public Map<String, String> d() {
        return this.f77756d;
    }

    public Map<String, String> e() {
        return this.f77755c;
    }

    public String f() {
        return this.f77759g;
    }

    public HttpMethod g() {
        return this.f77754b;
    }

    public String h() {
        return this.f77757e;
    }

    public String i() {
        return this.f77753a;
    }

    public String toString() {
        return "HttpRequestEntity{url='" + this.f77753a + "', method=" + this.f77754b + ", headers=" + this.f77755c + ", formParams=" + this.f77756d + ", bodyType=" + this.f77758f + ", json='" + this.f77759g + "', tag='" + this.f77757e + "'}";
    }

    e(HttpMethod httpMethod, String str, Map<String, String> map, BodyType bodyType, String str2, Map<String, String> map2, byte[] bArr, String str3) {
        this.f77754b = httpMethod;
        this.f77753a = str;
        this.f77755c = map;
        this.f77758f = bodyType;
        this.f77759g = str2;
        this.f77756d = map2;
        this.f77760h = bArr;
        this.f77757e = str3;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private HttpMethod f77761a;

        /* renamed from: b, reason: collision with root package name */
        private String f77762b;

        /* renamed from: c, reason: collision with root package name */
        private String f77763c;

        /* renamed from: d, reason: collision with root package name */
        private Map<String, String> f77764d = new HashMap(3);

        /* renamed from: e, reason: collision with root package name */
        private Map<String, String> f77765e = new HashMap(3);

        /* renamed from: f, reason: collision with root package name */
        private String f77766f;

        /* renamed from: g, reason: collision with root package name */
        private BodyType f77767g;

        /* renamed from: h, reason: collision with root package name */
        private byte[] f77768h;

        private void a(BodyType bodyType) {
            if (this.f77767g == null) {
                this.f77767g = bodyType;
            }
            if (this.f77767g != bodyType) {
                throw new IllegalStateException("bodyType already set!");
            }
        }

        public a b(@NonNull String str) {
            this.f77762b = str;
            return this;
        }

        public a a(HttpMethod httpMethod) {
            this.f77761a = httpMethod;
            return this;
        }

        public a a(@NonNull Map<String, String> map) {
            a(BodyType.FORM);
            this.f77764d.putAll(map);
            return this;
        }

        public a a(String str) {
            this.f77763c = str;
            return this;
        }

        public e a() {
            if (this.f77761a != null) {
                if (!TextUtils.isEmpty(this.f77762b)) {
                    BodyType bodyType = this.f77767g;
                    if (bodyType != null) {
                        int i3 = d.f77752a[bodyType.ordinal()];
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3 && this.f77768h == null) {
                                    throw new NullPointerException("data request body == null");
                                }
                            } else if (this.f77764d.isEmpty()) {
                                throw new NullPointerException("form request body == null");
                            }
                        } else if (TextUtils.isEmpty(this.f77766f)) {
                            throw new NullPointerException("json request body == null");
                        }
                        return new e(this.f77761a, this.f77762b, this.f77765e, this.f77767g, this.f77766f, this.f77764d, this.f77768h, this.f77763c, null);
                    }
                    throw new NullPointerException("bodyType == null");
                }
                throw new NullPointerException("request url == null!");
            }
            throw new NullPointerException("request method == null");
        }
    }
}
