package com.tencent.qqperf.monitor.filedescriptor;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes25.dex */
public class FileDescriptorMonitorConfigProcessor extends BaseConfigParser<a> {
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
            QLog.d("FileDescriptorMonitorConfigProcessor", 1, "parse: \n" + str);
            aVar.f(str);
            return aVar;
        } catch (Throwable th5) {
            try {
                QLog.e("FileDescriptorMonitorConfigProcessor", 1, "parse failed!", th5);
            } catch (Throwable unused) {
            }
            return aVar;
        }
    }
}
