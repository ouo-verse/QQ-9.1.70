package com.tencent.mobileqq.highway.conn;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.IInject;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.ipv6.HappyEyeballsRace;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.highway.utils.HwStatisticMgr;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ConnManager implements IHwManager, IConnectionListener {
    static IPatchRedirector $redirector_ = null;
    private static final int IP_TIMEOUT_FOR_HTTP_PATCH_MAX = 3;
    public static AtomicInteger connSeq;
    private long _connStartTime;
    private AtomicBoolean bUseHttpPatch;
    private int connCount;
    public ArrayList<ConnReportInfo> connInfoList;
    public volatile int connectedConn;
    public ConcurrentHashMap<Integer, IConnection> connections;
    public HwEngine engine;
    public ConcurrentHashMap<Integer, Runnable> heartBreaks;
    private int iHttpPatchConnId;
    public EndPoint lastEndPoint;
    private HappyEyeballsRace mHERace;
    public boolean mHasIpv6List;
    private ConcurrentHashMap<String, String> mIpTimeOutCounter;
    private List<EndPoint> mReportEndPoint;
    private int mReportFailCnt;
    private boolean mReportHasStart;
    private long mReportStart;
    private int mReportSuccCnt;
    public volatile AtomicLong vConnCost;
    public volatile int vConnErrCode;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9552);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            connSeq = new AtomicInteger(1);
        }
    }

    public ConnManager(HwEngine hwEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hwEngine);
            return;
        }
        this.connections = new ConcurrentHashMap<>();
        this.heartBreaks = new ConcurrentHashMap<>();
        this.connInfoList = new ArrayList<>();
        this.connectedConn = 0;
        this.vConnErrCode = 0;
        this.vConnCost = new AtomicLong(-1L);
        this._connStartTime = -1L;
        this.lastEndPoint = null;
        this.iHttpPatchConnId = -1;
        this.bUseHttpPatch = new AtomicBoolean(false);
        this.mIpTimeOutCounter = new ConcurrentHashMap<>();
        this.mHERace = new HappyEyeballsRace();
        this.mReportHasStart = false;
        this.mReportFailCnt = 0;
        this.mReportSuccCnt = 0;
        this.connCount = -1;
        this.mReportStart = -1L;
        this.engine = hwEngine;
    }

    private void createMultiConn(boolean z16, int i3, int i16) {
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "createMultiConn\uff0c isIpv6 = " + z16 + ", maxConnNum = " + i3 + ", netType = " + i16);
        while (this.connections.size() < i3 && openNewConnection(i16, false, z16) != null) {
        }
    }

    private void createNewConnectionIfNeed(int i3, boolean z16) {
        try {
            int i16 = (int) this.engine.getCurrentConfig().curConnNum;
            if (!z16 && i3 <= 1) {
                i16 = 1;
            }
            if (this.bUseHttpPatch.get()) {
                i16++;
            }
            synchronized (this.connections) {
                while (this.connections.size() < i16) {
                    int netType = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
                    if (netType == 0) {
                        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "CreateNewConnectionIfNeed : No network in networkCenter : ConnSize:" + this.connections.size() + " currentRequests:" + i3 + " maxConnNum:" + i16);
                        HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
                        this.engine.mRequestWorker.sendConnectRequest(5000L, false);
                        return;
                    }
                    if (this.mHERace.mIsRacing) {
                        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "CreateNewConnectionIfNeed : is racing , return. ");
                        return;
                    }
                    boolean isIpv6SwitchOpen = isIpv6SwitchOpen(this.engine);
                    int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
                    boolean hasIpv6List = hasIpv6List();
                    this.mHasIpv6List = hasIpv6List;
                    BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "CreateNewConnectionIfNeed : ipv6SwitchOpen = " + isIpv6SwitchOpen + " , netStack = " + activeNetIpFamily + " , hasIpv6List = " + hasIpv6List);
                    if (activeNetIpFamily == 3) {
                        if (this.connections.size() == 0 && isIpv6SwitchOpen && hasIpv6List) {
                            startRacing(netType);
                        } else {
                            createMultiConn(this.mHERace.mIsIpv6Fast, i16, netType);
                        }
                    } else if (activeNetIpFamily == 2) {
                        createMultiConn(true, i16, netType);
                    } else {
                        createMultiConn(false, i16, netType);
                    }
                }
            }
        } catch (Exception e16) {
            BdhLogUtil.LogException(BdhLogUtil.LogTag.Tag_Conn, "Create Conn Error.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createRacingConn(int i3, boolean z16, boolean z17) {
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "createRacingConn\uff0cisIpv6 =  " + z17);
        IConnection openNewConnection = openNewConnection(i3, z16, z17);
        if (openNewConnection != null) {
            synchronized (this.mHERace) {
                this.mHERace.mConnList.add(openNewConnection);
            }
        }
    }

    private boolean hasIpv6List() {
        ConfigManager configManager;
        HwEngine hwEngine = this.engine;
        if (hwEngine != null && (configManager = ConfigManager.getInstance(hwEngine.getAppContext(), this.engine)) != null) {
            return configManager.hasIpv6List(this.engine.getAppContext());
        }
        return false;
    }

    private IConnection openNewConnection(int i3, boolean z16, boolean z17) {
        IConnection iConnection;
        int i16;
        ConfigManager configManager = ConfigManager.getInstance(this.engine.getAppContext(), this.engine);
        HwEngine hwEngine = this.engine;
        IInject iInject = hwEngine.injectHelper;
        if (iInject == null) {
            return null;
        }
        EndPoint nextSrvAddr = configManager.getNextSrvAddr(hwEngine.getAppContext(), iInject.getRuntime(), this.engine.currentUin, z17);
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "openNewConnection, isIpv6 = " + z17 + ",ep = " + nextSrvAddr.toString());
        if (this.connectedConn <= 0 && this._connStartTime == -1) {
            this._connStartTime = SystemClock.uptimeMillis();
        }
        synchronized (this.connections) {
            this.connections.size();
        }
        this.lastEndPoint = nextSrvAddr;
        reportChannelStart(nextSrvAddr);
        if (!z16 && nextSrvAddr.protoType == 1) {
            int incrementAndGet = connSeq.incrementAndGet();
            if (i3 == 1) {
                i16 = 10000;
            } else {
                i16 = 20000;
            }
            iConnection = new TcpConnection(this, incrementAndGet, nextSrvAddr, i16, 30000, z17);
        } else {
            HttpConnection httpConnection = new HttpConnection(this, connSeq.incrementAndGet(), nextSrvAddr, z17);
            if (z16) {
                this.iHttpPatchConnId = httpConnection.getConnId();
                BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "OpenNewConnection For Http Patch : ID[" + this.iHttpPatchConnId + "]");
            }
            iConnection = httpConnection;
        }
        iConnection.setConnectListener(this);
        if (!iConnection.connect()) {
            return null;
        }
        this.connections.put(Integer.valueOf(iConnection.getConnId()), iConnection);
        return iConnection;
    }

    private void startRacing(int i3) {
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "startRacing . ");
        boolean z16 = true;
        this.mHERace.mIsRacing = true;
        if (!isIpv6SwitchOpen(this.engine) || !Ipv6Config.getFlags().isIpv6BDHFirst()) {
            z16 = false;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "startRacing\uff0cipv6First =  " + z16);
        createRacingConn(i3, false, z16);
        this.mHERace.mRacingRunnable = new Runnable(i3, z16) { // from class: com.tencent.mobileqq.highway.conn.ConnManager.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$ipv6First;
            final /* synthetic */ int val$netType;

            {
                this.val$netType = i3;
                this.val$ipv6First = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ConnManager.this, Integer.valueOf(i3), Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ConnManager.this.createRacingConn(this.val$netType, false, !this.val$ipv6First);
                    ConnManager.this.mHERace.mRacingRunnable = null;
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        };
        this.engine.mRequestWorker.mRequestHandler.postDelayed(this.mHERace.mRacingRunnable, (long) Ipv6Config.getFlags().mConnAttemptDelay);
    }

    public long getConnCost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return this.vConnCost.getAndSet(-1L);
    }

    public int getCurrentConnNum() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        synchronized (this.connections) {
            size = this.connections.size();
        }
        return size;
    }

    public boolean hasNet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        HwNetworkCenter hwNetworkCenter = HwNetworkCenter.getInstance(this.engine.getAppContext());
        hwNetworkCenter.updateNetInfo(this.engine.getAppContext());
        if (hwNetworkCenter.getNetType() != 0) {
            return true;
        }
        return false;
    }

    public void increaseDataFlowDw(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, j3);
            return;
        }
        int netType = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
        if (netType == 1) {
            this.engine.dwFlow_Wifi.addAndGet(j3);
        } else if (netType != 0) {
            this.engine.dwFlow_Xg.addAndGet(j3);
        }
    }

    public void increaseDataFlowUp(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, j3);
            return;
        }
        int netType = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
        if (netType == 1) {
            this.engine.upFlow_Wifi.addAndGet(j3);
        } else if (netType != 0) {
            this.engine.upFlow_Xg.addAndGet(j3);
        }
    }

    public boolean isIpv6Fast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.mHERace.mIsIpv6Fast;
    }

    public boolean isIpv6SwitchOpen(HwEngine hwEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) hwEngine)).booleanValue();
        }
        if (hwEngine != null && hwEngine.ipv6Switch) {
            BdhLogUtil.LogEvent("E", "engine.ipv6Switch is true");
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnectionListener
    public void onConnect(boolean z16, int i3, IConnection iConnection, EndPoint endPoint, int i16, ConnReportInfo connReportInfo) {
        ConfigManager configManager;
        long j3;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Integer.valueOf(i3), iConnection, endPoint, Integer.valueOf(i16), connReportInfo);
            return;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "ConnManager.onConnect, isSuccess = " + z16 + ", errno = " + i16);
        Context appContext = this.engine.getAppContext();
        if (appContext != null) {
            configManager = ConfigManager.getInstance(appContext, this.engine);
        } else {
            configManager = null;
        }
        synchronized (this.connections) {
            this.mHERace.doOnConect(z16, iConnection, this.engine);
        }
        if (z16) {
            this.connectedConn++;
            this.engine.mRequestWorker.onConnConnected(i3);
            if (iConnection.getProtoType() != 2) {
                this.engine.mRequestWorker.sendHeartBreak(i3, false, false, 0);
            }
            if (this._connStartTime >= 0) {
                long uptimeMillis = SystemClock.uptimeMillis() - this._connStartTime;
                this._connStartTime = -1L;
                this.vConnCost.compareAndSet(-1L, uptimeMillis);
            }
        } else {
            this.connections.remove(Integer.valueOf(iConnection.getConnId()));
            if (configManager != null) {
                j3 = 0;
                z17 = false;
                configManager.onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.currentUin, endPoint.host, i16, iConnection.isIpv6());
            } else {
                j3 = 0;
                z17 = false;
            }
            if (i16 == 3) {
                this.engine.mRequestWorker.sendConnectRequest(5000L, z17);
            } else {
                this.engine.mRequestWorker.sendConnectRequest(j3, z17);
            }
        }
        if (configManager != null) {
            configManager.onSvrConnFinish(endPoint, i16);
        }
        this.vConnErrCode = i16;
        reportConnectResult(endPoint, z16, i16, connReportInfo.connElapseTime);
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "OnConnect :\u3000connId:" + i3 + " Size:" + this.connections.size() + " errno:" + i16);
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnectionListener
    public void onConnectionIdle(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.engine.mRequestWorker.sendHeartBreak(i3, false, z16, 60000);
        }
    }

    public void onDecodeSucessfully(List<HwResponse> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) list);
        } else {
            this.engine.mRequestWorker.onReceiveResp(list);
        }
    }

    @Override // com.tencent.mobileqq.highway.IHwManager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnectionListener
    public void onDisConnect(int i3, IConnection iConnection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) iConnection);
            return;
        }
        HwNetworkCenter.getInstance(this.engine.getAppContext()).updateNetInfo(this.engine.getAppContext());
        IConnection remove = this.connections.remove(Integer.valueOf(iConnection.getConnId()));
        if (remove != null) {
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "OnDisConnect, mHERace.doOnConnFail.");
            this.mHERace.doOnConnFail(remove);
            this.connectedConn--;
            this.engine.mRequestWorker.onConnClose(i3);
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "OnDisConnect :\u3000connId:" + i3 + " Size:" + this.connections.size());
        }
        if (iConnection.getConnId() == this.iHttpPatchConnId) {
            this.iHttpPatchConnId = -1;
            this.bUseHttpPatch.set(false);
        }
    }

    public void onHeartBreakResp(int i3, EndPoint endPoint, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), endPoint, Boolean.valueOf(z16));
            return;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onHeartBreakResp : connId = " + i3 + ", isUrgent = " + z16);
        IConnection iConnection = this.connections.get(Integer.valueOf(i3));
        if (iConnection != null && z16) {
            iConnection.setUrgentFlag(false);
            this.heartBreaks.remove(Integer.valueOf(i3));
        }
    }

    public void onIPV6IllegalUserErr(int i3) {
        ConfigManager configManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        IConnection iConnection = this.connections.get(Integer.valueOf(i3));
        if (iConnection != null) {
            EndPoint endPoint = iConnection.getEndPoint();
            iConnection.disConnect();
            Context appContext = this.engine.getAppContext();
            if (endPoint != null && appContext != null && (configManager = ConfigManager.getInstance(appContext, this.engine)) != null) {
                configManager.clearIpv6Cfg(appContext);
            }
        }
        createNewConnectionIfNeed(1, false);
    }

    @Override // com.tencent.mobileqq.highway.IHwManager
    public void onInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.highway.conn.IConnectionListener
    public void onRecvInvalidData(EndPoint endPoint, IConnection iConnection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) endPoint, (Object) iConnection);
            return;
        }
        Context appContext = this.engine.getAppContext();
        if (endPoint != null && appContext != null) {
            ConfigManager configManager = ConfigManager.getInstance(appContext, this.engine);
            if (configManager != null) {
                configManager.onSrvAddrUnavailable(appContext, this.engine.currentUin, endPoint.host, 15, iConnection.isIpv6());
            }
            BdhLogUtil.LogEvent("P", "receive the invalid data,start weak net probe! ip:" + endPoint.host);
        }
    }

    public void onRequestTimeOut(int i3) {
        ConfigManager configManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onRequestTimeOut : connId:" + i3);
        IConnection iConnection = this.connections.get(Integer.valueOf(i3));
        if (iConnection != null) {
            EndPoint endPoint = iConnection.getEndPoint();
            if (iConnection.getProtoType() == 1) {
                iConnection.setUrgentFlag(true);
                ConcurrentHashMap<String, String> concurrentHashMap = this.mIpTimeOutCounter;
                String str = endPoint.host;
                concurrentHashMap.put(str, str);
                if (this.bUseHttpPatch.compareAndSet(false, true) && this.mIpTimeOutCounter.size() >= 3) {
                    this.mIpTimeOutCounter.clear();
                    int netType = HwNetworkCenter.getInstance(this.engine.getAppContext()).getNetType();
                    BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onRequestTimeOut : About to create a http patch. netType:" + netType);
                    if (netType == 1) {
                        int i16 = (int) this.engine.getCurrentConfig().curConnNum;
                        synchronized (this.connections) {
                            if (this.connections.size() < i16) {
                                openNewConnection(1, true, iConnection.isIpv6());
                            }
                        }
                        return;
                    }
                    this.bUseHttpPatch.set(false);
                    return;
                }
                return;
            }
            if (iConnection.getProtoType() == 2) {
                this.mIpTimeOutCounter.clear();
                Context appContext = this.engine.getAppContext();
                if (endPoint != null && appContext != null && (configManager = ConfigManager.getInstance(appContext, this.engine)) != null) {
                    configManager.onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.currentUin, endPoint.host, 7, iConnection.isIpv6());
                }
                iConnection.disConnect();
                createNewConnectionIfNeed(1, false);
            }
        }
    }

    public void onRequestWriteTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onRequestWriteTimeout : connId:" + i3);
        IConnection iConnection = this.connections.get(Integer.valueOf(i3));
        if (iConnection != null) {
            iConnection.disConnect();
        }
    }

    public void onUrgentHeartBreakTimeout(int i3) {
        ConfigManager configManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Conn, "onUrgentHeartBreakTimeout : connId:" + i3);
        IConnection iConnection = this.connections.get(Integer.valueOf(i3));
        if (iConnection != null) {
            EndPoint endPoint = iConnection.getEndPoint();
            iConnection.disConnect();
            Context appContext = this.engine.getAppContext();
            if (endPoint != null && appContext != null && (configManager = ConfigManager.getInstance(appContext, this.engine)) != null) {
                configManager.onSrvAddrUnavailable(this.engine.getAppContext(), this.engine.currentUin, endPoint.host, 7, iConnection.isIpv6());
            }
        }
        createNewConnectionIfNeed(1, false);
    }

    public HwRequest pullNextRequest(IConnection iConnection, boolean z16, long j3, long j16, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HwRequest) iPatchRedirector.redirect((short) 6, this, iConnection, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
        }
        if (z16) {
            i16 = 0;
        } else {
            i16 = 2;
        }
        HwRequest maxPriorityRequest = this.engine.mRequestWorker.getMaxPriorityRequest(iConnection.getConnId(), i16, j3, j16, i3);
        if (maxPriorityRequest == null && iConnection.getProtoType() == 2 && this.engine.mTransWorker.getTransactionNum() == 0) {
            iConnection.disConnect();
        }
        return maxPriorityRequest;
    }

    public void reportChannelStart(EndPoint endPoint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) endPoint);
            return;
        }
        int i3 = this.connCount + 1;
        this.connCount = i3;
        endPoint.connIndex = i3;
        if (this.mReportHasStart) {
            return;
        }
        this.mReportStart = SystemClock.uptimeMillis();
        this.mReportHasStart = true;
        this.mReportFailCnt = 0;
        this.mReportSuccCnt = 0;
        this.mReportEndPoint = Collections.synchronizedList(new ArrayList());
    }

    public void reportChannelStop(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        if (!this.mReportHasStart) {
            return;
        }
        this.mReportHasStart = false;
        if (z16) {
            this.connCount = -1;
        }
        HwStatisticMgr.doReportConnection(HwEngine.appId, this.engine.currentUin, z16, this.mReportFailCnt + this.mReportSuccCnt, this.mReportSuccCnt, this.mReportFailCnt, this.mReportEndPoint, SystemClock.uptimeMillis() - this.mReportStart);
    }

    public void reportConnectResult(EndPoint endPoint, boolean z16, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, endPoint, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        endPoint.connResult = i3;
        endPoint.cost = j3;
        if (z16) {
            this.mReportSuccCnt++;
        } else {
            this.mReportFailCnt++;
        }
        this.mReportEndPoint.add(endPoint);
        if (z16 || this.mReportFailCnt >= 8) {
            reportChannelStop(z16);
        }
    }

    public void wakeupConnectionToWrite(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        createNewConnectionIfNeed(i3, z16);
        synchronized (this.connections) {
            for (IConnection iConnection : this.connections.values()) {
                if (iConnection.isWritable()) {
                    iConnection.wakeupChannel();
                }
            }
        }
    }
}
