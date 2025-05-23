package com.tencent.smtt.sdk;

import android.util.Log;
import android.util.Pair;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes23.dex */
public class UrlRequestBuilderImpl extends UrlRequest.Builder {

    /* renamed from: a, reason: collision with root package name */
    private static final String f369180a = "UrlRequestBuilderImpl";

    /* renamed from: b, reason: collision with root package name */
    private final String f369181b;

    /* renamed from: c, reason: collision with root package name */
    private final UrlRequest.Callback f369182c;

    /* renamed from: d, reason: collision with root package name */
    private final Executor f369183d;

    /* renamed from: e, reason: collision with root package name */
    private String f369184e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f369186g;

    /* renamed from: i, reason: collision with root package name */
    private String f369188i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f369189j;

    /* renamed from: k, reason: collision with root package name */
    private String f369190k;

    /* renamed from: l, reason: collision with root package name */
    private String f369191l;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<Pair<String, String>> f369185f = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private int f369187h = 3;

    public UrlRequestBuilderImpl(String str, UrlRequest.Callback callback, Executor executor) {
        if (str != null) {
            if (callback != null) {
                if (executor != null) {
                    this.f369181b = str;
                    this.f369182c = callback;
                    this.f369183d = executor;
                    return;
                }
                throw new NullPointerException("Executor is required.");
            }
            throw new NullPointerException("Callback is required.");
        }
        throw new NullPointerException("URL is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest build() throws NullPointerException {
        int i3;
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            DexLoader b16 = a16.c().b();
            Class<?> cls = Integer.TYPE;
            Class<?> cls2 = Boolean.TYPE;
            UrlRequest urlRequest = (UrlRequest) b16.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, cls, UrlRequest.Callback.class, Executor.class, cls2, String.class, ArrayList.class, String.class, byte[].class, String.class, String.class}, this.f369181b, Integer.valueOf(this.f369187h), this.f369182c, this.f369183d, Boolean.valueOf(this.f369186g), this.f369184e, this.f369185f, this.f369188i, this.f369189j, this.f369190k, this.f369191l);
            if (urlRequest == null) {
                i3 = 7;
                urlRequest = (UrlRequest) b16.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", new Class[]{String.class, cls, UrlRequest.Callback.class, Executor.class, cls2, String.class, ArrayList.class, String.class}, this.f369181b, Integer.valueOf(this.f369187h), this.f369182c, this.f369183d, Boolean.valueOf(this.f369186g), this.f369184e, this.f369185f, this.f369188i);
            } else {
                i3 = 7;
            }
            if (urlRequest == null) {
                Class<?>[] clsArr = new Class[i3];
                clsArr[0] = String.class;
                clsArr[1] = cls;
                clsArr[2] = UrlRequest.Callback.class;
                clsArr[3] = Executor.class;
                clsArr[4] = cls2;
                clsArr[5] = String.class;
                clsArr[6] = ArrayList.class;
                Object[] objArr = new Object[i3];
                objArr[0] = this.f369181b;
                objArr[1] = Integer.valueOf(this.f369187h);
                objArr[2] = this.f369182c;
                objArr[3] = this.f369183d;
                objArr[4] = Boolean.valueOf(this.f369186g);
                objArr[5] = this.f369184e;
                objArr[6] = this.f369185f;
                urlRequest = (UrlRequest) b16.invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "GetX5UrlRequestProvider", clsArr, objArr);
            }
            if (urlRequest == null) {
                urlRequest = (UrlRequest) b16.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "UrlRequest_getX5UrlRequestProvider", new Class[]{String.class, cls, UrlRequest.Callback.class, Executor.class, cls2, String.class, ArrayList.class, String.class, byte[].class, String.class, String.class}, this.f369181b, Integer.valueOf(this.f369187h), this.f369182c, this.f369183d, Boolean.valueOf(this.f369186g), this.f369184e, this.f369185f, this.f369188i, this.f369189j, this.f369190k, this.f369191l);
            }
            if (urlRequest != null) {
                return urlRequest;
            }
            throw new NullPointerException("UrlRequest build fail");
        }
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setHttpMethod(String str) {
        if (str != null) {
            this.f369184e = str;
            return this;
        }
        throw new NullPointerException("Method is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBody(String str) {
        if (str != null) {
            this.f369188i = str;
            return this;
        }
        throw new NullPointerException("Body is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequest.Builder setRequestBodyBytes(byte[] bArr) {
        if (bArr != null) {
            this.f369189j = bArr;
            return this;
        }
        throw new NullPointerException("Body is required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 != null) {
            if ("Accept-Encoding".equalsIgnoreCase(str)) {
                Log.w(f369180a, "It's not necessary to set Accept-Encoding on requests - x5-request will do this automatically for you, and setting it yourself has no effect.", new Exception());
                return this;
            }
            this.f369185f.add(Pair.create(str, str2));
            return this;
        }
        throw new NullPointerException("Invalid header value.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.f369186g = true;
        return this;
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setDns(String str, String str2) {
        if (str != null && str2 != null) {
            this.f369190k = str;
            this.f369191l = str2;
            try {
                p a16 = p.a();
                if (a16 != null && a16.b()) {
                    a16.c().b().invokeStaticMethod("com.tencent.smtt.net.X5UrlRequestProvider", "setDns", new Class[]{String.class, String.class}, this.f369190k, this.f369191l);
                }
            } catch (Exception unused) {
            }
            return this;
        }
        throw new NullPointerException("host and address are required.");
    }

    @Override // com.tencent.smtt.export.external.interfaces.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int i3) {
        this.f369187h = i3;
        return this;
    }
}
