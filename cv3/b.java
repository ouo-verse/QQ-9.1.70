package cv3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.video.RFWPlayerVideoInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 L2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010I\u001a\u00020.\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002J \u0010\u001a\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tJ&\u0010!\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0006R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010%R\u0016\u0010=\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010%R\u0018\u0010@\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\"\u0010H\u001a\u00020A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcv3/b;", "", "Lcom/tencent/richframework/video/RFWPlayerVideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayParam;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "progress", BdhLogUtil.LogTag.Tag_Conn, "y", "p", "module", "errorCode", "t", "videoPlayParam", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "info", "w", "Landroid/graphics/drawable/Drawable;", "coverDrawable", "width", "height", "u", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "uinType", "videoWidth", "videoHeight", "", ReportConstant.COSTREPORT_PREFIX, "v", "r", "a", "I", "mVideoState", "b", "Lcom/tencent/richframework/video/RFWPlayerVideoInfo;", "mInfo", "c", "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayParam;", "mVideoPlayParam", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "d", "Ljava/lang/ref/WeakReference;", "mContext", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoOuterStatusListener;", "e", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoOuterStatusListener;", "mOuterStatusListener", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "f", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "mVideoView", "g", "mVideoWidth", h.F, "mVideoHeight", "i", "Landroid/graphics/drawable/Drawable;", "mCoverDrawable", "Lcom/tencent/mobileqq/mediafocus/b$c;", "j", "Lcom/tencent/mobileqq/mediafocus/b$c;", "getMMediaFocusListener", "()Lcom/tencent/mobileqq/mediafocus/b$c;", "setMMediaFocusListener", "(Lcom/tencent/mobileqq/mediafocus/b$c;)V", "mMediaFocusListener", "context", "<init>", "(Landroid/content/Context;)V", "k", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mVideoState;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private RFWPlayerVideoInfo mInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private VideoPlayParam mVideoPlayParam;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Context> mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IVideoOuterStatusListener mOuterStatusListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private BaseVideoView mVideoView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int mVideoWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mVideoHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Drawable mCoverDrawable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private b.c mMediaFocusListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"cv3/b$b", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoInnerStatusListener;", "", "notifyVideoStart", "notifyVideoStop", "", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "notifyVideoSeek", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "notifyVideoClose", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cv3.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10140b implements IVideoInnerStatusListener {
        C10140b() {
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoClose(int closeReason) {
            b.this.r();
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoSeek(int seek) {
            if (b.this.mVideoView != null) {
                Intrinsics.checkNotNull(b.this.mVideoView);
                int videoDurationMs = (int) ((seek * r2.getVideoDurationMs()) / 100.0f);
                b.this.C(videoDurationMs);
                if (QLog.isColorLevel()) {
                    QLog.d("NTVideoController", 2, "mOuterStatusListener notifyVideoSeek : " + seek + "  seekMillSec :" + videoDurationMs);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStart() {
            b.this.p();
        }

        @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
        public void notifyVideoStop() {
            b.this.A();
        }
    }

    public b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMediaFocusListener = new b.c() { // from class: cv3.a
            @Override // com.tencent.mobileqq.mediafocus.b.c
            public final void a(int i3) {
                b.x(b.this, i3);
            }
        };
        this.mContext = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        com.tencent.mobileqq.mediafocus.b.i().d(this.mMediaFocusListener);
        if (QLog.isColorLevel()) {
            QLog.d("NTVideoController", 2, "onPause ===");
        }
        BaseVideoView baseVideoView = this.mVideoView;
        if (baseVideoView != null) {
            baseVideoView.pause();
        }
        this.mVideoState = 6;
    }

    private final void B() {
        if (com.tencent.mobileqq.mediafocus.b.i().l(1, this.mMediaFocusListener) == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("NTVideoController", 2, "onPlay ===");
            }
            BaseVideoView baseVideoView = this.mVideoView;
            if (baseVideoView != null) {
                baseVideoView.play();
            }
            this.mVideoState = 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int progress) {
        if (QLog.isColorLevel()) {
            QLog.d("NTVideoController", 2, "onSeek === progress : " + progress);
        }
        BaseVideoView baseVideoView = this.mVideoView;
        if (baseVideoView != null) {
            baseVideoView.seekTo(progress);
        }
    }

    private final void D(VideoPlayParam videoPlayParam) {
        videoPlayParam.mCallback = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            objArr[0] = "clickPlay curState:";
            objArr[1] = Integer.valueOf(this.mVideoState);
            objArr[2] = ",path:";
            RFWPlayerVideoInfo rFWPlayerVideoInfo = this.mInfo;
            if (rFWPlayerVideoInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfo");
                rFWPlayerVideoInfo = null;
            }
            objArr[3] = rFWPlayerVideoInfo.mUrl;
            QLog.d("NTVideoController", 2, objArr);
        }
        B();
    }

    private final VideoPlayParam q(RFWPlayerVideoInfo videoInfo) {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        this.mVideoPlayParam = videoPlayParam;
        videoPlayParam.mIsMute = false;
        VideoPlayParam videoPlayParam2 = this.mVideoPlayParam;
        if (videoPlayParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
            videoPlayParam2 = null;
        }
        videoPlayParam2.mSceneId = 116;
        VideoPlayParam videoPlayParam3 = this.mVideoPlayParam;
        if (videoPlayParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
            videoPlayParam3 = null;
        }
        videoPlayParam3.mSceneName = SceneID.getSceneStr(116);
        VideoPlayParam videoPlayParam4 = this.mVideoPlayParam;
        if (videoPlayParam4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
            videoPlayParam4 = null;
        }
        videoPlayParam4.mNeedPlayProgress = true;
        VideoPlayParam videoPlayParam5 = this.mVideoPlayParam;
        if (videoPlayParam5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
            videoPlayParam5 = null;
        }
        videoPlayParam5.mStartPlayPosMs = videoInfo.mStartOffset;
        VideoPlayParam videoPlayParam6 = this.mVideoPlayParam;
        if (videoPlayParam6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
            videoPlayParam6 = null;
        }
        videoPlayParam6.mIsLocal = RFWFileUtils.isLocalPath(videoInfo.mUrl);
        VideoPlayParam videoPlayParam7 = this.mVideoPlayParam;
        if (videoPlayParam7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
            videoPlayParam7 = null;
        }
        if (videoPlayParam7.mIsLocal) {
            VideoPlayParam videoPlayParam8 = this.mVideoPlayParam;
            if (videoPlayParam8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
                videoPlayParam8 = null;
            }
            videoPlayParam8.mVideoPath = videoInfo.mUrl;
        } else {
            VideoPlayParam videoPlayParam9 = this.mVideoPlayParam;
            if (videoPlayParam9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
                videoPlayParam9 = null;
            }
            videoPlayParam9.mUrls = new String[]{videoInfo.mUrl};
            VideoPlayParam videoPlayParam10 = this.mVideoPlayParam;
            if (videoPlayParam10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
                videoPlayParam10 = null;
            }
            videoPlayParam10.mSavePath = videoInfo.mStorePath;
        }
        VideoPlayParam videoPlayParam11 = this.mVideoPlayParam;
        if (videoPlayParam11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
            videoPlayParam11 = null;
        }
        D(videoPlayParam11);
        VideoPlayParam videoPlayParam12 = this.mVideoPlayParam;
        if (videoPlayParam12 != null) {
            return videoPlayParam12;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(b this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isDevelopLevel()) {
            QLog.d("NTVideoController", 4, "onFocusChange focusType:", Integer.valueOf(i3));
        }
        if (i3 == -2) {
            BaseVideoView baseVideoView = this$0.mVideoView;
            if (baseVideoView == null) {
                return;
            }
            baseVideoView.setMute(true);
            return;
        }
        if (i3 == -1) {
            BaseVideoView baseVideoView2 = this$0.mVideoView;
            if (baseVideoView2 != null) {
                baseVideoView2.pause();
            }
            this$0.mVideoState = 6;
            IVideoOuterStatusListener iVideoOuterStatusListener = this$0.mOuterStatusListener;
            if (iVideoOuterStatusListener != null) {
                iVideoOuterStatusListener.onVideoStop();
                return;
            }
            return;
        }
        if (i3 != 1) {
            return;
        }
        WeakReference<Context> weakReference = this$0.mContext;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            weakReference = null;
        }
        Context context = weakReference.get();
        Object systemService = context != null ? context.getSystemService("audio") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        ((AudioManager) systemService).requestAudioFocus(null, 3, 2);
        BaseVideoView baseVideoView3 = this$0.mVideoView;
        if (baseVideoView3 != null) {
            baseVideoView3.play();
        }
        this$0.mVideoState = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        com.tencent.mobileqq.mediafocus.b.i().d(this.mMediaFocusListener);
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            weakReference = null;
        }
        if (weakReference.get() != null) {
            WeakReference<Context> weakReference2 = this.mContext;
            if (weakReference2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                weakReference2 = null;
            }
            Context context = weakReference2.get();
            Object systemService = context != null ? context.getSystemService("audio") : null;
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            ((AudioManager) systemService).abandonAudioFocus(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        BaseVideoView baseVideoView;
        if (this.mOuterStatusListener == null || (baseVideoView = this.mVideoView) == null) {
            return;
        }
        Intrinsics.checkNotNull(baseVideoView);
        long videoDurationMs = baseVideoView.getVideoDurationMs();
        if (QLog.isColorLevel()) {
            QLog.d("NTVideoController", 2, "mVideoView.getVideoDurationMs = " + videoDurationMs);
        }
        IVideoOuterStatusListener iVideoOuterStatusListener = this.mOuterStatusListener;
        Intrinsics.checkNotNull(iVideoOuterStatusListener);
        iVideoOuterStatusListener.onVideoStart((int) videoDurationMs);
    }

    public final void r() {
        if (QLog.isColorLevel()) {
            QLog.d("NTVideoController", 2, "destroy!");
        }
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            weakReference = null;
        }
        Context context = weakReference.get();
        Object systemService = context != null ? context.getSystemService("audio") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        ((AudioManager) systemService).abandonAudioFocus(null);
        this.mCoverDrawable = null;
        BaseVideoView baseVideoView = this.mVideoView;
        if (baseVideoView != null) {
            baseVideoView.releasePlayer(false);
        }
        this.mVideoView = null;
        com.tencent.mobileqq.mediafocus.b.i().d(this.mMediaFocusListener);
    }

    public final boolean s(Activity activity, int uinType, int videoWidth, int videoHeight) {
        float f16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (videoWidth <= 0 || videoHeight <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("NTVideoController", 2, "videoWidth or videoHeight Wrong. videoWidth = " + videoWidth + " videoHeight = " + videoHeight);
            }
            f16 = 0.5625f;
        } else {
            f16 = videoWidth / videoHeight;
        }
        if (f16 > 1.0f) {
            f16 = 1 / f16;
        }
        FloatingScreenParams build = new FloatingScreenParams.FloatingBuilder().setIsHorizontal(videoWidth > videoHeight).setRatio(f16).setCanMove(true).setCanZoom(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "FloatingBuilder()\n      \u2026\n                .build()");
        if (((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(RFWApplication.getApplication(), this.mVideoView, build, com.tencent.mobileqq.qqfloatingwindow.b.a(uinType)) == 1) {
            ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(activity);
            return false;
        }
        v();
        p();
        return true;
    }

    public final void u(Drawable coverDrawable, int width, int height) {
        this.mCoverDrawable = coverDrawable;
        this.mVideoWidth = width;
        this.mVideoHeight = height;
    }

    public final void v() {
        this.mOuterStatusListener = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(new C10140b());
    }

    public final void w(RFWPlayerVideoInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (QLog.isColorLevel()) {
            QLog.d("NTVideoController", 2, "initTVKVideoController with mediaInfo :", info.mUrl);
        }
        this.mInfo = info;
        this.mVideoPlayParam = q(info);
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            weakReference = null;
        }
        Context context = weakReference.get();
        VideoPlayParam videoPlayParam = this.mVideoPlayParam;
        if (videoPlayParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
            videoPlayParam = null;
        }
        IBaseVideoView createBaseVideoViewFS = QQVideoViewFactory.createBaseVideoViewFS(context, 0L, videoPlayParam, null);
        Intrinsics.checkNotNull(createBaseVideoViewFS, "null cannot be cast to non-null type com.tencent.mobileqq.videoplatform.view.BaseVideoView");
        this.mVideoView = (BaseVideoView) createBaseVideoViewFS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int module, int errorCode) {
        int i3 = module == 1 ? 402 : 401;
        if (errorCode == 14011001) {
            i3 = 403;
        }
        IVideoOuterStatusListener iVideoOuterStatusListener = this.mOuterStatusListener;
        if (iVideoOuterStatusListener != null) {
            iVideoOuterStatusListener.onVideoError(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016J0\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J0\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002H\u0016\u00a8\u0006\u001e"}, d2 = {"cv3/b$c", "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayerCallback;", "", "id", "", "state", "", "onStateChange", "position", "onLoopBack", "onDownloadComplete", "downSize", "onDownloadProgress", "positionMs", "onPlayProgress", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "exInfo", "onPlayError", "l", "", "b", "i", "i1", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onCapFrame", "onFirstFrameRendered", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements VideoPlayerCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onCapFrame(long l3, boolean b16, int i3, int i16, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long id5, int module, int errorType, int errorCode, String exInfo) {
            Intrinsics.checkNotNullParameter(exInfo, "exInfo");
            QLog.e("NTVideoController", 1, "module ===== " + module + "  errorType ===== " + errorType + "  errorCode ==== " + errorCode + "  exInfo === " + exInfo);
            b.this.t(module, errorCode);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long id5, long positionMs) {
            IVideoOuterStatusListener iVideoOuterStatusListener = b.this.mOuterStatusListener;
            if (iVideoOuterStatusListener != null) {
                iVideoOuterStatusListener.onVideoProgressUpdate((int) positionMs);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long id5, int state) {
            if (QLog.isColorLevel()) {
                QLog.d("NTVideoController", 2, "onStateChange , state = " + state + ", msgUniseq=" + id5);
            }
            if (state == 3) {
                if (b.this.mCoverDrawable != null && b.this.mOuterStatusListener != null) {
                    IVideoOuterStatusListener iVideoOuterStatusListener = b.this.mOuterStatusListener;
                    if (iVideoOuterStatusListener != null) {
                        iVideoOuterStatusListener.onSetVideoCover(b.this.mCoverDrawable);
                    }
                    IVideoOuterStatusListener iVideoOuterStatusListener2 = b.this.mOuterStatusListener;
                    if (iVideoOuterStatusListener2 != null) {
                        iVideoOuterStatusListener2.onVideoSize(b.this.mVideoWidth, b.this.mVideoHeight);
                    }
                }
                b.this.mVideoState = 3;
                return;
            }
            if (state == 4) {
                b.this.z();
                b.this.mVideoState = 4;
                return;
            }
            if (state == 5) {
                IVideoOuterStatusListener iVideoOuterStatusListener3 = b.this.mOuterStatusListener;
                if (iVideoOuterStatusListener3 != null) {
                    iVideoOuterStatusListener3.onVideoBuffering();
                }
                b.this.mVideoState = 5;
                return;
            }
            if (state == 7) {
                b.this.mVideoState = 7;
                return;
            }
            if (state != 8) {
                return;
            }
            RFWPlayerVideoInfo rFWPlayerVideoInfo = b.this.mInfo;
            VideoPlayParam videoPlayParam = null;
            if (rFWPlayerVideoInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfo");
                rFWPlayerVideoInfo = null;
            }
            rFWPlayerVideoInfo.mStartOffset = 0L;
            VideoPlayParam videoPlayParam2 = b.this.mVideoPlayParam;
            if (videoPlayParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoPlayParam");
            } else {
                videoPlayParam = videoPlayParam2;
            }
            videoPlayParam.mStartPlayPosMs = 0L;
            b.this.y();
            IVideoOuterStatusListener iVideoOuterStatusListener4 = b.this.mOuterStatusListener;
            if (iVideoOuterStatusListener4 != null) {
                iVideoOuterStatusListener4.onVideoComplete(true);
            }
            IVideoOuterStatusListener iVideoOuterStatusListener5 = b.this.mOuterStatusListener;
            if (iVideoOuterStatusListener5 != null) {
                iVideoOuterStatusListener5.onVideoProgressUpdate(0);
            }
            b.this.mVideoState = 8;
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadComplete(long id5) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long l3) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadProgress(long id5, long downSize) {
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long id5, long position) {
        }
    }
}
