package com.tencent.mobileqq.qmethodmonitor.monitor.config;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import de2.a;
import java.nio.charset.StandardCharsets;

/* loaded from: classes16.dex */
public class DexMonitorConfigParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        return new a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(@NonNull byte[] bArr) {
        a aVar = new a();
        if (bArr != null) {
            a a16 = a.a(new String(bArr, StandardCharsets.UTF_8));
            QLog.d("DexMonitorConfigParser", 1, "configs parse\uff1a" + a16);
            return a16;
        }
        return aVar;
    }
}
