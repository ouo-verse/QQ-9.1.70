package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qzonehub.api.IQzonePluginProxyActivity;
import com.tencent.qzonehub.api.ITranslucentActivityProxy;

/* loaded from: classes34.dex */
public class TranslucentActivityProxyImpl implements ITranslucentActivityProxy {
    @Override // com.tencent.qzonehub.api.ITranslucentActivityProxy
    public SharedPreferences getSharedPreferences(String str, int i3) {
        return SharedPreferencesProxyManager.getInstance().getProxy(str, i3);
    }

    @Override // com.tencent.qzonehub.api.ITranslucentActivityProxy
    public void startPlugin(Intent intent, Activity activity) {
        intent.putExtra(PluginStatic.PARAM_USE_QQ_RESOURCES, 2);
        ((IQzonePluginProxyActivity) QRoute.api(IQzonePluginProxyActivity.class)).launchPluingActivityForResult(activity, "", intent, -1);
        activity.finish();
    }
}
