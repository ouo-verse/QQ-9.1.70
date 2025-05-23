package com.tencent.mobileqq.ark.config.qqmc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import d91.f;

/* loaded from: classes11.dex */
public class ArkFavConfigParser extends BaseConfigParser<f> {
    public static f c() {
        return (f) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101301");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f defaultConfig() {
        return new f();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public f parse(@NonNull byte[] bArr) {
        String str = new String(bArr);
        if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkFavConfigParser", 1, "ArkFavConfigParser [onParsed] , content = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return new f();
        }
        return f.b(str);
    }
}
