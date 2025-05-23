package com.tencent.gdtad.config.parser;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.config.data.j;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes6.dex */
public final class GdtConfigParserForQuickApp extends BaseConfigParser<j> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j defaultConfig() {
        return new j();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j parse(@NonNull byte[] bArr) {
        j jVar = (j) a.a(bArr, j.class, defaultConfig());
        QLog.i("GdtConfigParserForQuickApp", 1, "[parse] " + jVar);
        return jVar;
    }
}
