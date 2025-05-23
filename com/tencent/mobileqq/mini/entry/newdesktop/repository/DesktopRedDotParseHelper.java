package com.tencent.mobileqq.mini.entry.newdesktop.repository;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J8\u0010\b\u001a\u00020\t2.\u0010\n\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bj\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002JN\u0010\u0011\u001a\u00020\t2.\u0010\n\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bj\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u000e2\u0016\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0013J \u0010\u0014\u001a\u00020\t2\u0016\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0013H\u0002J>\u0010\u0015\u001a\u00020\t2.\u0010\n\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bj\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/DesktopRedDotParseHelper;", "", "()V", "mPublicAccountRedDotMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "mPushRedDotMap", "clearDesktopRedDotInfo", "", "miniAppUIDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/HashMap;", "deleteRedDotDataFromDB", "appId", "initDesktopRedDotData", "redDotData", "", "saveDesktopRedDotInfo", "setDesktopRedDotInfo", "miniAppRedDotEntity", "Lcom/tencent/mobileqq/mini/entry/MiniAppRedDotEntity;", "updateRedDotDataFromDB", "entity", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class DesktopRedDotParseHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "DesktopRedDotParseHelper";
    private static DesktopRedDotParseHelper mInstance;
    private final ConcurrentHashMap<String, Integer> mPublicAccountRedDotMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> mPushRedDotMap = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/DesktopRedDotParseHelper$Companion;", "", "()V", "TAG", "", "mInstance", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/DesktopRedDotParseHelper;", "getInstance", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DesktopRedDotParseHelper getInstance() {
            if (DesktopRedDotParseHelper.mInstance == null) {
                DesktopRedDotParseHelper.mInstance = new DesktopRedDotParseHelper();
            }
            DesktopRedDotParseHelper desktopRedDotParseHelper = DesktopRedDotParseHelper.mInstance;
            Intrinsics.checkNotNull(desktopRedDotParseHelper, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.newdesktop.repository.DesktopRedDotParseHelper");
            return desktopRedDotParseHelper;
        }

        Companion() {
        }
    }

    private final void clearDesktopRedDotInfo(HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap) {
        List<Object> mutableListOf;
        QLog.d(TAG, 1, "clearDesktopRedDotInfo");
        this.mPublicAccountRedDotMap.clear();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(miniAppUIDataMap.get(1), miniAppUIDataMap.get(3), miniAppUIDataMap.get(2));
        for (Object obj : mutableListOf) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo");
            String appId = ((DesktopAppInfo) obj).mMiniAppInfo.appId;
            Integer num = this.mPushRedDotMap.get(appId);
            if (num != null && num.intValue() > 0) {
                updateRedDotDataFromDB(new MiniAppRedDotEntity(appId, 0, num.intValue()));
            } else {
                Intrinsics.checkNotNullExpressionValue(appId, "appId");
                deleteRedDotDataFromDB(appId);
            }
        }
    }

    private final void deleteRedDotDataFromDB(final String appId) {
        QLog.d(TAG, 1, "deleteRedDotDataFromDB");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i(TAG, 1, "deleteRedDotDataFromDB,app is null!");
            return;
        }
        final EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            QLog.i(TAG, 1, "deleteRedDotDataFromDB,entityManager is null!");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.repository.e
                @Override // java.lang.Runnable
                public final void run() {
                    DesktopRedDotParseHelper.deleteRedDotDataFromDB$lambda$4(appId, createEntityManager);
                }
            }, 32, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteRedDotDataFromDB$lambda$4(String appId, EntityManager entityManager) {
        Intrinsics.checkNotNullParameter(appId, "$appId");
        try {
            MiniAppRedDotEntity miniAppRedDotEntity = new MiniAppRedDotEntity(appId, 0, 0);
            miniAppRedDotEntity.setStatus(1001);
            if (entityManager.remove(miniAppRedDotEntity, "appId=?", new String[]{miniAppRedDotEntity.appId})) {
                QLog.d(TAG, 2, "deleteRedDotDataFromDB, delete " + miniAppRedDotEntity.appId + " success from db");
            } else {
                QLog.d(TAG, 2, "deleteRedDotDataFromDB, delete " + miniAppRedDotEntity.appId + " fail from db");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "deleteRedDotDataFromDB, exception: " + Log.getStackTraceString(th5));
        }
    }

    private final void updateRedDotDataFromDB(final MiniAppRedDotEntity entity) {
        QLog.d(TAG, 1, "updateRedDotDataFromDB");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (entity != null && peekAppRuntime != null) {
            final EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory().createEntityManager();
            if (createEntityManager == null) {
                QLog.i(TAG, 1, "updateRedDotData,entityManager is null!");
                return;
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.repository.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        DesktopRedDotParseHelper.updateRedDotDataFromDB$lambda$5(EntityManager.this, entity);
                    }
                }, 32, null, true);
                return;
            }
        }
        QLog.i(TAG, 1, "updateRedDotData,entity or app is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRedDotDataFromDB$lambda$5(EntityManager entityManager, MiniAppRedDotEntity miniAppRedDotEntity) {
        if (entityManager.isOpen()) {
            boolean z16 = false;
            if (miniAppRedDotEntity.getStatus() == 1000) {
                entityManager.persistOrReplace(miniAppRedDotEntity);
                if (miniAppRedDotEntity.getStatus() == 1001) {
                    z16 = true;
                }
            } else if (miniAppRedDotEntity.getStatus() == 1001 || miniAppRedDotEntity.getStatus() == 1002) {
                z16 = entityManager.update(miniAppRedDotEntity);
            }
            entityManager.close();
            QLog.d(TAG, 1, "updateRedDotData, delete recommend flag:" + z16 + " appInfo: " + miniAppRedDotEntity);
            return;
        }
        QLog.e(TAG, 1, "updateRedDotData, failed to delete recommend appInfo: " + miniAppRedDotEntity);
    }

    public final void initDesktopRedDotData(HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap, Map<String, Integer> redDotData) {
        Intrinsics.checkNotNullParameter(miniAppUIDataMap, "miniAppUIDataMap");
        Intrinsics.checkNotNullParameter(redDotData, "redDotData");
        if (miniAppUIDataMap.isEmpty()) {
            QLog.i(TAG, 1, "initMiniAppRedDotInfo mMiniAppUIDataMap is empty!");
        } else if (redDotData.isEmpty()) {
            QLog.i(TAG, 1, "initMiniAppRedDotInfo redDotData is empty!");
            clearDesktopRedDotInfo(miniAppUIDataMap);
        } else {
            saveDesktopRedDotInfo(redDotData);
        }
    }

    public final void setDesktopRedDotInfo(HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap, MiniAppRedDotEntity miniAppRedDotEntity) {
        List mutableListOf;
        boolean z16;
        Intrinsics.checkNotNullParameter(miniAppUIDataMap, "miniAppUIDataMap");
        Intrinsics.checkNotNullParameter(miniAppRedDotEntity, "miniAppRedDotEntity");
        if (!miniAppUIDataMap.isEmpty()) {
            int i3 = 0;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(miniAppUIDataMap.get(1), miniAppUIDataMap.get(3), miniAppUIDataMap.get(2));
            Iterator it = mutableListOf.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                Object obj = (List) it.next();
                if ((obj instanceof DesktopAppInfo) && ((DesktopAppInfo) obj).mMiniAppInfo.appId.equals(miniAppRedDotEntity.appId)) {
                    z16 = true;
                    break;
                }
            }
            if (!z16) {
                QLog.i(TAG, 1, "not needRefreshRedDot!");
                return;
            }
            ConcurrentHashMap<String, Integer> concurrentHashMap = this.mPushRedDotMap;
            String str = miniAppRedDotEntity.appId;
            Intrinsics.checkNotNullExpressionValue(str, "miniAppRedDotEntity.appId");
            concurrentHashMap.put(str, Integer.valueOf(miniAppRedDotEntity.wnsPushRedDotNum));
            Integer num = this.mPublicAccountRedDotMap.get(miniAppRedDotEntity.appId);
            if (num != null && num.intValue() > 0) {
                i3 = num.intValue();
            }
            updateRedDotDataFromDB(new MiniAppRedDotEntity(miniAppRedDotEntity.appId, i3, miniAppRedDotEntity.wnsPushRedDotNum));
            return;
        }
        QLog.i(TAG, 1, "setDesktopRedDotInfo miniAppUIDataMap is empty!");
    }

    private final void saveDesktopRedDotInfo(Map<String, Integer> redDotData) {
        QLog.d(TAG, 1, "saveDesktopRedDotInfo");
        for (Map.Entry<String, Integer> entry : redDotData.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (key != null && value != null) {
                if (!TextUtils.isEmpty(key) && value.intValue() > 0) {
                    this.mPublicAccountRedDotMap.put(key, value);
                }
                Integer num = this.mPushRedDotMap.get(key);
                if (num == null) {
                    num = 0;
                }
                updateRedDotDataFromDB(new MiniAppRedDotEntity(key, value.intValue(), num.intValue()));
            }
        }
    }
}
