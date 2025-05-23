package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.DownloadReportReq;
import Wallet.JudgeDownloadReq;
import Wallet.JudgeDownloadRsp;
import Wallet.ResInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.impl.QWalletPreferenceApiImpl;
import com.tencent.mobileqq.qwallet.impl.servlet.request.DownloadReportRequest;
import com.tencent.mobileqq.qwallet.impl.servlet.request.JudgeDownloadRequest;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.util.e;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class PreloadResourceImpl implements IPreloadResource {
    private static final long serialVersionUID = 1;

    /* renamed from: d, reason: collision with root package name */
    private transient PreloadFlowControlConfig f279032d;

    /* renamed from: e, reason: collision with root package name */
    private transient boolean f279033e;

    /* renamed from: f, reason: collision with root package name */
    private transient long f279034f;
    public String mAbi;
    public String mDownloadTime;
    public int mFilePos;
    public boolean mFlowControl;
    public int mFromType;

    @Deprecated
    public boolean mHasUnzip;
    public String mInvalidTime;
    public boolean mIsFromLocal;

    @Deprecated
    public boolean mIsNeedUnzip;
    public boolean mIsTemp;

    @Deprecated
    public boolean mIsUnzipInside;
    private PreloadTimerTask mReqTask;
    public String mResId;
    public int mRetryTime;

    @Deprecated
    public String mUnzipPrefix;
    public String md5;
    public String netType;
    public int size;
    public int type;
    public String url;
    public String urlPath;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static abstract class PreloadTimerTask extends TimerTask {

        /* renamed from: d, reason: collision with root package name */
        private boolean f279037d = false;

        public abstract void e();

        public boolean f() {
            return this.f279037d;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            e();
            this.f279037d = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f279038a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f279039b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f279040c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f279041d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f279042e;

        a(int i3, WeakReference weakReference, f fVar, long j3) {
            this.f279039b = i3;
            this.f279040c = weakReference;
            this.f279041d = fVar;
            this.f279042e = j3;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(g gVar) {
            int i3;
            long j3;
            PreloadServiceImpl preloadServiceImpl = (PreloadServiceImpl) this.f279040c.get();
            if (PreloadServiceImpl.isManagerValid(preloadServiceImpl)) {
                preloadServiceImpl.notifyResFlowCheckNext();
            }
            f fVar = this.f279041d;
            if (fVar != null) {
                fVar.onDoneFile(gVar);
            }
            DownloadReportReq downloadReportReq = new DownloadReportReq();
            if (gVar.f313006d == 0) {
                downloadReportReq.iType = 1;
            } else {
                downloadReportReq.iType = 2;
            }
            if (gVar.f313010h != null && !TextUtils.isEmpty(gVar.f313004c)) {
                File file = gVar.f313010h.get(gVar.f313004c);
                if (file == null) {
                    j3 = -2;
                } else {
                    try {
                        if (file.exists()) {
                            j3 = file.length();
                        } else {
                            j3 = -3;
                        }
                    } catch (Throwable th5) {
                        QLog.e("PreloadResource", 1, "error msg in qqpay-impl module: ", th5);
                        i3 = -4;
                    }
                }
                i3 = (int) j3;
            } else {
                i3 = -1;
            }
            downloadReportReq.vecResInfo = PreloadResourceImpl.this.getMyResInfos(i3);
            downloadReportReq.iUin = this.f279042e;
            downloadReportReq.sPhoneType = ah.F();
            downloadReportReq.sOsVersion = ah.t();
            downloadReportReq.sQQVersion = ah.P();
            downloadReportReq.iScene = gVar.h().getInt("scene");
            com.tencent.mobileqq.qwallet.impl.servlet.c.c(new DownloadReportRequest(downloadReportReq), null);
            if (QLog.isColorLevel()) {
                QLog.d("PreloadResource", 2, PreloadResourceImpl.this.mResId + " flow down result:" + gVar.f313006d + downloadReportReq);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(g gVar) {
            if (!this.f279038a) {
                this.f279038a = true;
                double currentTimeMillis = gVar.G / (System.currentTimeMillis() - gVar.H);
                if (currentTimeMillis < 1.0d) {
                    return;
                }
                DownloadReportReq downloadReportReq = new DownloadReportReq();
                downloadReportReq.sSpeed = currentTimeMillis + "";
                downloadReportReq.vecResInfo = PreloadResourceImpl.this.getMyResInfos();
                downloadReportReq.iType = 0;
                downloadReportReq.iUin = this.f279042e;
                com.tencent.mobileqq.qwallet.impl.servlet.c.c(new DownloadReportRequest(downloadReportReq), null);
                if (QLog.isColorLevel()) {
                    QLog.d("PreloadResource", 2, PreloadResourceImpl.this.mResId + " flow down speed:" + currentTimeMillis);
                }
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(g gVar) {
            gVar.G = 1048576L;
            int i3 = this.f279039b;
            if (i3 <= 3) {
                i3 = 3;
            }
            gVar.f313008f = i3;
            return super.onStart(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f279044d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f279045e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PreloadModuleImpl f279046f;

        b(WeakReference weakReference, f fVar, PreloadModuleImpl preloadModuleImpl) {
            this.f279044d = weakReference;
            this.f279045e = fVar;
            this.f279046f = preloadModuleImpl;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (i3 == 1) {
                try {
                    PreloadServiceImpl preloadServiceImpl = (PreloadServiceImpl) this.f279044d.get();
                    if (!PreloadServiceImpl.isManagerValid(preloadServiceImpl)) {
                        return;
                    }
                    if (!z16) {
                        preloadServiceImpl.notifyResFlowCheckNext();
                        return;
                    }
                    JudgeDownloadRsp judgeDownloadRsp = (JudgeDownloadRsp) bundle.getSerializable("rsp");
                    if (judgeDownloadRsp == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PreloadResource", 2, "onReceive rsp is null:" + judgeDownloadRsp);
                        }
                        preloadServiceImpl.notifyResFlowCheckNext();
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("PreloadResource", 2, PreloadResourceImpl.this.mResId + "FlowControlRsp|" + judgeDownloadRsp.iDownloadStatus + "|" + judgeDownloadRsp.iSegTime + "|" + judgeDownloadRsp.iFailedRetryMax);
                    }
                    synchronized (PreloadResourceImpl.this.f279032d) {
                        int i16 = judgeDownloadRsp.iDownloadStatus;
                        int i17 = 60;
                        if (i16 != 0) {
                            if (i16 != 1) {
                                PreloadResourceImpl.this.f279032d.mDownloadStatus = 2;
                                PreloadFlowControlConfig preloadFlowControlConfig = PreloadResourceImpl.this.f279032d;
                                int i18 = judgeDownloadRsp.iSegTime;
                                if (i18 > 60) {
                                    i17 = i18;
                                }
                                preloadFlowControlConfig.mNextCanReqTime = (i17 * 1000) + NetConnInfoCenter.getServerTimeMillis();
                            } else {
                                PreloadResourceImpl.this.f279032d.mDownloadStatus = 1;
                                PreloadFlowControlConfig preloadFlowControlConfig2 = PreloadResourceImpl.this.f279032d;
                                int i19 = judgeDownloadRsp.iFailedRetryMax;
                                if (i19 <= 0) {
                                    i19 = 3;
                                }
                                preloadFlowControlConfig2.mRetryDownloadTimes = i19;
                                PreloadFlowControlConfig preloadFlowControlConfig3 = PreloadResourceImpl.this.f279032d;
                                int i26 = judgeDownloadRsp.iSegTime;
                                if (i26 > 60) {
                                    i17 = i26;
                                }
                                preloadFlowControlConfig3.mValidDownloadTime = (i17 * 1000) + NetConnInfoCenter.getServerTimeMillis();
                            }
                        } else {
                            PreloadResourceImpl.this.f279032d.mDownloadStatus = 0;
                            PreloadFlowControlConfig preloadFlowControlConfig4 = PreloadResourceImpl.this.f279032d;
                            int i27 = judgeDownloadRsp.iSegTime;
                            if (i27 > 60) {
                                i17 = i27;
                            }
                            preloadFlowControlConfig4.mNextRetryReqTime = (i17 * 1000) + NetConnInfoCenter.getServerTimeMillis();
                        }
                        if (judgeDownloadRsp.iDownloadStatus != 0) {
                            PreloadResourceImpl.this.f279032d.mRetryReqTimes = 0;
                        }
                        PreloadResourceImpl.this.f279032d.saveConfig();
                    }
                    int i28 = judgeDownloadRsp.iDownloadStatus;
                    if (i28 == 2) {
                        preloadServiceImpl.notifyResFlowCheckNext();
                        f fVar = this.f279045e;
                        if (fVar != null) {
                            PreloadResourceImpl.this.notifyListenerDownloadFailInFlowControl(fVar, this.f279046f, preloadServiceImpl);
                            return;
                        }
                        return;
                    }
                    if (i28 == 0) {
                        PreloadResourceImpl.this.handleFlowConfig(preloadServiceImpl, this.f279046f, this.f279045e);
                    } else if (i28 == 1) {
                        PreloadResourceImpl.this.handleFlowConfig(preloadServiceImpl, this.f279046f, this.f279045e);
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PreloadResource", 2, PreloadResourceImpl.this.mResId + " startFlowControlReq onReceive exception:" + th5);
                    }
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    public class c extends d {
        public c(f fVar) {
            super(fVar);
        }

        private int b(String str, boolean z16) {
            int b16 = com.tencent.mobileqq.qwallet.preload.impl.b.b(str, 0, PreloadResourceImpl.this.getFilePos());
            if (b16 == 0) {
                if (z16) {
                    com.tencent.mobileqq.qwallet.preload.impl.b.d(str, 1, PreloadResourceImpl.this.getFilePos());
                }
                return 1;
            }
            if (b16 == 1) {
                return 7;
            }
            if (z16) {
                com.tencent.mobileqq.qwallet.preload.impl.b.d(str, 1, PreloadResourceImpl.this.getFilePos());
                return b16;
            }
            return b16;
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0137  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0176  */
        /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.d, com.tencent.mobileqq.vip.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onDoneFile(g gVar) {
            String absolutePath;
            boolean z16;
            int b16;
            if (gVar != null && gVar.f313010h != null && !TextUtils.isEmpty(gVar.f313004c)) {
                Bundle h16 = gVar.h();
                PreloadModuleImpl preloadModuleImpl = (PreloadModuleImpl) h16.getSerializable("module");
                PreloadResourceImpl preloadResourceImpl = (PreloadResourceImpl) h16.getSerializable("resource");
                File file = gVar.f313010h.get(gVar.f313004c);
                if (file == null) {
                    absolutePath = "";
                } else {
                    absolutePath = file.getAbsolutePath();
                }
                boolean z17 = false;
                if (gVar.f313006d == 0 && preloadResourceImpl != null) {
                    String encodeFile2HexStr = MD5Coding.encodeFile2HexStr(absolutePath);
                    if (file != null && file.exists() && !TextUtils.isEmpty(encodeFile2HexStr)) {
                        if (!TextUtils.isEmpty(preloadResourceImpl.md5) && !encodeFile2HexStr.equalsIgnoreCase(preloadResourceImpl.md5)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("PreloadResource", 2, "preload onDoneFile md5 not match|" + preloadResourceImpl.mResId + "|" + encodeFile2HexStr + "|" + preloadResourceImpl.md5);
                            }
                            com.tencent.mobileqq.qwallet.impl.d.d(absolutePath);
                            com.tencent.mobileqq.qwallet.preload.impl.b.d(gVar.f313004c, 5, PreloadResourceImpl.this.getFilePos());
                            gVar.f313006d = -1;
                            ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).reportResPreload(preloadModuleImpl, "RESULT_RES_PRELOAD_FAIL_MD5_CHECK", gVar.f313011i, gVar.f313006d);
                            z16 = true;
                            if (gVar.f313006d == -118) {
                                z16 = true;
                            }
                            if (z16 && preloadModuleImpl != null) {
                                preloadModuleImpl.removeResource(preloadResourceImpl);
                            }
                            String str = gVar.f313004c;
                            if (gVar.f313006d == 0) {
                                z17 = true;
                            }
                            b16 = b(str, z17);
                            gVar.h().putInt("scene", b16);
                            if (b16 == 7 && gVar.f313006d == 0) {
                                com.tencent.mobileqq.qwallet.preload.impl.c.j(gVar.f313004c, PreloadResourceImpl.this.getFilePos());
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("PreloadResource", 2, "preload onDoneFile|" + gVar.f313006d + "|" + gVar.f313004c + "|" + absolutePath + "|" + b16);
                            }
                            PreloadResConfigPrinter.f279031a.b(gVar, PreloadResourceImpl.this);
                            super.onDoneFile(gVar);
                            if (!PreloadResourceImpl.this.isNeedReport(gVar.f313004c)) {
                                PreloadResourceImpl.this.reportDownload(gVar.f313004c, gVar.f313006d, preloadModuleImpl);
                                return;
                            }
                            return;
                        }
                        com.tencent.mobileqq.qwallet.preload.impl.c.o(gVar.f313004c, encodeFile2HexStr, NetConnInfoCenter.getServerTimeMillis(), PreloadResourceImpl.this.getFilePos());
                        if (PreloadResourceImpl.this.d(absolutePath, gVar.f313004c)) {
                            PreloadResourceImpl.this.unzip(absolutePath, gVar.f313004c);
                        }
                        ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).reportResPreload(preloadModuleImpl, "RESULT_RES_PRELOAD_SUCC", gVar.f313011i, gVar.f313006d);
                    }
                } else {
                    ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).reportResPreload(preloadModuleImpl, "RESULT_RES_PRELOAD_FAIL_DOWNLOAD", gVar.f313011i, gVar.f313006d);
                }
                z16 = false;
                if (gVar.f313006d == -118) {
                }
                if (z16) {
                    preloadModuleImpl.removeResource(preloadResourceImpl);
                }
                String str2 = gVar.f313004c;
                if (gVar.f313006d == 0) {
                }
                b16 = b(str2, z17);
                gVar.h().putInt("scene", b16);
                if (b16 == 7) {
                    com.tencent.mobileqq.qwallet.preload.impl.c.j(gVar.f313004c, PreloadResourceImpl.this.getFilePos());
                }
                if (QLog.isColorLevel()) {
                }
                PreloadResConfigPrinter.f279031a.b(gVar, PreloadResourceImpl.this);
                super.onDoneFile(gVar);
                if (!PreloadResourceImpl.this.isNeedReport(gVar.f313004c)) {
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    public static abstract class d extends f {

        /* renamed from: a, reason: collision with root package name */
        private f f279049a;

        public d(f fVar) {
            this.f279049a = fVar;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(g gVar) {
            super.onDoneFile(gVar);
            f fVar = this.f279049a;
            if (fVar != null) {
                fVar.onDoneFile(gVar);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(g gVar) {
            super.onProgress(gVar);
            f fVar = this.f279049a;
            if (fVar != null) {
                fVar.onProgress(gVar);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(g gVar) {
            f fVar = this.f279049a;
            if (fVar != null) {
                fVar.onStart(gVar);
            }
            return super.onStart(gVar);
        }
    }

    public PreloadResourceImpl() {
        this.mIsFromLocal = false;
        this.mRetryTime = 0;
        this.mReqTask = null;
        this.f279034f = 0L;
    }

    private static boolean c(String str) {
        File[] listFiles;
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            if (file.length() <= 0) {
                return false;
            }
            return true;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.exists()) {
                    if (file2.isDirectory()) {
                        if (c(file2.getAbsolutePath())) {
                            return true;
                        }
                    } else if (file2.isFile() && file2.length() > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static synchronized boolean checkFolderAndUnzip(String str, String str2) {
        synchronized (PreloadResourceImpl.class) {
            if (isFolderPathValid(str2)) {
                return true;
            }
            return com.tencent.mobileqq.qwallet.preload.a.u(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(String str, String str2) {
        if (com.tencent.mobileqq.qwallet.preload.a.s(str2, this.type) && !isFolderPathValid(getFolderPath(str2, str))) {
            return true;
        }
        return false;
    }

    private void e(f fVar, PreloadModuleImpl preloadModuleImpl, PreloadServiceImpl preloadServiceImpl) {
        if (fVar == null) {
            return;
        }
        String resDownloadUrl = getResDownloadUrl(preloadModuleImpl);
        g gVar = new g(resDownloadUrl, new File(com.tencent.mobileqq.qwallet.preload.a.g(resDownloadUrl, getFilePos())));
        gVar.f313006d = 0;
        gVar.w(getDownloadParams(preloadModuleImpl));
        fVar.onDoneFile(gVar);
    }

    public static String getFolderPathByMD5AndUrl(String str, String str2, int i3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return com.tencent.mobileqq.qwallet.preload.a.l(i3) + MD5.toMD5(str2 + str);
        }
        return null;
    }

    public static boolean isFolderPathValid(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists() && c(str)) {
            return true;
        }
        return false;
    }

    public static boolean isPreloadRetryProtectTestOpen() {
        return com.tencent.mobileqq.qwallet.utils.g.c("qwalley_key_preload_retry_protect", false);
    }

    public static boolean isValidToReport(long j3, long j16) {
        if (Math.abs(j16 - j3) > 1000) {
            return true;
        }
        return false;
    }

    public static PreloadResourceImpl parsePreloadResource(JSONObject jSONObject, PreloadModuleImpl preloadModuleImpl, boolean z16, int i3) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        PreloadResourceImpl preloadResourceImpl = new PreloadResourceImpl();
        try {
            preloadResourceImpl.url = jSONObject.optString("url");
            preloadResourceImpl.urlPath = jSONObject.optString("url_path");
            preloadResourceImpl.type = jSONObject.optInt("type");
            preloadResourceImpl.md5 = jSONObject.optString("md5");
            preloadResourceImpl.mDownloadTime = jSONObject.optString(ImageManagerEnv.MTA_VALUE_DOWNLOAD_TIME);
            preloadResourceImpl.mInvalidTime = jSONObject.optString("invalid_time");
            preloadResourceImpl.netType = jSONObject.optString("net_type");
            preloadResourceImpl.size = jSONObject.optInt("size");
            if (jSONObject.optInt(Constants.KEYS.FLOW_CONTROL) == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            preloadResourceImpl.mFlowControl = z17;
            preloadResourceImpl.mIsFromLocal = z16;
            if (jSONObject.optInt("is_temp") == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            preloadResourceImpl.mIsTemp = z18;
            if (jSONObject.optInt("is_need_unzip") == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            preloadResourceImpl.mIsNeedUnzip = z19;
            if (jSONObject.optInt("is_unzip_inside") == 1) {
                z26 = true;
            } else {
                z26 = false;
            }
            preloadResourceImpl.mIsUnzipInside = z26;
            preloadResourceImpl.mUnzipPrefix = jSONObject.optString("unzip_prefix");
            preloadResourceImpl.mFromType = i3;
            preloadResourceImpl.mFilePos = jSONObject.optInt("file_pos", 0);
            preloadResourceImpl.mAbi = jSONObject.optString("abi", "32");
            String optString = jSONObject.optString(IPreloadServiceProxy.KEY_RESID);
            if (!TextUtils.isEmpty(optString)) {
                preloadResourceImpl.mResId = optString;
            } else {
                preloadResourceImpl.mResId = preloadResourceImpl.getResDownloadUrl(preloadModuleImpl);
            }
        } catch (Throwable th5) {
            QLog.e("PreloadResource", 1, "error msg in qqpay-impl module: ", th5);
        }
        return preloadResourceImpl;
    }

    public static synchronized boolean unzipToCustomPath(String str, String str2) {
        synchronized (PreloadResourceImpl.class) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!com.tencent.mobileqq.qwallet.preload.a.q(str2)) {
                    return false;
                }
                return com.tencent.mobileqq.qwallet.impl.d.B(str, str2, true);
            }
            return false;
        }
    }

    public void deleteResFile(PreloadModuleImpl preloadModuleImpl, int i3) {
        FileUtils.deleteFile(PreloadFlowControlConfig.getConfigPath(this.mResId));
        String resDownloadUrl = getResDownloadUrl(preloadModuleImpl);
        String g16 = com.tencent.mobileqq.qwallet.preload.a.g(resDownloadUrl, getFilePos());
        if (i3 == 9) {
            com.tencent.mobileqq.qwallet.preload.impl.b.c(resDownloadUrl, getFilePos());
        } else {
            com.tencent.mobileqq.qwallet.preload.impl.b.d(resDownloadUrl, i3, getFilePos());
        }
        if (com.tencent.mobileqq.qwallet.preload.a.s(resDownloadUrl, this.type)) {
            String folderPath = getFolderPath(this.url, g16);
            if (!TextUtils.isEmpty(folderPath)) {
                FileUtils.delete(folderPath, false);
            }
        }
        FileUtils.deleteFile(g16);
        com.tencent.mobileqq.qwallet.preload.impl.c.k(resDownloadUrl, getFilePos());
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PreloadResourceImpl) && com.tencent.mobileqq.qwallet.impl.d.r(this.mResId, ((PreloadResourceImpl) obj).mResId)) {
            return true;
        }
        return false;
    }

    public Bundle getDownloadParams(PreloadModuleImpl preloadModuleImpl) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("module", preloadModuleImpl);
        bundle.putSerializable("resource", this);
        return bundle;
    }

    public int getFilePos() {
        if (com.tencent.mobileqq.qwallet.preload.a.f278999a) {
            return 1;
        }
        return this.mFilePos;
    }

    public f getFlowControlDownloadListener(long j3, f fVar, PreloadServiceImpl preloadServiceImpl, int i3) {
        return new a(i3, new WeakReference(preloadServiceImpl), fVar, j3);
    }

    public String getFolderPath(String str, String str2) {
        if (com.tencent.mobileqq.qwallet.preload.a.s(str, this.type)) {
            return getFolderPathByMD5AndUrl(com.tencent.mobileqq.qwallet.preload.impl.c.e(str, str2, getFilePos()), str, getFilePos());
        }
        return null;
    }

    public ArrayList<ResInfo> getMyResInfos() {
        return getMyResInfos(this.size);
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadResource
    public String getResDownloadUrl(kl2.a aVar) {
        if (!TextUtils.isEmpty(this.url)) {
            return this.url;
        }
        return aVar.getBaseUrl() + "/" + this.urlPath;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadResource
    public String getResId() {
        return this.mResId;
    }

    public ResourceInfo getResInfo(PreloadModuleImpl preloadModuleImpl) {
        ResourceInfo f16 = com.tencent.mobileqq.qwallet.preload.impl.c.f(getResDownloadUrl(preloadModuleImpl), !this.mIsNeedUnzip, this.type, getFilePos());
        f16.type = this.type;
        f16.resId = this.mResId;
        return f16;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadResource
    public int getType() {
        return this.type;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadResource
    public String getUrl() {
        return this.url;
    }

    public boolean handleAbnormalRetry(PreloadModuleImpl preloadModuleImpl) {
        int b16 = com.tencent.mobileqq.qwallet.preload.impl.c.b(getResDownloadUrl(preloadModuleImpl), getFilePos());
        long a16 = com.tencent.mobileqq.qwallet.preload.impl.c.a(getResDownloadUrl(preloadModuleImpl), getFilePos());
        if (QLog.isColorLevel()) {
            QLog.d("PreloadResource", 2, "[handleAbnormalRetry]:" + this.url + "|" + b16 + "|" + a16 + "|" + preloadModuleImpl.mRetryTimeInterval + "|" + preloadModuleImpl.mRetryCount);
        }
        if (isRetryProtectOpen()) {
            if (b16 > preloadModuleImpl.mRetryCount) {
                if (!isResFileExist(preloadModuleImpl)) {
                    return true;
                }
            } else if (b16 >= 1 && Math.abs(NetConnInfoCenter.getServerTimeMillis() - a16) < preloadModuleImpl.mRetryTimeInterval * 60 * 60 * 1000) {
                this.f279033e = true;
                if (QLog.isColorLevel()) {
                    QLog.d("PreloadResource", 2, "ignore set to true for" + this.mResId);
                }
                return false;
            }
        }
        this.f279033e = false;
        return false;
    }

    public void handleFlowConfig(IPreloadService iPreloadService, final PreloadModuleImpl preloadModuleImpl, f fVar) {
        PreloadFlowControlConfig preloadFlowControlConfig;
        long j3;
        float f16;
        PreloadServiceImpl preloadServiceImpl = (PreloadServiceImpl) iPreloadService;
        if (isResFileExist(preloadModuleImpl)) {
            if (isNeedUnzip(preloadModuleImpl)) {
                unzip(com.tencent.mobileqq.qwallet.preload.a.g(getResDownloadUrl(preloadModuleImpl), getFilePos()), getResDownloadUrl(preloadModuleImpl));
            }
            if (fVar != null) {
                e(fVar, preloadModuleImpl, preloadServiceImpl);
            }
            preloadServiceImpl.notifyResFlowCheckNext();
            return;
        }
        if (this.f279032d == null) {
            this.f279032d = PreloadFlowControlConfig.getFlowControlConfig(this.mResId);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PreloadResource", 2, this.mResId + "handleFlowConfig:" + this.f279032d.mDownloadStatus);
        }
        long a16 = com.tencent.mobileqq.base.a.a();
        String F = ah.F();
        String P = ah.P();
        float l3 = (float) ah.l();
        float m3 = (float) ah.m();
        int n3 = ah.n();
        long c16 = m.c() / 1024;
        PreloadFlowControlConfig preloadFlowControlConfig2 = this.f279032d;
        synchronized (preloadFlowControlConfig2) {
            try {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                int i3 = this.f279032d.mDownloadStatus;
                if (i3 != -1) {
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                preloadServiceImpl.notifyResFlowCheckNext();
                            } else {
                                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(this.mResId);
                                    sb5.append(" STATUS_NOT_DOWNLOAD|");
                                    sb5.append(serverTimeMillis);
                                    sb5.append("|");
                                    f16 = m3;
                                    sb5.append(this.f279032d.mNextCanReqTime);
                                    QLog.d("PreloadResource", 2, sb5.toString());
                                } else {
                                    f16 = m3;
                                }
                                if (serverTimeMillis > this.f279032d.mNextCanReqTime) {
                                    startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), a16, 0, F, P, l3, f16, n3, c16), preloadServiceImpl, preloadModuleImpl, fVar);
                                } else {
                                    preloadServiceImpl.notifyResFlowCheckNext();
                                    if (fVar != null) {
                                        notifyListenerDownloadFailInFlowControl(fVar, preloadModuleImpl, preloadServiceImpl);
                                    }
                                }
                            }
                            preloadFlowControlConfig = preloadFlowControlConfig2;
                        } else {
                            long serverTimeMillis2 = NetConnInfoCenter.getServerTimeMillis();
                            if (QLog.isColorLevel()) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(this.mResId);
                                sb6.append("STATUS_NOW_DOWNLOAD|");
                                sb6.append(serverTimeMillis2);
                                sb6.append("|");
                                j3 = a16;
                                sb6.append(this.f279032d.mValidDownloadTime);
                                QLog.d("PreloadResource", 2, sb6.toString());
                            } else {
                                j3 = a16;
                            }
                            if (serverTimeMillis2 < this.f279032d.mValidDownloadTime) {
                                if (isTimeToDownload(preloadServiceImpl)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("PreloadResource", 2, this.mResId + "begin download");
                                    }
                                    preloadFlowControlConfig = preloadFlowControlConfig2;
                                    startDownloadRes(preloadModuleImpl, preloadServiceImpl, getFlowControlDownloadListener(j3, fVar, preloadServiceImpl, this.f279032d.mRetryDownloadTimes), true);
                                } else {
                                    preloadFlowControlConfig = preloadFlowControlConfig2;
                                    preloadServiceImpl.notifyResFlowCheckNext();
                                    if (fVar != null) {
                                        notifyListenerDownloadFailInFlowControl(fVar, preloadModuleImpl, preloadServiceImpl);
                                    }
                                }
                            } else {
                                preloadFlowControlConfig = preloadFlowControlConfig2;
                                startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), j3, 0, F, P, l3, m3, n3, c16), preloadServiceImpl, preloadModuleImpl, fVar);
                            }
                        }
                    } else {
                        preloadFlowControlConfig = preloadFlowControlConfig2;
                        long serverTimeMillis3 = NetConnInfoCenter.getServerTimeMillis();
                        long j16 = this.f279032d.mNextRetryReqTime - serverTimeMillis3;
                        if (QLog.isColorLevel()) {
                            QLog.d("PreloadResource", 2, this.mResId + "STATUS_WAIT_TO_REQ|" + serverTimeMillis3 + "|" + this.f279032d.mNextRetryReqTime + "|" + j16);
                        }
                        if (j16 <= 0) {
                            ArrayList<ResInfo> myResInfos = getMyResInfos();
                            PreloadFlowControlConfig preloadFlowControlConfig3 = this.f279032d;
                            int i16 = preloadFlowControlConfig3.mRetryReqTimes + 1;
                            preloadFlowControlConfig3.mRetryReqTimes = i16;
                            startFlowControlReq(JudgeDownloadReq.createReq(myResInfos, a16, i16, F, P, l3, m3, n3, c16), preloadServiceImpl, preloadModuleImpl, fVar);
                        } else {
                            PreloadTimerTask preloadTimerTask = this.mReqTask;
                            if (preloadTimerTask == null || preloadTimerTask.f()) {
                                final WeakReference weakReference = new WeakReference(preloadServiceImpl);
                                this.mReqTask = new PreloadTimerTask() { // from class: com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.1
                                    @Override // com.tencent.mobileqq.qwallet.preload.impl.PreloadResourceImpl.PreloadTimerTask
                                    public void e() {
                                        PreloadServiceImpl preloadServiceImpl2 = (PreloadServiceImpl) weakReference.get();
                                        if (PreloadServiceImpl.isManagerValid(preloadServiceImpl2) && preloadServiceImpl2.isResInConfig(PreloadResourceImpl.this)) {
                                            preloadServiceImpl2.addResToFlowControlCheck(new PreloadServiceImpl.d(PreloadResourceImpl.this, preloadModuleImpl, null));
                                        }
                                    }
                                };
                                ThreadManagerV2.getTimer().schedule(this.mReqTask, j16);
                            }
                            preloadServiceImpl.notifyResFlowCheckNext();
                            if (fVar != null) {
                                notifyListenerDownloadFailInFlowControl(fVar, preloadModuleImpl, preloadServiceImpl);
                            }
                        }
                    }
                } else {
                    preloadFlowControlConfig = preloadFlowControlConfig2;
                    startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), a16, 0, F, P, l3, m3, n3, c16), preloadServiceImpl, preloadModuleImpl, fVar);
                }
                return;
            } catch (Throwable th6) {
                th = th6;
                throw th;
            }
        }
        throw th;
    }

    public boolean isAbiMatch() {
        if (TextUtils.isEmpty(this.mAbi)) {
            return true;
        }
        for (String str : this.mAbi.split("\\|")) {
            if ("32".equals(str) && !e.d()) {
                return true;
            }
            if (IPreloadResource.ABI_64.equals(str) && e.d()) {
                return true;
            }
        }
        return false;
    }

    public boolean isChosenToReport() {
        BaseQQAppInterface n3 = com.tencent.mobileqq.qwallet.impl.d.n();
        if (n3 == null) {
            return false;
        }
        int i3 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getInt(n3.getCurrentUin(), QWalletPreferenceApiImpl.KEY_REPORT_RANDOM, 0);
        if (i3 == 0) {
            i3 = new Random(n3.getLongAccountUin()).nextInt();
            ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putInt(n3.getCurrentUin(), QWalletPreferenceApiImpl.KEY_REPORT_RANDOM, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PreloadResource", 2, "isChosenToReport|" + i3 + "|10000");
        }
        if (i3 % 10000 != 0) {
            return false;
        }
        return true;
    }

    public boolean isInValidTime() {
        long j3 = com.tencent.mobileqq.qwallet.impl.d.j(this.mInvalidTime);
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (j3 != -1 && j3 < serverTimeMillis) {
            if (QLog.isColorLevel()) {
                QLog.d("PreloadResource", 2, this.mResId + " out of date");
                return false;
            }
            return false;
        }
        return true;
    }

    public boolean isNeedDeleteOldFileWhenUpdate(PreloadModuleImpl preloadModuleImpl, PreloadResourceImpl preloadResourceImpl, PreloadServiceImpl preloadServiceImpl) {
        if (getFilePos() != preloadResourceImpl.getFilePos()) {
            return true;
        }
        if (!this.md5.equalsIgnoreCase(preloadResourceImpl.md5)) {
            String resDownloadUrl = getResDownloadUrl(preloadModuleImpl);
            String g16 = com.tencent.mobileqq.qwallet.preload.a.g(resDownloadUrl, getFilePos());
            if (!TextUtils.isEmpty(preloadResourceImpl.md5) && !preloadResourceImpl.md5.equalsIgnoreCase(com.tencent.mobileqq.qwallet.preload.impl.c.e(resDownloadUrl, g16, getFilePos()))) {
                return true;
            }
        }
        return false;
    }

    public boolean isNeedReport(String str) {
        if (!isChosenToReport()) {
            return false;
        }
        if (!this.mIsFromLocal) {
            return true;
        }
        BaseQQAppInterface n3 = com.tencent.mobileqq.qwallet.impl.d.n();
        if (n3 != null) {
            String b16 = com.tencent.mobileqq.qwallet.preload.a.b(n3.getCurrentUin());
            if (!TextUtils.isEmpty(b16) && b16.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNeedUnzip(PreloadModuleImpl preloadModuleImpl) {
        if (preloadModuleImpl != null) {
            return d(com.tencent.mobileqq.qwallet.preload.a.g(getResDownloadUrl(preloadModuleImpl), getFilePos()), getResDownloadUrl(preloadModuleImpl));
        }
        return false;
    }

    public boolean isResChange(PreloadResourceImpl preloadResourceImpl) {
        if (!com.tencent.mobileqq.qwallet.impl.d.r(this.url, preloadResourceImpl.url) || !com.tencent.mobileqq.qwallet.impl.d.r(this.urlPath, preloadResourceImpl.urlPath) || this.type != preloadResourceImpl.type || !com.tencent.mobileqq.qwallet.impl.d.r(this.md5, preloadResourceImpl.md5) || !com.tencent.mobileqq.qwallet.impl.d.r(this.mDownloadTime, preloadResourceImpl.mDownloadTime) || !com.tencent.mobileqq.qwallet.impl.d.r(this.mInvalidTime, preloadResourceImpl.mInvalidTime) || !com.tencent.mobileqq.qwallet.impl.d.r(this.netType, preloadResourceImpl.netType) || this.size != preloadResourceImpl.size || this.mFlowControl != preloadResourceImpl.mFlowControl || !com.tencent.mobileqq.qwallet.impl.d.r(this.mResId, preloadResourceImpl.mResId) || this.mIsFromLocal != preloadResourceImpl.mIsFromLocal || this.mIsTemp != preloadResourceImpl.mIsTemp || this.mRetryTime != preloadResourceImpl.mRetryTime || this.mIsNeedUnzip != preloadResourceImpl.mIsNeedUnzip || this.mIsUnzipInside != preloadResourceImpl.mIsUnzipInside || !com.tencent.mobileqq.qwallet.impl.d.r(this.mUnzipPrefix, preloadResourceImpl.mUnzipPrefix) || this.mHasUnzip != preloadResourceImpl.mHasUnzip || this.mFromType != preloadResourceImpl.mFromType || this.mFilePos != preloadResourceImpl.mFilePos || !TextUtils.equals(this.mAbi, preloadResourceImpl.mAbi)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadResource
    public boolean isResFileExist(kl2.a aVar) {
        return new File(com.tencent.mobileqq.qwallet.preload.a.g(getResDownloadUrl(aVar), getFilePos())).exists();
    }

    public boolean isRetryProtectOpen() {
        return true;
    }

    public boolean isTimeToDownload(PreloadServiceImpl preloadServiceImpl) {
        if (this.f279033e) {
            return false;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        long j3 = com.tencent.mobileqq.qwallet.impl.d.j(this.mDownloadTime);
        if ((j3 != -1 && j3 >= serverTimeMillis) || !preloadServiceImpl.isNetValidToDownload(this.netType)) {
            return false;
        }
        return true;
    }

    public void notifyListenerDownloadFailInFlowControl(f fVar, PreloadModuleImpl preloadModuleImpl, PreloadServiceImpl preloadServiceImpl) {
        if (fVar == null) {
            return;
        }
        String resDownloadUrl = getResDownloadUrl(preloadModuleImpl);
        g gVar = new g(resDownloadUrl, new File(com.tencent.mobileqq.qwallet.preload.a.g(resDownloadUrl, getFilePos())));
        gVar.f313006d = -5;
        gVar.w(getDownloadParams(preloadModuleImpl));
        fVar.onDoneFile(gVar);
    }

    public void reportDownload(String str, int i3, PreloadModuleImpl preloadModuleImpl) {
        int i16;
        String str2;
        if (isValidToReport(this.f279034f, System.currentTimeMillis())) {
            this.f279034f = System.currentTimeMillis();
            if (i3 == 0) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            if (preloadModuleImpl == null) {
                str2 = "";
            } else {
                str2 = preloadModuleImpl.mid;
            }
            VACDReportUtil.a("QWalletStat", DownloadReportRequest.FUNC_NAME, null, i16 + "|" + str2 + "|" + this.mResId + "|" + str, 0, null);
        }
    }

    public void startDownload(PreloadServiceImpl preloadServiceImpl, PreloadModuleImpl preloadModuleImpl, f fVar, boolean z16) {
        if (this.mFlowControl) {
            preloadServiceImpl.addResToFlowControlCheck(new PreloadServiceImpl.d(this, preloadModuleImpl, fVar));
        } else {
            startDownloadRes(preloadModuleImpl, preloadServiceImpl, fVar, z16);
        }
    }

    public void startDownloadRes(PreloadModuleImpl preloadModuleImpl, PreloadServiceImpl preloadServiceImpl, f fVar, boolean z16) {
        String resDownloadUrl = getResDownloadUrl(preloadModuleImpl);
        String g16 = com.tencent.mobileqq.qwallet.preload.a.g(resDownloadUrl, getFilePos());
        Bundle downloadParams = getDownloadParams(preloadModuleImpl);
        if (isResFileExist(preloadModuleImpl)) {
            if (isNeedUnzip(preloadModuleImpl)) {
                unzip(g16, resDownloadUrl);
            }
            e(fVar, preloadModuleImpl, preloadServiceImpl);
        } else {
            if (TextUtils.isEmpty(resDownloadUrl)) {
                return;
            }
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.url = resDownloadUrl;
            downloadParam.filePath = g16;
            downloadParam.isPreDownload = z16;
            PreloadComDownloader.c().e(downloadParam, new c(fVar), downloadParams);
        }
    }

    public void startFlowControlReq(JudgeDownloadReq judgeDownloadReq, PreloadServiceImpl preloadServiceImpl, PreloadModuleImpl preloadModuleImpl, f fVar) {
        com.tencent.mobileqq.qwallet.impl.servlet.c.c(new JudgeDownloadRequest(judgeDownloadReq), new b(new WeakReference(preloadServiceImpl), fVar, preloadModuleImpl));
    }

    public String toString() {
        return "Res [" + this.mResId + "|" + this.mFlowControl + "|" + this.mIsFromLocal + "|" + this.mIsNeedUnzip + "|" + this.mIsUnzipInside + "|" + this.mUnzipPrefix + "|" + this.mHasUnzip + "|" + this.mFromType + "|" + this.mFilePos + "|" + this.mAbi + "]";
    }

    public String toStringEx() {
        return " Res[resId=" + this.mResId + "|isResExist=" + isResFileExist() + "|type=" + this.type + "|isTimeValid=" + isInValidTime() + "|url=" + this.url + "]";
    }

    public void unzip(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        checkFolderAndUnzip(str, getFolderPath(str2, str));
    }

    public ArrayList<ResInfo> getMyResInfos(int i3) {
        ArrayList<ResInfo> arrayList = new ArrayList<>();
        ResInfo resInfo = new ResInfo();
        try {
            resInfo.sResId = this.mResId;
        } catch (Throwable th5) {
            QLog.e("PreloadResource", 1, "error msg in qqpay-impl module: ", th5);
        }
        resInfo.iSize = i3;
        arrayList.add(resInfo);
        return arrayList;
    }

    public boolean isResFileExist() {
        String str;
        if (!TextUtils.isEmpty(this.url)) {
            str = this.url;
        } else {
            str = "/" + this.urlPath;
        }
        return new File(com.tencent.mobileqq.qwallet.preload.a.g(str, getFilePos())).exists();
    }

    public PreloadResourceImpl(PreloadResourceImpl preloadResourceImpl) {
        this();
        this.url = preloadResourceImpl.url;
        this.urlPath = preloadResourceImpl.urlPath;
        this.type = preloadResourceImpl.type;
        this.md5 = preloadResourceImpl.md5;
        this.mDownloadTime = preloadResourceImpl.mDownloadTime;
        this.mInvalidTime = preloadResourceImpl.mInvalidTime;
        this.netType = preloadResourceImpl.netType;
        this.size = preloadResourceImpl.size;
        this.mResId = preloadResourceImpl.mResId;
        this.mFlowControl = preloadResourceImpl.mFlowControl;
        this.mIsFromLocal = preloadResourceImpl.mIsFromLocal;
        this.mIsTemp = preloadResourceImpl.mIsTemp;
        this.mRetryTime = preloadResourceImpl.mRetryTime;
        this.mIsNeedUnzip = preloadResourceImpl.mIsNeedUnzip;
        this.mIsUnzipInside = preloadResourceImpl.mIsUnzipInside;
        this.mUnzipPrefix = preloadResourceImpl.mUnzipPrefix;
        this.mHasUnzip = preloadResourceImpl.mHasUnzip;
        this.mFromType = preloadResourceImpl.mFromType;
        this.mFilePos = preloadResourceImpl.mFilePos;
        this.mAbi = preloadResourceImpl.mAbi;
    }
}
