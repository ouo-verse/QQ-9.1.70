package com.tencent.gdtad.config.parser;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.config.data.b;
import com.tencent.gdtad.log.GdtLog;

/* loaded from: classes6.dex */
public final class GdtConfigParserForDeeplinkLaunchTracer extends BaseConfigParser<b> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(@NonNull byte[] bArr) {
        b bVar = (b) a.a(bArr, b.class, defaultConfig());
        GdtLog.i("GdtConfigParserForDeeplinkLaunchTracer", "[parse] " + bVar);
        return bVar;
    }
}
