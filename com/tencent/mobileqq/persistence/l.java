package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.entitymanager.upgrade.IOnDBUpgradeListener;
import com.tencent.util.DBBuildUtil;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class l extends QQEntityManagerFactory {

    /* renamed from: a, reason: collision with root package name */
    private EntityManagerFactory f258326a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.persistence.bridge.b f258327b;

    l(String str) {
        super(str, 0);
    }

    public static EntityManager b(EntityManagerFactory entityManagerFactory) {
        if (!entityManagerFactory.closed) {
            g gVar = new g(entityManagerFactory.dbHelper, entityManagerFactory.mName);
            entityManagerFactory.closed = false;
            return gVar;
        }
        throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }

    public static l c(String str) {
        l lVar = new l(str);
        lVar.f258327b = new com.tencent.mobileqq.persistence.bridge.b();
        lVar.f258326a = DBBuildUtil.getDefaultEntityManagerFactoryBuilder(str).onDBUpgradeListener(lVar.f258327b).build();
        return lVar;
    }

    public static l d(String str, EntityManagerFactory entityManagerFactory) {
        l lVar = new l(str);
        if (entityManagerFactory instanceof QQEntityManagerFactory) {
            IOnDBUpgradeListener onDBUpgradeListener = ((QQEntityManagerFactory) entityManagerFactory).getOnDBUpgradeListener();
            if (onDBUpgradeListener instanceof com.tencent.mobileqq.persistence.bridge.b) {
                lVar.f258327b = (com.tencent.mobileqq.persistence.bridge.b) onDBUpgradeListener;
            }
        }
        lVar.f258326a = entityManagerFactory;
        return lVar;
    }

    public EntityManager a() {
        return b(this.f258326a);
    }

    @Override // com.tencent.mobileqq.data.QQEntityManagerFactory, com.tencent.mobileqq.persistence.EntityManagerFactory
    public SQLiteOpenHelper build(String str) {
        return this.f258326a.build(str);
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public void close() {
        this.f258326a.close();
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public EntityManager createEntityManager() {
        return this.f258326a.createEntityManager();
    }

    public boolean e() {
        com.tencent.mobileqq.persistence.bridge.b bVar = this.f258327b;
        if (bVar != null && bVar.a()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public boolean isOpen() {
        return this.f258326a.isOpen();
    }

    @Override // com.tencent.mobileqq.persistence.EntityManagerFactory
    public boolean verifyAuthentication() {
        return this.f258326a.verifyAuthentication();
    }
}
