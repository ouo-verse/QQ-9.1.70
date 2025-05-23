package com.tencent.gdtad.config.parser;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.config.data.i;
import com.tencent.gdtad.log.GdtLog;

/* loaded from: classes6.dex */
public final class GdtConfigParserForMsgReport extends BaseConfigParser<i> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i defaultConfig() {
        return new i();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i parse(@NonNull byte[] bArr) {
        i iVar = (i) a.a(bArr, i.class, defaultConfig());
        GdtLog.i("GdtConfigParserForMsgReport", "[parse] " + iVar);
        return iVar;
    }
}
