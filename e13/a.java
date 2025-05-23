package e13;

import android.content.Context;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    public static int a() {
        int mobileInfo;
        int i3 = 0;
        if (!AppNetConnInfo.isNetSupport()) {
            return 0;
        }
        if (AppNetConnInfo.isWifiConn()) {
            return 1;
        }
        if (AppNetConnInfo.isMobileConn() && (mobileInfo = AppNetConnInfo.getMobileInfo()) != -1) {
            i3 = 2;
            if (mobileInfo != 0 && mobileInfo != 1) {
                if (mobileInfo == 2) {
                    return 3;
                }
                if (mobileInfo != 3 && mobileInfo != 4) {
                    return -1;
                }
                return 4;
            }
        }
        return i3;
    }

    public static boolean b(Context context) {
        int a16 = a();
        if (a16 != 4 && a16 != 3) {
            return false;
        }
        return true;
    }

    public static boolean c(Context context) {
        return AppNetConnInfo.isWifiConn();
    }
}
