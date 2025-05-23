package com.qzone.reborn.groupalbum.reship.manager;

import android.content.ContentValues;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f56859b;

    /* renamed from: a, reason: collision with root package name */
    private volatile EntityManager f56860a;

    private EntityManager b() {
        if (this.f56860a == null) {
            synchronized (a.class) {
                if (this.f56860a == null) {
                    this.f56860a = com.qzone.reborn.util.c.a();
                }
            }
        }
        return this.f56860a;
    }

    public static a c() {
        if (f56859b == null) {
            synchronized (a.class) {
                if (f56859b == null) {
                    f56859b = new a();
                }
            }
        }
        return f56859b;
    }

    public boolean a(String str, String str2) {
        EntityManager b16 = b();
        if (b16 == null) {
            QLog.e("GroupAlbumReshipDbManager", 1, "[clearDataByType] but entityManager is null");
            return false;
        }
        try {
            QLog.d("GroupAlbumReshipDbManager", 1, "[clearData] clear count: " + b16.delete(GroupAlbumReshipSendBoxDbEntity.class.getSimpleName(), "mediaId=?", new String[]{str2}) + ",groupId:" + str + ",mediaId:" + str2);
        } catch (Exception e16) {
            QLog.w("GroupAlbumReshipDbManager", 1, "[clearData] error: ", e16);
        }
        return true;
    }

    public boolean d(GroupAlbumReshipSendBoxDbEntity groupAlbumReshipSendBoxDbEntity) {
        EntityManager b16 = b();
        if (b16 == null) {
            QLog.e("GroupAlbumReshipDbManager", 1, "[insert] but entityManager is null");
            return false;
        }
        QLog.d("GroupAlbumReshipDbManager", 1, "[insert]");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PersistTransaction(groupAlbumReshipSendBoxDbEntity));
        b16.doMultiDBOperateByTransaction(arrayList);
        return true;
    }

    public List<GroupAlbumReshipSendBoxDbEntity> f(String str) {
        List arrayList = new ArrayList();
        EntityManager b16 = b();
        if (b16 == null) {
            QLog.e("GroupAlbumReshipDbManager", 1, "[query] but entityManager is null");
            return arrayList;
        }
        try {
            arrayList = b16.query(GroupAlbumReshipSendBoxDbEntity.class, false, "groupId=?", new String[]{str}, null, null, "insertTime asc", null);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            QLog.d("GroupAlbumReshipDbManager", 1, "[query] data size: " + arrayList.size());
        } catch (Exception e16) {
            QLog.w("GroupAlbumReshipDbManager", 1, "[query] error: ", e16);
        }
        return arrayList;
    }

    public boolean g(GroupAlbumReshipSendBoxDbEntity groupAlbumReshipSendBoxDbEntity) {
        boolean z16;
        EntityManager b16 = b();
        if (b16 == null) {
            QLog.e("GroupAlbumReshipDbManager", 1, "[updateData] but entityManager is null");
            return false;
        }
        try {
            String simpleName = GroupAlbumReshipSendBoxDbEntity.class.getSimpleName();
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", groupAlbumReshipSendBoxDbEntity.data);
            z16 = b16.update(simpleName, contentValues, "mediaId=?", new String[]{groupAlbumReshipSendBoxDbEntity.mediaId});
            try {
                QLog.d("GroupAlbumReshipDbManager", 1, "[updateData] mediaId " + groupAlbumReshipSendBoxDbEntity.mediaId + ",groupId:" + groupAlbumReshipSendBoxDbEntity.groupId + "result:" + z16);
            } catch (Exception e16) {
                e = e16;
                QLog.w("GroupAlbumReshipDbManager", 1, "[updateData] error: ", e);
                return z16;
            }
        } catch (Exception e17) {
            e = e17;
            z16 = true;
        }
        return z16;
    }

    public void e() {
        QLog.d("GroupAlbumReshipDbManager", 1, "[onAccountChanged]");
        this.f56860a = com.qzone.reborn.util.c.a();
    }
}
