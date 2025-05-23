package com.tencent.gamecenter.wadl.biz.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GameCenterBroadcastReceiver extends BroadcastReceiver implements INetEventHandler {

    /* renamed from: d, reason: collision with root package name */
    boolean f106857d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f106858e = false;

    /* renamed from: f, reason: collision with root package name */
    private static volatile AtomicBoolean f106853f = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    public static int f106854h = 100;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f106855i = false;

    /* renamed from: m, reason: collision with root package name */
    private static GameCenterBroadcastReceiver f106856m = null;
    static byte[] C = new byte[0];

    public static GameCenterBroadcastReceiver b() {
        if (f106856m == null) {
            synchronized (C) {
                if (f106856m == null) {
                    f106856m = new GameCenterBroadcastReceiver();
                }
            }
        }
        return f106856m;
    }

    public static void c() {
        QLog.i("GameCenterBroadcastReceiver", 1, "registerReceiver");
        if (!f106853f.getAndSet(true)) {
            try {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GameCenterBroadcastReceiver b16 = GameCenterBroadcastReceiver.b();
                        AppNetConnInfo.registerNetChangeReceiver(MobileQQ.sMobileQQ, b16);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                        intentFilter.addAction(IECScreenReceiver.ACTION_QQ_FOREGROUND);
                        MobileQQ.sMobileQQ.registerReceiver(b16, intentFilter);
                    }
                }, 16, null, false);
            } catch (Throwable th5) {
                QLog.e("GameCenterBroadcastReceiver", 1, "registerReceiver exception", th5);
            }
        }
    }

    public static void d() {
        if (!f106853f.get()) {
            return;
        }
        QLog.i("GameCenterBroadcastReceiver", 1, "unRegisterReceiver");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    GameCenterBroadcastReceiver b16 = GameCenterBroadcastReceiver.b();
                    AppNetConnInfo.unregisterNetEventHandler(b16);
                    MobileQQ.sMobileQQ.unregisterReceiver(b16);
                } catch (Throwable th5) {
                    QLog.e("GameCenterBroadcastReceiver", 1, "unRegisterReceiver exception", th5);
                }
                GameCenterBroadcastReceiver.f106853f.set(false);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
    public void onNetChangeEvent(boolean z16) {
        if (!z16) {
            QLog.i("GameCenterBroadcastReceiver", 1, "no net");
            return;
        }
        if (AppNetConnInfo.isMobileConn()) {
            if (this.f106858e) {
                return;
            } else {
                QLog.i("GameCenterBroadcastReceiver", 1, "mobile connect");
            }
        } else if (AppNetConnInfo.isWifiConn()) {
            if (this.f106857d) {
                return;
            }
            this.f106857d = true;
            QLog.i("GameCenterBroadcastReceiver", 1, "wifi connect");
            ((IQQGameCheckService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameCheckService.class, "")).checkGameCenter(2);
        } else {
            QLog.i("GameCenterBroadcastReceiver", 1, "no connect");
        }
        this.f106857d = false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        final String action = intent.getAction();
        if (action == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver.3
            @Override // java.lang.Runnable
            public void run() {
                AppRuntime peekAppRuntime;
                boolean z16 = true;
                if (!IECScreenReceiver.ACTION_SCREEN_OFF.equals(action) && !IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                    if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                        GameCenterBroadcastReceiver.f106854h = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
                        QLog.i("GameCenterBroadcastReceiver", 1, "battery cap= " + GameCenterBroadcastReceiver.f106854h);
                        return;
                    }
                    if (!"android.intent.action.ACTION_POWER_CONNECTED".equals(action) && !"android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                        if (IECScreenReceiver.ACTION_QQ_FOREGROUND.equals(action) && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && ((IQQGameDownloadService) peekAppRuntime.getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI)).hasUnsentDlCmdWhenProcStartFailed()) {
                            QLog.i("GameCenterBroadcastReceiver", 1, "QQ_FOREGROUND, has unsent download command, recheck");
                            ((IQQGameCheckService) peekAppRuntime.getRuntimeService(IQQGameCheckService.class, "")).checkGameCenter(5);
                            return;
                        }
                        return;
                    }
                    int intExtra = intent.getIntExtra("status", -1);
                    if (intExtra != 2 && intExtra != 5) {
                        z16 = false;
                    }
                    GameCenterBroadcastReceiver.f106855i = z16;
                    return;
                }
                QLog.i("GameCenterBroadcastReceiver", 1, "mScreenOff = true");
                ((IQQGameCheckService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameCheckService.class, "")).checkGameCenter(1);
            }
        }, 16, null, false);
    }
}
