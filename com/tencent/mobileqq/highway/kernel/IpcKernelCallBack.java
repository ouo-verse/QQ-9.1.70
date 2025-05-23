package com.tencent.mobileqq.highway.kernel;

import android.os.Bundle;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
class IpcKernelCallBack extends AbstractKernelCallBack implements ITransactionCallback {
    static IPatchRedirector $redirector_;
    IpcTrans trans;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IpcKernelCallBack(IpcTrans ipcTrans, IKernelFinishCallBack iKernelFinishCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ipcTrans, (Object) iKernelFinishCallBack);
            return;
        }
        this.trans = ipcTrans;
        this.f236830cb = this;
        this.finishCallBack = iKernelFinishCallBack;
    }

    private Bundle generateBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("IPC_KEY_TRANS_ID", this.trans.kernelTransID);
        return bundle;
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelCallBack
    HashMap<String, String> generateReportInfo() {
        return null;
    }

    @Override // com.tencent.mobileqq.highway.kernel.AbstractKernelCallBack
    long getTransId() {
        return this.trans.kernelTransID;
    }

    @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
    public void onFailed(int i3, byte[] bArr, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), bArr, hashMap);
            return;
        }
        Bundle generateBundle = generateBundle();
        generateBundle.putByteArray("IPC_KEY_NOTIFY_RESP_DATA", bArr);
        generateBundle.putInt("IPC_KEY_NOTIFY_ERROR_CODE", i3);
        QIPCServerHelper.getInstance().callClient(this.trans.processName, "BDHKernelEngine", "IPC_ACTION_NOTIFY_FAILED", generateBundle, null);
    }

    @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
    public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) hashMap);
            return;
        }
        Bundle generateBundle = generateBundle();
        generateBundle.putByteArray("IPC_KEY_NOTIFY_RESP_DATA", bArr);
        QIPCServerHelper.getInstance().callClient(this.trans.processName, "BDHKernelEngine", "IPC_ACTION_NOTIFY_SUCCESS", generateBundle, null);
    }

    @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
    public void onSwitch2BackupChannel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
    public void onTransStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QIPCServerHelper.getInstance().callClient(this.trans.processName, "BDHKernelEngine", "IPC_ACTION_NOTIFY_START", generateBundle(), null);
        }
    }

    @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
    public void onUpdateProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        Bundle generateBundle = generateBundle();
        generateBundle.putInt("IPC_KEY_NOTIFY_PROGRESS", i3);
        QIPCServerHelper.getInstance().callClient(this.trans.processName, "BDHKernelEngine", "IPC_ACTION_NOTIFY_PROGRESS", generateBundle, null);
    }
}
