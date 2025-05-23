package com.tencent.biz.richframework.network.request;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSNetQUICExp {
    private static final List<String> BLACK_LIST = new ArrayList();
    private static final String DEFAULT_BLACK_VERSION = "25";
    public static final String EXP_NAME = "qfs_and_quic_req_571_release_exp";
    private static final String EXP_NAME_A = "qfs_and_quic_req_571_release_exp_A";
    private static final String EXP_NAME_B = "qfs_and_quic_req_571_release_exp_B";
    private static final String TAG = "VSNetQUICExp";
    private static volatile boolean sExpose;

    public static String getExpName() {
        return EXP_NAME_B;
    }

    public static boolean isBlackSDKVersion() {
        try {
            int i3 = Build.VERSION.SDK_INT;
            List<String> list = BLACK_LIST;
            if (!list.isEmpty()) {
                return list.contains(String.valueOf(i3));
            }
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_vs_net_quic_black_list", "25");
            if (TextUtils.isEmpty(loadAsString)) {
                return false;
            }
            list.addAll(Arrays.asList(loadAsString.split("_")));
            return list.contains(String.valueOf(i3));
        } catch (Exception e16) {
            QLog.d(TAG, 1, e16, new Object[0]);
            return false;
        }
    }

    public static boolean isEnabledQUICNetReq() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_quic_net_req", true);
    }

    public static void onAccountChange() {
        sExpose = false;
    }
}
