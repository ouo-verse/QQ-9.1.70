package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ExcitingTransferDownloadConfig {
    public long mSliceSize = 524288;
    public int uMaxParrallelSlice = 3;
    public int uMaxWaitingSlice = 30;
    public int uNotifyIntervals = 1000;
    public int uSpeedDuration = 2000;
    public int uSliceNum = 10;

    public String toString() {
        return "mSliceSize:" + this.mSliceSize + " uMaxParrallelSlice:" + this.uMaxParrallelSlice + " uMaxWaitingSlice:" + this.uMaxWaitingSlice + " uNotifyIntervals:" + this.uNotifyIntervals + " uSpeedDuration:" + this.uSpeedDuration + " uSliceNum:" + this.uSliceNum;
    }
}
