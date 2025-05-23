package com.tencent.comic;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class VipProxyPreLoadComicProcess extends PluginProxyBroadcastReceiver {
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "onReceive start");
        }
        super.onReceive(context, intent);
        try {
            if (intent.getBooleanExtra("isPreloadProcess", false)) {
                com.tencent.comic.data.f.f99357n.set(2);
                com.tencent.comic.data.f.f99358o.set(intent.getIntExtra("preloadEntry", 0));
            }
        } catch (Exception e16) {
            QLog.e("QQComicDebug", 1, e16, new Object[0]);
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "onReceive end");
        }
    }
}
