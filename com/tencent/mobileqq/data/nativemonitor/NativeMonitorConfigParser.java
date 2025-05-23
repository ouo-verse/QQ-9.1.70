package com.tencent.mobileqq.data.nativemonitor;

import androidx.annotation.NonNull;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class NativeMonitorConfigParser extends BaseConfigParser<NativeMonitorConfig> {
    private static void d(NativeMonitorConfig nativeMonitorConfig) {
        QLog.d(NativeMonitorConfigHelper.TAG, 1, "start to update config:" + nativeMonitorConfig.toString());
        if (nativeMonitorConfig.getTimeLimited() <= -3) {
            nativeMonitorConfig.setTimeLimitedDefault();
            if (QLog.isColorLevel()) {
                QLog.d(NativeMonitorConfigHelper.TAG, 2, "time limited is too small, setToDefault");
            }
        }
        if (nativeMonitorConfig.getMemoryLimited() <= -3) {
            nativeMonitorConfig.setMemoryLimitedDefault();
            if (QLog.isColorLevel()) {
                QLog.d(NativeMonitorConfigHelper.TAG, 2, "memory limited is too small, setToDefault");
            }
        }
        if (nativeMonitorConfig.getCountLimted() <= -3) {
            if (QLog.isColorLevel()) {
                QLog.d(NativeMonitorConfigHelper.TAG, 2, "count limited is too small, setToDefault");
            }
            nativeMonitorConfig.setCountLimitedDefault();
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NativeMonitorConfig defaultConfig() {
        NativeMonitorConfig nativeMonitorConfig = new NativeMonitorConfig();
        d(nativeMonitorConfig);
        return nativeMonitorConfig;
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public NativeMonitorConfig parse(@NonNull byte[] bArr) {
        try {
            NativeMonitorConfig nativeMonitorConfig = (NativeMonitorConfig) com.tencent.mobileqq.jsonconverter.a.f(new JSONObject(new String(bArr, StandardCharsets.UTF_8)), NativeMonitorConfig.class);
            d(nativeMonitorConfig);
            return nativeMonitorConfig;
        } catch (Throwable th5) {
            QLog.e("NativeMonitorConfigPars", 1, th5, new Object[0]);
            return defaultConfig();
        }
    }
}
