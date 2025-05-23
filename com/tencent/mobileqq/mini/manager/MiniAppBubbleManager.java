package com.tencent.mobileqq.mini.manager;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.entity.AppBubbleRecordEntity;
import com.tencent.mobileqq.mini.entity.RecentAppBubbleRecordEntity;
import com.tencent.mobileqq.mini.entity.RecommendAppBubbleRecordEntity;
import com.tencent.mobileqq.mini.util.DateUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.transaction.RemoveTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/mini/manager/MiniAppBubbleManager;", "", "()V", "mDataLoaded", "", "mLock", "Ljava/lang/Object;", "mRecentRecords", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/mini/entity/AppBubbleRecordEntity;", "Lkotlin/collections/HashMap;", "mRecommendRecords", "ensureBubbleRecord", "appId", "moduleType", "", "text", "clickCount", "preloadAllFromDB", "", "updateAppBubbleRecord", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppBubbleManager {
    public static final String TAG = "MiniAppBubbleManager";
    private boolean mDataLoaded;
    private final HashMap<String, AppBubbleRecordEntity> mRecentRecords = new HashMap<>();
    private final HashMap<String, AppBubbleRecordEntity> mRecommendRecords = new HashMap<>();
    private final Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void ensureBubbleRecord$lambda$8(Ref.ObjectRef record) {
        Intrinsics.checkNotNullParameter(record, "$record");
        MiniAppEntityManager miniAppEntityManager = MiniAppEntityManager.get();
        if (miniAppEntityManager != null) {
            miniAppEntityManager.removeEntity((Entity) record.element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadAllFromDB$lambda$2(MiniAppBubbleManager this$0) {
        MiniAppEntityManager miniAppEntityManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(TAG, 1, "preloadAllFromDB, begin");
        try {
            MiniAppEntityManager miniAppEntityManager2 = MiniAppEntityManager.get();
            List<? extends Entity> queryEntity = miniAppEntityManager2 != null ? miniAppEntityManager2.queryEntity(RecentAppBubbleRecordEntity.class, false, null, null, null, null, null, null) : null;
            MiniAppEntityManager miniAppEntityManager3 = MiniAppEntityManager.get();
            List<? extends Entity> queryEntity2 = miniAppEntityManager3 != null ? miniAppEntityManager3.queryEntity(RecommendAppBubbleRecordEntity.class, false, null, null, null, null, null, null) : null;
            ArrayList arrayList = new ArrayList();
            synchronized (this$0.mLock) {
                if (queryEntity != null) {
                    try {
                        QLog.d(TAG, 1, "recentRecords.size: " + queryEntity.size());
                        for (Entity entity : queryEntity) {
                            if (entity instanceof RecentAppBubbleRecordEntity) {
                                if (((RecentAppBubbleRecordEntity) entity).timestamp != 0 && !DateUtils.INSTANCE.isToday(((RecentAppBubbleRecordEntity) entity).timestamp)) {
                                    arrayList.add(new RemoveTransaction(entity));
                                    QLog.d(TAG, 1, "preloadFromDB, remove: " + entity);
                                } else {
                                    AbstractMap abstractMap = this$0.mRecentRecords;
                                    String str = ((RecentAppBubbleRecordEntity) entity).appId;
                                    Intrinsics.checkNotNullExpressionValue(str, "record.appId");
                                    abstractMap.put(str, entity);
                                    QLog.d(TAG, 1, "preloadFromDB, restore: " + entity);
                                }
                            }
                        }
                    } finally {
                    }
                }
                if (queryEntity2 != null) {
                    QLog.d(TAG, 1, "recommendRecords.size: " + queryEntity2.size());
                    for (Entity entity2 : queryEntity2) {
                        if (entity2 instanceof RecommendAppBubbleRecordEntity) {
                            if (((RecommendAppBubbleRecordEntity) entity2).timestamp != 0 && !DateUtils.INSTANCE.isToday(((RecommendAppBubbleRecordEntity) entity2).timestamp)) {
                                arrayList.add(new RemoveTransaction(entity2));
                                QLog.d(TAG, 1, "preloadFromDB, remove: " + entity2);
                            } else {
                                AbstractMap abstractMap2 = this$0.mRecommendRecords;
                                String str2 = ((RecommendAppBubbleRecordEntity) entity2).appId;
                                Intrinsics.checkNotNullExpressionValue(str2, "record.appId");
                                abstractMap2.put(str2, entity2);
                                QLog.d(TAG, 1, "preloadFromDB, restore: " + entity2);
                            }
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            if ((!arrayList.isEmpty()) && (miniAppEntityManager = MiniAppEntityManager.get()) != null) {
                miniAppEntityManager.doMultiDBOperateByTransaction(arrayList);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "preloadAllFromDB failed", e16);
        }
        QLog.d(TAG, 1, "preloadAllFromDB, end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void updateAppBubbleRecord$lambda$4(Ref.ObjectRef record) {
        Intrinsics.checkNotNullParameter(record, "$record");
        MiniAppEntityManager miniAppEntityManager = MiniAppEntityManager.get();
        if (miniAppEntityManager != null) {
            miniAppEntityManager.insertOrReplaceEntity((Entity) record.element);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00fc A[Catch: all -> 0x0134, TryCatch #0 {, blocks: (B:6:0x0017, B:7:0x0028, B:10:0x0032, B:11:0x005d, B:13:0x00ef, B:15:0x00fc, B:17:0x010d, B:18:0x011f, B:26:0x0048, B:27:0x0081, B:29:0x00c3, B:32:0x00d2, B:34:0x0020), top: B:4:0x0015 }] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.mobileqq.mini.entity.AppBubbleRecordEntity, com.tencent.mobileqq.mini.entity.RecentAppBubbleRecordEntity, T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.tencent.mobileqq.mini.entity.RecommendAppBubbleRecordEntity, com.tencent.mobileqq.mini.entity.AppBubbleRecordEntity, T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AppBubbleRecordEntity ensureBubbleRecord(String appId, int moduleType, String text, int clickCount) {
        boolean z16;
        T t16;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(text, "text");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.mLock) {
            if (moduleType == 2) {
                objectRef.element = this.mRecommendRecords.get(appId);
            } else {
                objectRef.element = this.mRecentRecords.get(appId);
            }
            Object obj = objectRef.element;
            z16 = true;
            if (obj == null) {
                if (moduleType == 2) {
                    ?? recommendAppBubbleRecordEntity = new RecommendAppBubbleRecordEntity();
                    recommendAppBubbleRecordEntity.appId = appId;
                    recommendAppBubbleRecordEntity.text = text;
                    recommendAppBubbleRecordEntity.clickCount = clickCount;
                    objectRef.element = recommendAppBubbleRecordEntity;
                    AbstractMap abstractMap = this.mRecommendRecords;
                    Intrinsics.checkNotNull(recommendAppBubbleRecordEntity);
                    abstractMap.put(appId, recommendAppBubbleRecordEntity);
                } else {
                    ?? recentAppBubbleRecordEntity = new RecentAppBubbleRecordEntity();
                    recentAppBubbleRecordEntity.appId = appId;
                    recentAppBubbleRecordEntity.text = text;
                    recentAppBubbleRecordEntity.clickCount = clickCount;
                    objectRef.element = recentAppBubbleRecordEntity;
                    AbstractMap abstractMap2 = this.mRecentRecords;
                    Intrinsics.checkNotNull(recentAppBubbleRecordEntity);
                    abstractMap2.put(appId, recentAppBubbleRecordEntity);
                }
                QLog.d(TAG, 1, "ensureBubbleRecord, moduleType: " + moduleType + " , create: " + objectRef.element);
            } else {
                QLog.d(TAG, 1, "ensureBubbleRecord, moduleType: " + moduleType + " , text: " + text + ", record: " + obj);
                T t17 = objectRef.element;
                Intrinsics.checkNotNull(t17);
                ((AppBubbleRecordEntity) t17).clickCount = clickCount;
                T t18 = objectRef.element;
                Intrinsics.checkNotNull(t18);
                if (!Intrinsics.areEqual(text, ((AppBubbleRecordEntity) t18).text)) {
                    T t19 = objectRef.element;
                    Intrinsics.checkNotNull(t19);
                    if (((AppBubbleRecordEntity) t19).timestamp == 0) {
                        z16 = false;
                    }
                    T t26 = objectRef.element;
                    Intrinsics.checkNotNull(t26);
                    ((AppBubbleRecordEntity) t26).text = text;
                    T t27 = objectRef.element;
                    Intrinsics.checkNotNull(t27);
                    ((AppBubbleRecordEntity) t27).showTimes = 0;
                    T t28 = objectRef.element;
                    Intrinsics.checkNotNull(t28);
                    ((AppBubbleRecordEntity) t28).timestamp = 0L;
                    t16 = objectRef.element;
                    Intrinsics.checkNotNull(t16);
                    if (((AppBubbleRecordEntity) t16).timestamp != 0) {
                        DateUtils dateUtils = DateUtils.INSTANCE;
                        T t29 = objectRef.element;
                        Intrinsics.checkNotNull(t29);
                        if (!dateUtils.isToday(((AppBubbleRecordEntity) t29).timestamp)) {
                            T t36 = objectRef.element;
                            Intrinsics.checkNotNull(t36);
                            ((AppBubbleRecordEntity) t36).timestamp = 0L;
                            T t37 = objectRef.element;
                            Intrinsics.checkNotNull(t37);
                            ((AppBubbleRecordEntity) t37).showTimes = 0;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            z16 = false;
            t16 = objectRef.element;
            Intrinsics.checkNotNull(t16);
            if (((AppBubbleRecordEntity) t16).timestamp != 0) {
            }
            Unit unit2 = Unit.INSTANCE;
        }
        if (z16) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.manager.a
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBubbleManager.ensureBubbleRecord$lambda$8(Ref.ObjectRef.this);
                }
            });
        }
        T t38 = objectRef.element;
        Intrinsics.checkNotNull(t38);
        return (AppBubbleRecordEntity) t38;
    }

    public final void preloadAllFromDB() {
        synchronized (this.mLock) {
            if (this.mDataLoaded) {
                return;
            }
            this.mDataLoaded = true;
            Unit unit = Unit.INSTANCE;
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.manager.b
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBubbleManager.preloadAllFromDB$lambda$2(MiniAppBubbleManager.this);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v13, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, java.lang.Object] */
    public final void updateAppBubbleRecord(String appId, int moduleType) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.mLock) {
            if (moduleType == 1) {
                objectRef.element = this.mRecentRecords.get(appId);
            } else if (moduleType == 2) {
                objectRef.element = this.mRecommendRecords.get(appId);
            }
            T t16 = objectRef.element;
            if (t16 == 0) {
                return;
            }
            Intrinsics.checkNotNull(t16);
            ((AppBubbleRecordEntity) t16).showTimes++;
            T t17 = objectRef.element;
            Intrinsics.checkNotNull(t17);
            if (((AppBubbleRecordEntity) t17).timestamp == 0) {
                T t18 = objectRef.element;
                Intrinsics.checkNotNull(t18);
                ((AppBubbleRecordEntity) t18).timestamp = System.currentTimeMillis();
            }
            QLog.d(TAG, 1, "updateAppBubbleRecord, moduleType: " + moduleType + " , record: " + objectRef.element);
            Unit unit = Unit.INSTANCE;
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.manager.c
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppBubbleManager.updateAppBubbleRecord$lambda$4(Ref.ObjectRef.this);
                }
            });
        }
    }
}
