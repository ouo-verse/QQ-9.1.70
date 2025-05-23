package com.tencent.mobileqq.highway.kernel;

import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BdhUploadRsp;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadCompleteCallback;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class AbstractKernelCallBack implements IKernelBdhUploadCompleteCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: cb, reason: collision with root package name */
    ITransactionCallback f236830cb;
    IKernelFinishCallBack finishCallBack;

    public AbstractKernelCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    abstract HashMap<String, String> generateReportInfo();

    abstract long getTransId();

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBdhUploadCompleteCallback
    public void onResult(int i3, String str, BdhUploadRsp bdhUploadRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bdhUploadRsp);
            return;
        }
        long transId = getTransId();
        if (i3 != 2006013 && i3 != 2006014) {
            if (i3 != 0) {
                QLog.e("BDHKernelEngine.KernelEngineServer", 1, "onResult, trans failed, transID:" + transId + " result:" + i3);
                ITransactionCallback iTransactionCallback = this.f236830cb;
                if (iTransactionCallback != null) {
                    iTransactionCallback.onFailed(i3, bdhUploadRsp.rspBuf, generateReportInfo());
                }
                this.finishCallBack.onFinishedKernelTrans(transId);
                return;
            }
            int i16 = bdhUploadRsp.status;
            if (i16 == 1) {
                QLog.i("BDHKernelEngine.KernelEngineServer", 1, "onResult, trans onTransStart, transID:" + transId);
                ITransactionCallback iTransactionCallback2 = this.f236830cb;
                if (iTransactionCallback2 != null) {
                    iTransactionCallback2.onTransStart();
                    return;
                }
                return;
            }
            if (i16 == 2) {
                QLog.d("BDHKernelEngine.KernelEngineServer", 4, "onResult, trans onUpdateProgress, transID:" + transId + " result:" + i3 + " progress:" + bdhUploadRsp.process.intValue());
                ITransactionCallback iTransactionCallback3 = this.f236830cb;
                if (iTransactionCallback3 != null) {
                    iTransactionCallback3.onUpdateProgress(bdhUploadRsp.sendFileSize.intValue());
                    return;
                }
                return;
            }
            if (i16 == 3) {
                QLog.i("BDHKernelEngine.KernelEngineServer", 1, "onResult, trans suc, transID:" + transId);
                ITransactionCallback iTransactionCallback4 = this.f236830cb;
                if (iTransactionCallback4 != null) {
                    iTransactionCallback4.onSuccess(bdhUploadRsp.rspBuf, generateReportInfo());
                }
                this.finishCallBack.onFinishedKernelTrans(transId);
                return;
            }
            return;
        }
        QLog.e("BDHKernelEngine.KernelEngineServer", 1, "onResult, trans canceled, transID:" + transId + " result:" + i3);
    }
}
