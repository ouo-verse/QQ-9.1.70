package g05;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.qzone.album.data.model.AlbumCacheData;
import com.yolo.esports.download.common.DownloadInfo;

/* compiled from: P */
/* loaded from: classes28.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f401052a = {"download_ticket", "download_url", "file_size", "file_md5", "file_name", "file_abs_path", "file_root_dir", AlbumCacheData.CREATE_TIME, "cost_time", "received_length", "total_length", "error_code", "error_msg", "priority", "scene", "pause_on_mobile", "download_state", "extra_info", "unique_id", "file_type"};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ContentValues a(DownloadInfo downloadInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_ticket", downloadInfo.s());
        contentValues.put("download_url", downloadInfo.f390014e);
        contentValues.put("file_size", Long.valueOf(downloadInfo.f390018m));
        contentValues.put("file_md5", downloadInfo.C);
        contentValues.put("file_name", downloadInfo.f390015f);
        contentValues.put("file_abs_path", downloadInfo.f390017i);
        contentValues.put("file_root_dir", downloadInfo.f390016h);
        contentValues.put(AlbumCacheData.CREATE_TIME, Long.valueOf(downloadInfo.D));
        contentValues.put("cost_time", Long.valueOf(downloadInfo.E));
        contentValues.put("received_length", Long.valueOf(downloadInfo.F));
        contentValues.put("total_length", Long.valueOf(downloadInfo.G));
        contentValues.put("error_code", Integer.valueOf(downloadInfo.H));
        contentValues.put("error_msg", downloadInfo.I);
        contentValues.put("priority", Integer.valueOf(downloadInfo.J));
        contentValues.put("scene", downloadInfo.K);
        contentValues.put("pause_on_mobile", Boolean.valueOf(downloadInfo.L));
        contentValues.put("download_state", Integer.valueOf(downloadInfo.M));
        contentValues.put("extra_info", downloadInfo.N);
        contentValues.put("unique_id", downloadInfo.P);
        contentValues.put("file_type", downloadInfo.U);
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DownloadInfo b(Cursor cursor) {
        boolean z16;
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.y(cursor.getString(c(cursor, "download_ticket")));
        downloadInfo.f390014e = cursor.getString(c(cursor, "download_url"));
        downloadInfo.f390018m = cursor.getLong(c(cursor, "file_size"));
        downloadInfo.C = cursor.getString(c(cursor, "file_md5"));
        downloadInfo.f390015f = cursor.getString(c(cursor, "file_name"));
        downloadInfo.f390017i = cursor.getString(c(cursor, "file_abs_path"));
        downloadInfo.f390016h = cursor.getString(c(cursor, "file_root_dir"));
        downloadInfo.D = cursor.getLong(c(cursor, AlbumCacheData.CREATE_TIME));
        downloadInfo.E = cursor.getLong(c(cursor, "cost_time"));
        downloadInfo.F = cursor.getLong(c(cursor, "received_length"));
        downloadInfo.G = cursor.getLong(c(cursor, "total_length"));
        downloadInfo.H = cursor.getInt(c(cursor, "error_code"));
        downloadInfo.I = cursor.getString(c(cursor, "error_msg"));
        downloadInfo.J = cursor.getInt(c(cursor, "priority"));
        downloadInfo.K = cursor.getString(c(cursor, "scene"));
        if (cursor.getInt(c(cursor, "pause_on_mobile")) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        downloadInfo.L = z16;
        downloadInfo.M = cursor.getInt(c(cursor, "download_state"));
        downloadInfo.N = cursor.getString(c(cursor, "extra_info"));
        downloadInfo.P = cursor.getString(c(cursor, "unique_id"));
        downloadInfo.U = cursor.getString(c(cursor, "file_type"));
        return downloadInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(Cursor cursor, String str) {
        if (cursor != null && !TextUtils.isEmpty(str)) {
            return cursor.getColumnIndex(str);
        }
        return -1;
    }
}
