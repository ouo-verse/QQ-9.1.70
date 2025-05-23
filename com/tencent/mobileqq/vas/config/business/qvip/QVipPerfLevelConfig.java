package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class QVipPerfLevelConfig {
    private int useApm = 1;

    @NonNull
    public static QVipPerfLevelConfig fromJson(@Nullable String str) {
        QVipPerfLevelConfig qVipPerfLevelConfig = new QVipPerfLevelConfig();
        try {
            if (!TextUtils.isEmpty(str)) {
                qVipPerfLevelConfig.useApm = new JSONObject(str).getInt("use_apm");
            }
        } catch (Exception e16) {
            QLog.e("QVipPerfLevelConfig", 1, "json parse error:" + e16);
        }
        if (QLog.isColorLevel()) {
            QLog.e("QVipPerfLevelConfig", 1, ProgressTracer.SEPARATOR + qVipPerfLevelConfig.toString());
        }
        return qVipPerfLevelConfig;
    }

    @NonNull
    public static QVipPerfLevelConfig obtainDefault() {
        return new QVipPerfLevelConfig();
    }

    public boolean notUseApm() {
        if (this.useApm != 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "QVipPerfLevelConfig{use_apm=" + this.useApm + '}';
    }
}
