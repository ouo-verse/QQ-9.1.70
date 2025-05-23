package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import tencent.im.cs.cmd0x346.cmd0x346$DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346$RspBody;

/* loaded from: classes19.dex */
public class JSPttDownloadProcessor extends BaseDownloadProcessor {
    static IPatchRedirector $redirector_;
    String[] mProtoMsg;
    String mTempPath;

    public JSPttDownloadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        } else {
            this.mProtoMsg = null;
        }
    }

    private cmd0x346$ReqBody constructApplyDownSuccess() {
        int i3;
        cmd0x346$DownloadSuccReq cmd0x346_downloadsuccreq = new cmd0x346$DownloadSuccReq();
        cmd0x346_downloadsuccreq.uint64_uin.set(Long.parseLong(this.mUiRequest.mSelfUin));
        cmd0x346_downloadsuccreq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.mUiRequest.mServerPath));
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.uint32_cmd.set(1000);
        cmd0x346_reqbody.uint32_seq.set(0);
        if ("ftn".equals(this.mStorageSource)) {
            i3 = 3;
        } else {
            "pttcenter".equals(this.mStorageSource);
            i3 = 17;
        }
        cmd0x346_reqbody.uint32_business_id.set(i3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        cmd0x346_reqbody.msg_download_succ_req.set(cmd0x346_downloadsuccreq);
        return cmd0x346_reqbody;
    }

    private void sendPttDownSuccess() {
        logRichMediaEvent("setSuccess", "req");
        boolean equals = "pttcenter".equals(this.mStorageSource);
        String str = RichMediaConstants.CMD_PTTCENTER_PTT_DOWN_SUCC;
        if (!equals && "ftn".equals(this.mStorageSource)) {
            str = RichMediaConstants.CMD_OFFLINEFILE_PTT_DOWN_SUCC;
        }
        cmd0x346$ReqBody constructApplyDownSuccess = constructApplyDownSuccess();
        ProtoReqManagerImpl.ProtoReq protoReq = new ProtoReqManagerImpl.ProtoReq();
        protoReq.ssoCmd = str;
        protoReq.reqBody = constructApplyDownSuccess.toByteArray();
        protoReq.fixScheduleCount = 1;
        protoReq.tryTime = 30000;
        protoReq.tryCount = 1;
        protoReq.callback = this;
        if (!isAppValid()) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
            onError();
            return;
        }
        ((IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(protoReq);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        super.checkParam();
        logRichMediaEvent("uiParam", this.mUiRequest.toString());
        String str = this.mUiRequest.mServerPath;
        if (str != null && !str.equals("") && !str.equals("null") && !FileUtils.isLocalPath(str) && !str.startsWith("http://")) {
            return 0;
        }
        this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("uuid illegal " + str)), null, null);
        onError();
        return -1;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                RichProto.RichProtoResp.C2CPttDownResp c2CPttDownResp = (RichProto.RichProtoResp.C2CPttDownResp) richProtoResp.resps.get(i3);
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("procUrl", c2CPttDownResp.toString());
                }
                this.mProcessorReport.mSendByQuickHttp = c2CPttDownResp.isSendByQuickHttp;
                if (QLog.isColorLevel()) {
                    QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.mProcessorReport.mSendByQuickHttp);
                }
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.copyRespCommon(processorReport.mStepUrl, c2CPttDownResp);
                if (c2CPttDownResp.result == 0) {
                    String str = c2CPttDownResp.downloadUrl;
                    this.mRespUrl = str;
                    this.file.fileUrl = str;
                    recieveFile();
                } else {
                    onError();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        sendMessageToUpdate(2005);
    }

    protected void onJSPttSetSuccess(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, byte[] bArr) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, bArr);
            return;
        }
        logRichMediaEvent("setSuccess", "resp");
        if (fromServiceMsg.getResultCode() != 1000) {
            logRichMediaEvent("onC2CPttSetSuccess", "error,code:" + fromServiceMsg.getResultCode());
            return;
        }
        try {
            cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
            try {
                cmd0x346_rspbody.mergeFrom(bArr);
                if (cmd0x346_rspbody.uint32_cmd.has()) {
                    j3 = cmd0x346_rspbody.uint32_cmd.get();
                } else {
                    j3 = -1;
                }
                if (j3 == 1010 && cmd0x346_rspbody.msg_download_succ_rsp.has()) {
                    int i3 = cmd0x346_rspbody.msg_download_succ_rsp.get().int32_ret_code.get();
                    if (QLog.isColorLevel()) {
                        logRichMediaEvent("onC2CPttSetSuccess", "retcode:" + i3);
                    }
                }
            } catch (Exception unused) {
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) protoResp, (Object) protoReq);
        } else {
            FromServiceMsg fromServiceMsg = protoResp.resp;
            onJSPttSetSuccess(null, fromServiceMsg, fromServiceMsg.getWupBuffer());
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) netResp);
            return;
        }
        super.onResp(netResp);
        this.mNetReq = null;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" result:");
        boolean z17 = false;
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        logRichMediaEvent("onHttpResp", sb5.toString());
        ProcessorReport processorReport = this.mProcessorReport;
        StepInfo stepInfo = processorReport.mStepTrans;
        if (netResp.mResult == 0) {
            z17 = true;
        }
        processorReport.copyStaticsInfoFromNetResp(stepInfo, netResp, z17);
        long j3 = netResp.mTotalFileLen;
        this.mTotolLen = j3;
        if (j3 <= 0) {
            this.mTotolLen = netResp.mTotalBlockLen + netResp.mReq.mStartDownOffset;
        }
        this.mRecvLen += netResp.mWrittenBlockLen;
        if (netResp.mResult == 0) {
            ((IPttTempApi) QRoute.api(IPttTempApi.class)).setJsPttLocalPath(this.mUiRequest.mOutFilePath);
            sendPttDownSuccess();
            onSuccess();
        } else {
            if (netResp.mErrCode == 9364 && this.mNetworkChgRetryCount < 3) {
                logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
                this.mNetworkChgRetryCount++;
                clearReprotInfo();
                sendGetUrlReq();
                return;
            }
            onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        sendMessageToUpdate(2003);
    }

    void recieveFile() {
        String str;
        this.mProcessorReport.mStepTrans.logStartTime();
        String str2 = this.mRespUrl;
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = this;
        httpNetReq.mReqUrl = str2;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mServerList = this.mIpList;
        TransferRequest transferRequest = this.mUiRequest;
        httpNetReq.mOutPath = transferRequest.mOutFilePath;
        httpNetReq.mMsgId = String.valueOf(transferRequest.mUniseq);
        TransferRequest transferRequest2 = this.mUiRequest;
        httpNetReq.mBusiProtoType = transferRequest2.mUinType;
        httpNetReq.mFileType = transferRequest2.mFileType;
        httpNetReq.mStartDownOffset = 0L;
        httpNetReq.mIsNetChgAsError = true;
        httpNetReq.mReqProperties.put("Accept-Encoding", "identity");
        httpNetReq.mCanPrintUrl = true;
        httpNetReq.mSupportBreakResume = true;
        httpNetReq.mTempPath = this.mTempPath;
        ArrayList<ServerAddr> arrayList = this.mIpList;
        if (arrayList != null && !arrayList.isEmpty()) {
            str = Arrays.toString(this.mIpList.toArray());
        } else {
            str = null;
        }
        logRichMediaEvent("httpDown", "RespDomain: " + TransFileUtil.getIpOrDomainFromURL(str2) + " ipList:" + str + " uuid:" + this.mUiRequest.mServerPath + " downOffset:" + httpNetReq.mStartDownOffset);
        if (!canDoNextStep()) {
            return;
        }
        this.mNetReq = httpNetReq;
        setMtype();
        this.mNetEngine.sendReq(httpNetReq);
    }

    void sendGetUrlReq() {
        this.mProcessorReport.mStepUrl.logStartTime();
        this.mStorageSource = "pttcenter";
        logRichMediaEvent("findDbRec", "not found");
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.C2CPttDownReq c2CPttDownReq = new RichProto.RichProtoReq.C2CPttDownReq();
        TransferRequest transferRequest = this.mUiRequest;
        c2CPttDownReq.selfUin = transferRequest.mSelfUin;
        c2CPttDownReq.peerUin = transferRequest.mPeerUin;
        c2CPttDownReq.secondUin = transferRequest.mSecondId;
        c2CPttDownReq.uinType = transferRequest.mUinType;
        c2CPttDownReq.uuid = transferRequest.mServerPath;
        c2CPttDownReq.storageSource = this.mStorageSource;
        c2CPttDownReq.isSelfSend = transferRequest.mIsSelfSend;
        c2CPttDownReq.voiceType = 0;
        c2CPttDownReq.busiType = 102;
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.C2C_PTT_DW;
        richProtoReq.reqs.add(c2CPttDownReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        NetReq netReq = this.mNetReq;
        if (netReq != null && (netReq instanceof HttpNetReq)) {
            ((HttpNetReq) netReq).mReqUrl = MsfSdkUtils.insertMtype(AppConstants.HTTP_TYPE_PTT_CD, ((HttpNetReq) netReq).mReqUrl);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseDownloadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.start();
        sendMessageToUpdate(2001);
        sendGetUrlReq();
    }
}
