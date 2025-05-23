package com.tencent.mobileqq.transfile.quic.internal;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.quic.open.ILoadSo;
import com.tencent.mobileqq.transfile.quic.open.ILoadSoCallback;
import com.tencent.mobileqq.transfile.quic.open.IQuicEngine;
import com.tencent.mobileqq.transfile.quic.open.QuicReq;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QuicEngineImp implements IQuicEngine, ILoadSoCallback {
    static IPatchRedirector $redirector_ = null;
    private static final int SO_LOADED = 2;
    private static final int SO_LOADING = 1;
    private static final String TAG = "QuicEngineImp";
    public static QuicNetReport.Stats sLastStats;
    private ILoadSo mILoadSo;
    private List<QuicReq> mReqWaitingList;
    private volatile int mSoLoadStatus;

    public QuicEngineImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mReqWaitingList = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void addToThreadPoll(QuicReq quicReq) {
        quicReq.mExcuteTime = System.currentTimeMillis();
        ThreadManagerV2.excute(new Runnable(quicReq) { // from class: com.tencent.mobileqq.transfile.quic.internal.QuicEngineImp.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ QuicReq val$req;

            {
                this.val$req = quicReq;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QuicEngineImp.this, (Object) quicReq);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QuicEngineImp.this.doQuicTask(this.val$req);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 128, null, false);
    }

    private void callbackWatingReqFail() {
        List<QuicReq> list = this.mReqWaitingList;
        if (list != null) {
            for (QuicReq quicReq : list) {
                DownloadListener downloadListener = quicReq.mDownloadListener;
                if (downloadListener != null) {
                    QuicNetReport quicNetReport = new QuicNetReport();
                    quicNetReport.channel = "quic";
                    String str = quicReq.mTempPath;
                    quicNetReport.tempPath = str;
                    quicNetReport.savePath = quicReq.mSavePath;
                    quicNetReport.f293472id = str.hashCode();
                    String str2 = quicReq.mPath;
                    quicNetReport.url = str2;
                    quicNetReport.f293473ip = quicReq.mIp;
                    quicNetReport.errMsg = "so load fail";
                    quicNetReport.port = quicReq.mPort;
                    quicNetReport.isIpv6 = quicReq.mIsIpv6;
                    quicNetReport.rttHost = quicReq.mRttHost;
                    quicNetReport.businessId = quicReq.mBussinessId;
                    quicNetReport.timeOut = quicReq.mTimeOut;
                    quicNetReport.failReason = 10;
                    downloadListener.onDownloadFailed(str2, quicNetReport);
                }
            }
            this.mReqWaitingList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doQuicTask(QuicReq quicReq) {
        String str = quicReq.mSavePath;
        String str2 = quicReq.mPath;
        String tempPath = Task.getTempPath(quicReq.mTempPath, str, str2);
        if (TextUtils.isEmpty(tempPath)) {
            return;
        }
        if (QuicDownloadRunnable.isExistTaskAddIfNeed(tempPath)) {
            QLog.d("quic", 4, "task is running.");
            taskDownloadingCallback(quicReq, str, str2, tempPath);
            return;
        }
        long j3 = quicReq.mExcuteTime;
        DownloadListener downloadListener = quicReq.mDownloadListener;
        if (downloadListener != null && downloadListener.isCanceled()) {
            if (QLog.isColorLevel()) {
                QLog.d("quic", 4, "task is canceled.");
            }
            QuicDownloadRunnable.removeRunningTask(tempPath);
            taskCanceledCallback(quicReq, str, str2, tempPath);
            return;
        }
        QuicDownloadRunnable quicDownloadRunnable = new QuicDownloadRunnable();
        try {
            QuicDownloadTask quicDownloadTask = new QuicDownloadTask(quicDownloadRunnable, str2, str, tempPath, quicReq.mHeaders, downloadListener);
            quicDownloadTask.initDownloadFile();
            if (j3 > 0) {
                quicDownloadTask.report.waitCost = System.currentTimeMillis() - j3;
            }
            QuicNetReport quicNetReport = quicDownloadTask.report;
            quicNetReport.f293473ip = quicReq.mIp;
            quicNetReport.port = quicReq.mPort;
            quicNetReport.isIpv6 = quicReq.mIsIpv6;
            quicNetReport.rttHost = quicReq.mRttHost;
            quicNetReport.businessId = quicReq.mBussinessId;
            int i3 = quicReq.mTimeOut;
            quicNetReport.timeOut = i3;
            quicDownloadTask.timeOut = i3;
            synchronized (this) {
                if (sLastStats != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("quic", 2, "report stats: " + sLastStats.toString());
                    }
                    quicDownloadTask.report.lastStats = sLastStats;
                    sLastStats = null;
                }
            }
            quicDownloadTask.encryption = quicReq.mIsQuicEncryption;
            quicDownloadTask.fec = quicReq.mFec;
            quicDownloadRunnable.enqueue(quicDownloadTask);
        } catch (Exception e16) {
            QuicDownloadRunnable.removeRunningTask(tempPath);
            taskFailedCallback(quicReq, str, str2, tempPath, 2, e16.getMessage());
        }
    }

    private void executeWatingReq() {
        List<QuicReq> list = this.mReqWaitingList;
        if (list != null) {
            Iterator<QuicReq> it = list.iterator();
            while (it.hasNext()) {
                addToThreadPoll(it.next());
            }
            this.mReqWaitingList.clear();
        }
    }

    public static QuicNetReport.Stats saveNetStats(QuicNetReport quicNetReport) {
        QuicNetReport.Stats convertJsontoStats = QuicNetReport.convertJsontoStats(quicNetReport.extra);
        if (convertJsontoStats != null) {
            byte[] bArr = quicNetReport.srvMessage;
            if (bArr != null && bArr.length > 0) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                convertJsontoStats.mSrvMessage = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, length);
            }
            if (convertJsontoStats.isValid()) {
                synchronized (QuicEngineImp.class) {
                    sLastStats = convertJsontoStats;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("quic", 4, convertJsontoStats.toString());
                }
                return convertJsontoStats;
            }
            return null;
        }
        return null;
    }

    private void taskCanceledCallback(QuicReq quicReq, String str, String str2, String str3) {
        taskFailedCallback(quicReq, str, str2, str3, 9);
    }

    private void taskDownloadingCallback(QuicReq quicReq, String str, String str2, String str3) {
        taskFailedCallback(quicReq, str, str2, str3, 8);
    }

    private void taskFailedCallback(QuicReq quicReq, String str, String str2, String str3, int i3) {
        taskFailedCallback(quicReq, str, str2, str3, i3, "");
    }

    @Override // com.tencent.mobileqq.transfile.quic.open.IQuicEngine
    public boolean execute(QuicReq quicReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) quicReq)).booleanValue();
        }
        if (Utils.checkIfCPUx86()) {
            QLog.e("quic", 4, "the phone cpu is x86");
            return false;
        }
        if (quicReq == null) {
            return false;
        }
        if (!TextUtils.isEmpty(quicReq.mPath)) {
            if (!TextUtils.isEmpty(quicReq.mSavePath)) {
                if (!TextUtils.isEmpty(quicReq.mIp)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("quic", 4, "start ip: " + quicReq.mIp + " port: " + quicReq.mPort);
                    }
                    synchronized (this) {
                        if (this.mSoLoadStatus == 2) {
                            addToThreadPoll(quicReq);
                        } else if (this.mSoLoadStatus == 1) {
                            this.mReqWaitingList.add(quicReq);
                        } else if (this.mSoLoadStatus == 0) {
                            this.mReqWaitingList.add(quicReq);
                            init();
                        }
                    }
                    return true;
                }
                throw new IllegalArgumentException("ip is empty!!!");
            }
            throw new IllegalArgumentException("savePath is empty!!!");
        }
        throw new IllegalArgumentException("url path is empty!!!");
    }

    public synchronized void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.mSoLoadStatus == 0 && this.mILoadSo != null) {
            this.mSoLoadStatus = 1;
            this.mILoadSo.loadSo(this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.quic.open.IQuicEngine
    public boolean isSoReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.mSoLoadStatus == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.transfile.quic.open.ILoadSoCallback
    public void onLoad(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        synchronized (this) {
            QLog.d(TAG, 1, "onLoad, isSuccess = " + z16);
            if (z16) {
                try {
                    QuicNative.init();
                    QuicNative.setDebugLog(false);
                } catch (Throwable th5) {
                    QLog.e("quic", 4, th5, new Object[0]);
                    this.mSoLoadStatus = 0;
                    callbackWatingReqFail();
                }
                this.mSoLoadStatus = 2;
                executeWatingReq();
            } else {
                this.mSoLoadStatus = 0;
                callbackWatingReqFail();
            }
        }
    }

    private void taskFailedCallback(QuicReq quicReq, String str, String str2, String str3, int i3, String str4) {
        DownloadListener downloadListener = quicReq.mDownloadListener;
        if (downloadListener != null) {
            QuicNetReport quicNetReport = new QuicNetReport();
            quicNetReport.channel = "quic";
            quicNetReport.tempPath = str3;
            quicNetReport.savePath = str;
            quicNetReport.f293472id = str3.hashCode();
            quicNetReport.url = str2;
            quicNetReport.f293473ip = quicReq.mIp;
            quicNetReport.errMsg = str4;
            quicNetReport.port = quicReq.mPort;
            quicNetReport.isIpv6 = quicReq.mIsIpv6;
            quicNetReport.rttHost = quicReq.mRttHost;
            quicNetReport.businessId = quicReq.mBussinessId;
            quicNetReport.timeOut = quicReq.mTimeOut;
            quicNetReport.failReason = i3;
            downloadListener.onDownloadFailed(str2, quicNetReport);
        }
    }

    public QuicEngineImp(ILoadSo iLoadSo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iLoadSo);
        } else {
            this.mReqWaitingList = new ArrayList();
            this.mILoadSo = iLoadSo;
        }
    }
}
