package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.downloader.d;
import com.tencent.mobileqq.uniformdownload.util.f;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e implements IHttpCommunicatorListener {
    static IPatchRedirector $redirector_;
    public static String Q;
    public static int R;
    public static int S;
    public static int T;
    private long C;
    private Object D;
    private HttpMsg E;
    private Object F;
    private d.b G;
    private Object H;
    private int I;
    private Object J;
    private int K;
    private int L;
    private String M;
    long N;
    long P;

    /* renamed from: d, reason: collision with root package name */
    private final long f305980d;

    /* renamed from: e, reason: collision with root package name */
    private final String f305981e;

    /* renamed from: f, reason: collision with root package name */
    private long f305982f;

    /* renamed from: h, reason: collision with root package name */
    private String f305983h;

    /* renamed from: i, reason: collision with root package name */
    private OutputStream f305984i;

    /* renamed from: m, reason: collision with root package name */
    private Object f305985m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19758);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        Q = "UniformDownloaderGenWorker";
        R = 1;
        S = 2;
        T = 3;
    }

    public e(long j3, AppRuntime appRuntime, String str, long j16, String str2, d.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), appRuntime, str, Long.valueOf(j16), str2, bVar);
            return;
        }
        this.f305984i = null;
        this.f305985m = new Object();
        this.C = 0L;
        this.D = new Object();
        this.F = new Object();
        this.G = null;
        this.H = new Object();
        this.I = S;
        this.J = new Object();
        this.K = 0;
        this.L = 0;
        this.N = 0L;
        this.P = 0L;
        this.f305980d = j3;
        this.f305981e = new com.tencent.mobileqq.uniformdownload.filemanager.a(appRuntime, str).a();
        this.G = bVar;
        this.f305982f = j16;
        this.M = str2;
    }

    private boolean a() {
        synchronized (this.f305985m) {
            try {
                try {
                    OutputStream outputStream = this.f305984i;
                    if (outputStream != null) {
                        outputStream.close();
                        this.f305984i = null;
                        QLog.i(Q, 1, "[UniformDL][" + this.f305980d + "]. closeFileStream: filepath:" + this.f305983h);
                    } else {
                        QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "]. closeFileStream.had closed: stream = null:");
                    }
                } catch (IOException e16) {
                    QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "]. closeFileStream: exception");
                    e16.printStackTrace();
                    return false;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        return true;
    }

    private synchronized boolean b(long j3) {
        String str;
        m(j3);
        String str2 = "bytes=" + j3 + "-";
        String str3 = this.f305981e;
        if (str3 != null && !str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str = this.f305981e + "?&range=" + String.valueOf(j3);
        } else {
            str = this.f305981e + "&range=" + String.valueOf(j3);
        }
        HttpMsg httpMsg = new HttpMsg(str, null, this, true);
        String str4 = "gprs";
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
            str4 = "wifi";
        }
        httpMsg.setRequestProperty("Net-type", str4);
        httpMsg.setRequestProperty("Range", str2);
        httpMsg.setPriority(1);
        if (!TextUtils.isEmpty(this.M)) {
            httpMsg.setRequestProperty("Cookie", this.M);
        }
        httpMsg.setDataSlice(true);
        httpMsg.fileType = 5;
        httpMsg.busiType = 0;
        httpMsg.msgId = String.valueOf(System.currentTimeMillis());
        httpMsg.setRequestProperty("Accept-Encoding", "identity");
        n(httpMsg);
        if (UniformDownloadMgr.m().k() == null) {
            QLog.i(Q, 1, "[UniformDL][" + this.f305980d + "]. downloadFile failed. APP=null. POS:" + j3 + " PGR:" + ((int) (j3 / this.f305982f)));
            return false;
        }
        ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendMsg(httpMsg);
        QLog.i(Q, 1, "[UniformDL][" + this.f305980d + "]. >>>>>>>>>>downloadFile. POS:" + j3 + " PGR:" + ((int) (j3 / this.f305982f)));
        return true;
    }

    private long c() {
        long j3;
        synchronized (this.D) {
            j3 = this.C;
        }
        return j3;
    }

    private HttpMsg d() {
        HttpMsg httpMsg;
        synchronized (this.F) {
            httpMsg = this.E;
        }
        return httpMsg;
    }

    private d.b e() {
        d.b bVar;
        synchronized (this.H) {
            bVar = this.G;
        }
        return bVar;
    }

    private int f() {
        int i3;
        synchronized (this.J) {
            i3 = this.I;
        }
        return i3;
    }

    private void g(int i3, String str, String str2) {
        h();
        AppRuntime k3 = UniformDownloadMgr.m().k();
        if (k3 != null) {
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) k3;
            long j3 = i3;
            ah.A1(baseQQAppInterface, this.f305980d, "actFileUfGenDownload", this.N, "", "", "", "", j3, str, this.P, this.C, this.f305982f, this.f305981e, "", this.K, str2, null);
            ah.A1(baseQQAppInterface, this.f305980d, "actFileUfGenDownloadDetail", this.N, "", "", "", "", j3, str, this.P, this.C, this.f305982f, this.f305981e, "", this.K, str2, null);
        } else {
            QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "].report failed - 3");
        }
        d.b e16 = e();
        if (e16 != null) {
            e16.c(i3, str, null);
        }
    }

    private synchronized void h() {
        p(S);
        s();
        a();
    }

    private boolean i(HttpMsg httpMsg, HttpMsg httpMsg2) {
        if (httpMsg == null) {
            return false;
        }
        if (httpMsg2 == null) {
            return true;
        }
        return httpMsg2.permitRetry();
    }

    private boolean j() {
        if (S == f()) {
            return true;
        }
        return false;
    }

    private boolean k() {
        synchronized (this.f305985m) {
            if (this.f305984i == null) {
                try {
                    this.f305984i = new FileOutputStream(this.f305983h, true);
                    QLog.i(Q, 1, "[UniformDL][" + this.f305980d + "]. openFileStream: filepath:" + this.f305983h);
                } catch (FileNotFoundException e16) {
                    QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "]. openFileStream: exception");
                    e16.printStackTrace();
                    return false;
                }
            } else {
                QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "]. openFileStream: had be opened");
            }
        }
        return true;
    }

    private void m(long j3) {
        synchronized (this.D) {
            this.C = j3;
        }
    }

    private void n(HttpMsg httpMsg) {
        synchronized (this.F) {
            this.E = httpMsg;
        }
    }

    private void o(d.b bVar) {
        synchronized (this.H) {
            this.G = bVar;
        }
    }

    private void p(int i3) {
        synchronized (this.J) {
            QLog.i(Q, 1, "[UniformDL][" + this.f305980d + "]. setStatus: " + this.I + " -> " + i3);
            this.I = i3;
        }
    }

    private void s() {
        HttpMsg d16 = d();
        if (d16 != null) {
            QLog.i(Q, 1, "[UniformDL][" + this.f305980d + "]. stopHttpRequest");
            n(null);
            if (UniformDownloadMgr.m().k() == null) {
                QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "]. stopHttpRequest failed.APP=null");
                return;
            }
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelMsg(d16);
            return;
        }
        QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "]. stopHttpRequest: no request");
    }

    private boolean t(byte[] bArr) {
        synchronized (this.f305985m) {
            try {
                try {
                    OutputStream outputStream = this.f305984i;
                    if (outputStream == null) {
                        QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "]. writeFileStream: stream = null:");
                        return false;
                    }
                    outputStream.write(bArr);
                    return true;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return false;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void decode(HttpMsg httpMsg, HttpMsg httpMsg2) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) httpMsg, (Object) httpMsg2);
            return;
        }
        if (j()) {
            QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "]. decode. but had stoped");
            return;
        }
        try {
            if (httpMsg2.getResponseCode() == 206 || httpMsg2.getResponseCode() == 200) {
                if (!t(httpMsg2.getRecvData())) {
                    int i3 = 3;
                    String a16 = f.a(3);
                    if (cu.e()) {
                        j3 = cu.b() * 1024;
                    } else {
                        j3 = 0;
                    }
                    if (j3 < this.f305982f - c()) {
                        QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "] write file failed. sd card space is no enough:[" + this.f305982f + " " + c() + " " + j3 + "]");
                        i3 = 9;
                        a16 = f.a(9);
                    }
                    g(i3, a16, a16);
                    return;
                }
                long c16 = c() + httpMsg2.getRecvData().length;
                long totalLen = httpMsg2.getTotalLen();
                if (this.f305982f != totalLen) {
                    this.f305982f = totalLen;
                }
                m(c16);
                this.P += httpMsg2.getRecvData().length;
                long j16 = this.f305982f;
                if (c16 >= j16) {
                    if (!a()) {
                        QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "].closeFileStream falied.path=" + this.f305983h);
                        String a17 = f.a(4);
                        g(4, a17, a17);
                        return;
                    }
                    QLog.i(Q, 1, "[UniformDL][" + this.f305980d + "].decode >>>>>>>. SUCESSFUL!!!");
                    d.b e16 = e();
                    if (e16 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("EXT_TRANS_SIZE ", this.C);
                        bundle.putLong("EXT_TTRANS_SIZE ", this.P);
                        bundle.putInt("EXT_AUTOTRY_COUNT", this.K);
                        e16.h(this.f305983h, this.f305982f, bundle);
                        return;
                    }
                    return;
                }
                int i16 = (int) ((((float) c16) / ((float) j16)) * 100.0f);
                d.b e17 = e();
                if (e17 != null) {
                    e17.a(i16, null);
                }
            }
        } catch (Exception e18) {
            e18.printStackTrace();
            String a18 = f.a(12);
            g(12, a18, a18);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleError(HttpMsg httpMsg, HttpMsg httpMsg2) {
        String str;
        long j3;
        String str2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) httpMsg, (Object) httpMsg2);
            return;
        }
        if (j()) {
            QLog.i(Q, 1, "[UniformDL][" + this.f305980d + "]. handleError..user puase");
            return;
        }
        if (httpMsg2 == null) {
            QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "]. handleError.. response=NULL:");
            h();
            String a16 = f.a(2);
            AppRuntime k3 = UniformDownloadMgr.m().k();
            if (k3 != null) {
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) k3;
                long j16 = 2;
                ah.A1(baseQQAppInterface, this.f305980d, "actFileUfGenDownload", this.N, "", "", "", "", j16, a16, this.P, this.C, this.f305982f, this.f305981e, "", 0, a16, null);
                ah.A1(baseQQAppInterface, this.f305980d, "actFileUfGenDownloadDetail", this.N, "", "", "", "", j16, a16, this.P, this.C, this.f305982f, this.f305981e, "", 0, a16, null);
            } else {
                QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "].report failed - 111");
            }
            d.b e16 = e();
            if (e16 != null) {
                e16.c(2, a16, null);
                return;
            }
            return;
        }
        String errorString = httpMsg2.getErrorString();
        if (errorString == null) {
            errorString = "null";
        }
        QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "]. handleError.. errString:" + errorString);
        if (T == f()) {
            QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "]. handleError.. slience pause. may app destroy!!");
            a();
            return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            h();
            String a17 = f.a(5);
            AppRuntime k16 = UniformDownloadMgr.m().k();
            if (k16 != null) {
                BaseQQAppInterface baseQQAppInterface2 = (BaseQQAppInterface) k16;
                long j17 = 5;
                ah.A1(baseQQAppInterface2, this.f305980d, "actFileUfGenDownload", this.N, "", "", "", "", j17, a17, this.P, this.C, this.f305982f, this.f305981e, "", 0, a17, null);
                ah.A1(baseQQAppInterface2, this.f305980d, "actFileUfGenDownloadDetail", this.N, "", "", "", "", j17, a17, this.P, this.C, this.f305982f, this.f305981e, "", 0, a17, null);
            } else {
                QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "].report failed - 11");
            }
            d.b e17 = e();
            if (e17 != null) {
                e17.c(5, a17, null);
                return;
            }
            return;
        }
        long j18 = httpMsg2.errCode;
        String valueOf = String.valueOf(httpMsg2.getSerial());
        String errorString2 = httpMsg2.getErrorString();
        if (i(httpMsg, httpMsg2) && (i3 = this.K) < 3) {
            int i16 = i3 + 1;
            this.K = i16;
            int i17 = this.L;
            if (i17 < 3 && httpMsg2.errCode == 9056) {
                this.L = i17 + 1;
                this.K = i16 - 1;
            } else {
                this.L = 0;
            }
            QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "]. handleError. auto retry to download. autoRetry=" + this.K + " eofRetry=" + this.L);
            s();
            if (!b(c())) {
                QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "]. auto retry dowload failed.");
                valueOf = f.a((int) 13);
                errorString2 = valueOf;
                j18 = 13L;
            } else {
                QLog.i(Q, 1, "[UniformDL][" + this.f305980d + "]. auto retry dowload started.");
                AppRuntime k17 = UniformDownloadMgr.m().k();
                if (k17 != null) {
                    ah.A1((BaseQQAppInterface) k17, this.f305980d, "actFileUfGenDownloadDetail", this.N, "", "", "", "", httpMsg2.errCode, String.valueOf(httpMsg2.getSerial()), this.P, this.C, this.f305982f, httpMsg2.getRealUrl(), httpMsg2.rawRespHeader, this.K, httpMsg2.getErrorString(), null);
                    return;
                }
                QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "].report failed - 1");
                return;
            }
        }
        this.K = 0;
        this.L = 0;
        h();
        AppRuntime k18 = UniformDownloadMgr.m().k();
        if (k18 != null) {
            if (13 != j18) {
                str = f.a((int) 11);
                str2 = str;
                j3 = 11;
            } else {
                str = valueOf;
                j3 = j18;
                str2 = errorString2;
            }
            BaseQQAppInterface baseQQAppInterface3 = (BaseQQAppInterface) k18;
            ah.A1(baseQQAppInterface3, this.f305980d, "actFileUfGenDownload", this.N, "", "", "", "", j3, str, this.P, this.C, this.f305982f, httpMsg2.getRealUrl(), httpMsg2.rawRespHeader, this.K, str2, null);
            ah.A1(baseQQAppInterface3, this.f305980d, "actFileUfGenDownloadDetail", this.N, "", "", "", "", httpMsg2.errCode, String.valueOf(httpMsg2.getSerial()), this.P, this.C, this.f305982f, httpMsg2.getRealUrl(), httpMsg2.rawRespHeader, this.K, httpMsg2.getErrorString(), null);
        } else {
            QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "].report failed - 2");
        }
        d.b e18 = e();
        if (e18 != null) {
            e18.c(6, "downloader fialed", null);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleRedirect(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            p(T);
        }
    }

    public boolean q(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3))).booleanValue();
        }
        if (str == null) {
            QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "]. start failed. filepath = null. POS:" + j3);
            return false;
        }
        if (R == f()) {
            QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "]. start. is runing. POS:" + j3);
            return true;
        }
        this.f305983h = str;
        if (!k()) {
            QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "]. start failed. openFileStream failed. POS:" + j3);
            String a16 = f.a(8);
            g(8, a16, a16);
            return false;
        }
        if (!b(j3)) {
            QLog.e(Q, 1, "[UniformDL][" + this.f305980d + "]. start download failed. POS:" + j3);
            String a17 = f.a(6);
            g(6, a17, a17);
            return false;
        }
        p(R);
        this.N = System.currentTimeMillis();
        QLog.i(Q, 1, "[UniformDL][" + this.f305980d + "]. start to run download . POS:" + j3);
        return true;
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            h();
            o(null);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, httpMsg, httpMsg2, Integer.valueOf(i3))).booleanValue();
        }
        QLog.i(Q, 1, "[UniformDL][" + this.f305980d + "]. HttpCommunicator statusChanged. status:" + i3);
        if (5 == i3 && c() < this.f305982f) {
            h();
            String a16 = f.a(14);
            AppRuntime k3 = UniformDownloadMgr.m().k();
            if (k3 != null) {
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) k3;
                long j3 = 14;
                ah.A1(baseQQAppInterface, this.f305980d, "actFileUfGenDownload", this.N, "", "", "", "", j3, a16, this.P, this.C, this.f305982f, httpMsg2.getRealUrl(), httpMsg2.rawRespHeader, this.K, a16, null);
                ah.A1(baseQQAppInterface, this.f305980d, "actFileUfGenDownloadDetail", this.N, "", "", "", "", j3, a16, this.P, this.C, this.f305982f, httpMsg2.getRealUrl(), httpMsg2.rawRespHeader, this.K, a16, null);
            } else {
                QLog.w(Q, 1, "[UniformDL][" + this.f305980d + "].report failed - 2");
            }
            d.b e16 = e();
            if (e16 != null) {
                e16.c(14, "downloader fialed", null);
            }
        }
        return true;
    }
}
