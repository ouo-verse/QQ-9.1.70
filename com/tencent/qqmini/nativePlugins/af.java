package com.tencent.qqmini.nativePlugins;

import android.content.Intent;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qzone.QZoneHelper;
import cooperation.vip.pb.vac_adv_get;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class af extends BaseJsPlugin {
    private JSONObject b(RequestEvent requestEvent) {
        try {
            return new JSONObject(requestEvent.jsonParams);
        } catch (JSONException unused) {
            QLog.e(QQPublicAccountNativePlugin.TAG, 1, "Failed to parse jsonParams=" + requestEvent.jsonParams);
            return null;
        }
    }

    @JsEvent({QQPublicAccountNativePlugin.API_OSUBSCRIBE_GET_DEVICE_INFO})
    public void qsubscribeGetdeviceinfo(RequestEvent requestEvent) {
        try {
            b(requestEvent);
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(BaseApplication.getContext(), new GdtDeviceInfoHelper.Params());
            if (create == null || create.deviceInfo == null) {
                return;
            }
            vac_adv_get.VacFeedsAdvMetaReq vacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
            vacFeedsAdvMetaReq.device_info.set(create.deviceInfo);
            new JSONObject().put("deviceinfo", Arrays.toString(vacFeedsAdvMetaReq.toByteArray()));
            requestEvent.ok();
        } catch (Throwable th5) {
            QLog.e(QQPublicAccountNativePlugin.TAG, 1, "Handle QQPublicAccountNativePlugin failed! ", th5);
            requestEvent.fail();
        }
    }

    @JsEvent({QQPublicAccountNativePlugin.API_QSUBSCRIBE_OPEN_DETAIL})
    public void qsubscribeOpendetail(RequestEvent requestEvent) {
        try {
            JSONObject optJSONObject = b(requestEvent).optJSONObject("data");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("uin");
                int optInt = optJSONObject.optInt("type");
                com.tencent.biz.subscribe.d.p(this.mMiniAppContext.getAttachActivity(), com.tencent.biz.subscribe.d.a(optJSONObject.optString("feedid"), optString, optInt, optJSONObject.optInt("width"), optJSONObject.optInt("height"), optJSONObject.optLong("createtime")), 9001);
            }
        } catch (Throwable th5) {
            QLog.e(QQPublicAccountNativePlugin.TAG, 1, "Handle QQPublicAccountNativePlugin failed! ", th5);
            requestEvent.fail();
        }
    }

    @JsEvent({QQPublicAccountNativePlugin.API_QSUBSCRIBE_OPEN_HOMEPAGE})
    public void qsubscribeOpenhomepage(RequestEvent requestEvent) {
        try {
            JSONObject optJSONObject = b(requestEvent).optJSONObject("data");
            if (optJSONObject != null) {
                com.tencent.biz.subscribe.d.v(this.mMiniAppContext.getAttachActivity(), optJSONObject.optString("uin"), 9001);
            }
        } catch (Throwable th5) {
            QLog.e(QQPublicAccountNativePlugin.TAG, 1, "Handle QQPublicAccountNativePlugin failed! ", th5);
            requestEvent.fail();
        }
    }

    @JsEvent({QQPublicAccountNativePlugin.API_QSUBSCRIBE_OPEN_DISCOVER})
    public void qsubscribeOpendiscover(RequestEvent requestEvent) {
        try {
            JSONObject optJSONObject = b(requestEvent).optJSONObject("data");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("uin");
                int optInt = optJSONObject.optInt("shoptype");
                Intent intent = new Intent();
                intent.putExtra("postUin", optString);
                intent.putExtra(GetAdInfoRequest.SOURCE_FROM, 1);
                intent.putExtra("has_shop", optInt > 1);
                intent.addFlags(268435456);
                QZoneHelper.forwardToQQPublicAccountPublishPage(this.mMiniAppContext.getAttachActivity(), intent, 0);
                requestEvent.ok();
            }
        } catch (Throwable th5) {
            QLog.e(QQPublicAccountNativePlugin.TAG, 1, "Handle QQPublicAccountNativePlugin failed! ", th5);
            requestEvent.fail();
        }
    }
}
