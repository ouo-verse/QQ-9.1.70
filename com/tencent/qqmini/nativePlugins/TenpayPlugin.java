package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.ark.ark;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IH5HbUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qwallet.pluginshare.ITenCookie;
import cooperation.qzone.QzoneIPCModule;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class TenpayPlugin extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private TenpayRecevicer f346955d;

    /* renamed from: e, reason: collision with root package name */
    private QWalletPayJsPluginResultReceiver f346956e;

    /* renamed from: f, reason: collision with root package name */
    private AppInterface f346957f;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes34.dex */
    public static class QWalletPayJsPluginResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        protected RequestEvent f346958d;

        /* renamed from: e, reason: collision with root package name */
        private AppInterface f346959e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<Activity> f346960f;

        public QWalletPayJsPluginResultReceiver(RequestEvent requestEvent, Handler handler, AppInterface appInterface, WeakReference<Activity> weakReference) {
            super(handler);
            this.f346958d = requestEvent;
            this.f346959e = appInterface;
            this.f346960f = weakReference;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            WeakReference<Activity> weakReference;
            JSONObject grapHbResult;
            super.onReceiveResult(i3, bundle);
            if (QLog.isColorLevel()) {
                QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TAG, 2, "resultCode = " + i3 + " resultData = " + bundle);
            }
            if (this.f346958d == null || bundle == null || (weakReference = this.f346960f) == null || weakReference.get() == null || (grapHbResult = ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getGrapHbResult(i3, bundle, this.f346960f.get())) == null) {
                return;
            }
            this.f346958d.ok(grapHbResult);
        }
    }

    /* loaded from: classes34.dex */
    private final class TenpayRecevicer extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private RequestEvent f346961d;

        TenpayRecevicer(RequestEvent requestEvent, Handler handler) {
            super(handler);
            this.f346961d = requestEvent;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            QLog.d(com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TAG, 2, "onReceiveResult resultCode = " + i3 + " resultData = " + bundle);
            if (i3 != 0) {
                this.f346961d.fail("error unkown!");
                return;
            }
            String string = bundle.getString("result");
            try {
                QLog.d(com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TAG, 2, "json: " + string);
                JSONObject jSONObject = new JSONObject(string);
                int optInt = jSONObject.optInt(QzoneIPCModule.RESULT_CODE, -1);
                String optString = jSONObject.optString("retmsg");
                if (optInt == 0) {
                    this.f346961d.ok(jSONObject);
                } else {
                    this.f346961d.fail(jSONObject, optString);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
                this.f346961d.fail("error unkown!");
            }
        }
    }

    private void b(RequestEvent requestEvent, JSONObject jSONObject) throws Exception {
        String optString = jSONObject.optString("listid");
        String optString2 = jSONObject.optString("uin");
        if (!StringUtil.isEmpty(optString2) && optString2.equals(this.f346957f.getCurrentAccountUin()) && !StringUtil.isEmpty(optString)) {
            String tempArgs = ((ITenCookie) QRoute.api(ITenCookie.class)).getTempArgs(optString);
            if (StringUtil.isEmpty(tempArgs)) {
                tempArgs = SharedPreferencesProxyManager.getInstance().getProxy("common_h5_hb_info" + optString2, 0).getString(optString, "");
            }
            if (QLog.isColorLevel()) {
                QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TAG, 2, "getHbResult dataStr: " + tempArgs);
            }
            JSONObject jSONObject2 = new JSONObject(tempArgs);
            if (jSONObject2.has("detail_data")) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("retcode", 0);
                jSONObject3.put("retmsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                jSONObject3.put("detail_data", jSONObject2.optJSONObject("detail_data"));
                requestEvent.ok(jSONObject3);
                return;
            }
            if (jSONObject2.has("exception_data")) {
                requestEvent.ok(jSONObject2.optJSONObject("exception_data"));
                return;
            } else {
                e(requestEvent, "-1001", "params error, detail_data is empty");
                return;
            }
        }
        e(requestEvent, "-1001", "params error,listid is empty or is not current user");
    }

    private JSONObject c(RequestEvent requestEvent) {
        try {
            return new JSONObject(requestEvent.jsonParams);
        } catch (JSONException unused) {
            QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TAG, 1, "Failed to parse jsonParams=" + requestEvent.jsonParams);
            return null;
        }
    }

    private void d(RequestEvent requestEvent, JSONObject jSONObject) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TAG, 2, "grapH5CommonHb params: " + jSONObject);
            }
            JSONObject extraDataForGrapH5CommonHbResult = ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getExtraDataForGrapH5CommonHbResult(jSONObject);
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TAG, 2, "grapH5CommonHb extraData: " + extraDataForGrapH5CommonHbResult);
            }
            if (extraDataForGrapH5CommonHbResult != null) {
                ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getGrapH5CommonHbResult(extraDataForGrapH5CommonHbResult.toString(), this.f346956e);
            } else {
                e(requestEvent, "-1001", QWalletMixJsPlugin.ERROR_MSG_PARAM_ERROR);
            }
        } catch (Throwable th5) {
            e(requestEvent, "-1001", th5.getLocalizedMessage());
        }
    }

    private void e(RequestEvent requestEvent, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TAG, 2, "handJsError: " + str2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retcode", str);
            jSONObject.put("retmsg", str2);
            requestEvent.fail(jSONObject, str2);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private boolean f(RequestEvent requestEvent, String str) {
        IMiniAppContext iMiniAppContext;
        try {
            if (QLog.isColorLevel()) {
                QLog.i(com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TAG, 2, "[qWalletBridge] paramStr: " + str);
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("action");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if ("graphb".equals(optString)) {
                d(requestEvent, optJSONObject);
            } else if ("getHbResult".equals(optString)) {
                b(requestEvent, optJSONObject);
            } else if ("refreshHbDetail".equals(optString)) {
                try {
                    ((IH5HbUtil) QRoute.api(IH5HbUtil.class)).getHbDetailInfo(optJSONObject, "redgiftH5CommonDetail", this.f346956e);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            } else {
                e(requestEvent, "-1001", "params exception: no match action");
            }
            if (jSONObject.optInt("closeWebView") == 1 && (iMiniAppContext = this.mMiniAppContext) != null && iMiniAppContext.getAttachActivity() != null) {
                this.mMiniAppContext.getAttachActivity().finish();
            }
        } catch (Exception e16) {
            e(requestEvent, "-1001", "params exception: " + e16.getLocalizedMessage());
        }
        return true;
    }

    @JsEvent({com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.PLUGIN_NAME})
    public void openTenpayView(RequestEvent requestEvent) {
        JSONObject c16 = c(requestEvent);
        if (QLog.isColorLevel()) {
            QLog.e(com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TAG, 2, "param: " + c16);
        }
        if (c16 == null) {
            requestEvent.fail(HardCodeUtil.qqStr(R.string.u2o));
            return;
        }
        this.f346955d = new TenpayRecevicer(requestEvent, new Handler(Looper.getMainLooper()));
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ark.ARKMETADATA_JSON, c16.getString("data"));
            bundle.putString("callbackSn", "0");
            bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
            if (PayBridgeActivity.tenpay(this.mMiniAppContext.getAttachActivity(), 5, bundle, this.f346955d)) {
                return;
            }
            requestEvent.fail(HardCodeUtil.qqStr(R.string.u2p));
        } catch (JSONException e16) {
            e16.printStackTrace();
            requestEvent.fail(HardCodeUtil.qqStr(R.string.u2o));
        }
    }

    @JsEvent({com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.PLUGIN_NAME_QWALLETBRIDGE})
    public void qWalletBridge(RequestEvent requestEvent) {
        JSONObject c16 = c(requestEvent);
        if (QLog.isColorLevel()) {
            QLog.d(com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TAG, 2, "param: " + c16);
        }
        BaseActivity baseActivity = (BaseActivity) this.mMiniAppContext.getAttachActivity();
        this.f346957f = baseActivity.getAppInterface();
        this.f346956e = new QWalletPayJsPluginResultReceiver(requestEvent, new Handler(Looper.getMainLooper()), this.f346957f, new WeakReference(baseActivity));
        if (c16 != null) {
            f(requestEvent, c16.optString("data"));
        }
    }
}
