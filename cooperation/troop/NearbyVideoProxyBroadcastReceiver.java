package cooperation.troop;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes28.dex */
public class NearbyVideoProxyBroadcastReceiver extends PluginProxyBroadcastReceiver {
    @Override // com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (QLog.isColorLevel()) {
            QLog.d("NearbyVideoProxyBroadcastReceiver", 2, "onReceive:" + intent.getAction());
        }
    }
}
