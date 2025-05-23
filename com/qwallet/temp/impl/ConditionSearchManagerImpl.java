package com.qwallet.temp.impl;

import com.qwallet.temp.IConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ConditionSearchManagerImpl implements IConditionSearchManager {
    private QQAppInterface mApp;
    private Map<IConditionSearchManager.a, ConditionSearchManager.c> mConfigListeners = new HashMap();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements ConditionSearchManager.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IConditionSearchManager.a f41759a;

        a(IConditionSearchManager.a aVar) {
            this.f41759a = aVar;
        }

        @Override // com.tencent.mobileqq.app.ConditionSearchManager.c
        public void onGetConfig(int i3, boolean z16) {
            IConditionSearchManager.a aVar = this.f41759a;
            if (aVar != null) {
                aVar.onGetConfig(i3, z16);
            }
        }
    }

    private ConditionSearchManager getManager() {
        return (ConditionSearchManager) this.mApp.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
    }

    @Override // com.qwallet.temp.IConditionSearchManager
    public void addListener(IConditionSearchManager.a aVar) {
        if (checkAppRuntimeInValid()) {
            return;
        }
        a aVar2 = new a(aVar);
        getManager().g(aVar2);
        this.mConfigListeners.put(aVar, aVar2);
    }

    public boolean checkAppRuntimeInValid() {
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "checkAppRuntimeInValid: ";
            objArr[1] = Boolean.valueOf(this.mApp == null);
            QLog.d("ConditionSearchManagerImpl", 2, objArr);
        }
        return this.mApp == null;
    }

    @Override // com.qwallet.temp.IConditionSearchManager
    public int checkUpdate() {
        if (checkAppRuntimeInValid()) {
            return 0;
        }
        return getManager().j();
    }

    @Override // com.qwallet.temp.IConditionSearchManager
    public boolean isNetUnAvailable(int i3) {
        if (i3 == 2) {
            return true;
        }
        return false;
    }

    @Override // com.qwallet.temp.IConditionSearchManager
    public boolean isUpdateOk(int i3) {
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            this.mApp = (QQAppInterface) appRuntime;
        }
    }

    @Override // com.qwallet.temp.IConditionSearchManager
    public void removeListener(IConditionSearchManager.a aVar) {
        if (!checkAppRuntimeInValid() && this.mConfigListeners.containsKey(aVar)) {
            getManager().S(this.mConfigListeners.get(aVar));
            this.mConfigListeners.remove(aVar);
        }
    }

    @Override // com.qwallet.temp.IConditionSearchManager
    public int resultOk() {
        return 0;
    }

    @Override // com.qwallet.temp.IConditionSearchManager
    public int update(int i3, boolean z16) {
        if (checkAppRuntimeInValid()) {
            return 0;
        }
        return getManager().h0(i3, z16);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
