package com.tencent.gdtad.config.parser;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.config.data.f;
import com.tencent.gdtad.log.GdtLog;

/* loaded from: classes6.dex */
public final class GdtConfigParserForMetricReport extends BaseConfigParser<f> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f defaultConfig() {
        return new f();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f parse(@NonNull byte[] bArr) {
        f fVar = (f) a.a(bArr, f.class, defaultConfig());
        GdtLog.i("GdtConfigParserForMetricReport", "[parse] " + fVar);
        return fVar;
    }
}
