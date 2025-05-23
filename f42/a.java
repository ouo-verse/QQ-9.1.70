package f42;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    private static String a(Context context, String str) {
        if (context == null) {
            QLog.w("FeedbackUtil", 1, "getData, context is null");
            return "";
        }
        String c16 = com.tencent.mobileqq.cooperation.a.c(context);
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
            sb5.append(c16);
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
            return b.b(b.c(URLEncoder.encode(sb5.toString(), "UTF-8").getBytes("UTF-8"), "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0KmCQ5mt/wNgO5NqqKjYXJzytcKSObsijsfli5wPzWz1HXaTkROdG6fHFws0sXoLWKyCUNhrIrlxoh3gaVMBm35UpRo5roxQXud2tJL7SkFkiC/iC2JWayzM5UhwLWM2Vfdpq5tWrHjahhqjLfDRTcsTqVbxFqW2e8q567EW6MWSYFxhL9LHNBXbGNpdUsjD6p9x6YsU0PrM0mXqhSCC8POb3qPODDWXpV+iWijx8xtTAHfhbG2AuGgagFsjqwBmiCIfmbSe0LBw8Esos6IU3XeNoDe6KftlRfrw1Srmj+nfo5WLT6xQiHMhTCq2vQbpIB22Oc8MIWAxFfD78YscfQIDAQAB"));
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
        return "https://h5.aisee.qq.com/index?appId=kh7xjfqhh4&pid=1&_wv=4096&data=" + a(context, str);
    }

    public static String d(IQQLiveSDK iQQLiveSDK) {
        return "https://h5.aisee.qq.com/index?appId=kh7xjfqhh4&pid=1&_wv=4096&data=" + b(iQQLiveSDK);
    }
}
