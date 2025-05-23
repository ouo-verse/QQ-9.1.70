package com.tencent.mobileqq.richmediabrowser.qqfloatingscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.g;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.view.EmptyDrawable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import tm2.f;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TVKVideoController implements g {
    private int C;
    private int D;
    private URLDrawable E;
    private long F;

    /* renamed from: e, reason: collision with root package name */
    private f f281874e;

    /* renamed from: f, reason: collision with root package name */
    private VideoPlayParam f281875f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Context> f281876h;

    /* renamed from: i, reason: collision with root package name */
    private IVideoOuterStatusListener f281877i;

    /* renamed from: m, reason: collision with root package name */
    private BaseVideoView f281878m;

    /* renamed from: d, reason: collision with root package name */
    private int f281873d = 0;
    b.c G = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IVideoInnerStatusListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoClose(int i3) {
            TVKVideoController.this.r();
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoSeek(int i3) {
            if (TVKVideoController.this.f281878m != null) {
                int videoDurationMs = (int) ((i3 * TVKVideoController.this.f281878m.getVideoDurationMs()) / 100.0d);
                TVKVideoController.this.C(videoDurationMs);
                if (QLog.isColorLevel()) {
                    QLog.d("TVKVideoController", 2, "mOuterStatusListener notifyVideoSeek : " + i3 + "  seekMillSec :" + videoDurationMs);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStart() {
            TVKVideoController.this.p();
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStop() {
            TVKVideoController.this.A();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements b.c {
        b() {
        }

        @Override // com.tencent.mobileqq.mediafocus.b.c
        public void a(int i3) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TVKVideoController", 4, "onFocusChange focusType:", Integer.valueOf(i3));
            }
            if (i3 != -2) {
                if (i3 != -1) {
                    if (i3 == 1) {
                        ((AudioManager) ((Context) TVKVideoController.this.f281876h.get()).getSystemService("audio")).requestAudioFocus(null, 3, 2);
                        if (TVKVideoController.this.f281878m != null) {
                            TVKVideoController.this.f281878m.play();
                        }
                        TVKVideoController.this.f281873d = 4;
                        return;
                    }
                    return;
                }
                if (TVKVideoController.this.f281878m != null) {
                    TVKVideoController.this.f281878m.pause();
                }
                TVKVideoController.this.f281873d = 6;
                if (TVKVideoController.this.f281877i != null) {
                    TVKVideoController.this.f281877i.onVideoStop();
                    return;
                }
                return;
            }
            if (TVKVideoController.this.f281878m != null) {
                TVKVideoController.this.f281878m.setMute(true);
            }
        }
    }

    public TVKVideoController(Context context) {
        this.f281876h = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        com.tencent.mobileqq.mediafocus.b.i().d(this.G);
        if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "onPause ===");
        }
        BaseVideoView baseVideoView = this.f281878m;
        if (baseVideoView != null) {
            baseVideoView.pause();
        }
        this.f281873d = 6;
    }

    private void B() {
        if (com.tencent.mobileqq.mediafocus.b.i().l(1, this.G) == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onPlay ===");
            }
            BaseVideoView baseVideoView = this.f281878m;
            if (baseVideoView != null) {
                baseVideoView.play();
            }
            this.f281873d = 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "onSeek === progress : " + i3);
        }
        BaseVideoView baseVideoView = this.f281878m;
        if (baseVideoView != null) {
            baseVideoView.seekTo(i3);
        }
    }

    private void D(VideoPlayParam videoPlayParam) {
        videoPlayParam.mCallback = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f281874e == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "clickPlay mCurInfo is null");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "clickPlay curState:", Integer.valueOf(this.f281873d), ",path:", this.f281874e.f436608b);
            }
            B();
        }
    }

    private VideoPlayParam q(f fVar) {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        this.f281875f = videoPlayParam;
        videoPlayParam.mIsMute = false;
        videoPlayParam.mSceneId = 116;
        videoPlayParam.mSceneName = SceneID.getSceneStr(116);
        VideoPlayParam videoPlayParam2 = this.f281875f;
        videoPlayParam2.mNeedPlayProgress = true;
        if (fVar != null) {
            videoPlayParam2.mStartPlayPosMs = fVar.f436623q;
            boolean z16 = true ^ fVar.f436607a;
            videoPlayParam2.mIsLocal = z16;
            if (z16) {
                videoPlayParam2.mVideoPath = fVar.f436608b;
            } else {
                videoPlayParam2.mUrls = fVar.f436609c;
                videoPlayParam2.mSavePath = fVar.f436608b;
            }
        }
        D(videoPlayParam2);
        return this.f281875f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3, int i16) {
        int i17;
        if (i3 == 1) {
            i17 = 402;
        } else {
            i17 = 401;
        }
        if (i16 == 14011001) {
            i17 = 403;
        }
        IVideoOuterStatusListener iVideoOuterStatusListener = this.f281877i;
        if (iVideoOuterStatusListener != null) {
            iVideoOuterStatusListener.onVideoError(i17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        com.tencent.mobileqq.mediafocus.b.i().d(this.G);
        WeakReference<Context> weakReference = this.f281876h;
        if (weakReference != null && weakReference.get() != null) {
            ((AudioManager) this.f281876h.get().getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        BaseVideoView baseVideoView;
        if (this.f281877i != null && (baseVideoView = this.f281878m) != null) {
            long videoDurationMs = baseVideoView.getVideoDurationMs();
            if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "mVideoView.getVideoDurationMs = " + videoDurationMs);
            }
            this.f281877i.onVideoStart((int) videoDurationMs);
        }
    }

    public void r() {
        if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "destory!");
        }
        WeakReference<Context> weakReference = this.f281876h;
        if (weakReference != null && weakReference.get() != null) {
            ((AudioManager) this.f281876h.get().getSystemService("audio")).abandonAudioFocus(null);
        }
        this.f281874e = null;
        this.f281876h = null;
        this.E = null;
        BaseVideoView baseVideoView = this.f281878m;
        if (baseVideoView != null) {
            baseVideoView.releasePlayer(false);
        }
        this.f281878m = null;
        com.tencent.mobileqq.mediafocus.b.i().d(this.G);
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).removeMsgRevokerListener(this);
    }

    public boolean s(int i3, int i16, int i17) {
        float f16;
        boolean z16;
        if (i16 > 0 && i17 > 0) {
            f16 = i16 / i17;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "videoWidth or videoHeight Wrong. videoWidth = " + i16 + " videoHeight = " + i17);
            }
            f16 = 0.5625f;
        }
        if (f16 > 1.0f) {
            f16 = 1.0f / f16;
        }
        if (i16 > i17) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(BaseApplication.getContext(), this.f281878m, new FloatingScreenParams.FloatingBuilder().setIsHorizontal(z16).setRatio(f16).setCanMove(true).setCanZoom(true).build(), com.tencent.mobileqq.qqfloatingwindow.b.a(i3)) == 1) {
            ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(this.f281876h.get());
            return false;
        }
        v();
        p();
        return true;
    }

    public void u(String str, int i3, int i16) {
        URL thumbUrl;
        this.C = i3;
        this.D = i16;
        if (FileUtils.fileExistsAndNotEmpty(str) && (thumbUrl = ((IShortVideoDepend) QRoute.api(IShortVideoDepend.class)).getThumbUrl(str)) != null) {
            String url = thumbUrl.toString();
            if (!TextUtils.isEmpty(url)) {
                EmptyDrawable emptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), i3, i16);
                try {
                    URLDrawable drawable = URLDrawable.getDrawable(url, emptyDrawable, emptyDrawable);
                    if (drawable.getStatus() != 1) {
                        drawable.downloadImediatly();
                    }
                    this.E = drawable;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TVKVideoController", 2, "initCover():  getDrawable Exception, coverUrl=" + url, e16);
                    }
                }
            }
        }
    }

    public void v() {
        this.f281877i = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new a());
    }

    @Override // com.tencent.mobileqq.richmediabrowser.g
    public void v5(long j3) {
        if (this.F == j3) {
            if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onRecokeMsg:", Long.valueOf(j3));
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.qqfloatingscreen.TVKVideoController.2
                @Override // java.lang.Runnable
                public void run() {
                    ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen();
                }
            });
        }
    }

    public void w(String str, long j3, long j16) {
        long j17;
        if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "initTVKVideoController with path:", str);
        }
        File file = new File(str);
        if (file.exists()) {
            j17 = file.length();
        } else {
            j17 = 0;
        }
        this.F = j3;
        f fVar = new f();
        this.f281874e = fVar;
        fVar.f436607a = false;
        fVar.f436608b = str;
        fVar.f436620n = j17;
        fVar.f436622p = j17;
        fVar.f436623q = j16;
        this.f281875f = q(fVar);
        this.f281878m = (BaseVideoView) QQVideoViewFactory.createBaseVideoView(this.f281876h.get(), 0L, this.f281875f, null);
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).addMsgRevokerListener(this);
    }

    public void x(f fVar, long j3, long j16) {
        if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "initTVKVideoController with mediaInfo :", fVar.f436608b);
        }
        this.F = j3;
        this.f281874e = fVar;
        fVar.f436623q = j16;
        this.f281875f = q(fVar);
        this.f281878m = (BaseVideoView) QQVideoViewFactory.createBaseVideoView(this.f281876h.get(), 0L, this.f281875f, null);
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).addMsgRevokerListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements VideoPlayerCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long j3, int i3, int i16, int i17, String str) {
            QLog.e("TVKVideoController", 1, "module ===== " + i3 + "  errorType ===== " + i16 + "  errorCode ==== " + i17 + "  exInfo === " + str);
            TVKVideoController.this.t(i3, i17);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long j3, long j16) {
            if (TVKVideoController.this.f281877i != null) {
                TVKVideoController.this.f281877i.onVideoProgressUpdate((int) j16);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long j3, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onStateChange , state = " + i3 + ", msgUniseq=" + j3);
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    TVKVideoController.this.z();
                    TVKVideoController.this.f281873d = 4;
                    return;
                }
                if (i3 != 5) {
                    if (i3 == 7) {
                        TVKVideoController.this.f281873d = 7;
                        return;
                    }
                    if (i3 == 8) {
                        if (TVKVideoController.this.f281874e != null) {
                            TVKVideoController.this.f281874e.f436623q = 0L;
                        }
                        if (TVKVideoController.this.f281875f != null) {
                            TVKVideoController.this.f281875f.mStartPlayPosMs = 0L;
                        }
                        TVKVideoController.this.y();
                        if (TVKVideoController.this.f281877i != null) {
                            TVKVideoController.this.f281877i.onVideoComplete(true);
                            TVKVideoController.this.f281877i.onVideoProgressUpdate(0);
                        }
                        TVKVideoController.this.f281873d = 8;
                        return;
                    }
                    return;
                }
                if (TVKVideoController.this.f281877i != null) {
                    TVKVideoController.this.f281877i.onVideoBuffering();
                }
                TVKVideoController.this.f281873d = 5;
                return;
            }
            if (TVKVideoController.this.E != null && TVKVideoController.this.f281877i != null) {
                TVKVideoController.this.f281877i.onSetVideoCover(TVKVideoController.this.E);
                TVKVideoController.this.f281877i.onVideoSize(TVKVideoController.this.C, TVKVideoController.this.D);
            }
            TVKVideoController.this.f281873d = 3;
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadComplete(long j3) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long j3) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadProgress(long j3, long j16) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long j3, long j16) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
        }
    }
}
