package com.tencent.mobileqq.config.business.tendoc;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.nio.charset.StandardCharsets;
import ta1.l;

/* loaded from: classes10.dex */
public class TencentDocLocalCooperationProcessor extends BaseConfigParser<l> {
    public static l c() {
        return (l) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tdoc_local_file_cooperation_bottom_bar");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l defaultConfig() {
        return new l();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public l parse(@NonNull byte[] bArr) {
        return l.d(new String(bArr, StandardCharsets.UTF_8));
    }
}
