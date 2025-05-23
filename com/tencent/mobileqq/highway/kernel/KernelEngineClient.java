package com.tencent.mobileqq.highway.kernel;

import android.os.Bundle;
import com.tencent.mobileqq.highway.IInject;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class KernelEngineClient extends AbstractKernelEngine {
    static IPatchRedirector $redirector_ = null;
    static final String TAG = "BDHKernelEngine.KernelEngineClient";
    private Map<Long, Transaction> allSubmitTrans;

    public KernelEngineClient(IInject iInject) {
        super(iInject);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iInject);
        } else {
            this.allSubmitTrans = new ConcurrentHashMap();
            QIPCClientHelper.getInstance().register(this);
        }
    }

    Bundle buildIpcTransBundle(Transaction transaction) {
        Bundle bundle = new Bundle();
        bundle.putString("IPC_KEY_SUB_PROCESS_NAME", MobileQQ.processName);
        bundle.putInt("IPC_KEY_COMMAND_ID", transaction.mBuzCmdId);
        bundle.putString("IPC_KEY_FILE_PATH", transaction.filePath);
        bundle.putByteArray("IPC_KEY_BIZ_INFO", transaction.extendInfo);
        bundle.putByteArray("IPC_KEY_UP_KEY", transaction.ticket);
        return bundle;
    }

    Bundle buildTransIDBundle(Transaction transaction) {
        Bundle bundle = new Bundle();
        bundle.putLong("IPC_KEY_TRANS_ID", transaction.kernelTransID);
        return bundle;
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelEngine
    public void cancelTransactionTask(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) transaction);
            return;
        }
        QIPCClientHelper.getInstance().callServer(this.name, "IPC_ACTION_CANCEL", buildTransIDBundle(transaction), null);
        this.allSubmitTrans.remove(Long.valueOf(transaction.kernelTransID));
        QLog.i(TAG, 1, "cancelTransactionTask,buzID:" + transaction.mBuzCmdId + "\tT_ID:" + transaction.kernelTransID);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 7, this, str, bundle, Integer.valueOf(i3));
        }
        long j3 = bundle.getLong("IPC_KEY_TRANS_ID");
        Transaction transaction = this.allSubmitTrans.get(Long.valueOf(j3));
        if (transaction == null) {
            return EIPCResult.createResult(-2001, null);
        }
        ITransactionCallback iTransactionCallback = transaction.f236840cb;
        if (iTransactionCallback == null) {
            return EIPCResult.createSuccessResult(null);
        }
        if (str.equals("IPC_ACTION_NOTIFY_SUCCESS")) {
            QLog.i(TAG, 1, "onCall, trans suc, transID:" + j3);
            iTransactionCallback.onSuccess(bundle.getByteArray("IPC_KEY_NOTIFY_RESP_DATA"), transaction.updateAndGetReporter());
        } else if (str.equals("IPC_ACTION_NOTIFY_START")) {
            QLog.i(TAG, 1, "onCall, trans onTransStart, transID:" + j3);
            iTransactionCallback.onTransStart();
        } else if (str.equals("IPC_ACTION_NOTIFY_FAILED")) {
            int i16 = bundle.getInt("IPC_KEY_NOTIFY_ERROR_CODE");
            QLog.e(TAG, 1, "onCall, trans failed, transID:" + j3 + " errorCode:" + i16);
            iTransactionCallback.onFailed(i16, bundle.getByteArray("IPC_KEY_NOTIFY_RESP_DATA"), transaction.updateAndGetReporter());
        } else if (str.equals("IPC_ACTION_NOTIFY_PROGRESS")) {
            int i17 = bundle.getInt("IPC_KEY_NOTIFY_PROGRESS");
            QLog.d(TAG, 4, "onCall, trans onUpdateProgress, transID:" + j3 + " progress:" + i17);
            iTransactionCallback.onUpdateProgress(i17);
        }
        return EIPCResult.createResult(-2002, null);
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelEngine
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.allSubmitTrans.clear();
            QIPCClientHelper.getInstance().getClient().unRegisterModule(this);
        }
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelEngine
    public void resumeTransactionTask(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) transaction);
            return;
        }
        if (transaction.kernelTransID != 0) {
            QLog.i(TAG, 1, "resumeTransactionTaskFailed,buzID:" + transaction.mBuzCmdId + "\tT_ID:" + transaction.kernelTransID);
            return;
        }
        QLog.i(TAG, 1, "resumeTransactionTask:" + transaction.mBuzCmdId + "\tT_ID:" + transaction.kernelTransID);
        submitTransactionTask(transaction);
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelEngine
    public void stopTransactionTask(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) transaction);
            return;
        }
        long j3 = transaction.kernelTransID;
        Bundle buildTransIDBundle = buildTransIDBundle(transaction);
        if (this.allSubmitTrans.containsKey(Long.valueOf(j3))) {
            this.allSubmitTrans.remove(Long.valueOf(j3));
            QIPCClientHelper.getInstance().callServer(this.name, "IPC_ACTION_CANCEL", buildTransIDBundle, null);
            transaction.kernelTransID = 0L;
        }
        QLog.i(TAG, 1, "stopTransactionTask,buzID:" + transaction.mBuzCmdId + "\tT_ID:" + transaction.kernelTransID);
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelEngine
    public int submitTransactionTask(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) transaction)).intValue();
        }
        transaction.isUseKernel = true;
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(this.name, "IPC_ACTION_SUBMIT", buildIpcTransBundle(transaction));
        if (callServer.isSuccess()) {
            long j3 = callServer.data.getLong("IPC_KEY_TRANS_ID");
            transaction.kernelTransID = j3;
            this.allSubmitTrans.put(Long.valueOf(j3), transaction);
            QLog.i(TAG, 1, "submitTransactionTask,buzID:" + transaction.mBuzCmdId + "\tT_ID:" + transaction.kernelTransID);
            return 0;
        }
        QLog.e(TAG, 1, "submitTransactionTaskFailed, errorCode:" + callServer.code, callServer.f396321e);
        return callServer.code;
    }
}
