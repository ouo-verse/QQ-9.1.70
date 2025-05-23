package cooperation.qqfav;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.db.JobDbManager;
import mqq.app.AppRuntime;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class d {
    public static void a(AppRuntime appRuntime, boolean z16, long j3) {
        String str;
        String[] strArr = new String[3];
        int systemNetwork = NetworkUtil.getSystemNetwork(appRuntime.getApplication().getApplicationContext());
        if (systemNetwork == 1) {
            if (z16) {
                strArr[0] = AppConstants.FlowStatPram.PARAM_WIFIFAVORITES_UPLOAD_FLOW;
            } else {
                strArr[0] = AppConstants.FlowStatPram.PARAM_WIFIFAVORITES_DOWNLOAD_FLOW;
            }
            strArr[1] = "param_WIFIFlow";
        } else {
            if (z16) {
                strArr[0] = AppConstants.FlowStatPram.PARAM_XGFAVORITES_UPLOAD_FLOW;
            } else {
                strArr[0] = AppConstants.FlowStatPram.PARAM_XGFAVORITES_DOWNLOAD_FLOW;
            }
            strArr[1] = "param_XGFlow";
        }
        strArr[2] = "param_Flow";
        appRuntime.sendAppDataIncermentMsg(appRuntime.getAccount(), strArr, j3);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addFlowCount ");
            sb5.append(j3);
            sb5.append(" for ");
            if (z16) {
                str = JobDbManager.TBL_UPLOAD;
            } else {
                str = "download";
            }
            sb5.append(str);
            sb5.append(", netType is ");
            sb5.append(systemNetwork);
            QLog.d(ProcessConstant.QQFAV, 2, sb5.toString());
        }
    }

    public static void b(AppRuntime appRuntime, int i3, int i16, int i17) {
        if (QLog.isColorLevel()) {
            QLog.i("qqfavReport", 2, "subAction= 0X800AA51, actionName = 0X800AA51, fromType = " + i3 + ", actionResult = " + i16 + ", ext2 = " + i17);
        }
        ReportController.o(null, "dc00898", "", "", "0X800AA51", "0X800AA51", i3, i16, "" + i17, "", "", "");
    }

    public static void c(AppRuntime appRuntime, String str, int i3, int i16, int i17) {
        d(appRuntime, str, i3, i16, i17, 0, "", "");
    }

    public static void d(AppRuntime appRuntime, String str, int i3, int i16, int i17, int i18, String str2, String str3) {
        QQAppInterface qQAppInterface;
        String str4;
        if (appRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) appRuntime;
        } else {
            qQAppInterface = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("qqfavReport", 2, "actionName = " + str + ", fromType = " + i3 + ", actionResult = " + i16 + ", ext2 =" + i17 + ", ext3 =" + i18 + ", ext4 =" + str2 + ", ext5 =" + str3);
        }
        StringBuilder sb5 = new StringBuilder();
        String str5 = "";
        sb5.append("");
        sb5.append(i17);
        String sb6 = sb5.toString();
        String str6 = "" + i18;
        if (str2 == null) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if (str3 != null) {
            str5 = str3;
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "Favorite", str, i3, i16, sb6, str6, str4, str5);
    }

    public static void e(AppRuntime appRuntime, int i3, int i16) {
        c(appRuntime, "User_AddFav", i16, 0, i3);
    }

    public static void f(AppRuntime appRuntime, int i3) {
        c(appRuntime, "User_DelFav", 0, 0, i3);
    }

    public static void g(AppRuntime appRuntime, int i3, int i16) {
        c(appRuntime, "User_OpenFavPage", i16, 0, i3);
    }

    public static void h(AppRuntime appRuntime, int i3) {
        c(appRuntime, "User_NewFav", i3, 0, 0);
    }
}
