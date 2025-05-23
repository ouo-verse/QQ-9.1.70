package com.tencent.mobileqq.config.business.tendoc;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import java.nio.charset.StandardCharsets;
import ta1.r;

/* loaded from: classes10.dex */
public class TencentDocUserConfigProcessor extends BaseConfigParser<r> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r defaultConfig() {
        return new r();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r parse(@NonNull byte[] bArr) {
        return r.a(new String(bArr, StandardCharsets.UTF_8));
    }
}
