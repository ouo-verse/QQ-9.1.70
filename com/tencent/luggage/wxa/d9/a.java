package com.tencent.luggage.wxa.d9;

import android.text.TextUtils;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.y;
import com.tencent.luggage.wxa.cp.z;
import com.tencent.luggage.wxa.g9.k;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    public static a f124134f;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f124135a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public Object f124136b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final String f124137c = "audio_cache_path_file.txt";

    /* renamed from: d, reason: collision with root package name */
    public String f124138d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f124139e;

    public static a e() {
        if (f124134f == null) {
            synchronized (a.class) {
                if (f124134f == null) {
                    f124134f = new a();
                }
            }
        }
        return f124134f;
    }

    public void c(String str) {
        com.tencent.luggage.wxa.e9.f fVar;
        if (!TextUtils.isEmpty(this.f124138d) && !str.equals(this.f124138d)) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioCachePathMgr", "init");
            String str2 = this.f124138d;
            this.f124138d = str;
            fVar = new C6136a(str2, str);
        } else if (TextUtils.isEmpty(this.f124138d)) {
            this.f124138d = str;
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioCachePathMgr", "init");
            fVar = new b(str);
        } else {
            fVar = null;
        }
        if (fVar != null) {
            a(fVar, "init cache path");
        }
    }

    public final v d() {
        v vVar = new v(this.f124139e);
        if (!vVar.e()) {
            try {
                vVar.c();
            } catch (IOException e16) {
                com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioCachePathMgr", e16, "getCacheFile", new Object[0]);
            }
        }
        return vVar;
    }

    public void f() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioCachePathMgr", "readData");
        a(new d(), "readData");
    }

    public void g() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioCachePathMgr", "saveData");
        a(new c(), "saveData");
    }

    public final synchronized void b() {
        if (this.f124135a.isEmpty()) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioCachePathMgr", "data is empty");
            return;
        }
        try {
            new v(this.f124139e).d();
            BufferedWriter bufferedWriter = new BufferedWriter(new z(d()));
            Iterator it = this.f124135a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                bufferedWriter.newLine();
                bufferedWriter.write(str);
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioCachePathMgr", "line count:%s", Integer.valueOf(this.f124135a.size()));
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioCachePathMgr", e16, "asyncRead", new Object[0]);
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioCachePathMgr", "save end");
    }

    public final synchronized void a() {
        try {
            this.f124135a.clear();
            BufferedReader bufferedReader = new BufferedReader(new y(d()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (!TextUtils.isEmpty(readLine)) {
                    this.f124135a.add(readLine);
                }
            }
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioCachePathMgr", "line count:%s", Integer.valueOf(this.f124135a.size()));
            bufferedReader.close();
        } catch (IOException e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioCachePathMgr", e16, "asyncRead", new Object[0]);
        }
    }

    public synchronized boolean d(String str) {
        return this.f124135a.contains(com.tencent.luggage.wxa.m9.c.a("" + str.hashCode()));
    }

    public void c() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioCachePathMgr", "close");
        g();
    }

    public synchronized boolean a(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioCachePathMgr", "append path:%s", str);
        String a16 = com.tencent.luggage.wxa.m9.c.a("" + str.hashCode());
        if (!this.f124135a.contains(a16)) {
            this.f124135a.add(a16);
        }
        return true;
    }

    public void a(com.tencent.luggage.wxa.e9.f fVar, String str) {
        com.tencent.luggage.wxa.e9.e eVar = new com.tencent.luggage.wxa.e9.e(fVar, str, 5);
        k.a();
        k.b(eVar);
    }

    public synchronized boolean b(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioCachePathMgr", "delete path:%s", str);
        String a16 = com.tencent.luggage.wxa.m9.c.a("" + str.hashCode());
        if (!this.f124135a.contains(a16)) {
            this.f124135a.remove(a16);
        }
        return true;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.d9.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6136a implements com.tencent.luggage.wxa.e9.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f124140a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f124141b;

        public C6136a(String str, String str2) {
            this.f124140a = str;
            this.f124141b = str2;
        }

        @Override // com.tencent.luggage.wxa.e9.f
        public void a() {
            a.this.f124139e = com.tencent.luggage.wxa.m9.a.a(this.f124140a, "audio_cache_path_file.txt");
            a.this.g();
            a.this.f124139e = com.tencent.luggage.wxa.m9.a.a(this.f124141b, "audio_cache_path_file.txt");
            a.this.f();
        }

        @Override // com.tencent.luggage.wxa.e9.f
        public void b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.e9.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f124143a;

        public b(String str) {
            this.f124143a = str;
        }

        @Override // com.tencent.luggage.wxa.e9.f
        public void a() {
            a.this.f124139e = com.tencent.luggage.wxa.m9.a.a(this.f124143a, "audio_cache_path_file.txt");
            a.this.f();
        }

        @Override // com.tencent.luggage.wxa.e9.f
        public void b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.e9.f {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.e9.f
        public void a() {
            a.this.b();
        }

        @Override // com.tencent.luggage.wxa.e9.f
        public void b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.e9.f {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.e9.f
        public void a() {
            a.this.a();
        }

        @Override // com.tencent.luggage.wxa.e9.f
        public void b() {
        }
    }
}
