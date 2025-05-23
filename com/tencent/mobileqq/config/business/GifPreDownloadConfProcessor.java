package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class GifPreDownloadConfProcessor extends BaseConfigParser<s> {
    public static s d() {
        return (s) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100887");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s defaultConfig() {
        return new s();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(s sVar) {
        if (QLog.isColorLevel()) {
            QLog.d("GifPreDownloadConfProcessor", 2, "onUpdate " + sVar.toString());
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public s parse(@NonNull byte[] bArr) {
        String str = new String(bArr, StandardCharsets.UTF_8);
        if (QLog.isColorLevel()) {
            QLog.d("GifPreDownloadConfProcessor", 2, "onParsed " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return new s();
        }
        return s.d(str);
    }
}
