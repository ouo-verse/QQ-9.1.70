package com.tencent.qqperf.monitor.file;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes25.dex */
public class ExternFileMonitorConfigParser extends BaseConfigParser<py3.a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public py3.a defaultConfig() {
        return new py3.a();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public py3.a parse(@NonNull byte[] bArr) {
        py3.a aVar = new py3.a();
        if (bArr != null) {
            py3.a a16 = py3.a.a(new String(bArr, StandardCharsets.UTF_8));
            QLog.d("ExternFileMonitorConfigParser", 1, "configs parse\uff1a" + a16);
            return a16;
        }
        return aVar;
    }
}
