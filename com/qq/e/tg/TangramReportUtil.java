package com.qq.e.tg;

import android.content.Context;
import android.os.Looper;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TangramReportUtil {
    public static void report(Context context, String str, int i3, int i16, Map map, Map map2) {
        String message;
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                GDTLogger.e("refuse report ad event in main thread!");
                return;
            }
            if (!StringUtil.isEmpty(str) && context != null) {
                if (GDTADManager.getInstance().initWith(context, str)) {
                    PM pm5 = GDTADManager.getInstance().getPM();
                    if (pm5 == null) {
                        GDTLogger.e("report: pm is null, sdk has not initialized?");
                        return;
                    }
                    POFactory pOFactory = pm5.getPOFactory(PM.BASE);
                    if (pOFactory != null) {
                        pOFactory.reportCost(i3, i16, map, map2);
                        return;
                    }
                    return;
                }
                return;
            }
            GDTLogger.e(String.format("TangramReportUtil report params error, appId=%s, context=%s", str, context));
        } catch (com.qq.e.comm.managers.plugin.a unused) {
            message = "init sdk failed with pe exception";
            GDTLogger.e(message);
        } catch (Throwable th5) {
            message = th5.getMessage();
            GDTLogger.e(message);
        }
    }
}
