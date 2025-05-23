package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* loaded from: classes32.dex */
public class PublicAccountDetailDynamicDataManagerServiceImpl implements IPublicAccountDetailDynamicDataManagerService {
    private static final int MAX_CACHE_SIZE = 50;
    private static final String TAG = "AccountDetailDynamicDataManager";
    QQAppInterface app;

    /* renamed from: em, reason: collision with root package name */
    private EntityManager f79073em;
    private MQLruCache<Long, zx.a> mPuin2AccountDetailDynamicInfoCache = new MQLruCache<>(50);

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService
    public Object getAccountDetailDynamicInfoFromCache(String str) {
        long j3;
        try {
            j3 = Long.parseLong(str);
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getAccountDetailDynamicInfoFromCache puin:" + str);
            }
            j3 = 0;
        }
        return getAccountDetailDynamicInfoFromCache(j3);
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService
    public void getDynamicListForFirstEnterFromDB(final AppInterface appInterface, final long j3, final IPublicAccountObserver iPublicAccountObserver) {
        ArrayList arrayList = (ArrayList) getDynamicListFromCache(j3);
        if (arrayList == null || arrayList.isEmpty()) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailDynamicDataManagerServiceImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    PublicAccountDynamicInfoEntityImpl publicAccountDynamicInfoEntityImpl = (PublicAccountDynamicInfoEntityImpl) DBMethodProxy.find(PublicAccountDetailDynamicDataManagerServiceImpl.this.f79073em, (Class<? extends Entity>) PublicAccountDynamicInfoEntityImpl.class, j3);
                    if (publicAccountDynamicInfoEntityImpl == null || j3 != Long.parseLong(publicAccountDynamicInfoEntityImpl.puin) || publicAccountDynamicInfoEntityImpl.dynamicInfoData == null) {
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(PublicAccountDetailDynamicDataManagerServiceImpl.TAG, 2, "getDynamicListForFirstEnterFromDB null != dynamicInfoEntity");
                    }
                    int d16 = com.tencent.biz.pubaccount.accountdetail.model.a.d((QQAppInterface) appInterface, true, publicAccountDynamicInfoEntityImpl.dynamicInfoData, true);
                    zx.a aVar = (zx.a) ((IPublicAccountDetailDynamicDataManagerService) appInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(j3);
                    if (d16 != 0 || aVar == null || aVar.c().isEmpty()) {
                        return;
                    }
                    iPublicAccountObserver.onDynamicListGet(true, d16);
                }
            }, 8, null, true);
        }
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService
    public Object getDynamicListFromCache(long j3) {
        zx.a aVar = (zx.a) getAccountDetailDynamicInfoFromCache(j3);
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        try {
            if (appRuntime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
                this.app = qQAppInterface;
                this.f79073em = qQAppInterface.getEntityManagerFactory().createEntityManager();
            } else {
                QLog.e(TAG, 1, "[onCreate] init error, not in QQAppInterface! appRuntime = " + appRuntime);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[onCreate] init error!", th5);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mPuin2AccountDetailDynamicInfoCache.evictAll();
        this.f79073em.close();
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService
    public synchronized int updateAccountDetailDynamicInfoCache(boolean z16, long j3, long j16, long j17, ArrayList<String> arrayList, boolean z17) {
        zx.a aVar = new zx.a();
        aVar.f453621a = j3;
        aVar.f453623c = j17;
        aVar.f453622b = j16;
        aVar.f453624d = z16;
        zx.a aVar2 = this.mPuin2AccountDetailDynamicInfoCache.get(Long.valueOf(j3));
        if (aVar2 != null) {
            if (j17 == 0) {
                aVar.f453622b = aVar2.f453622b;
            }
            if (!z16) {
                aVar.a(aVar2.c());
            }
        }
        aVar.d(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateAccountDetailDynamicInfoCache puin:" + j3 + " last_msg_id:" + aVar.f453622b + " msg_cnt:" + j17 + " isFirstEnter:" + z16 + " isFromDB:" + z17);
        }
        this.mPuin2AccountDetailDynamicInfoCache.put((MQLruCache<Long, zx.a>) Long.valueOf(j3), (Long) aVar);
        return 0;
    }

    protected boolean updateAccountDetailDynamicInfoDB(long j3, byte[] bArr) {
        PublicAccountDynamicInfoEntityImpl publicAccountDynamicInfoEntityImpl = (PublicAccountDynamicInfoEntityImpl) DBMethodProxy.find(this.f79073em, (Class<? extends Entity>) PublicAccountDynamicInfoEntityImpl.class, j3);
        if (publicAccountDynamicInfoEntityImpl == null) {
            publicAccountDynamicInfoEntityImpl = new PublicAccountDynamicInfoEntityImpl();
        }
        publicAccountDynamicInfoEntityImpl.puin = String.valueOf(j3);
        publicAccountDynamicInfoEntityImpl.dynamicInfoData = bArr;
        return updateEntity(publicAccountDynamicInfoEntityImpl);
    }

    protected boolean updateEntity(Entity entity) {
        if (entity.getStatus() == 1000) {
            this.f79073em.persistOrReplace(entity);
            return entity.getStatus() == 1001;
        }
        if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
            return this.f79073em.update(entity);
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService
    public Object getAccountDetailDynamicInfoFromCache(long j3) {
        return this.mPuin2AccountDetailDynamicInfoCache.get(Long.valueOf(j3));
    }

    @Override // com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService
    public int updateAccountDetailDynamicInfo(final byte[] bArr, boolean z16, long j3, long j16, long j17, ArrayList<String> arrayList, boolean z17) {
        final long j18;
        updateAccountDetailDynamicInfoCache(z16, j3, j16, j17, arrayList, z17);
        if (z17 || !z16 || bArr == null || j17 <= 0) {
            return 0;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateAccountDetailDynamicInfoDB puin:");
            j18 = j3;
            sb5.append(j18);
            sb5.append(" last_msg_id:");
            sb5.append(j16);
            sb5.append(" msg_cnt:");
            sb5.append(j17);
            sb5.append(" isFirstEnter:");
            sb5.append(z16);
            sb5.append(" isFromDB:");
            sb5.append(z17);
            QLog.d(TAG, 2, sb5.toString());
        } else {
            j18 = j3;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailDynamicDataManagerServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountDetailDynamicDataManagerServiceImpl.this.updateAccountDetailDynamicInfoDB(j18, bArr);
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountDetailDynamicDataManagerServiceImpl.TAG, 2, "updateAccountDetailDynamicInfoDB end");
                }
            }
        }, 8, null, true);
        return 0;
    }
}
