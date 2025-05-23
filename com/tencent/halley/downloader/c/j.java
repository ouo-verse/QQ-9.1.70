package com.tencent.halley.downloader.c;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.halley.common.HalleyException;
import com.tencent.halley.common.a.k;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.halley.downloader.DownloaderTaskListener;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class j implements com.tencent.halley.common.a.e, DownloaderTaskListener, com.tencent.halley.downloader.task.b.c {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static volatile j f113710g;

    /* renamed from: a, reason: collision with root package name */
    public Vector<com.tencent.halley.downloader.task.c> f113711a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.halley.downloader.task.a.b f113712b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f113713c;

    /* renamed from: d, reason: collision with root package name */
    public String f113714d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f113715e;

    /* renamed from: f, reason: collision with root package name */
    public int f113716f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.halley.downloader.task.b.b f113717h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9166);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            f113710g = null;
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113711a = new Vector<>();
        this.f113713c = false;
        this.f113714d = "";
        this.f113715e = false;
        this.f113716f = 0;
        this.f113717h = new com.tencent.halley.downloader.task.b.b(this);
        com.tencent.halley.common.a.c.a(QDLog.TAG_DOWNLOAD, this);
        this.f113712b = new com.tencent.halley.downloader.task.a.b(com.tencent.halley.common.a.a());
    }

    public static j a() {
        if (f113710g == null) {
            synchronized (j.class) {
                if (f113710g == null) {
                    f113710g = new j();
                }
            }
        }
        return f113710g;
    }

    private boolean g() {
        synchronized (this.f113711a) {
            Iterator<com.tencent.halley.downloader.task.c> it = this.f113711a.iterator();
            while (it.hasNext()) {
                com.tencent.halley.downloader.task.c next = it.next();
                if (next.isRunning() || next.isWaiting()) {
                    return true;
                }
            }
            return false;
        }
    }

    private void h() {
        if (g()) {
            this.f113717h.a();
        } else {
            this.f113717h.b();
        }
    }

    public final String b(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) downloaderTask);
        }
        if (downloaderTask == null || !(downloaderTask instanceof com.tencent.halley.downloader.task.c)) {
            return "param task not illegal.";
        }
        com.tencent.halley.downloader.task.c cVar = (com.tencent.halley.downloader.task.c) downloaderTask;
        synchronized (this) {
            if (com.tencent.halley.common.utils.j.a(cVar.f113841p)) {
                cVar.f113841p = "";
            }
            if (cVar.f113841p.contains("../")) {
                cVar.f113841p = cVar.f113841p.replace("../", "");
            }
            if (com.tencent.halley.downloader.a.a.g(cVar.f113841p)) {
                for (DownloaderTask downloaderTask2 : c()) {
                    if (cVar.f113840o.equalsIgnoreCase(downloaderTask2.getFileDir())) {
                        if (cVar.f113841p.equalsIgnoreCase(com.tencent.halley.downloader.a.a.g(((com.tencent.halley.downloader.task.c) downloaderTask2).f113841p) ? downloaderTask2.getFileName() : downloaderTask2.getRealSaveName())) {
                            com.tencent.halley.common.utils.d.e("halley-downloader-", "!!! another task exists with the same path:" + cVar.f113840o + "/" + cVar.f113841p);
                        }
                    }
                }
            }
            if (this.f113715e) {
                int size = this.f113716f / (d().size() + 1);
                downloaderTask.setTaskSpeedLimit(size);
                a(size);
            }
            synchronized (this.f113711a) {
                this.f113711a.add(cVar);
            }
            try {
                cVar.b();
            } catch (HalleyException e16) {
                String localizedMessage = e16.getLocalizedMessage();
                synchronized (this.f113711a) {
                    this.f113711a.remove(cVar);
                    return localizedMessage;
                }
            }
        }
        return "";
    }

    public final List<DownloaderTask> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        LinkedList linkedList = new LinkedList();
        synchronized (this.f113711a) {
            linkedList.addAll(this.f113711a);
        }
        return linkedList;
    }

    public final List<DownloaderTask> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        LinkedList linkedList = new LinkedList();
        synchronized (this.f113711a) {
            Iterator<com.tencent.halley.downloader.task.c> it = this.f113711a.iterator();
            while (it.hasNext()) {
                com.tencent.halley.downloader.task.c next = it.next();
                if (next.isRunning()) {
                    linkedList.add(next);
                }
            }
        }
        return linkedList;
    }

    @Override // com.tencent.halley.downloader.task.b.c
    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        List<DownloaderTask> d16 = d();
        int size = d16.size();
        Iterator<DownloaderTask> it = d16.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            com.tencent.halley.downloader.task.c cVar = (com.tencent.halley.downloader.task.c) it.next();
            if (cVar.f113810ai < size) {
                cVar.f113810ai = size;
            }
            if (cVar.e()) {
                z16 = true;
            }
        }
        return z16;
    }

    public final long f() {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        synchronized (this.f113711a) {
            Iterator<com.tencent.halley.downloader.task.c> it = this.f113711a.iterator();
            j3 = 0;
            while (it.hasNext()) {
                com.tencent.halley.downloader.task.c next = it.next();
                if (next.isRunning()) {
                    com.tencent.halley.downloader.task.b.a aVar = next.f113833h;
                    if (aVar != null) {
                        j16 = aVar.f113789a;
                    } else {
                        j16 = 0;
                    }
                    j3 += j16;
                }
            }
        }
        return j3;
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskCompletedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) downloaderTask);
        } else {
            h();
            com.tencent.halley.common.utils.d.b("halley-downloader-TaskManager".concat(String.valueOf(downloaderTask)), "onTaskCompletedMainloop task:".concat(String.valueOf(downloaderTask)));
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskCompletedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) downloaderTask);
        } else {
            a(downloaderTask);
            a((com.tencent.halley.downloader.task.c) downloaderTask, 0);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskDetectedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) downloaderTask);
            return;
        }
        com.tencent.halley.common.utils.d.b("halley-downloader-TaskManager".concat(String.valueOf(downloaderTask)), "onTaskDetectedMainloop task:" + downloaderTask + ",detectLen:" + downloaderTask.getTotalLen());
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskDetectedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) downloaderTask);
        } else {
            a(downloaderTask);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskFailedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) downloaderTask);
            return;
        }
        h();
        com.tencent.halley.common.utils.d.b("halley-downloader-TaskManager".concat(String.valueOf(downloaderTask)), "onTaskFailedMainloop task:" + downloaderTask + ",retCode:" + downloaderTask.getRet() + ",failInfo:" + downloaderTask.getFailInfoMsg());
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskFailedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) downloaderTask);
        } else {
            a(downloaderTask);
            a((com.tencent.halley.downloader.task.c) downloaderTask, 1);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskPausedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) downloaderTask);
            return;
        }
        h();
        com.tencent.halley.common.utils.d.b("halley-downloader-TaskManager".concat(String.valueOf(downloaderTask)), "onTaskPausedMainloop task:" + downloaderTask + ",isPausedOnMobile:" + downloaderTask.isPausedOnMobile());
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskPausedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) downloaderTask);
        } else {
            a(downloaderTask);
            a((com.tencent.halley.downloader.task.c) downloaderTask, 2);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskPendingMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) downloaderTask);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskReceivedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) downloaderTask);
            return;
        }
        com.tencent.halley.common.utils.d.b("halley-downloader-TaskManager".concat(String.valueOf(downloaderTask)), "onTaskReceivedMainloop task:" + downloaderTask + ",detectLen:" + downloaderTask.getTotalLen() + ",receivedLen:" + downloaderTask.getReceivedLen() + ",percentage:" + downloaderTask.getPercentage());
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskReceivedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) downloaderTask);
        } else {
            a(downloaderTask);
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskStartedMainloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) downloaderTask);
        } else {
            h();
        }
    }

    @Override // com.tencent.halley.downloader.DownloaderTaskListener
    public void onTaskStartedSubloop(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) downloaderTask);
        } else {
            a(downloaderTask);
        }
    }

    private static void c(HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(com.tencent.halley.downloader.a.a.f113580c)) {
            return;
        }
        hashMap.put("B10", com.tencent.halley.downloader.a.a.f113580c);
    }

    private static void d(HashMap<String, String> hashMap) {
        String str;
        if (b.a().f113681a) {
            hashMap.put("isdual", "1");
            str = "reportDualDownload, isdual==1";
        } else {
            hashMap.put("isdual", "0");
            str = "reportDualDownload, isdual==0";
        }
        com.tencent.halley.common.utils.d.c("halley-downloader-TaskManager", str);
    }

    public final void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        Iterator<DownloaderTask> it = d().iterator();
        while (it.hasNext()) {
            it.next().setTaskSpeedLimit(i3);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.halley.downloader.task.b.b bVar = this.f113717h;
        if (bVar != null) {
            try {
                if (bVar.f113797b) {
                    synchronized (bVar.f113796a) {
                        bVar.f113796a.notify();
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private static void b(HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(com.tencent.halley.downloader.a.a.f113579b)) {
            return;
        }
        hashMap.put("B9", com.tencent.halley.downloader.a.a.f113579b);
    }

    private void c(HashMap<String, String> hashMap, com.tencent.halley.downloader.task.c cVar) {
        if (!TextUtils.isEmpty(this.f113714d)) {
            hashMap.put("YYB1", this.f113714d);
        }
        if (TextUtils.isEmpty(cVar.f113809ah)) {
            return;
        }
        hashMap.put("YYB2", cVar.f113809ah);
    }

    private static void d(HashMap<String, String> hashMap, com.tencent.halley.downloader.task.c cVar) {
        long j3;
        long j16 = cVar.G;
        if (j16 > 0) {
            long j17 = cVar.H;
            if (j17 > j16) {
                j3 = j17 - j16;
                hashMap.put("B38", String.valueOf(j3));
            }
        }
        j3 = -1;
        hashMap.put("B38", String.valueOf(j3));
    }

    @Override // com.tencent.halley.common.a.e
    public final void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3, (Object) str);
            return;
        }
        List<DownloaderTask> d16 = d();
        if (d16.size() > 0) {
            Iterator<DownloaderTask> it = d16.iterator();
            while (it.hasNext()) {
                ((com.tencent.halley.downloader.task.c) it.next()).a(i3, str);
            }
        }
    }

    private static void b(HashMap<String, String> hashMap, com.tencent.halley.downloader.task.c cVar) {
        if (TextUtils.isEmpty(cVar.f113839n)) {
            return;
        }
        hashMap.put("B8", cVar.f113839n);
    }

    public final void a(DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) downloaderTask);
            return;
        }
        if (this.f113713c) {
            com.tencent.halley.downloader.task.a.b bVar = this.f113712b;
            if (downloaderTask.isDeleted()) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("taskid", downloaderTask.getId());
                contentValues.put("type", Integer.valueOf(downloaderTask.getType()));
                contentValues.put("knownsize", Long.valueOf(downloaderTask.getKnownSize()));
                contentValues.put("priority", Integer.valueOf(downloaderTask.getPriority().ordinal()));
                contentValues.put("category", Integer.valueOf(downloaderTask.getCategory().ordinal()));
                contentValues.put("url", downloaderTask.getFileUrl());
                contentValues.put("saveDir", downloaderTask.getFileDir());
                contentValues.put("saveName", downloaderTask.getFileName());
                contentValues.put("status", Integer.valueOf(com.tencent.halley.downloader.task.a.b.a(downloaderTask.getStatus())));
                contentValues.put("totalLen", Long.valueOf(downloaderTask.getTotalLen()));
                contentValues.put("rcvLen", Long.valueOf(downloaderTask.getReceivedLen()));
                contentValues.put("pencent", Integer.valueOf(downloaderTask.getPercentage()));
                int update = writableDatabase.update("history_task_table", contentValues, "saveDir=? and saveName=?", new String[]{downloaderTask.getFileDir(), downloaderTask.getFileName()});
                com.tencent.halley.common.utils.d.b("HistoryTaskDb", "updateRet:".concat(String.valueOf(update)));
                if (update <= 0) {
                    com.tencent.halley.common.utils.d.b("HistoryTaskDb", "insertRet:".concat(String.valueOf(writableDatabase.insert("history_task_table", null, contentValues))));
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public final void a(DownloaderTask downloaderTask, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, downloaderTask, Boolean.valueOf(z16));
            return;
        }
        if (downloaderTask == null) {
            return;
        }
        com.tencent.halley.common.utils.d.c("halley-downloader-TaskManager", "delete task:" + downloaderTask.getFileUrl());
        com.tencent.halley.downloader.task.c cVar = (com.tencent.halley.downloader.task.c) downloaderTask;
        cVar.a(z16);
        synchronized (this.f113711a) {
            this.f113711a.remove(downloaderTask);
        }
        if (downloaderTask.getStatus() != DownloaderTaskStatus.COMPLETE) {
            a(cVar, 3);
        }
        h();
        this.f113712b.a(downloaderTask);
    }

    private void a(com.tencent.halley.downloader.task.c cVar, int i3) {
        if (cVar == null) {
            return;
        }
        try {
            com.tencent.halley.common.utils.d.c("halley-downloader-TaskManager", "try reportResult task:" + cVar.getFileUrl() + ", result:" + i3 + ",costTime:" + cVar.C + ",receivedLen:" + cVar.getReceivedLen() + ",totalLen:" + cVar.getTotalLen() + ",flow:" + cVar.f113828c);
            HashMap<String, String> hashMap = new HashMap<>();
            int ret = cVar.getRet();
            if (i3 == 0) {
                ret = 0;
            }
            String str = cVar.isEaseTask() ? "HLDownTiny" : "B_DLSDK_Result";
            int a16 = com.tencent.halley.common.a.b.b.a(str, com.tencent.halley.common.a.c(), ret, (Map<String, String>) null);
            if (!com.tencent.halley.common.a.b.b.a(a16)) {
                com.tencent.halley.common.utils.d.d("halley-downloader-TaskManager", "Event:" + str + " did not report by rate:" + a16);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(com.tencent.halley.common.a.c());
            hashMap.put(Constants.BASE_IN_PLUGIN_ID, sb5.toString());
            hashMap.put("B1", cVar.f113850y);
            hashMap.put("B2", com.tencent.halley.common.utils.j.g());
            hashMap.put("B3", com.tencent.halley.common.a.f113172a);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(com.tencent.halley.common.a.f113174c);
            hashMap.put("B4", sb6.toString());
            hashMap.put("B6", com.tencent.halley.common.a.e());
            hashMap.put("C13", cVar.getFullSavePath());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(cVar.A);
            hashMap.put("B14", sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(cVar.C);
            hashMap.put("B15", sb8.toString());
            hashMap.put("B21", String.valueOf(ret));
            hashMap.put("B22", String.valueOf(i3));
            hashMap.put("B23", cVar.k());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(com.tencent.halley.common.a.c.h());
            hashMap.put("B25", sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            boolean z16 = true;
            sb10.append(cVar.isSupportRange() ? 1 : 0);
            hashMap.put("B28", sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            sb11.append(cVar.getCategory().ordinal());
            hashMap.put("B85", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(cVar.f());
            hashMap.put("B33", sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(cVar.getReceivedLen());
            hashMap.put("B41", sb13.toString());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(cVar.f113828c);
            hashMap.put("B44", sb14.toString());
            StringBuilder sb15 = new StringBuilder();
            sb15.append(cVar.f113829d.getAndSet(0L));
            hashMap.put("B45", sb15.toString());
            StringBuilder sb16 = new StringBuilder();
            sb16.append(cVar.f113810ai);
            hashMap.put("B66", sb16.toString());
            StringBuilder sb17 = new StringBuilder();
            sb17.append(cVar.getTaskSpeedLimit());
            hashMap.put("B96", sb17.toString());
            StringBuilder sb18 = new StringBuilder();
            sb18.append(cVar.f113802aa ? 1 : 0);
            hashMap.put("B97", sb18.toString());
            a(hashMap, cVar, i3);
            int a17 = com.tencent.halley.common.a.h.a("down_report_detail", 0, 1, 1);
            com.tencent.halley.common.utils.d.a("halley-downloader-TaskManager", "reportDetail:".concat(String.valueOf(a17)));
            if (a17 == 1) {
                a(hashMap, cVar, ret, i3);
            }
            if (ret != 0) {
                z16 = false;
            }
            com.tencent.halley.common.utils.d.d("halley-downloader-TaskManager", "Event:" + str + " report ret:" + k.a(str, z16, hashMap, false));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private static void a(HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(com.tencent.halley.downloader.a.a.f113578a)) {
            return;
        }
        hashMap.put("B5", com.tencent.halley.downloader.a.a.f113578a);
    }

    private static void a(HashMap<String, String> hashMap, com.tencent.halley.downloader.task.c cVar) {
        if (TextUtils.isEmpty(cVar.f113838m)) {
            return;
        }
        hashMap.put("B7", cVar.f113838m);
    }

    private void a(HashMap<String, String> hashMap, com.tencent.halley.downloader.task.c cVar, int i3) {
        a(hashMap);
        b(hashMap);
        c(hashMap);
        a(hashMap, cVar);
        b(hashMap, cVar);
        d(hashMap, cVar);
        c(hashMap, cVar);
        d(hashMap);
        if (cVar.N != -1) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(cVar.N);
            hashMap.put("B18", sb5.toString());
        }
        if (!TextUtils.isEmpty(cVar.f113837l)) {
            hashMap.put("B19", cVar.f113837l);
        }
        if (!TextUtils.isEmpty(cVar.f113849x)) {
            hashMap.put("B24", cVar.f113849x);
        }
        if (cVar.getKnownSize() > 0) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(cVar.getKnownSize());
            hashMap.put("B34", sb6.toString());
        }
        if (i3 != 0) {
            cVar.H = SystemClock.elapsedRealtime();
        }
        if (cVar.X) {
            hashMap.put("B46", "1");
        }
        if (i3 == 0 && cVar.I > 0) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(cVar.I);
            hashMap.put("B77", sb7.toString());
        }
        if (i3 == 2 && cVar.isPausedOnMobile()) {
            hashMap.put("B87", "1");
        }
        if (i3 == 1 && com.tencent.halley.common.a.h.a("down_report_exception", 0, 1, 0) == 1) {
            hashMap.put("C95", cVar.f113845t);
        }
    }

    private static void a(HashMap<String, String> hashMap, com.tencent.halley.downloader.task.c cVar, int i3, int i16) {
        if (i3 == -40 || i3 == -12 || i3 == -45) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(com.tencent.halley.downloader.a.b.b());
            hashMap.put("C11", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(com.tencent.halley.downloader.a.b.a());
            hashMap.put("C12", sb6.toString());
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(cVar.F);
        hashMap.put("C16", sb7.toString());
        hashMap.put("C17", String.valueOf(currentTimeMillis));
        hashMap.put("C20", com.tencent.halley.common.utils.j.b(cVar.getFailInfoMsg()));
        String h16 = cVar.h();
        if (h16.length() > 600) {
            h16 = h16.substring(0, 600);
        }
        hashMap.put("C26", String.valueOf(h16));
        StringBuilder sb8 = new StringBuilder();
        sb8.append(cVar.O);
        hashMap.put("C27", sb8.toString());
        String i17 = cVar.i();
        if (i17.length() > 4000) {
            i17 = i17.substring(0, 4000);
        }
        hashMap.put("C37", i17);
        if (i16 == 0 && cVar.f113834i.f113773e > 1000) {
            StringBuilder sb9 = new StringBuilder();
            sb9.append(cVar.f113834i.f113773e);
            hashMap.put("C48", sb9.toString());
        }
        if (cVar.p() > 1000) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append(cVar.p());
            hashMap.put("C72", sb10.toString());
        }
        if (cVar.S) {
            hashMap.put("C74", "1");
        }
        hashMap.put("C78", cVar.j());
        hashMap.put("C79", cVar.g());
        if (!TextUtils.isEmpty(cVar.f113846u)) {
            hashMap.put("C80", cVar.f113846u);
        }
        hashMap.put("B90", cVar.l());
        hashMap.put("B91", cVar.m());
        String n3 = cVar.n();
        if (!TextUtils.isEmpty(n3)) {
            hashMap.put("C92", n3);
        }
        String o16 = cVar.o();
        if (!TextUtils.isEmpty(o16)) {
            hashMap.put("C93", o16);
        }
        StringBuilder sb11 = new StringBuilder();
        sb11.append(cVar.f113831f.f113916g);
        hashMap.put("C94", sb11.toString());
    }
}
