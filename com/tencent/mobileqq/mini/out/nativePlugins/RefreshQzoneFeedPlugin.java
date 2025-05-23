package com.tencent.mobileqq.mini.out.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class RefreshQzoneFeedPlugin implements NativePlugin {
    public static final String TAG = "RefreshQzoneFeedPlugin";

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        if (jSContext != null) {
            Activity activity = jSContext.getActivity();
            if (activity != null) {
                Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
                Bundle bundle = new Bundle();
                bundle.putString("cmd", QZoneJsConstants.METHOD_REFRESH_FEED);
                intent.putExtras(bundle);
                QZoneHelper.forwardToQzoneTransluentActivity(activity, QZoneHelper.UserInfo.getInstance(), intent);
                jSContext.evaluateCallback(true, null, "");
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "RefreshQzoneFeed");
                    return;
                }
                return;
            }
            QLog.e(TAG, 1, "activity is null");
            return;
        }
        QLog.e(TAG, 1, "jsContext is null");
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
