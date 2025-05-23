package com.tencent.gdtad.config.parser;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.config.data.k;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes6.dex */
public final class GdtConfigParserForWXCustomerService extends BaseConfigParser<k> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k defaultConfig() {
        return new k();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public k parse(@NonNull byte[] bArr) {
        k kVar = (k) a.a(bArr, k.class, defaultConfig());
        QLog.i("GdtConfigParserForWXCustomerService", 1, "[parse] " + kVar);
        return kVar;
    }
}
