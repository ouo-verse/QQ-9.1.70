package com.tencent.biz.qqstory.takevideo.slideshow;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.text.TextUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
class ConvertRunnable implements Runnable, com.tencent.mobileqq.videocodec.mediacodec.recorder.c {
    private int C;
    private WeakReference<a> D;
    private com.tencent.mobileqq.videocodec.mediacodec.recorder.e E;
    private volatile boolean F;
    private int G;
    private boolean H;
    private long I;
    private String J;
    private String K;
    private String L;
    private Bitmap M;
    QQFilterRenderManager N;
    j P;
    long Q;
    long R;
    long S;

    /* renamed from: d, reason: collision with root package name */
    private String f94279d;

    /* renamed from: e, reason: collision with root package name */
    private SlideItemInfo f94280e;

    /* renamed from: f, reason: collision with root package name */
    private int f94281f;

    /* renamed from: h, reason: collision with root package name */
    private int f94282h;

    /* renamed from: i, reason: collision with root package name */
    private long f94283i;

    /* renamed from: m, reason: collision with root package name */
    private long f94284m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(d dVar);
    }

    private boolean e() {
        int i3;
        com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar = this.E;
        if (eVar != null && (i3 = this.C) > 0) {
            long j3 = this.f94284m;
            if (j3 < this.f94283i) {
                eVar.h(GLSLRender.GL_TEXTURE_2D, i3, null, null, j3);
                this.f94284m += 42000000;
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean f() {
        if (!this.F && QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "run exit:" + this.I + " run:" + this.F);
        }
        return !this.F;
    }

    private int g(Bitmap bitmap, int i3, int i16) {
        if (bitmap != null && i16 != 0 && i3 != 0) {
            Bitmap b16 = Image2Video.b(bitmap, 0.05f, 5, false);
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(b16, 0.0f, 0.0f, (Paint) null);
            float f16 = i3;
            float f17 = f16 * 1.0f;
            float f18 = i16;
            float f19 = f17 / f18;
            float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
            int width2 = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postTranslate(width2 * (-0.5f), height * (-0.5f));
            if (width > f19) {
                matrix.postScale(1.0f, ((f17 / bitmap.getWidth()) * bitmap.getHeight()) / f18);
                float f26 = f16 / width;
                canvas.drawBitmap(bitmap, new Rect(0, 0, width2, height), new RectF(0.0f, (f18 - f26) * 0.5f, f16, (f26 + f18) * 0.5f), (Paint) null);
            } else {
                matrix.postScale((((f18 * 1.0f) / bitmap.getHeight()) * bitmap.getWidth()) / f16, 1.0f);
                float f27 = width * f18;
                canvas.drawBitmap(bitmap, new Rect(0, 0, width2, height), new RectF((f16 - f27) * 0.5f, 0.0f, (f27 + f16) * 0.5f, f18), (Paint) null);
            }
            matrix.postTranslate(f16 * 0.5f, f18 * 0.5f);
            return GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, createBitmap);
        }
        if (bitmap == null) {
            return 0;
        }
        return GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, bitmap);
    }

    private int h(Bitmap bitmap, int i3, int i16) {
        if (bitmap != null && i16 != 0 && i3 != 0) {
            int createTexture = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, bitmap);
            if (this.N == null) {
                this.N = new QQFilterRenderManager();
            }
            this.N.surfaceCreate(i3, i16, i3, i16);
            this.N.surfaceChange(i3, i16, i3, i16);
            this.N.pushChain(new int[]{170}, (Object[]) null);
            List<QQBaseFilter> qQFilters = this.N.getQQFilters(170);
            if (qQFilters != null && qQFilters.size() > 0 && (qQFilters.get(0) instanceof QQImage2FrameFilter)) {
                ((QQImage2FrameFilter) qQFilters.get(0)).setImageSize(bitmap.getWidth(), bitmap.getHeight());
            }
            int drawFrame = this.N.drawFrame(createTexture);
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

    private void i(int i3, String str, String str2, MediaFormat mediaFormat) {
        a aVar;
        WeakReference<a> weakReference = this.D;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            d dVar = new d();
            dVar.f94391a = this.I;
            dVar.f94392b = i3;
            dVar.f94394d = str2;
            dVar.f94393c = str;
            dVar.f94395e = mediaFormat;
            dVar.f94396f = this.K;
            SlideItemInfo slideItemInfo = this.f94280e;
            dVar.f94397g = slideItemInfo.H;
            dVar.f94398h = slideItemInfo.I;
            aVar.a(dVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x008d, code lost:
    
        if (r14 == null) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j() {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        if (QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "run begin, taskid:" + this.I + " run:" + this.F);
        }
        if (f()) {
            id0.a.i("actImage2VideoResult", "9");
            i(9, this.f94279d, null, null);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception unused) {
            this.M = null;
        }
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(this.f94279d);
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = null;
                    bufferedInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                    bufferedInputStream = null;
                }
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream, 32768);
                } catch (Exception e17) {
                    e = e17;
                    bufferedInputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedInputStream = null;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (Exception unused3) {
                            throw th;
                        }
                    }
                    throw th;
                }
                try {
                    this.M = com.tencent.mobileqq.util.j.k(bufferedInputStream, null, this.f94281f, this.f94282h);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused4) {
                    }
                } catch (Exception e18) {
                    e = e18;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                }
            } catch (OutOfMemoryError unused6) {
                if (QLog.isColorLevel()) {
                    QLog.d("ConvertRunnable", 2, "run decode image OOM, taskid:" + this.I);
                }
                this.M = null;
                if (this.M != null) {
                }
            }
            try {
                fileInputStream.close();
            } catch (Exception unused7) {
                if (this.M == null) {
                    this.M = com.tencent.mobileqq.util.j.i(this.f94279d, this.f94281f, this.f94282h);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("ConvertRunnable", 2, "run decodeSampledBitmapFromFile, taskid:" + this.I + " decode cost:" + (currentTimeMillis2 - currentTimeMillis) + " ms");
                }
                if (this.M == null) {
                    this.F = false;
                    id0.a.i("actImage2VideoResult", "5");
                    i(5, this.f94279d, null, null);
                    return;
                }
                int exifOrientation = BaseImageUtil.getExifOrientation(this.f94279d);
                if (exifOrientation != 0 && exifOrientation % 90 == 0) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(exifOrientation, this.M.getWidth() / 2.0f, this.M.getHeight() / 2.0f);
                    Bitmap bitmap = this.M;
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.M.getHeight(), matrix, true);
                    this.M.recycle();
                    this.M = createBitmap;
                }
                if (f()) {
                    Bitmap bitmap2 = this.M;
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                        this.M = null;
                    }
                    id0.a.i("actImage2VideoResult", "9");
                    i(9, this.f94279d, null, null);
                    return;
                }
                if (this.M != null) {
                    this.F = false;
                    id0.a.i("actImage2VideoResult", "5");
                    i(5, this.f94279d, null, null);
                    return;
                }
                String str = Image2Video.f94286b;
                File file = new File(str);
                if (!file.exists()) {
                    boolean mkdirs = file.mkdirs();
                    if (QLog.isColorLevel()) {
                        QLog.d("ConvertRunnable", 2, "runImage2Video, createDir:" + mkdirs);
                    }
                }
                String name = new File(this.f94279d).getName();
                if (!TextUtils.isEmpty(name)) {
                    name = name.replace(".", "_") + ".mp4";
                }
                this.J = str + name;
                String str2 = this.J + "_tmp_" + System.currentTimeMillis();
                this.L = str2;
                com.tencent.biz.qqstory.utils.d.y(str2);
                long j3 = this.f94283i;
                int i3 = (int) j3;
                this.f94284m = 0L;
                long j16 = j3 * 1000000;
                this.f94283i = j16;
                this.f94283i = j16 / 2;
                if (f()) {
                    Bitmap bitmap3 = this.M;
                    if (bitmap3 != null) {
                        bitmap3.recycle();
                        this.M = null;
                    }
                    id0.a.i("actImage2VideoResult", "9");
                    i(9, this.f94279d, null, null);
                    return;
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("ConvertRunnable", 2, "run, start convert, taskid:" + this.I + " create bitmap cost: " + (currentTimeMillis3 - currentTimeMillis) + " ms");
                }
                long currentTimeMillis4 = System.currentTimeMillis();
                String str3 = str + name + ".dat";
                if (com.tencent.biz.qqstory.utils.d.j(str3)) {
                    com.tencent.biz.qqstory.utils.d.i(str3);
                }
                com.tencent.biz.qqstory.utils.c.a(str3, i3 + 42 + 15);
                if (!com.tencent.biz.qqstory.utils.d.j(str3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ConvertRunnable", 2, "run,createSilentPCMFile: failed " + this.I + " path=" + str3);
                    }
                    id0.a.i("actImage2VideoResult", "8");
                    i(8, this.f94279d, null, null);
                    return;
                }
                this.K = str3;
                long currentTimeMillis5 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("ConvertRunnable", 2, "run, createSilentPCMFile, taskid:" + this.I + "  create PCM cost: " + (currentTimeMillis5 - currentTimeMillis4) + " ms");
                }
                long currentTimeMillis6 = System.currentTimeMillis();
                this.E = new com.tencent.mobileqq.videocodec.mediacodec.recorder.e();
                com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(this.L, this.f94281f, this.f94282h, gm2.e.b().a(1) * 1000, 1, false, 0);
                cVar.d(EGL14.eglGetCurrentContext());
                this.E.q(cVar, this);
                long currentTimeMillis7 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("ConvertRunnable", 2, "run, init encoder, taskid:" + this.I + "  encoder init cost: " + (currentTimeMillis7 - currentTimeMillis6) + " ms");
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ConvertRunnable", 2, "run end, taskid:" + this.I);
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public void k() {
        if (QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "[runLocalVideo2Video]run begin, taskid:" + this.I + " run:" + this.F);
        }
        if (f()) {
            id0.a.i("actVideo2VideoResult", "9");
            i(9, this.f94279d, null, null);
            return;
        }
        String str = Image2Video.f94286b;
        File file = new File(str);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, createDir:" + mkdirs);
            }
        }
        String name = new File(this.f94279d).getName();
        if (!TextUtils.isEmpty(name)) {
            name = name.replace(".", "_") + ".mp4";
        }
        String str2 = str + name;
        this.J = str2;
        com.tencent.biz.qqstory.utils.d.y(str2);
        String str3 = this.J + ".dat";
        if (com.tencent.biz.qqstory.utils.d.j(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "before,getPCMFromFile[Have audio File]:  " + this.I + " audioPath: " + str3 + " audioFileSize=" + q.m(str3));
            }
            com.tencent.biz.qqstory.utils.c cVar = new com.tencent.biz.qqstory.utils.c();
            long currentTimeMillis = System.currentTimeMillis();
            cVar.c(this.f94279d, this.f94280e);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "run,getMetaDataFromFile:  " + this.I + " cost=" + (currentTimeMillis2 - currentTimeMillis) + " ms audioTrack: " + this.f94280e.H + " mSampleRate: " + this.f94280e.I);
            }
        } else {
            com.tencent.biz.qqstory.utils.c cVar2 = new com.tencent.biz.qqstory.utils.c();
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = this.f94279d;
            localMediaInfo.mDuration = this.f94280e.C;
            long currentTimeMillis3 = System.currentTimeMillis();
            SlideItemInfo slideItemInfo = this.f94280e;
            boolean d16 = cVar2.d(localMediaInfo, 0, (int) slideItemInfo.C, str3, slideItemInfo);
            long currentTimeMillis4 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "run,getPCMFromFile:  " + this.I + " cost=" + (currentTimeMillis4 - currentTimeMillis3) + " ms audioTrack: " + this.f94280e.H);
            }
            if (this.f94280e.H) {
                if (!d16 || !com.tencent.biz.qqstory.utils.d.j(str3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ConvertRunnable", 2, "run,getPCMFromFile: failed " + this.I + " path=" + str3 + " success=" + d16);
                    }
                    com.tencent.biz.qqstory.utils.d.y(str3);
                    id0.a.i("actVideo2VideoResult", "8");
                    i(8, this.f94279d, null, null);
                    return;
                }
            } else {
                com.tencent.biz.qqstory.utils.d.y(str3);
                com.tencent.biz.qqstory.utils.c.a(str3, (int) this.f94280e.C);
                if (!com.tencent.biz.qqstory.utils.d.j(str3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ConvertRunnable", 2, "run[video convert],createSilentPCMFile: failed " + this.I + " path=" + str3);
                    }
                    id0.a.i("actVideo2VideoResult", "8");
                    i(8, this.f94279d, null, null);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "After,getPCMFromFile: hasAudioTrack= " + this.f94280e.H + " path=" + str3 + " success=" + d16 + " audioFileSize=" + q.m(str3));
            }
        }
        this.K = str3;
        if (f()) {
            id0.a.i("actVideo2VideoResult", "9");
            i(9, this.f94279d, null, null);
            return;
        }
        this.f94280e.F = this.J;
        synchronized (this) {
            this.P = new j();
        }
        if (f()) {
            id0.a.i("actVideo2VideoResult", "9");
            i(9, this.f94279d, null, null);
            return;
        }
        long currentTimeMillis5 = System.currentTimeMillis();
        boolean h16 = this.P.h(this.f94280e);
        long currentTimeMillis6 = System.currentTimeMillis();
        if (f()) {
            id0.a.i("actVideo2VideoResult", "9");
            i(9, this.f94279d, null, null);
            return;
        }
        id0.a.i("actVideo2VideoTime", (System.currentTimeMillis() - this.S) + "");
        if (h16 && q.p(this.J)) {
            long m3 = q.m(this.J);
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, file exist, size:" + m3 + " file:" + this.J);
            }
            this.G = 0;
            id0.a.i("actVideo2VideoResult", "0");
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, [failed]file not exist:" + this.I + " file:" + this.J);
            }
            this.G = 7;
            id0.a.i("actVideo2VideoResult", "7");
            com.tencent.biz.qqstory.utils.d.y(this.J);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "runLocalVideo2Video, taskid:" + this.I + " run:" + this.F + " cost:" + (currentTimeMillis6 - currentTimeMillis5) + " ms successVideo:" + h16);
        }
        if (this.F) {
            i(this.G, this.f94279d, this.J, null);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeError(int i3, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.e("ConvertRunnable", 2, "onEncodeError, code:" + i3 + " taskID:" + this.I + " run:" + this.F);
        }
        if (this.F) {
            this.F = false;
            this.G = 7;
            i(7, this.f94279d, this.J, null);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFinish(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("ConvertRunnable", 2, "onEncodeFinish, taskid:" + this.I + " run:" + this.F + " finish cost: " + (currentTimeMillis - this.Q) + " ms");
        }
        if (this.F) {
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "onEncodeFinish, delete old:" + this.I + " file:" + this.J);
            }
            com.tencent.biz.qqstory.utils.d.y(this.J);
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "onEncodeFinish, rename start:" + this.I + " file:" + this.J);
            }
            if (com.tencent.biz.qqstory.utils.d.w(str, this.J)) {
                this.G = 0;
            } else {
                this.G = 7;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "onEncodeFinish, rename end:" + this.I + " file:" + this.J + " result:" + this.G);
            }
            if (q.p(this.J)) {
                long m3 = q.m(this.J);
                if (QLog.isColorLevel()) {
                    QLog.d("ConvertRunnable", 2, "onEncodeFinish, file exist, size:" + m3 + " file:" + this.J);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "onEncodeFinish, file not exist:" + this.I + " file:" + this.J);
            }
            com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar = this.E;
            if (eVar != null) {
                MediaFormat i3 = eVar.i();
                id0.a.i("actImage2VideoTime", (System.currentTimeMillis() - this.R) + "");
                id0.a.i("actImage2VideoResult", "0");
                i(this.G, this.f94279d, this.J, i3);
            }
        } else {
            id0.a.i("actImage2VideoResult", "3");
            com.tencent.biz.qqstory.utils.d.y(str);
        }
        QQFilterRenderManager qQFilterRenderManager = this.N;
        if (qQFilterRenderManager != null) {
            qQFilterRenderManager.surfaceDestroyed();
            this.N = null;
        }
        com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar2 = this.E;
        if (eVar2 != null) {
            eVar2.n();
            this.E = null;
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeFrame() {
        if (!this.F) {
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "onEncodeFrame, mRun is false, tasid." + this.I);
            }
            com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar = this.E;
            if (eVar != null) {
                eVar.s();
                return;
            }
            return;
        }
        if (!e()) {
            com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar2 = this.E;
            if (eVar2 != null) {
                eVar2.s();
            }
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "onEncodeFrame, stop recoder, taskid:" + this.I);
            }
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
    public void onEncodeStart() {
        if (this.F) {
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "onEncodeStart, taskid:" + this.I);
            }
            if (!this.H) {
                this.C = g(this.M, this.f94281f, this.f94282h);
            } else {
                this.C = h(this.M, this.f94281f, this.f94282h);
            }
            Bitmap bitmap = this.M;
            if (bitmap != null) {
                bitmap.recycle();
                this.M = null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("ConvertRunnable", 2, "onEncodeStart, taskid:" + this.I + " run:" + this.F + " preProcess cost: " + (currentTimeMillis2 - currentTimeMillis) + " ms mGpuBlur:" + this.H);
            }
            this.Q = System.currentTimeMillis();
            e();
            return;
        }
        Bitmap bitmap2 = this.M;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.M = null;
        }
        com.tencent.mobileqq.videocodec.mediacodec.recorder.e eVar = this.E;
        if (eVar != null) {
            eVar.s();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f94280e.f94290h == 0) {
            this.R = System.currentTimeMillis();
            j();
        } else {
            this.S = System.currentTimeMillis();
            k();
        }
    }
}
