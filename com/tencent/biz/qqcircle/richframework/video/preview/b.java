package com.tencent.biz.qqcircle.richframework.video.preview;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.richframework.video.preview.QFSVideoCaptureFrameTaskQueue;
import com.tencent.biz.qqcircle.richframework.video.preview.a;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements a, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, QFSVideoCaptureFrameTaskQueue.a, ISuperPlayer.OnSeekCompleteListener {
    private static volatile Object J = new Object();
    private ISPlayerVideoView C;
    private int D;
    private int E;
    private String F;
    private a.InterfaceC0927a G;
    private final AtomicBoolean H = new AtomicBoolean();
    private final AtomicLong I = new AtomicLong();

    /* renamed from: d, reason: collision with root package name */
    private ISuperPlayer f92060d;

    /* renamed from: e, reason: collision with root package name */
    private String f92061e;

    /* renamed from: f, reason: collision with root package name */
    private long f92062f;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f92063h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f92064i;

    /* renamed from: m, reason: collision with root package name */
    private volatile QFSVideoCaptureFrameTaskQueue f92065m;

    private void h() {
        release();
    }

    private void i(final int i3, final TextureView textureView) {
        RFWThreadManager.getInstance().getSerialThreadHandler().removeCallbacksAndMessages(J);
        RFWThreadManager.getInstance().getSerialThreadHandler().postAtTime(new Runnable() { // from class: mb0.c
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.biz.qqcircle.richframework.video.preview.b.this.k(textureView, i3);
            }
        }, J, SystemClock.uptimeMillis());
    }

    private void j(String str, long j3) {
        if (this.f92063h == null) {
            QLog.e("QPP-QFSSuperPlayerPreviewProxy", 1, "[initPlayer] preview video view container should not be null.");
            return;
        }
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(QCircleApplication.getAPP());
        this.C = createPlayerVideoView;
        if (!(createPlayerVideoView instanceof View)) {
            QLog.d("QPP-QFSSuperPlayerPreviewProxy", 1, "[initPlayer] current player video not is view.");
            return;
        }
        createPlayerVideoView.setXYaxis(2);
        this.f92063h.addView((View) this.C, new ViewGroup.LayoutParams(this.D, this.E));
        int a16 = mb0.a.a(j3);
        QLog.d("QPP-QFSSuperPlayerPreviewProxy", 1, "[initSuperPlayer] url: " + str + " | duration: " + j3 + " | durationToSecond: " + a16);
        o();
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(QCircleApplication.getAPP(), QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), this.C);
        this.f92060d = createMediaPlayer;
        createMediaPlayer.setOutputMute(true);
        this.f92060d.setOnVideoPreparedListener(this);
        this.f92060d.setOnErrorListener(this);
        this.f92060d.setBusinessDownloadStrategy(a16, a16, a16, a16);
        this.f92060d.setOnInfoListener(this);
        this.f92060d.setOnSeekCompleteListener(this);
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(str, 101, (String) null);
        createVideoInfoForUrl.setFileId(RFWVideoUtils.getFileIdWithTapPosition(str, ""));
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        obtain.tpCoreSampleRate = c.w4();
        this.f92060d.openMediaPlayer(QCircleApplication.getAPP(), createVideoInfoForUrl, 0L, obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(TextureView textureView, int i3) {
        if (textureView == null) {
            QLog.e("QPP-QFSSuperPlayerPreviewProxy", 1, "[handleSeekCompleteCapture] texture view should not be null.");
            return;
        }
        if (!textureView.isAvailable()) {
            QLog.e("QPP-QFSSuperPlayerPreviewProxy", 1, "[handleSeekCompleteCapture] current surface not is available, end flow.");
            return;
        }
        DisplayMetrics displayMetrics = textureView.getResources().getDisplayMetrics();
        int width = textureView.getWidth();
        int height = textureView.getHeight();
        if (width > 0 && height > 0) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(displayMetrics, width, height, Bitmap.Config.RGB_565);
                textureView.getBitmap(createBitmap);
                if (this.f92065m == null) {
                    QLog.e("QPP-QFSSuperPlayerPreviewProxy", 1, "[handleSeekCompleteCaptureBitmap] video capture frame task queue not be null.");
                    return;
                } else {
                    this.f92065m.A(i3, createBitmap);
                    return;
                }
            } catch (Throwable th5) {
                QLog.e("QPP-QFSSuperPlayerPreviewProxy", 1, "[handleSeekCompleteCaptureBitmap] ex: ", th5);
                return;
            }
        }
        QLog.e("QPP-QFSSuperPlayerPreviewProxy", 1, "[handleSeekCompleteCaptureBitmap] previewWidth <= 0 || previewHeight <= 0.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        a.InterfaceC0927a interfaceC0927a = this.G;
        if (interfaceC0927a == null) {
            return;
        }
        interfaceC0927a.a();
    }

    private void m() {
        a.InterfaceC0927a interfaceC0927a = this.G;
        if (interfaceC0927a == null) {
            return;
        }
        interfaceC0927a.onDecodeFirstFrame();
    }

    private void n() {
        RFWThreadManager.getUIHandler().postAtTime(new Runnable() { // from class: mb0.b
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.biz.qqcircle.richframework.video.preview.b.this.l();
            }
        }, SystemClock.uptimeMillis());
    }

    private void o() {
        ISuperPlayer iSuperPlayer = this.f92060d;
        if (iSuperPlayer == null) {
            return;
        }
        try {
            iSuperPlayer.release();
            this.f92060d.setOnVideoPreparedListener(null);
            this.f92060d.setOnErrorListener(null);
            this.f92060d.setOnInfoListener(null);
            this.f92060d.setOnSeekCompleteListener(null);
        } catch (Throwable th5) {
            RFWLog.d("QPP-QFSSuperPlayerPreviewProxy", RFWLog.USR, "[releasePlayer] ex", th5);
        }
        this.f92060d = null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.video.preview.a
    public void a(a.InterfaceC0927a interfaceC0927a) {
        this.G = interfaceC0927a;
    }

    @Override // com.tencent.biz.qqcircle.richframework.video.preview.QFSVideoCaptureFrameTaskQueue.a
    public void b(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            if (this.f92064i == null) {
                QLog.d("QPP-QFSSuperPlayerPreviewProxy", 1, "[setCacheBitmapToPreview] pre view image should not be null.");
                return;
            }
            String valueOf = String.valueOf(bitmap.hashCode());
            if (!TextUtils.equals(valueOf, this.F)) {
                this.f92064i.setImageBitmap(bitmap);
                this.F = valueOf;
            }
            if (!this.H.get()) {
                this.H.set(true);
                m();
                return;
            }
            return;
        }
        QLog.d("QPP-QFSSuperPlayerPreviewProxy", 1, "[setCacheBitmapToPreview] current bitmap is invalid, end flow.");
    }

    @Override // com.tencent.biz.qqcircle.richframework.video.preview.a
    public void c(View view, ImageView imageView, int i3, int i16) {
        this.f92064i = imageView;
        if (!(view instanceof FrameLayout) || !(imageView instanceof ImageView)) {
            return;
        }
        this.D = i3;
        this.E = i16;
        this.f92063h = (FrameLayout) view;
        this.f92064i = imageView;
        this.f92065m = new QFSVideoCaptureFrameTaskQueue();
        this.f92065m.w(this);
        this.f92065m.x(i3, i16);
    }

    @Override // com.tencent.biz.qqcircle.richframework.video.preview.a
    public void d(String str, long j3, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.d("QPP-QFSSuperPlayerPreviewProxy", 1, "[init] local video path, init fail.");
            return;
        }
        this.H.set(false);
        j(str, j3);
        this.f92061e = str;
        this.f92062f = j3;
        if (this.f92065m != null) {
            this.f92065m.v(i3);
            this.f92065m.o(j3);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.video.preview.QFSVideoCaptureFrameTaskQueue.a
    public int e(long j3, int i3, int i16) {
        if (this.f92060d != null) {
            synchronized (b.class) {
                ISuperPlayer iSuperPlayer = this.f92060d;
                if (iSuperPlayer != null) {
                    iSuperPlayer.seekTo((int) j3, 3);
                    this.I.set(j3);
                }
            }
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        if (i3 == 105) {
            RFWLog.d("QPP-QFSSuperPlayerPreviewProxy", 1, "[onInfo] PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED.");
        } else if (i3 == 103) {
            n();
        } else if (i3 == 201) {
            RFWLog.d("QPP-QFSSuperPlayerPreviewProxy", 1, "[onInfo] PLAYER_INFO_ALL_DOWNLOAD_FINISH.");
        } else if (i3 == 253) {
            h();
            RFWLog.d("QPP-QFSSuperPlayerPreviewProxy", 1, "[onInfo] PLAYER_INFO_AUTO_DEINIT.");
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        View renderView;
        if (this.f92065m != null && iSuperPlayer != null) {
            int a16 = mb0.a.a(this.I.get());
            ISPlayerVideoView iSPlayerVideoView = this.C;
            if (iSPlayerVideoView == null) {
                renderView = null;
            } else {
                renderView = iSPlayerVideoView.getRenderView();
            }
            if (renderView instanceof TextureView) {
                i(a16, (TextureView) renderView);
            } else {
                this.f92065m.A(a16, null);
            }
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        if (this.f92065m != null) {
            this.f92065m.A(0, null);
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.video.preview.a
    public void release() {
        QLog.d("QPP-QFSSuperPlayerPreviewProxy", 1, "[release] clear queue list and player source.");
        o();
        if (this.f92065m != null) {
            this.f92065m.r();
            this.f92065m.w(null);
        }
        this.H.set(false);
        RFWThreadManager.getInstance().getSerialThreadHandler().removeCallbacksAndMessages(J);
    }

    @Override // com.tencent.biz.qqcircle.richframework.video.preview.a
    public void reset() {
        if (this.f92065m != null) {
            this.f92065m.t();
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.video.preview.a
    public void seek(long j3) {
        if (this.f92060d == null) {
            QLog.d("QPP-QFSSuperPlayerPreviewProxy", 1, "[seek] current seek super player is null, init create player.");
            j(this.f92061e, this.f92062f);
        }
        if (this.f92065m != null) {
            this.f92065m.u(j3);
        }
    }
}
