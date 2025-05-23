package com.tencent.mobileqq.highway;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.api.HighwayConfBean;
import com.tencent.mobileqq.highway.api.RequestOps;
import com.tencent.mobileqq.highway.api.TransactionOps;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.kernel.AbstractKernelEngine;
import com.tencent.mobileqq.highway.kernel.KernelEngineClient;
import com.tencent.mobileqq.highway.kernel.KernelEngineServer;
import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.segment.RequestWorker;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.transaction.TransactionWorker;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HwEngine implements TransactionOps, RequestOps, INetInfoHandler {
    static IPatchRedirector $redirector_ = null;
    public static final boolean ISDEBUG = true;
    public static int appId;
    public static int localeId;
    public String currentUin;
    public AtomicLong dwFlow_Wifi;
    public AtomicLong dwFlow_Xg;
    public IInject injectHelper;
    public boolean ipv6Switch;
    public AbstractKernelEngine kernelEngine;
    private SparseArray<HwNetSegConf> mBuzSegConfigs;
    public ConnManager mConnManager;
    private Context mContext;
    public RequestWorker mRequestWorker;
    private HwNetSegConf mSegConfig;
    public TransactionWorker mTransWorker;
    public WeakNetLearner mWeakNetLearner;
    private WeakNetCallback probeEngineCallBack;
    public AtomicLong upFlow_Wifi;
    public AtomicLong upFlow_Xg;

    public HwEngine(Context context, String str, int i3, IInject iInject, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Integer.valueOf(i3), iInject, Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.upFlow_Wifi = new AtomicLong(0L);
        this.dwFlow_Wifi = new AtomicLong(0L);
        this.upFlow_Xg = new AtomicLong(0L);
        this.dwFlow_Xg = new AtomicLong(0L);
        this.mSegConfig = null;
        this.mBuzSegConfigs = null;
        this.probeEngineCallBack = new WeakNetCallback() { // from class: com.tencent.mobileqq.highway.HwEngine.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HwEngine.this);
                }
            }

            @Override // com.tencent.mobileqq.highway.netprobe.WeakNetCallback
            public void onResultOverflow(HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) hashMap);
                    return;
                }
                if (hashMap != null && !hashMap.isEmpty()) {
                    BdhLogUtil.LogEvent("P", "probe result upload to dengta, count " + hashMap.size());
                    RdmReq rdmReq = new RdmReq();
                    rdmReq.isMerge = false;
                    rdmReq.isRealTime = true;
                    rdmReq.isSucceed = true;
                    rdmReq.eventName = WeakNetLearner.REPORT_TAG_NAME;
                    rdmReq.elapse = 0L;
                    rdmReq.size = 0L;
                    rdmReq.params = hashMap;
                    try {
                        ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq);
                        rdmReportMsg.setAppId(HwEngine.appId);
                        rdmReportMsg.setTimeout(30000L);
                        MsfServiceSdk.get().sendMsg(rdmReportMsg);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        BdhLogUtil.LogException("P", "upload report has exception ", e16);
                    }
                }
            }
        };
        this.injectHelper = iInject;
        this.mContext = context;
        appId = i3;
        localeId = i16;
        this.currentUin = str;
        this.ipv6Switch = z16;
        if (MobileQQ.sProcessId == 1) {
            this.kernelEngine = new KernelEngineServer(iInject);
        } else {
            this.kernelEngine = new KernelEngineClient(iInject);
        }
        initHwEngine();
    }

    private void dumpEngineInfo() {
        BdhLogUtil.LogEvent("E", "dumpEngineInfo<-- : transNum:" + this.mTransWorker.getTransactionNum() + " connNum:" + this.mConnManager.getCurrentConnNum());
    }

    private void initHwEngine() {
        this.mConnManager = new ConnManager(this);
        this.mRequestWorker = new RequestWorker(this);
        this.mTransWorker = new TransactionWorker(this);
        this.mWeakNetLearner = new WeakNetLearner(this.mContext, this.probeEngineCallBack);
        this.mConnManager.onInit();
        this.mRequestWorker.onInit();
        this.mTransWorker.onInit();
        HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
        HighwayConfBean.init(this.injectHelper);
    }

    @Override // com.tencent.mobileqq.highway.api.RequestOps
    public void SubmitAckRequest(RequestAck requestAck) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) requestAck);
        } else {
            if (this.kernelEngine.isAllUseKernel()) {
                return;
            }
            this.mRequestWorker.sendAckRequest(requestAck);
        }
    }

    @Override // com.tencent.mobileqq.highway.api.RequestOps
    public void cancelAckRequest(RequestAck requestAck) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) requestAck);
        } else {
            if (this.kernelEngine.isAllUseKernel()) {
                return;
            }
            this.mRequestWorker.cancelAckRequest(requestAck);
        }
    }

    @Override // com.tencent.mobileqq.highway.api.TransactionOps
    public void cancelTransactionTask(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) transaction);
        } else if (transaction.isUseKernel) {
            this.kernelEngine.cancelTransactionTask(transaction);
        } else {
            this.mTransWorker.cancelTransaction(transaction);
        }
    }

    public void closeEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        BdhLogUtil.LogEvent("E", "Close Engine.");
        this.mTransWorker.onDestroy();
        this.mRequestWorker.onDestroy();
        this.mConnManager.onDestroy();
        this.mWeakNetLearner.onDestroy();
        HwServlet.resetStartMask();
        this.mContext = null;
        this.kernelEngine.onDestroy();
    }

    public Context getAppContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mContext;
    }

    public SparseArray<HwNetSegConf> getCurrentBuzConfigs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SparseArray) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        SparseArray<HwNetSegConf> sparseArray = this.mBuzSegConfigs;
        if (sparseArray == null) {
            SparseArray<HwNetSegConf> allBuzSegConfs = ConfigManager.getInstance(getAppContext(), this).getAllBuzSegConfs(getAppContext());
            this.mBuzSegConfigs = allBuzSegConfs;
            return allBuzSegConfs;
        }
        return sparseArray;
    }

    public HwNetSegConf getCurrentConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (HwNetSegConf) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        HwNetSegConf hwNetSegConf = this.mSegConfig;
        if (hwNetSegConf == null) {
            HwNetSegConf netSegConf = ConfigManager.getInstance(getAppContext(), this).getNetSegConf(getAppContext());
            this.mSegConfig = netSegConf;
            return netSegConf;
        }
        return hwNetSegConf;
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        BdhLogUtil.LogEvent("N", "NetChanged_ onNetMobile2None");
        this.mSegConfig = null;
        this.mBuzSegConfigs = null;
        HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
        this.mRequestWorker.onNetworkChanged(false);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        BdhLogUtil.LogEvent("N", "NetChanged_ onNetMobile2Wifi");
        this.mSegConfig = null;
        this.mBuzSegConfigs = null;
        HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
        this.mRequestWorker.onNetworkChanged(true);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        BdhLogUtil.LogEvent("N", "NetChanged_ onNetNone2Mobile");
        this.mSegConfig = null;
        this.mBuzSegConfigs = null;
        HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
        this.mRequestWorker.onNetworkChanged(true);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            return;
        }
        BdhLogUtil.LogEvent("N", "NetChanged_ onNetNone2Wifi");
        this.mSegConfig = null;
        this.mBuzSegConfigs = null;
        HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
        this.mRequestWorker.onNetworkChanged(true);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        BdhLogUtil.LogEvent("N", "NetChanged_ onNetWifi2Mobile");
        this.mSegConfig = null;
        this.mBuzSegConfigs = null;
        HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
        this.mRequestWorker.onNetworkChanged(true);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        BdhLogUtil.LogEvent("N", "NetChanged_ onNetWifi2None");
        this.mSegConfig = null;
        this.mBuzSegConfigs = null;
        HwNetworkCenter.getInstance(this.mContext).updateNetInfo(this.mContext);
        this.mRequestWorker.onNetworkChanged(false);
    }

    @Override // com.tencent.mobileqq.highway.api.TransactionOps
    public void preConnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (this.kernelEngine.isAllUseKernel()) {
                return;
            }
            BdhLogUtil.LogEvent("E", "preConnect.");
            this.mRequestWorker.sendConnectRequest(0L, true);
        }
    }

    @Override // com.tencent.mobileqq.highway.api.TransactionOps
    @Deprecated
    public void resumeTransactionTask(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) transaction);
        } else if (transaction.isUseKernel) {
            this.kernelEngine.resumeTransactionTask(transaction);
        } else {
            this.mTransWorker.resumeTransaction(transaction);
        }
    }

    @Override // com.tencent.mobileqq.highway.api.TransactionOps
    @Deprecated
    public void stopTransactionTask(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) transaction);
        } else if (transaction.isUseKernel) {
            this.kernelEngine.stopTransactionTask(transaction);
        } else {
            this.mTransWorker.stopTransaction(transaction);
        }
    }

    @Override // com.tencent.mobileqq.highway.api.TransactionOps
    public int submitTransactionTask(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) transaction)).intValue();
        }
        if (this.kernelEngine.isUseKernel(transaction.mBuzCmdId)) {
            return this.kernelEngine.submitTransactionTask(transaction);
        }
        int submitTransation = this.mTransWorker.submitTransation(transaction);
        dumpEngineInfo();
        return submitTransation;
    }
}
