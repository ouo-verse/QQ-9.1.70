package com.tencent.mobileqq.config.business.tendoc;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.nio.charset.StandardCharsets;
import ta1.m;

/* loaded from: classes10.dex */
public class TencentDocMyFileNameProcessor extends BaseConfigParser<m> {
    public static m c() {
        return (m) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tdoc_my_file_tencent_doc_name");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m defaultConfig() {
        return new m();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public m parse(@NonNull byte[] bArr) {
        return m.a(new String(bArr, StandardCharsets.UTF_8));
    }
}
