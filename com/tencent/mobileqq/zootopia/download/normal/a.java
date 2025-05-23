package com.tencent.mobileqq.zootopia.download.normal;

import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001c\u0010\u0014\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/normal/a;", "Lcom/tencent/mobileqq/zootopia/download/normal/h;", "", "category", "", "url", "Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadEntity;", "e", "", "d", "a", "data", "", "f", "c", "", "b", "Lcom/tencent/mobileqq/persistence/EntityManager;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/persistence/EntityManager;", "entityManager", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final EntityManager entityManager = new c().createEntityManager();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public List<FileDownloadEntity> a() {
        if (!this.entityManager.isOpen()) {
            QLog.e("Zootopia_File_DBHelper", 1, "queryDownloadInfoList error entityManager is close");
            return new ArrayList();
        }
        List query = this.entityManager.query(FileDownloadEntity.class);
        boolean z16 = query instanceof List;
        List list = query;
        if (!z16) {
            list = null;
        }
        return list == null ? new ArrayList() : list;
    }

    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public void b(int category, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!this.entityManager.isOpen()) {
            QLog.e("Zootopia_File_DBHelper", 1, "delete " + url + " error entityManager is close");
            return;
        }
        EntityManager entityManager = this.entityManager;
        String simpleName = FileDownloadEntity.class.getSimpleName();
        String[] strArr = new String[2];
        for (int i3 = 0; i3 < 2; i3++) {
            String.valueOf(category);
            strArr[i3] = url;
        }
        entityManager.delete(simpleName, "category = ? AND url = ?", strArr);
    }

    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public boolean c(FileDownloadEntity data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!this.entityManager.isOpen()) {
            QLog.e("Zootopia_File_DBHelper", 1, "update " + data.url + " error entityManager is close");
            return false;
        }
        this.entityManager.update(data);
        return true;
    }

    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public List<FileDownloadEntity> d(int category) {
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public FileDownloadEntity e(int category, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!this.entityManager.isOpen()) {
            QLog.e("Zootopia_File_DBHelper", 1, "queryDownloadInfo " + url + " error entityManager is close");
            return null;
        }
        EntityManager entityManager = this.entityManager;
        String[] strArr = new String[2];
        for (int i3 = 0; i3 < 2; i3++) {
            String.valueOf(category);
            strArr[i3] = url;
        }
        Entity find = DBMethodProxy.find(entityManager, FileDownloadEntity.class, "category = ? AND url = ?", strArr);
        if (find instanceof FileDownloadEntity) {
            return (FileDownloadEntity) find;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zootopia.download.normal.h
    public boolean f(FileDownloadEntity data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!this.entityManager.isOpen()) {
            QLog.e("Zootopia_File_DBHelper", 1, "insert " + data.url + " error entityManager is close");
            return false;
        }
        this.entityManager.persistOrReplace(data);
        return true;
    }
}
