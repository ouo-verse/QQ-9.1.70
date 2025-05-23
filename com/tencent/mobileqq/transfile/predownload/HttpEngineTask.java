package com.tencent.mobileqq.transfile.predownload;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class HttpEngineTask extends AbsPreDownloadTask implements INetEngineListener {
    static IPatchRedirector $redirector_;
    public HttpNetReq httpReq;
    private IHttpEngineTask mCallback;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface IHttpEngineTask extends INetEngineListener {
        void onPreDownloadStart(HttpEngineTask httpEngineTask);
    }

    public HttpEngineTask(BaseQQAppInterface baseQQAppInterface, String str, IHttpEngineTask iHttpEngineTask, HttpNetReq httpNetReq) {
        super(baseQQAppInterface, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, baseQQAppInterface, str, iHttpEngineTask, httpNetReq);
            return;
        }
        this.httpReq = httpNetReq;
        this.mCallback = iHttpEngineTask;
        this.app = null;
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) netResp);
            return;
        }
        IHttpEngineTask iHttpEngineTask = this.mCallback;
        if (iHttpEngineTask != null) {
            iHttpEngineTask.onResp(netResp);
        }
        IPreDownloadController iPreDownloadController = this.ctrl;
        if (iPreDownloadController != null) {
            iPreDownloadController.onTaskEnd(this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        IHttpEngineTask iHttpEngineTask = this.mCallback;
        if (iHttpEngineTask != null) {
            iHttpEngineTask.onUpdateProgeress(netReq, j3, j16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
    public void realCancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelReq(this.httpReq);
            this.ctrl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
    public void realStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PreDownload.Task", 2, "start: " + this);
        }
        ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(this.httpReq);
        this.httpReq.mCallback = this;
        IHttpEngineTask iHttpEngineTask = this.mCallback;
        if (iHttpEngineTask != null) {
            iHttpEngineTask.onPreDownloadStart(this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.toString());
        sb5.append("[");
        sb5.append(this.httpReq.mReqUrl);
        sb5.append(", ");
        Object obj = this.mCallback;
        if (obj == null) {
            obj = "";
        }
        sb5.append(obj);
        sb5.append("]");
        return sb5.toString();
    }
}
