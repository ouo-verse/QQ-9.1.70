package com.tencent.weiyun.transmission.upload.processor;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.utils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class InfoRecorder implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int COL_UP_ALBUM = 20;
    private static final int COL_UP_ARTIST = 21;
    private static final int COL_UP_AUTO_BACKUP_FLAG = 27;
    private static final int COL_UP_BATCH_DESC = 32;
    private static final int COL_UP_BATCH_ID = 29;
    private static final int COL_UP_BATCH_INDEX = 31;
    private static final int COL_UP_BATCH_TOTAL = 30;
    private static final int COL_UP_CMD_TYPE = 2;
    private static final int COL_UP_COMPRESS_FLAG = 22;
    private static final int COL_UP_COMPRESS_PATH = 23;
    private static final int COL_UP_COMPRESS_SHA = 24;
    private static final int COL_UP_COVER_FILE_ID = 25;
    private static final int COL_UP_COVER_FILE_VERSION = 26;
    private static final int COL_UP_CUR_SIZE = 37;
    private static final int COL_UP_DURATION = 19;
    private static final int COL_UP_ERROR_CODE = 34;
    private static final int COL_UP_ERROR_MSG = 35;
    private static final int COL_UP_FILE_ID = 38;
    private static final int COL_UP_FILE_NAME = 10;
    private static final int COL_UP_FILE_SIZE = 11;
    private static final int COL_UP_GROUP_ROOT_DIR_KEY = 28;
    private static final int COL_UP_HEIGHT = 18;
    private static final int COL_UP_ID = 0;
    private static final int COL_UP_INSERT_TIME = 9;
    private static final int COL_UP_LATITUDE = 15;
    private static final int COL_UP_LOCAL_MODIFIED = 4;
    private static final int COL_UP_LOCAL_PATH = 3;
    private static final int COL_UP_LOCAL_SHA = 12;
    private static final int COL_UP_LONGITUDE = 14;
    private static final int COL_UP_MIME_TYPE = 13;
    private static final int COL_UP_PP_DIR_KEY = 8;
    private static final int COL_UP_P_DIR_KEY = 7;
    private static final int COL_UP_P_DIR_NAME = 6;
    private static final int COL_UP_P_DIR_UID = 5;
    private static final int COL_UP_STATE = 33;
    private static final int COL_UP_TAKEN_TIME = 16;
    private static final int COL_UP_TOTAL_SIZE = 36;
    private static final int COL_UP_UID = 1;
    private static final int COL_UP_WIDTH = 17;
    private static final int MSG_ADD = 1;
    private static final int MSG_REMOVE = 3;
    private static final int MSG_RESTORE = 4;
    private static final int MSG_UPDATE = 2;
    private static final String[] PROJ_ADD;
    private static final String[] PROJ_RESTORE;
    private static final String TAG = "UploadInfoRecorder";
    private final InfoRecorderCallback mCallback;
    private final ReleaseLooperHandler mHandler;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface InfoRecorderCallback {
        void onInfoAdded(int i3, UploadJobContext uploadJobContext);

        void onInfoRemoved(long j3, boolean z16, UploadJobContext uploadJobContext);

        void onInfoRestored(String str, List<UploadJobContext> list);

        void onInfoUpdated(long j3, boolean z16, UploadJobContext.StatusInfo statusInfo, boolean z17);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13056);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            PROJ_ADD = new String[]{"_id"};
            PROJ_RESTORE = new String[]{"_id", "uid", "cmd_type", "local_path", JobDbManager.COL_UP_LOCAL_MODIFIED, "p_dir_uid", JobDbManager.COL_UP_P_DIR_NAME, "p_dir_key", JobDbManager.COL_UP_PP_DIR_KEY, "insert_time", "file_name", "file_size", JobDbManager.COL_UP_LOCAL_SHA, JobDbManager.COL_UP_MIME_TYPE, "longitude", "latitude", JobDbManager.COL_UP_TAKEN_TIME, "width", "height", "duration", "album", JobDbManager.COL_UP_ARTIST, JobDbManager.COL_UP_COMPRESS_FLAG, JobDbManager.COL_UP_COMPRESS_PATH, JobDbManager.COL_UP_COMPRESS_SHA, JobDbManager.COL_UP_COVER_FILE_ID, JobDbManager.COL_UP_COVER_FILE_VERSION, JobDbManager.COL_UP_AUTO_BACKUP_FLAG, "group_root_dir_key", JobDbManager.COL_UP_BATCH_ID, JobDbManager.COL_UP_BATCH_TOTAL, JobDbManager.COL_UP_BATCH_INDEX, JobDbManager.COL_UP_BATCH_DESC, "state", "error_code", "error_msg", "total_size", "cur_size", "file_id"};
        }
    }

    public InfoRecorder(InfoRecorderCallback infoRecorderCallback, ReleaseLooperHandler releaseLooperHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) infoRecorderCallback, (Object) releaseLooperHandler);
            return;
        }
        this.mCallback = infoRecorderCallback;
        this.mHandler = releaseLooperHandler;
        releaseLooperHandler.addCallback(this);
    }

    private UploadJobContext convertData(Cursor cursor) {
        boolean z16;
        boolean z17;
        UploadFile.UploadBatch createUploadBatch = UploadFile.createUploadBatch(cursor.getInt(30), cursor.getString(32));
        int i3 = cursor.getInt(2);
        String string = cursor.getString(5);
        String string2 = cursor.getString(6);
        String string3 = cursor.getString(7);
        String string4 = cursor.getString(8);
        String string5 = cursor.getString(3);
        if (cursor.getInt(22) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        UploadFile createUploadFile = UploadFile.createUploadFile(i3, string, string2, string3, string4, string5, z16, createUploadBatch, cursor.getInt(31));
        createUploadFile.lastModified = cursor.getLong(4);
        createUploadFile.fileName = cursor.getString(10);
        createUploadFile.fileSize = cursor.getLong(11);
        createUploadFile.sha = cursor.getString(12);
        createUploadFile.mimeType = cursor.getString(13);
        createUploadFile.longitude = cursor.getDouble(14);
        createUploadFile.latitude = cursor.getDouble(15);
        createUploadFile.takenTime = cursor.getLong(16);
        createUploadFile.width = cursor.getInt(17);
        createUploadFile.height = cursor.getInt(18);
        createUploadFile.duration = cursor.getLong(19);
        createUploadFile.album = cursor.getString(20);
        createUploadFile.artist = cursor.getString(21);
        createUploadFile.compressedPath = cursor.getString(23);
        createUploadFile.compressedSha = cursor.getString(24);
        createUploadFile.coverFileId = cursor.getString(25);
        createUploadFile.coverFileVersion = cursor.getString(26);
        if (cursor.getInt(27) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        createUploadFile.autoBackupFlag = z17;
        createUploadFile.groupRootDirKey = cursor.getString(28);
        createUploadFile.batchId = cursor.getString(29);
        UploadJobContext.StatusInfo statusInfo = new UploadJobContext.StatusInfo();
        statusInfo.state = cursor.getInt(33);
        statusInfo.errorCode = cursor.getInt(34);
        statusInfo.errorMsg = cursor.getString(35);
        statusInfo.totalSize = cursor.getLong(36);
        statusInfo.currSize = cursor.getLong(37);
        statusInfo.fileId = cursor.getString(38);
        statusInfo.filePath = createUploadFile.localPath;
        statusInfo.autoBackupFlag = createUploadFile.autoBackupFlag;
        UploadJobContext createInstance = UploadJobContext.createInstance(cursor.getString(1), createUploadFile, statusInfo);
        createInstance.setDbId(cursor.getLong(0));
        createInstance.setBirthTime(cursor.getLong(9));
        return createInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void deleteData(long j3, boolean z16) {
        Cursor cursor;
        int delete;
        boolean z17 = true;
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
        UploadJobContext uploadJobContext = null;
        if (openJobDb == null) {
            TsLog.e(TAG, "deleteData: Job db is null.");
            delete = 0;
        } else {
            if (j3 >= 0) {
                try {
                    cursor = openJobDb.query(JobDbManager.TBL_UPLOAD, PROJ_RESTORE, "_id=?", new String[]{Long.toString(j3)}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                uploadJobContext = convertData(cursor);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                TsLog.e(TAG, th);
                                IOUtils.closeSilently(cursor);
                                if (!z16) {
                                }
                                JobDbManager.getInstance().closeJobDb(openJobDb);
                                UploadJobContext uploadJobContext2 = uploadJobContext;
                                InfoRecorderCallback infoRecorderCallback = this.mCallback;
                                if (delete <= 0) {
                                }
                                infoRecorderCallback.onInfoRemoved(j3, z17, uploadJobContext2);
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
                if (!z16) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("valid_flag", (Integer) 0);
                    delete = openJobDb.update(JobDbManager.TBL_UPLOAD, contentValues, "_id=?", new String[]{Long.toString(j3)});
                } else {
                    delete = openJobDb.delete(JobDbManager.TBL_UPLOAD, "_id=?", new String[]{Long.toString(j3)});
                }
            } else {
                delete = 0;
            }
            JobDbManager.getInstance().closeJobDb(openJobDb);
        }
        UploadJobContext uploadJobContext22 = uploadJobContext;
        InfoRecorderCallback infoRecorderCallback2 = this.mCallback;
        if (delete <= 0) {
            z17 = false;
        }
        infoRecorderCallback2.onInfoRemoved(j3, z17, uploadJobContext22);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void insertData(int i3, UploadJobContext uploadJobContext) {
        String str;
        String str2;
        String str3;
        Cursor cursor;
        long j3;
        if (uploadJobContext == null) {
            return;
        }
        UploadFile file = uploadJobContext.file();
        UploadJobContext.StatusInfo statusInfo = uploadJobContext.statusInfo();
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
        if (openJobDb == null) {
            TsLog.e(TAG, "insertData: Job db is null.");
            return;
        }
        long j16 = -1;
        try {
            str = "p_dir_key";
            str2 = "local_path";
            str3 = "uid";
        } catch (Throwable th5) {
            th = th5;
            str = "p_dir_key";
            str2 = "local_path";
            str3 = "uid";
        }
        try {
            cursor = openJobDb.query(JobDbManager.TBL_UPLOAD, PROJ_ADD, "uid=? AND local_path=? AND p_dir_key=? ", new String[]{uploadJobContext.uid(), file.localPath, file.pDirKey}, null, null, "insert_time DESC limit 1");
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        j16 = cursor.getInt(0);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        TsLog.e(TAG, th);
                        IOUtils.closeSilently(cursor);
                        long currentTimeMillis = System.currentTimeMillis();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(str3, uploadJobContext.uid());
                        contentValues.put("cmd_type", Integer.valueOf(file.cmdType));
                        contentValues.put(str2, file.localPath);
                        contentValues.put(JobDbManager.COL_UP_LOCAL_MODIFIED, Long.valueOf(file.lastModified));
                        contentValues.put("file_name", file.fileName);
                        contentValues.put("p_dir_uid", file.rootDirUid);
                        contentValues.put(JobDbManager.COL_UP_P_DIR_NAME, file.pDirName);
                        contentValues.put(str, file.pDirKey);
                        contentValues.put(JobDbManager.COL_UP_PP_DIR_KEY, file.pPDirKey);
                        contentValues.put("insert_time", Long.valueOf(currentTimeMillis));
                        contentValues.put("thumb_uri", file.thumbUrl);
                        contentValues.put(JobDbManager.COL_UP_COMPRESS_FLAG, Integer.valueOf(file.isCompress ? 1 : 0));
                        contentValues.put(JobDbManager.COL_UP_COVER_FILE_ID, file.coverFileId);
                        contentValues.put(JobDbManager.COL_UP_COVER_FILE_VERSION, file.coverFileVersion);
                        contentValues.put(JobDbManager.COL_UP_AUTO_BACKUP_FLAG, Integer.valueOf(file.autoBackupFlag ? 1 : 0));
                        contentValues.put("group_root_dir_key", file.groupRootDirKey);
                        contentValues.put(JobDbManager.COL_UP_BATCH_ID, file.batchId);
                        contentValues.put(JobDbManager.COL_UP_BATCH_TOTAL, Integer.valueOf(file.batchTotal));
                        contentValues.put(JobDbManager.COL_UP_BATCH_INDEX, Integer.valueOf(file.batchIndex));
                        contentValues.put(JobDbManager.COL_UP_BATCH_DESC, file.batchDesc);
                        contentValues.put("valid_flag", (Integer) 1);
                        uploadJobContext.setBirthTime(currentTimeMillis);
                        if (j16 >= 0) {
                        }
                        j3 = j16;
                        JobDbManager.getInstance().closeJobDb(openJobDb);
                        if (j3 >= 0) {
                        }
                    } catch (Throwable th7) {
                        IOUtils.closeSilently(cursor);
                        throw th7;
                    }
                }
            }
        } catch (Throwable th8) {
            th = th8;
            cursor = null;
            TsLog.e(TAG, th);
            IOUtils.closeSilently(cursor);
            long currentTimeMillis2 = System.currentTimeMillis();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(str3, uploadJobContext.uid());
            contentValues2.put("cmd_type", Integer.valueOf(file.cmdType));
            contentValues2.put(str2, file.localPath);
            contentValues2.put(JobDbManager.COL_UP_LOCAL_MODIFIED, Long.valueOf(file.lastModified));
            contentValues2.put("file_name", file.fileName);
            contentValues2.put("p_dir_uid", file.rootDirUid);
            contentValues2.put(JobDbManager.COL_UP_P_DIR_NAME, file.pDirName);
            contentValues2.put(str, file.pDirKey);
            contentValues2.put(JobDbManager.COL_UP_PP_DIR_KEY, file.pPDirKey);
            contentValues2.put("insert_time", Long.valueOf(currentTimeMillis2));
            contentValues2.put("thumb_uri", file.thumbUrl);
            contentValues2.put(JobDbManager.COL_UP_COMPRESS_FLAG, Integer.valueOf(file.isCompress ? 1 : 0));
            contentValues2.put(JobDbManager.COL_UP_COVER_FILE_ID, file.coverFileId);
            contentValues2.put(JobDbManager.COL_UP_COVER_FILE_VERSION, file.coverFileVersion);
            contentValues2.put(JobDbManager.COL_UP_AUTO_BACKUP_FLAG, Integer.valueOf(file.autoBackupFlag ? 1 : 0));
            contentValues2.put("group_root_dir_key", file.groupRootDirKey);
            contentValues2.put(JobDbManager.COL_UP_BATCH_ID, file.batchId);
            contentValues2.put(JobDbManager.COL_UP_BATCH_TOTAL, Integer.valueOf(file.batchTotal));
            contentValues2.put(JobDbManager.COL_UP_BATCH_INDEX, Integer.valueOf(file.batchIndex));
            contentValues2.put(JobDbManager.COL_UP_BATCH_DESC, file.batchDesc);
            contentValues2.put("valid_flag", (Integer) 1);
            uploadJobContext.setBirthTime(currentTimeMillis2);
            if (j16 >= 0) {
            }
            j3 = j16;
            JobDbManager.getInstance().closeJobDb(openJobDb);
            if (j3 >= 0) {
            }
        }
        IOUtils.closeSilently(cursor);
        long currentTimeMillis22 = System.currentTimeMillis();
        ContentValues contentValues22 = new ContentValues();
        contentValues22.put(str3, uploadJobContext.uid());
        contentValues22.put("cmd_type", Integer.valueOf(file.cmdType));
        contentValues22.put(str2, file.localPath);
        contentValues22.put(JobDbManager.COL_UP_LOCAL_MODIFIED, Long.valueOf(file.lastModified));
        contentValues22.put("file_name", file.fileName);
        contentValues22.put("p_dir_uid", file.rootDirUid);
        contentValues22.put(JobDbManager.COL_UP_P_DIR_NAME, file.pDirName);
        contentValues22.put(str, file.pDirKey);
        contentValues22.put(JobDbManager.COL_UP_PP_DIR_KEY, file.pPDirKey);
        contentValues22.put("insert_time", Long.valueOf(currentTimeMillis22));
        contentValues22.put("thumb_uri", file.thumbUrl);
        contentValues22.put(JobDbManager.COL_UP_COMPRESS_FLAG, Integer.valueOf(file.isCompress ? 1 : 0));
        contentValues22.put(JobDbManager.COL_UP_COVER_FILE_ID, file.coverFileId);
        contentValues22.put(JobDbManager.COL_UP_COVER_FILE_VERSION, file.coverFileVersion);
        contentValues22.put(JobDbManager.COL_UP_AUTO_BACKUP_FLAG, Integer.valueOf(file.autoBackupFlag ? 1 : 0));
        contentValues22.put("group_root_dir_key", file.groupRootDirKey);
        contentValues22.put(JobDbManager.COL_UP_BATCH_ID, file.batchId);
        contentValues22.put(JobDbManager.COL_UP_BATCH_TOTAL, Integer.valueOf(file.batchTotal));
        contentValues22.put(JobDbManager.COL_UP_BATCH_INDEX, Integer.valueOf(file.batchIndex));
        contentValues22.put(JobDbManager.COL_UP_BATCH_DESC, file.batchDesc);
        contentValues22.put("valid_flag", (Integer) 1);
        uploadJobContext.setBirthTime(currentTimeMillis22);
        if (j16 >= 0) {
            openJobDb.update(JobDbManager.TBL_UPLOAD, contentValues22, "_id=?", new String[]{Long.toString(j16)});
        } else {
            contentValues22.put("state", Integer.valueOf(statusInfo.state));
            contentValues22.put("error_code", Integer.valueOf(statusInfo.errorCode));
            contentValues22.put("error_msg", statusInfo.errorMsg);
            contentValues22.put("total_size", Long.valueOf(statusInfo.totalSize));
            contentValues22.put("cur_size", Long.valueOf(statusInfo.currSize));
            contentValues22.put("file_id", statusInfo.fileId);
            j16 = openJobDb.insert(JobDbManager.TBL_UPLOAD, null, contentValues22);
        }
        j3 = j16;
        JobDbManager.getInstance().closeJobDb(openJobDb);
        if (j3 >= 0) {
            uploadJobContext.setDbId(j3);
            this.mCallback.onInfoAdded(i3, uploadJobContext);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void restoreData(String str) {
        String str2;
        int i3;
        Cursor cursor;
        ArrayList arrayList;
        ArrayList arrayList2;
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(false);
        if (openJobDb == null) {
            TsLog.e(TAG, "restoreData: Job db is null.");
            arrayList2 = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            try {
                str2 = "valid_flag";
                i3 = 1;
            } catch (Throwable th5) {
                th = th5;
                str2 = "valid_flag";
                i3 = 1;
            }
            try {
                cursor = openJobDb.query(JobDbManager.TBL_UPLOAD, PROJ_RESTORE, "uid=? AND valid_flag=1 AND state<>? ", new String[]{str, Integer.toString(5)}, null, null, "insert_time ASC");
                if (cursor != null) {
                    try {
                        arrayList = new ArrayList(cursor.getCount());
                        while (cursor.moveToNext()) {
                            try {
                                UploadJobContext convertData = convertData(cursor);
                                if (convertData.file().autoBackupFlag) {
                                    arrayList3.add(convertData);
                                } else {
                                    arrayList.add(convertData);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                try {
                                    TsLog.e(TAG, th);
                                    IOUtils.closeSilently(cursor);
                                    if (!arrayList3.isEmpty()) {
                                    }
                                    JobDbManager.getInstance().closeJobDb(openJobDb);
                                    arrayList2 = arrayList;
                                    this.mCallback.onInfoRestored(str, arrayList2);
                                } catch (Throwable th7) {
                                    IOUtils.closeSilently(cursor);
                                    throw th7;
                                }
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        arrayList = null;
                        TsLog.e(TAG, th);
                        IOUtils.closeSilently(cursor);
                        if (!arrayList3.isEmpty()) {
                        }
                        JobDbManager.getInstance().closeJobDb(openJobDb);
                        arrayList2 = arrayList;
                        this.mCallback.onInfoRestored(str, arrayList2);
                    }
                } else {
                    arrayList = null;
                }
            } catch (Throwable th9) {
                th = th9;
                cursor = null;
                arrayList = null;
                TsLog.e(TAG, th);
                IOUtils.closeSilently(cursor);
                if (!arrayList3.isEmpty()) {
                }
                JobDbManager.getInstance().closeJobDb(openJobDb);
                arrayList2 = arrayList;
                this.mCallback.onInfoRestored(str, arrayList2);
            }
            IOUtils.closeSilently(cursor);
            if (!arrayList3.isEmpty()) {
                StringBuilder sb5 = new StringBuilder(" IN (");
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    sb5.append(((UploadJobContext) it.next()).dbId());
                    sb5.append(',');
                }
                sb5.setCharAt(sb5.length() - i3, ')');
                ContentValues contentValues = new ContentValues(i3);
                contentValues.put(str2, (Integer) 0);
                openJobDb.update(JobDbManager.TBL_UPLOAD, contentValues, "_id" + sb5.toString(), null);
            }
            JobDbManager.getInstance().closeJobDb(openJobDb);
            arrayList2 = arrayList;
        }
        this.mCallback.onInfoRestored(str, arrayList2);
    }

    private void updateData(ContentValues contentValues, UploadJobContext.StatusInfo statusInfo, boolean z16) {
        int i3;
        if (contentValues != null && contentValues.size() > 0) {
            long longValue = contentValues.getAsLong("_id").longValue();
            JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
            boolean z17 = false;
            if (openJobDb == null) {
                TsLog.e(TAG, "updateData: Job db is null.");
                i3 = 0;
            } else {
                if (longValue >= 0) {
                    i3 = openJobDb.update(JobDbManager.TBL_UPLOAD, contentValues, "_id=?", new String[]{Long.toString(longValue)});
                } else {
                    i3 = 0;
                }
                JobDbManager.getInstance().closeJobDb(openJobDb);
            }
            InfoRecorderCallback infoRecorderCallback = this.mCallback;
            if (i3 > 0) {
                z17 = true;
            }
            infoRecorderCallback.onInfoUpdated(longValue, z17, statusInfo, z16);
        }
    }

    public void addInfo(int i3, UploadJobContext uploadJobContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) uploadJobContext);
        } else {
            if (uploadJobContext == null) {
                return;
            }
            this.mHandler.sendMessage(Message.obtain(null, 1, i3, 0, uploadJobContext));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            boolean z16 = false;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return false;
                    }
                    restoreData((String) message.obj);
                    return true;
                }
                long longValue = ((Long) message.obj).longValue();
                if (message.arg1 == 1) {
                    z16 = true;
                }
                deleteData(longValue, z16);
                return true;
            }
            if (message.arg1 == 1) {
                Object obj = message.obj;
                updateData((ContentValues) ((Object[]) obj)[0], (UploadJobContext.StatusInfo) ((Object[]) obj)[1], true);
                return true;
            }
            updateData((ContentValues) message.obj, null, false);
            return true;
        }
        insertData(message.arg1, (UploadJobContext) message.obj);
        return true;
    }

    public void removeInfo(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Boolean.valueOf(z16));
        } else {
            if (j3 < 0) {
                return;
            }
            this.mHandler.sendMessage(Message.obtain(null, 3, z16 ? 1 : 0, 0, Long.valueOf(j3)));
        }
    }

    public void restoreInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.mHandler.sendMessage(Message.obtain(null, 4, str));
        }
    }

    public void updateInfo(UploadJobContext uploadJobContext, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uploadJobContext, Boolean.valueOf(z16));
            return;
        }
        if (uploadJobContext == null) {
            return;
        }
        UploadJobContext.StatusInfo cloneStatusInfo = uploadJobContext.cloneStatusInfo();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(uploadJobContext.dbId()));
        contentValues.put("state", Integer.valueOf(cloneStatusInfo.state));
        contentValues.put("error_code", Integer.valueOf(cloneStatusInfo.errorCode));
        contentValues.put("error_msg", cloneStatusInfo.errorMsg);
        contentValues.put("total_size", Long.valueOf(cloneStatusInfo.totalSize));
        contentValues.put("cur_size", Long.valueOf(cloneStatusInfo.currSize));
        contentValues.put("file_id", cloneStatusInfo.fileId);
        if (!TextUtils.isEmpty(uploadJobContext.fileVersion())) {
            contentValues.put("file_version", uploadJobContext.fileVersion());
        }
        this.mHandler.sendMessage(Message.obtain(null, 2, z16 ? 1 : 0, 0, new Object[]{contentValues, cloneStatusInfo}));
    }

    public void updateInfo(long j3, UploadFile uploadFile) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), uploadFile);
            return;
        }
        if (j3 < 0 || uploadFile == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(j3));
        contentValues.put(JobDbManager.COL_UP_P_DIR_NAME, uploadFile.pDirName);
        contentValues.put("p_dir_key", uploadFile.pDirKey);
        contentValues.put(JobDbManager.COL_UP_PP_DIR_KEY, uploadFile.pPDirKey);
        contentValues.put("local_path", uploadFile.localPath);
        contentValues.put(JobDbManager.COL_UP_LOCAL_MODIFIED, Long.valueOf(uploadFile.lastModified));
        contentValues.put("file_size", Long.valueOf(uploadFile.fileSize));
        contentValues.put(JobDbManager.COL_UP_LOCAL_SHA, uploadFile.sha);
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, uploadFile.mimeType);
        contentValues.put("longitude", Double.valueOf(uploadFile.longitude));
        contentValues.put("latitude", Double.valueOf(uploadFile.latitude));
        contentValues.put(JobDbManager.COL_UP_TAKEN_TIME, Long.valueOf(uploadFile.takenTime));
        contentValues.put("width", Integer.valueOf(uploadFile.width));
        contentValues.put("height", Integer.valueOf(uploadFile.height));
        contentValues.put("duration", Long.valueOf(uploadFile.duration));
        contentValues.put("album", uploadFile.album);
        contentValues.put(JobDbManager.COL_UP_ARTIST, uploadFile.artist);
        contentValues.put(JobDbManager.COL_UP_COMPRESS_PATH, uploadFile.compressedPath);
        contentValues.put(JobDbManager.COL_UP_COMPRESS_SHA, uploadFile.compressedSha);
        this.mHandler.sendMessage(Message.obtain(null, 2, contentValues));
    }
}
