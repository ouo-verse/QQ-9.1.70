package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.view.Surface;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.aebase.k;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes32.dex */
public class PngsCreator {

    /* renamed from: m, reason: collision with root package name */
    private static String f65465m = "PngsCreator";

    /* renamed from: a, reason: collision with root package name */
    private Handler f65466a;

    /* renamed from: b, reason: collision with root package name */
    private c f65467b;

    /* renamed from: h, reason: collision with root package name */
    private a f65473h;

    /* renamed from: j, reason: collision with root package name */
    private String f65475j;

    /* renamed from: k, reason: collision with root package name */
    private List<PTFaceAttr> f65476k;

    /* renamed from: c, reason: collision with root package name */
    private BaseFilter f65468c = new SurfaceTextureFilter();

    /* renamed from: d, reason: collision with root package name */
    private qq.d f65469d = new qq.d();

    /* renamed from: e, reason: collision with root package name */
    private Frame f65470e = new Frame();

    /* renamed from: f, reason: collision with root package name */
    private int f65471f = 0;

    /* renamed from: g, reason: collision with root package name */
    private SurfaceTexture f65472g = null;

    /* renamed from: i, reason: collision with root package name */
    private int f65474i = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f65477l = 0;

    /* loaded from: classes32.dex */
    public interface a {
        void a(String str);
    }

    public PngsCreator(final String str, List<PTFaceAttr> list) {
        this.f65476k = list;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PngCreatorHT");
        baseHandlerThread.start();
        Handler handler = new Handler(baseHandlerThread.getLooper());
        this.f65466a = handler;
        handler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.PngsCreator.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.videocodec.mediacodec.encoder.a aVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.a(null, 1);
                aVar.f(aVar.c(320, 320));
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                PngsCreator.this.f65471f = iArr[0];
                GLES20.glBindTexture(36197, PngsCreator.this.f65471f);
                GLES20.glTexParameterf(36197, 10240, 9729.0f);
                GLES20.glTexParameterf(36197, 10241, 9729.0f);
                GLES20.glTexParameterf(36197, 10242, 33071.0f);
                GLES20.glTexParameterf(36197, 10243, 33071.0f);
                PngsCreator.this.f65468c.apply();
                PngsCreator.this.f65469d.d(320, 320);
                PngsCreator.this.f65469d.c();
                PngsCreator.this.f65472g = new SurfaceTexture(PngsCreator.this.f65471f);
                PngsCreator.this.f65472g.setOnFrameAvailableListener(new b());
                PngsCreator.this.f65467b = new c();
                PngsCreator.this.f65467b.b(str, new Surface(PngsCreator.this.f65472g));
            }
        });
    }

    public void r(final String str) {
        this.f65466a.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.PngsCreator.3
            @Override // java.lang.Runnable
            public void run() {
                if (PngsCreator.this.f65469d != null) {
                    PngsCreator.this.f65469d.a(str);
                }
            }
        });
    }

    public void u(a aVar) {
        this.f65477l = System.currentTimeMillis();
        this.f65475j = g.b.a.f65273b + File.separator + System.currentTimeMillis();
        try {
            new File(this.f65475j).mkdirs();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        QLog.d(f65465m, 4, "pngDir = ", this.f65475j);
        this.f65473h = aVar;
        this.f65466a.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.PngsCreator.2
            @Override // java.lang.Runnable
            public void run() {
                PngsCreator.this.f65474i = 0;
                PngsCreator.this.f65467b.e();
                PngsCreator.this.f65467b.a();
            }
        });
    }

    public void s() {
        this.f65474i = 0;
        this.f65466a.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.PngsCreator.5
            @Override // java.lang.Runnable
            public void run() {
                PngsCreator.this.f65467b.d();
                if (PngsCreator.this.f65472g != null) {
                    PngsCreator.this.f65472g.release();
                }
                GLES20.glDeleteTextures(1, new int[]{PngsCreator.this.f65471f}, 0);
                PngsCreator.this.f65468c.clearGLSLSelf();
                PngsCreator.this.f65469d.b();
                PngsCreator.this.f65470e.clear();
                PngsCreator.this.f65466a.getLooper().quit();
            }
        });
    }

    public void t(final String str, final int i3, final String str2, final String str3, final int i16, final String str4, final float f16, final float f17, final float f18, final float f19) {
        this.f65466a.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.PngsCreator.4
            @Override // java.lang.Runnable
            public void run() {
                if (PngsCreator.this.f65469d != null) {
                    PngsCreator.this.f65469d.g(true);
                    PngsCreator.this.f65469d.h(str, i3, str2, str3, i16, str4, f16, f17, f18, f19);
                }
            }
        });
    }

    /* loaded from: classes32.dex */
    class b implements SurfaceTexture.OnFrameAvailableListener {
        b() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            PTFaceAttr pTFaceAttr;
            QLog.d(PngsCreator.f65465m, 4, "PngsCreator onFrameAvailable()");
            surfaceTexture.updateTexImage();
            PngsCreator.this.f65468c.RenderProcess(PngsCreator.this.f65471f, 960, 480, -1, 0.0d, PngsCreator.this.f65470e);
            qq.d dVar = PngsCreator.this.f65469d;
            Frame frame = PngsCreator.this.f65470e;
            if (PngsCreator.this.f65474i < PngsCreator.this.f65476k.size()) {
                pTFaceAttr = c((PTFaceAttr) PngsCreator.this.f65476k.get(PngsCreator.this.f65474i));
            } else {
                pTFaceAttr = new PTFaceAttr(new PTFaceAttr.Builder());
            }
            Bitmap saveTexture = RendererUtils.saveTexture(dVar.e(frame, 480, 480, pTFaceAttr));
            saveTexture.setPremultiplied(false);
            k.f(String.format(PngsCreator.this.f65475j + "/frame_%03d.png", Integer.valueOf(PngsCreator.this.f65474i)), saveTexture);
            saveTexture.recycle();
            PngsCreator pngsCreator = PngsCreator.this;
            pngsCreator.f65474i = pngsCreator.f65474i + 1;
            if (PngsCreator.this.f65467b.a()) {
                return;
            }
            QLog.d(PngsCreator.f65465m, 4, "pngs create duration = " + (System.currentTimeMillis() - PngsCreator.this.f65477l));
            PngsCreator.this.f65473h.a(PngsCreator.this.f65475j);
        }

        private List<float[]> a(List<float[]> list) {
            if (list == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                float[] fArr = list.get(i3);
                float[] fArr2 = new float[fArr.length];
                for (int i16 = 0; i16 < fArr.length; i16++) {
                    fArr2[i16] = fArr[i16];
                }
                linkedList.add(fArr2);
            }
            return linkedList;
        }

        private List<List<PointF>> b(List<List<PointF>> list) {
            if (list == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                List<PointF> list2 = list.get(i3);
                LinkedList linkedList2 = new LinkedList();
                int size2 = list2.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    PointF pointF = list2.get(i16);
                    linkedList2.add(new PointF(pointF.x, pointF.y));
                }
                linkedList.add(linkedList2);
            }
            return linkedList;
        }

        private PTFaceAttr c(PTFaceAttr pTFaceAttr) {
            if (pTFaceAttr == null) {
                return null;
            }
            return new PTFaceAttr(new PTFaceAttr.Builder().facePoints(b(pTFaceAttr.getAllFacePoints())).facePoint94(b(pTFaceAttr.getAllFacePoints94())).faceAngles(a(pTFaceAttr.getAllFaceAngles())).faceDetectScale(pTFaceAttr.getFaceDetectScale()));
        }
    }
}
