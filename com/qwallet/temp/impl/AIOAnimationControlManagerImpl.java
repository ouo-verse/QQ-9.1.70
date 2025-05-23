package com.qwallet.temp.impl;

import com.qwallet.temp.IAIOAnimationControlManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AIOAnimationControlManagerImpl implements IAIOAnimationControlManager {
    private QQAppInterface mApp;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements AIOAnimationControlManager.h {
        a(d4.c cVar) {
        }

        @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
        public String getFriendUin() {
            throw null;
        }

        @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
        public int getLimitType() {
            throw null;
        }

        @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.h
        public long getShmsgseq() {
            throw null;
        }
    }

    private AIOAnimationControlManager getManager() {
        if (checkAppRuntimeInValid()) {
            return null;
        }
        return (AIOAnimationControlManager) this.mApp.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    }

    @Override // com.qwallet.temp.IAIOAnimationControlManager
    public boolean addPlayAnimationList(d4.c cVar, boolean z16) {
        AIOAnimationControlManager manager = getManager();
        if (manager != null) {
            return manager.j(new a(cVar), z16);
        }
        return false;
    }

    public boolean checkAppRuntimeInValid() {
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "checkAppRuntimeInValid: ";
            objArr[1] = Boolean.valueOf(this.mApp == null);
            QLog.d("AIOAnimationControlManagerImpl", 2, objArr);
        }
        return this.mApp == null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            this.mApp = (QQAppInterface) appRuntime;
        }
    }

    @Override // com.qwallet.temp.IAIOAnimationControlManager
    public void removeAllGiftMsgByTroop(String str) {
        AIOAnimationControlManager manager = getManager();
        if (manager != null) {
            manager.E(str);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
