package com.tencent.gamecenter.wadl.biz.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.gamecenter.wadl.api.IQQGameInstallService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GameInstallReceiver extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    private static GameInstallReceiver f106869b;

    /* renamed from: a, reason: collision with root package name */
    static byte[] f106868a = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    private static volatile AtomicBoolean f106870c = new AtomicBoolean(false);

    GameInstallReceiver() {
    }

    public static GameInstallReceiver b() {
        if (f106869b == null) {
            synchronized (f106868a) {
                if (f106869b == null) {
                    f106869b = new GameInstallReceiver();
                }
            }
        }
        return f106869b;
    }

    public static synchronized void c() {
        synchronized (GameInstallReceiver.class) {
            if (!f106870c.getAndSet(true)) {
                QLog.d("Installer_Wadl_GameInstallReceiver", 1, "registerReceiver processName=" + MobileQQ.processName);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameInstallReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            GameInstallReceiver b16 = GameInstallReceiver.b();
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(WadlProxyConsts.ACTION_GAME_CENTER_CUSTOM_INSTALL_ACTION);
                            MobileQQ.sMobileQQ.registerReceiver(b16, intentFilter);
                        } catch (Throwable th5) {
                            GameInstallReceiver.d();
                            QLog.e("Installer_Wadl_GameInstallReceiver", 1, "registerReceiver exception", th5);
                        }
                    }
                }, 16, null, false);
            }
        }
    }

    public static synchronized void d() {
        synchronized (GameInstallReceiver.class) {
            if (!f106870c.get()) {
                return;
            }
            QLog.d("Installer_Wadl_GameInstallReceiver", 1, "unRegisterReceiver process=" + MobileQQ.processName);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameInstallReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MobileQQ.sMobileQQ.unregisterReceiver(GameInstallReceiver.b());
                    } catch (Throwable th5) {
                        QLog.e("Installer_Wadl_GameInstallReceiver", 1, "unRegisterReceiver exception", th5);
                    }
                    GameInstallReceiver.f106870c.set(false);
                }
            }, 16, null, false);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        final String action = intent.getAction();
        if (action == null) {
            return;
        }
        QLog.i("Installer_Wadl_GameInstallReceiver", 1, "onReceive action=" + action);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameInstallReceiver.3
            @Override // java.lang.Runnable
            public void run() {
                if (WadlProxyConsts.ACTION_GAME_CENTER_CUSTOM_INSTALL_ACTION.equals(action)) {
                    ((IQQGameInstallService) QRoute.api(IQQGameInstallService.class)).onReceiveCustomInstallBroadcast(context, intent);
                }
            }
        }, 16, null, false);
    }
}
