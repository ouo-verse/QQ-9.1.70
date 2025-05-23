package com.tencent.mobileqq.highway.conn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.highway.IInject;
import com.tencent.mobileqq.highway.codec.HttpProtocolDataCodec;
import com.tencent.mobileqq.highway.codec.IProtocolCodecListener;
import com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.segment.RequestHeartBreak;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TcpConnection implements IConnection, IProtocolCodecListener {
    static IPatchRedirector $redirector_ = null;
    public static final int DEDAULT_CONN_TIMEOUT_xG = 20000;
    public static final int DEFAULT_CONN_TIMEOUT_Wi = 10000;
    public static final int DEFAULT_READ_BUF_SIZE = 32768;
    public static final int DEFAULT_READ_TIMEOUT = 30000;
    public static final int DEFAULT_SEND_BUF_SIZE = 524288;
    public static final int HEARTBREAK_DELTA = 20000;
    public static volatile boolean IsRunTimeShutDown = false;
    private static final int MAX_CONTINUE_HREAT = 2;
    private StringBuilder closeDebug;
    private int connId;
    private ConnReportInfo connInfo;
    private IConnectionListener connListener;
    private ConnManager connManager;
    private int continueHeartBreak;
    private TcpProtocolDataCodec dataCodec;
    private AtomicBoolean isConn;
    private boolean isIpv6;
    private AtomicBoolean isRunning;
    private volatile boolean isUrgent;
    private AtomicBoolean isWritting;
    private long lastHeartBreakTime;
    private ReentrantLock lock;
    private ConnWorker mConnHandler;
    private HandlerThread mConnThread;
    private int mConnTimeOut;
    private EndPoint mEp;
    private MsfSocketInputBuffer mInputBuffer;
    public int mLastDataSegSize;
    public long mLastDataTransTime;
    private int mNetFlowDw;
    private int mNetFlowUp;
    private OutputStream mOutputStream;
    private int mReadBufferSize;
    private ReadThread mReadThread;
    private int mReadTimeout;
    public long mRtt;
    private Handler mServletHandler;
    private Socket mSocket;
    private InetSocketAddress serverAddress;
    private AtomicBoolean shouldCloseConn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ConnWorker extends Handler {
        static IPatchRedirector $redirector_ = null;
        public static final int CONN = 1;
        public static final int QUIT = 3;
        public static final int SEND = 2;

        public ConnWorker(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TcpConnection.this, (Object) looper);
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
            if (i3 == 1) {
                TcpConnection tcpConnection = TcpConnection.this;
                tcpConnection.openConn(tcpConnection.mEp);
            } else if (i3 == 2) {
                TcpConnection.this.doSendData();
            } else if (i3 == 3) {
                TcpConnection.this.mConnThread.quit();
                TcpConnection.this.mConnThread = null;
                TcpConnection.this.mConnHandler = null;
            }
        }

        public void notifyToQuit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (TcpConnection.this.mConnHandler != null) {
                TcpConnection.this.mConnHandler.sendEmptyMessage(3);
            }
        }

        public void wakeupToWrite() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                ConnWorker connWorker = TcpConnection.this.mConnHandler;
                if (connWorker != null) {
                    connWorker.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class ReadThread extends BaseThread {
        static IPatchRedirector $redirector_;

        ReadThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TcpConnection.this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            MsfSocketInputBuffer msfSocketInputBuffer;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            while (TcpConnection.this.isRunning.get()) {
                try {
                    msfSocketInputBuffer = TcpConnection.this.mInputBuffer;
                    if (msfSocketInputBuffer == null) {
                        return;
                    }
                    while (!msfSocketInputBuffer.isDataAvailable(30000)) {
                        if (!TcpConnection.this.isRunning.get()) {
                            return;
                        }
                    }
                } catch (Exception e16) {
                    BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "ReadThread Error.", e16);
                    synchronized (TcpConnection.this.closeDebug) {
                        TcpConnection.this.closeDebug.append("By ReadThread : " + e16.getMessage() + ";");
                        TcpConnection.this.closeConn(1);
                    }
                }
                if (!TcpConnection.this.isRunning.get()) {
                    return;
                }
                int bufferlen = msfSocketInputBuffer.getBufferlen();
                long j3 = bufferlen;
                TcpConnection.this.connInfo.receiveDataLen += j3;
                TcpConnection.this.connManager.increaseDataFlowDw(j3);
                TcpConnection.access$412(TcpConnection.this, bufferlen);
                TcpConnection.this.dataCodec.onRecvData(msfSocketInputBuffer);
                msfSocketInputBuffer.reset();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10166);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            IsRunTimeShutDown = false;
            initRuntimShutDownHook();
        }
    }

    public TcpConnection(ConnManager connManager, int i3, EndPoint endPoint, int i16, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, connManager, Integer.valueOf(i3), endPoint, Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
            return;
        }
        this.lock = new ReentrantLock();
        this.isConn = new AtomicBoolean(false);
        this.shouldCloseConn = new AtomicBoolean(false);
        this.serverAddress = null;
        this.mInputBuffer = null;
        this.mConnTimeOut = 0;
        this.isWritting = new AtomicBoolean(false);
        this.isRunning = new AtomicBoolean(false);
        this.closeDebug = new StringBuilder("ConnTag:");
        this.isUrgent = false;
        this.continueHeartBreak = 0;
        this.lastHeartBreakTime = 0L;
        this.mServletHandler = null;
        this.mNetFlowUp = 0;
        this.mNetFlowDw = 0;
        this.mLastDataTransTime = 0L;
        this.mLastDataSegSize = 0;
        this.mRtt = 0L;
        this.connInfo = new ConnReportInfo();
        if (endPoint.protoType == 2) {
            this.dataCodec = new HttpProtocolDataCodec();
        } else {
            this.dataCodec = new TcpProtocolDataCodec();
        }
        this.connManager = connManager;
        this.mReadBufferSize = 32768;
        this.mReadTimeout = i17;
        this.connId = i3;
        this.mEp = endPoint;
        this.mConnTimeOut = i16;
        this.mConnThread = new BaseHandlerThread("Highway-BDH-CONN" + i3);
        this.dataCodec.setProtocolCodecListener(this);
        this.mServletHandler = new Handler(Looper.getMainLooper());
        this.isIpv6 = z16;
    }

    static /* synthetic */ int access$412(TcpConnection tcpConnection, int i3) {
        int i16 = tcpConnection.mNetFlowDw + i3;
        tcpConnection.mNetFlowDw = i16;
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void closeConn(int i3) {
        IConnectionListener iConnectionListener;
        InputStream inputStream;
        boolean z16 = true;
        QLog.d(BdhLogUtil.Tag, 1, "CCloseConn at : ConnId:" + this.connId + " Src:" + i3);
        this.isRunning.set(false);
        try {
        } catch (InterruptedException e16) {
            e = e16;
            z16 = false;
        } catch (Exception e17) {
            e = e17;
            z16 = false;
        }
        if (this.mSocket != null && this.isConn.get()) {
            if (this.lock.tryLock(30000L, TimeUnit.MILLISECONDS)) {
                MsfSocketInputBuffer msfSocketInputBuffer = this.mInputBuffer;
                if (msfSocketInputBuffer != null && (inputStream = msfSocketInputBuffer.instream) != null) {
                    setExclusiveStream(false, inputStream.toString());
                }
                OutputStream outputStream = this.mOutputStream;
                if (outputStream != null) {
                    setExclusiveStream(false, outputStream.toString());
                }
                try {
                    try {
                        ConnWorker connWorker = this.mConnHandler;
                        if (connWorker != null) {
                            connWorker.notifyToQuit();
                        }
                        this.mInputBuffer = null;
                        this.mOutputStream = null;
                        try {
                            Socket socket = this.mSocket;
                            if (socket != null) {
                                socket.close();
                            }
                        } catch (Exception unused) {
                        }
                        this.isConn.set(false);
                        this.mSocket = null;
                        this.mReadThread = null;
                    } catch (InterruptedException e18) {
                        e = e18;
                        BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "CloseConn Error.", e);
                        iConnectionListener = this.connListener;
                        if (iConnectionListener != null) {
                        }
                        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "CloseConn End. connId:" + this.connId + " isCloseSuccess:" + z16);
                    } catch (Exception e19) {
                        e = e19;
                        BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "CloseConn Error.", e);
                        iConnectionListener = this.connListener;
                        if (iConnectionListener != null) {
                        }
                        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "CloseConn End. connId:" + this.connId + " isCloseSuccess:" + z16);
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    ConnReportInfo connReportInfo = this.connInfo;
                    connReportInfo.finished = true;
                    connReportInfo.connLifeLong = SystemClock.uptimeMillis() - this.connInfo.connStartTime;
                    int i16 = this.mNetFlowUp;
                    int i17 = this.mNetFlowDw;
                    this.mNetFlowUp = 0;
                    this.mNetFlowDw = 0;
                    if (!IsRunTimeShutDown) {
                        new BaseThread(new Runnable(i16, i17) { // from class: com.tencent.mobileqq.highway.conn.TcpConnection.2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ int val$dataDwLen;
                            final /* synthetic */ int val$dataUpLen;

                            {
                                this.val$dataUpLen = i16;
                                this.val$dataDwLen = i17;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, this, TcpConnection.this, Integer.valueOf(i16), Integer.valueOf(i17));
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                IInject iInject = TcpConnection.this.connManager.engine.injectHelper;
                                if (iInject != null && iInject.getRuntime() != null) {
                                    HwServlet.reportTraffic4PicUp(iInject.getRuntime(), TcpConnection.this.connInfo.serverIp, TcpConnection.this.connInfo.port, true, this.val$dataUpLen);
                                    HwServlet.reportTraffic4PicUp(iInject.getRuntime(), TcpConnection.this.connInfo.serverIp, TcpConnection.this.connInfo.port, false, this.val$dataDwLen);
                                }
                            }
                        }, "Highway-BDH-reportTraffic").start();
                    }
                    this.lock.unlock();
                } catch (Throwable th6) {
                    th = th6;
                    this.lock.unlock();
                    throw th;
                }
            } else {
                this.shouldCloseConn.set(true);
                z16 = false;
            }
            iConnectionListener = this.connListener;
            if (iConnectionListener != null) {
                iConnectionListener.onDisConnect(this.connId, this);
            }
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "CloseConn End. connId:" + this.connId + " isCloseSuccess:" + z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendData() {
        HwRequest pullNextRequest;
        boolean z16;
        while (this.isRunning.get() && !this.isWritting.get()) {
            try {
                pullNextRequest = this.connManager.pullNextRequest(this, this.isUrgent, this.mLastDataTransTime, this.mRtt, this.mLastDataSegSize);
                z16 = true;
            } catch (Exception e16) {
                BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "SendThread Error.", e16);
                synchronized (this.closeDebug) {
                    this.closeDebug.append("By SendWorker :" + e16.getMessage() + ";");
                    closeConn(2);
                }
            }
            if (pullNextRequest == null) {
                this.isWritting.set(false);
                if (SystemClock.uptimeMillis() - this.lastHeartBreakTime > 60000) {
                    this.lastHeartBreakTime = SystemClock.uptimeMillis();
                    ConnManager connManager = this.connManager;
                    int i3 = this.connId;
                    if (this.continueHeartBreak != 0) {
                        z16 = false;
                    }
                    connManager.onConnectionIdle(i3, z16);
                    return;
                }
                return;
            }
            this.isWritting.set(true);
            pullNextRequest.endpoint = this.mEp;
            if (pullNextRequest instanceof RequestHeartBreak) {
                int i16 = this.continueHeartBreak;
                if (i16 > 2) {
                    this.connInfo.killSelf = true;
                    closeConn(4);
                    return;
                }
                this.continueHeartBreak = i16 + 1;
            } else {
                this.continueHeartBreak = 0;
                this.lastHeartBreakTime = 0L;
            }
            try {
                byte[] requestBody = pullNextRequest.getRequestBody();
                if (requestBody == null && pullNextRequest.hasRequestBody()) {
                    pullNextRequest.reqListener.handleError(-1004, "NullBody", this);
                    this.isWritting.set(false);
                } else {
                    byte[] encodeC2SData = this.dataCodec.encodeC2SData(this.mEp, pullNextRequest, requestBody);
                    if (encodeC2SData == null) {
                        this.isWritting.set(false);
                    } else {
                        if (pullNextRequest.retryCount == 0) {
                            this.connInfo.sentRequestCount++;
                        } else {
                            this.connInfo.sentRetryCount++;
                        }
                        this.connInfo.sentDataLen += encodeC2SData.length;
                        pullNextRequest.sendTime = SystemClock.uptimeMillis();
                        long uptimeMillis = SystemClock.uptimeMillis();
                        OutputStream outputStream = this.mOutputStream;
                        if (outputStream != null) {
                            outputStream.write(encodeC2SData);
                            outputStream.flush();
                        }
                        int length = encodeC2SData.length;
                        this.connManager.increaseDataFlowUp(length);
                        long uptimeMillis2 = SystemClock.uptimeMillis();
                        this.mNetFlowUp += length;
                        pullNextRequest.reqListener.handleSendEnd(this.connId, getProtoType());
                        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "SendRequest End. CostTrace  reqId: " + pullNextRequest.getHwSeq() + " SendComsume:" + pullNextRequest.sendComsume + " WriteComsume:" + (uptimeMillis2 - uptimeMillis) + " ConnID:" + this.connId + " ReqInfo:" + pullNextRequest.dumpBaseInfo() + " ContinueHeartBreak:" + this.continueHeartBreak);
                        this.isWritting.set(false);
                    }
                }
            } catch (Exception unused) {
                this.isWritting.set(false);
            }
        }
    }

    private static void initRuntimShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new BaseThread() { // from class: com.tencent.mobileqq.highway.conn.TcpConnection.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    TcpConnection.IsRunTimeShutDown = true;
                    BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "TcpConnection,Runtime ShutDown");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f9 A[Catch: all -> 0x02ca, TryCatch #8 {all -> 0x02ca, blocks: (B:52:0x01ba, B:61:0x01f9, B:64:0x0206, B:67:0x0212, B:70:0x021c, B:73:0x0228, B:76:0x0234, B:79:0x0240, B:81:0x024a, B:84:0x0254, B:87:0x0260, B:90:0x026c, B:93:0x0278, B:96:0x0284, B:99:0x0290, B:102:0x029a), top: B:51:0x01ba }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int openConn(EndPoint endPoint) {
        int i3;
        int i16;
        int i17;
        long j3;
        int i18;
        boolean hasNet;
        int i19;
        SocketAddress remoteSocketAddress;
        QLog.d(BdhLogUtil.Tag, 1, "C. Try openConn : host:" + endPoint.host + " port:" + endPoint.port + " ConnId:" + this.connId + " protoType:" + endPoint.protoType + " connType:Long");
        boolean z16 = false;
        if ((this.shouldCloseConn.get() || this.isConn.get()) && this.shouldCloseConn.get()) {
            this.shouldCloseConn.set(false);
            closeConn(2);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            try {
                if (this.lock.tryLock(30000L, TimeUnit.MILLISECONDS)) {
                    try {
                        this.serverAddress = new InetSocketAddress(endPoint.host, endPoint.port);
                        this.isConn.set(false);
                        Socket socket = new Socket();
                        this.mSocket = socket;
                        socket.setKeepAlive(true);
                        this.mSocket.setTcpNoDelay(true);
                        this.mSocket.setSoTimeout(this.mReadTimeout);
                        this.mSocket.setSendBufferSize(524288);
                        j3 = SystemClock.uptimeMillis();
                    } catch (Throwable th5) {
                        th = th5;
                        j3 = -1;
                    }
                    try {
                        this.mSocket.connect(this.serverAddress, this.mConnTimeOut);
                        this.mRtt = SystemClock.uptimeMillis() - j3;
                        this.mOutputStream = this.mSocket.getOutputStream();
                        MsfSocketInputBuffer msfSocketInputBuffer = new MsfSocketInputBuffer(this.mSocket, this.mReadBufferSize, "US-ASCII", -1);
                        this.mInputBuffer = msfSocketInputBuffer;
                        setExclusiveStream(true, msfSocketInputBuffer.instream.toString());
                        setExclusiveStream(true, this.mOutputStream.toString());
                        ReadThread readThread = new ReadThread();
                        this.mReadThread = readThread;
                        readThread.setName("Highway-BDH-read");
                        this.isRunning.set(true);
                        this.mReadThread.start();
                        this.isConn.set(true);
                        try {
                            StringBuilder sb5 = new StringBuilder("HostInfo");
                            if (this.mEp.host.contains("htdata") && (remoteSocketAddress = this.mSocket.getRemoteSocketAddress()) != null && (remoteSocketAddress instanceof InetSocketAddress)) {
                                String hostAddress = ((InetSocketAddress) remoteSocketAddress).getAddress().getHostAddress();
                                sb5.append("HostAddr:");
                                sb5.append(hostAddress);
                                sb5.append("-");
                            }
                            try {
                                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "OpenConn Success at : host:" + endPoint.host + " port:" + endPoint.port + " ConnId:" + this.connId + " ConnectCost:" + j3 + " remoteHost:" + sb5.toString() + " LocalPort:" + this.mSocket.getLocalPort());
                                try {
                                    this.lock.unlock();
                                    z16 = true;
                                    i17 = 0;
                                } catch (InterruptedException e16) {
                                    e = e16;
                                    z16 = true;
                                    i3 = 0;
                                    BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "OpenConn Error Interrupted : host:" + endPoint.host + " port:" + endPoint.port, e);
                                    i16 = i3;
                                    ConnReportInfo connReportInfo = this.connInfo;
                                    connReportInfo.result = z16;
                                    connReportInfo.connElapseTime = SystemClock.uptimeMillis() - this.connInfo.connStartTime;
                                    long uptimeMillis2 = SystemClock.uptimeMillis();
                                    if (this.connListener != null) {
                                    }
                                    if (!z16) {
                                    }
                                    return i16;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                i18 = 0;
                                z16 = true;
                                try {
                                    hasNet = this.connManager.hasNet();
                                    StringBuilder sb6 = new StringBuilder();
                                    i3 = i18;
                                    try {
                                        sb6.append("OpenConn Error : host:");
                                        sb6.append(endPoint.host);
                                        sb6.append(" port:");
                                        sb6.append(endPoint.port);
                                        sb6.append(" ConnId:");
                                        sb6.append(this.connId);
                                        sb6.append(" ConnectCost:");
                                        sb6.append(j3);
                                        sb6.append(" hasNet:");
                                        sb6.append(hasNet);
                                        BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, sb6.toString(), th);
                                        String lowerCase = th.toString().toLowerCase();
                                        if (hasNet) {
                                        }
                                        i19 = 3;
                                        try {
                                            this.lock.unlock();
                                            i17 = i19;
                                            i16 = i17;
                                        } catch (InterruptedException e17) {
                                            e = e17;
                                            i3 = i19;
                                            BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "OpenConn Error Interrupted : host:" + endPoint.host + " port:" + endPoint.port, e);
                                            i16 = i3;
                                            ConnReportInfo connReportInfo2 = this.connInfo;
                                            connReportInfo2.result = z16;
                                            connReportInfo2.connElapseTime = SystemClock.uptimeMillis() - this.connInfo.connStartTime;
                                            long uptimeMillis22 = SystemClock.uptimeMillis();
                                            if (this.connListener != null) {
                                            }
                                            if (!z16) {
                                            }
                                            return i16;
                                        }
                                        ConnReportInfo connReportInfo22 = this.connInfo;
                                        connReportInfo22.result = z16;
                                        connReportInfo22.connElapseTime = SystemClock.uptimeMillis() - this.connInfo.connStartTime;
                                        long uptimeMillis222 = SystemClock.uptimeMillis();
                                        if (this.connListener != null) {
                                        }
                                        if (!z16) {
                                        }
                                        return i16;
                                    } catch (Throwable th7) {
                                        th = th7;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    i3 = i18;
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            i18 = 14;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        i18 = 14;
                        z16 = false;
                        hasNet = this.connManager.hasNet();
                        StringBuilder sb62 = new StringBuilder();
                        i3 = i18;
                        sb62.append("OpenConn Error : host:");
                        sb62.append(endPoint.host);
                        sb62.append(" port:");
                        sb62.append(endPoint.port);
                        sb62.append(" ConnId:");
                        sb62.append(this.connId);
                        sb62.append(" ConnectCost:");
                        sb62.append(j3);
                        sb62.append(" hasNet:");
                        sb62.append(hasNet);
                        BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, sb62.toString(), th);
                        String lowerCase2 = th.toString().toLowerCase();
                        if (hasNet) {
                            if (lowerCase2.indexOf("illegal") > -1) {
                                i19 = 1;
                            } else if (lowerCase2.indexOf("route to host") > -1) {
                                i19 = 2;
                            } else if (lowerCase2.indexOf("unreachable") <= -1) {
                                if (lowerCase2.indexOf(QCircleDaTongConstant.ElementParamValue.PERMISSION) > -1) {
                                    i19 = 4;
                                } else if (lowerCase2.indexOf("refused") > -1) {
                                    i19 = 5;
                                } else if (lowerCase2.indexOf("reset") > -1) {
                                    i19 = 6;
                                } else {
                                    if (lowerCase2.indexOf("timeoutexception") <= -1 && lowerCase2.indexOf(") after") <= -1) {
                                        if (lowerCase2.indexOf("unknownhost") > -1) {
                                            i19 = 8;
                                        } else if (lowerCase2.indexOf("unresolved") > -1) {
                                            i19 = 9;
                                        } else if (lowerCase2.indexOf("enotsock") > -1) {
                                            i19 = 10;
                                        } else if (lowerCase2.indexOf("enobufs") > -1) {
                                            i19 = 11;
                                        } else if (lowerCase2.indexOf("ebadf") > -1) {
                                            i19 = 12;
                                        } else if (lowerCase2.indexOf(QCircleDaTongConstant.ElementParamValue.OPERATION) <= -1) {
                                            if (lowerCase2.indexOf(HippyReporter.RemoveEngineReason.INVALID) > -1) {
                                                i19 = 13;
                                            } else {
                                                try {
                                                    String stackTraceString = Log.getStackTraceString(th);
                                                    if (stackTraceString.length() > 200) {
                                                        stackTraceString.substring(0, 200);
                                                    }
                                                    i19 = 14;
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                    i3 = 14;
                                                    try {
                                                        this.lock.unlock();
                                                        throw th;
                                                    } catch (InterruptedException e18) {
                                                        e = e18;
                                                        BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "OpenConn Error Interrupted : host:" + endPoint.host + " port:" + endPoint.port, e);
                                                        i16 = i3;
                                                        ConnReportInfo connReportInfo222 = this.connInfo;
                                                        connReportInfo222.result = z16;
                                                        connReportInfo222.connElapseTime = SystemClock.uptimeMillis() - this.connInfo.connStartTime;
                                                        long uptimeMillis2222 = SystemClock.uptimeMillis();
                                                        if (this.connListener != null) {
                                                        }
                                                        if (!z16) {
                                                        }
                                                        return i16;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i19 = 7;
                                }
                            }
                            this.lock.unlock();
                            i17 = i19;
                            i16 = i17;
                            ConnReportInfo connReportInfo2222 = this.connInfo;
                            connReportInfo2222.result = z16;
                            connReportInfo2222.connElapseTime = SystemClock.uptimeMillis() - this.connInfo.connStartTime;
                            long uptimeMillis22222 = SystemClock.uptimeMillis();
                            if (this.connListener != null) {
                            }
                            if (!z16) {
                            }
                            return i16;
                        }
                        i19 = 3;
                        this.lock.unlock();
                        i17 = i19;
                        i16 = i17;
                        ConnReportInfo connReportInfo22222 = this.connInfo;
                        connReportInfo22222.result = z16;
                        connReportInfo22222.connElapseTime = SystemClock.uptimeMillis() - this.connInfo.connStartTime;
                        long uptimeMillis222222 = SystemClock.uptimeMillis();
                        if (this.connListener != null) {
                        }
                        if (!z16) {
                        }
                        return i16;
                    }
                } else {
                    z16 = false;
                    i17 = 14;
                }
                i16 = i17;
            } catch (InterruptedException e19) {
                e = e19;
                z16 = false;
                i3 = 14;
                BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "OpenConn Error Interrupted : host:" + endPoint.host + " port:" + endPoint.port, e);
                i16 = i3;
                ConnReportInfo connReportInfo222222 = this.connInfo;
                connReportInfo222222.result = z16;
                connReportInfo222222.connElapseTime = SystemClock.uptimeMillis() - this.connInfo.connStartTime;
                long uptimeMillis2222222 = SystemClock.uptimeMillis();
                if (this.connListener != null) {
                }
                if (!z16) {
                }
                return i16;
            }
        } catch (InterruptedException e26) {
            e = e26;
        }
        ConnReportInfo connReportInfo2222222 = this.connInfo;
        connReportInfo2222222.result = z16;
        connReportInfo2222222.connElapseTime = SystemClock.uptimeMillis() - this.connInfo.connStartTime;
        long uptimeMillis22222222 = SystemClock.uptimeMillis();
        if (this.connListener != null) {
            QLog.d(BdhLogUtil.Tag, 1, "C. OnConnectionConnected : ID:" + this.connId + " IsSuccess:" + z16 + " SsoSocketConnStat:" + i16 + " Conncost:" + (uptimeMillis22222222 - uptimeMillis) + " ms");
            this.connListener.onConnect(z16, this.connId, this, this.mEp, i16, this.connInfo);
        }
        if (!z16) {
            this.connInfo.connLifeBegin = SystemClock.uptimeMillis();
            this.mConnHandler.wakeupToWrite();
        } else {
            this.mConnHandler.notifyToQuit();
        }
        return i16;
    }

    public static void setExclusiveStream(boolean z16, String str) {
        synchronized (BaseApplication.exclusiveStreamList) {
            ArrayList<String> arrayList = BaseApplication.exclusiveStreamList;
            if (z16) {
                arrayList.add(str);
            } else {
                arrayList.remove(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public boolean connect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "Connect : About to send conn request.");
        this.mConnThread.start();
        ConnWorker connWorker = new ConnWorker(this.mConnThread.getLooper());
        this.mConnHandler = connWorker;
        connWorker.sendEmptyMessage(1);
        this.connInfo.connStartTime = SystemClock.uptimeMillis();
        ConnReportInfo connReportInfo = this.connInfo;
        EndPoint endPoint = this.mEp;
        connReportInfo.serverIp = endPoint.host;
        connReportInfo.port = endPoint.port;
        return true;
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public void disConnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.closeDebug) {
            this.closeDebug.append("By : disConnect;");
        }
        closeConn(3);
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public int getConnId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.connId;
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public EndPoint getEndPoint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (EndPoint) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mEp;
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public int getProtoType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public boolean isIpv6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.isIpv6;
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public boolean isWritable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.isRunning.get() && !this.isWritting.get()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.highway.codec.IProtocolCodecListener
    public void onDecodeInvalidData(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        QLog.d(BdhLogUtil.Tag, 1, "C.  ConnId:" + this.connId + " Host:" + this.mEp.host + " Port:" + this.mEp.port + " OnDecodeInvalidData : code : " + i3);
        IConnectionListener iConnectionListener = this.connListener;
        if (iConnectionListener != null) {
            iConnectionListener.onRecvInvalidData(this.mEp, this);
        }
        disConnect();
    }

    @Override // com.tencent.mobileqq.highway.codec.IProtocolCodecListener
    public void onDecodeSucessfully(List<HwResponse> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
            return;
        }
        this.connInfo.recvRespCount = list.size();
        this.connManager.onDecodeSucessfully(list);
    }

    @Override // com.tencent.mobileqq.highway.codec.IProtocolCodecListener
    public void onEncodePkgError(HwRequest hwRequest, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) hwRequest, i3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        HwResponse hwResponse = new HwResponse();
        hwResponse.hwSeq = hwRequest.getHwSeq();
        hwResponse.cmd = hwRequest.hwCmd;
        hwResponse.errCode = i3;
        hwResponse.recvTime = SystemClock.uptimeMillis();
        hwResponse.shouldRetry = false;
        this.connManager.onDecodeSucessfully(arrayList);
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public void setConnectListener(IConnectionListener iConnectionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iConnectionListener);
        } else {
            this.connListener = iConnectionListener;
        }
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public void setUrgentFlag(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.isUrgent = z16;
            wakeupChannel();
        }
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnection
    public void wakeupChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ConnWorker connWorker = this.mConnHandler;
        if (this.isRunning.get() && connWorker != null) {
            connWorker.wakeupToWrite();
        }
    }
}
