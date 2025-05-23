package com.tencent.mobileqq.gamecenter.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected EntityManager f211986a;

    public a(EntityManager entityManager) {
        this.f211986a = entityManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(Entity entity, String str, String[] strArr) {
        try {
            if (this.f211986a.isOpen()) {
                return this.f211986a.remove(entity, str, strArr);
            }
            QLog.e("GameCenterMsg.BaseDataHelper", 2, "removeEntity em closed e=" + entity.getTableName());
            return false;
        } catch (Throwable th5) {
            QLog.w("GameCenterMsg.BaseDataHelper", 1, th5.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(Entity entity) {
        try {
            if (this.f211986a.isOpen()) {
                if (entity.getStatus() == 1000) {
                    this.f211986a.persistOrReplace(entity);
                    if (entity.getStatus() == 1001) {
                        return true;
                    }
                    return false;
                }
                if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                    return this.f211986a.update(entity);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("GameCenterMsg.BaseDataHelper", 2, "updateEntity em closed e=" + entity.getTableName());
            }
            return false;
        } catch (Throwable th5) {
            QLog.w("GameCenterMsg.BaseDataHelper", 1, th5.getMessage());
            return false;
        }
    }
}
