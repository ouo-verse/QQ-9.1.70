package com.tencent.mobileqq.config.business;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class MiniAppApiReportConfigParser extends BaseConfigParser<y> {
    public static y c() {
        y yVar = (y) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100885");
        if (yVar == null) {
            return new y();
        }
        return yVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public y defaultConfig() {
        return new y();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public y parse(@NonNull byte[] bArr) {
        String str = new String(bArr);
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppApiReportConfigParser", 1, "[onParsed] , content = " + str);
        }
        return y.b(str);
    }
}
