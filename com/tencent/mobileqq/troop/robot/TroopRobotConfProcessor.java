package com.tencent.mobileqq.troop.robot;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import bt2.b;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes19.dex */
public class TroopRobotConfProcessor extends l<b> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b migrateOldOrDefaultContent(int i3) {
        if (QLog.isColorLevel()) {
            QLog.e("TroopRobotConfProcessor", 2, "migrateOldOrDefaultContent ");
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopRobotConfProcessor", 2, "onParsed start");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopRobotConfProcessor", 2, "onParsed " + aiVarArr.length);
            }
            return b.d(aiVarArr[0]);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(b bVar) {
        String str;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onUpdate ");
            if (bVar != null) {
                str = bVar.toString();
            } else {
                str = " empty";
            }
            sb5.append(str);
            QLog.d("TroopRobotConfProcessor", 2, sb5.toString());
        }
        if (bVar != null) {
            ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).updateTroopRobotConfig(bVar.c(), bVar.a());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<b> clazz() {
        return b.class;
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
            QLog.e("TroopRobotConfProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return LocaleManager.MOBILE_COUNTRY_CODE_CN_INT;
    }
}
