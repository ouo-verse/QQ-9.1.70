package com.tencent.gdtad.config.parser;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.config.data.e;
import com.tencent.gdtad.log.GdtLog;

/* loaded from: classes6.dex */
public final class GdtConfigParserForLinkReport extends BaseConfigParser<e> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e defaultConfig() {
        return new e();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e parse(@NonNull byte[] bArr) {
        e eVar = (e) a.a(bArr, e.class, defaultConfig());
        GdtLog.i("GdtConfigParserForLinkReport", "[parse] " + eVar);
        return eVar;
    }
}
