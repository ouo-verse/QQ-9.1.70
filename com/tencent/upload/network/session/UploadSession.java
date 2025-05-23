package com.tencent.upload.network.session;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.base.IConnectionCallback;
import com.tencent.upload.network.base.NetworkEngine;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.report.SessionReport;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.upload.request.IActionRequest;
import com.tencent.upload.request.UploadResponse;
import com.tencent.upload.task.UploadTask;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.PDUtil;
import com.tencent.upload.utils.UploadLog;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadSession implements IUploadSession, IConnectionCallback {
    static IPatchRedirector $redirector_ = null;
    private static final String CONNECT_TAG = "[connect] UploadSession";
    private static final int MAX_RECV_ERROR_CNT = 3;
    private static final String TAG = "UploadSession";
    private ConcurrentLinkedQueue<IActionRequest> mActionRequests;
    private SessionReport mBaseSessionInfo;
    private Const.BusinessType mBusinessType;
    private Const.ConnectType mConnectType;
    private String mConnectedIp;
    private NetworkEngine mConnection;
    private Handler mHandler;
    private final String mId;
    private volatile boolean mIsBusy;
    private volatile long mLastActiveTime;
    private ByteBuffer mReceivedBuffer;
    private int mRecvErrorCnt;
    private SparseArray<IActionRequest> mSendingMap;
    private volatile IUploadSession.SessionState mSessionState;
    private SparseArray<RequestWrapper> mTimeoutMap;
    private UploadRoute mUploadRoute;
    private final WeakReference<IUploadSessionCallback> mUploadSessionCallback;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RequestWrapper {
        static IPatchRedirector $redirector_;
        public final IActionRequest request;
        public Runnable runnable;
        public long startTime;

        public RequestWrapper(IActionRequest iActionRequest) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iActionRequest);
            } else {
                this.request = iActionRequest;
                this.startTime = System.currentTimeMillis();
            }
        }
    }

    public UploadSession(Looper looper, IUploadSessionCallback iUploadSessionCallback, Const.BusinessType businessType, Const.ConnectType connectType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, looper, iUploadSessionCallback, businessType, connectType);
            return;
        }
        this.mBaseSessionInfo = new SessionReport();
        this.mRecvErrorCnt = 0;
        String valueOf = String.valueOf(hashCode());
        this.mId = valueOf;
        this.mReceivedBuffer = ByteBuffer.allocate(128);
        this.mActionRequests = new ConcurrentLinkedQueue<>();
        this.mSendingMap = new SparseArray<>();
        this.mTimeoutMap = new SparseArray<>();
        this.mUploadSessionCallback = new WeakReference<>(iUploadSessionCallback);
        this.mSessionState = IUploadSession.SessionState.NO_CONNECT;
        this.mHandler = new Handler(looper);
        this.mBusinessType = businessType;
        this.mConnectType = connectType;
        SessionReport sessionReport = this.mBaseSessionInfo;
        sessionReport.sessionId = valueOf;
        sessionReport.businessType = businessType;
        sessionReport.connectType = connectType;
        recordLastActiveTime();
    }

    private void doCleanup(int i3) {
        IActionRequest iActionRequest;
        IActionRequest iActionRequest2;
        UploadLog.d(TAG, "do Cleanup Session. sid=" + this.mId);
        this.mReceivedBuffer.clear();
        Const.UploadRetCode retCode = Const.getRetCode(i3);
        UploadLog.d(TAG, "mActionRequests.size()=" + this.mActionRequests.size() + " mSendingMap.size()=" + this.mSendingMap.size() + " mTimeoutMap.size()=" + this.mTimeoutMap.size());
        Iterator<IActionRequest> it = this.mActionRequests.iterator();
        while (it.hasNext()) {
            IActionRequest next = it.next();
            if (next != null && next.getListener() != null) {
                next.getListener().onRequestError(next, retCode, this);
            }
        }
        this.mActionRequests.clear();
        for (int i16 = 0; i16 < this.mSendingMap.size(); i16++) {
            int keyAt = this.mSendingMap.keyAt(i16);
            RequestWrapper requestWrapper = this.mTimeoutMap.get(keyAt);
            if ((requestWrapper == null || requestWrapper.request == null) && (iActionRequest2 = this.mSendingMap.get(keyAt)) != null && iActionRequest2.getListener() != null) {
                iActionRequest2.getListener().onRequestError(iActionRequest2, retCode, this);
            }
        }
        this.mSendingMap.clear();
        for (int i17 = 0; i17 < this.mTimeoutMap.size(); i17++) {
            RequestWrapper requestWrapper2 = this.mTimeoutMap.get(this.mTimeoutMap.keyAt(i17));
            if (requestWrapper2 != null) {
                iActionRequest = requestWrapper2.request;
            } else {
                iActionRequest = null;
            }
            if (iActionRequest != null && iActionRequest.getListener() != null) {
                iActionRequest.getListener().onRequestError(iActionRequest, retCode, this);
            }
        }
        doClearAllTimeout();
    }

    private void doClearAllTimeout() {
        for (int i3 = 0; i3 < this.mTimeoutMap.size(); i3++) {
            RequestWrapper requestWrapper = this.mTimeoutMap.get(this.mTimeoutMap.keyAt(i3));
            if (requestWrapper != null) {
                this.mHandler.removeCallbacks(requestWrapper.runnable);
                requestWrapper.runnable = null;
            }
        }
        this.mTimeoutMap.clear();
    }

    private void doDeleteTimeout(UploadResponse uploadResponse) {
        int requestSequence;
        SparseArray<RequestWrapper> sparseArray;
        RequestWrapper requestWrapper;
        if (uploadResponse == null || (requestWrapper = (sparseArray = this.mTimeoutMap).get((requestSequence = uploadResponse.getRequestSequence()))) == null) {
            return;
        }
        this.mHandler.removeCallbacks(requestWrapper.runnable);
        sparseArray.delete(requestSequence);
    }

    private byte[] doDivideReceivedBuffer() {
        if (this.mReceivedBuffer.position() == 0) {
            UploadLog.w(TAG, "doDivideReceivedBuffer: mReceivedBuffer.position() == 0");
            return null;
        }
        if (this.mReceivedBuffer.position() < 4) {
            UploadLog.w(TAG, "doDivideReceivedBuffer: size < 4 sid=" + this.mId);
            return new byte[0];
        }
        int decodePDU = PDUtil.decodePDU(this.mReceivedBuffer.array());
        if (decodePDU <= UploadConfiguration.getMaxSessionPacketSize() && decodePDU >= 25) {
            if (decodePDU > this.mReceivedBuffer.position()) {
                UploadLog.w(TAG, "doDivideReceivedBuffer sid=" + this.mId + " size:" + decodePDU + " mReceivedBuffer position:" + this.mReceivedBuffer.position());
                return null;
            }
            byte[] bArr = new byte[decodePDU];
            this.mReceivedBuffer.flip();
            this.mReceivedBuffer.get(bArr);
            this.mReceivedBuffer.compact();
            return bArr;
        }
        UploadLog.w(TAG, " doDivideReceivedBuffer size > max, size:" + decodePDU + " sid=" + this.mId);
        return new byte[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doError(IConnectionCallback iConnectionCallback, int i3, String str) {
        if (iConnectionCallback != this) {
            return;
        }
        UploadLog.e(TAG, "Session Error. sid=" + this.mId + " errorCode=" + i3 + " msg=" + str + " currState=" + this.mSessionState.toString());
        IUploadSessionCallback iUploadSessionCallback = this.mUploadSessionCallback.get();
        if (iUploadSessionCallback != null && i3 != 0) {
            setSessionState(IUploadSession.SessionState.NO_CONNECT);
            doCleanup(i3);
            iUploadSessionCallback.onSessionError(this, i3, str);
        }
    }

    private void doHandleResponse(RequestWrapper requestWrapper, UploadResponse uploadResponse) {
        IActionRequest iActionRequest;
        if (requestWrapper != null) {
            iActionRequest = requestWrapper.request;
        } else {
            iActionRequest = null;
        }
        if (this.mSessionState == IUploadSession.SessionState.ESTABLISHED && iActionRequest != null && iActionRequest.getListener() != null) {
            if (uploadResponse != null) {
                uploadResponse.setSid(this.mId);
            }
            iActionRequest.getListener().onResponse(iActionRequest, uploadResponse);
        }
    }

    private void doReceiveBuffer(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int position = this.mReceivedBuffer.position() + bArr.length;
        if (this.mReceivedBuffer.capacity() < position) {
            UploadLog.d(TAG, "doReceiveBuffer mReceivedBuffer.capacity() size < " + position);
            ByteBuffer allocate = ByteBuffer.allocate(position);
            this.mReceivedBuffer.flip();
            allocate.put(this.mReceivedBuffer);
            this.mReceivedBuffer = allocate;
        }
        this.mReceivedBuffer.put(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRecv(IConnectionCallback iConnectionCallback, byte[] bArr) {
        boolean z16;
        recordLastActiveTime();
        doReceiveBuffer(bArr);
        UploadResponse.DecodeResult decodeResult = UploadResponse.DecodeResult.SUCCEED;
        while (true) {
            byte[] doDivideReceivedBuffer = doDivideReceivedBuffer();
            if (doDivideReceivedBuffer == null) {
                UploadLog.d(TAG, this.mId + " doDivideReceivedBuffer buf == null");
                break;
            }
            if (doDivideReceivedBuffer.length == 0) {
                UploadLog.d(TAG, this.mId + " doDivideReceivedBuffer buf.length == 0");
                break;
            }
            UploadResponse uploadResponse = new UploadResponse();
            try {
                decodeResult = uploadResponse.decode(doDivideReceivedBuffer);
            } catch (Exception e16) {
                UploadLog.e(TAG, this.mId + "decode error ", e16);
            }
            if (decodeResult.getCode() != 0) {
                UploadLog.e(TAG, this.mId + " doRecv decode error " + decodeResult);
                z16 = true;
                break;
            }
            RequestWrapper requestWrapper = this.mTimeoutMap.get(uploadResponse.getRequestSequence());
            if (requestWrapper != null) {
                doDeleteTimeout(uploadResponse);
                doHandleResponse(requestWrapper, uploadResponse);
            }
        }
        z16 = false;
        UploadLog.d(TAG, this.mId + " doRecv... hasDivideError:" + z16);
        if (z16) {
            if (this.mSessionState == IUploadSession.SessionState.ESTABLISHED) {
                IUploadSessionCallback iUploadSessionCallback = this.mUploadSessionCallback.get();
                if (iUploadSessionCallback != null) {
                    if (decodeResult.getCode() == 0) {
                        this.mRecvErrorCnt++;
                        decodeResult = UploadResponse.DecodeResult.DECODE_BUF_EMPTY_ERROR;
                    }
                    UploadLog.e(TAG, this.mId + " doRecv sRecvErrorCnt " + this.mRecvErrorCnt + " ret:" + decodeResult + " needCallBack:true");
                    this.mRecvErrorCnt = 0;
                    setSessionState(IUploadSession.SessionState.NO_CONNECT);
                    doCleanup(decodeResult.getCode());
                    iUploadSessionCallback.onSessionError(this, decodeResult.getCode(), decodeResult.getMsg());
                }
                UploadLog.d(TAG, this.mId + " doRecv... disconnect...");
                this.mConnection.stop();
                return;
            }
            return;
        }
        this.mRecvErrorCnt = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendFirstRequest() {
        IActionRequest iActionRequest;
        if (this.mActionRequests.isEmpty()) {
            return;
        }
        try {
            iActionRequest = this.mActionRequests.remove();
        } catch (Exception e16) {
            UploadLog.e(TAG, "get send request exception.", e16);
            iActionRequest = null;
        }
        if (iActionRequest == null) {
            return;
        }
        UploadLog.d(UploadTask.TRANSFER_TAG, "Send Request Begin. sid=" + this.mId + " " + iActionRequest.toString() + " sending:" + this.mSendingMap.size() + " waiting:" + this.mActionRequests.size());
        this.mSendingMap.put(iActionRequest.getRequestId(), iActionRequest);
        doSendRequest(iActionRequest);
    }

    private void doSendRequest(IActionRequest iActionRequest) {
        NetworkEngine networkEngine = this.mConnection;
        if (networkEngine == null) {
            UploadLog.e(TAG, "Session has no connection! actionId=" + iActionRequest.getTaskId() + " reqId=" + iActionRequest.getRequestId() + " sid=" + this.mId);
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.SESSION_WITHOUT_CONN;
            doError(this, uploadRetCode.getCode(), uploadRetCode.getDesc());
            return;
        }
        try {
            byte[] encode = iActionRequest.encode();
            if (encode == null) {
                UploadLog.e(TAG, "decode request failed. actionId=" + iActionRequest.getTaskId() + " reqId=" + iActionRequest.getRequestId() + " cmd=" + iActionRequest.getCmdId() + " sid=" + this.mId);
                this.mSendingMap.delete(iActionRequest.getRequestId());
                if (iActionRequest.getListener() != null) {
                    iActionRequest.getListener().onRequestError(iActionRequest, Const.UploadRetCode.DATA_ENCODE_ERROR, this);
                    return;
                }
                return;
            }
            int sendTimeout = getSendTimeout(encode.length);
            iActionRequest.startRecord();
            if (!networkEngine.sendAsync(encode, iActionRequest.getRequestId(), sendTimeout, sendTimeout)) {
                UploadLog.e(TAG, "NetworkEngine SendAsync failed. sid=" + this.mId);
                this.mSendingMap.delete(iActionRequest.getRequestId());
                Const.UploadRetCode uploadRetCode2 = Const.UploadRetCode.SESSION_CONN_SEND_FAILED;
                doError(this, uploadRetCode2.getCode(), uploadRetCode2.getDesc());
                return;
            }
            networkEngine.wakeUp();
        } catch (IOException e16) {
            if (iActionRequest.getListener() != null) {
                iActionRequest.getListener().onRequestError(iActionRequest, Const.UploadRetCode.IO_EXCEPTION, this);
            }
            UploadLog.e(TAG, "", e16);
        } catch (OutOfMemoryError e17) {
            if (iActionRequest.getListener() != null) {
                iActionRequest.getListener().onRequestError(iActionRequest, Const.UploadRetCode.OOM, this);
            }
            UploadLog.e(TAG, "", e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartTimeout(IActionRequest iActionRequest) {
        if (iActionRequest == null) {
            return;
        }
        int requestId = iActionRequest.getRequestId();
        if (this.mTimeoutMap.get(requestId) != null) {
            UploadLog.w(TAG, "timeout runnable has been started. reqId=" + requestId + " sid=" + this.mId);
            return;
        }
        RequestWrapper requestWrapper = new RequestWrapper(iActionRequest);
        int responseTimeout = getResponseTimeout(iActionRequest);
        Runnable runnable = new Runnable(responseTimeout, requestId, iActionRequest) { // from class: com.tencent.upload.network.session.UploadSession.9
            static IPatchRedirector $redirector_;
            final /* synthetic */ IActionRequest val$request;
            final /* synthetic */ int val$requestSequence;
            final /* synthetic */ int val$responseTimeout;

            {
                this.val$responseTimeout = responseTimeout;
                this.val$requestSequence = requestId;
                this.val$request = iActionRequest;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, UploadSession.this, Integer.valueOf(responseTimeout), Integer.valueOf(requestId), iActionRequest);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IActionRequest iActionRequest2;
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (UploadSession.this.mLastActiveTime != 0) {
                    long currentTimeMillis = System.currentTimeMillis() - UploadSession.this.mLastActiveTime;
                    int i3 = this.val$responseTimeout;
                    if (currentTimeMillis < i3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    int i16 = (int) (i3 - currentTimeMillis);
                    if (z16) {
                        UploadSession.this.mHandler.postDelayed(this, i16);
                        return;
                    }
                }
                SparseArray sparseArray = UploadSession.this.mTimeoutMap;
                RequestWrapper requestWrapper2 = (RequestWrapper) sparseArray.get(this.val$requestSequence);
                if (requestWrapper2 != null && requestWrapper2.runnable == this) {
                    String str = "ResponseTime! actionId=" + requestWrapper2.request.getTaskId() + " reqId=" + this.val$requestSequence + " cmd=" + requestWrapper2.request.getCmdId() + " sid=" + UploadSession.this.mId + " currState=" + UploadSession.this.mSessionState.toString();
                    UploadLog.w(UploadSession.TAG, str);
                    sparseArray.remove(this.val$requestSequence);
                    UploadSession.this.mHandler.removeCallbacks(requestWrapper2.runnable);
                    requestWrapper2.runnable = null;
                    if (UploadSession.this.mSessionState == IUploadSession.SessionState.ESTABLISHED && (iActionRequest2 = this.val$request) != null && iActionRequest2.getListener() != null) {
                        this.val$request.getListener().onRequestSessionReport(new UploadQualityReportBuilder().setExt1(UploadSession.this.getBaseSessionReportString()).setExt2(UploadQualityReportBuilder.STATE_RESPONSE_TIMEOUT).setAttachInfo(str));
                        this.val$request.getListener().onRequestTimeout(this.val$request, UploadSession.this);
                        return;
                    }
                    return;
                }
                UploadLog.w(UploadSession.TAG, "execute timeout runnable has been removed. reqId=" + this.val$requestSequence + " sid=" + UploadSession.this.mId);
            }
        };
        this.mHandler.removeCallbacks(requestWrapper.runnable);
        requestWrapper.runnable = runnable;
        this.mTimeoutMap.put(requestId, requestWrapper);
        this.mHandler.postDelayed(runnable, responseTimeout);
    }

    private static final int getResponseTimeout(IActionRequest iActionRequest) {
        int dataTimeout = UploadConfiguration.getDataTimeout();
        if (is2G()) {
            return dataTimeout * 2;
        }
        return dataTimeout;
    }

    public static final int getSendTimeout(int i3) {
        int dataTimeout = UploadConfiguration.getDataTimeout();
        if (is2G()) {
            return dataTimeout * 2;
        }
        return dataTimeout;
    }

    private static boolean is2G() {
        if (UploadConfiguration.getCurrentNetworkCategory() == 3) {
            return true;
        }
        return false;
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean isValidIPv6(java.lang.String r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L1d
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto La
            goto L1d
        La:
            java.net.InetAddress r1 = java.net.InetAddress.getByName(r3)     // Catch: java.net.UnknownHostException -> L1d
            java.lang.String r2 = r1.getHostAddress()     // Catch: java.net.UnknownHostException -> L1d
            boolean r3 = r2.equals(r3)     // Catch: java.net.UnknownHostException -> L1d
            if (r3 == 0) goto L1d
            boolean r3 = r1 instanceof java.net.Inet6Address     // Catch: java.net.UnknownHostException -> L1d
            if (r3 == 0) goto L1d
            r0 = 1
        L1d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.upload.network.session.UploadSession.isValidIPv6(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setSessionState(IUploadSession.SessionState sessionState) {
        if (this.mSessionState == sessionState) {
            return;
        }
        UploadLog.d(TAG, "update state sid:" + this.mId + " " + this.mSessionState.toString() + "-->" + sessionState.toString());
        this.mSessionState = sessionState;
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public void cancel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        Iterator<IActionRequest> it = this.mActionRequests.iterator();
        while (it.hasNext()) {
            IActionRequest next = it.next();
            if (next != null && next.getTaskId() == i3) {
                it.remove();
                UploadLog.d(TAG, this.mId + " cancel: mActionRequests remove: actSeq:" + i3 + " request:" + next.getRequestId());
            }
        }
        LinkedList linkedList = new LinkedList();
        int size = this.mSendingMap.size();
        for (int i16 = 0; i16 < size; i16++) {
            IActionRequest valueAt = this.mSendingMap.valueAt(i16);
            if (valueAt != null && valueAt.getTaskId() == i3) {
                int keyAt = this.mSendingMap.keyAt(i16);
                linkedList.add(Integer.valueOf(keyAt));
                UploadLog.d(TAG, this.mId + " cancel: mSendingMap remove: sendSeq:" + keyAt + " actSeq:" + valueAt.getTaskId() + " reqSeq:" + valueAt.getRequestId());
            }
        }
        while (linkedList.size() > 0) {
            this.mSendingMap.remove(((Integer) linkedList.removeFirst()).intValue());
        }
        int size2 = this.mTimeoutMap.size();
        for (int i17 = 0; i17 < size2; i17++) {
            RequestWrapper valueAt2 = this.mTimeoutMap.valueAt(i17);
            if (valueAt2 != null && valueAt2.request.getTaskId() == i3) {
                int keyAt2 = this.mTimeoutMap.keyAt(i17);
                linkedList.add(Integer.valueOf(keyAt2));
                UploadLog.d(TAG, this.mId + " cancel: mTimeoutMap remove runnable reqSeq:" + keyAt2 + " actSeq:" + valueAt2.request.getTaskId());
                this.mHandler.removeCallbacks(valueAt2.runnable);
                valueAt2.runnable = null;
            }
        }
        while (linkedList.size() > 0) {
            this.mTimeoutMap.remove(((Integer) linkedList.removeFirst()).intValue());
        }
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.mConnection == null) {
            return;
        }
        UploadLog.w(CONNECT_TAG, "Close Session. sid=" + this.mId);
        NetworkEngine networkEngine = this.mConnection;
        if (networkEngine != null) {
            networkEngine.stop();
            this.mConnection = null;
        }
        IUploadSessionCallback iUploadSessionCallback = this.mUploadSessionCallback.get();
        if (iUploadSessionCallback != null) {
            iUploadSessionCallback.onSessionClosed(this);
        }
        setSessionState(IUploadSession.SessionState.NO_CONNECT);
        this.mReceivedBuffer.clear();
        this.mActionRequests.clear();
        this.mSendingMap.clear();
        this.mBaseSessionInfo.reset();
        doClearAllTimeout();
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public String getBaseSessionReportString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        SessionReport sessionReport = this.mBaseSessionInfo;
        if (sessionReport != null) {
            return sessionReport.toString();
        }
        return "";
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public String getConnectedIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mConnectedIp;
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public String getSessionId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.mId;
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public IUploadSession.SessionState getState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (IUploadSession.SessionState) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mSessionState;
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public UploadRoute getUploadRoute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (UploadRoute) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mUploadRoute;
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public boolean isExpired() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (System.currentTimeMillis() - this.mLastActiveTime > 60000) {
            z16 = true;
        } else {
            z16 = false;
        }
        UploadLog.i(TAG, this.mId + " session isExpired:" + z16);
        return z16;
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public boolean isIdle() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (!this.mIsBusy && this.mActionRequests.size() == 0 && this.mSendingMap.size() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        UploadLog.d(TAG, "isIdle --- " + z16);
        return z16;
    }

    @Override // com.tencent.upload.network.base.IConnectionCallback
    public void onConnect(IConnectionCallback iConnectionCallback, boolean z16, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, iConnectionCallback, Boolean.valueOf(z16), Integer.valueOf(i3), str);
        } else {
            this.mHandler.post(new Runnable(iConnectionCallback, z16, i3, str) { // from class: com.tencent.upload.network.session.UploadSession.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ IConnectionCallback val$callback;
                final /* synthetic */ String val$connectedIp;
                final /* synthetic */ int val$errorCode;
                final /* synthetic */ boolean val$isSuccess;

                {
                    this.val$callback = iConnectionCallback;
                    this.val$isSuccess = z16;
                    this.val$errorCode = i3;
                    this.val$connectedIp = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UploadSession.this, iConnectionCallback, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i16;
                    String str2;
                    String str3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        UploadSession.this.mBaseSessionInfo.connectIp = UploadSession.this.mConnection.getConnectedIp();
                        SessionReport sessionReport = UploadSession.this.mBaseSessionInfo;
                        int i17 = 0;
                        if (UploadSession.this.mUploadRoute != null) {
                            i16 = UploadSession.this.mUploadRoute.getPort();
                        } else {
                            i16 = 0;
                        }
                        sessionReport.port = i16;
                        SessionReport sessionReport2 = UploadSession.this.mBaseSessionInfo;
                        String str4 = "";
                        if (UploadSession.this.mUploadRoute == null) {
                            str2 = "";
                        } else {
                            str2 = UploadSession.this.mUploadRoute.getIp();
                        }
                        sessionReport2.uploadRouteIp = str2;
                        SessionReport sessionReport3 = UploadSession.this.mBaseSessionInfo;
                        if (UploadSession.this.mUploadRoute != null) {
                            i17 = UploadSession.this.mUploadRoute.getNewStrategy();
                        }
                        sessionReport3.newStrategy = i17;
                        long j3 = -1;
                        if (UploadSession.this.mConnection.getStartConnectTime() != -1) {
                            j3 = System.currentTimeMillis() - UploadSession.this.mConnection.getStartConnectTime();
                        }
                        Object obj = this.val$callback;
                        if (obj != UploadSession.this) {
                            NetworkEngine networkEngine = (NetworkEngine) obj;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("doAfterConnect. sid=");
                            sb5.append(UploadSession.this.mId);
                            sb5.append(" succeed=");
                            sb5.append(this.val$isSuccess);
                            sb5.append(" errorCode=");
                            sb5.append(this.val$errorCode);
                            sb5.append(" ip=");
                            if (UploadSession.this.mUploadRoute != null) {
                                str4 = UploadSession.this.mUploadRoute.getIp();
                            }
                            sb5.append(str4);
                            sb5.append(" The connection is invalid, close it!");
                            sb5.append(networkEngine.hashCode());
                            UploadLog.d(UploadSession.CONNECT_TAG, sb5.toString());
                            networkEngine.stop();
                            return;
                        }
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("sid=");
                        sb6.append(UploadSession.this.mId);
                        sb6.append(" succeed=");
                        sb6.append(this.val$isSuccess);
                        sb6.append(" errorCode=");
                        sb6.append(this.val$errorCode);
                        sb6.append(" ip=");
                        if (UploadSession.this.mUploadRoute == null) {
                            str3 = "";
                        } else {
                            str3 = UploadSession.this.mUploadRoute.getIp();
                        }
                        sb6.append(str3);
                        sb6.append(" currState=");
                        sb6.append(UploadSession.this.mSessionState.toString());
                        sb6.append(" realip=");
                        sb6.append(UploadSession.this.mConnection.getConnectedIp());
                        String sb7 = sb6.toString();
                        UploadLog.d(UploadSession.CONNECT_TAG, "doAfterConnect. " + sb7);
                        IUploadReport uploadReport = UploadGlobalConfig.getUploadReport();
                        UploadQualityReportBuilder uploadQualityReportBuilder = new UploadQualityReportBuilder();
                        if (UploadSession.this.mBaseSessionInfo != null) {
                            str4 = UploadSession.this.mBaseSessionInfo.toString();
                        }
                        uploadReport.onSessionReport(uploadQualityReportBuilder.setExt1(str4).setExt2(UploadQualityReportBuilder.STATE_CONNECT).setExt3(String.valueOf(j3)).setExt4(String.valueOf(UploadSession.this.mConnection.getDomainParserTime())).setAttachInfo(sb7), UploadSession.this.mBaseSessionInfo.taskTypeConfig);
                        if (UploadSession.this.mSessionState == IUploadSession.SessionState.CONNECTING || UploadSession.this.mSessionState == IUploadSession.SessionState.NO_CONNECT) {
                            if (this.val$isSuccess) {
                                UploadSession.this.recordLastActiveTime();
                                UploadLog.d(UploadSession.CONNECT_TAG, "sid=" + UploadSession.this.mId + ", connect succeed:" + this.val$isSuccess + ", ip=" + this.val$connectedIp + ", currState=" + UploadSession.this.mSessionState.toString());
                                UploadSession.this.mConnectedIp = this.val$connectedIp;
                                UploadSession.this.setSessionState(IUploadSession.SessionState.ESTABLISHED);
                                IUploadSessionCallback iUploadSessionCallback = (IUploadSessionCallback) UploadSession.this.mUploadSessionCallback.get();
                                if (iUploadSessionCallback != null) {
                                    iUploadSessionCallback.onOpenSucceed(UploadSession.this);
                                    return;
                                }
                                return;
                            }
                            IUploadSessionCallback iUploadSessionCallback2 = (IUploadSessionCallback) UploadSession.this.mUploadSessionCallback.get();
                            if (iUploadSessionCallback2 != null) {
                                UploadSession.this.setSessionState(IUploadSession.SessionState.NO_CONNECT);
                                iUploadSessionCallback2.onOpenFailed(UploadSession.this, this.val$errorCode, "\u8fde\u63a5\u5931\u8d25");
                            }
                            if (UploadSession.this.mConnection != null) {
                                UploadSession.this.mConnection.stop();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.upload.network.base.IConnectionCallback
    public void onDisconnect(IConnectionCallback iConnectionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iConnectionCallback);
        } else {
            this.mHandler.post(new Runnable(iConnectionCallback) { // from class: com.tencent.upload.network.session.UploadSession.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ IConnectionCallback val$callback;

                {
                    this.val$callback = iConnectionCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadSession.this, (Object) iConnectionCallback);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Object obj = this.val$callback;
                    if (obj != UploadSession.this) {
                        ((NetworkEngine) obj).release();
                        return;
                    }
                    UploadLog.d(UploadSession.TAG, "Session DisConnected. sid=" + UploadSession.this.mId + " currState=" + UploadSession.this.mSessionState.toString());
                    IUploadSessionCallback iUploadSessionCallback = (IUploadSessionCallback) UploadSession.this.mUploadSessionCallback.get();
                    if (iUploadSessionCallback != null && UploadSession.this.getState() == IUploadSession.SessionState.ESTABLISHED) {
                        iUploadSessionCallback.onSessionClosed(UploadSession.this);
                    }
                    UploadSession.this.setSessionState(IUploadSession.SessionState.NO_CONNECT);
                    IUploadReport uploadReport = UploadGlobalConfig.getUploadReport();
                    UploadQualityReportBuilder uploadQualityReportBuilder = new UploadQualityReportBuilder();
                    if (UploadSession.this.mBaseSessionInfo != null) {
                        str = UploadSession.this.mBaseSessionInfo.toString();
                    } else {
                        str = "";
                    }
                    uploadReport.onSessionReport(uploadQualityReportBuilder.setExt1(str).setExt2("disconnect"), UploadSession.this.mBaseSessionInfo.taskTypeConfig);
                }
            });
        }
    }

    @Override // com.tencent.upload.network.base.IConnectionCallback
    public void onError(IConnectionCallback iConnectionCallback, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iConnectionCallback, i3);
        } else {
            this.mHandler.post(new Runnable(i3, iConnectionCallback) { // from class: com.tencent.upload.network.session.UploadSession.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ IConnectionCallback val$callback;
                final /* synthetic */ int val$socketStatus;

                {
                    this.val$socketStatus = i3;
                    this.val$callback = iConnectionCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UploadSession.this, Integer.valueOf(i3), iConnectionCallback);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i16 = this.val$socketStatus;
                    String str2 = "";
                    if (SessionPool.isNetworkUnavailable(i16)) {
                        if (UploadGlobalConfig.getConfig().isSwitchOn(Const.SwitchConfigKey.QQCIRCLE_CHANGE_ROUTE_FOR_IPV6)) {
                            if (UploadSession.this.mConnection == null || !UploadSession.isValidIPv6(UploadSession.this.mConnection.getConnectedIp())) {
                                i16 = Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode();
                            }
                        } else {
                            i16 = Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode();
                        }
                        IUploadReport uploadReport = UploadGlobalConfig.getUploadReport();
                        UploadQualityReportBuilder uploadQualityReportBuilder = new UploadQualityReportBuilder();
                        if (UploadSession.this.mBaseSessionInfo == null) {
                            str = "";
                        } else {
                            str = UploadSession.this.mBaseSessionInfo.toString();
                        }
                        uploadReport.onSessionReport(uploadQualityReportBuilder.setExt1(str).setExt2("error").setExt3(String.valueOf(this.val$socketStatus)).setExt4(String.valueOf(i16)), UploadSession.this.mBaseSessionInfo.taskTypeConfig);
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Session Error. sid=");
                    sb5.append(UploadSession.this.mId);
                    sb5.append(" socket_status=");
                    sb5.append(this.val$socketStatus);
                    sb5.append(" mConnection.getConnectedIp():");
                    if (UploadSession.this.mConnection != null) {
                        str2 = UploadSession.this.mConnection.getConnectedIp();
                    }
                    sb5.append(str2);
                    UploadLog.w(UploadSession.TAG, sb5.toString());
                    UploadSession.this.doError(this.val$callback, i16, "NDK Network Error: " + i16);
                }
            });
        }
    }

    @Override // com.tencent.upload.network.base.IConnectionCallback
    public void onRecv(IConnectionCallback iConnectionCallback, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iConnectionCallback, (Object) bArr);
        } else {
            this.mHandler.post(new Runnable(iConnectionCallback, bArr) { // from class: com.tencent.upload.network.session.UploadSession.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ IConnectionCallback val$callback;
                final /* synthetic */ byte[] val$pcallbackuf;

                {
                    this.val$callback = iConnectionCallback;
                    this.val$pcallbackuf = bArr;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UploadSession.this, iConnectionCallback, bArr);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        UploadSession.this.doRecv(this.val$callback, this.val$pcallbackuf);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.upload.network.base.IConnectionCallback
    public void onSendBegin(IConnectionCallback iConnectionCallback, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) iConnectionCallback, i3);
        } else {
            this.mHandler.post(new Runnable(i3) { // from class: com.tencent.upload.network.session.UploadSession.7
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$sendSequence;

                {
                    this.val$sendSequence = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadSession.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UploadSession.this.recordLastActiveTime();
                    UploadSession.this.doStartTimeout((IActionRequest) UploadSession.this.mSendingMap.get(this.val$sendSequence));
                }
            });
        }
    }

    @Override // com.tencent.upload.network.base.IConnectionCallback
    public void onSendEnd(IConnectionCallback iConnectionCallback, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) iConnectionCallback, i3);
        } else {
            this.mHandler.post(new Runnable(i3) { // from class: com.tencent.upload.network.session.UploadSession.8
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$sendSequence;

                {
                    this.val$sendSequence = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadSession.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IActionRequest iActionRequest;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UploadSession.this.recordLastActiveTime();
                    IActionRequest iActionRequest2 = (IActionRequest) UploadSession.this.mSendingMap.get(this.val$sendSequence);
                    if (iActionRequest2 == null) {
                        UploadLog.w(UploadTask.TRANSFER_TAG, "doSendEnd request== null. reqId=" + this.val$sendSequence + ", sid=" + UploadSession.this.mId);
                        return;
                    }
                    UploadLog.d(UploadTask.TRANSFER_TAG, "Send Request End. sid=" + UploadSession.this.mId + ", taskId=" + iActionRequest2.getTaskId() + ", reqId=" + iActionRequest2.getRequestId());
                    UploadSession.this.mSendingMap.delete(this.val$sendSequence);
                    if (iActionRequest2.getListener() != null) {
                        iActionRequest2.getListener().onRequestSended(iActionRequest2);
                    }
                    RequestWrapper requestWrapper = (RequestWrapper) UploadSession.this.mTimeoutMap.get(this.val$sendSequence);
                    if (requestWrapper != null && (iActionRequest = requestWrapper.request) != null && !iActionRequest.needTimeout()) {
                        if (requestWrapper.runnable != null) {
                            UploadSession.this.mHandler.removeCallbacks(requestWrapper.runnable);
                        }
                        requestWrapper.runnable = null;
                    }
                    UploadSession.this.doSendFirstRequest();
                }
            });
        }
    }

    @Override // com.tencent.upload.network.base.IConnectionCallback
    public void onSendTimeOut(IConnectionCallback iConnectionCallback, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, iConnectionCallback, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mHandler.post(new Runnable(iConnectionCallback, i3, i16) { // from class: com.tencent.upload.network.session.UploadSession.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ IConnectionCallback val$callback;
                final /* synthetic */ int val$reason;
                final /* synthetic */ int val$sendSequence;

                {
                    this.val$callback = iConnectionCallback;
                    this.val$sendSequence = i3;
                    this.val$reason = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UploadSession.this, iConnectionCallback, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Object obj;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Object obj2 = this.val$callback;
                    if (obj2 != UploadSession.this) {
                        ((NetworkEngine) obj2).stop();
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("doSendTimeout! sid=");
                    sb5.append(UploadSession.this.mId);
                    sb5.append(" seq:");
                    sb5.append(this.val$sendSequence);
                    sb5.append(" reason:");
                    sb5.append(this.val$reason);
                    sb5.append(" currState=");
                    sb5.append(UploadSession.this.mSessionState.toString());
                    sb5.append(" timeout route:");
                    if (UploadSession.this.mUploadRoute != null) {
                        obj = UploadSession.this.mUploadRoute;
                    } else {
                        obj = "null";
                    }
                    sb5.append(obj);
                    String sb6 = sb5.toString();
                    UploadLog.w(UploadSession.TAG, sb6);
                    if (UploadSession.this.mSessionState == IUploadSession.SessionState.ESTABLISHED) {
                        IActionRequest iActionRequest = (IActionRequest) UploadSession.this.mSendingMap.get(this.val$sendSequence);
                        if (iActionRequest != null && iActionRequest.getListener() != null) {
                            iActionRequest.getListener().onRequestSessionReport(new UploadQualityReportBuilder().setExt1(UploadSession.this.getBaseSessionReportString()).setExt2(UploadQualityReportBuilder.STATE_SEND_TIMEOUT).setAttachInfo(sb6));
                            iActionRequest.getListener().onRequestTimeout(iActionRequest, UploadSession.this);
                        }
                        IUploadSessionCallback iUploadSessionCallback = (IUploadSessionCallback) UploadSession.this.mUploadSessionCallback.get();
                        if (iUploadSessionCallback != null) {
                            UploadSession uploadSession = UploadSession.this;
                            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.REQUEST_TIMEOUT;
                            iUploadSessionCallback.onSessionError(uploadSession, uploadRetCode.getCode(), uploadRetCode.getDesc());
                            UploadSession.this.setSessionState(IUploadSession.SessionState.NO_CONNECT);
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.upload.network.base.IConnectionCallback
    public void onStart(IConnectionCallback iConnectionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iConnectionCallback);
        } else {
            if (iConnectionCallback != this) {
                return;
            }
            UploadLog.d(TAG, "Session onStart. sid=" + this.mId);
        }
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public boolean open(UploadRoute uploadRoute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? open(uploadRoute, UploadConfiguration.getConnectionTimeout()) : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uploadRoute)).booleanValue();
    }

    public void recordLastActiveTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.mLastActiveTime = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public boolean send(IActionRequest iActionRequest, TaskTypeConfig taskTypeConfig, IUploadSession.RequestListener requestListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, iActionRequest, taskTypeConfig, requestListener)).booleanValue();
        }
        if (this.mSessionState != IUploadSession.SessionState.ESTABLISHED) {
            UploadLog.e(TAG, "Can't send request, state is illegel. CurrState=" + this.mSessionState.toString() + " sid=" + this.mId);
            if (iActionRequest != null && iActionRequest.getListener() != null) {
                iActionRequest.getListener().onRequestError(iActionRequest, Const.UploadRetCode.SESSION_STATE_ERROR, this);
            }
            return false;
        }
        if (iActionRequest == null) {
            UploadLog.e(TAG, "Can't send request, request is illegel. sid=" + this.mId);
            return false;
        }
        this.mBaseSessionInfo.taskTypeConfig = taskTypeConfig;
        iActionRequest.setListener(requestListener);
        this.mActionRequests.add(iActionRequest);
        this.mHandler.post(new Runnable() { // from class: com.tencent.upload.network.session.UploadSession.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadSession.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    UploadSession.this.doSendFirstRequest();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        return true;
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public synchronized void setBusy(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.mIsBusy = z16;
        }
    }

    @Override // com.tencent.upload.network.session.IUploadSession
    public boolean open(UploadRoute uploadRoute, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uploadRoute, i3)).booleanValue();
        }
        if (uploadRoute == null) {
            UploadLog.w(CONNECT_TAG, "open route == null");
            return false;
        }
        if (i3 <= 0) {
            i3 = UploadConfiguration.getConnectionTimeout();
        }
        int i16 = i3;
        if (this.mConnection != null) {
            UploadLog.w(CONNECT_TAG, "mConnection != null next to stop and renew");
            this.mConnection.stop();
            this.mConnection = null;
        }
        if (this.mUploadRoute != null) {
            this.mUploadRoute = null;
        }
        NetworkEngine networkEngine = new NetworkEngine(this, this.mId, this.mConnectType);
        this.mConnection = networkEngine;
        if (!networkEngine.start()) {
            UploadLog.w(CONNECT_TAG, "NetworkEngine Start Failed! sid=" + this.mId + " state:" + this.mSessionState.toString());
            return false;
        }
        boolean connectAsync = this.mConnection.connectAsync(uploadRoute.getIp(), uploadRoute.getPort(), null, 0, i16);
        if (connectAsync) {
            this.mUploadRoute = uploadRoute;
            setSessionState(IUploadSession.SessionState.CONNECTING);
        }
        UploadLog.d(CONNECT_TAG, "connectAsync success, sid=" + this.mId + " state:" + this.mSessionState.toString());
        return connectAsync;
    }
}
