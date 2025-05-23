package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DecodeConfig {
    public int adjustRotation;
    public long endTimeMillSecond;
    public int height;
    public String inputFilePath;
    public boolean isLandscape;
    public boolean isLocal;
    public boolean noSleep;
    public long prolongToTime;
    public boolean repeat;
    public int rotation;
    public int speedType;
    public long startTimeMillSecond;
    public boolean syncDecode;
    public int width;

    public DecodeConfig() {
        this(null, 0, true, false);
    }

    public void copyFrom(DecodeConfig decodeConfig) {
        decodeConfig.getClass();
        this.inputFilePath = decodeConfig.inputFilePath;
        this.speedType = decodeConfig.speedType;
        this.noSleep = decodeConfig.noSleep;
        this.repeat = decodeConfig.repeat;
        this.startTimeMillSecond = decodeConfig.startTimeMillSecond;
        this.endTimeMillSecond = decodeConfig.endTimeMillSecond;
        this.prolongToTime = decodeConfig.prolongToTime;
        this.syncDecode = decodeConfig.syncDecode;
    }

    public String toString() {
        return "DecodeConfig{inputFilePath='" + this.inputFilePath + "', speedType=" + this.speedType + ", noSleep=" + this.noSleep + ", repeat=" + this.repeat + ", startTimeMillSecond=" + this.startTimeMillSecond + ", endTimeMillSecond=" + this.endTimeMillSecond + ", rotation=" + this.rotation + ", adjustRotation=" + this.adjustRotation + ", isLocal=" + this.isLocal + ",prolongToTime=" + this.prolongToTime + ",syncDecode=" + this.syncDecode + '}';
    }

    public String verify() {
        if (TextUtils.isEmpty(this.inputFilePath)) {
            return "inputFilePath is empty";
        }
        long j3 = this.startTimeMillSecond;
        if (j3 >= 0) {
            long j16 = this.endTimeMillSecond;
            if (j16 >= 0) {
                if (j16 < j3) {
                    return "end time less than start time, end=" + this.endTimeMillSecond + ", start=" + this.startTimeMillSecond;
                }
                return null;
            }
        }
        return "time less than 0, start=" + this.startTimeMillSecond + ", end=" + this.endTimeMillSecond;
    }

    public DecodeConfig(String str, int i3, boolean z16, boolean z17) {
        this(str, i3, z16, z17, 0L, 0L);
    }

    public DecodeConfig(String str, int i3, boolean z16, boolean z17, long j3, long j16) {
        this.syncDecode = false;
        this.rotation = 0;
        this.adjustRotation = 0;
        this.prolongToTime = -1L;
        this.inputFilePath = str;
        this.speedType = i3;
        this.noSleep = z17;
        this.repeat = z16;
        this.startTimeMillSecond = j3;
        this.endTimeMillSecond = j16;
    }
}
