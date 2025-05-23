package com.tencent.mobileqq.mini.entry.newdesktop.repository;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.entity.AppBubbleRecordEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DeskTopAppEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataMiniAppAdManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopLocalDataHelper;
import com.tencent.mobileqq.mini.manager.MiniAppBubbleManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 02\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J6\u0010 \u001a\u00020\u00062\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0010\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\"2\n\u0010%\u001a\u00060&j\u0002`'H\u0002J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J8\u0010,\u001a\u00020\u00062.\u0010-\u001a*\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0.j\u0014\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"`/H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/DesktopLocalDbRepository;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/IDesktopLocalDbRepository;", "()V", "mMiniAppBubbleManager", "Lcom/tencent/mobileqq/mini/manager/MiniAppBubbleManager;", "deleteGdtMiniAppCacheInfo", "", "desktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "deleteMiniAppCacheInfo", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "deleteMiniAppDbInfo", "entity", "getMiniAppDesktopLocalCacheInfo", "localDataCallback", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/MiniAppDesktopLocalDataHelper$MiniAppLocalDataCallback;", "getUpdateEntityTransaction", "Lcom/tencent/mobileqq/persistence/transaction/BaseTransaction;", "e", "Lcom/tencent/mobileqq/persistence/Entity;", "insertMiniAppDbInfo", "miniAppBubbleEnsureBubbleRecord", "Lcom/tencent/mobileqq/mini/entity/AppBubbleRecordEntity;", "appId", "", "moduleType", "", "text", "clickCount", "miniAppBubblePreloadAddFromDB", "miniAppBubbleUpdateAppBubbleRecord", "updateDbEntity", "appInfoList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "transactionList", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "updateEntity", "", "em", "Lcom/tencent/mobileqq/persistence/EntityManager;", "updateMiniAppDbInfoWithBatch", "miniAppUIDataMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class DesktopLocalDbRepository implements IDesktopLocalDbRepository {
    private static final String TAG = "DesktopLocalDbRepository";
    private final MiniAppBubbleManager mMiniAppBubbleManager = new MiniAppBubbleManager();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteMiniAppDbInfo$lambda$0(MiniAppInfo entity, EntityManager entityManager) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        DeskTopAppEntity deskTopAppEntity = new DeskTopAppEntity(entity);
        try {
            deskTopAppEntity.setStatus(1001);
            if (entityManager.remove(deskTopAppEntity, "uniqueId=?", new String[]{deskTopAppEntity.uniqueId})) {
                QLog.d(TAG, 2, "deleteEntity, delete " + deskTopAppEntity.name + " success from db");
            } else {
                QLog.d(TAG, 2, "deleteEntity, delete " + deskTopAppEntity.name + " fail from db");
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
    public static final void insertMiniAppDbInfo$lambda$1(DesktopAppInfo desktopAppInfo, DesktopLocalDbRepository this$0, EntityManager entityManager) {
        Intrinsics.checkNotNullParameter(desktopAppInfo, "$desktopAppInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DeskTopAppEntity deskTopAppEntity = new DeskTopAppEntity(desktopAppInfo.mMiniAppInfo);
        deskTopAppEntity.setStatus(1000);
        Intrinsics.checkNotNullExpressionValue(entityManager, "entityManager");
        this$0.updateEntity(entityManager, deskTopAppEntity);
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
    public static final void updateMiniAppDbInfoWithBatch$lambda$2(DesktopLocalDbRepository this$0, HashMap miniAppUIDataMap, EntityManager entityManager) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppUIDataMap, "$miniAppUIDataMap");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        List list = (List) miniAppUIDataMap.get(15);
        this$0.updateDbEntity(list != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list) : null, arrayList, sb5);
        List list2 = (List) miniAppUIDataMap.get(3);
        this$0.updateDbEntity(list2 != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list2) : null, arrayList, sb5);
        List list3 = (List) miniAppUIDataMap.get(1);
        this$0.updateDbEntity(list3 != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list3) : null, arrayList, sb5);
        List list4 = (List) miniAppUIDataMap.get(2);
        this$0.updateDbEntity(list4 != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list4) : null, arrayList, sb5);
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

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void deleteGdtMiniAppCacheInfo(DesktopAppInfo desktopAppInfo) {
        Intrinsics.checkNotNullParameter(desktopAppInfo, "desktopAppInfo");
        GdtAd gdtAdInfo = DesktopDataMiniAppAdManager.getInstance().getGdtAdInfo();
        MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
        if (miniAppInfo != null && gdtAdInfo != null) {
            if (desktopAppInfo.mModuleType != 1) {
                QLog.i(TAG, 1, "deleteGdtAdAppCache not recentApp!");
                return;
            }
            String str = miniAppInfo.appId;
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtAdInfo.info;
            Intrinsics.checkNotNull(adInfo);
            if (!Intrinsics.areEqual(str, adInfo.display_info.mini_program_id.get())) {
                QLog.i(TAG, 1, "deleteGdtAdAppCache not GdtMiniApp!");
                return;
            } else {
                DesktopDataMiniAppAdManager.getInstance().setGdtAdInfo(null);
                return;
            }
        }
        QLog.i(TAG, 1, "deleteGdtAdAppCache delete miniapp error!");
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void deleteMiniAppCacheInfo(MiniAppInfo miniAppInfo) {
        Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
        MiniCacheFreeManager.freeCache(BaseApplicationImpl.getApplication().getRuntime().getAccount(), miniAppInfo);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
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
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.repository.a
                @Override // java.lang.Runnable
                public final void run() {
                    DesktopLocalDbRepository.deleteMiniAppDbInfo$lambda$0(MiniAppInfo.this, createEntityManager);
                }
            }, 32, null, false);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void getMiniAppDesktopLocalCacheInfo(final MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback localDataCallback) {
        Intrinsics.checkNotNullParameter(localDataCallback, "localDataCallback");
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.e(TAG, 1, "initLocalDataRunnable, app is null.");
        } else {
            MiniAppDesktopLocalDataHelper.INSTANCE.getInstance().initLocalDesktopData(new MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.repository.DesktopLocalDbRepository$getMiniAppDesktopLocalCacheInfo$1
                @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback
                public void getLocalDataFailed(String errorMsg) {
                    MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback.this.getLocalDataFailed(errorMsg);
                    QLog.e("DesktopLocalDbRepository", 1, "getLocalDataFailed :" + errorMsg);
                }

                @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback
                public void getLocalDataSuccess(HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap) {
                    Intrinsics.checkNotNullParameter(miniAppUIDataMap, "miniAppUIDataMap");
                    QLog.i("DesktopLocalDbRepository", 1, "getDataSuccess miniAppUIDataMap:" + miniAppUIDataMap);
                    if (!miniAppUIDataMap.isEmpty()) {
                        MiniAppDesktopLocalDataHelper.MiniAppLocalDataCallback.this.getLocalDataSuccess(miniAppUIDataMap);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
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
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.repository.b
                @Override // java.lang.Runnable
                public final void run() {
                    DesktopLocalDbRepository.insertMiniAppDbInfo$lambda$1(DesktopAppInfo.this, this, createEntityManager);
                }
            }, 32, null, true);
        }
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public AppBubbleRecordEntity miniAppBubbleEnsureBubbleRecord(String appId, int moduleType, String text, int clickCount) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(text, "text");
        return this.mMiniAppBubbleManager.ensureBubbleRecord(appId, moduleType, text, clickCount);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void miniAppBubblePreloadAddFromDB() {
        this.mMiniAppBubbleManager.preloadAllFromDB();
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void miniAppBubbleUpdateAppBubbleRecord(String appId, int moduleType) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.mMiniAppBubbleManager.updateAppBubbleRecord(appId, moduleType);
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalDbRepository
    public void updateMiniAppDbInfoWithBatch(final HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap) {
        Intrinsics.checkNotNullParameter(miniAppUIDataMap, "miniAppUIDataMap");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(TAG, 1, "getAppInterface is null!");
            return;
        }
        final EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            QLog.e(TAG, 1, "entityManager is null!");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.repository.c
                @Override // java.lang.Runnable
                public final void run() {
                    DesktopLocalDbRepository.updateMiniAppDbInfoWithBatch$lambda$2(DesktopLocalDbRepository.this, miniAppUIDataMap, createEntityManager);
                }
            }, 32, null, true);
        }
    }

    private final void updateDbEntity(List<DesktopItemInfo> appInfoList, List<BaseTransaction<?>> transactionList, StringBuilder sb5) {
        DeskTopAppEntity deskTopAppEntity;
        List<DesktopItemInfo> list = appInfoList;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (DesktopItemInfo desktopItemInfo : appInfoList) {
            if (desktopItemInfo instanceof DesktopAppInfo) {
                deskTopAppEntity = new DeskTopAppEntity(((DesktopAppInfo) desktopItemInfo).mMiniAppInfo);
            } else {
                deskTopAppEntity = desktopItemInfo instanceof DesktopSearchInfo ? new DeskTopAppEntity(((DesktopSearchInfo) desktopItemInfo).mAppInfo) : null;
            }
            if (deskTopAppEntity != null) {
                deskTopAppEntity.setStatus(1000);
                BaseTransaction<?> updateEntityTransaction = getUpdateEntityTransaction(deskTopAppEntity);
                if (updateEntityTransaction != null) {
                    transactionList.add(updateEntityTransaction);
                }
                sb5.append(deskTopAppEntity.name);
                sb5.append(", ");
            }
        }
    }
}
