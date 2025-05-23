package ic0;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSRerankDbEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static volatile c f407420b;

    /* renamed from: a, reason: collision with root package name */
    private EntityManager f407421a;

    private List<com.tencent.tedger.outapi.beans.a> a(List<QFSRerankDbEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            QFSRerankDbEntity qFSRerankDbEntity = list.get(i3);
            if (qFSRerankDbEntity != null) {
                com.tencent.tedger.outapi.beans.a aVar = new com.tencent.tedger.outapi.beans.a();
                aVar.f375273a = qFSRerankDbEntity.dataId;
                aVar.f375274b = qFSRerankDbEntity.data;
                aVar.f375275c = qFSRerankDbEntity.insertTime;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private EntityManager c() {
        if (this.f407421a == null) {
            this.f407421a = QCircleServiceImpl.getEntityManager();
        }
        return this.f407421a;
    }

    public static c d() {
        if (f407420b == null) {
            synchronized (c.class) {
                if (f407420b == null) {
                    f407420b = new c();
                }
            }
        }
        return f407420b;
    }

    public int b(String str, String str2, String[] strArr) {
        String str3;
        String[] strArr2;
        EntityManager c16 = c();
        if (c16 == null) {
            QLog.e("TEDGEQFS_QFSRerankDbManager", 1, "[delete] but entityManager is null");
            return 0;
        }
        try {
            String simpleName = QFSRerankDbEntity.class.getSimpleName();
            if (str2 == null) {
                str3 = "dataType=?";
                strArr2 = new String[]{str};
            } else {
                str3 = "dataType=? AND " + str2;
                if (strArr == null) {
                    strArr = new String[0];
                }
                String[] strArr3 = new String[strArr.length + 1];
                strArr3[0] = str;
                int i3 = 0;
                while (i3 < strArr.length) {
                    int i16 = i3 + 1;
                    strArr3[i16] = strArr[i3];
                    i3 = i16;
                }
                strArr2 = strArr3;
            }
            return c16.delete(simpleName, str3, strArr2);
        } catch (Exception e16) {
            QLog.w("TEDGEQFS_QFSRerankDbManager", 1, "[delete] error: ", e16);
            return 0;
        }
    }

    public boolean e(String str, String str2, byte[] bArr, long j3) {
        EntityManager c16 = c();
        if (c16 == null) {
            QLog.e("TEDGEQFS_QFSRerankDbManager", 1, "[insert] but entityManager is null");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        QFSRerankDbEntity qFSRerankDbEntity = new QFSRerankDbEntity();
        qFSRerankDbEntity.dataType = str;
        qFSRerankDbEntity.dataId = str2;
        qFSRerankDbEntity.insertTime = j3;
        qFSRerankDbEntity.data = bArr;
        arrayList.add(new PersistTransaction(qFSRerankDbEntity));
        c16.doMultiDBOperateByTransaction(arrayList);
        QLog.d("TEDGEQFS_QFSRerankDbManager", 1, "[insert] dataType:" + str + ",id:" + str2);
        return true;
    }

    public List<com.tencent.tedger.outapi.beans.a> f(String str, String str2, boolean z16) {
        String str3;
        List<com.tencent.tedger.outapi.beans.a> arrayList = new ArrayList<>();
        EntityManager c16 = c();
        if (c16 == null) {
            QLog.e("TEDGEQFS_QFSRerankDbManager", 1, "[query] but entityManager is null");
            return arrayList;
        }
        if (z16) {
            str3 = "desc";
        } else {
            str3 = "asc";
        }
        try {
            arrayList = a(c16.query(QFSRerankDbEntity.class, true, "dataType=?", new String[]{str}, null, null, "insertTime " + str3, str2));
            QLog.d("TEDGEQFS_QFSRerankDbManager", 1, "[query] data size: " + arrayList.size() + ",dataType\uff1a" + str + ",limit:" + str2);
            return arrayList;
        } catch (Exception e16) {
            QLog.w("TEDGEQFS_QFSRerankDbManager", 1, "[query] error: ", e16);
            return arrayList;
        }
    }

    public com.tencent.tedger.outapi.beans.a g(String str, String str2) {
        EntityManager c16 = c();
        if (c16 == null) {
            QLog.e("TEDGEQFS_QFSRerankDbManager", 1, "[queryById] but entityManager is null");
            return null;
        }
        try {
            List<com.tencent.tedger.outapi.beans.a> a16 = a(c16.query(QFSRerankDbEntity.class, true, "dataType=? AND dataId=?", new String[]{str, str2}, null, null, null, null));
            if (!a16.isEmpty()) {
                return a16.get(0);
            }
        } catch (Exception e16) {
            QLog.w("TEDGEQFS_QFSRerankDbManager", 1, "[queryById] error: ", e16);
        }
        return null;
    }
}
