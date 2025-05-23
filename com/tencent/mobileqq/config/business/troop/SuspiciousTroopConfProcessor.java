package com.tencent.mobileqq.config.business.troop;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qphone.base.util.QLog;
import va1.a;

/* loaded from: classes10.dex */
public class SuspiciousTroopConfProcessor extends l<a> {
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        if (QLog.isColorLevel()) {
            QLog.e("SuspiciousTroopConfProcessor", 2, "migrateOldOrDefaultContent ");
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed start");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SuspiciousTroopConfProcessor", 2, "onParsed " + aiVarArr.length);
            }
            return a.a(aiVarArr[0]);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        String str;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onUpdate ");
            if (aVar != null) {
                str = aVar.toString();
            } else {
                str = " empty";
            }
            sb5.append(str);
            QLog.d("SuspiciousTroopConfProcessor", 2, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
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
            QLog.e("SuspiciousTroopConfProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT_CONTAINER;
    }
}
