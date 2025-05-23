package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IQFileUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class an {
    public static boolean a(MessageRecord messageRecord) {
        return b().checkComplexMessage(messageRecord);
    }

    private static IQFileUtils b() {
        return (IQFileUtils) QRoute.api(IQFileUtils.class);
    }

    public static int c() {
        return b().getIPStackType();
    }

    public static int d(String str) {
        return b().getIpAddrType(str);
    }

    public static int e(String str) {
        return b().getIpAddrTypeOfUrl(str);
    }

    public static String f(int i3, String str) {
        String str2;
        switch (i3) {
            case 0:
                str2 = "micro-dsc-";
                break;
            case 1:
                str2 = "minni-dsc-";
                break;
            case 2:
                str2 = "small-dsc-";
                break;
            case 3:
                str2 = "middle-dsc-";
                break;
            case 4:
                str2 = "large-dsc-";
                break;
            case 5:
                str2 = "qlarge-dsc-";
                break;
            case 6:
                str2 = "xlarge-dsc-";
                break;
            case 7:
                str2 = "qxlarge-dsc-";
                break;
            case 8:
                str2 = "screen-dsc-";
                break;
            default:
                str2 = "x-dsc-";
                break;
        }
        return str2 + str;
    }

    public static int g() {
        return b().getReportIPStackType();
    }

    public static int h() {
        return b().getReportLoginIPStackType();
    }

    public static boolean i() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return true;
        }
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("file_is_thread_switch_enabled");
    }

    public static void j() {
        QLog.d("QQFileUtils<FileAssistant>", 1, "call weiyun task: " + QLog.getStackTraceString(new Throwable()));
    }

    public static void k(Context context, TextView textView, String str, String str2, String str3, String str4, String str5, boolean z16, ah.f fVar) {
        b().setFileDescription(context, textView, str, str2, str3, str4, str5, z16, fVar);
    }
}
