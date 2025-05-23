package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.business.mutualmark.MutualMarkConfigParser;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class MutualMarkConfProcessor extends com.tencent.mobileqq.config.l<ad> {

    /* renamed from: a, reason: collision with root package name */
    private static ad f202457a;

    public static ad a() {
        ad e16 = MutualMarkConfigParser.e();
        if (QLog.isDebugVersion()) {
            QLog.d("MutualMarkConfProcessor", 1, "loadConfig:" + e16);
        }
        return e16;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ad migrateOldOrDefaultContent(int i3) {
        ad adVar = f202457a;
        if (adVar != null) {
            return adVar;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
        }
        ad a16 = ad.a();
        f202457a = a16;
        return a16;
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ad onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            QLog.d("MutualMarkConfProcessor", 1, "MutualMarkConfProcessor#onParsed: success\uff0cconfFiles:" + aiVarArr);
            int i3 = 0;
            if (com.tencent.relation.common.config.toggle.c.f364712y.g(false)) {
                i3 = aiVarArr.length - 1;
            }
            ad j3 = ad.j(aiVarArr[i3].f202268b);
            f202457a = null;
            return j3;
        }
        QLog.d("MutualMarkConfProcessor", 1, "MutualMarkConfProcessor#onParsed: fail");
        return ad.a();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<ad> clazz() {
        return ad.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(ad adVar) {
        if (QLog.isColorLevel()) {
            QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + adVar);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MutualMarkConfProcessor", 2, "onReqFailed failCode:" + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 524;
    }
}
