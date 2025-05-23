package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
@RequiresApi(19)
/* loaded from: classes.dex */
class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    DocumentsContractApi19() {
    }

    public static boolean canRead(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(getRawType(context, uri))) {
            return true;
        }
        return false;
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String rawType = getRawType(context, uri);
        int queryForInt = queryForInt(context, uri, WadlProxyConsts.FLAGS, 0);
        if (TextUtils.isEmpty(rawType)) {
            return false;
        }
        if ((queryForInt & 4) != 0) {
            return true;
        }
        if ("vnd.android.document/directory".equals(rawType) && (queryForInt & 8) != 0) {
            return true;
        }
        if (TextUtils.isEmpty(rawType) || (queryForInt & 2) == 0) {
            return false;
        }
        return true;
    }

    private static void closeQuietly(@Nullable AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e16) {
                throw e16;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean exists(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        boolean z16 = false;
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(contentResolver, uri, new String[]{"document_id"}, null, null, null);
            if (cursor.getCount() > 0) {
                z16 = true;
            }
            return z16;
        } catch (Exception e16) {
            Log.w(TAG, "Failed query: " + e16);
            return false;
        } finally {
            closeQuietly(cursor);
        }
    }

    public static long getFlags(Context context, Uri uri) {
        return queryForLong(context, uri, WadlProxyConsts.FLAGS, 0L);
    }

    @Nullable
    public static String getName(Context context, Uri uri) {
        return queryForString(context, uri, InputMethodUtil.SOUGOU_URI_DISPLAYNAME, null);
    }

    @Nullable
    private static String getRawType(Context context, Uri uri) {
        return queryForString(context, uri, JobDbManager.COL_UP_MIME_TYPE, null);
    }

    @Nullable
    public static String getType(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        if ("vnd.android.document/directory".equals(rawType)) {
            return null;
        }
        return rawType;
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(getRawType(context, uri));
    }

    public static boolean isFile(Context context, Uri uri) {
        String rawType = getRawType(context, uri);
        if (!"vnd.android.document/directory".equals(rawType) && !TextUtils.isEmpty(rawType)) {
            return true;
        }
        return false;
    }

    public static boolean isVirtual(Context context, Uri uri) {
        if (!DocumentsContract.isDocumentUri(context, uri) || (getFlags(context, uri) & 512) == 0) {
            return false;
        }
        return true;
    }

    public static long lastModified(Context context, Uri uri) {
        return queryForLong(context, uri, "last_modified", 0L);
    }

    public static long length(Context context, Uri uri) {
        return queryForLong(context, uri, "_size", 0L);
    }

    private static int queryForInt(Context context, Uri uri, String str, int i3) {
        return (int) queryForLong(context, uri, str, i3);
    }

    private static long queryForLong(Context context, Uri uri, String str, long j3) {
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{str}, null, null, null);
            if (cursor.moveToFirst() && !cursor.isNull(0)) {
                return cursor.getLong(0);
            }
            return j3;
        } catch (Exception e16) {
            Log.w(TAG, "Failed query: " + e16);
            return j3;
        } finally {
            closeQuietly(cursor);
        }
    }

    @Nullable
    private static String queryForString(Context context, Uri uri, String str, @Nullable String str2) {
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), uri, new String[]{str}, null, null, null);
            if (cursor.moveToFirst() && !cursor.isNull(0)) {
                return cursor.getString(0);
            }
            return str2;
        } catch (Exception e16) {
            Log.w(TAG, "Failed query: " + e16);
            return str2;
        } finally {
            closeQuietly(cursor);
        }
    }
}
