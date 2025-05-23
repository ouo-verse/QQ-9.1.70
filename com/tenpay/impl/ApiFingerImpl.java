package com.tenpay.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessKeyPreparationResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessNoExtResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessResultBase;
import com.tencent.soter.wrapper.wrap_task.InitializeParam;
import com.tenpay.QwLog;
import com.tenpay.api.IApiFinger;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.FingerNet.GetSupportSoterNet;
import com.tenpay.sdk.FingerNet.PrepareASkData;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.util.QwLog4Soter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiFingerImpl implements IApiFinger {
    public static final int FLG_OPENED = 3;
    public static final int FLG_OPENED_ON_OTHER_PHONE = 6;
    public static final int FLG_OVER_PAY_LIMIT = 4;
    public static final int FLG_ROOT_UNSUPPORT = 5;
    public static final int FLG_SUPPORT = 2;
    public static final int FLG_UNKOWN = 0;
    public static final int FLG_UNSUPPORT = 1;
    public static final int FLG_VALIDATE_ERROR = 7;
    private static final String TAG = "ApiFingerImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initFingerASK$0(ResultReceiver resultReceiver, SoterProcessNoExtResult soterProcessNoExtResult) {
        QLog.i(TAG, 1, "get is support soter done. result: " + soterProcessNoExtResult);
        if ((soterProcessNoExtResult.isSuccess() || soterProcessNoExtResult.errCode == 1028) && SoterWrapperApi.isSupportSoter()) {
            prepareASK(resultReceiver);
        } else {
            resultReceiver.send(-1, new Bundle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$prepareASK$1(ResultReceiver resultReceiver, SoterProcessKeyPreparationResult soterProcessKeyPreparationResult) {
        if (QLog.isColorLevel()) {
            QwLog.i("ASK\u83b7\u53d6\u6210\u529f result: " + soterProcessKeyPreparationResult);
        } else {
            QLog.i(TAG, 1, "ASK\u83b7\u53d6\u6210\u529f result: " + soterProcessKeyPreparationResult.getErrCode() + soterProcessKeyPreparationResult.getErrMsg());
        }
        if (soterProcessKeyPreparationResult.isSuccess()) {
            resultReceiver.send(0, null);
        } else {
            resultReceiver.send(-1, null);
        }
        VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "fingerprint.get.askey", null, null, soterProcessKeyPreparationResult.errCode, soterProcessKeyPreparationResult.errMsg);
    }

    private void prepareASK(final ResultReceiver resultReceiver) {
        try {
            SoterWrapperApi.prepareAppSecureKey(new SoterProcessCallback() { // from class: com.tenpay.impl.a
                @Override // com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback
                public final void onResult(SoterProcessResultBase soterProcessResultBase) {
                    ApiFingerImpl.lambda$prepareASK$1(resultReceiver, (SoterProcessKeyPreparationResult) soterProcessResultBase);
                }
            }, false, new PrepareASkData());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "ASK\u83b7\u53d6\u5931\u8d25  crash\uff1a", e16);
            resultReceiver.send(-1, null);
        }
    }

    @Override // com.tenpay.api.IApiFinger
    public void closeFingerPay(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedHelper.closeFinger(str);
    }

    @Override // com.tenpay.api.IApiFinger
    public void initFingerASK(Context context, HashMap<String, String> hashMap, final ResultReceiver resultReceiver) {
        try {
            SoterWrapperApi.init(context.getApplicationContext(), new SoterProcessCallback() { // from class: com.tenpay.impl.b
                @Override // com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback
                public final void onResult(SoterProcessResultBase soterProcessResultBase) {
                    ApiFingerImpl.this.lambda$initFingerASK$0(resultReceiver, (SoterProcessNoExtResult) soterProcessResultBase);
                }
            }, new InitializeParam.InitializeParamBuilder().setGetSupportNetWrapper(new GetSupportSoterNet(context, hashMap)).setScenes(Cgi.scene_FingerPay).setDistinguishSalt(hashMap.get("uin")).setSoterLogger(QwLog4Soter.getInstance()).build());
        } catch (Exception | OutOfMemoryError e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    @Override // com.tenpay.api.IApiBase
    public void init(Context context) {
    }
}
