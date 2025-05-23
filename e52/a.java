package e52;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static int a(Context context) {
        int b16 = b(context);
        int i3 = 1;
        if (b16 != 1) {
            i3 = 2;
            if (b16 != 2) {
                i3 = 3;
                if (b16 != 3) {
                    i3 = 4;
                    if (b16 != 4) {
                        return b16 != 5 ? -1 : 0;
                    }
                }
            }
        }
        return i3;
    }

    public static int b(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        int type = NetworkMonitor.getType(activeNetworkInfo);
        if (type != 0) {
            if (type != 1) {
                return type != 9 ? -1 : 5;
            }
            return 1;
        }
        switch (NetworkMonitor.getSubtype(activeNetworkInfo)) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
                return 4;
            case 16:
            default:
                return -1;
        }
    }
}
