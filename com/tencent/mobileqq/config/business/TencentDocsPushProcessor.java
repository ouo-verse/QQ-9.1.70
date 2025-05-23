package com.tencent.mobileqq.config.business;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class TencentDocsPushProcessor extends BaseConfigParser<bf> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bf defaultConfig() {
        return new bf();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bf parse(@NonNull byte[] bArr) {
        return bf.b(new String(bArr, StandardCharsets.UTF_8));
    }
}
