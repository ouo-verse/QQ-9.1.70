package com.tencent.mobileqq.config.business.newfriend;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.hippy.qq.update.qarchive.tools.zip.UnixStat;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import ra1.a;

/* loaded from: classes10.dex */
public class SysSuspiciousConfProcessor extends l<a> {
    public static a a() {
        a aVar = (a) am.s().x(UnixStat.DEFAULT_DIR_PERM);
        if (aVar == null) {
            return new a();
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        if (QLog.isColorLevel()) {
            QLog.e("SearchBusinessConfProcessor", 2, "migrateOldOrDefaultContent ");
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("SearchBusinessConfProcessor", 2, "onParsed start");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchBusinessConfProcessor", 2, "onParsed " + aiVarArr.length);
            }
            return a.b(aiVarArr[0]);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
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
            QLog.d("SearchBusinessConfProcessor", 2, sb5.toString());
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
            QLog.e("SearchBusinessConfProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return UnixStat.DEFAULT_DIR_PERM;
    }
}
