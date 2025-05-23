package com.tencent.mobileqq.zplan.persistent;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0007*\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bJA\u0010\u0012\u001a\u0004\u0018\u00010\u0002\"\b\b\u0000\u0010\u0007*\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/persistent/b;", "", "Lcom/tencent/mobileqq/persistence/Entity;", "entity", "", "c", "e", "T", "", "entities", "", "d", "Ljava/lang/Class;", "entityClass", "", "selection", "", "selectionArgs", "b", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;", "Lcom/tencent/mobileqq/zplan/persistent/c;", "a", "Lcom/tencent/mobileqq/zplan/persistent/c;", "entityManagerFactory", "Lcom/tencent/mobileqq/persistence/EntityManager;", "Lcom/tencent/mobileqq/persistence/EntityManager;", "entityManager", "uin", "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, b> f334919d = new HashMap<>();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final c entityManagerFactory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final EntityManager entityManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR0\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/persistent/b$a;", "", "Lcom/tencent/mobileqq/zplan/persistent/b;", "a", "", "uin", "b", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "managerHolder", "Ljava/util/HashMap;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.persistent.b$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            AppRuntime d16 = bb.f335811a.d();
            String account = d16 != null ? d16.getAccount() : null;
            if (account != null) {
                return b.INSTANCE.b(account);
            }
            return null;
        }

        public final b b(String uin) {
            b bVar;
            Intrinsics.checkNotNullParameter(uin, "uin");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (!TextUtils.isEmpty(uin)) {
                synchronized (b.f334919d) {
                    bVar = (b) b.f334919d.get(uin);
                    if (bVar == null) {
                        bVar = new b(uin, defaultConstructorMarker);
                        b.f334919d.put(uin, bVar);
                    }
                }
                return bVar;
            }
            QLog.e("ZPlanEntityManager", 1, "uin is empty!!");
            return null;
        }

        Companion() {
        }
    }

    public /* synthetic */ b(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private final boolean c(Entity entity) {
        switch (entity.getStatus()) {
            case 1000:
                this.entityManager.persistOrReplace(entity);
                return entity.getStatus() == 1001;
            case 1001:
            case 1002:
                return this.entityManager.update(entity);
            default:
                return false;
        }
    }

    public final <T extends Entity> Entity b(Class<T> entityClass, String selection, String[] selectionArgs) {
        Entity entity;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(entityClass, "entityClass");
        Intrinsics.checkNotNullParameter(selection, "selection");
        synchronized (this.entityManager) {
            List<? extends Entity> query = this.entityManager.query(entityClass, true, selection, selectionArgs, null, null, null, "1");
            if (query != null) {
                Intrinsics.checkNotNullExpressionValue(query, "query(entityClass, true,\u2026s, null, null, null, \"1\")");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) query);
                entity = (Entity) firstOrNull;
            } else {
                entity = null;
            }
        }
        return entity;
    }

    public final <T extends Entity> int d(Collection<? extends T> entities) {
        int i3;
        Intrinsics.checkNotNullParameter(entities, "entities");
        synchronized (this.entityManager) {
            Iterator<? extends T> it = entities.iterator();
            i3 = 0;
            while (it.hasNext()) {
                i3 += c(it.next()) ? 1 : 0;
            }
            Unit unit = Unit.INSTANCE;
        }
        return i3;
    }

    public final boolean e(Entity entity) {
        boolean c16;
        Intrinsics.checkNotNullParameter(entity, "entity");
        synchronized (this.entityManager) {
            c16 = c(entity);
        }
        return c16;
    }

    b(String str) {
        c cVar = new c(str);
        this.entityManagerFactory = cVar;
        EntityManager createEntityManager = cVar.createEntityManager();
        Intrinsics.checkNotNullExpressionValue(createEntityManager, "entityManagerFactory.createEntityManager()");
        this.entityManager = createEntityManager;
    }
}
