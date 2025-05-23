package com.tencent.gamecenter.wadl.biz.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameFullScreenNoticeService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GameFullScreenReceiver extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    private static GameFullScreenReceiver f106865b;

    /* renamed from: a, reason: collision with root package name */
    static byte[] f106864a = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    private static volatile AtomicBoolean f106866c = new AtomicBoolean(false);

    GameFullScreenReceiver() {
    }

    public static GameFullScreenReceiver b() {
        if (f106865b == null) {
            synchronized (f106864a) {
                if (f106865b == null) {
                    f106865b = new GameFullScreenReceiver();
                }
            }
        }
        return f106865b;
    }

    public static synchronized void c() {
        synchronized (GameFullScreenReceiver.class) {
            if (!f106866c.getAndSet(true)) {
                QLog.d("Wadl_GameFullScreenReceiver", 1, "registerReceiver processName=" + MobileQQ.processName);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameFullScreenReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            GameFullScreenReceiver b16 = GameFullScreenReceiver.b();
                            IntentFilter intentFilter = new IntentFilter();
                            if (MobileQQ.sProcessId == 1) {
                                intentFilter.addAction("android.intent.action.USER_PRESENT");
                            }
                            MobileQQ.sMobileQQ.registerReceiver(b16, intentFilter);
                        } catch (Throwable th5) {
                            GameFullScreenReceiver.d();
                            QLog.e("Wadl_GameFullScreenReceiver", 1, "registerReceiver exception", th5);
                        }
                    }
                }, 16, null, false);
            }
        }
    }

    public static synchronized void d() {
        synchronized (GameFullScreenReceiver.class) {
            if (!f106866c.get()) {
                return;
            }
            QLog.d("Wadl_GameFullScreenReceiver", 1, "unRegisterReceiver process=" + MobileQQ.processName);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameFullScreenReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MobileQQ.sMobileQQ.unregisterReceiver(GameFullScreenReceiver.b());
                    } catch (Throwable th5) {
                        QLog.e("Wadl_GameFullScreenReceiver", 1, "unRegisterReceiver exception", th5);
                    }
                    GameFullScreenReceiver.f106866c.set(false);
                }
            }, 16, null, false);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (action == null) {
            return;
        }
        QLog.d("Wadl_GameFullScreenReceiver", 1, "onReceive action=" + action);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.receiver.GameFullScreenReceiver.3
            @Override // java.lang.Runnable
            public void run() {
                IQQGameFullScreenNoticeService iQQGameFullScreenNoticeService;
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    try {
                        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                        if (appInterface != null && (iQQGameFullScreenNoticeService = (IQQGameFullScreenNoticeService) appInterface.getRuntimeService(IQQGameFullScreenNoticeService.class, "")) != null) {
                            iQQGameFullScreenNoticeService.showGameAppointmentFullScreen();
                        }
                    } catch (Throwable th5) {
                        QLog.e("Wadl_GameFullScreenReceiver", 1, th5, new Object[0]);
                    }
                }
            }
        }, 16, null, false);
    }
}
