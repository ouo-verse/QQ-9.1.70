package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface IExcitingTransferSendListener {
    void onExcitingSendProgress(long j3, long j16, long j17);

    void onExcitingSendResult(boolean z16, int i3, ExcitingTransferUploadResultRp excitingTransferUploadResultRp);

    void onExcitingSendStart();

    void onExcitingSubSenderResult(int i3, ExcitingTransferUploaderRp excitingTransferUploaderRp);
}
