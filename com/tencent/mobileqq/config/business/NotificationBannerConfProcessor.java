package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class NotificationBannerConfProcessor extends BaseConfigParser<ae> {
    public static ae d() {
        return (ae) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100810");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ae defaultConfig() {
        return new ae();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(ae aeVar) {
        if (QLog.isColorLevel()) {
            QLog.d("NotificationBannerConfProcessor", 2, "onUpdate " + aeVar.toString());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ae parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("NotificationBannerConfProcessor", 2, "NotificationBannerBean parse null");
            }
            return new ae();
        }
        if (QLog.isColorLevel()) {
            QLog.d("NotificationBannerConfProcessor", 2, "onParsed " + str);
        }
        return ae.d(str);
    }
}
