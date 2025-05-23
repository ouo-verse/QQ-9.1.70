package com.tencent.mobileqq.highway.transaction;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.kernel.AbstractKernelEngine;
import com.tencent.mobileqq.highway.netprobe.ProbeCallback;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.highway.netprobe.ProbeResponse;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.RequestDataTrans;
import com.tencent.mobileqq.highway.segment.RequestFinishQuery;
import com.tencent.mobileqq.highway.segment.RequestInfoQuery;
import com.tencent.mobileqq.highway.utils.BaseConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.TransactionReport;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelDataReportService;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Transaction implements ProbeCallback {
    static IPatchRedirector $redirector_ = null;
    public static final int HOLE_MASK_FIN = 3;
    public static final int HOLE_MASK_HOLD = 4;
    public static final int HOLE_MASK_INIT = 0;
    public static final int HOLE_MASK_SENT = 2;
    public static final int HOLE_MASK_WAIT = 1;
    public static final int HOLE_SIZE_PER_HOLE = 8192;
    private static final int MAX_QUERY_HOLE_RSP_SIZE = 5;
    public static final long waitForSessionkeyTimeout = 30000;
    public byte[] MD5;
    public Tracker TRACKER;
    private AtomicBoolean TimerStarted;
    public volatile boolean bQueryForFIN;
    public byte[] bitmap;
    public CacheIpInfo cacheIpInfo;

    /* renamed from: cb, reason: collision with root package name */
    public ITransactionCallback f236840cb;
    public ITransCallbackForReport cbForReport;
    public byte[] extendInfo;
    public String filePath;
    public AtomicBoolean hasSwitch2BackupChannel;
    public AtomicBoolean isFinish;
    public boolean isOpenUpEnable;
    public AtomicBoolean isSuccess;
    public boolean isUseKernel;
    public long kernelTransID;
    public CSDataHighwayHead.LoginSigHead loginSigHead;
    public byte[] mBuExtendinfo;
    public int mBuzCmdId;
    public int mCurrentQueryFinishCount;
    public int mErrorCode;
    private AtomicBoolean mIsPause;
    public String mMD5Str;
    boolean mNeedSegmentLikeVideo;
    private HashMap<String, String> mReport;
    public TransTimeOutMonitor mTimeOutMonitor;
    public TransReport mTransReport;
    private TransactionWorker mTransWorker;
    boolean needCryptExtendInfo;
    public int offset;
    public String peerUin;
    public int preSendDots;
    private RandomAccessFile raf;
    public int reUploadHwSeq;
    public boolean reUploadTransaction;
    private ConcurrentHashMap<Integer, HwRequest> sentRequestsRetry;
    public long startTime;
    public byte[] ticket;
    public int totalLength;
    int transationId;
    private int transferedSize;
    public int transferedSizeBDH;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface HwBuzType {
        public static final int COMMON = 0;
        public static final int PIC = 0;
        public static final int PIC_SUBBUZ_COMMON = 1;
        public static final int PIC_SUBBUZ_OPENUP = 4;
        public static final int SHORT_VIDEO = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class TransTimeOutMonitor implements Runnable {
        static IPatchRedirector $redirector_;
        public volatile boolean isKilled;
        public long mStartTime;

        public TransTimeOutMonitor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Transaction.this);
                return;
            }
            this.isKilled = false;
            this.mStartTime = 0L;
            this.mStartTime = SystemClock.uptimeMillis();
        }

        public boolean needExtendTimeExceedLimit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (SystemClock.uptimeMillis() - this.mStartTime >= 60000) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (!this.isKilled) {
                Transaction.this.onTransFailed(-1002, "TransTimeOut", -1002, -1002, 0, null);
            }
        }
    }

    public Transaction(String str, int i3, String str2, int i16, byte[] bArr, byte[] bArr2, ITransactionCallback iTransactionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), bArr, bArr2, iTransactionCallback);
            return;
        }
        this.transationId = -1;
        this.totalLength = 0;
        this.transferedSize = 0;
        this.transferedSizeBDH = 0;
        this.reUploadTransaction = false;
        this.reUploadHwSeq = 0;
        this.isFinish = new AtomicBoolean(false);
        this.mIsPause = new AtomicBoolean(false);
        this.bQueryForFIN = false;
        this.TimerStarted = new AtomicBoolean(false);
        this.TRACKER = null;
        this.mTransReport = new TransReport();
        this.isSuccess = new AtomicBoolean(false);
        this.mErrorCode = -1;
        this.mReport = new HashMap<>();
        this.needCryptExtendInfo = false;
        this.mNeedSegmentLikeVideo = false;
        this.sentRequestsRetry = new ConcurrentHashMap<>();
        this.mCurrentQueryFinishCount = 0;
        this.isUseKernel = false;
        this.hasSwitch2BackupChannel = new AtomicBoolean(false);
        this.peerUin = str;
        this.filePath = str2;
        this.offset = i16;
        this.mBuzCmdId = i3;
        this.MD5 = bArr2;
        this.ticket = bArr;
        this.f236840cb = iTransactionCallback;
        if (i16 < 0) {
            this.offset = 0;
        }
        this.isOpenUpEnable = false;
        this.mMD5Str = BdhUtils.bytes2HexStr(bArr2);
        this.loginSigHead = makeLoginSigHead(str);
    }

    private void extendTimeExceedLimit() {
        TransTimeOutMonitor transTimeOutMonitor = this.mTimeOutMonitor;
        if (transTimeOutMonitor.needExtendTimeExceedLimit()) {
            BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " ExtendTimeExceedLimit.");
            transTimeOutMonitor.isKilled = true;
            if (this.mTransWorker != null) {
                TransTimeOutMonitor transTimeOutMonitor2 = new TransTimeOutMonitor();
                this.mTimeOutMonitor = transTimeOutMonitor2;
                this.mTransWorker.startTransRunnable(transTimeOutMonitor, transTimeOutMonitor2);
            }
        }
    }

    private void finishAndDetachFromWorker(boolean z16) {
        BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "Finish. IsSuccess:" + z16);
        TransactionWorker transactionWorker = this.mTransWorker;
        if (transactionWorker != null) {
            transactionWorker.onTransactionFinish(z16, this);
            this.mTransWorker = null;
        }
        try {
            RandomAccessFile randomAccessFile = this.raf;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.raf = null;
            }
        } catch (IOException e16) {
            BdhLogUtil.LogException("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "Finish Error: IsSuccess:" + z16, e16);
        }
    }

    private String getA2Async(TicketManager ticketManager, String str) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String[] strArr = new String[1];
        try {
            ticketManager.getA2(Long.parseLong(str), 1600001625, new MainTicketCallback(strArr, countDownLatch) { // from class: com.tencent.mobileqq.highway.transaction.Transaction.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String[] val$A2;
                final /* synthetic */ CountDownLatch val$latch;

                {
                    this.val$A2 = strArr;
                    this.val$latch = countDownLatch;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Transaction.this, strArr, countDownLatch);
                    }
                }

                @Override // mqq.manager.MainTicketCallback
                public void onFail(int i3, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str2);
                    } else {
                        this.val$A2[0] = "";
                        this.val$latch.countDown();
                    }
                }

                @Override // mqq.manager.MainTicketCallback
                public void onSuccess(MainTicketInfo mainTicketInfo) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) mainTicketInfo);
                    } else {
                        this.val$A2[0] = mainTicketInfo.getA2();
                        this.val$latch.countDown();
                    }
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e16) {
                BdhLogUtil.LogException("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId(), e16);
                strArr[0] = "";
            }
            return strArr[0];
        } catch (Exception e17) {
            BdhLogUtil.LogException("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId(), e17);
            return "";
        }
    }

    private boolean isPause() {
        return this.mIsPause.get();
    }

    private CSDataHighwayHead.LoginSigHead makeLoginSigHead(String str) {
        String a26;
        byte[] hexToBytes;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        CSDataHighwayHead.LoginSigHead loginSigHead = new CSDataHighwayHead.LoginSigHead();
        TicketManager ticketManager = (TicketManager) peekAppRuntime.getManager(2);
        if (ticketManager != null && !TextUtils.isEmpty(str)) {
            if (ticketManager.useAsyncTicketInterface()) {
                a26 = getA2Async(ticketManager, str);
            } else {
                a26 = ticketManager.getA2(str);
            }
            if (TextUtils.isEmpty(a26)) {
                return null;
            }
            if (a26 != null) {
                try {
                    hexToBytes = BdhUtils.hexToBytes(a26);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return null;
                }
            } else {
                hexToBytes = null;
            }
            if (hexToBytes != null && hexToBytes.length != 0) {
                loginSigHead.bytes_loginsig.set(ByteStringMicro.copyFrom(hexToBytes));
                loginSigHead.uint32_loginsig_type.set(8);
                return loginSigHead;
            }
        }
        return null;
    }

    private void stopTimeoutTimer() {
        BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " StopTimeoutTime.");
        this.TimerStarted.set(false);
        TransTimeOutMonitor transTimeOutMonitor = this.mTimeOutMonitor;
        if (transTimeOutMonitor != null) {
            transTimeOutMonitor.isKilled = true;
        }
        TransactionWorker transactionWorker = this.mTransWorker;
        if (transactionWorker != null) {
            transactionWorker.stopTransRunnable(this.mTimeOutMonitor);
        }
    }

    public void cancelTransaction() {
        Tracker tracker;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            if (!this.isFinish.compareAndSet(false, true) || (tracker = this.TRACKER) == null) {
                return;
            }
            tracker.logStep(Tracker.CANCL, "");
            stopTimeoutTimer();
            finishAndDetachFromWorker(false);
        }
    }

    public void continueTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d(BdhLogUtil.Tag, 1, "T \tT_ID:" + getTransationId() + "\tcontinueTrans.");
        if (this.isFinish.get()) {
            return;
        }
        int i3 = this.totalLength;
        int i16 = i3 / 8192;
        if (i3 % 8192 != 0) {
            i16++;
        }
        for (int i17 = this.preSendDots; i17 < i16; i17++) {
            byte[] bArr = this.bitmap;
            if (bArr[i17] == 4) {
                bArr[i17] = 0;
            }
        }
        this.mTransWorker.notifyToSend();
    }

    public int getBuzType() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        if (this.mNeedSegmentLikeVideo || (i3 = this.mBuzCmdId) == 12 || i3 == 25) {
            return 1;
        }
        return 0;
    }

    public synchronized byte[] getData(DataTransInfo dataTransInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (byte[]) iPatchRedirector.redirect((short) 17, (Object) this, (Object) dataTransInfo);
        }
        int i3 = 0;
        if (this.isFinish.get()) {
            dataTransInfo.errno = 0;
            return null;
        }
        try {
            int i16 = dataTransInfo.length;
            byte[] bArr = new byte[i16];
            this.raf.seek(dataTransInfo.offset);
            while (i3 < dataTransInfo.length) {
                int read = this.raf.read(bArr, i3, i16);
                if (read == -1) {
                    dataTransInfo.errno = 9303;
                    return null;
                }
                i3 += read;
                i16 -= read;
            }
            return bArr;
        } catch (IOException e16) {
            BdhLogUtil.LogException("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "GetData Error.", e16);
            dataTransInfo.errno = BdhUtils.analysisIOProblem(e16);
            return null;
        }
    }

    public ConcurrentHashMap<Integer, HwRequest> getRetryRequests() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.sentRequestsRetry;
    }

    public int getTransationId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.transationId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int initSegmentList(TransactionWorker transactionWorker, boolean z16) {
        QLog.d(BdhLogUtil.Tag, 1, "T T_ID:" + getTransationId() + "\tinitSegmentList : \tisOpenUpEnable : " + this.isOpenUpEnable);
        this.mTransReport.mIsPreConnExist = z16;
        File file = new File(this.filePath);
        this.mTransWorker = transactionWorker;
        if (file.exists()) {
            if (!file.canRead()) {
                return 9070;
            }
            int length = (int) file.length();
            this.totalLength = length;
            if (length <= 0) {
                return 9071;
            }
            try {
                this.raf = new RandomAccessFile(file, "r");
                int i3 = this.totalLength;
                int i16 = i3 / 8192;
                if (i3 % 8192 != 0) {
                    i16++;
                }
                int i17 = this.offset / 8192;
                this.bitmap = new byte[i16];
                if (this.isOpenUpEnable) {
                    for (int i18 = 0; i18 < i16; i18++) {
                        if (i18 < this.preSendDots) {
                            this.bitmap[i18] = 0;
                        } else {
                            this.bitmap[i18] = 4;
                        }
                    }
                } else {
                    for (int i19 = 0; i19 < i16; i19++) {
                        if (i19 < i17) {
                            this.bitmap[i19] = 3;
                        } else {
                            this.bitmap[i19] = 0;
                        }
                    }
                }
                this.TRACKER = new Tracker(this.transationId, this.totalLength);
                this.mTimeOutMonitor = new TransTimeOutMonitor();
                this.TRACKER.logStep(Tracker.INITI, "DotsNum:" + i16 + " StartHole:" + i17);
                return 0;
            } catch (FileNotFoundException unused) {
            }
        }
        return 9042;
    }

    void needBDHReport(HashMap<String, String> hashMap) {
        int i3 = this.mCurrentQueryFinishCount;
        if (i3 > 0) {
            TransactionReport.reportQueryFinishQuality(this, i3);
        }
        reportKernel();
        int[] iArr = BaseConstants.BdhBusinessType.reportBDHExcept;
        int length = iArr.length;
        boolean z16 = false;
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                if (iArr[i16] == this.mBuzCmdId) {
                    break;
                } else {
                    i16++;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (z16 && this.startTime != 0 && this.totalLength != 0 && this.mTransWorker != null) {
            TransactionReport.reportFunction(TransactionReport.REPORT_TAG_ACTBDHCHANNEL, this, null);
        }
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeCallback
    public void onProbeFinish(ProbeResponse probeResponse) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) probeResponse);
            return;
        }
        StringBuilder sb5 = new StringBuilder("");
        for (ProbeItem probeItem : probeResponse.mProbeItemResults.keySet()) {
            if (ProbeChain.PROBE_NAME.equals(probeItem.getProbeName())) {
                Iterator<ProbeItem> it = ((ProbeChain) probeItem).chain.iterator();
                while (it.hasNext()) {
                    ProbeItem next = it.next();
                    if (next.mResult != null) {
                        sb5.append(next.getProbeName());
                        sb5.append("[");
                        if (next.mResult.success) {
                            str = "1";
                        } else {
                            str = "0";
                        }
                        sb5.append(str);
                        sb5.append("]");
                        sb5.append("[");
                        sb5.append(next.mResult.errCode);
                        sb5.append("];");
                    }
                }
            }
        }
        String str2 = this.mReport.get(TransReport.rep_bdhTrans);
        if (str2 != null) {
            this.mReport.put(TransReport.rep_bdhTrans, str2 + ((Object) sb5));
        }
        ITransactionCallback iTransactionCallback = this.f236840cb;
        if (iTransactionCallback != null) {
            iTransactionCallback.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
        }
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeCallback
    public void onProbeProgress(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        }
    }

    public void onQuertHoleError(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
            return;
        }
        if (this.isFinish.get()) {
            return;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " QueryDebug Query OnQuertHoleError : CopyBitmap:" + Arrays.toString(bArr) + " CurrentBitmap:" + Arrays.toString(this.bitmap));
        int i3 = 0;
        while (true) {
            byte[] bArr2 = this.bitmap;
            if (i3 < bArr2.length) {
                if (bArr2[i3] != 3 && bArr[i3] == 2) {
                    bArr2[i3] = 0;
                }
                i3++;
            } else {
                this.TRACKER.logStep(Tracker.QUERY, "QueryHoleError Bitmap:" + Arrays.toString(this.bitmap));
                this.mTransWorker.notifyToSend();
                return;
            }
        }
    }

    public void onQueryHoleResp(CSDataHighwayHead.QueryHoleRsp queryHoleRsp, byte[] bArr, boolean z16, HwResponse hwResponse, RequestInfoQuery requestInfoQuery) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, queryHoleRsp, bArr, Boolean.valueOf(z16), hwResponse, requestInfoQuery);
            return;
        }
        if (this.isFinish.get()) {
            return;
        }
        BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + " \tT_ID:" + getTransationId() + "\tQueryHoleResp");
        int i3 = queryHoleRsp.uint32_result.get();
        byte[] bArr2 = new byte[bArr.length];
        BdhUtils.copyData(bArr2, 0, bArr, 0, bArr.length);
        if (i3 != 0) {
            onQuertHoleError(bArr);
            return;
        }
        StringBuilder sb5 = new StringBuilder("Holes:");
        List<CSDataHighwayHead.DataHole> list = queryHoleRsp.rpt_data_hole.get();
        if (list != null && !list.isEmpty()) {
            int i16 = 0;
            for (CSDataHighwayHead.DataHole dataHole : list) {
                int i17 = (int) dataHole.uint64_begin.get();
                int i18 = (int) dataHole.uint64_end.get();
                int i19 = i17 / 8192;
                int i26 = (i18 - 1) / 8192;
                if (i26 > i16) {
                    i16 = i26;
                }
                sb5.append("Holes Start:");
                sb5.append(i19);
                sb5.append(" End:");
                sb5.append(i26);
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnQueryHoleResp : holes :  HoleStart:" + i17 + " HoleEnd:" + i18 + " BitmapS:" + i19 + " BitmapE:" + i26);
                while (i19 <= i26) {
                    if (bArr[i19] == 2) {
                        bArr[i19] = 0;
                    }
                    i19++;
                }
            }
            if (i16 >= bArr.length) {
                i16 = bArr.length - 1;
            }
            if (list.size() >= 5) {
                while (i16 < bArr.length) {
                    bArr[i16] = 0;
                    i16++;
                }
            }
            for (int i27 = 0; i27 < bArr.length; i27++) {
                if (bArr2[i27] == 2 && bArr[i27] == 0 && (this.bQueryForFIN || this.bitmap[i27] != 3)) {
                    this.bitmap[i27] = 0;
                } else if (bArr[i27] == 2) {
                    this.bitmap[i27] = 3;
                }
            }
            this.bQueryForFIN = false;
            this.mCurrentQueryFinishCount = 0;
        } else {
            sb5.append("null");
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " finish flag is null and hole is null mCurrentQueryFinishCount:" + this.mCurrentQueryFinishCount + " bQueryForFIN:" + this.bQueryForFIN);
            if (this.bQueryForFIN) {
                if (this.mCurrentQueryFinishCount < RequestFinishQuery.QUERY_HOLE_MAX_COUNT) {
                    queryTransactionFinish();
                } else {
                    onTransFailed(BaseConstants.ERROR.Error_QUERY_FINISH_FAIL, "QueryFinishFail", hwResponse.retCode, hwResponse.buzRetCode, requestInfoQuery.retryCount, hwResponse.mBuExtendinfo);
                }
            }
        }
        this.TRACKER.logStep(Tracker.QUERY, "QueryHoleResp " + sb5.toString());
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnQueryHoleResp : Merged : CopyBitmap:" + Arrays.toString(bArr) + " CurrentBitmap:" + Arrays.toString(this.bitmap));
        this.mTransWorker.notifyToSend();
    }

    public void onRequestFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        ITransCallbackForReport iTransCallbackForReport = this.cbForReport;
        if (iTransCallbackForReport != null) {
            iTransCallbackForReport.onFailed(i3, this.mTransWorker.getLastUsedIp(), this.mTransWorker.getLastUsedPort());
        }
    }

    public void onSwitchToBackupChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        stopTimeoutTimer();
        if (this.hasSwitch2BackupChannel.get()) {
            return;
        }
        this.hasSwitch2BackupChannel.set(true);
        ITransactionCallback iTransactionCallback = this.f236840cb;
        if (iTransactionCallback != null) {
            iTransactionCallback.onSwitch2BackupChannel();
        }
    }

    public void onTransFailed(int i3, String str, int i16, int i17, int i18, byte[] bArr) {
        ITransactionCallback iTransactionCallback;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), bArr);
            return;
        }
        if (!this.isFinish.compareAndSet(false, true)) {
            return;
        }
        BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " OnTransFailed : ERR_C:" + i3 + " ERR_H:" + i16 + " ERR_B:" + i17);
        stopTimeoutTimer();
        this.mTransReport.updateRetryInfo(i18);
        this.mBuExtendinfo = bArr;
        this.mErrorCode = i3;
        if (i17 != 0) {
            this.mErrorCode = i17;
        } else if (i16 != 0) {
            this.mErrorCode = i16;
        }
        TransactionWorker transactionWorker = this.mTransWorker;
        if (transactionWorker != null) {
            this.mTransReport.bHasNet = transactionWorker.updateAndCheckNet();
            this.mTransReport.isConnected = this.mTransWorker.isNetworkConnected();
            this.mTransReport.connErrCode = this.mTransWorker.getConnErroCode();
            this.mTransReport.setFailReason(this.mErrorCode, str);
            int i19 = this.mErrorCode;
            if (i19 == -1002 || i19 == -1005) {
                this.mTransWorker.dumpEngineInfo();
                String dumpTrackerInfo = this.TRACKER.dumpTrackerInfo();
                this.TRACKER.logStep(Tracker.QUERY, "TransFailed  Bitmap:" + Arrays.toString(this.bitmap));
                QLog.d("T", 1, "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " TRACEKERINFO:" + dumpTrackerInfo);
                if (BdhUtils.isNetWorkProb(this.mTransReport.connErrCode)) {
                    this.mErrorCode = 9004;
                }
            }
            int i26 = this.mBuzCmdId;
            if (i26 != 1 && i26 != 2 && i26 != 4) {
                TransReport transReport = this.mTransReport;
                if (!transReport.bHasNet || BdhUtils.isNetWorkProb(transReport.connErrCode)) {
                    this.mErrorCode = 9004;
                }
            } else {
                TransReport transReport2 = this.mTransReport;
                if (transReport2.bHasNet && !BdhUtils.isNetWorkProb(transReport2.connErrCode)) {
                    if (this.mErrorCode <= 0) {
                        TransReport transReport3 = this.mTransReport;
                        if (!transReport3.bHasNet || !transReport3.isConnected || BdhUtils.isNetWorkProb(transReport3.connErrCode)) {
                            this.mErrorCode = 9004;
                        }
                    }
                } else {
                    this.mErrorCode = 9004;
                }
            }
        }
        HashMap<String, String> updateAndGetReporter = updateAndGetReporter();
        this.mReport = updateAndGetReporter;
        needBDHReport(updateAndGetReporter);
        if (this.mTransReport.bHasNet && (i3 == -1002 || i3 == -1005 || i3 == -1003 || i3 == -1014)) {
            boolean startNetDetection = this.mTransWorker.startNetDetection(this);
            finishAndDetachFromWorker(false);
            if (!startNetDetection && (iTransactionCallback = this.f236840cb) != null) {
                iTransactionCallback.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
                return;
            }
            return;
        }
        finishAndDetachFromWorker(false);
        ITransactionCallback iTransactionCallback2 = this.f236840cb;
        if (iTransactionCallback2 != null) {
            iTransactionCallback2.onFailed(this.mErrorCode, this.mBuExtendinfo, this.mReport);
        }
    }

    public void onTransProgress(RequestDataTrans requestDataTrans, HwResponse hwResponse) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) requestDataTrans, (Object) hwResponse);
            return;
        }
        if (this.isFinish.get()) {
            return;
        }
        DataTransInfo dataTransInfo = requestDataTrans.mInfo;
        extendTimeExceedLimit();
        this.mTransReport.updateRetryInfo(dataTransInfo.retryTimes);
        TransReport transReport = this.mTransReport;
        long j3 = transReport.timeCost_Send;
        long j16 = dataTransInfo.timeCost_req;
        long j17 = dataTransInfo.timeCost_hw;
        long j18 = dataTransInfo.timeCost_cache;
        transReport.timeCost_Send = (int) (j3 + ((j16 - j17) - j18));
        transReport.timeCost_Ht = (int) (transReport.timeCost_Ht + j17);
        transReport.timeCost_Cache = (int) (transReport.timeCost_Cache + j18);
        int i3 = dataTransInfo.bitmapS;
        int i16 = dataTransInfo.bitmapE;
        if (i16 >= this.bitmap.length) {
            return;
        }
        for (int i17 = i3; i17 <= i16; i17++) {
            this.bitmap[i17] = 3;
        }
        int i18 = 0;
        int i19 = 0;
        while (true) {
            bArr = this.bitmap;
            if (i18 >= bArr.length) {
                break;
            }
            if (bArr[i18] == 3) {
                i19++;
            }
            i18++;
        }
        int i26 = i19 * 8192;
        this.transferedSize = i26;
        if (bArr[bArr.length - 1] == 3) {
            this.transferedSize = i26 - ((bArr.length * 8192) - this.totalLength);
        }
        int i27 = this.transferedSizeBDH;
        if (i27 - this.transferedSize > this.totalLength / 10) {
            int i28 = i27 / 8192;
            for (int i29 = 0; i29 < i28; i29++) {
                this.bitmap[i29] = 3;
            }
            this.mTransWorker.getHwEngine().mRequestWorker.remove2SENDRequest(this.transationId, i28);
            BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "UpdateTransferedSizeToServerRange,local size:" + this.transferedSize + " server size:" + this.transferedSizeBDH);
        }
        if (this.transferedSize >= this.totalLength) {
            BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "NotifySegmentProgress Error : Finish flag is lost.");
            this.mTransReport.bFINLost = true;
        }
        if (this.f236840cb != null) {
            BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " NotifySegmentProgress Total:" + this.totalLength + " TransSize:" + this.transferedSize + " allHoles:" + this.bitmap.length + " [" + i3 + ":" + i16 + "]");
            this.f236840cb.onUpdateProgress(this.transferedSize);
        }
        this.TRACKER.logStep(Tracker.PRGRS, "TransProgress Start:" + i3 + " End:" + i16);
        if (this.mTransReport.bFINLost && !this.bQueryForFIN) {
            this.bQueryForFIN = true;
            this.mTransReport.bFINLost = false;
            queryTransactionFinish();
            this.TRACKER.logStep(Tracker.QUERY, "FinFlagLost  Bitmap:" + Arrays.toString(this.bitmap));
        }
    }

    public void onTransReUpload(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        this.reUploadTransaction = true;
        this.reUploadHwSeq = i3;
        this.transferedSizeBDH = 0;
        extendTimeExceedLimit();
        int i16 = this.totalLength;
        int i17 = i16 / 8192;
        if (i16 % 8192 != 0) {
            i17++;
        }
        this.mTransWorker.getHwEngine().mRequestWorker.remove2SENDRequest(this.transationId, i17);
        for (int i18 = 0; i18 < i17; i18++) {
            this.bitmap[i18] = 0;
        }
        BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "reUpload long video");
        this.TRACKER.logStep(Tracker.REUPLOAD, "ReUpload trasaction");
        this.mTransReport.hasReUpload = true;
    }

    public void onTransSuccess(DataTransInfo dataTransInfo, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) dataTransInfo, (Object) bArr);
            return;
        }
        BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + " NotifySegmentSuccess");
        if (!this.isFinish.compareAndSet(false, true)) {
            return;
        }
        this.isSuccess.set(true);
        stopTimeoutTimer();
        if (dataTransInfo != null) {
            this.mTransReport.updateRetryInfo(dataTransInfo.retryTimes);
        }
        if (dataTransInfo != null) {
            TransReport transReport = this.mTransReport;
            long j3 = transReport.timeCost_Send;
            long j16 = dataTransInfo.timeCost_req;
            long j17 = dataTransInfo.timeCost_hw;
            long j18 = dataTransInfo.timeCost_cache;
            transReport.timeCost_Send = (int) (j3 + ((j16 - j17) - j18));
            transReport.timeCost_Ht = (int) (transReport.timeCost_Ht + j17);
            transReport.timeCost_Cache = (int) (transReport.timeCost_Cache + j18);
        }
        this.mBuExtendinfo = bArr;
        this.transferedSize = this.totalLength;
        HashMap<String, String> updateAndGetReporter = updateAndGetReporter();
        needBDHReport(updateAndGetReporter);
        finishAndDetachFromWorker(true);
        ITransactionCallback iTransactionCallback = this.f236840cb;
        if (iTransactionCallback != null) {
            iTransactionCallback.onSuccess(this.mBuExtendinfo, updateAndGetReporter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataTransInfo peekNextSegment(HwNetSegConf hwNetSegConf) {
        int i3 = (int) hwNetSegConf.segSize;
        DataTransInfo dataTransInfo = null;
        if (!this.isFinish.get() && !isPause()) {
            TransReport transReport = this.mTransReport;
            if (transReport.confSegSize == 0) {
                transReport.confSegSize = (int) hwNetSegConf.segSize;
                transReport.confSegNum = (int) hwNetSegConf.segNum;
                transReport.confConnNum = (int) hwNetSegConf.curConnNum;
            }
            int i16 = i3 / 8192;
            if (i3 % 8192 > 0) {
                i16++;
            }
            int i17 = 0;
            int i18 = -1;
            while (true) {
                byte[] bArr = this.bitmap;
                if (i17 < bArr.length) {
                    byte b16 = bArr[i17];
                    if (b16 == 0) {
                        if (i18 == -1) {
                            i18 = i17;
                        }
                        if (i17 == bArr.length - 1 || i16 == (i17 + 1) - i18) {
                            break;
                        }
                        i17++;
                    } else if (this.isOpenUpEnable && b16 == 4) {
                        i17 = i18 != -1 ? i17 - 1 : -1;
                        stopTimeoutTimer();
                    } else {
                        if (i18 != -1) {
                            break;
                        }
                        i17++;
                    }
                } else {
                    i17 = -1;
                    break;
                }
            }
            if (i18 != -1 && i17 != -1) {
                this.mTransReport.sliceNum++;
                dataTransInfo = new DataTransInfo(this);
                int i19 = this.totalLength;
                dataTransInfo.fileSize = i19;
                dataTransInfo.offset = i18 * 8192;
                dataTransInfo.bitmapS = i18;
                dataTransInfo.bitmapE = i17;
                byte[] bArr2 = this.bitmap;
                if (i17 == bArr2.length - 1) {
                    dataTransInfo.length = ((i17 - i18) * 8192) + (i19 - ((bArr2.length - 1) * 8192));
                } else {
                    dataTransInfo.length = ((i17 - i18) + 1) * 8192;
                }
                for (int i26 = i18; i26 <= i17; i26++) {
                    this.bitmap[i26] = 1;
                }
                this.TRACKER.logStep(Tracker.SLICE, "Start:" + i18 + " End:" + i17 + " Length:" + dataTransInfo.length);
                startTimeoutTimer();
            }
        }
        return dataTransInfo;
    }

    public void queryTransactionFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        byte[] bArr = new byte[this.bitmap.length];
        for (int i3 = 0; i3 <= this.bitmap.length - 1; i3++) {
            bArr[i3] = 2;
        }
        this.mTransWorker.getHwEngine().mRequestWorker.sendInfoQueryFinish(this, bArr, this.mCurrentQueryFinishCount);
    }

    void reportKernel() {
        AbstractKernelEngine abstractKernelEngine;
        IQQNTWrapperSession wrapperSession;
        HwEngine hwEngine = this.mTransWorker.getHwEngine();
        if (hwEngine != null && (abstractKernelEngine = hwEngine.kernelEngine) != null && (wrapperSession = abstractKernelEngine.getWrapperSession()) != null && wrapperSession.getDataReportService() != null) {
            IKernelDataReportService dataReportService = wrapperSession.getDataReportService();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("business", String.valueOf(this.mBuzCmdId));
            hashMap.put("file_size", String.valueOf(this.totalLength));
            hashMap.put("transfer_time", String.valueOf(SystemClock.uptimeMillis() - this.startTime));
            hashMap.put("error_code", String.valueOf(this.mErrorCode));
            dataReportService.beaconDataReport(null, "nt_bdh_upload", this.isSuccess.get(), hashMap, false);
        }
    }

    public void setPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        this.mIsPause.set(z16);
        if (isPause()) {
            stopTimeoutTimer();
        }
    }

    public void setVideoSegmentMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.mNeedSegmentLikeVideo = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startTimeoutTimer() {
        if (this.TimerStarted.compareAndSet(false, true)) {
            BdhLogUtil.LogEvent("T", "B_ID:" + this.mBuzCmdId + "\tT_ID:" + getTransationId() + "startTimeoutTimer.");
            ITransactionCallback iTransactionCallback = this.f236840cb;
            if (iTransactionCallback != null) {
                iTransactionCallback.onTransStart();
            }
            if (this.mTransWorker != null) {
                TransTimeOutMonitor transTimeOutMonitor = this.mTimeOutMonitor;
                transTimeOutMonitor.isKilled = true;
                TransTimeOutMonitor transTimeOutMonitor2 = new TransTimeOutMonitor();
                this.mTimeOutMonitor = transTimeOutMonitor2;
                this.mTransWorker.startTransRunnable(transTimeOutMonitor, transTimeOutMonitor2);
            }
        }
    }

    public HashMap<String, String> updateAndGetReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (HashMap) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        TransactionWorker transactionWorker = this.mTransWorker;
        if (transactionWorker != null) {
            this.mTransReport.ipConnCost = transactionWorker.getIpConnectCost();
            this.mTransReport.dataFlow = this.mTransWorker.getReportDataFlow();
            this.mTransReport.ipAddr = this.mTransWorker.getLastUsedIp();
            this.mTransReport.port = this.mTransWorker.getLastUsedPort();
        }
        TransReport transReport = this.mTransReport;
        transReport.mTransferedSize = this.transferedSize;
        return transReport.getReportInfo();
    }

    public Transaction(String str, int i3, String str2, int i16, byte[] bArr, byte[] bArr2, ITransactionCallback iTransactionCallback, byte[] bArr3) {
        this(str, i3, str2, i16, bArr, bArr2, iTransactionCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.extendInfo = bArr3;
        } else {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), bArr, bArr2, iTransactionCallback, bArr3);
        }
    }

    @Deprecated
    public Transaction(String str, int i3, String str2, int i16, byte[] bArr, byte[] bArr2, ITransactionCallback iTransactionCallback, int i17, byte[] bArr3, CSDataHighwayHead.LoginSigHead loginSigHead) {
        this(str, i3, str2, i16, bArr, bArr2, iTransactionCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), bArr, bArr2, iTransactionCallback, Integer.valueOf(i17), bArr3, loginSigHead);
            return;
        }
        this.isOpenUpEnable = true;
        this.preSendDots = i17;
        this.extendInfo = bArr3;
        this.loginSigHead = loginSigHead;
    }

    public Transaction(String str, int i3, String str2, int i16, byte[] bArr, ITransactionCallback iTransactionCallback, byte[] bArr2, boolean z16) {
        this(str, i3, str2, i16, null, bArr, iTransactionCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), bArr, iTransactionCallback, bArr2, Boolean.valueOf(z16));
            return;
        }
        this.extendInfo = bArr2;
        this.needCryptExtendInfo = z16;
        synchronized (SessionInfo.class) {
            byte[] httpconn_sig_session = SessionInfo.getInstance(str).getHttpconn_sig_session();
            if (httpconn_sig_session != null && httpconn_sig_session.length != 0) {
                int length = httpconn_sig_session.length;
                byte[] bArr3 = new byte[length];
                this.ticket = bArr3;
                System.arraycopy(httpconn_sig_session, 0, bArr3, 0, length);
                if (z16) {
                    byte[] sessionKey = SessionInfo.getInstance(str).getSessionKey();
                    if (sessionKey != null && sessionKey.length != 0) {
                        int length2 = sessionKey.length;
                        byte[] bArr4 = new byte[length2];
                        System.arraycopy(sessionKey, 0, bArr4, 0, length2);
                        this.extendInfo = new Cryptor().encrypt(bArr2, bArr4);
                    } else {
                        this.ticket = null;
                    }
                }
            }
        }
    }
}
