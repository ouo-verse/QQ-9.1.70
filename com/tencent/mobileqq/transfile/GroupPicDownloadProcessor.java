package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.r;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.quic.open.QuicEngineFactory;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes19.dex */
public class GroupPicDownloadProcessor extends BasePicDownloadProcessor {
    static IPatchRedirector $redirector_;
    long mGroupFileID;
    boolean mIsGroup;
    byte[] mMsgFileMd5;

    public GroupPicDownloadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mIsGroup = true;
        FileMsg fileMsg = this.file;
        TransferRequest transferRequest2 = this.mUiRequest;
        fileMsg.fileType = transferRequest2.mFileType;
        fileMsg.uniseq = transferRequest2.mUniseq;
        fileMsg.mSubMsgId = transferRequest2.mSubMsgId;
    }

    private boolean shouldReport(boolean z16) {
        TransferRequest transferRequest = this.mUiRequest;
        if (!transferRequest.mNeedReport || transferRequest.mBusiType == 1030) {
            return false;
        }
        if (!z16 && RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
            return false;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (processorReport.mIsOldDbRec || ((z16 && (processorReport.mReportedFlag & 2) > 0) || (!z16 && (processorReport.mReportedFlag & 1) > 0))) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        logRichMediaEvent("uiParam", this.mUiRequest.toString());
        String str = this.mUiRequest.mServerPath;
        if (str == null || str.equals("") || str.equals("null") || FileUtils.isLocalPath(str) || str.startsWith("http://")) {
            if (str != null && str.startsWith("http://")) {
                String parseUuidFromUrl = parseUuidFromUrl(str);
                if (parseUuidFromUrl != null) {
                    this.mUiRequest.mServerPath = parseUuidFromUrl;
                } else {
                    setError(9302, BaseTransProcessor.getExpStackString(new Exception("uuid illegal " + str)));
                    onError();
                    return -1;
                }
            } else {
                setError(9302, BaseTransProcessor.getExpStackString(new Exception("uuid illegal " + str)));
                onError();
                return -1;
            }
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest.mOut == null && transferRequest.useOutputstream) {
            setError(9302, BaseTransProcessor.getExpStackString(new Exception("no output stream")));
            onError();
            return -1;
        }
        Object obj = transferRequest.mExtraObj;
        if (obj != null && (obj instanceof TransferRequest.PicDownExtraInfo)) {
            this.mPicDownExtra = (TransferRequest.PicDownExtraInfo) obj;
            this.mRecvLen = r3.mStartDownOffset;
            boolean z16 = true;
            if (transferRequest.mUinType != 1) {
                z16 = false;
            }
            this.mIsGroup = z16;
            try {
                byte[] md5InBytesOfGroup = getMd5InBytesOfGroup(transferRequest.mMd5, transferRequest.mServerPath);
                this.mMsgFileMd5 = md5InBytesOfGroup;
                this.mGroupFileID = this.mUiRequest.mGroupFileID;
                if (md5InBytesOfGroup != null) {
                    return 0;
                }
                setError(9302, BaseTransProcessor.getExpStackString(new Exception("convert md5 error,md5:" + this.mUiRequest.mMd5 + "  uuid:" + this.mUiRequest.mServerPath)));
                onError();
                return -1;
            } catch (Exception unused) {
                setError(9302, BaseTransProcessor.getExpStackString(new Exception("convert md5 error,md5:" + this.mUiRequest.mMd5 + "  uuid:" + this.mUiRequest.mServerPath)));
                onError();
                return -1;
            }
        }
        setError(9302, BaseTransProcessor.getExpStackString(new Exception("extra obj")));
        onError();
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        int i3;
        StepInfo stepInfo;
        int i16;
        boolean z17;
        String str;
        String str2;
        String str3;
        boolean z18;
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        if (!z16) {
            String str4 = LogTag.RICH_MEDIA + TransFileUtil.getUinDesc(this.mUiRequest.mUinType) + "." + RichMediaUtil.getFileType(this.mUiRequest.mFileType);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("id:" + this.mUiRequest.mUniseq + "  ");
            sb5.append("errCode:" + this.mProcessorReport.errCode + "  ");
            StringBuilder sb6 = new StringBuilder();
            sb6.append("errDesc:");
            sb6.append(this.mProcessorReport.errDesc);
            sb5.append(sb6.toString());
            QLog.d(str4, 1, sb5.toString());
        }
        if (!shouldReport(z16)) {
            return;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        int i17 = processorReport.mReportedFlag;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        processorReport.mReportedFlag = i17 | i3;
        long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_STEP_INFO, this.mProcessorReport.mStepDirectDown.getReportInfo(1) + ";" + this.mProcessorReport.mStepUrl.getReportInfo(2) + ";" + this.mProcessorReport.mStepTrans.getReportInfo(3));
        ProcessorReport processorReport2 = this.mProcessorReport;
        HashMap<String, String> hashMap = processorReport2.mReportInfo;
        if (this.mDirectMsgUrlDown) {
            stepInfo = processorReport2.mStepDirectDown;
        } else {
            stepInfo = processorReport2.mStepTrans;
        }
        hashMap.put(ReportConstant.KEY_TRANS_CONSUME, String.valueOf(stepInfo.getTimeConsume()));
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_GROUP_ID, this.mUiRequest.mPeerUin);
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_UUID, this.mUiRequest.mServerPath);
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_DOWN_MODE, String.valueOf(this.mUiRequest.mDownMode));
        this.mProcessorReport.mReportInfo.put(QQNotificationManager.PARAM_UINTYPE, String.valueOf(this.mUiRequest.mUinType));
        ProcessorReport processorReport3 = this.mProcessorReport;
        processorReport3.mReportInfo.put(ReportConstant.KEY_SENDBY_QUICK_HTTP, String.valueOf(processorReport3.mSendByQuickHttp));
        HashMap<String, String> hashMap2 = this.mProcessorReport.mReportInfo;
        long j3 = this.mRecvLen;
        TransferRequest.PicDownExtraInfo picDownExtraInfo = this.mPicDownExtra;
        if (picDownExtraInfo == null) {
            i16 = 0;
        } else {
            i16 = picDownExtraInfo.mStartDownOffset;
        }
        hashMap2.put(ReportConstant.KEY_RECV_DATA_LEN, String.valueOf(j3 - i16));
        this.mProcessorReport.mReportInfo.put("param_directFailCode", String.valueOf(this.mSSORequestReason));
        this.mProcessorReport.mReportInfo.put("param_directFailDesc", "" + this.mDirectDownFailReason);
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_IN_QUEUE_COST, "" + this.inQueueCost);
        this.mProcessorReport.mReportInfo.put("ipFromDns", "" + this.mIpFromInnerDns);
        QuicNetReport quicNetReport = this.mQuicNetReport;
        if (quicNetReport != null && !quicNetReport.isHttpRetryed) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_IS_ENCRYPT_ROLLBACK, "" + this.mPicEncryptRollback + ",decryptErrorMsg:" + this.mDecryptErrorMsg);
        HashMap<String, String> hashMap3 = this.mProcessorReport.mReportInfo;
        String str5 = "1";
        if (this.mPicEncryptRollback) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap3.put(ReportConstant.KEY_ENC_RETRY, str);
        HashMap<String, String> hashMap4 = this.mProcessorReport.mReportInfo;
        if (z17) {
            str2 = "2";
        } else if (this.mIsHttpsDownload) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap4.put(ReportConstant.KEY_IS_HTTPS, str2);
        HashMap<String, String> hashMap5 = this.mProcessorReport.mReportInfo;
        if (z17) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap5.put(QuicNetReport.KEY_QUIC_DOWNLOAD, str3);
        HashMap<String, String> hashMap6 = this.mProcessorReport.mReportInfo;
        QuicNetReport quicNetReport2 = this.mQuicNetReport;
        if (quicNetReport2 == null || !quicNetReport2.success) {
            str5 = "0";
        }
        hashMap6.put(QuicNetReport.KEY_QUIC_DOWNLOAD_STATUS, str5);
        NetReq netReq = this.mNetReq;
        if (netReq != null && ((HttpNetReq) netReq).decoder != null) {
            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_DECRYPT_TIME, String.valueOf(((PicCryptor) ((HttpNetReq) netReq).decoder).f307065n));
        }
        if (this.mUiRequest.mUinType == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            GroupMsgMask groupMsgMask = GroupMsgMask.UNSPECIFIED;
            AppInterface appInterface2 = this.app;
            if (appInterface2 != null) {
                groupMsgMask = ((IConversationFacade) appInterface2.getRuntimeService(IConversationFacade.class, "")).getTroopMask(this.mUiRequest.mPeerUin);
            }
            this.mProcessorReport.mReportInfo.put("param_groupPolicy", String.valueOf(groupMsgMask.ordinal()));
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord == null && (appInterface = this.app) != null) {
            IMessageFacade iMessageFacade = (IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "");
            TransferRequest transferRequest = this.mUiRequest;
            messageRecord = iMessageFacade.getMsgItemByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
        }
        if (messageRecord != null && (messageRecord instanceof MessageForPic)) {
            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_IMAGETYPE, String.valueOf(((MessageForPic) messageRecord).imageType));
        }
        checkFailCodeReport(z16);
        if (z16) {
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
            reportForIpv6(false, nanoTime);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, nanoTime, 0L, this.mProcessorReport.mReportInfo, "");
        }
        setReportFlag();
        super.doReport(z16, BasePicDownloadProcessor.GROUP_PIC_DOWNLOAD_ERROR_CODE, nanoTime, this.mProcessorReport.mReportInfo);
        reportQuicNetState();
    }

    @Override // com.tencent.mobileqq.transfile.BasePicDownloadProcessor
    protected int getDnsType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return 1000;
    }

    @Override // com.tencent.mobileqq.transfile.BasePicDownloadProcessor
    protected String getHttpDomain() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return IPicTransFile.GROUP_PIC_DOWNLOAD_DOMAIN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest.mUinType == 1) {
            if (transferRequest.mFileType == 65537) {
                return StatisticCollector.TROOP_SMAILLPIC_DOWNLOAD_STATISTIC_TAG;
            }
            return StatisticCollector.TROOP_PIC_DOWNLOAD_STATISTIC_TAG;
        }
        if (transferRequest.mFileType == 65537) {
            return StatisticCollector.DISCUSSION_SMALLPIC_DOWNLOAD_STATISTIC_TAG;
        }
        return StatisticCollector.DISCUSSION_PIC_DOWNLOAD_STATISTIC_TAG;
    }

    @Override // com.tencent.mobileqq.transfile.BasePicDownloadProcessor
    public boolean isAllowEncrypt(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf downloadEncryptConf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) downloadEncryptConf)).booleanValue();
        }
        if (this.mUiRequest.bEnableEnc && downloadEncryptConf != null && (downloadEncryptConf.uint32_ctrl_flag.get() & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                RichProto.RichProtoResp.PicDownResp picDownResp = (RichProto.RichProtoResp.PicDownResp) richProtoResp.resps.get(i3);
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("procUrl", picDownResp.toString());
                }
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.mSendByQuickHttp = picDownResp.isSendByQuickHttp;
                processorReport.copyRespCommon(processorReport.mStepUrl, picDownResp);
                if (picDownResp.result == 0) {
                    this.mIpList = selectIpList(picDownResp.mIpv6List, picDownResp.mIpList);
                    this.mDownDomain = picDownResp.domain;
                    this.mUrlPath = picDownResp.urlPath;
                    if (QLog.isColorLevel()) {
                        logRichMediaEvent("proUrl", "picResp.protocolType = " + picDownResp.protocolType);
                    }
                    if (picDownResp.protocolType == 1) {
                        receiveFile(true);
                    } else {
                        receiveFile(false);
                    }
                } else {
                    onError();
                    return;
                }
            }
        }
    }

    String parseUuidFromUrl(String str) {
        int indexOf;
        String[] split;
        if (str != null) {
            try {
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
            } catch (Exception unused) {
            }
        }
        String str2 = null;
        if (str != null && !str.equals("null") && !str.startsWith("http://")) {
            return null;
        }
        if (str != null && str.length() > 0 && str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) && (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) >= 0 && indexOf < str.length() - 1 && (split = str.substring(indexOf + 1).split("\\&")) != null) {
            for (int i3 = 0; i3 < split.length; i3++) {
                if (split[i3].startsWith("pic=")) {
                    str2 = split[i3].substring(4);
                }
            }
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.transfile.BasePicDownloadProcessor
    void receiveFile(boolean z16, boolean z17) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        this.mIsHttpsDownload = z16;
        this.mRSMReporter.mIsHttps = z16;
        this.mProcessorReport.mStepTrans.logStartTime();
        if (this.mIsCancel) {
            return;
        }
        if (TextUtils.isEmpty(this.mDownDomain)) {
            if (z17) {
                str5 = IPicTransFile.GROUP_PIC_DOWNLOAD_QUIC_DOMAIN;
            } else {
                str5 = IPicTransFile.GROUP_PIC_DOWNLOAD_DOMAIN;
            }
            this.mDownDomain = str5;
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        if (z16) {
            str = "https://";
        } else {
            str = "http://";
        }
        if (this.isDomainTest) {
            ArrayList<ServerAddr> arrayList = this.mIpList;
            if (arrayList != null) {
                arrayList.clear();
            }
            httpNetReq.mIsHostIP = false;
            httpNetReq.mHostForHttpsVerify = IPicTransFile.GROUP_PIC_DOWNLOAD_DOMAIN;
            str2 = str + IPicTransFile.GROUP_PIC_DOWNLOAD_DOMAIN;
        } else {
            ArrayList<ServerAddr> arrayList2 = this.mIpList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                httpNetReq.mIsHostIP = true;
                ServerAddr serverAddr = this.mIpList.get(0);
                if (serverAddr.isIpv6 && !serverAddr.mIp.startsWith("[")) {
                    str3 = str + "[" + serverAddr.mIp + "]";
                } else {
                    str3 = str + serverAddr.mIp;
                }
                if (serverAddr.port != 80) {
                    str2 = str3 + ":" + serverAddr.port;
                } else {
                    str2 = str3;
                }
            } else {
                httpNetReq.mIsHostIP = false;
                str2 = str + this.mDownDomain;
            }
        }
        String fixUrl = getFixUrl(str2 + this.mUrlPath);
        boolean isSupportAvifDownload = isSupportAvifDownload();
        String appendInfoForSvr = appendInfoForSvr(fixUrl, isSupportAvifDownload);
        fixAvifOutFilePath(isSupportAvifDownload);
        httpNetReq.mCallback = this;
        httpNetReq.mFailedListener = this;
        httpNetReq.mReqUrl = appendInfoForSvr;
        httpNetReq.mIsHttps = z16;
        String str6 = this.mDownDomain;
        httpNetReq.mHostForHttpsVerify = str6;
        httpNetReq.mHttpMethod = 0;
        TransFileUtil.addDomainToList(this.mIpList, str6);
        httpNetReq.mServerList = this.mIpList;
        OldEngineDPCProfile oldEngineDPCProfile = this.mTimeoutProfile;
        if (oldEngineDPCProfile != null) {
            httpNetReq.mTimeoutParam = oldEngineDPCProfile.getTimeoutParam();
        }
        TransferRequest transferRequest = this.mUiRequest;
        httpNetReq.mOutPath = transferRequest.mOutFilePath;
        if (transferRequest.useOutputstream) {
            httpNetReq.mOutStream = transferRequest.mOut;
        }
        httpNetReq.mMsgId = String.valueOf(transferRequest.mUniseq);
        TransferRequest transferRequest2 = this.mUiRequest;
        httpNetReq.mBusiProtoType = transferRequest2.mUinType;
        httpNetReq.mFileType = transferRequest2.mFileType;
        httpNetReq.mIsNetChgAsError = true;
        httpNetReq.mStartDownOffset = 0L;
        httpNetReq.mWhiteListContentType = new String[]{"image"};
        if (isSupportAvifDownload) {
            if (transferRequest2.mRequestOffset > 0 || transferRequest2.mRequestLength > 0) {
                FileUtils.deleteFile(transferRequest2.mOutFilePath);
            }
            TransferRequest transferRequest3 = this.mUiRequest;
            transferRequest3.mRequestOffset = 0;
            transferRequest3.mRequestLength = 0;
        }
        int downloadStatus = getDownloadStatus(this.mUiRequest);
        if (downloadStatus == 4) {
            httpNetReq.mStartDownOffset = this.mUiRequest.mRequestOffset;
            httpNetReq.mEndDownOffset = 0L;
            httpNetReq.mIsRenameInEngine = false;
            httpNetReq.mReqProperties.put("Range", "bytes=" + this.mUiRequest.mRequestOffset + "-");
        } else if (downloadStatus != 3 && downloadStatus != 2) {
            httpNetReq.mEndDownOffset = 0L;
            httpNetReq.mReqProperties.put("Range", "bytes=" + httpNetReq.mStartDownOffset + "-");
        } else {
            httpNetReq.mStartDownOffset = this.mUiRequest.mRequestOffset;
            httpNetReq.mEndDownOffset = (r3 + r14.mRequestLength) - 1;
            httpNetReq.mIsRenameInEngine = false;
            httpNetReq.mReqProperties.put("Range", "bytes=" + this.mUiRequest.mRequestOffset + "-" + httpNetReq.mEndDownOffset);
        }
        httpNetReq.mReqProperties.put("Accept-Encoding", "identity");
        httpNetReq.mSupportBreakResume = !isSupportAvifDownload;
        httpNetReq.mReqProperties.put("Referer", "https://im.qq.com/mobileqq");
        encryptReqInit(httpNetReq, appendInfoForSvr);
        httpNetReq.mCanPrintUrl = true;
        httpNetReq.mUseCmwapConnectionTypeFromDpc = true;
        httpNetReq.mReqProperties.put(HttpMsg.MTYPE, AppConstants.HTTP_TYPE_PIC_CU);
        httpNetReq.mPrioty = this.mUiRequest.mPrioty;
        if (this.mDirectMsgUrlDown) {
            httpNetReq.mContinuErrorLimit = 0;
        }
        ArrayList<ServerAddr> arrayList3 = this.mIpList;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            str4 = Arrays.toString(this.mIpList.toArray());
        } else {
            str4 = null;
        }
        logRichMediaEvent("httpDown", "directMsgUrlDown:" + this.mDirectMsgUrlDown + ",req.mReqUrl = " + httpNetReq.mReqUrl + " ipList:" + str4 + " uuid:" + this.mUiRequest.mServerPath + " FileID:" + this.mUiRequest.mGroupFileID + " downOffset:" + httpNetReq.mStartDownOffset + ",isEncryptUrl:" + this.mEncryptUrl + ",isEncryptPic:" + this.mEncryptPic + ",isEncryptRollbackReq:" + this.mPicEncryptRollback);
        if (!canDoNextStep()) {
            return;
        }
        this.mNetReq = httpNetReq;
        setMtype();
        if (z17) {
            useQuicDownload(httpNetReq, QuicEngineFactory.createEngine());
        } else {
            sendHttpReq(httpNetReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendHttpReq(HttpNetReq httpNetReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) httpNetReq);
        } else {
            this.mNetEngine.sendReq(httpNetReq);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BasePicDownloadProcessor
    void sendRequest() {
        this.mProcessorReport.mStepUrl.logStartTime();
        this.mDirectMsgUrlDown = false;
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.GroupPicDownReq groupPicDownReq = new RichProto.RichProtoReq.GroupPicDownReq();
        TransferRequest transferRequest = this.mUiRequest;
        groupPicDownReq.selfUin = transferRequest.mSelfUin;
        groupPicDownReq.peerUin = transferRequest.mPeerUin;
        groupPicDownReq.secondUin = transferRequest.mSecondId;
        groupPicDownReq.uinType = transferRequest.mUinType;
        groupPicDownReq.fileType = transferRequest.mFileType;
        groupPicDownReq.groupFileID = this.mGroupFileID;
        groupPicDownReq.md5 = this.mMsgFileMd5;
        groupPicDownReq.msgTime = (int) transferRequest.mMsgTime;
        groupPicDownReq.protocolType = 0;
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.GRP_PIC_DW;
        richProtoReq.reqs.add(groupPicDownReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
        if (!isAppValid()) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
            onError();
            return;
        }
        QLog.i(BaseTransProcessor.TAG, 1, "sendRequest: req=" + this.mUiRequest + ", pic=" + groupPicDownReq);
        if (QLog.isColorLevel()) {
            logRichMediaEvent("requestStart", richProtoReq.toString());
        }
        if (!canDoNextStep()) {
            return;
        }
        this.mRichProtoReq = richProtoReq;
        RichProtoProc.procRichProtoReq(richProtoReq);
    }

    public void setError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            return;
        }
        this.mProcessorReport.setError(i3, str, null, null);
        if (i3 == 9302 && QLog.isColorLevel()) {
            String str2 = "setError,uuid:" + this.mUiRequest.mServerPath + " md5:" + this.mUiRequest.mMd5;
            QLog.d(BaseTransProcessor.TAG, 1, str2);
            r.a("Download_Pic_Error_Param_Check", str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void setMtype() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        int i3 = this.mUiRequest.mFileType;
        NetReq netReq = this.mNetReq;
        if (netReq instanceof HttpNetReq) {
            if (this.mIsGroup) {
                if (i3 == 2) {
                    ((HttpNetReq) netReq).mReqProperties.put(HttpMsg.MTYPE, AppConstants.HTTP_TYPE_PTT_GD);
                    return;
                } else {
                    ((HttpNetReq) netReq).mReqProperties.put(HttpMsg.MTYPE, AppConstants.HTTP_TYPE_PIC_GD);
                    return;
                }
            }
            if (i3 == 2) {
                ((HttpNetReq) netReq).mReqProperties.put(HttpMsg.MTYPE, AppConstants.HTTP_TYPE_PTT_DD);
            } else {
                ((HttpNetReq) netReq).mReqProperties.put(HttpMsg.MTYPE, AppConstants.HTTP_TYPE_PIC_DD);
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseDownloadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.start();
        if (this.mEncryptUrl && this.mEncryptPic && !checkMemoryForEncrypt()) {
            this.mEncryptUrl = false;
            this.mEncryptPic = false;
            sendRequest();
        } else {
            if (supportQuic() && getQuicToggleState()) {
                str = IPicTransFile.GROUP_PIC_DOWNLOAD_QUIC_DOMAIN;
            } else {
                str = IPicTransFile.GROUP_PIC_DOWNLOAD_DOMAIN;
            }
            directMsgUrlDown(str, 1000);
        }
    }

    protected boolean supportQuic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return true;
    }

    public GroupPicDownloadProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mIsGroup = true;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
