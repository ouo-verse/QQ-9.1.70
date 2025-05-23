package mr;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.filter.e;
import com.tencent.mobileqq.filter.f;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterConstants;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSVArtFilterNew;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.IntBuffer;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements GLSurfaceView.Renderer {
    private int C;
    private int D;
    private QQFilterRenderManager E;
    private e F;
    private long G = 0;
    private boolean H = true;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.encoder.a f417216d;

    /* renamed from: e, reason: collision with root package name */
    private b f417217e;

    /* renamed from: f, reason: collision with root package name */
    private GPUBaseFilter f417218f;

    /* renamed from: h, reason: collision with root package name */
    public EGLContext f417219h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f417220i;

    /* renamed from: m, reason: collision with root package name */
    private int f417221m;

    private void a(int i3, int i16) {
        b bVar = new b(this.f417216d);
        this.f417217e = bVar;
        bVar.a(i3, i16);
        this.f417217e.c();
        this.C = i3;
        this.D = i16;
    }

    public void b() {
        b bVar = this.f417217e;
        if (bVar != null) {
            bVar.d();
            this.f417217e = null;
        }
        com.tencent.mobileqq.videocodec.mediacodec.encoder.a aVar = this.f417216d;
        if (aVar != null) {
            aVar.g();
            this.f417216d = null;
        }
        GPUBaseFilter gPUBaseFilter = this.f417218f;
        if (gPUBaseFilter != null) {
            gPUBaseFilter.destroy();
        }
        QQFilterRenderManager qQFilterRenderManager = this.E;
        if (qQFilterRenderManager != null) {
            qQFilterRenderManager.surfaceDestroyed();
            this.E = null;
        }
    }

    public void c(int i3, int i16) {
        this.f417216d = new com.tencent.mobileqq.videocodec.mediacodec.encoder.a(EGL14.eglGetCurrentContext(), 1);
        a(i3, i16);
    }

    public void d(int i3, int i16) {
        c(i3, i16);
        this.f417219h = EGL14.eglGetCurrentContext();
        this.f417218f = com.tencent.mobileqq.filter.a.a(0);
        this.E = f.c();
        this.f417218f.init();
        QQFilterRenderManager qQFilterRenderManager = this.E;
        int i17 = this.C;
        int i18 = this.D;
        qQFilterRenderManager.surfaceCreate(i17, i18, i17, i18);
        onSurfaceCreated(null, null);
        onSurfaceChanged(null, i3, i16);
        List<QQBaseFilter> qQFilters = this.E.getQQFilters(90);
        if (qQFilters != null && qQFilters.size() > 0) {
            try {
                ((QQSVArtFilterNew) qQFilters.get(0)).onSurfaceChange(i3, i16);
            } catch (Exception unused) {
            }
        }
        this.E.setParam("key_orientation_degree", String.valueOf(90));
    }

    public void e(int i3, int i16) {
        this.f417216d = new com.tencent.mobileqq.videocodec.mediacodec.encoder.a(EGL14.EGL_NO_CONTEXT, 1);
        a(i3, i16);
    }

    public void f(EGLContext eGLContext, int i3, int i16) {
        this.f417216d = new com.tencent.mobileqq.videocodec.mediacodec.encoder.a(eGLContext, 1);
        a(i3, i16);
    }

    public Bitmap g(Bitmap bitmap, GPUBaseFilter gPUBaseFilter) {
        this.f417220i = bitmap;
        this.f417218f = gPUBaseFilter;
        onSurfaceCreated(null, null);
        onSurfaceChanged(null, bitmap.getWidth(), bitmap.getHeight());
        e eVar = this.F;
        int i3 = (eVar == null || !eVar.E) ? 2 : 30;
        for (int i16 = 0; i16 < i3; i16++) {
            onDrawFrame(null);
        }
        IntBuffer allocate = IntBuffer.allocate(bitmap.getWidth() * bitmap.getHeight());
        GLES20.glReadPixels(0, 0, bitmap.getWidth(), bitmap.getHeight(), 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        int[] array = allocate.array();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(IntBuffer.wrap(array));
        return createBitmap;
    }

    public Bitmap h(Bitmap bitmap, long j3) {
        Bitmap bitmap2;
        this.G = j3;
        GPUBaseFilter a16 = com.tencent.mobileqq.filter.a.a(0);
        QQFilterRenderManager b16 = f.b(f.f209753c);
        if (b16 != null) {
            this.F = new e(b16.getBusinessOperation().getCurrentAVFilterIdList(), b16.getBusinessOperation().getMusicItemInfo(), this.C, this.D, null);
        } else {
            this.F = null;
        }
        if (this.F == null || a16 == null) {
            bitmap2 = null;
        } else {
            try {
                Bitmap e16 = UIUtils.e(bitmap, 1.0f, -1.0f);
                a16.init();
                this.F.f(this.C, this.D);
                bitmap2 = g(e16, a16);
            } catch (OutOfMemoryError e17) {
                e = e17;
                bitmap2 = null;
            }
            try {
                a16.destroy();
                this.F.e();
                bitmap2 = UIUtils.e(bitmap2, 1.0f, -1.0f);
            } catch (OutOfMemoryError e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                    QLog.e("GPUBitmapImageRender", 2, "renderEditVideoFilterBitmap OutOfMemoryError" + e.toString());
                }
                this.F = null;
                return bitmap2;
            }
        }
        this.F = null;
        return bitmap2;
    }

    public Bitmap j(Bitmap bitmap, List<FilterDesc> list, a aVar) {
        int i3;
        GPUBaseFilter gPUBaseFilter = aVar.f417218f;
        this.f417218f = gPUBaseFilter;
        QQFilterRenderManager qQFilterRenderManager = aVar.E;
        this.E = qQFilterRenderManager;
        if (qQFilterRenderManager == null || gPUBaseFilter == null || list == null) {
            return null;
        }
        Bitmap e16 = UIUtils.e(bitmap, 1.0f, -1.0f);
        this.E.getBusinessOperation().setFilterEffectList(list);
        this.f417220i = e16;
        if (aVar.H) {
            aVar.H = false;
            i3 = 20;
        } else {
            i3 = 5;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            onDrawFrame(null);
        }
        IntBuffer allocate = IntBuffer.allocate(e16.getWidth() * e16.getHeight());
        GLES20.glReadPixels(0, 0, e16.getWidth(), e16.getHeight(), 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
        int[] array = allocate.array();
        Bitmap createBitmap = Bitmap.createBitmap(e16.getWidth(), e16.getHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(IntBuffer.wrap(array));
        return UIUtils.e(createBitmap, 1.0f, -1.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        GLES20.glViewport(0, 0, i3, i16);
        GLES20.glUseProgram(this.f417218f.getProgram());
        this.f417218f.onOutputSizeChanged(i3, i16);
        QQFilterRenderManager qQFilterRenderManager = this.E;
        if (qQFilterRenderManager != null) {
            int i17 = this.C;
            int i18 = this.D;
            qQFilterRenderManager.surfaceChange(i17, i18, i17, i18);
        }
    }

    public Bitmap i(Bitmap bitmap, List<FilterDesc> list, boolean z16) {
        if (list == null) {
            QLog.e("GPUBitmapImageRender", 1, "renderFilterListBitmap error, tempDescs is null!");
            return null;
        }
        GPUBaseFilter a16 = com.tencent.mobileqq.filter.a.a(0);
        QQFilterRenderManager a17 = f.a();
        this.E = a17;
        if (a17 == null) {
            QLog.e("GPUBitmapImageRender", 1, "renderFilterListBitmap error, mFilterProcess is null!");
            return null;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            Bitmap e16 = UIUtils.e(bitmap, 1.0f, -1.0f);
            if (e16 == null) {
                QLog.e("GPUBitmapImageRender", 1, "renderFilterListBitmap error, scaleBitmap is null!");
                return null;
            }
            a16.init();
            QQFilterRenderManager qQFilterRenderManager = this.E;
            int i3 = this.C;
            int i16 = this.D;
            qQFilterRenderManager.surfaceCreate(i3, i16, i3, i16);
            this.E.setParam("key_orientation_degree", String.valueOf(90));
            this.E.getBusinessOperation().setFilterEffectList(list);
            return UIUtils.e(g(e16, a16), 1.0f, -1.0f);
        }
        QLog.e("GPUBitmapImageRender", 1, "renderFilterListBitmap error, invalid bitmap!");
        return null;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Bitmap bitmap;
        GLES20.glClear(16640);
        if (this.f417220i.getWidth() % 2 == 1) {
            bitmap = Bitmap.createBitmap(this.f417220i.getWidth() + 1, this.f417220i.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawBitmap(this.f417220i, 0.0f, 0.0f, (Paint) null);
        } else {
            bitmap = null;
        }
        this.f417221m = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, bitmap == null ? this.f417220i : bitmap);
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        e eVar = this.F;
        if (eVar != null) {
            this.f417221m = eVar.d(this.C, this.D, this.f417221m, this.G);
        }
        QQFilterRenderManager qQFilterRenderManager = this.E;
        if (qQFilterRenderManager != null) {
            qQFilterRenderManager.setParam(QQFilterConstants.FilterParameters.KEY_DRAW_SCREEN, String.valueOf(false));
            this.E.setParam(QQFilterConstants.FilterParameters.KEY_WIDTH, String.valueOf(this.C));
            this.E.setParam(QQFilterConstants.FilterParameters.KEY_HEIGHT, String.valueOf(this.D));
            int drawFrame = this.E.drawFrame(this.f417221m);
            if (drawFrame != -1) {
                this.f417221m = drawFrame;
            }
        }
        GLES20.glFinish();
        this.f417218f.drawTexture(this.f417221m, null, fArr);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glDisable(2929);
    }
}
