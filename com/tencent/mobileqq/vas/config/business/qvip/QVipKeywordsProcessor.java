package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.ai;

/* loaded from: classes20.dex */
public class QVipKeywordsProcessor extends BaseQVipConfigProcessor<QVipKeywordsConfig> {
    public static final int CMD = 76;
    private static final String TAG = "QVipKeywordsProcessor";

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipKeywordsConfig> clazz() {
        return QVipKeywordsConfig.class;
    }

    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor, com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 76;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipKeywordsConfig migrateDefaultContent() {
        return new QVipKeywordsConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipKeywordsConfig migrateOldContent() {
        return new QVipKeywordsConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipKeywordsConfig parsed(ai[] aiVarArr) {
        return new QVipKeywordsConfig();
    }
}
