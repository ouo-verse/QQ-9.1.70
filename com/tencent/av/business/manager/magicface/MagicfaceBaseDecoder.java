package com.tencent.av.business.manager.magicface;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class MagicfaceBaseDecoder {

    /* renamed from: a, reason: collision with root package name */
    protected c f73352a;

    /* renamed from: b, reason: collision with root package name */
    WeakReference<a> f73353b;

    /* renamed from: c, reason: collision with root package name */
    WeakReference<b> f73354c;

    /* renamed from: e, reason: collision with root package name */
    String f73356e;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f73355d = false;

    /* renamed from: f, reason: collision with root package name */
    Handler f73357f = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(long j3, String str);

        void b(long j3, String str, int i3);

        void c(long j3, String str);

        void e(long j3, String str, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void a(Bitmap bitmap, Bitmap bitmap2, boolean z16, boolean z17, boolean z18, boolean z19, Rect rect);
    }

    public abstract int a();

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(final String str) {
        if (this.f73353b != null) {
            this.f73357f.post(new Runnable() { // from class: com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.5
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = MagicfaceBaseDecoder.this.f73353b.get();
                    if (aVar != null) {
                        aVar.a(-1040L, str);
                    }
                }
            });
        }
    }

    protected void c(final String str, final int i3) {
        if (this.f73353b != null) {
            this.f73357f.post(new Runnable() { // from class: com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.3
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = MagicfaceBaseDecoder.this.f73353b.get();
                    if (aVar != null) {
                        aVar.b(-1038L, str, i3);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(final String str, final boolean z16) {
        if (this.f73353b != null) {
            this.f73357f.post(new Runnable() { // from class: com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.4
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = MagicfaceBaseDecoder.this.f73353b.get();
                    if (aVar != null) {
                        aVar.e(-1039L, str, z16);
                    }
                }
            });
        }
    }

    protected void e(final String str) {
        if (this.f73353b != null) {
            this.f73357f.post(new Runnable() { // from class: com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.2
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = MagicfaceBaseDecoder.this.f73353b.get();
                    if (aVar != null) {
                        aVar.c(-1037L, str);
                    }
                }
            });
        }
    }

    public void f(a aVar) {
        this.f73353b = new WeakReference<>(aVar);
    }

    public void g(c cVar) {
        this.f73352a = cVar;
    }

    public void h(b bVar) {
        if (bVar != null) {
            this.f73354c = new WeakReference<>(bVar);
        } else {
            this.f73354c = null;
        }
    }

    public void i(String str) {
        this.f73356e = str;
    }

    public void j() {
        if (!this.f73355d) {
            this.f73352a.h();
            try {
                new BaseThread(new Runnable() { // from class: com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int priority = Thread.currentThread().getPriority();
                        Thread.currentThread().setPriority(10);
                        String b16 = MagicfaceBaseDecoder.this.f73352a.b();
                        MagicfaceBaseDecoder.this.f73355d = true;
                        MagicfaceBaseDecoder.this.e(b16);
                        int a16 = MagicfaceBaseDecoder.this.a();
                        MagicfaceBaseDecoder.this.f73355d = false;
                        MagicfaceBaseDecoder.this.f73352a.i();
                        MagicfaceBaseDecoder.this.c(b16, a16);
                        Thread.currentThread().setPriority(priority);
                    }
                }).start();
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("MagicfaceBaseDecoder", 1, "startDecoder err:" + e16.getMessage());
                }
            }
        }
    }

    public void k() {
        this.f73355d = false;
        this.f73352a.i();
    }
}
