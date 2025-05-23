package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppLocalSearchManager implements Manager {
    public static final String TAG = "MiniAppLocalSearchManager";
    private COMM.StCommonExt mBatchQueryExtInfo;
    private COMM.StCommonExt mExtInfo;

    public MiniAppLocalSearchManager(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "MiniAppLocalSearchManager init.");
        }
    }

    static /* bridge */ /* synthetic */ AppInterface b() {
        return getAppInterface();
    }

    private static AppInterface getAppInterface() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            AppRuntime runtime = application.getRuntime();
            if (runtime instanceof QQAppInterface) {
                return (QQAppInterface) runtime;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateEntity(EntityManager entityManager, Entity entity) {
        boolean z16 = false;
        if (entityManager.isOpen()) {
            if (entity.getStatus() == 1000) {
                entityManager.persistOrReplace(entity);
                if (entity.getStatus() == 1001) {
                    z16 = true;
                }
            } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                z16 = entityManager.update(entity);
            }
            entityManager.close();
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateEntity em closed e=" + entity.getTableName());
        }
        return false;
    }

    public List<MiniAppLocalSearchEntity> getLocalSearchData() {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            QLog.e(TAG, 2, "getLocalSearchData, app is null.");
            return null;
        }
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        MiniAppConfBean j3 = MiniAppConfProcessor.j();
        if (j3 != null ? j3.c() : false) {
            if (createEntityManager != null) {
                return createEntityManager.query(MiniAppLocalSearchEntity.class, MiniAppLocalSearchEntity.class.getSimpleName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getLocalSearchData, close local search.");
        }
        return null;
    }

    public void updateDataDbFromNetResult(final MiniAppLocalSearchEntity miniAppLocalSearchEntity) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager.2
            @Override // java.lang.Runnable
            public void run() {
                AppInterface b16 = MiniAppLocalSearchManager.b();
                if (b16 == null) {
                    QLog.e(MiniAppLocalSearchManager.TAG, 2, "updateDataToDB, app is null.");
                    return;
                }
                EntityManager createEntityManager = b16.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    String simpleName = MiniAppLocalSearchEntity.class.getSimpleName();
                    String str = miniAppLocalSearchEntity.appId;
                    List<? extends Entity> query = createEntityManager.query(MiniAppLocalSearchEntity.class, simpleName, false, "appId = ?", new String[]{str}, (String) null, (String) null, (String) null, str);
                    if (query == null || query.size() <= 0) {
                        return;
                    }
                    Iterator<? extends Entity> it = query.iterator();
                    while (it.hasNext()) {
                        MiniAppLocalSearchEntity miniAppLocalSearchEntity2 = (MiniAppLocalSearchEntity) it.next();
                        QLog.i(MiniAppLocalSearchManager.TAG, 2, "updateDataDbFromNetResult  : " + miniAppLocalSearchEntity.desc);
                        miniAppLocalSearchEntity2.desc = miniAppLocalSearchEntity.desc;
                        MiniAppLocalSearchManager.this.updateEntity(createEntityManager, miniAppLocalSearchEntity2);
                    }
                }
            }
        }, 32, null, true);
    }

    public void updateDataToDB(final MiniAppInfo miniAppInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager.1
            @Override // java.lang.Runnable
            public void run() {
                AppInterface b16 = MiniAppLocalSearchManager.b();
                if (b16 == null) {
                    QLog.e(MiniAppLocalSearchManager.TAG, 2, "updateDataToDB, app is null.");
                    return;
                }
                EntityManager createEntityManager = b16.getEntityManagerFactory().createEntityManager();
                if (createEntityManager != null) {
                    String simpleName = MiniAppLocalSearchEntity.class.getSimpleName();
                    String str = miniAppInfo.appId;
                    List<? extends Entity> query = createEntityManager.query(MiniAppLocalSearchEntity.class, simpleName, false, "appId = ?", new String[]{str}, (String) null, (String) null, (String) null, str);
                    if (query != null && query.size() > 0) {
                        Iterator<? extends Entity> it = query.iterator();
                        while (it.hasNext()) {
                            MiniAppLocalSearchEntity miniAppLocalSearchEntity = (MiniAppLocalSearchEntity) it.next();
                            miniAppLocalSearchEntity.showMask = 1;
                            MiniAppLocalSearchManager.this.updateEntity(createEntityManager, miniAppLocalSearchEntity);
                        }
                        return;
                    }
                    MiniAppInfo miniAppInfo2 = miniAppInfo;
                    MiniAppLocalSearchManager.this.updateEntity(createEntityManager, new MiniAppLocalSearchEntity(miniAppInfo2.appId, miniAppInfo2.name, miniAppInfo2.iconUrl, miniAppInfo2.desc, 1, miniAppInfo2.miniAppType, null, ""));
                }
            }
        }, 32, null, true);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
