package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.view.Surface;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aelight.camera.ae.g;
import com.tencent.common.GifUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.view.RendererUtils;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.widget.QzoneEmotionUtils;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: P */
/* loaded from: classes32.dex */
public class VideoGIFCreator {

    /* renamed from: r, reason: collision with root package name */
    private static String f65504r = "GIFCreator";

    /* renamed from: a, reason: collision with root package name */
    private Handler f65505a;

    /* renamed from: b, reason: collision with root package name */
    private d f65506b;

    /* renamed from: o, reason: collision with root package name */
    private b f65519o;

    /* renamed from: p, reason: collision with root package name */
    private c f65520p;

    /* renamed from: c, reason: collision with root package name */
    private BaseFilter f65507c = new SurfaceTextureFilter();

    /* renamed from: d, reason: collision with root package name */
    private BaseFilter f65508d = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");

    /* renamed from: e, reason: collision with root package name */
    private BaseFilter f65509e = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");

    /* renamed from: f, reason: collision with root package name */
    private BaseFilter f65510f = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.gif.preview.a f65511g = new com.tencent.aelight.camera.ae.gif.preview.a();

    /* renamed from: h, reason: collision with root package name */
    private Frame f65512h = new Frame();

    /* renamed from: i, reason: collision with root package name */
    private Frame f65513i = new Frame();

    /* renamed from: j, reason: collision with root package name */
    private int f65514j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f65515k = LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT;

    /* renamed from: l, reason: collision with root package name */
    private int f65516l = LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT;

    /* renamed from: m, reason: collision with root package name */
    private SurfaceTexture f65517m = null;

    /* renamed from: n, reason: collision with root package name */
    private GifEncoder f65518n = new GifEncoder();

    /* renamed from: q, reason: collision with root package name */
    private boolean f65521q = true;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void onGifCreateFail();

        void onGifCreateSuccess(String str);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c {

        /* renamed from: a, reason: collision with root package name */
        public int f65533a;

        /* renamed from: b, reason: collision with root package name */
        public float f65534b;

        /* renamed from: c, reason: collision with root package name */
        public float f65535c;

        /* renamed from: d, reason: collision with root package name */
        public float f65536d;

        /* renamed from: e, reason: collision with root package name */
        public float f65537e;

        c() {
        }
    }

    public VideoGIFCreator(final String str) {
        QLog.d(f65504r, 4, "input video = " + str);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("GIFCreatorHT");
        baseHandlerThread.start();
        Handler handler = new Handler(baseHandlerThread.getLooper());
        this.f65505a = handler;
        handler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.1
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                VideoGIFCreator.this.f65514j = iArr[0];
                VideoGIFCreator.this.f65517m = new SurfaceTexture(iArr[0]);
                VideoGIFCreator.this.f65506b = new d();
                VideoGIFCreator.this.f65506b.f(str, 0L, TTL.MAX_VALUE, new Surface(VideoGIFCreator.this.f65517m));
                VideoGIFCreator.this.z();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        File file = new File(g.b.C0560b.f65275b);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = file.getPath() + File.separator + System.currentTimeMillis() + QzoneEmotionUtils.SIGN_ICON_URL_END;
        try {
            this.f65518n.c(this.f65515k, this.f65516l, str);
        } catch (FileNotFoundException e16) {
            QLog.d(f65504r, 4, "gifEncoder init exception, msg = " + e16.getMessage());
        }
        com.tencent.mobileqq.videocodec.mediacodec.encoder.a aVar = new com.tencent.mobileqq.videocodec.mediacodec.encoder.a(null, 1);
        aVar.f(aVar.c(this.f65515k, this.f65516l));
        GLES20.glBindTexture(36197, this.f65514j);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        this.f65507c.apply();
        this.f65508d.apply();
        this.f65509e.apply();
        this.f65510f.apply();
        this.f65511g.c(this.f65515k, this.f65516l);
        this.f65511g.b();
        this.f65517m.setOnFrameAvailableListener(new a(str));
    }

    public void A() {
        this.f65505a.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.6
            @Override // java.lang.Runnable
            public void run() {
                VideoGIFCreator.this.f65506b.j();
                if (VideoGIFCreator.this.f65517m != null) {
                    VideoGIFCreator.this.f65517m.release();
                }
                GLES20.glDeleteTextures(1, new int[]{VideoGIFCreator.this.f65514j}, 0);
                if (VideoGIFCreator.this.f65520p != null) {
                    GLES20.glDeleteTextures(1, new int[]{VideoGIFCreator.this.f65520p.f65533a}, 0);
                }
                VideoGIFCreator.this.f65507c.clearGLSLSelf();
                VideoGIFCreator.this.f65508d.clearGLSLSelf();
                VideoGIFCreator.this.f65509e.clearGLSLSelf();
                VideoGIFCreator.this.f65510f.clearGLSL();
                VideoGIFCreator.this.f65511g.a();
                VideoGIFCreator.this.f65512h.clear();
                VideoGIFCreator.this.f65513i.clear();
                VideoGIFCreator.this.f65505a.getLooper().quit();
            }
        });
    }

    public void B(boolean z16) {
        this.f65521q = z16;
    }

    public void C(final Bitmap bitmap, final float f16, final float f17, final float f18, final float f19) {
        this.f65505a.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.4
            @Override // java.lang.Runnable
            public void run() {
                VideoGIFCreator videoGIFCreator = VideoGIFCreator.this;
                videoGIFCreator.f65520p = new c();
                VideoGIFCreator.this.f65520p.f65533a = RendererUtils.createTexture(bitmap);
                VideoGIFCreator.this.f65520p.f65534b = f16;
                VideoGIFCreator.this.f65520p.f65535c = f17;
                VideoGIFCreator.this.f65520p.f65536d = f18;
                VideoGIFCreator.this.f65520p.f65537e = f19;
            }
        });
    }

    public void D(b bVar) {
        this.f65519o = bVar;
        QLog.d(f65504r, 4, "start create gif");
        this.f65505a.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.5
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(VideoGIFCreator.f65504r, 4, "start decode");
                VideoGIFCreator.this.f65506b.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements SurfaceTexture.OnFrameAvailableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f65531d;

        a(String str) {
            this.f65531d = str;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Frame frame;
            QLog.d(VideoGIFCreator.f65504r, 4, "gif creator onFrameAvailable()");
            surfaceTexture.updateTexImage();
            if (VideoGIFCreator.this.f65521q) {
                VideoGIFCreator.this.f65507c.RenderProcess(VideoGIFCreator.this.f65514j, 960, 480, -1, 0.0d, VideoGIFCreator.this.f65512h);
                VideoGIFCreator.this.f65511g.f(true);
                frame = VideoGIFCreator.this.f65511g.d(VideoGIFCreator.this.f65512h, 480, 480);
            } else {
                VideoGIFCreator.this.f65507c.RenderProcess(VideoGIFCreator.this.f65514j, VideoGIFCreator.this.f65515k, VideoGIFCreator.this.f65516l, -1, 0.0d, VideoGIFCreator.this.f65512h);
                frame = VideoGIFCreator.this.f65512h;
                int b16 = VideoGIFCreator.this.f65506b.b();
                if (b16 != 0) {
                    VideoGIFCreator.this.f65510f.setRotationAndFlip(-b16, 0, 0);
                    VideoGIFCreator.this.f65510f.RenderProcess(VideoGIFCreator.this.f65512h.getTextureId(), VideoGIFCreator.this.f65515k, VideoGIFCreator.this.f65516l, -1, 0.0d, VideoGIFCreator.this.f65513i);
                    frame = VideoGIFCreator.this.f65513i;
                }
            }
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
            if (VideoGIFCreator.this.f65520p != null) {
                float f16 = (VideoGIFCreator.this.f65520p.f65534b * 2.0f) - 1.0f;
                float f17 = (VideoGIFCreator.this.f65520p.f65535c * 2.0f) - 1.0f;
                float f18 = (VideoGIFCreator.this.f65520p.f65536d * 2.0f) + f16;
                float f19 = (VideoGIFCreator.this.f65520p.f65537e * 2.0f) + f17;
                VideoGIFCreator.this.f65508d.setPositions(new float[]{f16, f17, f16, f19, f18, f19, f18, f17});
                VideoGIFCreator.this.f65508d.RenderProcess(VideoGIFCreator.this.f65520p.f65533a, frame.width, frame.height, -1, 0.0d, frame);
            }
            Frame frame2 = FrameBufferCache.getInstance().get(VideoGIFCreator.this.f65515k, VideoGIFCreator.this.f65516l);
            FrameUtil.clearFrame(frame2, 0.0f, 0.0f, 0.0f, 0.0f, frame2.width, frame2.height);
            VideoGIFCreator.this.f65509e.RenderProcess(frame.getTextureId(), VideoGIFCreator.this.f65515k, VideoGIFCreator.this.f65516l, -1, 0.0d, frame2);
            Bitmap saveTexture = RendererUtils.saveTexture(frame2);
            frame.unlock();
            frame2.unlock();
            GLES20.glDisable(3042);
            VideoGIFCreator.this.f65518n.b(saveTexture, 55);
            saveTexture.recycle();
            QLog.d(VideoGIFCreator.f65504r, 4, "gif creator decodeToSurface()");
            if (VideoGIFCreator.this.f65506b.a()) {
                return;
            }
            QLog.d(VideoGIFCreator.f65504r, 4, "gifEncoder.close() start");
            VideoGIFCreator.this.f65518n.a();
            QLog.d(VideoGIFCreator.f65504r, 4, "gifEncoder.close() end");
            QLog.d(VideoGIFCreator.f65504r, 4, "gif encode complete");
            String str = g.b.C0560b.f65275b + File.separator + System.currentTimeMillis() + "_compressed.gif";
            q.d(str);
            QLog.d(VideoGIFCreator.f65504r, 4, "gif compress start");
            int compressGif = GifUtil.compressGif(this.f65531d, str, 30);
            QLog.d(VideoGIFCreator.f65504r, 4, "gif compress end, ret = " + compressGif);
            q.d(this.f65531d);
            if (compressGif > 0) {
                VideoGIFCreator.this.f65519o.onGifCreateSuccess(str);
            } else {
                VideoGIFCreator.this.f65519o.onGifCreateFail();
            }
            VideoGIFCreator.this.A();
        }
    }

    public VideoGIFCreator(final String str, final float f16, final long j3) {
        QLog.d(f65504r, 4, "input video = " + str);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("GIFCreatorHT");
        baseHandlerThread.start();
        Handler handler = new Handler(baseHandlerThread.getLooper());
        this.f65505a = handler;
        handler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.2
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                VideoGIFCreator.this.f65514j = iArr[0];
                VideoGIFCreator.this.f65517m = new SurfaceTexture(iArr[0]);
                VideoGIFCreator.this.f65506b = new d();
                VideoGIFCreator.this.f65506b.e(str, f16, j3, new Surface(VideoGIFCreator.this.f65517m));
                VideoGIFCreator videoGIFCreator = VideoGIFCreator.this;
                videoGIFCreator.f65515k = videoGIFCreator.f65506b.d();
                VideoGIFCreator videoGIFCreator2 = VideoGIFCreator.this;
                videoGIFCreator2.f65516l = videoGIFCreator2.f65506b.c();
                int min = Math.min(VideoGIFCreator.this.f65515k, VideoGIFCreator.this.f65516l);
                if (min > 360) {
                    double d16 = min / 360.0d;
                    VideoGIFCreator.this.f65515k = (int) Math.floor(r2.f65515k / d16);
                    VideoGIFCreator.this.f65516l = (int) Math.floor(r2.f65516l / d16);
                }
                VideoGIFCreator.this.z();
            }
        });
    }
}
