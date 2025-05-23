package com.tencent.mobileqq.search.tnn.config;

import com.tencent.freesia.BaseConfigParser;
import java.nio.charset.StandardCharsets;
import xp2.a;

/* loaded from: classes18.dex */
public class SearchTnnConfigParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(byte[] bArr) {
        if (bArr.length > 0) {
            return a.b(new String(bArr, StandardCharsets.UTF_8));
        }
        return new a();
    }
}
