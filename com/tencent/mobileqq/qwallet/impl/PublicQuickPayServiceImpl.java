package com.tencent.mobileqq.qwallet.impl;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IPublicQuickPayService;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class PublicQuickPayServiceImpl implements IPublicQuickPayService {
    public static final String TAG = "PublicQuickPayService";
    private Dialog mCustomSingleButtonDialog;
    private BaseQQAppInterface mQQAppInterface;

    /* renamed from: com.tencent.mobileqq.qwallet.impl.PublicQuickPayServiceImpl$1, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass1 extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f278211d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IPublicQuickPayService.a f278212e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f278213f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ PublicQuickPayServiceImpl f278214h;

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            this.f278214h.onReceivePayResult(bundle, this.f278211d, this.f278212e, this.f278213f);
        }
    }

    private void doCallback(IPublicQuickPayService.a aVar, int i3, String str, String str2, String str3) {
        if (aVar != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("retCode", i3);
            bundle.putString("retMsg", str);
            bundle.putString("payTime", str2);
            bundle.putString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, str3);
            aVar.a(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReceivePayResult(Bundle bundle, Context context, IPublicQuickPayService.a aVar, String str) {
        String string = bundle.getString("result");
        int i3 = -2;
        if (!TextUtils.isEmpty(string)) {
            try {
                i3 = new JSONObject(string).optInt(QzoneIPCModule.RESULT_CODE, -2);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
        }
        int i16 = i3;
        if (i16 == -3 || i16 == -4 || i16 == -6) {
            showDialog(context);
        }
        doCallback(aVar, i16, bundle.getString("retmsg"), bundle.getString("payTime"), str);
    }

    private void showDialog(Context context) {
        Dialog dialog = this.mCustomSingleButtonDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mCustomSingleButtonDialog.dismiss();
        }
        Dialog createNewUpgradeYYBInstalledDialog = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).createNewUpgradeYYBInstalledDialog(context, HardCodeUtil.qqStr(R.string.pnr), "", HardCodeUtil.qqStr(R.string.e4i), new a(), null, null);
        this.mCustomSingleButtonDialog = createNewUpgradeYYBInstalledDialog;
        createNewUpgradeYYBInstalledDialog.show();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mQQAppInterface = (BaseQQAppInterface) appRuntime;
    }

    @Override // com.tencent.mobileqq.qwallet.IPublicQuickPayService
    public boolean publicQuickPay(String str, JSONObject jSONObject, Context context, IPublicQuickPayService.a aVar) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            showDialog(context);
            doCallback(aVar, -4, "auth failed!", null, null);
            return false;
        }
        QLog.e(TAG, 2, "jsonParams=" + jSONObject + ", puin=" + str);
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
