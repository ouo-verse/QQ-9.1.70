package com.tencent.mobileqq.config.business.tendoc;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.nio.charset.StandardCharsets;
import ta1.b;

/* loaded from: classes10.dex */
public class TenDocGroupListEntryConfigProcessor extends BaseConfigParser<b> {
    public static b c() {
        return (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tdoc_group_online_entrance_support_url");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(@NonNull byte[] bArr) {
        return b.c(new String(bArr, StandardCharsets.UTF_8));
    }
}
