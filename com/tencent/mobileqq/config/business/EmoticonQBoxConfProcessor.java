package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.business.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class EmoticonQBoxConfProcessor extends BaseConfigParser<k> {
    public static k c() {
        k kVar = (k) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101318");
        if (kVar == null) {
            return new k();
        }
        return kVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k defaultConfig() {
        return new k();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public k parse(@NonNull byte[] bArr) {
        k.a aVar;
        String str = new String(bArr, StandardCharsets.UTF_8);
        QLog.e("EmoticonQBoxConfProcessor", 1, "EmoticonQBoxConfProcessor.[onParsed] content=" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                aVar = (k.a) com.tencent.mobileqq.config.as.e(str, k.a.class);
            } catch (QStorageInstantiateException e16) {
                QLog.e("EmoticonQBoxConfProcessor", 1, "readJsonOrXml failed", e16);
                aVar = null;
            }
            return new k(str, aVar);
        }
        return new k();
    }
}
