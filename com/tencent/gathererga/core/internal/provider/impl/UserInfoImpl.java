package com.tencent.gathererga.core.internal.provider.impl;

import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.tencent.ad.tangram.system.AdTelephonyManager;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.gathererga.core.UserInfoProvider;
import com.tencent.gathererga.core.f;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.gathererga.core.internal.util.n;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public class UserInfoImpl implements UserInfoProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Integer> f108246b;

    /* renamed from: a, reason: collision with root package name */
    private Context f108247a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56057);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            f108246b = new HashMap<String, Integer>() { // from class: com.tencent.gathererga.core.internal.provider.impl.UserInfoImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put("46000", 1);
                    put("46002", 1);
                    put("46007", 1);
                    put("46008", 1);
                    put("46001", 2);
                    put("46006", 2);
                    put("46009", 2);
                    put("46003", 3);
                    put("46005", 3);
                    put("46011", 3);
                }
            };
        }
    }

    public UserInfoImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f108247a = null;
        }
    }

    private static f i(int i3) {
        Object num = new Integer(1);
        Object num2 = new Integer(2);
        Object num3 = new Integer(3);
        Object num4 = new Integer(4);
        try {
            num = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_2_G").get(TelephonyManager.class);
            num2 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_3_G").get(TelephonyManager.class);
            num3 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_4_G").get(TelephonyManager.class);
            num4 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_5_G").get(TelephonyManager.class);
        } catch (Throwable th5) {
            com.tencent.gathererga.core.internal.util.d.c("getDataTypeOnAndroidQ", th5);
        }
        try {
            Object invoke = TelephonyManager.class.getDeclaredMethod("getNetworkClass", Integer.TYPE).invoke(TelephonyManager.class, Integer.valueOf(i3));
            if (invoke.equals(num)) {
                return new com.tencent.gathererga.core.internal.provider.c(0L, 2);
            }
            if (invoke.equals(num2)) {
                return new com.tencent.gathererga.core.internal.provider.c(0L, 3);
            }
            if (invoke.equals(num3)) {
                return new com.tencent.gathererga.core.internal.provider.c(0L, 4);
            }
            if (invoke.equals(num4)) {
                return new com.tencent.gathererga.core.internal.provider.c(0L, 7);
            }
            return new com.tencent.gathererga.core.internal.provider.c(-300L, 0);
        } catch (Throwable th6) {
            com.tencent.gathererga.core.internal.util.d.c("getDataTypeOnAndroidQ", th6);
            return new com.tencent.gathererga.core.internal.provider.c(-300L, 0);
        }
    }

    private static f j(int i3) {
        long a16 = n.a(i3);
        if ((AdTelephonyManager.NETWORK_CLASS_BITMASK_2G & a16) != 0) {
            return new com.tencent.gathererga.core.internal.provider.c(0L, 2);
        }
        if ((AdTelephonyManager.NETWORK_CLASS_BITMASK_3G & a16) != 0) {
            return new com.tencent.gathererga.core.internal.provider.c(0L, 3);
        }
        if ((AdTelephonyManager.NETWORK_CLASS_BITMASK_4G & a16) != 0) {
            return new com.tencent.gathererga.core.internal.provider.c(0L, 4);
        }
        if ((a16 & 524288) != 0) {
            return new com.tencent.gathererga.core.internal.provider.c(0L, 7);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-300L, 0);
    }

    private String k() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f108247a.getSystemService("phone");
            if (telephonyManager.getSimState() == 5) {
                return DeviceInfoMonitor.getSimOperator(telephonyManager);
            }
            return null;
        } catch (Throwable th5) {
            com.tencent.gathererga.core.internal.util.d.a("Get operator encounter exception: " + th5.getMessage());
            return null;
        }
    }

    public static boolean l() {
        if (!TextUtils.isEmpty("HUAWEI")) {
            String[] split = "HUAWEI".split(",");
            if (split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(Build.MANUFACTURER)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean m(Context context) {
        if (com.tencent.gathererga.core.internal.util.b.b() >= 29 && l()) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                Method method = TelephonyManager.class.getMethod("getServiceState", new Class[0]);
                method.setAccessible(true);
                ServiceState serviceState = (ServiceState) method.invoke(telephonyManager, new Object[0]);
                if (serviceState != null) {
                    Method method2 = ServiceState.class.getMethod("getHwNetworkType", new Class[0]);
                    method2.setAccessible(true);
                    int intValue = ((Integer) method2.invoke(serviceState, new Object[0])).intValue();
                    com.tencent.gathererga.core.internal.util.d.a("UserInfoProviderImpl isHuawei5G - networkType: " + intValue);
                    if (intValue != 20) {
                        return false;
                    }
                    return true;
                }
            } catch (Throwable th5) {
                com.tencent.gathererga.core.internal.util.d.g("UserInfoProviderImpl isHuawei5G call failed", th5);
            }
        }
        return false;
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 407)
    public f getBootTime(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (f) iPatchRedirector.redirect((short) 18, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 307, permissions = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_WIFI_STATE"})
    public f getBssid(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (f) iPatchRedirector.redirect((short) 9, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-305L, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 305)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f getCarrier(com.tencent.gathererga.core.e eVar, boolean z16) {
        String str;
        Integer value;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        Object obj = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (f) iPatchRedirector.redirect((short) 5, this, eVar, Boolean.valueOf(z16));
        }
        try {
            str = k();
        } catch (Throwable th5) {
            th = th5;
            str = null;
        }
        try {
        } catch (Throwable th6) {
            th = th6;
            com.tencent.gathererga.core.internal.util.d.a("Get carrier encounter exception: " + th.getMessage());
            i3 = -300;
            long j3 = i3;
            if (z16) {
            }
            return new com.tencent.gathererga.core.internal.provider.c(j3, obj);
        }
        if (TextUtils.isEmpty(str)) {
            return new com.tencent.gathererga.core.internal.provider.c(0, obj);
        }
        for (Map.Entry<String, Integer> entry : f108246b.entrySet()) {
            if (str.startsWith(entry.getKey())) {
                long j16 = 0;
                if (z16) {
                    value = str;
                } else {
                    value = entry.getValue();
                }
                return new com.tencent.gathererga.core.internal.provider.c(j16, value);
            }
        }
        long j36 = i3;
        if (z16) {
            obj = str;
        }
        return new com.tencent.gathererga.core.internal.provider.c(j36, obj);
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 303)
    public f getCountry(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (f) iPatchRedirector.redirect((short) 16, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, this.f108247a.getResources().getConfiguration().locale.getCountry());
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 319)
    public f getCurrentVolume(com.tencent.gathererga.core.e eVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (f) iPatchRedirector.redirect((short) 22, (Object) this, (Object) eVar, i3);
        }
        try {
            return new com.tencent.gathererga.core.internal.provider.c(0L, Integer.valueOf(SystemMethodProxy.getStreamVolume((AudioManager) this.f108247a.getSystemService("audio"), i3)));
        } catch (Throwable th5) {
            com.tencent.gathererga.core.internal.util.d.a("getMinVolume streamType=" + i3 + ", exception:" + th5.getMessage());
            return new com.tencent.gathererga.core.internal.provider.c(-300L, null);
        }
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 315, permissions = {"android.permission.ACCESS_NETWORK_STATE"})
    public f getIpAddress(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-300L, "0.0.0.0");
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 304)
    public f getLanguage(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Locale.getDefault().getLanguage());
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 309, permissions = {"android.permission.ACCESS_FINE_LOCATION"})
    public f getLatitude(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (f) iPatchRedirector.redirect((short) 14, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Double.valueOf(0.0d));
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 323)
    public f getLocalCountry(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (f) iPatchRedirector.redirect((short) 17, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Locale.getDefault().getCountry());
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 310, permissions = {"android.permission.ACCESS_FINE_LOCATION"})
    public f getLongitude(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (f) iPatchRedirector.redirect((short) 15, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Double.valueOf(0.0d));
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 320)
    public f getMaxVolume(com.tencent.gathererga.core.e eVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (f) iPatchRedirector.redirect((short) 20, (Object) this, (Object) eVar, i3);
        }
        try {
            return new com.tencent.gathererga.core.internal.provider.c(0L, Integer.valueOf(((AudioManager) this.f108247a.getSystemService("audio")).getStreamMaxVolume(i3)));
        } catch (Throwable th5) {
            com.tencent.gathererga.core.internal.util.d.a("getMaxVolume streamType=" + i3 + ", exception:" + th5.getMessage());
            return new com.tencent.gathererga.core.internal.provider.c(-300L, null);
        }
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 321)
    public f getMinVolume(com.tencent.gathererga.core.e eVar, int i3) {
        int streamMinVolume;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (f) iPatchRedirector.redirect((short) 21, (Object) this, (Object) eVar, i3);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                streamMinVolume = ((AudioManager) this.f108247a.getSystemService("audio")).getStreamMinVolume(i3);
                return new com.tencent.gathererga.core.internal.provider.c(0L, Integer.valueOf(streamMinVolume));
            } catch (Throwable th5) {
                com.tencent.gathererga.core.internal.util.d.a("getMinVolume streamType=" + i3 + ", exception:" + th5.getMessage());
                return new com.tencent.gathererga.core.internal.provider.c(-300L, null);
            }
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, 0);
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 313)
    public f getMobileNetworkType(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (f) iPatchRedirector.redirect((short) 10, (Object) this, (Object) eVar);
        }
        try {
            if (((ConnectivityManager) this.f108247a.getSystemService("connectivity")).getActiveNetworkInfo() != null) {
                return new com.tencent.gathererga.core.internal.provider.c(0L, "" + NetworkMonitor.getNetworkType((TelephonyManager) this.f108247a.getSystemService("phone")));
            }
            return new com.tencent.gathererga.core.internal.provider.c(-300L, null);
        } catch (Exception unused) {
            return new com.tencent.gathererga.core.internal.provider.c(-300L, null);
        }
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 312, permissions = {"android.permission.ACCESS_NETWORK_STATE"})
    public f getNetworkType(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (f) iPatchRedirector.redirect((short) 11, (Object) this, (Object) eVar);
        }
        Context context = this.f108247a;
        if (context == null) {
            return new com.tencent.gathererga.core.internal.provider.c(-302L, 0);
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return new com.tencent.gathererga.core.internal.provider.c(-303L, 0);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return new com.tencent.gathererga.core.internal.provider.c(-304L, 0);
            }
            if (m(this.f108247a)) {
                return new com.tencent.gathererga.core.internal.provider.c(0L, 7);
            }
            switch (NetworkMonitor.getType(activeNetworkInfo)) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                    if (com.tencent.gathererga.core.internal.util.b.b() <= 29) {
                        return i(NetworkMonitor.getSubtype(activeNetworkInfo));
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) TelephonyManager.class.cast(this.f108247a.getSystemService("phone"));
                    if (telephonyManager == null) {
                        return new com.tencent.gathererga.core.internal.provider.c(-300L, 0);
                    }
                    return j(NetworkMonitor.getNetworkType(telephonyManager));
                case 1:
                case 6:
                    return new com.tencent.gathererga.core.internal.provider.c(0L, 1);
                default:
                    return new com.tencent.gathererga.core.internal.provider.c(0L, 0);
            }
        } catch (Throwable th5) {
            com.tencent.gathererga.core.internal.util.d.c("getType", th5);
            return new com.tencent.gathererga.core.internal.provider.c(-300L, 0);
        }
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 317)
    public f getScreenOrientation(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (f) iPatchRedirector.redirect((short) 13, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Integer.valueOf(this.f108247a.getResources().getConfiguration().orientation));
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 306)
    public f getTimeZone(com.tencent.gathererga.core.e eVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (f) iPatchRedirector.redirect((short) 6, (Object) this, (Object) eVar);
        }
        String str = "";
        try {
            i3 = 0;
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (AssertionError unused) {
            i3 = -301;
        } catch (Exception unused2) {
            i3 = -300;
        }
        return new com.tencent.gathererga.core.internal.provider.c(i3, str);
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 322)
    public f getTimeZoneID(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (f) iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, TimeZone.getDefault().getID());
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 308)
    public f getUserAgent(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, System.getProperty("http.agent"));
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 318)
    public f getWebviewUa(com.tencent.gathererga.core.e eVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (f) iPatchRedirector.redirect((short) 19, (Object) this, (Object) eVar);
        }
        try {
            if (com.tencent.gathererga.core.internal.util.b.b() >= 17) {
                str = WebSettings.getDefaultUserAgent(this.f108247a);
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                str = new QmWebview(this.f108247a).getSettings().getUserAgentString();
            } else {
                Exchanger exchanger = new Exchanger();
                new Handler(Looper.getMainLooper()).post(new Runnable(exchanger) { // from class: com.tencent.gathererga.core.internal.provider.impl.UserInfoImpl.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Exchanger f108248d;

                    {
                        this.f108248d = exchanger;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UserInfoImpl.this, (Object) exchanger);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        String[] strArr = new String[1];
                        try {
                            strArr[0] = new QmWebview(UserInfoImpl.this.f108247a).getSettings().getUserAgentString();
                        } catch (Exception e16) {
                            com.tencent.gathererga.core.internal.util.d.c("runnable getUserAgent", e16);
                        }
                        try {
                            this.f108248d.exchange(strArr[0]);
                        } catch (InterruptedException e17) {
                            com.tencent.gathererga.core.internal.util.d.b(e17.getMessage());
                        }
                    }
                });
                try {
                    str = (String) exchanger.exchange(null, 500L, TimeUnit.MILLISECONDS);
                } catch (Exception e16) {
                    com.tencent.gathererga.core.internal.util.d.b(e16.getMessage());
                    return new com.tencent.gathererga.core.internal.provider.c(-300L, null);
                }
            }
            return new com.tencent.gathererga.core.internal.provider.c(0L, str);
        } catch (Exception e17) {
            com.tencent.gathererga.core.internal.util.d.c(DKWebViewController.DKHippyWebviewFunction.GET_USER_AGENT, e17);
            return new com.tencent.gathererga.core.internal.provider.c(-300L, null);
        }
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider
    @InfoID(id = 316)
    public f isRooted(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (f) iPatchRedirector.redirect((short) 12, (Object) this, (Object) eVar);
        }
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i3 = 0; i3 < 10; i3++) {
            if (new File(strArr[i3]).exists()) {
                return new com.tencent.gathererga.core.internal.provider.c(0L, Boolean.TRUE);
            }
        }
        return new com.tencent.gathererga.core.internal.provider.c(0L, Boolean.FALSE);
    }

    @Override // com.tencent.gathererga.core.UserInfoProvider, com.tencent.gathererga.core.internal.c
    public void onInit(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.f108247a = context;
        }
    }
}
