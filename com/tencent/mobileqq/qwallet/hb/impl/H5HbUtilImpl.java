package com.tencent.mobileqq.qwallet.hb.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.hb.IH5HbUtil;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.pluginshare.ITenCookie;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class H5HbUtilImpl implements IH5HbUtil {
    private static final String TAG = "H5HbUtil";

    private JSONObject filterUinByNickName(JSONObject jSONObject) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("send_object");
            String optString = optJSONObject.optString("lucky_uin");
            optJSONObject.remove("lucky_uin");
            if (!TextUtils.isEmpty(optString)) {
                optJSONObject.put("lucky_name", ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickNameSync(null, optString));
            }
            jSONObject.remove("send_object");
            jSONObject.put("send_object", optJSONObject);
            return jSONObject;
        }
        return jSONObject2;
    }

    private void getHbDetail(String str, ResultReceiver resultReceiver) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("extra_data", str);
            bundle.putString("callbackSn", "0");
            Bundle bundle2 = new Bundle();
            bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 22);
            Parcel obtain = Parcel.obtain();
            resultReceiver.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            bundle2.putParcelable(IPayLogic.RECEIVER_COM_KEY, resultReceiver2);
            bundle2.putBundle("_qwallet_payparams_data", bundle);
            bundle2.putString("_qwallet_payparams_tag", "redgiftH5CommonDetail");
            QWalletPayBridge.launchBackground(MobileQQ.sMobileQQ, bundle2);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", th5);
        }
    }

    private String getPreCode(String str) {
        if (str.contains("pre_code=")) {
            String substring = str.substring(str.indexOf("pre_code="));
            if (substring.contains(ContainerUtils.FIELD_DELIMITER)) {
                substring = substring.substring(0, substring.indexOf(ContainerUtils.FIELD_DELIMITER));
            }
            if (substring.contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
                return substring.split(ContainerUtils.KEY_VALUE_DELIMITER)[1];
            }
            return substring;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IH5HbUtil
    public JSONObject getExtraDataForGrapH5CommonHbResult(JSONObject jSONObject) throws Exception {
        String optString = jSONObject.optString("listid");
        String optString2 = jSONObject.optString("uin");
        String currentUin = ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).currentUin();
        if (!TextUtils.isEmpty(optString2) && optString2.equals(currentUin) && !TextUtils.isEmpty(optString)) {
            String optString3 = jSONObject.optString("feedsid");
            String optString4 = jSONObject.optString("token");
            String str = optString + "_" + getPreCode(optString4);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "cache key: " + str);
            }
            String tempArgs = ((ITenCookie) QRoute.api(ITenCookie.class)).getTempArgs(str);
            if (TextUtils.isEmpty(tempArgs)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "get cache from disk");
                }
                tempArgs = ((ITenCookie) QRoute.api(ITenCookie.class)).getEncryptValue(optString2, str, SharedPreferencesProxyManager.getInstance().getProxy(ITenCookie.QB_TENPAY_HB_SP_NAME + optString2, 4));
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "paramForGarpH5CommonHb:" + tempArgs);
            }
            if (!TextUtils.isEmpty(tempArgs)) {
                JSONObject jSONObject2 = new JSONObject(tempArgs);
                jSONObject2.put("feedsid", optString3);
                jSONObject2.put("uin", optString2);
                jSONObject2.put("token", optString4);
                jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, "grapH5CommonHb");
                return jSONObject2;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IH5HbUtil
    public void getGrapH5CommonHbResult(String str, ResultReceiver resultReceiver) throws Throwable {
        Bundle bundle = new Bundle();
        bundle.putString("extra_data", str);
        bundle.putString("callbackSn", "0");
        Bundle bundle2 = new Bundle();
        bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 22);
        Parcel obtain = Parcel.obtain();
        resultReceiver.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        bundle2.putParcelable(IPayLogic.RECEIVER_COM_KEY, resultReceiver2);
        bundle2.putBundle("_qwallet_payparams_data", bundle);
        bundle2.putString("_qwallet_payparams_tag", "grapH5CommonHb");
        QWalletPayBridge.launchBackground(MobileQQ.sMobileQQ, bundle2);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IH5HbUtil
    public JSONObject getGrapHbResult(int i3, Bundle bundle, Activity activity) {
        JSONObject jSONObject;
        try {
            if (i3 == 0) {
                String string = bundle.getString("grapH5CommonHbResult");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject = new JSONObject(string);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "grapH5Json: " + jSONObject);
                    }
                    if (jSONObject.optJSONObject("hb_data") != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, "showHbDetail");
                        jSONObject2.put("extra_data", jSONObject.optJSONObject("hb_data"));
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(ark.ARKMETADATA_JSON, jSONObject2.toString());
                        bundle2.putString("callbackSn", "0");
                        PayBridgeActivity.tenpay(activity, 5, bundle2, (ResultReceiver) null);
                        return null;
                    }
                    JSONObject filterUinByNickName = filterUinByNickName(jSONObject.optJSONObject("detail"));
                    jSONObject.remove("detail");
                    jSONObject.put("detail_data", filterUinByNickName);
                } else {
                    JSONObject jSONObject3 = new JSONObject();
                    String string2 = bundle.getString("detail");
                    if (!TextUtils.isEmpty(string2)) {
                        JSONObject filterUinByNickName2 = filterUinByNickName(new JSONObject(string2));
                        filterUinByNickName2.remove("retcode");
                        filterUinByNickName2.remove("retmsg");
                        jSONObject3.put("detail_data", filterUinByNickName2);
                    }
                    jSONObject3.put("retcode", 0);
                    jSONObject3.put("retmsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                    jSONObject = jSONObject3;
                }
                return jSONObject;
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                String string3 = bundle.getString("retmsg");
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject4.put("retmsg", new JSONObject(string3).optString("err_msg"));
                } else {
                    jSONObject4.put("retmsg", "error when grap hb");
                }
                jSONObject4.put("retcode", i3);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
            return jSONObject4;
        } catch (Exception e17) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e17);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.IH5HbUtil
    public void getHbDetailInfo(JSONObject jSONObject, String str, ResultReceiver resultReceiver) throws JSONException {
        String optString = jSONObject.optString("listid");
        String optString2 = jSONObject.optString("uin");
        String optString3 = jSONObject.optString("offset");
        String optString4 = jSONObject.optString("limit");
        String currentUin = ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).currentUin();
        if (!TextUtils.isEmpty(optString2) && optString2.equals(currentUin) && !TextUtils.isEmpty(optString)) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("listid", optString);
            jSONObject2.put("uin", optString2);
            jSONObject2.put("offset", optString3);
            jSONObject2.put("limit", optString4);
            String tempArgs = ((ITenCookie) QRoute.api(ITenCookie.class)).getTempArgs(optString);
            if (!TextUtils.isEmpty(tempArgs)) {
                JSONObject jSONObject3 = new JSONObject(tempArgs);
                jSONObject2.put("authkey", jSONObject3.optString("authkey"));
                jSONObject2.put("grouptype", jSONObject3.optString("grouptype"));
                jSONObject2.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, jSONObject3.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID));
            }
            jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, str);
            getHbDetail(jSONObject2.toString(), resultReceiver);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "notifyViewUpdate extstr = " + jSONObject);
        }
    }
}
