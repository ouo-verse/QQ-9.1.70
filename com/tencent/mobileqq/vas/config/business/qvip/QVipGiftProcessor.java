package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.jsonconverter.a;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class QVipGiftProcessor extends BaseQVipConfigProcessor<QVipGiftConfig> {
    public static final int CMD = 667;
    static final String TAG = "QVIP.SDK.QVipGfitProcessor";

    public static QVipGiftConfig getConfig() {
        QVipGiftConfig qVipGiftConfig = (QVipGiftConfig) am.s().x(CMD);
        if (qVipGiftConfig == null) {
            return new QVipGiftConfig();
        }
        return qVipGiftConfig;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipGiftConfig> clazz() {
        return QVipGiftConfig.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return CMD;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipGiftConfig migrateDefaultContent() {
        return new QVipGiftConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipGiftConfig migrateOldContent() {
        return new QVipGiftConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipGiftConfig parsed(@NonNull ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, aiVarArr[0].f202268b);
        }
        String str = aiVarArr[0].f202268b;
        QVipGiftConfig qVipGiftConfig = !TextUtils.isEmpty(str) ? (QVipGiftConfig) a.e(str, QVipGiftConfig.class) : null;
        return qVipGiftConfig == null ? new QVipGiftConfig() : qVipGiftConfig;
    }
}
