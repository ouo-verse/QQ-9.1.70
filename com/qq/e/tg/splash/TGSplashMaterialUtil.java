package com.qq.e.tg.splash;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TGSplashMaterialUtil {
    public static void checkPreloadSplashMaterial() {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.splash.TGSplashMaterialUtil.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory(PM.SPLASH_AD);
                    if (pOFactory != null) {
                        pOFactory.checkPreloadSplashMaterial();
                    } else {
                        GDTLogger.e("\u63d2\u4ef6\u8fd8\u672a\u521d\u59cb\u5316\u5b8c\u6210");
                    }
                } catch (a e16) {
                    GDTLogger.e("Fail to init splash plugin", e16);
                }
            }
        });
    }
}
