package com.tencent.weiyun.transmission.upload.transferlist;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.utils.IOUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadTransferListHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "UploadTransferListHelper";

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private interface TransferQuery {
        public static final IPatchRedirector $redirector_ = null;
        public static final int BATCH_DESC = 19;
        public static final int BATCH_ID = 16;
        public static final int BATCH_INDEX = 18;
        public static final int BATCH_TOTAL = 17;
        public static final int COMPRESS_FLAG = 28;
        public static final int CUR_SIZE = 24;
        public static final int DIR_NAME = 27;
        public static final int DURATION = 15;
        public static final int ERROR_CODE = 21;
        public static final int ERROR_MSG = 22;
        public static final int FILE_ID = 25;
        public static final int FILE_NAME = 7;
        public static final int FILE_SIZE = 8;
        public static final int FILE_VERSION = 26;
        public static final int GROUP_ROOT_DIR_KEY = 30;
        public static final int GROUP_UIN = 29;
        public static final int HEIGHT = 14;
        public static final int ID = 0;
        public static final int INSERT_TIME = 5;
        public static final int LATITUDE = 11;
        public static final int LOCAL_MODIFIED = 3;
        public static final int LOCAL_PATH = 2;
        public static final int LOCAL_SHA = 9;
        public static final int LONGITUDE = 10;
        public static final String[] PROJECTION;
        public static final int P_DIR_KEY = 4;
        public static final int STATE = 20;
        public static final int TAKEN_TIME = 12;
        public static final int THUMB_URI = 6;
        public static final int TOTAL_SIZE = 23;
        public static final int UID = 1;
        public static final int WIDTH = 13;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(13264), (Class<?>) TransferQuery.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                PROJECTION = new String[]{"_id", "uid", "local_path", JobDbManager.COL_UP_LOCAL_MODIFIED, "p_dir_key", "insert_time", "thumb_uri", "file_name", "file_size", JobDbManager.COL_UP_LOCAL_SHA, "longitude", "latitude", JobDbManager.COL_UP_TAKEN_TIME, "width", "height", "duration", JobDbManager.COL_UP_BATCH_ID, JobDbManager.COL_UP_BATCH_TOTAL, JobDbManager.COL_UP_BATCH_INDEX, JobDbManager.COL_UP_BATCH_DESC, "state", "error_code", "error_msg", "total_size", "cur_size", "file_id", "file_version", JobDbManager.COL_UP_P_DIR_NAME, JobDbManager.COL_UP_COMPRESS_FLAG, "p_dir_uid", "group_root_dir_key"};
            }
        }
    }

    public UploadTransferListHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int deleteAllSuccessTask(String str) {
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
        if (openJobDb == null) {
            TsLog.e(TAG, "deleteAllSuccessTask: Job db is null.");
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("valid_flag", (Integer) 0);
        int update = openJobDb.update(JobDbManager.TBL_UPLOAD, contentValues, "uid=? AND state = 5", new String[]{str});
        JobDbManager.getInstance().closeJobDb(openJobDb);
        return update;
    }

    public static String getLocalFilePath(String str, String str2) {
        Cursor cursor;
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
        if (openJobDb == null) {
            TsLog.e(TAG, "findLocalInfo: Job db is null.");
        } else {
            try {
                cursor = openJobDb.query(JobDbManager.TBL_UPLOAD, new String[]{"local_path"}, "file_id=?  AND " + JobDbManager.COL_DOWN_CLOUD_SHA + "=? ", new String[]{str, str2}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            return cursor.getString(0);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            TsLog.e(TAG, th);
                            IOUtils.closeSilently(cursor);
                            JobDbManager.getInstance().closeJobDb(openJobDb);
                            return null;
                        } finally {
                            IOUtils.closeSilently(cursor);
                        }
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                cursor = null;
            }
            IOUtils.closeSilently(cursor);
            JobDbManager.getInstance().closeJobDb(openJobDb);
        }
        return null;
    }

    public static UploadBean getTransferItemByFileId(String str) {
        Cursor cursor;
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
        UploadBean uploadBean = null;
        if (openJobDb == null) {
            TsLog.e(TAG, "findLocalInfo: Job db is null.");
        } else {
            try {
                cursor = openJobDb.query(JobDbManager.TBL_UPLOAD, TransferQuery.PROJECTION, "file_id=? ", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            uploadBean = readFromCursor(cursor);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            TsLog.e(TAG, th);
                            IOUtils.closeSilently(cursor);
                            JobDbManager.getInstance().closeJobDb(openJobDb);
                            return uploadBean;
                        } catch (Throwable th6) {
                            IOUtils.closeSilently(cursor);
                            throw th6;
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                cursor = null;
            }
            IOUtils.closeSilently(cursor);
            JobDbManager.getInstance().closeJobDb(openJobDb);
        }
        return uploadBean;
    }

    public static ArrayList<UploadBean> getTransferList(String str) {
        ArrayList<UploadBean> arrayList = new ArrayList<>();
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
        if (openJobDb == null) {
            TsLog.e(TAG, "getTransferList: Job db is null.");
        } else {
            Cursor cursor = null;
            try {
                cursor = openJobDb.query(JobDbManager.TBL_UPLOAD, TransferQuery.PROJECTION, "uid=? AND valid_flag = 1 AND " + JobDbManager.COL_UP_AUTO_BACKUP_FLAG + " != 1", new String[]{str}, null, null, "CASE WHEN state = 5 THEN 1  WHEN state != 5 THEN 2 END DESC,CASE WHEN state = 5 THEN 1-insert_time WHEN state != 5 THEN _id END ASC");
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        arrayList.add(readFromCursor(cursor));
                    }
                }
            } finally {
                try {
                    IOUtils.closeSilently(cursor);
                    JobDbManager.getInstance().closeJobDb(openJobDb);
                } catch (Throwable th5) {
                }
            }
            IOUtils.closeSilently(cursor);
            JobDbManager.getInstance().closeJobDb(openJobDb);
        }
        return arrayList;
    }

    private static UploadBean readFromCursor(Cursor cursor) {
        UploadBean uploadBean = new UploadBean();
        uploadBean.f384463id = cursor.getLong(0);
        uploadBean.uid = cursor.getString(1);
        uploadBean.localPath = cursor.getString(2);
        uploadBean.localModified = cursor.getLong(3);
        uploadBean.pDirKey = cursor.getString(4);
        uploadBean.insertTime = cursor.getLong(5);
        uploadBean.thumbUri = cursor.getString(6);
        uploadBean.fileName = cursor.getString(7);
        uploadBean.fileSize = cursor.getLong(8);
        uploadBean.sha = cursor.getString(9);
        uploadBean.longitude = cursor.getDouble(10);
        uploadBean.latitude = cursor.getDouble(11);
        uploadBean.takenTime = cursor.getLong(12);
        uploadBean.width = cursor.getLong(13);
        uploadBean.height = cursor.getLong(14);
        uploadBean.duration = cursor.getLong(15);
        uploadBean.batchId = cursor.getString(16);
        uploadBean.batchTotal = cursor.getLong(17);
        uploadBean.batchIndex = cursor.getLong(18);
        uploadBean.batchDesc = cursor.getString(19);
        uploadBean.state = cursor.getInt(20);
        uploadBean.errorCode = cursor.getInt(21);
        uploadBean.errorMsg = cursor.getString(22);
        uploadBean.totalSize = cursor.getLong(23);
        uploadBean.curSize = cursor.getLong(24);
        uploadBean.fileId = cursor.getString(25);
        uploadBean.fileVersion = cursor.getString(26);
        uploadBean.cloudDirName = cursor.getString(27);
        uploadBean.compressFlag = cursor.getInt(28);
        uploadBean.groupUid = cursor.getString(29);
        uploadBean.groupRootDirKey = cursor.getString(30);
        return uploadBean;
    }
}
