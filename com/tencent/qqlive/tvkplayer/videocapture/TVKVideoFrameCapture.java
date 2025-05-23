package com.tencent.qqlive.tvkplayer.videocapture;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.TVKAssetPlayerFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.tools.auth.TVKAppKeyManager;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVideoFrameCapture implements ITVKVideoFrameCapture {
    private static final String API_AD_CALL_BACK_LOG_PREFIX = "ad manager callback : ";
    private static final String API_CALL_BACK_LOG_PREFIX = "asset player callback : ";
    private static final String API_CALL_LOG_PREFIX = "api call: ";
    private static final int CAPTURE_CGI_ERROR = 4;
    private static final int CAPTURE_PARAM_ERROR = 2;
    private static final int CAPTURE_PLAYER_ERROR = 5;
    private static final int CAPTURE_STATE_ERROR = 3;
    private static final int CAPTURE_UNSUPPORTED_ERROR = 1;
    private static final String MODULE_NAME = "TVKVideoFrameCapture";
    private final ITVKQQLiveAssetPlayer mAssetPlayer;
    private final QQLiveAssetPlayerListener mAssetPlayerListener;
    private ITVKPlayerState mAssetPlayerState;
    private Map<Integer, String> mErrorConstantMap;
    private final ITVKLogger mLogger;
    private final List<ITVKVideoFrameCapture.OnCaptureFrameOutListener> mOnCaptureFrameOutListeners = new ArrayList();
    private final List<ITVKVideoFrameCapture.OnCapturePreparedListener> mOnCapturePreparedListeners = new ArrayList();
    private final List<ITVKVideoFrameCapture.OnCaptureErrorListener> mOnCaptureErrorListeners = new ArrayList();
    private final List<ITVKVideoFrameCapture.OnCaptureBufferedListener> mOnCaptureBufferedListeners = new ArrayList();
    private final List<ITVKVideoFrameCapture.OnCaptureSeekCompleteListener> mOnCaptureSeekCompleteListener = new ArrayList();
    private final List<ITVKVideoFrameCapture.OnCaptureCompletionListener> mOnCaptureCompletionListeners = new ArrayList();

    public TVKVideoFrameCapture(TVKContext tVKContext) {
        QQLiveAssetPlayerListener qQLiveAssetPlayerListener = new QQLiveAssetPlayerListener();
        this.mAssetPlayerListener = qQLiveAssetPlayerListener;
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        ITVKQQLiveAssetPlayer createAssetPlayer = TVKAssetPlayerFactory.createAssetPlayer(tVKContext, null, null, null);
        this.mAssetPlayer = createAssetPlayer;
        this.mAssetPlayerState = TVKAssetPlayerFactory.createPlayerState();
        createAssetPlayer.setAssetPlayerListener(qQLiveAssetPlayerListener);
        initConstantsMap();
    }

    private void initConstantsMap() {
        HashMap hashMap = new HashMap();
        this.mErrorConstantMap = hashMap;
        hashMap.put(1, "CAPTURE_UNSUPPORTED_ERROR");
        this.mErrorConstantMap.put(2, "CAPTURE_PARAM_ERROR");
        this.mErrorConstantMap.put(3, "CAPTURE_STATE_ERROR");
        this.mErrorConstantMap.put(4, "CAPTURE_CGI_ERROR");
        this.mErrorConstantMap.put(5, "CAPTURE_PLAYER_ERROR");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnCompletion() {
        synchronized (this.mOnCaptureCompletionListeners) {
            Iterator<ITVKVideoFrameCapture.OnCaptureCompletionListener> it = this.mOnCaptureCompletionListeners.iterator();
            while (it.hasNext()) {
                it.next().onCaptureCompletion(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnEndOfBuffering() {
        synchronized (this.mOnCaptureBufferedListeners) {
            Iterator<ITVKVideoFrameCapture.OnCaptureBufferedListener> it = this.mOnCaptureBufferedListeners.iterator();
            while (it.hasNext()) {
                it.next().onEndOfBuffering(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnError(int i3) {
        synchronized (this.mOnCaptureErrorListeners) {
            Iterator<ITVKVideoFrameCapture.OnCaptureErrorListener> it = this.mOnCaptureErrorListeners.iterator();
            while (it.hasNext()) {
                it.next().onError(this, i3, this.mErrorConstantMap.get(Integer.valueOf(i3)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnFrameOut(byte[] bArr, int i3, int i16, int i17, int i18, long j3) {
        synchronized (this.mOnCaptureFrameOutListeners) {
            Iterator<ITVKVideoFrameCapture.OnCaptureFrameOutListener> it = this.mOnCaptureFrameOutListeners.iterator();
            while (it.hasNext()) {
                it.next().onVideoFrame(bArr, i3, i16, i17, i18, j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnPrepared() {
        synchronized (this.mOnCapturePreparedListeners) {
            Iterator<ITVKVideoFrameCapture.OnCapturePreparedListener> it = this.mOnCapturePreparedListeners.iterator();
            while (it.hasNext()) {
                it.next().onCapturePrepared(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnSeekComplete() {
        synchronized (this.mOnCaptureSeekCompleteListener) {
            Iterator<ITVKVideoFrameCapture.OnCaptureSeekCompleteListener> it = this.mOnCaptureSeekCompleteListener.iterator();
            while (it.hasNext()) {
                it.next().onCaptureSeekComplete(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnStartBuffering() {
        synchronized (this.mOnCaptureBufferedListeners) {
            Iterator<ITVKVideoFrameCapture.OnCaptureBufferedListener> it = this.mOnCaptureBufferedListeners.iterator();
            while (it.hasNext()) {
                it.next().onStartBuffering(this);
            }
        }
    }

    private void removeAllListeners() {
        synchronized (this.mOnCaptureCompletionListeners) {
            this.mOnCaptureCompletionListeners.clear();
        }
        synchronized (this.mOnCaptureFrameOutListeners) {
            this.mOnCaptureFrameOutListeners.clear();
        }
        synchronized (this.mOnCapturePreparedListeners) {
            this.mOnCapturePreparedListeners.clear();
        }
        synchronized (this.mOnCaptureSeekCompleteListener) {
            this.mOnCaptureSeekCompleteListener.clear();
        }
        synchronized (this.mOnCaptureBufferedListeners) {
            this.mOnCaptureBufferedListeners.clear();
        }
        synchronized (this.mOnCaptureErrorListeners) {
            this.mOnCaptureErrorListeners.clear();
        }
    }

    private void resetAll() {
        removeAllListeners();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public boolean addOnCaptureBufferedListener(ITVKVideoFrameCapture.OnCaptureBufferedListener onCaptureBufferedListener) {
        if (onCaptureBufferedListener == null) {
            return false;
        }
        synchronized (this.mOnCaptureBufferedListeners) {
            if (this.mOnCaptureBufferedListeners.contains(onCaptureBufferedListener)) {
                return false;
            }
            this.mOnCaptureBufferedListeners.add(onCaptureBufferedListener);
            return true;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public boolean addOnCaptureCompletionListener(ITVKVideoFrameCapture.OnCaptureCompletionListener onCaptureCompletionListener) {
        if (onCaptureCompletionListener == null) {
            return false;
        }
        synchronized (this.mOnCaptureCompletionListeners) {
            if (this.mOnCaptureCompletionListeners.contains(onCaptureCompletionListener)) {
                return false;
            }
            this.mOnCaptureCompletionListeners.add(onCaptureCompletionListener);
            return true;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public boolean addOnCaptureErrorListener(ITVKVideoFrameCapture.OnCaptureErrorListener onCaptureErrorListener) {
        if (onCaptureErrorListener == null) {
            return false;
        }
        synchronized (this.mOnCaptureErrorListeners) {
            if (this.mOnCaptureErrorListeners.contains(onCaptureErrorListener)) {
                return false;
            }
            this.mOnCaptureErrorListeners.add(onCaptureErrorListener);
            return true;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public boolean addOnCaptureFrameOutListener(ITVKVideoFrameCapture.OnCaptureFrameOutListener onCaptureFrameOutListener) {
        if (onCaptureFrameOutListener == null) {
            return false;
        }
        synchronized (this.mOnCaptureFrameOutListeners) {
            if (this.mOnCaptureFrameOutListeners.contains(onCaptureFrameOutListener)) {
                return false;
            }
            this.mOnCaptureFrameOutListeners.add(onCaptureFrameOutListener);
            return true;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public boolean addOnCapturePreparedListener(ITVKVideoFrameCapture.OnCapturePreparedListener onCapturePreparedListener) {
        if (onCapturePreparedListener == null) {
            return false;
        }
        synchronized (this.mOnCapturePreparedListeners) {
            if (this.mOnCapturePreparedListeners.contains(onCapturePreparedListener)) {
                return false;
            }
            this.mOnCapturePreparedListeners.add(onCapturePreparedListener);
            return true;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public boolean addOnCaptureSeekCompleteListener(ITVKVideoFrameCapture.OnCaptureSeekCompleteListener onCaptureSeekCompleteListener) {
        if (onCaptureSeekCompleteListener == null) {
            return false;
        }
        synchronized (this.mOnCaptureSeekCompleteListener) {
            if (this.mOnCaptureSeekCompleteListener.contains(onCaptureSeekCompleteListener)) {
                return false;
            }
            this.mOnCaptureSeekCompleteListener.add(onCaptureSeekCompleteListener);
            return true;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public void captureVideoByUrl(Context context, String str, long j3, long j16) {
        this.mLogger.info("api call: captureVideoByUrl, url:" + str + ", skipStartPositionMs:" + j3 + ", skipEndPositionMs:" + j16, new Object[0]);
        if (!TVKAppKeyManager.isAuthorized()) {
            this.mLogger.error("captureVideoByUrl fail, because unAuthorized or authorized failed:" + TVKAppKeyManager.getKeyStateDescription(), new Object[0]);
            notifyOnError(1);
            return;
        }
        if (!this.mAssetPlayerState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.STOPPED)) {
            this.mLogger.error("captureVideoByUrl player state invalid:" + this.mAssetPlayerState, new Object[0]);
            notifyOnError(3);
            return;
        }
        TVKPlayerVideoInfo tVKPlayerVideoInfo = new TVKPlayerVideoInfo(TVKAssetFactory.createUrlAsset(str));
        tVKPlayerVideoInfo.setSkipStartPositionMs(j3);
        tVKPlayerVideoInfo.setSkipEndPositionMs(j16);
        tVKPlayerVideoInfo.addConfigMap("playmode", "video_capture");
        this.mAssetPlayer.openMediaPlayerByUrl(context, str, "", j3, j16, new TVKUserInfo(), tVKPlayerVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public void captureVideoByVid(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo == null) {
            this.mLogger.error("captureVideoByVid, video info is null", new Object[0]);
            notifyOnError(2);
            return;
        }
        String definition = tVKPlayerVideoInfo.getDefinition();
        this.mLogger.info("api call: captureVideoByVid, definition:" + definition + ", skipStartPositionMs:" + tVKPlayerVideoInfo.getSkipStartPositionMs() + ", skipEndPositionMs:" + tVKPlayerVideoInfo.getSkipEndPositionMs(), new Object[0]);
        if (!TVKAppKeyManager.isAuthorized()) {
            this.mLogger.error("captureVideoByVid fail, because unAuthorized or authorized failed:" + TVKAppKeyManager.getKeyStateDescription(), new Object[0]);
            notifyOnError(1);
            return;
        }
        if (!this.mAssetPlayerState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.STOPPED)) {
            this.mLogger.error("captureVideoByVid player state invalid:" + this.mAssetPlayerState, new Object[0]);
            notifyOnError(3);
            return;
        }
        if (tVKUserInfo == null) {
            tVKUserInfo = new TVKUserInfo();
        }
        try {
            TVKPlayerVideoInfo m239clone = tVKPlayerVideoInfo.m239clone();
            m239clone.addConfigMap("playmode", "video_capture");
            if (TextUtils.isEmpty(definition) || "auto".equalsIgnoreCase(definition)) {
                m239clone.setDefinition("hd");
            }
            this.mAssetPlayer.openMediaPlayer(context, tVKUserInfo, m239clone);
        } catch (CloneNotSupportedException unused) {
            this.mLogger.error("check video info implementation", new Object[0]);
            notifyOnError(2);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public void pause() {
        this.mLogger.info("api call: pause", new Object[0]);
        this.mAssetPlayer.pause();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public void release() {
        this.mLogger.info("api call: release", new Object[0]);
        this.mAssetPlayer.release();
        resetAll();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public void seekTo(int i3) {
        this.mAssetPlayer.seekTo(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public void seekToAccuratePos(int i3) {
        this.mAssetPlayer.seekToAccuratePos(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public void start() {
        this.mLogger.info("api call: start", new Object[0]);
        this.mAssetPlayer.start();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKVideoFrameCapture
    public void stop() {
        this.mLogger.info("api call: stop", new Object[0]);
        this.mAssetPlayer.stop();
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class QQLiveAssetPlayerListener implements ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener {
        QQLiveAssetPlayerListener() {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public long getAdvRemainTimeMs() {
            return 0L;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onCompletion() {
            TVKVideoFrameCapture.this.notifyOnCompletion();
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public boolean onError(TVKError tVKError) {
            TVKVideoFrameCapture.this.notifyOnError(5);
            return true;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public TVKUserInfo onGetUserInfo() {
            return null;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public boolean onInfo(int i3, long j3, long j16, Object obj) {
            if (i3 == 112) {
                TVKVideoFrameCapture.this.notifyOnStartBuffering();
                return true;
            }
            if (i3 == 113) {
                TVKVideoFrameCapture.this.notifyOnEndOfBuffering();
                return true;
            }
            return true;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onSeekComplete() {
            TVKVideoFrameCapture.this.notifyOnSeekComplete();
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onStateChange(ITVKPlayerState iTVKPlayerState) {
            TVKVideoFrameCapture.this.mLogger.info("asset player callback : asset player state change, state: " + iTVKPlayerState, new Object[0]);
            TVKVideoFrameCapture.this.mAssetPlayerState = iTVKPlayerState;
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onVideoCGIed(TVKNetVideoInfo tVKNetVideoInfo) {
            TVKVideoFrameCapture.this.mAssetPlayer.prepare();
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
            if (tVKVideoFrameBuffer.getData() == null) {
                TVKVideoFrameCapture.this.mLogger.error("data in video frame buffer is null", new Object[0]);
            }
            TVKVideoFrameCapture.this.notifyOnFrameOut(tVKVideoFrameBuffer.getData()[0], tVKVideoFrameBuffer.getWidth(), tVKVideoFrameBuffer.getHeight(), tVKVideoFrameBuffer.getRotation(), 0, tVKVideoFrameBuffer.getPtsMs());
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onVideoPrepared() {
            TVKVideoFrameCapture.this.notifyOnPrepared();
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onLoopBackChanged() {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onPermissionTimeout() {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onVideoPreparing() {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onDebugTrackingInfo(TPDebugTrackingInfo tPDebugTrackingInfo) {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onNetVideoInfo(@NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onSubtitleDataOut(TPSubtitleData tPSubtitleData) {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onCaptureImageFailed(int i3, int i16) {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onVideoSizeChanged(int i3, int i16) {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onCaptureImageSucceed(int i3, int i16, int i17, Bitmap bitmap) {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener
        public void onOriginalLogoPosition(int i3, int i16, int i17, int i18, boolean z16) {
        }
    }
}
