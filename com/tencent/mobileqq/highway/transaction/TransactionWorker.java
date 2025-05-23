package com.tencent.mobileqq.highway.transaction;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.IInject;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.netprobe.EchoProbe;
import com.tencent.mobileqq.highway.netprobe.LoginWifiProbe;
import com.tencent.mobileqq.highway.netprobe.MtuProbe;
import com.tencent.mobileqq.highway.netprobe.ProbeCallback;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeRequest;
import com.tencent.mobileqq.highway.netprobe.ProbeTask;
import com.tencent.mobileqq.highway.netprobe.TracerouteProbe;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TransactionWorker implements IHwManager, HwServlet.OnGetConfigListener {
    static IPatchRedirector $redirector_ = null;
    public static final int PRIORITY_HIGH = 0;
    public static final int PRIORITY_LOW = 2;
    public static final int PRIORITY_MEDIUM = 1;
    public static final int PRIORITY_NUM = 3;
    public static final int TRANS_OP_CNCL = 2;
    public static final int TRANS_OP_SEND = 1;
    private static final int[] round_array;
    private static final AtomicInteger seqFactory;
    private HwEngine engine;
    private volatile int index;
    private SparseArray<ArrayList<Transaction>> transQueues;
    private ArrayList<Transaction> transWaitForSessionKeyQueue;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16429);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            seqFactory = new AtomicInteger(new Random().nextInt(100000));
            round_array = new int[]{0, 0, 1, 0, 0, 1, 2};
        }
    }

    public TransactionWorker(HwEngine hwEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hwEngine);
            return;
        }
        this.transQueues = new SparseArray<>();
        this.index = 0;
        this.transWaitForSessionKeyQueue = new ArrayList<>();
        this.engine = hwEngine;
    }

    private void submitTransactionToTransQuene(Transaction transaction) {
        int i3;
        transaction.transationId = seqFactory.incrementAndGet();
        BdhLogUtil.LogEvent("T", "SubmitTransation : T_Id:" + transaction.transationId + " ukey:" + String.valueOf(transaction.ticket));
        synchronized (this.transQueues) {
            if (transaction.mBuzCmdId == 25) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (this.transQueues.get(i3) != null) {
                this.transQueues.get(i3).add(transaction);
                BdhLogUtil.LogEvent("T", "SubmitTransation : T_Id:" + transaction.transationId + " : add to queue[ " + i3 + "]");
            }
        }
        notifyToSend();
        transaction.startTime = SystemClock.uptimeMillis();
    }

    private int submitTransactionToWaitForSessionKeyQuene(Transaction transaction) {
        IInject iInject;
        RequestWorker requestWorker;
        HwEngine hwEngine = this.engine;
        if (hwEngine != null && (iInject = hwEngine.injectHelper) != null && (requestWorker = hwEngine.mRequestWorker) != null && requestWorker.mRequestHandler != null) {
            HwServlet.getConfig(iInject.getRuntime(), this.engine.currentUin, this);
            synchronized (SessionInfo.class) {
                this.transWaitForSessionKeyQueue.add(transaction);
            }
            transaction.startTimeoutTimer();
            BdhLogUtil.LogEvent("T", "Submit Trans to transWaitForSessionKeyQueue ,Transaction path:" + transaction.filePath + " transWaitForSessionKeyQueue size:" + this.transWaitForSessionKeyQueue.size());
            return 0;
        }
        return -1018;
    }

    public void cancelTransaction(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) transaction);
        } else {
            transaction.cancelTransaction();
            this.engine.mRequestWorker.notifyTransactionChange(2, transaction);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dumpEngineInfo() {
        QLog.d("E", 1, "EngineInfo : Request:" + this.engine.mRequestWorker.mCurrentRequests + " TransCnt:" + this.engine.mTransWorker.getTransactionNum() + " ConnCnt:" + this.engine.mConnManager.connectedConn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getConnErroCode() {
        return this.engine.mConnManager.vConnErrCode;
    }

    public HwEngine getHwEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (HwEngine) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.engine;
    }

    public long getIpConnectCost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.engine.mConnManager.getConnCost();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLastUsedIp() {
        EndPoint endPoint = this.engine.mConnManager.lastEndPoint;
        if (endPoint != null) {
            return endPoint.host;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLastUsedPort() {
        EndPoint endPoint = this.engine.mConnManager.lastEndPoint;
        if (endPoint != null) {
            return String.valueOf(endPoint.port);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long[] getReportDataFlow() {
        return new long[]{this.engine.upFlow_Wifi.getAndSet(0L), this.engine.dwFlow_Wifi.getAndSet(0L), this.engine.upFlow_Xg.getAndSet(0L), this.engine.dwFlow_Xg.getAndSet(0L)};
    }

    public Transaction getTransactionById(int i3) {
        Transaction transaction;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Transaction) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        synchronized (this.transQueues) {
            transaction = null;
            for (int i16 = 0; i16 < 3; i16++) {
                ArrayList<Transaction> arrayList = this.transQueues.get(i16);
                if (arrayList != null) {
                    Iterator<Transaction> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Transaction next = it.next();
                        if (next.getTransationId() == i3) {
                            transaction = next;
                        }
                    }
                }
            }
        }
        return transaction;
    }

    public int getTransactionNum() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        synchronized (this.transQueues) {
            i3 = 0;
            for (int i16 = 0; i16 < 3; i16++) {
                if (this.transQueues.get(i16) != null) {
                    i3 += this.transQueues.get(i16).size();
                }
            }
        }
        return i3;
    }

    public boolean isNetworkConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return BdhUtils.isBdhNetConnected(this.engine.getAppContext());
    }

    public void notifyToSend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.engine.mRequestWorker.notifyTransactionChange(1, null);
        }
    }

    @Override // com.tencent.mobileqq.highway.IHwManager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this.transQueues) {
            for (int i3 = 0; i3 < 3; i3++) {
                ArrayList arrayList = new ArrayList();
                if (this.transQueues.get(i3) != null) {
                    arrayList.addAll(this.transQueues.get(i3));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        cancelTransaction((Transaction) it.next());
                    }
                    this.transQueues.get(i3).clear();
                }
            }
            this.transQueues.clear();
        }
        this.transWaitForSessionKeyQueue = new ArrayList<>();
    }

    @Override // com.tencent.mobileqq.highway.config.HwServlet.OnGetConfigListener
    public void onGetConfig() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        HwEngine hwEngine = this.engine;
        if (hwEngine != null && (str = hwEngine.currentUin) != null) {
            synchronized (SessionInfo.class) {
                byte[] httpconn_sig_session = SessionInfo.getInstance(str).getHttpconn_sig_session();
                if (httpconn_sig_session != null && httpconn_sig_session.length != 0) {
                    BdhLogUtil.LogEvent("E", "onGetConfig suc,transWaitForSessionKeyQueue size:" + this.transWaitForSessionKeyQueue.size());
                    int length = httpconn_sig_session.length;
                    Iterator<Transaction> it = this.transWaitForSessionKeyQueue.iterator();
                    while (it.hasNext()) {
                        Transaction next = it.next();
                        byte[] bArr = new byte[length];
                        next.ticket = bArr;
                        System.arraycopy(httpconn_sig_session, 0, bArr, 0, length);
                        if (next.needCryptExtendInfo) {
                            byte[] sessionKey = SessionInfo.getInstance(str).getSessionKey();
                            if (sessionKey != null && sessionKey.length != 0) {
                                int length2 = sessionKey.length;
                                byte[] bArr2 = new byte[length2];
                                System.arraycopy(sessionKey, 0, bArr2, 0, length2);
                                next.extendInfo = new Cryptor().encrypt(next.extendInfo, bArr2);
                                submitTransactionToTransQuene(next);
                            } else {
                                BdhLogUtil.LogEvent("T", "onGetConfig,get sessionKey successfully,but task has mSigSession, not has mSessionKey, transaction path:" + next.filePath);
                                HwServlet.getConfig(this.engine.injectHelper.getRuntime(), str);
                                next.onTransFailed(-1017, "", 0, 0, 0, null);
                            }
                        } else {
                            submitTransactionToTransQuene(next);
                        }
                    }
                    this.transWaitForSessionKeyQueue.clear();
                } else {
                    BdhLogUtil.LogEvent("E", "onGetConfig failed,transWaitForSessionKeyQueue size:" + this.transWaitForSessionKeyQueue.size());
                    Iterator<Transaction> it5 = this.transWaitForSessionKeyQueue.iterator();
                    while (it5.hasNext()) {
                        it5.next().onTransFailed(-1016, "", 0, 0, 0, null);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.highway.IHwManager
    public void onInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (this.transQueues) {
            for (int i3 = 0; i3 < 3; i3++) {
                this.transQueues.put(i3, new ArrayList<>());
            }
        }
    }

    public void onTransactionFinish(boolean z16, Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), transaction);
            return;
        }
        synchronized (this.transQueues) {
            for (int i3 = 0; i3 < 3; i3++) {
                if (this.transQueues.get(i3) != null) {
                    this.transQueues.get(i3).remove(transaction);
                }
            }
        }
        if (!z16) {
            this.engine.mRequestWorker.notifyTransactionChange(2, transaction);
        }
    }

    public DataTransInfo pullNextSegment(SparseArray<HwNetSegConf> sparseArray) {
        DataTransInfo dataTransInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (DataTransInfo) iPatchRedirector.redirect((short) 14, (Object) this, (Object) sparseArray);
        }
        synchronized (this.transQueues) {
            dataTransInfo = null;
            int i3 = 0;
            do {
                int[] iArr = round_array;
                if (i3 >= iArr.length) {
                    break;
                }
                ArrayList<Transaction> arrayList = this.transQueues.get(iArr[this.index]);
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<Transaction> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Transaction next = it.next();
                        HwNetSegConf hwNetSegConf = sparseArray.get(next.getBuzType());
                        if (hwNetSegConf == null) {
                            sparseArray.get(0);
                        }
                        DataTransInfo peekNextSegment = next.peekNextSegment(hwNetSegConf);
                        if (peekNextSegment != null) {
                            if (QLog.isDevelopLevel()) {
                                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "pullNextSegment : T_Id:" + peekNextSegment.parent.getTransationId() + " ConfSegNum:" + hwNetSegConf.segNum + " ConfSegSize:" + hwNetSegConf.segSize);
                            }
                            dataTransInfo = peekNextSegment;
                        }
                    }
                }
                if (this.index >= round_array.length - 1) {
                    this.index = 0;
                } else {
                    this.index++;
                }
                i3++;
            } while (dataTransInfo == null);
        }
        return dataTransInfo;
    }

    public void resumeTransaction(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) transaction);
        } else {
            transaction.setPause(false);
            this.engine.mRequestWorker.notifyTransactionChange(1, transaction);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean startNetDetection(ProbeCallback probeCallback) {
        try {
            EndPoint endPoint = this.engine.mConnManager.lastEndPoint;
            if (endPoint != null) {
                ProbeChain probeChain = new ProbeChain();
                probeChain.addProbeItem(new LoginWifiProbe());
                probeChain.addProbeItem(new MtuProbe());
                probeChain.addProbeItem(new EchoProbe());
                probeChain.addProbeItem(new TracerouteProbe());
                if (this.engine.mWeakNetLearner.startProbe(new ProbeTask(new ProbeRequest(endPoint.host, probeChain), probeCallback))) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startTransRunnable(Runnable runnable, Runnable runnable2) {
        RequestWorker.RequestHandler requestHandler = this.engine.mRequestWorker.mRequestHandler;
        if (requestHandler != null) {
            if (runnable != null) {
                requestHandler.removeCallbacks(runnable);
            }
            requestHandler.postDelayed(runnable2, 600000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopTransRunnable(Runnable runnable) {
        RequestWorker.RequestHandler requestHandler = this.engine.mRequestWorker.mRequestHandler;
        if (requestHandler != null) {
            requestHandler.removeCallbacks(runnable);
        }
    }

    public void stopTransaction(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) transaction);
        } else {
            transaction.setPause(true);
            this.engine.mRequestWorker.notifyTransactionChange(2, transaction);
        }
    }

    public int submitTransation(Transaction transaction) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) transaction)).intValue();
        }
        if (transaction != null && transaction.filePath != null && transaction.transationId == -1) {
            if (this.engine.mConnManager.getCurrentConnNum() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int initSegmentList = transaction.initSegmentList(this, z16);
            if (initSegmentList == 0) {
                if (transaction.ticket != null) {
                    submitTransactionToTransQuene(transaction);
                } else {
                    return submitTransactionToWaitForSessionKeyQuene(transaction);
                }
            }
            return initSegmentList;
        }
        return 9042;
    }

    public void switchToBackupChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        synchronized (this.transQueues) {
            for (int i3 = 0; i3 < 3; i3++) {
                if (this.transQueues.get(i3) != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.transQueues.get(i3));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Transaction transaction = (Transaction) it.next();
                        cancelTransaction(transaction);
                        transaction.onSwitchToBackupChannel();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean updateAndCheckNet() {
        HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
        if (HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType() == 0) {
            return false;
        }
        return true;
    }
}
