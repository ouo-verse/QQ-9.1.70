package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.report.ProcessorReport;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UrlDownloader extends BaseDownloadProcessor {
    static IPatchRedirector $redirector_;
    protected TransferRequest.PicDownExtraInfo mPicDownExtra;

    public UrlDownloader(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mRecvLen = ((TransferRequest.PicDownExtraInfo) this.mUiRequest.mExtraObj).mStartDownOffset;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        this.mController.removeProcessor(BaseTransFileController.makeReceiveKey(this.mUiRequest));
        TransferRequest transferRequest = this.mUiRequest;
        TransferResult transferResult = transferRequest.mResult;
        if (transferResult != null) {
            transferResult.mResult = -1;
            ProcessorReport processorReport = this.mProcessorReport;
            transferResult.mErrCode = processorReport.errCode;
            transferResult.mErrDesc = processorReport.errDesc;
            transferResult.mOrigReq = transferRequest;
        }
        synchronized (this) {
            logRichMediaEvent("notify", "start");
            notifyAll();
            logRichMediaEvent("notify", "end");
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) netResp);
            return;
        }
        super.onResp(netResp);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" result:");
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        logRichMediaEvent("onHttpResp", sb5.toString());
        this.mRecvLen += netResp.mWrittenBlockLen;
        if (netResp.mResult == 0) {
            onSuccess();
        } else {
            onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        TransferRequest transferRequest = this.mUiRequest;
        TransferResult transferResult = transferRequest.mResult;
        this.mController.removeProcessor(BaseTransFileController.makeReceiveKey(transferRequest));
        if (transferResult != null) {
            transferResult.mResult = 0;
            transferResult.mOrigReq = this.mUiRequest;
        }
        synchronized (this) {
            logRichMediaEvent("notify", "start");
            notifyAll();
            logRichMediaEvent("notify", "end");
        }
    }

    void receiveFile() {
        String str = this.mUiRequest.mServerPath;
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = this;
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        TransferRequest transferRequest = this.mUiRequest;
        httpNetReq.mOutStream = transferRequest.mOut;
        httpNetReq.mOutPath = transferRequest.mOutFilePath;
        httpNetReq.mMsgId = String.valueOf(transferRequest.mUniseq);
        TransferRequest transferRequest2 = this.mUiRequest;
        httpNetReq.mBusiProtoType = transferRequest2.mUinType;
        httpNetReq.mFileType = transferRequest2.mFileType;
        httpNetReq.mStartDownOffset = this.mRecvLen;
        httpNetReq.mReqProperties.put("Accept-Encoding", "identity");
        TransferRequest transferRequest3 = this.mUiRequest;
        httpNetReq.mPrioty = transferRequest3.mPrioty;
        if (transferRequest3.mSupportRangeBreakDown) {
            httpNetReq.mReqProperties.put("Range", "bytes=" + httpNetReq.mStartDownOffset + "-");
            httpNetReq.mSupportBreakResume = true;
        }
        httpNetReq.mContinuErrorLimit = 4;
        httpNetReq.mExcuteTimeLimit = 90000L;
        logRichMediaEvent("httpDown", " url:" + str + ",downOffset:" + httpNetReq.mStartDownOffset);
        this.mNetEngine.sendReq(httpNetReq);
    }

    @Override // com.tencent.mobileqq.transfile.BaseDownloadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            receiveFile();
        }
    }

    public UrlDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
