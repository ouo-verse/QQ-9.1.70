package com.tencent.mobileqq.config;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class WeiYunMiniAppProcessor extends BaseConfigParser<aw> {
    public static aw c() {
        return (aw) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("weiyun_miniapp_entrance");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public aw defaultConfig() {
        return new aw();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public aw parse(@NonNull byte[] bArr) {
        return aw.a(new String(bArr, StandardCharsets.UTF_8));
    }
}
