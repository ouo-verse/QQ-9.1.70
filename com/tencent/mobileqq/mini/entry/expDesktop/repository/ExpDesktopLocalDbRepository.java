package com.tencent.mobileqq.mini.entry.expDesktop.repository;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppEntityV3;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopLocalDataHelper;
import com.tencent.mobileqq.mini.manager.MiniAppBubbleManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u001aH\u0002J6\u0010\u001b\u001a\u00020\u00062\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u00162\n\u0010\u001e\u001a\u00060\u001fj\u0002` H\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J8\u0010%\u001a\u00020\u00062\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00170'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00162\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/ExpDesktopLocalDbRepository;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/IExpDesktopLocalDbRepository;", "()V", "mMiniAppBubbleManager", "Lcom/tencent/mobileqq/mini/manager/MiniAppBubbleManager;", "deleteMiniAppCacheInfo", "", "entity", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "deleteMiniAppDbInfo", "getMiniAppDesktopLocalCacheInfo", "localDataCallback", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpDesktopLocalDataHelper$MiniAppLocalDataCallback;", "getUpdateEntityTransaction", "Lcom/tencent/mobileqq/persistence/transaction/BaseTransaction;", "e", "Lcom/tencent/mobileqq/persistence/Entity;", "insertMiniAppDbInfo", "desktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "miniAppBubblePreloadAddFromDB", "resetDesktopAppInfoToDesktopItemInfo", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "desktopAppInfos", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateDbEntity", "appInfoList", "transactionList", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "updateEntity", "", "em", "Lcom/tencent/mobileqq/persistence/EntityManager;", "updateMiniAppDbInfoWithBatch", "personalModuleMap", "", "", "recommendModule", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "rankModules", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ExpDesktopLocalDbRepository implements IExpDesktopLocalDbRepository {
    private static final String TAG = "ExpDesktopLocalDbRepository";
    private final MiniAppBubbleManager mMiniAppBubbleManager = new MiniAppBubbleManager();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteMiniAppDbInfo$lambda$0(MiniAppInfo entity, EntityManager entityManager) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        DesktopAppEntityV3 desktopAppEntityV3 = new DesktopAppEntityV3(entity);
        try {
            desktopAppEntityV3.setStatus(1001);
            if (entityManager.remove(desktopAppEntityV3, "uniqueId=?", new String[]{desktopAppEntityV3.uniqueId})) {
                QLog.d(TAG, 2, "deleteEntity, delete " + desktopAppEntityV3.name + " success from db");
            } else {
                QLog.d(TAG, 2, "deleteEntity, delete " + desktopAppEntityV3.name + " fail from db");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "deleteEntity, Exception:" + th5);
        }
    }

    private final BaseTransaction<?> getUpdateEntityTransaction(Entity e16) {
        if (e16.getStatus() == 1000) {
            return new PersistOrReplaceTransaction(e16);
        }
        if (e16.getStatus() == 1001 || e16.getStatus() == 1002) {
            return new UpdateTransaction(e16);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertMiniAppDbInfo$lambda$1(DesktopAppInfo desktopAppInfo, ExpDesktopLocalDbRepository this$0, EntityManager entityManager) {
        Intrinsics.checkNotNullParameter(desktopAppInfo, "$desktopAppInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DesktopAppEntityV3 desktopAppEntityV3 = new DesktopAppEntityV3(desktopAppInfo.mMiniAppInfo);
        desktopAppEntityV3.setStatus(1000);
        Intrinsics.checkNotNullExpressionValue(entityManager, "entityManager");
        this$0.updateEntity(entityManager, desktopAppEntityV3);
    }

    private final boolean updateEntity(EntityManager em5, Entity e16) {
        boolean z16 = false;
        if (em5.isOpen()) {
            if (e16.getStatus() == 1000) {
                em5.persistOrReplace(e16);
                if (e16.getStatus() == 1001) {
                    z16 = true;
                }
            } else if (e16.getStatus() == 1001 || e16.getStatus() == 1002) {
                z16 = em5.update(e16);
            }
            em5.close();
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateEntity em closed e=" + e16.getTableName());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMiniAppDbInfoWithBatch$lambda$3(Map personalModuleMap, ExpDesktopLocalDbRepository this$0, List recentAppInfoList, List recommendModule, List rankModules, EntityManager entityManager) {
        List filterNotNull;
        Intrinsics.checkNotNullParameter(personalModuleMap, "$personalModuleMap");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recentAppInfoList, "$recentAppInfoList");
        Intrinsics.checkNotNullParameter(recommendModule, "$recommendModule");
        Intrinsics.checkNotNullParameter(rankModules, "$rankModules");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        if (personalModuleMap.get(3) != null) {
            Object obj = personalModuleMap.get(3);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
            this$0.updateDbEntity(this$0.resetDesktopAppInfoToDesktopItemInfo(((ExpDesktopGroupAppInfo) obj).getGroupAppInfo()), arrayList, sb5);
        }
        if (personalModuleMap.get(1) != null) {
            this$0.updateDbEntity(recentAppInfoList, arrayList, sb5);
        }
        if (!recommendModule.isEmpty()) {
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(recommendModule);
            Iterator it = filterNotNull.iterator();
            while (it.hasNext()) {
                this$0.updateDbEntity(this$0.resetDesktopAppInfoToDesktopItemInfo(((ExpDesktopGroupAppInfo) it.next()).getGroupAppInfo()), arrayList, sb5);
            }
        }
        if ((!rankModules.isEmpty()) && rankModules.get(0) != null && (!((ExpDesktopRankTabAppInfo) rankModules.get(0)).getRankSubTabAppInfo().isEmpty())) {
            this$0.updateDbEntity(this$0.resetDesktopAppInfoToDesktopItemInfo(((ExpDesktopRankTabAppInfo) rankModules.get(0)).getRankSubTabAppInfo().get(0).getRankAppInfo()), arrayList, sb5);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "insertEntityWithBatch : ", sb5.toString());
        }
        try {
            entityManager.doMultiDBOperateByTransaction(arrayList);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "insertEntityWithBatch exception: ", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void deleteMiniAppCacheInfo(MiniAppInfo entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        MiniCacheFreeManager.freeCache(BaseApplicationImpl.getApplication().getRuntime().getAccount(), entity);
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void deleteMiniAppDbInfo(final MiniAppInfo entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "getAppInterface is null!");
            return;
        }
        final EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            QLog.e(TAG, 1, "entityManager is null!");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.a
                @Override // java.lang.Runnable
                public final void run() {
                    ExpDesktopLocalDbRepository.deleteMiniAppDbInfo$lambda$0(MiniAppInfo.this, createEntityManager);
                }
            }, 32, null, false);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void getMiniAppDesktopLocalCacheInfo(final MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback localDataCallback) {
        Intrinsics.checkNotNullParameter(localDataCallback, "localDataCallback");
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.e(TAG, 1, "initLocalDataRunnable, app is null.");
        } else {
            MiniAppExpDesktopLocalDataHelper.INSTANCE.getInstance().initLocalDesktopData(new MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.ExpDesktopLocalDbRepository$getMiniAppDesktopLocalCacheInfo$1
                @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback
                public void getLocalDataFailed(String errorMsg) {
                    MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback.this.getLocalDataFailed(errorMsg);
                    QLog.e("ExpDesktopLocalDbRepository", 1, "getLocalDataFailed :" + errorMsg);
                }

                @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback
                public void getLocalDataSuccess(Map<Integer, DesktopItemInfo> personalModuleMap, List<ExpDesktopGroupAppInfo> recommendModules, List<ExpDesktopRankTabAppInfo> rankModules) {
                    Intrinsics.checkNotNullParameter(personalModuleMap, "personalModuleMap");
                    Intrinsics.checkNotNullParameter(recommendModules, "recommendModules");
                    Intrinsics.checkNotNullParameter(rankModules, "rankModules");
                    MiniAppExpDesktopLocalDataHelper.MiniAppLocalDataCallback.this.getLocalDataSuccess(personalModuleMap, recommendModules, rankModules);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void insertMiniAppDbInfo(final DesktopAppInfo desktopAppInfo) {
        Intrinsics.checkNotNullParameter(desktopAppInfo, "desktopAppInfo");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "getAppInterface is null!");
            return;
        }
        final EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            QLog.e(TAG, 1, "entityManager is null!");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.c
                @Override // java.lang.Runnable
                public final void run() {
                    ExpDesktopLocalDbRepository.insertMiniAppDbInfo$lambda$1(DesktopAppInfo.this, this, createEntityManager);
                }
            }, 32, null, true);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void miniAppBubblePreloadAddFromDB() {
        this.mMiniAppBubbleManager.preloadAllFromDB();
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalDbRepository
    public void updateMiniAppDbInfoWithBatch(final Map<Integer, DesktopItemInfo> personalModuleMap, final List<ExpDesktopGroupAppInfo> recommendModule, final List<ExpDesktopRankTabAppInfo> rankModules) {
        Intrinsics.checkNotNullParameter(personalModuleMap, "personalModuleMap");
        Intrinsics.checkNotNullParameter(recommendModule, "recommendModule");
        Intrinsics.checkNotNullParameter(rankModules, "rankModules");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "getAppInterface is null!");
            return;
        }
        final EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            QLog.e(TAG, 1, "entityManager is null!");
            return;
        }
        DesktopItemInfo desktopItemInfo = personalModuleMap.get(1);
        Intrinsics.checkNotNull(desktopItemInfo, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo");
        final List<DesktopItemInfo> resetDesktopAppInfoToDesktopItemInfo = resetDesktopAppInfoToDesktopItemInfo(((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.repository.b
            @Override // java.lang.Runnable
            public final void run() {
                ExpDesktopLocalDbRepository.updateMiniAppDbInfoWithBatch$lambda$3(personalModuleMap, this, resetDesktopAppInfoToDesktopItemInfo, recommendModule, rankModules, createEntityManager);
            }
        }, 32, null, true);
    }

    private final void updateDbEntity(List<DesktopItemInfo> appInfoList, List<BaseTransaction<?>> transactionList, StringBuilder sb5) {
        DesktopAppEntityV3 desktopAppEntityV3;
        List<DesktopItemInfo> list = appInfoList;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (DesktopItemInfo desktopItemInfo : appInfoList) {
            if (desktopItemInfo instanceof DesktopAppInfo) {
                desktopAppEntityV3 = new DesktopAppEntityV3(((DesktopAppInfo) desktopItemInfo).mMiniAppInfo);
            } else {
                desktopAppEntityV3 = desktopItemInfo instanceof DesktopSearchInfo ? new DesktopAppEntityV3(((DesktopSearchInfo) desktopItemInfo).mAppInfo) : null;
            }
            if (desktopAppEntityV3 != null) {
                desktopAppEntityV3.setStatus(1000);
                BaseTransaction<?> updateEntityTransaction = getUpdateEntityTransaction(desktopAppEntityV3);
                if (updateEntityTransaction != null) {
                    transactionList.add(updateEntityTransaction);
                }
                sb5.append(desktopAppEntityV3.name);
                sb5.append(", ");
            }
        }
    }

    private final List<DesktopItemInfo> resetDesktopAppInfoToDesktopItemInfo(ArrayList<DesktopAppInfo> desktopAppInfos) {
        if (desktopAppInfos == null || desktopAppInfos.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = desktopAppInfos.iterator();
        while (it.hasNext()) {
            arrayList.add((DesktopAppInfo) it.next());
        }
        return arrayList;
    }
}
