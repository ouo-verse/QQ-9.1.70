package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.ptt.api.impl.PttInfoCollectorImpl;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/* loaded from: classes19.dex */
public class JSPttUploadProcessor extends BaseUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "JSPttUploadProcessor";
    String mFileKey;

    public JSPttUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        }
    }

    private int doCheckParam() {
        logRichMediaEvent("uiParam", this.mUiRequest.toString());
        String str = this.mUiRequest.mLocalPath;
        if (str != null && !"".equals(str)) {
            File file = new File(str);
            if (!file.exists()) {
                this.mProcessorReport.setError(9042, BaseTransProcessor.getExpStackString(new Exception("sendFile not exist " + str)), null, null);
                onError();
                return -1;
            }
            if (!file.canRead()) {
                this.mProcessorReport.setError(9070, BaseTransProcessor.getExpStackString(new Exception("sendFile not readable " + this.file.filePath)), null, null);
                onError();
                return -1;
            }
            this.mExtName = "amr";
            long length = file.length();
            this.file.fileSize = length;
            this.mFileSize = length;
            if (length <= 0) {
                this.mProcessorReport.setError(9071, BaseTransProcessor.getExpStackString(new Exception("file size 0 " + str)), null, null);
                onError();
                return -1;
            }
            return 0;
        }
        this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("filePath null")), null, null);
        onError();
        return -1;
    }

    private void doStart(boolean z16) {
        if (!z16) {
            sendMessageToUpdate(1001);
        }
        this.file.closeInputStream();
        if (this.mLocalMd5 == null && !getMd5()) {
            onError();
            return;
        }
        if (this.mRaf == null) {
            try {
                this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
                this.mRaf = null;
            }
            if (this.mRaf == null) {
                this.mProcessorReport.setError(9303, "read file error", null, null);
                onError();
                return;
            }
        }
        sendRequest();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        super.checkParam();
        return doCheckParam();
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    protected String getConnUrl(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
        }
        StringBuilder sb5 = new StringBuilder();
        ServerAddr serverAddr = this.mIpList.get(0);
        sb5.append("http://");
        sb5.append(serverAddr.mIp);
        if (serverAddr.port != 80) {
            sb5.append(":");
            sb5.append(serverAddr.port);
        }
        sb5.append("/qqcommfileupload?ver=");
        sb5.append(100);
        sb5.append("&ukey=");
        sb5.append(this.mUkey);
        sb5.append("&filekey=");
        sb5.append(this.mMd5Str);
        sb5.append("&filesize=");
        sb5.append(this.mFileSize);
        sb5.append("&bmd5=");
        sb5.append(MD5.toMD5(bArr));
        sb5.append("&range=");
        sb5.append(this.mTransferedSize);
        sb5.append("&voice_codec=0");
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                RichProto.RichProtoResp.C2CPttUpResp c2CPttUpResp = (RichProto.RichProtoResp.C2CPttUpResp) richProtoResp.resps.get(i3);
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("procUrl", c2CPttUpResp.toString());
                }
                this.mProcessorReport.mSendByQuickHttp = c2CPttUpResp.isSendByQuickHttp;
                if (QLog.isColorLevel()) {
                    QLog.e("http_sideway", 2, "JSPttUpProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.mProcessorReport.mSendByQuickHttp);
                }
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.copyRespCommon(processorReport.mStepUrl, c2CPttUpResp);
                if (c2CPttUpResp.result == 0) {
                    if (c2CPttUpResp.isExist) {
                        this.mResid = c2CPttUpResp.uuid;
                    } else {
                        this.mResid = c2CPttUpResp.uuid;
                        this.mUkey = c2CPttUpResp.mUkey;
                        this.mIpList = c2CPttUpResp.ipList;
                        this.mTransferedSize = 0L;
                        this.mBlockSize = c2CPttUpResp.blockSize;
                        ((IPttTempApi) QRoute.api(IPttTempApi.class)).setJsPttServerId(this.mResid);
                        sendFile();
                    }
                } else {
                    onError();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        sendMessageToUpdate(1005);
        doReport(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6 A[Catch: Exception -> 0x0193, TRY_ENTER, TryCatch #2 {Exception -> 0x0193, blocks: (B:10:0x0021, B:12:0x0028, B:14:0x0035, B:19:0x004f, B:21:0x0067, B:26:0x0085, B:34:0x009b, B:38:0x00a6, B:40:0x00e3, B:42:0x0116, B:44:0x011a, B:45:0x0129, B:47:0x0144, B:49:0x0157, B:51:0x015b, B:59:0x007d, B:61:0x015f, B:63:0x0165, B:65:0x0169, B:67:0x017e, B:54:0x0075, B:29:0x0093), top: B:9:0x0021, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e3 A[Catch: Exception -> 0x0193, TryCatch #2 {Exception -> 0x0193, blocks: (B:10:0x0021, B:12:0x0028, B:14:0x0035, B:19:0x004f, B:21:0x0067, B:26:0x0085, B:34:0x009b, B:38:0x00a6, B:40:0x00e3, B:42:0x0116, B:44:0x011a, B:45:0x0129, B:47:0x0144, B:49:0x0157, B:51:0x015b, B:59:0x007d, B:61:0x015f, B:63:0x0165, B:65:0x0169, B:67:0x017e, B:54:0x0075, B:29:0x0093), top: B:9:0x0021, inners: #0, #1 }] */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResp(NetResp netResp) {
        long j3;
        long parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) netResp);
            return;
        }
        super.onResp(netResp);
        String str = null;
        this.mNetReq = null;
        int i3 = netResp.mHttpCode;
        try {
            if (netResp.mResult == 0) {
                if (netResp.mRespProperties.get(HttpMsg.USERRETURNCODE) != null) {
                    j3 = Long.parseLong(netResp.mRespProperties.get(HttpMsg.USERRETURNCODE));
                } else {
                    j3 = Long.MAX_VALUE;
                }
                if (j3 != 0 && j3 != Long.MAX_VALUE) {
                    ProcessorReport processorReport = this.mProcessorReport;
                    processorReport.copyStaticsInfoFromNetResp(processorReport.mStepTrans, netResp, false);
                    this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, null, ProcessorReport.getHttpDataReason(i3, j3), this.mProcessorReport.mStepTrans);
                    onError();
                    return;
                }
                String str2 = netResp.mRespProperties.get("Range");
                if (str2 != null) {
                    try {
                        parseInt = Integer.parseInt(str2);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    if (parseInt == Long.MAX_VALUE && (str = netResp.mRespProperties.get(HttpMsg.XRANGE)) != null) {
                        try {
                            parseInt = Integer.parseInt(str);
                        } catch (Exception e17) {
                            e17.printStackTrace();
                            parseInt = Long.MAX_VALUE;
                        }
                    }
                    if (parseInt != Long.MAX_VALUE) {
                        ProcessorReport processorReport2 = this.mProcessorReport;
                        processorReport2.copyStaticsInfoFromNetResp(processorReport2.mStepTrans, netResp, false);
                        this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, "no header range:" + str2 + " x-range:" + str, ProcessorReport.getServerReason(AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, -9531L), this.mProcessorReport.mStepTrans);
                        new PttInfoCollectorImpl().reportNoRange(true);
                        onError();
                        return;
                    }
                    logRichMediaEvent("decodeHttpResp", "from " + this.mTransferedSize + " to " + parseInt + " userReturnCode:" + j3);
                    if (parseInt <= this.mTransferedSize) {
                        if (this.mServerRollbackCount < 3) {
                            logRichMediaEvent("procHttpRespBody", "server offset rollback");
                            this.mServerRollbackCount++;
                        } else {
                            ProcessorReport processorReport3 = this.mProcessorReport;
                            processorReport3.copyStaticsInfoFromNetResp(processorReport3.mStepTrans, netResp, false);
                            this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE, "", ProcessorReport.getServerReason(AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, -9530L), this.mProcessorReport.mStepTrans);
                            onError();
                            return;
                        }
                    }
                    this.file.transferedSize = parseInt;
                    this.mTransferedSize = parseInt;
                    ProcessorReport processorReport4 = this.mProcessorReport;
                    processorReport4.copyStaticsInfoFromNetResp(processorReport4.mStepTrans, netResp, true);
                    if (parseInt < this.mFileSize) {
                        sendFile();
                        return;
                    } else {
                        onSuccess();
                        return;
                    }
                }
                parseInt = Long.MAX_VALUE;
                if (parseInt == Long.MAX_VALUE) {
                    parseInt = Integer.parseInt(str);
                }
                if (parseInt != Long.MAX_VALUE) {
                }
            } else {
                if (netResp.mErrCode == 9364 && this.mNetworkChgRetryCount < 3) {
                    logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
                    this.mNetworkChgRetryCount++;
                    clearReprotInfo();
                    sendRequest();
                    return;
                }
                ProcessorReport processorReport5 = this.mProcessorReport;
                processorReport5.copyStaticsInfoFromNetResp(processorReport5.mStepTrans, netResp, false);
                this.mProcessorReport.setError(netResp.mErrCode, netResp.mErrDesc, null, null);
                onError();
            }
        } catch (Exception unused) {
            this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERROR_DECODE_EXP, ProcessorReport.getExceptionMessage(new Exception("decode unknown exception")), "", this.mProcessorReport.mStepTrans);
            onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        sendMessageToUpdate(1003);
        doReport(true);
    }

    void sendRequest() {
        this.mProcessorReport.mStepUrl.logStartTime();
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.PttUpReq pttUpReq = new RichProto.RichProtoReq.PttUpReq();
        TransferRequest transferRequest = this.mUiRequest;
        pttUpReq.selfUin = transferRequest.mSelfUin;
        pttUpReq.peerUin = transferRequest.mPeerUin;
        pttUpReq.secondUin = transferRequest.mSecondId;
        pttUpReq.uinType = transferRequest.mUinType;
        pttUpReq.fileName = this.mFileName;
        pttUpReq.fileSize = (int) this.mFileSize;
        pttUpReq.md5 = this.mLocalMd5;
        pttUpReq.voiceType = 0;
        pttUpReq.voiceLength = 1;
        pttUpReq.audioPanelType = transferRequest.mPttUploadPanel;
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.C2C_PTT_UP;
        richProtoReq.reqs.add(pttUpReq);
        richProtoReq.protoReqMgr = getProtoReqManager();
        if (!isAppValid()) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
            onError();
        } else {
            if (QLog.isColorLevel()) {
                logRichMediaEvent("requestStart", richProtoReq.toString());
            }
            if (!canDoNextStep()) {
                return;
            }
            this.mRichProtoReq = richProtoReq;
            RichProtoProc.procRichProtoReq(richProtoReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void setMtype() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        NetReq netReq = this.mNetReq;
        if (netReq != null && (netReq instanceof HttpNetReq)) {
            ((HttpNetReq) netReq).mReqUrl = MsfSdkUtils.insertMtype(AppConstants.HTTP_TYPE_PTT_CU, ((HttpNetReq) netReq).mReqUrl);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.start();
            doStart(false);
        }
    }
}
