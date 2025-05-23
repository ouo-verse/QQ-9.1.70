package com.tencent.gdtad.config.parser;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.log.GdtLog;

/* loaded from: classes6.dex */
public final class GdtConfigParserForAnalysisReport extends BaseConfigParser<com.tencent.gdtad.config.data.a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.gdtad.config.data.a defaultConfig() {
        return new com.tencent.gdtad.config.data.a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.tencent.gdtad.config.data.a parse(@NonNull byte[] bArr) {
        com.tencent.gdtad.config.data.a aVar = (com.tencent.gdtad.config.data.a) a.a(bArr, com.tencent.gdtad.config.data.a.class, defaultConfig());
        GdtLog.i("GdtConfigParserForAnalysisReport", "[parse] " + aVar);
        return aVar;
    }
}
