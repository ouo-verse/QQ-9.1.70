package com.tencent.mtt.hippy.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mtt.hippy.d.d;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.net.URI;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class p implements d.a {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mtt.hippy.d.d f337000a;

    /* renamed from: b, reason: collision with root package name */
    private final k f337001b;

    /* renamed from: c, reason: collision with root package name */
    private a f337002c;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f337005f = new Runnable() { // from class: com.tencent.mtt.hippy.a.p.1
        @Override // java.lang.Runnable
        public void run() {
            if (!p.this.f337003d) {
                return;
            }
            if (p.this.f337000a == null || !p.this.f337000a.c()) {
                p.this.a();
            }
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private boolean f337003d = false;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f337004e = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void c();

        void d();
    }

    public p(k kVar) {
        this.f337001b = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.tencent.mtt.hippy.d.d dVar = new com.tencent.mtt.hippy.d.d(URI.create(this.f337001b.a()), this, null);
        this.f337000a = dVar;
        dVar.a();
    }

    private void c() {
        this.f337004e.removeCallbacks(this.f337005f);
        this.f337004e.postDelayed(this.f337005f, 2000L);
    }

    @Override // com.tencent.mtt.hippy.d.d.a
    public void a(Exception exc) {
        if (this.f337003d) {
            c();
        }
    }

    @Override // com.tencent.mtt.hippy.d.d.a
    public void b() {
        this.f337004e.post(new Runnable() { // from class: com.tencent.mtt.hippy.a.p.2
            @Override // java.lang.Runnable
            public void run() {
                if (p.this.f337002c != null) {
                    p.this.f337002c.d();
                }
            }
        });
    }

    @Override // com.tencent.mtt.hippy.d.d.a
    public void a(byte[] bArr) {
    }

    @Override // com.tencent.mtt.hippy.d.d.a
    public void b(int i3, String str) {
        if (this.f337003d) {
            c();
        }
    }

    @Override // com.tencent.mtt.hippy.d.d.a
    public void b(String str) {
        try {
            String optString = new JSONObject(str).optString("action");
            if (this.f337002c != null && optString.equals("compileSuccess")) {
                this.f337004e.post(new Runnable() { // from class: com.tencent.mtt.hippy.a.p.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (p.this.f337002c != null) {
                            p.this.f337002c.c();
                        }
                    }
                });
            }
        } catch (Exception unused) {
            LogUtils.e("hippy_console", "revceive invalid live reload msg");
        }
    }
}
