package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import r92.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020$\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J.\u0010\u0018\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010#\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\"H\u0016R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/nearby/now/view/f;", "Lr92/a;", "", "k", "Landroid/view/View;", "getView", "e", "start", "", com.tencent.luggage.wxa.c8.c.G, "seekTo", "getCurrentPosition", "pause", "restart", "getDuration", "", HippyQQPagView.FunctionName.GET_PROGRESS, "", "isPlaying", "", "vid", "localPath", "remotePath", QFSEdgeItem.KEY_VIDEO_TIME, "a", "Lr92/a$a;", "listener", "d", "Lr92/a$c;", "b", "Lr92/a$d;", "f", "Lr92/a$e;", "g", "Lr92/a$b;", "c", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "videoView", "Lr92/a$a;", "onCompletionListener", "Lr92/a$c;", "onErrorListener", "Lr92/a$e;", "onPreparedListener", "<init>", "(Landroid/content/Context;)V", "qqnearby_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f implements r92.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private BaseVideoView videoView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private a.InterfaceC11126a onCompletionListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a.c onErrorListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a.e onPreparedListener;

    public f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        k();
    }

    private final void k() {
        IBaseVideoView createBaseVideoView = QQVideoViewFactory.createBaseVideoView(this.context, 0L, null, null);
        Intrinsics.checkNotNull(createBaseVideoView, "null cannot be cast to non-null type com.tencent.mobileqq.videoplatform.view.BaseVideoView");
        this.videoView = (BaseVideoView) createBaseVideoView;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    @Override // r92.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String vid, String localPath, String remotePath, long videoTime) {
        boolean z16;
        BaseVideoView baseVideoView;
        boolean endsWith$default;
        if (this.videoView == null) {
            k();
            return;
        }
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mSceneName = SceneID.getSceneStr(129);
        videoPlayParam.mSceneId = 129;
        boolean z17 = false;
        if (localPath != null) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(localPath, ".mp4", false, 2, null);
            if (endsWith$default) {
                z16 = true;
                if (z16) {
                    videoPlayParam.mUrls = new String[]{remotePath};
                } else {
                    videoPlayParam.mVideoPath = localPath;
                    z17 = true;
                }
                videoPlayParam.mIsLocal = z17;
                if (videoTime > 0) {
                    videoPlayParam.mMaxPlayTimeMs = videoTime;
                }
                videoPlayParam.mNeedPlayProgress = true;
                videoPlayParam.mCallback = new a();
                baseVideoView = this.videoView;
                if (baseVideoView == null) {
                    baseVideoView.setVideoParam(videoPlayParam);
                    start();
                    return;
                }
                return;
            }
        }
        z16 = false;
        if (z16) {
        }
        videoPlayParam.mIsLocal = z17;
        if (videoTime > 0) {
        }
        videoPlayParam.mNeedPlayProgress = true;
        videoPlayParam.mCallback = new a();
        baseVideoView = this.videoView;
        if (baseVideoView == null) {
        }
    }

    @Override // r92.a
    public void b(a.c listener) {
        this.onErrorListener = listener;
    }

    @Override // r92.a
    public void d(a.InterfaceC11126a listener) {
        this.onCompletionListener = listener;
    }

    @Override // r92.a
    public void e() {
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.releasePlayer(false);
            this.videoView = null;
        }
        this.onCompletionListener = null;
        this.onErrorListener = null;
        this.onPreparedListener = null;
    }

    @Override // r92.a
    public void g(a.e listener) {
        this.onPreparedListener = listener;
    }

    @Override // r92.a
    public long getCurrentPosition() {
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            return baseVideoView.getCurPlayingPos();
        }
        return 0L;
    }

    @Override // r92.a
    public long getDuration() {
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            return baseVideoView.getVideoDurationMs();
        }
        return 0L;
    }

    @Override // r92.a
    public int getProgress() {
        if (this.videoView != null) {
            return (int) ((r0.getCurPlayingPos() * 100) / (r0.getVideoDurationMs() + 0.1d));
        }
        return -1;
    }

    @Override // r92.a
    public View getView() {
        return this.videoView;
    }

    @Override // r92.a
    public boolean isPlaying() {
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            return baseVideoView.isPlaying();
        }
        return false;
    }

    @Override // r92.a
    public void pause() {
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.pause();
        }
    }

    @Override // r92.a
    public void restart() {
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.seekTo(0);
            baseVideoView.play();
        }
    }

    @Override // r92.a
    public void seekTo(long pos) {
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.seekTo((int) pos);
        }
    }

    @Override // r92.a
    public void start() {
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView == null || baseVideoView.isPlaying()) {
            return;
        }
        baseVideoView.play();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J2\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J2\u0010\u0019\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/nearby/now/view/f$a", "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayerCallback;", "", "id", "", "state", "", "onStateChange", "p0", "p1", "onLoopBack", "onDownloadComplete", "onDownloadProgress", "onPlayProgress", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "exInfo", "onPlayError", "", "p2", "p3", "Landroid/graphics/Bitmap;", "p4", "onCapFrame", "onFirstFrameRendered", "qqnearby_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements VideoPlayerCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long id5, int module, int errorType, int errorCode, String exInfo) {
            a.c cVar = f.this.onErrorListener;
            if (cVar != null) {
                cVar.a(f.this, 0, 0, 0, exInfo, null);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long id5, int state) {
            a.InterfaceC11126a interfaceC11126a;
            if (state != 3) {
                if (state == 8 && (interfaceC11126a = f.this.onCompletionListener) != null) {
                    interfaceC11126a.a(f.this);
                    return;
                }
                return;
            }
            a.e eVar = f.this.onPreparedListener;
            if (eVar != null) {
                eVar.a(f.this);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadComplete(long p06) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long p06) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadProgress(long p06, long p16) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long p06, long p16) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long p06, long p16) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onCapFrame(long p06, boolean p16, int p26, int p36, Bitmap p46) {
        }
    }

    @Override // r92.a
    public void c(a.b listener) {
    }

    @Override // r92.a
    public void f(a.d listener) {
    }
}
