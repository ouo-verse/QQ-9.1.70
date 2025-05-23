package com.tencent.qqlive.tvkplayer.videotrack;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.ViewGroup;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;
import com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer;
import com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr;
import com.tencent.qqlive.tvkplayer.videotrack.TVKVideoTrackHelper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes23.dex */
public class TVKVideoTrackPlayerMgr implements ITVKVideoTrackPlayerMgr {
    private static final String TAG = "TVKVideoTrackPlayerMgr";
    private Looper mCallBackLooper;
    private Context mContext;
    private ITVKTPPlayer mMasterPlayer;
    private TVKUserInfo mUserInfo;
    private ITVKVideoTrackPlayerMgr.VideoTrackMgrOnListener mVideoTrackMgrOnListener;
    private int mPlayerType = 0;
    private Set<ITVKPlayerEventListener> mPlayerEventListeners = new HashSet();
    private Set<ITVKReportEventListener> mReportEventListeners = new HashSet();
    ITVKPlayerEventListener mTrackInnerListener = new ITVKPlayerEventListener() { // from class: com.tencent.qqlive.tvkplayer.videotrack.TVKVideoTrackPlayerMgr.1
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener
        public void onPlayerEvent(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.PlayerEvent playerEvent, ITVKPlayerEventListener.EventParams eventParams) {
            Iterator it = TVKVideoTrackPlayerMgr.this.mPlayerEventListeners.iterator();
            while (it.hasNext()) {
                ((ITVKPlayerEventListener) it.next()).onPlayerEvent(iTVKMediaPlayer, playerEvent, eventParams);
            }
        }
    };
    private long mPlayerPositionMs = 0;
    private ArrayMap<String, ITVKVideoTrackPlayer> mVideoTracks = new ArrayMap<>();

    /* loaded from: classes23.dex */
    private class VideoTrackPlayerListener implements ITVKVideoTrackPlayer.VideoTrackPlayerListener {
        VideoTrackPlayerListener() {
        }

        @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer.VideoTrackPlayerListener
        public void onCompletion(ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKVideoTrackPlayerMgr.this.handleTrackComplete(iTVKVideoTrackPlayer);
        }

        @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer.VideoTrackPlayerListener
        public void onEndBuffering(ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKVideoTrackPlayerMgr.this.handleTrackEndBuffering(iTVKVideoTrackPlayer);
        }

        @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer.VideoTrackPlayerListener
        public boolean onError(ITVKVideoTrackPlayer iTVKVideoTrackPlayer, TVKError tVKError) {
            TVKVideoTrackPlayerMgr.this.handleTrackError(iTVKVideoTrackPlayer, tVKError);
            return false;
        }

        @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer.VideoTrackPlayerListener
        public void onNetVideoInfo(ITVKVideoTrackPlayer iTVKVideoTrackPlayer, TVKNetVideoInfo tVKNetVideoInfo) {
            TVKVideoTrackPlayerMgr.this.handleTrackNetVideoInfo(iTVKVideoTrackPlayer, tVKNetVideoInfo);
        }

        @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer.VideoTrackPlayerListener
        public void onSeekComplete(ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKVideoTrackPlayerMgr.this.handleTrackSeekComplete(iTVKVideoTrackPlayer);
        }

        @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer.VideoTrackPlayerListener
        public void onStartBuffering(ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKVideoTrackPlayerMgr.this.handleTrackStartBuffering(iTVKVideoTrackPlayer);
        }

        @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer.VideoTrackPlayerListener
        public void onVideoPrepared(ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
            TVKVideoTrackPlayerMgr.this.handleTrackPrepared(iTVKVideoTrackPlayer);
        }
    }

    public TVKVideoTrackPlayerMgr(Context context, Looper looper) {
        this.mContext = context;
        this.mCallBackLooper = looper;
    }

    private void handleOnTrackOpen() {
        ITVKVideoTrackPlayerMgr.VideoTrackMgrOnListener videoTrackMgrOnListener = this.mVideoTrackMgrOnListener;
        if (videoTrackMgrOnListener != null) {
            videoTrackMgrOnListener.onTrackOpen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTrackComplete(ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
        TVKVideoTrackHelper.LogHelper.printCallbackTrackComplete(TAG, iTVKVideoTrackPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTrackEndBuffering(ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
        TVKVideoTrackHelper.LogHelper.printCallbackTrackBufferEnd(TAG, iTVKVideoTrackPlayer);
        ITVKVideoTrackPlayerMgr.VideoTrackMgrOnListener videoTrackMgrOnListener = this.mVideoTrackMgrOnListener;
        if (videoTrackMgrOnListener != null) {
            videoTrackMgrOnListener.onRequestResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTrackError(ITVKVideoTrackPlayer iTVKVideoTrackPlayer, TVKError tVKError) {
        TVKVideoTrackHelper.LogHelper.printCallbackTrackError(TAG, iTVKVideoTrackPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTrackNetVideoInfo(ITVKVideoTrackPlayer iTVKVideoTrackPlayer, TVKNetVideoInfo tVKNetVideoInfo) {
        TVKVideoTrackHelper.LogHelper.printCallbackNetVideoInfo(TAG, iTVKVideoTrackPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTrackPrepared(ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
        TVKVideoTrackHelper.LogHelper.printCallbackTrackPrepared(TAG, iTVKVideoTrackPlayer);
        startTimeMatchedVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTrackSeekComplete(ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
        TVKVideoTrackHelper.LogHelper.printCallbackTrackSeekComplete(TAG, iTVKVideoTrackPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTrackStartBuffering(ITVKVideoTrackPlayer iTVKVideoTrackPlayer) {
        TVKVideoTrackHelper.LogHelper.printCallbackTrackBufferStart(TAG, iTVKVideoTrackPlayer);
        ITVKVideoTrackPlayerMgr.VideoTrackMgrOnListener videoTrackMgrOnListener = this.mVideoTrackMgrOnListener;
        if (videoTrackMgrOnListener != null) {
            videoTrackMgrOnListener.onRequestPause();
        }
    }

    private void startTimeMatchedVideo() {
        ITVKVideoTrackPlayerMgr.VideoTrackMgrOnListener videoTrackMgrOnListener;
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            TVKVideoTrackInfo videoTrackInfo = iTVKVideoTrackPlayer.getVideoTrackInfo();
            if (iTVKVideoTrackPlayer.state() == 4 && (videoTrackMgrOnListener = this.mVideoTrackMgrOnListener) != null && videoTrackMgrOnListener.onCanBePlay() && TVKVideoTrackHelper.Utils.inTimeInterval(videoTrackInfo, this.mPlayerPositionMs)) {
                TVKVideoTrackHelper.LogHelper.printStartTimeMatchedTrack(TAG, iTVKVideoTrackPlayer);
                iTVKVideoTrackPlayer.start();
                return;
            } else if (iTVKVideoTrackPlayer.state() == 2 && TVKVideoTrackHelper.Utils.inTimeInterval(videoTrackInfo, this.mPlayerPositionMs)) {
                TVKVideoTrackHelper.LogHelper.printOpenTimeMatchedTrack(TAG, iTVKVideoTrackPlayer);
                long insertTimeMs = (this.mPlayerPositionMs - videoTrackInfo.getInsertTimeMs()) + iTVKVideoTrackPlayer.getVideoTrackInfo().getVideoTrackStartPositionMs();
                if (insertTimeMs < 0) {
                    insertTimeMs = 0;
                }
                iTVKVideoTrackPlayer.openMediaPlayer(insertTimeMs, 0L);
                handleOnTrackOpen();
                return;
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void addPlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        this.mPlayerEventListeners.add(iTVKPlayerEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void addReportEventListener(ITVKReportEventListener iTVKReportEventListener) {
        this.mReportEventListeners.add(iTVKReportEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void addTrack(int i3, String str, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalArgumentException {
        if (i3 != 1) {
            TVKLogUtil.i(TAG, "api : add track , not video track, do nothing");
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!TVKVideoTrackHelper.Utils.contains(str, this.mVideoTracks)) {
                if (this.mPlayerType == 2) {
                    TVKVideoTrackHelper.LogHelper.printApiCallAddTrack(TAG, str, tVKPlayerVideoInfo);
                    TVKVideoTrackPlayer tVKVideoTrackPlayer = new TVKVideoTrackPlayer(this.mContext, str, this.mUserInfo, tVKPlayerVideoInfo, this.mMasterPlayer, this.mCallBackLooper);
                    tVKVideoTrackPlayer.setVideoTrackPlayerListener(new VideoTrackPlayerListener());
                    tVKVideoTrackPlayer.addPlayerEventListener(this.mTrackInnerListener);
                    this.mVideoTracks.put(str, tVKVideoTrackPlayer);
                    TVKLogUtil.i(TAG, "api : add track ,video track name = " + str);
                    return;
                }
                throw new IllegalArgumentException("api : add track , main player type is not self dev player");
            }
            throw new IllegalArgumentException("api : add track , track already added");
        }
        throw new IllegalArgumentException("api : add track , track info name is null");
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void deselectTrack(TVKTrackInfo tVKTrackInfo) {
        if (tVKTrackInfo != null) {
            if (tVKTrackInfo.getTrackType() != 1) {
                TVKLogUtil.i(TAG, "api : deselect track , not video track, do nothing");
                return;
            }
            if (TVKVideoTrackHelper.Utils.contains((TVKVideoTrackInfo) tVKTrackInfo, this.mVideoTracks)) {
                ITVKVideoTrackPlayer iTVKVideoTrackPlayer = this.mVideoTracks.get(tVKTrackInfo.getTrackName());
                Objects.requireNonNull(iTVKVideoTrackPlayer);
                if (!iTVKVideoTrackPlayer.isSelected()) {
                    TVKLogUtil.w(TAG, "deselect track , track info not selected , do nothing here");
                    return;
                }
                TVKVideoTrackHelper.LogHelper.printApiCallDeselectTrack(TAG, tVKTrackInfo);
                ITVKVideoTrackPlayer iTVKVideoTrackPlayer2 = this.mVideoTracks.get(tVKTrackInfo.getTrackName());
                Objects.requireNonNull(iTVKVideoTrackPlayer2);
                iTVKVideoTrackPlayer2.stop();
                ITVKVideoTrackPlayer iTVKVideoTrackPlayer3 = this.mVideoTracks.get(tVKTrackInfo.getTrackName());
                Objects.requireNonNull(iTVKVideoTrackPlayer3);
                iTVKVideoTrackPlayer3.deSelect();
                return;
            }
            throw new IllegalArgumentException("deselect track , track info not added, please add first");
        }
        throw new IllegalArgumentException("deselect track , track info is null");
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public int getSelectedTrack(int i3) {
        TVKLogUtil.w(TAG, "unsupported operation: getSelectedTrack");
        return -1;
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public TVKTrackInfo[] getTrackInfo() {
        TVKTrackInfo[] tVKTrackInfoArr = new TVKTrackInfo[this.mVideoTracks.size()];
        for (int i3 = 0; i3 < this.mVideoTracks.size(); i3++) {
            tVKTrackInfoArr[i3] = this.mVideoTracks.valueAt(i3).getVideoTrackInfo();
        }
        return tVKTrackInfoArr;
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public boolean isVideoTrackEmpty() {
        ArrayMap<String, ITVKVideoTrackPlayer> arrayMap = this.mVideoTracks;
        if (arrayMap == null || arrayMap.size() <= 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void onClickPause() {
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            if (TVKVideoTrackHelper.Utils.isTrackActive(iTVKVideoTrackPlayer.state())) {
                iTVKVideoTrackPlayer.pause();
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void pause() {
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            if (TVKVideoTrackHelper.Utils.isTrackActive(iTVKVideoTrackPlayer.state())) {
                iTVKVideoTrackPlayer.pause();
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void pauseDownload() {
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            if (TVKVideoTrackHelper.Utils.isTrackActive(iTVKVideoTrackPlayer.state())) {
                iTVKVideoTrackPlayer.pauseDownload();
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void refreshPlayer() {
        TVKLogUtil.i(TAG, "refreshPlayer not supported here");
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void refreshPlayerWithReopen() {
        TVKLogUtil.i(TAG, "refreshPlayerWithReopen not supported here");
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void release() {
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            iTVKVideoTrackPlayer.stop();
            iTVKVideoTrackPlayer.removePlayerEventListener(this.mTrackInnerListener);
            iTVKVideoTrackPlayer.release();
            iTVKVideoTrackPlayer.deSelect();
        }
        this.mVideoTracks.clear();
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void removePlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        this.mPlayerEventListeners.remove(iTVKPlayerEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void removeReportEventListener(ITVKReportEventListener iTVKReportEventListener) {
        this.mReportEventListeners.remove(iTVKReportEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void resumeDownload() {
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            if (TVKVideoTrackHelper.Utils.isTrackActive(iTVKVideoTrackPlayer.state())) {
                iTVKVideoTrackPlayer.resumeDownload();
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void saveReport() {
        Iterator<ITVKVideoTrackPlayer> it = this.mVideoTracks.values().iterator();
        while (it.hasNext()) {
            it.next().saveReport();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void seekTo(int i3) {
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            if (TVKVideoTrackHelper.Utils.isTrackActive(iTVKVideoTrackPlayer.state())) {
                iTVKVideoTrackPlayer.seekTo(i3);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void seekToAccuratePos(int i3) {
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            if (TVKVideoTrackHelper.Utils.isTrackActive(iTVKVideoTrackPlayer.state())) {
                iTVKVideoTrackPlayer.seekToAccuratePos(i3);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void selectTrack(TVKTrackInfo tVKTrackInfo) throws IllegalArgumentException {
        if (tVKTrackInfo != null) {
            if (tVKTrackInfo.getTrackType() != 1) {
                TVKLogUtil.i(TAG, "api : select track , not video track, do nothing");
                return;
            }
            if (TVKVideoTrackHelper.Utils.contains((TVKVideoTrackInfo) tVKTrackInfo, this.mVideoTracks)) {
                ITVKVideoTrackPlayer iTVKVideoTrackPlayer = this.mVideoTracks.get(tVKTrackInfo.getTrackName());
                Objects.requireNonNull(iTVKVideoTrackPlayer);
                if (iTVKVideoTrackPlayer.isSelected()) {
                    TVKLogUtil.w(TAG, "api : select track , track info already selected , do nothing here");
                    return;
                }
                TVKVideoTrackHelper.LogHelper.printApiCallSelectTrack(TAG, tVKTrackInfo);
                ITVKVideoTrackPlayer iTVKVideoTrackPlayer2 = this.mVideoTracks.get(tVKTrackInfo.getTrackName());
                Objects.requireNonNull(iTVKVideoTrackPlayer2);
                ITVKVideoTrackPlayer iTVKVideoTrackPlayer3 = iTVKVideoTrackPlayer2;
                TVKLogUtil.i(TAG, "api : select track ,main player current position=" + this.mPlayerPositionMs);
                long insertTimeMs = (this.mPlayerPositionMs - iTVKVideoTrackPlayer3.getVideoTrackInfo().getInsertTimeMs()) + iTVKVideoTrackPlayer3.getVideoTrackInfo().getVideoTrackStartPositionMs();
                if (insertTimeMs < 0) {
                    insertTimeMs = 0;
                }
                boolean inTimeInterval = TVKVideoTrackHelper.Utils.inTimeInterval(iTVKVideoTrackPlayer3.getVideoTrackInfo(), this.mPlayerPositionMs);
                boolean videoTrackEnablePreload = iTVKVideoTrackPlayer3.getVideoTrackInfo().videoTrackEnablePreload();
                iTVKVideoTrackPlayer3.select();
                if (inTimeInterval) {
                    TVKLogUtil.i(TAG, "api : select track , track info time match , call open player");
                    iTVKVideoTrackPlayer3.openMediaPlayer(insertTimeMs, 0L);
                    handleOnTrackOpen();
                    return;
                } else {
                    if (videoTrackEnablePreload) {
                        TVKLogUtil.i(TAG, "api : select track , track info need preload , call open player");
                        iTVKVideoTrackPlayer3.openMediaPlayer(insertTimeMs, 0L);
                        handleOnTrackOpen();
                        return;
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("api : select track , track info not added, please add first");
        }
        throw new IllegalArgumentException("api : select track , track info is null");
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void setPlaySpeedRatio(float f16) {
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            if (TVKVideoTrackHelper.Utils.isTrackActive(iTVKVideoTrackPlayer.state())) {
                iTVKVideoTrackPlayer.setPlaySpeedRatio(f16);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void setVideoTrackPlayerMgrListener(ITVKVideoTrackPlayerMgr.VideoTrackMgrOnListener videoTrackMgrOnListener) {
        this.mVideoTrackMgrOnListener = videoTrackMgrOnListener;
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void start() {
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            if (TVKVideoTrackHelper.Utils.isTrackActive(iTVKVideoTrackPlayer.state())) {
                iTVKVideoTrackPlayer.start();
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void stop() {
        try {
            Iterator<ITVKVideoTrackPlayer> it = this.mVideoTracks.values().iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
        } catch (Exception unused) {
            TVKLogUtil.w(TAG, "TVKVideoTrackPlayerMgr stop error");
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void switchDefinition(String str) throws IllegalStateException, IllegalArgumentException {
        TVKLogUtil.w(TAG, "unsupported operation: switchDefinition");
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void switchDefinitionWithReopen(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException {
        TVKLogUtil.w(TAG, "unsupported operation: switchDefinition");
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void updateMasterPlayer(ITVKTPPlayer iTVKTPPlayer) {
        this.mMasterPlayer = iTVKTPPlayer;
        Iterator<ITVKVideoTrackPlayer> it = this.mVideoTracks.values().iterator();
        while (it.hasNext()) {
            it.next().updateMasterPlayer(this.mMasterPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void updatePlayerPositionMs(long j3) {
        this.mPlayerPositionMs = j3;
        startTimeMatchedVideo();
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void updatePlayerType(int i3) {
        this.mPlayerType = i3;
        TVKLogUtil.i(TAG, "master player type is " + i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void updateReportParam(TVKProperties tVKProperties) {
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            if (TVKVideoTrackHelper.Utils.isTrackActive(iTVKVideoTrackPlayer.state())) {
                iTVKVideoTrackPlayer.updateReportParam(tVKProperties);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void updateUserInfo(TVKUserInfo tVKUserInfo) {
        this.mUserInfo = tVKUserInfo;
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException {
        TVKLogUtil.w(TAG, "unsupported operation: switchDefinition");
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void onClickPause(ViewGroup viewGroup) {
        for (ITVKVideoTrackPlayer iTVKVideoTrackPlayer : this.mVideoTracks.values()) {
            if (TVKVideoTrackHelper.Utils.isTrackActive(iTVKVideoTrackPlayer.state())) {
                iTVKVideoTrackPlayer.pause();
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr
    public void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException {
    }
}
