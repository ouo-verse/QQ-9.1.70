package com.tencent.mobileqq.editor.composite.step;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.opengl.EGL14;
import android.support.annotation.RequiresApi;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.e;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f204017a;

    /* renamed from: b, reason: collision with root package name */
    private final int f204018b;

    /* renamed from: c, reason: collision with root package name */
    private final int f204019c;

    /* renamed from: d, reason: collision with root package name */
    private final int f204020d;

    /* renamed from: e, reason: collision with root package name */
    private e f204021e;

    /* renamed from: f, reason: collision with root package name */
    private QQFilterRenderManager f204022f;

    /* renamed from: g, reason: collision with root package name */
    private int f204023g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<Integer> f204024h;

    /* renamed from: i, reason: collision with root package name */
    private long f204025i;

    /* renamed from: j, reason: collision with root package name */
    private long f204026j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f204027k;

    /* renamed from: l, reason: collision with root package name */
    private int f204028l;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements com.tencent.mobileqq.videocodec.mediacodec.recorder.c {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public long f204029d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f204030e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ VideoStoryPicToVideo.a f204031f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ VideoStoryPicToVideo.b f204032h;

        a(List list, VideoStoryPicToVideo.a aVar, VideoStoryPicToVideo.b bVar) {
            this.f204030e = list;
            this.f204031f = aVar;
            this.f204032h = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, list, aVar, bVar);
            }
        }

        private boolean a() {
            int longValue;
            if (c.this.f204024h.size() == 1) {
                longValue = 0;
            } else {
                longValue = (int) (c.this.f204026j / ((Long.valueOf("2").longValue() * 1000) * 1000000));
                if (longValue >= c.this.f204024h.size()) {
                    return false;
                }
            }
            long j3 = c.this.f204023g * 1000000;
            if (c.this.f204021e == null || ((Integer) c.this.f204024h.get(longValue)).intValue() <= 0 || c.this.f204026j >= c.this.f204025i * 1000000) {
                return false;
            }
            c.this.f204021e.h(GLSLRender.GL_TEXTURE_2D, ((Integer) c.this.f204024h.get(0)).intValue(), null, null, c.this.f204026j);
            c.m(c.this, j3);
            return true;
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeError(int i3, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) th5);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + i3);
            }
            synchronized (c.this) {
                c.this.notifyAll();
            }
            if (this.f204031f != null) {
                this.f204032h.c(th5.getMessage());
                this.f204032h.b(943001);
                this.f204031f.b(this.f204032h);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFinish(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (currentTimeMillis - this.f204029d) + " ms mGpuBlur:" + c.this.f204027k);
            }
            VideoStoryPicToVideo.a aVar = this.f204031f;
            if (aVar != null) {
                aVar.a(this.f204032h);
            }
            if (c.this.f204022f != null) {
                c.this.f204022f.surfaceDestroyed();
                c.this.f204022f = null;
            }
            if (c.this.f204021e != null) {
                c.this.f204021e.n();
                c.this.f204021e = null;
            }
            if (c.this.f204024h != null) {
                c.this.f204024h.clear();
            }
            synchronized (c.this) {
                c.this.notifyAll();
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFrame() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
            if (!a() && c.this.f204021e != null) {
                c.this.f204021e.s();
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeStart() {
            int p16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (Bitmap bitmap : this.f204030e) {
                if (!c.this.f204027k) {
                    c cVar = c.this;
                    p16 = cVar.o(bitmap, cVar.f204019c, c.this.f204018b);
                } else {
                    c cVar2 = c.this;
                    p16 = cVar2.p(bitmap, cVar2.f204019c, c.this.f204018b);
                }
                c.this.f204024h.add(Integer.valueOf(p16));
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (currentTimeMillis2 - currentTimeMillis) + " ms mGpuBlur:" + c.this.f204027k);
            }
            this.f204029d = System.currentTimeMillis();
            a();
        }
    }

    public c(String str, int i3, int i16, int i17, long j3, boolean z16, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i18));
            return;
        }
        this.f204023g = 42;
        this.f204024h = new ArrayList<>();
        this.f204017a = str;
        this.f204025i = j3;
        this.f204019c = i3;
        this.f204018b = i16;
        this.f204020d = i17;
        this.f204027k = z16;
        this.f204028l = i18;
    }

    static /* synthetic */ long m(c cVar, long j3) {
        long j16 = cVar.f204026j + j3;
        cVar.f204026j = j16;
        return j16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o(Bitmap bitmap, int i3, int i16) {
        if (bitmap != null && i16 != 0 && i3 != 0) {
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            float f16 = i3;
            float f17 = f16 * 1.0f;
            float f18 = i16;
            bitmap.getWidth();
            bitmap.getHeight();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postTranslate(width * (-0.5f), height * (-0.5f));
            int i17 = this.f204028l;
            if (i17 != 180 && i17 != 270) {
                matrix.postRotate(-180.0f, 0.0f, 1.0f);
            }
            matrix.postScale(-1.0f, 1.0f);
            float width2 = f17 / bitmap.getWidth();
            matrix.postScale(width2, width2);
            matrix.postTranslate(f16 * 0.5f, f18 * 0.5f);
            canvas.drawBitmap(bitmap, matrix, null);
            return GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, createBitmap);
        }
        if (bitmap == null) {
            return 0;
        }
        return GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p(Bitmap bitmap, int i3, int i16) {
        if (bitmap != null && i16 != 0 && i3 != 0) {
            int createTexture = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, bitmap);
            if (this.f204022f == null) {
                this.f204022f = new QQFilterRenderManager();
            }
            this.f204022f.surfaceCreate(i3, i16, i3, i16);
            this.f204022f.surfaceChange(i3, i16, i3, i16);
            this.f204022f.pushChain(new int[]{170}, (Object[]) null);
            List<QQBaseFilter> qQFilters = this.f204022f.getQQFilters(170);
            if (qQFilters != null && qQFilters.size() > 0 && (qQFilters.get(0) instanceof QQImage2FrameFilter)) {
                ((QQImage2FrameFilter) qQFilters.get(0)).setImageSize(bitmap.getWidth(), bitmap.getHeight());
            }
            int drawFrame = this.f204022f.drawFrame(createTexture);
            if (createTexture > 0) {
                GlUtil.deleteTexture(createTexture);
            }
            return drawFrame;
        }
        if (bitmap == null) {
            return 0;
        }
        return GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, bitmap);
    }

    @RequiresApi(api = 17)
    @TargetApi(17)
    public void q(List<Bitmap> list, VideoStoryPicToVideo.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) aVar);
            return;
        }
        VideoStoryPicToVideo.b bVar = new VideoStoryPicToVideo.b(0, "success");
        this.f204021e = new e();
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(this.f204017a, this.f204019c, this.f204018b, this.f204020d, 1, false, 0);
        cVar.d(EGL14.eglGetCurrentContext());
        QLog.d("MuiltiImageToVideo", 2, this.f204017a + " " + this.f204019c + " " + this.f204018b + " " + this.f204020d);
        this.f204021e.q(cVar, new a(list, aVar, bVar));
        try {
            synchronized (this) {
                LockMethodProxy.wait(this);
            }
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    public void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f204023g = i3;
        }
    }
}
