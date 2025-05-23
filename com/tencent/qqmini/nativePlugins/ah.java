package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.out.nativePlugins.RefreshQzoneFeedPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class ah extends BaseJsPlugin {
    @JsEvent({"refreshQzoneFeed"})
    public void refreshQzoneFeed(RequestEvent requestEvent) {
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        if (attachActivity != null) {
            Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", QZoneJsConstants.METHOD_REFRESH_FEED);
            intent.putExtras(bundle);
            QZoneHelper.forwardToQzoneTransluentActivity(attachActivity, QZoneHelper.UserInfo.getInstance(), intent);
            requestEvent.ok();
            if (QLog.isColorLevel()) {
                QLog.i(RefreshQzoneFeedPlugin.TAG, 2, "RefreshQzoneFeed");
                return;
            }
            return;
        }
        QLog.e(RefreshQzoneFeedPlugin.TAG, 1, "activity is null");
    }
}
