package com.qzone.reborn.albumx.qzone.local;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.RemoveTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0002J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0016\u0010\r\u001a\u00020\u000b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004JA\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u000e2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\u001d\u001a\u00020\u001bJC\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u001f\u0010\u0015J\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010$\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/e;", "", "Lcom/tencent/mobileqq/persistence/EntityManager;", "f", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaInfos", "Lcom/qzone/reborn/albumx/qzone/local/QZoneUploadRecommedDbEntity;", "b", "dbEntities", "a", "", "g", "k", "", "selection", "", "selectionArgs", "orderBy", "limit", "i", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "whereClause", "whereArgs", "", "c", "(Ljava/lang/String;[Ljava/lang/String;)I", "", "d", "e", "Lcom/qzone/reborn/albumx/qzone/local/QZoneUploadHistoryDbEntity;", "j", "uploadInfo", tl.h.F, "Lcom/tencent/mobileqq/persistence/EntityManager;", "mEntityManager", "Ljava/lang/String;", "mAccount", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f52658a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static EntityManager mEntityManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String mAccount;

    e() {
    }

    private final synchronized EntityManager f() {
        String uinString = LoginData.getInstance().getUinString();
        if (uinString != null && uinString.length() > 1) {
            String str = mAccount;
            if (str != null && !TextUtils.equals(str, uinString)) {
                QLog.d("QZoneLocalRecommendDbManager", 1, "[getEntityManager] account change");
                mEntityManager = null;
            }
            if (mEntityManager == null) {
                mEntityManager = new i(uinString).createEntityManager();
                mAccount = uinString;
            }
            return mEntityManager;
        }
        return null;
    }

    public final int c(String whereClause, String[] whereArgs) {
        Intrinsics.checkNotNullParameter(whereClause, "whereClause");
        EntityManager f16 = f();
        if (f16 == null) {
            QLog.e("QZoneLocalRecommendDbManager", 1, "[count] but entityManager is null");
            return 0;
        }
        try {
            return f16.count(QZoneUploadRecommedDbEntity.class, whereClause, whereArgs);
        } catch (Exception e16) {
            QLog.w("QZoneLocalRecommendDbManager", 1, "[count] error: ", e16);
            return 0;
        }
    }

    public final void d(List<RFWMediaInfo> mediaInfos) {
        Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
        EntityManager f16 = f();
        if (f16 == null) {
            QLog.e("QZoneLocalRecommendDbManager", 1, "[delete] but entityManager is null");
            return;
        }
        List<QZoneUploadRecommedDbEntity> b16 = b(mediaInfos);
        ArrayList arrayList = new ArrayList();
        for (QZoneUploadRecommedDbEntity qZoneUploadRecommedDbEntity : b16) {
            qZoneUploadRecommedDbEntity.setStatus(1001);
            arrayList.add(new RemoveTransaction(qZoneUploadRecommedDbEntity, "mPath=?", new String[]{qZoneUploadRecommedDbEntity.mPath}));
        }
        if (f16.doMultiDBOperateByTransaction(arrayList)) {
            return;
        }
        QLog.d("QZoneLocalRecommendDbManager", 1, "[delete] result false");
    }

    public final void e() {
        EntityManager f16 = f();
        if (f16 == null) {
            QLog.e("QZoneLocalRecommendDbManager", 1, "[deleteAll] but entityManager is null");
        } else {
            f16.drop(QZoneUploadRecommedDbEntity.class);
        }
    }

    public final boolean g(List<RFWMediaInfo> mediaInfos) {
        EntityManager f16 = f();
        if (f16 == null) {
            QLog.e("QZoneLocalRecommendDbManager", 1, "[insertOrUpdate] but entityManager is null");
            return false;
        }
        List<QZoneUploadRecommedDbEntity> b16 = b(mediaInfos);
        ArrayList arrayList = new ArrayList();
        int size = b16.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(new PersistOrReplaceTransaction(b16.get(i3)));
        }
        if (!f16.doMultiDBOperateByTransaction(arrayList)) {
            QLog.d("QZoneLocalRecommendDbManager", 1, "[insertOrUpdate] result false");
        }
        return true;
    }

    public final boolean h(QZoneUploadHistoryDbEntity uploadInfo) {
        Intrinsics.checkNotNullParameter(uploadInfo, "uploadInfo");
        EntityManager f16 = f();
        if (f16 == null) {
            QLog.e("QZoneLocalRecommendDbManager", 1, "[insertOrUpdateHistory] but entityManager is null");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PersistOrReplaceTransaction(uploadInfo));
        if (!f16.doMultiDBOperateByTransaction(arrayList)) {
            QLog.d("QZoneLocalRecommendDbManager", 1, "[insertOrUpdateHistory] result false");
        }
        return true;
    }

    public final List<RFWMediaInfo> i(String selection, String[] selectionArgs, String orderBy, String limit) {
        List<RFWMediaInfo> emptyList;
        List<RFWMediaInfo> emptyList2;
        EntityManager f16 = f();
        if (f16 == null) {
            QLog.e("QZoneLocalRecommendDbManager", 1, "[query] but entityManager is null");
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        try {
            return a(f16.query(QZoneUploadRecommedDbEntity.class, true, selection, selectionArgs, null, null, orderBy, limit));
        } catch (Exception e16) {
            QLog.w("QZoneLocalRecommendDbManager", 1, "[query] error: ", e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    public final List<QZoneUploadHistoryDbEntity> j(String selection, String[] selectionArgs, String orderBy, String limit) {
        List<QZoneUploadHistoryDbEntity> emptyList;
        List<QZoneUploadHistoryDbEntity> emptyList2;
        EntityManager f16 = f();
        if (f16 == null) {
            QLog.e("QZoneLocalRecommendDbManager", 1, "[queryUploadHistory] but entityManager is null");
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        try {
            return f16.query(QZoneUploadHistoryDbEntity.class, true, selection, selectionArgs, null, null, orderBy, limit);
        } catch (Exception e16) {
            QLog.w("QZoneLocalRecommendDbManager", 1, "[queryUploadHistory] error: ", e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    private final List<RFWMediaInfo> a(List<? extends QZoneUploadRecommedDbEntity> dbEntities) {
        List<RFWMediaInfo> emptyList;
        if (dbEntities == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        int size = dbEntities.size();
        for (int i3 = 0; i3 < size; i3++) {
            QZoneUploadRecommedDbEntity qZoneUploadRecommedDbEntity = dbEntities.get(i3);
            if (qZoneUploadRecommedDbEntity != null) {
                copyOnWriteArrayList.add(h.f52663a.b(qZoneUploadRecommedDbEntity));
            }
        }
        return copyOnWriteArrayList;
    }

    private final List<QZoneUploadRecommedDbEntity> b(List<RFWMediaInfo> mediaInfos) {
        List<QZoneUploadRecommedDbEntity> emptyList;
        if (mediaInfos == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        int size = mediaInfos.size();
        for (int i3 = 0; i3 < size; i3++) {
            RFWMediaInfo rFWMediaInfo = mediaInfos.get(i3);
            if (rFWMediaInfo != null) {
                copyOnWriteArrayList.add(h.f52663a.a(rFWMediaInfo));
            }
        }
        return copyOnWriteArrayList;
    }

    public final boolean k(List<RFWMediaInfo> mediaInfos) {
        if (mediaInfos == null) {
            return false;
        }
        EntityManager f16 = f();
        if (f16 == null) {
            QLog.e("QZoneLocalRecommendDbManager", 1, "[update] but entityManager is null");
            return false;
        }
        List<QZoneUploadRecommedDbEntity> b16 = b(mediaInfos);
        ArrayList arrayList = new ArrayList();
        int size = b16.size();
        for (int i3 = 0; i3 < size; i3++) {
            QZoneUploadRecommedDbEntity qZoneUploadRecommedDbEntity = b16.get(i3);
            qZoneUploadRecommedDbEntity.setStatus(1001);
            arrayList.add(new UpdateTransaction(qZoneUploadRecommedDbEntity));
        }
        if (!f16.doMultiDBOperateByTransaction(arrayList)) {
            QLog.d("QZoneLocalRecommendDbManager", 1, "[update] result false");
        }
        return true;
    }
}
