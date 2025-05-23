package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.ap.j;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.w;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.rc.a0;
import com.tencent.luggage.wxa.rc.k;
import com.tencent.luggage.wxa.tn.l;
import com.tencent.luggage.wxa.tn.o;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.m0;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import org.apache.commons.io.FilenameUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class LuggageLocalFileObjectManager {

    /* renamed from: e, reason: collision with root package name */
    public static final w f151883e = new a();

    /* renamed from: f, reason: collision with root package name */
    public static final a0 f151884f = new d();

    /* renamed from: a, reason: collision with root package name */
    public final String f151885a;

    /* renamed from: b, reason: collision with root package name */
    public final String f151886b;

    /* renamed from: c, reason: collision with root package name */
    public final String f151887c;

    /* renamed from: d, reason: collision with root package name */
    public final Collection f151888d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements w {
        @Override // com.tencent.luggage.wxa.cp.w
        public boolean a(v vVar) {
            return LuggageLocalFileObjectManager.b(vVar, "store_", true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements w {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.cp.w
        public boolean a(v vVar) {
            return LuggageLocalFileObjectManager.this.a(vVar, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements w {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.cp.w
        public boolean a(v vVar) {
            return LuggageLocalFileObjectManager.this.b(vVar, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d extends a0 {
        public String toString() {
            return "AppBrandLocalMediaObject::Nil";
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
        j a(String str, String str2);

        a0 a(a0 a0Var);

        a0 a(String str);

        a0 b(String str);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public final class f implements e {
        public f() {
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.e
        public a0 a(a0 a0Var) {
            if (a0Var == null) {
                return null;
            }
            String replaceFirst = a0Var.f139454b.replaceFirst("tmp_", "store_");
            if (!((Boolean) k.a(a0Var.f139454b, replaceFirst).first).booleanValue()) {
                return null;
            }
            a0 a0Var2 = new a0();
            a0Var2.f139454b = replaceFirst;
            a0Var2.f139453a = a0Var.f139453a.replaceFirst("tmp_", "store_");
            a0Var2.f139458f = a0Var.f139458f;
            a0Var2.f139456d = a0Var.f139456d;
            a0Var2.f139459g = new v(a0Var2.f139454b).r();
            a0Var2.f139455c = a0Var.f139455c;
            a0Var2.f139457e = true;
            return a0Var2;
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.e
        public a0 b(String str) {
            String str2 = null;
            String str3 = "tmp_";
            if (!str.startsWith("store_") && !str.startsWith("tmp_")) {
                return null;
            }
            String extension = FilenameUtils.getExtension(str);
            String replaceFirst = str.replaceFirst("store_", "").replaceFirst("tmp_", "");
            if (!w0.c(extension)) {
                replaceFirst = replaceFirst.replaceFirst("\\." + extension, "");
            }
            if (w0.c(replaceFirst)) {
                return LuggageLocalFileObjectManager.f151884f;
            }
            try {
                LuggageLocalFileObjectManager luggageLocalFileObjectManager = LuggageLocalFileObjectManager.this;
                str2 = luggageLocalFileObjectManager.a(replaceFirst, luggageLocalFileObjectManager.f151886b);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e16, "retrieveMediaObject, decrypt exp ", new Object[0]);
            }
            if (w0.c(str2)) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                return LuggageLocalFileObjectManager.f151884f;
            }
            String[] split = str2.split("\\|");
            if (split == null || split.length != 2) {
                return LuggageLocalFileObjectManager.f151884f;
            }
            if (str.startsWith("store_")) {
                str3 = "store_";
            }
            String str4 = LuggageLocalFileObjectManager.this.c() + str3 + replaceFirst;
            long a16 = w0.a(split[0], 0L);
            String str5 = split[1];
            if (!str5.equalsIgnoreCase(extension)) {
                return LuggageLocalFileObjectManager.f151884f;
            }
            try {
                long b16 = LuggageLocalFileObjectManager.this.b(str4);
                if (a16 != b16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", Long.valueOf(b16), Long.valueOf(a16), str);
                    return LuggageLocalFileObjectManager.f151884f;
                }
                a0 a0Var = new a0();
                a0Var.f139453a = LuggageLocalFileObjectManager.this.f151887c + str;
                a0Var.f139454b = str4;
                a0Var.f139455c = com.tencent.luggage.wxa.bo.e.c(str5);
                a0Var.f139457e = str3.equalsIgnoreCase("store_");
                v vVar = new v(a0Var.f139454b);
                a0Var.f139459g = vVar.r();
                a0Var.f139458f = vVar.s();
                return a0Var;
            } catch (IOException e17) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", w0.a((Throwable) e17));
                return LuggageLocalFileObjectManager.f151884f;
            }
        }

        public String toString() {
            return "V2MediaObjectInfoHandler";
        }

        public /* synthetic */ f(LuggageLocalFileObjectManager luggageLocalFileObjectManager, a aVar) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.e
        public j a(String str, String str2) {
            String str3;
            String str4;
            if (w0.c(str2)) {
                str2 = LuggageLocalFileObjectManager.this.b();
            }
            try {
                String format = String.format(Locale.US, "%d|%s", Long.valueOf(LuggageLocalFileObjectManager.this.b(str)), str2);
                try {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "hy: attach media obj: %s", format);
                    LuggageLocalFileObjectManager luggageLocalFileObjectManager = LuggageLocalFileObjectManager.this;
                    str3 = luggageLocalFileObjectManager.b(format, luggageLocalFileObjectManager.f151886b);
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e16, "attachMediaObject, enc exp = ", new Object[0]);
                    str3 = null;
                }
                if (w0.c(str3)) {
                    return null;
                }
                String str5 = "tmp_" + str3;
                String str6 = LuggageLocalFileObjectManager.this.c() + str5;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(LuggageLocalFileObjectManager.this.f151887c);
                sb5.append(str5);
                if (w0.c(str2)) {
                    str4 = "";
                } else {
                    str4 = '.' + str2;
                }
                sb5.append(str4);
                String sb6 = sb5.toString();
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", sb6, str6);
                return j.a(sb6, str6, str2);
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", w0.a((Throwable) e17));
                return null;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.e
        public a0 a(String str) {
            String str2;
            String[] split;
            String str3 = "";
            String replaceFirst = str.replaceFirst("store_", "").replaceFirst("tmp_", "");
            try {
                LuggageLocalFileObjectManager luggageLocalFileObjectManager = LuggageLocalFileObjectManager.this;
                str2 = luggageLocalFileObjectManager.a(replaceFirst, luggageLocalFileObjectManager.f151886b);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e16, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
                str2 = null;
            }
            if (w0.c(str2) || (split = str2.split("\\|")) == null || split.length != 2) {
                return null;
            }
            String str4 = split[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append(LuggageLocalFileObjectManager.this.f151887c);
            sb5.append(str);
            if (!w0.c(str4)) {
                str3 = "." + str4;
            }
            sb5.append(str3);
            String sb6 = sb5.toString();
            a0 a0Var = new a0();
            a0Var.f139453a = sb6;
            a0Var.f139454b = LuggageLocalFileObjectManager.this.c() + str;
            a0Var.f139456d = replaceFirst;
            a0Var.f139457e = str.startsWith("store_");
            v vVar = new v(a0Var.f139454b);
            a0Var.f139459g = vVar.r();
            a0Var.f139458f = vVar.s();
            return a0Var;
        }
    }

    public LuggageLocalFileObjectManager(String str, String str2, String str3) {
        this.f151885a = new v(str).g() + "/";
        this.f151886b = str2;
        this.f151887c = str3;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new f(this, null));
        this.f151888d = Collections.unmodifiableCollection(linkedList);
    }

    public final String b() {
        return "unknown";
    }

    public long e() {
        v[] g16 = g();
        long j3 = 0;
        if (g16 != null && g16.length > 0) {
            for (v vVar : g16) {
                j3 += vVar.s();
            }
        }
        return j3;
    }

    public List f() {
        v[] g16 = g();
        if (g16 != null && g16.length > 0) {
            LinkedList linkedList = new LinkedList();
            for (v vVar : g16) {
                a0 c16 = c(vVar.i());
                if (c16 != null) {
                    linkedList.add(c16);
                }
            }
            return linkedList;
        }
        return null;
    }

    public v[] g() {
        v vVar = new v(c());
        if (vVar.e() && vVar.p()) {
            return vVar.a(new b());
        }
        return null;
    }

    @Keep
    public String genMediaFilePath(String str) {
        if (w0.c(str)) {
            return null;
        }
        return c() + str;
    }

    public List h() {
        v[] i3 = i();
        if (i3 != null && i3.length > 0) {
            LinkedList linkedList = new LinkedList();
            for (v vVar : i3) {
                a0 c16 = c(vVar.i());
                if (c16 != null) {
                    linkedList.add(c16);
                }
            }
            return linkedList;
        }
        return null;
    }

    public final v[] i() {
        v vVar = new v(c());
        if (vVar.e() && vVar.p()) {
            return vVar.a(new c());
        }
        return null;
    }

    public final String c(String str, String str2) {
        return w0.c(str) ? str2 : str;
    }

    public final String d() {
        return this.f151885a;
    }

    public final String c() {
        l.a(d());
        try {
            new v(this.f151885a, ".nomedia").c();
        } catch (Exception unused) {
        }
        return this.f151885a;
    }

    public a0 d(String str) {
        if (!w0.c(str) && str.startsWith(this.f151887c)) {
            String substring = str.substring(this.f151887c.length());
            Iterator it = this.f151888d.iterator();
            a0 a0Var = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e eVar = (e) it.next();
                a0 b16 = eVar.b(substring);
                if (b16 != null) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", eVar.toString(), b16);
                    a0Var = b16;
                    break;
                }
                a0Var = b16;
            }
            if (f151884f == a0Var) {
                return null;
            }
            return a0Var;
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", str);
        return null;
    }

    public boolean b(v vVar, boolean z16) {
        return new v(c()).equals(new v(vVar.j())) && b(vVar, "tmp_", z16);
    }

    public static boolean b(v vVar, String str, boolean z16) {
        return (!z16 || vVar.e()) && !vVar.p() && !w0.c(vVar.i()) && vVar.i().startsWith(str);
    }

    public final boolean a(boolean z16, String str, String str2) {
        if (z16 && ((Boolean) k.a(str, str2).first).booleanValue()) {
            return true;
        }
        return !z16 && o.a(str, str2);
    }

    public a0 c(String str) {
        a0 a0Var = null;
        if (w0.c(str)) {
            return null;
        }
        Iterator it = this.f151888d.iterator();
        while (it.hasNext() && (a0Var = ((e) it.next()).a(str)) == null) {
        }
        return a0Var;
    }

    public boolean a(v vVar, boolean z16) {
        return new v(c()).equals(new v(vVar.j())) && b(vVar, "store_", z16);
    }

    public final a0 a(String str, Class cls, String str2, boolean z16) {
        a0 a0Var;
        String str3;
        if (!x.d(str)) {
            return null;
        }
        String c16 = c(FilenameUtils.getExtension(str), str2);
        Iterator it = this.f151888d.iterator();
        j jVar = null;
        while (it.hasNext() && (jVar = ((e) it.next()).a(str, c16)) == null) {
        }
        if (jVar == null || jVar.a() < 2) {
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(jVar == null ? -1 : jVar.a());
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast, no handler return correct info, attach.size = %d", objArr);
            return null;
        }
        try {
            a0Var = (a0) cls.newInstance();
            a0Var.f139453a = (String) jVar.a(0);
            a0Var.f139455c = com.tencent.luggage.wxa.bo.e.c(c16);
            str3 = (String) jVar.a(1);
            a0Var.f139454b = str3;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.LuggageLocalFileObjectManager", e16, "", new Object[0]);
        }
        if (w0.c(str3)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
            return null;
        }
        if (w0.c(c16)) {
            c16 = b();
        }
        a0Var.f139456d = w0.b((String) jVar.a(2), c16);
        if (!a(z16, str, a0Var.f139454b)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "createLocalFileLink fail, deleteSrc: %b, from: %s, to: %s", Boolean.valueOf(z16), str, a0Var.f139454b);
            return null;
        }
        v vVar = new v(a0Var.f139454b);
        a0Var.f139458f = vVar.s();
        a0Var.f139459g = vVar.r();
        return a0Var;
    }

    public final String b(String str, String str2) {
        return w0.a(new m0().b(str.getBytes(), str2.getBytes()));
    }

    public final long b(String str) {
        InputStream n3 = x.n(str);
        CheckedInputStream checkedInputStream = new CheckedInputStream(n3, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        w0.a((Closeable) checkedInputStream);
        w0.a((Closeable) n3);
        return value;
    }

    public a0 a(String str) {
        return a(str, (String) null, false);
    }

    public a0 a(String str, String str2, boolean z16) {
        return a(str, a0.class, str2, z16);
    }

    public final String a(String str, String str2) {
        byte[] a16 = new m0().a(w0.a(str), str2.getBytes());
        if (w0.c(str)) {
            return null;
        }
        return new String(a16);
    }

    public a0 a(a0 a0Var) {
        Iterator it = this.f151888d.iterator();
        a0 a0Var2 = null;
        while (it.hasNext() && (a0Var2 = ((e) it.next()).a(a0Var)) == null) {
        }
        return a0Var2;
    }
}
