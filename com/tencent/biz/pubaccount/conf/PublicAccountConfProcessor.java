package com.tencent.biz.pubaccount.conf;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import gy.c;
import mqq.app.AppRuntime;

/* loaded from: classes32.dex */
public class PublicAccountConfProcessor extends l<c> {
    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountConfProcessor", 2, "[onParsed]");
        }
        if (aiVarArr == null || aiVarArr.length <= 0) {
            return null;
        }
        return c.d(aiVarArr);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(c cVar) {
        cVar.a();
        cVar.e();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<c> clazz() {
        return c.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return ea.M0(((QQAppInterface) runtime).getApp());
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 32;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c migrateOldOrDefaultContent(int i3) {
        if (i3 == 0) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                return c.c(ea.L0(((QQAppInterface) runtime).getApplication()));
            }
        }
        return new c();
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
