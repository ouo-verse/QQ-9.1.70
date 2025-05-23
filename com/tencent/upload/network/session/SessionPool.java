package com.tencent.upload.network.session;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.network.route.RouteFactory;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.network.session.IUploadSession;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.UploadLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes27.dex */
public class SessionPool implements IUploadSessionCallback {
    static IPatchRedirector $redirector_ = null;
    private static final int CLOSE_WAIT_TIME = 240000;
    private static final int MSG_CLOSE_POOL = 110000;
    private static final int MSG_REBUILD_SESSIONS = 110001;
    private static final String TAG = "SessionPool";
    private static final Map<String, String> sSessionIdMap;
    private Const.BusinessType mBusinessType;
    private volatile boolean mClosed;
    private Const.ConnectType mConnectType;
    private UploadRoute mCurrentRoute;
    private List<IUploadSession> mDetectingSession;
    private Const.FileType mFileType;
    private boolean mInited;
    private int mLastErrorCode;
    private PoolStateListener mListener;
    private UploadConfiguration.NetworkStateObserver mNetworkStateObserver;
    private int mPoolInitSize;
    private IUploadRouteStrategy mRouteStrategy;
    private ServerRouteTable mServerRouteTable;
    private BlockingQueue<IUploadSession> mSessionQueue;
    private HandlerThread mThread;
    private Handler mWorkHandler;
    private String oldIp;

    /* loaded from: classes27.dex */
    public interface PoolStateListener {
        void allIpFailed(SessionPool sessionPool, Const.UploadRetCode uploadRetCode);

        boolean hasRemainTasks(String str);

        void onNetWorkConnectFail(SessionPool sessionPool, int i3, String str);

        void onSessionPoolError(SessionPool sessionPool, int i3);

        void onSessionPoolRestore(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes27.dex */
    public static class WorkThreadHandler extends Handler {
        static IPatchRedirector $redirector_;
        private WeakReference<SessionPool> mRef;

        /* renamed from: n, reason: collision with root package name */
        private int f383920n;

        public WorkThreadHandler(SessionPool sessionPool, Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sessionPool, (Object) looper);
            } else {
                this.f383920n = 1;
                this.mRef = new WeakReference<>(sessionPool);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            switch (message.what) {
                case 110000:
                    WeakReference<SessionPool> weakReference = this.mRef;
                    if (weakReference != null && weakReference.get() != null) {
                        UploadLog.d(SessionPool.TAG, "receive msg MSG_CLOSE_POOL");
                        this.mRef.get().close();
                        return;
                    }
                    return;
                case 110001:
                    if (SessionPool.access$300()) {
                        UploadLog.d(SessionPool.TAG, "receive msg MSG_REBUILD_SESSIONS hasNetwork:true");
                        WeakReference<SessionPool> weakReference2 = this.mRef;
                        if (weakReference2 != null && weakReference2.get() != null) {
                            SessionPool sessionPool = this.mRef.get();
                            if (sessionPool.mSessionQueue.size() == 0 && sessionPool.mDetectingSession.size() == 0) {
                                sessionPool.reset();
                            }
                            this.f383920n = 1;
                            return;
                        }
                        UploadLog.e(SessionPool.TAG, "mRef == null");
                        return;
                    }
                    UploadLog.d(SessionPool.TAG, "receive msg MSG_REBUILD_SESSIONS n == " + this.f383920n);
                    if (this.f383920n <= 6) {
                        Message obtainMessage = obtainMessage(110001);
                        this.f383920n = this.f383920n + 1;
                        sendMessageDelayed(obtainMessage, (1 << r0) * 1000);
                        return;
                    }
                    WeakReference<SessionPool> weakReference3 = this.mRef;
                    if (weakReference3 != null && weakReference3.get() != null) {
                        SessionPool sessionPool2 = this.mRef.get();
                        if (sessionPool2.mListener != null) {
                            PoolStateListener poolStateListener = sessionPool2.mListener;
                            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.NETWORK_NOT_AVAILABLE;
                            poolStateListener.onNetWorkConnectFail(sessionPool2, uploadRetCode.getCode(), uploadRetCode.getDesc());
                            return;
                        }
                        return;
                    }
                    UploadLog.w(SessionPool.TAG, "mRef == null or mRef.get() == null");
                    return;
                default:
                    return;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            sSessionIdMap = new HashMap();
        }
    }

    public SessionPool(ServerRouteTable serverRouteTable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) serverRouteTable);
            return;
        }
        this.mClosed = false;
        this.mLastErrorCode = 0;
        this.mServerRouteTable = serverRouteTable;
        this.mBusinessType = serverRouteTable.businessType;
        this.mFileType = serverRouteTable.supportFileType;
        this.mConnectType = serverRouteTable.connectType;
    }

    static /* synthetic */ boolean access$300() {
        return isNetworkAvailable();
    }

    private boolean changeRoute(int i3) {
        this.mClosed = false;
        this.mInited = false;
        UploadLog.d(getTag(), "do change route.");
        cleanSessions();
        if (this.mRouteStrategy == null) {
            this.mRouteStrategy = RouteFactory.createRouteStrategy(this.mServerRouteTable);
        }
        if (isNetworkAvailable()) {
            UploadRoute next = this.mRouteStrategy.next(this.mCurrentRoute, i3);
            if (next == null) {
                UploadLog.d(TAG, "changeRoute get next route null");
                return false;
            }
            createSession(next);
            UploadLog.d(TAG, "changeRoute get next route !");
            return true;
        }
        UploadLog.d(TAG, "changeRoute network is not available return");
        return false;
    }

    private void createSession(UploadRoute uploadRoute) {
        if (uploadRoute == null) {
            UploadLog.d(getTag(), "create session route == null");
        } else {
            createSession(this.mPoolInitSize, uploadRoute);
        }
    }

    public static String getSessionIdByPath(String str) {
        return sSessionIdMap.get(str);
    }

    private void initHandler(Looper looper) {
        if (looper != null) {
            this.mWorkHandler = new WorkThreadHandler(this, looper);
            return;
        }
        throw new IllegalArgumentException("initHandler Exception looper == null !!");
    }

    private void initNetworkListener() {
        UploadConfiguration.NetworkStateObserver networkStateObserver = new UploadConfiguration.NetworkStateObserver() { // from class: com.tencent.upload.network.session.SessionPool.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SessionPool.this);
                }
            }

            @Override // com.tencent.upload.common.UploadConfiguration.NetworkStateObserver
            public void onStateChanged(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                UploadLog.d(SessionPool.TAG, "hasNetwork: " + z16);
                if (!z16) {
                    return;
                }
                if (SessionPool.this.mListener != null && !SessionPool.this.mListener.hasRemainTasks(SessionPool.this.getTableKey())) {
                    return;
                }
                SessionPool.this.mWorkHandler.postDelayed(new Runnable() { // from class: com.tencent.upload.network.session.SessionPool.1.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            SessionPool.this.initSessions();
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                }, 500L);
            }
        };
        this.mNetworkStateObserver = networkStateObserver;
        UploadConfiguration.registerNetworkStateObserver(networkStateObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSessions() {
        String str;
        this.mInited = false;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initSessions... ServerRouteTable:");
        ServerRouteTable serverRouteTable = this.mServerRouteTable;
        if (serverRouteTable != null) {
            str = serverRouteTable.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        sb5.append(" fileType:");
        sb5.append(this.mFileType);
        sb5.append(" BusinessType:");
        sb5.append(this.mBusinessType);
        sb5.append(" mConnectType:");
        sb5.append(this.mConnectType);
        UploadLog.d(TAG, sb5.toString());
        this.mRouteStrategy = RouteFactory.createRouteStrategy(this.mServerRouteTable);
        if (isNetworkAvailable()) {
            createSession(this.mRouteStrategy.reset());
            return;
        }
        UploadLog.d(TAG, "initSessions network is not available !");
        PoolStateListener poolStateListener = this.mListener;
        if (poolStateListener != null) {
            Const.UploadRetCode uploadRetCode = Const.UploadRetCode.NETWORK_NOT_AVAILABLE;
            poolStateListener.onNetWorkConnectFail(this, uploadRetCode.getCode(), uploadRetCode.getDesc());
        }
    }

    private static boolean isInVaildServer(int i3) {
        if (i3 != Const.UploadRetCode.EINPROGRESS.getCode() && i3 != Const.UploadRetCode.EAGAIN.getCode()) {
            return false;
        }
        return true;
    }

    private static boolean isNetworkAvailable() {
        return UploadConfiguration.isNetworkAvailable();
    }

    public static boolean isNetworkUnavailable(int i3) {
        String[] split;
        String networkUnavailableRetCode = UploadConfiguration.getNetworkUnavailableRetCode();
        UploadLog.i(TAG, "check network unavailable code, retCodeList:" + networkUnavailableRetCode + ", targetCode:" + i3);
        if (!TextUtils.isEmpty(networkUnavailableRetCode) && (split = networkUnavailableRetCode.split(",")) != null && split.length > 0) {
            for (String str : split) {
                String trim = str.trim();
                if (!TextUtils.isEmpty(trim) && trim.equals(String.valueOf(i3))) {
                    UploadLog.i(TAG, "check network unavailable: true");
                    return true;
                }
            }
        }
        UploadLog.i(TAG, "check network unavailable: false");
        return false;
    }

    private boolean isSessionValid(IUploadSession iUploadSession) {
        if (iUploadSession != null && iUploadSession.getState() == IUploadSession.SessionState.ESTABLISHED) {
            return true;
        }
        return false;
    }

    private boolean needChangeNextRoute(int i3) {
        String[] split;
        String changeRouteRetCode = UploadConfiguration.getChangeRouteRetCode();
        UploadLog.i(getTag(), "check needChangeNextRoute, retCodeList:" + changeRouteRetCode + ", targetCode:" + i3);
        if (!TextUtils.isEmpty(changeRouteRetCode) && (split = changeRouteRetCode.split(",")) != null && split.length > 0) {
            for (String str : split) {
                String trim = str.trim();
                if (!TextUtils.isEmpty(trim) && trim.equals(String.valueOf(i3))) {
                    UploadLog.i(getTag(), "check needChangeNextRoute: true");
                    return true;
                }
            }
        }
        UploadLog.i(getTag(), "check needChangeNextRoute: false");
        return false;
    }

    public static void recordSessionId(String str, String str2) {
        sSessionIdMap.put(str, str2);
    }

    private void setPoolInitSize() {
        UploadLog.d(TAG, "setPoolInitSize: " + this.mServerRouteTable.sessionSize);
        this.mPoolInitSize = this.mServerRouteTable.sessionSize;
    }

    public void allIpFailed(Const.UploadRetCode uploadRetCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) uploadRetCode);
            return;
        }
        PoolStateListener poolStateListener = this.mListener;
        if (poolStateListener != null) {
            poolStateListener.allIpFailed(this, uploadRetCode);
        }
    }

    public void cleanSessions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        UploadLog.d(getTag(), "cleanSessions --- " + this.mSessionQueue.size() + " detect:" + this.mDetectingSession.size());
        for (IUploadSession iUploadSession : this.mSessionQueue) {
            if (isSessionValid(iUploadSession)) {
                iUploadSession.close();
            }
        }
        this.mSessionQueue.clear();
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            if (this.mClosed) {
                UploadLog.d(TAG, "pool has close");
                return;
            }
            UploadLog.d(TAG, "close session pool");
            this.mClosed = true;
            this.mSessionQueue.clear();
        }
    }

    public int getDetectingSessionSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        List<IUploadSession> list = this.mDetectingSession;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Const.FileType getPoolType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Const.FileType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mFileType;
    }

    public int getSessionQueueSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        BlockingQueue<IUploadSession> blockingQueue = this.mSessionQueue;
        if (blockingQueue != null) {
            return blockingQueue.size();
        }
        return 0;
    }

    public String getTableKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mServerRouteTable.getSessionPoolKey();
    }

    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SessionPool-" + this.mBusinessType + "-" + this.mConnectType + "-" + hashCode();
    }

    public IUploadRouteStrategy getmRouteStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IUploadRouteStrategy) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mRouteStrategy;
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        UploadLog.d(TAG, "SessionPool init.");
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(getTag());
        this.mThread = baseHandlerThread;
        baseHandlerThread.start();
        initHandler(this.mThread.getLooper());
        this.mSessionQueue = new LinkedBlockingQueue(6);
        this.mDetectingSession = new LinkedList();
        initNetworkListener();
        setPoolInitSize();
        initSessions();
    }

    public boolean isReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (!this.mInited && this.mSessionQueue.size() <= 0) {
            return false;
        }
        return true;
    }

    public void notifyIdle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        UploadLog.d(getTag(), "notifyIdle --- mSessionQueue size:" + this.mSessionQueue.size() + " mDetectingSession size:" + this.mDetectingSession.size());
        if (this.mSessionQueue.size() == 0 && this.mDetectingSession.size() == 0) {
            this.mListener.onSessionPoolError(this, Const.UploadRetCode.NO_SESSION.getCode());
        }
    }

    public void offer(IUploadSession iUploadSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iUploadSession);
            return;
        }
        UploadLog.d(getTag(), "offer session --- id:" + iUploadSession.hashCode());
        if (iUploadSession.getState() == IUploadSession.SessionState.ESTABLISHED && !this.mSessionQueue.contains(iUploadSession)) {
            this.mSessionQueue.offer(iUploadSession);
        }
        notifyIdle();
    }

    @Override // com.tencent.upload.network.session.IUploadSessionCallback
    public synchronized void onOpenFailed(IUploadSession iUploadSession, int i3, String str) {
        PoolStateListener poolStateListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, iUploadSession, Integer.valueOf(i3), str);
            return;
        }
        if (iUploadSession != null && this.mDetectingSession.contains(iUploadSession)) {
            UploadLog.i("[connect] " + getTag(), "failed to open session:" + iUploadSession.hashCode());
            this.mDetectingSession.remove(iUploadSession);
            UploadLog.i("[connect] " + getTag(), "onOpenFailed remove from mDetectingSession, current size:" + this.mDetectingSession.size());
            if (iUploadSession.getUploadRoute().isDuplicate(this.mCurrentRoute) && this.mSessionQueue.size() == 0 && this.mDetectingSession.size() == 0) {
                if (isNetworkAvailable()) {
                    UploadRoute next = this.mRouteStrategy.next(this.mCurrentRoute, 0);
                    if (next == null) {
                        UploadLog.i("[connect] " + getTag(), "all ip failed, mCurrentRoute:" + this.mCurrentRoute);
                        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.SOCKET_FD_OVERLOAD;
                        if (i3 == uploadRetCode.getCode()) {
                            allIpFailed(uploadRetCode);
                        } else {
                            allIpFailed(null);
                        }
                        return;
                    }
                    createSession(next, 1);
                } else {
                    UploadLog.w("[connect] " + getTag(), "network is not available !! mDetectingSession.size():" + this.mDetectingSession.size() + " mSessionQueue.size():" + this.mSessionQueue.size());
                    if (this.mDetectingSession.size() == 0 && this.mSessionQueue.size() == 0 && (poolStateListener = this.mListener) != null) {
                        Const.UploadRetCode uploadRetCode2 = Const.UploadRetCode.NETWORK_NOT_AVAILABLE;
                        poolStateListener.onNetWorkConnectFail(this, uploadRetCode2.getCode(), uploadRetCode2.getDesc());
                    }
                }
            }
        }
    }

    @Override // com.tencent.upload.network.session.IUploadSessionCallback
    public synchronized void onOpenSucceed(IUploadSession iUploadSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) iUploadSession);
            return;
        }
        if (iUploadSession != null && this.mDetectingSession.contains(iUploadSession)) {
            notify();
            UploadLog.i("[connect] " + getTag(), "session is ready --- id:" + iUploadSession.hashCode());
            this.mDetectingSession.remove(iUploadSession);
            this.mSessionQueue.offer(iUploadSession);
            if (this.mSessionQueue.size() == 1 && !this.mInited) {
                UploadLog.i("[connect] " + getTag(), "sessionPool is inited now !");
                this.mInited = true;
                this.mListener.onSessionPoolRestore(getTableKey());
            } else if (this.mSessionQueue.size() > 0) {
                this.mInited = true;
            }
        }
    }

    @Override // com.tencent.upload.network.session.IUploadSessionCallback
    public void onSessionClosed(IUploadSession iUploadSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) iUploadSession);
            return;
        }
        if (iUploadSession == null) {
            return;
        }
        UploadLog.w("[connect] " + getTag(), "onSessionClosed ! Session:" + iUploadSession.hashCode());
        this.mSessionQueue.remove(iUploadSession);
        notifyIdle();
    }

    @Override // com.tencent.upload.network.session.IUploadSessionCallback
    public synchronized void onSessionError(IUploadSession iUploadSession, int i3, String str) {
        PoolStateListener poolStateListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, iUploadSession, Integer.valueOf(i3), str);
            return;
        }
        if (iUploadSession == null) {
            return;
        }
        boolean isNetworkAvailable = isNetworkAvailable();
        this.mLastErrorCode = i3;
        UploadLog.w("[connect] " + getTag(), "onSessionError... Session:" + iUploadSession.hashCode() + " errCode=" + i3 + " errMsg=" + str + " networkAvailable=" + isNetworkAvailable + " currentRoute=" + this.mCurrentRoute + " sessionRoute=" + iUploadSession.getUploadRoute());
        this.mSessionQueue.remove(iUploadSession);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[connect] ");
        sb5.append(getTag());
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append("remove session ");
        sb7.append(iUploadSession.hashCode());
        sb7.append(" queue size: ");
        sb7.append(this.mSessionQueue.size());
        UploadLog.w(sb6, sb7.toString());
        PoolStateListener poolStateListener2 = this.mListener;
        if (poolStateListener2 != null && !poolStateListener2.hasRemainTasks(getTableKey())) {
            UploadLog.w("[connect] " + getTag(), "onSessionError... no hasRemainTask ");
            iUploadSession.close();
            return;
        }
        if (needChangeNextRoute(i3)) {
            UploadLog.w("[connect] " + getTag(), "[dochangeRoute] errCode=" + i3 + " errMsg=" + str + " currentRoute=" + iUploadSession.getUploadRoute().toString());
            if (!isNetworkAvailable()) {
                allIpFailed(Const.UploadRetCode.NETWORK_NOT_AVAILABLE);
                return;
            }
            if (changeRoute(6)) {
                UploadLog.i("[connect] " + getTag(), "changeRoute success");
            } else if (isNetworkAvailable()) {
                UploadLog.i("[connect] " + getTag(), "changeRoute failed, allIpFailed");
                allIpFailed(null);
            } else {
                allIpFailed(Const.UploadRetCode.NETWORK_NOT_AVAILABLE);
            }
        } else {
            if (i3 != Const.UploadRetCode.EINPROGRESS.getCode() && i3 != Const.UploadRetCode.EAGAIN.getCode() && i3 != Const.UploadRetCode.EHOSTUNREACH.getCode() && i3 != Const.UploadRetCode.ENETUNREACH.getCode() && i3 != Const.UploadRetCode.ENETDOWN.getCode() && i3 != Const.UploadRetCode.ETIMEDOUT.getCode() && i3 != Const.UploadRetCode.ECONNABORTED.getCode() && i3 != 30100 && i3 != Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode()) {
                UploadLog.i("[connect] " + getTag(), "reconnect session: " + iUploadSession.hashCode());
                iUploadSession.close();
                iUploadSession.open(iUploadSession.getUploadRoute());
                this.mDetectingSession.add(iUploadSession);
            }
            UploadLog.w("[connect] " + getTag(), "errCode=" + i3 + " \u7f51\u7edc\u5f02\u5e38 !");
            if (this.mSessionQueue.size() == 0 && (poolStateListener = this.mListener) != null) {
                poolStateListener.onNetWorkConnectFail(this, i3, str);
            }
        }
    }

    public synchronized IUploadSession poll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IUploadSession) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.mSessionQueue.size() == 0 || this.mSessionQueue.peek() == null || this.mSessionQueue.peek().isExpired()) {
            if (this.mSessionQueue.size() > 0) {
                while (true) {
                    if (this.mSessionQueue.size() <= 0) {
                        break;
                    }
                    IUploadSession poll = this.mSessionQueue.poll();
                    if (poll == null) {
                        UploadLog.d(getTag(), "All session expired !!!");
                        break;
                    }
                    if (poll.isExpired()) {
                        poll.close();
                        this.mSessionQueue.remove(poll);
                    } else {
                        UploadLog.d(getTag(), "get idle session:" + poll.hashCode());
                        return poll;
                    }
                }
            } else {
                UploadLog.d(getTag(), "queue size == 0");
            }
            UploadLog.d(getTag(), "create one session !");
            createSession(1, this.mCurrentRoute);
            UploadLog.d(getTag(), "wait 30s start...");
            try {
                wait(30000L);
            } catch (InterruptedException e16) {
                UploadLog.d(TAG, "poll exception " + e16);
            }
            UploadLog.d(getTag(), "wait 30s end...");
        }
        return this.mSessionQueue.poll();
    }

    public void rebuildSessions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        UploadLog.d(TAG, getTag() + " rebuildSessions");
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.removeMessages(110001);
            Handler handler2 = this.mWorkHandler;
            handler2.sendMessageDelayed(handler2.obtainMessage(110001), 1000L);
        }
    }

    public void registerListener(PoolStateListener poolStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) poolStateListener);
        } else {
            this.mListener = poolStateListener;
        }
    }

    public void removeCloseTimer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.removeMessages(110000);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (isInVaildServer(this.mLastErrorCode) && changeRoute(0)) {
            return;
        }
        this.mClosed = false;
        cleanSessions();
        UploadLog.d(getTag(), "reset session pool");
        initSessions();
    }

    public void saveRoute(UploadRoute uploadRoute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) uploadRoute);
            return;
        }
        this.mLastErrorCode = 0;
        if (TextUtils.isEmpty(this.oldIp) || !uploadRoute.getIp().equalsIgnoreCase(this.oldIp)) {
            UploadLog.d(getTag(), "save recent route: " + uploadRoute);
            this.oldIp = uploadRoute.getIp();
            IUploadRouteStrategy iUploadRouteStrategy = this.mRouteStrategy;
            if (iUploadRouteStrategy != null) {
                iUploadRouteStrategy.save(uploadRoute);
            }
        }
    }

    public void setCloseTimer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        UploadLog.d(TAG, getTag() + " setCloseTimer");
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.removeMessages(110000);
            Handler handler2 = this.mWorkHandler;
            handler2.sendMessageDelayed(handler2.obtainMessage(110000), 240000L);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer("SessionPool{\n");
        stringBuffer.append("mPoolInitSize=");
        stringBuffer.append(this.mPoolInitSize);
        stringBuffer.append('\n');
        stringBuffer.append(", mServerRouteTable=");
        stringBuffer.append(this.mServerRouteTable);
        stringBuffer.append('\n');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public void unregisterListener(PoolStateListener poolStateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) poolStateListener);
        } else if (this.mListener == poolStateListener) {
            this.mListener = null;
        }
    }

    private void createSession(UploadRoute uploadRoute, int i3) {
        if (uploadRoute == null) {
            UploadLog.d(getTag(), "create session route == num");
        } else {
            createSession(i3, uploadRoute);
        }
    }

    private synchronized void createSession(int i3, UploadRoute uploadRoute) {
        UploadLog.d(getTag(), "createSession num: " + i3 + " route:" + uploadRoute);
        this.mCurrentRoute = uploadRoute.m286clone();
        for (int i16 = 0; i16 < i3; i16++) {
            UploadSession uploadSession = new UploadSession(this.mThread.getLooper(), this, this.mBusinessType, this.mConnectType);
            if (uploadSession.open(uploadRoute)) {
                UploadLog.d(getTag(), "createSession open success !! id:" + uploadSession.hashCode());
                this.mDetectingSession.add(uploadSession);
                UploadLog.d(getTag(), "createSession... detect size:" + this.mDetectingSession.size() + " mSessionQueue size:" + this.mSessionQueue.size());
            } else {
                UploadLog.e(getTag(), "createSession open fail !!");
                uploadSession.close();
            }
        }
    }

    public void reset(UploadRoute uploadRoute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) uploadRoute);
            return;
        }
        cleanSessions();
        this.mClosed = false;
        this.mInited = false;
        createSession(this.mPoolInitSize, uploadRoute);
        UploadLog.d(getTag(), "reset session pool with redirect route: " + uploadRoute);
    }
}
