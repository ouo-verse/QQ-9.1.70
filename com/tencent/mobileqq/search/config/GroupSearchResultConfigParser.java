package com.tencent.mobileqq.search.config;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import java.nio.charset.StandardCharsets;

/* loaded from: classes18.dex */
public class GroupSearchResultConfigParser extends BaseConfigParser<a> {
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
            return a.b(new String(bArr, StandardCharsets.UTF_8));
        }
        return new a();
    }
}
