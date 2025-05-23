package com.tencent.gamecenter.wadl.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.luggage.wxa.wh.c;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import ol0.a;

/* loaded from: classes6.dex */
public class FloatingPermissionConfProcessor extends l<a> {
    public static a a() {
        a aVar = (a) am.s().x(c.CTRL_INDEX);
        if (QLog.isColorLevel() && aVar != null) {
            QLog.i("Wadl_FloatingPermissionConfProcessor", 2, "loadConfig " + aVar.toString());
        }
        return aVar;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_FloatingPermissionConfProcessor", 2, "onParsed ");
        }
        if (aiVarArr != null && aiVarArr.length > 0) {
            new a();
            return a.a(aiVarArr);
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
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_FloatingPermissionConfProcessor", 2, "onUpdate " + aVar.toString());
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return true;
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
            QLog.d("Wadl_FloatingPermissionConfProcessor", 2, "onReqFailed " + i3);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return c.CTRL_INDEX;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqNoReceive() {
    }
}
