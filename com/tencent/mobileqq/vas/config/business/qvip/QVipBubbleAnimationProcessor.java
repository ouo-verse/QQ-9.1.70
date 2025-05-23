package com.tencent.mobileqq.vas.config.business.qvip;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class QVipBubbleAnimationProcessor extends BaseQVipConfigProcessor<QVipBubbleAnimationConfig> {
    public static final int CMD = 727;
    public static final String QVIP_SDK_TAG = "QVIP.SDK.";
    static final String TAG = "QVIP.SDK.QVipServiceAccountFolderProcessor";

    public static QVipBubbleAnimationConfig getConfig() {
        QVipBubbleAnimationConfig qVipBubbleAnimationConfig = (QVipBubbleAnimationConfig) am.s().x(CMD);
        if (qVipBubbleAnimationConfig == null) {
            return new QVipBubbleAnimationConfig();
        }
        return qVipBubbleAnimationConfig;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipBubbleAnimationConfig> clazz() {
        return QVipBubbleAnimationConfig.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return CMD;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipBubbleAnimationConfig migrateDefaultContent() {
        return new QVipBubbleAnimationConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipBubbleAnimationConfig migrateOldContent() {
        return new QVipBubbleAnimationConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipBubbleAnimationConfig parsed(@NonNull ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, aiVarArr[0].f202268b);
        }
        QVipBubbleAnimationConfig qVipBubbleAnimationConfig = new QVipBubbleAnimationConfig();
        try {
            String str = aiVarArr[0].f202268b;
            if (!TextUtils.isEmpty(str)) {
                qVipBubbleAnimationConfig.json = str;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return qVipBubbleAnimationConfig;
    }
}
