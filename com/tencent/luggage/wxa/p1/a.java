package com.tencent.luggage.wxa.p1;

import android.os.Build;
import com.tencent.luggage.wxa.n3.p;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.y8.c;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f137108a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f137109b = "android-" + Build.VERSION.SDK_INT;

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f137110c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.p1.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6568a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final C6568a f137111a = new C6568a();

        public C6568a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final OkHttpClient invoke() {
            return p.get();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(C6568a.f137111a);
        f137110c = lazy;
    }

    public final OkHttpClient a() {
        Object value = f137110c.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sRawOkHttpClient>(...)");
        return (OkHttpClient) value;
    }

    public final void a(int i3, String uin, int i16, byte[] content, Map params) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(params, "params");
        int length = content.length;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("appengine#$()%d%d", Arrays.copyOf(new Object[]{Integer.valueOf(i16), Integer.valueOf(length)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        byte[] bytes = format.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String a16 = c.a(bytes);
        Intrinsics.checkNotNullExpressionValue(a16, "getMessageDigest(beforeMd5.toByteArray())");
        String lowerCase = a16.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("http://");
        sb5.append("aesupport.weixin.qq.com");
        sb5.append("/cgi-bin/mmsupport-bin/aestackreport");
        sb5.append("?version=");
        sb5.append(Integer.toHexString(i16));
        sb5.append("&devicetype=");
        sb5.append(f137109b);
        sb5.append("&filelength=");
        sb5.append(length);
        sb5.append("&sum=");
        sb5.append(lowerCase);
        sb5.append("&uin=");
        sb5.append(uin);
        if (i3 >= 0) {
            sb5.append("&productid=");
            sb5.append(i3);
        }
        for (Map.Entry entry : params.entrySet()) {
            sb5.append(Typography.amp + ((String) entry.getKey()) + '=' + ((String) entry.getValue()));
        }
        try {
            b bVar = b.f137112a;
            byte[] a17 = bVar.a(content);
            com.tencent.luggage.wxa.dn.b bVar2 = new com.tencent.luggage.wxa.dn.b();
            byte[] bytes2 = lowerCase.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            bVar.a(bVar2, a17, bytes2);
            byte[] bArr = bVar2.f124396a;
            if (bArr != null) {
                w.d("Luggage.CgiAEStackReport", "http post, content length = " + bArr.length);
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
                a(sb6, bArr);
            }
        } catch (Exception e16) {
            w.h("Luggage.CgiAEStackReport", "post http reqeust fail", e16);
        }
    }

    public final void a(String str, byte[] bArr) {
        Request build = new Request.Builder().url(str).post(RequestBody.create(MediaType.parse("binary/octet-stream"), bArr)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .u\u2026nt))\n            .build()");
        Response execute = a().newCall(build).execute();
        int code = execute.code();
        if (code != 200) {
            w.f("Luggage.CgiAEStackReport", "rsp error, code = " + code);
        }
        ResponseBody body = execute.body();
        Intrinsics.checkNotNull(body);
        w.d("Luggage.CgiAEStackReport", "http post with HttpClient, rsp code = " + code + ", content = " + body.string());
    }
}
