package com.qzone.publish.business.model;

import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f51010a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f51011b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f51012c;

    /* renamed from: d, reason: collision with root package name */
    public long f51013d;

    /* renamed from: e, reason: collision with root package name */
    public int f51014e;

    /* renamed from: f, reason: collision with root package name */
    public int f51015f;

    /* renamed from: g, reason: collision with root package name */
    public int f51016g;

    /* renamed from: h, reason: collision with root package name */
    public long f51017h;

    /* renamed from: i, reason: collision with root package name */
    public long f51018i;

    /* renamed from: j, reason: collision with root package name */
    public long f51019j;

    /* renamed from: k, reason: collision with root package name */
    public Vector<C0436a> f51020k;

    /* renamed from: l, reason: collision with root package name */
    public int f51021l;

    /* renamed from: m, reason: collision with root package name */
    public long f51022m;

    /* renamed from: n, reason: collision with root package name */
    public long f51023n;

    /* renamed from: o, reason: collision with root package name */
    public long f51024o;

    /* renamed from: p, reason: collision with root package name */
    public Vector<C0436a> f51025p;

    /* compiled from: P */
    /* renamed from: com.qzone.publish.business.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static class C0436a {

        /* renamed from: a, reason: collision with root package name */
        public int f51026a;

        /* renamed from: b, reason: collision with root package name */
        public String f51027b;

        /* renamed from: c, reason: collision with root package name */
        public long f51028c;

        /* renamed from: d, reason: collision with root package name */
        public long f51029d;

        /* renamed from: e, reason: collision with root package name */
        public long f51030e;

        /* renamed from: f, reason: collision with root package name */
        public long f51031f;

        public C0436a(int i3, String str) {
            this.f51026a = i3;
            this.f51027b = str;
        }

        public long a() {
            long j3 = this.f51030e;
            if (j3 == 0) {
                return 0L;
            }
            long j16 = this.f51031f;
            if (j16 != 0) {
                return j16 - j3;
            }
            return 0L;
        }

        public String toString() {
            return hashCode() + ":" + this.f51027b + "|" + this.f51028c + "|" + this.f51029d + "|" + a();
        }
    }

    public synchronized void a(C0436a c0436a) {
        if (c0436a == null) {
            return;
        }
        int i3 = c0436a.f51026a;
        if (i3 == 1) {
            if (this.f51025p == null) {
                this.f51025p = new Vector<>();
            }
            this.f51025p.add(c0436a);
            this.f51015f++;
            this.f51021l++;
            this.f51022m += c0436a.f51028c;
            this.f51023n += c0436a.f51029d;
            this.f51024o += c0436a.a();
        } else if (i3 == 2) {
            if (this.f51020k == null) {
                this.f51020k = new Vector<>();
            }
            this.f51020k.add(c0436a);
            this.f51015f++;
            this.f51016g++;
            this.f51017h += c0436a.f51028c;
            this.f51018i += c0436a.f51029d;
            this.f51019j += c0436a.a();
        }
    }

    public long b() {
        long j3 = this.f51013d;
        long j16 = this.f51012c;
        if (j3 >= j16) {
            return j3 - j16;
        }
        return -1L;
    }

    public JSONObject c() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("task_type", String.valueOf(this.f51010a));
            jSONObject.put("task_subtype", String.valueOf(this.f51011b));
            jSONObject.put("task_time", String.valueOf(b()));
            jSONObject.put("retry_count", String.valueOf(this.f51014e));
            jSONObject.put("media_num", String.valueOf(this.f51015f));
            jSONObject.put("video_num", String.valueOf(this.f51016g));
            jSONObject.put("video_origin_size", String.valueOf(this.f51017h));
            jSONObject.put("video_compressed_size", String.valueOf(this.f51018i));
            jSONObject.put("video_compress_time", String.valueOf(this.f51019j));
            Vector<C0436a> vector = this.f51020k;
            String str2 = "";
            if (vector == null) {
                str = "";
            } else {
                str = vector.toString();
            }
            jSONObject.put("video_extend", str);
            jSONObject.put("photo_num", String.valueOf(this.f51021l));
            jSONObject.put("photo_origin_size", String.valueOf(this.f51022m));
            jSONObject.put("photo_compressed_size", String.valueOf(this.f51023n));
            jSONObject.put("photo_compress_time", String.valueOf(this.f51024o));
            Vector<C0436a> vector2 = this.f51025p;
            if (vector2 != null) {
                str2 = vector2.toString();
            }
            jSONObject.put("photo_extend", str2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }
}
