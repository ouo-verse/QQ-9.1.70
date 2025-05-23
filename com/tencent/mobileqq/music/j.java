package com.tencent.mobileqq.music;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String[] f251884a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33901);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f251884a = new String[]{"samsung SM-N7508V", "samsung SM-N9002", "samsung SM-N9005", "samsung SM-N9006", "samsung SM-N9008", "samsung SM-N9009", "samsung SM-N9009V", "samsung SM-G3858", "samsung SM-G7108V", "samsung SM-G7108U", "samsung SM-G9008V", "samsung GT-I9308I", "samsung GT-I9508V", "samsung SM-G3588V", "samsung SM-T2558", "samsung SM-G9300", "HTC T528w", "MI 3", "HTC 802t", "GT-I9100", "GT-I9300", "SCH-I939", "MX4", "HUAWEI C8813D"};
        }
    }

    public static boolean a() {
        String model = DeviceInfoMonitor.getModel();
        String[] strArr = f251884a;
        int length = strArr.length;
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (strArr[i3].contains(model)) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "isPhoneInWhiteList \uff1a phone = " + model + ", result=" + z16);
        }
        return z16;
    }
}
