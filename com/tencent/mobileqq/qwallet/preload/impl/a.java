package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.DownloadReportReq;
import Wallet.JudgeDownloadReq;
import Wallet.JudgeDownloadRsp;
import Wallet.ResInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.impl.servlet.request.DownloadReportRequest;
import com.tencent.mobileqq.qwallet.impl.servlet.request.JudgeDownloadRequest;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends IPreloadService.b {

    /* renamed from: a, reason: collision with root package name */
    DownloadParam f279097a;

    /* renamed from: b, reason: collision with root package name */
    f f279098b;

    /* renamed from: c, reason: collision with root package name */
    private PreloadFlowControlConfig f279099c;

    /* renamed from: d, reason: collision with root package name */
    private String f279100d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qwallet.preload.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8482a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f279101d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f279102e;

        C8482a(WeakReference weakReference, f fVar) {
            this.f279101d = weakReference;
            this.f279102e = fVar;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (i3 == 1) {
                try {
                    PreloadServiceImpl preloadServiceImpl = (PreloadServiceImpl) this.f279101d.get();
                    if (!PreloadServiceImpl.isManagerValid(preloadServiceImpl)) {
                        f fVar = this.f279102e;
                        if (fVar != null) {
                            a.this.f(fVar);
                            return;
                        }
                        return;
                    }
                    if (!z16) {
                        f fVar2 = this.f279102e;
                        if (fVar2 != null) {
                            a.this.f(fVar2);
                        }
                        preloadServiceImpl.notifyResFlowCheckNext();
                        return;
                    }
                    JudgeDownloadRsp judgeDownloadRsp = (JudgeDownloadRsp) bundle.getSerializable("rsp");
                    if (judgeDownloadRsp == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("RealTimeFlowControlObj", 2, "onReceive rsp is null:" + judgeDownloadRsp);
                        }
                        f fVar3 = this.f279102e;
                        if (fVar3 != null) {
                            a.this.f(fVar3);
                        }
                        preloadServiceImpl.notifyResFlowCheckNext();
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("RealTimeFlowControlObj", 2, a.this.f279100d + "FlowControlRsp|" + judgeDownloadRsp.iDownloadStatus + "|" + judgeDownloadRsp.iSegTime + "|" + judgeDownloadRsp.iFailedRetryMax);
                    }
                    synchronized (a.this.f279099c) {
                        int i16 = judgeDownloadRsp.iDownloadStatus;
                        int i17 = 60;
                        if (i16 != 0) {
                            if (i16 != 1) {
                                a.this.f279099c.mDownloadStatus = 2;
                                PreloadFlowControlConfig preloadFlowControlConfig = a.this.f279099c;
                                int i18 = judgeDownloadRsp.iSegTime;
                                if (i18 > 60) {
                                    i17 = i18;
                                }
                                preloadFlowControlConfig.mNextCanReqTime = (i17 * 1000) + NetConnInfoCenter.getServerTimeMillis();
                            } else {
                                a.this.f279099c.mDownloadStatus = 1;
                                PreloadFlowControlConfig preloadFlowControlConfig2 = a.this.f279099c;
                                int i19 = judgeDownloadRsp.iFailedRetryMax;
                                if (i19 <= 0) {
                                    i19 = 3;
                                }
                                preloadFlowControlConfig2.mRetryDownloadTimes = i19;
                                PreloadFlowControlConfig preloadFlowControlConfig3 = a.this.f279099c;
                                int i26 = judgeDownloadRsp.iSegTime;
                                if (i26 > 60) {
                                    i17 = i26;
                                }
                                preloadFlowControlConfig3.mValidDownloadTime = (i17 * 1000) + NetConnInfoCenter.getServerTimeMillis();
                            }
                        } else {
                            a.this.f279099c.mDownloadStatus = 0;
                            PreloadFlowControlConfig preloadFlowControlConfig4 = a.this.f279099c;
                            int i27 = judgeDownloadRsp.iSegTime;
                            if (i27 > 60) {
                                i17 = i27;
                            }
                            preloadFlowControlConfig4.mNextRetryReqTime = (i17 * 1000) + NetConnInfoCenter.getServerTimeMillis();
                        }
                        if (judgeDownloadRsp.iDownloadStatus != 0) {
                            a.this.f279099c.mRetryReqTimes = 0;
                        }
                        a.this.f279099c.saveConfig();
                    }
                    int i28 = judgeDownloadRsp.iDownloadStatus;
                    if (i28 == 2) {
                        preloadServiceImpl.notifyResFlowCheckNext();
                        f fVar4 = this.f279102e;
                        if (fVar4 != null) {
                            a.this.f(fVar4);
                            return;
                        }
                        return;
                    }
                    if (i28 == 0) {
                        a.this.a(preloadServiceImpl);
                    } else if (i28 == 1) {
                        a.this.a(preloadServiceImpl);
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("RealTimeFlowControlObj", 2, a.this.f279100d + " startFlowControlReq onReceive exception:" + th5);
                    }
                    f fVar5 = this.f279102e;
                    if (fVar5 != null) {
                        a.this.f(fVar5);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b extends f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f279104a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f279105b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f279106c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f279107d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f279108e;

        b(int i3, WeakReference weakReference, f fVar, long j3) {
            this.f279105b = i3;
            this.f279106c = weakReference;
            this.f279107d = fVar;
            this.f279108e = j3;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(g gVar) {
            int i3;
            long j3;
            PreloadServiceImpl preloadServiceImpl = (PreloadServiceImpl) this.f279106c.get();
            if (PreloadServiceImpl.isManagerValid(preloadServiceImpl)) {
                preloadServiceImpl.notifyResFlowCheckNext();
            }
            f fVar = this.f279107d;
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
                        QLog.e("RealTimeFlowControlObj", 1, "error msg in qqpay-impl module: ", th5);
                        i3 = -4;
                    }
                }
                i3 = (int) j3;
            } else {
                i3 = -1;
            }
            downloadReportReq.vecResInfo = a.this.e(i3);
            downloadReportReq.iUin = this.f279108e;
            downloadReportReq.sPhoneType = ah.F();
            downloadReportReq.sOsVersion = ah.t();
            downloadReportReq.sQQVersion = ah.P();
            downloadReportReq.iScene = gVar.h().getInt("scene");
            com.tencent.mobileqq.qwallet.impl.servlet.c.c(new DownloadReportRequest(downloadReportReq), null);
            if (QLog.isColorLevel()) {
                QLog.d("RealTimeFlowControlObj", 2, a.this.f279100d + " flow down result:" + gVar.f313006d + downloadReportReq);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(g gVar) {
            if (!this.f279104a) {
                this.f279104a = true;
                double currentTimeMillis = gVar.G / (System.currentTimeMillis() - gVar.H);
                if (currentTimeMillis < 1.0d) {
                    return;
                }
                DownloadReportReq downloadReportReq = new DownloadReportReq();
                downloadReportReq.sSpeed = currentTimeMillis + "";
                downloadReportReq.vecResInfo = a.this.e(0);
                downloadReportReq.iType = 0;
                downloadReportReq.iUin = this.f279108e;
                com.tencent.mobileqq.qwallet.impl.servlet.c.c(new DownloadReportRequest(downloadReportReq), null);
                if (QLog.isColorLevel()) {
                    QLog.d("RealTimeFlowControlObj", 2, a.this.f279100d + " flow down speed:" + currentTimeMillis);
                }
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(g gVar) {
            gVar.G = 1048576L;
            gVar.f313008f = Math.max(this.f279105b, 3);
            return super.onStart(gVar);
        }
    }

    public a(DownloadParam downloadParam, f fVar) {
        this.f279097a = downloadParam;
        this.f279098b = fVar;
    }

    private void g(f fVar, String str) {
        if (fVar == null) {
            return;
        }
        g gVar = new g(this.f279097a.url, new File(str));
        gVar.f313006d = 0;
        fVar.onDoneFile(gVar);
    }

    /* JADX WARN: Not initialized variable reg: 20, insn: 0x01aa: MOVE (r19 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]) (LINE:427), block:B:67:0x01aa */
    @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.b
    public void a(IPreloadService iPreloadService) {
        PreloadFlowControlConfig preloadFlowControlConfig;
        PreloadFlowControlConfig preloadFlowControlConfig2;
        PreloadFlowControlConfig preloadFlowControlConfig3;
        long j3;
        PreloadServiceImpl preloadServiceImpl;
        PreloadFlowControlConfig preloadFlowControlConfig4;
        PreloadServiceImpl preloadServiceImpl2 = (PreloadServiceImpl) iPreloadService;
        DownloadParam downloadParam = this.f279097a;
        ResourceInfo j16 = com.tencent.mobileqq.qwallet.preload.a.j(downloadParam.url, downloadParam.isForceUnzip, downloadParam.filePos);
        if (com.tencent.mobileqq.qwallet.preload.a.r(j16, this.f279097a)) {
            f fVar = this.f279098b;
            if (fVar != null) {
                g(fVar, j16.filePath);
            }
            preloadServiceImpl2.notifyResFlowCheckNext();
            return;
        }
        if (this.f279099c == null) {
            String resIdByUrl = preloadServiceImpl2.getResIdByUrl(this.f279097a.url);
            this.f279100d = resIdByUrl;
            if (TextUtils.isEmpty(resIdByUrl)) {
                this.f279100d = MD5.toMD5(this.f279097a.url);
            }
            this.f279099c = PreloadFlowControlConfig.getFlowControlConfig(this.f279100d);
        }
        if (QLog.isColorLevel()) {
            QLog.d("RealTimeFlowControlObj", 2, this.f279100d + "handleFlowConfig:" + this.f279099c.mDownloadStatus);
        }
        long a16 = com.tencent.mobileqq.base.a.a();
        String F = ah.F();
        String P = ah.P();
        float l3 = (float) ah.l();
        float m3 = (float) ah.m();
        int n3 = ah.n();
        long c16 = m.c() / 1024;
        PreloadFlowControlConfig preloadFlowControlConfig5 = this.f279099c;
        synchronized (preloadFlowControlConfig5) {
            try {
                try {
                    int i3 = this.f279099c.mDownloadStatus;
                    if (i3 != -1) {
                        if (i3 != 0) {
                            try {
                                if (i3 != 1) {
                                    if (i3 != 2) {
                                        preloadServiceImpl2.notifyResFlowCheckNext();
                                        preloadFlowControlConfig2 = preloadFlowControlConfig5;
                                    } else {
                                        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                                        if (QLog.isColorLevel()) {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(this.f279100d);
                                            sb5.append(" STATUS_NOT_DOWNLOAD|");
                                            sb5.append(serverTimeMillis);
                                            sb5.append("|");
                                            preloadServiceImpl = preloadServiceImpl2;
                                            preloadFlowControlConfig4 = preloadFlowControlConfig5;
                                            sb5.append(this.f279099c.mNextCanReqTime);
                                            QLog.d("RealTimeFlowControlObj", 2, sb5.toString());
                                        } else {
                                            preloadServiceImpl = preloadServiceImpl2;
                                            preloadFlowControlConfig4 = preloadFlowControlConfig5;
                                        }
                                        if (serverTimeMillis > this.f279099c.mNextCanReqTime) {
                                            h(JudgeDownloadReq.createReq(e(0), a16, 0, F, P, l3, m3, n3, c16), preloadServiceImpl, this.f279098b);
                                        } else {
                                            preloadServiceImpl.notifyResFlowCheckNext();
                                            f fVar2 = this.f279098b;
                                            if (fVar2 != null) {
                                                f(fVar2);
                                            }
                                        }
                                        preloadFlowControlConfig2 = preloadFlowControlConfig4;
                                    }
                                } else {
                                    long serverTimeMillis2 = NetConnInfoCenter.getServerTimeMillis();
                                    if (QLog.isColorLevel()) {
                                        StringBuilder sb6 = new StringBuilder();
                                        sb6.append(this.f279100d);
                                        sb6.append("STATUS_NOW_DOWNLOAD|");
                                        sb6.append(serverTimeMillis2);
                                        sb6.append("|");
                                        j3 = serverTimeMillis2;
                                        sb6.append(this.f279099c.mValidDownloadTime);
                                        QLog.d("RealTimeFlowControlObj", 2, sb6.toString());
                                    } else {
                                        j3 = serverTimeMillis2;
                                    }
                                    if (j3 < this.f279099c.mValidDownloadTime) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("RealTimeFlowControlObj", 2, this.f279100d + "begin download");
                                        }
                                        preloadFlowControlConfig2 = preloadFlowControlConfig5;
                                        PreloadComDownloader.c().e(this.f279097a, d(a16, this.f279098b, preloadServiceImpl2, this.f279099c.mRetryDownloadTimes), null);
                                    } else {
                                        preloadFlowControlConfig2 = preloadFlowControlConfig5;
                                        h(JudgeDownloadReq.createReq(e(0), a16, 0, F, P, l3, m3, n3, c16), preloadServiceImpl2, this.f279098b);
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                preloadFlowControlConfig = preloadFlowControlConfig3;
                                throw th;
                            }
                        } else {
                            preloadFlowControlConfig2 = preloadFlowControlConfig5;
                            long serverTimeMillis3 = NetConnInfoCenter.getServerTimeMillis();
                            long j17 = this.f279099c.mNextRetryReqTime - serverTimeMillis3;
                            if (QLog.isColorLevel()) {
                                QLog.d("RealTimeFlowControlObj", 2, this.f279100d + "STATUS_WAIT_TO_REQ|" + serverTimeMillis3 + "|" + this.f279099c.mNextRetryReqTime + "|" + j17);
                            }
                            if (j17 <= 0) {
                                ArrayList<ResInfo> e16 = e(0);
                                PreloadFlowControlConfig preloadFlowControlConfig6 = this.f279099c;
                                int i16 = preloadFlowControlConfig6.mRetryReqTimes + 1;
                                preloadFlowControlConfig6.mRetryReqTimes = i16;
                                h(JudgeDownloadReq.createReq(e16, a16, i16, F, P, l3, m3, n3, c16), preloadServiceImpl2, this.f279098b);
                            } else {
                                preloadServiceImpl2.notifyResFlowCheckNext();
                                f fVar3 = this.f279098b;
                                if (fVar3 != null) {
                                    f(fVar3);
                                }
                            }
                        }
                    } else {
                        preloadFlowControlConfig2 = preloadFlowControlConfig5;
                        h(JudgeDownloadReq.createReq(e(0), a16, 0, F, P, l3, m3, n3, c16), preloadServiceImpl2, this.f279098b);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    preloadFlowControlConfig = preloadFlowControlConfig5;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    public f d(long j3, f fVar, PreloadServiceImpl preloadServiceImpl, int i3) {
        return new b(i3, new WeakReference(preloadServiceImpl), fVar, j3);
    }

    public ArrayList<ResInfo> e(int i3) {
        ArrayList<ResInfo> arrayList = new ArrayList<>();
        ResInfo resInfo = new ResInfo();
        try {
            resInfo.sResId = this.f279100d;
            resInfo.iSize = i3;
        } catch (Throwable th5) {
            QLog.e("RealTimeFlowControlObj", 1, "error msg in qqpay-impl module: ", th5);
        }
        arrayList.add(resInfo);
        return arrayList;
    }

    public void f(f fVar) {
        if (fVar == null) {
            return;
        }
        String str = this.f279097a.url;
        g gVar = new g(str, new File(com.tencent.mobileqq.qwallet.preload.a.g(str, this.f279097a.filePos)));
        gVar.f313006d = -5;
        fVar.onDoneFile(gVar);
    }

    public void h(JudgeDownloadReq judgeDownloadReq, PreloadServiceImpl preloadServiceImpl, f fVar) {
        com.tencent.mobileqq.qwallet.impl.servlet.c.c(new JudgeDownloadRequest(judgeDownloadReq), new C8482a(new WeakReference(preloadServiceImpl), fVar));
    }
}
