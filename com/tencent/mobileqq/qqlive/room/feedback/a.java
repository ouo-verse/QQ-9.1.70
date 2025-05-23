package com.tencent.mobileqq.qqlive.room.feedback;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static String a(Context context, String str) {
        if (context == null) {
            QLog.w("FeedbackUtil", 1, "getData, context is null");
            return "";
        }
        String a16 = com.tencent.mobileqq.qqlive.room.report.clarify.a.a(context);
        String model = DeviceInfoMonitor.getModel();
        String valueOf = String.valueOf(Build.VERSION.RELEASE);
        String valueOf2 = String.valueOf(NetworkUtil.getNetworkType(context));
        String str2 = Build.BRAND;
        String model2 = DeviceInfoMonitor.getModel();
        String valueOf3 = String.valueOf(2);
        String valueOf4 = String.valueOf(System.currentTimeMillis());
        StringBuilder sb5 = new StringBuilder();
        try {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("userid=");
            sb5.append(str);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("version=");
            sb5.append(a16);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("hardware=");
            sb5.append(model);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("os=");
            sb5.append(valueOf);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("net=");
            sb5.append(valueOf2);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("brand=");
            sb5.append(str2);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("model=");
            sb5.append(model2);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("root=");
            sb5.append(valueOf3);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("t=");
            sb5.append(valueOf4);
            return b.b(b.c(URLEncoder.encode(sb5.toString(), "UTF-8").getBytes("UTF-8"), "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1lkNci+x5C8alQ1C2LUOH0lKtuOp/TB6Qb+hiE5gnqt7sGCT+MRQ6RL7F8F3IzYm4snpZVEMunLySZn148N8QTJcgBtlBlFtLAx+b08zb7gF3Rk0sppbZUhcnVL1lLDr1gm/0lEetvn7ctnTgE7s4QUkDCxDEPEYtwXJmEghgrSXIuTOcHVjI6uYSUzJ6cMVl2gXNe4nD0wleYWh4BxczT9hmeD+ZqTG/LGWRbPA2Yd2KbTINymFvTr8ZWcG317wnruY3bBF6qWAJv/WbRjoBdGrky45LUdFXEy+n5A82YhksXSPj3IwomCEFERxRnP1IxNwpCUVz6yUTLwvGfJC6QIDAQAB"));
        } catch (Exception e16) {
            QLog.i("FeedbackUtil", 1, e16.getMessage());
            return "";
        }
    }

    private static String b(IQQLiveSDK iQQLiveSDK) {
        if (iQQLiveSDK != null && iQQLiveSDK.getAppRuntime() != null) {
            return a(iQQLiveSDK.getAppRuntime().getApplicationContext(), iQQLiveSDK.getAppRuntime().getAccount());
        }
        QLog.w("FeedbackUtil", 1, "getData, liveSDK is null");
        return "";
    }

    public static String c(Context context, String str) {
        return "https://h5.aisee.qq.com/index?appId=08404709ca&pid=1&_wv=4096&data=" + a(context, str);
    }

    public static String d(IQQLiveSDK iQQLiveSDK) {
        return "https://h5.aisee.qq.com/index?appId=08404709ca&pid=1&_wv=4096&data=" + b(iQQLiveSDK);
    }
}
