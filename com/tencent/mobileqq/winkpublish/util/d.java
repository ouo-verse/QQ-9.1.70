package com.tencent.mobileqq.winkpublish.util;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Integer> f327442a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, Boolean> f327443b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static String f327444c = null;

    /* renamed from: d, reason: collision with root package name */
    private static List<b> f327445d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private static INetEventHandler f327446e = new a();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements INetEventHandler {
        a() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            QLog.i("NetworkState", 1, "--onNetChangeEvent isNetEffective:" + z16);
            d.n(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface b {
        void onNetworkConnect(boolean z16);
    }

    static {
        f327442a.put("unknown", 0);
        f327442a.put("cmnet", 1);
        f327442a.put("cmwap", 2);
        f327442a.put("3gnet", 3);
        f327442a.put("3gwap", 4);
        f327442a.put("uninet", 5);
        f327442a.put("uniwap", 6);
        f327442a.put("wifi", 7);
        f327442a.put("ctwap", 8);
        f327442a.put("ctnet", 9);
        f327442a.put("cmcc", 10);
        f327442a.put("unicom", 11);
        f327442a.put("cmct", 12);
        o();
    }

    public static String c() {
        if (AppNetConnInfo.isWifiConn()) {
            return "wifi";
        }
        String currentAPN = AppNetConnInfo.getCurrentAPN();
        return TextUtils.isEmpty(currentAPN) ? "unknown" : currentAPN;
    }

    public static int d() {
        NetworkInfo recentNetworkInfo;
        if (!AppNetConnInfo.isNetSupport() || (recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo()) == null || !recentNetworkInfo.isConnectedOrConnecting()) {
            return 0;
        }
        if (1 == NetworkMonitor.getType(recentNetworkInfo)) {
            return 4;
        }
        switch (f327442a.get(NetworkMonitor.netGetExInfo(recentNetworkInfo)) != null ? f327442a.get(NetworkMonitor.netGetExInfo(recentNetworkInfo)).intValue() : 5) {
            case 1:
            case 2:
            case 10:
                return 1;
            case 3:
            case 4:
            case 5:
            case 6:
            case 11:
                return 2;
            case 7:
                return 4;
            case 8:
            case 9:
            case 12:
                return 3;
            default:
                return 0;
        }
    }

    public static boolean e() {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (f327443b.get(account) != null) {
            return f327443b.get(account).booleanValue();
        }
        boolean z16 = 1 == LocalMultiProcConfig.getInt4UinString("key_force_wifi_to_4g", 0, account);
        f327443b.put(account, Boolean.valueOf(z16));
        return z16;
    }

    private static boolean g() {
        return k() && !f();
    }

    public static int h() {
        if (AppNetConnInfo.isWifiConn()) {
            return 1;
        }
        if (AppNetConnInfo.isMobileConn()) {
            int mobileInfo = AppNetConnInfo.getMobileInfo();
            int i3 = 2;
            if (mobileInfo != 1) {
                if (mobileInfo == 2) {
                    return 3;
                }
                i3 = 4;
                if (mobileInfo != 3) {
                    if (mobileInfo == 4) {
                        return 5;
                    }
                }
            }
            return i3;
        }
        return 0;
    }

    public static String i() {
        return "unknown";
    }

    public static boolean j() {
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            return f();
        }
        return AppNetConnInfo.isMobileConn();
    }

    public static boolean k() {
        return AppNetConnInfo.isNetSupport();
    }

    public static boolean l() {
        int i3;
        if (!AppNetConnInfo.isMobileConn()) {
            return false;
        }
        try {
            i3 = f327442a.get(AppNetConnInfo.getCurrentAPN()).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = 5;
        }
        return i3 == 2 || i3 == 4 || i3 == 6 || i3 == 8;
    }

    public static boolean m() {
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            return g();
        }
        return AppNetConnInfo.isWifiConn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(boolean z16) {
        int size;
        b[] bVarArr;
        synchronized (f327445d) {
            size = f327445d.size();
            bVarArr = new b[size];
            f327445d.toArray(bVarArr);
        }
        for (int i3 = 0; i3 < size; i3++) {
            bVarArr[i3].onNetworkConnect(z16);
        }
    }

    public static void o() {
        try {
            AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), f327446e);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static boolean f() {
        try {
            if (!k()) {
                return false;
            }
            if (AppNetConnInfo.isWifiConn()) {
                return e();
            }
            return true;
        } catch (Exception e16) {
            QLog.e("NetworkState", 1, "getIsMobileForDebugVersion error", e16);
            return AppNetConnInfo.isMobileConn();
        }
    }

    public static void b(b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (f327445d) {
            if (!f327445d.contains(bVar)) {
                f327445d.add(bVar);
            }
        }
    }
}
