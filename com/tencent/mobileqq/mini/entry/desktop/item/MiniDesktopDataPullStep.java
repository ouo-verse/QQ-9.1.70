package com.tencent.mobileqq.mini.entry.desktop.item;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* loaded from: classes33.dex */
public class MiniDesktopDataPullStep {
    public static volatile boolean READY = false;
    private static final String TAG = "MiniDesktopDataPullStep";
    private static boolean miniDesktopMiniViewCreated = false;
    private static volatile boolean requested = false;

    public static void pullMiniDesktopData() {
        READY = true;
        if (requested) {
            QLog.d(TAG, 1, "already pulled, ignore it");
            return;
        }
        if (!miniDesktopMiniViewCreated) {
            QLog.i(TAG, 1, "pullMiniDesktopData miniDesktopMiniViewCreated is false");
            requested = true;
            return;
        }
        QLog.d(TAG, 1, "pullMiniDesktopData");
        if (!QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("mini_get_app_list_exp_" + ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getCurrentAccountUin(), false)) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).sendStartUpMiniAppDesktopInfo();
        }
        requested = true;
    }

    public static void setMiniDesktopMiniViewCreated() {
        miniDesktopMiniViewCreated = true;
    }
}
