package com.tencent.luggage.wxa.cp;

import com.tencent.luggage.wxa.cp.k;
import com.tencent.luggage.wxa.cp.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class v implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f123839a;

    /* renamed from: b, reason: collision with root package name */
    public l.h f123840b;

    public v(String str) {
        this(b0.b(str));
    }

    public static v a(File file) {
        if (file != null) {
            return new v(file);
        }
        return null;
    }

    public boolean b() {
        l.h x16 = x();
        if (!x16.a()) {
            return false;
        }
        k.a aVar = x16.f123799a;
        if ((aVar.a() & 1) == 0) {
            return false;
        }
        String d16 = aVar.d(x16.f123800b, true);
        if (d16 != null) {
            return new File(d16).canWrite();
        }
        return aVar.i(x16.f123800b);
    }

    public boolean c() {
        l.h x16 = x();
        if (x16.a()) {
            if (x16.f123799a.i(x16.f123800b)) {
                return false;
            }
            x16.f123799a.a(x16.f123800b, false).close();
            return true;
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + this.f123839a);
    }

    public boolean d() {
        l.h x16 = x();
        if (x16.a() && x16.f123799a.b(x16.f123800b)) {
            return true;
        }
        return false;
    }

    public boolean e() {
        l.h x16 = x();
        if (!x16.a()) {
            return false;
        }
        return x16.f123799a.i(x16.f123800b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        return this.f123839a.equals(((v) obj).f123839a);
    }

    public v f() {
        return new v((String) null, h());
    }

    public String g() {
        return h().toString();
    }

    public final b0 h() {
        if (o()) {
            return this.f123839a;
        }
        String str = this.f123839a.f123727c;
        String property = System.getProperty("user.dir");
        if (!str.isEmpty()) {
            property = property + '/' + str;
        }
        String str2 = property;
        b0 b0Var = this.f123839a;
        return new b0(b0Var.f123725a, b0Var.f123726b, str2, b0Var.f123728d, b0Var.f123729e);
    }

    public int hashCode() {
        return m().hashCode() ^ 1234321;
    }

    public String i() {
        String str = this.f123839a.f123727c;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf >= 0) {
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public String j() {
        b0 l3 = l();
        if (l3 == null) {
            return null;
        }
        return l3.toString();
    }

    public v k() {
        b0 l3 = l();
        if (l3 == null) {
            return null;
        }
        return new v((String) null, l3);
    }

    public b0 l() {
        String substring;
        String str = this.f123839a.f123727c;
        int length = str.length();
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf != -1 && str.charAt(length - 1) != '/') {
            if (str.indexOf(47) == lastIndexOf && str.charAt(0) == '/') {
                substring = str.substring(0, lastIndexOf + 1);
            } else {
                substring = str.substring(0, lastIndexOf);
            }
            b0 b0Var = this.f123839a;
            return new b0(b0Var.f123725a, b0Var.f123726b, substring, b0Var.f123728d, b0Var.f123729e);
        }
        return null;
    }

    public String m() {
        return this.f123839a.toString();
    }

    public b0 n() {
        return this.f123839a;
    }

    public boolean o() {
        b0 b0Var = this.f123839a;
        String str = b0Var.f123727c;
        if (!b0Var.a() && (str.length() <= 0 || str.charAt(0) != '/')) {
            return false;
        }
        return true;
    }

    public boolean p() {
        i c16;
        l.h x16 = x();
        if (!x16.a() || (c16 = x16.f123799a.c(x16.f123800b)) == null || !c16.f123770f) {
            return false;
        }
        return true;
    }

    public boolean q() {
        i c16;
        l.h x16 = x();
        if (!x16.a() || (c16 = x16.f123799a.c(x16.f123800b)) == null || c16.f123770f) {
            return false;
        }
        return true;
    }

    public long r() {
        i c16;
        l.h x16 = x();
        if (!x16.a() || (c16 = x16.f123799a.c(x16.f123800b)) == null) {
            return 0L;
        }
        return c16.f123769e;
    }

    public long s() {
        i c16;
        l.h x16 = x();
        if (!x16.a() || (c16 = x16.f123799a.c(x16.f123800b)) == null) {
            return 0L;
        }
        return c16.f123767c;
    }

    public String[] t() {
        Iterable f16;
        l.h x16 = x();
        if (!x16.a() || (f16 = x16.f123799a.f(x16.f123800b)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f16.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String toString() {
        return this.f123839a.toString();
    }

    public v[] u() {
        Iterable f16;
        l.h x16 = x();
        if (!x16.a() || (f16 = x16.f123799a.f(x16.f123800b)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f16.iterator();
        while (it.hasNext()) {
            arrayList.add(new v((String) it.next(), n()));
        }
        return (v[]) arrayList.toArray(new v[0]);
    }

    public boolean v() {
        return w();
    }

    public boolean w() {
        l.h x16 = x();
        if (!x16.a()) {
            return false;
        }
        return x16.f123799a.d(x16.f123800b);
    }

    public l.h x() {
        l.h a16 = l.d().a(this.f123839a, this.f123840b);
        this.f123840b = a16;
        return a16;
    }

    public v(b0 b0Var) {
        this.f123840b = null;
        String str = b0Var.f123727c;
        if (str != null) {
            String a16 = c0.a(str, false, false);
            if (!b0Var.f123727c.equals(a16)) {
                b0Var = new b0(b0Var.f123725a, b0Var.f123726b, a16, b0Var.f123728d, b0Var.f123729e);
            }
        }
        this.f123839a = b0Var;
    }

    public boolean a() {
        l.h x16 = x();
        if (!x16.a()) {
            return false;
        }
        k.a aVar = x16.f123799a;
        String d16 = aVar.d(x16.f123800b, false);
        if (d16 != null) {
            return new File(d16).canRead();
        }
        return aVar.i(x16.f123800b);
    }

    public v[] a(a0 a0Var) {
        Iterable<String> f16;
        if (a0Var == null) {
            return u();
        }
        l.h x16 = x();
        if (!x16.a() || (f16 = x16.f123799a.f(x16.f123800b)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : f16) {
            if (a0Var.a(this, str)) {
                arrayList.add(new v(str, n()));
            }
        }
        return (v[]) arrayList.toArray(new v[0]);
    }

    public v(File file) {
        this.f123840b = null;
        this.f123839a = new b0(null, null, file.getPath(), null, null);
    }

    public v(v vVar) {
        this.f123840b = null;
        this.f123839a = vVar.f123839a;
        this.f123840b = vVar.f123840b;
    }

    public v(String str, String str2) {
        this(str == null ? null : b0.b(str), str2);
    }

    public v(v vVar, String str) {
        this(c0.a(str, false, true), vVar == null ? b0.f123724f : vVar.n());
    }

    public v[] a(w wVar) {
        Iterable f16;
        if (wVar == null) {
            return u();
        }
        l.h x16 = x();
        if (!x16.a() || (f16 = x16.f123799a.f(x16.f123800b)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f16.iterator();
        while (it.hasNext()) {
            v vVar = new v((String) it.next(), n());
            if (wVar.a(vVar)) {
                arrayList.add(vVar);
            }
        }
        return (v[]) arrayList.toArray(new v[0]);
    }

    public v(File file, String str) {
        this(new File(file, str));
    }

    public v(b0 b0Var, String str) {
        this.f123840b = null;
        if (b0Var == null) {
            this.f123839a = new b0(null, null, c0.a(str, false, false), null, null);
            return;
        }
        String str2 = b0Var.f123727c;
        if (!str.isEmpty()) {
            str2 = c0.a(str2 + '/' + str, false, false);
        }
        this.f123839a = new b0(b0Var.f123725a, b0Var.f123726b, str2, b0Var.f123728d, b0Var.f123729e);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(v vVar) {
        return m().compareTo(vVar.m());
    }

    public v(String str, b0 b0Var) {
        this.f123840b = null;
        if (str != null && !str.isEmpty()) {
            String str2 = b0Var.f123727c;
            this.f123839a = new b0(b0Var.f123725a, b0Var.f123726b, str2 + '/' + str, b0Var.f123728d, b0Var.f123729e);
            return;
        }
        this.f123839a = b0Var;
    }
}
