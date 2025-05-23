package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.jsonconverter.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes20.dex */
public class QVipWatchWordProcessor extends BaseQVipConfigProcessor<QVipWatchWordConfig> {
    public static final int CMD = 648;

    public static QVipWatchWordConfig getConfig() {
        return (QVipWatchWordConfig) am.s().x(648);
    }

    public static boolean isShowWatchWord(String str) {
        QVipWatchWordConfig config = getConfig();
        if (config != null && config.isEnable()) {
            if (QLog.isColorLevel()) {
                QLog.d("QVipWatchWordProcessor", 2, "isShowWatchWord:" + str + " configUrl:" + config.getWatchUrl() + " configPattern:" + config.getPattern());
            }
            ArrayList<String> watchUrl = config.getWatchUrl();
            for (int i3 = 0; i3 < watchUrl.size(); i3++) {
                if (str.contains(watchUrl.get(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipWatchWordConfig> clazz() {
        return QVipWatchWordConfig.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 648;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipWatchWordConfig migrateDefaultContent() {
        return new QVipWatchWordConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipWatchWordConfig migrateOldContent() {
        return new QVipWatchWordConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipWatchWordConfig parsed(@NonNull ai[] aiVarArr) {
        String str = aiVarArr[0].f202268b;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QVipWatchWordConfig qVipWatchWordConfig = (QVipWatchWordConfig) a.e(str, QVipWatchWordConfig.class);
        if (!QLog.isColorLevel()) {
            return qVipWatchWordConfig;
        }
        QLog.d("QVipWatchWordProcessor", 2, "content:" + str + " config:" + qVipWatchWordConfig.toString());
        return qVipWatchWordConfig;
    }
}
