package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.opengl.EGL14;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor;
import com.tencent.biz.qqstory.utils.d;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQImage2FrameFilter;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends b {

    /* renamed from: f, reason: collision with root package name */
    private String f94373f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f94374g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f94375h;

    /* renamed from: j, reason: collision with root package name */
    long f94377j;

    /* renamed from: l, reason: collision with root package name */
    long f94379l;

    /* renamed from: e, reason: collision with root package name */
    private int f94372e = -1;

    /* renamed from: i, reason: collision with root package name */
    QQFilterRenderManager f94376i = null;

    /* renamed from: k, reason: collision with root package name */
    private long f94378k = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqstory.takevideo.slideshow.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0945a implements com.tencent.mobileqq.videocodec.mediacodec.recorder.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SlideShowProcessor.c f94380d;

        C0945a(SlideShowProcessor.c cVar) {
            this.f94380d = cVar;
        }

        private boolean a() {
            a aVar = a.this;
            if (aVar.f94383b != null && aVar.f94372e > 0 && a.this.f94378k < this.f94380d.f94346g) {
                a aVar2 = a.this;
                aVar2.f94383b.h(GLSLRender.GL_TEXTURE_2D, aVar2.f94372e, null, null, a.this.f94378k);
                a.this.f94378k += 42000000;
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeError(int i3, Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("ImageToVideo", 2, "onEncodeError, code:" + i3 + " taskID:" + this.f94380d.f94354b + " run:" + this.f94380d.f94353a);
            }
            synchronized (a.this) {
                a.this.notifyAll();
            }
            SlideShowProcessor.c cVar = this.f94380d;
            if (cVar.f94353a) {
                cVar.f94353a = false;
                a aVar = a.this;
                aVar.f94382a = 7;
                aVar.b(7, cVar.f94343d, aVar.f94384c, null, null, cVar);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFinish(String str) {
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.f94380d.f94354b + " run:" + this.f94380d.f94353a + " finish cost: " + (currentTimeMillis - a.this.f94379l) + " ms");
            }
            if (this.f94380d.f94353a) {
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.f94380d.f94354b + " file:" + a.this.f94384c);
                }
                d.y(a.this.f94384c);
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.f94380d.f94354b + " file:" + a.this.f94384c);
                }
                if (d.w(str, a.this.f94384c)) {
                    a.this.f94382a = 0;
                } else {
                    a.this.f94382a = 7;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.f94380d.f94354b + " file:" + a.this.f94384c + " result:" + a.this.f94382a);
                }
                if (q.p(a.this.f94384c)) {
                    long m3 = q.m(a.this.f94384c);
                    if (QLog.isColorLevel()) {
                        QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + m3 + " file:" + a.this.f94384c);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.f94380d.f94354b + " file:" + a.this.f94384c);
                }
                e eVar = a.this.f94383b;
                if (eVar != null) {
                    MediaFormat i3 = eVar.i();
                    id0.a.i("actImage2VideoTime", (System.currentTimeMillis() - a.this.f94377j) + "");
                    id0.a.i("actImage2VideoResult", "0");
                    a aVar = a.this;
                    int i16 = aVar.f94382a;
                    SlideShowProcessor.c cVar = this.f94380d;
                    aVar.b(i16, cVar.f94343d, aVar.f94384c, i3, null, cVar);
                }
            } else {
                id0.a.i("actImage2VideoResult", "3");
                d.y(str);
            }
            QQFilterRenderManager qQFilterRenderManager = a.this.f94376i;
            if (qQFilterRenderManager != null) {
                qQFilterRenderManager.surfaceDestroyed();
                a.this.f94376i = null;
            }
            e eVar2 = a.this.f94383b;
            if (eVar2 != null) {
                eVar2.n();
                a.this.f94383b = null;
            }
            synchronized (a.this) {
                a.this.notifyAll();
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeFrame() {
            if (!this.f94380d.f94353a) {
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.f94380d.f94354b);
                }
                e eVar = a.this.f94383b;
                if (eVar != null) {
                    eVar.s();
                    return;
                }
                return;
            }
            if (!a()) {
                e eVar2 = a.this.f94383b;
                if (eVar2 != null) {
                    eVar2.s();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.f94380d.f94354b);
                }
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.c
        public void onEncodeStart() {
            if (this.f94380d.f94353a) {
                long currentTimeMillis = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.f94380d.f94354b);
                }
                if (!a.this.f94374g) {
                    a aVar = a.this;
                    Bitmap bitmap = aVar.f94375h;
                    SlideShowProcessor.c cVar = this.f94380d;
                    aVar.f94372e = aVar.l(bitmap, cVar.f94344e, cVar.f94345f);
                } else {
                    a aVar2 = a.this;
                    Bitmap bitmap2 = aVar2.f94375h;
                    SlideShowProcessor.c cVar2 = this.f94380d;
                    aVar2.f94372e = aVar2.m(bitmap2, cVar2.f94344e, cVar2.f94345f);
                }
                if (a.this.f94375h != null) {
                    a.this.f94375h.recycle();
                    a.this.f94375h = null;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.f94380d.f94354b + " run:" + this.f94380d.f94353a + " preProcess cost: " + (currentTimeMillis2 - currentTimeMillis) + " ms mGpuBlur:" + a.this.f94374g);
                }
                a.this.f94379l = System.currentTimeMillis();
                a();
                return;
            }
            if (a.this.f94375h != null) {
                a.this.f94375h.recycle();
                a.this.f94375h = null;
            }
            e eVar = a.this.f94383b;
            if (eVar != null) {
                eVar.s();
            }
        }
    }

    public a(boolean z16) {
        this.f94374g = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(Bitmap bitmap, int i3, int i16) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public int m(Bitmap bitmap, int i3, int i16) {
        try {
            if (bitmap != null && i16 != 0 && i3 != 0) {
                int createTexture = GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, bitmap);
                if (this.f94376i == null) {
                    this.f94376i = new QQFilterRenderManager();
                }
                this.f94376i.surfaceCreate(i3, i16, i3, i16);
                this.f94376i.surfaceChange(i3, i16, i3, i16);
                this.f94376i.pushChain(new int[]{170}, (Object[]) null);
                List<QQBaseFilter> qQFilters = this.f94376i.getQQFilters(170);
                if (qQFilters != null && qQFilters.size() > 0 && (qQFilters.get(0) instanceof QQImage2FrameFilter)) {
                    ((QQImage2FrameFilter) qQFilters.get(0)).setImageSize(bitmap.getWidth(), bitmap.getHeight());
                }
                int drawFrame = this.f94376i.drawFrame(createTexture);
                if (createTexture > 0) {
                    GlUtil.deleteTexture(createTexture);
                }
                return drawFrame;
            }
            if (bitmap == null) {
                return 0;
            }
            return GlUtil.createTexture(GLSLRender.GL_TEXTURE_2D, bitmap);
        } catch (Exception e16) {
            ms.a.c("ImageToVideo", "converFrameGpu Exception:" + e16.getMessage());
            return -1;
        }
    }

    @TargetApi(16)
    public static MediaFormat n() {
        com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c("", 720, 1280, gm2.e.b().a(1) * 1000, 1, false, 0);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", 720, 1280);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[]{0, 0, 0, 1, 103, 66, Byte.MIN_VALUE, 31, -38, 2, -48, 40, 105, 72, 40, 48, 40, 54, -123, 9, -88}));
        createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(new byte[]{0, 0, 0, 1, 104, -50, 6, -30}));
        createVideoFormat.setInteger("bitrate", cVar.f312561f);
        createVideoFormat.setInteger("frame-rate", cVar.f312562g);
        createVideoFormat.setInteger("i-frame-interval", cVar.f312563h);
        return createVideoFormat;
    }

    @TargetApi(16)
    public static MediaFormat o(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                mediaExtractor.setDataSource(str);
                for (int i3 = 0; i3 < mediaExtractor.getTrackCount(); i3++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i3);
                    if (trackFormat.getString("mime").startsWith("video/")) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ImageToVideo", 2, "getVideoFormatFromVideo, elapsed Time : " + (SystemClock.elapsedRealtime() - elapsedRealtime));
                        }
                        return trackFormat;
                    }
                }
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, ThrowablesUtils.getStackTraceAsString(e16));
                }
            }
            mediaExtractor.release();
            return null;
        } finally {
            mediaExtractor.release();
        }
    }

    private int p(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
            mediaMetadataRetriever.release();
            return parseInt;
        } catch (Exception unused2) {
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
                return -1;
            }
            return -1;
        } catch (Throwable th6) {
            th = th6;
            mediaMetadataRetriever2 = mediaMetadataRetriever;
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x0086, code lost:
    
        if (r1 == null) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[Catch: OutOfMemoryError -> 0x016b, Exception -> 0x018e, SYNTHETIC, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x018e, blocks: (B:24:0x0089, B:26:0x008d, B:27:0x0099, B:29:0x00a3, B:30:0x00cd, B:32:0x00d1, B:34:0x00ee, B:36:0x00f6, B:38:0x00fa, B:39:0x0134, B:41:0x013a, B:43:0x013e, B:44:0x0143, B:134:0x016a), top: B:11:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(SlideShowProcessor.c cVar) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        if (QLog.isColorLevel()) {
            QLog.d("ImageToVideo", 2, "run begin run:" + cVar.f94353a);
        }
        if (a(cVar)) {
            id0.a.i("actImage2VideoResult", "9");
            b(9, cVar.f94343d, null, null, null, cVar);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.d("ImageToVideo", 2, "run decode image OOM, taskid:" + cVar.f94354b);
            }
            this.f94375h = null;
        }
        try {
            try {
                fileInputStream = new FileInputStream(cVar.f94343d);
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
                }
                if (fileInputStream == null) {
                }
            }
            try {
                try {
                    this.f94375h = j.k(bufferedInputStream, null, cVar.f94344e, cVar.f94345f);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th7) {
                    th = th7;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (fileInputStream == null) {
                        try {
                            fileInputStream.close();
                            throw th;
                        } catch (Exception unused4) {
                            throw th;
                        }
                    }
                    throw th;
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
            try {
                fileInputStream.close();
            } catch (Exception unused6) {
                if (this.f94375h == null) {
                    this.f94375h = j.i(cVar.f94343d, cVar.f94344e, cVar.f94345f);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, "run decodeSampledBitmapFromFile, taskid:" + cVar.f94354b + " decode cost:" + (currentTimeMillis2 - currentTimeMillis) + " ms");
                }
                if (this.f94375h == null) {
                    cVar.f94353a = false;
                    id0.a.i("actImage2VideoResult", "5");
                    b(5, cVar.f94343d, null, null, null, cVar);
                    return;
                }
                int exifOrientation = BaseImageUtil.getExifOrientation(cVar.f94343d);
                if (exifOrientation != 0 && exifOrientation % 90 == 0) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(exifOrientation, this.f94375h.getWidth() / 2.0f, this.f94375h.getHeight() / 2.0f);
                    Bitmap bitmap = this.f94375h;
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f94375h.getHeight(), matrix, true);
                    this.f94375h.recycle();
                    this.f94375h = createBitmap;
                }
                if (a(cVar)) {
                    Bitmap bitmap2 = this.f94375h;
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                        this.f94375h = null;
                    }
                    id0.a.i("actImage2VideoResult", "9");
                    b(9, cVar.f94343d, null, null, null, cVar);
                    return;
                }
                if (this.f94375h != null) {
                }
            }
        } catch (Exception unused7) {
            this.f94375h = null;
            if (this.f94375h != null) {
                cVar.f94353a = false;
                id0.a.i("actImage2VideoResult", "5");
                b(5, cVar.f94343d, null, null, null, cVar);
                return;
            }
            String str = Image2Video.f94286b;
            File file = new File(str);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, "runImage2Video, createDir:" + mkdirs);
                }
            }
            File file2 = new File(cVar.f94343d);
            String name = file2.getName();
            if (!TextUtils.isEmpty(name)) {
                name = (name.replace(".", "_") + "_" + file2.length()) + ".mp4";
            }
            TransitionHandler transitionHandler = (TransitionHandler) QQStoryContext.a().getBusinessHandler(PeakAppInterface.H);
            if (transitionHandler.D2(cVar.f94343d) != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, name + " has in memory cache");
                    return;
                }
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            String str2 = SlideShowProcessor.f94332f;
            sb5.append(str2);
            sb5.append(name);
            if (p(sb5.toString()) >= 1000) {
                if (FileUtils.fileExists(str2 + name + ".dat")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ImageToVideo", 2, name + " has in file cache");
                    }
                    LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                    localMediaInfo.path = str2 + name;
                    localMediaInfo.mMimeType = "video";
                    localMediaInfo.mAudioPath = str2 + name + ".dat";
                    localMediaInfo.mHasAudioTrack = false;
                    localMediaInfo.mSampleRate = 1;
                    transitionHandler.H2(cVar.f94343d, localMediaInfo);
                    return;
                }
            }
            this.f94384c = str + name;
            String str3 = this.f94384c + "_tmp_" + System.currentTimeMillis();
            this.f94373f = str3;
            d.y(str3);
            long j3 = cVar.f94346g;
            int i3 = (int) j3;
            this.f94378k = 0L;
            long j16 = j3 * 1000000;
            cVar.f94346g = j16;
            cVar.f94346g = j16 / 2;
            if (a(cVar)) {
                Bitmap bitmap3 = this.f94375h;
                if (bitmap3 != null) {
                    bitmap3.recycle();
                    this.f94375h = null;
                }
                id0.a.i("actImage2VideoResult", "9");
                b(9, cVar.f94343d, null, null, null, cVar);
                return;
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("ImageToVideo", 2, "run, start convert, taskid:" + cVar.f94354b + " create bitmap cost: " + (currentTimeMillis3 - currentTimeMillis) + " ms");
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            String str4 = str + name + ".dat";
            if (d.j(str4)) {
                d.i(str4);
            }
            com.tencent.biz.qqstory.utils.c.a(str4, i3 + 42 + 15);
            if (!d.j(str4)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ImageToVideo", 2, "run,createSilentPCMFile: failed " + cVar.f94354b + " path=" + str4);
                }
                id0.a.i("actImage2VideoResult", "8");
                b(8, cVar.f94343d, null, null, null, cVar);
                return;
            }
            this.f94385d = str4;
            long currentTimeMillis5 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("ImageToVideo", 2, "run, createSilentPCMFile, taskid:" + cVar.f94354b + "  create PCM cost: " + (currentTimeMillis5 - currentTimeMillis4) + " ms");
            }
            long currentTimeMillis6 = System.currentTimeMillis();
            this.f94383b = new e();
            com.tencent.mobileqq.videocodec.mediacodec.encoder.c cVar2 = new com.tencent.mobileqq.videocodec.mediacodec.encoder.c(this.f94373f, cVar.f94344e, cVar.f94345f, gm2.e.b().a(1) * 1000, 1, false, 0);
            cVar2.d(EGL14.eglGetCurrentContext());
            this.f94383b.q(cVar2, new C0945a(cVar));
            long currentTimeMillis7 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("ImageToVideo", 2, "run, init encoder, taskid:" + cVar.f94354b + "  encoder init cost: " + (currentTimeMillis7 - currentTimeMillis6) + " ms");
            }
            try {
                synchronized (this) {
                    LockMethodProxy.wait(this);
                }
            } catch (InterruptedException e19) {
                e19.printStackTrace();
            }
            if (QLog.isColorLevel()) {
                QLog.d("ImageToVideo", 2, "run end, taskid:" + cVar.f94354b);
            }
        }
    }
}
