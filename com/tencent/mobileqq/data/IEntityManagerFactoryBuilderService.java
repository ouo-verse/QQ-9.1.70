package com.tencent.mobileqq.data;

import com.tencent.mobileqq.data.entitymanager.OnDBTableVerifyFailListener;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.data.entitymanager.upgrade.IAfterDBUpgradeListener;
import com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener;
import com.tencent.mobileqq.persistence.Entity;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface IEntityManagerFactoryBuilderService {
    Provider<Entity[]> getDBCreateTableProvider();

    IAfterDBUpgradeListener getDBUpGradeFinishListener();

    IOnDBUpgradeListener getDBUpGradeListener();

    OnDBTableVerifyFailListener getDBVerifyFailHandler();
}
