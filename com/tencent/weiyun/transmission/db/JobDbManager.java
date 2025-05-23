package com.tencent.weiyun.transmission.db;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.utils.Singleton;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class JobDbManager {
    static IPatchRedirector $redirector_ = null;
    public static final String COL_DOWN_CLOUD_SHA = "cloud_sha";
    public static final String COL_DOWN_CMD_TYPE = "cmd_type";
    public static final String COL_DOWN_CUR_SIZE = "cur_size";
    public static final String COL_DOWN_ERROR_CODE = "error_code";
    public static final String COL_DOWN_ERROR_MSG = "error_msg";
    public static final String COL_DOWN_FILE_ID = "file_id";
    public static final String COL_DOWN_FILE_NAME = "file_name";
    public static final String COL_DOWN_FILE_SIZE = "file_size";
    public static final String COL_DOWN_FILE_TYPE = "file_type";
    public static final String COL_DOWN_FILE_VERSION = "file_version";
    public static final String COL_DOWN_GROUP_ROOT_DIR_KEY = "group_root_dir_key";
    public static final String COL_DOWN_ID = "_id";
    public static final String COL_DOWN_INSERT_TIME = "insert_time";
    public static final String COL_DOWN_LOCAL_DIR = "local_dir";
    public static final String COL_DOWN_LOCAL_PATH = "local_path";
    public static final String COL_DOWN_P_DIR_KEY = "p_dir_key";
    public static final String COL_DOWN_P_DIR_UID = "p_dir_uid";
    public static final String COL_DOWN_STATE = "state";
    public static final String COL_DOWN_THUMB_URI = "thumb_uri";
    public static final String COL_DOWN_TOTAL_SIZE = "total_size";
    public static final String COL_DOWN_UID = "uid";
    public static final String COL_DOWN_VALID_FLAG = "valid_flag";
    public static final String COL_UP_ALBUM = "album";
    public static final String COL_UP_ARTIST = "artist";
    public static final String COL_UP_AUTO_BACKUP_FLAG = "auto_backup_flag";
    public static final String COL_UP_BATCH_DESC = "batch_desc";
    public static final String COL_UP_BATCH_ID = "batch_id";
    public static final String COL_UP_BATCH_INDEX = "batch_index";
    public static final String COL_UP_BATCH_TOTAL = "batch_total";
    public static final String COL_UP_CMD_TYPE = "cmd_type";
    public static final String COL_UP_COMPRESS_FLAG = "compress_flag";
    public static final String COL_UP_COMPRESS_PATH = "compress_path";
    public static final String COL_UP_COMPRESS_SHA = "compress_sha";
    public static final String COL_UP_COVER_FILE_ID = "cover_file_id";
    public static final String COL_UP_COVER_FILE_VERSION = "cover_file_version";
    public static final String COL_UP_CUR_SIZE = "cur_size";
    public static final String COL_UP_DURATION = "duration";
    public static final String COL_UP_ERROR_CODE = "error_code";
    public static final String COL_UP_ERROR_MSG = "error_msg";
    public static final String COL_UP_FILE_ID = "file_id";
    public static final String COL_UP_FILE_NAME = "file_name";
    public static final String COL_UP_FILE_SIZE = "file_size";
    public static final String COL_UP_FILE_VERSION = "file_version";
    public static final String COL_UP_GROUP_ROOT_DIR_KEY = "group_root_dir_key";
    public static final String COL_UP_HEIGHT = "height";
    public static final String COL_UP_ID = "_id";
    public static final String COL_UP_INSERT_TIME = "insert_time";
    public static final String COL_UP_LATITUDE = "latitude";
    public static final String COL_UP_LOCAL_MODIFIED = "local_modified";
    public static final String COL_UP_LOCAL_PATH = "local_path";
    public static final String COL_UP_LOCAL_SHA = "local_sha";
    public static final String COL_UP_LONGITUDE = "longitude";
    public static final String COL_UP_MIME_TYPE = "mime_type";
    public static final String COL_UP_PP_DIR_KEY = "pp_dir_key";
    public static final String COL_UP_P_DIR_KEY = "p_dir_key";
    public static final String COL_UP_P_DIR_NAME = "p_dir_name";
    public static final String COL_UP_P_DIR_UID = "p_dir_uid";
    public static final String COL_UP_STATE = "state";
    public static final String COL_UP_TAKEN_TIME = "taken_time";
    public static final String COL_UP_THUMB_URI = "thumb_uri";
    public static final String COL_UP_TOTAL_SIZE = "total_size";
    public static final String COL_UP_UID = "uid";
    public static final String COL_UP_VALID_FLAG = "valid_flag";
    public static final String COL_UP_WIDTH = "width";
    public static final String TBL_DOWNLOAD = "download";
    public static final String TBL_UPLOAD = "upload";
    private static Singleton<JobDbManager, Void> sInstance;
    private final JobDbHelper mJobDbHelper;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11609);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            sInstance = new Singleton<JobDbManager, Void>() { // from class: com.tencent.weiyun.transmission.db.JobDbManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.weiyun.utils.Singleton
                public JobDbManager create(Void r46) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new JobDbManager(null) : (JobDbManager) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
                }
            };
        }
    }

    /* synthetic */ JobDbManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
    }

    public static JobDbManager getInstance() {
        return sInstance.get(null);
    }

    public void closeJobDb(JobDbWrapper jobDbWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jobDbWrapper);
        } else if (jobDbWrapper != null) {
            this.mJobDbHelper.closeDatabase(jobDbWrapper.database());
        }
    }

    public void dumpDb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mJobDbHelper.dumpDb(WeiyunTransmissionGlobal.getInstance().getContext(), Environment.getExternalStorageDirectory());
    }

    public JobDbWrapper openJobDb(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JobDbWrapper) iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
        SQLiteDatabase openDatabase = this.mJobDbHelper.openDatabase(z16);
        if (openDatabase == null) {
            return null;
        }
        return new JobDbWrapper(openDatabase);
    }

    JobDbManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mJobDbHelper = new JobDbHelper(WeiyunTransmissionGlobal.getInstance().getContext());
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
