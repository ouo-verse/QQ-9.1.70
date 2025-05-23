package com.tencent.tmdownloader;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.aidl.b;
import com.tencent.tmassistant.common.PackageInstallReceiver;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.q;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.notification.NotifyParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TMAssistantDownloadService extends Service implements com.tencent.tmdownloader.internal.downloadservice.g.a {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_HANDSHAKE_YYB = 1;
    private static final int MSG_INIT_YYBMG = 0;
    protected static final String TAG = "TMADownloadSDKService";
    protected final d downloadSDKServiceImpl;
    protected final HashMap<com.tencent.tmassistant.aidl.a, String> mCallbackHashMap;
    protected final RemoteCallbackList<com.tencent.tmassistant.aidl.a> mCallbacks;
    private Handler mHandler;
    private com.tencent.tmassistantbase.util.f mLogListener;
    com.tencent.tmdownloader.internal.notification.a mNotificationManager;
    com.tencent.tmdownloader.internal.downloadservice.g.c mServiceDownloadTaskManager;
    private com.tencent.tmdownloader.internal.downloadclient.a yybManager;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TMAssistantDownloadService.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            TMAssistantDownloadService.this.mServiceDownloadTaskManager = new com.tencent.tmdownloader.internal.downloadservice.g.c(com.tencent.tmdownloader.f.b.a.a().c());
            try {
                TMAssistantDownloadService tMAssistantDownloadService = TMAssistantDownloadService.this;
                tMAssistantDownloadService.mServiceDownloadTaskManager.a(tMAssistantDownloadService);
                TMAssistantDownloadService.this.mServiceDownloadTaskManager.a();
            } catch (Throwable unused) {
            }
            if (GlobalUtil.getInstance().getContext() == null) {
                GlobalUtil.getInstance().setContext(TMAssistantDownloadService.this);
            }
            try {
                ApkDownloadManager.getInstance().init();
                PackageInstallReceiver.a().a(TMAssistantDownloadService.this);
                com.tencent.tmassistant.st.b.a();
            } catch (Throwable unused2) {
            }
            q.a("Load downloadInfo end, timeCost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TMAssistantDownloadService.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                LockMethodProxy.sleep(10000L);
                TMAssistantDownloadService.this.mHandler.sendEmptyMessage(0);
            } catch (InterruptedException e16) {
                r.c(TMAssistantDownloadService.TAG, "exception:", e16);
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c extends Handler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TMAssistantDownloadService.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 == 1) {
                    TMAssistantDownloadService.this.yybManager.b();
                }
            } else {
                if (GlobalUtil.getInstance().getQQDownloaderAPILevel() < 5 && GlobalUtil.getInstance().getQQDownloaderConnectLevel() < 1) {
                    return;
                }
                if (TMAssistantDownloadService.this.yybManager == null) {
                    TMAssistantDownloadService.this.yybManager = new com.tencent.tmdownloader.internal.downloadclient.a();
                }
                TMAssistantDownloadService.this.yybManager.b(TMAssistantDownloadService.this.getApplicationContext(), "TMAssistantYYBManager");
                TMAssistantDownloadService.this.yybManager.a(TMAssistantDownloadService.this.getApplicationContext(), "open_sdkcom.tencent.mobileqq:web");
                sendEmptyMessage(1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    protected class d extends b.a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements com.tencent.tmassistantbase.util.f {
            static IPatchRedirector $redirector_;

            a(d dVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
                }
            }
        }

        protected d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TMAssistantDownloadService.this);
            }
        }

        @Override // com.tencent.tmassistant.aidl.b
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
                return;
            }
            r.b(TMAssistantDownloadService.TAG, "<setServiceSetingIsDownloadWifiOnly>isDownloadWifiOnly: " + z16);
            com.tencent.tmdownloader.internal.downloadservice.e.a().a(z16);
        }

        @Override // com.tencent.tmassistant.aidl.b
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            r.b(TMAssistantDownloadService.TAG, "<setServiceSetingIsTaskAutoResume>isTaskAutoResume: " + z16);
            com.tencent.tmdownloader.internal.downloadservice.e.a().b(z16);
        }

        @Override // com.tencent.tmassistant.aidl.b
        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return 1;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        @Override // com.tencent.tmassistant.aidl.b
        public TMAssistantDownloadTaskInfo d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (TMAssistantDownloadTaskInfo) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
            }
            com.tencent.tmdownloader.internal.downloadservice.g.c cVar = TMAssistantDownloadService.this.mServiceDownloadTaskManager;
            if (cVar != null) {
                TMAssistantDownloadTaskInfo d16 = cVar.d(str, str2);
                r.b(TMAssistantDownloadService.TAG, "<getDownloadTaskInfo>returnValue: " + d16);
                return d16;
            }
            return null;
        }

        @Override // com.tencent.tmassistant.aidl.b
        public void e(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
                return;
            }
            r.b(TMAssistantDownloadService.TAG, "<cancelDownloadTask>clientkey:" + str + ",url:" + str2);
            com.tencent.tmdownloader.internal.downloadservice.g.c cVar = TMAssistantDownloadService.this.mServiceDownloadTaskManager;
            if (cVar != null) {
                cVar.a(str, str2);
            }
        }

        @Override // com.tencent.tmassistant.aidl.b
        public List<TMAssistantDownloadTaskInfo> f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (List) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            }
            com.tencent.tmdownloader.internal.downloadservice.g.c cVar = TMAssistantDownloadService.this.mServiceDownloadTaskManager;
            if (cVar != null) {
                List<TMAssistantDownloadTaskInfo> c16 = cVar.c(str);
                r.b(TMAssistantDownloadService.TAG, "<getDownloadTaskInfoByVia>jimluo service return " + c16);
                return c16;
            }
            return null;
        }

        @Override // com.tencent.tmassistant.aidl.b
        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this);
            } else if (TMAssistantDownloadService.this.mLogListener != null) {
                r.b(TMAssistantDownloadService.this.mLogListener);
                TMAssistantDownloadService.this.mLogListener = null;
            }
        }

        @Override // com.tencent.tmassistant.aidl.b
        public boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            boolean booleanValue = ApkDownloadManager.getInstance().isAllDownloadFinished().booleanValue();
            r.b(TMAssistantDownloadService.TAG, "<isAllDownloadFinished>returnValue: " + booleanValue);
            return booleanValue;
        }

        @Override // com.tencent.tmassistant.aidl.b
        public void c(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
                return;
            }
            r.b(TMAssistantDownloadService.TAG, "<pauseDownloadTask>clientkey:" + str + ",url:" + str2);
            try {
                com.tencent.tmdownloader.internal.downloadservice.g.c cVar = TMAssistantDownloadService.this.mServiceDownloadTaskManager;
                if (cVar != null) {
                    cVar.e(str, str2);
                }
            } catch (Exception e16) {
                r.a(TMAssistantDownloadService.TAG, "<pauseDownloadTask>exception: ", e16);
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.tmassistant.aidl.b
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
                return;
            }
            r.b(TMAssistantDownloadService.TAG, "<setServiceSetingMaxTaskNum>maxTaskNum: " + i3);
            com.tencent.tmdownloader.internal.downloadservice.e.a().a(i3);
        }

        @Override // com.tencent.tmassistant.aidl.b
        public void b(String str, com.tencent.tmassistant.aidl.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) aVar);
                return;
            }
            r.b(TMAssistantDownloadService.TAG, "<unregisterDownloadTaskCallback>clientKey:" + str);
            if (str == null || aVar == null) {
                return;
            }
            TMAssistantDownloadService.this.mCallbacks.unregister(aVar);
            synchronized (this) {
                TMAssistantDownloadService.this.mCallbackHashMap.remove(aVar);
            }
        }

        @Override // com.tencent.tmassistant.aidl.b
        public int a(String str, String str2, int i3, String str3, String str4, Map map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, this, str, str2, Integer.valueOf(i3), str3, str4, map)).intValue();
            }
            Objects.toString(TMAssistantDownloadService.this.mServiceDownloadTaskManager);
            if (map != null) {
                map.size();
                if (map.containsKey(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION)) {
                    r.b(TMAssistantDownloadService.TAG, "startDownloadTask showNotificationStr : " + ((String) map.get(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION)));
                }
            }
            if (TMAssistantDownloadService.this.mServiceDownloadTaskManager == null) {
                return 6;
            }
            com.tencent.tmdownloader.f.b.a.a().a(str, str2);
            if (map != null && map.containsKey(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION)) {
                String str5 = (String) map.get(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
                r.b(TMAssistantDownloadService.TAG, "startDownloadTask showNotificationStr : " + str5);
                try {
                    if (!TextUtils.isEmpty(str5) && Integer.valueOf(str5).intValue() == TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE) {
                        TMAssistantDownloadService tMAssistantDownloadService = TMAssistantDownloadService.this;
                        if (tMAssistantDownloadService.mNotificationManager == null) {
                            tMAssistantDownloadService.mNotificationManager = com.tencent.tmdownloader.internal.notification.a.b();
                            TMAssistantDownloadService.this.mNotificationManager.d();
                        }
                    }
                } catch (Exception e16) {
                    r.a(TMAssistantDownloadService.TAG, "call startDownload showNotificationStr parse Exception: ", e16);
                }
            }
            return TMAssistantDownloadService.this.mServiceDownloadTaskManager.a(str, str2, i3, str3, str4, map);
        }

        @Override // com.tencent.tmassistant.aidl.b
        public void a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
                return;
            }
            r.b(TMAssistantDownloadService.TAG, "<deleteDownloadTask>clientkey:" + str + ",url:" + str2);
            com.tencent.tmdownloader.internal.downloadservice.g.c cVar = TMAssistantDownloadService.this.mServiceDownloadTaskManager;
            if (cVar != null) {
                cVar.b(str, str2);
            }
        }

        @Override // com.tencent.tmassistant.aidl.b
        public void a(String str, com.tencent.tmassistant.aidl.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) aVar);
                return;
            }
            r.b(TMAssistantDownloadService.TAG, "<registerDownloadTaskCallback>clientKey:" + str);
            if (str == null || aVar == null) {
                return;
            }
            TMAssistantDownloadService.this.mCallbacks.register(aVar);
            synchronized (this) {
                TMAssistantDownloadService.this.mCallbackHashMap.put(aVar, str);
            }
        }

        @Override // com.tencent.tmassistant.aidl.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this);
            } else if (TMAssistantDownloadService.this.mLogListener == null) {
                TMAssistantDownloadService.this.mLogListener = new a(this);
                r.a(TMAssistantDownloadService.this.mLogListener);
            }
        }
    }

    public TMAssistantDownloadService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.downloadSDKServiceImpl = new d();
        this.mCallbacks = new RemoteCallbackList<>();
        this.mCallbackHashMap = new HashMap<>();
        this.mServiceDownloadTaskManager = null;
        this.mNotificationManager = null;
        this.yybManager = null;
        this.mLogListener = null;
        this.mHandler = new c();
    }

    private boolean handlePush(NotifyParam notifyParam) {
        switch (notifyParam.notificationTypeId) {
            case 101:
            case 102:
                ApkDownloadManager.getInstance().pauseDownload(notifyParam.url);
                return true;
            case 103:
                ApkDownloadManager.getInstance().continueDownload(notifyParam.url);
                return true;
            case 104:
                com.tencent.tmdownloader.internal.downloadservice.c queryDownloadInfo = ApkDownloadManager.getInstance().queryDownloadInfo(notifyParam.url);
                if (queryDownloadInfo != null) {
                    com.tencent.tmdownloader.internal.downloadservice.a.b(com.tencent.tmdownloader.f.b.c.b(queryDownloadInfo.f380689j));
                    com.tencent.tmdownloader.internal.notification.a.b().e(String.valueOf(queryDownloadInfo.f380696q));
                    return true;
                }
                return true;
            case 105:
                ApkDownloadManager.getInstance().restartDownload(notifyParam.url);
                return true;
            default:
                return true;
        }
    }

    @Override // com.tencent.tmdownloader.internal.downloadservice.g.a
    public void OnDownloadProgressChanged(String str, String str2, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        synchronized (this.mCallbacks) {
            try {
                int beginBroadcast = this.mCallbacks.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        com.tencent.tmassistant.aidl.a broadcastItem = this.mCallbacks.getBroadcastItem(i3);
                        String str3 = this.mCallbackHashMap.get(broadcastItem);
                        if (str3 != null && str3.equals(str)) {
                            broadcastItem.a(str, str2, j3, j16);
                        }
                    } catch (RemoteException e16) {
                        r.a(TAG, "exception: ", e16);
                    }
                }
                this.mCallbacks.finishBroadcast();
            } finally {
            }
        }
    }

    @Override // com.tencent.tmdownloader.internal.downloadservice.g.a
    public void OnDownloadStateChanged(String str, String str2, int i3, int i16, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3);
            return;
        }
        synchronized (this.mCallbacks) {
            try {
                int beginBroadcast = this.mCallbacks.beginBroadcast();
                for (int i17 = 0; i17 < beginBroadcast; i17++) {
                    try {
                        com.tencent.tmassistant.aidl.a broadcastItem = this.mCallbacks.getBroadcastItem(i17);
                        String str4 = this.mCallbackHashMap.get(broadcastItem);
                        if (str4 != null && str4.equals(str)) {
                            broadcastItem.a(str, str2, i3, i16, str3);
                        }
                    } catch (RemoteException e16) {
                        Log.e(TAG, "exception: ", e16);
                    }
                }
                this.mCallbacks.finishBroadcast();
            } finally {
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        Objects.toString(intent);
        Objects.toString(this.downloadSDKServiceImpl);
        return this.downloadSDKServiceImpl;
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate();
        GlobalUtil.getInstance().setContext(this);
        NetworkMonitorReceiver.getInstance().registerReceiver();
        l.b();
        try {
            MobileQQCloseServiceReceiver.a().d(this);
        } catch (Throwable unused) {
        }
        com.tencent.tmassistantbase.util.e.a().post(new a());
        new BaseThread(new b()).start();
        q.a("TMAssistantDownloadService.onCreate end, timeCost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        ApkDownloadManager.getInstance().uninit();
        com.tencent.tmdownloader.internal.downloadservice.g.c cVar = this.mServiceDownloadTaskManager;
        if (cVar != null) {
            cVar.b();
            this.mServiceDownloadTaskManager.a((com.tencent.tmdownloader.internal.downloadservice.g.a) null);
            this.mServiceDownloadTaskManager = null;
        }
        com.tencent.tmdownloader.internal.notification.a aVar = this.mNotificationManager;
        if (aVar != null) {
            aVar.e();
            this.mNotificationManager = null;
        }
        NetworkMonitorReceiver.getInstance().unregisterReceiver();
        GlobalUtil.getInstance().destroy();
        MobileQQCloseServiceReceiver.a().e(this);
        try {
            PackageInstallReceiver.a().b(this);
        } catch (Throwable unused) {
        }
        SystemClock.sleep(300L);
        SystemMethodProxy.killProcess(Process.myPid());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.String] */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        NotifyParam notifyParam;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        NotifyParam notifyParam2 = null;
        if (intent != null) {
            try {
                notifyParam = intent.getStringExtra("client_key");
            } catch (Exception e16) {
                e16.printStackTrace();
                notifyParam = null;
            }
            try {
                notifyParam2 = (NotifyParam) intent.getParcelableExtra("notifyParam");
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            if (notifyParam2 != null) {
                if (TextUtils.isEmpty(notifyParam2.url)) {
                    return 2;
                }
                handlePush(notifyParam2);
            }
            notifyParam2 = notifyParam;
        }
        Message message = new Message();
        message.what = 0;
        message.obj = notifyParam2;
        this.mHandler.sendMessage(message);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent)).booleanValue();
        }
        Objects.toString(intent);
        return super.onUnbind(intent);
    }
}
