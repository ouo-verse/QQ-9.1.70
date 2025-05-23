package com.tencent.biz.pubaccount.conf;

import com.tencent.luggage.wxa.gf.n0;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import gy.d;

/* loaded from: classes32.dex */
public class PublicAccountLongClickConfProcessor extends l<d> {
    @Override // com.tencent.mobileqq.config.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d migrateOldOrDefaultContent(int i3) {
        return new d();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d onParsed(ai[] aiVarArr) throws QStorageInstantiateException {
        ai aiVar;
        if (aiVarArr != null && aiVarArr.length > 0 && (aiVar = aiVarArr[0]) != null) {
            String str = aiVar.f202268b;
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountLongClickConfProcessor", 2, "onParsed content:\n" + str);
            }
            return d.b(str);
        }
        QLog.e("PublicAccountLongClickConfProcessor", 1, "onParsed no content!!!!");
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(d dVar) {
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountLongClickConfProcessor", 2, "onUpdate");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<d> clazz() {
        return d.class;
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
        QLog.e("PublicAccountLongClickConfProcessor", 1, "onReqFailed: " + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return n0.CTRL_INDEX;
    }
}
