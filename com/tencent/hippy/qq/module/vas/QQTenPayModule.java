package com.tencent.hippy.qq.module.vas;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.api.IVipPayApi;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qwallet.plugin.IQWalletHelper;

@HippyNativeModule(name = QQTenPayModule.TAG)
/* loaded from: classes7.dex */
public class QQTenPayModule extends QQBaseModule {
    static final String TAG = "QQTenPayModule";
    private final String METHOD_BUYGOODS;
    private final String METHOD_OPENSERVICE;
    private final String METHOD_PAY_SUBSCRIBE;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes7.dex */
    public static class VasHippyResultRecevicer extends ResultReceiver {
        private final Promise mPromise;

        public VasHippyResultRecevicer(Promise promise, Handler handler) {
            super(handler);
            this.mPromise = promise;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            if (QLog.isColorLevel()) {
                QLog.i(QQTenPayModule.TAG, 2, "VasHippyResultReceiver receive = " + this);
                QLog.i(QQTenPayModule.TAG, 2, "resultCode = " + i3 + " resultData = " + bundle);
            }
            if (this.mPromise != null && bundle != null) {
                if (i3 == 7 || i3 == 4 || i3 == 14) {
                    String string = bundle.getString("callbackSn");
                    String string2 = bundle.getString("result");
                    if (!TextUtils.isEmpty(string) && string.equals(this.mPromise.getCallId())) {
                        this.mPromise.resolve(string2);
                        return;
                    }
                    QLog.e(QQTenPayModule.TAG, 1, "callbackSn wrong, callbackSn= " + string);
                    this.mPromise.reject("callbackSn wrong");
                    return;
                }
                return;
            }
            QLog.e(QQTenPayModule.TAG, 1, "handle result error, promise = " + this.mPromise + " resultData = " + bundle);
        }
    }

    public QQTenPayModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.METHOD_OPENSERVICE = "openService";
        this.METHOD_BUYGOODS = IVipPayApi.METHOD_BUYGOODS;
        this.METHOD_PAY_SUBSCRIBE = IVipPayApi.METHOD_PAY_SUBSCRIBE;
    }

    private void invokeNewPay(String str, String str2, Promise promise, int i3, String str3) {
        String string;
        long currentTimeMillis = System.currentTimeMillis();
        String appInfoFromHistory = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getAppInfoFromHistory(null);
        Bundle bundle = new Bundle();
        bundle.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, promise.getCallId());
        bundle.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, str);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, currentTimeMillis);
        bundle.putString(PayProxy.Source.PAY_URL_APPINFO_EXTRA_KEY, appInfoFromHistory);
        bundle.putString("payparmas_h5_url", str2);
        Bundle newPay = PayBridgeActivity.newPay(getAppInterface(), getActivity(), new VasHippyResultRecevicer(promise, new Handler()), i3, bundle);
        if (newPay.getInt("retCode", -1) != 0 && (string = newPay.getString("retJson")) != null) {
            promise.resolve(string);
        }
    }

    @HippyMethod(name = IVipPayApi.METHOD_BUYGOODS)
    public void buyGoods(String str, String str2, Promise promise) {
        invokeNewPay(str, str2, promise, 7, IVipPayApi.METHOD_BUYGOODS);
    }

    @HippyMethod(name = "openService")
    public void openService(String str, String str2, Promise promise) {
        invokeNewPay(str, str2, promise, 4, "openService");
    }

    @HippyMethod(name = IVipPayApi.METHOD_PAY_SUBSCRIBE)
    public void paySubscribe(String str, String str2, Promise promise) {
        invokeNewPay(str, str2, promise, 14, IVipPayApi.METHOD_PAY_SUBSCRIBE);
    }
}
