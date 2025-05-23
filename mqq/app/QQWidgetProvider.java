package mqq.app;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes28.dex */
public class QQWidgetProvider extends AppWidgetProvider {
    public void onReceive(AppRuntime appRuntime, Context context, Intent intent) {
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        MobileQQ.sMobileQQ.onActivityCreate(this, intent);
        onReceive(MobileQQ.sMobileQQ.waitAppRuntime(), context, intent);
    }
}
