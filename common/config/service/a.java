package common.config.service;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a implements QzoneConfig.a {
    @Override // common.config.service.QzoneConfig.a
    public Boolean a(String str, String str2, boolean z16) {
        if (!c(str) || !d(str2) || TextUtils.equals(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(str2, ""), "getConfigFromWNS")) {
            return null;
        }
        return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str2, z16));
    }

    @Override // common.config.service.QzoneConfig.a
    public String b(String str, String str2) {
        if (!c(str) || !d(str2)) {
            return null;
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(str2, "");
        if (TextUtils.equals(loadAsString, "getConfigFromWNS")) {
            return null;
        }
        return loadAsString;
    }

    public boolean c(String str) {
        return TextUtils.equals(str, "qqcircle");
    }

    public boolean d(String str) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).getConfigVersion(str) != 0) {
            return true;
        }
        return false;
    }
}
