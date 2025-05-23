package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes32.dex */
public class PersonalityOperator implements e {

    /* renamed from: b, reason: collision with root package name */
    protected int f68276b;

    /* renamed from: g, reason: collision with root package name */
    VideoMaterial f68281g;

    /* renamed from: s, reason: collision with root package name */
    b f68293s;

    /* renamed from: c, reason: collision with root package name */
    int f68277c = 320;

    /* renamed from: d, reason: collision with root package name */
    int f68278d = 480;

    /* renamed from: e, reason: collision with root package name */
    protected double f68279e = 0.75d;

    /* renamed from: f, reason: collision with root package name */
    protected int[] f68280f = new int[2];

    /* renamed from: h, reason: collision with root package name */
    HashMap<String, VideoFilterBase> f68282h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    int[] f68283i = new int[1];

    /* renamed from: j, reason: collision with root package name */
    int[] f68284j = new int[1];

    /* renamed from: k, reason: collision with root package name */
    Frame f68285k = new Frame();

    /* renamed from: l, reason: collision with root package name */
    BaseFilter f68286l = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");

    /* renamed from: m, reason: collision with root package name */
    int[] f68287m = new int[1];

    /* renamed from: n, reason: collision with root package name */
    Frame f68288n = new Frame();

    /* renamed from: o, reason: collision with root package name */
    BaseFilter f68289o = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");

    /* renamed from: p, reason: collision with root package name */
    Frame f68290p = new Frame();

    /* renamed from: q, reason: collision with root package name */
    Frame f68291q = new Frame();

    /* renamed from: r, reason: collision with root package name */
    l f68292r = null;

    /* renamed from: t, reason: collision with root package name */
    int f68294t = 0;

    /* renamed from: u, reason: collision with root package name */
    boolean f68295u = false;

    /* renamed from: v, reason: collision with root package name */
    boolean f68296v = false;

    /* renamed from: w, reason: collision with root package name */
    boolean f68297w = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f68298x = false;

    /* renamed from: y, reason: collision with root package name */
    boolean f68299y = true;

    /* renamed from: z, reason: collision with root package name */
    int f68300z = 0;
    boolean A = false;
    public boolean B = false;

    /* renamed from: a, reason: collision with root package name */
    protected int f68275a;
    public int C = this.f68275a;

    public PersonalityOperator(b bVar) {
        this.f68293s = bVar;
    }

    static VideoFilterBase d(VideoMaterial videoMaterial) {
        return null;
    }

    static VideoFilterBase f(VideoMaterial videoMaterial) {
        return new i();
    }

    static VideoFilterBase g(VideoMaterial videoMaterial) {
        return null;
    }

    public void a(String str) {
        if (this.f68282h.isEmpty()) {
            return;
        }
        VideoFilterBase videoFilterBase = this.f68282h.get(str);
        videoFilterBase.ApplyGLSLFilter();
        videoFilterBase.setRenderMode(1);
    }

    public void b(float f16, float f17, boolean z16) {
        PointF pointF = new PointF(f16, f17);
        float f18 = this.f68275a / this.f68277c;
        pointF.x *= f18;
        pointF.y *= f18;
        this.f68292r.f68408c.add(new PointF(pointF.x - (this.f68275a * 0.5f), pointF.y - (this.f68276b * 0.5f)));
        this.f68292r.f68414i = z16;
    }

    public void j() {
        this.f68291q.clear();
        int[] iArr = this.f68280f;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
    }

    public void l() {
        this.f68291q.bindFrame(this.f68280f[0], this.f68275a, this.f68276b, this.f68279e);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        GLES20.glFlush();
        if (Build.VERSION.SDK_INT < 30) {
            this.f68289o.RenderProcess(this.f68291q.getTextureId(), this.f68275a, this.f68276b, 0, this.f68279e, this.f68290p);
        }
        if (!this.f68296v) {
            if (this.f68295u) {
                this.f68285k.bindFrame(this.f68284j[0], this.f68275a, this.f68276b, 1.0d);
                m.a();
                this.f68295u = false;
            } else {
                t(this.f68291q.getFBO(), this.f68291q.getTextureId(), this.f68275a, this.f68276b);
            }
        }
        this.A = false;
    }

    public void m(l lVar) {
        if ((lVar.f68414i && lVar.f68411f) || this.f68296v) {
            return;
        }
        if (!lVar.f68411f && lVar.f68412g) {
            if (lVar.f68413h) {
                s(this.f68275a, this.f68276b, lVar);
            }
            this.A = true;
        } else if (lVar.f68408c.size() > 1) {
            v(this.f68291q, this.f68275a, this.f68276b, lVar);
        }
    }

    public void n() {
        c();
        int[] iArr = this.f68280f;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        this.f68289o.apply();
        this.f68286l.apply();
        int[] iArr2 = this.f68283i;
        GLES20.glGenTextures(iArr2.length, iArr2, 0);
        int[] iArr3 = this.f68284j;
        GLES20.glGenTextures(iArr3.length, iArr3, 0);
        int[] iArr4 = this.f68287m;
        GLES20.glGenTextures(iArr4.length, iArr4, 0);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        l lVar;
        if (this.f68282h.isEmpty()) {
            if (QLog.isColorLevel() && motionEvent.getAction() == 0) {
                QLog.w("PersonalityOperator", 2, "onTouch filterMap is empty");
            }
            return true;
        }
        if (this.f68300z + 1 > 50 && (lVar = this.f68292r) != null && lVar.f68414i) {
            if (motionEvent.getAction() == 0) {
                QQStoryContext.h();
                QQToast.makeText(QQStoryContext.a().getApp(), HardCodeUtil.qqStr(R.string.p1d), 0).show();
            }
            return true;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (motionEvent.getAction() == 2) {
            if (this.f68292r != null) {
                b(x16, y16, false);
                int i3 = this.f68294t + 1;
                this.f68294t = i3;
                this.f68294t = i3 % 4;
            }
        } else if (motionEvent.getAction() == 0) {
            VideoMaterial videoMaterial = this.f68281g;
            if (videoMaterial != null && !TextUtils.isEmpty(videoMaterial.getId())) {
                String id5 = this.f68281g.getId();
                b bVar = this.f68293s;
                l lVar2 = new l(102, id5, bVar != null ? bVar.a() : 0);
                this.f68292r = lVar2;
                this.f68300z++;
                lVar2.f68413h = true;
                b bVar2 = this.f68293s;
                if (bVar2 != null) {
                    bVar2.d(this.f68292r);
                }
                b(x16, y16, false);
                this.f68294t = 0;
            }
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.f68292r != null) {
            b(x16, y16, true);
        }
        this.f68298x = true;
        b bVar3 = this.f68293s;
        if (bVar3 != null) {
            bVar3.b();
        }
        return true;
    }

    public void p(int i3, int i16) {
        float min = Math.min(720.0f / Math.min(i3, i16), 1.0f);
        this.f68275a = (int) (i3 * min);
        this.f68276b = (int) (i16 * min);
        if (!this.f68282h.isEmpty()) {
            w(this.f68275a, this.f68276b, 1.0d);
        }
        this.f68277c = i3;
        this.f68278d = i16;
        if (this.f68297w) {
            o(true);
        }
    }

    public void s(int i3, int i16, l lVar) {
        HashMap<String, VideoFilterBase> hashMap = this.f68282h;
        if (hashMap == null || hashMap.size() < 1) {
            return;
        }
        Frame frame = new Frame(this.f68285k.getFBO(), this.f68285k.getTextureId(), i3, i16);
        GlUtil.setBlendMode(true);
        GLES20.glBindFramebuffer(36160, this.f68285k.getFBO());
        GLES20.glViewport(0, 0, i3, i16);
        this.f68286l.RenderProcess(lVar.f68416k.getTextureId(), i3, i16, this.f68285k.getTextureId(), 1.0d, frame);
        GlUtil.setBlendMode(false);
        lVar.f68411f = true;
    }

    public void t(int i3, int i16, int i17, int i18) {
        HashMap<String, VideoFilterBase> hashMap = this.f68282h;
        if (hashMap == null || hashMap.size() < 1) {
            return;
        }
        Frame frame = new Frame(i3, i16, i17, i18);
        GlUtil.setBlendMode(true);
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glViewport(0, 0, i17, i18);
        this.f68285k.bindFrame(this.f68284j[0], i17, i18, 1.0d);
        this.f68286l.RenderProcess(this.f68285k.getTextureId(), i17, i18, i16, 1.0d, frame);
        GlUtil.setBlendMode(false);
    }

    public void c() {
        this.f68300z = 0;
        try {
            this.f68290p.clear();
            this.f68289o.clearGLSL();
            if (this.f68299y) {
                this.f68299y = false;
                if (!this.f68282h.isEmpty()) {
                    Iterator<Map.Entry<String, VideoFilterBase>> it = this.f68282h.entrySet().iterator();
                    while (it.hasNext()) {
                        it.next().getValue().clearGLSLSelf();
                    }
                    this.f68282h.clear();
                }
            }
            this.f68285k.clear();
            this.f68286l.clearGLSL();
            int[] iArr = this.f68283i;
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            int[] iArr2 = this.f68284j;
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
            int[] iArr3 = this.f68287m;
            GLES20.glDeleteTextures(iArr3.length, iArr3, 0);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("PersonalityOperator", 2, "clear " + th5.toString());
            }
        }
    }

    public void h() {
        this.f68295u = true;
        this.f68300z = 0;
        b bVar = this.f68293s;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void i() {
        this.f68296v = true;
        b bVar = this.f68293s;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void o(boolean z16) {
        this.f68296v = false;
        this.f68295u = true;
        this.f68297w = !z16;
        b bVar = this.f68293s;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void q() {
        this.f68295u = true;
        this.f68300z--;
        b bVar = this.f68293s;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void r(int i3) {
        this.B = true;
        this.C = i3;
        b bVar = this.f68293s;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b6, code lost:
    
        if (r0 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00ef, code lost:
    
        r2 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00f7, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00f9, code lost:
    
        com.tencent.qphone.base.util.QLog.d("PersonalityOperator", 2, "capture personality end " + (r2 - r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ec, code lost:
    
        r0.c(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ea, code lost:
    
        if (r0 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d9, code lost:
    
        if (r0 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k() {
        b bVar;
        if (this.A) {
            t(this.f68291q.getFBO(), this.f68291q.getTextureId(), this.f68275a, this.f68276b);
        }
        this.f68289o.RenderProcess(this.f68291q.getTextureId(), this.f68277c, this.f68278d, 0, this.f68279e, this.f68290p);
        b bVar2 = this.f68293s;
        if (bVar2 != null && (bVar2 instanceof d)) {
            ((d) bVar2).D();
        }
        if (!this.B) {
            return;
        }
        this.B = false;
        if (QLog.isColorLevel()) {
            QLog.d("PersonalityOperator", 2, "capture personality start");
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap bitmap = null;
        try {
            try {
                IntBuffer allocate = IntBuffer.allocate(this.f68277c * this.f68278d);
                GLES20.glReadPixels(0, 0, this.f68277c, this.f68278d, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
                int[] array = allocate.array();
                Bitmap createBitmap = Bitmap.createBitmap(this.f68277c, this.f68278d, Bitmap.Config.ARGB_8888);
                createBitmap.copyPixelsFromBuffer(IntBuffer.wrap(array));
                float f16 = (this.C * 1.0f) / this.f68277c;
                Matrix matrix = new Matrix();
                matrix.postRotate(180.0f);
                matrix.postScale((-1.0f) * f16, f16 * 1.0f);
                bitmap = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, false);
                this.f68298x = false;
                bVar = this.f68293s;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Personality", 2, e16, new Object[0]);
                }
                bVar = this.f68293s;
            } catch (OutOfMemoryError e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("Personality", 2, "saveTextureToBitmap OOM :" + e17);
                }
                bVar = this.f68293s;
            }
        } catch (Throwable th5) {
            b bVar3 = this.f68293s;
            if (bVar3 != null) {
                bVar3.c(bitmap);
            }
            throw th5;
        }
    }

    public void u(final VideoMaterial videoMaterial) {
        VideoFilterBase e16;
        if (videoMaterial != null) {
            if (!this.f68282h.containsKey(videoMaterial.getId()) && (e16 = e(videoMaterial)) != null) {
                this.f68282h.put(videoMaterial.getId(), e16);
            }
            this.f68281g = videoMaterial;
            Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.PersonalityOperator.1
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    PersonalityOperator.this.a(videoMaterial.getId());
                    PersonalityOperator personalityOperator = PersonalityOperator.this;
                    personalityOperator.w(personalityOperator.f68275a, personalityOperator.f68276b, 1.0d);
                    hd0.c.a("PersonalityOperator", "setVideoFilter " + videoMaterial.getId() + " t:" + (System.currentTimeMillis() - currentTimeMillis));
                }
            };
            b bVar = this.f68293s;
            if (bVar != null) {
                bVar.e(runnable);
                return;
            }
            return;
        }
        hd0.c.a("PersonalityOperator", "material is null!");
    }

    public static VideoFilterBase e(VideoMaterial videoMaterial) {
        if (videoMaterial == null) {
            return null;
        }
        if (videoMaterial.getShaderType() == 13) {
            return d(videoMaterial);
        }
        if (videoMaterial.getShaderType() == 15) {
            return f(videoMaterial);
        }
        if (videoMaterial.getShaderType() == 14) {
            return g(videoMaterial);
        }
        return null;
    }

    public void v(Frame frame, int i3, int i16, l lVar) {
        HashMap<String, VideoFilterBase> hashMap = this.f68282h;
        if (hashMap == null || hashMap.size() < 1) {
            return;
        }
        GlUtil.setBlendMode(true);
        GLES20.glBindFramebuffer(36160, frame.getFBO());
        ArrayList arrayList = new ArrayList();
        boolean z16 = lVar.f68414i;
        arrayList.addAll(lVar.f68408c);
        VideoFilterBase videoFilterBase = this.f68282h.get(lVar.f68407b);
        if (videoFilterBase instanceof k) {
            k kVar = (k) videoFilterBase;
            kVar.c(arrayList);
            kVar.renderTexture(frame.getTextureId(), i3, i16);
            if (z16) {
                this.f68285k.bindFrame(this.f68284j[0], i3, i16, 1.0d);
                GLES20.glBindFramebuffer(36160, this.f68285k.getFBO());
                GLES20.glViewport(0, 0, i3, i16);
                kVar.c(lVar.f68408c);
                kVar.renderTexture(this.f68285k.getTextureId(), i3, i16);
                lVar.c();
            }
        } else if (videoFilterBase instanceof i) {
            i iVar = (i) videoFilterBase;
            iVar.b();
            iVar.d(arrayList, z16, lVar);
            GLES20.glViewport(0, 0, i3, i16);
            GLES20.glBindFramebuffer(36160, frame.getFBO());
            iVar.renderTexture(frame.getTextureId(), i3, i16);
            if (z16) {
                this.f68285k.bindFrame(this.f68284j[0], i3, i16, 1.0d);
                GLES20.glBindFramebuffer(36160, this.f68285k.getFBO());
                GLES20.glViewport(0, 0, i3, i16);
                iVar.e(this.f68285k.getTextureId());
                lVar.c();
            }
        } else if (videoFilterBase instanceof j) {
            j jVar = (j) videoFilterBase;
            jVar.e(arrayList);
            m.c(this.f68288n, this.f68287m[0], i3, i16, true);
            jVar.d();
            m.d(this.f68286l, frame, this.f68288n, this.f68287m[0], i3, i16);
            if (z16) {
                jVar.e(lVar.f68408c);
                this.f68285k.bindFrame(this.f68284j[0], i3, i16, 1.0d);
                m.d(this.f68286l, this.f68285k, this.f68288n, this.f68287m[0], i3, i16);
                lVar.c();
            }
        }
        GlUtil.setBlendMode(false);
        if (lVar.f68414i && lVar.f68413h) {
            Frame b16 = lVar.b(i3, i16);
            t(b16.getFBO(), b16.getTextureId(), i3, i16);
        }
    }

    public void w(int i3, int i16, double d16) {
        float f16 = i3;
        float f17 = i16;
        if (f16 / f17 > 0.75d) {
            i16 = (int) (f16 / 0.75d);
        } else {
            i3 = (int) (f17 * 0.75d);
        }
        int i17 = i3;
        int i18 = i16;
        if (this.f68282h.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, VideoFilterBase>> it = this.f68282h.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().updateVideoSize(i17, i18, d16);
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f68283i[0]);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6402, i17, i18, 0, 6402, 5123, null);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9728);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9728);
    }
}
