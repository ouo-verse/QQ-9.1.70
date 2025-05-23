package com.tencent.mobileqq.qrcode.processor;

import android.text.TextUtils;
import com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.dt.api.ScanPicData;
import com.tencent.mobileqq.dt.api.e;
import com.tencent.mobileqq.qrcode.processor.O3QRProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.api.IScanCacheApi;
import com.tencent.mobileqq.qrscan.k;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J.\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000f\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qrcode/processor/O3QRProcessor;", "Lcom/tencent/biz/qrcode/processor/BaseQRScanResultProcessor;", "", "result", "Lcom/tencent/mobileqq/qrscan/ScannerParams;", "scannerParams", "cameraDataPath", "", "o", "getName", "", "type", "qBarType", "", "a", "k", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/qrscan/k;", "onQRHandleResultCallback", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/qrscan/k;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class O3QRProcessor extends BaseQRScanResultProcessor {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O3QRProcessor(AppRuntime appRuntime, k onQRHandleResultCallback) {
        super(appRuntime, onQRHandleResultCallback);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(onQRHandleResultCallback, "onQRHandleResultCallback");
    }

    private final void o(String result, ScannerParams scannerParams, String cameraDataPath) {
        QLog.i(getName(), 1, "[handleQRResultInternal] result=" + result);
        if (TextUtils.isEmpty(result)) {
            return;
        }
        String str = scannerParams != null ? scannerParams.f276517h : null;
        if (str == null || str.length() == 0) {
            QLog.i(getName(), 1, "cameraDataPath is " + cameraDataPath);
            IDTAPI idtapi = (IDTAPI) QRoute.api(IDTAPI.class);
            e eVar = new e();
            eVar.f203664a = cameraDataPath;
            eVar.f203665b = result;
            idtapi.scanCameraSecurity(eVar);
            return;
        }
        QLog.i(getName(), 1, "localPhotoPath is " + ((Object) str));
        ScanPicData scanPicData = scannerParams != null ? scannerParams.H : null;
        if (scanPicData == null) {
            QLog.e(getName(), 1, "scanPicData is null");
        } else {
            scanPicData.v(result);
            ((IDTAPI) QRoute.api(IDTAPI.class)).scanPressSecurityReport(scanPicData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(O3QRProcessor this$0, String str, ScannerParams scannerParams, String str2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o(str, scannerParams, str2);
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor, com.tencent.mobileqq.qrscan.f
    public boolean a(int type, final String result, String qBarType, final ScannerParams scannerParams) {
        final String tempCameraDataPath = ((IScanCacheApi) QRoute.api(IScanCacheApi.class)).getTempCameraDataPath();
        ThreadManagerV2.excute(new Runnable() { // from class: lk2.a
            @Override // java.lang.Runnable
            public final void run() {
                O3QRProcessor.p(O3QRProcessor.this, result, scannerParams, tempCameraDataPath);
            }
        }, 16, null, false);
        return false;
    }

    @Override // com.tencent.mobileqq.qrscan.f
    public String getName() {
        return "O3QRProcessor";
    }

    @Override // com.tencent.biz.qrcode.processor.BaseQRScanResultProcessor
    protected boolean k(String result, String qBarType, ScannerParams scannerParams) {
        return false;
    }
}
