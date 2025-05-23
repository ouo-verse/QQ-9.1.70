package com.tencent.mobileqq.matchfriend.reborn.couple;

import com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001H\u0007J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0014\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/QQCoupleStorage;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "T", "", "", "coupleId", "", "c", "couple", "", "e", "subtype", "b", "a", "Ljava/lang/String;", "bizId", "Ljava/lang/Class;", "Ljava/lang/Class;", "clz", "tag", "d", PanoramaConfig.KEY_CURRENT_UIN, "Lcom/tencent/mobileqq/persistence/EntityManager;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/persistence/EntityManager;", "entityManager", "<init>", "(Ljava/lang/String;Ljava/lang/Class;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQCoupleStorage<T extends IQQCoupleModel> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String bizId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Class<? extends IQQCoupleModel> clz;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String tag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String currentUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy entityManager;

    public QQCoupleStorage(String bizId, Class<? extends IQQCoupleModel> clz) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(clz, "clz");
        this.bizId = bizId;
        this.clz = clz;
        this.tag = "QQCoupleStorage_" + bizId + "_" + clz.getSimpleName();
        this.currentUin = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<EntityManager>(this) { // from class: com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleStorage$entityManager$2
            final /* synthetic */ QQCoupleStorage<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final EntityManager invoke() {
                EntityManagerFactory entityManagerFactory;
                String str;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    str = ((QQCoupleStorage) this.this$0).tag;
                    QLog.e(str, 1, "Init EntityManager but app is null!");
                }
                if (peekAppRuntime == null || (entityManagerFactory = peekAppRuntime.getEntityManagerFactory()) == null) {
                    return null;
                }
                return entityManagerFactory.createEntityManager();
            }
        });
        this.entityManager = lazy;
    }

    private final EntityManager d() {
        return (EntityManager) this.entityManager.getValue();
    }

    public final void b(String coupleId, String subtype) {
        Intrinsics.checkNotNullParameter(coupleId, "coupleId");
        Intrinsics.checkNotNullParameter(subtype, "subtype");
        long nanoTime = System.nanoTime();
        EntityManager d16 = d();
        Integer valueOf = d16 != null ? Integer.valueOf(d16.delete(this.clz.getSimpleName(), "bizId=? AND coupleId=? AND subtype=?", new String[]{this.bizId, coupleId, subtype})) : null;
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (QLog.isDevelopLevel()) {
            QLog.d(this.tag, 1, "[deleteCoupleByCoupleIdAndSubtype] cost:" + nanoTime2 + "(ns), count=" + valueOf);
        }
    }

    public final List<T> c(String coupleId) {
        Intrinsics.checkNotNullParameter(coupleId, "coupleId");
        long nanoTime = System.nanoTime();
        EntityManager d16 = d();
        List<T> list = null;
        List<? extends Entity> query = d16 != null ? d16.query(this.clz, false, "bizId=? AND coupleId=?", new String[]{this.bizId, coupleId}, null, null, null, null) : null;
        if (query instanceof List) {
            list = (List<T>) query;
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (QLog.isDevelopLevel()) {
            QLog.d(this.tag, 1, "[getCouplesByCoupleId] " + coupleId + " cost:" + nanoTime2 + "(ns)");
        }
        return list;
    }

    public final void e(IQQCoupleModel couple) {
        Intrinsics.checkNotNullParameter(couple, "couple");
        long nanoTime = System.nanoTime();
        ArrayList arrayList = new ArrayList();
        if (couple.getStatus() == 1000) {
            arrayList.add(new PersistOrReplaceTransaction(couple));
        } else if (couple.getStatus() == 1001 || couple.getStatus() == 1002) {
            arrayList.add(new UpdateTransaction(couple));
        }
        EntityManager d16 = d();
        Boolean valueOf = d16 != null ? Boolean.valueOf(d16.doMultiDBOperateByTransaction(arrayList)) : null;
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (QLog.isDevelopLevel()) {
            QLog.d(this.tag, 1, "[upsertCoupleToDB] cost:" + nanoTime2 + "(ns), result=" + valueOf);
        }
    }
}
