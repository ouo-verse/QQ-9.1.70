package com.tencent.biz.pubaccount.conf;

import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import gy.a;
import mqq.app.AppRuntime;

/* loaded from: classes32.dex */
public class PaSubscribeRedDotProcessor extends l<a> {
    @Override // com.tencent.mobileqq.config.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a onParsed(ai[] aiVarArr) {
        if (QLog.isColorLevel()) {
            QLog.d("PaSubscribeRedDotProcessor", 2, "[onParsed]");
        }
        if (aiVarArr == null || aiVarArr.length <= 0) {
            return null;
        }
        return a.d(aiVarArr);
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(a aVar) {
        aVar.e();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return true;
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
        if (!(runtime instanceof QQAppInterface)) {
            return 0;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        return ea.H0(qQAppInterface.getApp(), qQAppInterface.getAccount());
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 35;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        if (i3 == 0) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                return a.a(SubscriptRecommendController.g(qQAppInterface), SubscriptRecommendController.f(qQAppInterface), SubscriptRecommendController.m(qQAppInterface));
            }
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
