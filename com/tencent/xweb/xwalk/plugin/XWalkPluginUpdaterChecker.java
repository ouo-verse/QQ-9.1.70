package com.tencent.xweb.xwalk.plugin;

import android.os.AsyncTask;
import com.tencent.luggage.wxa.ar.i0;
import com.tencent.luggage.wxa.ar.j0;
import com.tencent.luggage.wxa.ar.m;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.o;
import com.tencent.luggage.wxa.ar.r;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.x;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.z;
import com.tencent.luggage.wxa.ar.z0;
import com.tencent.luggage.wxa.wq.l;
import com.tencent.luggage.wxa.yq.b;
import com.tencent.luggage.wxa.yq.c;
import com.tencent.luggage.wxa.yq.n;
import com.tencent.luggage.wxa.yq.s;
import com.tencent.xweb.CommandCfgPlugin;
import com.tencent.xweb.XWebDownloader;
import com.tencent.xweb.XWebEmbedSetting;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import com.tencent.xweb.xwalk.plugin.XFileSchedulerFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes27.dex */
public class XWalkPluginUpdaterChecker extends AsyncTask<String, Integer, Integer> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f385158a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final StatusInfo f385159b = new StatusInfo();

    /* renamed from: c, reason: collision with root package name */
    public final Map f385160c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public int f385161d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f385162e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f385163f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f385164g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f385165h = 0;

    /* renamed from: i, reason: collision with root package name */
    public boolean f385166i = false;

    /* renamed from: j, reason: collision with root package name */
    public String f385167j = "";

    /* renamed from: k, reason: collision with root package name */
    public XWalkPluginUpdateListener f385168k = null;

    /* renamed from: l, reason: collision with root package name */
    public String f385169l = "0";

    /* renamed from: m, reason: collision with root package name */
    public final String f385170m = z0.d();

    /* renamed from: n, reason: collision with root package name */
    public final l.a f385171n = new l.a();

    /* loaded from: classes27.dex */
    public static class StatusInfo {
        public int curStatus = 0;
        public int errCode = 0;
    }

    /* loaded from: classes27.dex */
    public static class TaskInfo {
        public AsyncTask task = null;
        public int type = 1;
        public boolean taskFinished = false;
    }

    public boolean isBusy() {
        return !this.f385166i;
    }

    public void onNotifyProgress(String str, int i3) {
        if (this.f385159b.curStatus == 3 && b() && this.f385167j.equals(str)) {
            this.f385168k.onXWalkPluginUpdateProgress(i3);
        }
    }

    public void onNotifyResult(String str, int i3) {
        x0.a("XWalkPluginUpdaterChecker", "onNotifyResult: " + str + " install retCode: " + i3);
        synchronized (this.f385158a) {
            if (this.f385159b.curStatus == 5) {
                return;
            }
            boolean z16 = true;
            if (i3 == -3) {
                this.f385162e++;
            } else if (i3 == -1) {
                this.f385163f++;
            } else if (i3 == -2) {
                this.f385164g++;
            } else if (i3 == 0) {
                this.f385165h++;
            }
            ((TaskInfo) this.f385160c.get(str)).taskFinished = true;
            Iterator it = this.f385160c.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TaskInfo taskInfo = (TaskInfo) ((Map.Entry) it.next()).getValue();
                if (taskInfo != null && !taskInfo.taskFinished) {
                    z16 = false;
                    break;
                }
            }
            int i16 = this.f385159b.curStatus;
            if (z16) {
                this.f385160c.clear();
                StatusInfo statusInfo = this.f385159b;
                statusInfo.curStatus = 5;
                int i17 = this.f385163f;
                if (i17 > 0 && this.f385164g == 0) {
                    statusInfo.errCode = -10;
                } else if (i17 == 0 && this.f385164g > 0) {
                    statusInfo.errCode = -11;
                } else if (i17 > 0 || this.f385164g > 0) {
                    statusInfo.errCode = -9;
                }
            }
            StatusInfo statusInfo2 = this.f385159b;
            a(i16, statusInfo2.curStatus, statusInfo2.errCode);
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        a(1);
        super.onPreExecute();
    }

    public void setParams(HashMap<String, String> hashMap, String str, XWalkPluginUpdateListener xWalkPluginUpdateListener) {
        String str2;
        if (hashMap != null) {
            String str3 = hashMap.get(ConstValue.XWEB_UPDATER_START_CHECK_TYPE);
            this.f385169l = str3;
            if (str3 == null || str3.isEmpty()) {
                x0.d("XWalkPluginUpdaterChecker", "setParams, not set type, use default type: timer");
                this.f385169l = "0";
            }
        }
        this.f385167j = str;
        this.f385168k = xWalkPluginUpdateListener;
        l.a aVar = this.f385171n;
        aVar.f144363b = this.f385169l;
        if (b()) {
            str2 = this.f385167j;
        } else {
            str2 = "";
        }
        aVar.f144364c = str2;
        this.f385171n.f144366e = this.f385170m;
        x0.a("XWalkPluginUpdaterChecker", "create XWalkPluginUpdaterChecker, singlePlugin:" + this.f385167j + ", notifyType:" + this.f385169l + " [0:timer/1:notify/2:force/4:embed/5:config/6:embedPlugin/7:auto]");
    }

    public void tryCancelUpdate() {
        a(4, -1);
    }

    public final boolean b() {
        String str = this.f385167j;
        return (str == null || str.isEmpty() || this.f385168k == null) ? false : true;
    }

    public final void c() {
        for (XWalkPlugin xWalkPlugin : XWalkPluginManager.getAllPlugins()) {
            if (xWalkPlugin != null) {
                try {
                    if (xWalkPlugin.hasEmbed()) {
                        if (b() && !this.f385167j.equals(xWalkPlugin.getPluginName())) {
                            x0.a("XWalkPluginUpdaterChecker", "tryInstallEmbedPlugins set only " + this.f385167j + ", skip " + xWalkPlugin.getPluginName());
                        } else {
                            int embedVersion = xWalkPlugin.getEmbedVersion();
                            int availableVersion = xWalkPlugin.getAvailableVersion(true);
                            x0.a("XWalkPluginUpdaterChecker", "tryInstallEmbedPlugins process " + xWalkPlugin.getPluginName() + ", curVersion " + availableVersion + ", embedVersion " + embedVersion);
                            if (availableVersion >= embedVersion) {
                                x0.a("XWalkPluginUpdaterChecker", "tryInstallEmbedPlugins no need to install embed, skip");
                            } else {
                                l.b bVar = new l.b();
                                bVar.f144370b = xWalkPlugin.getPluginName();
                                bVar.f144371c = availableVersion;
                                bVar.f144372d = embedVersion;
                                bVar.f144373e = 1;
                                bVar.f144374f = "embed";
                                bVar.f144375g = this.f385171n;
                                bVar.f144379k = System.currentTimeMillis();
                                String embedFileMD5 = xWalkPlugin.getEmbedFileMD5();
                                String embedFileName = xWalkPlugin.getEmbedFileName();
                                if (embedFileMD5 != null && !embedFileMD5.isEmpty() && embedFileName != null && !embedFileName.isEmpty()) {
                                    c cVar = new c(xWalkPlugin.getPluginName(), embedVersion);
                                    if (!cVar.a(embedFileName, embedFileMD5)) {
                                        x0.a("XWalkPluginUpdaterChecker", "tryInstallEmbedPlugins copy failed, skip");
                                        bVar.f144380l = System.currentTimeMillis();
                                        bVar.f144378j = -6;
                                        bVar.f144369a = -4;
                                        l.a(bVar);
                                    } else {
                                        j0 j0Var = new j0();
                                        j0Var.f121684l = embedVersion;
                                        j0Var.f121697y = cVar.b();
                                        j0Var.f121676d = embedFileMD5;
                                        j0Var.f121678f = false;
                                        j0Var.f121696x = false;
                                        int performInstall = xWalkPlugin.performInstall(j0Var);
                                        x0.a("XWalkPluginUpdaterChecker", "tryInstallEmbedPlugins install ret = " + performInstall);
                                        bVar.f144380l = System.currentTimeMillis();
                                        bVar.f144378j = performInstall;
                                        if (performInstall == 0) {
                                            bVar.f144369a = 0;
                                        } else {
                                            bVar.f144369a = -3;
                                        }
                                        l.a(bVar);
                                    }
                                }
                                x0.a("XWalkPluginUpdaterChecker", "tryInstallEmbedPlugins embedFileName or embedFileMD5 is empty, skip");
                                bVar.f144380l = System.currentTimeMillis();
                                bVar.f144378j = -5;
                                bVar.f144369a = -4;
                                l.a(bVar);
                            }
                        }
                    }
                } catch (Throwable th5) {
                    x0.a("XWalkPluginUpdaterChecker", "tryInstallEmbedPlugins error: " + th5.getMessage());
                }
            }
        }
    }

    public final boolean a(int i3) {
        return a(i3, 1, (Map) null);
    }

    public final boolean a(int i3, int i16) {
        return a(i3, i16, (Map) null);
    }

    public final boolean a(int i3, Map map) {
        return a(i3, 1, map);
    }

    public final boolean a(int i3, int i16, Map map) {
        int i17;
        int i18;
        int i19;
        synchronized (this.f385158a) {
            StatusInfo statusInfo = this.f385159b;
            i17 = statusInfo.curStatus;
            if (i3 > i17) {
                statusInfo.curStatus = i3;
                if (i16 != 1) {
                    statusInfo.errCode = i16;
                }
                if (i3 == 4) {
                    if (this.f385160c.size() == 0) {
                        this.f385159b.curStatus = 5;
                    } else {
                        Iterator it = this.f385160c.entrySet().iterator();
                        while (it.hasNext()) {
                            TaskInfo taskInfo = (TaskInfo) ((Map.Entry) it.next()).getValue();
                            if (taskInfo != null && !taskInfo.taskFinished) {
                                taskInfo.task.cancel(true);
                            }
                        }
                    }
                } else if (i3 == 3 && map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        String str = (String) entry.getKey();
                        TaskInfo taskInfo2 = (TaskInfo) entry.getValue();
                        this.f385160c.put(str, taskInfo2);
                        int i26 = taskInfo2.type;
                        if (i26 == 1) {
                            ((XWebDownloader.HttpDownloadTask) taskInfo2.task).execute(new Void[0]);
                        } else if (i26 == 2) {
                            ((XWebDownloader.WXFileDownloaderTask) taskInfo2.task).execute(new Void[0]);
                        } else {
                            this.f385160c.remove(str);
                        }
                    }
                    this.f385161d = this.f385160c.size();
                }
            }
            StatusInfo statusInfo2 = this.f385159b;
            i18 = statusInfo2.curStatus;
            i19 = statusInfo2.errCode;
        }
        a(i17, i18, i19);
        return i18 > i17;
    }

    public final void a(int i3, int i16, int i17) {
        if (i16 <= i3) {
            x0.a("XWalkPluginUpdaterChecker", "status not changed, return");
            return;
        }
        x0.a("XWalkPluginUpdaterChecker", "change status from " + i3 + " to " + i16 + ", errcode:" + i17);
        if (b()) {
            if (i3 == 0 && i16 == 1) {
                this.f385168k.onXWalkPluginUpdateStarted();
            } else if (i3 != 0 && i16 == 5) {
                this.f385168k.onXWalkPluginUpdateCompleted(i17);
            }
        }
        if (i16 == 5) {
            n0.a(15718, this.f385159b.errCode + "," + this.f385161d + "," + this.f385162e + "," + this.f385163f + "," + this.f385164g + "," + this.f385165h);
            XWalkPluginUpdater.markPluginUpdateFinishedInProcess();
            this.f385166i = true;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(String... strArr) {
        if ("1".equals(this.f385169l)) {
            x0.a("XWalkPluginUpdaterChecker", "check type is notify, ignore time limit and update check time");
            XWalkPluginUpdater.setLastCheckPluginUpdateTime(System.currentTimeMillis());
        } else if ("6".equals(this.f385169l)) {
            x0.a("XWalkPluginUpdaterChecker", "check type is only install embed, ignore time limit");
        } else {
            if (!XWalkPluginUpdater.isNeedCheckPluginUpdate()) {
                x0.a("XWalkPluginUpdaterChecker", "too close, no need to check update");
                return -3;
            }
            XWalkPluginUpdater.setLastCheckPluginUpdateTime(System.currentTimeMillis());
        }
        if (XWalkPluginUpdater.isPluginUpdatingByOtherProcess()) {
            x0.a("XWalkPluginUpdaterChecker", "is updating by others, return");
            return -4;
        }
        XWalkPluginUpdater.markPluginUpdateStartedInProcess();
        if (x.a("plugin_clear_old_versions", 86400000L)) {
            x0.a("XWalkPluginUpdaterChecker", "try clear old plugin versions");
            XWalkPluginManager.clearOldVersions();
            XWalkPluginManager.clearTempDir();
        } else {
            x0.a("XWalkPluginUpdaterChecker", "no need to clear old plugin versions");
        }
        if (x.a("plugin_check_files", 43200000L)) {
            x0.a("XWalkPluginUpdaterChecker", "try check plugin files");
            XWalkPluginManager.checkFiles();
        } else {
            x0.a("XWalkPluginUpdaterChecker", "no need to check plugin files");
            XWalkPluginManager.checkKeyFiles(3);
        }
        c();
        return 0;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        if (num.intValue() == -3) {
            a(5, num.intValue());
        } else if (num.intValue() == -4) {
            this.f385171n.f144362a = num.intValue();
            l.a(this.f385171n);
            a(5, num.intValue());
        } else if ("6".equals(this.f385169l)) {
            x0.a("XWalkPluginUpdaterChecker", "check type is only install embed plugin, skip download");
            a(5, 0);
        } else {
            x0.a("XWalkPluginUpdaterChecker", "doFetchPluginUpdateConfig start");
            a();
        }
        super.onPostExecute(num);
    }

    public final void a() {
        if (!z.a()) {
            x0.a("XWalkPluginUpdaterChecker", "doFetchPluginUpdateConfig network not available");
            l.a aVar = this.f385171n;
            aVar.f144362a = -2;
            l.a(aVar);
            a(5, -2);
            return;
        }
        if (!a(2)) {
            x0.a("XWalkPluginUpdaterChecker", "status change to fetch config failed");
            l.a aVar2 = this.f385171n;
            aVar2.f144362a = -1;
            l.a(aVar2);
            a(5, -1);
            return;
        }
        n.b bVar = new n.b();
        bVar.f146095a = this.f385170m;
        bVar.f146096b = u0.d();
        bVar.f146097c = true;
        n.a(bVar, new b() { // from class: com.tencent.xweb.xwalk.plugin.XWalkPluginUpdaterChecker.1
            public final o a(com.tencent.luggage.wxa.ar.n nVar, String str, int i3, boolean z16) {
                o[] oVarArr;
                if (nVar != null && (oVarArr = nVar.f121746d) != null && oVarArr.length != 0 && str != null && !str.isEmpty()) {
                    for (o oVar : nVar.f121746d) {
                        if (str.equals(oVar.f121755s) && oVar.f121645a > i3 && oVar.f121647c.a(z16, true, "XWalkPluginUpdaterChecker")) {
                            return oVar;
                        }
                    }
                    return null;
                }
                x0.c("XWalkPluginUpdaterChecker", "findMatchedPluginInfo params error");
                return null;
            }

            @Override // com.tencent.luggage.wxa.yq.b
            public void onTaskFailed(n.d dVar) {
                x0.a("XWalkPluginUpdaterChecker", "plugin config download failed: " + dVar.f146103c);
                n0.F();
                XWalkPluginUpdaterChecker.this.f385171n.f144367f = dVar;
                XWalkPluginUpdaterChecker.this.f385171n.f144362a = -5;
                l.a(XWalkPluginUpdaterChecker.this.f385171n);
                XWalkPluginUpdaterChecker.this.a(5, -5);
            }

            @Override // com.tencent.luggage.wxa.yq.b
            public void onTaskStarted() {
                n0.E();
            }

            @Override // com.tencent.luggage.wxa.yq.b
            public void onTaskSucceed(n.d dVar) {
                int i3;
                XWalkPluginUpdaterChecker.this.f385171n.f144367f = dVar;
                n0.G();
                com.tencent.luggage.wxa.ar.n b16 = r.b(dVar.f146102b);
                if (b16 == null) {
                    x0.a("XWalkPluginUpdaterChecker", "parse plugin config failed");
                    n0.H();
                    XWalkPluginUpdaterChecker.this.f385171n.f144362a = -6;
                    l.a(XWalkPluginUpdaterChecker.this.f385171n);
                    XWalkPluginUpdaterChecker.this.a(5, -6);
                    return;
                }
                x0.d("XWalkPluginUpdaterChecker", "onTaskSucceed, costTime:" + dVar.f146107g + "ms, configVersion:" + b16.f121745c + ", commands:" + Arrays.toString(b16.f121747e));
                l.a aVar3 = XWalkPluginUpdaterChecker.this.f385171n;
                String str = b16.f121745c;
                aVar3.f144365d = str;
                n0.a(str, false);
                CommandCfgPlugin.getInstance().applyCommand(b16.f121747e, b16.f121745c);
                s.a(IXWebBroadcastListener.STAGE_PLUGINCFG_UPDATE, 0, 0);
                o[] oVarArr = b16.f121746d;
                if (oVarArr != null && oVarArr.length != 0) {
                    if ("5".equals(XWalkPluginUpdaterChecker.this.f385169l)) {
                        x0.a("XWalkPluginUpdaterChecker", "onTaskSucceed, check update plugin config only");
                        XWalkPluginUpdaterChecker.this.f385171n.f144362a = 0;
                        l.a(XWalkPluginUpdaterChecker.this.f385171n);
                        XWalkPluginUpdaterChecker.this.a(5, 0);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    for (XWalkPlugin xWalkPlugin : XWalkPluginManager.getAllPlugins()) {
                        if (xWalkPlugin == null) {
                            x0.a("XWalkPluginUpdaterChecker", "process plugin null");
                        } else {
                            XFileSchedulerFactory.XFileScheduler scheduler = XFileSchedulerFactory.getScheduler(xWalkPlugin.getPluginName());
                            if (XWalkPluginUpdaterChecker.this.b() && !XWalkPluginUpdaterChecker.this.f385167j.equals(xWalkPlugin.getPluginName())) {
                                x0.a("XWalkPluginUpdaterChecker", "set only update " + XWalkPluginUpdaterChecker.this.f385167j + ", skip " + xWalkPlugin.getPluginName());
                            } else if (XWebEmbedSetting.getForbidDownloadCode() && !xWalkPlugin.isIgnoreForbidDownloadCode()) {
                                x0.a("XWalkPluginUpdaterChecker", "forbid download code, skip " + xWalkPlugin.getPluginName());
                                scheduler.saveSchedulerConfig(null);
                            } else {
                                int availableVersion = xWalkPlugin.getAvailableVersion(true);
                                if (!XWalkPluginUpdaterChecker.this.b() && !xWalkPlugin.isDownloadImmediately() && availableVersion == -1) {
                                    x0.a("XWalkPluginUpdaterChecker", "not installed before, do not need download now, skip " + xWalkPlugin.getPluginName());
                                } else {
                                    o a16 = a(b16, xWalkPlugin.getPluginName(), availableVersion, XWalkPluginUpdaterChecker.this.b());
                                    if (a16 == null) {
                                        x0.a("XWalkPluginUpdaterChecker", "no matched plugin version, skip " + xWalkPlugin.getPluginName());
                                        scheduler.saveSchedulerConfig(null);
                                    } else {
                                        j0 j0Var = new j0();
                                        j0Var.f121684l = a16.f121645a;
                                        j0Var.f121694v = a16.f121649e;
                                        j0Var.f121695w = a16.f121650f;
                                        j0Var.f121696x = false;
                                        m a17 = a(a16, availableVersion);
                                        if (a17 != null && xWalkPlugin.canDownloadPatch(a16.f121646b)) {
                                            j0Var.f121680h = a17.f121737b;
                                            j0Var.f121676d = a17.f121738c;
                                            j0Var.f121697y = xWalkPlugin.getDownloadFullPath(j0Var.f121684l, true);
                                            j0Var.f121689q = a17.f121739d;
                                            j0Var.f121690r = a17.f121740e;
                                            j0Var.f121678f = true;
                                            j0Var.f121693u = a16.f121646b;
                                            j0Var.f121698z = a16.f121659o;
                                            j0Var.A = a16.f121660p;
                                            j0Var.B = a16.f121661q;
                                        } else {
                                            j0Var.f121680h = a16.f121648d;
                                            j0Var.f121676d = a16.f121655k;
                                            j0Var.f121697y = xWalkPlugin.getDownloadFullPath(j0Var.f121684l, false);
                                            j0Var.f121689q = a16.f121656l;
                                            j0Var.f121690r = a16.f121657m;
                                            j0Var.f121678f = false;
                                            j0Var.f121693u = a16.f121646b;
                                            j0Var.f121698z = a16.f121659o;
                                            j0Var.A = a16.f121660p;
                                            j0Var.B = a16.f121661q;
                                        }
                                        String str2 = j0Var.f121697y;
                                        if (str2 != null && !str2.isEmpty()) {
                                            j0Var.f121683k = i0.getUpdateTimeFromVersion(a16, xWalkPlugin.getPluginName());
                                            j0 onUpdateScheduleConfig = scheduler.onUpdateScheduleConfig(j0Var);
                                            if (XWalkPluginUpdaterChecker.this.b() || scheduler.isTimeToUpdate(true)) {
                                                n0.a(903L, scheduler.getIdkeyOffsetFromDefault() + 160, 1L);
                                                if (!XWalkPluginUpdaterChecker.this.b() && !z.a()) {
                                                    x0.a("XWalkPluginUpdaterChecker", "network is not available, skip " + xWalkPlugin.getPluginName());
                                                } else if (!XWalkPluginUpdaterChecker.this.b() && !onUpdateScheduleConfig.f121689q && !z.b()) {
                                                    x0.a("XWalkPluginUpdaterChecker", "can not use cellular, skip " + xWalkPlugin.getPluginName());
                                                } else {
                                                    TaskInfo taskInfo = new TaskInfo();
                                                    XWalkPluginUpdaterChecker xWalkPluginUpdaterChecker = XWalkPluginUpdaterChecker.this;
                                                    XWalkPluginDownloadListener xWalkPluginDownloadListener = new XWalkPluginDownloadListener(xWalkPluginUpdaterChecker, xWalkPlugin, onUpdateScheduleConfig, xWalkPluginUpdaterChecker.f385171n);
                                                    if (onUpdateScheduleConfig.f121678f) {
                                                        i3 = 2;
                                                    } else {
                                                        i3 = 1;
                                                    }
                                                    XWebDownloader.WXFileDownloaderTask wXFileDownloaderTask = new XWebDownloader.WXFileDownloaderTask(false, xWalkPluginDownloadListener, onUpdateScheduleConfig.f121680h, onUpdateScheduleConfig.f121697y, i3);
                                                    if (onUpdateScheduleConfig.f121690r && wXFileDownloaderTask.isValid()) {
                                                        x0.a("XWalkPluginUpdaterChecker", "use wx file downloader, plugin:" + xWalkPlugin.getPluginName() + ", isPatch:" + onUpdateScheduleConfig.f121678f + ", version:" + onUpdateScheduleConfig.f121684l);
                                                        taskInfo.task = wXFileDownloaderTask;
                                                        taskInfo.type = 2;
                                                    } else {
                                                        x0.a("XWalkPluginUpdaterChecker", "use default file downloader, plugin:" + xWalkPlugin.getPluginName() + ", isPatch:" + onUpdateScheduleConfig.f121678f + ", version:" + onUpdateScheduleConfig.f121684l);
                                                        taskInfo.task = new XWebDownloader.HttpDownloadTask(false, xWalkPluginDownloadListener, onUpdateScheduleConfig.f121680h, onUpdateScheduleConfig.f121697y);
                                                        taskInfo.type = 1;
                                                    }
                                                    hashMap.put(xWalkPlugin.getPluginName(), taskInfo);
                                                    StringBuilder sb5 = XWalkPluginUpdaterChecker.this.f385171n.f144368g;
                                                    sb5.append(xWalkPlugin.getPluginName());
                                                    sb5.append("_");
                                                    sb5.append(onUpdateScheduleConfig.f121684l);
                                                    sb5.append(" ");
                                                    if (onUpdateScheduleConfig.f121678f) {
                                                        xWalkPlugin.recordPatchDownloadInfo(a16.f121646b);
                                                    }
                                                }
                                            }
                                        } else {
                                            x0.a("XWalkPluginUpdaterChecker", "download path is empty, skip " + xWalkPlugin.getPluginName());
                                            scheduler.saveSchedulerConfig(null);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    XWalkPluginUpdaterChecker.this.f385171n.f144362a = 0;
                    l.a(XWalkPluginUpdaterChecker.this.f385171n);
                    if (hashMap.size() != 0) {
                        XWalkPluginUpdaterChecker.this.a(3, hashMap);
                        return;
                    } else {
                        x0.a("XWalkPluginUpdaterChecker", "no available update, no task");
                        XWalkPluginUpdaterChecker.this.a(5, -8);
                        return;
                    }
                }
                x0.a("XWalkPluginUpdaterChecker", "onTaskSucceed, plugin config contains no plugin");
                XWalkPluginUpdaterChecker.this.f385171n.f144362a = -7;
                l.a(XWalkPluginUpdaterChecker.this.f385171n);
                XWalkPluginUpdaterChecker.this.a(5, -7);
            }

            public final m a(o oVar, int i3) {
                m[] mVarArr;
                if (oVar != null && (mVarArr = oVar.f121653i) != null && mVarArr.length != 0) {
                    for (m mVar : mVarArr) {
                        if (mVar.f121736a == i3) {
                            return mVar;
                        }
                    }
                }
                return null;
            }

            @Override // com.tencent.luggage.wxa.yq.b
            public void onTaskProgressChanged(n.c cVar) {
            }
        });
    }
}
