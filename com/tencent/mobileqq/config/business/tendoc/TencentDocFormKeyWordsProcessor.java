package com.tencent.mobileqq.config.business.tendoc;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.nio.charset.StandardCharsets;
import ta1.i;

/* loaded from: classes10.dex */
public class TencentDocFormKeyWordsProcessor extends BaseConfigParser<i> {
    public static i c() {
        return (i) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tdoc_local_form_key_words");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i defaultConfig() {
        return new i();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public i parse(@NonNull byte[] bArr) {
        return i.b(new String(bArr, StandardCharsets.UTF_8));
    }
}
