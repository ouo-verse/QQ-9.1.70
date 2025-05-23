package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import tencent.im.longconn.longmsg.LongMsg$MsgUpReq;
import tencent.im.longconn.longmsg.LongMsg$ReqBody;
import tencent.im.longconn.multimsg.UpFileRspExtInfo;
import tencent.im.msg.im_msg_head$Head;
import tencent.im.msg.im_msg_head$HttpConnHead;
import tencent.im.msg.im_msg_head$LoginSig;

/* loaded from: classes19.dex */
public class MultiMsgUpProcessor extends BaseUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MultiMsgUpProcessor";
    public static ExcitingTransferHostInfo mBDHIpv4;
    public static ExcitingTransferHostInfo mBDHIpv6;
    public static boolean mIsBDHImmediately;
    private static int seq;
    public boolean mIsByBDH;
    private String mLocalPath;
    private byte[] mMsgKey;
    private byte[] mResId;
    private boolean mSSCMSpanned;
    private byte[] mSig;
    private String mUUID;
    private int mUinType;
    private byte[] mUkey;
    public int multiMsgType;
    private long selfUin;
    private com.tencent.wstt.SSCM.a sscmObject;
    private long startTime;
    private byte[] toSendData;
    private byte[] toSendPBData;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76000);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            mIsBDHImmediately = true;
            seq = 0;
        }
    }

    public MultiMsgUpProcessor(TransFileControllerImpl transFileControllerImpl, TransferRequest transferRequest) {
        super(transFileControllerImpl, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) transFileControllerImpl, (Object) transferRequest);
            return;
        }
        this.startTime = -1L;
        this.sscmObject = new com.tencent.wstt.SSCM.a();
        this.mIsByBDH = true;
        this.mSSCMSpanned = false;
        TransferRequest transferRequest2 = this.mUiRequest;
        this.mLocalPath = transferRequest2.mLocalPath;
        this.mUinType = transferRequest2.mUinType;
        byte[] bArr = transferRequest.toSendData;
        this.toSendData = bArr;
        this.multiMsgType = transferRequest.multiMsgType;
        if (bArr != null) {
            this.mFileSize = bArr.length;
        } else {
            this.mFileSize = 0L;
        }
        try {
            this.selfUin = Long.parseLong(transferRequest2.mSelfUin);
        } catch (Exception e16) {
            e16.printStackTrace();
            this.selfUin = 0L;
        }
    }

    private boolean constructToSendData() {
        LongMsg$MsgUpReq longMsg$MsgUpReq = new LongMsg$MsgUpReq();
        longMsg$MsgUpReq.setHasFlag(true);
        longMsg$MsgUpReq.uint64_dst_uin.set(Long.valueOf(this.mUiRequest.mPeerUin).longValue());
        longMsg$MsgUpReq.bytes_msg_content.set(ByteStringMicro.copyFrom(this.toSendData));
        if (!mIsBDHImmediately) {
            longMsg$MsgUpReq.bytes_msg_ukey.set(ByteStringMicro.copyFrom(this.mUkey));
        }
        longMsg$MsgUpReq.uint32_store_type.set(2);
        if (this.mUiRequest.isJubaoMsgType) {
            longMsg$MsgUpReq.uint32_msg_type.set(17);
        } else {
            longMsg$MsgUpReq.uint32_msg_type.set(convertMsgType(this.mUinType));
        }
        LongMsg$ReqBody longMsg$ReqBody = new LongMsg$ReqBody();
        longMsg$ReqBody.setHasFlag(true);
        longMsg$ReqBody.uint32_subcmd.set(1);
        longMsg$ReqBody.uint32_term_type.set(5);
        longMsg$ReqBody.uint32_platform_type.set(9);
        longMsg$ReqBody.rpt_msg_up_req.add(longMsg$MsgUpReq);
        longMsg$ReqBody.uint32_busi_type.set(this.mUiRequest.upMsgBusiType);
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "constructToSendData called(). upMsgBusiType = " + this.mUiRequest.upMsgBusiType);
        }
        if (this.mIsByBDH && this.multiMsgType == 0) {
            longMsg$ReqBody.uint32_agent_type.set(1);
        }
        this.toSendPBData = longMsg$ReqBody.toByteArray();
        if (this.mIsByBDH) {
            return true;
        }
        byte[] encrypt = new Cryptor().encrypt(longMsg$ReqBody.toByteArray(), this.mMsgKey);
        im_msg_head$LoginSig im_msg_head_loginsig = new im_msg_head$LoginSig();
        im_msg_head_loginsig.uint32_type.set(22);
        im_msg_head_loginsig.bytes_sig.set(ByteStringMicro.copyFrom(this.mSig));
        String str = AppSetting.f99551k;
        String str2 = new String();
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) != '.') {
                str2 = str2.concat(Character.toString(str.charAt(i3)));
            }
        }
        im_msg_head$HttpConnHead im_msg_head_httpconnhead = new im_msg_head$HttpConnHead();
        im_msg_head_httpconnhead.uint64_uin.set(this.selfUin);
        im_msg_head_httpconnhead.uint32_command.set(1791);
        im_msg_head_httpconnhead.uint32_sub_command.set(1291);
        im_msg_head_httpconnhead.uint32_seq.set(getSeq());
        im_msg_head_httpconnhead.uint32_version.set(Integer.parseInt(str2));
        im_msg_head_httpconnhead.uint32_flag.set(1);
        im_msg_head_httpconnhead.uint32_compress_type.set(0);
        im_msg_head_httpconnhead.uint32_error_code.set(0);
        im_msg_head$Head im_msg_head_head = new im_msg_head$Head();
        im_msg_head_head.uint32_head_type.set(4);
        im_msg_head_head.msg_login_sig.set(im_msg_head_loginsig);
        im_msg_head_head.msg_httpconn_head.set(im_msg_head_httpconnhead);
        byte[] byteArray = im_msg_head_head.toByteArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.write(40);
            dataOutputStream.writeInt(byteArray.length);
            dataOutputStream.writeInt(encrypt.length);
            dataOutputStream.write(byteArray);
            dataOutputStream.write(encrypt);
            dataOutputStream.write(41);
            dataOutputStream.flush();
            this.toSendPBData = byteArrayOutputStream.toByteArray();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage());
            }
            this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERROR_UNKOWN_EXCEPTION, "constructToSendData() dos.write()", null, null);
            return false;
        }
    }

    public static int convertMsgType(int i3) {
        if (i3 == 1 || i3 == 3000) {
            return 3;
        }
        if (i3 != 1039) {
            if (i3 != 1040) {
                return 1;
            }
            return 15;
        }
        return 255;
    }

    private static int getSeq() {
        int i3 = seq;
        seq = i3 + 1;
        return i3;
    }

    private void sendRequest() {
        this.mProcessorReport.mStepUrl.logStartTime();
        RichProto.RichProtoReq.MultiMsgUpReq multiMsgUpReq = new RichProto.RichProtoReq.MultiMsgUpReq();
        multiMsgUpReq.size = this.mFileSize;
        multiMsgUpReq.md5 = this.mLocalMd5;
        multiMsgUpReq.multiMsgType = this.multiMsgType;
        TransferRequest transferRequest = this.mUiRequest;
        multiMsgUpReq.selfUin = transferRequest.mSelfUin;
        multiMsgUpReq.peerUin = transferRequest.mPeerUin;
        multiMsgUpReq.secondUin = transferRequest.mSecondId;
        multiMsgUpReq.uinType = transferRequest.mUinType;
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.MULTI_MSG_UP;
        richProtoReq.reqs.add(multiMsgUpReq);
        richProtoReq.protoReqMgr = getProtoReqManager();
        if (!isAppValid()) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
            onError();
            return;
        }
        if (QLog.isColorLevel()) {
            logRichMediaEvent("requestStart", richProtoReq.toString());
        }
        if (!canDoNextStep()) {
            return;
        }
        this.mRichProtoReq = richProtoReq;
        if (mIsBDHImmediately) {
            if (constructToSendData()) {
                sendFile();
            } else {
                onError();
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        super.checkParam();
        logRichMediaEvent("uiParam", this.mUiRequest.toString());
        if (this.toSendData != null && 0 < this.mFileSize && 0 != this.selfUin) {
            this.mExtName = "";
            return 0;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        boolean z17 = true;
        sb5.append(this.mProcessorReport.mStepUrl.getReportInfo(1));
        sb5.append(";");
        int i3 = 2;
        sb5.append(this.mProcessorReport.mStepTrans.getReportInfo(2));
        sb5.append(";");
        sb5.append(this.mProcessorReport.mStepMsg.getReportInfo(3));
        String sb6 = sb5.toString();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doDSReport : GroupPic doReport : result:" + z16);
        }
        if (this.mUiRequest.mBusiType == 1030) {
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
                    if (!z16) {
                        i3 = 1;
                    }
                    processorReport.mReportedFlag = i3 | i16;
                    processorReport.mEndTime = System.currentTimeMillis();
                    long nanoTime = System.nanoTime();
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    long j3 = (nanoTime - processorReport2.mStartTime) / 1000000;
                    processorReport2.mReportInfo.put(ReportConstant.KEY_STEP_INFO, sb6);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_GROUP_ID, this.mUiRequest.mPeerUin);
                    if (z16) {
                        if (this.reportTimeTrans <= 0 || this.reportTimePicCache <= 0) {
                            z17 = false;
                        }
                        if (this.isReportValid && z17) {
                            StringBuilder sb7 = new StringBuilder();
                            this.costReport = sb7;
                            sb7.append(ReportConstant.COSTREPORT_PREFIX);
                            sb7.append(this.segmentNum);
                            sb7.append("_");
                            sb7.append(ReportConstant.COSTREPORT_TRANS);
                            sb7.append(this.reportTimeTrans);
                            sb7.append("_");
                            sb7.append(ReportConstant.COSTREPORT_HT);
                            sb7.append(this.reportTimeHt);
                            sb7.append("_");
                            sb7.append("pic");
                            sb7.append(this.reportTimePicCache);
                            sb7.append(";");
                            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_COST_EACH, this.costReport.toString());
                            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SLICE_NUM, String.valueOf(this.segmentNum));
                        }
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.MULTIMSG_UPLOAD_STATISTIC_TAG, true, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
                    } else {
                        ProcessorReport processorReport3 = this.mProcessorReport;
                        if (processorReport3.errCode != -9527) {
                            processorReport3.mReportInfo.remove("param_rspHeader");
                        }
                        this.mProcessorReport.mReportInfo.remove("param_url");
                        ProcessorReport processorReport4 = this.mProcessorReport;
                        processorReport4.mReportInfo.put("param_FailCode", String.valueOf(processorReport4.errCode));
                        ProcessorReport processorReport5 = this.mProcessorReport;
                        processorReport5.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport5.errDesc);
                        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_MD5, this.mFileName);
                        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.mFileSize));
                        this.mProcessorReport.mReportInfo.put("param_busi", String.valueOf(this.mUiRequest.mBusiType));
                        this.mProcessorReport.mReportInfo.put(QQNotificationManager.PARAM_UINTYPE, String.valueOf(this.mUiRequest.mUinType));
                        this.mProcessorReport.mReportInfo.put("param_uniseq", String.valueOf(this.mUiRequest.mUniseq));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.MULTIMSG_UPLOAD_STATISTIC_TAG, false, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
                    }
                    setReportFlag();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    protected long getBlockSize(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, j3)).longValue();
        }
        return this.toSendPBData.length;
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    protected String getConnUrl(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bArr);
        }
        StringBuilder sb5 = new StringBuilder();
        ServerAddr serverAddr = this.mIpList.get(0);
        sb5.append("http://");
        sb5.append(serverAddr.mIp);
        if (serverAddr.port != 80) {
            sb5.append(":");
            sb5.append(serverAddr.port);
        }
        sb5.append("/cgi-bin/httpconn");
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public boolean getMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        byte[] mD5Byte = MD5.toMD5Byte(this.toSendData);
        this.mLocalMd5 = mD5Byte;
        if (mD5Byte == null) {
            this.mProcessorReport.setError(9041, "getMd5 error", null, null);
            return false;
        }
        String bytes2HexStr = HexUtil.bytes2HexStr(mD5Byte);
        this.mFileName = bytes2HexStr;
        this.mMd5Str = bytes2HexStr;
        this.file.fileMd5 = bytes2HexStr;
        this.mFileName += "." + this.mExtName;
        return true;
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public byte[] getStreamData(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return this.toSendPBData;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        List<RichProto.RichProtoResp.RespCommon> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp != null && (list = richProtoResp.resps) != null && list.size() != 0) {
            for (RichProto.RichProtoResp.RespCommon respCommon : richProtoResp.resps) {
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("procUrl", respCommon.toString());
                }
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.copyRespCommon(processorReport.mStepUrl, respCommon);
                RichProto.RichProtoResp.MultiMsgUpResp multiMsgUpResp = (RichProto.RichProtoResp.MultiMsgUpResp) respCommon;
                if (multiMsgUpResp.result == 0) {
                    byte[] bArr = multiMsgUpResp.resId;
                    this.mResId = bArr;
                    this.mUkey = multiMsgUpResp.ukey;
                    this.mIpList = multiMsgUpResp.ipList;
                    this.mMsgKey = multiMsgUpResp.msgKey;
                    this.mSig = multiMsgUpResp.msgSig;
                    try {
                        this.mUUID = new String(bArr, "utf-8");
                    } catch (UnsupportedEncodingException e16) {
                        e16.printStackTrace();
                    }
                    if (constructToSendData()) {
                        sendFile();
                    } else {
                        onError();
                    }
                } else {
                    this.mProcessorReport.setError(9007, "upResp.result=" + multiMsgUpResp.result, null, null);
                    onError();
                    return;
                }
            }
            return;
        }
        this.mProcessorReport.setError(9006, "resp == null || resp.resps == null || resp.resps.size() == 0", null, null);
        onError();
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onError();
        sendMessageToUpdate(1005);
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = -1;
            ProcessorReport processorReport = this.mProcessorReport;
            aVar.f258598b = processorReport.errCode;
            aVar.f258599c = processorReport.errDesc;
            aVar.f258608l = Long.valueOf(this.mUiRequest.mUniseq);
            this.mUiRequest.mUpCallBack.q(aVar);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) netResp);
            return;
        }
        super.onResp(netResp);
        if (!this.mIsCancel && !this.mIsPause) {
            this.mNetReq = null;
            logRichMediaEvent("onResp", "result:" + netResp.mResult + " errCode:" + netResp.mErrCode + " errDesc:" + netResp.mErrDesc);
            try {
                boolean z16 = false;
                if (netResp.mResult == 0) {
                    this.mNetworkChgRetryCount = 0;
                    if (netResp.mRespProperties.get(HttpMsg.USERRETURNCODE) != null) {
                        try {
                            i3 = Integer.parseInt(netResp.mRespProperties.get(HttpMsg.USERRETURNCODE));
                        } catch (NumberFormatException unused) {
                            i3 = Integer.MIN_VALUE;
                        }
                    } else {
                        i3 = Integer.MAX_VALUE;
                    }
                    if (i3 == 0 || i3 == Integer.MAX_VALUE) {
                        z16 = true;
                    }
                    ProcessorReport processorReport = this.mProcessorReport;
                    processorReport.copyStaticsInfoFromNetResp(processorReport.mStepTrans, netResp, z16);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
                    if (z16) {
                        logRichMediaEvent("onResp", "Success. SendTotalCost:" + uptimeMillis + "ms ,fileSize:" + this.file.fileSize + " ,code:" + i3);
                        onSuccess();
                        return;
                    }
                    this.mProcessorReport.setError(i3, "user return code error", null, null);
                    onError();
                    return;
                }
                ProcessorReport processorReport2 = this.mProcessorReport;
                processorReport2.copyStaticsInfoFromNetResp(processorReport2.mStepTrans, netResp, false);
                this.mProcessorReport.setError(netResp.mErrCode, netResp.mErrDesc, null, null);
                onError();
            } catch (Exception unused2) {
                this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERROR_DECODE_EXP, ProcessorReport.getExceptionMessage(new Exception("decode unknown exception")), "", this.mProcessorReport.mStepTrans);
                onError();
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onSuccess();
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258598b = 0;
            aVar.f258601e = this.mFileSize;
            aVar.f258603g = this.mMd5Str;
            aVar.f258608l = Long.valueOf(this.mUiRequest.mUniseq);
            try {
                aVar.f258602f = new String(this.mResId, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                aVar.f258598b = -1;
                String str = "Failed. Convert ResID to UTF-8 string failed, resID = " + this.mResId.toString();
                aVar.f258599c = str;
                logRichMediaEvent("onSuccess", str);
            }
            this.mUiRequest.mUpCallBack.q(aVar);
        }
        sendMessageToUpdate(1003);
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        if (this.mIsPause) {
            this.mIsPause = false;
            this.mIsCancel = false;
            sendMessageToUpdate(1002);
            this.mServerRollbackCount = 0;
            this.mTryCount = 0;
            this.mUkey = null;
            this.mReqUrlCount = 0;
            this.mTransferedSize = 0L;
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.errCode = 0;
            processorReport.errDesc = "";
            this.sscmObject.e();
            this.mController.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.transfile.MultiMsgUpProcessor.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiMsgUpProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        MultiMsgUpProcessor.this.start();
                    }
                }
            });
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public void sendFile() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.startTime == -1) {
            this.startTime = SystemClock.uptimeMillis();
        }
        this.mProcessorReport.mStepTrans.logStartTime();
        long j3 = this.mTransferedSize;
        long blockSize = getBlockSize(j3);
        byte[] streamData = getStreamData((int) j3, (int) blockSize);
        if (streamData == null) {
            onError();
            return;
        }
        logRichMediaEvent("sendingdata", "pos:" + j3 + "  transferData len:" + streamData.length);
        if (this.mIsByBDH) {
            String uuid = UUID.randomUUID().toString();
            this.mUUID = uuid;
            String filePath = AbsDownloader.getFilePath(uuid);
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
            FileUtils.writeFile(this.toSendPBData, filePath);
            this.mLocalPath = filePath;
            this.mUiRequest.mLocalPath = filePath;
            super.getMd5();
            ITransactionCallback iTransactionCallback = new ITransactionCallback() { // from class: com.tencent.mobileqq.transfile.MultiMsgUpProcessor.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiMsgUpProcessor.this);
                    }
                }

                @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
                public void onFailed(int i16, byte[] bArr, HashMap<String, String> hashMap) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, this, Integer.valueOf(i16), bArr, hashMap);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("MultiMsg_TAG", 2, "BDH.Upload fail  : result:" + i16);
                    }
                    MultiMsgUpProcessor.this.onError();
                }

                @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
                public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bArr, (Object) hashMap);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("MultiMsg_TAG", 2, "Multimsg upload file by BDH and onSuccess  ");
                    }
                    UpFileRspExtInfo upFileRspExtInfo = new UpFileRspExtInfo();
                    try {
                        upFileRspExtInfo.mergeFrom(bArr);
                        MultiMsgUpProcessor.this.mResId = upFileRspExtInfo.bytes_msg_res_id.get().toByteArray();
                        if (QLog.isDevelopLevel()) {
                            QLog.i("MultiMsg_TAG_opt", 2, "Multimsg upload file by BDH and onSuccess  " + new String(MultiMsgUpProcessor.this.mResId, "utf-8"));
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i("MultiMsg_TAG_opt", 2, "Multimsg upload file by BDH and onSuccess but exception + " + e16);
                        }
                        e16.printStackTrace();
                    }
                    File file2 = new File(AbsDownloader.getFilePath(MultiMsgUpProcessor.this.mUUID));
                    if (file2.exists()) {
                        file2.delete();
                    }
                    MultiMsgUpProcessor.this.onSuccess();
                }

                @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
                public void onSwitch2BackupChannel() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                        iPatchRedirector2.redirect((short) 6, (Object) this);
                    }
                }

                @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
                public void onTransStart() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                    }
                }

                @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
                public void onUpdateProgress(int i16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, i16);
                    }
                }
            };
            if (!mIsBDHImmediately) {
                i3 = 27;
            } else {
                i3 = 77;
            }
            this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i3, this.mLocalPath, 0, this.mLocalMd5, iTransactionCallback, (byte[]) null, false);
            int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.mTrans);
            if (QLog.isColorLevel()) {
                QLog.i("MultiMsg_TAG", 2, "Multimsg upload file by BDH and retCode = " + submitTransactionTask);
            }
            if (submitTransactionTask != 0) {
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.setError(submitTransactionTask, "SubmitError.", "", processorReport.mStepTrans);
                onError();
                return;
            }
            return;
        }
        HttpNetReq constructHttpNetReq = constructHttpNetReq(streamData);
        if (j3 + blockSize >= this.mFileSize) {
            constructHttpNetReq.mReqProperties.put("Connection", "close");
        }
        if (!canDoNextStep()) {
            return;
        }
        this.mNetReq = constructHttpNetReq;
        setMtype();
        this.mNetEngine.sendReq(constructHttpNetReq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void setMtype() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        NetReq netReq = this.mNetReq;
        if (netReq != null && (netReq instanceof HttpNetReq)) {
            if (ao.r(this.mUinType)) {
                str = AppConstants.HTTP_TYPE_MULTIMSG_CU;
            } else if (this.mUinType == 1) {
                str = AppConstants.HTTP_TYPE_MULTIMSG_GU;
            } else {
                str = AppConstants.HTTP_TYPE_MULTIMSG_DU;
            }
            NetReq netReq2 = this.mNetReq;
            ((HttpNetReq) netReq2).mReqUrl = MsfSdkUtils.insertMtype(str, ((HttpNetReq) netReq2).mReqUrl);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.start();
        sendMessageToUpdate(1000);
        byte[] bArr = this.toSendData;
        if (bArr != null && bArr.length != 0) {
            if (this.mLocalMd5 == null && !getMd5()) {
                onError();
                return;
            }
            AppInterface appInterface = this.app;
            if (appInterface != null && appInterface.getHwEngine() != null) {
                this.app.getHwEngine().preConnect();
            }
            sendRequest();
            return;
        }
        this.mProcessorReport.setError(9042, "data is empty", null, null);
        onError();
    }
}
