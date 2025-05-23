package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.miniapp.util.TextureRender.VideoTextureRenderer;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VideoEmbeddedWidgetClient extends StateMachine implements IExtendedEmbeddedWidgetClient, Handler.Callback, StateMachine.OnStateChangeListener {
    private static final int DEFAULT_INTERVAL_TIME = 250;
    private static final int EVENT_INIT_SUCC = 1;
    private static final int EVENT_MEDIAPLAYER_PREPARED = 5;
    private static final int EVENT_VIDEOSURFACE_SUCC = 3;
    private static final int EVENT_X5SURFACE_SUCC = 2;
    private static final int MEDIA_INFO_SUPER_BUFFERING_END = 113;
    private static final int MEDIA_INFO_SUPER_BUFFERING_START = 112;
    private static final int MEDIA_INFO_SUPER_FIRST_VIDEO_FRAME_RENDERED = 105;
    private static final int MEDIA_INFO_SUPER_LOOP_END = 108;
    private static final int MEDIA_INFO_SUPER_LOOP_START = 107;
    public static final int MSG_IS_HLS = 1003;
    public static final int MSG_TIME_UPDATE = 1001;
    public static final int MSG_VIDEO_SURFACE_CREATED = 1002;
    private static final String TAG = "miniapp-embedded";
    private static final float[] rateSupportArray = {0.5f, 0.8f, 1.0f, 1.25f, 1.5f, 2.0f};
    private IJsService callBackWebview;
    private int curPageWebviewId;
    private String licenseUrl;
    private Map<String, String> mAttributes;
    private IMediaPlayer mMediaPlayer;
    private IMediaPlayerUtil mMediaPlayerUtil;
    private IMiniAppContext mMiniAppContext;
    private String mTagName;
    private IEmbeddedWidget mWidget;
    private Surface mediaPlaySurface;
    private String provisionUrl;
    private VideoTextureRenderer renderer;
    private SurfaceTexture videoTexture;
    private final Handler handler = new Handler(Looper.getMainLooper(), this);
    private boolean hasPlayClicked = false;
    private boolean hasPrepared = false;
    private boolean hasCompleted = false;
    private boolean hasStoped = false;
    private Surface mSurface = null;
    private boolean isPaused = false;
    private boolean pauseByOpenNative = false;
    private boolean pauseByNavigate = false;
    private boolean isOnPageBackGrond = false;
    private int width = -1;
    private int height = -1;
    private int videoWidth = -1;
    private int videoHeight = -1;
    private boolean needEvent = true;
    private boolean hide = false;
    private String objectFit = HVideoConstants.ResizeType.RESIZE_CONTAIN;
    private boolean autoplay = false;
    private boolean muted = false;
    private boolean loop = false;
    private int initialTime = 0;
    private boolean autoPauseIfNavigate = true;
    private boolean autoPauseIfOpenNative = true;
    private boolean isDrm = false;
    private String filePath = "";
    private String cueFilePath = "";
    private volatile Boolean isHls = null;
    private String data = "";
    private int viewId = -1;
    private StateMachine.State stateInitial = new StateMachine.State(1);
    private StateMachine.State stateInited = new StateMachine.State(2);
    private StateMachine.State stateX5SurfaceCreated = new StateMachine.State(3);
    private StateMachine.State stateVideoSurfaceCreated = new StateMachine.State(4);
    private StateMachine.State stateCanPlay = new StateMachine.State(5);

    public VideoEmbeddedWidgetClient(IMiniAppContext iMiniAppContext, String str, Map<String, String> map, IEmbeddedWidget iEmbeddedWidget) {
        this.mTagName = str;
        this.mAttributes = map;
        this.mWidget = iEmbeddedWidget;
        this.mMiniAppContext = iMiniAppContext;
        initStateConfig();
        initMediaPlayer();
        addStateChangeListener(this);
        sendEvent(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluateSubscribeJS(String str, String str2, int i3) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(str, str2, i3));
        }
        IJsService iJsService = this.callBackWebview;
        if (iJsService != null) {
            iJsService.evaluateSubscribeJS(str, str2, this.curPageWebviewId);
        }
    }

    private IMediaPlayer.OnBufferingUpdateListener getOnBufferingUpdateListener() {
        return new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.5
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i3) {
                if (VideoEmbeddedWidgetClient.this.callBackWebview != null && !VideoEmbeddedWidgetClient.this.isPaused) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("data", VideoEmbeddedWidgetClient.this.data);
                        jSONObject.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, i3);
                        jSONObject.put("videoPlayerId", VideoEmbeddedWidgetClient.this.viewId);
                        VideoEmbeddedWidgetClient.this.evaluateSubscribeJS(EmbeddedVideoJsPlugin.VIDEO_EVENT_PROGRESS, jSONObject.toString(), VideoEmbeddedWidgetClient.this.curPageWebviewId);
                        QMLog.d(VideoEmbeddedWidgetClient.TAG, "evaluateSubcribeJS onXWebVideoProgress = " + jSONObject.toString());
                    } catch (Throwable th5) {
                        QMLog.e(VideoEmbeddedWidgetClient.TAG, "VIDEO_EVENT_PROGRESS  error.", th5);
                    }
                }
            }
        };
    }

    private IMediaPlayer.OnCompletionListener getOnCompletionListener() {
        return new IMediaPlayer.OnCompletionListener() { // from class: com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.8
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                VideoEmbeddedWidgetClient.this.hasCompleted = true;
                VideoEmbeddedWidgetClient.this.isPaused = true;
                if (VideoEmbeddedWidgetClient.this.callBackWebview != null) {
                    if (VideoEmbeddedWidgetClient.this.handler != null) {
                        VideoEmbeddedWidgetClient.this.handler.removeMessages(1001);
                    }
                    if (VideoEmbeddedWidgetClient.this.isHls == null || !VideoEmbeddedWidgetClient.this.isHls.booleanValue()) {
                        VideoEmbeddedWidgetClient.this.sendTimeUpdateToJs();
                    }
                    VideoEmbeddedWidgetClient.this.sendEndToJs();
                }
            }
        };
    }

    private IMediaPlayer.OnInfoListener getOnInfoListener() {
        return new IMediaPlayer.OnInfoListener() { // from class: com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.6
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i3, int i16) {
                if (QMLog.isColorLevel() && !FastClickUtils.isFastDoubleClick(VideoEmbeddedWidgetClient.TAG, 500L)) {
                    QMLog.d(VideoEmbeddedWidgetClient.TAG, "onInfo what : " + i3 + "; extra : " + i16 + "; isHls : " + VideoEmbeddedWidgetClient.this.isHls);
                }
                int superMsg = VideoEmbeddedWidgetClient.this.getSuperMsg(i3);
                if (superMsg != 3) {
                    if (superMsg != 107) {
                        if (superMsg != 108) {
                            if (superMsg != 701) {
                                if (superMsg == 702 && VideoEmbeddedWidgetClient.this.callBackWebview != null) {
                                    QMLog.d(VideoEmbeddedWidgetClient.TAG, "superPlayer buffering end.");
                                    VideoEmbeddedWidgetClient.this.sendBufferUpdateToJs();
                                    if (VideoEmbeddedWidgetClient.this.mMediaPlayer == null || !VideoEmbeddedWidgetClient.this.mMediaPlayer.isSuperPlayer() || !VideoEmbeddedWidgetClient.this.isPaused) {
                                        VideoEmbeddedWidgetClient videoEmbeddedWidgetClient = VideoEmbeddedWidgetClient.this;
                                        videoEmbeddedWidgetClient.sendPlayToJs(videoEmbeddedWidgetClient.viewId);
                                    }
                                }
                            } else if (VideoEmbeddedWidgetClient.this.callBackWebview != null) {
                                try {
                                    QMLog.d(VideoEmbeddedWidgetClient.TAG, "superPlayer buffering start.");
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("data", VideoEmbeddedWidgetClient.this.data);
                                    jSONObject.put("videoPlayerId", VideoEmbeddedWidgetClient.this.viewId);
                                    VideoEmbeddedWidgetClient.this.evaluateSubscribeJS(EmbeddedVideoJsPlugin.VIDEO_EVENT_WAITING, jSONObject.toString(), VideoEmbeddedWidgetClient.this.curPageWebviewId);
                                    QMLog.d(VideoEmbeddedWidgetClient.TAG, "evaluateSubcribeJS onXWebVideoWaiting = " + jSONObject.toString());
                                } catch (Throwable th5) {
                                    QMLog.e(VideoEmbeddedWidgetClient.TAG, "VIDEO_EVENT_WAITING  error.", th5);
                                }
                            }
                        } else if (VideoEmbeddedWidgetClient.this.callBackWebview != null) {
                            QMLog.d(VideoEmbeddedWidgetClient.TAG, "superPlayer loop end.");
                        }
                    } else if (VideoEmbeddedWidgetClient.this.callBackWebview != null) {
                        QMLog.d(VideoEmbeddedWidgetClient.TAG, "superPlayer loop start.");
                        VideoEmbeddedWidgetClient.this.isPaused = false;
                        VideoEmbeddedWidgetClient.this.sendTimingMsg(250L);
                    }
                } else if (VideoEmbeddedWidgetClient.this.callBackWebview != null) {
                    VideoEmbeddedWidgetClient.this.sendLoadedMetaDataToJs();
                }
                return false;
            }
        };
    }

    private IMediaPlayer.OnPreparedListener getOnPreparedListener() {
        return new IMediaPlayer.OnPreparedListener() { // from class: com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.7
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                QMLog.d(VideoEmbeddedWidgetClient.TAG, "onPrepared");
                VideoEmbeddedWidgetClient.this.hasPrepared = true;
                VideoEmbeddedWidgetClient.this.sendEvent(5);
                if (VideoEmbeddedWidgetClient.this.mMediaPlayer != null) {
                    VideoEmbeddedWidgetClient.this.sendTimeUpdateToJs();
                }
            }
        };
    }

    private IMediaPlayer.OnVideoSizeChangedListener getOnVideoSizeChangedListener() {
        return new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i3, int i16) {
                QMLog.i(VideoEmbeddedWidgetClient.TAG, "onVideoSizeChanged : w - " + i3 + "; h - " + i16);
                VideoEmbeddedWidgetClient.this.videoWidth = i3;
                VideoEmbeddedWidgetClient.this.videoHeight = i16;
                if (VideoEmbeddedWidgetClient.this.renderer != null) {
                    VideoEmbeddedWidgetClient.this.renderer.setVideoSize(i3, i16, VideoEmbeddedWidgetClient.this.objectFit);
                } else {
                    QMLog.e(VideoEmbeddedWidgetClient.TAG, "setOnVideoSizeChangedListener renderer is null");
                }
            }
        };
    }

    private String getOskPlayerUrl() {
        if (!this.filePath.startsWith("http") && !this.filePath.startsWith("https")) {
            return ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath);
        }
        return this.mMediaPlayerUtil.getUrl(((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSuperMsg(int i3) {
        if (i3 == 105) {
            return 3;
        }
        if (i3 == 112) {
            return 701;
        }
        if (i3 == 113) {
            return 702;
        }
        return i3;
    }

    private void handleIsHLS() {
        QMLog.d(TAG, "MSG_IS_HLS");
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.9
            @Override // java.lang.Runnable
            public void run() {
                String str;
                boolean z16;
                QMLog.d(VideoEmbeddedWidgetClient.TAG, "VideoManager probeContentFlag getSubThreadHandler start. " + VideoEmbeddedWidgetClient.this.cueFilePath);
                long currentTimeMillis = System.currentTimeMillis();
                if (VideoEmbeddedWidgetClient.this.mMediaPlayer != null && !VideoEmbeddedWidgetClient.this.mMediaPlayer.isSuperPlayer()) {
                    IMediaPlayerUtil iMediaPlayerUtil = VideoEmbeddedWidgetClient.this.mMediaPlayerUtil;
                    if (VideoEmbeddedWidgetClient.this.mMiniAppContext != null) {
                        str = ((MiniAppFileManager) VideoEmbeddedWidgetClient.this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(VideoEmbeddedWidgetClient.this.cueFilePath);
                    } else {
                        str = "";
                    }
                    int contentFlag = VideoEmbeddedWidgetClient.this.mMediaPlayerUtil.getContentFlag(iMediaPlayerUtil.getUrl(str));
                    QMLog.d(VideoEmbeddedWidgetClient.TAG, "VideoManager probeContentFlag const : " + (System.currentTimeMillis() - currentTimeMillis));
                    VideoEmbeddedWidgetClient videoEmbeddedWidgetClient = VideoEmbeddedWidgetClient.this;
                    if (contentFlag == 5) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    videoEmbeddedWidgetClient.isHls = Boolean.valueOf(z16);
                    QMLog.d(VideoEmbeddedWidgetClient.TAG, "VideoManager probeContentFlag isHls : " + VideoEmbeddedWidgetClient.this.isHls + "; flag : " + contentFlag);
                }
                if (VideoEmbeddedWidgetClient.this.callBackWebview != null) {
                    VideoEmbeddedWidgetClient.this.sendLoadedMetaDataToJs();
                }
            }
        });
    }

    private void handlePauseEvent(int i3) {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null && iMediaPlayer.isPlaying()) {
            this.isPaused = true;
            QMLog.e(TAG, "pause isPaused true");
            try {
                VideoTextureRenderer videoTextureRenderer = this.renderer;
                if (videoTextureRenderer != null) {
                    videoTextureRenderer.pauseRender();
                }
                this.mMediaPlayer.pause();
            } catch (Throwable th5) {
                QMLog.e(TAG, "pause error.", th5);
            }
            sendPauseToJs(i3);
        }
    }

    private void handlePlayBackRateEvent(JSONObject jSONObject) {
        if (this.mMediaPlayer != null) {
            try {
                String optString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    if (jSONArray.length() == 1) {
                        float parseFloat = Float.parseFloat(jSONArray.optString(0, "1.0"));
                        if (Arrays.binarySearch(rateSupportArray, parseFloat) >= 0) {
                            this.mMediaPlayer.setRate(parseFloat);
                        } else {
                            QMLog.e(TAG, "playbackRate error." + parseFloat);
                        }
                    }
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "playbackRate error.", th5);
            }
        }
    }

    private void handlePlayEvent(int i3) {
        IMediaPlayer iMediaPlayer;
        String oskPlayerUrl;
        this.isPaused = false;
        if ((this.hasCompleted || this.hasStoped) && (iMediaPlayer = this.mMediaPlayer) != null) {
            iMediaPlayer.reset();
            this.hasPrepared = false;
            this.hasCompleted = false;
            this.hasStoped = false;
            try {
                if (this.mMediaPlayer.isSuperPlayer()) {
                    oskPlayerUrl = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath);
                } else {
                    oskPlayerUrl = getOskPlayerUrl();
                }
                QMLog.d(TAG, "handleOperateXWebVideo playUrl : " + oskPlayerUrl);
                if (!this.isDrm) {
                    this.mMediaPlayer.setDataSource(oskPlayerUrl);
                } else {
                    this.mMediaPlayer.setDrmDataSource(oskPlayerUrl, this.provisionUrl, this.licenseUrl);
                }
                this.handler.sendEmptyMessage(1003);
                setCurrState(this.stateVideoSurfaceCreated);
                this.mMediaPlayer.prepareAsync();
                this.mMediaPlayer.setSurface(this.mediaPlaySurface);
            } catch (Throwable th5) {
                QMLog.e(TAG, "handleOperateXWebVideo  play error.", th5);
            }
        }
        if (this.hasPrepared) {
            if (this.mMediaPlayer != null) {
                try {
                    VideoTextureRenderer videoTextureRenderer = this.renderer;
                    if (videoTextureRenderer != null) {
                        videoTextureRenderer.resumeRender();
                    }
                    if (!this.isOnPageBackGrond) {
                        this.isPaused = false;
                        this.mMediaPlayer.start();
                        sendTimingMsg(250L);
                    } else {
                        QMLog.e(TAG, "isOnPageBackGrond when mediaPlayerStart - 1");
                    }
                } catch (Throwable th6) {
                    QMLog.e(TAG, "start error.", th6);
                }
                sendPlayToJs(i3);
                return;
            }
            return;
        }
        this.hasPlayClicked = true;
        sendPlayToJs(i3);
    }

    private void handleSeekEvent(JSONObject jSONObject) {
        if (this.mMediaPlayer != null) {
            try {
                String optString = jSONObject.optString("data");
                if (!TextUtils.isEmpty(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    if (jSONArray.length() == 1) {
                        this.mMediaPlayer.seekTo((long) (jSONArray.getDouble(0) * 1000.0d));
                    }
                }
            } catch (Throwable th5) {
                QMLog.e(TAG, "seek error.", th5);
            }
        }
    }

    private void handleStopEvent() {
        if (this.mMediaPlayer != null) {
            this.isPaused = true;
            this.hasStoped = true;
            QMLog.d(TAG, "pause isPaused true");
            VideoTextureRenderer videoTextureRenderer = this.renderer;
            if (videoTextureRenderer != null) {
                videoTextureRenderer.pauseRender();
            }
            this.mMediaPlayer.stop();
        }
    }

    private void handleSurfaceCreated() {
        VideoTextureRenderer videoTextureRenderer = this.renderer;
        if (videoTextureRenderer != null) {
            SurfaceTexture videoTexture = videoTextureRenderer.getVideoTexture();
            this.videoTexture = videoTexture;
            if (videoTexture != null) {
                sendEvent(3);
                return;
            } else {
                QMLog.e(TAG, "MSG_VIDEO_SURFACE_CREATED videoTexture is null!");
                return;
            }
        }
        QMLog.e(TAG, "MSG_VIDEO_SURFACE_CREATED renderer is null!");
    }

    private void handleUpdate() {
        if (this.isHls != null && this.isHls.booleanValue()) {
            QMLog.d(TAG, "hls, do not send onXWebVideoTimeUpdate.");
            return;
        }
        if (this.isPaused) {
            QMLog.d(TAG, "handleUpdate video is Paused\uff01");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mMediaPlayer != null && this.callBackWebview != null && !this.hasCompleted) {
            sendTimeUpdateToJs();
        }
        sendTimingMsg((currentTimeMillis + 250) - System.currentTimeMillis());
    }

    private void initMediaPlayer() {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        this.mMediaPlayer = channelProxy.getMediaPlayer();
        this.mMediaPlayerUtil = channelProxy.getMediaPlayerUtil();
        this.mMediaPlayer.setOnCompletionListener(getOnCompletionListener());
        this.mMediaPlayer.setOnPreparedListener(getOnPreparedListener());
        this.mMediaPlayer.setOnInfoListener(getOnInfoListener());
        this.mMediaPlayer.setOnBufferingUpdateListener(getOnBufferingUpdateListener());
        this.mMediaPlayer.setOnVideoSizeChangedListener(getOnVideoSizeChangedListener());
        this.mMediaPlayer.setOnLoopStartListener(new IMediaPlayer.OnLoopStartListener() { // from class: com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnLoopStartListener
            public void onLoopStart(IMediaPlayer iMediaPlayer) {
                VideoEmbeddedWidgetClient.this.isPaused = false;
                VideoEmbeddedWidgetClient.this.sendTimingMsg(250L);
            }
        });
        this.mMediaPlayer.setOnSeekCompleteListener(new IMediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                QMLog.i(VideoEmbeddedWidgetClient.TAG, "onSeekComplete ");
            }
        });
        this.mMediaPlayer.setOnErrorListener(new IMediaPlayer.OnErrorListener() { // from class: com.tencent.qqmini.miniapp.plugin.VideoEmbeddedWidgetClient.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnErrorListener
            public boolean onError(IMediaPlayer iMediaPlayer, int i3, int i16) {
                QMLog.i(VideoEmbeddedWidgetClient.TAG, "onError : what - " + i3 + "; extra - " + i16);
                return false;
            }
        });
    }

    private void initStateConfig() {
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateInitial).next(this.stateInited).registEvent(1));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateInited).next(this.stateX5SurfaceCreated).registEvent(2));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateX5SurfaceCreated).next(this.stateVideoSurfaceCreated).registEvent(3));
        addStateTransfer(new StateMachine.StateTransfer().from(this.stateVideoSurfaceCreated).next(this.stateCanPlay).registEvent(5));
        setCurrState(this.stateInitial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBufferUpdateToJs() {
        if (this.callBackWebview != null && !this.isPaused) {
            try {
                int bufferPercent = this.mMediaPlayer.getBufferPercent();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", this.data);
                jSONObject.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, bufferPercent);
                jSONObject.put("videoPlayerId", this.viewId);
                QMLog.d(TAG, "superPlayer buffer percent is " + bufferPercent);
                evaluateSubscribeJS(EmbeddedVideoJsPlugin.VIDEO_EVENT_PROGRESS, jSONObject.toString(), this.curPageWebviewId);
                QMLog.d(TAG, "evaluateSubcribeJS onXWebVideoProgress = " + jSONObject.toString());
            } catch (Throwable th5) {
                QMLog.e(TAG, "VIDEO_EVENT_PROGRESS  error.", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEndToJs() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.data);
            jSONObject.put("videoPlayerId", this.viewId);
            evaluateSubscribeJS(EmbeddedVideoJsPlugin.VIDEO_EVENT_END, jSONObject.toString(), this.curPageWebviewId);
            QMLog.d(TAG, "evaluateSubcribeJS onXWebVideoEnded = " + jSONObject.toString());
        } catch (Throwable th5) {
            QMLog.e(TAG, "VIDEO_EVENT_END  error.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLoadedMetaDataToJs() {
        long j3;
        long j16;
        try {
            long j17 = 0;
            if (this.hasPrepared) {
                j3 = this.mMediaPlayer.getDuration();
            } else {
                j3 = 0;
            }
            if (j3 > 0) {
                j16 = j3 / 1000;
            } else {
                j16 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.data);
            jSONObject.put("videoPlayerId", this.viewId);
            if (this.isHls == null || !this.isHls.booleanValue()) {
                j17 = j16;
            }
            jSONObject.put("duration", j17);
            jSONObject.put("width", this.mMediaPlayer.getVideoWidth() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
            jSONObject.put("height", this.mMediaPlayer.getVideoHeight() / DisplayUtil.getDensity(AppLoaderFactory.g().getContext()));
            evaluateSubscribeJS(EmbeddedVideoJsPlugin.VIDEO_EVENT_LOADED_METADATA, jSONObject.toString(), this.curPageWebviewId);
            QMLog.d(TAG, "evaluateSubcribeJS onXWebVideoLoadedMetaData = " + jSONObject.toString());
        } catch (Throwable th5) {
            QMLog.e(TAG, "VIDEO_EVENT_LOADED_METADATA error.", th5);
        }
    }

    private void sendPauseToJs(int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.data);
            jSONObject.put("videoPlayerId", i3);
            jSONObject.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, System.currentTimeMillis());
            evaluateSubscribeJS(EmbeddedVideoJsPlugin.VIDEO_EVENT_PAUSE, jSONObject.toString(), this.curPageWebviewId);
            QMLog.d(TAG, "evaluateSubcribeJS onXWebVideoPause = " + jSONObject.toString());
        } catch (Throwable th5) {
            QMLog.e(TAG, "VIDEO_EVENT_PAUSE error.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPlayToJs(int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.data);
            jSONObject.put("videoPlayerId", i3);
            jSONObject.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, System.currentTimeMillis());
            evaluateSubscribeJS(EmbeddedVideoJsPlugin.VIDEO_EVENT_PLAY, jSONObject.toString(), this.curPageWebviewId);
            QMLog.d(TAG, "evaluateSubcribeJS onXWebVideoPlay = " + jSONObject.toString());
        } catch (Throwable th5) {
            QMLog.e(TAG, "VIDEO_EVENT_PLAY error.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTimeUpdateToJs() {
        long j3;
        long j16;
        if (this.isPaused) {
            QMLog.d(TAG, "sendTimeUpdateToJs video is Paused\uff01");
            return;
        }
        try {
            long j17 = 0;
            if (this.hasPrepared) {
                j3 = this.mMediaPlayer.getDuration();
            } else {
                j3 = 0;
            }
            if (j3 > 0) {
                j16 = j3 / 1000;
            } else {
                j16 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.data);
            jSONObject.put("position", this.mMediaPlayer.getCurrentPosition() / 1000.0d);
            if (this.isHls == null || !this.isHls.booleanValue()) {
                j17 = j16;
            }
            jSONObject.put("duration", j17);
            jSONObject.put("videoPlayerId", this.viewId);
            evaluateSubscribeJS(EmbeddedVideoJsPlugin.VIDEO_EVENT_TIME_UPDATE, jSONObject.toString(), this.curPageWebviewId);
        } catch (Throwable th5) {
            QMLog.e(TAG, "VIDEO_EVENT_TIME_UPDATE error.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTimingMsg(long j3) {
        Message obtain = Message.obtain();
        obtain.what = 1001;
        this.handler.sendMessageDelayed(obtain, j3);
    }

    private void updateMediaPlayer() {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            if (this.muted) {
                iMediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                iMediaPlayer.setVolume(1.0f, 1.0f);
            }
            this.mMediaPlayer.setLooping(this.loop);
            int i3 = this.initialTime;
            if (i3 > 0) {
                long j3 = i3 * 1000;
                QMLog.d(TAG, "before seekTo " + j3);
                this.mMediaPlayer.seekTo(j3);
                QMLog.d(TAG, "after seekTo " + j3);
            }
        }
    }

    private void updateRenderer() {
        int i3;
        int i16;
        VideoTextureRenderer videoTextureRenderer = this.renderer;
        if (videoTextureRenderer != null) {
            int i17 = this.width;
            if (i17 >= 0 && (i16 = this.height) >= 0) {
                videoTextureRenderer.setSurfaceSize(i17, i16);
            }
            int i18 = this.videoWidth;
            if (i18 >= 0 && (i3 = this.videoHeight) >= 0) {
                this.renderer.setVideoSize(i18, i3, this.objectFit);
            }
            VideoTextureRenderer videoTextureRenderer2 = this.renderer;
            if (videoTextureRenderer2 != null) {
                videoTextureRenderer2.resumeRender();
            }
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public IMiniAppContext getMiniAppContext() {
        return this.mMiniAppContext;
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public int getViewId() {
        return this.viewId;
    }

    public void handleInsertXWebVideo(JSONObject jSONObject, IJsService iJsService) {
        this.callBackWebview = iJsService;
        if (iJsService instanceof BrandPageWebview) {
            this.curPageWebviewId = ((BrandPageWebview) iJsService).getWebViewId();
        } else if (iJsService instanceof MiniWebView) {
            this.curPageWebviewId = ((MiniWebView) iJsService).J();
        } else {
            QMLog.e(TAG, "cant get webviewId from " + iJsService);
        }
        if (jSONObject != null) {
            QMLog.d(TAG, "handleInsertXWebVideo : " + jSONObject.toString());
            if (jSONObject.has("position")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("position");
                this.width = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("width", -1)) + 0.5f);
                this.height = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("height", -1)) + 0.5f);
            }
            this.viewId = jSONObject.optInt("viewId", -1);
            this.needEvent = jSONObject.optBoolean("needEvent", true);
            this.hide = jSONObject.optBoolean("hide", false);
            this.objectFit = jSONObject.optString("objectFit", HVideoConstants.ResizeType.RESIZE_CONTAIN);
            this.autoplay = jSONObject.optBoolean("autoplay", false);
            this.muted = jSONObject.optBoolean("muted", false);
            this.loop = jSONObject.optBoolean("loop", false);
            this.initialTime = jSONObject.optInt("initialTime", 0);
            this.autoPauseIfNavigate = jSONObject.optBoolean("autoPauseIfNavigate", true);
            this.autoPauseIfOpenNative = jSONObject.optBoolean("autoPauseIfOpenNative", true);
            this.data = jSONObject.optString("data");
        }
        VideoTextureRenderer videoTextureRenderer = this.renderer;
        if (videoTextureRenderer != null) {
            videoTextureRenderer.setSurfaceSize(this.width, this.height);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                handleUpdate();
                return false;
            case 1002:
                handleSurfaceCreated();
                return false;
            case 1003:
                handleIsHLS();
                return false;
            default:
                return false;
        }
    }

    public void handleOperateXWebVideo(JSONObject jSONObject) {
        QMLog.d(TAG, "handleOperateXWebVideo : " + jSONObject.toString());
        int optInt = jSONObject.optInt("viewId", -1);
        if (optInt == this.viewId && jSONObject.has("type")) {
            String optString = jSONObject.optString("type");
            if ("play".equals(optString)) {
                handlePlayEvent(optInt);
                return;
            }
            if ("pause".equals(optString)) {
                handlePauseEvent(optInt);
                return;
            }
            if (InnerAudioPlugin.AUDIO_OPERATE_SEEK.equals(optString)) {
                handleSeekEvent(jSONObject);
                return;
            }
            if ("playbackRate".equals(optString) && !TextUtils.isEmpty(this.data)) {
                handlePlayBackRateEvent(jSONObject);
            } else if ("stop".equals(optString)) {
                handleStopEvent();
            }
        }
    }

    public void handleUpdateXWebVideo(JSONObject jSONObject) {
        String oskPlayerUrl;
        if (jSONObject != null) {
            QMLog.d(TAG, "handleUpdateXWebVideo : " + jSONObject.toString());
            if (jSONObject.optInt("viewId", -1) == this.viewId) {
                this.needEvent = jSONObject.optBoolean("needEvent", this.needEvent);
                this.hide = jSONObject.optBoolean("hide", this.hide);
                this.objectFit = jSONObject.optString("objectFit", this.objectFit);
                this.autoplay = jSONObject.optBoolean("autoplay", this.autoplay);
                this.muted = jSONObject.optBoolean("muted", this.muted);
                this.loop = jSONObject.optBoolean("loop", this.loop);
                this.initialTime = jSONObject.optInt("initialTime", this.initialTime);
                this.autoPauseIfNavigate = jSONObject.optBoolean("autoPauseIfNavigate", this.autoPauseIfNavigate);
                this.autoPauseIfOpenNative = jSONObject.optBoolean("autoPauseIfOpenNative", this.autoPauseIfOpenNative);
                this.provisionUrl = jSONObject.optString("provisionUrl");
                this.licenseUrl = jSONObject.optString("licenseUrl");
                this.isDrm = jSONObject.optBoolean("isDrm", false);
                if (jSONObject.has("filePath")) {
                    this.filePath = jSONObject.optString("filePath");
                }
                try {
                    if (!this.cueFilePath.equals(this.filePath)) {
                        String str = this.filePath;
                        this.cueFilePath = str;
                        if (!TextUtils.isEmpty(str)) {
                            setCurrState(this.stateVideoSurfaceCreated);
                        }
                        this.isPaused = false;
                        this.hasPrepared = false;
                        this.hasCompleted = false;
                        if (this.mMediaPlayer.isPlaying()) {
                            this.mMediaPlayer.stop();
                        }
                        this.mMediaPlayer.reset();
                        if (this.mMediaPlayer.isSuperPlayer()) {
                            oskPlayerUrl = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(this.filePath);
                        } else {
                            oskPlayerUrl = getOskPlayerUrl();
                        }
                        QMLog.d(TAG, "handleUpdateXWebVideo playUrl : " + oskPlayerUrl);
                        if (!this.isDrm) {
                            this.mMediaPlayer.setDataSource(oskPlayerUrl);
                        } else {
                            this.mMediaPlayer.setDrmDataSource(oskPlayerUrl, this.provisionUrl, this.licenseUrl);
                        }
                        this.handler.sendEmptyMessage(1003);
                        this.mMediaPlayer.prepareAsync();
                    }
                } catch (Throwable th5) {
                    QMLog.e(TAG, "handleUpdateXWebVideo  play error.", th5);
                }
                if (jSONObject.has("position")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("position");
                    this.width = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("width", -1)) + 0.5f);
                    int density = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("height", -1)) + 0.5f);
                    this.height = density;
                    VideoTextureRenderer videoTextureRenderer = this.renderer;
                    if (videoTextureRenderer != null) {
                        videoTextureRenderer.setSurfaceSize(this.width, density);
                        this.renderer.setVideoSize(this.videoWidth, this.videoHeight, this.objectFit);
                    } else {
                        QMLog.e(TAG, "handleUpdateXWebVideo renderer is null!");
                    }
                }
                IMediaPlayer iMediaPlayer = this.mMediaPlayer;
                if (iMediaPlayer != null) {
                    if (this.muted) {
                        iMediaPlayer.setVolume(0.0f, 0.0f);
                    } else {
                        iMediaPlayer.setVolume(1.0f, 1.0f);
                    }
                    this.mMediaPlayer.setLooping(this.loop);
                }
            }
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeDestroy() {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.nativeDestroy " + this);
        this.isPaused = true;
        synchronized (this) {
            VideoTextureRenderer videoTextureRenderer = this.renderer;
            if (videoTextureRenderer != null) {
                videoTextureRenderer.pauseRender();
                this.renderer.onPause();
                this.renderer = null;
            }
            SurfaceTexture surfaceTexture = this.videoTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.videoTexture = null;
            }
            Surface surface = this.mediaPlaySurface;
            if (surface != null) {
                surface.release();
                this.mediaPlaySurface = null;
            }
            IMediaPlayer iMediaPlayer = this.mMediaPlayer;
            if (iMediaPlayer != null) {
                iMediaPlayer.release();
                this.mMediaPlayer = null;
            }
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativePause() {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.nativePause " + this);
        this.isOnPageBackGrond = true;
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null && iMediaPlayer.isPlaying() && !this.isPaused && this.autoPauseIfOpenNative) {
            this.pauseByOpenNative = true;
            try {
                VideoTextureRenderer videoTextureRenderer = this.renderer;
                if (videoTextureRenderer != null) {
                    videoTextureRenderer.pauseRender();
                }
                this.mMediaPlayer.pause();
                this.isPaused = true;
                sendPauseToJs(this.viewId);
            } catch (Throwable th5) {
                QMLog.e(TAG, "nativePause mMediaPlayer.pause() error.", th5);
            }
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeResume() {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.nativeResume " + this);
        this.isOnPageBackGrond = false;
        if (this.mMediaPlayer != null && this.pauseByOpenNative) {
            this.pauseByOpenNative = false;
            try {
                VideoTextureRenderer videoTextureRenderer = this.renderer;
                if (videoTextureRenderer != null) {
                    videoTextureRenderer.resumeRender();
                }
                QMLog.i(TAG, "VideoEmbeddedWidgetClient.webviewResume isPaused " + this.isPaused);
                if (!this.isOnPageBackGrond) {
                    this.isPaused = false;
                    this.mMediaPlayer.start();
                    sendPauseToJs(this.viewId);
                    sendTimingMsg(250L);
                    return;
                }
                QMLog.e(TAG, "isOnPageBackGrond when mediaPlayerStart - 3");
            } catch (Throwable th5) {
                QMLog.e(TAG, "nativeResume mMediaPlayer.start() error.", th5);
            }
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onActive() {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.onActive");
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDeactive() {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.onDeactive");
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDestroy() {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.onDestroy");
        this.isPaused = true;
        synchronized (this) {
            VideoTextureRenderer videoTextureRenderer = this.renderer;
            if (videoTextureRenderer != null) {
                videoTextureRenderer.pauseRender();
                this.renderer.onPause();
                this.renderer = null;
            }
            SurfaceTexture surfaceTexture = this.videoTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.videoTexture = null;
            }
            Surface surface = this.mediaPlaySurface;
            if (surface != null) {
                surface.release();
                this.mediaPlaySurface = null;
            }
            IMediaPlayer iMediaPlayer = this.mMediaPlayer;
            if (iMediaPlayer != null) {
                iMediaPlayer.release();
                this.mMediaPlayer = null;
            }
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRectChanged(Rect rect) {
        if (QMLog.isColorLevel() && !FastClickUtils.isFastDoubleClick(TAG, 500L)) {
            QMLog.i(TAG, "VideoEmbeddedWidgetClient.onRectChanged, rect:" + rect.toString() + "\uff1b size : " + (rect.right - rect.left) + "," + (rect.bottom - rect.top));
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRequestRedraw() {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.onRequestRedraw");
    }

    @Override // com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener
    public void onStateChanged() {
        QMLog.i(TAG, "onStateChanged : " + getCurrState() + "; videoTexture : " + this.videoTexture);
        if (!this.isOnPageBackGrond && getCurrState() == this.stateCanPlay && this.videoTexture != null && this.mMediaPlayer != null) {
            QMLog.d(TAG, "stateCanPlay!!!!");
            Surface surface = new Surface(this.videoTexture);
            this.mediaPlaySurface = surface;
            this.mMediaPlayer.setSurface(surface);
            updateRenderer();
            if (this.autoplay || this.hasPlayClicked) {
                try {
                    if (!this.isOnPageBackGrond) {
                        this.isPaused = false;
                        this.mMediaPlayer.start();
                        sendTimingMsg(250L);
                        updateMediaPlayer();
                    } else {
                        QMLog.e(TAG, "isOnPageBackGrond when mediaPlayerStart - 4");
                    }
                } catch (Throwable th5) {
                    QMLog.e(TAG, "mMediaPlayer.start() error.", th5);
                }
                if (this.callBackWebview != null) {
                    if (this.autoplay || !this.hasPlayClicked) {
                        sendPlayToJs(this.viewId);
                    }
                    if (this.mMediaPlayer != null) {
                        sendTimeUpdateToJs();
                    }
                }
            }
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onSurfaceCreated(Surface surface) {
        Boolean bool;
        QMLog.d(TAG, "onSurfaceCreated: " + surface);
        if (surface != null && surface.isValid()) {
            this.mSurface = surface;
            this.renderer = new VideoTextureRenderer(AppLoaderFactory.g().getContext(), this.mSurface, this.width, this.height, this.handler);
            sendEvent(2);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onSurfaceCreated isValid() : ");
        if (surface != null) {
            bool = Boolean.valueOf(surface.isValid());
        } else {
            bool = null;
        }
        sb5.append(bool);
        QMLog.e(TAG, sb5.toString());
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onSurfaceDestroyed(Surface surface) {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.onSurfaceDestroyed");
        onDestroy();
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public boolean onTouchEvent(MotionEvent motionEvent) {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.onTouchEvent, rect:" + motionEvent.toString());
        return false;
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onVisibilityChanged(boolean z16) {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.onVisibilityChanged \uff1a " + z16);
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewDestroy() {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.webViewDestroy " + this);
        this.isPaused = true;
        synchronized (this) {
            VideoTextureRenderer videoTextureRenderer = this.renderer;
            if (videoTextureRenderer != null) {
                videoTextureRenderer.pauseRender();
                this.renderer.onPause();
                this.renderer = null;
            }
            SurfaceTexture surfaceTexture = this.videoTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.videoTexture = null;
            }
            Surface surface = this.mediaPlaySurface;
            if (surface != null) {
                surface.release();
                this.mediaPlaySurface = null;
            }
            IMediaPlayer iMediaPlayer = this.mMediaPlayer;
            if (iMediaPlayer != null) {
                iMediaPlayer.release();
                this.mMediaPlayer = null;
            }
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewPause() {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.webviewPause " + this);
        this.isOnPageBackGrond = true;
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null && iMediaPlayer.isPlaying() && this.autoPauseIfNavigate) {
            this.pauseByNavigate = true;
            try {
                VideoTextureRenderer videoTextureRenderer = this.renderer;
                if (videoTextureRenderer != null) {
                    videoTextureRenderer.pauseRender();
                }
                this.mMediaPlayer.pause();
                this.isPaused = true;
            } catch (Throwable th5) {
                QMLog.e(TAG, "webviewPause mMediaPlayer.pause() error.", th5);
            }
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewResume() {
        QMLog.i(TAG, "VideoEmbeddedWidgetClient.webviewResume " + this);
        this.isOnPageBackGrond = false;
        if (this.mMediaPlayer != null && this.pauseByNavigate) {
            this.pauseByNavigate = false;
            try {
                VideoTextureRenderer videoTextureRenderer = this.renderer;
                if (videoTextureRenderer != null) {
                    videoTextureRenderer.resumeRender();
                }
                QMLog.i(TAG, "VideoEmbeddedWidgetClient.webviewResume isPaused " + this.isPaused);
                if (!this.isOnPageBackGrond) {
                    this.isPaused = false;
                    this.mMediaPlayer.start();
                    sendTimingMsg(250L);
                    return;
                }
                QMLog.e(TAG, "isOnPageBackGrond when mediaPlayerStart - 2");
            } catch (Throwable th5) {
                QMLog.e(TAG, "webviewResume mMediaPlayer.start() error.", th5);
            }
        }
    }
}
