package com.vivo.push.sdk.service;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.vivo.push.util.ag;
import com.vivo.push.util.u;
import java.util.List;

/* loaded from: classes15.dex */
public class LinkProxyActivity extends Activity {
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce A[Catch: Exception -> 0x00e1, TryCatch #2 {Exception -> 0x00e1, blocks: (B:26:0x0093, B:28:0x0099, B:30:0x00a5, B:32:0x00ab, B:34:0x00b3, B:37:0x00ba, B:39:0x00c2, B:41:0x00c6, B:45:0x00ce, B:46:0x00d2), top: B:25:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d2 A[Catch: Exception -> 0x00e1, TRY_LEAVE, TryCatch #2 {Exception -> 0x00e1, blocks: (B:26:0x0093, B:28:0x0099, B:30:0x00a5, B:32:0x00ab, B:34:0x00b3, B:37:0x00ba, B:39:0x00c2, B:41:0x00c6, B:45:0x00ce, B:46:0x00d2), top: B:25:0x0093 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onCreate(Bundle bundle) {
        PackageManager packageManager;
        List<ResolveInfo> queryIntentServices;
        ResolveInfo resolveInfo;
        ServiceInfo serviceInfo;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            u.d(OuterCallReportModel.COMPONENT_LINKPROXY, "enter RequestPermissionsActivity onCreate, intent is null, finish");
            finish();
            return;
        }
        boolean z16 = true;
        try {
            Window window = getWindow();
            window.setGravity(8388659);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.height = 1;
            attributes.width = 1;
            window.setAttributes(attributes);
        } catch (Throwable th5) {
            u.b(OuterCallReportModel.COMPONENT_LINKPROXY, "enter onCreate error ", th5);
        }
        String packageName = getPackageName();
        u.d(OuterCallReportModel.COMPONENT_LINKPROXY, hashCode() + " enter onCreate " + packageName);
        if ("com.vivo.abe".equals(packageName)) {
            try {
                if (intent.getExtras() == null) {
                    u.d(OuterCallReportModel.COMPONENT_LINKPROXY, "adapterToService getExtras() is null");
                } else {
                    Intent intent2 = (Intent) intent.getExtras().get("previous_intent");
                    if (intent2 == null) {
                        u.d(OuterCallReportModel.COMPONENT_LINKPROXY, "adapterToService proxyIntent is null");
                    } else {
                        ag.a(this, intent2);
                    }
                }
            } catch (Exception e16) {
                u.a(OuterCallReportModel.COMPONENT_LINKPROXY, e16.toString(), e16);
            }
        } else {
            try {
                if (intent.getExtras() != null) {
                    Intent intent3 = (Intent) intent.getExtras().get("previous_intent");
                    if (intent3 != null && (packageManager = getPackageManager()) != null && (queryIntentServices = InstalledAppListMonitor.queryIntentServices(packageManager, intent3, PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT)) != null && !queryIntentServices.isEmpty() && (resolveInfo = queryIntentServices.get(0)) != null && (serviceInfo = resolveInfo.serviceInfo) != null && serviceInfo.exported) {
                        if (!z16) {
                            startService(intent3);
                        } else {
                            u.b(OuterCallReportModel.COMPONENT_LINKPROXY, "service's exported is ".concat(String.valueOf(z16)));
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                }
            } catch (Exception e17) {
                u.a(OuterCallReportModel.COMPONENT_LINKPROXY, e17.toString(), e17);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        u.d(OuterCallReportModel.COMPONENT_LINKPROXY, hashCode() + " onDestory " + getPackageName());
    }
}
