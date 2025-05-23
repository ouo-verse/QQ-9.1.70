package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.jsonconverter.a;
import com.tencent.qphone.base.util.QLog;

@Deprecated
/* loaded from: classes20.dex */
public class QVipFeatureSwitchProcessor extends BaseQVipConfigProcessor<QVipFeatureSwitchConfig> {
    public static final int CMD = 648;

    public static QVipFeatureSwitchConfig getConfig() {
        return new QVipFeatureSwitchConfig();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipFeatureSwitchConfig> clazz() {
        return QVipFeatureSwitchConfig.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 648;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipFeatureSwitchConfig migrateDefaultContent() {
        return new QVipFeatureSwitchConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipFeatureSwitchConfig migrateOldContent() {
        return new QVipFeatureSwitchConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipFeatureSwitchConfig parsed(@NonNull ai[] aiVarArr) {
        String str = aiVarArr[0].f202268b;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QVipFeatureSwitchConfig qVipFeatureSwitchConfig = (QVipFeatureSwitchConfig) a.e(str, QVipFeatureSwitchConfig.class);
        if (!QLog.isColorLevel()) {
            return qVipFeatureSwitchConfig;
        }
        QLog.d("QVipFeatureSwitchProcessor", 2, "content:" + str + " config:" + qVipFeatureSwitchConfig.toString());
        return qVipFeatureSwitchConfig;
    }
}
