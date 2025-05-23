package com.qwallet.temp.impl;

import com.qwallet.temp.ITroopGagMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.troopgag.data.d;
import com.tencent.mobileqq.troop.utils.aj;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TroopGagMgrImpl implements ITroopGagMgr {
    private QQAppInterface mApp;

    private aj getManager() {
        return (aj) this.mApp.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
    }

    @Override // com.qwallet.temp.ITroopGagMgr
    public d getSelfGagInfo(String str, boolean z16) {
        return getManager().a(str, z16);
    }

    @Override // com.qwallet.temp.ITroopGagMgr
    public boolean isMySelfSilent(String str) {
        return getManager().e(str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            this.mApp = (QQAppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
