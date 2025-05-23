package com.tencent.mobileqq.mini.apkgEntity;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.UTFDataFormatException;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppEntityManager implements Manager {
    private static final String TAG = "MiniAppEntityManager";
    private final EntityManager mEntityManager;
    private final MiniAppEntityManagerFactory miniAppEntityManagerFactory;
    private static final HashMap<String, MiniAppEntityManager> sManagerHolder = new HashMap<>();
    private static final long APPINFO_DELETE_TIME = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_APPINFOENTITY_DELEATE_INTERVAL_TIME, 172800000L);
    private static final long OTHER_DELETE_TIME = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_OTHERENTITY_DELEATE_INTERVAL_TIME, QzoneConfig.DefaultValue.DEFAULT_OTHERENTITY_DELEATE_INTERVAL_TIME);

    MiniAppEntityManager(String str) {
        MiniAppEntityManagerFactory miniAppEntityManagerFactory = new MiniAppEntityManagerFactory(str);
        this.miniAppEntityManagerFactory = miniAppEntityManagerFactory;
        this.mEntityManager = miniAppEntityManagerFactory.createEntityManager();
        verifyAuthenticationAsync();
    }

    private void deleteDbFile() {
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null) {
                String account = runtime.getAccount();
                if (TextUtils.isEmpty(account)) {
                    return;
                }
                File databasePath = BaseApplication.getContext().getDatabasePath("miniapp_" + account + DBBackupServiceImpl.DB_FILE_SUFFIX);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("deleteDbFile db : ");
                sb5.append(databasePath.getPath());
                QLog.e(TAG, 1, sb5.toString());
                FileUtils.deleteFile(databasePath.getPath());
                File databasePath2 = BaseApplication.getContext().getDatabasePath("miniapp_" + account + ".db-journal");
                StringBuilder sb6 = new StringBuilder();
                sb6.append("deleteDbFile dbJournal : ");
                sb6.append(databasePath2.getPath());
                QLog.e(TAG, 1, sb6.toString());
                FileUtils.deleteFile(databasePath2.getPath());
                File databasePath3 = BaseApplication.getContext().getDatabasePath("miniapp_" + account + ".db-wal");
                StringBuilder sb7 = new StringBuilder();
                sb7.append("deleteDbFile dbWal : ");
                sb7.append(databasePath3.getPath());
                QLog.e(TAG, 1, sb7.toString());
                FileUtils.deleteFile(databasePath3.getPath());
                File databasePath4 = BaseApplication.getContext().getDatabasePath("miniapp_" + account + ".db-shm");
                StringBuilder sb8 = new StringBuilder();
                sb8.append("deleteDbFile dbShm : ");
                sb8.append(databasePath4.getPath());
                QLog.e(TAG, 1, sb8.toString());
                FileUtils.deleteFile(databasePath4.getPath());
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "deleteDbFile error,", th5);
        }
    }

    public static MiniAppEntityManager get() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (MiniAppEntityManager) runtime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
        }
        return get(runtime.getAccount());
    }

    private static void removeCachedManager(MiniAppEntityManager miniAppEntityManager) {
        synchronized (MiniAppEntityManager.class) {
            sManagerHolder.values().remove(miniAppEntityManager);
        }
    }

    private void verifyAuthenticationAsync() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MiniAppEntityManager.this.miniAppEntityManagerFactory.verifyAuthentication();
                } catch (Exception e16) {
                    QLog.e(MiniAppEntityManager.TAG, 1, "verifyAuthentication error.", e16);
                }
            }
        }, 32, null, true);
    }

    public synchronized void checkDB() {
        QLog.d("miniapp-db", 1, "checkDB");
        long currentTimeMillis = System.currentTimeMillis() - APPINFO_DELETE_TIME;
        long currentTimeMillis2 = System.currentTimeMillis() - OTHER_DELETE_TIME;
        try {
            execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", MiniAppInfoEntity.class.getSimpleName(), Long.valueOf(currentTimeMillis)));
            execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", MiniAppByIdEntity.class.getSimpleName(), Long.valueOf(currentTimeMillis)));
            execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", MiniAppByLinkEntity.class.getSimpleName(), Long.valueOf(currentTimeMillis)));
            execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", MiniAppShowInfoEntity.class.getSimpleName(), Long.valueOf(currentTimeMillis2)));
            execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", MiniAppInfoByIdEntity.class.getSimpleName(), Long.valueOf(currentTimeMillis)));
            execSQL(String.format("DELETE FROM %s WHERE timeStamp < '%s';", MiniAppInfoByLinkEntity.class.getSimpleName(), Long.valueOf(currentTimeMillis)));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "checkDB  error,", th5);
            if (th5 instanceof UTFDataFormatException) {
                QLog.e(TAG, 1, "checkDB  error instanceof UTFDataFormatException, delete db file.");
                deleteDbFile();
            }
        }
    }

    public synchronized boolean clearEntityTable(String str) {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager == null) {
            return false;
        }
        return DBMethodProxy.execSQL(entityManager, "DELETE FROM " + str);
    }

    public synchronized int delete(String str, String str2, String[] strArr) {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager == null) {
            return -1;
        }
        return entityManager.delete(str, str2, strArr);
    }

    public boolean doMultiDBOperateByTransaction(List<BaseTransaction> list) {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager == null) {
            return false;
        }
        return entityManager.doMultiDBOperateByTransaction(list);
    }

    public synchronized boolean execSQL(String str) {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager == null) {
            return false;
        }
        return DBMethodProxy.execSQL(entityManager, str);
    }

    public synchronized Entity find(Class<? extends Entity> cls, String str, String[] strArr) {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager == null) {
            return null;
        }
        List<? extends Entity> query = entityManager.query(cls, true, str, strArr, null, null, null, "1");
        if (query == null) {
            return null;
        }
        return query.get(0);
    }

    public EntityTransaction getTransaction() {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager == null) {
            return null;
        }
        return entityManager.getTransaction();
    }

    public synchronized boolean insertOrReplaceEntity(Entity entity) {
        if (this.mEntityManager == null) {
            return false;
        }
        if (entity.getStatus() == 1000) {
            this.mEntityManager.persistOrReplace(entity);
            return entity.getStatus() == 1001;
        }
        if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
            return this.mEntityManager.update(entity);
        }
        return false;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager != null) {
            entityManager.close();
        }
        MiniAppEntityManagerFactory miniAppEntityManagerFactory = this.miniAppEntityManagerFactory;
        if (miniAppEntityManagerFactory != null && miniAppEntityManagerFactory.isOpen()) {
            this.miniAppEntityManagerFactory.close();
        }
        removeCachedManager(this);
    }

    public synchronized boolean removeEntity(Entity entity) {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager == null) {
            return false;
        }
        if (entity == null) {
            return false;
        }
        return entityManager.remove(entity);
    }

    public synchronized boolean update(String str, ContentValues contentValues, String str2, String[] strArr) {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager == null) {
            return false;
        }
        return entityManager.update(str, contentValues, str2, strArr);
    }

    public synchronized List<? extends Entity> queryEntity(Class<? extends Entity> cls, boolean z16, String str, String[] strArr, String str2, String str3, String str4, String str5) {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager == null) {
            return null;
        }
        return entityManager.query(cls, z16, str, strArr, str2, str3, str4, str5);
    }

    public static MiniAppEntityManager get(String str) {
        MiniAppEntityManager miniAppEntityManager;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (MiniAppEntityManager.class) {
            HashMap<String, MiniAppEntityManager> hashMap = sManagerHolder;
            miniAppEntityManager = hashMap.get(str);
            if (miniAppEntityManager == null) {
                miniAppEntityManager = new MiniAppEntityManager(str);
                hashMap.put(str, miniAppEntityManager);
            }
        }
        return miniAppEntityManager;
    }
}
