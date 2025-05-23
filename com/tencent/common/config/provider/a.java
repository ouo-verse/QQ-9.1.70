package com.tencent.common.config.provider;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f99587a;

    /* renamed from: b, reason: collision with root package name */
    public static String f99588b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, String> f99589c;

    /* renamed from: d, reason: collision with root package name */
    static String f99590d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66020);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f99587a = a.class.getName();
        f99588b = "EXTRA_DATAV1";
        f99589c = null;
        f99590d = "wns_share_data";
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void a(Map<String, String> map) {
        if (map != null && true != map.isEmpty() && BaseApplication.getContext() != null) {
            long c16 = b.c();
            QLog.d("ConfigProvider", 2, "last_check_time:" + c16);
            if (System.currentTimeMillis() - c16 > 86400000) {
                ArrayList arrayList = new ArrayList();
                for (String str : map.keySet()) {
                    String[] split = map.get(str).split(":");
                    if (split != null && split.length >= 2) {
                        long d16 = d(split[1]);
                        if (d16 > 0 && System.currentTimeMillis() - d16 > 2592000000L) {
                            arrayList.add(str);
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    map.remove((String) it.next());
                }
                arrayList.clear();
                QLog.e("ConfigProvider", 2, " last_check_time:" + System.currentTimeMillis());
                b.f(System.currentTimeMillis());
            }
        }
    }

    public static boolean b(Map<String, byte[]> map, boolean z16) {
        Iterator<String> it;
        if (map == null) {
            return false;
        }
        Iterator<String> it5 = map.keySet().iterator();
        boolean z17 = false;
        while (it5.hasNext()) {
            String next = it5.next();
            if (next != null && next.equals(QzoneConfig.MAIN_KEY_EXTRA_CONFIG)) {
                byte[] bArr = map.get(next);
                UniAttribute uniAttribute = new UniAttribute();
                uniAttribute.decode(bArr);
                for (String str : uniAttribute.getKeySet()) {
                    String str2 = (String) uniAttribute.get(str);
                    if (str != null && str.equals(QzoneConfig.SECONDARY_WIFI_OPERATOR_CRARRY) && str2 != null) {
                        QLog.d("QzoneIPStracyConfig", 2, str + ContainerUtils.KEY_VALUE_DELIMITER + str2);
                        try {
                        } catch (Exception e16) {
                            it = it5;
                            QLog.i("ConfigProvider", 2, "receive WiFiOperator error,value=" + str2, e16);
                            z17 = true;
                        }
                        if (Integer.valueOf(str2).intValue() < 0) {
                            QLog.i("ConfigProvider", 2, "receive WiFiOperator error,value=" + str2);
                            z17 = true;
                        } else {
                            if (NetworkState.isWifiConn()) {
                                if (!z16) {
                                    WiFiDash.updateBSSID();
                                }
                                String bssid = WiFiDash.getBSSID();
                                if (bssid != null) {
                                    g(bssid, str2 + ":" + System.currentTimeMillis());
                                    QLog.d("QzoneIPStracyConfig", 2, "save bssid=" + bssid + ",value=" + str2 + ":" + System.currentTimeMillis());
                                }
                            } else {
                                if (!z16) {
                                    NetworkState.isNetSupport();
                                }
                                String apn = NetworkState.getAPN();
                                if (apn != null) {
                                    String lowerCase = apn.toLowerCase();
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(str2);
                                    sb5.append(":");
                                    it = it5;
                                    sb5.append(System.currentTimeMillis());
                                    g(lowerCase, sb5.toString());
                                    QLog.d("QzoneIPStracyConfig", 2, "save apn=" + apn.toLowerCase() + ",value=" + str2 + ":" + System.currentTimeMillis());
                                    z17 = false;
                                }
                            }
                            it = it5;
                            z17 = false;
                        }
                    } else {
                        it = it5;
                    }
                    it5 = it;
                }
            }
            it5 = it5;
        }
        return z17;
    }

    public static void c(int i3) {
        String str;
        if (i3 <= 0) {
            return;
        }
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 8) {
                        str = "";
                    } else {
                        str = "1";
                    }
                } else {
                    str = "2";
                }
            } else {
                str = "0";
            }
        } else {
            str = "3";
        }
        if (!TextUtils.isEmpty(str)) {
            f(str);
        }
    }

    private static long d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return -1L;
        }
    }

    public static int e() {
        String apn;
        String str;
        String[] split;
        try {
            Map<String, String> e16 = b.e();
            if (e16 == null) {
                return 0;
            }
            if (NetworkState.isWifiConn()) {
                apn = WiFiDash.getBSSID();
            } else {
                apn = NetworkState.getAPN();
            }
            if (apn == null || (str = e16.get(apn)) == null || (split = str.split(":")) == null || split.length <= 0) {
                return 0;
            }
            return Integer.valueOf(split[0]).intValue();
        } catch (Exception e17) {
            QLog.e(f99587a, 2, "read wifi operator by bssid fail", e17);
            return 0;
        }
    }

    public static void f(String str) {
        if (NetworkState.isWifiConn()) {
            String bssid = WiFiDash.getBSSID();
            if (bssid != null) {
                g(bssid, str + ":" + System.currentTimeMillis());
                QLog.d("QzoneIPStracyConfig", 2, "save bssid=" + bssid + ",value=" + str + ":" + System.currentTimeMillis());
                return;
            }
            return;
        }
        String apn = NetworkState.getAPN();
        if (apn != null) {
            g(apn.toLowerCase(), str + ":" + System.currentTimeMillis());
            QLog.d("QzoneIPStracyConfig", 2, "save apn=" + apn.toLowerCase() + ",value=" + str + ":" + System.currentTimeMillis());
        }
    }

    public static void g(String str, String str2) {
        Map<String, String> e16 = b.e();
        f99589c = e16;
        if (e16 != null) {
            e16.put(str, str2);
        } else {
            HashMap hashMap = new HashMap();
            f99589c = hashMap;
            hashMap.put(str, str2);
        }
        a(f99589c);
        b.g(f99589c);
    }
}
