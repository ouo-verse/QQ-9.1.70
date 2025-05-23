package l61;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f413884a = true;

    public static void a(QQAppInterface qQAppInterface) {
        boolean z16;
        if (qQAppInterface == null) {
            return;
        }
        try {
            String serverConfigValue = qQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.common, "aio_pia");
            if (!"0".equals(serverConfigValue)) {
                z16 = true;
            } else {
                z16 = false;
            }
            f413884a = z16;
            if (QLog.isColorLevel()) {
                QLog.d("AIO_Panel", 2, "getAIOPanelConfig = " + serverConfigValue + " isShowQwalletHbEntry = " + f413884a);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("AIOPanelUtiles", 2, th5, new Object[0]);
            }
        }
    }

    public static void b(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
        int i16 = 1;
        if (i3 != 0) {
            if (i3 == 3000) {
                i16 = 2;
            } else if (i3 == 1) {
                i16 = 3;
            } else if (i3 != 6000 && i3 != 6001 && i3 != 6002 && i3 != 1008 && i3 != 9500) {
                i16 = 4;
            } else {
                i16 = 5;
            }
        }
        ReportController.o(baseQQAppInterface, "CliOper", "", "", str, str, i16, 0, "", "", "", "");
    }

    public static void c(AppRuntime appRuntime, String str, int i3) {
        int i16 = 1;
        if (i3 != 0) {
            if (i3 == 3000) {
                i16 = 2;
            } else if (i3 == 1) {
                i16 = 3;
            } else if (i3 != 6000 && i3 != 6001 && i3 != 6002 && i3 != 1008 && i3 != 9500) {
                i16 = 4;
            } else {
                i16 = 5;
            }
        }
        ReportController.o(appRuntime, "CliOper", "", "", str, str, i16, 0, "", "", "", "");
    }
}
