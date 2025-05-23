package com.tencent.biz.pubaccount.api.impl;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.api.IPublicAccountCheck;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.j;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EnterpriseQQHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class PublicAccountCheckImpl extends AsyncStep<Automator> implements IPublicAccountCheck {
    private static final String PREF_KEY_APP_VERSION = "isPublicAccountListAppVersion";
    PublicAccountObserverImpl mPublicAccountObserver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends IPublicAccountObserver.c {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onUpdateUserFollowList(int i3, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "PublicAccount onUpdateUserFollowList:" + z16 + " " + i3);
            }
            if (z16 && i3 == 0) {
                ((Automator) PublicAccountCheckImpl.this.mAutomator).f195307f.edit().putBoolean("isPublicAccountListOK", true).putString(PublicAccountCheckImpl.PREF_KEY_APP_VERSION, AppSetting.f99551k).commit();
                PublicAccountCheckImpl.this.setResult(7);
            } else if (i3 != 0) {
                PublicAccountCheckImpl.this.setResult(6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        PublicAccountHandlerImpl publicAccountHandlerImpl = (PublicAccountHandlerImpl) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
        if (this.mStepId == 5) {
            boolean z16 = ((Automator) this.mAutomator).f195307f.getBoolean("isPublicAccountListOK", false);
            String string = ((Automator) this.mAutomator).f195307f.getString(PREF_KEY_APP_VERSION, "");
            if (z16 && AppSetting.f99551k.equals(string)) {
                return 7;
            }
            registeObserver();
            publicAccountHandlerImpl.setNotNeedUpdate();
            j.Companion companion = com.tencent.biz.pubaccount.util.j.INSTANCE;
            boolean g16 = companion.g();
            if (companion.e(g16) == 2) {
                publicAccountHandlerImpl.clearPublicAccountSeq();
            }
            publicAccountHandlerImpl.getUserFollowList(g16, 1);
            return 2;
        }
        boolean isNeedUpdate = publicAccountHandlerImpl.isNeedUpdate();
        j.Companion companion2 = com.tencent.biz.pubaccount.util.j.INSTANCE;
        boolean g17 = companion2.g();
        boolean f16 = companion2.f();
        int e16 = companion2.e(g17);
        if (e16 != 0) {
            companion2.h(false);
            f16 = false;
        }
        boolean z17 = !publicAccountHandlerImpl.hasStepRequestFollowList() && (!f16 || g17);
        QLog.d("IAutomator", 1, "STEP_UPDATE_PUBLIC needUpdate: " + isNeedUpdate + " needPullList: " + z17 + " state: " + e16);
        if (isNeedUpdate || z17) {
            registeObserver();
            if (e16 == 2) {
                publicAccountHandlerImpl.clearPublicAccountSeq();
            }
            publicAccountHandlerImpl.getUserFollowList(g17, 1);
        }
        SharedPreferences sharedPreferences = ((Automator) this.mAutomator).E.getApplication().getApplicationContext().getSharedPreferences(((Automator) this.mAutomator).E.getAccount(), 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - sharedPreferences.getLong("eqqlist_login_update_ts", 0L) > 86400000) {
            EnterpriseQQHandler enterpriseQQHandler = (EnterpriseQQHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.ENTERPRISEQQ_HANDLER);
            if (enterpriseQQHandler != null) {
                enterpriseQQHandler.D2(SystemClock.uptimeMillis());
            }
            sharedPreferences.edit().putLong("eqqlist_login_update_ts", currentTimeMillis);
        }
        ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).initSubscribeFolderRedDotStyle(g17);
        companion2.j(false);
        return isNeedUpdate ? 2 : 7;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        PublicAccountObserverImpl publicAccountObserverImpl = this.mPublicAccountObserver;
        if (publicAccountObserverImpl != null) {
            ((Automator) this.mAutomator).E.removeObserver(publicAccountObserverImpl);
            this.mPublicAccountObserver = null;
        }
    }

    void registeObserver() {
        if (this.mPublicAccountObserver == null) {
            PublicAccountObserverImpl publicAccountObserverImpl = new PublicAccountObserverImpl();
            this.mPublicAccountObserver = publicAccountObserverImpl;
            publicAccountObserverImpl.setOnCallback(new a());
            ((Automator) this.mAutomator).E.addObserver(this.mPublicAccountObserver);
        }
    }
}
