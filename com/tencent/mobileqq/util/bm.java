package com.tencent.mobileqq.util;

import android.app.Activity;
import android.os.Build;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qwallet.plugin.IActivity;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bm {
    public static int a(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1809423831:
                if (str.equals("setFaceData")) {
                    c16 = 0;
                    break;
                }
                break;
            case -135762164:
                if (str.equals(QCircleQualityReporter.KEY_ID)) {
                    c16 = 1;
                    break;
                }
                break;
            case -80575799:
                if (str.equals("changeSecureMobile")) {
                    c16 = 2;
                    break;
                }
                break;
            case 873317756:
                if (str.equals("identifyNoLogin")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1095415352:
                if (str.equals("studyModeIdentify")) {
                    c16 = 4;
                    break;
                }
                break;
            case 1386901826:
                if (str.equals("loginVerify")) {
                    c16 = 5;
                    break;
                }
                break;
            case 1764164264:
                if (str.equals("deleteFace")) {
                    c16 = 6;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 3;
            case 1:
                return 5;
            case 2:
                return 2;
            case 3:
                return 6;
            case 4:
                return 7;
            case 5:
                return 4;
            case 6:
                return 1;
            default:
                return 101;
        }
    }

    public static boolean b(Activity activity) {
        boolean z16;
        boolean z17;
        boolean isInMultiWindowMode;
        if ((activity instanceof IActivity) && Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (isInMultiWindowMode) {
                z16 = true;
                if (!(activity instanceof QBaseActivity) && ((QBaseActivity) activity).isInMultiWindow()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                QLog.d("Identificationutil", 1, "multiWindowInWallet : ", Boolean.valueOf(z16), " currentPageInMultiWindow : ", Boolean.valueOf(z17));
                if (z17 && !z16) {
                    return false;
                }
                return true;
            }
        }
        z16 = false;
        if (!(activity instanceof QBaseActivity)) {
        }
        z17 = false;
        QLog.d("Identificationutil", 1, "multiWindowInWallet : ", Boolean.valueOf(z16), " currentPageInMultiWindow : ", Boolean.valueOf(z17));
        if (z17) {
        }
        return true;
    }

    public static boolean c() {
        if (BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "IdentificationIpcServer_Model", "action_is_video_chatting", null).code == 1) {
            return true;
        }
        return false;
    }
}
