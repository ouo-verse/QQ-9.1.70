package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.heytap.databaseengine.apiv3.data.Element;
import com.xiaomi.push.af;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class cf {

    /* renamed from: c, reason: collision with root package name */
    private static volatile cf f388385c;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentLinkedQueue<d> f388386a;

    /* renamed from: b, reason: collision with root package name */
    private Context f388387b;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends d {

        /* renamed from: c, reason: collision with root package name */
        File f388388c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f388389d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Date f388390e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Date f388391f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f388392g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f388393h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f388394i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i3, Date date, Date date2, String str, String str2, boolean z16) {
            super();
            this.f388389d = i3;
            this.f388390e = date;
            this.f388391f = date2;
            this.f388392g = str;
            this.f388393h = str2;
            this.f388394i = z16;
        }

        @Override // com.xiaomi.push.cf.d, com.xiaomi.push.af.c
        public void b() {
            try {
                File file = new File(cf.this.f388387b.getFilesDir() + "/.logcache");
                if (!im.b(file)) {
                    return;
                }
                file.mkdirs();
                if (file.isDirectory()) {
                    ce ceVar = new ce();
                    ceVar.d(this.f388389d);
                    this.f388388c = ceVar.c(cf.this.f388387b, this.f388390e, this.f388391f, file);
                }
            } catch (NullPointerException unused) {
            }
        }

        @Override // com.xiaomi.push.af.c
        public void c() {
            File file = this.f388388c;
            if (file != null && file.exists()) {
                cf.this.f388386a.add(new e(this.f388392g, this.f388393h, this.f388388c, this.f388394i));
            }
            cf.this.e(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b extends af.c {

        /* renamed from: a, reason: collision with root package name */
        af.c f388396a;

        b() {
        }

        @Override // com.xiaomi.push.af.c
        public void b() {
            d dVar = (d) cf.this.f388386a.peek();
            if (dVar != null && dVar.d()) {
                if (cf.this.f388386a.remove(dVar)) {
                    this.f388396a = dVar;
                }
                af.c cVar = this.f388396a;
                if (cVar != null) {
                    cVar.b();
                }
            }
        }

        @Override // com.xiaomi.push.af.c
        public void c() {
            af.c cVar = this.f388396a;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class c extends d {
        c() {
            super();
        }

        @Override // com.xiaomi.push.cf.d, com.xiaomi.push.af.c
        public void b() {
            cf.this.i();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class e extends d {

        /* renamed from: c, reason: collision with root package name */
        String f388401c;

        /* renamed from: d, reason: collision with root package name */
        String f388402d;

        /* renamed from: e, reason: collision with root package name */
        File f388403e;

        /* renamed from: f, reason: collision with root package name */
        int f388404f;

        /* renamed from: g, reason: collision with root package name */
        boolean f388405g;

        /* renamed from: h, reason: collision with root package name */
        boolean f388406h;

        e(String str, String str2, File file, boolean z16) {
            super();
            this.f388401c = str;
            this.f388402d = str2;
            this.f388403e = file;
            this.f388406h = z16;
        }

        private boolean f() {
            int i3;
            int i16 = 0;
            SharedPreferences sharedPreferences = cf.this.f388387b.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i3 = jSONObject.getInt(Element.ELEMENT_NAME_TIMES);
            } catch (JSONException unused) {
                i3 = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis < 86400000) {
                if (i3 > 10) {
                    return false;
                }
                i16 = i3;
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put(Element.ELEMENT_NAME_TIMES, i16 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e16) {
                jz4.c.z("JSONException on put " + e16.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.cf.d, com.xiaomi.push.af.c
        public void b() {
            try {
                if (f()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.ae.g());
                    hashMap.put("token", this.f388402d);
                    hashMap.put("net", au.j(cf.this.f388387b));
                    au.n(this.f388401c, hashMap, this.f388403e, "file");
                }
                this.f388405g = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.af.c
        public void c() {
            if (!this.f388405g) {
                int i3 = this.f388404f + 1;
                this.f388404f = i3;
                if (i3 < 3) {
                    cf.this.f388386a.add(this);
                }
            }
            if (this.f388405g || this.f388404f >= 3) {
                this.f388403e.delete();
            }
            cf.this.e((1 << this.f388404f) * 1000);
        }

        @Override // com.xiaomi.push.cf.d
        public boolean d() {
            if (!au.x(cf.this.f388387b) && (!this.f388406h || !au.t(cf.this.f388387b))) {
                return false;
            }
            return true;
        }
    }

    cf(Context context) {
        ConcurrentLinkedQueue<d> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f388386a = concurrentLinkedQueue;
        this.f388387b = context;
        concurrentLinkedQueue.add(new c());
        j(0L);
    }

    public static cf b(Context context) {
        if (f388385c == null) {
            synchronized (cf.class) {
                if (f388385c == null) {
                    f388385c = new cf(context);
                }
            }
        }
        f388385c.f388387b = context;
        return f388385c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(long j3) {
        d peek = this.f388386a.peek();
        if (peek != null && peek.d()) {
            j(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            File file = new File(this.f388387b.getFilesDir() + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void j(long j3) {
        if (!this.f388386a.isEmpty()) {
            fn.b(new b(), j3);
        }
    }

    private void k() {
        while (!this.f388386a.isEmpty()) {
            d peek = this.f388386a.peek();
            if (peek != null) {
                if (peek.e() || this.f388386a.size() > 6) {
                    jz4.c.z("remove Expired task");
                    this.f388386a.remove(peek);
                } else {
                    return;
                }
            }
        }
    }

    public void d() {
        k();
        e(0L);
    }

    public void h(String str, String str2, Date date, Date date2, int i3, boolean z16) {
        this.f388386a.add(new a(i3, date, date2, str, str2, z16));
        j(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class d extends af.c {

        /* renamed from: a, reason: collision with root package name */
        long f388399a = System.currentTimeMillis();

        d() {
        }

        public boolean d() {
            return true;
        }

        final boolean e() {
            if (System.currentTimeMillis() - this.f388399a > 172800000) {
                return true;
            }
            return false;
        }

        @Override // com.xiaomi.push.af.c
        public void b() {
        }
    }
}
