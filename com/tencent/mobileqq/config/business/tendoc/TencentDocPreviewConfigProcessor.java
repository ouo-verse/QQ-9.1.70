package com.tencent.mobileqq.config.business.tendoc;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.nio.charset.StandardCharsets;
import ta1.o;

/* loaded from: classes10.dex */
public class TencentDocPreviewConfigProcessor extends BaseConfigParser<o> {
    public static o c() {
        return (o) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("tdoc_local_file_online_preview_use_tencent_doc");
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o defaultConfig() {
        return new o();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public o parse(@NonNull byte[] bArr) {
        return o.b(new String(bArr, StandardCharsets.UTF_8));
    }
}
