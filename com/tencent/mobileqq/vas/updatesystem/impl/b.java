package com.tencent.mobileqq.vas.updatesystem.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.updatesystem.db.entity.LocalFileMd5Entity;
import com.tencent.mobileqq.vas.updatesystem.db.entity.LocalUpdateEntity;
import com.tencent.mobileqq.vas.updatesystem.db.entity.ShouldUpdateEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import sw4.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements sw4.c {

    /* renamed from: a, reason: collision with root package name */
    private q33.a f311218a;

    /* renamed from: b, reason: collision with root package name */
    private EntityManager f311219b;

    public b() {
        q33.a aVar = new q33.a(e());
        this.f311218a = aVar;
        this.f311219b = aVar.createEntityManager();
    }

    private String e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getAccount();
        }
        return null;
    }

    private boolean g(Entity entity) {
        EntityManager f16 = f();
        boolean z16 = false;
        if (f16.isOpen()) {
            if (entity.getStatus() == 1000) {
                f16.persistOrReplace(entity);
                if (entity.getStatus() == 1001) {
                    z16 = true;
                }
            } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                z16 = f16.update(entity);
            }
            f16.close();
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasUpdate_DbImpl", 2, "updateEntity em closed e=" + entity.getTableName());
        }
        return false;
    }

    @Override // sw4.c
    public List<c.a> a(int i3) {
        ArrayList arrayList = new ArrayList();
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    List<? extends Entity> query = f().query(LocalFileMd5Entity.class);
                    if (query == null) {
                        return null;
                    }
                    Iterator<? extends Entity> it = query.iterator();
                    while (it.hasNext()) {
                        LocalFileMd5Entity localFileMd5Entity = (LocalFileMd5Entity) it.next();
                        if (localFileMd5Entity != null) {
                            c.a aVar = new c.a();
                            aVar.f434914a = localFileMd5Entity.mItemId;
                            aVar.f434915b = localFileMd5Entity.mContent;
                            arrayList.add(aVar);
                        }
                    }
                }
            } else {
                List<? extends Entity> query2 = f().query(ShouldUpdateEntity.class);
                if (query2 == null) {
                    return null;
                }
                Iterator<? extends Entity> it5 = query2.iterator();
                while (it5.hasNext()) {
                    ShouldUpdateEntity shouldUpdateEntity = (ShouldUpdateEntity) it5.next();
                    if (shouldUpdateEntity != null) {
                        c.a aVar2 = new c.a();
                        aVar2.f434914a = shouldUpdateEntity.mItemId;
                        aVar2.f434915b = shouldUpdateEntity.mContent;
                        arrayList.add(aVar2);
                    }
                }
            }
        } else {
            List<? extends Entity> query3 = f().query(LocalUpdateEntity.class);
            if (query3 == null) {
                return null;
            }
            Iterator<? extends Entity> it6 = query3.iterator();
            while (it6.hasNext()) {
                LocalUpdateEntity localUpdateEntity = (LocalUpdateEntity) it6.next();
                if (localUpdateEntity != null) {
                    c.a aVar3 = new c.a();
                    aVar3.f434914a = localUpdateEntity.mItemId;
                    aVar3.f434915b = localUpdateEntity.mContent;
                    arrayList.add(aVar3);
                }
            }
        }
        return arrayList;
    }

    @Override // sw4.c
    public String b(int i3, String str) {
        SharedPreferences sharedPreferences;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return "";
                    }
                    if (VasToggle.BUG_104253873.isEnable(true)) {
                        sharedPreferences = VasMMKV.getQuickUpdateDb(BaseApplication.getContext(), "quick_update_common");
                    } else {
                        sharedPreferences = BaseApplication.getContext().getSharedPreferences("quick_update_common", 0);
                    }
                    return sharedPreferences.getString(str, "");
                }
                List<? extends Entity> query = f().query(LocalFileMd5Entity.class, false, "mItemId=?", new String[]{str}, null, null, null, "1");
                if (query == null || query.size() < 1 || query.get(0) == null) {
                    return "";
                }
                return ((LocalFileMd5Entity) query.get(0)).mContent;
            }
            List<? extends Entity> query2 = f().query(ShouldUpdateEntity.class, false, "mItemId=?", new String[]{str}, null, null, null, "1");
            if (query2 == null || query2.size() < 1 || query2.get(0) == null) {
                return "";
            }
            return ((ShouldUpdateEntity) query2.get(0)).mContent;
        }
        List<? extends Entity> query3 = f().query(LocalUpdateEntity.class, false, "mItemId=?", new String[]{str}, null, null, null, "1");
        if (query3 == null || query3.size() < 1 || query3.get(0) == null) {
            return "";
        }
        return ((LocalUpdateEntity) query3.get(0)).mContent;
    }

    @Override // sw4.c
    public void c(int i3, String str) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    f().delete(LocalFileMd5Entity.TABLE_NAME, "mItemId=?", new String[]{str});
                    return;
                }
                return;
            }
            f().delete(ShouldUpdateEntity.TABLE_NAME, "mItemId=?", new String[]{str});
            return;
        }
        f().delete(LocalUpdateEntity.TABLE_NAME, "mItemId=?", new String[]{str});
    }

    @Override // sw4.c
    public void d(int i3, String str, String str2) {
        SharedPreferences sharedPreferences;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (VasToggle.BUG_104253873.isEnable(true)) {
                            sharedPreferences = VasMMKV.getQuickUpdateDb(BaseApplication.getContext(), "quick_update_common");
                        } else {
                            sharedPreferences = BaseApplication.getContext().getSharedPreferences("quick_update_common", 0);
                        }
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(str, str2);
                        edit.commit();
                        return;
                    }
                    return;
                }
                LocalFileMd5Entity localFileMd5Entity = new LocalFileMd5Entity();
                localFileMd5Entity.mItemId = str;
                localFileMd5Entity.mContent = str2;
                g(localFileMd5Entity);
                return;
            }
            ShouldUpdateEntity shouldUpdateEntity = new ShouldUpdateEntity();
            shouldUpdateEntity.mItemId = str;
            shouldUpdateEntity.mContent = str2;
            g(shouldUpdateEntity);
            return;
        }
        LocalUpdateEntity localUpdateEntity = new LocalUpdateEntity();
        localUpdateEntity.mItemId = str;
        localUpdateEntity.mContent = str2;
        g(localUpdateEntity);
    }

    public EntityManager f() {
        if (this.f311218a == null) {
            this.f311218a = new q33.a(e());
        }
        if (this.f311219b == null) {
            this.f311219b = this.f311218a.createEntityManager();
        }
        return this.f311219b;
    }
}
