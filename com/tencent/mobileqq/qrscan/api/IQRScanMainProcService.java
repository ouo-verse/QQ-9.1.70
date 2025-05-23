package com.tencent.mobileqq.qrscan.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.qrscan.ScannerParams;
import mqq.app.api.IRuntimeService;

@Service(process = {""})
/* loaded from: classes17.dex */
public interface IQRScanMainProcService extends IRuntimeService {
    void onScannerCreate(Context context, ScannerParams scannerParams);

    void onScannerDestroy();

    void onToolScannerActivityStateChanged(int i3);
}
