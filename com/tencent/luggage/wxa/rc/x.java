package com.tencent.luggage.wxa.rc;

import com.tencent.luggage.wxa.rc.g;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.m0;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class x {

    /* renamed from: i, reason: collision with root package name */
    public static final a0 f139578i = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f139579a;

    /* renamed from: b, reason: collision with root package name */
    public final String f139580b;

    /* renamed from: c, reason: collision with root package name */
    public final String f139581c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f139582d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.ei.l f139583e;

    /* renamed from: f, reason: collision with root package name */
    public g.a f139584f;

    /* renamed from: g, reason: collision with root package name */
    public final Collection f139585g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f139586h = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends a0 {
        public String toString() {
            return "AppBrandLocalMediaObject::Nil";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        com.tencent.luggage.wxa.ap.j a(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class c implements b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.rc.x.b
        public com.tencent.luggage.wxa.ap.j a(String str, String str2) {
            String str3;
            String str4;
            if (w0.c(str2)) {
                str2 = x.this.b();
            }
            try {
                String format = String.format(Locale.US, "%d|%s", Long.valueOf(x.this.b(str)), str2);
                try {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "hy: attach media obj: %s", format);
                    x xVar = x.this;
                    str3 = xVar.a(format, xVar.f139580b);
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e16, "attachMediaObject, enc exp = ", new Object[0]);
                    str3 = null;
                }
                if (w0.c(str3)) {
                    return null;
                }
                String str5 = "blob_" + str3;
                String str6 = x.this.c() + str5;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(x.this.f139581c);
                sb5.append(str5);
                if (w0.c(str2)) {
                    str4 = "";
                } else {
                    str4 = '.' + str2;
                }
                sb5.append(str4);
                String sb6 = sb5.toString();
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", sb6, str6);
                return com.tencent.luggage.wxa.ap.j.a(sb6, str6, str2);
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", w0.a((Throwable) e17));
                return null;
            }
        }

        public String toString() {
            return "V2MediaObjectInfoHandler";
        }

        public /* synthetic */ c(x xVar, w wVar) {
            this();
        }
    }

    public x(String str, String str2, String str3, g.a aVar) {
        this.f139579a = new com.tencent.luggage.wxa.cp.v(str).g() + "/";
        this.f139580b = str2;
        this.f139581c = str3;
        this.f139584f = aVar;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new c(this, null));
        this.f139585g = Collections.unmodifiableCollection(linkedList);
    }

    public final String b() {
        return "unknown";
    }

    public com.tencent.luggage.wxa.cp.v c(String str) {
        if (w0.c(str)) {
            return null;
        }
        ByteBuffer a16 = a(str);
        boolean d16 = d(str);
        if (a16 == null && d16) {
            com.tencent.luggage.wxa.cp.v vVar = (com.tencent.luggage.wxa.cp.v) this.f139586h.remove(str);
            if (vVar != null && vVar.e()) {
                vVar.d();
            }
            return null;
        }
        com.tencent.luggage.wxa.cp.v vVar2 = (com.tencent.luggage.wxa.cp.v) this.f139586h.get(str);
        if (d16 && vVar2 != null && vVar2.e()) {
            return vVar2;
        }
        String b16 = b();
        Iterator it = this.f139585g.iterator();
        com.tencent.luggage.wxa.ap.j jVar = null;
        while (it.hasNext() && (jVar = ((b) it.next()).a(str, b16)) == null) {
        }
        if (jVar == null || jVar.a() < 2) {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(jVar == null ? -1 : jVar.a());
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "createTempLocalFile, no handler return correct info, attach.size = %d", objArr);
            return null;
        }
        try {
            String str2 = (String) jVar.a(1);
            if (w0.c(str2)) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "createTempLocalFile appId %s, Null Or Nil fileFullPath");
                return null;
            }
            if (a16 != null) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "get buffer success");
                com.tencent.luggage.wxa.cp.x.b(str2, com.tencent.luggage.wxa.tk.c.a(a16));
                com.tencent.luggage.wxa.cp.v vVar3 = new com.tencent.luggage.wxa.cp.v(str2);
                this.f139586h.put(str, vVar3);
                return vVar3;
            }
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "get buffer fail");
            return null;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.LuggageBlobFileObjectManager", e16, "", new Object[0]);
            return null;
        }
    }

    public boolean d(String str) {
        return this.f139586h.containsKey(str);
    }

    public final long b(String str) {
        ByteBuffer a16 = a(str);
        if (a16 == null) {
            return -1L;
        }
        CheckedInputStream checkedInputStream = new CheckedInputStream(new com.tencent.luggage.wxa.h6.a(a16), new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        w0.a((Closeable) checkedInputStream);
        return value;
    }

    public final String d() {
        return this.f139579a;
    }

    public void a() {
        this.f139586h.clear();
        com.tencent.luggage.wxa.cp.x.b(d());
    }

    public final String a(String str, String str2) {
        return w0.a(new m0().b(str.getBytes(), str2.getBytes()));
    }

    public ByteBuffer a(String str) {
        if (this.f139583e == null) {
            if (this.f139582d == null) {
                g.a aVar = this.f139584f;
                if (aVar != null) {
                    this.f139582d = aVar.a();
                }
                if (this.f139582d == null) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "service is null");
                    return null;
                }
            }
            this.f139583e = (com.tencent.luggage.wxa.ei.l) this.f139582d.getJsRuntime().a(com.tencent.luggage.wxa.ei.l.class);
        }
        com.tencent.luggage.wxa.ei.l lVar = this.f139583e;
        if (lVar != null && lVar.m() != null) {
            return this.f139583e.m().a(str);
        }
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.f139583e == null);
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "getBuffer failed, mBufferAddon == null?: [%b]", objArr);
        return null;
    }

    public final String c() {
        com.tencent.luggage.wxa.tn.l.a(d());
        try {
            new com.tencent.luggage.wxa.cp.v(this.f139579a, ".nomedia").c();
        } catch (Exception unused) {
        }
        return this.f139579a;
    }
}
