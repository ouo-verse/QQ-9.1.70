package com.tencent.open.downloadnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.k;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.open.appstore.dl.DownloadInfoReport;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;
import com.tencent.open.downloadnew.common.a;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.common.TMAssistantDownloadContentType;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.ITMAssistantDownloadLogListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import cooperation.qappcenter.QAppCenterPluginProxyActivityTools;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadManager {

    /* renamed from: q, reason: collision with root package name */
    public static final String f341207q;

    /* renamed from: r, reason: collision with root package name */
    protected static DownloadManager f341208r;

    /* renamed from: s, reason: collision with root package name */
    protected static final byte[] f341209s;

    /* renamed from: a, reason: collision with root package name */
    protected TMAssistantDownloadClient f341210a;

    /* renamed from: b, reason: collision with root package name */
    private DownloaderGetCodeClient f341211b;

    /* renamed from: d, reason: collision with root package name */
    protected WeakReference<AppInterface> f341213d;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.open.downloadnew.b f341215f;

    /* renamed from: i, reason: collision with root package name */
    protected PackageInstallReceiver f341218i;

    /* renamed from: c, reason: collision with root package name */
    protected String f341212c = "";

    /* renamed from: e, reason: collision with root package name */
    protected boolean f341214e = false;

    /* renamed from: g, reason: collision with root package name */
    protected ConcurrentHashMap<String, DownloadInfo> f341216g = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    protected ConcurrentLinkedQueue<DownloadListener> f341217h = new ConcurrentLinkedQueue<>();

    /* renamed from: j, reason: collision with root package name */
    protected boolean f341219j = false;

    /* renamed from: k, reason: collision with root package name */
    protected ITMAssistantDownloadClientListener f341220k = new ITMAssistantDownloadClientListener() { // from class: com.tencent.open.downloadnew.DownloadManager.5
        @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
        public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient tMAssistantDownloadClient, final String str, final long j3, final long j16) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.5.2
                @Override // java.lang.Runnable
                public void run() {
                    DownloadInfo l06 = DownloadManager.this.l0(str, j3, j16);
                    if (l06 == null) {
                        com.tencent.open.base.f.i("DownloadManager_", "OnDownloadSDKTaskProgressChanged info == null");
                    } else {
                        com.tencent.open.base.f.h("DownloadManager_", "OnDownloadSDKTaskProgressChanged info state=" + l06.f() + " progress=" + l06.Q);
                    }
                    DownloadManager.this.K(2, l06);
                }
            });
        }

        @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
        public void onDownloadSDKTaskStateChanged(final TMAssistantDownloadClient tMAssistantDownloadClient, final String str, final int i3, final int i16, final String str2) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.5.1
                /* JADX WARN: Removed duplicated region for block: B:11:0x00b4  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x010d  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
                    long j3;
                    long j16;
                    com.tencent.open.base.f.e("DownloadManager_", "OnDownloadStateChanged,clientKey:" + tMAssistantDownloadClient + ",state:" + i3 + ",url:" + str);
                    int o16 = DownloadManager.o(i3);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onStateChanged url: +++++loacalState=");
                    sb5.append(o16);
                    sb5.append(" +++++downloadInfo=");
                    sb5.append(DownloadManager.this.y(str));
                    com.tencent.open.base.f.h("DownloadManager_", sb5.toString());
                    DownloadInfo m06 = DownloadManager.this.m0(str, o16);
                    if (m06 == null) {
                        com.tencent.open.base.f.i("DownloadManager_", "OnDownloadSDKTaskStateChanged info == null");
                        return;
                    }
                    TMAssistantDownloadClient tMAssistantDownloadClient2 = tMAssistantDownloadClient;
                    if (tMAssistantDownloadClient2 != null) {
                        try {
                            tMAssistantDownloadTaskInfo = tMAssistantDownloadClient2.getDownloadTaskState(str);
                        } catch (Exception e16) {
                            com.tencent.open.base.f.d("DownloadManager_", "getDownloadTaskState>>>", e16);
                            tMAssistantDownloadTaskInfo = null;
                        }
                        if (tMAssistantDownloadTaskInfo != null) {
                            long j17 = tMAssistantDownloadTaskInfo.mReceiveDataLen;
                            long j18 = tMAssistantDownloadTaskInfo.mTotalDataLen;
                            int i17 = (int) ((((float) j17) * 100.0f) / ((float) j18));
                            m06.Q = i17;
                            m06.f341180b0 = j18;
                            com.tencent.open.base.f.h("DownloadManager_", "OnDownloadSDKTaskStateChanged info progress = " + i17);
                            j3 = j18;
                            j16 = j17;
                            if (o16 == -2) {
                                if (o16 != 10) {
                                    if (o16 != 20) {
                                        if (o16 != 2) {
                                            if (o16 != 3) {
                                                if (o16 == 4) {
                                                    DownloadManager.this.h0(m06, 0L, j3 - m06.V, "complete");
                                                    DownloadManager.this.n(m06);
                                                    return;
                                                }
                                                return;
                                            }
                                            DownloadManager.this.h0(m06, j16, j16 - m06.V, "pause");
                                            DownloadManager.this.K(3, m06);
                                            return;
                                        }
                                        DownloadManager.this.K(2, m06);
                                        return;
                                    }
                                    DownloadManager.this.K(20, m06);
                                    return;
                                }
                                DownloadManager.this.K(10, m06);
                                return;
                            }
                            DownloadManager.this.s(m06, j16, j3, i16);
                            DownloadManager.this.L(-2, m06, i16, str2);
                            return;
                        }
                    }
                    j16 = 0;
                    j3 = 0;
                    if (o16 == -2) {
                    }
                }
            });
        }

        @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
        public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient tMAssistantDownloadClient) {
            com.tencent.open.base.f.c("DownloadManager_", "OnDwonloadSDKServiceInvalid");
        }
    };

    /* renamed from: l, reason: collision with root package name */
    protected long f341221l = 0;

    /* renamed from: m, reason: collision with root package name */
    protected long f341222m = 0;

    /* renamed from: n, reason: collision with root package name */
    protected final int f341223n = 1000;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.open.downloadnew.a f341224o = new b();

    /* renamed from: p, reason: collision with root package name */
    protected ITMAssistantDownloadLogListener f341225p = new c();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements com.tencent.open.downloadnew.a {
        b() {
        }

        @Override // com.tencent.open.downloadnew.a
        public void a(String str, int i3, String str2, boolean z16, Bundle bundle) {
            com.tencent.open.base.f.a("DownloadManager_", "receive get code finished pkgName|" + str + " versionCode|" + i3 + " code|" + str2 + " extraData|" + bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString("PackageName", str);
            bundle2.putString("Code", str2);
            bundle2.putInt("VersionCode", i3);
            bundle2.putBoolean("IsSuccess", z16);
            DownloadManager.this.o0(bundle2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class c implements ITMAssistantDownloadLogListener {

        /* renamed from: a, reason: collision with root package name */
        SimpleDateFormat f341265a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");

        c() {
        }

        @Override // com.tencent.tmdownloader.ITMAssistantDownloadLogListener
        public void onLog(ArrayList<TMAssistantDownloadLogInfo> arrayList) {
            if (arrayList == null && QLog.isColorLevel()) {
                QLog.i("DownloadManager_", 2, "logList is null");
            }
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = File.separator;
        sb5.append(str);
        sb5.append("tencent");
        sb5.append(str);
        sb5.append(".qqdownload");
        sb5.append(str);
        f341207q = sb5.toString();
        f341209s = new byte[1];
    }

    protected DownloadManager() {
        com.tencent.open.base.f.a("DownloadManager_", "DownloadManager create QQ5.0");
        this.f341211b = DownloaderGetCodeClient.i();
        this.f341218i = new PackageInstallReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        com.tencent.open.adapter.a.f().e().registerReceiver(this.f341218i, intentFilter);
        com.tencent.open.downloadnew.common.d.d().g(ThreadManager.getSubThreadHandler().getLooper());
        Y(WebViewDownloadListener.g());
        Y(com.tencent.open.downloadnew.common.d.d());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.2
            @Override // java.lang.Runnable
            public void run() {
                TMAssistantDownloadTaskInfo F;
                DownloadManager.this.f341216g = (ConcurrentHashMap) com.tencent.open.downloadnew.common.b.g().d();
                try {
                    DownloadInfo x16 = DownloadManager.this.x("com.tencent.mobileqq");
                    if (x16 != null && x16.J == 0) {
                        String str = "";
                        if (x16.E == 0) {
                            F = DownloadManager.this.F(x16.f341186f);
                            if (F != null) {
                                str = F.mSavePath;
                            }
                        } else {
                            F = DownloadManager.this.F(x16.F);
                            str = x16.L;
                        }
                        if (F == null) {
                            DownloadManager.this.f341216g.remove(x16.f341184e);
                            com.tencent.open.downloadnew.common.b.g().c(x16.f341184e);
                        } else if (F.mState == 4 && com.tencent.open.business.base.a.i(str) <= com.tencent.open.adapter.a.f().c()) {
                            DownloadManager.this.f341216g.remove(x16.f341184e);
                            com.tencent.open.downloadnew.common.b.g().c(x16.f341184e);
                        }
                    }
                } catch (Exception e16) {
                    com.tencent.open.base.f.d("DownloadManager_", "speical clear>>>", e16);
                }
            }
        }, 32, null, true);
    }

    public static DownloadManager C() {
        DownloadManager downloadManager;
        synchronized (DownloadManager.class) {
            if (f341208r == null) {
                try {
                    DownloadManager downloadManager2 = new DownloadManager();
                    f341208r = downloadManager2;
                    downloadManager2.f341212c = "open_sdkcom.tencent.mobileqq:web";
                    downloadManager2.H();
                    f341208r.k();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            downloadManager = f341208r;
        }
        return downloadManager;
    }

    public static synchronized boolean G() {
        boolean z16;
        synchronized (DownloadManager.class) {
            if (f341208r != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    private void O(final DownloadInfo downloadInfo) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TMAssistantDownloadTaskInfo F = DownloadManager.this.F(downloadInfo.F);
                    if (F != null) {
                        downloadInfo.L = F.mSavePath;
                        UpdateManager.d().f(downloadInfo);
                    }
                } catch (Exception e16) {
                    com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e16);
                }
            }
        });
    }

    private void V(DownloadInfo downloadInfo, String str, String str2) {
        boolean r16;
        if (downloadInfo.P != 4 && downloadInfo.f341183d0) {
            com.tencent.open.base.f.e("DownloadManager_", "isAutoInstallBySDK is true");
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                r16 = com.tencent.open.business.base.a.r(com.tencent.open.adapter.a.f().e(), str, downloadInfo.M, downloadInfo.e(LaunchParam.KEY_REF_ID), downloadInfo.e(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE));
                np3.a.g().i(100, downloadInfo);
            } else {
                return;
            }
        } else {
            r16 = com.tencent.open.business.base.a.r(com.tencent.open.adapter.a.f().e(), str, downloadInfo.M, downloadInfo.e(LaunchParam.KEY_REF_ID), downloadInfo.e(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE));
            np3.a.g().i(100, downloadInfo);
        }
        if (r16 && "com.tencent.mobileqq".equals(downloadInfo.f341189h)) {
            com.tencent.mobileqq.upgrade.e.e().l();
        }
        if (r16 && str2.equals(SDKConst.SELF_PACKAGENAME) && downloadInfo.f341184e.equals("1101070898")) {
            com.tencent.open.base.f.h("DownloadManager_", "report yyb start install");
            String c16 = com.tencent.open.business.base.e.c(downloadInfo.C, "NEWYYB");
            MyAppApi.z().L();
            String v3 = MyAppApi.z().v();
            if (TextUtils.isEmpty(v3)) {
                v3 = downloadInfo.f341184e;
            }
            com.tencent.open.business.base.e.h("311", c16, v3, downloadInfo.f341181c0);
            Context e16 = com.tencent.open.adapter.a.f().e();
            if (e16 != null) {
                com.tencent.open.business.base.e.j(e16, "312", c16, v3);
            }
        }
    }

    private void e0(final DownloadInfo downloadInfo) {
        String str;
        DownloadInfo downloadInfo2;
        String str2;
        DownloadInfo downloadInfo3;
        com.tencent.open.base.f.a("DownloadManager_", ">>startDownload downloadInfo:" + downloadInfo);
        if (downloadInfo.X) {
            ImageCache.c("app", com.tencent.open.base.d.d(downloadInfo.f341184e, 100), new a(downloadInfo));
        }
        final DownloadInfo w3 = w(downloadInfo.f341184e);
        if (w3 != null) {
            if (j(w3, downloadInfo)) {
                downloadInfo3 = w3;
            } else {
                downloadInfo3 = downloadInfo;
            }
            com.tencent.open.base.f.h("DownloadManager_", "startDownload() downloadInfo != null>>>downloadInfo.url=" + downloadInfo.f341186f + "downloadInfo.isAutoInstall" + downloadInfo.T + "+++++downloadInfo.downloadType=" + downloadInfo.E + "  test" + w(downloadInfo.f341184e));
            downloadInfo2 = downloadInfo3;
        } else {
            if (downloadInfo.S == 12) {
                str = TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID;
            } else {
                str = "900";
            }
            com.tencent.open.business.base.e.h(str, downloadInfo.C, downloadInfo.f341184e, downloadInfo.f341181c0);
            com.tencent.open.base.f.h("DownloadManager_", "+++++startDownload()+++++ downloadInfo == null>>>downloadInfo.url=" + downloadInfo.f341186f + "+++++downloadInfo.downloadType=" + downloadInfo.E);
            downloadInfo2 = downloadInfo;
        }
        e(downloadInfo2);
        if ("com.tencent.mobileqq".equals(downloadInfo2.f341189h) && J()) {
            g0(downloadInfo2);
        }
        final int i3 = downloadInfo2.E;
        if (i3 == 1) {
            str2 = downloadInfo2.F;
        } else {
            str2 = downloadInfo2.f341186f;
        }
        final String str3 = str2;
        final HashMap hashMap = new HashMap();
        hashMap.put(TMAssistantDownloadConst.PARAM_APPID, downloadInfo2.f341184e);
        hashMap.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, downloadInfo2.f341189h);
        hashMap.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(downloadInfo2.I));
        hashMap.put(TMAssistantDownloadConst.PARAM_VIA, downloadInfo2.C);
        hashMap.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, "qqNumber");
        hashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
        hashMap.put(TMAssistantDownloadConst.PARAM_ICON_URL, downloadInfo2.Y);
        hashMap.put(TMAssistantDownloadConst.PARAM_APP_NAME, downloadInfo2.f341191i);
        hashMap.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(downloadInfo2.Z));
        hashMap.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(downloadInfo2.f341183d0));
        hashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(downloadInfo2.f341187f0));
        final DownloadInfo downloadInfo4 = downloadInfo2;
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.11
            @Override // java.lang.Runnable
            public void run() {
                int startDownloadTask;
                int i16 = 3;
                if (!TextUtils.isEmpty(str3)) {
                    com.tencent.open.base.f.h("DownloadManager_", "startDownload download file, url = " + str3 + "params = " + hashMap);
                    try {
                        int i17 = i3;
                        if (i17 == 0) {
                            startDownloadTask = DownloadManager.this.D().startDownloadTask(str3, "application/vnd.android.package-archive", hashMap);
                        } else if (i17 == 1) {
                            hashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(3));
                            startDownloadTask = DownloadManager.this.D().startDownloadTask(str3, TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF, hashMap);
                        } else {
                            com.tencent.open.base.f.h("DownloadManager_", "startDownload download unapk file, url = " + str3 + ",filename = " + downloadInfo4.f341189h);
                            startDownloadTask = DownloadManager.this.D().startDownloadTask(str3, 0, TMAssistantDownloadContentType.CONTENT_TYPE_OTHERS, downloadInfo4.f341191i, hashMap);
                        }
                        i16 = startDownloadTask;
                    } catch (Exception e16) {
                        com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e16);
                    }
                }
                com.tencent.open.base.f.h("DownloadManager_", "startDownloadTask downloadSDKClient result=" + i16 + " url=" + str3);
                if (i16 != 0) {
                    DownloadManager.this.M(downloadInfo4, i16, "");
                } else {
                    DownloadInfo downloadInfo5 = w3;
                    DownloadInfo downloadInfo6 = downloadInfo4;
                    if (downloadInfo5 == downloadInfo6 && downloadInfo6.P == 20) {
                        DownloadManager.this.K(20, downloadInfo4);
                    }
                }
                DownloadInfoReport.g(1, str3, i16, downloadInfo);
            }
        });
        try {
            DownloadInfoReport.e(this.f341213d.get(), downloadInfo2);
        } catch (Throwable unused) {
        }
    }

    public static int o(int i3) {
        switch (i3) {
            case 1:
                return 20;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return -2;
            case 6:
                return 10;
            default:
                return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(final Bundle bundle) {
        com.tencent.open.base.f.a("DownloadManager_", "receive write code msg......");
        if (bundle == null) {
            com.tencent.open.base.f.a("DownloadManager_", "receive write code msg but data is null......");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.21
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    try {
                        String string = bundle.getString("PackageName");
                        com.tencent.open.base.f.a("DownloadManager_", "receive write code msg pkgName|" + string);
                        if (string == null) {
                            return;
                        }
                        DownloadInfo x16 = DownloadManager.this.x(string);
                        if (x16 == null) {
                            com.tencent.open.base.f.a("DownloadManager_", "receive write code msg pkgName|" + string + " download info is null");
                            return;
                        }
                        String string2 = bundle.getString("Code");
                        com.tencent.open.base.f.a("DownloadManager_", "receive write code msg pkgName|" + string + " code|" + string2);
                        if (TextUtils.isEmpty(string2)) {
                            x16.k(4);
                            x16.f341179a0 = 0;
                            DownloadManager.this.e(x16);
                            DownloadManager.this.K(4, x16);
                            DownloadManager.this.Z(x16, x16.f341180b0);
                            com.tencent.open.business.base.e.h(IndividuationPlugin.Business_Font, x16.C, x16.f341184e, x16.f341181c0);
                            if (x16.T) {
                                DownloadManager.this.I(x16);
                                return;
                            }
                            return;
                        }
                        bundle.getInt("VersionCode");
                        File file = new File(x16.L);
                        try {
                            com.tencent.securitysdk.utils.a.j(file, string2);
                            String f16 = com.tencent.securitysdk.utils.a.f(file);
                            com.tencent.open.base.f.a("DownloadManager_", "receive write code msg pkgName|" + string + " check code|" + f16);
                            z16 = string2.equals(f16);
                        } catch (IOException e16) {
                            com.tencent.open.base.f.a("DownloadManager_", "write code Exception|" + e16.getMessage());
                            z16 = false;
                        }
                        if (z16) {
                            com.tencent.open.base.f.a("DownloadManager_", "receive write code msg pkgName|" + string + " write code and check code suc");
                            x16.f341179a0 = 0;
                            DownloadManager.this.e(x16);
                            DownloadManager.this.K(4, x16);
                            DownloadManager.this.Z(x16, x16.f341180b0);
                            com.tencent.open.business.base.e.h(IndividuationPlugin.Business_Font, x16.C, x16.f341184e, x16.f341181c0);
                            if (x16.T) {
                                DownloadManager.this.I(x16);
                                return;
                            }
                            return;
                        }
                        com.tencent.open.base.f.a("DownloadManager_", "receive write code msg pkgName|" + string + " write code or check code fail");
                        x16.f341179a0 = -20;
                        x16.P = -2;
                        DownloadManager.this.e(x16);
                        DownloadManager.this.M(x16, x16.f341179a0, null);
                    } catch (Exception e17) {
                        com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e17);
                    }
                }
            }, 32, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(final DownloadInfo downloadInfo) {
        com.tencent.open.base.f.a("DownloadManager_", "receive get code msg......");
        if (downloadInfo == null) {
            com.tencent.open.base.f.a("DownloadManager_", "receive get code msg but info is null......");
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.20
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.tencent.open.base.f.a("DownloadManager_", downloadInfo.f341189h + " begin getApkCode ......");
                        DownloaderGetCodeClient downloaderGetCodeClient = DownloadManager.this.f341211b;
                        DownloadInfo downloadInfo2 = downloadInfo;
                        downloaderGetCodeClient.g(downloadInfo2.f341189h, downloadInfo2.I, DownloadManager.this.f341224o);
                    } catch (Exception e16) {
                        com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e16);
                    }
                }
            });
        }
    }

    public List<DownloadInfo> A(String str) {
        if (str == null) {
            return null;
        }
        com.tencent.open.base.f.h("DownloadManager_", "getDownloadInfoById via == " + str);
        ArrayList arrayList = new ArrayList();
        for (DownloadInfo downloadInfo : this.f341216g.values()) {
            if (!TextUtils.isEmpty(downloadInfo.C) && downloadInfo.C.equals(str)) {
                arrayList.add(downloadInfo);
            }
        }
        com.tencent.open.base.f.h("DownloadManager_", "getDownloadInfoByVia result =" + arrayList);
        return arrayList;
    }

    protected synchronized List<DownloadInfo> B(int i3) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (DownloadInfo downloadInfo : this.f341216g.values()) {
            if (downloadInfo.f() == i3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    public TMAssistantDownloadClient D() {
        TMAssistantDownloadManager.getInstance(com.tencent.open.adapter.a.f().e()).getDownloadSDKClient(this.f341212c).registerDownloadTaskListener(this.f341220k);
        if (QLog.isColorLevel()) {
            QLog.i("DownloadManager_", 2, "registerLogListener!");
            TMAssistantDownloadManager.getInstance(com.tencent.open.adapter.a.f().e()).getDownloadSDKClient(this.f341212c).registerLogListener(this.f341225p);
        }
        if (!this.f341219j) {
            try {
                TMAssistantDownloadSettingClient downloadSDKSettingClient = TMAssistantDownloadManager.getInstance(com.tencent.open.adapter.a.f().e()).getDownloadSDKSettingClient();
                if (downloadSDKSettingClient != null) {
                    downloadSDKSettingClient.setDownloadSDKMaxTaskNum(3);
                    this.f341219j = true;
                }
            } catch (Exception e16) {
                com.tencent.open.base.f.c("DownloadManager_", "exception: " + e16.toString());
            }
        }
        TMAssistantDownloadClient downloadSDKClient = TMAssistantDownloadManager.getInstance(com.tencent.open.adapter.a.f().e()).getDownloadSDKClient(this.f341212c);
        this.f341210a = downloadSDKClient;
        return downloadSDKClient;
    }

    public TMAssistantDownloadTaskInfo E(DownloadInfo downloadInfo) {
        Bundle bundle = new Bundle();
        bundle.putString(e.f341493b, downloadInfo.f341184e);
        bundle.putString(e.f341494c, downloadInfo.G);
        bundle.putString(e.f341495d, downloadInfo.H);
        bundle.putString(e.f341497f, downloadInfo.f341189h);
        bundle.putInt(e.f341496e, downloadInfo.I);
        bundle.putString(e.f341500i, downloadInfo.C);
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
        try {
            com.tencent.open.base.f.h("State_Log", "OpenSDK getTaskInfoFromMyApp param SNGAppId=" + downloadInfo.f341184e + " apkId=" + downloadInfo.H + " taskAppId=" + downloadInfo.G + " packageName=" + downloadInfo.f341189h + " version=" + downloadInfo.I + " via=" + downloadInfo.C);
            tMAssistantDownloadTaskInfo = MyAppApi.z().y(bundle);
            if (tMAssistantDownloadTaskInfo != null) {
                com.tencent.open.base.f.h("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo path=" + tMAssistantDownloadTaskInfo.mSavePath + " state=" + tMAssistantDownloadTaskInfo.mState);
            } else {
                com.tencent.open.base.f.h("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo is null");
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.b("DownloadManager_", "getTaskInfoFromMyApp>>>", e16);
        }
        return tMAssistantDownloadTaskInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TMAssistantDownloadTaskInfo F(String str) {
        TMAssistantDownloadTaskInfo downloadTaskState;
        if (!TextUtils.isEmpty(str)) {
            try {
                downloadTaskState = D().getDownloadTaskState(str);
            } catch (Exception e16) {
                com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e16);
            }
            if (downloadTaskState == null) {
                com.tencent.open.base.f.h("DownloadManager_", "getTaskInfoFromSDK null url=" + str);
            }
            return downloadTaskState;
        }
        downloadTaskState = null;
        if (downloadTaskState == null) {
        }
        return downloadTaskState;
    }

    protected void H() {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.3
            @Override // java.lang.Runnable
            public void run() {
                ConcurrentHashMap<String, a.C9279a> h16;
                DownloadInfo w3;
                TMAssistantDownloadTaskInfo F;
                String j3 = com.tencent.open.business.base.a.j(com.tencent.open.adapter.a.f().e());
                if (!TextUtils.isEmpty(j3) && !j3.contains(":") && (h16 = com.tencent.open.downloadnew.common.a.e().h()) != null) {
                    Iterator<String> it = h16.keySet().iterator();
                    while (it.hasNext()) {
                        a.C9279a c9279a = h16.get(it.next());
                        if (c9279a != null && (w3 = DownloadManager.this.w(c9279a.f341463b)) != null && !TextUtils.isEmpty(w3.f341186f) && (F = DownloadManager.this.F(w3.f341186f)) != null && 4 != DownloadManager.o(F.mState)) {
                            com.tencent.open.downloadnew.common.a.e().a(c9279a.f341462a);
                        }
                    }
                }
            }
        }, 5000L);
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.4
            @Override // java.lang.Runnable
            public void run() {
                String str;
                Context e16 = com.tencent.open.adapter.a.f().e();
                boolean z16 = e16.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false);
                SimpleAccount firstSimpleAccount = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
                if (firstSimpleAccount != null) {
                    str = firstSimpleAccount.getUin();
                } else {
                    str = "";
                }
                String str2 = str;
                if (!z16) {
                    com.tencent.open.base.f.a("DownloadManager_", "getUpdateApp will do full report");
                    com.tencent.open.business.base.appreport.a.a(e16, null, null, str2, true);
                    return;
                }
                if (new File(e16.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists()) {
                    com.tencent.open.base.f.a("DownloadManager_", "getUpdateApp will do incremental report");
                    com.tencent.open.business.base.appreport.a.b(e16, null, 0, null, null, str2);
                }
            }
        }, 10000L);
    }

    public void I(DownloadInfo downloadInfo) {
        String str;
        if (downloadInfo == null) {
            com.tencent.open.base.f.h("DownloadManager_", "installDownload info == null");
            return;
        }
        if (!downloadInfo.X) {
            com.tencent.open.base.f.h("DownloadManager_", "installDownload info is not apk");
            return;
        }
        if (TextUtils.isEmpty(downloadInfo.L)) {
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
            if (downloadInfo.J == 0) {
                TMAssistantDownloadTaskInfo F = F(downloadInfo.f341186f);
                if (F == null || F.mState != 4) {
                    str = "";
                } else {
                    str = F.mSavePath;
                }
                if (TextUtils.isEmpty(str)) {
                    tMAssistantDownloadTaskInfo = E(downloadInfo);
                }
            } else {
                TMAssistantDownloadTaskInfo E = E(downloadInfo);
                if (E == null || E.mState != 4) {
                    str = "";
                } else {
                    str = E.mSavePath;
                }
                if (TextUtils.isEmpty(str)) {
                    tMAssistantDownloadTaskInfo = F(downloadInfo.f341186f);
                }
            }
            if (tMAssistantDownloadTaskInfo != null && tMAssistantDownloadTaskInfo.mState == 4) {
                str = tMAssistantDownloadTaskInfo.mSavePath;
            }
            if (!TextUtils.isEmpty(str)) {
                downloadInfo.L = str;
                downloadInfo.k(4);
                e(downloadInfo);
            }
        } else {
            str = downloadInfo.L;
        }
        String e16 = com.tencent.open.business.base.a.e(str);
        com.tencent.open.base.f.h("DownloadManager_", "installDownload localAPKPath=" + str + ", apkPackageName=" + e16 + " updateType=" + downloadInfo.E);
        Log.v("DownloadManager_", "installDownload localAPKPath=" + str + ", apkPackageName=" + e16 + " updateType=" + downloadInfo.E);
        if (e16 != null) {
            com.tencent.open.base.f.a("DownloadManager_", "[installDownload] begin sendCheckDownloadReq pkgname=" + e16);
            V(downloadInfo, str, e16);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            com.tencent.open.base.f.h("DownloadManager_", "package invaild del file");
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
        L(-2, downloadInfo, -24, "");
    }

    public boolean J() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    public void K(int i3, DownloadInfo downloadInfo) {
        L(i3, downloadInfo, 0, "");
    }

    public synchronized void L(int i3, DownloadInfo downloadInfo, int i16, String str) {
        if (downloadInfo == null) {
            com.tencent.open.base.f.c("DownloadManager_", "notifyListener info == null id=" + i3);
            return;
        }
        if (i3 != -2) {
            if (i3 != 6) {
                if (i3 != 13) {
                    if (i3 != 20) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    if (i3 != 9) {
                                        if (i3 == 10) {
                                            com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lry) + this.f341217h.size());
                                            this.f341216g.remove(downloadInfo.f341184e);
                                            com.tencent.open.downloadnew.common.b.g().c(downloadInfo.f341184e);
                                            com.tencent.open.downloadnew.common.a.e().a(downloadInfo.f341196m);
                                            downloadInfo.k(10);
                                            com.tencent.open.base.f.h("DownloadManager_", "downloadInfo.state = " + downloadInfo.f());
                                            Iterator<DownloadListener> it = this.f341217h.iterator();
                                            while (it.hasNext()) {
                                                it.next().onDownloadCancel(downloadInfo);
                                            }
                                        }
                                    } else {
                                        com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.ls6) + this.f341217h.size());
                                        Iterator<DownloadListener> it5 = this.f341217h.iterator();
                                        while (it5.hasNext()) {
                                            it5.next().uninstallSucceed(downloadInfo.f341184e, downloadInfo.f341189h);
                                        }
                                    }
                                } else {
                                    com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lrv) + this.f341217h.size());
                                    Iterator<DownloadListener> it6 = this.f341217h.iterator();
                                    while (it6.hasNext()) {
                                        it6.next().onDownloadFinish(downloadInfo);
                                    }
                                    DownloadInfoReport.g(2, null, 100, downloadInfo);
                                }
                            } else {
                                com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lrp) + this.f341217h.size());
                                Iterator<DownloadListener> it7 = this.f341217h.iterator();
                                while (it7.hasNext()) {
                                    it7.next().onDownloadPause(downloadInfo);
                                }
                            }
                        } else if (downloadInfo.J == 1 || System.currentTimeMillis() - this.f341221l > 1000) {
                            this.f341221l = System.currentTimeMillis();
                            com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lrg) + this.f341217h.size());
                            List<DownloadInfo> B = B(2);
                            com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lro) + B.size());
                            Iterator<DownloadListener> it8 = this.f341217h.iterator();
                            while (it8.hasNext()) {
                                DownloadListener next = it8.next();
                                com.tencent.open.base.f.h("DownloadManager_", "###\u4e0b\u8f7d1 listner name" + next.getClass().getName());
                                next.onDownloadUpdate(B);
                            }
                        }
                    } else {
                        com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.f171903ls1) + this.f341217h.size());
                        Iterator<DownloadListener> it9 = this.f341217h.iterator();
                        while (it9.hasNext()) {
                            it9.next().onDownloadWait(downloadInfo);
                        }
                    }
                } else {
                    com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lrl) + this.f341217h.size());
                    Iterator<DownloadListener> it10 = this.f341217h.iterator();
                    while (it10.hasNext()) {
                        it10.next().packageReplaced(downloadInfo.f341184e, downloadInfo.f341189h);
                    }
                }
            } else {
                com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lrz) + this.f341217h.size());
                Iterator<DownloadListener> it11 = this.f341217h.iterator();
                while (it11.hasNext()) {
                    it11.next().installSucceed(downloadInfo.f341184e, downloadInfo.f341189h);
                }
            }
        } else {
            M(downloadInfo, i16, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0079. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01b5 A[Catch: Exception -> 0x013d, LOOP:0: B:35:0x01af->B:37:0x01b5, LOOP_END, TryCatch #0 {Exception -> 0x013d, blocks: (B:11:0x004d, B:29:0x0079, B:30:0x007c, B:31:0x007f, B:32:0x0082, B:33:0x0085, B:34:0x0187, B:35:0x01af, B:37:0x01b5, B:39:0x01bf, B:41:0x01c5, B:44:0x0093, B:45:0x00a4, B:46:0x00b5, B:47:0x00c6, B:49:0x00d4, B:51:0x00dd, B:53:0x00e1, B:55:0x00e7, B:57:0x00fe, B:59:0x0106, B:61:0x010a, B:63:0x0113, B:64:0x0120, B:65:0x0130, B:67:0x0141, B:70:0x0150, B:71:0x016f, B:73:0x0176, B:75:0x017d, B:77:0x0179, B:78:0x0160), top: B:10:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c5 A[Catch: Exception -> 0x013d, TRY_LEAVE, TryCatch #0 {Exception -> 0x013d, blocks: (B:11:0x004d, B:29:0x0079, B:30:0x007c, B:31:0x007f, B:32:0x0082, B:33:0x0085, B:34:0x0187, B:35:0x01af, B:37:0x01b5, B:39:0x01bf, B:41:0x01c5, B:44:0x0093, B:45:0x00a4, B:46:0x00b5, B:47:0x00c6, B:49:0x00d4, B:51:0x00dd, B:53:0x00e1, B:55:0x00e7, B:57:0x00fe, B:59:0x0106, B:61:0x010a, B:63:0x0113, B:64:0x0120, B:65:0x0130, B:67:0x0141, B:70:0x0150, B:71:0x016f, B:73:0x0176, B:75:0x017d, B:77:0x0179, B:78:0x0160), top: B:10:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093 A[Catch: Exception -> 0x013d, TryCatch #0 {Exception -> 0x013d, blocks: (B:11:0x004d, B:29:0x0079, B:30:0x007c, B:31:0x007f, B:32:0x0082, B:33:0x0085, B:34:0x0187, B:35:0x01af, B:37:0x01b5, B:39:0x01bf, B:41:0x01c5, B:44:0x0093, B:45:0x00a4, B:46:0x00b5, B:47:0x00c6, B:49:0x00d4, B:51:0x00dd, B:53:0x00e1, B:55:0x00e7, B:57:0x00fe, B:59:0x0106, B:61:0x010a, B:63:0x0113, B:64:0x0120, B:65:0x0130, B:67:0x0141, B:70:0x0150, B:71:0x016f, B:73:0x0176, B:75:0x017d, B:77:0x0179, B:78:0x0160), top: B:10:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0113 A[Catch: Exception -> 0x013d, TryCatch #0 {Exception -> 0x013d, blocks: (B:11:0x004d, B:29:0x0079, B:30:0x007c, B:31:0x007f, B:32:0x0082, B:33:0x0085, B:34:0x0187, B:35:0x01af, B:37:0x01b5, B:39:0x01bf, B:41:0x01c5, B:44:0x0093, B:45:0x00a4, B:46:0x00b5, B:47:0x00c6, B:49:0x00d4, B:51:0x00dd, B:53:0x00e1, B:55:0x00e7, B:57:0x00fe, B:59:0x0106, B:61:0x010a, B:63:0x0113, B:64:0x0120, B:65:0x0130, B:67:0x0141, B:70:0x0150, B:71:0x016f, B:73:0x0176, B:75:0x017d, B:77:0x0179, B:78:0x0160), top: B:10:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0130 A[Catch: Exception -> 0x013d, TryCatch #0 {Exception -> 0x013d, blocks: (B:11:0x004d, B:29:0x0079, B:30:0x007c, B:31:0x007f, B:32:0x0082, B:33:0x0085, B:34:0x0187, B:35:0x01af, B:37:0x01b5, B:39:0x01bf, B:41:0x01c5, B:44:0x0093, B:45:0x00a4, B:46:0x00b5, B:47:0x00c6, B:49:0x00d4, B:51:0x00dd, B:53:0x00e1, B:55:0x00e7, B:57:0x00fe, B:59:0x0106, B:61:0x010a, B:63:0x0113, B:64:0x0120, B:65:0x0130, B:67:0x0141, B:70:0x0150, B:71:0x016f, B:73:0x0176, B:75:0x017d, B:77:0x0179, B:78:0x0160), top: B:10:0x004d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void M(final DownloadInfo downloadInfo, int i3, String str) {
        final String str2;
        int i16;
        Iterator<DownloadListener> it;
        this.f341219j = false;
        if (downloadInfo == null) {
            com.tencent.open.base.f.i("DownloadManager_", "handleDownloadErrorCallBack info == null code = " + i3 + " msg = " + str);
            return;
        }
        com.tencent.open.base.f.i("DownloadManager_", "handleDownloadErrorCallBack code = " + i3 + " msg = " + str);
        if (i3 >= 400 && i3 <= 599) {
            try {
                str = com.tencent.open.adapter.a.f().e().getString(R.string.cob);
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        if (i3 != -51) {
            i16 = 3;
            if (i3 != -40 && i3 != -30) {
                if (i3 != -24) {
                    if (i3 != -20 && i3 != -10) {
                        switch (i3) {
                            case -1:
                                break;
                            case 0:
                            case 5:
                                return;
                            case 1:
                                str = com.tencent.open.adapter.a.f().e().getString(R.string.cob);
                                downloadInfo.k(i16);
                                com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lru) + this.f341217h.size());
                                it = this.f341217h.iterator();
                                while (it.hasNext()) {
                                    it.next().onDownloadError(downloadInfo, i3, str, i16);
                                }
                                if (TextUtils.isEmpty(str)) {
                                    c0(str);
                                    return;
                                }
                                return;
                            case 2:
                                str = com.tencent.open.adapter.a.f().e().getString(R.string.cog);
                                downloadInfo.k(i16);
                                com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lru) + this.f341217h.size());
                                it = this.f341217h.iterator();
                                while (it.hasNext()) {
                                }
                                if (TextUtils.isEmpty(str)) {
                                }
                                break;
                            case 3:
                                str = com.tencent.open.adapter.a.f().e().getString(R.string.co7);
                                downloadInfo.k(i16);
                                com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lru) + this.f341217h.size());
                                it = this.f341217h.iterator();
                                while (it.hasNext()) {
                                }
                                if (TextUtils.isEmpty(str)) {
                                }
                                break;
                            case 4:
                                com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lrj));
                                String str3 = downloadInfo.f341189h;
                                if (str3 != null && "com.tencent.mobileqq".equals(str3) && downloadInfo.E != 1 && J()) {
                                    com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lrk));
                                    ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.6
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            TMAssistantDownloadTaskInfo F = DownloadManager.this.F(downloadInfo.f341186f);
                                            if (F != null) {
                                                downloadInfo.L = F.mSavePath;
                                            }
                                            DownloadInfo downloadInfo2 = downloadInfo;
                                            downloadInfo2.f341179a0 = DownloadManager.this.p0(downloadInfo2);
                                            if (downloadInfo.f341179a0 != 0) {
                                                com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lrn));
                                                downloadInfo.P = -2;
                                                downloadInfo.Q = 100;
                                                DownloadManager downloadManager = DownloadManager.this;
                                                DownloadInfo downloadInfo3 = downloadInfo;
                                                downloadManager.M(downloadInfo3, downloadInfo3.f341179a0, null);
                                                return;
                                            }
                                            com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lsb));
                                            downloadInfo.P = 4;
                                            downloadInfo.Q = 100;
                                            DownloadManager.this.n(downloadInfo);
                                        }
                                    });
                                    return;
                                }
                                downloadInfo.k(4);
                                if (downloadInfo.E == 1) {
                                    O(downloadInfo);
                                    return;
                                } else {
                                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.7
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                TMAssistantDownloadTaskInfo F = DownloadManager.this.F(downloadInfo.f341186f);
                                                if (F != null) {
                                                    com.tencent.open.base.f.a("DownloadManager_", "onDownloadError taskInfo != null\uff01info.writeCodeState = " + downloadInfo.f341179a0);
                                                    DownloadInfo downloadInfo2 = downloadInfo;
                                                    downloadInfo2.L = F.mSavePath;
                                                    downloadInfo2.f341180b0 = F.mTotalDataLen;
                                                    DownloadManager.this.e(downloadInfo2);
                                                    DownloadInfo downloadInfo3 = downloadInfo;
                                                    if (downloadInfo3.f341179a0 == 0) {
                                                        DownloadManager.this.K(4, downloadInfo3);
                                                        if (!downloadInfo.f341184e.equals("1101070898")) {
                                                            DownloadManager.this.Z(downloadInfo, F.mTotalDataLen);
                                                        }
                                                    } else {
                                                        com.tencent.open.base.f.a("DownloadManager_", "onDownloadError taskInfo == null");
                                                        DownloadManager.this.t(downloadInfo);
                                                        return;
                                                    }
                                                }
                                            } catch (Exception e17) {
                                                com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e17);
                                            }
                                            DownloadInfo downloadInfo4 = downloadInfo;
                                            com.tencent.open.business.base.e.h(IndividuationPlugin.Business_Font, downloadInfo4.C, downloadInfo4.f341184e, downloadInfo4.f341181c0);
                                            DownloadInfo downloadInfo5 = downloadInfo;
                                            if (downloadInfo5.T) {
                                                DownloadManager.this.I(downloadInfo5);
                                            }
                                        }
                                    }, 32, null, true);
                                    return;
                                }
                            default:
                                switch (i3) {
                                    case 600:
                                    case 604:
                                        break;
                                    case 601:
                                    case 602:
                                    case 603:
                                    case 605:
                                    case 606:
                                        break;
                                    case 607:
                                        str = com.tencent.open.adapter.a.f().e().getString(R.string.cof);
                                        break;
                                    default:
                                        switch (i3) {
                                            case 700:
                                            case 704:
                                            case 705:
                                                break;
                                            case 701:
                                            case 702:
                                            case 706:
                                            case 707:
                                            case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK /* 708 */:
                                            case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES /* 709 */:
                                                break;
                                            case 703:
                                            case 711:
                                                str = com.tencent.open.adapter.a.f().e().getString(R.string.coi);
                                                break;
                                            case 710:
                                                str = com.tencent.open.adapter.a.f().e().getString(R.string.cod);
                                                break;
                                            case TMAssistantDownloadErrorCode.DOWNLOAD_ERR_KNOWN_LENGTH_CHECK_ERROR /* 712 */:
                                                break;
                                            default:
                                                switch (i3) {
                                                    case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH /* 730 */:
                                                        break;
                                                    case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY /* 731 */:
                                                    case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION /* 732 */:
                                                        break;
                                                    default:
                                                        str = com.tencent.open.adapter.a.f().e().getString(R.string.co7);
                                                        break;
                                                }
                                        }
                                }
                                downloadInfo.k(i16);
                                com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lru) + this.f341217h.size());
                                it = this.f341217h.iterator();
                                while (it.hasNext()) {
                                }
                                if (TextUtils.isEmpty(str)) {
                                }
                                break;
                        }
                    }
                }
            }
            com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.ls7));
            downloadInfo.k(i16);
            com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lru) + this.f341217h.size());
            it = this.f341217h.iterator();
            while (it.hasNext()) {
            }
            if (TextUtils.isEmpty(str)) {
            }
        }
        if (i3 == 712) {
            str = com.tencent.open.adapter.a.f().e().getString(R.string.co9);
        } else {
            str = com.tencent.open.adapter.a.f().e().getString(R.string.co_);
        }
        com.tencent.mobileqq.upgrade.banner.b.f(false);
        if (downloadInfo.E == 1) {
            str2 = downloadInfo.F;
        } else {
            str2 = downloadInfo.f341186f;
        }
        if (str2 != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DownloadManager.this.D().cancelDownloadTask(str2);
                        DownloadManager.this.f341216g.remove(downloadInfo.f341184e);
                        com.tencent.open.downloadnew.common.b.g().c(downloadInfo.f341184e);
                    } catch (Exception e17) {
                        com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e17);
                    }
                }
            }, 32, null, true);
        }
        i16 = 10;
        downloadInfo.k(i16);
        com.tencent.open.base.f.h("DownloadManager_", HardCodeUtil.qqStr(R.string.lru) + this.f341217h.size());
        it = this.f341217h.iterator();
        while (it.hasNext()) {
        }
        if (TextUtils.isEmpty(str)) {
        }
    }

    public void N(DownloadInfo downloadInfo) {
        com.tencent.open.base.f.a("DownloadManager_", "onReveiveInstallIntent info=" + downloadInfo);
        if (downloadInfo.J == 0) {
            com.tencent.open.business.base.e.h("310", downloadInfo.C, downloadInfo.f341184e, downloadInfo.f341181c0);
        }
        if (!"5".equals(downloadInfo.M)) {
            m(downloadInfo.f341184e, false);
        }
        com.tencent.open.downloadnew.common.a.e().a(downloadInfo.f341196m);
    }

    public void P(DownloadInfo downloadInfo) {
        com.tencent.open.base.f.a("DownloadManager_", "patchNewApkSuccess DownloadInfo|" + downloadInfo);
        t(downloadInfo);
    }

    public int Q(String str) {
        final String str2;
        DownloadInfo w3 = w(str);
        if (w3 != null) {
            if (w3.E == 1) {
                str2 = w3.F;
            } else {
                str2 = w3.f341186f;
            }
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DownloadManager.this.D().pauseDownloadTask(str2);
                    } catch (Exception e16) {
                        com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e16);
                    }
                }
            });
            com.tencent.open.base.f.h("DownloadManager_", "pause url=" + str2 + ", appid=" + str);
            return 0;
        }
        return 0;
    }

    public synchronized void R() {
        for (DownloadInfo downloadInfo : this.f341216g.values()) {
            if (downloadInfo != null && (downloadInfo.f() == 2 || downloadInfo.f() == 20)) {
                Q(downloadInfo.f341184e);
            }
        }
    }

    public synchronized void S() {
        for (DownloadInfo downloadInfo : this.f341216g.values()) {
            if (downloadInfo != null && downloadInfo.J == 1 && (downloadInfo.f() == 2 || downloadInfo.f() == 20)) {
                downloadInfo.k(3);
                K(3, downloadInfo);
            }
        }
    }

    public List<DownloadInfo> T(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        List<DownloadInfo> A = A(str);
        if (A != null && A.size() > 0) {
            for (DownloadInfo downloadInfo : A) {
                if (downloadInfo != null) {
                    if (downloadInfo.J == 0) {
                        if (downloadInfo.E == 1) {
                            str2 = downloadInfo.F;
                        } else {
                            str2 = downloadInfo.f341186f;
                        }
                        TMAssistantDownloadTaskInfo F = C().F(str2);
                        if (F != null) {
                            com.tencent.open.base.f.h("DownloadManager_", "queryDownloadInfosByVia sdk getReceiveDataLen=" + F.mReceiveDataLen + " getTotalDataLen=" + F.mTotalDataLen);
                            downloadInfo.Q = (int) ((((float) F.mReceiveDataLen) * 100.0f) / ((float) F.mTotalDataLen));
                            downloadInfo.f341180b0 = F.mTotalDataLen;
                            downloadInfo.k(o(F.mState));
                            if (downloadInfo.E == 1) {
                                if (TextUtils.isEmpty(downloadInfo.L)) {
                                    downloadInfo.L = F.mSavePath;
                                }
                            } else {
                                downloadInfo.L = F.mSavePath;
                            }
                            arrayList.add(downloadInfo);
                        } else {
                            this.f341216g.remove(downloadInfo.f341184e);
                            com.tencent.open.downloadnew.common.b.g().c(downloadInfo.f341184e);
                        }
                    } else {
                        this.f341216g.remove(downloadInfo.f341184e);
                        com.tencent.open.downloadnew.common.b.g().c(downloadInfo.f341184e);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized ConcurrentLinkedQueue<DownloadListener> U() {
        return this.f341217h;
    }

    public boolean W(DownloadInfo downloadInfo) {
        String str;
        com.tencent.open.base.f.h("DownloadManager_", "refreshDownloadInfo DownloadInfo=" + downloadInfo);
        DownloadInfo w3 = w(downloadInfo.f341184e);
        if (w3 != null) {
            com.tencent.open.base.f.h("DownloadManager_", "refreshDownloadInfo cacheInfo =" + w3);
            int i3 = w3.J;
            int i16 = 3;
            if (i3 == 0) {
                com.tencent.open.base.f.h("DownloadManager_", "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
                downloadInfo.W = w3.W;
                if (w3.E == 1) {
                    str = w3.F;
                } else {
                    str = w3.f341186f;
                }
                TMAssistantDownloadTaskInfo F = C().F(str);
                if (F != null) {
                    com.tencent.open.base.f.h("DownloadManager_", "refreshDownloadInfo sdk getReceiveDataLen=" + F.mReceiveDataLen + " getTotalDataLen=" + F.mTotalDataLen);
                    downloadInfo.Q = (int) ((((float) F.mReceiveDataLen) * 100.0f) / ((float) F.mTotalDataLen));
                    downloadInfo.f341180b0 = F.mTotalDataLen;
                    downloadInfo.k(o(F.mState));
                    downloadInfo.J = 0;
                    if (w3.E == 1) {
                        if (TextUtils.isEmpty(w3.L)) {
                            downloadInfo.L = F.mSavePath;
                        } else {
                            downloadInfo.L = w3.L;
                        }
                    } else {
                        downloadInfo.L = F.mSavePath;
                    }
                    if (downloadInfo.P == 4) {
                        int i17 = w3.f341179a0;
                        downloadInfo.f341179a0 = i17;
                        if (i17 != 0) {
                            downloadInfo.P = 3;
                            e(w3);
                        }
                    }
                    return true;
                }
                this.f341216g.remove(w3.f341184e);
                com.tencent.open.downloadnew.common.b.g().c(w3.f341184e);
                downloadInfo.P = -100;
                return true;
            }
            if (i3 == 1) {
                TMAssistantDownloadTaskInfo E = E(w3);
                if (E != null) {
                    int o16 = o(E.mState);
                    if (o16 != -2) {
                        i16 = o16;
                    }
                    downloadInfo.k(i16);
                    downloadInfo.J = 1;
                    downloadInfo.L = E.mSavePath;
                    long j3 = E.mReceiveDataLen;
                    long j16 = E.mTotalDataLen;
                    downloadInfo.Q = (int) ((((float) j3) * 100.0f) / ((float) j16));
                    downloadInfo.f341180b0 = j16;
                    if (!MyAppApi.z().R()) {
                        downloadInfo.Q = 0;
                    }
                    return true;
                }
                this.f341216g.remove(w3.f341184e);
                com.tencent.open.downloadnew.common.b.g().c(w3.f341184e);
            }
        }
        return false;
    }

    public boolean X(com.tencent.open.downloadnew.b bVar) {
        if (bVar == null) {
            return false;
        }
        this.f341215f = bVar;
        return true;
    }

    public synchronized void Y(DownloadListener downloadListener) {
        if (!this.f341217h.contains(downloadListener)) {
            this.f341217h.add(downloadListener);
        }
    }

    public void Z(DownloadInfo downloadInfo, long j3) {
        int i3;
        Bundle bundle;
        if (u() != null && u().get() != null && u().get() != null) {
            if ("biz_src_yyb".equals(downloadInfo.M)) {
                i3 = 14;
            } else if ("biz_src_zf_games".equals(downloadInfo.M)) {
                i3 = 15;
            } else if ("biz_src_jc_update".equals(downloadInfo.M)) {
                i3 = 17;
            } else if ("biz_src_news".equals(downloadInfo.M)) {
                i3 = 18;
            } else if ("biz_src_jc_vip".equals(downloadInfo.M) || !AdDownloadConstants.DOWNLOAD_SOURCE_AD.equals(downloadInfo.M)) {
                i3 = 40;
            } else {
                return;
            }
            if (!TextUtils.isEmpty(downloadInfo.f341191i)) {
                bundle = new Bundle();
                bundle.putString("appname", downloadInfo.f341191i + ".apk");
            } else {
                bundle = null;
            }
            com.tencent.open.base.f.a("DownloadManager_", "reportDownloadResult info.packageName = " + downloadInfo.f341189h + ",info.urlStr = " + downloadInfo.f341186f + ",info.filePath = " + downloadInfo.L);
            Intent intent = new Intent("com.opensdk.downloadmanager.renameFilename");
            Bundle bundle2 = new Bundle();
            bundle2.putString("filePath", downloadInfo.L);
            bundle2.putLong("dataLength", j3);
            bundle2.putInt("fileSourceId", i3);
            bundle2.putBundle("otherData", bundle);
            bundle2.putInt("peerType", -1);
            intent.putExtra("extraBundle", bundle2);
            com.tencent.open.adapter.a.f().e().sendBroadcast(intent);
        }
    }

    public void a0(String str, long j3, String str2) {
        String[] strArr;
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
            if ("biz_src_yyb".equals(str2)) {
                strArr = new String[]{AppConstants.FlowStatPram.PARAM_WIFIAPP_CENTER_DEFAULT_DOWNLOAD_FLOW, "param_WIFIFlow", "param_Flow"};
            } else if ("biz_src_jc_update".equals(str2)) {
                strArr = new String[]{AppConstants.FlowStatPram.PARAM_WIFIAPP_CENTER_QQUPDATE_DOWNLOAD_FLOW, "param_WIFIFlow", "param_Flow"};
            } else if ("biz_src_zf_games".equals(str2)) {
                strArr = new String[]{AppConstants.FlowStatPram.PARAM_WIFIAPP_CENTER_GAME_CENTER_DOWNLOAD_FLOW, "param_WIFIFlow", "param_Flow"};
            } else {
                if ("biz_src_jc_vip".equals(str2)) {
                    strArr = new String[]{AppConstants.FlowStatPram.PARAM_WIFIAPP_CENTER_OTHERS_DOWNLOAD_FLOW, "param_WIFIFlow", "param_Flow"};
                }
                strArr = null;
            }
        } else if ("biz_src_yyb".equals(str2)) {
            strArr = new String[]{AppConstants.FlowStatPram.PARAM_XGAPP_CENTER_DEFAULT_DOWNLOAD_FLOW, "param_XGFlow", "param_Flow"};
        } else if ("biz_src_jc_update".equals(str2)) {
            strArr = new String[]{AppConstants.FlowStatPram.PARAM_XGAPP_CENTER_QQUPDATE_DOWNLOAD_FLOW, "param_XGFlow", "param_Flow"};
        } else if ("biz_src_zf_games".equals(str2)) {
            strArr = new String[]{AppConstants.FlowStatPram.PARAM_XGAPP_CENTER_GAME_CENTER_DOWNLOAD_FLOW, "param_XGFlow", "param_Flow"};
        } else {
            if ("biz_src_jc_vip".equals(str2)) {
                strArr = new String[]{AppConstants.FlowStatPram.PARAM_XGAPP_CENTER_OTHERS_DOWNLOAD_FLOW, "param_XGFlow", "param_Flow"};
            }
            strArr = null;
        }
        if (u() != null && strArr != null) {
            AppInterface appInterface = u().get();
            if (appInterface == null) {
                com.tencent.open.base.f.a("DownloadManager_", "appinterface is null");
                return;
            }
            try {
                appInterface.getCurrentAccountUin();
                com.tencent.open.base.f.a("DownloadManager_", "sendAppDataIncerment logMsg: " + str + " ,fileSize : " + j3);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        com.tencent.open.base.f.a("DownloadManager_", "application or tags is null");
    }

    public synchronized void b0(AppInterface appInterface) {
        this.f341213d = new WeakReference<>(appInterface);
    }

    public void c0(String str) {
        try {
            if (BaseActivity.sTopActivity.isResume() && System.currentTimeMillis() - this.f341222m > 1000) {
                this.f341222m = System.currentTimeMillis();
                ToastUtil.a().e(str);
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.d("DownloadManager_", "showToast>>>", e16);
        }
    }

    public synchronized void d0(DownloadInfo downloadInfo) {
        e0(downloadInfo);
    }

    public synchronized void e(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            if (!TextUtils.isEmpty(downloadInfo.f341184e)) {
                com.tencent.open.base.f.a("DownloadManager_", "addDownloadInfo info.appId = " + downloadInfo.f341184e + ",info.packageName = " + downloadInfo.f341189h + ",info.filePath = " + downloadInfo.L);
                this.f341216g.put(downloadInfo.f341184e, downloadInfo);
                com.tencent.open.downloadnew.common.b.g().a(downloadInfo);
            }
        }
    }

    public boolean f(String str) {
        DownloadInfo w3 = C().w(str);
        if (w3 != null && w3.f() == 4) {
            return true;
        }
        return false;
    }

    public synchronized void f0(DownloadInfo downloadInfo, ApkUpdateDetail apkUpdateDetail) {
        if (apkUpdateDetail != null) {
            if (apkUpdateDetail.updatemethod == 4) {
                try {
                    String str = apkUpdateDetail.url;
                    long j3 = apkUpdateDetail.patchsize;
                    com.tencent.open.base.f.a("DownloadManager_", HardCodeUtil.qqStr(R.string.f171905ls3) + (j3 / 1048576) + "MB  fileMd5=" + apkUpdateDetail.fileMd5 + " urlPatch=" + str);
                    downloadInfo.F = str;
                    downloadInfo.E = 1;
                    if (j3 > 0) {
                        downloadInfo.f341187f0 = j3;
                    }
                    d0(downloadInfo);
                } catch (Exception e16) {
                    com.tencent.open.base.f.d("DownloadManager_", "statrDownloadWithUpdateData jsonException>>>", e16);
                    d0(downloadInfo);
                }
            }
        }
        com.tencent.open.base.f.a("DownloadManager_", "statrDownloadWithUpdateData updateJson empty");
        d0(downloadInfo);
    }

    public boolean g(String str, String str2, boolean z16) {
        DownloadInfo w3 = w(str);
        if (w3 != null) {
            m(str, false);
        }
        if (w3 != null) {
            if (z16) {
                K(10, w3);
                return true;
            }
            try {
                com.tencent.open.downloadnew.common.a.e().a(w3.f341196m);
                return true;
            } catch (Exception e16) {
                com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e16);
                return true;
            }
        }
        return true;
    }

    public void g0(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.tencent.open.downloadnew.b bVar = this.f341215f;
        if (bVar != null) {
            bVar.a(downloadInfo.f341189h, downloadInfo.I, null);
        } else {
            this.f341215f = null;
        }
    }

    public void h(boolean z16) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        String str = "";
        String str2 = "";
        for (DownloadInfo downloadInfo : this.f341216g.values()) {
            if (downloadInfo != null && downloadInfo.P != 4 && downloadInfo.P != 1 && downloadInfo.J == 1) {
                arrayList.add(downloadInfo);
                if (TextUtils.isEmpty(str2) && !com.tencent.open.business.base.a.a(downloadInfo.f341189h)) {
                    str2 = downloadInfo.f341191i;
                }
                i3++;
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                DownloadInfo downloadInfo2 = (DownloadInfo) it.next();
                downloadInfo2.k(10);
                K(10, downloadInfo2);
            }
        }
        boolean z17 = QAppCenterPluginProxyActivityTools.f390374a0;
        if (z16 && i3 > 0) {
            StringBuilder sb5 = new StringBuilder();
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + HardCodeUtil.qqStr(R.string.lrw);
            }
            sb5.append(str);
            sb5.append(i3);
            sb5.append(HardCodeUtil.qqStr(R.string.lrh));
            String sb6 = sb5.toString();
            if (z17) {
                ToastUtil.a().f(sb6, 1);
            } else {
                MyAppApi.z().g0(true, sb6);
            }
        }
    }

    protected void h0(DownloadInfo downloadInfo, long j3, long j16, String str) {
        if (j16 > 0) {
            downloadInfo.V = j3;
            e(downloadInfo);
            a0(str, j16, downloadInfo.M);
        }
    }

    public void i(String str) {
        if (str != null && str.trim().length() > 0) {
            com.tencent.open.downloadnew.common.a.e().a(str);
        }
    }

    public boolean i0(com.tencent.open.downloadnew.b bVar) {
        com.tencent.open.downloadnew.b bVar2;
        if (bVar == null || (bVar2 = this.f341215f) == null || bVar != bVar2) {
            return false;
        }
        this.f341215f = null;
        return true;
    }

    protected boolean j(DownloadInfo downloadInfo, DownloadInfo downloadInfo2) {
        downloadInfo.T = downloadInfo2.T;
        downloadInfo.U = downloadInfo2.U;
        downloadInfo.J = downloadInfo2.J;
        downloadInfo.C = downloadInfo2.C;
        downloadInfo.N = downloadInfo2.N;
        if (!TextUtils.isEmpty(downloadInfo.f341186f)) {
            if (!downloadInfo.f341186f.equals(downloadInfo2.f341186f)) {
                m(downloadInfo2.f341184e, false);
                return false;
            }
            return true;
        }
        downloadInfo.f341186f = downloadInfo2.f341186f;
        return true;
    }

    public synchronized void j0(DownloadListener downloadListener) {
        if (this.f341217h.contains(downloadListener)) {
            this.f341217h.remove(downloadListener);
        }
    }

    protected void k() {
        if (this.f341216g.size() > 200) {
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.18
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    try {
                        if (!com.tencent.open.adapter.a.f().e().getSharedPreferences("opensdk_config", 0).getBoolean("download_clear_unuse", false)) {
                            for (DownloadInfo downloadInfo : DownloadManager.this.f341216g.values()) {
                                if (downloadInfo.J == 0) {
                                    if (downloadInfo.E == 0) {
                                        str = downloadInfo.f341186f;
                                    } else {
                                        str = downloadInfo.F;
                                    }
                                    if (DownloadManager.this.F(str) == null) {
                                        DownloadManager.this.f341216g.remove(downloadInfo.f341184e);
                                        com.tencent.open.downloadnew.common.b.g().c(downloadInfo.f341184e);
                                    }
                                } else if (DownloadManager.this.E(downloadInfo) == null) {
                                    DownloadManager.this.f341216g.remove(downloadInfo.f341184e);
                                    com.tencent.open.downloadnew.common.b.g().c(downloadInfo.f341184e);
                                }
                            }
                            if (DownloadManager.this.f341216g.size() > 200) {
                                SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("opensdk_config", 0).edit();
                                edit.putBoolean("download_clear_unuse", true);
                                edit.commit();
                            }
                        }
                    } catch (Exception e16) {
                        com.tencent.open.base.f.d("DownloadManager_", "checkDownloadList>>>", e16);
                    }
                }
            }, 3000L);
        }
    }

    public void k0(ITMAssistantDownloadLogListener iTMAssistantDownloadLogListener) {
        if (iTMAssistantDownloadLogListener == null) {
            if (QLog.isColorLevel()) {
                QLog.i("DownloadManager_", 2, "unregisterLogListener logListener == null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("DownloadManager_", 2, "unregisterLogListener");
        }
        try {
            TMAssistantDownloadClient tMAssistantDownloadClient = this.f341210a;
            if (tMAssistantDownloadClient != null) {
                tMAssistantDownloadClient.unRegisterLogListener(iTMAssistantDownloadLogListener);
            }
        } catch (Exception e16) {
            com.tencent.open.base.f.d("DownloadManager_", "unregisterLogListener Exception:", e16);
        }
    }

    public void l() {
        try {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!DownloadManager.this.f341214e) {
                            MyAppApi.z();
                            if (!MyAppApi.G()) {
                                DownloadManager.this.h(true);
                            }
                            DownloadManager.this.f341214e = true;
                        }
                    } catch (Exception e16) {
                        com.tencent.open.base.f.d("DownloadManager_", "getQQAppInterface>>>", e16);
                    }
                }
            });
        } catch (Exception e16) {
            com.tencent.open.base.f.d("DownloadManager_", "getQQAppInterface>>>", e16);
        }
    }

    public DownloadInfo l0(String str, long j3, long j16) {
        DownloadInfo y16 = y(str);
        if (y16 != null) {
            y16.k(2);
            if (j16 != 0) {
                y16.Q = (int) ((((float) j3) * 100.0f) / ((float) j16));
            }
            y16.f341180b0 = j16;
        }
        return y16;
    }

    public void m(String str, final boolean z16) {
        final String str2;
        if (TextUtils.isEmpty(str)) {
            com.tencent.open.base.f.i("DownloadManager_", "appid is empty");
            return;
        }
        DownloadInfo w3 = w(str);
        if (w3 == null) {
            com.tencent.open.base.f.i("DownloadManager_", "clearDownloadInfo info == null");
            return;
        }
        com.tencent.open.base.f.h("DownloadManager_", "clearDownloadInfo info =" + w3.toString());
        if (w3.J == 0) {
            if (w3.E == 1) {
                str2 = w3.F;
            } else {
                str2 = w3.f341186f;
            }
            if (!TextUtils.isEmpty(str2)) {
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (z16) {
                                DownloadManager.this.D().deleteDownloadTask(str2);
                            } else {
                                DownloadManager.this.D().cancelDownloadTask(str2);
                            }
                        } catch (Exception e16) {
                            com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e16);
                        }
                    }
                });
            }
        }
        this.f341216g.remove(str);
        com.tencent.open.downloadnew.common.b.g().c(str);
    }

    public DownloadInfo m0(String str, int i3) {
        DownloadInfo y16 = y(str);
        if (y16 != null && i3 != -2) {
            y16.k(i3);
        }
        return y16;
    }

    public synchronized void n(final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            com.tencent.open.base.f.a("DownloadManager_", "complete info == null ");
            return;
        }
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) && "com.tencent.mobileqq".equals(downloadInfo.f341189h) && ConfigHandler.e3((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime())) {
            downloadInfo.T = false;
        }
        com.tencent.open.base.f.h("DownloadManager_", "onDownload complete, info = " + downloadInfo.toString());
        if (downloadInfo.J == 0) {
            if (downloadInfo.E == 1) {
                O(downloadInfo);
            } else {
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.13
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            TMAssistantDownloadTaskInfo F = DownloadManager.this.F(downloadInfo.f341186f);
                            if (F != null) {
                                DownloadInfo downloadInfo2 = downloadInfo;
                                downloadInfo2.L = F.mSavePath;
                                if ("com.tencent.mobileqq".equals(downloadInfo2.f341189h)) {
                                    File file = new File(downloadInfo.L);
                                    UpgradeDetailWrapper j3 = k.i().j();
                                    if (file.exists() && j3 != null) {
                                        if (!TextUtils.equals(j3.f306170d.strNewSoftwareMD5.toUpperCase(), com.tencent.open.base.g.b(file).toUpperCase())) {
                                            DownloadManager.this.M(downloadInfo, -51, "download file md5 check failed(not patche)");
                                            file.delete();
                                            return;
                                        }
                                    }
                                }
                                downloadInfo.f341180b0 = F.mTotalDataLen;
                                com.tencent.open.base.f.e("DownloadManager_", "onDownload complete, info.filePath = " + downloadInfo.L);
                                if ("com.tencent.mobileqq".equals(downloadInfo.f341189h) && DownloadManager.this.J()) {
                                    com.tencent.open.base.f.a("DownloadManager_", "QQ Download complete begin write code ......");
                                    DownloadInfo downloadInfo3 = downloadInfo;
                                    downloadInfo3.f341179a0 = DownloadManager.this.p0(downloadInfo3);
                                    if (downloadInfo.f341179a0 != 0) {
                                        com.tencent.open.base.f.a("DownloadManager_", "QQ apk write code fail......");
                                        downloadInfo.P = -2;
                                        DownloadManager.this.e(downloadInfo);
                                        DownloadManager downloadManager = DownloadManager.this;
                                        DownloadInfo downloadInfo4 = downloadInfo;
                                        downloadManager.M(downloadInfo4, downloadInfo4.f341179a0, null);
                                        return;
                                    }
                                    com.tencent.open.base.f.a("DownloadManager_", "QQ apk code suc......");
                                    DownloadManager.this.e(downloadInfo);
                                    DownloadManager.this.K(4, downloadInfo);
                                    DownloadManager.this.Z(downloadInfo, F.mTotalDataLen);
                                } else {
                                    com.tencent.open.base.f.a("DownloadManager_", downloadInfo.f341189h + " Download complete begin write code ......");
                                    DownloadManager.this.t(downloadInfo);
                                    return;
                                }
                            }
                        } catch (Exception e16) {
                            com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e16);
                        }
                        DownloadInfo downloadInfo5 = downloadInfo;
                        com.tencent.open.business.base.e.h(IndividuationPlugin.Business_Font, downloadInfo5.C, downloadInfo5.f341184e, downloadInfo5.f341181c0);
                        DownloadInfo downloadInfo6 = downloadInfo;
                        if (downloadInfo6.T) {
                            DownloadManager.this.I(downloadInfo6);
                        }
                    }
                });
            }
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.14
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TMAssistantDownloadTaskInfo E = DownloadManager.this.E(downloadInfo);
                        if (E != null) {
                            DownloadInfo downloadInfo2 = downloadInfo;
                            downloadInfo2.L = E.mSavePath;
                            DownloadManager.this.e(downloadInfo2);
                            DownloadManager.this.K(4, downloadInfo);
                        }
                        DownloadInfo downloadInfo3 = downloadInfo;
                        com.tencent.open.business.base.e.h(IndividuationPlugin.Business_Font, downloadInfo3.C, downloadInfo3.f341184e, downloadInfo3.f341181c0);
                        DownloadManager.this.I(downloadInfo);
                    } catch (Exception e16) {
                        com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e16);
                    }
                }
            }, 32, null, true);
        }
    }

    public DownloadInfo n0(String str, int i3) {
        DownloadInfo w3 = w(str);
        if (w3 != null) {
            if (i3 == -2) {
                i3 = 3;
            }
            w3.k(i3);
        }
        return w3;
    }

    public void p(final Activity activity, final Bundle bundle, final String str, final ApkUpdateDetail apkUpdateDetail, final int i3) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.17

            /* compiled from: P */
            /* renamed from: com.tencent.open.downloadnew.DownloadManager$17$a */
            /* loaded from: classes22.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    bundle.putBoolean(e.f341510s, false);
                    AnonymousClass17 anonymousClass17 = AnonymousClass17.this;
                    DownloadApi.d(activity, bundle, str, apkUpdateDetail, i3);
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.open.downloadnew.DownloadManager$17$b */
            /* loaded from: classes22.dex */
            class b implements DialogInterface.OnClickListener {
                b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Exception unused) {
                    }
                    String string = bundle.getString(e.f341493b);
                    String string2 = bundle.getString(e.f341501j);
                    String string3 = bundle.getString(e.f341497f);
                    String string4 = bundle.getString(e.f341500i);
                    DownloadManager.this.K(10, new DownloadInfo(string, string2.trim(), string3, bundle.getString(e.f341503l), string4, null, str, bundle.getBoolean(e.f341516y, true)));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = new a();
                b bVar = new b();
                com.tencent.open.base.f.e("DownloadManager_", "dialog create and show");
                AlertDialog create = new AlertDialog.Builder(activity).setMessage(activity.getString(R.string.af9)).setPositiveButton(R.string.af7, bVar).setNegativeButton(R.string.af8, aVar).create();
                create.setCanceledOnTouchOutside(false);
                if (!activity.isFinishing()) {
                    create.show();
                }
            }
        });
    }

    public int p0(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -30;
        }
        com.tencent.open.downloadnew.b bVar = this.f341215f;
        if (bVar != null) {
            return bVar.b(downloadInfo.f341189h, downloadInfo.I, downloadInfo.L, null);
        }
        this.f341215f = null;
        return -40;
    }

    public boolean q(String str, String str2, boolean z16) {
        DownloadInfo w3 = w(str);
        if (w3 != null) {
            m(str, true);
        }
        if (w3 != null) {
            if (z16) {
                K(10, w3);
            } else {
                try {
                    com.tencent.open.downloadnew.common.a.e().a(w3.f341196m);
                } catch (Exception e16) {
                    com.tencent.open.base.f.d("DownloadManager_", "downloadSDKClient>>>", e16);
                }
            }
        }
        return true;
    }

    public void r() {
        try {
            Iterator<DownloadListener> it = this.f341217h.iterator();
            while (it.hasNext()) {
                j0(it.next());
            }
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.downloadnew.DownloadManager.16
                @Override // java.lang.Runnable
                public void run() {
                    DownloadManager.this.f341220k = null;
                    if (UpdateManager.e()) {
                        UpdateManager.d().c();
                    }
                    if (MyAppApi.F()) {
                        MyAppApi.z().Y();
                    }
                    DownloadManager downloadManager = DownloadManager.this;
                    downloadManager.k0(downloadManager.f341225p);
                }
            });
        } catch (Exception e16) {
            com.tencent.open.base.f.b("DownloadManager_", "onDestroy>>>", e16);
        }
        synchronized (DownloadManager.class) {
            f341208r = null;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0057. Please report as an issue. */
    protected void s(DownloadInfo downloadInfo, long j3, long j16, int i3) {
        if (downloadInfo == null) {
            com.tencent.open.base.f.a("DownloadManager_", "trafficReport info == null code = " + i3);
            return;
        }
        com.tencent.open.base.f.a("DownloadManager_", "trafficReport code = " + i3);
        if (i3 >= 400 && i3 <= 599) {
            h0(downloadInfo, j3, j3 - downloadInfo.V, "open appstore network error");
        }
        if (i3 != -24) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                switch (i3) {
                                    case 600:
                                    case 604:
                                        break;
                                    case 601:
                                    case 602:
                                    case 603:
                                    case 605:
                                        break;
                                    default:
                                        switch (i3) {
                                            case 700:
                                            case 704:
                                            case 705:
                                                break;
                                            case 701:
                                            case 702:
                                            case 706:
                                            case 707:
                                            case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK /* 708 */:
                                            case TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES /* 709 */:
                                                break;
                                            case 703:
                                                h0(downloadInfo, j3, j3 - downloadInfo.V, "write file error");
                                                return;
                                            default:
                                                return;
                                        }
                                }
                            }
                        } else {
                            h0(downloadInfo, j3, j3 - downloadInfo.V, "DownloadSDK_START_FAILED_EXISTED");
                            return;
                        }
                    }
                    h0(downloadInfo, j3, j3 - downloadInfo.V, "download error");
                    return;
                }
                h0(downloadInfo, j3, j3 - downloadInfo.V, "network error");
                return;
            }
            h0(downloadInfo, j3, j3 - downloadInfo.V, "do not need to handle error");
            return;
        }
        h0(downloadInfo, 0L, j3 - downloadInfo.V, "package invalid");
    }

    public synchronized WeakReference<AppInterface> u() {
        AppInterface appInterface;
        if (this.f341213d == null) {
            try {
                if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface) && (appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime()) != null) {
                    this.f341213d = new WeakReference<>(appInterface);
                }
            } catch (Exception e16) {
                com.tencent.open.base.f.d("DownloadManager_", "getQQAppInterface>>>", e16);
            }
        }
        return this.f341213d;
    }

    public String v(String str) {
        DownloadInfo w3 = w(str);
        if (w3 != null) {
            return w3.L;
        }
        return "";
    }

    public DownloadInfo w(String str) {
        if (str == null) {
            com.tencent.open.base.f.h("DownloadManager_", "getDownloadInfoById appId == null");
            return null;
        }
        return this.f341216g.get(str);
    }

    public synchronized DownloadInfo x(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : this.f341216g.values()) {
                if (str.equals(downloadInfo.f341189h)) {
                    return downloadInfo;
                }
            }
        }
        return null;
    }

    protected DownloadInfo y(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : this.f341216g.values()) {
                if ((downloadInfo.E == 0 && str.equals(downloadInfo.f341186f)) || ((downloadInfo.E == 1 && str.equals(downloadInfo.F)) || (downloadInfo.E == 2 && str.equals(downloadInfo.f341186f)))) {
                    return downloadInfo;
                }
            }
            return null;
        }
        return null;
    }

    public String z(String str) {
        DownloadInfo w3 = w(str);
        if (w3 != null) {
            return w3.M;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements qp3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f341262a;

        a(DownloadInfo downloadInfo) {
            this.f341262a = downloadInfo;
        }

        @Override // qp3.b
        public void a(String str, String str2, String str3) {
            com.tencent.open.base.f.i("DownloadManager_", ">>download apk icon err,should load another size icon");
            ImageCache.c("app", com.tencent.open.base.d.d(this.f341262a.f341184e, 75), null);
        }

        @Override // qp3.b
        public void b(String str, String str2, String str3) {
        }
    }
}
