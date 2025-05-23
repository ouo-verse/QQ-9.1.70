package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.media.AudioManager;
import com.qq.e.comm.managers.GDTADManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;

/* compiled from: P */
/* loaded from: classes3.dex */
public class aq {
    public static int a() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext == null) {
            return 0;
        }
        try {
            Object systemService = appContext.getSystemService("audio");
            if (systemService instanceof AudioManager) {
                return SystemMethodProxy.getStreamVolume((AudioManager) systemService, 3);
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
