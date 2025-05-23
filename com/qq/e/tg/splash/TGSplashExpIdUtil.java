package com.qq.e.tg.splash;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class TGSplashExpIdUtil {
    public static final String EXP_ID_SET = "expIdSet";

    private static boolean a() {
        try {
            if (GDTADManager.getInstance().isInitialized() && GDTADManager.getInstance().getSM() != null) {
                if (GDTADManager.getInstance().getSM().getInteger("key_enable_report_exp_id", 1) == 1) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            GDTLogger.e("TGSplashExpIdUtil [updateExpIdList] clear expIdList");
            return false;
        }
    }

    public static Set<String> getExpIdSet() {
        if (!a()) {
            GDTLogger.i("TGSplashExpIdUtil [getExpIdSet] not enable report");
            return null;
        }
        return SharedPreferencedUtil.getStringSet(EXP_ID_SET, null);
    }

    public static void updateExpIdSet(Set<String> set) {
        if (set == null || set.isEmpty()) {
            GDTLogger.i("TGSplashExpIdUtil [updateExpIdList] clear expIdList");
        }
        if (!a()) {
            GDTLogger.i("TGSplashExpIdUtil [updateExpIdList] not enable report");
        } else {
            SharedPreferencedUtil.putStringSet(EXP_ID_SET, set);
        }
    }
}
