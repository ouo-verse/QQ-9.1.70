package com.tencent.qqperf.monitor.crash.config;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import my3.a;
import my3.b;

/* loaded from: classes25.dex */
public class CrashConfigProcessorForQQmc extends BaseConfigParser<a> {
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
        try {
            String str = new String(bArr);
            QLog.d("CrashConfigProcessorForQQmc", 1, "parse: \n" + str);
            return b.b().c(str);
        } catch (Throwable th5) {
            try {
                QLog.e("CrashConfigProcessorForQQmc", 1, "parse failed!", th5);
            } catch (Throwable unused) {
            }
            return aVar;
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public boolean isAccountRelated() {
        return false;
    }
}
