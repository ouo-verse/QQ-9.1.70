package com.tencent.mobileqq.config.business;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class TencentDocsIsDetailPageProcessor extends BaseConfigParser<be> {
    public static be c() {
        return (be) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tdoc_is_docs_detail_page_config");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public be defaultConfig() {
        return new be();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public be parse(@NonNull byte[] bArr) {
        return be.b(new String(bArr, StandardCharsets.UTF_8));
    }
}
