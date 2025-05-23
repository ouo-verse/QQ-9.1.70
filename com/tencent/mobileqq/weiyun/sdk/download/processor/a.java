package com.tencent.mobileqq.weiyun.sdk.download.processor;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.utils.IOUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f315217f;

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f315218h;

    /* renamed from: d, reason: collision with root package name */
    private final InterfaceC8982a f315219d;

    /* renamed from: e, reason: collision with root package name */
    private final ReleaseLooperHandler f315220e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.weiyun.sdk.download.processor.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC8982a {
        void a(int i3, com.tencent.mobileqq.weiyun.model.b bVar, String str);

        void b(long j3, boolean z16, com.tencent.mobileqq.weiyun.model.b bVar);

        void d(long j3, boolean z16, com.tencent.mobileqq.weiyun.model.c cVar, boolean z17);

        void onInfoRestored(String str, List<com.tencent.mobileqq.weiyun.model.b> list);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20979);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f315217f = new String[]{"_id", JobDbManager.COL_DOWN_CLOUD_SHA, "local_path"};
            f315218h = new String[]{"_id", "uid", "cmd_type", "file_name", "p_dir_uid", "p_dir_key", "file_id", JobDbManager.COL_DOWN_CLOUD_SHA, "file_size", "file_type", "file_version", "group_root_dir_key", "state", "error_code", "error_msg", "total_size", "cur_size", "local_path", JobDbManager.COL_DOWN_LOCAL_DIR};
        }
    }

    public a(InterfaceC8982a interfaceC8982a, ReleaseLooperHandler releaseLooperHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) interfaceC8982a, (Object) releaseLooperHandler);
            return;
        }
        this.f315219d = interfaceC8982a;
        this.f315220e = releaseLooperHandler;
        releaseLooperHandler.addCallback(this);
    }

    private com.tencent.mobileqq.weiyun.model.b b(Cursor cursor) {
        com.tencent.mobileqq.weiyun.model.a b16 = com.tencent.mobileqq.weiyun.model.a.b(cursor.getInt(2), cursor.getString(6), cursor.getString(3), cursor.getString(7), cursor.getLong(8), cursor.getInt(9), cursor.getString(4), cursor.getString(5), null);
        b16.E = cursor.getString(11);
        com.tencent.mobileqq.weiyun.model.c cVar = new com.tencent.mobileqq.weiyun.model.c();
        cVar.f315182d = cursor.getInt(12);
        cVar.f315183e = cursor.getInt(13);
        cVar.f315184f = cursor.getString(14);
        cVar.f315185h = cursor.getLong(15);
        cVar.f315186i = cursor.getLong(16);
        cVar.f315187m = cursor.getString(17);
        cVar.C = b16.f315158e;
        cVar.D = cursor.getString(10);
        com.tencent.mobileqq.weiyun.model.b b17 = com.tencent.mobileqq.weiyun.model.b.b(cursor.getString(1), b16, cursor.getString(18), cVar);
        b17.q(cursor.getLong(0));
        return b17;
    }

    private void c(long j3, boolean z16) {
        Cursor cursor;
        int delete;
        boolean z17 = true;
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
        com.tencent.mobileqq.weiyun.model.b bVar = null;
        if (openJobDb == null) {
            delete = 0;
        } else {
            if (j3 >= 0) {
                try {
                    cursor = openJobDb.query("download", f315218h, "_id=?", new String[]{Long.toString(j3)}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                bVar = b(cursor);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable unused2) {
                    cursor = null;
                }
                IOUtils.closeSilently(cursor);
                if (z16) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("valid_flag", (Integer) 0);
                    delete = openJobDb.update("download", contentValues, "_id=?", new String[]{Long.toString(j3)});
                } else {
                    delete = openJobDb.delete("download", "_id=?", new String[]{Long.toString(j3)});
                }
            } else {
                delete = 0;
            }
            JobDbManager.getInstance().closeJobDb(openJobDb);
        }
        InterfaceC8982a interfaceC8982a = this.f315219d;
        if (delete <= 0) {
            z17 = false;
        }
        interfaceC8982a.b(j3, z17, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(int i3, com.tencent.mobileqq.weiyun.model.b bVar) {
        String str;
        String str2;
        String str3;
        Cursor cursor;
        String str4;
        long j3;
        String[] strArr;
        String str5;
        String string;
        if (bVar == null) {
            return;
        }
        com.tencent.mobileqq.weiyun.model.a g16 = bVar.g();
        com.tencent.mobileqq.weiyun.model.c y16 = bVar.y();
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
        if (openJobDb == null) {
            return;
        }
        String[] strArr2 = {bVar.z(), g16.f315158e, bVar.o()};
        long j16 = -1;
        try {
            strArr = f315217f;
            str5 = "uid=? AND file_id=? AND " + JobDbManager.COL_DOWN_LOCAL_DIR + "=? ";
            str = JobDbManager.COL_DOWN_LOCAL_DIR;
            str2 = "file_id";
        } catch (Throwable unused) {
            str = JobDbManager.COL_DOWN_LOCAL_DIR;
            str2 = "file_id";
        }
        try {
            cursor = openJobDb.query("download", strArr, str5, strArr2, null, null, "insert_time DESC limit 1");
        } catch (Throwable unused2) {
            str3 = null;
            cursor = null;
            IOUtils.closeSilently(cursor);
            str4 = null;
            String str6 = g16.f315160h;
            ContentValues contentValues = new ContentValues();
            contentValues.put("uid", bVar.z());
            contentValues.put("cmd_type", Integer.valueOf(g16.f315157d));
            contentValues.put("file_name", g16.f315159f);
            contentValues.put("p_dir_uid", g16.C);
            contentValues.put("p_dir_key", g16.D);
            contentValues.put(str2, g16.f315158e);
            contentValues.put(JobDbManager.COL_DOWN_CLOUD_SHA, str6);
            contentValues.put("file_size", Long.valueOf(g16.f315161i));
            contentValues.put("file_type", Integer.valueOf(g16.f315162m));
            contentValues.put(str, bVar.o());
            contentValues.put("insert_time", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("thumb_uri", g16.F);
            contentValues.put("group_root_dir_key", g16.E);
            contentValues.put("valid_flag", (Integer) 1);
            if (!TextUtils.isEmpty(y16.f315187m)) {
            }
            if (j16 >= 0) {
            }
            j3 = j16;
            JobDbManager.getInstance().closeJobDb(openJobDb);
            if (j3 >= 0) {
            }
        }
        if (cursor != null) {
            if (cursor.moveToNext()) {
                long j17 = cursor.getInt(0);
                try {
                    str3 = cursor.getString(1);
                    try {
                        string = cursor.getString(2);
                        j16 = j17;
                        IOUtils.closeSilently(cursor);
                        str4 = string;
                    } catch (Throwable unused3) {
                        j16 = j17;
                        IOUtils.closeSilently(cursor);
                        str4 = null;
                        String str62 = g16.f315160h;
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("uid", bVar.z());
                        contentValues2.put("cmd_type", Integer.valueOf(g16.f315157d));
                        contentValues2.put("file_name", g16.f315159f);
                        contentValues2.put("p_dir_uid", g16.C);
                        contentValues2.put("p_dir_key", g16.D);
                        contentValues2.put(str2, g16.f315158e);
                        contentValues2.put(JobDbManager.COL_DOWN_CLOUD_SHA, str62);
                        contentValues2.put("file_size", Long.valueOf(g16.f315161i));
                        contentValues2.put("file_type", Integer.valueOf(g16.f315162m));
                        contentValues2.put(str, bVar.o());
                        contentValues2.put("insert_time", Long.valueOf(System.currentTimeMillis()));
                        contentValues2.put("thumb_uri", g16.F);
                        contentValues2.put("group_root_dir_key", g16.E);
                        contentValues2.put("valid_flag", (Integer) 1);
                        if (!TextUtils.isEmpty(y16.f315187m)) {
                        }
                        if (j16 >= 0) {
                        }
                        j3 = j16;
                        JobDbManager.getInstance().closeJobDb(openJobDb);
                        if (j3 >= 0) {
                        }
                    }
                } catch (Throwable unused4) {
                    j16 = j17;
                    str3 = null;
                    IOUtils.closeSilently(cursor);
                    str4 = null;
                    String str622 = g16.f315160h;
                    ContentValues contentValues22 = new ContentValues();
                    contentValues22.put("uid", bVar.z());
                    contentValues22.put("cmd_type", Integer.valueOf(g16.f315157d));
                    contentValues22.put("file_name", g16.f315159f);
                    contentValues22.put("p_dir_uid", g16.C);
                    contentValues22.put("p_dir_key", g16.D);
                    contentValues22.put(str2, g16.f315158e);
                    contentValues22.put(JobDbManager.COL_DOWN_CLOUD_SHA, str622);
                    contentValues22.put("file_size", Long.valueOf(g16.f315161i));
                    contentValues22.put("file_type", Integer.valueOf(g16.f315162m));
                    contentValues22.put(str, bVar.o());
                    contentValues22.put("insert_time", Long.valueOf(System.currentTimeMillis()));
                    contentValues22.put("thumb_uri", g16.F);
                    contentValues22.put("group_root_dir_key", g16.E);
                    contentValues22.put("valid_flag", (Integer) 1);
                    if (!TextUtils.isEmpty(y16.f315187m)) {
                    }
                    if (j16 >= 0) {
                    }
                    j3 = j16;
                    JobDbManager.getInstance().closeJobDb(openJobDb);
                    if (j3 >= 0) {
                    }
                }
                String str6222 = g16.f315160h;
                ContentValues contentValues222 = new ContentValues();
                contentValues222.put("uid", bVar.z());
                contentValues222.put("cmd_type", Integer.valueOf(g16.f315157d));
                contentValues222.put("file_name", g16.f315159f);
                contentValues222.put("p_dir_uid", g16.C);
                contentValues222.put("p_dir_key", g16.D);
                contentValues222.put(str2, g16.f315158e);
                contentValues222.put(JobDbManager.COL_DOWN_CLOUD_SHA, str6222);
                contentValues222.put("file_size", Long.valueOf(g16.f315161i));
                contentValues222.put("file_type", Integer.valueOf(g16.f315162m));
                contentValues222.put(str, bVar.o());
                contentValues222.put("insert_time", Long.valueOf(System.currentTimeMillis()));
                contentValues222.put("thumb_uri", g16.F);
                contentValues222.put("group_root_dir_key", g16.E);
                contentValues222.put("valid_flag", (Integer) 1);
                if (!TextUtils.isEmpty(y16.f315187m)) {
                    contentValues222.put("local_path", y16.f315187m);
                }
                if (j16 >= 0) {
                    openJobDb.update("download", contentValues222, "_id=?", new String[]{Long.toString(j16)});
                    if ("0".equals(str6222) || !TextUtils.equals(str3, str6222)) {
                        str4 = "";
                    }
                } else {
                    contentValues222.put("state", Integer.valueOf(y16.f315182d));
                    contentValues222.put("error_code", Integer.valueOf(y16.f315183e));
                    contentValues222.put("error_msg", y16.f315184f);
                    contentValues222.put("total_size", Long.valueOf(y16.f315185h));
                    contentValues222.put("cur_size", Long.valueOf(y16.f315186i));
                    j16 = openJobDb.insert("download", null, contentValues222);
                }
                j3 = j16;
                JobDbManager.getInstance().closeJobDb(openJobDb);
                if (j3 >= 0) {
                    bVar.q(j3);
                    this.f315219d.a(i3, bVar, str4);
                    return;
                }
                return;
            }
        }
        str3 = null;
        string = null;
        IOUtils.closeSilently(cursor);
        str4 = string;
        String str62222 = g16.f315160h;
        ContentValues contentValues2222 = new ContentValues();
        contentValues2222.put("uid", bVar.z());
        contentValues2222.put("cmd_type", Integer.valueOf(g16.f315157d));
        contentValues2222.put("file_name", g16.f315159f);
        contentValues2222.put("p_dir_uid", g16.C);
        contentValues2222.put("p_dir_key", g16.D);
        contentValues2222.put(str2, g16.f315158e);
        contentValues2222.put(JobDbManager.COL_DOWN_CLOUD_SHA, str62222);
        contentValues2222.put("file_size", Long.valueOf(g16.f315161i));
        contentValues2222.put("file_type", Integer.valueOf(g16.f315162m));
        contentValues2222.put(str, bVar.o());
        contentValues2222.put("insert_time", Long.valueOf(System.currentTimeMillis()));
        contentValues2222.put("thumb_uri", g16.F);
        contentValues2222.put("group_root_dir_key", g16.E);
        contentValues2222.put("valid_flag", (Integer) 1);
        if (!TextUtils.isEmpty(y16.f315187m)) {
        }
        if (j16 >= 0) {
        }
        j3 = j16;
        JobDbManager.getInstance().closeJobDb(openJobDb);
        if (j3 >= 0) {
        }
    }

    private void f(String str) {
        ArrayList arrayList;
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(false);
        ArrayList arrayList2 = null;
        arrayList2 = null;
        Cursor cursor = null;
        if (openJobDb != null) {
            try {
                Cursor query = openJobDb.query("download", f315218h, "uid=? AND valid_flag=1 AND state<>? ", new String[]{str, Integer.toString(4)}, null, null, "insert_time ASC");
                if (query != null) {
                    try {
                        arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            try {
                                arrayList.add(b(query));
                            } catch (Throwable unused) {
                                cursor = query;
                                IOUtils.closeSilently(cursor);
                                arrayList2 = arrayList;
                                JobDbManager.getInstance().closeJobDb(openJobDb);
                                this.f315219d.onInfoRestored(str, arrayList2);
                            }
                        }
                        arrayList2 = arrayList;
                    } catch (Throwable unused2) {
                        arrayList = null;
                    }
                }
                IOUtils.closeSilently(query);
            } catch (Throwable unused3) {
                arrayList = null;
            }
            JobDbManager.getInstance().closeJobDb(openJobDb);
        }
        this.f315219d.onInfoRestored(str, arrayList2);
    }

    private void h(ContentValues contentValues, com.tencent.mobileqq.weiyun.model.c cVar, boolean z16) {
        int i3;
        if (contentValues != null && contentValues.size() > 0) {
            long longValue = contentValues.getAsLong("_id").longValue();
            JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
            boolean z17 = false;
            if (openJobDb == null) {
                i3 = 0;
            } else {
                if (longValue >= 0) {
                    i3 = openJobDb.update("download", contentValues, "_id=?", new String[]{Long.toString(longValue)});
                } else {
                    i3 = 0;
                }
                JobDbManager.getInstance().closeJobDb(openJobDb);
            }
            InterfaceC8982a interfaceC8982a = this.f315219d;
            if (i3 > 0) {
                z17 = true;
            }
            interfaceC8982a.d(longValue, z17, cVar, z16);
        }
    }

    public void a(int i3, com.tencent.mobileqq.weiyun.model.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bVar);
        } else {
            if (bVar == null) {
                return;
            }
            this.f315220e.sendMessage(Message.obtain(null, 1, i3, 0, bVar));
        }
    }

    public void e(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Boolean.valueOf(z16));
        } else {
            if (j3 < 0) {
                return;
            }
            this.f315220e.sendMessage(Message.obtain(null, 3, z16 ? 1 : 0, 0, Long.valueOf(j3)));
        }
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f315220e.sendMessage(Message.obtain(null, 4, str));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            boolean z16 = false;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return false;
                    }
                    f((String) message.obj);
                    return true;
                }
                long longValue = ((Long) message.obj).longValue();
                if (message.arg1 == 1) {
                    z16 = true;
                }
                c(longValue, z16);
                return true;
            }
            Object obj = message.obj;
            ContentValues contentValues = (ContentValues) ((Object[]) obj)[0];
            com.tencent.mobileqq.weiyun.model.c cVar = (com.tencent.mobileqq.weiyun.model.c) ((Object[]) obj)[1];
            if (message.arg1 == 1) {
                z16 = true;
            }
            h(contentValues, cVar, z16);
            return true;
        }
        d(message.arg1, (com.tencent.mobileqq.weiyun.model.b) message.obj);
        return true;
    }

    public void i(com.tencent.mobileqq.weiyun.model.b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bVar, Boolean.valueOf(z16));
            return;
        }
        if (bVar == null) {
            return;
        }
        com.tencent.mobileqq.weiyun.model.c a16 = bVar.a();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(bVar.e()));
        contentValues.put("state", Integer.valueOf(a16.f315182d));
        contentValues.put("error_code", Integer.valueOf(a16.f315183e));
        contentValues.put("error_msg", a16.f315184f);
        contentValues.put("total_size", Long.valueOf(a16.f315185h));
        contentValues.put("cur_size", Long.valueOf(a16.f315186i));
        if (!TextUtils.isEmpty(a16.f315187m)) {
            contentValues.put("local_path", a16.f315187m);
        }
        if (!TextUtils.isEmpty(bVar.h())) {
            contentValues.put("file_version", bVar.h());
        }
        this.f315220e.sendMessage(Message.obtain(null, 2, z16 ? 1 : 0, 0, new Object[]{contentValues, a16}));
    }
}
