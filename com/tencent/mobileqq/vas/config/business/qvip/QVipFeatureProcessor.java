package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.jsonconverter.a;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class QVipFeatureProcessor extends BaseQVipConfigProcessor<QVipFeatureConfig> {
    public static final int CMD = 690;
    static final String TAG = "QVIP.SDK.QVipFeatureProcessor";

    public static QVipFeatureConfig get() {
        QVipFeatureConfig qVipFeatureConfig;
        try {
            qVipFeatureConfig = (QVipFeatureConfig) am.s().x(690);
        } catch (Throwable th5) {
            th5.printStackTrace();
            qVipFeatureConfig = null;
        }
        if (qVipFeatureConfig == null) {
            return new QVipFeatureConfig();
        }
        return qVipFeatureConfig;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipFeatureConfig> clazz() {
        return QVipFeatureConfig.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 690;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipFeatureConfig migrateDefaultContent() {
        return new QVipFeatureConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipFeatureConfig migrateOldContent() {
        return new QVipFeatureConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipFeatureConfig parsed(@NonNull ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, aiVarArr[0].f202268b);
        }
        try {
            String str = aiVarArr[0].f202268b;
            if (!TextUtils.isEmpty(str)) {
                QVipFeatureConfig qVipFeatureConfig = (QVipFeatureConfig) a.e(str, QVipFeatureConfig.class);
                qVipFeatureConfig.onParsedConfigFinished();
                return qVipFeatureConfig;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return new QVipFeatureConfig();
    }
}
