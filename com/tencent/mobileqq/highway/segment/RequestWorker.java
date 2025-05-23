package com.tencent.mobileqq.highway.segment;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.conn.IConnection;
import com.tencent.mobileqq.highway.conn.TcpConnection;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.transaction.DataTransInfo;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.BaseConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RequestWorker implements IHwManager {
    static IPatchRedirector $redirector_ = null;
    public static final int PRIORITY_NUM = 3;
    public static final int REQ_PRIORITY_DATA = 2;
    public static final int REQ_PRIORITY_HEART = 0;
    public static final int REQ_PRIORITY_QUERY = 1;
    private static final AtomicInteger seqFactory;
    HwEngine engine;
    public volatile int mCurrentRequests;
    private HandlerThread mHandlerThread;
    public RequestHandler mRequestHandler;
    private AtomicBoolean mWorking;
    private SparseArray<List<HwRequest>> priorityList;
    private ConcurrentHashMap<Integer, HwRequest> sendUrgentHB;
    private ConcurrentHashMap<Integer, HwRequest> sentRequests;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class RequestHandler extends Handler {
        static IPatchRedirector $redirector_ = null;
        public static final int CANCEL = 3;
        public static final int CONN = 4;
        public static final int PRECONN = 5;
        public static final int QUIT = 2;
        public static final int SEND = 1;

        public RequestHandler(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RequestWorker.this, (Object) looper);
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
                RequestWorker.this.prepareRequests();
                return;
            }
            if (i3 == 3) {
                RequestWorker.this.cancelRequestByTrans((Transaction) message.obj);
                return;
            }
            if (i3 == 2) {
                RequestWorker.this.doQuit();
                return;
            }
            if (i3 == 4) {
                RequestWorker requestWorker = RequestWorker.this;
                requestWorker.engine.mConnManager.wakeupConnectionToWrite(requestWorker.mCurrentRequests, false);
            } else if (i3 == 5) {
                RequestWorker requestWorker2 = RequestWorker.this;
                requestWorker2.engine.mConnManager.wakeupConnectionToWrite(requestWorker2.mCurrentRequests, true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class RequestListener implements IRequestListener {
        static IPatchRedirector $redirector_;
        private Runnable netDetectTimer;
        private final HwRequest req;
        private Runnable reqTimeoutTimer;
        private Runnable writeTimeoutTimer;

        public RequestListener(HwRequest hwRequest) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RequestWorker.this, (Object) hwRequest);
                return;
            }
            this.req = hwRequest;
            this.netDetectTimer = new Runnable(RequestWorker.this, hwRequest) { // from class: com.tencent.mobileqq.highway.segment.RequestWorker.RequestListener.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ HwRequest val$req;
                final /* synthetic */ RequestWorker val$this$0;

                {
                    this.val$this$0 = r8;
                    this.val$req = hwRequest;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RequestListener.this, r8, hwRequest);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (RequestListener.this.req.isCancel.get()) {
                        RequestWorker.this.sentRequests.remove(Integer.valueOf(RequestListener.this.req.getHwSeq()));
                    } else {
                        RequestListener.this.handleError(-1000, "NoNetWork", RequestWorker.this.engine.mConnManager.connections.get(Integer.valueOf(this.val$req.sendConnId)));
                    }
                }
            };
            this.reqTimeoutTimer = new Runnable(RequestWorker.this) { // from class: com.tencent.mobileqq.highway.segment.RequestWorker.RequestListener.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ RequestWorker val$this$0;

                {
                    this.val$this$0 = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RequestListener.this, (Object) r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        RequestListener.this.handleSendTimeOut();
                    }
                }
            };
            this.writeTimeoutTimer = new Runnable(RequestWorker.this) { // from class: com.tencent.mobileqq.highway.segment.RequestWorker.RequestListener.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ RequestWorker val$this$0;

                {
                    this.val$this$0 = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RequestListener.this, (Object) r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        RequestListener.this.handleWriteTimeout();
                    }
                }
            };
        }

        private void recordConnInfo(HwRequest hwRequest, long j3) {
            int i3;
            ConnManager connManager;
            IConnection iConnection;
            DataTransInfo dataTransInfo = ((RequestDataTrans) hwRequest).mInfo;
            if (dataTransInfo != null) {
                i3 = dataTransInfo.length;
            } else {
                i3 = 0;
            }
            HwEngine hwEngine = RequestWorker.this.engine;
            if (hwEngine != null && (connManager = hwEngine.mConnManager) != null && (iConnection = connManager.connections.get(Integer.valueOf(hwRequest.sendConnId))) != null && iConnection.getProtoType() == 1) {
                TcpConnection tcpConnection = (TcpConnection) iConnection;
                tcpConnection.mLastDataSegSize = i3;
                tcpConnection.mLastDataTransTime = j3;
                if (QLog.isDevelopLevel()) {
                    BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "recordConnInfo: conId = " + hwRequest.sendConnId + " record con.mLastDataTransTime = " + j3 + " con.mLastDataSegSize = " + i3);
                }
            }
        }

        private void scheduleRetry(int i3, long j3) {
            boolean z16;
            Transaction transactionById;
            if (RequestWorker.this.mWorking.get() && !this.req.isCancel.get() && RequestWorker.this.mRequestHandler != null) {
                this.req.lastSendStartTime = SystemClock.uptimeMillis();
                if (HwNetworkCenter.getInstance(RequestWorker.this.engine.getAppContext()).getNetType() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                HwRequest hwRequest = this.req;
                if ((hwRequest instanceof RequestDataTrans) && (transactionById = RequestWorker.this.engine.mTransWorker.getTransactionById(hwRequest.transId)) != null) {
                    transactionById.getRetryRequests().put(Integer.valueOf(this.req.getHwSeq()), this.req);
                }
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "conId:" + this.req.sendConnId + " ScheduleRetry : " + this.req.getHwSeq() + " retry:" + this.req.retryCount + " delay:" + j3 + " hasNet:" + z16 + " sentRequestsRetry.size()");
                if (z16) {
                    HwRequest hwRequest2 = this.req;
                    hwRequest2.retryCount++;
                    hwRequest2.onRetry(i3);
                    if (j3 != 0) {
                        RequestWorker.this.mRequestHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.highway.segment.RequestWorker.RequestListener.4
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RequestListener.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                } else {
                                    if (RequestListener.this.req.isCancel.get()) {
                                        return;
                                    }
                                    RequestWorker requestWorker = RequestWorker.this;
                                    requestWorker.engine.mConnManager.wakeupConnectionToWrite(requestWorker.mCurrentRequests, false);
                                }
                            }
                        }, j3);
                        return;
                    } else {
                        RequestWorker requestWorker = RequestWorker.this;
                        requestWorker.engine.mConnManager.wakeupConnectionToWrite(requestWorker.mCurrentRequests, false);
                        return;
                    }
                }
                RequestWorker.this.mRequestHandler.postDelayed(this.netDetectTimer, j3);
            }
        }

        @Override // com.tencent.mobileqq.highway.segment.IRequestListener
        public void handleConnClosed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.highway.segment.IRequestListener
        public void handleError(int i3, String str, IConnection iConnection) {
            boolean z16;
            boolean z17;
            boolean z18;
            Transaction transaction;
            String str2;
            String str3;
            boolean isIpv6;
            int i16 = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z19 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, iConnection);
                return;
            }
            HwRequest hwRequest = this.req;
            if (!(hwRequest instanceof RequestAck)) {
                hwRequest.onError(i16);
            }
            long j3 = 0;
            if (HwNetworkCenter.getInstance(RequestWorker.this.engine.getAppContext()).getNetType() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            RequestWorker.this.mRequestHandler.removeCallbacks(this.reqTimeoutTimer);
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "conId:" + this.req.sendConnId + " HandleError : Seq:" + this.req.getHwSeq() + " ErrCode:" + i16 + " HasNet:" + z16);
            if (this.req.isCancel.get()) {
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            HwRequest hwRequest2 = this.req;
            hwRequest2.timeComsume += uptimeMillis - hwRequest2.lastSendStartTime;
            if (i16 == -1004) {
                if (hwRequest2.hwCmd.equalsIgnoreCase("PicUp.DataUp")) {
                    i16 = ((RequestDataTrans) this.req).mInfo.errno;
                }
                z17 = false;
            } else {
                z17 = true;
            }
            if (z16 && i16 != -1000) {
                HwRequest hwRequest3 = this.req;
                hwRequest3.continueErrCount++;
                if (i16 == -1003) {
                    EndPoint endPoint = hwRequest3.endpoint;
                    if (endPoint != null) {
                        str3 = endPoint.host;
                    } else {
                        str3 = null;
                    }
                    String str4 = hwRequest3.lastUseAddress;
                    if (str4 != null && str4.equalsIgnoreCase(str3)) {
                        this.req.continueConnClose++;
                    } else {
                        this.req.continueConnClose = 1;
                    }
                    HwRequest hwRequest4 = this.req;
                    hwRequest4.lastUseAddress = str3;
                    if (hwRequest4.continueConnClose >= 3) {
                        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "ContinueConnClose exceed the ContinueConnClosedLimitation. Host : " + str3 + " retryCount:" + this.req.retryCount);
                        ConfigManager configManager = ConfigManager.getInstance(RequestWorker.this.engine.getAppContext(), RequestWorker.this.engine);
                        if (configManager != null) {
                            Context appContext = RequestWorker.this.engine.getAppContext();
                            String str5 = RequestWorker.this.engine.currentUin;
                            if (iConnection == null) {
                                isIpv6 = false;
                            } else {
                                isIpv6 = iConnection.isIpv6();
                            }
                            configManager.onSrvAddrUnavailable(appContext, str5, str3, 9, isIpv6);
                        }
                        Transaction transactionById = RequestWorker.this.engine.mTransWorker.getTransactionById(this.req.transId);
                        if (transactionById != null) {
                            transactionById.onRequestFailed(i16);
                        }
                    }
                } else if (i16 == -1014) {
                    z17 = false;
                }
            } else {
                this.req.continueConnClose = 0;
            }
            HwRequest hwRequest5 = this.req;
            if (hwRequest5.timeComsume >= 600000) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (hwRequest5.continueErrCount >= 10) {
                z19 = true;
            }
            if (!(hwRequest5 instanceof RequestAck)) {
                transaction = RequestWorker.this.engine.mTransWorker.getTransactionById(hwRequest5.transId);
                if (transaction != null) {
                    TransReport transReport = transaction.mTransReport;
                    HwRequest hwRequest6 = this.req;
                    if (hwRequest6.protoType == 1) {
                        str2 = "TCP";
                    } else {
                        str2 = "HTTP";
                    }
                    transReport.protoType = str2;
                    EndPoint endPoint2 = hwRequest6.endpoint;
                    if (endPoint2 != null) {
                        transReport.ipIndex = endPoint2.ipIndex;
                        if (iConnection != null) {
                            transReport.isIpv6 = iConnection.isIpv6();
                        }
                        TransReport transReport2 = transaction.mTransReport;
                        ConnManager connManager = RequestWorker.this.engine.mConnManager;
                        transReport2.mHasIpv6List = connManager.mHasIpv6List;
                        transReport2.mIPv6Fast = connManager.isIpv6Fast();
                    }
                }
            } else {
                transaction = null;
            }
            if (z17 && !z18 && !z19) {
                if (!z16) {
                    j3 = 6000;
                }
                HwRequest hwRequest7 = this.req;
                if (!(hwRequest7 instanceof RequestHeartBreak)) {
                    RequestWorker.this.addHwRequest(hwRequest7);
                    scheduleRetry(i16, j3);
                    return;
                }
                return;
            }
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "HandleError : Seq:" + this.req.getHwSeq() + " NotifyError :" + i16 + "req.timeComsume:" + this.req.timeComsume + " allowRetry:" + z17 + " req.continueErrCount:" + this.req.continueErrCount);
            this.req.onError(i16);
            if (transaction != null) {
                HwResponse hwResponse = new HwResponse();
                hwResponse.hwSeq = this.req.getHwSeq();
                hwResponse.errCode = i16;
                if (z18) {
                    hwResponse.errCode = -1005;
                }
                transaction.onTransFailed(hwResponse.errCode, str, 0, 0, this.req.retryCount, null);
            }
            RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
        }

        @Override // com.tencent.mobileqq.highway.segment.IRequestListener
        public void handleResponse(HwResponse hwResponse) {
            HwRequest hwRequest;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) hwResponse);
                return;
            }
            RequestHandler requestHandler = RequestWorker.this.mRequestHandler;
            long j3 = hwResponse.recvTime - this.req.sendTime;
            long uptimeMillis = SystemClock.uptimeMillis() - hwResponse.recvTime;
            HwRequest hwRequest2 = this.req;
            if (hwRequest2 instanceof RequestDataTrans) {
                recordConnInfo(hwRequest2, j3);
            }
            hwResponse.reqCost = j3;
            hwResponse.switchCost = uptimeMillis;
            HwRequest hwRequest3 = this.req;
            hwResponse.mBuCmdId = hwRequest3.mBuCmdId;
            hwResponse.mTransId = hwRequest3.transId;
            if (requestHandler != null) {
                requestHandler.removeCallbacks(this.reqTimeoutTimer);
            }
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "HandleResp :" + hwResponse.dumpRespInfo() + " ,isCancle:" + this.req.isCancel);
            if (this.req.isCancel.get() && BaseConstants.REQ_HW_CMD.REQ_CMD_HEART_BREAK.equalsIgnoreCase(this.req.hwCmd)) {
                RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
                return;
            }
            if (hwResponse.isIpv6 && hwResponse.retCode == 97) {
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "handleResponse , ipv6 illegal user");
                RequestWorker.this.engine.mConnManager.onIPV6IllegalUserErr(this.req.sendConnId);
                RequestWorker.this.addHwRequest(this.req);
                scheduleRetry(hwResponse.buzRetCode, 0L);
                return;
            }
            if (hwResponse.shouldRetry && (i3 = (hwRequest = this.req).buzRetryCount) < 3) {
                hwRequest.buzRetryCount = i3 + 1;
                RequestWorker.this.addHwRequest(hwRequest);
                scheduleRetry(hwResponse.buzRetCode, 0L);
            } else {
                RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
                this.req.updateStaus(4);
                IConnection iConnection = RequestWorker.this.engine.mConnManager.connections.get(Integer.valueOf(this.req.sendConnId));
                if (iConnection != null) {
                    hwResponse.isIpv6 = iConnection.isIpv6();
                }
                this.req.onResponse(RequestWorker.this, hwResponse);
            }
        }

        @Override // com.tencent.mobileqq.highway.segment.IRequestListener
        public void handleSendBegin(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            RequestWorker requestWorker = RequestWorker.this;
            RequestHandler requestHandler = requestWorker.mRequestHandler;
            if (requestWorker.mWorking.get() && requestHandler != null) {
                requestHandler.removeCallbacks(this.reqTimeoutTimer);
                requestHandler.removeCallbacks(this.netDetectTimer);
                HwRequest hwRequest = this.req;
                hwRequest.sendConnId = i3;
                hwRequest.lastSendStartTime = SystemClock.uptimeMillis();
                requestHandler.postDelayed(this.reqTimeoutTimer, this.req.timeOut);
                requestHandler.postDelayed(this.writeTimeoutTimer, this.req.timeOut);
                this.req.onSendBegin();
            }
        }

        @Override // com.tencent.mobileqq.highway.segment.IRequestListener
        public void handleSendEnd(int i3, int i16) {
            Transaction transaction;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            HwRequest hwRequest = this.req;
            long uptimeMillis = SystemClock.uptimeMillis();
            HwRequest hwRequest2 = this.req;
            hwRequest.sendComsume = uptimeMillis - hwRequest2.lastSendStartTime;
            hwRequest2.protoType = i16;
            RequestHandler requestHandler = RequestWorker.this.mRequestHandler;
            if (requestHandler != null) {
                requestHandler.removeCallbacks(this.writeTimeoutTimer);
            }
            this.req.onSendEnd();
            HwRequest hwRequest3 = this.req;
            if ((hwRequest3 instanceof RequestDataTrans) && (transaction = ((RequestDataTrans) hwRequest3).mInfo.parent) != null) {
                AtomicInteger atomicInteger = transaction.mTransReport.mDataFlowOfChannel.get(Integer.valueOf(i3));
                if (atomicInteger != null) {
                    atomicInteger.incrementAndGet();
                } else {
                    transaction.mTransReport.mDataFlowOfChannel.put(Integer.valueOf(i3), new AtomicInteger(1));
                }
            }
        }

        @Override // com.tencent.mobileqq.highway.segment.IRequestListener
        public void handleSendTimeOut() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (this.req.isCancel.get()) {
                RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
                return;
            }
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "conId:" + this.req.sendConnId + " handleSendTimeOut->req.hwSeq:" + this.req.getHwSeq());
            this.req.onError(-1005);
            HwRequest hwRequest = this.req;
            int i3 = hwRequest.sendConnId;
            if (hwRequest instanceof RequestHeartBreak) {
                RequestHeartBreak requestHeartBreak = (RequestHeartBreak) hwRequest;
                if (requestHeartBreak.isUrgent) {
                    synchronized (requestHeartBreak) {
                        this.req.isCancel.set(true);
                        RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
                    }
                    RequestWorker.this.engine.mConnManager.onUrgentHeartBreakTimeout(this.req.sendConnId);
                    return;
                }
            }
            RequestWorker.this.engine.mConnManager.onRequestTimeOut(i3);
            if (RequestWorker.this.sendUrgentHB.get(Integer.valueOf(i3)) != null && !((HwRequest) RequestWorker.this.sendUrgentHB.get(Integer.valueOf(i3))).isCancel.get() && ((HwRequest) RequestWorker.this.sendUrgentHB.get(Integer.valueOf(i3))).status.get() != 4) {
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "conId:" + i3 + " handleSendTimeOut->there has been a HB sending !");
            } else {
                RequestWorker.this.sendHeartBreak(i3, true, true, 0);
            }
            HwRequest hwRequest2 = this.req;
            hwRequest2.timeOut += 15000;
            hwRequest2.timeOutCount++;
            handleError(-1005, "ReqTimeOut", RequestWorker.this.engine.mConnManager.connections.get(Integer.valueOf(i3)));
        }

        @Override // com.tencent.mobileqq.highway.segment.IRequestListener
        public void handleWriteTimeout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (this.req.isCancel.get()) {
                RequestWorker.this.sentRequests.remove(Integer.valueOf(this.req.getHwSeq()));
                return;
            }
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "conId:" + this.req.sendConnId + " handleWriteTimeout->req.hwSeq:" + this.req.getHwSeq());
            this.req.onError(-1006);
            RequestWorker.this.engine.mConnManager.onRequestWriteTimeout(this.req.sendConnId);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16265);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            seqFactory = new AtomicInteger(new Random().nextInt(100000));
        }
    }

    public RequestWorker(HwEngine hwEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hwEngine);
            return;
        }
        this.priorityList = new SparseArray<>();
        this.mCurrentRequests = 0;
        this.sentRequests = new ConcurrentHashMap<>();
        this.sendUrgentHB = new ConcurrentHashMap<>();
        this.mWorking = new AtomicBoolean(false);
        this.engine = hwEngine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHwRequest(HwRequest hwRequest) {
        int priority = hwRequest.getPriority();
        if (priority + 0 > 3) {
            priority = 2;
        }
        synchronized (this.priorityList) {
            hwRequest.status.set(2);
            this.priorityList.get(priority).add(hwRequest);
            if (hwRequest.getPriority() > 0) {
                this.mCurrentRequests++;
            }
        }
    }

    private void cancelAllRequest() {
        synchronized (this.priorityList) {
            for (int i3 = 0; i3 < 3; i3++) {
                this.priorityList.get(i3).clear();
            }
        }
        synchronized (this.sentRequests) {
            Iterator<HwRequest> it = this.sentRequests.values().iterator();
            while (it.hasNext()) {
                it.next().isCancel.set(true);
            }
            this.sentRequests.clear();
        }
        this.sendUrgentHB.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelRequestByTrans(Transaction transaction) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.priorityList) {
            List<HwRequest> list = this.priorityList.get(2);
            for (HwRequest hwRequest : list) {
                if (hwRequest.transId == transaction.getTransationId()) {
                    hwRequest.isCancel.set(true);
                    hwRequest.onCancle();
                    arrayList.add(hwRequest);
                }
            }
            list.removeAll(arrayList);
            arrayList.clear();
        }
        synchronized (this.sentRequests) {
            for (HwRequest hwRequest2 : this.sentRequests.values()) {
                if (hwRequest2.transId == transaction.getTransationId() && hwRequest2.getPriority() == 2) {
                    hwRequest2.isCancel.set(true);
                    hwRequest2.onCancle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doQuit() {
        cancelAllRequest();
        this.mRequestHandler = null;
        this.mHandlerThread.quit();
    }

    public static synchronized int getNextSeq() {
        int incrementAndGet;
        synchronized (RequestWorker.class) {
            AtomicInteger atomicInteger = seqFactory;
            incrementAndGet = atomicInteger.incrementAndGet();
            if (incrementAndGet > 1000000) {
                atomicInteger.set(new Random().nextInt(1060000));
            }
        }
        return incrementAndGet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnClosed(int i3) {
        synchronized (this.sentRequests) {
            SparseArray sparseArray = new SparseArray();
            ArrayList arrayList = new ArrayList();
            for (HwRequest hwRequest : this.sentRequests.values()) {
                if (!hwRequest.isCancel.get() && hwRequest.sendConnId == i3) {
                    IConnection iConnection = this.engine.mConnManager.connections.get(Integer.valueOf(i3));
                    if (hwRequest.hwCmd.equalsIgnoreCase(BaseConstants.REQ_HW_CMD.REQ_CMD_HEART_BREAK)) {
                        hwRequest.isCancel.set(true);
                        hwRequest.reqListener.handleError(-1003, "ConnClose", iConnection);
                    } else if (hwRequest.hwCmd.equalsIgnoreCase(BaseConstants.REQ_HW_CMD.REQ_CMD_QUERY)) {
                        hwRequest.reqListener.handleError(-1003, "ConnClose", iConnection);
                    } else if (hwRequest instanceof RequestFilter) {
                        if (hwRequest.retryCount > 1) {
                            this.sentRequests.remove(Integer.valueOf(hwRequest.getHwSeq()));
                            hwRequest.onError(-1003);
                            return;
                        }
                        hwRequest.reqListener.handleError(-1003, "ConnClose", iConnection);
                    } else if (hwRequest.hwCmd.equalsIgnoreCase("PicUp.DataUp") && !hwRequest.isCancel.get() && hwRequest.status.get() == 3) {
                        Transaction transactionById = this.engine.mTransWorker.getTransactionById(hwRequest.transId);
                        if (transactionById != null) {
                            sparseArray.put(transactionById.getTransationId(), transactionById);
                        }
                        arrayList.add(hwRequest);
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                HwRequest hwRequest2 = (HwRequest) it.next();
                hwRequest2.isCancel.set(true);
                this.sentRequests.remove(Integer.valueOf(hwRequest2.getHwSeq()));
            }
            int size = sparseArray.size();
            for (int i16 = 0; i16 < size; i16++) {
                Transaction transaction = (Transaction) sparseArray.valueAt(i16);
                byte[] bArr = new byte[transaction.bitmap.length];
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    HwRequest hwRequest3 = (HwRequest) it5.next();
                    if (hwRequest3.transId == transaction.getTransationId()) {
                        DataTransInfo dataTransInfo = ((RequestDataTrans) hwRequest3).mInfo;
                        int i17 = dataTransInfo.bitmapE;
                        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "QueryDebug Waiting Resp : " + hwRequest3.dumpBaseInfo());
                        for (int i18 = dataTransInfo.bitmapS; i18 <= i17; i18++) {
                            bArr[i18] = 2;
                        }
                    }
                }
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "QueryDebug Before Query : TransId:" + transaction.getTransationId() + " CopyBitmap:" + Arrays.toString(bArr) + " CurrentBitmap:" + Arrays.toString(transaction.bitmap));
                sendInfoQueryRequest(transaction, bArr);
            }
            if (size == 0 && this.engine.mTransWorker.getTransactionNum() > 0) {
                this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
            }
            this.sendUrgentHB.remove(Integer.valueOf(i3));
        }
    }

    private void handleResp(List<HwResponse> list) {
        IRequestListener iRequestListener;
        Transaction transactionById;
        Object obj;
        for (HwResponse hwResponse : list) {
            HwRequest hwRequest = this.sentRequests.get(Integer.valueOf(hwResponse.hwSeq));
            if (hwRequest == null && (transactionById = this.engine.mTransWorker.getTransactionById(hwResponse.mTransId)) != null && (hwRequest = transactionById.getRetryRequests().get(Integer.valueOf(hwResponse.hwSeq))) != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("HandleRetryRequestsResp : Resp.hwSeq:");
                sb5.append(hwResponse.hwSeq);
                sb5.append(" SegmentResp:");
                sb5.append(hwResponse.segmentResp);
                sb5.append(" FIN:");
                CSDataHighwayHead.SegHead segHead = hwResponse.segmentResp;
                if (segHead != null) {
                    obj = Integer.valueOf(segHead.uint32_flag.get());
                } else {
                    obj = "null";
                }
                sb5.append(obj);
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, sb5.toString());
            }
            if (hwRequest != null && (iRequestListener = hwRequest.reqListener) != null) {
                iRequestListener.handleResponse(hwResponse);
            }
        }
        prepareRequests();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepareRequests() {
        HwEngine hwEngine = this.engine;
        if (hwEngine != null && hwEngine.injectHelper != null && hwEngine.getAppContext() != null) {
            HwNetSegConf currentConfig = this.engine.getCurrentConfig();
            int size = this.priorityList.get(2).size() + this.sentRequests.size();
            long j3 = currentConfig.segNum;
            if (j3 > 8) {
                QLog.i(BdhLogUtil.Tag, 1, "seg num beyond default,value :" + j3);
                j3 = 8L;
            }
            boolean z16 = false;
            while (size < j3) {
                HwEngine hwEngine2 = this.engine;
                DataTransInfo pullNextSegment = hwEngine2.mTransWorker.pullNextSegment(hwEngine2.getCurrentBuzConfigs());
                if (pullNextSegment == null) {
                    break;
                }
                Transaction transaction = pullNextSegment.parent;
                RequestDataTrans requestDataTrans = new RequestDataTrans(transaction.peerUin, "PicUp.DataUp", transaction.mBuzCmdId, pullNextSegment, transaction.ticket, transaction.getTransationId(), 30000L);
                addHwRequest(requestDataTrans);
                size++;
                pullNextSegment.parent.TRACKER.logStep(Tracker.QUEUE, " SLICEINFO Start:" + pullNextSegment.bitmapS + " End:" + pullNextSegment.bitmapE + " Seq:" + requestDataTrans.getHwSeq());
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "PrepareRequests : T_Id:" + pullNextSegment.parent.getTransationId() + " Offset:" + pullNextSegment.offset + " Len:" + pullNextSegment.length + " HwSeq:" + requestDataTrans.getHwSeq() + " Status:" + requestDataTrans.status.get() + " dataSize:" + size);
                z16 = true;
            }
            if (z16) {
                this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
            }
        }
    }

    public void cancelAckRequest(HwRequest hwRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) hwRequest);
            return;
        }
        hwRequest.isCancel.set(true);
        hwRequest.onCancle();
        synchronized (this.priorityList) {
            this.priorityList.get(2).remove(hwRequest);
        }
        synchronized (this.sentRequests) {
            this.sentRequests.remove(hwRequest);
        }
    }

    public HwRequest getMaxPriorityRequest(int i3, int i16, long j3, long j16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        int i19 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HwRequest) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i17));
        }
        HwRequest hwRequest = null;
        if (!this.mWorking.get()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.sentRequests) {
            for (HwRequest hwRequest2 : this.sentRequests.values()) {
                if (hwRequest2.isCancel.get()) {
                    arrayList.add(Integer.valueOf(hwRequest2.getHwSeq()));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.sentRequests.remove(Integer.valueOf(((Integer) it.next()).intValue()));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        synchronized (this.priorityList) {
            int i26 = 0;
            while (true) {
                if (i26 > i16) {
                    break;
                }
                try {
                    List<HwRequest> list = this.priorityList.get(i26);
                    if (list.size() != 0) {
                        if (i26 != 0) {
                            hwRequest = list.remove(i18);
                            if (hwRequest.status.get() != 3) {
                                if ((hwRequest instanceof RequestDataTrans) && BdhSegTimeoutUtil.sEnableDynTimeout == i19) {
                                    long calculateTimeout = BdhSegTimeoutUtil.calculateTimeout(this.engine.getAppContext(), (RequestDataTrans) hwRequest, j16, i17, j3);
                                    if (calculateTimeout > 1000) {
                                        hwRequest.timeOut = calculateTimeout;
                                    }
                                }
                            }
                        } else {
                            Iterator<HwRequest> it5 = list.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    break;
                                }
                                HwRequest next = it5.next();
                                if (!this.engine.mConnManager.connections.containsKey(Integer.valueOf(((RequestHeartBreak) next).connId))) {
                                    arrayList2.add(next);
                                } else if (((RequestHeartBreak) next).connId == i3) {
                                    if (next instanceof RequestHeartBreak) {
                                        RequestHeartBreak requestHeartBreak = (RequestHeartBreak) next;
                                        if (requestHeartBreak.isUrgent) {
                                            long urgentHbTimeout = BdhSegTimeoutUtil.getUrgentHbTimeout(this.engine.getAppContext());
                                            if (urgentHbTimeout > 1000) {
                                                requestHeartBreak.timeOut = urgentHbTimeout;
                                            }
                                        }
                                    }
                                    hwRequest = next;
                                }
                            }
                            if (hwRequest != null) {
                                list.remove(hwRequest);
                            }
                            list.removeAll(arrayList2);
                        }
                    }
                    i26++;
                    i18 = 0;
                    i19 = 1;
                } finally {
                }
            }
            if (hwRequest != null) {
                if (hwRequest.getPriority() > 0) {
                    this.mCurrentRequests--;
                }
                hwRequest.updateStaus(3);
                this.sentRequests.put(Integer.valueOf(hwRequest.getHwSeq()), hwRequest);
                if (hwRequest.reqListener == null) {
                    hwRequest.reqListener = new RequestListener(hwRequest);
                }
                hwRequest.reqListener.handleSendBegin(i3);
            }
        }
        return hwRequest;
    }

    public void notifyTransactionChange(int i3, Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) transaction);
            return;
        }
        RequestHandler requestHandler = this.mRequestHandler;
        if (this.mWorking.get() && requestHandler != null) {
            if (i3 == 1) {
                requestHandler.sendEmptyMessage(1);
            } else if (i3 == 2) {
                Message obtain = Message.obtain(this.mRequestHandler);
                obtain.what = 3;
                obtain.obj = transaction;
                obtain.sendToTarget();
            }
        }
    }

    public void onConnClose(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        RequestHandler requestHandler = this.mRequestHandler;
        if (this.mWorking.get() && requestHandler != null) {
            requestHandler.post(new Runnable(i3) { // from class: com.tencent.mobileqq.highway.segment.RequestWorker.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$connId;

                {
                    this.val$connId = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RequestWorker.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        RequestWorker.this.handleConnClosed(this.val$connId);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public void onConnConnected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
    }

    public void onConnIdle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.highway.IHwManager
    public void onDestroy() {
        RequestHandler requestHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.mWorking.compareAndSet(true, false) && (requestHandler = this.mRequestHandler) != null) {
            requestHandler.sendEmptyMessage(2);
        }
    }

    @Override // com.tencent.mobileqq.highway.IHwManager
    public void onInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            this.priorityList.put(i3, new LinkedList());
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Highway-BDH-REQ", 5);
        this.mHandlerThread = baseHandlerThread;
        baseHandlerThread.start();
        this.mRequestHandler = new RequestHandler(this.mHandlerThread.getLooper());
        this.mWorking.set(true);
    }

    public void onNetworkChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        BdhLogUtil.LogEvent("N", "RequestWorker onNetworkChanged : about to clear the request - hasNetwork:" + z16);
        RequestHandler requestHandler = this.mRequestHandler;
        if (z16 && this.mWorking.get() && requestHandler != null) {
            if (this.sentRequests.isEmpty() && this.mCurrentRequests == 0) {
                requestHandler.obtainMessage(1).sendToTarget();
            } else {
                sendConnectRequest(0L, false);
            }
        }
    }

    public void onReceiveResp(List<HwResponse> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
        } else {
            if (!this.mWorking.get()) {
                return;
            }
            handleResp(list);
        }
    }

    public void remove2SENDRequest(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        List<HwRequest> list = this.priorityList.get(2);
        for (HwRequest hwRequest : list) {
            if (hwRequest.transId == i3) {
                RequestDataTrans requestDataTrans = (RequestDataTrans) hwRequest;
                if (requestDataTrans.mInfo.bitmapE <= i16 && requestDataTrans.status.get() == 2) {
                    list.remove(hwRequest.getHwSeq());
                }
            }
        }
    }

    public void sendAckRequest(HwRequest hwRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) hwRequest);
        } else {
            addHwRequest(hwRequest);
            this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
        }
    }

    public void sendConnectRequest(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        RequestHandler requestHandler = this.mRequestHandler;
        if (this.mWorking.get() && requestHandler != null) {
            int i3 = 5;
            if (j3 > 0) {
                if (!z16) {
                    i3 = 4;
                }
                requestHandler.sendMessageDelayed(requestHandler.obtainMessage(i3), j3);
            } else {
                if (!z16) {
                    i3 = 4;
                }
                requestHandler.obtainMessage(i3).sendToTarget();
            }
        }
    }

    public void sendFinishQueryRequest(Transaction transaction, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, transaction, bArr, Integer.valueOf(i3));
            return;
        }
        RequestFinishQuery requestFinishQuery = new RequestFinishQuery(transaction.peerUin, BaseConstants.REQ_HW_CMD.REQ_CMD_QUERY, transaction.mBuzCmdId, transaction.ticket, transaction, 30000L, bArr);
        transaction.mCurrentQueryFinishCount++;
        requestFinishQuery.mQueryHoleFinishIndex = i3;
        addHwRequest(requestFinishQuery);
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "sendFinishQueryRequest : " + requestFinishQuery.dumpBaseInfo() + " size:" + this.mCurrentRequests + " queryIndex:" + requestFinishQuery.mQueryHoleFinishIndex);
        this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
    }

    public void sendHeartBreak(int i3, boolean z16, boolean z17, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16));
            return;
        }
        RequestHandler requestHandler = this.mRequestHandler;
        if (this.mWorking.get() && requestHandler != null) {
            RequestHeartBreak requestHeartBreak = new RequestHeartBreak(this.engine.currentUin, BaseConstants.REQ_HW_CMD.REQ_CMD_HEART_BREAK, 0, 30000L, i3, z16);
            Runnable remove = this.engine.mConnManager.heartBreaks.remove(Integer.valueOf(i3));
            if (z17 && remove != null) {
                requestHandler.removeCallbacks(remove);
            }
            if (i16 == 0) {
                addHwRequest(requestHeartBreak);
                if (z16) {
                    this.sendUrgentHB.put(Integer.valueOf(i3), requestHeartBreak);
                }
                BdhLogUtil.LogEvent("N", "SendHeartBreak : " + requestHeartBreak.dumpBaseInfo() + " size:" + this.mCurrentRequests + " delay:" + i16);
                this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
                return;
            }
            Runnable runnable = new Runnable(i3, requestHeartBreak, i16) { // from class: com.tencent.mobileqq.highway.segment.RequestWorker.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$connId;
                final /* synthetic */ int val$delay;
                final /* synthetic */ HwRequest val$heartBreak;

                {
                    this.val$connId = i3;
                    this.val$heartBreak = requestHeartBreak;
                    this.val$delay = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RequestWorker.this, Integer.valueOf(i3), requestHeartBreak, Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (RequestWorker.this.engine.mConnManager.connections.containsKey(Integer.valueOf(this.val$connId))) {
                        RequestWorker.this.addHwRequest(this.val$heartBreak);
                        BdhLogUtil.LogEvent("N", "OnConnIdle: SendHeartBreak : " + this.val$heartBreak.dumpBaseInfo() + " size:" + RequestWorker.this.mCurrentRequests + " delay:" + this.val$delay);
                        RequestWorker.this.engine.mConnManager.heartBreaks.remove(Integer.valueOf(this.val$connId));
                        RequestWorker requestWorker = RequestWorker.this;
                        requestWorker.engine.mConnManager.wakeupConnectionToWrite(requestWorker.mCurrentRequests, false);
                    }
                }
            };
            requestHandler.postDelayed(runnable, i16);
            this.engine.mConnManager.heartBreaks.put(Integer.valueOf(i3), runnable);
        }
    }

    public void sendInfoQueryFinish(Transaction transaction, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, transaction, bArr, Integer.valueOf(i3));
        } else if (i3 == 0) {
            sendFinishQueryRequest(transaction, bArr, i3);
        } else {
            this.mRequestHandler.postDelayed(new Runnable(transaction, bArr, i3) { // from class: com.tencent.mobileqq.highway.segment.RequestWorker.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$index;
                final /* synthetic */ byte[] val$sentBitmap;
                final /* synthetic */ Transaction val$trans;

                {
                    this.val$trans = transaction;
                    this.val$sentBitmap = bArr;
                    this.val$index = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RequestWorker.this, transaction, bArr, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        RequestWorker.this.sendFinishQueryRequest(this.val$trans, this.val$sentBitmap, this.val$index);
                    }
                }
            }, RequestFinishQuery.QUERY_HOLE_INTERVAL);
        }
    }

    public void sendInfoQueryRequest(Transaction transaction, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) transaction, (Object) bArr);
            return;
        }
        RequestInfoQuery requestInfoQuery = new RequestInfoQuery(transaction.peerUin, BaseConstants.REQ_HW_CMD.REQ_CMD_QUERY, transaction.mBuzCmdId, transaction.ticket, transaction, 30000L, bArr);
        addHwRequest(requestInfoQuery);
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "SendInfoQueryRequest : " + requestInfoQuery.dumpBaseInfo() + " size:" + this.mCurrentRequests);
        this.engine.mConnManager.wakeupConnectionToWrite(this.mCurrentRequests, false);
    }
}
