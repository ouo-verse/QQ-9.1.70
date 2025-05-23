package com.tencent.aelight.camera.ae.camera.testpkg;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.flashshow.autotest.f;
import com.tencent.aelight.camera.ae.flashshow.autotest.g;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.qqcamerakit.common.d;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

/* loaded from: classes32.dex */
public class VideoCameraProxy implements com.tencent.aelight.camera.ae.camera.testpkg.b, HWDecodeListener {
    private List<d> C;
    private com.tencent.aelight.camera.ae.camera.testpkg.c E;
    private f F;

    /* renamed from: d, reason: collision with root package name */
    protected HWVideoDecoder f62283d;

    /* renamed from: e, reason: collision with root package name */
    protected List<DecodeConfig> f62284e;

    /* renamed from: h, reason: collision with root package name */
    protected VideoDecodeHardWare f62286h;

    /* renamed from: f, reason: collision with root package name */
    protected int f62285f = -1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f62287i = false;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f62288m = new Handler(Looper.getMainLooper());
    private Observer<g> D = new a();
    private Object G = new Object();
    private Object H = new Object();
    private boolean I = false;
    private long J = -1;
    private long K = -1;
    private long L = -1;

    /* loaded from: classes32.dex */
    class a implements Observer<g> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(g gVar) {
            QLog.i("VideoCameraProxy", 1, "lsNode = " + gVar.e() + " video = " + gVar.f());
            VideoCameraProxy.this.F(gVar);
        }
    }

    /* loaded from: classes32.dex */
    class b implements c {
        b() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.testpkg.VideoCameraProxy.c
        public void a() {
            QLog.e("VideoCameraProxy", 4, "endDecode SurfaceTextureForTest.");
            VideoCameraProxy.this.E.b();
            VideoCameraProxy.this.f62286h.i();
            QLog.d("VideoCameraProxy", 4, "InputBuffer BUFFER_FLAG_END_OF_STREAM");
            VideoCameraProxy.this.F.q();
        }

        @Override // com.tencent.aelight.camera.ae.camera.testpkg.VideoCameraProxy.c
        public void b(DecodeConfig decodeConfig) {
            VideoCameraProxy.this.f62286h.k();
            if (VideoCameraProxy.this.C == null || VideoCameraProxy.this.C.size() == 0) {
                return;
            }
            Object[] objArr = {new com.tencent.qqcamerakit.capture.d(decodeConfig.height, decodeConfig.width)};
            Iterator it = VideoCameraProxy.this.C.iterator();
            while (it.hasNext()) {
                ((d) it.next()).notify(2, 0, null, objArr);
            }
        }

        @Override // com.tencent.aelight.camera.ae.camera.testpkg.VideoCameraProxy.c
        public void c() {
            QLog.e("VideoCameraProxy", 4, "startDecode SurfaceTextureForTest.");
            VideoCameraProxy.this.E.c();
        }
    }

    /* loaded from: classes32.dex */
    public interface c {
        void a();

        void b(DecodeConfig decodeConfig);

        void c();
    }

    public VideoCameraProxy() {
        f a16 = f.INSTANCE.a();
        this.F = a16;
        List<g> f16 = a16.f();
        if (f16 == null) {
            return;
        }
        D(f16);
    }

    private DecodeConfig B() {
        int size = (this.f62285f + 1) % this.f62284e.size();
        this.f62285f = size;
        return this.f62284e.get(size);
    }

    private void C() {
        this.f62288m.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.testpkg.VideoCameraProxy.3
            @Override // java.lang.Runnable
            public void run() {
                VideoCameraProxy.this.F.e(VideoCameraProxy.this.D);
            }
        });
    }

    private void D(List<g> list) {
        this.f62284e = new ArrayList();
        for (g gVar : list) {
            if (gVar.f()) {
                DecodeConfig decodeConfig = new DecodeConfig(gVar.e(), 0, true, true, 0L, gVar.getLoc().mDuration);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(gVar.e());
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                long parseLong = Long.parseLong(extractMetadata);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
                int parseInt = Integer.parseInt(extractMetadata2);
                int parseInt2 = Integer.parseInt(extractMetadata3);
                int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (parseInt3 != 90 && parseInt3 != 270) {
                    decodeConfig.width = parseInt2;
                    decodeConfig.height = parseInt;
                } else {
                    decodeConfig.width = parseInt;
                    decodeConfig.height = parseInt2;
                }
                QLog.i("VideoCameraProxy", 4, gVar.e() + ":duration:" + extractMetadata + ",width:" + decodeConfig.width + ",height:" + decodeConfig.height + ", rotation = " + parseInt3);
                decodeConfig.endTimeMillSecond = parseLong;
                this.f62284e.add(decodeConfig);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(g gVar) {
        this.F.p(false);
        if (this.E == null) {
            return;
        }
        if (gVar.f()) {
            A();
        } else {
            z();
        }
    }

    private void y() {
        final BaseTimer baseTimer = new BaseTimer();
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.aelight.camera.ae.camera.testpkg.VideoCameraProxy.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (VideoCameraProxy.this.E == null) {
                    VideoCameraProxy.this.f62288m.removeCallbacksAndMessages(null);
                    baseTimer.cancel();
                } else {
                    VideoCameraProxy.this.E.a().onFrameAvailable(VideoCameraProxy.this.E);
                }
            }
        }, 0L, 33L);
        this.f62288m.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.testpkg.VideoCameraProxy.5
            @Override // java.lang.Runnable
            public void run() {
                baseTimer.cancel();
                VideoCameraProxy.this.F.q();
            }
        }, 4000L);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public int c() {
        return 0;
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public Object g() {
        return null;
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void j(boolean z16) {
        HWVideoDecoder hWVideoDecoder = this.f62283d;
        if (hWVideoDecoder != null) {
            hWVideoDecoder.stopDecode();
        }
        VideoDecodeHardWare videoDecodeHardWare = this.f62286h;
        if (videoDecodeHardWare != null) {
            videoDecodeHardWare.e();
        }
        this.f62287i = false;
        this.f62288m.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public long k() {
        return 0L;
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public boolean n(int i3) {
        return false;
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void o(d dVar) {
        if (this.C == null) {
            this.C = new ArrayList();
        }
        if (dVar == null || this.C.contains(dVar)) {
            return;
        }
        this.C.add(dVar);
        C();
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFrame(long j3, long j16) throws InterruptedException {
        QLog.i("VideoCameraProxy", 4, "onDecodeFrame.");
        synchronized (this.G) {
            this.K = j3;
            this.L = j16;
            synchronized (this.H) {
                this.H.notifyAll();
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoCameraProxy", 2, "onDecodeFrame start timestamp = " + j3);
            }
            try {
                this.G.wait(2000L);
                if (!this.I) {
                    this.J = -1L;
                    this.K = 0L;
                    this.L = 0L;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("VideoCameraProxy", 2, "onDecodeFrame end timestamp = " + j3);
                }
                this.I = false;
            } catch (InterruptedException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoCameraProxy", 2, "onDecodeFrame InterruptedException");
                }
                this.I = false;
                throw e16;
            }
        }
    }

    private void A() {
        E(true);
        this.f62286h.g(new Surface(this.E), B(), this.f62284e.size() == 1);
    }

    private void z() {
        E(false);
        y();
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeCancel() {
        QLog.i("VideoCameraProxy", 4, "onDecodeCancel.");
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeError(int i3, Throwable th5) {
        QLog.i("VideoCameraProxy", 4, "onDecodeError.");
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFinish() {
        QLog.i("VideoCameraProxy", 4, "onDecodeFinish.");
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeRepeat() {
        QLog.i("VideoCameraProxy", 4, "onDecodeRepeat.");
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeSeekTo(long j3) {
        QLog.i("VideoCameraProxy", 4, "onDecodeSeekTo.");
    }

    @Override // com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeStart() {
        QLog.i("VideoCameraProxy", 4, "onDecodeStart.");
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void r(SurfaceTexture surfaceTexture, com.tencent.qqcamerakit.capture.b bVar) {
        this.E = (com.tencent.aelight.camera.ae.camera.testpkg.c) surfaceTexture;
        if (this.f62287i) {
            return;
        }
        if (!(surfaceTexture instanceof com.tencent.aelight.camera.ae.camera.testpkg.c)) {
            QLog.e("VideoCameraProxy", 4, "surface is not instanceof SurfaceTextureForTest.");
            return;
        }
        this.f62287i = true;
        VideoDecodeHardWare videoDecodeHardWare = new VideoDecodeHardWare();
        this.f62286h = videoDecodeHardWare;
        videoDecodeHardWare.j(new b());
        this.F.q();
    }

    private void E(boolean z16) {
        com.tencent.aelight.camera.ae.flashshow.autotest.b.f64141g = !z16;
        com.tencent.aelight.camera.ae.flashshow.autotest.b.f64150p = !z16;
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void d(d dVar) {
        List<d> list;
        if (dVar == null || (list = this.C) == null) {
            return;
        }
        list.remove(dVar);
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void a(boolean z16) {
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void f(boolean z16) {
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void m(int i3) {
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void setZoom(float f16) {
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void b() {
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void e() {
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void h(int i3, boolean z16) {
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void i(int i3, long j3) {
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void p(com.tencent.qqcamerakit.capture.d dVar, boolean z16, String str, int i3, c.b bVar) {
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void l(com.tencent.qqcamerakit.capture.d dVar, com.tencent.qqcamerakit.capture.d dVar2, com.tencent.qqcamerakit.capture.d dVar3, int i3, String str, int i16, int i17) {
    }

    @Override // com.tencent.aelight.camera.ae.camera.testpkg.b
    public void q(Matrix matrix, c.a aVar, int i3, int i16, int i17, float f16, float f17) {
    }
}
