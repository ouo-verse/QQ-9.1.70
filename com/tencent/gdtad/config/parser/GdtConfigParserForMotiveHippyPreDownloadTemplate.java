package com.tencent.gdtad.config.parser;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.config.data.h;
import com.tencent.gdtad.log.GdtLog;

/* loaded from: classes6.dex */
public final class GdtConfigParserForMotiveHippyPreDownloadTemplate extends BaseConfigParser<h> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h defaultConfig() {
        return new h();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h parse(@NonNull byte[] bArr) {
        h hVar = (h) a.a(bArr, h.class, defaultConfig());
        try {
            GdtLog.i("GdtConfigParserForMotiveHippyPreDownloadTemplate", "[parse] " + hVar);
        } catch (Throwable th5) {
            GdtLog.e("GdtConfigParserForMotiveHippyPreDownloadTemplate", "[parse]", th5);
        }
        return hVar;
    }
}
