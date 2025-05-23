package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.ap.j;
import com.tencent.luggage.wxa.bo.e;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.rc.d;
import com.tencent.luggage.wxa.rc.s;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxa.tn.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.m0;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import org.apache.commons.io.FilenameUtils;

/* compiled from: P */
@Deprecated
/* loaded from: classes9.dex */
public final class AppBrandLocalMediaObjectManager {

    /* renamed from: a, reason: collision with root package name */
    public static final Collection f151880a;

    /* renamed from: b, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.so.c f151881b = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: com.tencent.mm.plugin.appbrand.appstorage.a
        @Override // com.tencent.luggage.wxa.so.c.a
        public final Object a() {
            return AppBrandLocalMediaObjectManager.d();
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.rc.c f151882c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends com.tencent.luggage.wxa.rc.c {
        @Override // com.tencent.luggage.wxa.rc.c
        public String toString() {
            return "AppBrandLocalMediaObject::Nil";
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        j a(String str, String str2, String str3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c implements b {
        public c() {
        }

        public /* synthetic */ c(d dVar) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.b
        public j a(String str, String str2, String str3) {
            String str4;
            String str5;
            if (w0.c(str3)) {
                str3 = AppBrandLocalMediaObjectManager.a();
            }
            try {
                try {
                    str4 = AppBrandLocalMediaObjectManager.b(String.format(Locale.US, "%d|%s", Long.valueOf(AppBrandLocalMediaObjectManager.c(str2)), str3), str);
                } catch (Exception e16) {
                    w.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e16, "attachMediaObject, enc exp = ", new Object[0]);
                    str4 = null;
                }
                if (w0.c(str4)) {
                    return null;
                }
                String str6 = "tmp_" + str4;
                String str7 = AppBrandLocalMediaObjectManager.d(str) + str6;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("wxfile://");
                sb5.append(str6);
                if (w0.c(str3)) {
                    str5 = "";
                } else {
                    str5 = '.' + str3;
                }
                sb5.append(str5);
                String sb6 = sb5.toString();
                w.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", sb6, str7);
                return j.a(sb6, str7, str3);
            } catch (Exception e17) {
                w.b("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", w0.a((Throwable) e17));
                return null;
            }
        }

        public String toString() {
            return "V2MediaObjectInfoHandler";
        }
    }

    static {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new c(null));
        f151880a = Collections.unmodifiableCollection(linkedList);
        f151882c = new a();
    }

    public static String b() {
        return "unknown";
    }

    public static String c() {
        return (String) f151881b.b();
    }

    public static String d() {
        String a16 = com.tencent.luggage.wxa.tk.c.a();
        if (!a16.endsWith("/")) {
            a16 = a16 + "/";
        }
        return a16 + "wxafiles/";
    }

    public static String e(String str) {
        return ((String) f151881b.b()) + str + "/";
    }

    @Keep
    public static String genMediaFilePath(String str, String str2) {
        if (!w0.c(str) && !w0.c(str2)) {
            return d(str) + str2;
        }
        return null;
    }

    public static /* synthetic */ String a() {
        return b();
    }

    public static String c(String str, String str2) {
        return w0.c(str) ? str2 : str;
    }

    public static String b(String str, String str2) {
        return w0.a(new m0().b(str.getBytes(), str2.getBytes()));
    }

    public static long c(String str) {
        InputStream n3 = x.n(str);
        CheckedInputStream checkedInputStream = new CheckedInputStream(n3, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        w0.a((Closeable) checkedInputStream);
        w0.a((Closeable) n3);
        return value;
    }

    public static boolean a(boolean z16, String str, String str2) {
        if (z16 && x.b(str, str2)) {
            return true;
        }
        return !z16 && x.a(str, str2) >= 0;
    }

    public static String d(String str) {
        String e16 = e(str);
        l.a(e16);
        try {
            new v(e16, ".nomedia").c();
        } catch (Exception unused) {
        }
        return e16;
    }

    public static com.tencent.luggage.wxa.rc.c a(String str, String str2, Class cls, String str3, boolean z16) {
        com.tencent.luggage.wxa.rc.c cVar;
        String str4;
        if (w0.c(str) || !x.d(str2)) {
            return null;
        }
        String c16 = c(FilenameUtils.getExtension(str2), str3);
        Iterator it = f151880a.iterator();
        j jVar = null;
        while (it.hasNext() && (jVar = ((b) it.next()).a(str, str2, c16)) == null) {
        }
        if (jVar == null || jVar.a() < 2) {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(jVar == null ? -1 : jVar.a());
            w.b("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast, no handler return correct info, attach.size = %d", objArr);
            return null;
        }
        try {
            cVar = (com.tencent.luggage.wxa.rc.c) cls.newInstance();
            cVar.f139471a = (String) jVar.a(0);
            cVar.f139473c = e.c(c16);
            str4 = (String) jVar.a(1);
            cVar.f139472b = str4;
        } catch (Exception e16) {
            w.a("MicroMsg.AppBrand.LocalMediaObjectManager", e16, "", new Object[0]);
        }
        if (w0.c(str4)) {
            w.b("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
            return null;
        }
        if (w0.c(c16)) {
            c16 = b();
        }
        cVar.f139474d = w0.b((String) jVar.a(3), c16);
        if (a(z16, str2, cVar.f139472b)) {
            v vVar = new v(cVar.f139472b);
            cVar.f139476f = vVar.s();
            cVar.f139477g = vVar.r();
            s sVar = (s) com.tencent.luggage.wxa.h1.e.c(s.class);
            if (sVar != null) {
                sVar.a(str, vVar);
            }
            return cVar;
        }
        return null;
    }

    public static com.tencent.luggage.wxa.rc.c a(String str, String str2, String str3, boolean z16) {
        return a(str, str2, com.tencent.luggage.wxa.rc.c.class, str3, z16);
    }
}
