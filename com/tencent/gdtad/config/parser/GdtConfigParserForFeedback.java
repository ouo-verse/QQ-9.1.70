package com.tencent.gdtad.config.parser;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.config.data.d;
import com.tencent.gdtad.log.GdtLog;

/* loaded from: classes6.dex */
public final class GdtConfigParserForFeedback extends BaseConfigParser<d> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d defaultConfig() {
        return new d();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d parse(@NonNull byte[] bArr) {
        d dVar = (d) a.a(bArr, d.class, defaultConfig());
        GdtLog.i("GdtConfigParserForFeedback", "[parse] " + dVar);
        return dVar;
    }
}
