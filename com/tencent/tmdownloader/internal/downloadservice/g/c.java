package com.tencent.tmdownloader.internal.downloadservice.g;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadContentType;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.downloadservice.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected List<b> f380720a;

    /* renamed from: b, reason: collision with root package name */
    protected a f380721b;

    public c(ArrayList<b> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) arrayList);
            return;
        }
        this.f380720a = Collections.synchronizedList(new ArrayList());
        this.f380721b = null;
        if (arrayList != null && arrayList.size() > 0) {
            synchronized (this.f380720a) {
                this.f380720a.addAll(arrayList);
            }
        }
    }

    @Override // com.tencent.tmdownloader.internal.downloadservice.f
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
    }

    public void b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str == null || str2 == null) {
            return;
        }
        r.b("ServiceDownloadTaskManager", "deleteDownload clientKey:" + str);
        b c16 = c(str, str2);
        r.b("ServiceDownloadTaskManager", "deleteDownload taskItem:" + c16);
        if (c16 != null) {
            c16.f380717c = 6;
            synchronized (this.f380720a) {
                this.f380720a.remove(c16);
            }
            r.b("ServiceDownloadTaskManager", "clientKey:" + str + ",remove taskItem");
        } else {
            r.c("ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is null");
        }
        ArrayList<b> b16 = b(str2);
        if (b16 != null && b16.size() != 0) {
            r.c("ServiceDownloadTaskManager", "deleteDownload clientKey:" + str + ",taskItem is null");
            return;
        }
        r.b("ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is the only on deleteAll");
        ApkDownloadManager.getInstance().deleteDownload(str2);
        a aVar = this.f380721b;
        if (aVar != null) {
            aVar.OnDownloadStateChanged(str, str2, 6, 0, null);
        }
    }

    public List<TMAssistantDownloadTaskInfo> c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? a(ApkDownloadManager.getInstance().queryDownloadInfoByVia(str)) : (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
    }

    public TMAssistantDownloadTaskInfo d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TMAssistantDownloadTaskInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        com.tencent.tmdownloader.internal.downloadservice.c queryDownloadInfo = ApkDownloadManager.getInstance().queryDownloadInfo(str2);
        if (queryDownloadInfo != null) {
            return a(queryDownloadInfo);
        }
        if (com.tencent.tmdownloader.internal.downloadservice.b.b(str2, "application/vnd.android.package-archive")) {
            String d16 = com.tencent.tmdownloader.internal.downloadservice.b.d(str2);
            String b16 = com.tencent.tmdownloader.f.b.c.b(d16);
            com.tencent.tmdownloader.f.b.c cVar = new com.tencent.tmdownloader.f.b.c(d16, d16);
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(str2, b16, 4, cVar.c(), cVar.c(), "application/vnd.android.package-archive");
            r.b("ServiceDownloadTaskManager", "getDownloadTaskInfo downloadTaskInfo savePath | " + tMAssistantDownloadTaskInfo.mSavePath);
            return tMAssistantDownloadTaskInfo;
        }
        if (com.tencent.tmdownloader.internal.downloadservice.b.b(str2, TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF)) {
            String a16 = com.tencent.tmdownloader.internal.downloadservice.b.a(str2, TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF);
            String b17 = com.tencent.tmdownloader.f.b.c.b(a16);
            com.tencent.tmdownloader.f.b.c cVar2 = new com.tencent.tmdownloader.f.b.c(a16, a16);
            return new TMAssistantDownloadTaskInfo(str2, b17, 4, cVar2.c(), cVar2.c(), TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF);
        }
        d(str2);
        return null;
    }

    public void e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        r.b("ServiceDownloadTaskManager", BaseConstants.BROADCAST_USERSYNC_ENTER);
        if (str != null && str2 != null) {
            r.b("ServiceDownloadTaskManager", "pauseDownload clientKey:" + str + "; url: " + str2);
            b c16 = c(str, str2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("pauseDownload taskItem:");
            sb5.append(c16);
            r.b("ServiceDownloadTaskManager", sb5.toString());
            if (c16 != null) {
                c16.f380717c = 3;
                synchronized (this.f380720a) {
                    this.f380720a.remove(c16);
                }
                r.b("ServiceDownloadTaskManager", "clientKey:" + str + ",remove taskItem");
                ArrayList<b> b16 = b(str2);
                if (b16 == null || b16.size() == 0) {
                    r.b("ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is the only on pauseAll");
                    ApkDownloadManager.getInstance().pauseDownload(str2);
                }
                a aVar = this.f380721b;
                if (aVar != null) {
                    aVar.OnDownloadStateChanged(str, str2, c16.f380717c, 0, null);
                }
            } else {
                r.c("ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is null");
            }
            r.b("ServiceDownloadTaskManager", "exit");
        }
    }

    private List<TMAssistantDownloadTaskInfo> a(List<com.tencent.tmdownloader.internal.downloadservice.c> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<com.tencent.tmdownloader.internal.downloadservice.c> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    protected synchronized b c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
        }
        if (str == null || str2 == null) {
            return null;
        }
        synchronized (this.f380720a) {
            for (b bVar : this.f380720a) {
                String str3 = bVar.f380715a;
                if (str3 != null && str3.equals(str) && bVar.f380716b.equals(str2)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    private TMAssistantDownloadTaskInfo a(com.tencent.tmdownloader.internal.downloadservice.c cVar) {
        if (cVar == null) {
            return null;
        }
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = new TMAssistantDownloadTaskInfo(cVar.f380681b, com.tencent.tmdownloader.f.b.c.b(cVar.f380689j), cVar.f380686g, cVar.f380687h, cVar.f380688i, cVar.f380680a);
        tMAssistantDownloadTaskInfo.mAppId = cVar.f380696q;
        tMAssistantDownloadTaskInfo.mTaskPackageName = cVar.f380697r;
        tMAssistantDownloadTaskInfo.mTaskVersionCode = cVar.f380698s;
        tMAssistantDownloadTaskInfo.mIconUrl = cVar.C;
        tMAssistantDownloadTaskInfo.mAppName = cVar.D;
        tMAssistantDownloadTaskInfo.mVia = cVar.f380703x;
        tMAssistantDownloadTaskInfo.mChannelid = cVar.f380704y;
        tMAssistantDownloadTaskInfo.mStartTime = cVar.f380699t;
        tMAssistantDownloadTaskInfo.mEndTime = cVar.f380700u;
        tMAssistantDownloadTaskInfo.showNotification = cVar.J;
        tMAssistantDownloadTaskInfo.isAutoInstallBySDK = cVar.E;
        r.b("ServiceDownloadTaskManager", "TMAssistantDownloadTaskInfo pkg is: " + tMAssistantDownloadTaskInfo.mTaskPackageName + ", mAppName is: " + tMAssistantDownloadTaskInfo.mAppName + " dt mAppName is: " + cVar.D + ", isAutoInstallBySDK is: " + tMAssistantDownloadTaskInfo.isAutoInstallBySDK);
        return tMAssistantDownloadTaskInfo;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            ApkDownloadManager.getInstance().RemoveDownloadListener(this);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    protected synchronized ArrayList<b> b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        if (str == null) {
            return null;
        }
        ArrayList<b> arrayList = new ArrayList<>();
        synchronized (this.f380720a) {
            for (b bVar : this.f380720a) {
                if (bVar.f380716b.equals(str)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    protected synchronized void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.f380720a) {
            for (b bVar : this.f380720a) {
                if (bVar.f380716b.equals(str)) {
                    arrayList.add(bVar);
                }
            }
        }
        if (arrayList.size() > 0) {
            synchronized (this.f380720a) {
                this.f380720a.removeAll(arrayList);
            }
        }
    }

    public int a(String str, String str2, int i3, String str3, String str4, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3), str3, str4, map)).intValue();
        }
        if (str == null || str2 == null) {
            return 3;
        }
        r.b("ServiceDownloadTaskManager", "clientKey:" + str);
        if (c(str, str2) != null) {
            r.b("ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is not null");
            return ApkDownloadManager.getInstance().startDownload(str2, i3, str3, str4, map);
        }
        r.b("ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is null");
        ArrayList<b> b16 = b(str2);
        b bVar = new b(str, str2);
        bVar.f380717c = 1;
        synchronized (this.f380720a) {
            this.f380720a.add(bVar);
        }
        r.b("ServiceDownloadTaskManager", "clientKey:" + str + ",add newTask");
        Iterator<b> it = b16.iterator();
        boolean z16 = false;
        boolean z17 = false;
        while (it.hasNext()) {
            int i16 = it.next().f380717c;
            if (i16 == 2) {
                z16 = true;
            } else if (i16 == 1) {
                z17 = true;
            }
        }
        if (!z16 && !z17) {
            r.b("ServiceDownloadTaskManager", "clientKey:" + str + ",start newTask download");
            return ApkDownloadManager.getInstance().startDownload(str2, i3, str3, str4, map);
        }
        if (z16) {
            bVar.f380717c = 2;
        } else if (z17) {
            bVar.f380717c = 1;
        }
        a aVar = this.f380721b;
        if (aVar != null) {
            aVar.OnDownloadStateChanged(str, str2, bVar.f380717c, 0, null);
        }
        r.b("ServiceDownloadTaskManager", "clientKey:" + str + ",newTask is downloading");
        return 0;
    }

    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str == null || str2 == null) {
            return;
        }
        r.b("ServiceDownloadTaskManager", "cancelDownload clientKey:" + str);
        b c16 = c(str, str2);
        r.b("ServiceDownloadTaskManager", "cancelDownload taskItem:" + c16);
        if (c16 != null) {
            c16.f380717c = 6;
            synchronized (this.f380720a) {
                this.f380720a.remove(c16);
            }
            r.b("ServiceDownloadTaskManager", "clientKey:" + str + ",remove taskItem");
        } else {
            r.c("ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is null");
        }
        ArrayList<b> b16 = b(str2);
        if (b16 != null && b16.size() != 0) {
            r.c("ServiceDownloadTaskManager", "cancelDownload clientKey:" + str + ",taskItem is null");
            return;
        }
        r.b("ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is the only on cancelAll");
        ApkDownloadManager.getInstance().cancelDownload(str2);
        a aVar = this.f380721b;
        if (aVar != null) {
            aVar.OnDownloadStateChanged(str, str2, 6, 0, null);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            ApkDownloadManager.getInstance().AddDownloadListener(this);
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            this.f380721b = aVar;
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.tmdownloader.internal.downloadservice.f
    public void a(String str, int i3, int i16, String str2) {
        ArrayList<b> b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            return;
        }
        if (this.f380721b == null || (b16 = b(str)) == null || b16.size() <= 0) {
            return;
        }
        Iterator<b> it = b16.iterator();
        while (it.hasNext()) {
            b next = it.next();
            r.b("ServiceDownloadTaskManager", "clientKey:" + next.f380715a + ",state:" + i3 + ",errorcode:" + i16 + ",url:" + str.hashCode());
            next.f380717c = i3;
            this.f380721b.OnDownloadStateChanged(next.f380715a, str, i3, i16, str2);
        }
    }

    @Override // com.tencent.tmdownloader.internal.downloadservice.f
    public void a(String str, long j3, long j16) {
        ArrayList<b> b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (this.f380721b == null || (b16 = b(str)) == null || b16.size() <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<b> it = b16.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.a(j3, j16, currentTimeMillis)) {
                r.b("ServiceDownloadTaskManager", "clientKey:" + next.f380715a + ",receivedLen:" + j3 + ",url:" + str.hashCode());
                this.f380721b.OnDownloadProgressChanged(next.f380715a, str, j3, j16);
            }
        }
    }
}
