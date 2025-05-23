package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class o extends BaseJsPlugin {
    public static void b(Activity activity, String str) {
        if (!TextUtils.isEmpty(str) && !activity.isFinishing()) {
            Intent intent = new Intent();
            if (HttpUtil.isValidUrl(str)) {
                intent.putExtra("url", str);
                RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
                return;
            }
            try {
                intent.setData(Uri.parse(str));
                RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTER_JUMP);
                return;
            } catch (Exception e16) {
                QLog.e("GuildDiscoverJsPlugin", 1, e16, new Object[0]);
                return;
            }
        }
        QLog.e("GuildDiscoverJsPlugin", 1, "[jumpUrlOrSchema] url is empty or activity isFinishing");
    }

    @JsEvent({"openNativePageFromContainer"})
    public void openNativePageFromContainer(RequestEvent requestEvent) {
        QLog.d("GuildDiscoverJsPlugin", 1, "[openNativePageFromContainer], jsonParams:" + requestEvent.jsonParams);
        try {
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
            if (optJSONObject == null) {
                QLog.d("GuildDiscoverJsPlugin", 1, "[openNativePageFromContainer], data is invalid");
                requestEvent.fail("data is invalid");
                return;
            }
            String optString = optJSONObject.optString(ZPlanPublishSource.FROM_SCHEME);
            QLog.d("GuildDiscoverJsPlugin", 1, "[openNativePageFromContainer], scheme:" + optString);
            b(this.mMiniAppContext.getAttachActivity(), optString);
            requestEvent.ok();
        } catch (Exception e16) {
            QLog.e("GuildDiscoverJsPlugin", 1, e16, new Object[0]);
            requestEvent.fail();
        }
    }
}
