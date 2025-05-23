package com.tencent.qqnt.qwallet.db;

import androidx.annotation.WorkerThread;
import androidx.collection.LruCache;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqnt.qwallet.aio.pay.EnumPaymentType;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eJ\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0011H\u0007J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0012J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010 \u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010!\u001a\u00020\nR\u001b\u0010&\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010#\u001a\u0004\b2\u00103R \u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010.R\u001b\u0010:\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010#\u001a\u0004\b8\u00109R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010.\u00a8\u0006>"}, d2 = {"Lcom/tencent/qqnt/qwallet/db/QWalletDBManager;", "", "Lcom/tencent/qqnt/qwallet/db/QWalletDatabase;", "u", "", "id", "ownerUin", "", "paymentType", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "v", "Lcom/tencent/qqnt/qwallet/db/c;", "cache", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/qwallet/aio/pay/EnumPaymentType;", "Lcom/tencent/qqnt/qwallet/db/i;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "listId", "toUin", "Lcom/tencent/qqnt/qwallet/db/f;", "y", "text", "B", HippyTKDListViewAdapter.X, "cmd", "w", "entity", "i", tl.h.F, "g", DomainData.DOMAIN_NAME, "b", "Lkotlin/Lazy;", "p", "()Lcom/tencent/qqnt/qwallet/db/QWalletDatabase;", "database", "Lcom/tencent/qqnt/qwallet/db/g;", "c", "t", "()Lcom/tencent/qqnt/qwallet/db/g;", "paymentStateDao", "Landroidx/collection/LruCache;", "d", "Landroidx/collection/LruCache;", "paymentStateCache", "Lcom/tencent/qqnt/qwallet/db/d;", "e", "r", "()Lcom/tencent/qqnt/qwallet/db/d;", "hbStateDao", "f", "hbStateCache", "Lcom/tencent/qqnt/qwallet/db/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/qqnt/qwallet/db/a;", "hbCommandDao", "hbCommandCache", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QWalletDBManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QWalletDBManager f361825a = new QWalletDBManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy database;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy paymentStateDao;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, PaymentStateEntity> paymentStateCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy hbStateDao;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, HbStateEntity> hbStateCache;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy hbCommandDao;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, HbCommandEntity> hbCommandCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/qwallet/db/QWalletDBManager$a", "Landroidx/room/RoomDatabase$Callback;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "", "onDestructiveMigration", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RoomDatabase.Callback {
        a() {
        }

        @Override // androidx.room.RoomDatabase.Callback
        public void onDestructiveMigration(@NotNull SupportSQLiteDatabase db5) {
            Intrinsics.checkNotNullParameter(db5, "db");
            QLog.d("WalletNT-QWalletDBManager", 1, "onDestructiveMigration: db version " + db5.getVersion() + " path " + db5.getPath());
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletDatabase>() { // from class: com.tencent.qqnt.qwallet.db.QWalletDBManager$database$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletDatabase invoke() {
                QWalletDatabase u16;
                u16 = QWalletDBManager.f361825a.u();
                return u16;
            }
        });
        database = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<g>() { // from class: com.tencent.qqnt.qwallet.db.QWalletDBManager$paymentStateDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                QWalletDatabase p16;
                p16 = QWalletDBManager.f361825a.p();
                return p16.e();
            }
        });
        paymentStateDao = lazy2;
        paymentStateCache = new LruCache<>(30);
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.qqnt.qwallet.db.QWalletDBManager$hbStateDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                QWalletDatabase p16;
                p16 = QWalletDBManager.f361825a.p();
                return p16.d();
            }
        });
        hbStateDao = lazy3;
        hbStateCache = new LruCache<>(30);
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.qwallet.db.a>() { // from class: com.tencent.qqnt.qwallet.db.QWalletDBManager$hbCommandDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                QWalletDatabase p16;
                p16 = QWalletDBManager.f361825a.p();
                return p16.c();
            }
        });
        hbCommandDao = lazy4;
        hbCommandCache = new LruCache<>(30);
    }

    QWalletDBManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(PaymentStateEntity entity) {
        boolean z16;
        Intrinsics.checkNotNullParameter(entity, "$entity");
        long b16 = f361825a.t().b(entity);
        if (b16 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("WalletNT-QWalletDBManager", 2, "cacheAndSaveAsync insert result=" + b16 + " " + z16 + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(HbStateEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        f361825a.r().c(entity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(HbCommandEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        f361825a.q().a(entity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o() {
        f361825a.t().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QWalletDatabase p() {
        return (QWalletDatabase) database.getValue();
    }

    private final com.tencent.qqnt.qwallet.db.a q() {
        return (com.tencent.qqnt.qwallet.db.a) hbCommandDao.getValue();
    }

    private final d r() {
        return (d) hbStateDao.getValue();
    }

    private final String s(String id5, String ownerUin, int paymentType) {
        return com.tencent.mobileqq.base.a.c() + "-" + id5 + "-" + ownerUin + "-" + paymentType;
    }

    private final g t() {
        return (g) paymentStateDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QWalletDatabase u() {
        RoomDatabase build = Room.databaseBuilder(MobileQQ.sMobileQQ, QWalletDatabase.class, "qwallet_aio_db").fallbackToDestructiveMigration().addCallback(new a()).build();
        Intrinsics.checkNotNullExpressionValue(build, "databaseBuilder(MobileQQ\u2026\n                .build()");
        return (QWalletDatabase) build;
    }

    public final void A(@NotNull HbCommandEntity cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        hbCommandCache.remove(cache.getListId());
    }

    @WorkerThread
    public final void B(@NotNull String text, @NotNull String listId) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(listId, "listId");
        String c16 = com.tencent.mobileqq.base.a.c();
        String str = listId + "-" + c16;
        try {
            r().b(text, listId, c16);
            HbStateEntity a16 = r().a(listId, c16);
            if (a16 == null || hbStateCache.put(str, a16) == null) {
                hbStateCache.remove(str);
            }
        } catch (Exception e16) {
            QLog.w("WalletNT-QWalletDBManager", 1, "updateHbStateEntity error:", e16);
        }
    }

    public final void g(@NotNull final HbCommandEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        QLog.d("WalletNT-QWalletDBManager", 1, "cacheAndSaveAsync: entity " + entity);
        hbCommandCache.put(entity.getListId(), entity);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.db.m
            @Override // java.lang.Runnable
            public final void run() {
                QWalletDBManager.l(HbCommandEntity.this);
            }
        }, 32, null, true);
    }

    public final void h(@NotNull final HbStateEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        QLog.d("WalletNT-QWalletDBManager", 1, "cacheAndSaveAsync: entity " + entity);
        hbStateCache.put(entity.getListId() + "-" + entity.getToUin(), entity);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.db.k
            @Override // java.lang.Runnable
            public final void run() {
                QWalletDBManager.k(HbStateEntity.this);
            }
        }, 32, null, true);
    }

    public final void i(@NotNull final PaymentStateEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        QLog.d("WalletNT-QWalletDBManager", 1, "cacheAndSaveAsync: entity " + entity);
        paymentStateCache.put(s(entity.getPaymentId(), entity.getMsgOwnerUin(), entity.getPaymentType()), entity);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.db.l
            @Override // java.lang.Runnable
            public final void run() {
                QWalletDBManager.j(PaymentStateEntity.this);
            }
        }, 32, null, true);
    }

    public final void m() {
        paymentStateCache.evictAll();
        hbStateCache.evictAll();
        hbCommandCache.evictAll();
    }

    public final void n() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.db.j
            @Override // java.lang.Runnable
            public final void run() {
                QWalletDBManager.o();
            }
        }, 32, null, true);
    }

    public final boolean v() {
        if (hbCommandCache.size() <= 0) {
            return true;
        }
        return false;
    }

    @WorkerThread
    @Nullable
    public final HbCommandEntity w(@NotNull String cmd) {
        Object obj;
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Iterator<T> it = hbCommandCache.snapshot().values().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((HbCommandEntity) obj).getCommand(), cmd)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        HbCommandEntity hbCommandEntity = (HbCommandEntity) obj;
        if (hbCommandEntity != null) {
            QLog.d("WalletNT-QWalletDBManager", 1, "queryHbCommandByCmd: ");
            return hbCommandEntity;
        }
        HbCommandEntity c16 = q().c(cmd);
        if (c16 != null) {
            QLog.d("WalletNT-QWalletDBManager", 1, "queryHbCommandByCmd: : record found " + c16 + ", save to ram cache");
            hbCommandCache.put(c16.getListId(), c16);
        }
        return c16;
    }

    @WorkerThread
    @Nullable
    public final HbCommandEntity x(@NotNull String listId) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        LruCache<String, HbCommandEntity> lruCache = hbCommandCache;
        HbCommandEntity hbCommandEntity = lruCache.get(listId);
        if (hbCommandEntity != null) {
            QLog.d("WalletNT-QWalletDBManager", 1, "queryHbCommandByListId: cache found " + hbCommandEntity);
            return hbCommandEntity;
        }
        HbCommandEntity b16 = q().b(listId);
        if (b16 != null) {
            QLog.d("WalletNT-QWalletDBManager", 1, "queryHbCommandByListId: record found " + b16 + ", save to ram cache");
            lruCache.put(listId, b16);
        }
        return b16;
    }

    @WorkerThread
    @Nullable
    public final HbStateEntity y(@NotNull String listId, @NotNull String toUin) {
        HbStateEntity hbStateEntity;
        Intrinsics.checkNotNullParameter(listId, "listId");
        Intrinsics.checkNotNullParameter(toUin, "toUin");
        String str = listId + "-" + toUin;
        HbStateEntity hbStateEntity2 = hbStateCache.get(str);
        if (hbStateEntity2 != null) {
            QLog.d("WalletNT-QWalletDBManager", 1, "queryHbStateEntity: cache found " + hbStateEntity2);
            return hbStateEntity2;
        }
        try {
            hbStateEntity = r().a(listId, toUin);
        } catch (Exception e16) {
            QLog.w("WalletNT-QWalletDBManager", 1, "queryHbStateEntity error:", e16);
            hbStateEntity = null;
        }
        if (hbStateEntity != null) {
            QLog.d("WalletNT-QWalletDBManager", 1, "queryHbStateEntity: record found " + hbStateEntity + ", save to ram cache");
            hbStateCache.put(str, hbStateEntity);
        }
        return hbStateEntity;
    }

    @WorkerThread
    @Nullable
    public final PaymentStateEntity z(@NotNull String id5, @NotNull String ownerUin, @NotNull EnumPaymentType paymentType) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(ownerUin, "ownerUin");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        String s16 = s(id5, ownerUin, paymentType.ordinal());
        LruCache<String, PaymentStateEntity> lruCache = paymentStateCache;
        PaymentStateEntity paymentStateEntity = lruCache.get(s16);
        if (paymentStateEntity != null) {
            QLog.d("WalletNT-QWalletDBManager", 1, "queryPaymentEntity: cache found " + paymentStateEntity);
            return paymentStateEntity;
        }
        PaymentStateEntity c16 = t().c(com.tencent.mobileqq.base.a.c(), id5, ownerUin, paymentType.ordinal());
        if (c16 != null) {
            QLog.d("WalletNT-QWalletDBManager", 1, "queryPaymentEntity: record found " + c16 + ", save to ram cache");
            lruCache.put(s16, c16);
        } else {
            QLog.w("WalletNT-QWalletDBManager", 1, "queryPaymentEntity not found: id=" + id5 + " ownerUin=" + ownerUin + " type=" + paymentType);
        }
        return c16;
    }
}
