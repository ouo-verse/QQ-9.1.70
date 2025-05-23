package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ActionRecorder {
    private static final int MAX_RECORD_LENGTH = 3400;
    private static final int MIN_SEEK_RANGE = 500;
    private static final String TAG = "video.ActionRecorder";
    private float lastSpeedRatio = 1.0f;
    private long lastSpeedRatioPosition = 0;
    private String seekRecord = "";
    private String speedRatioRecord = "";

    private void appendSeekRecord(long j3, long j16) {
        String str = "";
        if (!TextUtils.isEmpty(this.seekRecord)) {
            str = "|";
        }
        String str2 = str + j3 + "-" + j16;
        if (str2.length() + this.seekRecord.length() > MAX_RECORD_LENGTH) {
            return;
        }
        this.seekRecord += str2;
        Log.d(TAG, "appendSeekRecord(), seekRecord: " + this.seekRecord);
    }

    private void appendSpeedRatioRecord(float f16, long j3, long j16) {
        String str = "";
        if (!TextUtils.isEmpty(this.speedRatioRecord)) {
            str = "|";
        }
        String str2 = str + f16 + "-" + j3 + "-" + j16;
        if (str2.length() + this.speedRatioRecord.length() > MAX_RECORD_LENGTH) {
            return;
        }
        this.speedRatioRecord += str2;
        Log.d(TAG, "appendSpeedRatioRecord(), speedRatioRecord: " + this.speedRatioRecord);
    }

    private void resetSeekRecord() {
        this.seekRecord = "";
    }

    private void resetSpeedRatioRecord() {
        this.speedRatioRecord = "";
    }

    public synchronized void end(long j3) {
        float f16 = this.lastSpeedRatio;
        if (f16 != 1.0f) {
            appendSpeedRatioRecord(f16, this.lastSpeedRatioPosition, j3);
            this.lastSpeedRatioPosition = j3;
        }
    }

    public String getSeekRecord() {
        return this.seekRecord;
    }

    public String getSpeedRatioRecord() {
        return this.speedRatioRecord;
    }

    public synchronized void seekTo(long j3, long j16) {
        if (Math.abs(j16 - j3) < 500) {
            return;
        }
        appendSeekRecord(j3, j16);
    }

    public synchronized void speedRatioPlay(float f16, long j3) {
        float f17 = this.lastSpeedRatio;
        if (f16 == f17) {
            return;
        }
        if (f17 != 1.0f) {
            appendSpeedRatioRecord(f17, this.lastSpeedRatioPosition, j3);
        }
        this.lastSpeedRatio = f16;
        this.lastSpeedRatioPosition = j3;
    }

    public synchronized void start(long j3, float f16) {
        this.lastSpeedRatio = f16;
        this.lastSpeedRatioPosition = j3;
        resetSeekRecord();
        resetSpeedRatioRecord();
    }
}
