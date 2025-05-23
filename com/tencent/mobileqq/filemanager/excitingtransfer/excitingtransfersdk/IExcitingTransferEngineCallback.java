package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface IExcitingTransferEngineCallback {
    void onOneSlotComplete(long j3, int i3, ExcitingTransferOneSlotComplete excitingTransferOneSlotComplete);

    void onRecvComplete(long j3, int i3, ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo);

    void onRecvProgress(long j3, long j16, long j17, long j18);

    void onRecvStart(long j3);

    void onSendComplete(long j3, int i3, ExcitingTransferUploadResultRp excitingTransferUploadResultRp);

    void onSendProgress(long j3, long j16, long j17, long j18, long j19);

    void onSendStart(long j3);

    void onSpeed(long j3, ExcitingTransferDownloadSpeedInfo excitingTransferDownloadSpeedInfo);

    void onSubSenderResult(long j3, int i3, ExcitingTransferUploaderRp excitingTransferUploaderRp);
}
