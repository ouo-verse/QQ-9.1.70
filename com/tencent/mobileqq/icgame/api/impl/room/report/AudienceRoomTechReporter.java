package com.tencent.mobileqq.icgame.api.impl.room.report;

import a32.c;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.impl.room.StreamLatencyCalculator;
import com.tencent.mobileqq.icgame.api.impl.room.StreamSeiParser;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.api.room.IcgRoomPlayerConfig;
import com.tencent.mobileqq.icgame.api.room.PlayerConfig;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AudienceRoomTechReporter extends b32.a {
    public static final String TAG = "ICGameAudienceRoomTechReporter";
    private static String userId;
    private static String userName;
    private long clickTime;
    private long initTime;
    private String mediaUrl;
    private long roomId;
    private long startBufferTime;
    private long startEnterRoomTime;
    private long startPlayTime;
    private String toolState;
    private String uuid;
    private final IAegisLogApi log = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    private final AudienceReportInfo info = new AudienceReportInfo();
    private long streamLatencySum = 0;
    private long streamLatencyCollectionCount = 0;
    private boolean streamLatencyReportedFirstTime = false;
    private final StreamLatencyCalculator streamLatencyCalculator = new StreamLatencyCalculator();
    private boolean isPause = false;
    private boolean isStartPlay = false;
    private Runnable reportStreamLatencyRunnable = new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.report.a
        @Override // java.lang.Runnable
        public final void run() {
            AudienceRoomTechReporter.this.lambda$new$0();
        }
    };

    private void addLatency(long j3) {
        if (!isLatencyValid(j3)) {
            return;
        }
        synchronized (this) {
            this.streamLatencySum += j3;
            this.streamLatencyCollectionCount++;
        }
    }

    private void initRoomInfo(AudienceRoomConfig audienceRoomConfig) {
        IcgRoomPlayerConfig icgRoomPlayerConfig;
        if (audienceRoomConfig != null && (icgRoomPlayerConfig = audienceRoomConfig.preloadPlayParams) != null) {
            this.roomId = icgRoomPlayerConfig.roomId;
        }
        this.info.setRoomInfo(this.roomId, "");
    }

    private void initUserInfo(IQQLiveSDK iQQLiveSDK) {
        IQQLiveModuleLogin loginModule;
        LiveUserInfo userInfo;
        if ((TextUtils.isEmpty(userId) || TextUtils.isEmpty(userName)) && (loginModule = iQQLiveSDK.getLoginModule()) != null && (userInfo = loginModule.getUserInfo()) != null) {
            userId = "" + userInfo.uid;
            userName = userInfo.nick;
        }
    }

    private boolean isLatencyValid(long j3) {
        if (j3 > 0 && j3 <= 20000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        float f16;
        long j3 = this.streamLatencyCollectionCount;
        if (j3 != 0) {
            f16 = (((float) this.streamLatencySum) * 1.0f) / ((float) j3);
        } else {
            f16 = 0.0f;
        }
        AudienceReportInfo audienceReportInfo = this.info;
        if (audienceReportInfo != null) {
            audienceReportInfo.onLatency(f16);
        }
        synchronized (this) {
            this.streamLatencySum = 0L;
            this.streamLatencyCollectionCount = 0L;
        }
        stopCollectStreamLatency();
        startCollectStreamLatency();
    }

    private void logE(String str) {
        this.log.e(TAG, str + " roomId:" + this.roomId + " uuid:" + this.uuid + " name:" + userName);
    }

    private void logI(String str) {
        this.log.i(TAG, str + " roomId:" + this.roomId + " uuid:" + this.uuid + " name:" + userName);
    }

    private void startCollectStreamLatency() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.reportStreamLatencyRunnable, 60000L);
    }

    private void stopCollectStreamLatency() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.reportStreamLatencyRunnable);
    }

    public void init(IQQLiveSDK iQQLiveSDK, AudienceRoomConfig audienceRoomConfig) {
        initUserInfo(iQQLiveSDK);
        this.initTime = System.currentTimeMillis();
        this.uuid = System.currentTimeMillis() + "#" + userId;
        this.info.initBaseInfo(BaseApplication.getContext(), iQQLiveSDK, this.uuid);
        initRoomInfo(audienceRoomConfig);
        logI("\u623f\u95f4\u4e0a\u62a5\u521d\u59cb\u5316");
    }

    public void onEnterRoomFailed(int i3, String str) {
        this.info.onEnterRoomFailure(i3, str);
        logI("\u8fdb\u623f\u5931\u8d25 code:" + i3 + " msg:" + str);
    }

    public void onEnterRoomStart() {
        logI("\u5f00\u59cb\u8fdb\u623f");
        this.startEnterRoomTime = System.currentTimeMillis();
    }

    public void onEnterRoomSuccess(LiveInfo liveInfo) {
        long j3;
        long currentTimeMillis = System.currentTimeMillis() - this.startEnterRoomTime;
        logI("\u8fdb\u623f\u6210\u529f \u8017\u65f6:" + currentTimeMillis + "ms");
        if (liveInfo != null) {
            LiveRoomInfo liveRoomInfo = liveInfo.roomInfo;
            if (liveRoomInfo != null) {
                this.info.setRoomInfo(liveRoomInfo.roomId, liveRoomInfo.roomName);
            }
            LiveAnchorInfo liveAnchorInfo = liveInfo.anchorInfo;
            if (liveAnchorInfo != null) {
                this.info.setAnchorInfo(liveAnchorInfo.uid, liveAnchorInfo.nickName);
            }
        }
        this.info.onEnterRoomSuccess(currentTimeMillis);
        StreamLatencyCalculator streamLatencyCalculator = this.streamLatencyCalculator;
        if (liveInfo == null) {
            j3 = System.currentTimeMillis();
        } else {
            j3 = liveInfo.nowTimeMs;
        }
        streamLatencyCalculator.onEnterRoom(j3);
    }

    @Override // b32.a
    public void onError(int i3, int i16, int i17, String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.startPlayTime;
        this.isStartPlay = false;
        String str2 = i3 + " " + i16 + " " + str;
        logI("\u64ad\u653e\u9519\u8bef code:" + i17 + " desc:" + str2);
        this.info.onPlayError(i17, str2, currentTimeMillis);
        stopCollectStreamLatency();
    }

    public void onExitRoomEnd(int i3, String str) {
        logI("\u9000\u623f\u7ed3\u675f code:" + i3 + " msg:" + str);
    }

    public void onExitRoomStart() {
        logI("\u5f00\u59cb\u9000\u623f");
        this.streamLatencyCalculator.onExitRoom();
        stopCollectStreamLatency();
    }

    @Override // b32.a
    public void onFirstFrameCome(long j3, long j16) {
        boolean z16;
        long j17;
        if (this.startPlayTime <= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (z16) {
            j17 = this.initTime;
        } else {
            j17 = this.startPlayTime;
        }
        long j18 = currentTimeMillis - j17;
        logI("\u9996\u5e27\u4e8b\u4ef6 \u8017\u65f6:" + j18 + "ms");
        this.info.onFirstFrameEvent(j18);
        startCollectStreamLatency();
    }

    @Override // b32.a
    public void onInfo(c cVar) {
        long seiServerTimeStamp = StreamSeiParser.getSeiServerTimeStamp(cVar);
        if (seiServerTimeStamp == 0) {
            return;
        }
        long streamLatency = this.streamLatencyCalculator.getStreamLatency(seiServerTimeStamp);
        addLatency(streamLatency);
        if (!this.streamLatencyReportedFirstTime && isLatencyValid(streamLatency)) {
            AudienceReportInfo audienceReportInfo = this.info;
            if (audienceReportInfo != null) {
                audienceReportInfo.onLatency((float) streamLatency);
            }
            this.streamLatencyReportedFirstTime = true;
        }
        logI("\u89c6\u9891\u6d41\u7aef\u5230\u7aef\u5ef6\u65f6: " + streamLatency);
    }

    @Override // b32.a
    public void onPause() {
        if (this.isPause) {
            return;
        }
        this.isPause = true;
        logI("\u64ad\u653e\u6682\u505c");
        this.info.onPlayPause();
    }

    @Override // b32.a
    public void onPlay() {
        if (this.isPause) {
            logI("\u6062\u590d\u64ad\u653e");
            this.info.onPlayResume();
        } else if (!this.isStartPlay) {
            logI("\u5f00\u59cb\u64ad\u653e url:" + this.mediaUrl);
            this.isStartPlay = true;
            this.info.onPlayStart(this.mediaUrl);
        }
        this.isPause = false;
        this.startBufferTime = 0L;
    }

    @Override // b32.a
    public void onPlayCompleted() {
        long currentTimeMillis = System.currentTimeMillis() - this.startPlayTime;
        this.isStartPlay = false;
        logI("\u64ad\u653e\u5b8c\u6210 \u64ad\u653e\u65f6\u957f:" + currentTimeMillis + "ms");
        this.info.onPlayEnd(currentTimeMillis);
        stopCollectStreamLatency();
    }

    @Override // b32.a
    public void onPreparing(StreamType streamType, String str, PlayerConfig playerConfig) {
        this.mediaUrl = str;
        this.startPlayTime = System.currentTimeMillis();
        logI("\u51c6\u5907\u64ad\u653e streamType:" + streamType + " url:" + str);
        this.info.onPlayPrepare(streamType, str);
    }

    @Override // b32.a
    public void onStartBuffer() {
        this.startBufferTime = System.currentTimeMillis();
        logI("\u5f00\u59cb\u7f13\u51b2");
        this.info.onBufferStart();
    }

    @Override // b32.a
    public void onStop() {
        if (this.startPlayTime <= 0) {
            this.startPlayTime = this.initTime;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.startPlayTime;
        this.isStartPlay = false;
        this.startBufferTime = 0L;
        logI("\u64ad\u653e\u505c\u6b62 \u64ad\u653e\u65f6\u957f:" + currentTimeMillis + "ms");
        this.info.onPlayEnd(currentTimeMillis);
        stopCollectStreamLatency();
    }

    @Override // b32.a
    public void onStopBuffer() {
        if (this.startBufferTime > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.startBufferTime;
            logI("\u7ed3\u675f\u7f13\u51b2 \u65f6\u957f:" + currentTimeMillis + "ms");
            this.info.onBufferEnd(currentTimeMillis);
            this.startBufferTime = 0L;
            return;
        }
        logE("\u7ed3\u675f\u7f13\u5b58 startBufferTime is error!");
    }

    @Override // b32.a
    public void onSwitchDefinition(EnterRoomInfo.VideoDefinition videoDefinition, String str) {
        this.mediaUrl = str;
        logI("\u5207\u6362\u6e05\u6670\u5ea6 \u6e05\u6670\u5ea6:" + videoDefinition + " url:" + str);
        this.info.onDefinitionChange(true);
    }

    @Override // b32.a
    public void onVideoSizeChanged(int i3, int i16) {
        String str = i3 + HippyTKDListViewAdapter.X + i16;
        this.info.onResolutionChange(this.mediaUrl, str);
        logI("\u5206\u8fa8\u7387\u53d1\u751f\u53d8\u5316:" + str);
    }

    public void setExtraData(Bundle bundle) {
        if (bundle != null) {
            this.clickTime = bundle.getLong(AEEditorConstants.VIDEO_CLIP_START_TIME, 0L);
            this.toolState = bundle.getString("tool_state");
        }
    }

    public void setMediaUrl(String str) {
        logI("\u8bbe\u7f6e\u64ad\u653e\u5730\u5740 url:" + str);
        this.mediaUrl = str;
    }

    public void reset() {
    }
}
