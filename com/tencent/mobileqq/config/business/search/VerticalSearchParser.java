package com.tencent.mobileqq.config.business.search;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import java.nio.charset.StandardCharsets;
import sa1.c;

/* loaded from: classes10.dex */
public class VerticalSearchParser extends BaseConfigParser<c> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c defaultConfig() {
        return new c();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c parse(@NonNull byte[] bArr) {
        if (bArr.length > 0) {
            return c.h(new String(bArr, StandardCharsets.UTF_8));
        }
        return new c();
    }
}
