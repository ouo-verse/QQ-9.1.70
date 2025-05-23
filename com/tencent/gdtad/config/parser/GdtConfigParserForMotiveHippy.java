package com.tencent.gdtad.config.parser;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.config.data.g;
import com.tencent.gdtad.log.GdtLog;

/* loaded from: classes6.dex */
public final class GdtConfigParserForMotiveHippy extends BaseConfigParser<g> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g defaultConfig() {
        return new g();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g parse(@NonNull byte[] bArr) {
        g gVar = (g) a.a(bArr, g.class, defaultConfig());
        GdtLog.i("GdtConfigParserForMotiveHippy", "[parse] " + gVar);
        return gVar;
    }
}
