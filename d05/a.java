package d05;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import cooperation.qzone.remote.ServiceConst;
import oz4.g;
import oz4.k;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class a {
    public static k.a a(Context context) {
        String str;
        String sdkVersion = XhsShareSdkTools.getSdkVersion();
        String currentAppPackageName = XhsShareSdkTools.getCurrentAppPackageName(context);
        try {
            str = XhsShareSdkTools.getAppVersionName(context, XhsShareSdkTools.getXhsPackageName());
        } catch (PackageManager.NameNotFoundException e16) {
            XhsShareSdk.d("SDKTracker", "Get package & Get version", e16);
            str = "";
        }
        return new k.a().a("sdk_version", sdkVersion).a("xhs_version", str).a("app_package", currentAppPackageName);
    }

    public static void b(Context context, String str, boolean z16, int i3, String str2, long j3) {
        String str3;
        g h16 = g.h();
        k.a a16 = a(context);
        a16.f424784b = 30758;
        a16.f424785c = 3;
        a16.f424786d.put(ServiceConst.PARA_SESSION_ID, str);
        if (z16) {
            str3 = "SUCCESS";
        } else {
            str3 = Tracker.FAIL;
        }
        a16.f424786d.put("share_result", str3);
        a16.f424786d.put("share_error_code", String.valueOf(i3));
        a16.f424786d.put("share_error_message", str2);
        a16.f424786d.put("time_consume", String.valueOf(j3));
        h16.d(a16);
    }
}
