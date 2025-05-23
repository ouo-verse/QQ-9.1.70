package com.tencent.av.ui;

import android.os.Build;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class p {

    /* renamed from: b, reason: collision with root package name */
    private static final String[][] f76185b = {new String[]{"LENOVO", "Lenovo TB-J606F"}, new String[]{"LENOVO", "Lenovo TB-J706F"}, new String[]{"LENOVO", "Lenovo YT-K606F"}, new String[]{"LENOVO", "Lenovo TB-J716F"}, new String[]{"LENOVO", "Lenovo TB-J607F"}};

    /* renamed from: a, reason: collision with root package name */
    private Integer f76186a = null;

    private void b() {
        if (this.f76186a == null) {
            String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qavPadOrientationRotateFlag.name(), String.valueOf(0));
            if (String.valueOf(1).equals(featureValue)) {
                this.f76186a = 1;
            } else if (String.valueOf(2).equals(featureValue)) {
                this.f76186a = 2;
            } else if (c()) {
                this.f76186a = 2;
            } else {
                this.f76186a = 0;
            }
            QLog.i("PadOrientationRotateChecker", 1, "initPadOrientationRotateFlag, value[" + featureValue + "]");
        }
    }

    private boolean c() {
        String str = Build.MANUFACTURER;
        String model = DeviceInfoMonitor.getModel();
        String[][] strArr = f76185b;
        int length = strArr.length;
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String[] strArr2 = strArr[i3];
            if (strArr2[0].equalsIgnoreCase(str) && strArr2[1].equalsIgnoreCase(model)) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PadOrientationRotateChecker", 2, "isDisableDevice, manufacturer[" + str + "], model[" + model + "], isDisableDevice[" + z16 + "]");
        }
        return z16;
    }

    public boolean a() {
        if (this.f76186a == null) {
            b();
        }
        if (2 != this.f76186a.intValue()) {
            return true;
        }
        return false;
    }
}
