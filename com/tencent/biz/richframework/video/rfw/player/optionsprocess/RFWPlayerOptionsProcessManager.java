package com.tencent.biz.richframework.video.rfw.player.optionsprocess;

import android.os.Looper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayerListenerDispatchUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class RFWPlayerOptionsProcessManager {
    private static volatile RFWPlayerOptionsProcessManager sInstance;
    private final ConcurrentHashMap<String, IRFWPlayerOptionsProcess> mProcessMap = new ConcurrentHashMap<>();

    /* loaded from: classes5.dex */
    public interface IProcessCallBack {
        void onFinish(RFWPlayerOptions rFWPlayerOptions, boolean z16);
    }

    RFWPlayerOptionsProcessManager() {
        initDefaultProcess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackFinishInMain(final RFWPlayerOptions rFWPlayerOptions, final IProcessCallBack iProcessCallBack) {
        if (iProcessCallBack == null) {
            return;
        }
        if (Looper.getMainLooper().isCurrentThread()) {
            RFWLog.d("QFSPlayerOptionsProcessManager_" + rFWPlayerOptions.tag(), RFWLog.USR, "callBackFinish");
            iProcessCallBack.onFinish(rFWPlayerOptions, false);
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.optionsprocess.b
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerOptionsProcessManager.lambda$callBackFinishInMain$0(RFWPlayerOptions.this, iProcessCallBack);
            }
        });
    }

    private void execute(final LinkedList<String> linkedList, RFWPlayerOptions rFWPlayerOptions, final IProcessCallBack iProcessCallBack) {
        if (linkedList.size() == 0) {
            RFWLog.d("QFSPlayerOptionsProcessManager_" + rFWPlayerOptions.tag(), RFWLog.USR, "startProcess()| end order empty| current option" + rFWPlayerOptions);
            callBackFinishInMain(rFWPlayerOptions, iProcessCallBack);
            return;
        }
        final String str = linkedList.get(0);
        IRFWPlayerOptionsProcess iRFWPlayerOptionsProcess = this.mProcessMap.get(str);
        if (iRFWPlayerOptionsProcess == null) {
            RFWLog.d("QFSPlayerOptionsProcessManager_" + rFWPlayerOptions.tag(), RFWLog.USR, "tryToContinueProcess:" + str);
            tryToContinueProcess(linkedList, rFWPlayerOptions, iProcessCallBack);
            return;
        }
        RFWPlayerListenerDispatchUtils.notifyOptionsCallback(str, rFWPlayerOptions, true);
        iRFWPlayerOptionsProcess.onProcess(rFWPlayerOptions, new IProcessCallBack() { // from class: com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager.1
            @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager.IProcessCallBack
            public void onFinish(RFWPlayerOptions rFWPlayerOptions2, boolean z16) {
                if (z16) {
                    RFWPlayerListenerDispatchUtils.notifyOptionsCallback(str, rFWPlayerOptions2, false);
                    RFWPlayerOptionsProcessManager rFWPlayerOptionsProcessManager = RFWPlayerOptionsProcessManager.this;
                    rFWPlayerOptionsProcessManager.startProcess(rFWPlayerOptionsProcessManager.getNextOrder(linkedList), rFWPlayerOptions2, iProcessCallBack);
                    return;
                }
                RFWLog.d("QFSPlayerOptionsProcessManager_" + rFWPlayerOptions2.tag(), RFWLog.USR, "startProcess()| end by startKey:" + str + "currentOption:" + rFWPlayerOptions2);
                RFWPlayerListenerDispatchUtils.notifyOptionsCallback(str, rFWPlayerOptions2, false);
                RFWPlayerOptionsProcessManager.this.callBackFinishInMain(rFWPlayerOptions2, iProcessCallBack);
            }
        });
    }

    public static RFWPlayerOptionsProcessManager g() {
        if (sInstance == null) {
            synchronized (RFWPlayerOptionsProcessManager.class) {
                if (sInstance == null) {
                    sInstance = new RFWPlayerOptionsProcessManager();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LinkedList<String> getNextOrder(LinkedList<String> linkedList) {
        if (linkedList != null && linkedList.size() != 0) {
            linkedList.remove(0);
            return linkedList;
        }
        return new LinkedList<>();
    }

    private void initDefaultProcess() {
        RFWPlayerOptionsLocalPathProcess rFWPlayerOptionsLocalPathProcess = new RFWPlayerOptionsLocalPathProcess();
        this.mProcessMap.put(rFWPlayerOptionsLocalPathProcess.getProcessKey(), rFWPlayerOptionsLocalPathProcess);
        RFWPlayerOptionPreloadCheckProcess rFWPlayerOptionPreloadCheckProcess = new RFWPlayerOptionPreloadCheckProcess();
        this.mProcessMap.put(rFWPlayerOptionPreloadCheckProcess.getProcessKey(), rFWPlayerOptionPreloadCheckProcess);
        RFWPlayerOptionURLSelectedProcess rFWPlayerOptionURLSelectedProcess = new RFWPlayerOptionURLSelectedProcess();
        this.mProcessMap.put(rFWPlayerOptionURLSelectedProcess.getProcessKey(), rFWPlayerOptionURLSelectedProcess);
        RFWPlayerOptionH264ReSelectedProcess rFWPlayerOptionH264ReSelectedProcess = new RFWPlayerOptionH264ReSelectedProcess();
        this.mProcessMap.put(rFWPlayerOptionH264ReSelectedProcess.getProcessKey(), rFWPlayerOptionH264ReSelectedProcess);
        RFWPlayerOptionsHttpValidProcess rFWPlayerOptionsHttpValidProcess = new RFWPlayerOptionsHttpValidProcess();
        this.mProcessMap.put(rFWPlayerOptionsHttpValidProcess.getProcessKey(), rFWPlayerOptionsHttpValidProcess);
        RFWPlayerPlayerDirectIPProcess rFWPlayerPlayerDirectIPProcess = new RFWPlayerPlayerDirectIPProcess();
        this.mProcessMap.put(rFWPlayerPlayerDirectIPProcess.getProcessKey(), rFWPlayerPlayerDirectIPProcess);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$callBackFinishInMain$0(RFWPlayerOptions rFWPlayerOptions, IProcessCallBack iProcessCallBack) {
        RFWLog.d("QFSPlayerOptionsProcessManager_" + rFWPlayerOptions.tag(), RFWLog.USR, "callBackFinish");
        iProcessCallBack.onFinish(rFWPlayerOptions, false);
    }

    private void tryToContinueProcess(LinkedList<String> linkedList, RFWPlayerOptions rFWPlayerOptions, IProcessCallBack iProcessCallBack) {
        LinkedList<String> nextOrder = getNextOrder(linkedList);
        if (nextOrder.size() > 0) {
            RFWLog.d("QFSPlayerOptionsProcessManager_" + rFWPlayerOptions.tag(), RFWLog.USR, "tryToContinueProcess()");
            startProcess(nextOrder, rFWPlayerOptions, iProcessCallBack);
            return;
        }
        RFWLog.d("QFSPlayerOptionsProcessManager_" + rFWPlayerOptions.tag(), RFWLog.USR, "tryToContinueProcess()|  edn error key");
        callBackFinishInMain(rFWPlayerOptions, iProcessCallBack);
    }

    public void initBusinessProcess(List<Class<IRFWPlayerOptionsProcess>> list) {
        if (list != null && !list.isEmpty()) {
            try {
                Iterator<Class<IRFWPlayerOptionsProcess>> it = list.iterator();
                while (it.hasNext()) {
                    IRFWPlayerOptionsProcess newInstance = it.next().getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.mProcessMap.put(newInstance.getProcessKey(), newInstance);
                    RFWLog.d("QFSPlayerOptionsProcessManager", RFWLog.USR, "inject business process:" + newInstance.getProcessKey());
                }
            } catch (Exception e16) {
                RFWLog.d("QFSPlayerOptionsProcessManager", RFWLog.USR, "inject class process failed", e16);
            }
        }
    }

    public void startProcess(LinkedList<String> linkedList, RFWPlayerOptions rFWPlayerOptions, IProcessCallBack iProcessCallBack) {
        if (rFWPlayerOptions != null && linkedList != null && iProcessCallBack != null) {
            execute(linkedList, rFWPlayerOptions, iProcessCallBack);
        }
    }
}
