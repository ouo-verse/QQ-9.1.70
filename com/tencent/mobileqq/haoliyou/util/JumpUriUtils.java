package com.tencent.mobileqq.haoliyou.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JumpUriUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "JumpUriUtils";

    JumpUriUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String getCopyFileNameFromUri(Uri uri) {
        try {
            String uri2 = uri.toString();
            int lastIndexOf = uri2.lastIndexOf(File.separator);
            if (lastIndexOf < 0 || lastIndexOf >= uri2.length()) {
                uri2 = uri2.substring(lastIndexOf + 1);
            }
            return FileUtils.sanitizeFilename(uri2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getCopyFileNameFromUri catch exception: ", e16);
            return "";
        }
    }

    private static int getCopySizeFromUri(ContentResolver contentResolver, Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = contentResolver.openInputStream(uri);
                int available = inputStream.available();
                try {
                    inputStream.close();
                } catch (IOException e16) {
                    QLog.e(TAG, 1, "getCopySizeFromUri finally catch Exception:", e16);
                }
                return available;
            } catch (Throwable th5) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e17) {
                        QLog.e(TAG, 1, "getCopySizeFromUri finally catch Exception:", e17);
                    }
                }
                throw th5;
            }
        } catch (Exception e18) {
            QLog.e(TAG, 1, "getCopySizeFromUri catch Exception:", e18);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return 0;
                } catch (IOException e19) {
                    QLog.e(TAG, 1, "getCopySizeFromUri finally catch Exception:", e19);
                    return 0;
                }
            }
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cd, code lost:
    
        if (r3 == null) goto L42;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0118  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static UriQueryFileInfo getUriFileNameAndLength(ContentResolver contentResolver, Uri uri) {
        Cursor cursor;
        String string;
        ?? r26 = 0;
        if (contentResolver == null || uri == null) {
            return null;
        }
        long j3 = 0;
        try {
            try {
                cursor = ContactsMonitor.query(contentResolver, uri, null, null, null, null);
            } catch (Exception e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (r26 != 0) {
                }
                throw th;
            }
            try {
            } catch (Exception e17) {
                e = e17;
                QLog.e(TAG, 1, "getUriFileNameAndLength resolver query Exception", e);
            }
            if (cursor == null) {
                QLog.i(TAG, 1, "getUriFileNameAndLength query cursor null");
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            cursor.moveToFirst();
            j3 = readLastModified(cursor);
            int columnIndex = cursor.getColumnIndex(InputMethodUtil.SOUGOU_URI_DISPLAYNAME);
            long j16 = cursor.getLong(cursor.getColumnIndex("_size"));
            if (columnIndex == -1) {
                string = System.currentTimeMillis() + "";
            } else {
                string = cursor.getString(columnIndex);
            }
            String sanitizeFilename = FileUtils.sanitizeFilename(string);
            if (!TextUtils.isEmpty(sanitizeFilename)) {
                UriQueryFileInfo uriQueryFileInfo = new UriQueryFileInfo(sanitizeFilename, j16, j3);
                cursor.close();
                return uriQueryFileInfo;
            }
            String string2 = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            if (!TextUtils.isEmpty(string2)) {
                sanitizeFilename = FileUtils.sanitizeFilename(new File(string2).getName());
            }
            QLog.i(TAG, 1, "getUriFileNameAndLength cursor path name: " + sanitizeFilename);
            if (!TextUtils.isEmpty(sanitizeFilename)) {
                UriQueryFileInfo uriQueryFileInfo2 = new UriQueryFileInfo(sanitizeFilename, j16, j3);
                cursor.close();
                return uriQueryFileInfo2;
            }
            cursor.close();
            String copyFileNameFromUri = getCopyFileNameFromUri(uri);
            long copySizeFromUri = getCopySizeFromUri(contentResolver, uri);
            QLog.i(TAG, 1, "getUriFileNameAndLength copy name: " + copyFileNameFromUri + ", size:" + copySizeFromUri + ", lastModified:" + j3);
            if (!TextUtils.isEmpty(copyFileNameFromUri)) {
                return new UriQueryFileInfo(copyFileNameFromUri, copySizeFromUri, j3);
            }
            QLog.e(TAG, 1, "getUriFileNameAndLength getCopyName fail");
            return null;
        } catch (Throwable th6) {
            th = th6;
            r26 = contentResolver;
            if (r26 != 0) {
                r26.close();
            }
            throw th;
        }
    }

    public static void grantShareUriPermissions(Intent intent, Activity activity) {
        Bundle extras;
        if (intent == null || activity == null || (extras = intent.getExtras()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Object obj = extras.get("android.intent.extra.STREAM");
            if (obj instanceof ArrayList) {
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof Uri) {
                        arrayList.add((Uri) next);
                    }
                }
            } else if (obj instanceof Uri) {
                arrayList.add((Uri) obj);
            }
            Uri data = intent.getData();
            if (data != null) {
                arrayList.add(data);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "grantShareUriPermissions catch exception: ", e16);
        }
        QLog.d(TAG, 4, "grantShareUriPermissions uriList size\uff1a" + arrayList.size());
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            try {
                activity.grantUriPermission(activity.getPackageName(), (Uri) it5.next(), 1);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "grantShareUriPermissions catch exception: ", th5);
            }
        }
    }

    public static long queryLastModified(ContentResolver contentResolver, Uri uri) {
        if (contentResolver == null || uri == null) {
            return 0L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Cursor cursor = null;
        try {
            try {
                Cursor query = ContactsMonitor.query(contentResolver, uri, null, null, null, null);
                if (query == null) {
                    QLog.i(TAG, 1, "queryLastModified query cursor null");
                    if (query != null) {
                        query.close();
                    }
                    return 0L;
                }
                query.moveToFirst();
                long readLastModified = readLastModified(query);
                QLog.d(TAG, 4, "queryLastModified cost: " + (System.currentTimeMillis() - currentTimeMillis));
                query.close();
                return readLastModified;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "queryLastModified resolver query Exception", e16);
                if (0 != 0) {
                    cursor.close();
                }
                return 0L;
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                cursor.close();
            }
            throw th5;
        }
    }

    private static long readLastModified(Cursor cursor) {
        int columnIndex;
        if (cursor == null) {
            return 0L;
        }
        try {
            columnIndex = cursor.getColumnIndex("date_modified");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "readLastModified resolver query Exception", e16);
        }
        if (columnIndex >= 0) {
            return cursor.getLong(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("last_modified");
        if (columnIndex2 >= 0) {
            return cursor.getLong(columnIndex2);
        }
        QLog.i(TAG, 1, "readLastModified lastModified available columns: " + Arrays.toString(cursor.getColumnNames()));
        QLog.i(TAG, 1, "readLastModified return default");
        return 0L;
    }
}
