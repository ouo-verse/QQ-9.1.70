package com.tencent.mobileqq.config.business.search;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import java.nio.charset.StandardCharsets;
import sa1.a;

/* loaded from: classes10.dex */
public class SearchHotWordConfParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        if (bArr.length > 0) {
            return a.g(new String(bArr, StandardCharsets.UTF_8));
        }
        return new a();
    }
}
