package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.ptt.api.impl.PttInfoCollectorImpl;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import tencent.im.cs.cmd0x346.cmd0x346$DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346$RspBody;

/* loaded from: classes19.dex */
public class C2CPttDownloadProcessor extends BasePttDownloaderProcessor implements Runnable, NetFailedListener {
    static IPatchRedirector $redirector_;
    String mDirectDownloadURL;
    private TransferRequest.PttDownExtraInfo mExtraInfo;
    private long mMsgRecTime;
    private long mMsgTime;
    String[] mProtoMsg;
    MessageForPtt mPtt;
    String mTempPath;
    private boolean useUrlIp;

    public C2CPttDownloadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mProtoMsg = null;
        this.mDirectDownloadURL = null;
        this.useUrlIp = false;
    }

    private File getUnfinishedStreamFile(long j3, long j16) {
        com.tencent.mobileqq.streamtransfile.c value;
        Map.Entry<String, com.tencent.mobileqq.streamtransfile.c> streamFileInfoEntryByMsg = ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).getStreamFileInfoEntryByMsg(j3, j16);
        if (QLog.isColorLevel()) {
            QLog.d(BaseTransProcessor.TAG, 2, "try get stream info " + j3 + " " + j16 + " " + streamFileInfoEntryByMsg);
        }
        if (streamFileInfoEntryByMsg != null && (value = streamFileInfoEntryByMsg.getValue()) != null) {
            ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(streamFileInfoEntryByMsg.getKey());
            value.c(false);
            File e16 = value.e();
            if (e16 != null && e16.exists()) {
                return e16;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        super.checkParam();
        logRichMediaEvent("uiParam", this.mUiRequest.toString());
        String str = this.mUiRequest.mServerPath;
        IPttTempApi iPttTempApi = (IPttTempApi) QRoute.api(IPttTempApi.class);
        AppInterface appInterface = ((BasePttDownloaderProcessor) this).app;
        TransferRequest transferRequest = this.mUiRequest;
        MessageRecord msgItemByUniseq = iPttTempApi.getMsgItemByUniseq(appInterface, transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
        if (msgItemByUniseq != null && msgItemByUniseq.getPttStreamFlag() == 10001) {
            this.mProcessorReport.mIsOldDbRec = true;
        }
        if (str != null && !str.equals("") && !str.equals("null") && !FileUtils.isLocalPath(str) && !str.startsWith("http://")) {
            TransferRequest transferRequest2 = this.mUiRequest;
            MessageForPtt messageForPtt = (MessageForPtt) transferRequest2.mRec;
            this.mPtt = messageForPtt;
            this.mExtraInfo = (TransferRequest.PttDownExtraInfo) transferRequest2.mExtraObj;
            this.mMsgTime = messageForPtt.msgTime;
            this.mMsgRecTime = messageForPtt.msgRecTime;
            int i3 = messageForPtt.voiceType;
            if (transferRequest2.mOutFilePath == null || !FileUtils.isLocalPath(transferRequest2.mLocalPath)) {
                String str2 = this.mPtt.fullLocalPath;
                if (str2 != null && !str2.equals("")) {
                    this.mUiRequest.mOutFilePath = this.mPtt.fullLocalPath;
                } else {
                    this.mUiRequest.mOutFilePath = getPttStorePath("c2c", str, i3);
                }
                this.mTempPath = this.mUiRequest.mOutFilePath + "~tmp";
                MessageRecord messageRecord = this.mUiRequest.mRec;
                File unfinishedStreamFile = getUnfinishedStreamFile(messageRecord.msgUid, messageRecord.shmsgseq);
                if (unfinishedStreamFile != null) {
                    File file = new File(this.mTempPath);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    unfinishedStreamFile.renameTo(file);
                    return 0;
                }
                return 0;
            }
            return 0;
        }
        this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("uuid illegal " + str)), null, null);
        onError();
        return -1;
    }

    cmd0x346$ReqBody constructApplyDownSuccess() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        int i3;
        String str;
        String str2;
        String str3;
        ServerAddr ipAndPortFromUrl;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        if (!z16 && RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
            return;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (!processorReport.mIsOldDbRec) {
            if (!z16 || (processorReport.mReportedFlag & 2) <= 0) {
                if (z16 || (processorReport.mReportedFlag & 1) <= 0) {
                    int i16 = processorReport.mReportedFlag;
                    if (z16) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    processorReport.mReportedFlag = i16 | i3;
                    long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_STEP_INFO, this.mProcessorReport.mStepDirectDown.getReportInfo(1) + ";" + this.mProcessorReport.mStepUrl.getReportInfo(2) + ";" + this.mProcessorReport.mStepTrans.getReportInfo(3) + ";" + this.mProcessorReport.mStepMsg.getReportInfo(4));
                    HashMap<String, String> hashMap = this.mProcessorReport.mReportInfo;
                    if (this.mIsHttpsDownload) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    hashMap.put(ReportConstant.KEY_IS_HTTPS, str);
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    processorReport2.mReportInfo.put(ReportConstant.KEY_TRANS_CONSUME, String.valueOf(processorReport2.mStepTrans.getTimeConsume()));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_FROM_UIN, this.mUiRequest.mPeerUin);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_UUID, this.mUiRequest.mServerPath);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PTT_WRITTEN_SIZE, String.valueOf(this.mRecvLen));
                    ProcessorReport processorReport3 = this.mProcessorReport;
                    processorReport3.mReportInfo.put(ReportConstant.KEY_SENDBY_QUICK_HTTP, String.valueOf(processorReport3.mSendByQuickHttp));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PTT_OPT, String.valueOf(((IPttOptimizeParams) QRoute.api(IPttOptimizeParams.class)).getOptString(((BasePttDownloaderProcessor) this).app, this.useUrlIp)));
                    if (QLog.isColorLevel()) {
                        QLog.d(BaseTransProcessor.TAG, 2, "totle=" + this.mTotolLen + " written=" + this.mRecvLen);
                    }
                    if (QLog.isDevelopLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("C2cPttDownload success: ");
                        sb5.append(z16);
                        sb5.append(", cost: ");
                        sb5.append(nanoTime);
                        sb5.append(" directDownloadIfCan: ");
                        if (this.mDirectDownloadURL != null) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        sb5.append(z17);
                        QLog.d("SPD", 4, sb5.toString());
                    }
                    try {
                        if (z16) {
                            this.mProcessorReport.mReportInfo.put("param_isSuccess", "1");
                            reportForIpv6(true, nanoTime);
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, nanoTime, this.mTotolLen, this.mProcessorReport.mReportInfo, "");
                        } else {
                            ProcessorReport processorReport4 = this.mProcessorReport;
                            if (processorReport4.errCode != -9527) {
                                processorReport4.mReportInfo.remove("param_rspHeader");
                            }
                            ProcessorReport processorReport5 = this.mProcessorReport;
                            processorReport5.mReportInfo.put("param_FailCode", String.valueOf(processorReport5.errCode));
                            ProcessorReport processorReport6 = this.mProcessorReport;
                            processorReport6.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport6.errDesc);
                            NetReq netReq = this.mNetReq;
                            if ((netReq instanceof HttpNetReq) && (ipAndPortFromUrl = TransFileUtil.getIpAndPortFromUrl(((HttpNetReq) netReq).mReqUrl)) != null) {
                                this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_REQ_IP, ipAndPortFromUrl.mIp);
                            }
                            this.mProcessorReport.mReportInfo.put("param_isSuccess", "0");
                            reportForIpv6(false, nanoTime);
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, nanoTime, 0L, this.mProcessorReport.mReportInfo, "");
                            ProcessorReport processorReport7 = this.mProcessorReport;
                            if (processorReport7.errCode == -9527 && (str2 = processorReport7.errDesc) != null && str2.equals("H_400_-5103017")) {
                                if (this.mMsgRecTime > this.mMsgTime) {
                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                                    long j3 = this.mMsgRecTime;
                                    long j16 = this.mMsgTime;
                                    hashMap2.put("MsgOff", String.valueOf((j3 - j16) / 86400));
                                    hashMap2.put("PttOff", String.valueOf((currentTimeMillis - j3) / 86400));
                                    hashMap2.put("OutOfTimeReason", String.valueOf(256));
                                    hashMap2.put("param_FailCode", String.valueOf((currentTimeMillis - j16) / 86400));
                                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actC2CPTTOutOfTime", false, 0L, 0L, hashMap2, null);
                                }
                                TransferRequest transferRequest = this.mUiRequest;
                                Object obj = transferRequest.mExtraObj;
                                if (obj != null) {
                                    if (transferRequest.mUinType == 0) {
                                        str3 = "0X80059B2";
                                    } else {
                                        str3 = "0X80059B4";
                                    }
                                    String str4 = str3;
                                    TransferRequest.PttDownExtraInfo pttDownExtraInfo = (TransferRequest.PttDownExtraInfo) obj;
                                    ReportController.o(((BasePttDownloaderProcessor) this).app, "CliOper", "", "", str4, str4, PttInfoCollectorImpl.mergeDownloadPTTFromType(pttDownExtraInfo.mFromType, pttDownExtraInfo.mLayer), 0, "", "", "", AppSetting.f99551k);
                                }
                            }
                        }
                        setReportFlag();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(BaseTransProcessor.TAG, 2, "report exception =" + e16.toString());
                        }
                    }
                    MessageForPtt messageForPtt = this.mPtt;
                    if (messageForPtt != null) {
                        ((IPTTPreDownloader) ((BasePttDownloaderProcessor) this).app.getRuntimeService(IPTTPreDownloader.class, "all")).onDownloadFinish(z16, this.mProcessorReport.errCode, this.mExtraInfo, messageForPtt);
                    }
                }
            }
        }
    }

    public String getDomainRequest(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (str.startsWith("http://")) {
            str2 = "http://" + this.mDownDomain;
        } else if (str.startsWith("https://")) {
            str2 = "https://" + this.mDownDomain;
        } else {
            str2 = null;
        }
        return TransFileUtil.replaceIp(str, str2 + "/");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return StatisticCollector.C2C_PUSHTALK_PTT_DOWNLOAD_STATISTIC_TAG;
    }

    boolean isFailedByOverDue() {
        String str;
        ProcessorReport processorReport = this.mProcessorReport;
        if (processorReport.errCode == -9527 && (str = processorReport.errDesc) != null && (str.equals("H_400_-5103017") || this.mProcessorReport.errDesc.equals("H_400_-5103039"))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
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
                    if (str != null && str.startsWith("https://")) {
                        this.mIsHttpsDownload = true;
                        this.mRSMReporter.mIsHttps = true;
                    }
                    this.file.fileUrl = this.mRespUrl;
                    String str2 = c2CPttDownResp.domainV4V6;
                    if (str2 != null && str2.length() > 0) {
                        this.mDownDomain = c2CPttDownResp.domainV4V6;
                    }
                    ArrayList<ServerAddr> selectIpList = selectIpList(c2CPttDownResp.mIpv6List, c2CPttDownResp.mIpList);
                    this.mIpList = selectIpList;
                    if (this.isDomainTest) {
                        this.mDownDomain = BaseDownloadProcessor.PTT_VIDEO_DOWNLOAD_DOMAIN;
                        selectIpList.clear();
                    }
                    recieveFile();
                } else {
                    onError();
                    return;
                }
            }
        }
    }

    protected void onC2CPttSetSuccess(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, byte[] bArr) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, bArr);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        if (this.mUiRequest.mDownCallBack != null) {
            c.a aVar = new c.a();
            aVar.f258654a = -1;
            this.mUiRequest.mDownCallBack.h(aVar);
            return;
        }
        sendMessageToUpdate(2005);
    }

    @Override // com.tencent.mobileqq.transfile.NetFailedListener
    public void onFailed(NetResp netResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) netResp);
            return;
        }
        this.mRSMReporter.mFileSize = this.mRecvLen;
        reportForServerMonitor(netResp, false, RMServMonitorReport.REPORT_NAME_NM_PTTDOWN, this.mUiRequest.mServerPath);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) protoResp, (Object) protoReq);
        } else {
            FromServiceMsg fromServiceMsg = protoResp.resp;
            onC2CPttSetSuccess(null, fromServiceMsg, fromServiceMsg.getWupBuffer());
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        StepInfo stepInfo;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) netResp);
            return;
        }
        super.onResp(netResp);
        if (this.mDirectDownloadURL != null) {
            stepInfo = this.mProcessorReport.mStepDirectDown;
            ThreadManager.getSubThreadHandler().removeCallbacks(this);
        } else {
            stepInfo = this.mProcessorReport.mStepTrans;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" result:");
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        logRichMediaEvent("onHttpResp", sb5.toString());
        ProcessorReport processorReport = this.mProcessorReport;
        if (netResp.mResult == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        processorReport.copyStaticsInfoFromNetResp(stepInfo, netResp, z17);
        long j3 = netResp.mTotalFileLen;
        this.mTotolLen = j3;
        if (j3 <= 0) {
            this.mTotolLen = netResp.mTotalBlockLen + netResp.mReq.mStartDownOffset;
        }
        this.mRecvLen += netResp.mWrittenBlockLen;
        if (netResp.mResult == 0) {
            sendPttDownSuccess();
            onSuccess();
            this.mRSMReporter.mFileSize = this.mRecvLen;
            reportForServerMonitor(netResp, true, RMServMonitorReport.REPORT_NAME_NM_PTTDOWN, this.mUiRequest.mServerPath);
            if (this.mDirectDownloadURL != null) {
                reportDirectDownload(0);
            }
        } else {
            if (this.mDirectDownloadURL != null) {
                requestUrlWhileDirectFailed(false);
                return;
            }
            if (netResp.mErrCode == 9364 && this.mNetworkChgRetryCount < 3) {
                logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
                this.mNetReq = null;
                this.mNetworkChgRetryCount++;
                clearReprotInfo();
                sendGetUrlReq();
                return;
            }
            onError();
        }
        this.mNetReq = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        String str;
        super.onSuccess();
        MessageForPtt messageForPtt = this.mPtt;
        messageForPtt.url = MessageForPtt.getMsgFilePath(messageForPtt.voiceType, this.mUiRequest.mOutFilePath);
        MessageForPtt messageForPtt2 = this.mPtt;
        messageForPtt2.fileSize = this.mTotolLen;
        messageForPtt2.urlAtServer = this.mUiRequest.mServerPath;
        Message updateMessageDataBaseContent = updateMessageDataBaseContent(messageForPtt2);
        if (updateMessageDataBaseContent != null && (str = this.mUiRequest.mServerPath) != null && str.equals(updateMessageDataBaseContent.pttUrl)) {
            updateMessageDataBaseContent.pttUrl = this.mUiRequest.mOutFilePath;
        }
        AppInterface appInterface = ((BasePttDownloaderProcessor) this).app;
        if (appInterface != null && ((ISttManagerService) appInterface.getRuntimeService(ISttManagerService.class, "all")).needAuotoChange(this.mPtt)) {
            ReportController.o(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
            ((ISttManagerService) ((BasePttDownloaderProcessor) this).app.getRuntimeService(ISttManagerService.class, "all")).translate(this.mPtt, 2);
        }
        if (this.mUiRequest.mDownCallBack != null) {
            c.a aVar = new c.a();
            aVar.f258654a = 0;
            this.mUiRequest.mDownCallBack.h(aVar);
            return;
        }
        sendMessageToUpdate(2003);
    }

    void recieveFile() {
        String domainRequest;
        this.mProcessorReport.mStepTrans.logStartTime();
        String str = this.mRespUrl;
        if (TextUtils.isEmpty(this.mDownDomain)) {
            this.mDownDomain = BaseDownloadProcessor.PTT_VIDEO_DOWNLOAD_DOMAIN;
        }
        ArrayList<ServerAddr> arrayList = this.mIpList;
        if (arrayList != null && arrayList.size() > 0) {
            domainRequest = TransFileUtil.replaceIp(str, this.mIpList.get(0).getServerUrl(str));
            this.mIpList.remove(0);
        } else {
            domainRequest = getDomainRequest(str);
        }
        TransFileUtil.addDomainToList(this.mIpList, this.mDownDomain);
        recieveFile(domainRequest);
    }

    void reportDirectDownload(int i3) {
        boolean z16;
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", String.valueOf(i3));
            StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            statisticCollector.collectPerformance(null, "C2CPTTDirectUrl", z16, 0L, 0L, hashMap, null);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:8:0x0010, B:10:0x0014, B:15:0x002b, B:16:0x003a, B:18:0x0041, B:20:0x004c, B:21:0x0054, B:23:0x005a, B:24:0x006a, B:25:0x0067, B:26:0x0050, B:27:0x001e, B:30:0x006d), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041 A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:8:0x0010, B:10:0x0014, B:15:0x002b, B:16:0x003a, B:18:0x0041, B:20:0x004c, B:21:0x0054, B:23:0x005a, B:24:0x006a, B:25:0x0067, B:26:0x0050, B:27:0x001e, B:30:0x006d), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:8:0x0010, B:10:0x0014, B:15:0x002b, B:16:0x003a, B:18:0x0041, B:20:0x004c, B:21:0x0054, B:23:0x005a, B:24:0x006a, B:25:0x0067, B:26:0x0050, B:27:0x001e, B:30:0x006d), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005a A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:8:0x0010, B:10:0x0014, B:15:0x002b, B:16:0x003a, B:18:0x0041, B:20:0x004c, B:21:0x0054, B:23:0x005a, B:24:0x006a, B:25:0x0067, B:26:0x0050, B:27:0x001e, B:30:0x006d), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067 A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:8:0x0010, B:10:0x0014, B:15:0x002b, B:16:0x003a, B:18:0x0041, B:20:0x004c, B:21:0x0054, B:23:0x005a, B:24:0x006a, B:25:0x0067, B:26:0x0050, B:27:0x001e, B:30:0x006d), top: B:3:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050 A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:8:0x0010, B:10:0x0014, B:15:0x002b, B:16:0x003a, B:18:0x0041, B:20:0x004c, B:21:0x0054, B:23:0x005a, B:24:0x006a, B:25:0x0067, B:26:0x0050, B:27:0x001e, B:30:0x006d), top: B:3:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void requestUrlWhileDirectFailed(boolean z16) {
        boolean z17;
        String str;
        synchronized (BaseTransProcessor.TAG) {
            if (this.mDirectDownloadURL != null) {
                ProcessorReport processorReport = this.mProcessorReport;
                if ((processorReport.errCode != -9527 || (str = processorReport.errDesc) == null || !str.equals("H_400_-5103017")) && this.mProcessorReport.errCode != 9366) {
                    z17 = true;
                    if (z17) {
                        ((IPttTempApi) QRoute.api(IPttTempApi.class)).doOnPttSrvAddressError(this.useUrlIp, this.mDirectDownloadURL);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("SPD", 4, "c2c directDownloadIfCan error");
                    }
                    if (!z16) {
                        reportDirectDownload(4);
                    } else {
                        reportDirectDownload(3);
                    }
                    if (!isFailedByOverDue()) {
                        MessageForPtt messageForPtt = this.mPtt;
                        messageForPtt.fileSize = 2005L;
                        updateMessageDataBaseContent(messageForPtt);
                        onError();
                    } else {
                        sendGetUrlReq();
                    }
                    this.mDirectDownloadURL = null;
                }
                z17 = false;
                if (z17) {
                }
                if (QLog.isDevelopLevel()) {
                }
                if (!z16) {
                }
                if (!isFailedByOverDue()) {
                }
                this.mDirectDownloadURL = null;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.mNetReq != null) {
            if (QLog.isColorLevel()) {
                QLog.e("SPD", 2, "Direct download failed overtime = " + this.mDirectDownloadURL);
            }
            this.mNetEngine.cancelReq(this.mNetReq);
            this.mNetReq = null;
        }
        requestUrlWhileDirectFailed(true);
    }

    void sendGetUrlReq() {
        this.mProcessorReport.mStepUrl.logStartTime();
        IPttTempApi iPttTempApi = (IPttTempApi) QRoute.api(IPttTempApi.class);
        AppInterface appInterface = ((BasePttDownloaderProcessor) this).app;
        TransferRequest transferRequest = this.mUiRequest;
        MessageRecord msgItemByUniseq = iPttTempApi.getMsgItemByUniseq(appInterface, transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
        if (msgItemByUniseq != null && (msgItemByUniseq instanceof MessageForPtt)) {
            this.mStorageSource = ((MessageForPtt) msgItemByUniseq).storageSource;
        } else {
            this.mStorageSource = "pttcenter";
            logRichMediaEvent("findDbRec", "not found");
        }
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.C2CPttDownReq c2CPttDownReq = new RichProto.RichProtoReq.C2CPttDownReq();
        TransferRequest transferRequest2 = this.mUiRequest;
        c2CPttDownReq.selfUin = transferRequest2.mSelfUin;
        c2CPttDownReq.peerUin = transferRequest2.mPeerUin;
        c2CPttDownReq.secondUin = transferRequest2.mSecondId;
        int i3 = transferRequest2.mUinType;
        c2CPttDownReq.uinType = i3;
        c2CPttDownReq.uuid = transferRequest2.mServerPath;
        c2CPttDownReq.storageSource = this.mStorageSource;
        c2CPttDownReq.isSelfSend = transferRequest2.mIsSelfSend;
        MessageForPtt messageForPtt = this.mPtt;
        c2CPttDownReq.voiceType = messageForPtt.voiceType;
        c2CPttDownReq.autoToText = messageForPtt.autoToText;
        if (1008 == i3) {
            c2CPttDownReq.busiType = messageForPtt.busiType;
        }
        c2CPttDownReq.downType = transferRequest2.mDownMode;
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.C2C_PTT_DW;
        richProtoReq.reqs.add(c2CPttDownReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) ((BasePttDownloaderProcessor) this).app.getRuntimeService(IProtoReqManager.class, "");
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

    void sendPttDownSuccess() {
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
        ((IProtoReqManager) ((BasePttDownloaderProcessor) this).app.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(protoReq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void setMtype() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
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
        int i3 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        MessageForPtt messageForPtt = this.mPtt;
        if (messageForPtt.extFlag == -1) {
            messageForPtt.extFlag = 0L;
        }
        if (this.mExtraInfo.mFromType == 6) {
            messageForPtt.extFlag |= 1;
        }
        super.start();
        IPttInfoCollector iPttInfoCollector = (IPttInfoCollector) QRoute.api(IPttInfoCollector.class);
        AppInterface appInterface = ((BasePttDownloaderProcessor) this).app;
        if (this.mUiRequest.mUinType == 0) {
            i3 = 1;
        }
        iPttInfoCollector.reportPTTPV(appInterface, i3, false, 2);
        if (!this.mUiRequest.mOutFilePath.equals(this.mPtt.fullLocalPath)) {
            MessageForPtt messageForPtt2 = this.mPtt;
            messageForPtt2.fullLocalPath = this.mUiRequest.mOutFilePath;
            updateMessageDataBaseContent(messageForPtt2);
        }
        sendGetUrlReq();
    }

    Message updateMessageDataBaseContent(MessageForPtt messageForPtt) {
        try {
            messageForPtt.serial();
            IPttTempApi iPttTempApi = (IPttTempApi) QRoute.api(IPttTempApi.class);
            AppInterface appInterface = ((BasePttDownloaderProcessor) this).app;
            TransferRequest transferRequest = this.mUiRequest;
            iPttTempApi.updateMsgContentByUniseq(appInterface, transferRequest.mPeerUin, transferRequest.mUinType, messageForPtt.uniseq, messageForPtt.msgData);
            return ((IPttTempApi) QRoute.api(IPttTempApi.class)).getLastMessage(((BasePttDownloaderProcessor) this).app, this.mUiRequest.mPeerUin, 0);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(BaseTransProcessor.TAG, 2, "updatedb", e16);
            }
            return null;
        }
    }

    public C2CPttDownloadProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mProtoMsg = null;
        this.mDirectDownloadURL = null;
        this.useUrlIp = false;
    }

    void recieveFile(String str) {
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = this;
        httpNetReq.mFailedListener = this;
        httpNetReq.mReqUrl = str;
        if (str.startsWith("https://")) {
            httpNetReq.mIsHttps = true;
        }
        httpNetReq.mHostForHttpsVerify = this.mDownDomain;
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
        httpNetReq.mUseCmwapConnectionTypeFromDpc = true;
        if (this.mDirectDownloadURL != null) {
            httpNetReq.mExcuteTimeLimit = 120000L;
            httpNetReq.mContinuErrorLimit = 0;
        }
        ArrayList<ServerAddr> arrayList = this.mIpList;
        String arrays = (arrayList == null || arrayList.isEmpty()) ? null : Arrays.toString(this.mIpList.toArray());
        logRichMediaEvent("httpDown", "RespDomain: " + TransFileUtil.getIpOrDomainFromURL(str) + " ipList:" + arrays + " uuid:" + this.mUiRequest.mServerPath + " downOffset:" + httpNetReq.mStartDownOffset);
        if (canDoNextStep()) {
            this.mNetReq = httpNetReq;
            setMtype();
            this.mNetEngine.sendReq(httpNetReq);
        }
    }
}
