package com.tencent.halley.downloader.task.a;

import android.content.Context;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b extends a {
    static IPatchRedirector $redirector_;

    public b(Context context) {
        super(context, "history_task_table");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    public static int a(DownloaderTaskStatus downloaderTaskStatus) {
        return downloaderTaskStatus.ordinal() <= DownloaderTaskStatus.DOWNLOADING.ordinal() ? DownloaderTaskStatus.PAUSED.ordinal() : downloaderTaskStatus.ordinal();
    }

    @Override // com.tencent.halley.downloader.task.a.a
    protected final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "history_task_table";
    }

    @Override // com.tencent.halley.downloader.task.a.a
    protected final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? "CREATE TABLE IF NOT EXISTS history_task_table (id INTEGER PRIMARY KEY AUTOINCREMENT,taskid TEXT,type INTEGER,knownsize TEXT,category TEXT,priority TEXT,url TEXT,saveDir TEXT,saveName TEXT,status INTEGER,totalLen INTEGER,rcvLen INTEGER,pencent INTEGER);" : (String) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    public final void a(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloaderTask);
            return;
        }
        try {
            getWritableDatabase().delete("history_task_table", "saveDir=? and saveName=?", new String[]{downloaderTask.getSaveDir(), downloaderTask.getInitSaveName()});
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
