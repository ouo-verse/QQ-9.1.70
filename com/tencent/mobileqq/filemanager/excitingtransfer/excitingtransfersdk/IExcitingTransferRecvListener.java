package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface IExcitingTransferRecvListener {
    void onOneSlotComplete(int i3, ExcitingTransferOneSlotComplete excitingTransferOneSlotComplete);

    void onRecvComplete(int i3, ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo);

    void onRecvProgress(long j3, long j16, long j17);

    void onRecvStart();

    void onSpeed(ExcitingTransferDownloadSpeedInfo excitingTransferDownloadSpeedInfo);
}
