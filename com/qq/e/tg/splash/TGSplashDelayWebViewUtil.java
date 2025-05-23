package com.qq.e.tg.splash;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UTI;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class TGSplashDelayWebViewUtil {
    public static void onActivityResultCallBack() {
        GdtSDKThreadManager.getInstance().runOnThread(1, new Runnable() { // from class: com.qq.e.tg.splash.TGSplashDelayWebViewUtil.1
            @Override // java.lang.Runnable
            public final void run() {
                POFactory pOFactory;
                try {
                    if (!GDTADManager.getInstance().initWith(GDTADManager.getInstance().getAppContext(), GDTADManager.getInstance().getAppStatus().getAPPID())) {
                        GDTLogger.e("TGSplashDelayWebViewUtil[onActivityResultCallBack] sdk hasn't initialed");
                        return;
                    }
                    if (GDTADManager.getInstance().getPM() != null) {
                        pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                    } else {
                        pOFactory = null;
                    }
                    if (pOFactory == null) {
                        GDTLogger.e("TGSplashDelayWebViewUtil[onActivityResultCallBack] poFactory hasn't initialed");
                        return;
                    }
                    UTI tangramAdTriggerDelegate = pOFactory.getTangramAdTriggerDelegate();
                    if (tangramAdTriggerDelegate == null) {
                        GDTLogger.e("TGSplashDelayWebViewUtil[onActivityResultCallBack] delegate is null");
                    } else {
                        tangramAdTriggerDelegate.onActivityResultCallBack();
                    }
                } catch (Throwable th5) {
                    GDTLogger.e("TGSplashDelayWebViewUtil[onActivityResultCallBack]", th5);
                }
            }
        });
    }
}
