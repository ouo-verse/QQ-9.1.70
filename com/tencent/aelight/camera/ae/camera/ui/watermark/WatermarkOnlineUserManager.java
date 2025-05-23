package com.tencent.aelight.camera.ae.camera.ui.watermark;

import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.config.g;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WatermarkOnlineUserManager {

    /* renamed from: h, reason: collision with root package name */
    private static volatile WatermarkOnlineUserManager f63419h;

    /* renamed from: a, reason: collision with root package name */
    private final int f63420a = 2000;

    /* renamed from: b, reason: collision with root package name */
    private final int f63421b = 60000;

    /* renamed from: c, reason: collision with root package name */
    private final int f63422c = 1000;

    /* renamed from: d, reason: collision with root package name */
    private long f63423d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f63424e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f63425f = 0;

    /* renamed from: g, reason: collision with root package name */
    private final Object f63426g = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends g {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f63427d;

        a(AppInterface appInterface) {
            this.f63427d = appInterface;
        }

        @Override // com.tencent.aelight.camera.ae.config.g
        public void onUpdateOnlineUserNum(boolean z16, int i3) {
            ms.a.f("WatermarkOnlineUserManager", "requestOnlineUserNum---isSuccess=" + z16 + ", num=" + i3);
            this.f63427d.removeObserver(this);
            if (z16) {
                synchronized (WatermarkOnlineUserManager.this.f63426g) {
                    WatermarkOnlineUserManager.this.f63425f = i3;
                }
            }
        }
    }

    WatermarkOnlineUserManager() {
    }

    private void d(long j3) {
        long j16 = this.f63423d;
        if (j3 - j16 <= 1000) {
            if (j3 - j16 < 0) {
                this.f63423d = j3;
            }
        } else {
            this.f63423d = j3;
            synchronized (this.f63426g) {
                int i3 = this.f63425f;
                if (i3 != 0) {
                    this.f63425f = (i3 - 1000) + new Random().nextInt(2000);
                }
            }
        }
    }

    private void e(long j3) {
        long j16 = this.f63424e;
        if (j3 - j16 > 60000) {
            this.f63424e = j3;
            new BaseThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkOnlineUserManager.1
                @Override // java.lang.Runnable
                public void run() {
                    WatermarkOnlineUserManager.this.h();
                }
            }).start();
        } else if (j3 - j16 < 0) {
            this.f63424e = j3;
        }
    }

    public static WatermarkOnlineUserManager f() {
        if (f63419h == null) {
            synchronized (WatermarkOnlineUserManager.class) {
                if (f63419h == null) {
                    f63419h = new WatermarkOnlineUserManager();
                }
            }
        }
        return f63419h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        AppInterface a16 = com.tencent.aelight.camera.aebase.a.a();
        if (a16 != null) {
            CameraPeakServiceHandler cameraPeakServiceHandler = (CameraPeakServiceHandler) a16.getBusinessHandler(((IAEClassManager) QRoute.api(IAEClassManager.class)).getCameraPeakServiceHandlerClass().getName());
            a16.addObserver(new a(a16));
            cameraPeakServiceHandler.o3();
        }
    }

    public int g() {
        long currentTimeMillis = System.currentTimeMillis();
        e(currentTimeMillis);
        d(currentTimeMillis);
        return this.f63425f;
    }
}
