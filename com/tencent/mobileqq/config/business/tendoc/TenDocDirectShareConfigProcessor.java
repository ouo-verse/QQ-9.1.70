package com.tencent.mobileqq.config.business.tendoc;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class TenDocDirectShareConfigProcessor extends BaseConfigParser<ta1.a> {
    public static ta1.a c() {
        return (ta1.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tdoc_local_file_safe_share");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ta1.a defaultConfig() {
        return new ta1.a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ta1.a parse(@NonNull byte[] bArr) {
        return ta1.a.b(new String(bArr, StandardCharsets.UTF_8));
    }
}
