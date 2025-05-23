package com.tencent.av.audio;

import android.annotation.TargetApi;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import java.lang.ref.WeakReference;

/* compiled from: P */
@TargetApi(29)
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private MediaProjection f73216a;

    /* renamed from: b, reason: collision with root package name */
    private ShareAudioCapture f73217b;

    /* renamed from: c, reason: collision with root package name */
    private bc f73218c;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a implements Handler.Callback {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<d> f73219d;

        a(d dVar) {
            this.f73219d = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            d dVar = this.f73219d.get();
            if (dVar != null) {
                dVar.c(message.what, message.obj);
                return false;
            }
            return false;
        }
    }

    public void a() {
        i(4, null);
    }

    @VisibleForTesting
    public void b() {
        this.f73216a = null;
    }

    public void c(int i3, Object obj) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        b();
                        return;
                    }
                    return;
                }
                l((MediaProjection) obj);
                return;
            }
            f();
            return;
        }
        h();
    }

    public void d() {
        this.f73217b = new ShareAudioCapture();
        this.f73218c = ThreadManagerV2.newHandlerRecycleThread("ShareAudioCaptureHelper" + ((int) (Math.random() * 100.0d)), 0).a(new a(this));
    }

    public void e() {
        i(2, null);
    }

    @VisibleForTesting
    public void f() {
        ShareAudioCapture shareAudioCapture = this.f73217b;
        if (shareAudioCapture != null) {
            shareAudioCapture.k();
        }
    }

    public void g() {
        i(1, null);
    }

    @VisibleForTesting
    public void h() {
        ShareAudioCapture shareAudioCapture = this.f73217b;
        if (shareAudioCapture != null) {
            shareAudioCapture.i(this.f73216a);
        }
    }

    public void i(int i3, Object obj) {
        bc bcVar = this.f73218c;
        if (bcVar != null) {
            bcVar.obtainMessage(i3, obj).sendToTarget();
        }
    }

    public void j(e eVar) {
        this.f73217b.g(eVar);
    }

    public void k(MediaProjection mediaProjection) {
        i(3, mediaProjection);
    }

    @VisibleForTesting
    public void l(MediaProjection mediaProjection) {
        this.f73216a = mediaProjection;
    }

    public void m() {
        this.f73217b = null;
        if (this.f73218c != null) {
            this.f73218c = null;
        }
    }
}
