package com.tencent.mobileqq.shortvideo.util;

import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final List<String> f288247a = Arrays.asList("VIVO X7", "VIVO XPLAY5A", "VIVO X6SPLUS", "VIVO X6S A", "REDMI NOTE 3", "REDMI NOTE 4X", "MI 5", "MI-4C", "CAM-AL00", "MLA-AL10", "CAZ-AL10", "VNS-AL00");

    public static boolean a() {
        String str = Build.MANUFACTURER + ";" + DeviceInfoMonitor.getModel();
        String[] split = "Meizu;PRO 6 Plus|samsung;SM-G9250|samsung;SM-G955FD|HUAWEI;CAM-TL00|OPPO;OPPO A37m|OPPO;OPPO A59s|samsung;SM-G9280|samsung;SM-G9200|samsung;SM-G955F|Meizu;Meizu S6".split("\\|");
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                if (str2 != null && str2.equals(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MediaCodecUtil", 2, "isFollowBlackPhone true: " + str);
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 23 || i3 == 24) {
            String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
            Iterator<String> it = f288247a.iterator();
            while (it.hasNext()) {
                if (upperCase.contains(it.next())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean c() {
        Build.MANUFACTURER.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING);
        return false;
    }
}
