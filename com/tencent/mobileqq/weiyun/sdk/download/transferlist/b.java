package com.tencent.mobileqq.weiyun.sdk.download.transferlist;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.utils.IOUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private interface a {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f315250a;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(21039), (Class<?>) a.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                f315250a = new String[]{"_id", "uid", "file_name", "p_dir_key", "file_id", JobDbManager.COL_DOWN_CLOUD_SHA, "file_size", JobDbManager.COL_DOWN_LOCAL_DIR, "insert_time", "thumb_uri", "state", "error_code", "error_msg", "total_size", "cur_size", "local_path", "file_version", "p_dir_uid", "group_root_dir_key"};
            }
        }
    }

    public static int a(String str) {
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
        if (openJobDb == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("valid_flag", (Integer) 0);
        int update = openJobDb.update("download", contentValues, "uid=? AND state = 4", new String[]{str});
        JobDbManager.getInstance().closeJobDb(openJobDb);
        return update;
    }

    public static ArrayList<com.tencent.mobileqq.weiyun.sdk.download.transferlist.a> b(String str) {
        ArrayList<com.tencent.mobileqq.weiyun.sdk.download.transferlist.a> arrayList = new ArrayList<>();
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
        if (openJobDb != null) {
            Cursor cursor = null;
            try {
                cursor = openJobDb.query("download", a.f315250a, "uid=? AND valid_flag = 1", new String[]{str}, null, null, "CASE WHEN state = 4 THEN 1  WHEN state != 4 THEN 2 END DESC,CASE WHEN state = 4 THEN 1-insert_time WHEN state != 4 THEN _id END ASC");
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        arrayList.add(c(cursor));
                    }
                }
            } catch (Throwable unused) {
            }
            IOUtils.closeSilently(cursor);
            JobDbManager.getInstance().closeJobDb(openJobDb);
        }
        return arrayList;
    }

    private static com.tencent.mobileqq.weiyun.sdk.download.transferlist.a c(Cursor cursor) {
        com.tencent.mobileqq.weiyun.sdk.download.transferlist.a aVar = new com.tencent.mobileqq.weiyun.sdk.download.transferlist.a();
        aVar.f315231a = cursor.getLong(0);
        aVar.f315232b = cursor.getString(1);
        aVar.f315233c = cursor.getString(2);
        aVar.f315234d = cursor.getString(3);
        aVar.f315235e = cursor.getString(4);
        aVar.f315236f = cursor.getString(5);
        aVar.f315237g = cursor.getLong(6);
        aVar.f315238h = cursor.getString(7);
        aVar.f315239i = cursor.getLong(8);
        aVar.f315240j = cursor.getString(9);
        aVar.f315241k = cursor.getInt(10);
        aVar.f315242l = cursor.getInt(11);
        aVar.f315243m = cursor.getString(12);
        aVar.f315244n = cursor.getLong(13);
        aVar.f315245o = cursor.getLong(14);
        aVar.f315246p = cursor.getString(15);
        aVar.f315247q = cursor.getString(16);
        aVar.f315248r = cursor.getString(17);
        aVar.f315249s = cursor.getString(18);
        return aVar;
    }
}
