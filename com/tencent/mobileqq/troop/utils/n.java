package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class n {
    static IPatchRedirector $redirector_;

    public static boolean a(QQAppInterface qQAppInterface, Map<UUID, ? extends Entity> map, long j3) {
        if (map == null) {
            QLog.e("SerializableManager", 4, "bad Entity Param");
            return false;
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        TroopFileTansferItemEntity troopFileTansferItemEntity = new TroopFileTansferItemEntity();
        troopFileTansferItemEntity.troopuin = j3;
        if (!createEntityManager.drop(troopFileTansferItemEntity.getTableName())) {
            return false;
        }
        for (Entity entity : map.values()) {
            ((TroopFileTansferItemEntity) entity).troopuin = j3;
            entity.setStatus(1000);
            createEntityManager.persist(entity);
        }
        return true;
    }
}
