package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class av {
    private static boolean a() {
        return uq3.o.O1();
    }

    public static boolean b() {
        try {
            if (!a()) {
                return false;
            }
            return TextUtils.equals("exp_stop_play_the_video_B", c());
        } catch (Throwable th5) {
            QLog.e("QQFSShowDrawerPanelCtrlExpUtil", 1, "[isHitExp] ex: ", th5);
            return false;
        }
    }

    public static String c() {
        try {
            if (!a()) {
                return "";
            }
            return ((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).getAssignment("exp_stop_play_the_video");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void d() {
        try {
            if (!a()) {
                return;
            }
            QLog.d("QQFSShowDrawerPanelCtrlExpUtil", 1, "[reportExpExposure] exp name: exp_stop_play_the_video");
            ((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).reportExperimentExport("exp_stop_play_the_video");
        } catch (Throwable th5) {
            QLog.e("QQFSShowDrawerPanelCtrlExpUtil", 1, "[reportExpExposure] ex:", th5);
        }
    }
}
