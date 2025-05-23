package com.tencent.mobileqq.weiyun.sdk.download.processor;

import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.utils.IOUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final a f315221d;

    /* renamed from: e, reason: collision with root package name */
    private final ReleaseLooperHandler f315222e;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void c(long j3, boolean z16, boolean z17, boolean z18, String str);
    }

    public b(a aVar, ReleaseLooperHandler releaseLooperHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) releaseLooperHandler);
            return;
        }
        this.f315221d = aVar;
        this.f315222e = releaseLooperHandler;
        releaseLooperHandler.addCallback(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str) {
        int i3;
        int i16;
        Cursor cursor;
        String str2;
        Cursor cursor2;
        String string;
        JobDbWrapper openJobDb = JobDbManager.getInstance().openJobDb(true);
        if (openJobDb == null) {
            return null;
        }
        try {
            i3 = 0;
            i16 = 2;
            try {
                cursor = openJobDb.query("download", new String[]{"local_path"}, JobDbManager.COL_DOWN_CLOUD_SHA + "=? AND state=? ", new String[]{str, Integer.toString(4)}, null, null, "insert_time DESC limit 1");
            } catch (Throwable unused) {
                cursor = null;
                IOUtils.closeSilently(cursor);
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                }
                String str3 = str2;
                JobDbManager.getInstance().closeJobDb(openJobDb);
                return str3;
            }
        } catch (Throwable unused2) {
            i3 = 0;
            i16 = 2;
        }
        if (cursor != null) {
            try {
            } catch (Throwable unused3) {
                IOUtils.closeSilently(cursor);
                str2 = null;
                if (TextUtils.isEmpty(str2)) {
                }
                String str32 = str2;
                JobDbManager.getInstance().closeJobDb(openJobDb);
                return str32;
            }
            if (cursor.moveToNext()) {
                string = cursor.getString(0);
                IOUtils.closeSilently(cursor);
                str2 = string;
                if (TextUtils.isEmpty(str2)) {
                    try {
                        String[] strArr = new String[i16];
                        strArr[i3] = str;
                        strArr[1] = Integer.toString(4);
                        Cursor query = openJobDb.query(JobDbManager.TBL_UPLOAD, new String[]{"local_path"}, JobDbManager.COL_UP_LOCAL_SHA + "=? AND state=? ", strArr, null, null, "insert_time DESC limit 1");
                        if (query != null) {
                            try {
                                if (query.moveToNext()) {
                                    str2 = query.getString(i3);
                                }
                            } catch (Throwable unused4) {
                                cursor2 = query;
                                IOUtils.closeSilently(cursor2);
                                String str322 = str2;
                                JobDbManager.getInstance().closeJobDb(openJobDb);
                                return str322;
                            }
                        }
                        IOUtils.closeSilently(query);
                    } catch (Throwable unused5) {
                        cursor2 = null;
                    }
                }
                String str3222 = str2;
                JobDbManager.getInstance().closeJobDb(openJobDb);
                return str3222;
            }
        }
        string = null;
        IOUtils.closeSilently(cursor);
        str2 = string;
        if (TextUtils.isEmpty(str2)) {
        }
        String str32222 = str2;
        JobDbManager.getInstance().closeJobDb(openJobDb);
        return str32222;
    }

    private void b(com.tencent.mobileqq.weiyun.model.b bVar) {
        boolean copyFileAndNotifyOS;
        String str;
        if (bVar == null) {
            return;
        }
        String f16 = bVar.f();
        String str2 = bVar.g().f315160h;
        String o16 = bVar.o();
        long j3 = bVar.g().f315161i - bVar.y().f315186i;
        if (bVar.k()) {
            return;
        }
        if (!TextUtils.isEmpty(f16) && TextUtils.equals(str2, IOUtils.getFileSha1(f16))) {
            this.f315221d.c(bVar.e(), true, false, false, f16);
            return;
        }
        if (bVar.k()) {
            return;
        }
        if (!IOUtils.ensureStorageSpace(o16, j3)) {
            this.f315221d.c(bVar.e(), false, false, true, "");
            return;
        }
        if (bVar.k()) {
            return;
        }
        if (!IOUtils.ensureWritable(o16)) {
            this.f315221d.c(bVar.e(), false, true, false, "");
            return;
        }
        if (bVar.k()) {
            return;
        }
        String ensureFilePath = IOUtils.ensureFilePath(o16, bVar.g().f315159f);
        if (bVar.k()) {
            return;
        }
        String a16 = a(str2);
        if (!TextUtils.isEmpty(a16) && !TextUtils.equals(f16, a16) && TextUtils.equals(str2, IOUtils.getFileSha1(a16))) {
            if (TextUtils.equals(o16, IOUtils.getParentDir(a16))) {
                copyFileAndNotifyOS = true;
                str = a16;
            } else {
                copyFileAndNotifyOS = IOUtils.copyFileAndNotifyOS(WeiyunTransmissionGlobal.getInstance().getContext(), a16, ensureFilePath);
                str = ensureFilePath;
            }
            this.f315221d.c(bVar.e(), copyFileAndNotifyOS, false, false, str);
            return;
        }
        if (bVar.k()) {
            return;
        }
        this.f315221d.c(bVar.e(), false, false, false, ensureFilePath);
    }

    public void c(com.tencent.mobileqq.weiyun.model.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            if (bVar == null) {
                return;
            }
            this.f315222e.sendMessage(Message.obtain(null, 11, bVar));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 11) {
            b((com.tencent.mobileqq.weiyun.model.b) message.obj);
            return true;
        }
        return false;
    }
}
