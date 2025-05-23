package com.tencent.mobileqq.app.message.messageclean;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.api.MiniGameSpaceOccupyListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.zootopia.api.IZootopiaSpaceApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.CacheFileType;
import com.tencent.qqnt.kernel.nativeinterface.CacheOrderType;
import com.tencent.qqnt.kernel.nativeinterface.ChatCacheDeleteInfo;
import com.tencent.qqnt.kernel.nativeinterface.ChatCacheInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileCacheInfo;
import com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetChatCacheInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetFileCacheInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelScanEndCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.br;
import com.tencent.qqnt.msg.api.IRichMediaService;
import com.tencent.qqnt.msg.migration.NTMsgMigrationManager;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NTScanSpaceManager {
    static IPatchRedirector $redirector_;
    private static volatile NTScanSpaceManager A;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.qqnt.kernel.api.af f196051a;

    /* renamed from: b, reason: collision with root package name */
    private List<ad> f196052b;

    /* renamed from: c, reason: collision with root package name */
    private final be f196053c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f196054d;

    /* renamed from: e, reason: collision with root package name */
    private long f196055e;

    /* renamed from: f, reason: collision with root package name */
    private long f196056f;

    /* renamed from: g, reason: collision with root package name */
    private long f196057g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f196058h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f196059i;

    /* renamed from: j, reason: collision with root package name */
    private final al f196060j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f196061k;

    /* renamed from: l, reason: collision with root package name */
    private CountDownLatch f196062l;

    /* renamed from: m, reason: collision with root package name */
    private long f196063m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f196064n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f196065o;

    /* renamed from: p, reason: collision with root package name */
    private ac f196066p;

    /* renamed from: q, reason: collision with root package name */
    private tb3.a f196067q;

    /* renamed from: r, reason: collision with root package name */
    private MiniGameSpaceOccupyListener f196068r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f196069s;

    /* renamed from: t, reason: collision with root package name */
    private long f196070t;

    /* renamed from: u, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f196071u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f196072v;

    /* renamed from: w, reason: collision with root package name */
    private List<i> f196073w;

    /* renamed from: x, reason: collision with root package name */
    private volatile boolean f196074x;

    /* renamed from: y, reason: collision with root package name */
    private volatile boolean f196075y;

    /* renamed from: z, reason: collision with root package name */
    private final BroadcastReceiver f196076z;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class CacheSizeRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final NTScanSpaceManager f196080d;

        public CacheSizeRunnable(NTScanSpaceManager nTScanSpaceManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTScanSpaceManager);
            } else {
                this.f196080d = nTScanSpaceManager;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            long cacheSize;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                try {
                    if (this.f196080d.f196072v) {
                        cacheSize = ((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).scanCacheFile(this.f196080d.f196074x);
                    } else {
                        cacheSize = ((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).getCacheSize(null);
                    }
                    this.f196080d.f196053c.q(cacheSize);
                    QLog.d("NTScanSpaceManager", 1, "Runnable cacheSizeRunnable finish cacheSize:" + cacheSize);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
                    String str = "0";
                    if (appInterface != null) {
                        str = appInterface.getCurrentAccountUin();
                    }
                    String str2 = str;
                    com.tencent.mobileqq.utils.w.a("storageCacheSize", uptimeMillis - this.f196080d.f196055e, this.f196080d.f196055e, uptimeMillis, str2);
                    NTScanSpaceManager nTScanSpaceManager = this.f196080d;
                    nTScanSpaceManager.f196057g = uptimeMillis - nTScanSpaceManager.f196055e;
                    if (this.f196080d.f196074x) {
                        QLog.d("NTScanSpaceManager", 1, "isOptimizeStorageUI qqTotalSizeRunnable otherSizeRunnable");
                        this.f196080d.f196053c.z(((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).getWhiteListSize() + cacheSize);
                        long h16 = q.h(true);
                        this.f196080d.f196053c.z(this.f196080d.f196053c.l() + h16);
                        this.f196080d.f196053c.y(h16);
                        long uptimeMillis2 = SystemClock.uptimeMillis();
                        QLog.d("NTScanSpaceManager", 1, "Runnable qqTotalSizeRunnable finish qqTotalSize:" + this.f196080d.f196053c.l() + ", qqApp:" + h16 + ", cost: " + (uptimeMillis2 - this.f196080d.f196055e));
                        com.tencent.mobileqq.utils.w.a("storageQQTotalSize", uptimeMillis2 - this.f196080d.f196055e, this.f196080d.f196055e, uptimeMillis2, str2);
                        long totalInternalMemorySize = SdCardUtil.getTotalInternalMemorySize();
                        long totalExternalMemorySize = SdCardUtil.getTotalExternalMemorySize(BaseApplicationImpl.getApplication());
                        long availableInternalMemorySize = SdCardUtil.getAvailableInternalMemorySize();
                        long availableExternalMemorySize = SdCardUtil.getAvailableExternalMemorySize(BaseApplicationImpl.getApplication());
                        this.f196080d.f196053c.v(totalInternalMemorySize + totalExternalMemorySize);
                        this.f196080d.f196053c.u(availableInternalMemorySize + availableExternalMemorySize);
                        QLog.d("NTScanSpaceManager", 1, "Runnable otherSizeRunnable finish totalInternal:" + totalInternalMemorySize + ", totalExternal:" + totalExternalMemorySize + ", avaInternal:" + availableInternalMemorySize + ", avaExternal:" + availableExternalMemorySize + " deviceTotalSize:" + this.f196080d.f196053c.f() + " deviceAvailableSize:" + this.f196080d.f196053c.e());
                        long uptimeMillis3 = SystemClock.uptimeMillis();
                        com.tencent.mobileqq.utils.w.a("storageOtherSize", uptimeMillis3 - this.f196080d.f196055e, this.f196080d.f196055e, uptimeMillis3, str2);
                    }
                } catch (Exception e16) {
                    QLog.e("NTScanSpaceManager", 1, "Runnable cacheSizeRunnable exception:", e16);
                }
            } finally {
                this.f196080d.f196062l.countDown();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class ChatRecordSizeRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final NTScanSpaceManager f196081d;

        /* compiled from: P */
        /* loaded from: classes11.dex */
        class a implements ac {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatRecordSizeRunnable.this);
                }
            }

            @Override // com.tencent.mobileqq.app.message.messageclean.ac
            public void onLoadFinish() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                } else {
                    ChatRecordSizeRunnable.this.f196081d.f196062l.countDown();
                }
            }

            @Override // com.tencent.mobileqq.app.message.messageclean.ac
            public void onLoadStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }

        public ChatRecordSizeRunnable(NTScanSpaceManager nTScanSpaceManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTScanSpaceManager);
            } else {
                this.f196081d = nTScanSpaceManager;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f196081d.w0(new a());
                this.f196081d.g0();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class CoreRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final NTScanSpaceManager f196083d;

        public CoreRunnable(NTScanSpaceManager nTScanSpaceManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTScanSpaceManager);
            } else {
                this.f196083d = nTScanSpaceManager;
            }
        }

        private void e() {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager.CoreRunnable.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) CoreRunnable.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        k.f196233a.g();
                    }
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            e();
            this.f196083d.f196055e = SystemClock.uptimeMillis();
            QLog.d("NTScanSpaceManager", 1, "all runnable begin, scanBeginTime: " + this.f196083d.f196055e);
            if (this.f196083d.f196074x) {
                this.f196083d.f196062l = new CountDownLatch(3);
            } else {
                this.f196083d.f196062l = new CountDownLatch(5);
                ThreadManagerV2.excute(new QQTotalSizeRunnable(this.f196083d), 64, null, true);
                ThreadManagerV2.excute(new OtherSizeRunnable(this.f196083d), 64, null, true);
            }
            ThreadManagerV2.excute(new NTScanRunnable(this.f196083d), 64, null, true);
            ThreadManagerV2.excute(new CacheSizeRunnable(this.f196083d), 64, null, true);
            try {
                this.f196083d.f196062l.await();
                QLog.d("NTScanSpaceManager", 1, "all runnable finish success, storageSize:" + this.f196083d.f196053c);
            } catch (InterruptedException e16) {
                QLog.d("NTScanSpaceManager", 1, "coreRunnable exception:" + e16);
            }
            this.f196083d.f196054d = true;
            this.f196083d.f196058h = false;
            this.f196083d.f196061k = false;
            long uptimeMillis = SystemClock.uptimeMillis();
            NTScanSpaceManager nTScanSpaceManager = this.f196083d;
            nTScanSpaceManager.f196056f = uptimeMillis - nTScanSpaceManager.f196055e;
            QLog.d("NTScanSpaceManager", 1, "CoreRunnable complete , assign isScanning false, scanTimeCost: " + this.f196083d.f196056f + ", endTime: " + uptimeMillis + ", scanBeginTime: " + this.f196083d.f196055e);
            AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
            if (appInterface != null) {
                str = appInterface.getCurrentAccountUin();
            } else {
                str = "0";
            }
            com.tencent.mobileqq.utils.w.a("storageOverview", this.f196083d.f196056f, this.f196083d.f196055e, uptimeMillis, str);
            this.f196083d.u0();
            QLog.d("NTScanSpaceManager", 1, "success, completeLoading");
            k.f196233a.c(this.f196083d.f196061k);
            StorageReport.k().t(this.f196083d.f196053c.k(), this.f196083d.f196053c.j(), this.f196083d.f196053c.a(), this.f196083d.f196072v);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class NTScanRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final NTScanSpaceManager f196084d;

        /* compiled from: P */
        /* loaded from: classes11.dex */
        class a implements IKernelScanEndCallback {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ArrayList f196085a;

            a(ArrayList arrayList) {
                this.f196085a = arrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTScanRunnable.this, (Object) arrayList);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelScanEndCallback
            public void onResult(int i3, ArrayList<Long> arrayList) {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) arrayList);
                    return;
                }
                QLog.d("NTScanSpaceManager", 1, "IKernelScanEndCallback onResult: result " + i3 + " size : " + arrayList);
                if (i3 == 0) {
                    long c16 = NTScanRunnable.this.c(arrayList, 4);
                    long c17 = NTScanRunnable.this.c(arrayList, 5);
                    long c18 = NTScanRunnable.this.c(arrayList, 8);
                    NTScanRunnable.this.f196084d.f196053c.s(c16);
                    NTScanRunnable.this.f196084d.f196053c.t(c18);
                    NTScanRunnable.this.f196084d.f196053c.r(c17);
                    NTScanRunnable.this.f196084d.f196062l.countDown();
                    long uptimeMillis = SystemClock.uptimeMillis();
                    AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
                    if (appInterface != null) {
                        str = appInterface.getCurrentAccountUin();
                    } else {
                        str = "0";
                    }
                    com.tencent.mobileqq.utils.w.a("storageNTScan", uptimeMillis - NTScanRunnable.this.f196084d.f196055e, NTScanRunnable.this.f196084d.f196055e, uptimeMillis, str);
                    ThreadManagerV2.excute(new ChatRecordSizeRunnable(NTScanRunnable.this.f196084d), 64, null, true);
                    StorageReport.k().u(c16, c17, c18, this.f196085a);
                }
            }
        }

        public NTScanRunnable(NTScanSpaceManager nTScanSpaceManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTScanSpaceManager);
            } else {
                this.f196084d = nTScanSpaceManager;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c(ArrayList<Long> arrayList, int i3) {
            if (arrayList != null && arrayList.size() >= i3) {
                return arrayList.get(i3).longValue();
            }
            return 0L;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    ArrayList<String> U = this.f196084d.U();
                    this.f196084d.f196051a.G0(U);
                    this.f196084d.f196051a.Z(new a(U));
                    return;
                } catch (Exception e16) {
                    QLog.e("NTScanSpaceManager", 1, "Runnable NTScanRunnable exception:", e16);
                    this.f196084d.f196062l.countDown();
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class OtherSizeRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final NTScanSpaceManager f196087d;

        public OtherSizeRunnable(NTScanSpaceManager nTScanSpaceManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTScanSpaceManager);
            } else {
                this.f196087d = nTScanSpaceManager;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                try {
                    long totalInternalMemorySize = SdCardUtil.getTotalInternalMemorySize();
                    long totalExternalMemorySize = SdCardUtil.getTotalExternalMemorySize(BaseApplicationImpl.getApplication());
                    long availableInternalMemorySize = SdCardUtil.getAvailableInternalMemorySize();
                    long availableExternalMemorySize = SdCardUtil.getAvailableExternalMemorySize(BaseApplicationImpl.getApplication());
                    this.f196087d.f196053c.v(totalInternalMemorySize + totalExternalMemorySize);
                    this.f196087d.f196053c.u(availableInternalMemorySize + availableExternalMemorySize);
                    QLog.d("NTScanSpaceManager", 1, "Runnable otherSizeRunnable finish totalInternal:" + totalInternalMemorySize + ", totalExternal:" + totalExternalMemorySize + ", avaInternal:" + availableInternalMemorySize + ", avaExternal:" + availableExternalMemorySize + " deviceTotalSize:" + this.f196087d.f196053c.f() + " deviceAvailableSize:" + this.f196087d.f196053c.e());
                    long uptimeMillis = SystemClock.uptimeMillis();
                    AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
                    if (appInterface == null) {
                        str = "0";
                    } else {
                        str = appInterface.getCurrentAccountUin();
                    }
                    com.tencent.mobileqq.utils.w.a("storageOtherSize", uptimeMillis - this.f196087d.f196055e, this.f196087d.f196055e, uptimeMillis, str);
                } catch (Exception e16) {
                    QLog.e("NTScanSpaceManager", 1, "Runnable otherSizeRunnable exception:", e16);
                }
            } finally {
                this.f196087d.f196062l.countDown();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class QQTotalSizeRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final NTScanSpaceManager f196088d;

        public QQTotalSizeRunnable(NTScanSpaceManager nTScanSpaceManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTScanSpaceManager);
            } else {
                this.f196088d = nTScanSpaceManager;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                try {
                    this.f196088d.f196053c.z(StorageReport.k().o(null, 0, 98));
                    long h16 = q.h(true);
                    this.f196088d.f196053c.z(this.f196088d.f196053c.l() + h16);
                    this.f196088d.f196053c.y(h16);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    QLog.d("NTScanSpaceManager", 1, "Runnable qqTotalSizeRunnable finish qqTotalSize:" + this.f196088d.f196053c.l() + ", qqApp:" + h16 + ", cost: " + (uptimeMillis - this.f196088d.f196055e));
                    AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
                    if (appInterface == null) {
                        str = "0";
                    } else {
                        str = appInterface.getCurrentAccountUin();
                    }
                    com.tencent.mobileqq.utils.w.a("storageQQTotalSize", uptimeMillis - this.f196088d.f196055e, this.f196088d.f196055e, uptimeMillis, str);
                } catch (Exception e16) {
                    QLog.e("NTScanSpaceManager", 1, "Runnable qqTotalSizeRunnable exception:", e16);
                }
            } finally {
                this.f196088d.f196062l.countDown();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class StorageCleanListener implements IKernelStorageCleanListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<NTScanSpaceManager> f196089a;

        StorageCleanListener(NTScanSpaceManager nTScanSpaceManager) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTScanSpaceManager);
            } else {
                this.f196089a = new WeakReference<>(nTScanSpaceManager);
            }
        }

        private long b(ArrayList<Long> arrayList, int i3) {
            if (arrayList != null && arrayList.size() >= i3) {
                return arrayList.get(i3).longValue();
            }
            return 0L;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanListener
        public /* synthetic */ void onChatCleanDone(String str, int i3) {
            br.a(this, str, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanListener
        public void onCleanCacheProgressChanged(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanListener
        public void onCleanCacheStorageChanged(ArrayList<Long> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
                return;
            }
            NTScanSpaceManager nTScanSpaceManager = this.f196089a.get();
            if (nTScanSpaceManager == null) {
                return;
            }
            QLog.d("NTScanSpaceManager", 1, "onCleanCacheStorageChanged size:" + arrayList);
            long b16 = b(arrayList, 4);
            long b17 = b(arrayList, 5);
            long b18 = b(arrayList, 8);
            nTScanSpaceManager.f196070t = nTScanSpaceManager.f196053c.d() - b16;
            nTScanSpaceManager.f196053c.s(b16);
            nTScanSpaceManager.f196053c.t(b16);
            nTScanSpaceManager.f196053c.r(b17);
            nTScanSpaceManager.f196053c.t(b18);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager.StorageCleanListener.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StorageCleanListener.this);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    NTScanSpaceManager nTScanSpaceManager2 = (NTScanSpaceManager) StorageCleanListener.this.f196089a.get();
                    if (nTScanSpaceManager2 == null) {
                        return;
                    }
                    Iterator it = nTScanSpaceManager2.f196073w.iterator();
                    while (it.hasNext()) {
                        ((i) it.next()).onUpdate();
                    }
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanListener
        public /* synthetic */ void onFinishScan(ArrayList arrayList) {
            br.d(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanListener
        public void onScanCacheProgressChanged(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements IOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f196090a;

        a(WeakReference weakReference) {
            this.f196090a = weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTScanSpaceManager.this, (Object) weakReference);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            QLog.d("NTScanSpaceManager", 1, "deleteFile clearChatCacheInfo result:" + i3 + " errMsg:" + str);
            Runnable runnable = (Runnable) this.f196090a.get();
            if (i3 == 0 && runnable != null) {
                QLog.d("NTScanSpaceManager", 1, "deleteFile localCallback run");
                runnable.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements ICanImportCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ab f196092a;

        b(ab abVar) {
            this.f196092a = abVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTScanSpaceManager.this, (Object) abVar);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback
        public void onResult(int i3, String str, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
                return;
            }
            QLog.d("NTScanSpaceManager", 1, "canProcessDataMigration onResult: result:" + i3 + " errMsg:" + str + " tipLevel:" + i16);
            if (i16 == 1) {
                QLog.d("NTScanSpaceManager", 1, "silent import. startScan");
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final ab abVar = this.f196092a;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.app.message.messageclean.am
                    @Override // java.lang.Runnable
                    public final void run() {
                        ab.this.a();
                    }
                });
                return;
            }
            if (i3 == 1) {
                String P = NTScanSpaceManager.this.P();
                if (P == null) {
                    P = "";
                }
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                int decodeInt = from.decodeInt(P + "message_import_show_count", 0);
                if (decodeInt >= 3) {
                    QLog.d("NTScanSpaceManager", 1, "over MaxCount. startScan");
                    Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
                    final ab abVar2 = this.f196092a;
                    uIHandlerV22.post(new Runnable() { // from class: com.tencent.mobileqq.app.message.messageclean.an
                        @Override // java.lang.Runnable
                        public final void run() {
                            ab.this.a();
                        }
                    });
                    return;
                }
                QLog.d("NTScanSpaceManager", 1, "show dialog count:" + decodeInt);
                from.encodeInt(P + "message_import_show_count", decodeInt + 1);
                Handler uIHandlerV23 = ThreadManagerV2.getUIHandlerV2();
                final ab abVar3 = this.f196092a;
                uIHandlerV23.post(new Runnable() { // from class: com.tencent.mobileqq.app.message.messageclean.ao
                    @Override // java.lang.Runnable
                    public final void run() {
                        ab.this.b();
                    }
                });
                return;
            }
            if (i3 == 2) {
                Handler uIHandlerV24 = ThreadManagerV2.getUIHandlerV2();
                final ab abVar4 = this.f196092a;
                uIHandlerV24.post(new Runnable() { // from class: com.tencent.mobileqq.app.message.messageclean.ap
                    @Override // java.lang.Runnable
                    public final void run() {
                        ab.this.onLoading();
                    }
                });
            } else {
                QLog.d("NTScanSpaceManager", 1, "import Done, startScan");
                Handler uIHandlerV25 = ThreadManagerV2.getUIHandlerV2();
                final ab abVar5 = this.f196092a;
                uIHandlerV25.post(new Runnable() { // from class: com.tencent.mobileqq.app.message.messageclean.aq
                    @Override // java.lang.Runnable
                    public final void run() {
                        ab.this.a();
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTScanSpaceManager.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (!NewIntent.ACTION_ACCOUNT_CHANGED.equals(action) && !NewIntent.ACTION_LOGOUT.equals(action)) {
                if ("qq_setting_on_destroy".equals(action)) {
                    NTScanSpaceManager.this.o0();
                    return;
                }
                return;
            }
            NTScanSpaceManager.this.s0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements z {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ad f196095a;

        d(ad adVar) {
            this.f196095a = adVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTScanSpaceManager.this, (Object) adVar);
            }
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.z
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
                return;
            }
            QLog.d("NTScanSpaceManager", 1, "onLoadComplete timeout: " + z16);
            this.f196095a.U0(NTScanSpaceManager.this.f196053c, z16);
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.z
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f196095a.O1(0.0f);
            }
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.z
        public void onProgressUpdate(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            } else {
                this.f196095a.O1(f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e implements tb3.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f196097a;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTScanSpaceManager.this);
            } else {
                this.f196097a = true;
            }
        }

        @Override // tb3.a
        public void totalOccupiedSpaceUpdate(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else if (this.f196097a) {
                NTScanSpaceManager.this.f196053c.A(j3);
                this.f196097a = false;
            } else {
                NTScanSpaceManager.this.f196053c.C(j3);
                StorageReport.k().z(j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class f implements MiniGameSpaceOccupyListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTScanSpaceManager.this);
            }
        }

        @Override // com.tencent.mobileqq.minigame.api.MiniGameSpaceOccupyListener
        public void totalOccupiedSpaceUpdate(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else if (NTScanSpaceManager.this.f196069s) {
                NTScanSpaceManager.this.f196053c.w(j3);
                NTScanSpaceManager.this.f196069s = false;
            } else {
                NTScanSpaceManager.this.f196053c.B(j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class g implements IKernelGetChatCacheInfoCallback {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTScanSpaceManager.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetChatCacheInfoCallback
        public void onResult(int i3, ArrayList<ChatCacheInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) arrayList);
                return;
            }
            QLog.i("NTScanSpaceManager", 1, " getChatCacheInfo finish");
            NTScanSpaceManager.this.f196060j.i(arrayList);
            NTScanSpaceManager.this.h0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class h implements IKernelGetFileCacheInfoCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t81.a f196101a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f196102b;

        h(t81.a aVar, int i3) {
            this.f196101a = aVar;
            this.f196102b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTScanSpaceManager.this, aVar, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetFileCacheInfoCallback
        public void onResult(ArrayList<FileCacheInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
                return;
            }
            if (arrayList.isEmpty()) {
                QLog.d("NTScanSpaceManager", 1, "getFileCacheInfo onResult infos is null");
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator<FileCacheInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                FileCacheInfo next = it.next();
                if (next.getPath() != null && next.getPath().length() != 0) {
                    arrayList2.add(next.getPath());
                    arrayList3.add(Long.valueOf(next.getFileSize()));
                    NTScanSpaceManager.this.f196071u.put(next.getPath(), Long.valueOf(next.getFileKey()));
                } else {
                    QLog.d("NTScanSpaceManager", 1, "info path is false");
                }
            }
            this.f196101a.a(arrayList2, arrayList3, this.f196102b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface i {
        void onUpdate();
    }

    NTScanSpaceManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f196052b = new ArrayList();
        this.f196053c = new be();
        this.f196060j = new al();
        this.f196063m = -1L;
        this.f196069s = true;
        this.f196070t = 0L;
        this.f196071u = new ConcurrentHashMap<>();
        this.f196072v = false;
        this.f196073w = new ArrayList(2);
        this.f196074x = false;
        this.f196075y = false;
        c cVar = new c();
        this.f196076z = cVar;
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("qq_setting_on_destroy");
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        appInterface.getApp().registerReceiver(cVar, intentFilter);
        com.tencent.qqnt.kernel.api.af storageCleanService = ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getStorageCleanService();
        this.f196051a = storageCleanService;
        if (storageCleanService == null) {
            return;
        }
        this.f196063m = storageCleanService.B0(new StorageCleanListener(this));
        QLog.d("NTScanSpaceManager", 1, "addStorageScanCleanListener storageCleanListenerId: " + this.f196063m + ", instance:" + A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        if (this.f196067q == null) {
            return;
        }
        ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).unRegisterZootopiaSpaceOccupyListener(this.f196067q);
        this.f196067q = null;
    }

    private void F() {
        this.f196060j.a();
    }

    private CacheFileType K(int i3) {
        if (i3 == 0) {
            return CacheFileType.KPIC;
        }
        if (i3 == 2) {
            return CacheFileType.KVIDEO;
        }
        if (i3 == 3) {
            return CacheFileType.KDOC;
        }
        if (i3 == 5) {
            return CacheFileType.KANDROIDAPP;
        }
        return CacheFileType.KNORMAL;
    }

    private CacheOrderType L(int i3) {
        if (i3 == 0) {
            return CacheOrderType.KTIMEDESC;
        }
        if (i3 == 1) {
            return CacheOrderType.KSIZEDESC;
        }
        return CacheOrderType.KTIMEDESC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        ac acVar = this.f196066p;
        if (acVar != null) {
            acVar.onLoadStart();
        }
        g gVar = new g();
        QLog.i("NTScanSpaceManager", 1, " getChatMessage begin");
        this.f196051a.getChatCacheInfo(1, 99999, CacheOrderType.KSIZEDESC, 0, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String P() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return peekAppRuntime.getCurrentUin();
    }

    public static NTScanSpaceManager S() {
        if (A == null) {
            synchronized (NTScanSpaceManager.class) {
                if (A == null) {
                    A = new NTScanSpaceManager();
                }
            }
        }
        return A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> U() {
        ArrayList<String> arrayList = new ArrayList<>();
        String str = com.tencent.mobileqq.vfs.b.i().e() + "/Tencent/QQfile_recv/";
        for (String str2 : ((IRichMediaService) QRoute.api(IRichMediaService.class)).getVideoMediaFileDirs()) {
            if (!str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        for (String str3 : ((IRichMediaService) QRoute.api(IRichMediaService.class)).getFileMediaFileDirs()) {
            if (!str3.startsWith(str)) {
                arrayList.add(str3);
            }
        }
        for (String str4 : ((IRichMediaService) QRoute.api(IRichMediaService.class)).getPicMediaFileDirs(true)) {
            if (!str4.startsWith(str)) {
                arrayList.add(str4);
            }
        }
        for (String str5 : ((IRichMediaService) QRoute.api(IRichMediaService.class)).getPicMediaFileDirs(false)) {
            if (!str5.startsWith(str)) {
                arrayList.add(str5);
            }
        }
        arrayList.add(((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getFileSaveRootDirectory());
        QLog.d("NTScanSpaceManager", 1, "storageCleanService addFilesScanPaths paths:" + arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        String str;
        this.f196059i = false;
        ac acVar = this.f196066p;
        if (acVar != null) {
            acVar.onLoadFinish();
        }
        QLog.d("NTScanSpaceManager", 1, "LoadChatDataFinish All Data!!!");
        long uptimeMillis = SystemClock.uptimeMillis();
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = "0";
        }
        long j3 = this.f196055e;
        com.tencent.mobileqq.utils.w.a("storageNTChaRecordSize", uptimeMillis - j3, j3, uptimeMillis, str);
    }

    private void m0(float f16) {
        for (ad adVar : this.f196052b) {
            if (adVar != null) {
                adVar.O1(f16);
            }
        }
    }

    private void n0() {
        for (ad adVar : this.f196052b) {
            if (adVar != null) {
                adVar.B0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        this.f196054d = false;
        this.f196075y = false;
        ((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).releaseCleanupManager();
        com.tencent.qqnt.kernel.api.af afVar = this.f196051a;
        if (afVar != null) {
            afVar.closeCleanWindow();
        }
    }

    private void p0() {
        if (this.f196068r != null) {
            return;
        }
        this.f196068r = new f();
        ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).registerMiniGameSpaceOccupyListener(this.f196068r);
    }

    private void r0() {
        if (this.f196067q != null) {
            return;
        }
        this.f196067q = new e();
        ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).registerZootopiaSpaceOccupyListener(this.f196067q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        com.tencent.qqnt.kernel.api.af afVar = this.f196051a;
        if (afVar == null) {
            return;
        }
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.put("param_qq_dir_size", Long.valueOf(this.f196053c.l()));
        hashMap.put("param_cache_dir_scan_cost", Long.valueOf(this.f196057g));
        hashMap.put("param_disk_free_size", Long.valueOf(this.f196053c.e()));
        hashMap.put("param_cache_size", Long.valueOf(this.f196053c.a()));
        hashMap.put("param_disk_size", Long.valueOf(this.f196053c.f()));
        hashMap.put("param_other_size", Long.valueOf(this.f196053c.j()));
        QLog.d("NTScanSpaceManager", 1, "reportKernel Data:" + hashMap);
        afVar.addReportData(hashMap);
        afVar.reportData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        if (this.f196068r == null) {
            return;
        }
        ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).unRegisterMiniGameSpaceOccupyListener(this.f196068r);
        this.f196068r = null;
    }

    public void A0(ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) adVar);
            return;
        }
        QLog.d("NTScanSpaceManager", 1, "unregisterScanSpaceListener scanSpaceListener: " + adVar);
        this.f196052b.remove(adVar);
        k.f196233a.i(adVar);
    }

    public void E(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) iVar);
        } else {
            this.f196073w.add(iVar);
        }
    }

    public void G(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) str);
            return;
        }
        QLog.d("NTScanSpaceManager", 1, "filePathKeyMap size is " + this.f196071u.size() + " ,tag " + str);
        if (this.f196071u.size() != 0) {
            this.f196071u.clear();
        }
    }

    public void H(List<String> list, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) list, (Object) runnable);
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        for (String str : list) {
            if (this.f196071u.containsKey(str)) {
                arrayList.add(this.f196071u.get(str));
            }
        }
        this.f196051a.clearChatCacheInfo(new ArrayList<>(), arrayList, new a(new WeakReference(runnable)));
    }

    public void I(ArrayList<ChatCacheDeleteInfo> arrayList, aa aaVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) arrayList, (Object) aaVar);
            return;
        }
        if (arrayList.size() == 0) {
            aaVar.a(false);
            return;
        }
        QLog.d("NTScanSpaceManager", 1, "deleteMessages cacheDeleteInfos\uff1a" + arrayList.size());
        ThreadManager.getFileThreadHandler().post(new Runnable(arrayList, aaVar) { // from class: com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ArrayList f196077d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ aa f196078e;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager$8$a */
            /* loaded from: classes11.dex */
            class a implements IOperateCallback {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this);
                    }
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public void onResult(int i3, String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                        return;
                    }
                    boolean z16 = true;
                    QLog.d("NTScanSpaceManager", 1, "clearChatCacheInfo deleteMessages onResult. result:" + i3 + " errMsg:" + str);
                    aa aaVar = AnonymousClass8.this.f196078e;
                    if (i3 != 0) {
                        z16 = false;
                    }
                    aaVar.a(z16);
                }
            }

            {
                this.f196077d = arrayList;
                this.f196078e = aaVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, NTScanSpaceManager.this, arrayList, aaVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    NTScanSpaceManager.this.f196051a.clearChatCacheInfo(this.f196077d, new ArrayList<>(), new a());
                }
            }
        });
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    public HashMap<Long, Pair<com.tencent.mobileqq.app.message.messageclean.g, ArrayList<Long>>> M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (HashMap) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f196060j.b();
    }

    public HashMap<Long, ArrayList<com.tencent.mobileqq.app.message.messageclean.g>> O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (HashMap) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f196060j.d();
    }

    public long Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.f196070t;
    }

    public ArrayList<com.tencent.mobileqq.app.message.messageclean.g> R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ArrayList) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f196060j.e();
    }

    public ArrayList<ChatCacheDeleteInfo> T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ArrayList) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.f196060j.c(this.f196060j.f());
    }

    public be V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (be) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f196053c;
    }

    public long W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        if (this.f196058h) {
            return SystemClock.uptimeMillis() - this.f196055e;
        }
        return this.f196056f;
    }

    public boolean X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f196054d;
    }

    public boolean Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f196069s;
    }

    public boolean Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.f196059i;
    }

    public boolean a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f196074x;
    }

    public boolean b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        QLog.d("NTScanSpaceManager", 1, "isScanning isScanning: " + this.f196058h + ", instance:" + A);
        return this.f196058h;
    }

    public boolean c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        QLog.d("NTScanSpaceManager", 1, "isScanningDone isScanningDone: " + this.f196075y + ", instance:" + A);
        return this.f196075y;
    }

    public boolean d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f196065o;
    }

    public boolean e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f196064n;
    }

    public boolean f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        QLog.d("NTScanSpaceManager", 1, "isTimeout isTimeout: " + this.f196061k + ", instance:" + A);
        return this.f196061k;
    }

    public void g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            this.f196060j.a();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTScanSpaceManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        NTScanSpaceManager.this.f196059i = true;
                        NTScanSpaceManager.this.N();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 64, null, true);
        }
    }

    public void i0(List<String> list, int i3, int i16, t81.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, list, Integer.valueOf(i3), Integer.valueOf(i16), aVar);
            return;
        }
        QLog.d("NTScanSpaceManager", 1, "loadFileDataByType. paths:" + list + " type:" + i3 + " order:" + i16);
        this.f196051a.getFileCacheInfo(K(i3), true, 10001, L(i16), new FileCacheInfo(), new h(aVar, i3));
    }

    public void j0(ab abVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) abVar);
            return;
        }
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            QLog.d("NTScanSpaceManager", 1, "getKernelMsgService is null. startScan");
            abVar.a();
        } else {
            NTMsgMigrationManager.X().J();
            e16.canProcessDataMigration(new b(abVar));
        }
    }

    public void k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            this.f196070t = 0L;
            F();
        }
    }

    public void l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            this.f196070t = 0L;
        }
    }

    public void q0(ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) adVar);
            return;
        }
        QLog.d("NTScanSpaceManager", 1, "registerScanSpaceListener scanSpaceListener: " + adVar);
        this.f196052b.add(adVar);
        k.f196233a.e(adVar, new d(adVar));
    }

    public void s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
        if (appInterface != null) {
            appInterface.getApp().unregisterReceiver(this.f196076z);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NTScanSpaceManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    NTScanSpaceManager.this.B0();
                    NTScanSpaceManager.this.z0();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        QLog.d("NTScanSpaceManager", 1, "release instance:" + A);
        if (this.f196051a != null) {
            QLog.d("NTScanSpaceManager", 1, "release storageCleanListenerId: " + this.f196063m + ", instance:" + A);
            long j3 = this.f196063m;
            if (j3 != -1) {
                this.f196051a.t(j3);
            }
            this.f196051a.closeCleanWindow();
        }
        A = null;
        k.f196233a.f();
        ((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).releaseCleanupManager();
    }

    public void t0(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) iVar);
        } else {
            this.f196073w.remove(iVar);
        }
    }

    public void v0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f196074x = z16;
        }
    }

    public void w0(ac acVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) acVar);
        } else {
            this.f196066p = acVar;
        }
    }

    public void x0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.f196075y = z16;
        }
    }

    public void y0(boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        if (this.f196058h) {
            return;
        }
        this.f196058h = true;
        this.f196061k = false;
        this.f196054d = false;
        this.f196072v = z16;
        n0();
        m0(0.0f);
        ThreadManagerV2.excute(new CoreRunnable(this), 16, null, true);
        AppInterface appInterface = (AppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
        if (appInterface != null) {
            j3 = appInterface.getLongAccountUin();
        } else {
            j3 = 0;
        }
        boolean isZplanAccessibleWithoutSetting = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(Constant.FROM_ID_START_ACTIVITY, j3);
        this.f196064n = isZplanAccessibleWithoutSetting;
        if (isZplanAccessibleWithoutSetting) {
            r0();
            ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).calculateZootopiaSpaceOccupy();
        }
        boolean isSupportVA = ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).isSupportVA();
        this.f196065o = isSupportVA;
        if (isSupportVA) {
            p0();
            ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).calculateMiniGameSpaceOccupy();
        }
        QLog.d("NTScanSpaceManager", 1, "isShowZPlanDownloadManager:" + this.f196064n, ",isShowMiniGameDownloadManager:", Boolean.valueOf(this.f196065o));
    }
}
