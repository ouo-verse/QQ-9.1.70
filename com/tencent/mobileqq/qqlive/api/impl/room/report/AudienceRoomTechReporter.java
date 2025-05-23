package com.tencent.mobileqq.qqlive.api.impl.room.report;

import android.os.Bundle;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.thumbplayer.report.reportv2.TPReportEventId;
import ft3.c;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AudienceRoomTechReporter extends AudienceRoomPlayerListener implements EnterAudienceRoomCallback, ExitRoomCallback {
    static IPatchRedirector $redirector_ = null;
    public static final long PERIOD_REPORT_INTERVAL = 10000;
    public static final String TAG = "AudienceRoomTechReporter";
    private int blockCostTime;
    private final AtomicLong blockCostTimeInPeriod;
    private int blockCount;
    private final AtomicInteger blockCountInPeriod;
    private long blockStartTime;
    private long clickTime;
    private long enterRoomTime;
    private long initTime;
    private final AtomicBoolean isPeriodReporting;
    private final AtomicLong lastPeriodReportTime;
    private String mediaUrl;
    private final Runnable periodReportTask;
    private int protoType;
    private String resolution;
    private IQQLiveSDK sdk;
    private long startEnterRoomTime;
    private long startPlayTime;
    private String toolState;

    public AudienceRoomTechReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isPeriodReporting = new AtomicBoolean(false);
        this.lastPeriodReportTime = new AtomicLong(0L);
        this.blockCountInPeriod = new AtomicInteger(0);
        this.blockCostTimeInPeriod = new AtomicLong(0L);
        this.periodReportTask = new Runnable() { // from class: com.tencent.mobileqq.qqlive.api.impl.room.report.AudienceRoomTechReporter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudienceRoomTechReporter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (AudienceRoomTechReporter.this.isPeriodReporting.get()) {
                    AudienceRoomTechReporter.this.doPeriodReport(0, "");
                    ThreadManager.getSubThreadHandler().postDelayed(AudienceRoomTechReporter.this.periodReportTask, 10000L);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPeriodReport(int i3, String str) {
        getAudienceReportTask(TPReportEventId.TP_REPORT_EVENT_LIVE_PERIOD).addKeyValue(TPReportKeys.LiveExKeys.LIVE_EX_BLOCK_COUNT, this.blockCountInPeriod.get()).addKeyValue(TPReportKeys.LiveExKeys.LIVE_EX_BLOCK_TIME, this.blockCostTimeInPeriod.get()).addKeyValue("period", System.currentTimeMillis() - this.lastPeriodReportTime.get()).addKeyValue("errorcode", i3).addKeyValue("errormsg", str).send();
        this.lastPeriodReportTime.set(System.currentTimeMillis());
        this.blockCountInPeriod.set(0);
        this.blockCostTimeInPeriod.set(0L);
    }

    private c getAudienceReportTask(String str) {
        return this.sdk.getDataReportModule().newReportTask().a(str).addKeyValue("url", this.mediaUrl).addKeyValue("videocodec", 1).addKeyValue("videotrans", this.protoType).addKeyValue("videoresolution", this.resolution).b("AudienceRoom");
    }

    private void onEnterRoomEnd(int i3, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.enterRoomTime = currentTimeMillis;
        getAudienceReportTask("enter_room").addKeyValue("errorcode", i3).addKeyValue("errormsg", str).addKeyValue("costtime", currentTimeMillis - this.startEnterRoomTime).send();
        startPeriodReport();
    }

    private void onExitRoomEnd(int i3, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        getAudienceReportTask("exit_room").addKeyValue("errorcode", i3).addKeyValue("errormsg", str).addKeyValue(TPReportKeys.PlayerStep.PLAYER_START_TIME, this.enterRoomTime).addKeyValue(TPReportKeys.PlayerStep.PLAYER_END_TIME, currentTimeMillis).addKeyValue("costtime", currentTimeMillis - this.enterRoomTime).addKeyValue(TPReportKeys.LiveExKeys.LIVE_EX_BLOCK_COUNT, this.blockCount).addKeyValue(TPReportKeys.LiveExKeys.LIVE_EX_BLOCK_TIME, this.blockCostTime).send();
    }

    private void onPlayEnd(int i3, String str) {
        this.blockCount = 0;
        this.blockCostTime = 0;
        this.resolution = "";
        doPeriodReport(i3, str);
        stopPeriodReport();
    }

    private void reportFirstFrame() {
        long currentTimeMillis = System.currentTimeMillis();
        QQLiveCurRoomInfo curRoomInfo = this.sdk.getCurRoomInfo();
        if (curRoomInfo != null) {
            long j3 = 0;
            if (this.clickTime > 0) {
                HashMap hashMap = new HashMap();
                LoginInfo loginInfo = this.sdk.getLoginModule().getLoginInfo();
                if (loginInfo != null) {
                    j3 = loginInfo.uid;
                }
                hashMap.put("qqlive_user_id", Long.valueOf(j3));
                hashMap.put("qqlive_logined_when_enter", 0);
                hashMap.put("qqlive_room_id", Long.valueOf(curRoomInfo.roomId));
                hashMap.put("qqlive_zhibo_type", 0);
                hashMap.put("qqlive_click_to_play_cost", Long.valueOf(currentTimeMillis - this.clickTime));
                hashMap.put("qqlive_tool_state", this.toolState);
                hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND06MK9E48EOTF");
                VideoReport.reportEvent("ev_qqlive_click_to_first_frame", hashMap);
                this.clickTime = -1L;
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "report qqlive_click_to_play_cost: " + hashMap);
                }
            }
        }
    }

    private void startPeriodReport() {
        this.isPeriodReporting.set(true);
        this.lastPeriodReportTime.set(System.currentTimeMillis());
        ThreadManager.getSubThreadHandler().postDelayed(this.periodReportTask, 10000L);
    }

    private void stopPeriodReport() {
        this.isPeriodReporting.set(false);
        ThreadManager.getSubThreadHandler().removeCallbacks(this.periodReportTask);
    }

    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
        } else {
            this.sdk = iQQLiveSDK;
            this.initTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback
    public void onComplete(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) str);
            return;
        }
        onExitRoomEnd(i3, str);
        this.mediaUrl = "";
        this.protoType = 0;
    }

    public void onEnterRoomStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.startEnterRoomTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
    public void onError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3, (Object) str);
        } else {
            onPlayEnd(i3, str);
            getAudienceReportTask("play_error").addKeyValue("errorcode", i3).addKeyValue("errormsg", str).send();
        }
    }

    public void onExitRoomStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            stopPeriodReport();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback
    public void onFailed(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
        } else {
            onEnterRoomEnd(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
    public void onFirstFrameCome(long j3, long j16) {
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (this.startPlayTime > 0) {
            i3 = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 != 0) {
            j17 = this.initTime;
        } else {
            j17 = this.startPlayTime;
        }
        getAudienceReportTask("play_start").addKeyValue("firstframetime", currentTimeMillis - j17).addKeyValue("ispreload", i3).send();
        reportFirstFrame();
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
    public void onPlay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.startPlayTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
    public void onPlayCompleted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            onPlayEnd(0, "");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
    public void onStartBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.blockStartTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
    public void onStopBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.blockStartTime;
        this.blockCostTime = (int) (this.blockCostTime + currentTimeMillis);
        this.blockCount++;
        this.blockCostTimeInPeriod.addAndGet(currentTimeMillis);
        this.blockCountInPeriod.incrementAndGet();
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback
    public void onSuccess(LiveInfo liveInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) liveInfo);
            return;
        }
        this.mediaUrl = liveInfo.watchMediaInfo.getMediaUrl();
        this.protoType = liveInfo.watchMediaInfo.getProtoType();
        onEnterRoomEnd(0, "");
    }

    @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
    public void onVideoSizeChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.resolution = i3 + "_" + i16;
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public void setExtraData(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
        } else if (bundle != null) {
            this.clickTime = bundle.getLong(AEEditorConstants.VIDEO_CLIP_START_TIME, 0L);
            this.toolState = bundle.getString("tool_state");
        }
    }

    public void setMediaUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mediaUrl = str;
        }
    }
}
