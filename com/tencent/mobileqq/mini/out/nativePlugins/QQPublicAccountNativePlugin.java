package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.Intent;
import com.tencent.biz.subscribe.d;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qzone.QZoneHelper;
import cooperation.vip.pb.vac_adv_get;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class QQPublicAccountNativePlugin implements NativePlugin {
    private static final String API_NAME = "api_name";
    public static final String API_OSUBSCRIBE_GET_DEVICE_INFO = "qsubscribe_getdeviceinfo";
    public static final String API_QSUBSCRIBE_OPEN_DETAIL = "qsubscribe_opendetail";
    public static final String API_QSUBSCRIBE_OPEN_DISCOVER = "qsubscribe_opendiscover";
    public static final String API_QSUBSCRIBE_OPEN_HOMEPAGE = "qsubscribe_openhomepage";
    private static final String DATA = "data";
    private static final String QQ_KANDIAN_TICKET_ID = "1b0ad2";
    public static final String TAG = "QQPublicAccountNativePlugin";

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        if (jSContext != null) {
            try {
                String optString = jSONObject.optString("api_name");
                if (API_QSUBSCRIBE_OPEN_DISCOVER.equals(optString)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        String optString2 = optJSONObject.optString("uin");
                        int optInt = optJSONObject.optInt("shoptype");
                        Intent intent = new Intent();
                        intent.putExtra("postUin", optString2);
                        intent.putExtra(GetAdInfoRequest.SOURCE_FROM, 1);
                        intent.putExtra("has_shop", optInt > 1);
                        intent.addFlags(268435456);
                        QZoneHelper.forwardToQQPublicAccountPublishPage(jSContext.getActivity(), intent, 0);
                        jSContext.evaluateCallback(true, null, "");
                    }
                } else if (API_QSUBSCRIBE_OPEN_DETAIL.equals(optString)) {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                    if (optJSONObject2 != null) {
                        d.p(jSContext.getActivity(), d.a(optJSONObject2.optString("feedid"), optJSONObject2.optString("uin"), optJSONObject2.optInt("type"), optJSONObject2.optInt("width"), optJSONObject2.optInt("height"), optJSONObject2.optLong("createtime")), 9001);
                    }
                } else if (API_QSUBSCRIBE_OPEN_HOMEPAGE.equals(optString)) {
                    JSONObject optJSONObject3 = jSONObject.optJSONObject("data");
                    if (optJSONObject3 != null) {
                        d.v(jSContext.getActivity(), optJSONObject3.optString("uin"), 9001);
                    }
                } else if (API_OSUBSCRIBE_GET_DEVICE_INFO.equals(optString)) {
                    GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(BaseApplication.getContext(), new GdtDeviceInfoHelper.Params());
                    if (create != null && create.deviceInfo != null) {
                        vac_adv_get.VacFeedsAdvMetaReq vacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
                        vacFeedsAdvMetaReq.device_info.set(create.deviceInfo);
                        String arrays = Arrays.toString(vacFeedsAdvMetaReq.toByteArray());
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("deviceinfo", arrays);
                        jSContext.evaluateCallback(true, jSONObject2, "");
                    }
                }
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 2, "Handle QQPublicAccountNativePlugin failed! " + QLog.getStackTraceString(th5));
                jSContext.evaluateCallback(false, null, "parse param error!");
                return;
            }
        }
        QLog.e(TAG, 2, "Handle QQPublicAccountNativePlugin failed! jsContext is null!  ");
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
