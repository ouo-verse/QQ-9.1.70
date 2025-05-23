package com.tencent.mobileqq.filemanager.api.impl;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qlink.a;
import com.tencent.mobileqq.filemanager.api.IQlinkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QlinkUtilsImpl implements IQlinkUtils {
    private static boolean isAllow = true;
    private static boolean isInited = false;

    private static boolean isConfigAllow() {
        QLog.d("QLinkEntranceConfigParser", 1, "isConfigAllow start, brand: " + Build.BRAND + ", MODEL: " + DeviceInfoMonitor.getModel() + ", SDK_INT: " + Build.VERSION.SDK_INT);
        com.tencent.mobileqq.config.business.qlink.a aVar = (com.tencent.mobileqq.config.business.qlink.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101316");
        if (aVar == null) {
            QLog.d("QLinkEntranceConfigParser", 1, "isConfigAllow: true for configs is null");
            return true;
        }
        List<a.C7474a> list = aVar.f202790d;
        if (list != null && !list.isEmpty()) {
            for (a.C7474a c7474a : aVar.f202790d) {
                if (!TextUtils.isEmpty(c7474a.f202792b)) {
                    if (DeviceInfoMonitor.getModel().equalsIgnoreCase(c7474a.f202792b)) {
                        Iterator<Integer> it = c7474a.f202793c.iterator();
                        while (it.hasNext()) {
                            if (it.next().intValue() == Build.VERSION.SDK_INT) {
                                QLog.d("QLinkEntranceConfigParser", 1, "isConfigAllow: false for model");
                                return false;
                            }
                        }
                    } else {
                        continue;
                    }
                } else if (Build.BRAND.equalsIgnoreCase(c7474a.f202791a)) {
                    Iterator<Integer> it5 = c7474a.f202793c.iterator();
                    while (it5.hasNext()) {
                        if (it5.next().intValue() == Build.VERSION.SDK_INT) {
                            QLog.d("QLinkEntranceConfigParser", 1, "isConfigAllow: false for brand");
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            }
            QLog.d("QLinkEntranceConfigParser", 1, "isConfigAllow: true");
            return true;
        }
        QLog.d("QLinkEntranceConfigParser", 1, "isConfigAllow: true for configs is empty");
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.api.IQlinkUtils
    public boolean isAllowToQLink() {
        if (isInited) {
            return isAllow;
        }
        boolean isConfigAllow = isConfigAllow();
        isAllow = isConfigAllow;
        isInited = true;
        return isConfigAllow;
    }
}
