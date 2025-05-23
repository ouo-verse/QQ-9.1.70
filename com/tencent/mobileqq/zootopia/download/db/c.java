package com.tencent.mobileqq.zootopia.download.db;

import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.z1.download.db.ZootopiaDownloadEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016R\u001c\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/db/c;", "Lcom/tencent/mobileqq/zootopia/download/db/b;", "", "Lcom/tencent/mobileqq/z1/download/db/ZootopiaDownloadEntity;", "a", "data", "", "d", "c", "", "id", "", "b", "Lcom/tencent/mobileqq/persistence/EntityManager;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/persistence/EntityManager;", "entityManager", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final EntityManager entityManager = new a().createEntityManager();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.zootopia.download.db.b
    public List<ZootopiaDownloadEntity> a() {
        if (!this.entityManager.isOpen()) {
            QLog.e("Zootopia_DBHelper", 1, "queryDownloadInfoList error entityManager is close");
            return new ArrayList();
        }
        List query = this.entityManager.query(ZootopiaDownloadEntity.class);
        boolean z16 = query instanceof List;
        List list = query;
        if (!z16) {
            list = null;
        }
        return list == null ? new ArrayList() : list;
    }

    @Override // com.tencent.mobileqq.zootopia.download.db.b
    public void b(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        if (!this.entityManager.isOpen()) {
            QLog.e("Zootopia_DBHelper", 1, "delete " + id5 + " error entityManager is close");
            return;
        }
        this.entityManager.delete(ZootopiaDownloadEntity.class.getSimpleName(), "zootopiaId=?", new String[]{id5});
    }

    @Override // com.tencent.mobileqq.zootopia.download.db.b
    public boolean c(ZootopiaDownloadEntity data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!this.entityManager.isOpen()) {
            QLog.e("Zootopia_DBHelper", 1, "update " + data.zootopiaId + " error entityManager is close");
            return false;
        }
        this.entityManager.update(data);
        return true;
    }

    @Override // com.tencent.mobileqq.zootopia.download.db.b
    public boolean d(ZootopiaDownloadEntity data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!this.entityManager.isOpen()) {
            QLog.e("Zootopia_DBHelper", 1, "insert " + data.zootopiaId + " error entityManager is close");
            return false;
        }
        this.entityManager.persistOrReplace(data);
        return true;
    }
}
