package com.tencent.luggage.wxa.yi;

import com.tencent.luggage.wxa.yi.d;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e {
    public final boolean A;
    public boolean B;

    /* renamed from: a, reason: collision with root package name */
    public int f145893a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f145894b;

    /* renamed from: c, reason: collision with root package name */
    public String f145895c;

    /* renamed from: d, reason: collision with root package name */
    public String f145896d;

    /* renamed from: e, reason: collision with root package name */
    public d.e f145897e;

    /* renamed from: f, reason: collision with root package name */
    public Map f145898f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f145899g;

    /* renamed from: i, reason: collision with root package name */
    public String f145901i;

    /* renamed from: j, reason: collision with root package name */
    public String f145902j;

    /* renamed from: k, reason: collision with root package name */
    public HttpURLConnection f145903k;

    /* renamed from: l, reason: collision with root package name */
    public String f145904l;

    /* renamed from: n, reason: collision with root package name */
    public String f145906n;

    /* renamed from: q, reason: collision with root package name */
    public boolean f145909q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f145910r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f145911s;

    /* renamed from: u, reason: collision with root package name */
    public boolean f145913u;

    /* renamed from: w, reason: collision with root package name */
    public String f145915w;

    /* renamed from: x, reason: collision with root package name */
    public int f145916x;

    /* renamed from: y, reason: collision with root package name */
    public String f145917y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f145918z;

    /* renamed from: h, reason: collision with root package name */
    public int f145900h = 15;

    /* renamed from: o, reason: collision with root package name */
    public Runnable f145907o = null;

    /* renamed from: p, reason: collision with root package name */
    public boolean f145908p = false;

    /* renamed from: t, reason: collision with root package name */
    public boolean f145912t = true;

    /* renamed from: v, reason: collision with root package name */
    public boolean f145914v = false;

    /* renamed from: m, reason: collision with root package name */
    public long f145905m = System.currentTimeMillis();

    public e(String str, byte[] bArr, int i3, d.e eVar, String str2, boolean z16, boolean z17, boolean z18, boolean z19, String str3, int i16, String str4, boolean z26, boolean z27, boolean z28) {
        this.f145909q = false;
        this.f145910r = false;
        this.f145911s = false;
        this.f145913u = false;
        this.f145918z = false;
        this.B = false;
        this.f145895c = str;
        this.f145894b = bArr;
        this.f145897e = eVar;
        this.f145893a = i3;
        this.f145896d = str2;
        this.f145909q = z16;
        this.f145910r = z17;
        this.f145913u = z19;
        this.f145911s = z18;
        this.f145915w = str3;
        this.f145916x = i16;
        this.f145917y = str4;
        this.f145918z = z26;
        this.A = z27;
        this.B = z28;
    }

    public boolean A() {
        return this.f145910r;
    }

    public boolean B() {
        return this.A;
    }

    public boolean C() {
        return this.B;
    }

    public d.e a() {
        return this.f145897e;
    }

    public int b() {
        return this.f145900h;
    }

    public HttpURLConnection c() {
        return this.f145903k;
    }

    public int d() {
        return (int) (System.currentTimeMillis() - this.f145905m);
    }

    public void e(String str) {
        this.f145902j = str;
    }

    public void f(String str) {
        this.f145895c = str;
    }

    public ArrayList g() {
        return this.f145899g;
    }

    public boolean h() {
        return this.f145918z;
    }

    public String i() {
        return this.f145906n;
    }

    public boolean j() {
        return this.f145908p;
    }

    public boolean k() {
        return this.f145914v;
    }

    public Map l() {
        return this.f145898f;
    }

    public String m() {
        return this.f145917y;
    }

    public String n() {
        return this.f145915w;
    }

    public String o() {
        return this.f145896d;
    }

    public int p() {
        return this.f145916x;
    }

    public byte[] q() {
        return this.f145894b;
    }

    public String r() {
        return this.f145901i;
    }

    public Runnable s() {
        return this.f145907o;
    }

    public String t() {
        return this.f145902j;
    }

    public int u() {
        return this.f145893a;
    }

    public String v() {
        return this.f145895c;
    }

    public boolean w() {
        return this.f145913u;
    }

    public boolean x() {
        return this.f145909q;
    }

    public boolean y() {
        return this.f145911s;
    }

    public boolean z() {
        return this.f145912t;
    }

    public void a(Map map) {
        this.f145898f = map;
    }

    public void b(String str) {
        this.f145906n = str;
    }

    public void c(String str) {
        this.f145915w = str;
    }

    public void d(String str) {
        this.f145901i = str;
    }

    public String e() {
        return this.f145904l;
    }

    public long f() {
        if (this.f145894b != null) {
            return r0.length;
        }
        return 0L;
    }

    public void g(boolean z16) {
        this.f145910r = z16;
    }

    public void a(ArrayList arrayList) {
        this.f145899g = arrayList;
    }

    public void b(boolean z16) {
        this.f145914v = z16;
    }

    public void c(boolean z16) {
        this.f145913u = z16;
    }

    public void d(boolean z16) {
        this.f145909q = z16;
    }

    public void e(boolean z16) {
        this.f145911s = z16;
    }

    public void a(int i3) {
        this.f145900h = i3;
    }

    public void b(int i3) {
        this.f145916x = i3;
    }

    public void f(boolean z16) {
        this.f145912t = z16;
    }

    public void a(String str) {
        this.f145904l = str;
    }

    public void a(HttpURLConnection httpURLConnection) {
        this.f145903k = httpURLConnection;
    }

    public void a(Runnable runnable) {
        this.f145907o = runnable;
    }

    public void a(boolean z16) {
        this.f145908p = z16;
    }
}
