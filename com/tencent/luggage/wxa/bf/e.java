package com.tencent.luggage.wxa.bf;

import android.util.Base64;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.CharEncoding;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface e {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f122535a = Charset.forName("UTF-8");

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final Map f122536a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bf.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6052a implements e {

            /* renamed from: b, reason: collision with root package name */
            public final Charset f122537b = Charset.forName("US-ASCII");

            @Override // com.tencent.luggage.wxa.bf.e
            public String a(ByteBuffer byteBuffer) {
                return new String(com.tencent.luggage.wxa.tk.c.a(byteBuffer), this.f122537b);
            }

            @Override // com.tencent.luggage.wxa.bf.e
            public ByteBuffer a(String str) {
                return ByteBuffer.wrap(str.getBytes(this.f122537b));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements e {
            @Override // com.tencent.luggage.wxa.bf.e
            public String a(ByteBuffer byteBuffer) {
                return new String(Base64.encode(com.tencent.luggage.wxa.tk.c.a(byteBuffer), 2), e.f122535a);
            }

            @Override // com.tencent.luggage.wxa.bf.e
            public ByteBuffer a(String str) {
                return ByteBuffer.wrap(Base64.decode(str.getBytes(e.f122535a), 2));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements e {
            @Override // com.tencent.luggage.wxa.bf.e
            public String a(ByteBuffer byteBuffer) {
                return new BigInteger(1, com.tencent.luggage.wxa.tk.c.a(byteBuffer)).toString(16);
            }

            @Override // com.tencent.luggage.wxa.bf.e
            public ByteBuffer a(String str) {
                return ByteBuffer.wrap(new BigInteger(str, 16).toByteArray());
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class f implements e {
            @Override // com.tencent.luggage.wxa.bf.e
            public String a(ByteBuffer byteBuffer) {
                return new String(com.tencent.luggage.wxa.tk.c.a(byteBuffer), e.f122535a);
            }

            @Override // com.tencent.luggage.wxa.bf.e
            public ByteBuffer a(String str) {
                return ByteBuffer.wrap(str.getBytes(e.f122535a));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class g implements e {

            /* renamed from: b, reason: collision with root package name */
            public final Charset f122540b = Charset.forName("ISO-8859-1");

            @Override // com.tencent.luggage.wxa.bf.e
            public String a(ByteBuffer byteBuffer) {
                return new String(com.tencent.luggage.wxa.tk.c.a(byteBuffer), this.f122540b);
            }

            @Override // com.tencent.luggage.wxa.bf.e
            public ByteBuffer a(String str) {
                return ByteBuffer.wrap(str.getBytes(this.f122540b));
            }
        }

        static {
            HashMap hashMap = new HashMap();
            f122536a = hashMap;
            hashMap.put("ascii", new C6052a());
            hashMap.put("base64", new b());
            hashMap.put("hex", new c());
            d dVar = new d(Charset.forName("ISO-10646-UCS-2"));
            hashMap.put("ucs2", dVar);
            hashMap.put("ucs-2", dVar);
            C6053e c6053e = new C6053e(Charset.forName(CharEncoding.UTF_16LE));
            hashMap.put("utf16le", c6053e);
            hashMap.put("utf-16le", c6053e);
            f fVar = new f();
            hashMap.put("utf8", fVar);
            hashMap.put("utf-8", fVar);
            g gVar = new g();
            hashMap.put("latin1", gVar);
            hashMap.put("binary", gVar);
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class d implements e {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Charset f122538b;

            public d(Charset charset) {
                this.f122538b = charset;
            }

            @Override // com.tencent.luggage.wxa.bf.e
            public String a(ByteBuffer byteBuffer) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                return new String(com.tencent.luggage.wxa.tk.c.a(byteBuffer), this.f122538b);
            }

            @Override // com.tencent.luggage.wxa.bf.e
            public ByteBuffer a(String str) {
                return ByteBuffer.wrap(str.getBytes(this.f122538b)).order(ByteOrder.LITTLE_ENDIAN);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bf.e$a$e, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6053e implements e {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Charset f122539b;

            public C6053e(Charset charset) {
                this.f122539b = charset;
            }

            @Override // com.tencent.luggage.wxa.bf.e
            public String a(ByteBuffer byteBuffer) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                return new String(com.tencent.luggage.wxa.tk.c.a(byteBuffer), this.f122539b);
            }

            @Override // com.tencent.luggage.wxa.bf.e
            public ByteBuffer a(String str) {
                return ByteBuffer.wrap(str.getBytes(this.f122539b)).order(ByteOrder.LITTLE_ENDIAN);
            }
        }

        public static void a() {
        }
    }

    String a(ByteBuffer byteBuffer);

    ByteBuffer a(String str);
}
