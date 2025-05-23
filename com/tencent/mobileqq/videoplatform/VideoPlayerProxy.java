package com.tencent.mobileqq.videoplatform;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.TextureView;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.PlayerState;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.a;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes20.dex */
public class VideoPlayerProxy implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, SDKInitListener, ISuperPlayer.OnCaptureImageListener, ISPlayerVideoView.IVideoViewCallBack {
    static IPatchRedirector $redirector_;
    private static a sVideoPlaySDKInit;
    private long bufferEndtime;
    private long bufferStartTime;
    private VideoPlayerInnerCallback mCallback;
    private Context mContext;
    public long mID;
    private PlayProgressChecker mPlayPgsChecker;
    private ISuperPlayer mPlayer;
    private QAReport mReporter;
    boolean mScaleFullScreen;
    public AtomicInteger mState;
    private List<TPOptionalParam> mTPOptionalParamList;
    private VideoPlayParam mVideoParam;
    private ISPlayerVideoView mVideoView;

    public VideoPlayerProxy(Context context, long j3, VideoPlayParam videoPlayParam, VideoPlayerInnerCallback videoPlayerInnerCallback, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Long.valueOf(j3), videoPlayParam, videoPlayerInnerCallback, Boolean.valueOf(z16));
            return;
        }
        this.mState = new AtomicInteger(0);
        this.mContext = context;
        this.mID = j3;
        this.mVideoParam = videoPlayParam;
        this.mCallback = videoPlayerInnerCallback;
        this.mScaleFullScreen = z16;
        this.mVideoView = createVideoView();
        init();
    }

    private ISPlayerVideoView createVideoView() {
        return SuperPlayerFactory.createPlayerVideoView(this.mContext.getApplicationContext());
    }

    private void doOnAllDownloadFinish() {
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "doOnAllDownloadFinish.");
        }
        VideoPlayerInnerCallback videoPlayerInnerCallback = this.mCallback;
        if (videoPlayerInnerCallback != null) {
            videoPlayerInnerCallback.onDownloadComplete(this.mID);
        }
    }

    private void doOnBufferEnd() {
        QAReport qAReport;
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "doOnBufferEnd.");
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.bufferEndtime = currentTimeMillis;
        long j3 = this.bufferStartTime;
        if (j3 > 0 && currentTimeMillis > 0 && (qAReport = this.mReporter) != null) {
            qAReport.totalBufferingDuration += currentTimeMillis - j3;
        }
        this.bufferStartTime = 0L;
        this.bufferEndtime = 0L;
        synchronized (this) {
            if (this.mState.get() == 6) {
                return;
            }
            changeState(4);
        }
    }

    private void doOnBufferStart() {
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "doOnBufferStart.");
        }
        QAReport qAReport = this.mReporter;
        if (qAReport != null) {
            qAReport.bufferCount++;
        }
        this.bufferStartTime = System.currentTimeMillis();
        synchronized (this) {
            if (this.mState.get() == 6) {
                return;
            }
            changeState(5);
        }
    }

    private void doOnCurLoopEnd() {
        ISuperPlayer iSuperPlayer;
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "doOnCurLoopEnd.");
        }
        VideoPlayerInnerCallback videoPlayerInnerCallback = this.mCallback;
        if (videoPlayerInnerCallback != null && (iSuperPlayer = this.mPlayer) != null) {
            videoPlayerInnerCallback.onLoopBack(this.mID, iSuperPlayer.getCurrentPositionMs());
        }
    }

    private void doOnDownProgressUpdate(Object obj) {
        if (obj instanceof TPDownloadProgressInfo) {
            long downloadBytes = ((TPDownloadProgressInfo) obj).getDownloadBytes();
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "doOnDownProgressUpdate, curDownSize =  " + downloadBytes);
            }
            VideoPlayerInnerCallback videoPlayerInnerCallback = this.mCallback;
            if (videoPlayerInnerCallback != null) {
                videoPlayerInnerCallback.onDownloadProgress(this.mID, downloadBytes);
            }
        }
    }

    private void doOnFirstFrameRendered() {
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "doOnFirstFrameRendered.");
        }
        QAReport qAReport = this.mReporter;
        if (qAReport != null && qAReport.firstRenderTime == 0) {
            qAReport.firstRenderTime = System.currentTimeMillis();
        }
        VideoPlayerInnerCallback videoPlayerInnerCallback = this.mCallback;
        if (videoPlayerInnerCallback != null) {
            videoPlayerInnerCallback.onFirstFrameRendered(this.mID);
        }
    }

    private void doOnVideoDecoderType(long j3) {
        QAReport qAReport;
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "doOnVideoDecoderType.");
        }
        if (j3 == 102 && (qAReport = this.mReporter) != null) {
            qAReport.lastTryDecoderMode = 102;
            qAReport.isMediaCodec = 1;
        }
    }

    private void doPlay() {
        if (this.mPlayer != null) {
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "play, mPlayer != null ");
            }
            if (this.mState.get() == 6) {
                if (LogUtil.isColorLevel()) {
                    LogUtil.d(getLogTag(), 2, "play, mPlayer.isPausing() =  " + this.mPlayer.isPausing());
                }
                startPlayer();
                if (LogUtil.isColorLevel()) {
                    LogUtil.d(getLogTag(), 2, "play, startPlayer() ");
                    return;
                }
                return;
            }
            openPlayer();
            return;
        }
        createMediaPlayer();
        openPlayer();
    }

    public static a getVideoPlaySDKInit() {
        return sVideoPlaySDKInit;
    }

    private synchronized void init() {
        if (sVideoPlaySDKInit != null) {
            changeState(1);
            sVideoPlaySDKInit.a(this);
        } else if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
            changeState(1);
            VideoPlaySDKManager.getInstance().initSDKAsync(this.mContext, this);
        }
    }

    private void logPlayDoNothing() {
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "play, do nothing.");
        }
        if (this.mPlayer != null && LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "play, mPlayer.isPlaying() = " + this.mPlayer.isPlaying());
        }
    }

    private synchronized void openPlayer() {
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "openPlayer ");
        }
        QAReport qAReport = new QAReport();
        this.mReporter = qAReport;
        qAReport.videoPlayParam = this.mVideoParam;
        qAReport.openPlayerTime = System.currentTimeMillis();
        if (this.mPlayer != null && this.mVideoParam != null) {
            changeState(3);
            VideoPlayParam videoPlayParam = this.mVideoParam;
            long j3 = videoPlayParam.mMaxPlayTimeMs;
            if (j3 > 0) {
                this.mPlayer.setLoopback(videoPlayParam.mIsLoop, 0L, j3);
            } else {
                this.mPlayer.setLoopback(videoPlayParam.mIsLoop);
            }
            this.mPlayer.setOutputMute(this.mVideoParam.mIsMute);
            this.mPlayer.setPlayerOptionalParamList(this.mTPOptionalParamList);
            VideoPlayParam videoPlayParam2 = this.mVideoParam;
            if (videoPlayParam2.mIsLocal) {
                String str = videoPlayParam2.mVideoPath;
                if (str != null) {
                    this.mPlayer.openMediaPlayer(this.mContext, SuperPlayerFactory.createVideoInfoForUrl(str, videoPlayParam2.mVideoFormat, videoPlayParam2.mFileID), this.mVideoParam.mStartPlayPosMs);
                    this.mVideoParam.mLastPlayPosMs = 0L;
                    LogUtil.d(getLogTag(), 2, "openPlayer, videoPath = " + this.mVideoParam.mVideoPath);
                }
            } else {
                String[] strArr = videoPlayParam2.mUrls;
                if (strArr != null) {
                    SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(strArr, videoPlayParam2.mVideoFormat, videoPlayParam2.mFileID, videoPlayParam2.mSavePath);
                    createVideoInfoForUrl.setCookies(this.mVideoParam.mCookies);
                    this.mPlayer.openMediaPlayer(this.mContext, createVideoInfoForUrl, this.mVideoParam.mStartPlayPosMs);
                    this.mVideoParam.mLastPlayPosMs = 0L;
                    if (LogUtil.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        for (String str2 : this.mVideoParam.mUrls) {
                            sb5.append(str2);
                            sb5.append(" ; ");
                        }
                        LogUtil.d(getLogTag(), 2, "openPlayer, mVideoParam.mSavePath = " + this.mVideoParam.mSavePath + " urls = " + sb5.toString());
                    }
                }
            }
        }
    }

    public static void setVideoPlaySDKInit(a aVar) {
        sVideoPlaySDKInit = aVar;
    }

    private void startCheckPlayProgress() {
        VideoPlayParam videoPlayParam = this.mVideoParam;
        if (videoPlayParam != null && videoPlayParam.mNeedPlayProgress) {
            PlayProgressChecker playProgressChecker = this.mPlayPgsChecker;
            if (playProgressChecker == null) {
                this.mPlayPgsChecker = new PlayProgressChecker(this.mID, this.mPlayer, this.mCallback);
            } else {
                playProgressChecker.mPlayer = this.mPlayer;
            }
            this.mPlayPgsChecker.start();
        }
    }

    private synchronized void startPlayer() {
        ThreadUtil.postOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.videoplatform.VideoPlayerProxy.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoPlayerProxy.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    synchronized (VideoPlayerProxy.this.mReporter) {
                        if (VideoPlayerProxy.this.mReporter != null && VideoPlayerProxy.this.mPlayer != null) {
                            VideoPlayerProxy.this.mReporter.hasStarted = true;
                            MediaInfo mediaInfo = VideoPlayerProxy.this.mPlayer.getMediaInfo();
                            if (mediaInfo != null) {
                                VideoPlayerProxy.this.mReporter.videoDuration = mediaInfo.getDurationMs();
                                VideoPlayerProxy.this.mReporter.videoWidth = mediaInfo.getVideoWidth();
                                VideoPlayerProxy.this.mReporter.videoHeight = mediaInfo.getVideoHeight();
                                VideoPlayerProxy.this.mReporter.videoBitRate = mediaInfo.getVideoBitRate();
                                VideoPlayerProxy.this.mReporter.videoCodec = mediaInfo.getVideoCodec();
                                VideoPlayerProxy.this.mReporter.videoProfile = mediaInfo.getVideoProfile();
                                VideoPlayerProxy.this.mReporter.audioBitRate = mediaInfo.getAudioBitRate();
                                VideoPlayerProxy.this.mReporter.audioChannels = mediaInfo.getChannels();
                                VideoPlayerProxy.this.mReporter.audioCodec = mediaInfo.getAudioCodec();
                                VideoPlayerProxy.this.mReporter.audioProfile = mediaInfo.getAudioProfile();
                                VideoPlayerProxy.this.mReporter.audioSampleRate = mediaInfo.getSampleRate();
                                VideoPlayerProxy.this.mReporter.containerFormat = mediaInfo.getContainerFormat();
                            }
                            VideoPlayerProxy.this.mReporter.startPlayTime = System.currentTimeMillis();
                        }
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.start();
            changeState(4);
            startCheckPlayProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCheckPlayProgress() {
        PlayProgressChecker playProgressChecker = this.mPlayPgsChecker;
        if (playProgressChecker != null) {
            playProgressChecker.stop();
        }
    }

    public void addSubtitleSource(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, str2, str3);
        } else {
            ThreadUtil.postOnSubThread(new Runnable(str, str3) { // from class: com.tencent.mobileqq.videoplatform.VideoPlayerProxy.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$name;
                final /* synthetic */ String val$url;

                {
                    this.val$url = str;
                    this.val$name = str3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, VideoPlayerProxy.this, str, str3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    synchronized (this) {
                        if (VideoPlayerProxy.this.mPlayer != null && VideoPlayerProxy.this.mPlayer.isPlaying()) {
                            if (LogUtil.isColorLevel()) {
                                LogUtil.d(VideoPlayerProxy.this.getLogTag(), 2, "mMediaPlayer.addSubtitleSource()");
                            }
                            VideoPlayerProxy.this.mPlayer.addSubtitleSource(this.val$url, this.val$name);
                            TPTrackInfo[] trackInfo = VideoPlayerProxy.this.mPlayer.getTrackInfo();
                            if (trackInfo == null) {
                                return;
                            }
                            for (int i3 = 0; i3 < trackInfo.length; i3++) {
                                LogUtil.d(VideoPlayerProxy.this.getLogTag(), 1, "mMediaPlayer.addSubtitleSource(), tpTrackInfo[i].getName() = " + trackInfo[i3].getName());
                                if (trackInfo[i3].getName().equalsIgnoreCase(this.val$name)) {
                                    VideoPlayerProxy.this.mPlayer.selectTrack(i3, 100L);
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public void captureCurFrame(long j3, int i3, int i16) {
        View renderView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mPlayer == null) {
            LogUtil.e(getLogTag(), 1, "captuerCurFrame failed, mPlayer is null.");
            VideoPlayerInnerCallback videoPlayerInnerCallback = this.mCallback;
            if (videoPlayerInnerCallback != null) {
                videoPlayerInnerCallback.onCapFrame(this.mID, false, 0, 0, null);
                return;
            }
            return;
        }
        ISPlayerVideoView iSPlayerVideoView = this.mVideoView;
        if (iSPlayerVideoView == null) {
            renderView = null;
        } else {
            renderView = iSPlayerVideoView.getRenderView();
        }
        if (!(renderView instanceof TextureView)) {
            LogUtil.e(getLogTag(), 1, "captuerCurFrame failed, renderView is not TextureView.");
            VideoPlayerInnerCallback videoPlayerInnerCallback2 = this.mCallback;
            if (videoPlayerInnerCallback2 != null) {
                videoPlayerInnerCallback2.onCapFrame(this.mID, false, 0, 0, null);
                return;
            }
            return;
        }
        ThreadUtil.postOnSubThread(new Runnable(renderView) { // from class: com.tencent.mobileqq.videoplatform.VideoPlayerProxy.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View val$renderView;

            {
                this.val$renderView = renderView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoPlayerProxy.this, (Object) renderView);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TextureView textureView = (TextureView) this.val$renderView;
                if (!textureView.isAvailable()) {
                    LogUtil.e(VideoPlayerProxy.this.getLogTag(), 1, "captuerCurFrame failed, current surface is not available.");
                    if (VideoPlayerProxy.this.mCallback != null) {
                        VideoPlayerProxy.this.mCallback.onCapFrame(VideoPlayerProxy.this.mID, false, 0, 0, null);
                        return;
                    }
                    return;
                }
                try {
                    Bitmap bitmap = textureView.getBitmap();
                    if (VideoPlayerProxy.this.mCallback != null) {
                        VideoPlayerProxy.this.mCallback.onCapFrame(VideoPlayerProxy.this.mID, true, bitmap.getWidth(), bitmap.getHeight(), bitmap);
                    }
                } catch (Throwable th5) {
                    LogUtil.e(VideoPlayerProxy.this.getLogTag(), 1, "captuerCurFrame failed! ", th5);
                    if (VideoPlayerProxy.this.mCallback != null) {
                        VideoPlayerProxy.this.mCallback.onCapFrame(VideoPlayerProxy.this.mID, false, 0, 0, null);
                    }
                }
            }
        });
    }

    protected void changeState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        if (i3 != this.mState.get()) {
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "changeState() , newState = " + PlayerState.getStateStr(i3));
            }
            this.mState.set(i3);
            ThreadUtil.postOnUIThread(new Runnable(i3) { // from class: com.tencent.mobileqq.videoplatform.VideoPlayerProxy.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f312680d;

                {
                    this.f312680d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoPlayerProxy.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (VideoPlayerProxy.this.mCallback != null) {
                        VideoPlayerProxy.this.mCallback.onStateChange(VideoPlayerProxy.this.mID, this.f312680d);
                    }
                }
            });
        }
    }

    public synchronized void createMediaPlayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (this.mPlayer != null) {
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "createMediaPlayer");
        }
        if (this.mVideoParam == null) {
            LogUtil.e(getLogTag(), 1, "createMediaPlayer, mVideoParam is null.");
            return;
        }
        changeState(3);
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(this.mContext.getApplicationContext(), this.mVideoParam.mSceneId, this.mVideoView);
        this.mPlayer = createMediaPlayer;
        if (this.mScaleFullScreen) {
            createMediaPlayer.setXYaxis(2);
        } else {
            createMediaPlayer.setXYaxis(0);
        }
        this.mPlayer.setOnVideoPreparedListener(this);
        this.mPlayer.setOnCompletionListener(this);
        this.mPlayer.setOnSeekCompleteListener(this);
        this.mPlayer.setOnInfoListener(this);
        this.mPlayer.setOnErrorListener(this);
        this.mPlayer.setOnCaptureImageListener(this);
        ISPlayerVideoView iSPlayerVideoView = this.mVideoView;
        if (iSPlayerVideoView != null) {
            iSPlayerVideoView.addViewCallBack(this);
        }
    }

    public long getCurPostionMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        try {
            ISuperPlayer iSuperPlayer = this.mPlayer;
            if (iSuperPlayer == null || !iSuperPlayer.isPlaying()) {
                return -1L;
            }
            return this.mPlayer.getCurrentPositionMs();
        } catch (Throwable th5) {
            LogUtil.e(getLogTag(), 1, "getCurPlayingPos() error .", th5);
            return -1L;
        }
    }

    protected long getLogId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Long) iPatchRedirector.redirect((short) 31, (Object) this)).longValue();
        }
        return this.mID;
    }

    protected String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return "[VideoPlatForm]VideoPlayerProxy[" + getLogId() + "][state:" + PlayerState.getStateStr(this.mState.get()) + "]";
    }

    public long getVideoDurationMs() {
        long j3;
        VideoPlayParam videoPlayParam;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            j3 = iSuperPlayer.getDurationMs();
        } else {
            j3 = 0;
        }
        if (j3 <= 0 && (videoPlayParam = this.mVideoParam) != null) {
            return videoPlayParam.mVideoFileTimeMs;
        }
        return j3;
    }

    public VideoPlayParam getVideoParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (VideoPlayParam) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mVideoParam;
    }

    public View getVideoView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (View) this.mVideoView;
    }

    public boolean isMute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isOutputMute();
        }
        return false;
    }

    public boolean isPlaying() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            return iSuperPlayer.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageFailed(ISuperPlayer iSuperPlayer, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, iSuperPlayer, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.e(getLogTag(), 2, "onCaptureImageSucceed() , id = " + i3 + " , errCode = " + i16);
        }
        VideoPlayerInnerCallback videoPlayerInnerCallback = this.mCallback;
        if (videoPlayerInnerCallback != null) {
            videoPlayerInnerCallback.onCapFrame(i3, false, 0, 0, null);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
    public void onCaptureImageSucceed(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, iSuperPlayer, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bitmap);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "onCaptureImageSucceed(), id = " + i3 + " , width = " + i16 + " , height = " + i17);
        }
        VideoPlayerInnerCallback videoPlayerInnerCallback = this.mCallback;
        if (videoPlayerInnerCallback != null) {
            videoPlayerInnerCallback.onCapFrame(i3, true, i16, i17, bitmap);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
    public void onCompletion(ISuperPlayer iSuperPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) iSuperPlayer);
            return;
        }
        synchronized (this) {
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "onCompletion.");
            }
            changeState(8);
            QAReport qAReport = this.mReporter;
            if (qAReport != null) {
                qAReport.doReport(true);
            }
            release(false, false);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, iSuperPlayer, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str)).booleanValue();
        }
        synchronized (this) {
            String logTag = getLogTag();
            LogUtil.d(logTag, 1, "onError, " + ("errorModule=" + i3 + "errorType = " + i16 + " , errorCode = " + i17 + " ,extraInfo = " + str));
            changeState(7);
            VideoPlayerInnerCallback videoPlayerInnerCallback = this.mCallback;
            if (videoPlayerInnerCallback != null) {
                videoPlayerInnerCallback.onPlayError(this.mID, i3, i16, i17, str);
            }
            QAReport qAReport = this.mReporter;
            if (qAReport != null) {
                qAReport.errCode = i17;
                qAReport.errType = i16;
                qAReport.errModule = i3;
                qAReport.errDetailInfo = str;
            }
            release(false, true);
        }
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, this, iSuperPlayer, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), obj)).booleanValue();
        }
        if (i3 != 105) {
            if (i3 != 108) {
                if (i3 != 115) {
                    if (i3 != 201) {
                        if (i3 != 207) {
                            if (i3 != 112) {
                                if (i3 == 113) {
                                    doOnBufferEnd();
                                }
                            } else {
                                doOnBufferStart();
                            }
                        } else {
                            doOnDownProgressUpdate(obj);
                        }
                    } else {
                        doOnAllDownloadFinish();
                    }
                } else {
                    doOnVideoDecoderType(j3);
                }
            } else {
                doOnCurLoopEnd();
            }
        } else {
            doOnFirstFrameRendered();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
    public void onSDKInited(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
            return;
        }
        synchronized (this) {
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "onSDKInited, isSucceed =  " + z16);
            }
            ThreadUtil.postOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.videoplatform.VideoPlayerProxy.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoPlayerProxy.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        VideoPlayerProxy.this.changeState(2);
                    }
                }
            });
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) iSuperPlayer);
        } else if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "onSeekComplete");
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceChanged(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, obj);
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceCreated(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, obj);
        }
    }

    @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
    public void onSurfaceDestroy(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, obj);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.e(getLogTag(), 2, "onSurfaceDestroy() ");
        }
        VideoPlayerInnerCallback videoPlayerInnerCallback = this.mCallback;
        if (videoPlayerInnerCallback != null) {
            videoPlayerInnerCallback.onSurfaceDestroy(this.mID);
        }
        release(false, false);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) iSuperPlayer);
            return;
        }
        if (LogUtil.isColorLevel()) {
            String logTag = getLogTag();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onVideoPrepared, mPlayer == null ? ");
            if (this.mPlayer == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            LogUtil.d(logTag, 2, sb5.toString());
        }
        synchronized (this) {
            if (this.mState.get() == 5 || this.mState.get() == 3) {
                if (LogUtil.isColorLevel()) {
                    LogUtil.d(getLogTag(), 2, "onVideoPrepared, startPlayer.");
                }
                startPlayer();
            }
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "pause");
        }
        synchronized (this) {
            if (this.mState.get() == 4 || this.mState.get() == 5 || this.mState.get() == 3) {
                changeState(6);
            }
        }
        ThreadUtil.postOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.videoplatform.VideoPlayerProxy.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VideoPlayerProxy.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (this) {
                    if (VideoPlayerProxy.this.mPlayer != null && VideoPlayerProxy.this.mPlayer.isPlaying()) {
                        if (LogUtil.isColorLevel()) {
                            LogUtil.d(VideoPlayerProxy.this.getLogTag(), 2, "mMediaPlayer.pause()");
                        }
                        VideoPlayerProxy.this.mPlayer.pause();
                        VideoPlayerProxy.this.stopCheckPlayProgress();
                    }
                }
            }
        });
    }

    public void pauseDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.pauseDownload();
        }
    }

    public synchronized void play() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "play");
        }
        if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
            VideoPlaySDKManager.getInstance().addSDKInstalledListener(this);
            if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "play, sdk not ready, return.");
            }
        } else {
            if (this.mState.get() != 4 && this.mState.get() != 5 && this.mState.get() != 3) {
                doPlay();
            }
            logPlayDoNothing();
        }
    }

    public void release(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "releasePlayer");
        }
        synchronized (this) {
            if (this.mState.get() == 9) {
                if (LogUtil.isColorLevel()) {
                    LogUtil.d(getLogTag(), 2, "has released, do nothing.");
                }
                return;
            }
            changeState(9);
            stopCheckPlayProgress();
            QAReport qAReport = this.mReporter;
            if (qAReport != null) {
                qAReport.doReport(!z17);
            }
            ISPlayerVideoView iSPlayerVideoView = this.mVideoView;
            if (iSPlayerVideoView != null) {
                iSPlayerVideoView.removeViewCallBack(this);
            }
            ThreadUtil.postOnSubThread(new Runnable(z16) { // from class: com.tencent.mobileqq.videoplatform.VideoPlayerProxy.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$recordPos;

                {
                    this.val$recordPos = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, VideoPlayerProxy.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    synchronized (VideoPlayerProxy.this) {
                        if (LogUtil.isColorLevel()) {
                            LogUtil.d(VideoPlayerProxy.this.getLogTag(), 2, "release,run");
                        }
                        if (VideoPlayerProxy.this.mPlayer != null) {
                            if (this.val$recordPos) {
                                long currentPositionMs = (int) VideoPlayerProxy.this.mPlayer.getCurrentPositionMs();
                                if (LogUtil.isColorLevel()) {
                                    LogUtil.d(VideoPlayerProxy.this.getLogTag(), 2, "releasePlayer,record play pos = " + currentPositionMs);
                                }
                                if (VideoPlayerProxy.this.mVideoParam != null) {
                                    VideoPlayerProxy.this.mVideoParam.mLastPlayPosMs = currentPositionMs;
                                }
                            }
                            if (VideoPlayerProxy.this.mState.get() == 9) {
                                if (LogUtil.isColorLevel()) {
                                    LogUtil.d(VideoPlayerProxy.this.getLogTag(), 2, "release,mPlayer.stop() & mPlayer.release()");
                                }
                                VideoPlayerProxy.this.mPlayer.stop();
                                VideoPlayerProxy.this.mPlayer.release();
                                VideoPlayerProxy.this.mPlayer = null;
                            }
                        }
                    }
                }
            });
            VideoPlaySDKManager.getInstance().removeSDKInstalledListener(this);
        }
    }

    public void resumeDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.resumeDownload();
        }
    }

    public void seekTo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.seekTo(i3);
        }
    }

    public void setID(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
            return;
        }
        this.mID = j3;
        PlayProgressChecker playProgressChecker = this.mPlayPgsChecker;
        if (playProgressChecker != null) {
            playProgressChecker.setId(j3);
        }
    }

    public void setMute(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
            return;
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOutputMute(z16);
        }
    }

    public void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener onSubtitleDataListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) onSubtitleDataListener);
            return;
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.setOnSubtitleDataListener(onSubtitleDataListener);
        }
    }

    public void setPlayerOptionalParamList(List<TPOptionalParam> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) list);
        } else {
            this.mTPOptionalParamList = list;
        }
    }

    public void setVideoParam(VideoPlayParam videoPlayParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) videoPlayParam);
        } else {
            this.mVideoParam = videoPlayParam;
        }
    }

    public void seekTo(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        ISuperPlayer iSuperPlayer = this.mPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.seekTo(i3, i16);
        }
    }
}
