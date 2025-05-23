package com.tencent.tmdownloader.f.b;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected static a f380643a;

    /* compiled from: P */
    /* renamed from: com.tencent.tmdownloader.f.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class RunnableC10002a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f380644a;

        RunnableC10002a(a aVar, ArrayList arrayList) {
            this.f380644a = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) arrayList);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.tmdownloader.internal.storage.table.c.a((ArrayList<com.tencent.tmdownloader.internal.downloadservice.c>) this.f380644a);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19416);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f380643a == null) {
                f380643a = new a();
            }
            aVar = f380643a;
        }
        return aVar;
    }

    public ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? com.tencent.tmdownloader.internal.storage.table.c.a() : (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public ArrayList<com.tencent.tmdownloader.internal.downloadservice.g.b> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return com.tencent.tmdownloader.internal.storage.table.c.b();
    }

    public com.tencent.tmdownloader.internal.downloadservice.c b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? com.tencent.tmdownloader.internal.storage.table.c.b(str) : (com.tencent.tmdownloader.internal.downloadservice.c) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
    }

    public void a(ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            new BaseThread(new RunnableC10002a(this, arrayList)).start();
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        }
    }

    public void a(com.tencent.tmdownloader.internal.downloadservice.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
            return;
        }
        Log.i("DBManager", "addDownloadInfo di=" + cVar);
        Log.i("DBManager", "addDownloadInfo di.filename=" + cVar.f380689j + ",mURL=" + cVar.f380681b);
        com.tencent.tmdownloader.internal.storage.table.c.a(cVar);
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            com.tencent.tmdownloader.internal.storage.table.c.a(str);
            com.tencent.tmdownloader.internal.storage.table.b.a(str);
        }
    }

    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            com.tencent.tmdownloader.internal.storage.table.b.a(str, str2);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
        }
    }
}
