package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class QVipPerfLevelProcessor extends BaseQVipConfigProcessor<QVipPerfLevelConfig> {
    public static final int CMD = 580;
    static final String TAG = "QVIP.PERF.ConfigProcessor";

    @NonNull
    public static QVipPerfLevelConfig get() {
        QVipPerfLevelConfig qVipPerfLevelConfig = (QVipPerfLevelConfig) am.s().x(580);
        if (qVipPerfLevelConfig == null) {
            return QVipPerfLevelConfig.obtainDefault();
        }
        return qVipPerfLevelConfig;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipPerfLevelConfig> clazz() {
        return QVipPerfLevelConfig.class;
    }

    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor, com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 580;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipPerfLevelConfig migrateDefaultContent() {
        return QVipPerfLevelConfig.obtainDefault();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipPerfLevelConfig migrateOldContent() {
        return QVipPerfLevelConfig.obtainDefault();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipPerfLevelConfig parsed(@NonNull ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, aiVarArr[0].f202268b);
        }
        return QVipPerfLevelConfig.fromJson(aiVarArr[0].f202268b);
    }
}
