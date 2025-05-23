package com.tencent.mtt.hippy.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mtt.hippy.a.f;
import com.tencent.mtt.hippy.d.d;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.net.URI;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements d.a {

    /* renamed from: a, reason: collision with root package name */
    com.tencent.mtt.hippy.d.d f336939a;

    /* renamed from: c, reason: collision with root package name */
    private a f336941c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f336942d;

    /* renamed from: e, reason: collision with root package name */
    private f.a f336943e;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, a> f336940b = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f336944f = new Runnable() { // from class: com.tencent.mtt.hippy.a.b.1
        @Override // java.lang.Runnable
        public void run() {
            com.tencent.mtt.hippy.d.d dVar = b.this.f336939a;
            if (dVar != null && !dVar.c()) {
                b.this.f336939a.a();
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(String str);

        void a(Throwable th5);
    }

    private void c() {
        this.f336942d.removeCallbacks(this.f336944f);
        this.f336942d.postDelayed(this.f336944f, 3000L);
    }

    public void a() {
        com.tencent.mtt.hippy.d.d dVar = this.f336939a;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.tencent.mtt.hippy.d.d.a
    public void b() {
        a aVar = this.f336941c;
        if (aVar != null) {
            aVar.a((String) null);
        }
        this.f336941c = null;
    }

    public void a(int i3, String str) {
        com.tencent.mtt.hippy.d.d dVar = this.f336939a;
        if (dVar != null) {
            dVar.a(i3, str);
        }
    }

    @Override // com.tencent.mtt.hippy.d.d.a
    public void b(int i3, String str) {
        LogUtils.d("onDisconnect", "code:" + i3 + ",reason:" + str);
        if (i3 == 0 && ("EOF".equals(str) || "CONNECT".equals(str))) {
            c();
        } else {
            this.f336939a = null;
            this.f336942d.removeCallbacks(this.f336944f);
        }
    }

    public void a(f.a aVar) {
        this.f336943e = aVar;
    }

    @Override // com.tencent.mtt.hippy.d.d.a
    public void b(String str) {
        this.f336943e.onReceiveData(str);
    }

    @Override // com.tencent.mtt.hippy.d.d.a
    public void a(Exception exc) {
        a((Throwable) exc);
    }

    public void a(String str) {
        com.tencent.mtt.hippy.d.d dVar = this.f336939a;
        if (dVar == null || !dVar.c()) {
            LogUtils.e("sendMessage", "mWebSocket is null");
        } else {
            this.f336939a.a(str);
        }
    }

    public void a(String str, a aVar) {
        this.f336941c = aVar;
        com.tencent.mtt.hippy.d.d dVar = new com.tencent.mtt.hippy.d.d(URI.create(str), this, null);
        this.f336939a = dVar;
        dVar.a();
        this.f336942d = new Handler(Looper.getMainLooper());
    }

    private void a(Throwable th5) {
        a();
        a aVar = this.f336941c;
        if (aVar != null) {
            aVar.a(th5);
            this.f336941c = null;
        }
        Iterator<a> it = this.f336940b.values().iterator();
        while (it.hasNext()) {
            it.next().a(th5);
        }
        this.f336940b.clear();
    }

    @Override // com.tencent.mtt.hippy.d.d.a
    public void a(byte[] bArr) {
    }
}
