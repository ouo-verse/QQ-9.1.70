package com.tencent.biz.richframework.video.rfw.player.strategy;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWLowDeviceAv1Exp;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.util.HashSet;
import uq3.k;

/* loaded from: classes5.dex */
public class RFWPlayerAV1Strategy {
    private static final HashSet<String> BLACK_SET = new HashSet<>();
    public static final String KEY_AV1_BADE_CASE_COUNT = "paley_av1_bad_case_counts" + QUA.getQUA3();

    public static boolean enableAV1() {
        if (getAV1Flag() > 0) {
            return true;
        }
        return false;
    }

    private static boolean enableAv1BlackList() {
        if (uq3.c.Y0("qqcircle", "qqcircle_av1_black_list_model_enable", 1, false).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int getAV1Flag() {
        if (!uq3.c.a5()) {
            RFWLog.d("QFSPlayerAV1Strategy", RFWLog.USR, "wns not enable return, av1 flag: 0");
            return 0;
        }
        if (isEnableTarget() && isEnableModel()) {
            if (RFWLowDeviceAv1Exp.hitExpB()) {
                RFWLog.d("QFSPlayerAV1Strategy", RFWLog.USR, "hit exp 9.0.35: 0");
                return 0;
            }
            if (k.a().e(KEY_AV1_BADE_CASE_COUNT, 0) < uq3.c.q2()) {
                return 1;
            }
            RFWLog.d("QFSPlayerAV1Strategy", RFWLog.USR, "trigger av1 down level, av1 flag: 2");
            return 2;
        }
        RFWLog.d("QFSPlayerAV1Strategy", RFWLog.USR, "targetSdk not enable return, av1 flag: 0");
        return 0;
    }

    private static String getBlackList() {
        try {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_av1_black_list_model", "ALP-AL00|BLA-AL00|EML-AL00|COL-AL10|V1818CA|PAR-AL00|BKL-AL20|CLT-AL00|V1818CT|vivo Y83A|COR-AL10|COR-AL10|CLT-AL01|V1818CT|PDBM00|V1981A|vivo X21A|Readboy_C15S1 Pro|vivo Y71A|S1A|DUA-AL00|vivo Y71|H20|DRA-AL00|Readboy_T16H|V2034A|DUA-TL00|22122RK93C|V1818A|PFUM10|vivo Y51s|JLH-AN00|OPD2404");
        } catch (Exception unused) {
            return "ALP-AL00|BLA-AL00|EML-AL00|COL-AL10|V1818CA|PAR-AL00|BKL-AL20|CLT-AL00|V1818CT|vivo Y83A|COR-AL10|COR-AL10|CLT-AL01|V1818CT|PDBM00|V1981A|vivo X21A|Readboy_C15S1 Pro|vivo Y71A|S1A|DUA-AL00|vivo Y71|H20|DRA-AL00|Readboy_T16H|V2034A|DUA-TL00|22122RK93C|V1818A|PFUM10|vivo Y51s|JLH-AN00|OPD2404";
        }
    }

    private static boolean isEnableModel() {
        if (!enableAv1BlackList()) {
            return true;
        }
        String mobileModel = QCircleDeviceInfoUtils.getMobileModel();
        if (!BLACK_SET.isEmpty()) {
            return !r3.contains(mobileModel.toLowerCase());
        }
        try {
            String blackList = getBlackList();
            if (!TextUtils.isEmpty(blackList)) {
                QLog.d("QFSPlayerAV1Strategy", 2, "mobileModel:" + mobileModel);
                String[] split = blackList.split("\\|");
                if (split == null) {
                    return true;
                }
                for (String str : split) {
                    BLACK_SET.add(str.toLowerCase());
                }
            }
        } catch (Exception e16) {
            RFWLog.d("QFSPlayerAV1Strategy", RFWLog.CLR, e16);
        }
        return !BLACK_SET.contains(mobileModel.toLowerCase());
    }

    private static boolean isEnableTarget() {
        if (!uq3.c.i()) {
            return true;
        }
        int i3 = RFWLog.USR;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isEnableTarget sdk version: ");
        int i16 = Build.VERSION.SDK_INT;
        sb5.append(i16);
        RFWLog.d("QFSPlayerAV1Strategy", i3, sb5.toString());
        if (i16 > 27) {
            return true;
        }
        return false;
    }
}
