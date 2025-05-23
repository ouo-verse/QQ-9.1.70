package com.tencent.mobileqq.persistence.bridge;

import com.tencent.mobileqq.data.IEntityManagerFactoryBuilderService;
import com.tencent.mobileqq.data.entitymanager.OnDBTableVerifyFailListener;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.data.entitymanager.upgrade.IAfterDBUpgradeListener;
import com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener;
import com.tencent.mobileqq.persistence.Entity;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements IEntityManagerFactoryBuilderService {
    @Override // com.tencent.mobileqq.data.IEntityManagerFactoryBuilderService
    public Provider<Entity[]> getDBCreateTableProvider() {
        return new d();
    }

    @Override // com.tencent.mobileqq.data.IEntityManagerFactoryBuilderService
    public IAfterDBUpgradeListener getDBUpGradeFinishListener() {
        return new a();
    }

    @Override // com.tencent.mobileqq.data.IEntityManagerFactoryBuilderService
    public IOnDBUpgradeListener getDBUpGradeListener() {
        return new b();
    }

    @Override // com.tencent.mobileqq.data.IEntityManagerFactoryBuilderService
    public OnDBTableVerifyFailListener getDBVerifyFailHandler() {
        return new DBTableVerifyFailHandler();
    }
}
