package com.tencent.luggage.wxa.s8;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public h f140140a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f140141b;

    /* renamed from: c, reason: collision with root package name */
    public a f140142c;

    /* renamed from: d, reason: collision with root package name */
    public FloatBuffer f140143d;

    /* renamed from: e, reason: collision with root package name */
    public List f140144e;

    /* renamed from: f, reason: collision with root package name */
    public j f140145f;

    /* renamed from: g, reason: collision with root package name */
    public StringBuilder f140146g = new StringBuilder();

    public g(e eVar, c cVar) {
        h hVar = new h(eVar, this);
        this.f140140a = hVar;
        hVar.a(cVar);
        this.f140141b = new HashMap();
        this.f140142c = new a();
        this.f140144e = new ArrayList();
    }

    public final k a(char c16, int i3) {
        if (this.f140145f == null) {
            return null;
        }
        String a16 = a(c16);
        k kVar = (k) this.f140141b.get(a16);
        if (kVar != null) {
            return kVar;
        }
        k a17 = this.f140140a.a(c16, i3);
        if (a17 == null) {
            com.tencent.luggage.wxa.p8.f.a("MagicBrush.MBFontGlyphManager", "Load glyph failed. glyph == null [" + c16 + "]", new Object[0]);
            return null;
        }
        this.f140141b.put(a16, a17);
        return a17;
    }

    public FloatBuffer b(String str) {
        List c16;
        if (str == null || str.length() == 0 || (c16 = c(str)) == null || c16.size() == 0) {
            return null;
        }
        FloatBuffer a16 = a(str.length());
        float a17 = this.f140140a.a(c16);
        Paint.FontMetrics a18 = this.f140140a.a();
        a16.put(a17).put(a18.ascent).put(a18.bottom).put(a18.bottom - a18.ascent);
        k.a(a16, c16);
        a16.flip();
        this.f140144e.clear();
        return a16;
    }

    public final List c(String str) {
        k a16;
        if (str == null || str.length() == 0) {
            return null;
        }
        this.f140144e.clear();
        int i3 = 0;
        while (i3 < str.length()) {
            int a17 = a(str, i3);
            if (a17 > 0) {
                a16 = b(str, i3, a17);
                i3 += a17;
            } else {
                a16 = a(str.charAt(i3), i3);
                i3++;
            }
            if (a16 == null) {
                this.f140144e.clear();
                return null;
            }
            this.f140144e.add(a16);
        }
        return this.f140144e;
    }

    public float d(String str) {
        if (str != null && str.length() != 0) {
            List c16 = c(str);
            if (c16 != null && c16.size() != 0) {
                return this.f140140a.a(c16);
            }
            return -1.0f;
        }
        return 0.0f;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Queue f140147a = new LinkedList();

        public k a() {
            k kVar = (k) this.f140147a.poll();
            return kVar == null ? new k() : kVar;
        }

        public void a(k kVar) {
            if (kVar != null) {
                kVar.a();
                this.f140147a.offer(kVar);
            }
        }
    }

    public final int a(String str, int i3) {
        if (com.tencent.luggage.wxa.p8.a.a() == null) {
            return 0;
        }
        return com.tencent.luggage.wxa.p8.a.a().b(str, i3);
    }

    public final String a(String str, int i3, int i16) {
        if (i16 > 0) {
            this.f140146g.setLength(0);
            while (i16 > 0) {
                this.f140146g.append(str.charAt(i3));
                i3++;
                i16--;
            }
            StringBuilder sb5 = this.f140146g;
            sb5.append("|");
            sb5.append(this.f140145f.f140166c);
            return this.f140146g.toString();
        }
        throw new IllegalStateException("There is no font drawable");
    }

    public final String a(char c16) {
        if (this.f140145f == null) {
            return null;
        }
        this.f140146g.setLength(0);
        StringBuilder sb5 = this.f140146g;
        sb5.append(c16);
        sb5.append("|");
        sb5.append(this.f140145f.f140166c);
        sb5.append("|");
        Typeface typeface = this.f140145f.f140164a;
        sb5.append(typeface == null ? "null" : Integer.valueOf(typeface.hashCode()));
        if (this.f140145f.f140167d) {
            sb5.append("|");
            sb5.append(this.f140145f.f140168e);
        }
        if (this.f140145f.f140169f != null) {
            sb5.append("|");
            sb5.append(this.f140145f.f140169f.f140175a);
        }
        return sb5.toString();
    }

    public final k b(String str, int i3, int i16) {
        int i17;
        String a16 = a(str, i3, i16);
        k kVar = (k) this.f140141b.get(a16);
        if (kVar != null) {
            return kVar;
        }
        if (com.tencent.luggage.wxa.p8.a.a() != null) {
            Drawable a17 = com.tencent.luggage.wxa.p8.a.a().a(str, i3);
            if (a17 == null || (i17 = (int) this.f140145f.f140166c) <= 0 || i17 <= 0) {
                return null;
            }
            k a18 = this.f140140a.a(a17, i17, i17);
            if (a18 == null) {
                com.tencent.luggage.wxa.p8.f.a("MagicBrush.MBFontGlyphManager", "Load font drawable glyph failed.", new Object[0]);
                return null;
            }
            a18.f140186j = i16;
            this.f140141b.put(a16, a18);
            return a18;
        }
        throw new IllegalStateException("FontDrawableProvider must support");
    }

    public void b() {
        h hVar = this.f140140a;
        if (hVar != null) {
            hVar.f();
            this.f140140a = null;
        }
    }

    public void a(j jVar) {
        this.f140145f = jVar;
        this.f140140a.a(jVar);
    }

    public float a(String str) {
        return this.f140140a.a(str);
    }

    public void a() {
        HashMap hashMap = this.f140141b;
        if (hashMap != null) {
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                this.f140142c.a((k) it.next());
            }
            this.f140141b.clear();
        }
    }

    public final FloatBuffer a(int i3) {
        int max = (Math.max(i3, 10) * 40) + 16;
        FloatBuffer floatBuffer = this.f140143d;
        if (floatBuffer == null || floatBuffer.capacity() * 4 < max) {
            this.f140143d = ByteBuffer.allocateDirect(max).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.f140143d.clear();
        return this.f140143d;
    }
}
