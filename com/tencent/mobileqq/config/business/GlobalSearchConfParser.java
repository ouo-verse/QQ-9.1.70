package com.tencent.mobileqq.config.business;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.search.config.SearchConfig;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class GlobalSearchConfParser extends BaseConfigParser<t> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t defaultConfig() {
        return new t();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable t tVar) {
        SearchConfig.needSeparate = tVar.a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public t parse(@NonNull byte[] bArr) {
        if (bArr.length > 0) {
            return t.c(new String(bArr, StandardCharsets.UTF_8));
        }
        return new t();
    }
}
