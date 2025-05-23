package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.teamwork.api.IAIOMessageSpreadManager;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AIOMessageSpreadManagerImpl implements IAIOMessageSpreadManager {
    @Override // com.tencent.mobileqq.teamwork.api.IAIOMessageSpreadManager
    public void updateConfig(Object obj) {
        if (obj instanceof ta1.q) {
            ta1.q qVar = (ta1.q) obj;
            if (!TextUtils.isEmpty(qVar.k())) {
                ((AIOMessageSpreadManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).s(qVar);
            }
        }
    }
}
