package com.tencent.mobileqq.wxmini.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.gdtad.wechat.mini.IGdtWXMINIProgramAPI;
import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes35.dex */
final class a implements WxaExtendApiJSBridge.c {
    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge.c
    public void openUrl(Activity activity, String str) {
        QLog.i("WxaOpenUrlHandler", 1, "[openUrl] activity:" + activity + " url:" + str);
        try {
            Bundle bundle = new Bundle();
            bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_miniapp");
            ((IGdtWXMINIProgramAPI) QRoute.api(IGdtWXMINIProgramAPI.class)).handleOpenUrl(new WeakReference<>(activity), bundle, str);
        } catch (Throwable th5) {
            QLog.e("WxaOpenUrlHandler", 1, "[openUrl]", th5);
        }
    }
}
