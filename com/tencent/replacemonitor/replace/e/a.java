package com.tencent.replacemonitor.replace.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.replacemonitor.MonitorListener;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.replacemonitor.replace.a;
import com.tencent.replacemonitor.replace.st.ReplaceMonitorLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.j;
import com.tencent.tmassistantbase.util.r;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements MonitorListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<WeakReference<MonitorListener>> f364900a;

    /* renamed from: b, reason: collision with root package name */
    private ReferenceQueue<MonitorListener> f364901b;

    /* renamed from: c, reason: collision with root package name */
    private Map<Integer, Long> f364902c;

    /* renamed from: d, reason: collision with root package name */
    private a.InterfaceC9737a f364903d;

    /* compiled from: P */
    /* renamed from: com.tencent.replacemonitor.replace.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    class C9738a implements a.InterfaceC9737a {
        static IPatchRedirector $redirector_;

        C9738a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.replacemonitor.replace.a.InterfaceC9737a
        public void a(int i3, int i16, long j3, String str, long j16, String str2) {
            long j17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str, Long.valueOf(j16), str2);
                return;
            }
            r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onGetMonitorInfoSuccess reqId = " + i3 + " appType = " + i16 + " fileSize = " + j3 + " apkMd5 = " + str + " runMd5FileSize = " + j16 + " cpChannelId = " + str2);
            Long l3 = (Long) a.this.f364902c.get(Integer.valueOf(i3));
            if (l3 != null) {
                j17 = l3.longValue();
            } else {
                j17 = 0;
            }
            MonitorTask a16 = com.tencent.replacemonitor.replace.d.a.c().a(j17);
            r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onGetMonitorInfoSuccess task = " + a16);
            if (a16 != null) {
                if (a16.fileSize <= 0) {
                    a16.fileSize = j3;
                }
                if (TextUtils.isEmpty(a16.fileMd5)) {
                    a16.fileMd5 = str;
                }
                if (TextUtils.isEmpty(a16.cpChannelId)) {
                    a16.cpChannelId = str2;
                }
                a16.appType = i16;
                com.tencent.replacemonitor.replace.d.a.c().f(a16);
            }
            if (j16 > 0) {
                com.tencent.replacemonitor.a.f364886a = j16;
                Context context = GlobalUtil.getInstance().getContext();
                if (context != null) {
                    context.getSharedPreferences("replace_monitor_spf", 0).edit().putLong("md5_check_max_file_size", j16).apply();
                }
            }
        }

        @Override // com.tencent.replacemonitor.replace.a.InterfaceC9737a
        public void b(int i3, int i16, String str) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
                return;
            }
            r.c(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onGetMonitorInfoFailed reqId = " + i3 + " errorCode = " + i16 + " errorMsg = " + str);
            Long l3 = (Long) a.this.f364902c.get(Integer.valueOf(i3));
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            MonitorTask a16 = com.tencent.replacemonitor.replace.d.a.c().a(j3);
            if (a16 != null) {
                r.c(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onGetMonitorInfoFailed task.packageName = " + a16.packageName + " apkId = " + a16.yybApkId + " appId = " + a16.yybAppId);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MonitorTask f364905d;

        b(MonitorTask monitorTask) {
            this.f364905d = monitorTask;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) monitorTask);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MonitorTask a16 = com.tencent.replacemonitor.replace.d.a.c().a(this.f364905d.f364885id);
            r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl>>\u6267\u884c\u5b89\u88c5\u540e\u5b9a\u65f6\u68c0\u67e5 task1 = " + a16);
            if (a16 != null) {
                new com.tencent.replacemonitor.replace.b(a16, MonitorStep.AFTER_INSTALL, a.this).run();
            }
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f364900a = new CopyOnWriteArrayList();
        this.f364901b = new ReferenceQueue<>();
        this.f364902c = new ConcurrentHashMap();
        this.f364903d = new C9738a();
    }

    private void h(MonitorTask monitorTask, MonitorResult monitorResult) {
        List<WeakReference<MonitorListener>> list = this.f364900a;
        if (list != null && list.size() > 0) {
            Iterator<WeakReference<MonitorListener>> it = this.f364900a.iterator();
            while (it.hasNext()) {
                it.next().get().onMonitorFinish(monitorTask, monitorResult);
            }
        }
    }

    private void k(MonitorTask monitorTask, MonitorResult monitorResult) {
        ReplaceMonitorLog replaceMonitorLog = new ReplaceMonitorLog();
        replaceMonitorLog.packageName = monitorTask.packageName;
        replaceMonitorLog.yybAppId = monitorTask.yybAppId;
        replaceMonitorLog.yybApkId = monitorTask.yybApkId;
        replaceMonitorLog.additionalId = monitorTask.additionalId;
        replaceMonitorLog.channelId = monitorTask.cpChannelId;
        replaceMonitorLog.fileSize = monitorTask.fileSize;
        replaceMonitorLog.appType = monitorTask.appType;
        replaceMonitorLog.replaceInterval = monitorResult.replaceTime - monitorTask.lastModifedTime;
        replaceMonitorLog.traceId = monitorTask.traceId;
        replaceMonitorLog.versionCode = monitorTask.versionCode;
        replaceMonitorLog.replacePackageName = monitorResult.replacedPkgName;
        replaceMonitorLog.replaceVersionCode = monitorResult.replacedVersionCode;
        replaceMonitorLog.replaceChannelId = monitorResult.replaceChannelId;
        replaceMonitorLog.replaceFileMd5 = monitorResult.replaceFileMD5;
        replaceMonitorLog.replaceFileSize = monitorResult.replacedFileSize;
        replaceMonitorLog.step = monitorResult.step;
        replaceMonitorLog.monitorType = monitorResult.monitorType;
        replaceMonitorLog.isTDownloadApp = monitorTask.isTencentDownload;
        replaceMonitorLog.externalParams = monitorTask.externalParams;
        replaceMonitorLog.doReport();
        r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onMonitorFinish \u68c0\u6d4b\u5230\u6d17\u5305\uff0c\u5f00\u59cb\u4e0a\u62a5" + replaceMonitorLog.build());
    }

    public long a(MonitorTask monitorTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) monitorTask)).longValue();
        }
        return -1L;
    }

    public MonitorResult b(MonitorTask monitorTask, MonitorStep monitorStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MonitorResult) iPatchRedirector.redirect((short) 6, (Object) this, (Object) monitorTask, (Object) monitorStep);
        }
        return null;
    }

    public MonitorTask c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MonitorTask) iPatchRedirector.redirect((short) 8, (Object) this, j3);
        }
        return com.tencent.replacemonitor.replace.d.a.c().a(j3);
    }

    public MonitorTask d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MonitorTask) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        return com.tencent.replacemonitor.replace.d.a.c().b(str);
    }

    public void f(Context context, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) map);
            return;
        }
        GlobalUtil.getInstance().setContext(context);
        new com.tencent.replacemonitor.replace.a(this.f364903d);
        if (context != null) {
            com.tencent.replacemonitor.a.f364886a = context.getSharedPreferences("replace_monitor_spf", 0).getLong("md5_check_max_file_size", 209715200L);
            r.c(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl ReplaceMonitorImpl MD5_CHECK_MAX_FILE_SIZE = " + com.tencent.replacemonitor.a.f364886a);
        } else {
            r.c(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl ReplaceMonitorImpl context = null");
        }
        com.tencent.replacemonitor.replace.d.a.c();
    }

    public void g(MonitorListener monitorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) monitorListener);
            return;
        }
        r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>register listener = " + monitorListener);
        while (true) {
            Reference<? extends MonitorListener> poll = this.f364901b.poll();
            if (poll == null) {
                break;
            } else {
                this.f364900a.remove(poll);
            }
        }
        if (monitorListener != null) {
            for (WeakReference<MonitorListener> weakReference : this.f364900a) {
                if (weakReference != null && weakReference.get() == monitorListener) {
                    return;
                }
            }
            this.f364900a.add(new WeakReference<>(monitorListener, this.f364901b));
        }
    }

    public void i(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16));
            return;
        }
        PackageInfo b16 = j.b(str);
        r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onAppInstalled packageInfo = " + b16);
        if (b16 == null) {
            return;
        }
        List<MonitorTask> d16 = com.tencent.replacemonitor.replace.d.a.c().d(b16.packageName, b16.versionCode);
        List<MonitorTask> g16 = com.tencent.replacemonitor.replace.d.a.c().g(j.a(b16));
        r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onAppInstalled tasks = " + com.tencent.tmassistantbase.util.b.b(d16) + " tasksByName = " + com.tencent.tmassistantbase.util.b.b(g16));
        if (!com.tencent.tmassistantbase.util.b.a(d16)) {
            for (MonitorTask monitorTask : d16) {
                MonitorStep monitorStep = monitorTask.lastStep;
                if (monitorStep == MonitorStep.BEFORE_INSTALL) {
                    r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onAppInstalled \u6267\u884c\u5b89\u88c5\u4e2d\u68c0\u6d4b  " + monitorTask.appName);
                    l(monitorTask, MonitorStep.INSTALLING);
                } else if (monitorStep == MonitorStep.INSTALLING) {
                    r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onAppInstalled \u53d1\u73b0\u8986\u76d6\u5b89\u88c5\uff0c\u6267\u884c\u5b89\u88c5\u540e\u68c0\u6d4b  " + monitorTask.appName);
                    l(monitorTask, MonitorStep.AFTER_INSTALL);
                }
            }
            return;
        }
        if (!com.tencent.tmassistantbase.util.b.a(g16)) {
            for (MonitorTask monitorTask2 : g16) {
                if (monitorTask2.packageName.equals(b16.packageName) && monitorTask2.versionCode < b16.versionCode) {
                    r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onAppInstalled " + monitorTask2.appName + " \u53d1\u73b0\u5b89\u88c5\u4e86\u66f4\u9ad8\u7248\u672c\uff0c\u4e0d\u505a\u6d17\u5305\u5224\u5b9a\u5e76\u5220\u9664\u4efb\u52a1");
                    com.tencent.replacemonitor.replace.d.a.c().e(monitorTask2);
                } else {
                    MonitorStep monitorStep2 = monitorTask2.lastStep;
                    if (monitorStep2 == MonitorStep.BEFORE_INSTALL) {
                        r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onAppInstalled \u53d1\u73b0\u540c\u540d\u5e94\u7528\u5b89\u88c5\uff0c\u6267\u884c\u5b89\u88c5\u4e2d\u68c0\u6d4b  " + monitorTask2.appName);
                        l(monitorTask2, MonitorStep.INSTALLING);
                    } else if (monitorStep2 == MonitorStep.INSTALLING && !j.d(monitorTask2.packageName)) {
                        r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onAppInstalled,\u53d1\u73b0\u5df2\u5b89\u88c5\u5e94\u7528\u88ab\u5378\u8f7d\uff0c\u4f46\u662fappName\u76f8\u540c\u5305\u540d\u4e0d\u540c\u7684\u5e94\u7528\u88ab\u5b89\u88c5\uff0c\u6267\u884c\u5b89\u88c5\u540e\u68c0\u6d4b  " + monitorTask2.appName);
                        l(monitorTask2, MonitorStep.AFTER_INSTALL);
                    }
                }
            }
        }
    }

    public void j(MonitorTask monitorTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) monitorTask);
            return;
        }
        r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>deleteTask task = " + monitorTask);
        if (monitorTask != null) {
            com.tencent.replacemonitor.replace.d.a.c().e(monitorTask);
        }
    }

    public void l(MonitorTask monitorTask, MonitorStep monitorStep) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) monitorTask, (Object) monitorStep);
            return;
        }
        if (monitorTask != null) {
            r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>execSync task.packageName = " + monitorTask.packageName + " task.versionCode = " + monitorTask.versionCode + " task.appType = " + monitorTask.appType);
            e.a().post(new com.tencent.replacemonitor.replace.b(monitorTask, monitorStep, this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000d, B:13:0x0018, B:15:0x0047, B:16:0x004a, B:18:0x0051, B:21:0x0058, B:22:0x00a4, B:24:0x00aa, B:27:0x0094, B:28:0x00bb), top: B:2:0x0001 }] */
    @Override // com.tencent.replacemonitor.MonitorListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void onMonitorFinish(MonitorTask monitorTask, MonitorResult monitorResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) monitorTask, (Object) monitorResult);
            return;
        }
        if (monitorTask != null && monitorResult != null) {
            r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onMonitorFinish " + monitorTask.appName + monitorResult.step + " \u68c0\u6d4b\u7ed3\u679c\u4e3a" + monitorResult.resultCode);
            if (monitorResult.resultCode == 1) {
                k(monitorTask, monitorResult);
            }
            h(monitorTask, monitorResult);
            if (monitorResult.resultCode != 1 && monitorResult.step != MonitorStep.AFTER_INSTALL) {
                r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onMonitorFinish " + monitorTask.packageName + " " + monitorTask.appName + monitorResult.step + "\u68c0\u6d4b\u901a\u8fc7\uff0c\u66f4\u65b0MonitorTask.lastStep");
                monitorTask.lastStep = monitorResult.step;
                com.tencent.replacemonitor.replace.d.a.c().f(monitorTask);
                if (monitorResult.step == MonitorStep.INSTALLING) {
                    e.a().postDelayed(new b(monitorTask), 1800000L);
                }
                return;
            }
            r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onMonitorFinish \u5220\u9664\u5df2\u7ecf\u68c0\u6d4b\u5230\u6d17\u5305\u6216\u5b8c\u6574\u6267\u884c\u7684\u4efb\u52a1");
            com.tencent.replacemonitor.replace.d.a.c().e(monitorTask);
            if (monitorResult.step == MonitorStep.INSTALLING) {
            }
            return;
        }
        r.b(ReplaceMonitor.WASH_TAG, "ReplaceMonitorImpl >>onMonitorFinish task == null || result == null");
    }
}
