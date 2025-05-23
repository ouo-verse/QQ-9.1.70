package com.tencent.biz.pubaccount.accountdetail.model;

import android.os.Bundle;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$SetFunctionFlagRequset;
import com.tencent.mobileqq.mp.mobileqq_mp$SetFunctionFlagResponse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AccountDetailBaseInfoModel {
    public static void a(QQAppInterface qQAppInterface, PublicAccountDetailImpl publicAccountDetailImpl) {
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailToDBAndCache");
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        if (publicAccountDetailImpl != null && publicAccountDetailImpl.getId() != -1) {
            if (!createEntityManager.update(publicAccountDetailImpl)) {
                createEntityManager.drop(PublicAccountDetailImpl.class);
            }
        } else {
            createEntityManager.persist(publicAccountDetailImpl);
        }
        createEntityManager.close();
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager == null || publicAccountDetailImpl == null) {
            return;
        }
        iPublicAccountDataManager.saveAccountDetailInfoCache(publicAccountDetailImpl);
        if (publicAccountDetailImpl.followType == 1) {
            iPublicAccountDataManager.savePublicAccountInfo(PublicAccountInfo.createPublicAccount(publicAccountDetailImpl, 0L));
        }
    }

    public static void b(final QQAppInterface qQAppInterface, final String str, final IPublicAccountConfigAttr.a aVar, final int i3) {
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_SET_PUBLIC_FLAG);
        mobileqq_mp$SetFunctionFlagRequset mobileqq_mp_setfunctionflagrequset = new mobileqq_mp$SetFunctionFlagRequset();
        mobileqq_mp_setfunctionflagrequset.version.set(1);
        mobileqq_mp_setfunctionflagrequset.uin.set((int) Long.parseLong(str));
        mobileqq_mp_setfunctionflagrequset.type.set(aVar.f79335g);
        mobileqq_mp_setfunctionflagrequset.value.set(i3);
        mobileqq_mp_setfunctionflagrequset.account_type.set(1);
        newIntent.putExtra("data", mobileqq_mp_setfunctionflagrequset.toByteArray());
        newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.biz.pubaccount.accountdetail.model.AccountDetailBaseInfoModel.1
            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i16, boolean z16, Bundle bundle) {
                if (QLog.isColorLevel()) {
                    QLog.d("AccountDetailBaseInfoModel", 2, "success:" + String.valueOf(z16));
                }
                PublicAccountHandlerImpl publicAccountHandlerImpl = (PublicAccountHandlerImpl) QQAppInterface.this.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
                if (z16) {
                    try {
                        byte[] byteArray = bundle.getByteArray("data");
                        if (byteArray != null) {
                            mobileqq_mp$SetFunctionFlagResponse mobileqq_mp_setfunctionflagresponse = new mobileqq_mp$SetFunctionFlagResponse();
                            mobileqq_mp_setfunctionflagresponse.mergeFrom(byteArray);
                            if (mobileqq_mp_setfunctionflagresponse.ret_info.get().ret_code.get() == 0) {
                                mobileqq_mp_setfunctionflagresponse.ret_info.get().ret_code.get();
                                if (QLog.isColorLevel()) {
                                    QLog.d("AccountDetailBaseInfoModel", 2, "sendSetFunctionFlagRequest success");
                                }
                                aVar.f79334f = i3;
                                IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) QQAppInterface.this.getRuntimeService(IPublicAccountDataManager.class, "all");
                                final PublicAccountDetailImpl publicAccountDetailImpl = iPublicAccountDataManager != null ? (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfo(str) : null;
                                if (publicAccountDetailImpl != null) {
                                    IPublicAccountConfigAttr.a aVar2 = aVar;
                                    int i17 = aVar2.f79335g;
                                    if (i17 == 6) {
                                        int i18 = i3;
                                        if (i18 == 1) {
                                            publicAccountDetailImpl.mShowMsgFlag = i18;
                                        }
                                    } else if (i17 == 3) {
                                        publicAccountDetailImpl.isSyncLbs = true;
                                        publicAccountDetailImpl.isAgreeSyncLbs = aVar2.f79334f == 1;
                                    }
                                    ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.model.AccountDetailBaseInfoModel.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailInSubThread");
                                            }
                                            AccountDetailBaseInfoModel.a(QQAppInterface.this, publicAccountDetailImpl);
                                        }
                                    }, 10L);
                                    publicAccountHandlerImpl.notifyUI(109, true, aVar);
                                    return;
                                }
                                return;
                            }
                            publicAccountHandlerImpl.notifyUI(109, false, aVar);
                            return;
                        }
                        publicAccountHandlerImpl.notifyUI(109, false, aVar);
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                publicAccountHandlerImpl.notifyUI(109, false, aVar);
            }
        });
        qQAppInterface.startServlet(newIntent);
    }
}
