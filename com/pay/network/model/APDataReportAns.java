package com.pay.network.model;

import com.pay.http.APBaseHttpAns;
import com.pay.http.APBaseHttpReq;
import com.pay.http.APHttpHandle;
import com.pay.http.IAPHttpAnsObserver;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class APDataReportAns extends APBaseHttpAns {
    public APDataReportAns(APHttpHandle aPHttpHandle, IAPHttpAnsObserver iAPHttpAnsObserver, HashMap<String, APBaseHttpReq> hashMap, String str) {
        super(aPHttpHandle, iAPHttpAnsObserver, hashMap, str);
    }

    private void progressJson(byte[] bArr, APBaseHttpReq aPBaseHttpReq) {
        APLog.i("MidasPlugin.jar APDataReportAns", "report ok");
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onFinishAns(byte[] bArr, APBaseHttpReq aPBaseHttpReq) {
        progressJson(bArr, aPBaseHttpReq);
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onErrorAns(APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStartAns(APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStopAns(APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onReceiveAns(byte[] bArr, int i3, long j3, APBaseHttpReq aPBaseHttpReq) {
    }
}
