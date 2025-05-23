package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileDataReporter extends QRouteApi {
    void reportMultiPicTransferResult(FileTransNotifyInfo fileTransNotifyInfo);

    void reportZipPreviewListResult(boolean z16);
}
