package fj;

import com.qzone.reborn.groupalbum.utils.GroupAlbumFakeFeedDbEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static volatile f f399447b;

    /* renamed from: a, reason: collision with root package name */
    private volatile EntityManager f399448a;

    private EntityManager b() {
        if (this.f399448a == null) {
            synchronized (f.class) {
                if (this.f399448a == null) {
                    this.f399448a = com.qzone.reborn.util.c.a();
                }
            }
        }
        return this.f399448a;
    }

    public static f c() {
        if (f399447b == null) {
            synchronized (f.class) {
                if (f399447b == null) {
                    f399447b = new f();
                }
            }
        }
        return f399447b;
    }

    public boolean a(String str, String str2) {
        EntityManager b16 = b();
        if (b16 == null) {
            QLog.e("upload2_QZoneFakeFeedDbManager", 1, "[clearDataByType] but entityManager is null");
            return false;
        }
        try {
            QLog.d("upload2_QZoneFakeFeedDbManager", 1, "[clearData] clear count: " + b16.delete(GroupAlbumFakeFeedDbEntity.class.getSimpleName(), "groupId=? AND clintKey=?", new String[]{str, str2}) + ",spaceId:" + str + ",clientKey:" + str2);
        } catch (Exception e16) {
            QLog.w("upload2_QZoneFakeFeedDbManager", 1, "[clearData] error: ", e16);
        }
        return true;
    }

    public boolean d(GroupAlbumFakeFeedDbEntity groupAlbumFakeFeedDbEntity) {
        EntityManager b16 = b();
        if (b16 == null) {
            QLog.e("upload2_QZoneFakeFeedDbManager", 1, "[insert] but entityManager is null");
            return false;
        }
        QLog.d("upload2_QZoneFakeFeedDbManager", 1, "[insert]");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PersistTransaction(groupAlbumFakeFeedDbEntity));
        b16.doMultiDBOperateByTransaction(arrayList);
        return true;
    }

    public void e() {
        this.f399448a = com.qzone.reborn.util.c.a();
    }

    public List<GroupAlbumFakeFeedDbEntity> f() {
        List arrayList = new ArrayList();
        EntityManager b16 = b();
        if (b16 == null) {
            QLog.e("upload2_QZoneFakeFeedDbManager", 1, "[query] but entityManager is null");
            return arrayList;
        }
        try {
            arrayList = b16.query(GroupAlbumFakeFeedDbEntity.class, false, null, null, null, null, "insertTime asc", null);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            QLog.d("upload2_QZoneFakeFeedDbManager", 1, "[query] data size: " + arrayList.size());
        } catch (Exception e16) {
            QLog.w("upload2_QZoneFakeFeedDbManager", 1, "[query] error: ", e16);
        }
        return arrayList;
    }
}
