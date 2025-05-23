package cooperation.qzone;

import com.tencent.common.config.AppSetting;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QUA {
    public static final String NOW = AppSetting.f99545e;
    private static final String QUA = "V1_AND_SQ_9.1.70_9898_YYB_D";
    private static String VERSION_FOR_MM = null;
    private static String VERSION_FOR_P = null;
    public static final String quaBuildNum = "100084";

    private static String getCoreInQua() {
        return QUA.substring(3, 25);
    }

    public static String getQUA3() {
        return QUA;
    }

    public static String getVersionForHabo() {
        if (VERSION_FOR_MM == null) {
            VERSION_FOR_MM = getCoreInQua();
        }
        return VERSION_FOR_MM;
    }

    public static String getVersionForPic() {
        if (VERSION_FOR_P == null) {
            VERSION_FOR_P = getCoreInQua();
        }
        return VERSION_FOR_P;
    }
}
