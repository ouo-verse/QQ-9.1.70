package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;

/* loaded from: classes20.dex */
public class QVipPubAccountProocessor extends BaseQVipConfigProcessor<QVipPubAccountConfig> {
    public static final int CMD = 651;

    @NonNull
    public static QVipPubAccountConfig get() {
        QVipPubAccountConfig qVipPubAccountConfig = (QVipPubAccountConfig) am.s().x(CMD);
        if (qVipPubAccountConfig == null) {
            return new QVipPubAccountConfig();
        }
        return qVipPubAccountConfig;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipPubAccountConfig> clazz() {
        return QVipPubAccountConfig.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return CMD;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipPubAccountConfig migrateDefaultContent() {
        return new QVipPubAccountConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipPubAccountConfig migrateOldContent() {
        return new QVipPubAccountConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipPubAccountConfig parsed(@NonNull ai[] aiVarArr) {
        return QVipPubAccountConfig.fromJson(aiVarArr[0].f202268b);
    }
}
