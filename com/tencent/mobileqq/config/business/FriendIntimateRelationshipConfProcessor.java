package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.business.intimate.IntimateSwitchConfigParser;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes10.dex */
public class FriendIntimateRelationshipConfProcessor extends com.tencent.mobileqq.config.l<q> {
    @NonNull
    public static q a() {
        return IntimateSwitchConfigParser.e();
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q migrateOldOrDefaultContent(int i3) {
        return new q();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            q a16 = q.a(aiVarArr[0].f202268b);
            if (QLog.isColorLevel()) {
                QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onParsed " + aiVarArr[0].f202268b);
            }
            return a16;
        }
        return new q();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<q> clazz() {
        return q.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onUpdate(q qVar) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onUpdate newConf:" + qVar);
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
            QLog.d("FriendIntimateRelationshipConfProcessor", 2, "onReqFailed failCode:" + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 455;
    }
}
