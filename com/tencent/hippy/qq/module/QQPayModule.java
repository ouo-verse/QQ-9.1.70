package com.tencent.hippy.qq.module;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qwallet.plugin.IQWalletHelper;
import org.json.JSONObject;

@HippyNativeModule(name = QQPayModule.TAG)
/* loaded from: classes7.dex */
public class QQPayModule extends QQBaseModule {
    private static final String METHOD_BUYGOODS = "buyGoods";
    private static final String METHOD_OPENSERVICE = "openService";
    private static final String METHOD_PAY_SUBSCRIBE = "paySubscribe";
    public static final String TAG = "QQPayModule";

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes7.dex */
    public static class VasHippyResultReceiver extends ResultReceiver {
        private final Promise mPromise;

        public VasHippyResultReceiver(Promise promise, Handler handler) {
            super(handler);
            this.mPromise = promise;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            if (QLog.isColorLevel()) {
                QLog.i(QQPayModule.TAG, 2, "resultCode = " + i3 + " resultData = " + bundle);
            }
            if (this.mPromise != null && bundle != null) {
                if (i3 == 7 || i3 == 4 || i3 == 14) {
                    String string = bundle.getString("callbackSn");
                    String string2 = bundle.getString("result");
                    if (!TextUtils.isEmpty(string) && string.equals(this.mPromise.getCallId())) {
                        this.mPromise.resolve(string2);
                        return;
                    }
                    QLog.e(QQPayModule.TAG, 1, "callbackSn wrong, callbackSn= " + string);
                    this.mPromise.reject("callbackSn wrong");
                    return;
                }
                return;
            }
            QLog.e(QQPayModule.TAG, 1, "handle result error, promise = " + this.mPromise + " resultData = " + bundle);
        }
    }

    public QQPayModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private void invokeNewPay(String str, Promise promise, int i3) {
        String string;
        long currentTimeMillis = System.currentTimeMillis();
        String appInfoFromHistory = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getAppInfoFromHistory(null);
        Bundle bundle = new Bundle();
        bundle.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, promise.getCallId());
        bundle.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, str);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, currentTimeMillis);
        bundle.putString(PayProxy.Source.PAY_URL_APPINFO_EXTRA_KEY, appInfoFromHistory);
        Bundle newPay = PayBridgeActivity.newPay(getAppInterface(), getActivity(), new VasHippyResultReceiver(promise, new Handler()), i3, bundle);
        if (newPay.getInt("retCode", -1) != 0 && (string = newPay.getString("retJson")) != null) {
            promise.resolve(string);
        }
    }

    @HippyMethod(name = "buyGoods")
    public void buyGoods(HippyMap hippyMap, Promise promise) {
        JSONObject jSONObject;
        QLog.i(TAG, 1, "[buyGoods]");
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        invokeNewPay(jSONObject.toString(), promise, 7);
    }

    @HippyMethod(name = METHOD_OPENSERVICE)
    public void openService(String str, String str2, Promise promise) {
        invokeNewPay(str, promise, 4);
    }

    @HippyMethod(name = "paySubscribe")
    public void paySubscribe(String str, Promise promise) {
        invokeNewPay(str, promise, 14);
    }
}
