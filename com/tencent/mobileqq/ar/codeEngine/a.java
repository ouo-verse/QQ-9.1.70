package com.tencent.mobileqq.ar.codeEngine;

import android.os.Handler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IQRCodeApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    boolean f198345a = false;

    /* renamed from: b, reason: collision with root package name */
    Handler f198346b;

    public a(Handler handler) {
        this.f198346b = handler;
    }

    public int a() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int initForCamera = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).initForCamera(1, "ANY", "UTF-8");
            int readersForCamera = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).setReadersForCamera(((IQRCodeApi) QRoute.api(IQRCodeApi.class)).getSupportReader());
            String version = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).getVersion();
            if (QLog.isColorLevel()) {
                QLog.d("QRSession.QRRecog", 2, String.format("initQbar time cost:%sms, initResult=%s readerResult=%s version=%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(initForCamera), Integer.valueOf(readersForCamera), version));
            }
            this.f198345a = true;
            return 0;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QRSession.QRRecog", 2, "initQbar fail!", e16);
                return -1;
            }
            return -1;
        }
    }

    public boolean b(byte[] bArr, int i3, int i16, ScannerResult scannerResult) {
        ArrayList<QBarResult> arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        if (((IQRCodeApi) QRoute.api(IQRCodeApi.class)).scanImageForCamera(bArr, i3, i16) == 1) {
            arrayList = ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).getResultForCamera();
            scannerResult.f276520d = arrayList;
        } else {
            arrayList = null;
        }
        if (QLog.isColorLevel()) {
            if (scannerResult.l()) {
                QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR suc. results=%s qrRecog minicode_timecost=%d", arrayList, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            } else {
                QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR failed. hasQR=%s qrAreaRatio=%s qrRecog minicode_timecost=%d", Boolean.FALSE, Float.valueOf(0.0f), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            }
        }
        return scannerResult.l();
    }

    public void c() {
        try {
            if (this.f198345a) {
                ((IQRCodeApi) QRoute.api(IQRCodeApi.class)).releaseForCamera();
                this.f198345a = false;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QRSession.QRRecog", 2, "unInitQbar fail!", e16);
            }
        }
    }
}
