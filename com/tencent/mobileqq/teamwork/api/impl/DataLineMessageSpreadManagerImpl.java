package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.teamwork.api.IDataLineMessageSpreadManager;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DataLineMessageSpreadManagerImpl implements IDataLineMessageSpreadManager {
    @Override // com.tencent.mobileqq.teamwork.api.IDataLineMessageSpreadManager
    public void updateConfig(Object obj) {
        if (obj instanceof ta1.g) {
            ta1.g gVar = (ta1.g) obj;
            if (!TextUtils.isEmpty(gVar.f())) {
                ((DataLineMessageSpreadManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER_DATALINE)).n(gVar);
            }
        }
    }
}
