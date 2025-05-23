package com.tencent.mobileqq.persistence.backup.impl;

import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.dbfix.DBFix;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.persistence.backup.DBBackupConfigProcessor;
import com.tencent.mobileqq.persistence.backup.IDBBackupService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DBBackupServiceImpl implements IDBBackupService {
    public static final String DB_FILE_SUFFIX = ".db";
    private static final String FORMAT_TIME = "yyyyMMdd";
    public static final String KEY_BACKUP_ACTION_S = "backup_action_s";
    private static final String KEY_BACKUP_DB_MASTER_TIME = "backup_db_master_time";
    public static final String KEY_BACKUP_MASTER_DB_SIZE = "backup_master_db_size";
    public static final String KEY_BACKUP_MASTER_TIME = "backup_master_time";
    private static final String MANUFACTURER_OF_HARDWARE_VIVO = "vivo";
    private static final String MASTER_FILE_SUFFIX = ".db-mbu";
    private static final String MASTER_TEMP_FILE_SUFFIX = "_temp.db-mbu";
    private static final String SP_BACKUP_DB_MASTER = "_backup_db_master";
    private static final String TAG = "DBFix";
    public static final int UNIT_M = 1048576;
    private static final AtomicBoolean HAS_RUN_BACKUP = new AtomicBoolean(false);
    public static boolean sIsBackupSuccess = false;
    public static long sBackupTime = -1;

    private boolean backupMaster(AppRuntime appRuntime, File file, File file2) {
        try {
            if (!((DBFixManager) appRuntime.getManager(QQManagerFactory.DB_FIX_MANAGER)).k()) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean doBackupMaster = DBFix.getInstance().doBackupMaster(file.getAbsolutePath(), file2.getAbsolutePath());
            sBackupTime = System.currentTimeMillis() - currentTimeMillis;
            QLog.d(TAG, 1, "backup master result: ", Boolean.valueOf(doBackupMaster), ", dbSize: ", Long.valueOf(file.length() / 1048576), "M, cost: ", Long.valueOf(sBackupTime), "ms");
            return doBackupMaster;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "backup master failed! ", e16);
            return false;
        }
    }

    private boolean hasBackupToday(long j3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = simpleDateFormat.format(new Date(j3));
        String format2 = simpleDateFormat.format(new Date());
        QLog.d(TAG, 1, "last backup date: ", format, ", nowDate: ", format2);
        return format.equals(format2);
    }

    @Override // com.tencent.mobileqq.persistence.backup.IDBBackupService
    public void backupDBMaster(AppRuntime appRuntime) {
        Object obj;
        AtomicBoolean atomicBoolean = HAS_RUN_BACKUP;
        if (atomicBoolean.get()) {
            QLog.e(TAG, 1, "hasRunBackup!");
            return;
        }
        if (!atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        if ((appRuntime instanceof QQAppInterface) && ((QQAppInterface) appRuntime).isAccLoginSuccess()) {
            if (!Build.MANUFACTURER.equalsIgnoreCase("vivo")) {
                QLog.e(TAG, 1, "It's not vivo!");
                return;
            }
            DBBackupConfigProcessor.a a16 = DBBackupConfigProcessor.a();
            boolean c16 = a16.c();
            int b16 = a16.b();
            QLog.d(TAG, 1, "isBackupMaster: ", Boolean.valueOf(c16), ", threshold: ", Integer.valueOf(b16), "MB");
            if (!c16) {
                return;
            }
            String account = appRuntime.getAccount();
            File databasePath = appRuntime.getApplication().getDatabasePath(account + DB_FILE_SUFFIX);
            if (databasePath.exists() && databasePath.length() / 1048576 <= b16) {
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(account + SP_BACKUP_DB_MASTER, 0);
                if (hasBackupToday(sharedPreferences.getLong(KEY_BACKUP_DB_MASTER_TIME, 0L))) {
                    return;
                }
                final File databasePath2 = appRuntime.getApplication().getDatabasePath(account + MASTER_FILE_SUFFIX);
                final File databasePath3 = appRuntime.getApplication().getDatabasePath(account + MASTER_TEMP_FILE_SUFFIX);
                FileUtils.deleteFile(databasePath3.getAbsolutePath());
                boolean backupMaster = backupMaster(appRuntime, databasePath, databasePath3);
                sIsBackupSuccess = backupMaster;
                if (backupMaster) {
                    sharedPreferences.edit().putLong(KEY_BACKUP_DB_MASTER_TIME, System.currentTimeMillis()).apply();
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DBBackupServiceImpl.this.copyMasterFile(databasePath2, databasePath3);
                        }
                    }, 64, null, true);
                    return;
                }
                return;
            }
            Object[] objArr = new Object[2];
            objArr[0] = "dbFile not exist or too large: ";
            if (databasePath.exists()) {
                obj = Long.valueOf(databasePath.length() / 1048576);
            } else {
                obj = "not exist";
            }
            objArr[1] = obj;
            QLog.e(TAG, 1, objArr);
            return;
        }
        QLog.e(TAG, 1, "not Login Success");
    }

    void copyMasterFile(File file, File file2) {
        FileUtils.deleteFile(file.getAbsolutePath());
        if (!file2.renameTo(file)) {
            QLog.e(TAG, 1, "backup master success but rename fail");
            boolean copyFile = FileUtils.copyFile(file2, file);
            FileUtils.deleteFile(file2.getAbsolutePath());
            if (!copyFile) {
                QLog.e(TAG, 1, "backup master success but copy fail final");
            }
        }
    }
}
