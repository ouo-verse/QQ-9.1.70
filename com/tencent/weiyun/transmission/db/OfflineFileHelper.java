package com.tencent.weiyun.transmission.db;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.utils.IOUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OfflineFileHelper {
    static IPatchRedirector $redirector_ = null;
    private static final int DOWNLOAD_STATE_FAILED = 5;
    private static final int DOWNLOAD_STATE_INIT = 0;
    private static final int DOWNLOAD_STATE_RUNNING = 2;
    private static final int DOWNLOAD_STATE_SUCCESS = 4;
    private static final int DOWNLOAD_STATE_SUSPEND = 3;
    private static final int DOWNLOAD_STATE_WAIT = 1;
    private static final String TAG = "OfflineFileHelper";

    public OfflineFileHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015c A[EXC_TOP_SPLITTER, LOOP:0: B:36:0x015c->B:44:0x015c, LOOP_START, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> getOfflineFilePath(String str, String str2, String str3) {
        String[] strArr;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        char c16;
        Cursor cursor;
        String[] strArr2;
        StringBuilder sb5;
        Cursor query;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashSet hashSet = new HashSet();
            JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(false);
            if (openJobDb == null) {
                TsLog.e(TAG, "getOfflineFilePath: Job db is null.");
            } else {
                boolean isEmpty = TextUtils.isEmpty(str3);
                if (isEmpty) {
                    strArr = new String[]{str, str2, Integer.toString(4)};
                } else {
                    strArr = new String[]{str, str2, str3, Integer.toString(4)};
                }
                String[] strArr3 = strArr;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("uid");
                sb6.append("=? AND ");
                sb6.append("file_id");
                sb6.append("=? AND ");
                if (!isEmpty) {
                    sb6.append(JobDbManager.COL_DOWN_CLOUD_SHA);
                    sb6.append("=? AND ");
                }
                sb6.append("state");
                sb6.append("=? ");
                Cursor cursor2 = null;
                try {
                    str4 = "=? ";
                    str5 = "state";
                    str6 = "file_id";
                    str7 = "=? AND ";
                    str8 = "uid";
                    c16 = 4;
                } catch (Throwable th5) {
                    th = th5;
                    str4 = "=? ";
                    str5 = "state";
                    str6 = "file_id";
                    str7 = "=? AND ";
                    str8 = "uid";
                    c16 = 4;
                }
                try {
                    cursor = openJobDb.query("download", new String[]{"local_path"}, sb6.toString(), strArr3, null, null, "insert_time ASC");
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                String string = cursor.getString(0);
                                if (!TextUtils.isEmpty(string)) {
                                    hashSet.add(string);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                try {
                                    TsLog.e(TAG, th);
                                    IOUtils.closeSilently(cursor);
                                    if (isEmpty) {
                                    }
                                    String[] strArr4 = strArr2;
                                    sb5 = new StringBuilder();
                                    sb5.append(str8);
                                    String str9 = str7;
                                    sb5.append(str9);
                                    sb5.append(str6);
                                    sb5.append(str9);
                                    if (!isEmpty) {
                                    }
                                    sb5.append(str5);
                                    sb5.append(str4);
                                    query = openJobDb.query(JobDbManager.TBL_UPLOAD, new String[]{"local_path"}, sb5.toString(), strArr4, null, null, "insert_time ASC");
                                    if (query != null) {
                                    }
                                    IOUtils.closeSilently(query);
                                    JobDbManager.getInstance().closeJobDb(openJobDb);
                                    return new ArrayList(hashSet);
                                } finally {
                                }
                            }
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    cursor = null;
                    TsLog.e(TAG, th);
                    IOUtils.closeSilently(cursor);
                    if (isEmpty) {
                    }
                    String[] strArr42 = strArr2;
                    sb5 = new StringBuilder();
                    sb5.append(str8);
                    String str92 = str7;
                    sb5.append(str92);
                    sb5.append(str6);
                    sb5.append(str92);
                    if (!isEmpty) {
                    }
                    sb5.append(str5);
                    sb5.append(str4);
                    query = openJobDb.query(JobDbManager.TBL_UPLOAD, new String[]{"local_path"}, sb5.toString(), strArr42, null, null, "insert_time ASC");
                    if (query != null) {
                    }
                    IOUtils.closeSilently(query);
                    JobDbManager.getInstance().closeJobDb(openJobDb);
                    return new ArrayList(hashSet);
                }
                IOUtils.closeSilently(cursor);
                if (isEmpty) {
                    strArr2 = new String[]{str, str2, Integer.toString(5)};
                } else {
                    strArr2 = new String[5];
                    strArr2[0] = str;
                    strArr2[1] = str2;
                    strArr2[2] = str3;
                    strArr2[3] = str3;
                    strArr2[c16] = Integer.toString(5);
                }
                String[] strArr422 = strArr2;
                sb5 = new StringBuilder();
                sb5.append(str8);
                String str922 = str7;
                sb5.append(str922);
                sb5.append(str6);
                sb5.append(str922);
                if (!isEmpty) {
                    sb5.append('(');
                    sb5.append(JobDbManager.COL_UP_LOCAL_SHA);
                    sb5.append("=? OR ");
                    sb5.append(JobDbManager.COL_UP_COMPRESS_SHA);
                    sb5.append("=?) AND ");
                }
                sb5.append(str5);
                sb5.append(str4);
                try {
                    query = openJobDb.query(JobDbManager.TBL_UPLOAD, new String[]{"local_path"}, sb5.toString(), strArr422, null, null, "insert_time ASC");
                    if (query != null) {
                        while (query.moveToNext()) {
                            try {
                                String string2 = query.getString(0);
                                if (!TextUtils.isEmpty(string2)) {
                                    hashSet.add(string2);
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                cursor2 = query;
                                try {
                                    TsLog.e(TAG, th);
                                    JobDbManager.getInstance().closeJobDb(openJobDb);
                                    return new ArrayList(hashSet);
                                } finally {
                                }
                            }
                        }
                    }
                    IOUtils.closeSilently(query);
                } catch (Throwable th9) {
                    th = th9;
                }
                JobDbManager.getInstance().closeJobDb(openJobDb);
            }
            return new ArrayList(hashSet);
        }
        return new ArrayList(0);
    }
}
