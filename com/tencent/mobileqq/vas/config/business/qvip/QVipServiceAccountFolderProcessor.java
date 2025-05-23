package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.jsonconverter.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class QVipServiceAccountFolderProcessor extends BaseQVipConfigProcessor<QVipServiceAccountFolderConfig> {
    public static final int CMD = 722;
    static final String TAG = "QVIP.SDK.QVipServiceAccountFolderProcessor";

    public static QVipServiceAccountFolderConfig getConfig() {
        QVipServiceAccountFolderConfig qVipServiceAccountFolderConfig = (QVipServiceAccountFolderConfig) am.s().x(CMD);
        if (qVipServiceAccountFolderConfig == null) {
            return new QVipServiceAccountFolderConfig();
        }
        return qVipServiceAccountFolderConfig;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipServiceAccountFolderConfig> clazz() {
        return QVipServiceAccountFolderConfig.class;
    }

    public void setSplashEnable(boolean z16) {
        BaseApplication.getContext().getSharedPreferences(AppConstants.BANNER_AND_SPLASH, 4).edit().putBoolean("showRecommendPage", z16).commit();
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return CMD;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipServiceAccountFolderConfig migrateDefaultContent() {
        return new QVipServiceAccountFolderConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipServiceAccountFolderConfig migrateOldContent() {
        return new QVipServiceAccountFolderConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipServiceAccountFolderConfig parsed(@NonNull ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, aiVarArr[0].f202268b);
        }
        try {
            String str = aiVarArr[0].f202268b;
            if (!TextUtils.isEmpty(str)) {
                QVipServiceAccountFolderConfig qVipServiceAccountFolderConfig = (QVipServiceAccountFolderConfig) a.e(str, QVipServiceAccountFolderConfig.class);
                setSplashEnable(qVipServiceAccountFolderConfig.showRecommendPage);
                return qVipServiceAccountFolderConfig;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return new QVipServiceAccountFolderConfig();
    }
}
