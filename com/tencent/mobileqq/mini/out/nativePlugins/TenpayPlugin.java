package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.ark.ark;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IH5HbUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qwallet.pluginshare.ITenCookie;
import cooperation.qzone.QzoneIPCModule;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class TenpayPlugin implements NativePlugin {
    public static final String PLUGIN_NAME = "openTenpayView";
    public static final String PLUGIN_NAME_QWALLETBRIDGE = "qWalletBridge";
    public static final String TAG = "TenpayPlugin";
    private AppRuntime app;
    private JSContext jsContext;
    private QWalletPayJsPluginResultReceiver mRecevicer;
    private TenpayRecevicer payRecevicer;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes33.dex */
    public static class QWalletPayJsPluginResultReceiver extends ResultReceiver {
        protected JSContext mJsPlugin;

        public QWalletPayJsPluginResultReceiver(JSContext jSContext, Handler handler) {
            super(handler);
            this.mJsPlugin = jSContext;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            JSONObject grapHbResult;
            super.onReceiveResult(i3, bundle);
            if (QLog.isColorLevel()) {
                QLog.i(TenpayPlugin.TAG, 2, "resultCode = " + i3 + " resultData = " + bundle);
            }
            if (this.mJsPlugin == null || bundle == null || (grapHbResult = ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getGrapHbResult(i3, bundle, this.mJsPlugin.getActivity())) == null) {
                return;
            }
            this.mJsPlugin.evaluateCallback(true, grapHbResult, "");
        }
    }

    /* loaded from: classes33.dex */
    private final class TenpayRecevicer extends ResultReceiver {
        TenpayRecevicer(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            QLog.d(TenpayPlugin.TAG, 2, "onReceiveResult resultCode = " + i3 + " resultData = " + bundle);
            if (i3 != 0) {
                TenpayPlugin.this.jsContext.evaluateCallback(false, null, "error unkown!");
                return;
            }
            String string = bundle.getString("result");
            try {
                QLog.d(TenpayPlugin.TAG, 2, "json: " + string);
                JSONObject jSONObject = new JSONObject(string);
                TenpayPlugin.this.jsContext.evaluateCallback(jSONObject.optInt(QzoneIPCModule.RESULT_CODE, -1) == 0, jSONObject, jSONObject.optString("retmsg"));
            } catch (JSONException e16) {
                e16.printStackTrace();
                TenpayPlugin.this.jsContext.evaluateCallback(false, null, "error unkown!");
            }
        }
    }

    private void getHbResult(JSONObject jSONObject) throws Exception {
        String optString = jSONObject.optString("listid");
        String optString2 = jSONObject.optString("uin");
        if (!StringUtil.isEmpty(optString2) && optString2.equals(this.app.getCurrentAccountUin()) && !StringUtil.isEmpty(optString)) {
            String tempArgs = ((ITenCookie) QRoute.api(ITenCookie.class)).getTempArgs(optString);
            if (StringUtil.isEmpty(tempArgs)) {
                tempArgs = SharedPreferencesProxyManager.getInstance().getProxy("common_h5_hb_info" + optString2, 0).getString(optString, "");
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getHbResult dataStr: " + tempArgs);
            }
            JSONObject jSONObject2 = new JSONObject(tempArgs);
            if (jSONObject2.has("detail_data")) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("retcode", 0);
                jSONObject3.put("retmsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                jSONObject3.put("detail_data", jSONObject2.optJSONObject("detail_data"));
                this.jsContext.evaluateCallback(true, jSONObject3, "");
                return;
            }
            if (jSONObject2.has("exception_data")) {
                this.jsContext.evaluateCallback(true, jSONObject2.optJSONObject("exception_data"), "");
                return;
            } else {
                handJsError("-1001", "params error, detail_data is empty");
                return;
            }
        }
        handJsError("-1001", "params error,listid is empty or is not current user");
    }

    private void grapH5CommonHb(JSONObject jSONObject) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "grapH5CommonHb params: " + jSONObject);
            }
            JSONObject extraDataForGrapH5CommonHbResult = ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getExtraDataForGrapH5CommonHbResult(jSONObject);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "grapH5CommonHb extraData: " + extraDataForGrapH5CommonHbResult);
            }
            if (extraDataForGrapH5CommonHbResult != null) {
                ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getGrapH5CommonHbResult(extraDataForGrapH5CommonHbResult.toString(), this.mRecevicer);
            } else {
                handJsError("-1001", QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR);
            }
        } catch (Throwable th5) {
            handJsError("-1001", th5.getLocalizedMessage());
        }
    }

    private void handJsError(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handJsError: " + str2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retcode", str);
            jSONObject.put("retmsg", str2);
            this.jsContext.evaluateCallback(false, jSONObject, str2);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private boolean qWalletBridge(String str) {
        JSContext jSContext;
        try {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[qWalletBridge] paramStr: " + str);
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("action");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if ("graphb".equals(optString)) {
                grapH5CommonHb(optJSONObject);
            } else if ("getHbResult".equals(optString)) {
                getHbResult(optJSONObject);
            } else if ("refreshHbDetail".equals(optString)) {
                try {
                    ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getHbDetailInfo(optJSONObject, "redgiftH5CommonDetail", this.mRecevicer);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            } else {
                handJsError("-1001", "params exception: no match action");
            }
            if (jSONObject.optInt("closeWebView") == 1 && (jSContext = this.jsContext) != null && jSContext.getActivity() != null) {
                this.jsContext.getActivity().finish();
            }
        } catch (Exception e16) {
            handJsError("-1001", "params exception: " + e16.getLocalizedMessage());
        }
        return true;
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        this.jsContext = jSContext;
        if (jSContext != null) {
            try {
                this.app = ((BaseActivity) jSContext.getActivity()).getAppInterface();
                if (jSONObject == null) {
                    this.jsContext.evaluateCallback(false, null, HardCodeUtil.qqStr(R.string.u2o));
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, jSONObject.toString());
                }
                String optString = jSONObject.optString("api_name");
                if (optString.equals(PLUGIN_NAME)) {
                    this.payRecevicer = new TenpayRecevicer(new Handler(Looper.getMainLooper()));
                    QLog.e(TAG, 1, "param: " + jSONObject);
                    Bundle bundle = new Bundle();
                    bundle.putString(ark.ARKMETADATA_JSON, jSONObject.getString("data"));
                    bundle.putString("callbackSn", "0");
                    bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
                    if (PayBridgeActivity.tenpay(this.jsContext.getActivity(), 5, bundle, this.payRecevicer)) {
                        return;
                    }
                    this.jsContext.evaluateCallback(false, null, HardCodeUtil.qqStr(R.string.u2p));
                    return;
                }
                if (optString.equals(PLUGIN_NAME_QWALLETBRIDGE)) {
                    this.mRecevicer = new QWalletPayJsPluginResultReceiver(this.jsContext, new Handler(Looper.getMainLooper()));
                    qWalletBridge(jSONObject.optString("data"));
                    return;
                }
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                this.jsContext.evaluateCallback(false, null, HardCodeUtil.qqStr(R.string.u2o));
                return;
            }
        }
        QLog.i(TAG, 1, "js context is null");
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
