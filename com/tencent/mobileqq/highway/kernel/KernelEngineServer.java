package com.tencent.mobileqq.highway.kernel;

import android.os.Bundle;
import com.tencent.mobileqq.highway.IInject;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.BaseConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BdhUploadReq;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadService;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class KernelEngineServer extends AbstractKernelEngine implements IKernelFinishCallBack {
    static IPatchRedirector $redirector_ = null;
    static final String TAG = "BDHKernelEngine.KernelEngineServer";
    private Map<Long, Object> allSubmitTrans;
    private Object transLock;

    public KernelEngineServer(IInject iInject) {
        super(iInject);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iInject);
        } else {
            this.transLock = new Object();
            this.allSubmitTrans = new HashMap();
        }
    }

    private BdhUploadReq buildReq(Transaction transaction) {
        BdhUploadReq bdhUploadReq = new BdhUploadReq();
        bdhUploadReq.commandId = transaction.mBuzCmdId;
        bdhUploadReq.filePath = transaction.filePath;
        byte[] bArr = transaction.extendInfo;
        if (bArr != null) {
            bdhUploadReq.bizInfo = bArr;
        }
        bdhUploadReq.priority = 1;
        bdhUploadReq.upKey = transaction.ticket;
        return bdhUploadReq;
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelEngine
    public void cancelTransactionTask(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) transaction);
            return;
        }
        long j3 = transaction.kernelTransID;
        IKernelBdhUploadService kernelService = getKernelService();
        if (kernelService == null) {
            QLog.e(TAG, 1, "cancelTransactionTaskFailed no kernel engine");
            return;
        }
        synchronized (this.transLock) {
            this.allSubmitTrans.remove(Long.valueOf(j3));
            kernelService.cancelUpload(j3);
        }
        QLog.i(TAG, 1, "cancelTransactionTask,buzID:" + transaction.mBuzCmdId + "\tT_ID:" + transaction.kernelTransID);
    }

    public IKernelBdhUploadService getKernelService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IKernelBdhUploadService) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        IQQNTWrapperSession wrapperSession = getWrapperSession();
        if (wrapperSession != null) {
            return wrapperSession.getBdhUploadService();
        }
        return null;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 8, this, str, bundle, Integer.valueOf(i3));
        }
        IKernelBdhUploadService kernelService = getKernelService();
        if (kernelService == null) {
            QLog.e(TAG, 1, "ipc submitTransactionTaskFailed no kernel engine");
            return EIPCResult.createResult(BaseConstants.ERROR.ERR_NO_KERNEL_ENGINE, null);
        }
        if (str.equals("IPC_ACTION_SUBMIT")) {
            IpcTrans ipcTrans = new IpcTrans(bundle);
            BdhUploadReq buildReq = buildReq(ipcTrans);
            synchronized (this.transLock) {
                long uploadFile = kernelService.uploadFile(buildReq, new IpcKernelCallBack(ipcTrans, this));
                ipcTrans.kernelTransID = uploadFile;
                this.allSubmitTrans.put(Long.valueOf(uploadFile), ipcTrans);
            }
            QLog.i(TAG, 1, "ipc submitTransactionTask,buzID:" + ipcTrans.commandId + "\tT_ID:" + ipcTrans.kernelTransID);
            Bundle bundle2 = new Bundle();
            bundle2.putLong("IPC_KEY_TRANS_ID", ipcTrans.kernelTransID);
            return EIPCResult.createSuccessResult(bundle2);
        }
        if (str.equals("IPC_ACTION_CANCEL")) {
            long j3 = bundle.getLong("IPC_KEY_TRANS_ID");
            synchronized (this.transLock) {
                this.allSubmitTrans.remove(Long.valueOf(j3));
                kernelService.cancelUpload(j3);
            }
            QLog.i(TAG, 1, "ipc cancelTransactionTask,\tT_ID:" + j3);
            return EIPCResult.createSuccessResult(null);
        }
        return EIPCResult.createResult(-2002, null);
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelEngine
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        synchronized (this.transLock) {
            this.allSubmitTrans.clear();
        }
    }

    @Override // com.tencent.mobileqq.highway.kernel.IKernelFinishCallBack
    public void onFinishedKernelTrans(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
            return;
        }
        synchronized (this.transLock) {
            this.allSubmitTrans.remove(Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelEngine
    public void resumeTransactionTask(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) transaction);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) transaction);
            return;
        }
        long j3 = transaction.kernelTransID;
        IKernelBdhUploadService kernelService = getKernelService();
        if (kernelService == null) {
            QLog.e(TAG, 1, "stopTransactionTaskFailed no kernel engine");
            return;
        }
        synchronized (this.transLock) {
            if (this.allSubmitTrans.containsKey(Long.valueOf(j3))) {
                this.allSubmitTrans.remove(Long.valueOf(j3));
                kernelService.cancelUpload(j3);
                transaction.kernelTransID = 0L;
            }
        }
        QLog.i(TAG, 1, "stopTransactionTask,buzID:" + transaction.mBuzCmdId + "\tT_ID:" + transaction.kernelTransID);
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelEngine
    public int submitTransactionTask(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) transaction)).intValue();
        }
        IKernelBdhUploadService kernelService = getKernelService();
        if (kernelService == null) {
            QLog.e(TAG, 1, "submitTransactionTaskFailed no kernel engine");
            return BaseConstants.ERROR.ERR_NO_KERNEL_ENGINE;
        }
        BdhUploadReq buildReq = buildReq(transaction);
        synchronized (this.transLock) {
            long uploadFile = kernelService.uploadFile(buildReq, new KernelCallBack(transaction, this));
            transaction.isUseKernel = true;
            transaction.kernelTransID = uploadFile;
            this.allSubmitTrans.put(Long.valueOf(uploadFile), transaction);
        }
        QLog.i(TAG, 1, "submitTransactionTask,buzID:" + transaction.mBuzCmdId + "\tT_ID:" + transaction.kernelTransID);
        return 0;
    }

    private BdhUploadReq buildReq(IpcTrans ipcTrans) {
        BdhUploadReq bdhUploadReq = new BdhUploadReq();
        bdhUploadReq.commandId = ipcTrans.commandId;
        bdhUploadReq.filePath = ipcTrans.filePath;
        byte[] bArr = ipcTrans.bizInfo;
        if (bArr != null) {
            bdhUploadReq.bizInfo = bArr;
        }
        bdhUploadReq.priority = 1;
        bdhUploadReq.upKey = ipcTrans.upKey;
        return bdhUploadReq;
    }
}
