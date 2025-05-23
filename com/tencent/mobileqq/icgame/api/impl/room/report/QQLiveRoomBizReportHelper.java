package com.tencent.mobileqq.icgame.api.impl.room.report;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.impl.room.BaseLiveRoom;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.report.i;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveRoomBizReportHelper {
    private static final long DEFAULT_HEART_DURATION = 5000;
    private static final String TAG = "ICGame_room_report";
    private IQQLiveSDK liveSDK;
    private ILiveRoom room;
    private String seq;
    private long uid;
    private i reportCallbackWrapper = new i();
    private Handler heartBeatHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
    private boolean isDestroy = false;
    private long lastHeartTime = 0;
    private long enterRoomTime = 0;
    private long heartDuration = 5000;
    private Runnable heartRunnable = new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.room.report.QQLiveRoomBizReportHelper.1
        @Override // java.lang.Runnable
        public void run() {
            QQLiveRoomBizReportHelper.this.reportRoomHeartForBiz();
        }
    };

    private void checkAndCreateSeq() {
        BaseRoomInfo roomInfo;
        if (this.uid <= 0) {
            try {
                this.uid = this.liveSDK.getLoginModule().getLoginInfo().uid;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
        if (!TextUtils.isEmpty(this.seq)) {
            return;
        }
        try {
            if (this.enterRoomTime <= 0) {
                this.enterRoomTime = System.currentTimeMillis();
            }
            ILiveRoom iLiveRoom = this.room;
            if (iLiveRoom == null || this.seq != null || (roomInfo = iLiveRoom.getRoomInfo()) == null) {
                return;
            }
            this.seq = roomInfo.getRoomId() + "_" + roomInfo.getProgramId() + "_" + this.enterRoomTime;
        } catch (Throwable th6) {
            QLog.e(TAG, 1, th6, new Object[0]);
        }
    }

    private String covertToString(HashMap<String, String> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                sb5.append("key:");
                sb5.append(entry.getKey());
                sb5.append(", value:");
                sb5.append(entry.getValue());
                sb5.append("\n");
            }
            return sb5.toString();
        }
        return "";
    }

    private void fillCommonReportInfo(HashMap<String, String> hashMap) {
        hashMap.put("key_room_uid", String.valueOf(this.uid));
        hashMap.put("key_room_app_id", this.liveSDK.getAppId());
        BaseAnchorInfo anchorInfo = this.room.getAnchorInfo();
        if (anchorInfo != null) {
            hashMap.put("key_room_anchor_id", String.valueOf(anchorInfo.getAnchorUid()));
        }
        BaseRoomInfo roomInfo = this.room.getRoomInfo();
        if (roomInfo != null) {
            hashMap.put("key_room_room_id", String.valueOf(roomInfo.getRoomId()));
            hashMap.put("key_room_program_id", String.valueOf(roomInfo.getProgramId()));
        }
        hashMap.put("key_room_seq", this.seq);
        hashMap.put("key_room_enter_time", String.valueOf(this.enterRoomTime));
        hashMap.put("key_room_window_mode", getRoomWindowMode());
    }

    private String getRoomWindowMode() {
        QQLiveCurRoomInfo curRoomInfo = this.liveSDK.getCurRoomInfo();
        BaseRoomInfo roomInfo = this.room.getRoomInfo();
        if (curRoomInfo != null && roomInfo != null && curRoomInfo.roomId == roomInfo.getRoomId()) {
            return String.valueOf(curRoomInfo.isFloatWindow ? 1 : 0);
        }
        return String.valueOf(0);
    }

    private void reportEnterRoomForBiz() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "reportEnterRoomForBiz");
        }
        try {
            if (this.seq == null) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            fillCommonReportInfo(hashMap);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "reportEnterRoomForBiz, data: " + covertToString(hashMap));
            }
            this.reportCallbackWrapper.a("event_room_enter", hashMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    private void reportExitRoomForBiz() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "reportExitRoomForBiz");
        }
        try {
            if (this.seq == null) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            fillCommonReportInfo(hashMap);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "reportExitRoomForBiz, data: " + covertToString(hashMap));
            }
            this.reportCallbackWrapper.a("event_room_exit", hashMap);
            if ((System.nanoTime() - this.lastHeartTime) / 1000000 < this.heartDuration) {
                reportRoomHeartForBiz();
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportRoomHeartForBiz() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "reportRoomHeartForBiz");
        }
        try {
            if (this.seq == null) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            fillCommonReportInfo(hashMap);
            long nanoTime = System.nanoTime();
            hashMap.put("key_room_duration", String.valueOf((nanoTime - this.lastHeartTime) / 1000000));
            this.lastHeartTime = nanoTime;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "reportRoomHeartForBiz, data: " + covertToString(hashMap));
            }
            this.reportCallbackWrapper.a("event_room_heart", hashMap);
            Runnable runnable = this.heartRunnable;
            if (runnable != null && !this.isDestroy) {
                this.heartBeatHandler.postDelayed(runnable, this.heartDuration);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public void clearReportCallback() {
        try {
            this.reportCallbackWrapper.b();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public void destroy() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "destroy");
        }
        this.isDestroy = true;
        reset();
        this.heartRunnable = null;
        this.liveSDK = null;
        this.room = null;
    }

    public long getEnterRoomTime() {
        return this.enterRoomTime;
    }

    public void init(IQQLiveSDK iQQLiveSDK, BaseLiveRoom baseLiveRoom) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "init");
        }
        if (iQQLiveSDK != null && baseLiveRoom != null) {
            this.liveSDK = iQQLiveSDK;
            this.room = baseLiveRoom;
        }
    }

    public void onEnterRoom() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onEnterRoom");
        }
        if (!this.isDestroy && this.liveSDK != null && this.room != null) {
            checkAndCreateSeq();
            reportEnterRoomForBiz();
        }
    }

    public void onExitRoom() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onExitRoom");
        }
        if (!this.isDestroy && this.liveSDK != null && this.room != null) {
            checkAndCreateSeq();
            reportExitRoomForBiz();
        }
    }

    public void registerReportCallback(com.tencent.mobileqq.qqlive.report.a aVar) {
        try {
            this.reportCallbackWrapper.c(aVar);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public void reset() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "reset");
        }
        stopRoomHeartForBiz();
        clearReportCallback();
        this.seq = null;
        this.lastHeartTime = 0L;
        this.enterRoomTime = 0L;
        this.heartDuration = 5000L;
    }

    public void setEnterRoomTime(long j3) {
        this.enterRoomTime = j3;
    }

    public void startRoomHeartForBiz(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "startRoomHeartForBiz");
        }
        try {
            if (!this.isDestroy && this.heartRunnable != null) {
                checkAndCreateSeq();
                if (j3 > 0) {
                    this.heartDuration = j3;
                }
                this.lastHeartTime = System.nanoTime();
                this.heartBeatHandler.postDelayed(this.heartRunnable, this.heartDuration);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public void stopRoomHeartForBiz() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "stopRoomHeartForBiz");
        }
        try {
            this.heartBeatHandler.removeCallbacksAndMessages(null);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public void unRegisterReportCallback(com.tencent.mobileqq.qqlive.report.a aVar) {
        try {
            this.reportCallbackWrapper.d(aVar);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }
}
