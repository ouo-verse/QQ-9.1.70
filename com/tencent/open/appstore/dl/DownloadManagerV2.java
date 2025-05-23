package com.tencent.open.appstore.dl;

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
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.download.unite.core.UniteDownloadDbOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.k;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appstore.notice.NoticeReceiver;
import com.tencent.open.appstore.receiver.InstallStateReceiver;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.f;
import com.tencent.open.base.g;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.DownloaderGetCodeClient;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.open.downloadnew.WebViewDownloadListener;
import com.tencent.open.downloadnew.YybDownloadSdkCallBack;
import com.tencent.open.downloadnew.b;
import com.tencent.open.downloadnew.common.a;
import com.tencent.open.downloadnew.common.c;
import com.tencent.open.downloadnew.e;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqperf.reporter.api.IDownloaderReporter;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.common.TMAssistantDownloadContentType;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import cooperation.qappcenter.QAppCenterPluginProxyActivityTools;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadManagerV2 implements ITMAssistantDownloadClientListener {

    /* renamed from: p, reason: collision with root package name */
    private static volatile DownloadManagerV2 f340789p;

    /* renamed from: a, reason: collision with root package name */
    private TMAssistantDownloadClient f340790a;

    /* renamed from: b, reason: collision with root package name */
    private DownloaderGetCodeClient f340791b;

    /* renamed from: c, reason: collision with root package name */
    private String f340792c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<AppInterface> f340793d;

    /* renamed from: f, reason: collision with root package name */
    private b f340795f;

    /* renamed from: j, reason: collision with root package name */
    private InstallStateReceiver f340799j;

    /* renamed from: k, reason: collision with root package name */
    private NoticeReceiver f340800k;

    /* renamed from: e, reason: collision with root package name */
    private boolean f340794e = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f340796g = false;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, DownloadInfo> f340797h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentLinkedQueue<DownloadListener> f340798i = new ConcurrentLinkedQueue<>();

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.open.downloadnew.a f340801l = new a();

    /* renamed from: m, reason: collision with root package name */
    private long f340802m = 0;

    /* renamed from: n, reason: collision with root package name */
    private long f340803n = 0;

    /* renamed from: o, reason: collision with root package name */
    private final int f340804o = 1000;

    /* compiled from: P */
    /* renamed from: com.tencent.open.appstore.dl.DownloadManagerV2$18, reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass18 implements Runnable {
        final /* synthetic */ DownloadManagerV2 this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (UpdateManager.e()) {
                UpdateManager.d().c();
            }
            if (MyAppApi.F()) {
                MyAppApi.z().Y();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements com.tencent.open.downloadnew.a {
        a() {
        }

        @Override // com.tencent.open.downloadnew.a
        public void a(String str, int i3, String str2, boolean z16, Bundle bundle) {
            f.e("DownloadManagerV2", "receive get code finished pkgName|" + str + " versionCode|" + i3 + " code|" + str2 + " extraData|" + bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString("PackageName", str);
            bundle2.putString("Code", str2);
            bundle2.putInt("VersionCode", i3);
            bundle2.putBoolean("IsSuccess", z16);
            bundle2.putAll(bundle);
            DownloadManagerV2.this.H0(bundle2);
        }
    }

    DownloadManagerV2() {
        f.e("DownloadManagerV2", "DownloadManagerV2 init");
        YybDownloadSdkCallBack.getInstance();
        this.f340792c = "com.tencent.open.appstore.dl.DownloadManagerV2";
        ReplaceMonitor.get().init(com.tencent.open.adapter.a.f().e(), new HashMap());
        this.f340799j = new InstallStateReceiver();
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        this.f340800k = new NoticeReceiver();
        final IntentFilter intentFilter2 = new IntentFilter();
        String str = "." + Common.m().replace(":", ".");
        intentFilter2.addAction(c.f341481a + str);
        intentFilter2.addAction(c.f341482b + str);
        intentFilter2.addAction(c.f341483c + str);
        intentFilter2.addAction(c.f341484d + str);
        intentFilter2.addAction(c.f341485e + str);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.open.adapter.a.f().e().registerReceiver(DownloadManagerV2.this.f340799j, intentFilter);
                com.tencent.open.adapter.a.f().e().registerReceiver(DownloadManagerV2.this.f340800k, intentFilter2);
            }
        }, 16, null, true);
        com.tencent.open.appstore.notice.f.d().g(ThreadManager.getSubThreadHandler().getLooper());
        t0(com.tencent.open.appstore.notice.f.d());
        t0(WebViewDownloadListener.g());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.3
            @Override // java.lang.Runnable
            public void run() {
                TMAssistantDownloadTaskInfo Y;
                DownloadManagerV2.this.f340797h = pp3.a.j().e();
                if (DownloadManagerV2.this.f340797h != null) {
                    for (DownloadInfo downloadInfo : DownloadManagerV2.this.f340797h.values()) {
                        if (downloadInfo.f() == 2) {
                            downloadInfo.k(3);
                        }
                    }
                }
                try {
                    DownloadInfo O = DownloadManagerV2.this.O("com.tencent.mobileqq");
                    if (O != null && O.J == 0) {
                        String str2 = "";
                        if (O.E == 0) {
                            Y = DownloadManagerV2.this.Y(O.f341186f);
                            if (Y != null) {
                                str2 = Y.mSavePath;
                            }
                        } else {
                            Y = DownloadManagerV2.this.Y(O.F);
                            str2 = O.L;
                        }
                        if (Y == null) {
                            DownloadManagerV2.this.u0(O);
                        } else if (Y.mState == 4 && com.tencent.open.business.base.a.i(str2) <= com.tencent.open.adapter.a.f().c()) {
                            DownloadManagerV2.this.u0(O);
                        }
                    }
                } catch (Exception e16) {
                    f.d("DownloadManagerV2", "speical clear>>>", e16);
                }
            }
        }, 32, null, true);
        this.f340791b = DownloaderGetCodeClient.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(DownloadInfo downloadInfo) {
        String str;
        f.e("DownloadManagerV2", ">>startDownload downloadInfo:" + downloadInfo);
        DownloadInfo R = R(downloadInfo.f341182d);
        if (R == null) {
            R = pp3.a.j().g(downloadInfo.f341182d);
            f.e("DownloadManagerV2", ">>startDownload get from DB:" + R);
        }
        if (R != null && R.f() == 4 && !new File(R.L).exists()) {
            f.c("DownloadManagerV2", "[startDownload] info succeed, but file is deleted!info=" + R);
            R.g();
            R = null;
        }
        final DownloadInfo downloadInfo2 = R;
        if (downloadInfo2 != null) {
            downloadInfo2.J = 0;
            downloadInfo2.C = downloadInfo.C;
            downloadInfo2.M = downloadInfo.M;
            downloadInfo2.T = downloadInfo.T;
            downloadInfo2.f341201q0 = downloadInfo.f341201q0;
            downloadInfo2.N = downloadInfo.N;
            f.h("DownloadManagerV2", "startDownload() downloadInfo != null>>>downloadInfo.url=" + downloadInfo2.f341186f + "downloadInfo.isAutoInstall" + downloadInfo2.T + "+++++downloadInfo.downloadType=" + downloadInfo2.E + "  test" + R(downloadInfo2.f341182d));
            downloadInfo = downloadInfo2;
        } else {
            AppCenterReporter.r(downloadInfo);
        }
        downloadInfo.f341199o0 = BaseApplicationImpl.getApplication().getQQProcessName();
        f.e("DownloadManagerV2", ">>startDownload record download start process flag:" + downloadInfo.f341199o0);
        f.e("DownloadManagerV2", ">>startDownload add info " + downloadInfo.N);
        v(downloadInfo, true);
        if ("com.tencent.mobileqq".equals(downloadInfo.f341189h) && c0()) {
            B0(downloadInfo);
        }
        final int i3 = downloadInfo.E;
        if (i3 == 1) {
            str = downloadInfo.F;
        } else {
            str = downloadInfo.f341186f;
        }
        final String str2 = str;
        final HashMap hashMap = new HashMap();
        hashMap.put(TMAssistantDownloadConst.PARAM_APPID, downloadInfo.f341184e);
        hashMap.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, downloadInfo.f341189h);
        hashMap.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(downloadInfo.I));
        hashMap.put(TMAssistantDownloadConst.PARAM_VIA, downloadInfo.C);
        hashMap.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, "qqNumber");
        hashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
        hashMap.put(TMAssistantDownloadConst.PARAM_ICON_URL, downloadInfo.Y);
        hashMap.put(TMAssistantDownloadConst.PARAM_APP_NAME, downloadInfo.f341191i);
        hashMap.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(downloadInfo.Z));
        hashMap.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(downloadInfo.f341183d0));
        hashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(downloadInfo.f341187f0));
        hashMap.put(TMAssistantDownloadConst.PARAM_QQ_SOURCE_ID, downloadInfo.M);
        final DownloadInfo downloadInfo3 = downloadInfo;
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.13
            @Override // java.lang.Runnable
            public void run() {
                int startDownloadTask;
                int i16 = 3;
                if (!TextUtils.isEmpty(str2)) {
                    f.e("DownloadManagerV2", "startDownload download file, url = " + str2 + "params = " + hashMap);
                    try {
                        int i17 = i3;
                        if (i17 == 0) {
                            startDownloadTask = DownloadManagerV2.this.W().startDownloadTask(str2, "application/vnd.android.package-archive", hashMap);
                        } else if (i17 == 1) {
                            hashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(3));
                            startDownloadTask = DownloadManagerV2.this.W().startDownloadTask(str2, TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF, hashMap);
                        } else {
                            f.h("DownloadManagerV2", "startDownload download unapk file, url = " + str2 + ",filename = " + downloadInfo3.f341189h);
                            startDownloadTask = DownloadManagerV2.this.W().startDownloadTask(str2, 0, TMAssistantDownloadContentType.CONTENT_TYPE_OTHERS, downloadInfo3.f341191i, hashMap);
                        }
                        i16 = startDownloadTask;
                    } catch (Exception e16) {
                        f.d("DownloadManagerV2", "downloadSDKClient>>>", e16);
                    }
                }
                f.e("DownloadManagerV2", "startDownloadTask downloadSDKClient result=" + i16 + " url=" + str2);
                if (i16 != 0) {
                    DownloadManagerV2.this.g0(downloadInfo3, i16, "");
                    return;
                }
                DownloadInfo downloadInfo4 = downloadInfo2;
                DownloadInfo downloadInfo5 = downloadInfo3;
                if (downloadInfo4 == downloadInfo5 && downloadInfo5.f() == 20) {
                    DownloadManagerV2.this.d0(20, downloadInfo3);
                }
            }
        });
        try {
            DownloadInfoReport.e(this.f340793d.get(), downloadInfo);
        } catch (Throwable unused) {
        }
    }

    private void B0(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        b bVar = this.f340795f;
        if (bVar != null) {
            bVar.a(downloadInfo.f341189h, downloadInfo.I, null);
        } else {
            this.f340795f = null;
        }
    }

    private void C(String str, final boolean z16) {
        final String str2;
        if (TextUtils.isEmpty(str)) {
            f.i("DownloadManagerV2", "appid is empty");
            return;
        }
        DownloadInfo R = R(str);
        if (R == null) {
            f.i("DownloadManagerV2", "clearDownloadInfo info == null");
            return;
        }
        f.h("DownloadManagerV2", "clearDownloadInfo info =" + R.toString());
        if (R.J == 0) {
            if (R.E == 1) {
                str2 = R.F;
            } else {
                str2 = R.f341186f;
            }
            if (!TextUtils.isEmpty(str2)) {
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.15
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (z16) {
                                DownloadManagerV2.this.W().deleteDownloadTask(str2);
                            } else {
                                DownloadManagerV2.this.W().cancelDownloadTask(str2);
                            }
                        } catch (Exception e16) {
                            f.d("DownloadManagerV2", "downloadSDKClient>>>", e16);
                        }
                    }
                });
            }
        }
        u0(R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int D(int i3) {
        return DownloadManager.o(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadInfo E0(String str, long j3, long j16) {
        DownloadInfo S = S(str);
        int i3 = (int) ((((float) j3) * 100.0f) / ((float) j16));
        if (S != null) {
            S.k(2);
            S.Q = i3;
            S.f341180b0 = j16;
        }
        return S;
    }

    private boolean F(String str, boolean z16) {
        DownloadInfo R = R(str);
        if (R != null) {
            C(str, true);
        }
        if (R != null) {
            if (z16) {
                d0(10, R);
            } else {
                try {
                    com.tencent.open.downloadnew.common.a.e().a(R.f341196m);
                } catch (Exception e16) {
                    f.d("DownloadManagerV2", "downloadSDKClient>>>", e16);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadInfo F0(String str, int i3) {
        DownloadInfo S = S(str);
        if (S != null && i3 != -2) {
            S.k(i3);
        }
        return S;
    }

    private DownloadInfo G0(String str, int i3) {
        DownloadInfo N = N(str);
        if (N != null) {
            if (i3 == -2) {
                i3 = 3;
            }
            N.k(i3);
        }
        return N;
    }

    private void H(final DownloadInfo downloadInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TMAssistantDownloadTaskInfo Y = DownloadManagerV2.this.Y(downloadInfo.f341186f);
                    if (Y != null) {
                        f.e("DownloadManagerV2", "[doGeneraWriteCodeTask] taskInfo=" + Y + ",writeCodeState=" + downloadInfo.f341179a0);
                        DownloadInfo downloadInfo2 = downloadInfo;
                        downloadInfo2.L = Y.mSavePath;
                        downloadInfo2.f341180b0 = Y.mTotalDataLen;
                        DownloadManagerV2.this.u(downloadInfo2);
                        DownloadInfo downloadInfo3 = downloadInfo;
                        if (downloadInfo3.f341179a0 != 0 && !TextUtils.isEmpty(downloadInfo3.f341189h)) {
                            f.e("DownloadManagerV2", "[doGeneraWriteCodeTask] taskInfo == null");
                            DownloadManagerV2.this.K(downloadInfo);
                            return;
                        }
                        DownloadManagerV2.this.d0(4, downloadInfo);
                        if (!"1101070898".equals(downloadInfo.f341184e)) {
                            DownloadManagerV2.this.v0(downloadInfo, Y.mTotalDataLen);
                        }
                    }
                } catch (Exception e16) {
                    f.d("DownloadManagerV2", "[doGeneraWriteCodeTask]>>>", e16);
                }
                DownloadInfo downloadInfo4 = downloadInfo;
                if (downloadInfo4.T) {
                    DownloadManagerV2.this.b0(downloadInfo4, false);
                }
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(final Bundle bundle) {
        f.e("DownloadManagerV2", "[writeApkCodeAsync] ");
        if (bundle == null) {
            f.e("DownloadManagerV2", "[writeApkCodeAsync] data is null......");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.22
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    try {
                        String string = bundle.getString(e.f341492a);
                        if (TextUtils.isEmpty(string)) {
                            return;
                        }
                        DownloadInfo R = DownloadManagerV2.this.R(string);
                        String string2 = bundle.getString("PackageName");
                        if (R == null) {
                            f.c("DownloadManagerV2", "[writeApkCodeAsync]  pkgName=" + string2 + " download info is null");
                            return;
                        }
                        String string3 = bundle.getString("Code");
                        f.e("DownloadManagerV2", "[writeApkCodeAsync] pkgName=" + string2 + ", code=" + string3);
                        if (TextUtils.isEmpty(string3)) {
                            R.f341179a0 = 0;
                            R.k(4);
                            DownloadManagerV2.this.u(R);
                            DownloadManagerV2.this.d0(4, R);
                            DownloadManagerV2.this.v0(R, R.f341180b0);
                            f.e("AppCenterReporter", "from:[writeApkCodeAsync] code is empty");
                            AppCenterReporter.s(R);
                            if (R.T) {
                                DownloadManagerV2.this.b0(R, false);
                                return;
                            }
                            return;
                        }
                        bundle.getInt("VersionCode");
                        File file = new File(R.L);
                        try {
                            com.tencent.securitysdk.utils.a.j(file, string3);
                            String f16 = com.tencent.securitysdk.utils.a.f(file);
                            f.e("DownloadManagerV2", "[writeApkCodeAsync] pkgName=" + string2 + ",check code=" + f16);
                            z16 = string3.equals(f16);
                        } catch (IOException e16) {
                            f.e("DownloadManagerV2", "[writeApkCodeAsync] Exception=" + e16.getMessage());
                            z16 = false;
                        }
                        if (z16) {
                            f.e("DownloadManagerV2", "[writeApkCodeAsync]  pkgName=" + string2 + " write code and check code suc");
                            R.f341179a0 = 0;
                            DownloadManagerV2.this.u(R);
                            DownloadManagerV2.this.d0(4, R);
                            DownloadManagerV2.this.v0(R, R.f341180b0);
                            f.e("AppCenterReporter", "from:[writeApkCodeAsync] APK_WRITE_CODE_SUC");
                            AppCenterReporter.s(R);
                            if (R.T) {
                                DownloadManagerV2.this.b0(R, false);
                                return;
                            }
                            return;
                        }
                        f.e("DownloadManagerV2", "[writeApkCodeAsync] pkgName=" + string2 + " write code or check code fail");
                        R.f341179a0 = -20;
                        R.k(-2);
                        DownloadManagerV2.this.u(R);
                        DownloadManagerV2.this.g0(R, R.f341179a0, null);
                    } catch (Exception e17) {
                        f.d("DownloadManagerV2", "[writeApkCodeAsync] >>>", e17);
                    }
                }
            }, 32, null, true);
        }
    }

    private void I(final DownloadInfo downloadInfo) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TMAssistantDownloadTaskInfo Y = DownloadManagerV2.this.Y(downloadInfo.f341186f);
                    if (Y != null) {
                        DownloadInfo downloadInfo2 = downloadInfo;
                        downloadInfo2.L = Y.mSavePath;
                        if (downloadInfo2.f341197m0 && "com.tencent.mobileqq".equals(downloadInfo2.f341189h)) {
                            File file = new File(downloadInfo.L);
                            UpgradeDetailWrapper j3 = k.i().j();
                            if (file.exists() && j3 != null) {
                                if (!TextUtils.equals(j3.f306170d.strNewSoftwareMD5.toUpperCase(), g.b(file).toUpperCase())) {
                                    DownloadManagerV2.this.g0(downloadInfo, -51, "download file md5 check failed(not patche)");
                                    file.delete();
                                    return;
                                }
                            }
                        }
                        downloadInfo.f341180b0 = Y.mTotalDataLen;
                        f.e("DownloadManagerV2", "onDownload complete, info.filePath = " + downloadInfo.L);
                        if ("com.tencent.mobileqq".equals(downloadInfo.f341189h) && DownloadManagerV2.this.c0()) {
                            f.e("DownloadManagerV2", "QQ Download complete begin write code ......");
                            DownloadInfo downloadInfo3 = downloadInfo;
                            downloadInfo3.f341179a0 = DownloadManagerV2.this.I0(downloadInfo3);
                            if (downloadInfo.f341179a0 != 0) {
                                f.e("DownloadManagerV2", "QQ apk write code fail......");
                                downloadInfo.k(-2);
                                DownloadManagerV2.this.u(downloadInfo);
                                DownloadManagerV2 downloadManagerV2 = DownloadManagerV2.this;
                                DownloadInfo downloadInfo4 = downloadInfo;
                                downloadManagerV2.g0(downloadInfo4, downloadInfo4.f341179a0, null);
                                return;
                            }
                            f.e("DownloadManagerV2", "QQ apk code suc......");
                        } else if (!TextUtils.isEmpty(downloadInfo.f341189h)) {
                            f.e("DownloadManagerV2", downloadInfo.f341189h + " Download complete begin write code ......");
                            DownloadManagerV2.this.K(downloadInfo);
                            return;
                        }
                        DownloadManagerV2.this.u(downloadInfo);
                        DownloadManagerV2.this.d0(4, downloadInfo);
                        DownloadManagerV2.this.v0(downloadInfo, Y.mTotalDataLen);
                    }
                } catch (Exception e16) {
                    f.d("DownloadManagerV2", "downloadSDKClient>>>", e16);
                }
                f.e("AppCenterReporter", "from:[doMd5CheckAndWriteCode]");
                AppCenterReporter.s(downloadInfo);
                DownloadInfo downloadInfo5 = downloadInfo;
                if (downloadInfo5.T) {
                    DownloadManagerV2.this.b0(downloadInfo5, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I0(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -30;
        }
        b bVar = this.f340795f;
        if (bVar != null) {
            return bVar.b(downloadInfo.f341189h, downloadInfo.I, downloadInfo.L, null);
        }
        this.f340795f = null;
        return -40;
    }

    private void J(final DownloadInfo downloadInfo) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.10
            @Override // java.lang.Runnable
            public void run() {
                TMAssistantDownloadTaskInfo Y = DownloadManagerV2.this.Y(downloadInfo.f341186f);
                if (Y != null) {
                    downloadInfo.L = Y.mSavePath;
                }
                DownloadInfo downloadInfo2 = downloadInfo;
                downloadInfo2.f341179a0 = DownloadManagerV2.this.I0(downloadInfo2);
                if (downloadInfo.f341179a0 != 0) {
                    f.e("DownloadManagerV2", HardCodeUtil.qqStr(R.string.lrq));
                    downloadInfo.k(-2);
                    downloadInfo.Q = 100;
                    DownloadManagerV2 downloadManagerV2 = DownloadManagerV2.this;
                    DownloadInfo downloadInfo3 = downloadInfo;
                    downloadManagerV2.g0(downloadInfo3, downloadInfo3.f341179a0, null);
                    return;
                }
                f.h("DownloadManagerV2", HardCodeUtil.qqStr(R.string.ls9));
                downloadInfo.k(4);
                downloadInfo.Q = 100;
                DownloadManagerV2.this.f0(downloadInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(final DownloadInfo downloadInfo) {
        f.e("DownloadManagerV2", "[getApkCodeAsync]");
        if (downloadInfo == null) {
            f.e("DownloadManagerV2", "[getApkCodeAsync] info is null......");
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.21
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        f.e("DownloadManagerV2", "[getApkCodeAsync]" + downloadInfo.f341189h + " begin getApkCode ......");
                        DownloaderGetCodeClient downloaderGetCodeClient = DownloadManagerV2.this.f340791b;
                        DownloadInfo downloadInfo2 = downloadInfo;
                        downloaderGetCodeClient.h(downloadInfo2.f341182d, downloadInfo2.f341189h, downloadInfo2.I, DownloadManagerV2.this.f340801l);
                    } catch (Exception e16) {
                        f.d("DownloadManagerV2", "[getApkCodeAsync] >>>", e16);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadInfo N(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : this.f340797h.values()) {
                if (TextUtils.equals(downloadInfo.f341184e, str)) {
                    return downloadInfo;
                }
            }
            return null;
        }
        return null;
    }

    public static DownloadManagerV2 V() {
        if (f340789p == null) {
            synchronized (DownloadManagerV2.class) {
                if (f340789p == null) {
                    f340789p = new DownloadManagerV2();
                    f340789p.Z();
                    f340789p.A();
                }
            }
        }
        return f340789p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TMAssistantDownloadClient W() {
        TMAssistantDownloadManager.getInstance(com.tencent.open.adapter.a.f().e()).getDownloadSDKClient(this.f340792c).registerDownloadTaskListener(this);
        if (!this.f340796g) {
            try {
                TMAssistantDownloadSettingClient downloadSDKSettingClient = TMAssistantDownloadManager.getInstance(com.tencent.open.adapter.a.f().e()).getDownloadSDKSettingClient();
                if (downloadSDKSettingClient != null) {
                    downloadSDKSettingClient.setDownloadSDKMaxTaskNum(3);
                    this.f340796g = true;
                }
            } catch (Exception e16) {
                f.c("DownloadManagerV2", "exception: " + e16.toString());
            }
        }
        TMAssistantDownloadClient downloadSDKClient = TMAssistantDownloadManager.getInstance(com.tencent.open.adapter.a.f().e()).getDownloadSDKClient(this.f340792c);
        this.f340790a = downloadSDKClient;
        return downloadSDKClient;
    }

    private void Z() {
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.5
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo N;
                TMAssistantDownloadTaskInfo Y;
                ConcurrentHashMap<String, a.C9279a> h16 = com.tencent.open.downloadnew.common.a.e().h();
                if (h16 == null) {
                    return;
                }
                Iterator<String> it = h16.keySet().iterator();
                while (it.hasNext()) {
                    a.C9279a c9279a = h16.get(it.next());
                    if (c9279a != null && (N = DownloadManagerV2.this.N(c9279a.f341463b)) != null && !TextUtils.isEmpty(N.f341186f) && (Y = DownloadManagerV2.this.Y(N.f341186f)) != null && 4 != DownloadManagerV2.D(Y.mState)) {
                        com.tencent.open.downloadnew.common.a.e().a(c9279a.f341462a);
                    }
                }
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e0(int i3, DownloadInfo downloadInfo, int i16, String str) {
        if (downloadInfo == null) {
            f.c("DownloadManagerV2", "notifyListener info == null id=" + i3);
            return;
        }
        boolean z16 = true;
        if (i3 != -2) {
            if (i3 != 6) {
                if (i3 != 13) {
                    if (i3 != 20) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 != 4) {
                                    if (i3 != 9) {
                                        if (i3 == 10) {
                                            f.e("DownloadManagerV2", "[notifyListener] STATE_CANCEL:" + this.f340798i.size());
                                            u0(downloadInfo);
                                            com.tencent.open.downloadnew.common.a.e().a(downloadInfo.f341196m);
                                            downloadInfo.k(10);
                                            f.e("DownloadManagerV2", "downloadInfo.state = " + downloadInfo.f());
                                            Iterator<DownloadListener> it = this.f340798i.iterator();
                                            while (it.hasNext()) {
                                                it.next().onDownloadCancel(downloadInfo);
                                            }
                                            if (downloadInfo.J == 0) {
                                                AppCenterReporter.h(downloadInfo);
                                            }
                                            z16 = false;
                                        }
                                    } else {
                                        f.e("DownloadManagerV2", "[notifyListener] PACKAGE_UNINSTALLED:" + this.f340798i.size());
                                        Iterator<DownloadListener> it5 = this.f340798i.iterator();
                                        while (it5.hasNext()) {
                                            it5.next().uninstallSucceed(downloadInfo.f341184e, downloadInfo.f341189h);
                                        }
                                    }
                                } else {
                                    f.e("DownloadManagerV2", "[notifyListener] STATE_COMPLETE:" + this.f340798i.size());
                                    downloadInfo.Q = 100;
                                    if (downloadInfo.J == 0) {
                                        AppCenterReporter.i(downloadInfo);
                                    }
                                    Iterator<DownloadListener> it6 = this.f340798i.iterator();
                                    while (it6.hasNext()) {
                                        it6.next().onDownloadFinish(downloadInfo);
                                    }
                                    DownloadInfoReport.g(12, null, 100, downloadInfo);
                                }
                            } else {
                                f.e("DownloadManagerV2", "[notifyListener] STATE_PAUSE:" + this.f340798i.size());
                                Iterator<DownloadListener> it7 = this.f340798i.iterator();
                                while (it7.hasNext()) {
                                    it7.next().onDownloadPause(downloadInfo);
                                }
                            }
                        } else {
                            if (downloadInfo.J != 1) {
                                if (System.currentTimeMillis() - this.f340802m > 1000) {
                                }
                                z16 = false;
                            }
                            this.f340802m = System.currentTimeMillis();
                            f.e("DownloadManagerV2", "[notifyListener] STATE_DOWNLOADING:" + this.f340798i.size());
                            List<DownloadInfo> U = U(2);
                            f.h("DownloadManagerV2", "[notifyListener] STATE_DOWNLOADING: infos size= " + U.size());
                            Iterator<DownloadListener> it8 = this.f340798i.iterator();
                            while (it8.hasNext()) {
                                DownloadListener next = it8.next();
                                f.h("DownloadManagerV2", "[notifyListener] DownloadConstants.STATE_DOWNLOADING: listener name:" + next.getClass().getName());
                                next.onDownloadUpdate(U);
                            }
                        }
                    } else {
                        f.e("DownloadManagerV2", "[notifyListener] STATE_WAIT:" + this.f340798i.size());
                        Iterator<DownloadListener> it9 = this.f340798i.iterator();
                        while (it9.hasNext()) {
                            it9.next().onDownloadWait(downloadInfo);
                        }
                    }
                } else {
                    f.e("DownloadManagerV2", "[notifyListener] PACKAGE_REPLACED:" + this.f340798i.size());
                    Iterator<DownloadListener> it10 = this.f340798i.iterator();
                    while (it10.hasNext()) {
                        it10.next().packageReplaced(downloadInfo.f341184e, downloadInfo.f341189h);
                    }
                }
            } else {
                f.e("DownloadManagerV2", "[notifyListener] PACKAGE_INSTALLED:" + this.f340798i.size());
                Iterator<DownloadListener> it11 = this.f340798i.iterator();
                while (it11.hasNext()) {
                    it11.next().installSucceed(downloadInfo.f341184e, downloadInfo.f341189h);
                }
            }
        } else {
            g0(downloadInfo, i16, str);
        }
        if (z16) {
            f.e("DownloadManagerV2", "[notifyListener] Need Save Info:" + downloadInfo);
            u(downloadInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x005e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078 A[Catch: Exception -> 0x0104, TryCatch #0 {Exception -> 0x0104, blocks: (B:24:0x006a, B:25:0x0078, B:26:0x0089, B:27:0x009a, B:28:0x00ab, B:30:0x00b0, B:32:0x00b9, B:34:0x00bd, B:36:0x00c3, B:38:0x00c7, B:40:0x00cf, B:42:0x00d3, B:44:0x00d7, B:45:0x00e4, B:46:0x00f4, B:48:0x0130, B:49:0x0154, B:51:0x015a, B:53:0x0164, B:57:0x016d, B:58:0x0170, B:60:0x0174, B:62:0x0178, B:66:0x010c, B:67:0x012b, B:68:0x011c), top: B:7:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7 A[Catch: Exception -> 0x0104, TryCatch #0 {Exception -> 0x0104, blocks: (B:24:0x006a, B:25:0x0078, B:26:0x0089, B:27:0x009a, B:28:0x00ab, B:30:0x00b0, B:32:0x00b9, B:34:0x00bd, B:36:0x00c3, B:38:0x00c7, B:40:0x00cf, B:42:0x00d3, B:44:0x00d7, B:45:0x00e4, B:46:0x00f4, B:48:0x0130, B:49:0x0154, B:51:0x015a, B:53:0x0164, B:57:0x016d, B:58:0x0170, B:60:0x0174, B:62:0x0178, B:66:0x010c, B:67:0x012b, B:68:0x011c), top: B:7:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f4 A[Catch: Exception -> 0x0104, TryCatch #0 {Exception -> 0x0104, blocks: (B:24:0x006a, B:25:0x0078, B:26:0x0089, B:27:0x009a, B:28:0x00ab, B:30:0x00b0, B:32:0x00b9, B:34:0x00bd, B:36:0x00c3, B:38:0x00c7, B:40:0x00cf, B:42:0x00d3, B:44:0x00d7, B:45:0x00e4, B:46:0x00f4, B:48:0x0130, B:49:0x0154, B:51:0x015a, B:53:0x0164, B:57:0x016d, B:58:0x0170, B:60:0x0174, B:62:0x0178, B:66:0x010c, B:67:0x012b, B:68:0x011c), top: B:7:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015a A[Catch: Exception -> 0x0104, LOOP:0: B:49:0x0154->B:51:0x015a, LOOP_END, TryCatch #0 {Exception -> 0x0104, blocks: (B:24:0x006a, B:25:0x0078, B:26:0x0089, B:27:0x009a, B:28:0x00ab, B:30:0x00b0, B:32:0x00b9, B:34:0x00bd, B:36:0x00c3, B:38:0x00c7, B:40:0x00cf, B:42:0x00d3, B:44:0x00d7, B:45:0x00e4, B:46:0x00f4, B:48:0x0130, B:49:0x0154, B:51:0x015a, B:53:0x0164, B:57:0x016d, B:58:0x0170, B:60:0x0174, B:62:0x0178, B:66:0x010c, B:67:0x012b, B:68:0x011c), top: B:7:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0174 A[Catch: Exception -> 0x0104, TryCatch #0 {Exception -> 0x0104, blocks: (B:24:0x006a, B:25:0x0078, B:26:0x0089, B:27:0x009a, B:28:0x00ab, B:30:0x00b0, B:32:0x00b9, B:34:0x00bd, B:36:0x00c3, B:38:0x00c7, B:40:0x00cf, B:42:0x00d3, B:44:0x00d7, B:45:0x00e4, B:46:0x00f4, B:48:0x0130, B:49:0x0154, B:51:0x015a, B:53:0x0164, B:57:0x016d, B:58:0x0170, B:60:0x0174, B:62:0x0178, B:66:0x010c, B:67:0x012b, B:68:0x011c), top: B:7:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0178 A[Catch: Exception -> 0x0104, TRY_LEAVE, TryCatch #0 {Exception -> 0x0104, blocks: (B:24:0x006a, B:25:0x0078, B:26:0x0089, B:27:0x009a, B:28:0x00ab, B:30:0x00b0, B:32:0x00b9, B:34:0x00bd, B:36:0x00c3, B:38:0x00c7, B:40:0x00cf, B:42:0x00d3, B:44:0x00d7, B:45:0x00e4, B:46:0x00f4, B:48:0x0130, B:49:0x0154, B:51:0x015a, B:53:0x0164, B:57:0x016d, B:58:0x0170, B:60:0x0174, B:62:0x0178, B:66:0x010c, B:67:0x012b, B:68:0x011c), top: B:7:0x0044 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g0(DownloadInfo downloadInfo, int i3, String str) {
        int i16;
        Iterator<DownloadListener> it;
        this.f340796g = false;
        if (downloadInfo == null) {
            f.e("DownloadManagerV2", "[onDownloadError] info == null code = " + i3 + " msg = " + str);
            return;
        }
        f.e("DownloadManagerV2", "[onDownloadError] errorCode = " + i3 + " msg = " + str);
        try {
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
                                    break;
                                case 2:
                                    str = com.tencent.open.adapter.a.f().e().getString(R.string.cog);
                                    break;
                                case 3:
                                    str = com.tencent.open.adapter.a.f().e().getString(R.string.co7);
                                    break;
                                case 4:
                                    String str2 = downloadInfo.f341189h;
                                    if (str2 != null && "com.tencent.mobileqq".equals(str2) && downloadInfo.E != 1 && c0()) {
                                        J(downloadInfo);
                                        return;
                                    }
                                    downloadInfo.k(4);
                                    if (downloadInfo.E == 1) {
                                        n0(downloadInfo);
                                        return;
                                    } else {
                                        H(downloadInfo);
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
                            }
                        }
                    }
                }
                downloadInfo.k(i16);
                f.e("DownloadManagerV2", "[onDownloadError] ListenerSize:" + this.f340798i.size());
                it = this.f340798i.iterator();
                while (it.hasNext()) {
                    it.next().onDownloadError(downloadInfo, i3, str, i16);
                }
                if (!TextUtils.isEmpty(str) && i3 != 6) {
                    y0(str);
                }
                if (downloadInfo.J != 0) {
                    AppCenterReporter.q(downloadInfo, i3, str);
                    return;
                } else {
                    f.c("DownloadManagerV2", "[onDownloadError] downloadType=DOWNLOAD_TYPE_MYAPP, shouldn't report!");
                    return;
                }
            }
            if (i3 == 712) {
                str = com.tencent.open.adapter.a.f().e().getString(R.string.co9);
            } else {
                str = com.tencent.open.adapter.a.f().e().getString(R.string.co_);
            }
            w0(downloadInfo);
            i16 = 10;
            downloadInfo.k(i16);
            f.e("DownloadManagerV2", "[onDownloadError] ListenerSize:" + this.f340798i.size());
            it = this.f340798i.iterator();
            while (it.hasNext()) {
            }
            if (!TextUtils.isEmpty(str)) {
                y0(str);
            }
            if (downloadInfo.J != 0) {
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void n0(final DownloadInfo downloadInfo) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TMAssistantDownloadTaskInfo Y = DownloadManagerV2.this.Y(downloadInfo.F);
                    if (Y != null) {
                        downloadInfo.L = Y.mSavePath;
                        UpdateManager.d().f(downloadInfo);
                    }
                } catch (Exception e16) {
                    f.d("DownloadManagerV2", "downloadSDKClient>>>", e16);
                }
            }
        });
    }

    private int p0(String str) {
        final String str2;
        DownloadInfo R = R(str);
        if (R != null) {
            if (R.E == 1) {
                str2 = R.F;
            } else {
                str2 = R.f341186f;
            }
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.14
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DownloadManagerV2.this.W().pauseDownloadTask(str2);
                    } catch (Exception e16) {
                        f.d("DownloadManagerV2", "downloadSDKClient>>>", e16);
                    }
                }
            });
            f.h("DownloadManagerV2", "pause url=" + str2 + ", ticket=" + str);
            return 0;
        }
        return 0;
    }

    private void q0(DownloadInfo downloadInfo, String str, String str2, boolean z16) {
        boolean r16;
        if (downloadInfo.f() != 4 && downloadInfo.f341183d0) {
            f.e("DownloadManagerV2", "isAutoInstallBySDK is true");
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                if (z16) {
                    downloadInfo.f341199o0 = BaseApplicationImpl.getApplication().getQQProcessName();
                    v(downloadInfo, true);
                }
                r16 = com.tencent.open.business.base.a.r(com.tencent.open.adapter.a.f().e(), str, downloadInfo.M, downloadInfo.e(LaunchParam.KEY_REF_ID), downloadInfo.e(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE));
                AppCenterReporter.u(downloadInfo);
            } else {
                return;
            }
        } else {
            if (z16) {
                downloadInfo.f341199o0 = BaseApplicationImpl.getApplication().getQQProcessName();
                v(downloadInfo, true);
            }
            r16 = com.tencent.open.business.base.a.r(com.tencent.open.adapter.a.f().e(), str, downloadInfo.M, downloadInfo.e(LaunchParam.KEY_REF_ID), downloadInfo.e(AdDownloadConstants.PARAMS_HIDE_INSTALL_SUCCESS_PAGE));
            AppCenterReporter.u(downloadInfo);
        }
        if (r16 && SDKConst.SELF_PACKAGENAME.equals(str2) && "1101070898".equals(downloadInfo.f341184e)) {
            f.h("DownloadManagerV2", "report yyb start install");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            this.f340797h.remove(downloadInfo.f341182d);
            pp3.a.j().c(downloadInfo.f341182d);
        }
    }

    private boolean w(String str, boolean z16) {
        DownloadInfo R = R(str);
        if (R != null) {
            C(str, false);
        }
        if (R != null) {
            if (z16) {
                d0(10, R);
                return true;
            }
            try {
                com.tencent.open.downloadnew.common.a.e().a(R.f341196m);
                return true;
            } catch (Exception e16) {
                f.d("DownloadManagerV2", "downloadSDKClient>>>", e16);
                return true;
            }
        }
        return true;
    }

    private void w0(final DownloadInfo downloadInfo) {
        final String str;
        com.tencent.mobileqq.upgrade.banner.b.f(false);
        if (downloadInfo.E == 1) {
            str = downloadInfo.F;
        } else {
            str = downloadInfo.f341186f;
        }
        if (str != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DownloadManagerV2.this.W().cancelDownloadTask(str);
                        DownloadManagerV2.this.u0(downloadInfo);
                    } catch (Exception e16) {
                        f.d("DownloadManagerV2", "downloadSDKClient>>>", e16);
                    }
                }
            }, 32, null, true);
        }
    }

    protected void A() {
        if (this.f340797h.size() > 200) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.20
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    try {
                        if (!com.tencent.open.adapter.a.f().e().getSharedPreferences("opensdk_config_DownloadManagerV2", 0).getBoolean("download_clear_unuse", false)) {
                            for (DownloadInfo downloadInfo : DownloadManagerV2.this.f340797h.values()) {
                                if (downloadInfo.J == 0) {
                                    if (downloadInfo.E == 0) {
                                        str = downloadInfo.f341186f;
                                    } else {
                                        str = downloadInfo.F;
                                    }
                                    if (DownloadManagerV2.this.Y(str) == null) {
                                        DownloadManagerV2.this.u0(downloadInfo);
                                    }
                                } else if (DownloadManagerV2.this.X(downloadInfo) == null) {
                                    DownloadManagerV2.this.u0(downloadInfo);
                                }
                            }
                            if (DownloadManagerV2.this.f340797h.size() > 200) {
                                SharedPreferences.Editor edit = com.tencent.open.adapter.a.f().e().getSharedPreferences("opensdk_config_DownloadManagerV2", 0).edit();
                                edit.putBoolean("download_clear_unuse", true);
                                edit.apply();
                            }
                        }
                    } catch (Exception e16) {
                        f.d("DownloadManagerV2", "checkDownloadList>>>", e16);
                    }
                }
            }, 32, null, true, 3000L);
        }
    }

    public void B() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.4
            @Override // java.lang.Runnable
            public void run() {
                if (!DownloadManagerV2.this.f340794e) {
                    MyAppApi.b0();
                    if (!MyAppApi.G()) {
                        DownloadManagerV2.this.y(true);
                    }
                    DownloadManagerV2.this.f340794e = true;
                }
            }
        });
    }

    public boolean C0(b bVar) {
        b bVar2;
        if (bVar == null || (bVar2 = this.f340795f) == null || bVar != bVar2) {
            return false;
        }
        this.f340795f = null;
        return true;
    }

    public synchronized void D0(DownloadListener downloadListener) {
        if (this.f340798i.contains(downloadListener)) {
            this.f340798i.remove(downloadListener);
        }
    }

    public void E(final Activity activity, final Bundle bundle, final String str, final ApkUpdateDetail apkUpdateDetail, final int i3) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.19

            /* compiled from: P */
            /* renamed from: com.tencent.open.appstore.dl.DownloadManagerV2$19$a */
            /* loaded from: classes22.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    bundle.putBoolean(e.f341510s, false);
                    DownloadProxy k3 = DownloadProxy.k();
                    AnonymousClass19 anonymousClass19 = AnonymousClass19.this;
                    k3.g(activity, bundle, str, apkUpdateDetail, i3);
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.open.appstore.dl.DownloadManagerV2$19$b */
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
                    DownloadManagerV2.this.d0(10, new DownloadInfo(string, string2.trim(), string3, bundle.getString(e.f341503l), string4, null, str, bundle.getBoolean(e.f341516y, true)));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = new a();
                b bVar = new b();
                f.e("DownloadManagerV2", "dialog create and show");
                AlertDialog create = new AlertDialog.Builder(activity).setMessage(activity.getString(R.string.af9)).setPositiveButton(R.string.af7, bVar).setNegativeButton(R.string.af8, aVar).create();
                create.setCanceledOnTouchOutside(false);
                if (!activity.isFinishing()) {
                    create.show();
                }
            }
        });
    }

    public boolean G(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return F(DownloadInfo.b(str), z16);
    }

    public synchronized WeakReference<AppInterface> L() {
        AppInterface appInterface;
        if (this.f340793d == null) {
            try {
                if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface) && (appInterface = (AppInterface) BaseApplicationImpl.getApplication().getRuntime()) != null) {
                    this.f340793d = new WeakReference<>(appInterface);
                }
            } catch (Exception e16) {
                f.d("DownloadManagerV2", "getQQAppInterface>>>", e16);
            }
        }
        return this.f340793d;
    }

    public String M(String str) {
        DownloadInfo R = R(str);
        if (R != null) {
            return R.L;
        }
        return "";
    }

    public DownloadInfo O(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : this.f340797h.values()) {
                if (str.equals(downloadInfo.f341189h)) {
                    return downloadInfo;
                }
            }
            return null;
        }
        return null;
    }

    public List<DownloadInfo> P(String str, int i3) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (DownloadInfo downloadInfo : pp3.a.j().d(str)) {
            if (downloadInfo.f() == i3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    public List<DownloadInfo> Q(String str, int i3) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (DownloadInfo downloadInfo : this.f340797h.values()) {
            if (str.equals(downloadInfo.f341189h) && downloadInfo.f() == i3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    public DownloadInfo R(final String str) {
        if (str == null) {
            f.h("DownloadManagerV2", "getDownloadInfoByTicket ticket == null");
            return null;
        }
        DownloadInfo downloadInfo = this.f340797h.get(str);
        if (downloadInfo == null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.11
                @Override // java.lang.Runnable
                public void run() {
                    DownloadInfo g16;
                    if (DownloadManagerV2.this.f340797h.get(str) == null && (g16 = pp3.a.j().g(str)) != null) {
                        DownloadManagerV2.this.u(g16);
                    }
                }
            }, 16, null, true);
        }
        return downloadInfo;
    }

    public DownloadInfo S(String str) {
        if (TextUtils.isEmpty(str)) {
            f.h("DownloadManagerV2", "getDownloadInfoByTicket ticket == null");
            return null;
        }
        return R(DownloadInfo.b(str));
    }

    public ConcurrentHashMap<String, DownloadInfo> T() {
        return this.f340797h;
    }

    protected synchronized List<DownloadInfo> U(int i3) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (DownloadInfo downloadInfo : this.f340797h.values()) {
            if (downloadInfo.f() == i3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    public TMAssistantDownloadTaskInfo X(DownloadInfo downloadInfo) {
        Bundle bundle = new Bundle();
        bundle.putString(e.f341493b, downloadInfo.f341184e);
        bundle.putString(e.f341494c, downloadInfo.G);
        bundle.putString(e.f341495d, downloadInfo.H);
        bundle.putString(e.f341497f, downloadInfo.f341189h);
        bundle.putInt(e.f341496e, downloadInfo.I);
        bundle.putString(e.f341500i, downloadInfo.C);
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
        try {
            f.h("DownloadManagerV2", "OpenSDK getTaskInfoFromMyApp param SNGAppId=" + downloadInfo.f341184e + " apkId=" + downloadInfo.H + " taskAppId=" + downloadInfo.G + " packageName=" + downloadInfo.f341189h + " version=" + downloadInfo.I + " via=" + downloadInfo.C);
            tMAssistantDownloadTaskInfo = MyAppApi.z().y(bundle);
            if (tMAssistantDownloadTaskInfo != null) {
                f.h("DownloadManagerV2", "OpenSDK getTaskInfoFromMyApp result taskInfo path=" + tMAssistantDownloadTaskInfo.mSavePath + " state=" + tMAssistantDownloadTaskInfo.mState);
            } else {
                f.h("DownloadManagerV2", "OpenSDK getTaskInfoFromMyApp result taskInfo is null");
            }
        } catch (Exception e16) {
            f.e("DownloadManagerV2", "getTaskInfoFromMyApp>>>" + e16.getMessage());
        }
        return tMAssistantDownloadTaskInfo;
    }

    public TMAssistantDownloadTaskInfo Y(String str) {
        TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                TMAssistantDownloadClient W = W();
                long currentTimeMillis2 = System.currentTimeMillis();
                tMAssistantDownloadTaskInfo = W.getDownloadTaskState(str);
                f.c("NEW_QAPP_TIME_COST", "step1=" + (currentTimeMillis2 - currentTimeMillis) + ",step2=" + (System.currentTimeMillis() - currentTimeMillis2));
            } catch (Exception e16) {
                f.d("DownloadManagerV2", "downloadSDKClient>>>", e16);
            }
        }
        if (tMAssistantDownloadTaskInfo == null) {
            f.h("DownloadManagerV2", "getTaskInfoFromSDK null url=" + str);
        }
        return tMAssistantDownloadTaskInfo;
    }

    public boolean a0(DownloadInfo downloadInfo) {
        return b0(downloadInfo, true);
    }

    public boolean b0(DownloadInfo downloadInfo, boolean z16) {
        String str;
        if (downloadInfo == null) {
            f.h("DownloadManagerV2", "installDownload info == null");
            return false;
        }
        if (!downloadInfo.X) {
            f.h("DownloadManagerV2", "installDownload info is not apk");
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.L)) {
            TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo = null;
            if (downloadInfo.J == 0) {
                TMAssistantDownloadTaskInfo Y = Y(downloadInfo.f341186f);
                if (Y == null || Y.mState != 4) {
                    str = "";
                } else {
                    str = Y.mSavePath;
                }
                if (TextUtils.isEmpty(str) && (tMAssistantDownloadTaskInfo = X(downloadInfo)) != null) {
                    downloadInfo.J = 1;
                }
            } else {
                TMAssistantDownloadTaskInfo X = X(downloadInfo);
                if (X == null || X.mState != 4) {
                    str = "";
                } else {
                    str = X.mSavePath;
                }
                if (TextUtils.isEmpty(str)) {
                    tMAssistantDownloadTaskInfo = Y(downloadInfo.f341186f);
                }
            }
            if (tMAssistantDownloadTaskInfo != null && tMAssistantDownloadTaskInfo.mState == 4) {
                str = tMAssistantDownloadTaskInfo.mSavePath;
            }
            if (!TextUtils.isEmpty(str)) {
                downloadInfo.L = str;
                downloadInfo.k(4);
                u(downloadInfo);
            }
        } else {
            str = downloadInfo.L;
        }
        if (!new File(str).canRead()) {
            f.e("DownloadManagerV2", "can't read apk file. installDownload localAPKPath=" + str);
            return false;
        }
        String e16 = com.tencent.open.business.base.a.e(str);
        f.e("DownloadManagerV2", "installDownload localAPKPath=" + str + ", apkPackageName=" + e16 + " updateType=" + downloadInfo.E);
        if (e16 != null) {
            f.a("DownloadManagerV2", "[installDownload] begin sendCheckDownloadReq pkgname=" + e16);
            q0(downloadInfo, str, e16, z16);
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            f.h("DownloadManagerV2", "package invaild del file");
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
        e0(-2, downloadInfo, -24, "");
        return false;
    }

    public boolean c0() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    public void d0(int i3, DownloadInfo downloadInfo) {
        e0(i3, downloadInfo, 0, "");
    }

    public synchronized void f0(final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            f.e("DownloadManagerV2", "[onDownloadComplete] info == null ");
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if ((runtime instanceof QQAppInterface) && "com.tencent.mobileqq".equals(downloadInfo.f341189h) && ConfigHandler.e3((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime())) {
            downloadInfo.T = false;
        }
        f.e("DownloadManagerV2", "[onDownloadComplete] complete, info = " + downloadInfo.toString());
        if (downloadInfo.J == 0) {
            if (downloadInfo.E == 1) {
                n0(downloadInfo);
            } else {
                I(downloadInfo);
            }
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TMAssistantDownloadTaskInfo X = DownloadManagerV2.this.X(downloadInfo);
                        if (X != null) {
                            DownloadInfo downloadInfo2 = downloadInfo;
                            downloadInfo2.L = X.mSavePath;
                            DownloadManagerV2.this.u(downloadInfo2);
                            DownloadManagerV2.this.d0(4, downloadInfo);
                        }
                        f.e("AppCenterReporter", "from:[onDownloadComplete]");
                        AppCenterReporter.s(downloadInfo);
                        DownloadManagerV2.this.b0(downloadInfo, false);
                    } catch (Exception e16) {
                        f.d("DownloadManagerV2", "downloadSDKClient>>>", e16);
                    }
                }
            }, 32, null, true);
        }
        UniteDownloadDbOperator.e().c(runtime.getAccount(), downloadInfo);
        ((IDownloaderReporter) QRoute.api(IDownloaderReporter.class)).downloaderReport("DownloadV2", downloadInfo.f341186f, downloadInfo.f341180b0);
    }

    public void h0(DownloadInfo downloadInfo, int i3) {
        f.e("DownloadManagerV2", "onReveiveInstallIntent info=" + downloadInfo);
        if (downloadInfo.J == 0) {
            AppCenterReporter.t(downloadInfo, i3);
        }
        if (!"5".equals(downloadInfo.M)) {
            C(downloadInfo.f341182d, false);
        }
        com.tencent.open.downloadnew.common.a.e().a(downloadInfo.f341196m);
    }

    public void i0(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            h0(downloadInfo, 1);
            V().d0(6, downloadInfo);
        }
    }

    public void j0(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            h0(downloadInfo, 2);
            V().d0(13, downloadInfo);
        }
    }

    public void k0(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            V().d0(9, downloadInfo);
        }
    }

    public void l0(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i3) {
        DownloadInfo N = N(tMAssistantCallYYBParamStruct.SNGAppId);
        if (N == null) {
            N = MyAppApi.z().s(tMAssistantCallYYBParamStruct, null);
            u(N);
        }
        N.Q = i3;
        N.k(2);
        d0(2, N);
    }

    public void m0(TMAssistantCallYYBParamStruct tMAssistantCallYYBParamStruct, int i3, TMAssistantCallYYBTaskInfo tMAssistantCallYYBTaskInfo, int i16, String str) {
        int D = D(i3);
        DownloadInfo G0 = G0(tMAssistantCallYYBParamStruct.SNGAppId, D);
        if (G0 == null && i3 != 6) {
            G0 = MyAppApi.z().s(tMAssistantCallYYBParamStruct, null);
            u(G0);
            G0(tMAssistantCallYYBParamStruct.SNGAppId, D);
        } else if ((i3 == 2 || i3 == 3) && MyAppApi.z().R() && tMAssistantCallYYBTaskInfo != null) {
            try {
                int i17 = (int) ((((float) tMAssistantCallYYBTaskInfo.mReceiveDataLen) * 100.0f) / ((float) tMAssistantCallYYBTaskInfo.mTotalDataLen));
                if (G0 != null) {
                    G0.Q = i17;
                }
                f.e("DownloadManagerV2", "onYYBDownloadTaskStateChanged info progress = " + i17);
            } catch (Exception e16) {
                f.d("DownloadManagerV2", "onYYBDownloadTaskStateChanged>>>", e16);
            }
        }
        if (G0 != null) {
            f.e("DownloadManagerV2", "onYYBDownloadTaskStateChanged notifyListener localState=" + D + " dlInfo=" + G0.toString());
            e0(D, G0, i16, str);
            return;
        }
        f.e("DownloadManagerV2", "onYYBDownloadTaskStateChanged notifyListener error dlInfo == null");
    }

    public int o0(String str) {
        return p0(DownloadInfo.b(str));
    }

    @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
    public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient tMAssistantDownloadClient, final String str, final long j3, final long j16) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.24
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo E0 = DownloadManagerV2.this.E0(str, j3, j16);
                if (E0 == null) {
                    f.i("DownloadManagerV2", "OnDownloadSDKTaskProgressChanged info == null");
                } else {
                    f.h("DownloadManagerV2", "OnDownloadSDKTaskProgressChanged info state=" + E0.f() + " progress=" + E0.Q);
                }
                DownloadManagerV2.this.d0(2, E0);
            }
        });
    }

    @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
    public void onDownloadSDKTaskStateChanged(final TMAssistantDownloadClient tMAssistantDownloadClient, final String str, final int i3, final int i16, final String str2) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.23
            @Override // java.lang.Runnable
            public void run() {
                TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
                f.e("DownloadManagerV2", "OnDownloadStateChanged,clientKey:" + tMAssistantDownloadClient + ",state:" + i3 + ",url:" + str);
                int D = DownloadManagerV2.D(i3);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onStateChanged url: +++++loacalState=");
                sb5.append(D);
                sb5.append(" +++++downloadInfo=");
                sb5.append(DownloadManagerV2.this.S(str));
                f.h("DownloadManagerV2", sb5.toString());
                DownloadInfo F0 = DownloadManagerV2.this.F0(str, D);
                if (F0 == null) {
                    f.i("DownloadManagerV2", "OnDownloadSDKTaskStateChanged info == null");
                    return;
                }
                TMAssistantDownloadClient tMAssistantDownloadClient2 = tMAssistantDownloadClient;
                if (tMAssistantDownloadClient2 != null) {
                    try {
                        tMAssistantDownloadTaskInfo = tMAssistantDownloadClient2.getDownloadTaskState(str);
                    } catch (Exception e16) {
                        f.d("DownloadManagerV2", "getDownloadTaskState>>>", e16);
                        tMAssistantDownloadTaskInfo = null;
                    }
                    if (tMAssistantDownloadTaskInfo != null) {
                        int i17 = (int) ((((float) tMAssistantDownloadTaskInfo.mReceiveDataLen) * 100.0f) / ((float) tMAssistantDownloadTaskInfo.mTotalDataLen));
                        F0.Q = i17;
                        F0.L = tMAssistantDownloadTaskInfo.mSavePath;
                        f.h("DownloadManagerV2", "OnDownloadSDKTaskStateChanged info progress = " + i17 + ", " + tMAssistantDownloadTaskInfo.mReceiveDataLen + "|" + tMAssistantDownloadTaskInfo.mTotalDataLen);
                    }
                }
                if (D == -2) {
                    DownloadManagerV2.this.e0(-2, F0, i16, str2);
                    return;
                }
                if (D != 10) {
                    if (D != 20) {
                        if (D != 2) {
                            if (D != 3) {
                                if (D == 4) {
                                    DownloadManagerV2.this.f0(F0);
                                    return;
                                }
                                return;
                            }
                            DownloadManagerV2.this.d0(3, F0);
                            return;
                        }
                        DownloadManagerV2.this.d0(2, F0);
                        return;
                    }
                    DownloadManagerV2.this.d0(20, F0);
                    return;
                }
                DownloadManagerV2.this.d0(10, F0);
            }
        });
    }

    @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
    public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient tMAssistantDownloadClient) {
        f.c("DownloadManagerV2", "OnDwonloadSDKServiceInvalid");
    }

    public boolean r0(DownloadInfo downloadInfo) {
        String str;
        f.h("DownloadManagerV2", "refreshDownloadInfo DownloadInfo=" + downloadInfo);
        DownloadInfo R = R(downloadInfo.f341182d);
        if (R == null) {
            R = O(downloadInfo.f341189h);
        }
        if (R != null) {
            f.h("DownloadManagerV2", "refreshDownloadInfo cacheInfo =" + R);
            int i3 = R.J;
            int i16 = 3;
            if (i3 == 0) {
                f.h("DownloadManagerV2", "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
                downloadInfo.W = R.W;
                if (R.E == 1) {
                    str = R.F;
                } else {
                    str = R.f341186f;
                }
                TMAssistantDownloadTaskInfo Y = V().Y(str);
                if (Y != null) {
                    f.h("DownloadManagerV2", "refreshDownloadInfo sdk getReceiveDataLen=" + Y.mReceiveDataLen + " getTotalDataLen=" + Y.mTotalDataLen);
                    downloadInfo.Q = (int) ((((float) Y.mReceiveDataLen) * 100.0f) / ((float) Y.mTotalDataLen));
                    downloadInfo.k(D(Y.mState));
                    downloadInfo.J = 0;
                    if (R.E == 1) {
                        if (TextUtils.isEmpty(R.L)) {
                            downloadInfo.L = Y.mSavePath;
                        } else {
                            downloadInfo.L = R.L;
                        }
                    } else {
                        downloadInfo.L = Y.mSavePath;
                    }
                    if (downloadInfo.f() == 4) {
                        int i17 = R.f341179a0;
                        downloadInfo.f341179a0 = i17;
                        if (i17 != 0) {
                            downloadInfo.k(3);
                            u(R);
                        }
                    }
                    return true;
                }
                u0(R);
                downloadInfo.k(-100);
                return true;
            }
            if (i3 == 1) {
                TMAssistantDownloadTaskInfo X = X(R);
                if (X != null) {
                    int D = D(X.mState);
                    if (D != -2) {
                        i16 = D;
                    }
                    downloadInfo.k(i16);
                    downloadInfo.J = 1;
                    downloadInfo.L = X.mSavePath;
                    downloadInfo.Q = (int) ((((float) X.mReceiveDataLen) * 100.0f) / ((float) X.mTotalDataLen));
                    if (!MyAppApi.z().R()) {
                        downloadInfo.Q = 0;
                    }
                    return true;
                }
                u0(R);
            }
        }
        return false;
    }

    public boolean s0(b bVar) {
        if (bVar == null) {
            return false;
        }
        this.f340795f = bVar;
        return true;
    }

    public synchronized void t0(DownloadListener downloadListener) {
        if (!this.f340798i.contains(downloadListener)) {
            this.f340798i.add(downloadListener);
        }
    }

    public void u(DownloadInfo downloadInfo) {
        v(downloadInfo, false);
    }

    public synchronized void v(final DownloadInfo downloadInfo, final boolean z16) {
        if (downloadInfo != null) {
            downloadInfo.m();
            if (TextUtils.isEmpty(downloadInfo.f341182d)) {
                return;
            }
            f.e("DownloadManagerV2", "addDownloadInfo info.appId = " + downloadInfo.f341184e + ",info.packageName = " + downloadInfo.f341189h + ",info.filePath = " + downloadInfo.L + "info.notificationStyle =" + downloadInfo.N);
            this.f340797h.put(downloadInfo.f341182d, downloadInfo);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.17
                @Override // java.lang.Runnable
                public void run() {
                    pp3.a.j().a(downloadInfo, z16);
                }
            }, 32, null, true);
        }
    }

    public void v0(DownloadInfo downloadInfo, long j3) {
        int i3;
        Bundle bundle;
        if (L() != null && L().get() != null && L().get() != null) {
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
            f.e("DownloadManagerV2", "reportDownloadResult info.packageName = " + downloadInfo.f341189h + ",info.urlStr = " + downloadInfo.f341186f + ",info.filePath = " + downloadInfo.L);
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

    public boolean x(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return w(DownloadInfo.b(str), z16);
    }

    public synchronized void x0(AppInterface appInterface) {
        this.f340793d = new WeakReference<>(appInterface);
    }

    public void y(boolean z16) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        String str = "";
        String str2 = "";
        for (DownloadInfo downloadInfo : this.f340797h.values()) {
            if (downloadInfo != null && downloadInfo.f() != 4 && downloadInfo.f() != 1 && downloadInfo.J == 1) {
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
                d0(10, downloadInfo2);
            }
        }
        boolean z17 = QAppCenterPluginProxyActivityTools.f390374a0;
        if (z16 && i3 > 0) {
            StringBuilder sb5 = new StringBuilder();
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + HardCodeUtil.qqStr(R.string.f171904ls2);
            }
            sb5.append(str);
            sb5.append(i3);
            sb5.append(HardCodeUtil.qqStr(R.string.lsc));
            String sb6 = sb5.toString();
            if (z17) {
                ToastUtil.a().f(sb6, 1);
            } else {
                MyAppApi.z().g0(true, sb6);
            }
        }
    }

    public void y0(String str) {
        try {
            if (BaseActivity.sTopActivity.isResume() && System.currentTimeMillis() - this.f340803n > 1000) {
                this.f340803n = System.currentTimeMillis();
                ToastUtil.a().e(str);
            }
        } catch (Exception e16) {
            f.d("DownloadManagerV2", "showToast>>>", e16);
        }
    }

    public void z(String str) {
        if (str != null && str.trim().length() > 0) {
            com.tencent.open.downloadnew.common.a.e().a(str);
        }
    }

    public synchronized void z0(final DownloadInfo downloadInfo) {
        com.tencent.mobileqq.download.unite.core.a.c().e(downloadInfo, new Runnable() { // from class: com.tencent.open.appstore.dl.DownloadManagerV2.12
            @Override // java.lang.Runnable
            public void run() {
                DownloadManagerV2.this.A0(downloadInfo);
            }
        });
    }
}
