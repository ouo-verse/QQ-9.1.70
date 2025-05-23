package com.tencent.qzonehub.api.impl;

import android.os.ResultReceiver;
import com.tencent.qzonehub.api.DownloadResultCallback;
import com.tencent.qzonehub.api.IQzoneVideoSoDownloadModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneVideoSoDownloadModuleImpl implements IQzoneVideoSoDownloadModule {
    @Override // com.tencent.qzonehub.api.IQzoneVideoSoDownloadModule
    public ResultReceiver getReceiverForSending(DownloadResultCallback downloadResultCallback) {
        return QzoneVideoSoDownloadModule.getReceiverForSending(downloadResultCallback);
    }
}
