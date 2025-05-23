package com.tencent.mobileqq.config;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class ThreadMonitorConfigParser extends BaseConfigParser<au> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public au defaultConfig() {
        return new au();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public au parse(@NonNull byte[] bArr) {
        au auVar = new au();
        if (bArr != null) {
            au a16 = au.a(new String(bArr, StandardCharsets.UTF_8));
            QLog.d("ThreadMonitorConfigParser", 1, "configs parse\uff1a" + a16);
            return a16;
        }
        return auVar;
    }
}
