package com.tencent.superplayer.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.SuperPlayerMgrCommons;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class SuperPlayerMgrInternal {
    private static final int MSG_INDEX = 0;
    private static final int MSG_OPEN_MEDIA_PLAYER = 1;
    private static final int MSG_PAUSE = 13;
    private static final int MSG_PAUSE_DOWNLOAD = 89;
    private static final int MSG_RELEASE = 21;
    private static final int MSG_RESET = 15;
    private static final int MSG_RESUME_DOWNLOAD = 90;
    private static final int MSG_SEEK_TO = 23;
    private static final int MSG_SEEK_TO_BY_MODE = 24;
    private static final int MSG_SET_AUDIO_GAIN_RATIO = 31;
    private static final int MSG_SET_BUSINESS_DOWNLOAD_STRATEGY = 92;
    private static final int MSG_SET_LOOPBACK = 29;
    private static final int MSG_SET_LOOPBACK_WITH_POSITION = 85;
    private static final int MSG_SET_OUTPUT_MUTE = 27;
    private static final int MSG_SET_PLAY_SPEED_RATIO = 9;
    private static final int MSG_SET_SURFACE = 6;
    private static final int MSG_SET_VOLUME_GRAIN = 94;
    private static final int MSG_START = 12;
    private static final int MSG_STOP = 14;
    private static final int MSG_SWITCH_DEFINITION = 88;
    private static final int MSG_SWITCH_DEFINITION_FOR_URL = 93;
    private static final int MSG_UPDATE_PLAYER_VIDEO_VIEW = 5;
    private EventHandler mEventHandler;
    private SPlayerManagerInternalListener mHandleListener;
    private String mLogTag;
    private Looper mLooper;
    private volatile boolean mIsNeedBlockMessage = true;
    private volatile boolean mIsReleased = false;
    private Queue<Message> mPendingMessages = new LinkedList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class EventHandler extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (SuperPlayerMgrInternal.this.mHandleListener == null) {
                LogUtil.e(SuperPlayerMgrInternal.this.mLogTag, "handle listener is null, return");
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 9) {
                    if (i3 != 21) {
                        if (i3 != 27) {
                            if (i3 != 29) {
                                if (i3 != 85) {
                                    if (i3 != 5) {
                                        if (i3 != 6) {
                                            if (i3 != 23) {
                                                if (i3 != 24) {
                                                    switch (i3) {
                                                        case 12:
                                                            SuperPlayerMgrInternal.this.mHandleListener.handleStart();
                                                            return;
                                                        case 13:
                                                            SuperPlayerMgrInternal.this.mHandleListener.handlePause();
                                                            return;
                                                        case 14:
                                                            SuperPlayerMgrInternal.this.mHandleListener.handleStop();
                                                            return;
                                                        case 15:
                                                            SuperPlayerMgrInternal.this.mHandleListener.handleReset();
                                                            return;
                                                        default:
                                                            switch (i3) {
                                                                case 88:
                                                                    SuperPlayerMgrCommons.SwitchDefnParams switchDefnParams = (SuperPlayerMgrCommons.SwitchDefnParams) message.obj;
                                                                    SuperPlayerMgrInternal.this.mHandleListener.handleSwitchDefinition(switchDefnParams.defn, switchDefnParams.mode);
                                                                    return;
                                                                case 89:
                                                                    SuperPlayerMgrInternal.this.mHandleListener.handlePauseDownload();
                                                                    return;
                                                                case 90:
                                                                    SuperPlayerMgrInternal.this.mHandleListener.handleResumeDownload();
                                                                    return;
                                                                default:
                                                                    switch (i3) {
                                                                        case 92:
                                                                            int[] iArr = (int[]) message.obj;
                                                                            SuperPlayerMgrInternal.this.mHandleListener.handleSetBusinessDownloadStrategy(iArr[0], iArr[1], iArr[2], iArr[3]);
                                                                            return;
                                                                        case 93:
                                                                            SuperPlayerMgrCommons.SwitchDefnForUrlParams switchDefnForUrlParams = (SuperPlayerMgrCommons.SwitchDefnForUrlParams) message.obj;
                                                                            SuperPlayerMgrInternal.this.mHandleListener.handleSwitchDefinitionForUrl(switchDefnForUrlParams.url, switchDefnForUrlParams.mode);
                                                                            return;
                                                                        case 94:
                                                                            SuperPlayerMgrInternal.this.mHandleListener.handleSetVolumeGain(((Float) message.obj).floatValue());
                                                                            return;
                                                                        default:
                                                                            return;
                                                                    }
                                                            }
                                                    }
                                                }
                                                SuperPlayerMgrInternal.this.mHandleListener.handleSeekTo(message.arg1, message.arg2);
                                                return;
                                            }
                                            SuperPlayerMgrInternal.this.mHandleListener.handleSeekTo(message.arg1);
                                            return;
                                        }
                                        SuperPlayerMgrInternal.this.mHandleListener.handleSetSurface((Surface) message.obj);
                                        return;
                                    }
                                    SuperPlayerMgrInternal.this.mHandleListener.handleUpdatePlayerVideoView((ISPlayerVideoView) message.obj);
                                    return;
                                }
                                SuperPlayerMgrCommons.LoopbackParams loopbackParams = (SuperPlayerMgrCommons.LoopbackParams) message.obj;
                                SuperPlayerMgrInternal.this.mHandleListener.handleSetLoopback(loopbackParams.isLoopback, loopbackParams.loopStartPositionMs, loopbackParams.loopEndPositionMs, loopbackParams.seekMode);
                                return;
                            }
                            SuperPlayerMgrInternal.this.mHandleListener.handleSetLoopback(((Boolean) message.obj).booleanValue());
                            return;
                        }
                        SuperPlayerMgrInternal.this.mHandleListener.handleSetOutputMute(((Boolean) message.obj).booleanValue());
                        return;
                    }
                    SuperPlayerMgrInternal.this.mHandleListener.handleRelease();
                    return;
                }
                SuperPlayerMgrInternal.this.mHandleListener.handleSetPlaySpeedRatio(((Float) message.obj).floatValue());
                return;
            }
            SuperPlayerMgrCommons.OpenMediaParams openMediaParams = (SuperPlayerMgrCommons.OpenMediaParams) message.obj;
            try {
                SuperPlayerMgrInternal.this.mHandleListener.handleOpenMediaPlayer(openMediaParams.context, openMediaParams.videoInfo, openMediaParams.startPositionMilsec, openMediaParams.playerOption);
            } catch (TPLoadLibraryException unused) {
                LogUtil.e(SuperPlayerMgrInternal.this.mLogTag, "handle handleOpenMediaPlayer exception");
            }
        }

        EventHandler(Looper looper) {
            super(looper);
        }
    }

    /* loaded from: classes26.dex */
    interface SPlayerManagerInternalListener {
        void handleAddSubtitleSource(String str, String str2, String str3);

        int handleCaptureImageInTime(long j3, int i3, int i16);

        int handleCaptureImageInTime(long j3, int i3, int i16, int i17, int i18, int i19);

        void handleDeselectTrack(int i3, long j3);

        long handleGetCurrentPosition();

        long handleGetDuration();

        long handleGetFileSizeBytes();

        MediaInfo handleGetMediaInfo();

        TPProgramInfo[] handleGetProgramInfo();

        String handleGetStreamDumpInfo();

        TPTrackInfo[] handleGetTrackInfo();

        int handleGetVideoHeight();

        int handleGetVideoRotation();

        int handleGetVideoWidth();

        boolean handleIsBuffering();

        void handleOpenMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption) throws TPLoadLibraryException;

        void handlePause();

        void handlePauseDownload();

        void handleRelease();

        void handleReset();

        void handleResumeDownload();

        void handleSeekTo(int i3);

        void handleSeekTo(int i3, int i16);

        void handleSelectProgram(int i3, long j3);

        void handleSelectTrack(int i3, long j3);

        void handleSetBusinessDownloadStrategy(int i3, int i16, int i17, int i18);

        void handleSetLoopback(boolean z16);

        void handleSetLoopback(boolean z16, long j3, long j16, int i3);

        boolean handleSetOutputMute(boolean z16);

        void handleSetPlaySpeedRatio(float f16);

        void handleSetPlayerActive();

        void handleSetSurface(Surface surface);

        void handleSetVolumeGain(float f16);

        void handleStart();

        void handleStop();

        void handleSwitchDefinition(String str, int i3);

        void handleSwitchDefinitionForUrl(String str, int i3);

        void handleUpdatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SuperPlayerMgrInternal(String str, Looper looper, SPlayerManagerInternalListener sPlayerManagerInternalListener) {
        this.mLogTag = str;
        this.mLooper = looper;
        this.mEventHandler = new EventHandler(this.mLooper);
        this.mHandleListener = sPlayerManagerInternalListener;
    }

    private void internalMessage(int i3, Object obj) {
        internalMessage(i3, 0, 0, obj);
    }

    private boolean isNeedBlockMessage(int i3) {
        if (this.mIsNeedBlockMessage && (i3 == 1 || i3 == 21)) {
            this.mIsNeedBlockMessage = false;
        }
        return this.mIsNeedBlockMessage;
    }

    public void addSubtitleSource(String str, String str2, String str3) {
        this.mHandleListener.handleAddSubtitleSource(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int captureImageInTime(long j3, int i3, int i16) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        return this.mHandleListener.handleCaptureImageInTime(j3, i3, i16);
    }

    public void deselectTrack(int i3, long j3) {
        this.mHandleListener.handleDeselectTrack(i3, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getCurrentPositionMs() {
        return this.mHandleListener.handleGetCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getDurationMs() {
        return this.mHandleListener.handleGetDuration();
    }

    public long getFileSizeBytes() {
        return this.mHandleListener.handleGetFileSizeBytes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaInfo getMediaInfo() {
        return this.mHandleListener.handleGetMediaInfo();
    }

    public TPProgramInfo[] getProgramInfo() {
        return this.mHandleListener.handleGetProgramInfo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getStreamDumpInfo() {
        return this.mHandleListener.handleGetStreamDumpInfo();
    }

    public TPTrackInfo[] getTrackInfo() {
        return this.mHandleListener.handleGetTrackInfo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVideoHeight() {
        return this.mHandleListener.handleGetVideoHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVideoRotation() {
        return this.mHandleListener.handleGetVideoRotation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVideoWidth() {
        return this.mHandleListener.handleGetVideoWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBuffering() {
        return this.mHandleListener.handleIsBuffering();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openMediaPlayer(Context context, SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption) {
        SuperPlayerMgrCommons.OpenMediaParams openMediaParams = new SuperPlayerMgrCommons.OpenMediaParams();
        openMediaParams.context = context;
        openMediaParams.videoInfo = superPlayerVideoInfo;
        openMediaParams.startPositionMilsec = j3;
        openMediaParams.playerOption = superPlayerOption;
        internalMessage(1, openMediaParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        internalMessage(13, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pauseDownload() {
        internalMessage(89, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        internalMessage(21, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        internalMessage(15, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resumeDownload() {
        internalMessage(90, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void seekTo(int i3) {
        internalMessage(23, i3, 0, null);
    }

    public void selectProgram(int i3, long j3) {
        this.mHandleListener.handleSelectProgram(i3, j3);
    }

    public void selectTrack(int i3, long j3) {
        this.mHandleListener.handleSelectTrack(i3, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18) {
        internalMessage(92, new int[]{i3, i16, i17, i18});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setIsNeedBlockMessage(boolean z16) {
        this.mIsNeedBlockMessage = z16;
        if (!this.mIsNeedBlockMessage) {
            while (!this.mPendingMessages.isEmpty()) {
                Message poll = this.mPendingMessages.poll();
                if (poll != null) {
                    this.mEventHandler.sendMessage(poll);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoopback(boolean z16) {
        internalMessage(29, Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOutputMute(boolean z16) {
        internalMessage(27, Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlaySpeedRatio(float f16) {
        internalMessage(9, Float.valueOf(f16));
    }

    public void setPlayerActive() {
        this.mHandleListener.handleSetPlayerActive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSurface(Surface surface) {
        internalMessage(6, surface);
    }

    public void setVolumeGain(float f16) {
        internalMessage(94, Float.valueOf(f16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        internalMessage(12, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        internalMessage(14, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchDefinition(String str, int i3) {
        SuperPlayerMgrCommons.SwitchDefnParams switchDefnParams = new SuperPlayerMgrCommons.SwitchDefnParams();
        switchDefnParams.defn = str;
        switchDefnParams.mode = i3;
        internalMessage(88, switchDefnParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchDefinitionForUrl(String str, int i3) {
        SuperPlayerMgrCommons.SwitchDefnForUrlParams switchDefnForUrlParams = new SuperPlayerMgrCommons.SwitchDefnForUrlParams();
        switchDefnForUrlParams.url = str;
        switchDefnForUrlParams.mode = i3;
        internalMessage(93, switchDefnForUrlParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updatePlayerVideoView(ISPlayerVideoView iSPlayerVideoView) {
        internalMessage(5, iSPlayerVideoView);
    }

    private synchronized void internalMessage(int i3, int i16, int i17, Object obj) {
        if (this.mIsReleased) {
            return;
        }
        Message obtainMessage = this.mEventHandler.obtainMessage();
        obtainMessage.what = i3;
        obtainMessage.arg1 = i16;
        obtainMessage.arg2 = i17;
        obtainMessage.obj = obj;
        if (isNeedBlockMessage(i3)) {
            this.mPendingMessages.offer(obtainMessage);
            return;
        }
        if (i3 == 21) {
            this.mIsReleased = true;
            this.mPendingMessages.clear();
        }
        this.mEventHandler.sendMessage(obtainMessage);
        while (!this.mPendingMessages.isEmpty()) {
            Message poll = this.mPendingMessages.poll();
            if (poll != null) {
                this.mEventHandler.sendMessage(poll);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int captureImageInTime(long j3, int i3, int i16, int i17, int i18, int i19) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        return this.mHandleListener.handleCaptureImageInTime(j3, i3, i16, i17, i18, i19);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void seekTo(int i3, int i16) {
        internalMessage(24, i3, i16, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoopback(boolean z16, long j3, long j16, int i3) {
        SuperPlayerMgrCommons.LoopbackParams loopbackParams = new SuperPlayerMgrCommons.LoopbackParams();
        loopbackParams.isLoopback = z16;
        loopbackParams.loopStartPositionMs = j3;
        loopbackParams.loopEndPositionMs = j16;
        loopbackParams.seekMode = i3;
        internalMessage(85, loopbackParams);
    }
}
