package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;

/* loaded from: classes20.dex */
public class QVipPrettyAccountProcessor extends BaseQVipConfigProcessor<QVipPrettyAccountConfig> {
    public static final int CMD = 665;

    @NonNull
    public static QVipPrettyAccountConfig get() {
        QVipPrettyAccountConfig qVipPrettyAccountConfig = (QVipPrettyAccountConfig) am.s().x(CMD);
        if (qVipPrettyAccountConfig == null) {
            return new QVipPrettyAccountConfig();
        }
        return qVipPrettyAccountConfig;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipPrettyAccountConfig> clazz() {
        return QVipPrettyAccountConfig.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return CMD;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipPrettyAccountConfig migrateDefaultContent() {
        return new QVipPrettyAccountConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipPrettyAccountConfig migrateOldContent() {
        return new QVipPrettyAccountConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipPrettyAccountConfig parsed(@NonNull ai[] aiVarArr) {
        return QVipPrettyAccountConfig.fromJson(aiVarArr[0].f202268b);
    }
}
