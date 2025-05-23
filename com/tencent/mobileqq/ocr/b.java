package com.tencent.mobileqq.ocr;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f254703a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17484);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f254703a = new String[]{"M3X", "U20", "ZTE C2016", "Lenovo K900", "HUAWEI MT7-CL00", "HUAWEI G7-TL00", "PE-CL00", "Moto X Pro", "X907", "ASUS_Z00ADB", "HUAWEI P7-L07", "XT1581", "M821", "R7c"};
        }
    }

    public static boolean a() {
        boolean z16;
        String s16 = ah.s();
        if (!TextUtils.isEmpty(s16)) {
            z16 = false;
            for (String str : f254703a) {
                if (s16.equals(str)) {
                    break;
                }
            }
        }
        z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d("OCRDeviceUtil", 2, "isSupportAddContextMenu mode:" + s16 + ",isSupport: " + z16);
        }
        return z16;
    }
}
