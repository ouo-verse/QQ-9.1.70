package com.tencent.biz.qqcircle.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.capability.TPHdrCapability;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class cn {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Pair<String, Integer>> f92748a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static AtomicReference<String> f92749b = new AtomicReference<>();

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<Integer, vd2.g> f92750c;

    /* renamed from: d, reason: collision with root package name */
    private static String f92751d;

    static {
        HashMap<Integer, vd2.g> hashMap = new HashMap<>();
        f92750c = hashMap;
        f92751d = "";
        hashMap.put(3, new vd2.e());
        hashMap.put(0, new vd2.b());
        hashMap.put(1, new vd2.c());
        hashMap.put(2, new vd2.d());
        hashMap.put(4, new vd2.f());
    }

    private static String a() {
        return uq3.o.W("Harmony,29|Harmony,30|M2011K2C,30|RKY-AN00,31");
    }

    public static byte b() {
        if (!uq3.o.s()) {
            return (byte) 0;
        }
        Iterator<Map.Entry<Integer, vd2.g>> it = f92750c.entrySet().iterator();
        byte b16 = 0;
        while (it.hasNext()) {
            try {
                vd2.g value = it.next().getValue();
                String a16 = value.a();
                int e16 = uq3.k.b().e(a16, 127);
                if (e16 == 1) {
                    b16 = (byte) (b16 | value.b());
                    uq3.k.b().m(a16, 1);
                } else if (e16 == 0) {
                    uq3.k.b().m(a16, 0);
                } else if (f(value.d(), value.e())) {
                    b16 = (byte) (b16 | value.b());
                    uq3.k.b().m(a16, 1);
                } else {
                    int c16 = c(value.c());
                    if (1 == c16) {
                        b16 = (byte) (b16 | value.b());
                    }
                    uq3.k.b().m(a16, c16);
                }
            } catch (Exception e17) {
                QLog.e("QFSVideoHDRUtils", 1, e17, new Object[0]);
            }
        }
        String str = ((int) b16) + "|enableHLG:" + (b16 & 1) + "|enableHDR10:" + (b16 & 2) + "|enableHDR10+\uff1a" + (b16 & 4) + "|enableHDRDoBly:" + (b16 & 8) + "|enableHDRVivid:" + (b16 & RegisterType.UNINIT_REF);
        if (!TextUtils.equals(str, f92751d)) {
            f92751d = str;
            QLog.d("QFSVideoHDRUtils", 1, "getHdrTag() result:" + str);
        }
        return b16;
    }

    private static int c(int i3) {
        if (QQVideoPlaySDKManager.isSDKReady() && QQVideoPlaySDKManager.isTpCoreSoExits()) {
            try {
                return TPHdrCapability.getHdrCapability(i3);
            } catch (TPLoadLibraryException unused) {
            }
        }
        return 127;
    }

    private static boolean d(List<Pair<String, Integer>> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (Pair<String, Integer> pair : list) {
            String str = pair.first;
            Integer num = pair.second;
            if (!TextUtils.isEmpty(str) && ((TextUtils.equals(str, "Harmony") && g(num)) || (i(str) && j(num)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean e() {
        String a16 = a();
        if (TextUtils.isEmpty(a16)) {
            return false;
        }
        if (!TextUtils.equals(f92749b.get(), a16)) {
            k(a16);
            f92749b.set(a16);
        }
        return d(f92748a);
    }

    private static boolean f(String str, String str2) {
        try {
            for (String str3 : ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(str, str2).split(";")) {
                if (DeviceInfoMonitor.getModel().equals(str3)) {
                    return true;
                }
            }
        } catch (Exception e16) {
            QLog.w("QFSVideoHDRUtils", 1, "[isHDRsupport] ", e16);
        }
        return false;
    }

    private static boolean g(Integer num) {
        if (h() && j(num)) {
            return true;
        }
        return false;
    }

    private static boolean h() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            String obj = cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString();
            Locale locale = Locale.ROOT;
            return TextUtils.equals("Harmony".toLowerCase(locale), obj.toLowerCase(locale));
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean i(String str) {
        return TextUtils.equals(DeviceInfoMonitor.getModel(), str);
    }

    private static boolean j(Integer num) {
        if (num.intValue() == -1 || num.intValue() == Build.VERSION.SDK_INT) {
            return true;
        }
        return false;
    }

    private static void k(String str) {
        Pair<String, Integer> pair;
        try {
            String[] split = str.split("\\|");
            if (split != null && split.length != 0) {
                f92748a.clear();
                for (String str2 : split) {
                    String[] split2 = str2.split("\\,");
                    if (split2.length >= 2) {
                        pair = new Pair<>(split2[0], Integer.valueOf(split2[1]));
                    } else if (split2.length == 1) {
                        pair = new Pair<>(split2[0], -1);
                    } else {
                        pair = null;
                    }
                    if (pair != null) {
                        f92748a.add(pair);
                    }
                }
                QLog.d("QFSVideoHDRUtils", 1, "[parseHDRBlackDeviceFlag] hdrBlackListStr: " + str);
                return;
            }
            QLog.d("QFSVideoHDRUtils", 4, "[parseHDRBlackDeviceFlag] device info split array should not be null.");
        } catch (Throwable th5) {
            QLog.d("QFSVideoHDRUtils", 1, "[parseHDRBlackDeviceFlag] ex: ", th5);
        }
    }
}
