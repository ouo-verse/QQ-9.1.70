package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import r92.a;

/* loaded from: classes33.dex */
public class VideoPlayerView implements IVideoPlayerView {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int EXO_PLAYER = 1;
    public static final int LOCAL_PLAYER = 2;
    public static final int NOWN_PLAYER = 0;
    private static final String TAG = "VideoPlayerView";
    private ImageView doodleView;
    protected ImageView ivCover;
    protected QQAppInterface mApp;
    protected Context mContext;
    private String mCurrentPath;
    private long mEndPlayTime;
    protected Handler mHandler;
    long mLastPos;
    com.tencent.mobileqq.nearby.now.view.e mReultListener;
    private RelativeLayout mRootView;
    IVideoPlayerView.a mShowLoadingWhenLoadingCoverListener;
    private long mStartPlayTime;
    private boolean mStartPlayed;
    private VideoData mVideoData;
    protected IVideoInfoListener mVideoInfoListener;
    INowShortVideoProtoManager nowShortVideoProtoManager;
    private final int PROGRESS_MSG = 2025;
    private final int UPDATE_COVER = 2026;
    protected boolean isPlaying = false;
    public int mPlayerType = 0;
    private long mInterval = -1;
    private boolean isLocalFile = true;
    private boolean hasError = false;
    private int retryCount = 0;
    private boolean mPaused = false;
    long mFileSize = 0;
    long mOffset = 0;
    public String mLastUrl = "";
    protected r92.a mPlayer = createVideoView();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 2025) {
                r92.a aVar = VideoPlayerView.this.mPlayer;
                if (aVar != null) {
                    int progress = aVar.getProgress();
                    ((IVideoPlayerView.b) VideoPlayerView.this.mVideoInfoListener).onPlayProgress(progress);
                    if (QLog.isColorLevel()) {
                        QLog.d(VideoPlayerView.TAG, 2, "PROGRESS_MSG :" + progress);
                    }
                }
                VideoPlayerView.this.mHandler.sendEmptyMessageDelayed(2025, 100L);
                return;
            }
            if (i3 != 2026) {
                return;
            }
            ImageView imageView = VideoPlayerView.this.ivCover;
            if (imageView != null && imageView.getParent() != null && ((ViewGroup) VideoPlayerView.this.ivCover.getParent()).getChildAt(0) != VideoPlayerView.this.ivCover) {
                if (QLog.isColorLevel()) {
                    QLog.i(VideoPlayerView.TAG, 2, "UPDATE_COVER  mPlayer.getCurrentPosition()=" + VideoPlayerView.this.mPlayer.getCurrentPosition());
                }
                ((ViewGroup) VideoPlayerView.this.ivCover.getParent()).removeView(VideoPlayerView.this.ivCover);
                VideoPlayerView.this.mRootView.addView(VideoPlayerView.this.ivCover, 0, new RelativeLayout.LayoutParams(-1, -1));
                VideoPlayerView.this.mRootView.requestLayout();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(VideoPlayerView.TAG, 2, "UPDATE_COVER  2do nothing()=");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class b implements a.InterfaceC11126a {
        b() {
        }

        @Override // r92.a.InterfaceC11126a
        public void a(r92.a aVar) {
            IVideoInfoListener iVideoInfoListener = VideoPlayerView.this.mVideoInfoListener;
            if (iVideoInfoListener != null) {
                ((IVideoPlayerView.b) iVideoInfoListener).onComplete();
            }
            VideoPlayerView.this.mHandler.removeMessages(2025);
            q92.c.i(VideoPlayerView.this.mVideoData.f252695e, VideoPlayerView.this.isVideoCached() ? 1 : 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class c implements a.d {
        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class d implements a.b {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class e implements a.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoData f252854a;

        e(VideoData videoData) {
            this.f252854a = videoData;
        }

        @Override // r92.a.c
        public boolean a(r92.a aVar, int i3, int i16, int i17, String str, Object obj) {
            com.tencent.mobileqq.nearby.now.view.e eVar = VideoPlayerView.this.mReultListener;
            if (eVar == null) {
                return true;
            }
            eVar.a(this.f252854a.f252695e, i3, i16, "use sdk play error");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class f implements a.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoData f252856a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f252857b;

        f(VideoData videoData, boolean z16) {
            this.f252856a = videoData;
            this.f252857b = z16;
        }

        @Override // r92.a.e
        public void a(r92.a aVar) {
            String str;
            IVideoInfoListener iVideoInfoListener = VideoPlayerView.this.mVideoInfoListener;
            if (iVideoInfoListener != null) {
                ((IVideoPlayerView.b) iVideoInfoListener).onStartPlaying();
            }
            Context context = VideoPlayerView.this.mContext;
            if ((context instanceof BaseActivity) && ((BaseActivity) context).isResume()) {
                if (QLog.isColorLevel()) {
                    QLog.i(VideoPlayerView.TAG, 2, "player truly start! app=" + VideoPlayerView.this.mApp);
                }
                VideoPlayerView.this.nowShortVideoProtoManager.reportPlay(this.f252856a.f252695e, null);
                com.tencent.mobileqq.nearby.now.view.e eVar = VideoPlayerView.this.mReultListener;
                if (eVar != null) {
                    eVar.a(this.f252856a.f252695e, 100, 0, "");
                }
                ((u92.c) VideoPlayerView.this.mApp.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.f252856a.f252695e);
                INowVideoReporter opType = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opName("video_view").opType("video");
                if (this.f252856a.I) {
                    str = "0";
                } else {
                    str = "1";
                }
                opType.d4(str).genderInd1().d2(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getRePlayCount() + "").reportByVideo(VideoPlayerView.this.mApp);
                VideoPlayerView.this.mPlayer.start();
                if (!this.f252857b) {
                    long fileSize = VideoPlayerView.this.getFileSize();
                    q92.c.l(this.f252856a.f252695e, 1, String.valueOf(VideoPlayerView.this.getDownloadOffset() / fileSize), String.valueOf(fileSize), String.valueOf(VideoPlayerView.this.getDownloadOffset()), String.valueOf(q92.c.a()), true);
                }
            }
            VideoPlayerView.this.mHandler.removeMessages(2025);
            VideoPlayerView.this.mHandler.sendEmptyMessageDelayed(2025, 100L);
            VideoPlayerView.this.mHandler.sendEmptyMessageDelayed(2026, 300L);
        }
    }

    public VideoPlayerView(Context context, QQAppInterface qQAppInterface) {
        this.mContext = context;
        this.mApp = qQAppInterface;
        this.nowShortVideoProtoManager = ((INowShortVideoProtoManager) QRoute.api(INowShortVideoProtoManager.class)).init(this.mApp);
    }

    public static String getFileName(String str) {
        return MD5.toMD5(str);
    }

    public static String setFileCompleted(File file) {
        if (file.exists()) {
            String absolutePath = file.getParentFile().getAbsolutePath();
            String name = file.getName();
            if (name.endsWith(".tmp")) {
                name = name.substring(0, name.length() - 4);
            }
            String str = absolutePath + "/" + name;
            file.renameTo(new File(str));
            return str;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public r92.a createVideoView() {
        return new com.tencent.mobileqq.nearby.now.view.f(this.mContext);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public long getCurrentPosition() {
        return this.mPlayer.getCurrentPosition();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public long getDownloadOffset() {
        if (this.mVideoData == null) {
            return 0L;
        }
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_PATH;
        sb5.append(str);
        sb5.append(AppConstants.PATH_NOW_VIDEO);
        sb5.append("vid_");
        sb5.append(getFileName(this.mVideoData.f252697f));
        sb5.append(".mp4");
        if (new File(VFSAssistantUtils.getSDKPrivatePath(sb5.toString())).exists()) {
            return r0.length();
        }
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(str + AppConstants.PATH_NOW_VIDEO + "vid_" + getFileName(this.mVideoData.f252697f) + ".mp4.tmp"));
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public long getDuration() {
        return this.mPlayer.getDuration();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public long getFileSize() {
        return this.mFileSize;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public int getPlayerType() {
        return this.mPlayerType;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public String getmLastUrl() {
        return this.mLastUrl;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public int getmPlayerType() {
        return this.mPlayerType;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void initWidgetView(RelativeLayout relativeLayout) {
        this.mRootView = relativeLayout;
        this.ivCover = (ImageView) relativeLayout.findViewById(R.id.duw);
        this.doodleView = (ImageView) this.mRootView.findViewById(R.id.bo_);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(2025);
            this.mHandler.removeMessages(2026);
        }
        this.mHandler = new a(this.mContext.getMainLooper());
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public boolean isPlaying() {
        return this.mPlayer.isPlaying();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public boolean isVideoCached() {
        if (this.mVideoData == null) {
            return false;
        }
        if (new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + AppConstants.PATH_NOW_VIDEO + "vid_" + getFileName(this.mVideoData.f252697f) + ".mp4")).exists()) {
            return true;
        }
        long j3 = this.mOffset;
        return j3 >= this.mFileSize && j3 != 0;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void pause() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "pause");
        }
        this.mPlayer.pause();
        this.mPaused = true;
        this.mLastPos = getCurrentPosition();
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void play(RelativeLayout relativeLayout, VideoData videoData, Object obj) {
        this.mVideoData = videoData;
        initWidgetView(relativeLayout);
        play(videoData);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public boolean restart() {
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).setRePlayCount(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getRePlayCount() + 1);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "restart");
        }
        q92.c.k(this.mVideoData.f252695e, isVideoCached() ? 1 : 2, "0", "0");
        q92.c.c(2);
        q92.c.f();
        this.mPlayer.restart();
        return true;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void resume() {
        if (this.mPaused) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "resume");
            }
            this.mPlayer.start();
            this.mPlayer.seekTo(this.mLastPos);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "!not paused no resume!");
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void seekTo(long j3) {
        this.mPlayer.seekTo(j3);
        this.mStartPlayed = true;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void setCoverVisibility(int i3) {
        this.ivCover.setVisibility(i3);
        this.doodleView.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void setOnVideoInfoListener(IVideoInfoListener iVideoInfoListener) {
        this.mVideoInfoListener = iVideoInfoListener;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void setProgressCallbackInterval(long j3) {
        this.mInterval = j3;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void setShowLoadingWhenLoadingCoverListener(IVideoPlayerView.a aVar) {
        this.mShowLoadingWhenLoadingCoverListener = aVar;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void setVideoPlayViewVisibility(int i3) {
        r92.a aVar = this.mPlayer;
        if (aVar == null || aVar.getView() == null) {
            return;
        }
        this.mPlayer.getView().setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void setmLastUrl(String str) {
        this.mLastUrl = str;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void setmPlayerType(int i3) {
        this.mPlayerType = i3;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void stopPlayback(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "stopPlayback, clearSurface=" + z16);
        }
        IVideoInfoListener iVideoInfoListener = this.mVideoInfoListener;
        if (iVideoInfoListener != null) {
            ((IVideoPlayerView.b) iVideoInfoListener).onDoingStopPlayback();
        }
        if (this.mStartPlayed) {
            this.mEndPlayTime = System.currentTimeMillis();
            this.mPlayer.getDuration();
            this.mStartPlayed = false;
        }
        this.mPlayer.e();
        this.mPaused = false;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void suspend() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "stop");
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(2025);
            this.mHandler.removeMessages(2026);
        }
        if (this.mStartPlayed) {
            this.mStartPlayed = false;
        }
        r92.a aVar = this.mPlayer;
        if (aVar != null && aVar.getView() != null && this.mPlayer.getView().getParent() != null) {
            ((ViewGroup) this.mPlayer.getView().getParent()).removeView(this.mPlayer.getView());
        }
        this.mPlayer.e();
        this.mReultListener = null;
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void play(VideoData videoData) {
        String str = videoData.f252697f;
        this.mFileSize = 0L;
        this.mOffset = 0L;
        boolean isVideoCached = isVideoCached();
        this.mLastUrl = str;
        this.mCurrentPath = str;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "play(String videoPath)! path is: " + str + "play stack is: " + Log.getStackTraceString(new Throwable()));
        }
        r92.a aVar = this.mPlayer;
        if (aVar != null) {
            aVar.e();
        }
        r92.a aVar2 = this.mPlayer;
        if (aVar2 != null && aVar2.getView() != null && this.mPlayer.getView().getParent() != null) {
            ((ViewGroup) this.mPlayer.getView().getParent()).removeView(this.mPlayer.getView());
        }
        r92.a createVideoView = createVideoView();
        this.mPlayer = createVideoView;
        if (createVideoView == null) {
            QLog.e(TAG, 1, "mPlayer == null!");
            return;
        }
        if (createVideoView != null && createVideoView.getView() != null && this.mPlayer.getView().getParent() != null) {
            ((ViewGroup) this.mPlayer.getView().getParent()).removeView(this.mPlayer.getView());
        }
        r92.a aVar3 = this.mPlayer;
        if (aVar3 != null) {
            this.mRootView.addView(aVar3.getView(), 0, new RelativeLayout.LayoutParams(-1, -1));
        }
        this.mRootView.requestLayout();
        this.mPlayerType = 1;
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).setRePlayCount(0);
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).setPlayTimeBegin(System.currentTimeMillis());
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).setFeedId(videoData.f252695e);
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).setAnchorUin(String.valueOf(videoData.D));
        IVideoInfoListener iVideoInfoListener = this.mVideoInfoListener;
        if (iVideoInfoListener != null) {
            ((IVideoPlayerView.b) iVideoInfoListener).onDoingStartPlayback();
        }
        try {
            this.ivCover.setVisibility(0);
            this.doodleView.setVisibility(0);
            this.mPlayer.d(new b());
            this.mPlayer.f(new c());
            this.mPlayer.c(new d());
            this.mPlayer.b(new e(videoData));
            String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + AppConstants.PATH_NOW_VIDEO + "vid_" + getFileName(str) + ".mp4");
            File file = new File(sDKPrivatePath);
            if (file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "file.exists ! use local file");
                }
                long length = file.length();
                this.mFileSize = length;
                this.mOffset = length;
                this.mPlayer.a("vid_" + getFileName(str), sDKPrivatePath, str, videoData.V);
            } else {
                File file2 = new File(sDKPrivatePath + ".tmp");
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "use remote file,tmp's exsit=" + file2.exists());
                }
                this.mPlayer.a("vid_" + getFileName(str), sDKPrivatePath + ".tmp", str, videoData.V);
            }
            this.mPlayer.g(new f(videoData, isVideoCached));
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "player start!");
            }
            this.mPaused = false;
        } catch (Exception e16) {
            Log.e(TAG, e16.toString());
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.view.IVideoPlayerView
    public void hideDownloadProgress() {
    }
}
