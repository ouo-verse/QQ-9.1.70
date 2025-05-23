package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.ptt.temp.api.IPttTransferTempApi;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.transfile.protohandler.BaseHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388$ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388$RspBody;
import tencent.im.cs.cmd0x388.cmd0x388$TryUpPttReq;
import tencent.im.cs.cmd0x388.cmd0x388$TryUpPttRsp;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$ElemFlags2;
import tencent.im.msg.im_msg_body$Ptt;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes19.dex */
public class GroupPttUploadProcessor extends BaseUploadProcessor implements IVoiceChangeHelper.a, INetEventHandler, IGroupPttUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final boolean NEW_STORE_FLAG = true;
    public static final String TAG = "GroupPttUploadProcessor";
    AppInterface app;
    BaseTransFileController mController;
    long mFileID;
    String mGroupFileKeyStr;
    boolean mHasVirtualStarted;
    boolean mIsGroup;
    private String mPttFilePath;
    BaseMessageObserver messageObserver;
    private boolean netDown;
    private long netDownTime;
    private long timeStamp;

    public GroupPttUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mIsGroup = true;
        this.mHasVirtualStarted = false;
        this.netDown = false;
        this.netDownTime = 0L;
        this.timeStamp = 0L;
        this.mController = baseTransFileController;
        this.app = super.app;
        AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
        this.messageObserver = ((IPttTransferTempApi) QRoute.api(IPttTransferTempApi.class)).getGroupPttUploadProcessorMsgObserver(this);
    }

    private void checkConnErr() {
        ProcessorReport processorReport = this.mProcessorReport;
        if (processorReport.errCode == 9004) {
            String str = processorReport.mReportInfo.get(ReportConstant.KEY_REASON);
            if ("connError_unreachable".equalsIgnoreCase(str)) {
                this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_REASON, "N_1");
            } else if ("connError_noroute".equalsIgnoreCase(str)) {
                this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_REASON, "N_2");
            }
        }
    }

    private void fillPttRichTextExtraValue(im_msg_body$RichText im_msg_body_richtext, MessageForPtt messageForPtt) {
        if (messageForPtt != null && im_msg_body_richtext != null) {
            im_msg_body_richtext.ptt.uint32_format.set(messageForPtt.voiceType);
            im_msg_body_richtext.ptt.uint32_time.set(Utils.O(messageForPtt.voiceLength));
        }
    }

    private void fixStepTime() {
        if (this.mUiRequest.mIsPttPreSend) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.mStepUrl.fixAtPttPreSend(processorReport.mStartTime);
            ProcessorReport processorReport2 = this.mProcessorReport;
            processorReport2.mStepTrans.fixAtPttPreSend(processorReport2.mStartTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendFileByBDH$0(int i3, String str, String str2) {
        reportForServerMonitor(RMServMonitorReport.REPORT_NAME_NM_PTTUP, false, i3, str, str2, this.mMd5Str, this.mUuid, null);
    }

    private void logErro() {
        String str = LogTag.RICH_MEDIA + TransFileUtil.getUinDesc(this.mUiRequest.mUinType) + "." + RichMediaUtil.getFileType(this.mUiRequest.mFileType);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("id:" + this.mUiRequest.mUniseq + "  ");
        sb5.append("errCode:" + this.mProcessorReport.errCode + "  ");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("errDesc:");
        sb6.append(this.mProcessorReport.errDesc);
        sb5.append(sb6.toString());
        QLog.d(str, 1, sb5.toString());
    }

    private RichProto.RichProtoReq.PttUpReq makePttUpReq() {
        RichProto.RichProtoReq.PttUpReq pttUpReq = new RichProto.RichProtoReq.PttUpReq();
        pttUpReq.fileName = this.mFileName;
        pttUpReq.fileSize = (int) this.mFileSize;
        pttUpReq.md5 = this.mLocalMd5;
        TransferRequest transferRequest = this.mUiRequest;
        pttUpReq.audioPanelType = transferRequest.mPttUploadPanel;
        MessageForPtt messageForPtt = (MessageForPtt) transferRequest.mRec;
        pttUpReq.voiceType = messageForPtt.voiceType;
        pttUpReq.selfUin = transferRequest.mSelfUin;
        pttUpReq.peerUin = transferRequest.mPeerUin;
        pttUpReq.secondUin = transferRequest.mSecondId;
        pttUpReq.uinType = transferRequest.mUinType;
        int i3 = messageForPtt.voiceLength;
        if (i3 == 0) {
            i3 = ((IQQRecorderTempApi) QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(this.mUiRequest.mRec);
        }
        pttUpReq.voiceLength = i3;
        if (this.mUiRequest.mUinType == 1026) {
            pttUpReq.uinType = 1;
            if (QLog.isColorLevel()) {
                QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
            }
        }
        return pttUpReq;
    }

    public static int modifyVoiceType(int i3) {
        return Math.min(i3, 1);
    }

    private void resetStatictisInfo() {
        this.file.stepSig.reset();
        this.file.stepUrl.reset();
        this.file.stepTrans.reset();
        this.file.stepNotify.reset();
        ProcessorReport processorReport = this.mProcessorReport;
        FileMsg fileMsg = this.file;
        long nanoTime = System.nanoTime();
        fileMsg.startTime = nanoTime;
        processorReport.mStartTime = nanoTime;
        this.file.endTime = 0L;
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        AppNetConnInfo.unregisterNetEventHandler(this);
        return super.cancel();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        super.checkParam();
        if (!this.mUiRequest.mPttCompressFinish) {
            return 0;
        }
        return doCheckParam();
    }

    protected im_msg_body$RichText constructPTTRichText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (im_msg_body$RichText) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        try {
            im_msg_body$Ptt im_msg_body_ptt = new im_msg_body$Ptt();
            im_msg_body_ptt.uint32_file_type.set(4);
            im_msg_body_ptt.uint64_src_uin.set(Long.parseLong(this.mUiRequest.mSelfUin));
            im_msg_body_ptt.uint32_file_id.set((int) this.mFileID);
            String str = this.mGroupFileKeyStr;
            if (str != null) {
                try {
                    im_msg_body_ptt.bytes_group_file_key.set(ByteStringMicro.copyFrom(str.getBytes("utf-8")));
                } catch (UnsupportedEncodingException unused) {
                }
            }
            IPttTempApi iPttTempApi = (IPttTempApi) QRoute.api(IPttTempApi.class);
            AppInterface appInterface = this.app;
            int pttVipFlag = iPttTempApi.getPttVipFlag(appInterface, appInterface.getCurrentAccountUin());
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body$ElemFlags2 im_msg_body_elemflags2 = new im_msg_body$ElemFlags2();
            im_msg_body_elemflags2.uint32_vip_status.set(pttVipFlag);
            im_msg_body_elem.elem_flags2.set(im_msg_body_elemflags2);
            im_msg_body_ptt.bool_valid.set(true);
            im_msg_body_ptt.uint32_file_size.set((int) this.mFileSize);
            im_msg_body_ptt.bytes_file_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
            im_msg_body_ptt.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mFileName));
            byte[] groupConstructPTTExtraInfo = ((IMessageForPttUtilsApi) QRoute.api(IMessageForPttUtilsApi.class)).groupConstructPTTExtraInfo((MessageForPtt) this.mUiRequest.mRec);
            if (groupConstructPTTExtraInfo != null) {
                im_msg_body_ptt.bytes_pb_reserve.set(ByteStringMicro.copyFrom(groupConstructPTTExtraInfo));
            }
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body_richtext.ptt.set(im_msg_body_ptt);
            im_msg_body_richtext.elems.add(im_msg_body_elem);
            return im_msg_body_richtext;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "Construct richtext error", e16);
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.transfile.IGroupPttUploadProcessor
    public void copyStatisInfo(StepInfo stepInfo, boolean z16, boolean z17, StatictisInfo statictisInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, stepInfo, Boolean.valueOf(z16), Boolean.valueOf(z17), statictisInfo);
        } else {
            this.mProcessorReport.copyStatisInfo(stepInfo, z16, z17, statictisInfo);
        }
    }

    protected int doCheckParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        logRichMediaEvent("uiParam", this.mUiRequest.toString());
        TransferRequest transferRequest = this.mUiRequest;
        int i3 = transferRequest.mUinType;
        if (i3 != 1 && i3 != 1026) {
            this.mIsGroup = false;
        } else {
            this.mIsGroup = true;
        }
        if (transferRequest.mRec == null) {
            this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("message null")), null, null);
            onError();
            return -1;
        }
        String str = transferRequest.mLocalPath;
        if (TextUtils.isEmpty(str)) {
            this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("filePath null")), null, null);
            onError();
            return -1;
        }
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
        this.mPttFilePath = str;
        long length = file.length();
        this.file.fileSize = length;
        this.mFileSize = length;
        if (length <= 0) {
            this.mProcessorReport.setError(9071, BaseTransProcessor.getExpStackString(new Exception("file size 0 " + str)), null, null);
            onError();
            return -1;
        }
        this.mExtName = "amr";
        return 0;
    }

    public void doOnSendSuc(byte[] bArr, HashMap<String, String> hashMap, long j3) {
        List<cmd0x388$TryUpPttRsp> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, bArr, hashMap, Long.valueOf(j3));
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            list = new cmd0x388$RspBody().mergeFrom(bArr).rpt_msg_tryup_ptt_rsp.get();
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "get uuid from BDH error", e16);
            }
        }
        if (list != null && list.size() != 0) {
            cmd0x388$TryUpPttRsp cmd0x388_tryuppttrsp = list.get(0);
            if (cmd0x388_tryuppttrsp.uint64_fileid.has()) {
                this.mFileID = cmd0x388_tryuppttrsp.uint64_fileid.get();
            }
            if (cmd0x388_tryuppttrsp.bytes_file_key.has()) {
                this.mGroupFileKeyStr = new String(cmd0x388_tryuppttrsp.bytes_file_key.get().toByteArray(), "utf-8");
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (uptimeMillis - j3) + "ms ,fileSize:" + this.file.fileSize + " transInfo:" + hashMap.get(TransReport.rep_bdhTrans));
            }
            addBDHReportInfo(hashMap);
            this.mProcessorReport.mStepTrans.logFinishTime();
            this.mProcessorReport.mStepTrans.result = 1;
            this.mTransferedSize = this.mFileSize;
            synchronized (this) {
                TransferRequest transferRequest = this.mUiRequest;
                if (transferRequest.mIsPttPreSend && !transferRequest.mCanSendMsg) {
                    transferRequest.mCanSendMsg = true;
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 4, "group send file success, wait for send msg");
                    }
                }
                sendMsg();
                this.file.closeInputStream();
                if (this.mUiRequest.mIsPttPreSend) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 4, "group send file success, can send msg, direct send");
                    }
                    ((IPttPreSendService) this.app.getRuntimeService(IPttPreSendService.class, "all")).doOnPreSendEnd(getKey());
                }
            }
            this.file.closeInputStream();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "<BDH_LOG> Transaction Success,delete combined file");
            }
            reportForServerMonitor(RMServMonitorReport.REPORT_NAME_NM_PTTUP, true, 0, hashMap.get("ip"), hashMap.get("port"), this.mMd5Str, this.mUuid, null);
            return;
        }
        throw new Exception("resps null");
    }

    protected void doRealReport(boolean z16, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (z16) {
            collectChnlCostReport();
            TransferRequest transferRequest = this.mUiRequest;
            if (transferRequest.mIsPresend) {
                long j17 = this.mEnterAioTime;
                long j18 = 0;
                if (j17 != 0) {
                    j18 = (j16 - j17) / 1000000;
                }
                if (transferRequest.myPresendInvalid) {
                    j18 = j3;
                }
                double d16 = j18 / j3;
                if (d16 >= 0.0d && d16 <= 1.0d) {
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_AIOPERCENT, d16 + "");
                }
                this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_AIODURATION, j18 + "");
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doReport ,mStartTime = " + this.mProcessorReport.mStartTime + ",mEnterAioTime = " + this.mEnterAioTime + ",finishTime  = " + j16 + ", aioDuration = " + j18 + ", duration = " + j3 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.mUiRequest.myPresendInvalid + ",Percent = " + d16);
                }
            }
            this.mProcessorReport.mReportInfo.put("param_isSuccess", "1");
            this.mProcessorReport.reportForIpv6(true, j3, true, getReportTAG());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        } else {
            ProcessorReport processorReport = this.mProcessorReport;
            if (processorReport.errCode != -9527) {
                processorReport.mReportInfo.remove("param_rspHeader");
            }
            this.mProcessorReport.mReportInfo.remove("param_url");
            ProcessorReport processorReport2 = this.mProcessorReport;
            processorReport2.mReportInfo.put("param_FailCode", String.valueOf(processorReport2.errCode));
            ProcessorReport processorReport3 = this.mProcessorReport;
            processorReport3.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport3.errDesc);
            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.mFileSize));
            this.mProcessorReport.mReportInfo.put("param_uniseq", String.valueOf(this.mUiRequest.mUniseq));
            this.mProcessorReport.mReportInfo.put("param_isSuccess", "0");
            this.mProcessorReport.reportForIpv6(false, j3, true, getReportTAG());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        }
        setReportFlag();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doReport(boolean z16) {
        boolean z17;
        ProcessorReport processorReport;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        int i3 = 1;
        if (!z16) {
            logErro();
            checkConnErr();
            if (this.shouldMsgReportSucc == 1) {
                this.mProcessorReport.mStepMsg.result = 1;
                z17 = true;
                fixStepTime();
                String str = this.mProcessorReport.mStepUrl.getReportInfo(1) + ";" + this.mProcessorReport.mStepTrans.getReportInfo(2) + ";" + this.mProcessorReport.mStepMsg.getReportInfo(3);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doDSReport : GroupPic doReport : result:" + z17);
                }
                if (z17 && RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
                    AppNetConnInfo.unregisterNetEventHandler(this);
                    return;
                }
                processorReport = this.mProcessorReport;
                if (processorReport.mIsOldDbRec && ((!z17 || (processorReport.mReportedFlag & 2) <= 0) && (z17 || (processorReport.mReportedFlag & 1) <= 0))) {
                    int i16 = processorReport.mReportedFlag;
                    if (z17) {
                        i3 = 2;
                    }
                    processorReport.mReportedFlag = i3 | i16;
                    processorReport.mEndTime = System.currentTimeMillis();
                    long nanoTime = System.nanoTime();
                    long j3 = (nanoTime - this.mProcessorReport.mStartTime) / 1000000;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("SendGrpPic, cost=");
                    StepInfo stepInfo = this.mProcessorReport.mStepTrans;
                    sb5.append((stepInfo.finishTime - stepInfo.startTime) / 1000000);
                    Log.i("AutoMonitor", sb5.toString());
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_STEP_INFO, str);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_GROUP_ID, this.mUiRequest.mPeerUin);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_GROUP_FILE_ID, String.valueOf(this.mFileID));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_MD5, this.mFileName);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEYIS_PRESEND, this.mUiRequest.mIsPresend + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEYIS_SECOND_TRANS, this.mIsPicSecondTransfered + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PHONE_TYPE, ah.u() + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_NET_TYPE, NetworkUtil.getSystemNetwork(BaseApplication.getContext()) + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_IS_RAW_PIC, this.mIsRawPic + "");
                    this.mProcessorReport.mReportInfo.put(QQNotificationManager.PARAM_UINTYPE, String.valueOf(this.mUiRequest.mUinType));
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    processorReport2.mReportInfo.put(ReportConstant.KEY_SENDBY_QUICK_HTTP, String.valueOf(processorReport2.mSendByQuickHttp));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_TYPE, String.valueOf(this.mPicType));
                    this.mProcessorReport.mReportInfo.put("param_busi", String.valueOf(this.mUiRequest.mBusiType));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SOURCE_TYPE, String.valueOf(this.mUiRequest.isQzonePic ? 1 : 0));
                    if (this.netDown) {
                        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PTT_NET_DOWN, String.valueOf(this.netDownTime / 1000000));
                        if (QLog.isColorLevel()) {
                            QLog.d("weak_net", 2, String.valueOf(this.netDownTime / 1000000));
                        }
                    }
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PTT_OPT, String.valueOf(((IPttOptimizeParams) QRoute.api(IPttOptimizeParams.class)).getOptString(this.app, false)));
                    doRealReport(z17, j3, nanoTime);
                    AppNetConnInfo.unregisterNetEventHandler(this);
                    return;
                }
                AppNetConnInfo.unregisterNetEventHandler(this);
            }
        }
        z17 = z16;
        fixStepTime();
        String str2 = this.mProcessorReport.mStepUrl.getReportInfo(1) + ";" + this.mProcessorReport.mStepTrans.getReportInfo(2) + ";" + this.mProcessorReport.mStepMsg.getReportInfo(3);
        if (QLog.isColorLevel()) {
        }
        if (z17) {
        }
        processorReport = this.mProcessorReport;
        if (processorReport.mIsOldDbRec) {
        }
        AppNetConnInfo.unregisterNetEventHandler(this);
    }

    protected void doStart(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (!z16) {
            sendMessageToUpdate(1001);
        }
        sendMessageToUpdate(1000);
        this.file.closeInputStream();
        sendMessageToUpdate(1001);
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
        this.app.getHwEngine().preConnect();
        sendFileByBDH();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public long getFileStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        if (this.mUiRequest.mPttCompressFinish) {
            return super.getFileStatus();
        }
        return 7000L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.mIsGroup) {
            return StatisticCollector.TROOP_PTT_UPLOAD_STATISTIC_TAG;
        }
        return StatisticCollector.DISCUSSION_PTT_UPLOAD_STATISTIC_TAG;
    }

    @Override // com.tencent.mobileqq.transfile.IGroupPttUploadProcessor
    public TransferRequest getRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (TransferRequest) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mUiRequest;
    }

    @Override // com.tencent.mobileqq.transfile.IGroupPttUploadProcessor
    public StepInfo getStepMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (StepInfo) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mProcessorReport.mStepMsg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void inter_retry() {
        if (this.mIsCancel) {
            return;
        }
        if (this.mUkey != null && this.mFileID != 0) {
            if (this.mTransferedSize >= this.mFileSize) {
                sendMsg();
                return;
            } else if (this.mChannelStatus == 1 && this.mTrans != null) {
                log("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
                this.app.getHwEngine().resumeTransactionTask(this.mTrans);
                return;
            } else {
                start();
                return;
            }
        }
        start();
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeHelper.a
    public void onCompressFinished(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        synchronized (this) {
            TransferRequest transferRequest = this.mUiRequest;
            transferRequest.mPttCompressFinish = true;
            MessageForPtt messageForPtt = (MessageForPtt) transferRequest.mRec;
            messageForPtt.voiceLength = i16;
            messageForPtt.voiceType = i3;
            if (doCheckParam() == 0) {
                doStart(this.mHasVirtualStarted);
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
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
            this.mUiRequest.mUpCallBack.q(aVar);
        }
        if (this.mUiRequest.mIsPttPreSend) {
            ((IPttPreSendService) this.app.getRuntimeService(IPttPreSendService.class, "all")).doOnPreSendEnd(getKey());
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
    public void onNetChangeEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        if (z16) {
            if (this.timeStamp > 0) {
                this.netDownTime += System.nanoTime() - this.timeStamp;
                this.timeStamp = 0L;
            }
        } else {
            this.timeStamp = System.nanoTime();
        }
        this.netDown = true;
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.onSuccess();
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258601e = this.mFileSize;
            aVar.f258603g = this.mMd5Str;
            aVar.f258602f = this.mFileName;
            TransferRequest transferRequest = this.mUiRequest;
            aVar.f258600d = transferRequest.mLocalPath;
            aVar.f258604h = this.mFileID;
            transferRequest.mUpCallBack.q(aVar);
        } else {
            updateMessageDataBaseContent(true);
        }
        sendMessageToUpdate(1003);
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        super.pause();
        if (!this.mIsPause) {
            this.mIsPause = true;
            if (QLog.isColorLevel()) {
                logRichMediaEvent("pause", "");
            }
            sendMessageToUpdate(1006);
            RichProto.RichProtoReq richProtoReq = this.mRichProtoReq;
            if (richProtoReq != null) {
                RichProtoProc.cancelRichProtoReq(richProtoReq);
                this.mRichProtoReq = null;
            }
            int i3 = this.mChannelStatus;
            if (i3 != 0) {
                if (i3 == 1) {
                    if (this.mTrans != null) {
                        log("<BDH_LOG> pause() pause BDH channel, transation id=" + this.mTrans.getTransationId());
                        this.app.getHwEngine().stopTransactionTask(this.mTrans);
                        return;
                    }
                    log("<BDH_LOG> pause() pause BDH channel, but trans == null");
                    return;
                }
                return;
            }
            log("<BDH_LOG> pause() BUT current status is INIT");
        }
    }

    protected boolean queryStateByPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).queryStateByPath(this.mUiRequest.mLocalPath, this);
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest.mIsPttPreSend && transferRequest.mCanSendMsg) {
            sendProgressMessage();
            sendMsg();
        } else if (this.mIsPause) {
            this.mIsPause = false;
            this.mIsCancel = false;
            sendMessageToUpdate(1002);
            if (this.mChannelStatus != 1) {
                this.mUkey = null;
            }
            this.mServerRollbackCount = 0;
            this.mTryCount = 0;
            this.mReqUrlCount = 0;
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.errCode = 0;
            processorReport.errDesc = "";
            resetStatictisInfo();
            this.mController.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.transfile.a
                @Override // java.lang.Runnable
                public final void run() {
                    GroupPttUploadProcessor.this.inter_retry();
                }
            });
        }
        return 0;
    }

    void sendDiscussMsg() {
        String str;
        im_msg_body$RichText constructPTTRichText = constructPTTRichText();
        if (constructPTTRichText == null) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "constructpberror", null, processorReport.mStepMsg);
            onError();
            return;
        }
        if (!isAppValid()) {
            ProcessorReport processorReport2 = this.mProcessorReport;
            processorReport2.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport2.mStepMsg);
            onError();
            return;
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord == null) {
            IPttTempApi iPttTempApi = (IPttTempApi) QRoute.api(IPttTempApi.class);
            AppInterface appInterface = this.app;
            TransferRequest transferRequest = this.mUiRequest;
            messageRecord = iPttTempApi.getMsgItemByUniseq(appInterface, transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
        }
        if (!(messageRecord instanceof MessageForPtt)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Mr_");
            if (messageRecord == null) {
                str = "null";
            } else {
                str = "" + messageRecord.msgtype;
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            ProcessorReport processorReport3 = this.mProcessorReport;
            processorReport3.setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "msgtypeError", sb6, processorReport3.mStepMsg);
            onError();
            return;
        }
        MessageForPtt messageForPtt = (MessageForPtt) this.mUiRequest.mRec;
        fillPttRichTextExtraValue(constructPTTRichText, messageForPtt);
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "<---sendDiscussMsg voiceType\uff1a" + messageForPtt.voiceType + " voiceLengh:" + messageForPtt.voiceLength);
        }
        ((MessageForPtt) messageRecord).richText = constructPTTRichText;
        if (this.needSendMsg) {
            ((IPttTempApi) QRoute.api(IPttTempApi.class)).sendMessage(this.app, messageRecord, this.messageObserver);
            return;
        }
        TransferRequest transferRequest2 = this.mUiRequest;
        if (transferRequest2.mUpCallBack != null) {
            messageForPtt.url = MessageForPtt.getMsgFilePath(messageForPtt.voiceType, transferRequest2.mLocalPath);
            messageForPtt.fileSize = this.mFileSize;
            messageForPtt.urlAtServer = this.mFileName;
            messageForPtt.itemType = 2;
            messageForPtt.groupFileID = this.mFileID;
            messageForPtt.groupFileKeyStr = this.mGroupFileKeyStr;
            messageForPtt.md5 = this.mMd5Str;
            messageForPtt.serial();
            this.mUiRequest.mUpCallBack.g(constructPTTRichText);
        }
    }

    public void sendFileByBDH() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
        }
        this.mProcessorReport.mStepTrans.logStartTime();
        if (this.mTrans != null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        cmd0x388$ReqBody cmd0x388_reqbody = new cmd0x388$ReqBody();
        cmd0x388_reqbody.setHasFlag(true);
        int i3 = 3;
        cmd0x388_reqbody.uint32_subcmd.set(3);
        int handlerNetType = BaseHandler.getHandlerNetType();
        cmd0x388_reqbody.uint32_net_type.set(handlerNetType);
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "GroupPttUp: net[" + handlerNetType + "]");
        }
        RichProto.RichProtoReq.PttUpReq makePttUpReq = makePttUpReq();
        cmd0x388$TryUpPttReq cmd0x388_tryuppttreq = new cmd0x388$TryUpPttReq();
        cmd0x388_tryuppttreq.setHasFlag(true);
        cmd0x388_tryuppttreq.uint64_src_uin.set(Long.valueOf(makePttUpReq.selfUin).longValue());
        cmd0x388_tryuppttreq.uint64_group_code.set(Long.valueOf(makePttUpReq.peerUin).longValue());
        cmd0x388_tryuppttreq.uint64_file_id.set(0L);
        cmd0x388_tryuppttreq.uint64_file_size.set(makePttUpReq.fileSize);
        cmd0x388_tryuppttreq.bytes_file_md5.set(ByteStringMicro.copyFrom(makePttUpReq.md5));
        cmd0x388_tryuppttreq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(makePttUpReq.fileName));
        cmd0x388_tryuppttreq.uint32_src_term.set(5);
        cmd0x388_tryuppttreq.uint32_platform_type.set(9);
        PBUInt32Field pBUInt32Field = cmd0x388_tryuppttreq.uint32_bu_type;
        if (makePttUpReq.uinType != 1) {
            i3 = 4;
        }
        pBUInt32Field.set(i3);
        cmd0x388_tryuppttreq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
        cmd0x388_tryuppttreq.uint32_voice_length.set(makePttUpReq.voiceLength);
        cmd0x388_tryuppttreq.uint32_codec.set(modifyVoiceType(makePttUpReq.voiceType));
        cmd0x388_tryuppttreq.uint32_voice_type.set(makePttUpReq.audioPanelType);
        cmd0x388_tryuppttreq.bool_new_up_chan.set(true);
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "GroupPttUp: panel[" + makePttUpReq.audioPanelType + "] type[" + makePttUpReq.voiceType + "] length[" + makePttUpReq.voiceLength + "] size[" + makePttUpReq.fileSize + "]");
        }
        cmd0x388_reqbody.rpt_msg_tryup_ptt_req.add(cmd0x388_tryuppttreq);
        Transaction transaction = new Transaction(this.app.getCurrentAccountUin(), 29, this.mPttFilePath, (int) this.mStartOffset, this.mLocalMd5, new ITransactionCallback(uptimeMillis) { // from class: com.tencent.mobileqq.transfile.GroupPttUploadProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = uptimeMillis;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, GroupPttUploadProcessor.this, Long.valueOf(uptimeMillis));
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onFailed(int i16, byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(i16), bArr, hashMap);
                    return;
                }
                long uptimeMillis2 = SystemClock.uptimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d(GroupPttUploadProcessor.TAG, 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (uptimeMillis2 - this.val$startTime) + "ms");
                }
                GroupPttUploadProcessor.this.addBDHReportInfo(hashMap);
                GroupPttUploadProcessor.this.onError();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) bArr, (Object) hashMap);
                } else {
                    GroupPttUploadProcessor.this.doOnSendSuc(bArr, hashMap, this.val$startTime);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSwitch2BackupChannel() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                long uptimeMillis2 = SystemClock.uptimeMillis();
                GroupPttUploadProcessor.this.log("<BDH_LOG> onSwitch2BackupChannel()");
                GroupPttUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SWITCH_CHNL, String.valueOf(uptimeMillis2 - this.val$startTime));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                GroupPttUploadProcessor.this.log("<BDH_LOG> onTransStart()");
                StepInfo stepInfo = GroupPttUploadProcessor.this.mProcessorReport.mStepTrans;
                stepInfo.startTime = 0L;
                stepInfo.logStartTime();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i16);
                    return;
                }
                GroupPttUploadProcessor groupPttUploadProcessor = GroupPttUploadProcessor.this;
                long j3 = i16;
                groupPttUploadProcessor.file.transferedSize = j3;
                groupPttUploadProcessor.mTransferedSize = j3;
                if (j3 < groupPttUploadProcessor.mFileSize && !groupPttUploadProcessor.mIsCancel && !groupPttUploadProcessor.mIsPause) {
                    groupPttUploadProcessor.sendProgressMessage();
                }
            }
        }, cmd0x388_reqbody.toByteArray(), false);
        this.mTrans = transaction;
        transaction.cbForReport = new ITransCallbackForReport() { // from class: com.tencent.mobileqq.transfile.b
            @Override // com.tencent.mobileqq.highway.api.ITransCallbackForReport
            public final void onFailed(int i16, String str, String str2) {
                GroupPttUploadProcessor.this.lambda$sendFileByBDH$0(i16, str, str2);
            }
        };
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.mTrans);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:29");
        }
        if (submitTransactionTask != 0) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(submitTransactionTask, "sendFileByBDH SubmitError.", "", processorReport.mStepTrans);
            onError();
        }
    }

    void sendGroupMsg() {
        String str;
        im_msg_body$RichText constructPTTRichText = constructPTTRichText();
        if (constructPTTRichText == null) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "constructpberror", null, processorReport.mStepMsg);
            onError();
            return;
        }
        if (!isAppValid()) {
            ProcessorReport processorReport2 = this.mProcessorReport;
            processorReport2.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport2.mStepMsg);
            onError();
            return;
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord == null) {
            IPttTempApi iPttTempApi = (IPttTempApi) QRoute.api(IPttTempApi.class);
            AppInterface appInterface = this.app;
            TransferRequest transferRequest = this.mUiRequest;
            messageRecord = iPttTempApi.getMsgItemByUniseq(appInterface, transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
        }
        if (!(messageRecord instanceof MessageForPtt)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Mr_");
            if (messageRecord == null) {
                str = "null";
            } else {
                str = "" + messageRecord.msgtype;
            }
            sb5.append(str);
            String sb6 = sb5.toString();
            ProcessorReport processorReport3 = this.mProcessorReport;
            processorReport3.setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "msgtypeError", sb6, processorReport3.mStepMsg);
            onError();
            return;
        }
        MessageForPtt messageForPtt = (MessageForPtt) this.mUiRequest.mRec;
        fillPttRichTextExtraValue(constructPTTRichText, messageForPtt);
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "<---sendGroupMsg voiceType\uff1a" + messageForPtt.voiceType + " voiceLengh:" + messageForPtt.voiceLength);
        }
        ((MessageForPtt) messageRecord).richText = constructPTTRichText;
        if (this.mUiRequest.mUinType == 1026 && QLog.isColorLevel()) {
            QLog.i("PttShow", 2, "sendGroupMsg, UIN_TYPE_HOTCHAT_TOPIC");
        }
        if (this.needSendMsg) {
            ((IPttTempApi) QRoute.api(IPttTempApi.class)).sendMessage(this.app, messageRecord, this.messageObserver);
            return;
        }
        TransferRequest transferRequest2 = this.mUiRequest;
        if (transferRequest2.mUpCallBack != null) {
            messageForPtt.url = MessageForPtt.getMsgFilePath(messageForPtt.voiceType, transferRequest2.mLocalPath);
            messageForPtt.fileSize = this.mFileSize;
            messageForPtt.urlAtServer = this.mFileName;
            messageForPtt.itemType = 2;
            messageForPtt.groupFileID = this.mFileID;
            messageForPtt.groupFileKeyStr = this.mGroupFileKeyStr;
            messageForPtt.md5 = this.mMd5Str;
            messageForPtt.serial();
            this.mUiRequest.mUpCallBack.g(constructPTTRichText);
        }
    }

    void sendMsg() {
        if (!canDoNextStep()) {
            return;
        }
        this.mProcessorReport.mStepMsg.logStartTime();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
        }
        if (this.mIsGroup) {
            sendGroupMsg();
        } else {
            sendDiscussMsg();
        }
    }

    @Override // com.tencent.mobileqq.transfile.IGroupPttUploadProcessor
    public void setShouldMsgReportSucc(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.shouldMsgReportSucc = i3;
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        boolean queryStateByPath;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.start();
        if (!this.mUiRequest.mPttCompressFinish) {
            synchronized (IVoiceChangeManager.class) {
                queryStateByPath = queryStateByPath();
            }
            if (queryStateByPath) {
                synchronized (this) {
                    if (this.mHasVirtualStarted) {
                        sendMessageToUpdate(1001);
                        this.mHasVirtualStarted = true;
                    }
                }
                return;
            }
            if (doCheckParam() == 0) {
                doStart(false);
                return;
            }
            return;
        }
        doStart(false);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void updateMessageDataBaseContent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord == null) {
            IPttTempApi iPttTempApi = (IPttTempApi) QRoute.api(IPttTempApi.class);
            AppInterface appInterface = this.app;
            TransferRequest transferRequest = this.mUiRequest;
            messageRecord = iPttTempApi.getMsgItemByUniseq(appInterface, transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
            logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
        }
        if (messageRecord == null) {
            logRichMediaEvent("updateDb", "msg null");
            return;
        }
        if (messageRecord.isMultiMsg) {
            logRichMediaEvent("updateDb", "is multiMsg");
            return;
        }
        TransferRequest transferRequest2 = this.mUiRequest;
        if (transferRequest2.mFileType == 2 && (messageRecord instanceof MessageForPtt)) {
            MessageForPtt messageForPtt = (MessageForPtt) messageRecord;
            if (!transferRequest2.mIsPttPreSend) {
                messageForPtt.url = MessageForPtt.getMsgFilePath(messageForPtt.voiceType, transferRequest2.mLocalPath);
            }
            messageForPtt.fileSize = this.mFileSize;
            messageForPtt.urlAtServer = this.mFileName;
            messageForPtt.itemType = 2;
            messageForPtt.groupFileID = this.mFileID;
            messageForPtt.groupFileKeyStr = this.mGroupFileKeyStr;
            messageForPtt.md5 = this.mMd5Str;
            messageForPtt.serial();
            IPttTempApi iPttTempApi2 = (IPttTempApi) QRoute.api(IPttTempApi.class);
            AppInterface appInterface2 = this.app;
            TransferRequest transferRequest3 = this.mUiRequest;
            iPttTempApi2.updateMsgContentByUniseq(appInterface2, transferRequest3.mPeerUin, transferRequest3.mUinType, messageRecord.uniseq, messageForPtt.msgData);
            if (((ISttManagerService) this.app.getRuntimeService(ISttManagerService.class, "all")).needAuotoChange(messageForPtt)) {
                ReportController.o(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
                ((ISttManagerService) this.app.getRuntimeService(ISttManagerService.class, "all")).translate(messageForPtt, 2);
            }
        }
    }
}
