package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class BaseTransFileController implements INetEngineListener {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.richmedia.TransFileController";
    public AppInterface app;
    public int count;
    public ProcHandler mHandler;
    protected AtomicBoolean mWorking;
    public ConcurrentHashMap<String, IHttpCommunicatorListener> processorMap;
    public long startTime;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class ProcHandler extends Handler {
        static IPatchRedirector $redirector_;
        public static final int RUN = 0;

        public ProcHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseTransFileController.this);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) message);
                return;
            }
            if (message.what == 0 && (obj = message.obj) != null && (obj instanceof BaseTransProcessor)) {
                BaseTransProcessor baseTransProcessor = (BaseTransProcessor) obj;
                BaseTransFileController.this.fillTransRequestMessage(baseTransProcessor);
                baseTransProcessor.start();
            }
        }

        public void startProcessor(BaseTransProcessor baseTransProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseTransProcessor);
            } else {
                sendMessage(obtainMessage(0, baseTransProcessor));
            }
        }

        public ProcHandler(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) BaseTransFileController.this, (Object) looper);
        }
    }

    public BaseTransFileController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHandler = null;
        this.mWorking = new AtomicBoolean(true);
        this.processorMap = new ConcurrentHashMap<>(20);
    }

    public static String getProperty(String str) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString(str, null);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String makeKey(String str, long j3) {
        return str + j3;
    }

    public static String makeReceiveKey(TransferRequest transferRequest) {
        return makeReceiveKey(transferRequest.mMd5, transferRequest.mServerPath, transferRequest.mFileType);
    }

    public static void setProperty(String str, String str2) {
        try {
            PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putString(str, str2).commit();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void addHandle(TransProcessorHandler transProcessorHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) transProcessorHandler);
        } else {
            BaseTransProcessor.addHandler(transProcessorHandler);
        }
    }

    public void addProcessor(String str, IHttpCommunicatorListener iHttpCommunicatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) iHttpCommunicatorListener);
        } else {
            this.processorMap.put(str, iHttpCommunicatorListener);
        }
    }

    public boolean containsProcessor(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3))).booleanValue();
        }
        String str2 = str + j3;
        if (this.processorMap.isEmpty()) {
            return false;
        }
        return this.processorMap.containsKey(str2);
    }

    protected void fillTransRequestMessage(BaseTransProcessor baseTransProcessor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseTransProcessor);
        }
    }

    public IHttpCommunicatorListener findProcessor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IHttpCommunicatorListener) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (this.processorMap.isEmpty()) {
            return null;
        }
        return this.processorMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<String> getKeySetClone(ConcurrentHashMap<String, IHttpCommunicatorListener> concurrentHashMap) {
        Set<String> set;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Set) iPatchRedirector.redirect((short) 17, (Object) this, (Object) concurrentHashMap);
        }
        HashSet hashSet = new HashSet();
        if (concurrentHashMap != null) {
            set = concurrentHashMap.keySet();
        } else {
            set = null;
        }
        if (set != null) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return hashSet;
    }

    public ConcurrentHashMap<String, IHttpCommunicatorListener> getProcessMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.processorMap;
    }

    public abstract BaseTransProcessor getProcessor(TransferRequest transferRequest);

    public AtomicBoolean isWorking() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AtomicBoolean) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mWorking;
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) netResp);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doPreConn req");
            sb5.append(netResp.mReq);
            sb5.append(" result:");
            if (netResp.mResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.e("Q.richmedia.TransFileController", 2, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    void printBadRequest() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.startTime <= 0) {
            this.startTime = currentTimeMillis;
        }
        if (currentTimeMillis - this.startTime > 2000) {
            this.startTime = currentTimeMillis;
            this.count = 0;
        } else {
            this.count++;
        }
        if (this.count > 500) {
            QLog.e("Q.richmedia.TransFileController", 1, "bad bad \u65e5\u5fd7\u9891\u7e41\u6253\u5370" + QLog.getStackTraceString(new Throwable()));
        }
    }

    public void removeHandle(TransProcessorHandler transProcessorHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) transProcessorHandler);
        } else {
            BaseTransProcessor.removeHandler(transProcessorHandler);
        }
    }

    public boolean removeProcessor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null || this.processorMap.remove(str) == null) {
            return false;
        }
        return true;
    }

    public void stop(TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) transferRequest);
            return;
        }
        String keyForTransfer = transferRequest.getKeyForTransfer();
        if (this.processorMap.containsKey(keyForTransfer)) {
            IHttpCommunicatorListener iHttpCommunicatorListener = this.processorMap.get(keyForTransfer);
            if (iHttpCommunicatorListener instanceof BaseTransProcessor) {
                BaseTransProcessor baseTransProcessor = (BaseTransProcessor) iHttpCommunicatorListener;
                baseTransProcessor.stop();
                baseTransProcessor.cancel();
                this.processorMap.remove(keyForTransfer);
            }
        }
    }

    public void stopCurrentWork() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        for (String str : getKeySetClone(this.processorMap)) {
            IHttpCommunicatorListener iHttpCommunicatorListener = this.processorMap.get(str);
            if (iHttpCommunicatorListener instanceof BaseTransProcessor) {
                BaseTransProcessor baseTransProcessor = (BaseTransProcessor) iHttpCommunicatorListener;
                baseTransProcessor.stop();
                baseTransProcessor.cancel();
                baseTransProcessor.accountChanged();
                this.processorMap.remove(str);
            }
        }
    }

    public synchronized boolean transferAsync(TransferRequest transferRequest) {
        boolean z16;
        TransferRequest transferRequest2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) transferRequest)).booleanValue();
        }
        String keyForTransfer = transferRequest.getKeyForTransfer();
        if (this.mWorking.get()) {
            z16 = true;
            if (!this.processorMap.containsKey(keyForTransfer)) {
                BaseTransProcessor processor = getProcessor(transferRequest);
                if (processor != null && processor.checkParam() == 0) {
                    this.processorMap.put(keyForTransfer, processor);
                    processor.setKey(keyForTransfer);
                    ProcHandler procHandler = this.mHandler;
                    if (procHandler != null) {
                        procHandler.startProcessor(processor);
                        return z16;
                    }
                }
            } else {
                QLog.d("Q.richmedia.TransFileController", 1, "bad bad:" + transferRequest.mUniseq);
                printBadRequest();
                BaseTransProcessor baseTransProcessor = (BaseTransProcessor) findProcessor(transferRequest.mPeerUin, transferRequest.mUniseq);
                if (baseTransProcessor != null) {
                    if (transferRequest.mFileType == 131078 && (transferRequest2 = baseTransProcessor.mUiRequest) != null && transferRequest2.mDownCallBack == null && transferRequest.mDownCallBack != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.richmedia.TransFileController", 2, "multimsg-replace callback to predownload");
                        }
                        baseTransProcessor.mUiRequest.mDownCallBack = transferRequest.mDownCallBack;
                    }
                    baseTransProcessor.resume();
                }
            }
        } else if (QLog.isColorLevel()) {
            QLog.e("Q.richmedia.TransFileController", 2, ProcessorReport.getExceptionMessage(new Exception("tranfilecontroller closed")));
        }
        z16 = false;
        return z16;
    }

    public static String makeReceiveKey(String str, String str2, int i3) {
        if (str != null && !"null".equals(str) && !"".equals(str)) {
            return str + "_" + i3;
        }
        return str2 + "_" + i3;
    }

    public IHttpCommunicatorListener findProcessor(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (IHttpCommunicatorListener) iPatchRedirector.redirect((short) 14, this, str, Long.valueOf(j3));
        }
        if (this.processorMap.isEmpty()) {
            return null;
        }
        return this.processorMap.get(str + j3);
    }

    public BaseTransFileController(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mHandler = null;
        this.mWorking = new AtomicBoolean(true);
        this.processorMap = new ConcurrentHashMap<>(20);
        if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
        }
        this.app = (AppInterface) appRuntime;
        this.mHandler = new ProcHandler(ThreadManagerV2.getSubThreadLooper());
    }
}
