package com.tencent.tmdownloader.internal.downloadservice;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.common.HalleyException;
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.notify.DownloadTaskInfo;
import com.tencent.tmdownloader.notify.DownloadTaskNotifier;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    static IPatchRedirector $redirector_;
    public String A;
    public int B;
    public String C;
    public String D;
    public boolean E;
    public boolean F;
    public int G;
    public long H;
    public String I;
    public int J;
    public String K;
    public String L;
    final Object M;
    public DownloaderTaskListener N;

    /* renamed from: a, reason: collision with root package name */
    public String f380680a;

    /* renamed from: b, reason: collision with root package name */
    public String f380681b;

    /* renamed from: c, reason: collision with root package name */
    public String f380682c;

    /* renamed from: d, reason: collision with root package name */
    public String f380683d;

    /* renamed from: e, reason: collision with root package name */
    boolean f380684e;

    /* renamed from: f, reason: collision with root package name */
    public int f380685f;

    /* renamed from: g, reason: collision with root package name */
    public int f380686g;

    /* renamed from: h, reason: collision with root package name */
    public long f380687h;

    /* renamed from: i, reason: collision with root package name */
    public long f380688i;

    /* renamed from: j, reason: collision with root package name */
    public String f380689j;

    /* renamed from: k, reason: collision with root package name */
    public int f380690k;

    /* renamed from: l, reason: collision with root package name */
    public int f380691l;

    /* renamed from: m, reason: collision with root package name */
    public String f380692m;

    /* renamed from: n, reason: collision with root package name */
    public long f380693n;

    /* renamed from: o, reason: collision with root package name */
    protected HashMap<String, String> f380694o;

    /* renamed from: p, reason: collision with root package name */
    protected String f380695p;

    /* renamed from: q, reason: collision with root package name */
    public long f380696q;

    /* renamed from: r, reason: collision with root package name */
    public String f380697r;

    /* renamed from: s, reason: collision with root package name */
    public String f380698s;

    /* renamed from: t, reason: collision with root package name */
    public long f380699t;

    /* renamed from: u, reason: collision with root package name */
    public long f380700u;

    /* renamed from: v, reason: collision with root package name */
    public long f380701v;

    /* renamed from: w, reason: collision with root package name */
    public String f380702w;

    /* renamed from: x, reason: collision with root package name */
    public String f380703x;

    /* renamed from: y, reason: collision with root package name */
    public String f380704y;

    /* renamed from: z, reason: collision with root package name */
    public String f380705z;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements DownloaderTaskListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f380706a;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            } else {
                this.f380706a = 2;
            }
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskCompletedMainloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) downloaderTask);
            }
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskCompletedSubloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) downloaderTask);
                return;
            }
            c.this.f380689j = downloaderTask.getRealSaveName();
            downloaderTask.getRealSaveName();
            c.this.b(downloaderTask.getReceivedLength());
            c cVar = c.this;
            cVar.f380691l = 0;
            cVar.b(4);
            c cVar2 = c.this;
            long j3 = cVar2.f380687h;
            long j16 = cVar2.f380688i;
            cVar2.a(103, downloaderTask);
            com.tencent.tmassistant.st.b.a().a(c.this, downloaderTask);
            DownloadTaskNotifier.get().notify(c.this.a(downloaderTask), 4);
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskDetectedMainloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) downloaderTask);
            }
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskDetectedSubloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) downloaderTask);
                return;
            }
            c.this.f380689j = downloaderTask.getRealSaveName();
            downloaderTask.getRealSaveName();
            downloaderTask.getPercentage();
            downloaderTask.getReceivedLength();
            c.this.a(downloaderTask.getTotalLength());
            if (downloaderTask.getPercentage() == 0 && downloaderTask.getReceivedLength() == 0) {
                c.this.b(2);
            }
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskFailedMainloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) downloaderTask);
            }
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskFailedSubloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) downloaderTask);
                return;
            }
            downloaderTask.getFailCode();
            c.this.f380689j = downloaderTask.getRealSaveName();
            c.this.a(downloaderTask.getFailCode());
            c cVar = c.this;
            cVar.f380688i = 0L;
            cVar.f380687h = 0L;
            cVar.b(5);
            c.this.a(102, downloaderTask);
            if (downloaderTask.getFailCode() == -72 && this.f380706a > 0) {
                this.f380706a--;
                c.this.a();
                c.this.e();
            }
            DownloadTaskNotifier.get().notify(c.this.a(downloaderTask), 3);
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskPausedMainloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) downloaderTask);
            }
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskPausedSubloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) downloaderTask);
                return;
            }
            downloaderTask.isPausedOnMobile();
            c cVar = c.this;
            boolean z16 = cVar.F;
            cVar.b(3);
            if (c.this.F) {
                downloaderTask.setApkId("BY_MOBILE");
            } else {
                downloaderTask.setApkId("BY_MAUAL");
            }
            c.this.a(101, downloaderTask);
            DownloadTaskNotifier.get().notify(c.this.a(downloaderTask), 2);
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskPendingMainloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) downloaderTask);
            }
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskReceivedMainloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) downloaderTask);
                return;
            }
            if (downloaderTask != null) {
                long receivedLength = downloaderTask.getReceivedLength();
                c cVar = c.this;
                if (receivedLength != cVar.f380687h) {
                    cVar.b(receivedLength);
                }
            }
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskReceivedSubloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloaderTask);
                return;
            }
            downloaderTask.getFailCode();
            long j3 = c.this.f380687h;
            downloaderTask.getReceivedLength();
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskStartedMainloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloaderTask);
            }
        }

        @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
        public void onTaskStartedSubloop(DownloaderTask downloaderTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloaderTask);
                return;
            }
            downloaderTask.getRealSaveName();
            downloaderTask.getPercentage();
            downloaderTask.getReceivedLength();
            if (downloaderTask.getPercentage() == 0) {
                c.this.b(2);
            }
            DownloadTaskNotifier.get().notify(c.this.a(downloaderTask), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380708a;

        b(c cVar, String str) {
            this.f380708a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                SDKReportManager2.getInstance().postReport(8, this.f380708a);
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f380696q = 0L;
        this.f380697r = "";
        this.f380698s = "";
        this.f380699t = 0L;
        this.f380700u = 0L;
        this.f380701v = 0L;
        this.f380702w = "";
        this.f380703x = "";
        this.f380704y = "";
        this.f380705z = "";
        this.A = "";
        this.B = 0;
        this.C = "";
        this.D = "";
        this.E = false;
        this.F = false;
        this.G = 0;
        this.J = 0;
        this.M = new Object();
        this.N = new a();
        this.f380684e = false;
    }

    private boolean d(String str) {
        List<DownloaderTask> allTasks = HalleyAgent.getDownloader().getAllTasks();
        r.a("_DownloadInfo", "isSavePathExisted " + str + ",taskList=" + allTasks);
        for (DownloaderTask downloaderTask : allTasks) {
            if (TextUtils.equals(downloaderTask.getSavePath(), str) && !TextUtils.equals(downloaderTask.getUrl(), this.f380681b)) {
                r.a("_DownloadInfo", "Task " + downloaderTask.getUrl() + " has same path:" + str);
                return true;
            }
        }
        return false;
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        int i3 = this.f380686g;
        return (i3 <= 3 || i3 == 6 || i3 == 5) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        long j3 = this.f380688i;
        return j3 != 0 && this.f380687h == j3;
    }

    public int e() {
        DownloaderTask createNewTask;
        HashMap<String, String> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (!TextUtils.isEmpty(this.f380695p) && ((hashMap = this.f380694o) == null || hashMap.size() <= 0)) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            try {
                JSONObject jSONObject = new JSONObject(this.f380695p);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap2.put(str, jSONObject.getString(str));
                }
                if (hashMap2.size() > 0) {
                    this.f380694o = hashMap2;
                }
            } catch (JSONException e16) {
                r.c("_DownloadInfo", "exception: ", e16);
                e16.printStackTrace();
            }
        }
        if (this.f380684e) {
            return 5;
        }
        if (this.f380689j == null) {
            if ("application/vnd.android.package-archive".equals(this.f380680a)) {
                this.f380689j = com.tencent.tmdownloader.internal.downloadservice.b.d(this.f380681b);
            } else {
                this.f380689j = com.tencent.tmdownloader.internal.downloadservice.b.a(this.f380681b, this.f380680a);
            }
        }
        int i3 = this.f380686g;
        if (i3 == 5) {
            this.f380682c = this.f380681b;
        }
        if (i3 == 5) {
            this.f380686g = 0;
            this.f380691l = 0;
        }
        a("_DownloadInfo");
        DownloaderTask c16 = c(this.f380681b);
        if (c16 != null) {
            c16.toString();
            c16.getPercentage();
            c16.toString();
            c16.getReceivedLength();
        } else {
            DownloaderTask b16 = b(this.f380681b);
            if (b16 != null) {
                File file = new File(b16.getRealSaveName());
                if (!com.tencent.tmdownloader.internal.downloadservice.b.b(this.f380681b, this.f380680a) && !file.exists()) {
                    a();
                }
            }
        }
        if (c16 == null) {
            try {
                if (d(com.tencent.tmdownloader.f.b.c.a(this.f380689j) + File.separator + this.f380689j)) {
                    this.f380689j = com.tencent.tmdownloader.internal.downloadservice.b.a(this.f380681b, this.f380680a);
                }
                if (this.H > 0) {
                    Downloader downloader = HalleyAgent.getDownloader();
                    String str2 = this.f380681b;
                    createNewTask = downloader.createNewTask(0, str2, str2, com.tencent.tmdownloader.f.b.c.a(this.f380689j), this.f380689j, this.N, this.H);
                } else {
                    Downloader downloader2 = HalleyAgent.getDownloader();
                    int i16 = this.G;
                    String str3 = this.f380681b;
                    createNewTask = downloader2.createNewTask(i16, str3, str3, com.tencent.tmdownloader.f.b.c.a(this.f380689j), this.f380689j, this.N);
                }
                createNewTask.setAppId(this.f380696q + "");
                createNewTask.setPauseTaskOnMobile(false);
                String str4 = this.f380703x;
                if (str4 != null && !TextUtils.isEmpty(str4) && this.f380703x.contains("ANDROIDQQ.GAME.DETAIL")) {
                    String model = GlobalUtil.getInstance().getModel();
                    String str5 = "_" + GlobalUtil.getInstance().getBrand() + "_" + model;
                    HalleyAgent.getDownloader().setQua1(this.f380703x + str5);
                }
                String str6 = this.f380703x;
                if (str6 != null && !TextUtils.isEmpty(str6)) {
                    createNewTask.setAppScene(this.f380703x);
                    createNewTask.setCategory(DownloaderTaskCategory.Cate_DefaultMass);
                } else {
                    createNewTask.setCategory(DownloaderTaskCategory.Cate_DefaultEase);
                }
                b(1);
                HalleyAgent.getDownloader().addNewTask(createNewTask);
                a(100, createNewTask);
                com.tencent.tmdownloader.f.b.c.b(this.f380689j);
            } catch (Exception e17) {
                r.a("_DownloadInfo", "startDownloadIfReady HalleyAgent createNewTask Exception", e17);
            }
        } else {
            try {
                c16.setPauseTaskOnMobile(false);
                b(1);
                c16.resume();
            } catch (HalleyException e18) {
                e18.printStackTrace();
            }
        }
        return 0;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        DownloaderTask c16 = c(this.f380681b);
        if (c16 != null) {
            HalleyAgent.getDownloader().deleteTask(c16, false);
            b(6);
        } else {
            r.c("_DownloadInfo", "DownloadInfo::stopDownload task == null");
        }
    }

    public synchronized void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        if (b()) {
            return;
        }
        this.f380686g = i3;
        if (i3 != 6 && i3 != 6) {
            if (i3 == 5) {
                this.f380693n = System.currentTimeMillis();
            }
            com.tencent.tmdownloader.f.b.a.a().a(this);
            d.a().a(this.f380681b, this.f380686g, this.f380691l, "");
            if (this.f380686g == 4 && this.E) {
                com.tencent.tmdownloader.internal.downloadservice.a.b(com.tencent.tmdownloader.f.b.c.b(this.f380689j));
            }
        } else {
            com.tencent.tmdownloader.f.b.a.a().a(this.f380681b);
            d.a().a(String.valueOf(this.f380696q));
        }
    }

    public DownloaderTask c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (DownloaderTask) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        List<DownloaderTask> incompleteTasks = HalleyAgent.getDownloader().getIncompleteTasks();
        synchronized (this.M) {
            for (DownloaderTask downloaderTask : incompleteTasks) {
                if (downloaderTask.getId().equals(str)) {
                    return downloaderTask;
                }
            }
            return null;
        }
    }

    public void a(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hashMap);
        } else {
            if (hashMap == null || hashMap.size() <= 0) {
                return;
            }
            this.f380694o = hashMap;
            this.f380695p = new JSONObject(hashMap).toString();
        }
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
            return;
        }
        if (0 == j3) {
            this.f380687h = 0L;
        }
        this.f380688i = j3;
        com.tencent.tmdownloader.f.b.a.a().a(this);
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        DownloaderTask c16 = c(this.f380681b);
        if (c16 != null) {
            c16.pause();
            b(3);
        } else {
            r.c("_DownloadInfo", "DownloadInfo::pauseDownload task == null");
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        DownloaderTask b16 = b(this.f380681b);
        if (b16 == null) {
            return;
        }
        String b17 = com.tencent.tmdownloader.f.b.c.b(b16.getRealSaveName());
        if (b17 != null) {
            File file = new File(b17);
            if (file.exists()) {
                file.delete();
            }
        }
        HalleyAgent.getDownloader().deleteTask(b16, true);
        b(6);
    }

    public void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            this.f380687h = j3;
            d.a().a(this.f380681b, this.f380687h, this.f380688i);
        }
    }

    public static c b(Cursor cursor) {
        c cVar = new c();
        cVar.f380685f = cursor.getInt(cursor.getColumnIndex(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
        cVar.f380683d = cursor.getString(cursor.getColumnIndex("uId"));
        cVar.f380682c = cursor.getString(cursor.getColumnIndex("finalUrl"));
        cVar.f380681b = cursor.getString(cursor.getColumnIndex("taskUrl"));
        cVar.I = cursor.getString(cursor.getColumnIndex("bakUrl"));
        cVar.f380689j = cursor.getString(cursor.getColumnIndex(WadlProxyConsts.PARAM_FILENAME));
        cVar.f380680a = cursor.getString(cursor.getColumnIndex("contentType"));
        cVar.f380688i = cursor.getLong(cursor.getColumnIndex("totalBytes"));
        cVar.f380686g = cursor.getInt(cursor.getColumnIndex("status"));
        cVar.f380687h = cursor.getLong(cursor.getColumnIndex("receivedBytes"));
        cVar.f380690k = cursor.getInt(cursor.getColumnIndex("priority"));
        cVar.H = cursor.getLong(cursor.getColumnIndex("fileSize"));
        cVar.f380692m = null;
        cVar.f380691l = 0;
        cVar.f380693n = 0L;
        cVar.f380695p = null;
        return cVar;
    }

    public static c a(Cursor cursor) {
        c cVar = new c();
        cVar.f380685f = cursor.getInt(cursor.getColumnIndex(MiniAppGetGameTaskTicketServlet.KEY_TASKID));
        cVar.f380683d = cursor.getString(cursor.getColumnIndex("uId"));
        cVar.f380682c = cursor.getString(cursor.getColumnIndex("finalUrl"));
        cVar.f380681b = cursor.getString(cursor.getColumnIndex("taskUrl"));
        cVar.I = cursor.getString(cursor.getColumnIndex("bakUrl"));
        cVar.f380689j = cursor.getString(cursor.getColumnIndex(WadlProxyConsts.PARAM_FILENAME));
        cVar.f380680a = cursor.getString(cursor.getColumnIndex("contentType"));
        cVar.f380688i = cursor.getLong(cursor.getColumnIndex("totalBytes"));
        cVar.f380686g = cursor.getInt(cursor.getColumnIndex("status"));
        cVar.f380687h = cursor.getLong(cursor.getColumnIndex("receivedBytes"));
        cVar.f380690k = cursor.getInt(cursor.getColumnIndex("priority"));
        cVar.f380692m = cursor.getString(cursor.getColumnIndex("netType"));
        cVar.f380691l = cursor.getInt(cursor.getColumnIndex("downloadFailedErrCode"));
        cVar.f380693n = cursor.getLong(cursor.getColumnIndex("downloadFailedTime"));
        cVar.f380695p = cursor.getString(cursor.getColumnIndex("headerParams"));
        cVar.f380696q = cursor.getLong(cursor.getColumnIndex("appId"));
        cVar.f380697r = cursor.getString(cursor.getColumnIndex("taskPakcageName"));
        cVar.f380698s = cursor.getString(cursor.getColumnIndex("taskVersioncode"));
        cVar.f380699t = cursor.getLong(cursor.getColumnIndex("startTime"));
        cVar.f380700u = cursor.getLong(cursor.getColumnIndex("endTime"));
        cVar.B = cursor.getInt(cursor.getColumnIndex("downloadType"));
        cVar.f380701v = cursor.getLong(cursor.getColumnIndex("uin"));
        cVar.f380702w = cursor.getString(cursor.getColumnIndex("uintype"));
        cVar.f380703x = cursor.getString(cursor.getColumnIndex("via"));
        cVar.f380704y = cursor.getString(cursor.getColumnIndex("channelId"));
        cVar.f380705z = cursor.getString(cursor.getColumnIndex("traceId"));
        cVar.A = cursor.getString(cursor.getColumnIndex(WadlProxyConsts.EXTRA_DATA));
        cVar.C = cursor.getString(cursor.getColumnIndex("iconUrl"));
        cVar.D = cursor.getString(cursor.getColumnIndex("appName"));
        cVar.E = cursor.getInt(cursor.getColumnIndex(WadlResult.WEB_KEY_IS_AUTO_INSTALL_BY_SDK)) != 0;
        cVar.H = cursor.getLong(cursor.getColumnIndex("fileSize"));
        return cVar;
    }

    public c(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
            return;
        }
        this.f380696q = 0L;
        this.f380697r = "";
        this.f380698s = "";
        this.f380699t = 0L;
        this.f380700u = 0L;
        this.f380701v = 0L;
        this.f380702w = "";
        this.f380703x = "";
        this.f380704y = "";
        this.f380705z = "";
        this.A = "";
        this.B = 0;
        this.C = "";
        this.D = "";
        this.E = false;
        this.F = false;
        this.G = 0;
        this.J = 0;
        this.M = new Object();
        this.N = new a();
        this.f380681b = str;
        this.f380682c = com.tencent.tmdownloader.internal.downloadservice.b.b(str);
        this.f380683d = UUID.randomUUID().toString();
        this.f380690k = i3;
        this.f380686g = 0;
        this.f380691l = 0;
        this.f380684e = false;
        this.f380680a = str2;
        this.f380692m = com.tencent.tmdownloader.internal.downloadservice.b.a();
        this.f380693n = 0L;
    }

    public DownloaderTask b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (DownloaderTask) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        List<DownloaderTask> allTasks = HalleyAgent.getDownloader().getAllTasks();
        synchronized (this.M) {
            for (DownloaderTask downloaderTask : allTasks) {
                if (downloaderTask.getId().equals(str)) {
                    return downloaderTask;
                }
            }
            return null;
        }
    }

    public static void a(ContentValues contentValues, c cVar) {
        if (cVar == null || contentValues == null) {
            return;
        }
        contentValues.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, Integer.valueOf(cVar.f380685f));
        contentValues.put("uId", cVar.f380683d);
        contentValues.put("finalUrl", cVar.f380682c);
        contentValues.put("taskUrl", cVar.f380681b);
        contentValues.put("bakUrl", cVar.I);
        contentValues.put(WadlProxyConsts.PARAM_FILENAME, cVar.f380689j);
        contentValues.put("contentType", cVar.f380680a);
        contentValues.put("totalBytes", Long.valueOf(cVar.f380688i));
        contentValues.put("status", Integer.valueOf(cVar.f380686g));
        contentValues.put("receivedBytes", Long.valueOf(cVar.f380687h));
        contentValues.put("priority", Integer.valueOf(cVar.f380690k));
        contentValues.put("netType", cVar.f380692m);
        contentValues.put("downloadFailedErrCode", Integer.valueOf(cVar.f380691l));
        contentValues.put("downloadFailedTime", Long.valueOf(cVar.f380693n));
        contentValues.put("headerParams", cVar.f380695p);
        contentValues.put("appId", Long.valueOf(cVar.f380696q));
        contentValues.put("taskPakcageName", cVar.f380697r);
        contentValues.put("taskVersioncode", cVar.f380698s);
        contentValues.put("startTime", Long.valueOf(cVar.f380699t));
        contentValues.put("endTime", Long.valueOf(cVar.f380700u));
        contentValues.put("downloadType", Integer.valueOf(cVar.B));
        contentValues.put("uin", Long.valueOf(cVar.f380701v));
        contentValues.put("uintype", cVar.f380702w);
        contentValues.put("via", cVar.f380703x);
        contentValues.put("channelId", cVar.f380704y);
        contentValues.put("traceId", cVar.f380705z);
        contentValues.put(WadlProxyConsts.EXTRA_DATA, cVar.A);
        contentValues.put("iconUrl", cVar.C);
        contentValues.put("appName", cVar.D);
        contentValues.put(WadlResult.WEB_KEY_IS_AUTO_INSTALL_BY_SDK, Integer.valueOf(cVar.E ? 1 : 0));
        contentValues.put("fileSize", Long.valueOf(cVar.H));
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        if (i3 >= 0) {
            this.f380691l = i3;
        } else if (i3 == -23) {
            this.f380691l = 601;
        } else if (i3 == -25) {
            this.f380691l = 602;
        } else if (i3 == -29) {
            this.f380691l = 603;
        } else if (i3 == -26) {
            this.f380691l = 605;
        } else if (i3 == -27) {
            this.f380691l = 606;
        } else if (i3 == -51) {
            this.f380691l = 700;
        } else if (i3 == -41) {
            this.f380691l = 701;
        } else if (i3 == -58) {
            this.f380691l = 702;
        } else if (i3 == -14 || i3 == -47 || i3 == -49 || i3 == -50 || i3 == -72) {
            this.f380691l = 703;
        } else if (i3 == -11) {
            this.f380691l = 704;
        } else if (i3 == -43) {
            this.f380691l = 705;
        } else if (i3 == -42) {
            this.f380691l = 706;
        } else if (i3 == -53 || i3 == -65 || i3 == -59) {
            this.f380691l = 707;
        } else if (i3 == -57) {
            this.f380691l = TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES;
        } else if (i3 == -12 || i3 == -40) {
            this.f380691l = 710;
        } else if (i3 == -13 || i3 == -46) {
            this.f380691l = 711;
        } else if (i3 == -15) {
            this.f380691l = 605;
        } else if (i3 == -10) {
            this.f380691l = TMAssistantDownloadErrorCode.DOWNLOAD_ERR_KNOWN_LENGTH_CHECK_ERROR;
        } else {
            this.f380691l = 604;
        }
        r.a("_DownloadInfo", "halleytest convertHalleyFailCodeToDownloadFailedErrCode halley failCode = " + i3 + ",mDownloadFailedErrCode = " + this.f380691l);
    }

    public void a(int i3, DownloaderTask downloaderTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) downloaderTask);
            return;
        }
        if (downloaderTask == null) {
            r.a("_DownloadInfo", "<downloadReport> task is null ,return");
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String uniqueKey = downloaderTask.getUniqueKey();
        String url = downloaderTask.getUrl();
        int i16 = !downloaderTask.isPausedOnMobile() ? 1 : 0;
        int failCode = downloaderTask.getFailCode();
        if (i3 != 101) {
            i16 = -1;
        }
        com.tencent.tmassistantbase.util.e.a().post(new b(this, currentTimeMillis + "|" + this.f380696q + "|" + this.f380698s + "|" + this.f380697r + "|" + this.B + "|" + i3 + "|" + uniqueKey + "|" + url + "|" + i16 + "|" + failCode + "|" + downloaderTask.getStartTime() + "|" + downloaderTask.getCostTime() + "|" + downloaderTask.getTotalLength() + "|" + this.f380703x));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTaskInfo a(DownloaderTask downloaderTask) {
        DownloadTaskInfo downloadTaskInfo = new DownloadTaskInfo();
        downloadTaskInfo.url = downloaderTask.getUrl();
        downloadTaskInfo.pkgName = this.f380697r;
        downloadTaskInfo.source = this.K;
        try {
            downloadTaskInfo.versionCode = Integer.parseInt(this.f380698s);
        } catch (Throwable unused) {
        }
        downloadTaskInfo.stackInfo = this.L;
        return downloadTaskInfo;
    }
}
