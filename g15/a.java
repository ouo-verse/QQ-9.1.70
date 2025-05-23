package g15;

import android.text.TextUtils;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.pm.PackageUtil;
import cooperation.qzone.util.QZLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a extends QZoneObserver {
    public static Boolean m(String str) {
        String str2;
        boolean isPackageInstalled = PackageUtil.isPackageInstalled(BaseApplication.getContext(), str);
        if (QZLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("QBoss filter : ");
            if (isPackageInstalled) {
                str2 = "";
            } else {
                str2 = "not ";
            }
            sb5.append(str2);
            sb5.append("install PkgName = ");
            sb5.append(str);
            QZLog.d("QzoneQbossHelper", 4, sb5.toString());
        }
        return Boolean.valueOf(isPackageInstalled);
    }

    public static String n(String str) {
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("\"download_app_package_name\":\"[^\"]*").matcher(str);
            if (matcher.find()) {
                String[] split = matcher.group(0).split("\"");
                if (split.length == 4) {
                    if (QZLog.isDevelopLevel()) {
                        QZLog.d("QzoneQbossHelper", 4, "QBoss filter : find PkgName in json");
                    }
                    if (split[3].length() <= 0) {
                        return null;
                    }
                    return split[3];
                }
            }
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QzoneQbossHelper", 4, "QBoss filter : not find PkgName in json");
        }
        return null;
    }
}
