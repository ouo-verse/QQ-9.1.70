package com.tencent.mobileqq.data.nativemonitor.traffic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor.NativeTrafficMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NativeTrafficMonitorHelper {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f203166d = false;

    /* renamed from: e, reason: collision with root package name */
    private static volatile NativeTrafficMonitorHelper f203167e;

    /* renamed from: a, reason: collision with root package name */
    protected com.tencent.mobileqq.data.nativemonitor.traffic.a f203168a;

    /* renamed from: b, reason: collision with root package name */
    private INetInfoHandler f203169b = null;

    /* renamed from: c, reason: collision with root package name */
    private final BroadcastReceiver f203170c = new BroadcastReceiver() { // from class: com.tencent.mobileqq.data.nativemonitor.traffic.NativeTrafficMonitorHelper.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            try {
                QLog.d("NativeTrafficMonitorHelper", 1, "mReceiver action : " + action + ", process_name :" + intent.getStringExtra("process_name"));
            } catch (Exception e16) {
                QLog.e("NativeTrafficMonitorHelper", 1, "action: " + action, e16);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.data.nativemonitor.traffic.NativeTrafficMonitorHelper.2.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (IECScreenReceiver.ACTION_QQ_BACKGROUND.equals(action)) {
                            NativeTrafficMonitor.getInstance().nativeSetAppIsOnForeground(false);
                            QLog.d("NativeTrafficMonitorHelper", 1, "qq change to background");
                        } else if (IECScreenReceiver.ACTION_QQ_FOREGROUND.equals(action)) {
                            NativeTrafficMonitor.getInstance().nativeSetAppIsOnForeground(true);
                            QLog.d("NativeTrafficMonitorHelper", 1, "qq change to foreground");
                        } else {
                            QLog.d("NativeTrafficMonitorHelper", 1, "unknown action: " + action);
                        }
                    } catch (Throwable th5) {
                        QLog.d("NativeTrafficMonitorHelper", 2, "mReceiver fail", th5);
                    }
                }
            }, 16, null, true);
        }
    };

    NativeTrafficMonitorHelper() {
    }

    private void a() {
        this.f203169b = new a();
    }

    public static NativeTrafficMonitorHelper b() {
        if (f203167e == null) {
            synchronized (NativeTrafficMonitorHelper.class) {
                if (f203167e == null) {
                    f203167e = new NativeTrafficMonitorHelper();
                }
            }
        }
        return f203167e;
    }

    private void c(com.tencent.mobileqq.data.nativemonitor.traffic.a aVar) {
        QLog.d("NativeTrafficMonitorHelper", 1, "realInitNativeTrafficMonitorWithConfig start, " + aVar);
        if (aVar != null && aVar.q()) {
            this.f203168a = aVar;
            BaseApplication context = BaseApplication.getContext();
            f203166d = d(context);
            QLog.d("NativeTrafficMonitorHelper", 1, "[realInitNativeTrafficMonitorWithConfig] registerResult: " + f203166d);
            NativeTrafficMonitor.getInstance().setTrafficReporter(b.b());
            NativeTrafficMonitor.getInstance().setUpTrafficMonitor(context);
            boolean isMobileNetWork = NetworkUtil.isMobileNetWork(context);
            QLog.d("NativeTrafficMonitorHelper", 1, "realInitNativeTrafficMonitorWithConfig isMobileNet: " + isMobileNetWork);
            NativeTrafficMonitor.getInstance().setNetStateIsMobile(isMobileNetWork);
            NativeTrafficMonitor.getInstance().nativeEnableDetailMonitor(aVar.p());
            NativeTrafficMonitor.getInstance().nativeEnableGlobalMonitor(aVar.o());
            NativeTrafficMonitor.getInstance().nativeSetReportThreshold(aVar.g(), aVar.k(), aVar.m(), aVar.l());
            NativeTrafficMonitor.getInstance().nativeSetGloBalMonitorThreshold(aVar.d(), aVar.c(), aVar.a(), aVar.i(), aVar.e(), aVar.j());
        }
    }

    private boolean d(Context context) {
        if (context == null) {
            QLog.e("NativeTrafficMonitorHelper", 1, "[registerBroadcast] context is null!");
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_BACKGROUND);
        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_FOREGROUND);
        try {
            context.registerReceiver(this.f203170c, intentFilter);
            return true;
        } catch (Throwable th5) {
            QLog.e("NativeTrafficMonitorHelper", 1, "registered failed, try unregisterReceiver ", th5);
            context.unregisterReceiver(this.f203170c);
            return false;
        }
    }

    private void e() {
        com.tencent.mobileqq.data.nativemonitor.traffic.a aVar;
        QLog.d("NativeTrafficMonitorHelper", 1, "startToInitNativeTrafficMonitorWithConfig isPublicVersion[true]");
        try {
            aVar = (com.tencent.mobileqq.data.nativemonitor.traffic.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(QQLiveReportConstants.VALUE_APPID);
        } catch (Exception e16) {
            QLog.e("NativeTrafficMonitorHelper", 1, "load manager config err.", e16);
            aVar = new com.tencent.mobileqq.data.nativemonitor.traffic.a();
        }
        try {
            c(aVar);
        } catch (UnsatisfiedLinkError e17) {
            QLog.e("NativeTrafficMonitorHelper", 1, "realInitNativeTrafficMonitorWithConfig err.", e17);
        }
    }

    public void f() {
        QLog.d("NativeTrafficMonitorHelper", 1, "stepUpNativeTrafficMonitor");
        a();
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.f203169b);
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements INetInfoHandler {
        a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            NativeTrafficMonitor.getInstance().setNetStateIsMobile(false);
            QLog.d("NativeTrafficMonitorHelper", 1, "NetWork change form mobile to wifi");
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            NativeTrafficMonitor.getInstance().setNetStateIsMobile(true);
            QLog.d("NativeTrafficMonitorHelper", 1, "NetWork change form none to mobile");
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            NativeTrafficMonitor.getInstance().setNetStateIsMobile(false);
            QLog.d("NativeTrafficMonitorHelper", 1, "NetWork change form none to wifi");
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            NativeTrafficMonitor.getInstance().setNetStateIsMobile(true);
            QLog.d("NativeTrafficMonitorHelper", 1, "NetWork change form wifi to mobile");
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
        }
    }
}
