package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.ptt.temp.api.IPttTransferTempApi;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.pttlogic.api.IPttSSCMPool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.transfile.protohandler.BaseHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.util.WeakReference;
import org.slf4j.Marker;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346$ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346$RspBody;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$ElemFlags2;
import tencent.im.msg.im_msg_body$Ptt;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$TmpPtt;

/* loaded from: classes19.dex */
public class C2CPttUploadProcessor extends BaseUploadProcessor implements IVoiceChangeHelper.a, INetEventHandler, IC2CPttUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "C2CPicUploadProcessor";
    private static int s0x346Seq;
    WeakReference<AppInterface> app;
    boolean mHasVirtualStarted;
    private String mPttFilePath;
    BaseMessageObserver messageObserver;
    private boolean netDown;
    private long netDownTime;
    private long timeStamp;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27359);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            s0x346Seq = 0;
        }
    }

    public C2CPttUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        com.tencent.wstt.SSCM.a sscm;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mHasVirtualStarted = false;
        this.netDown = false;
        this.netDownTime = 0L;
        this.timeStamp = 0L;
        this.app = new WeakReference<>(super.app);
        synchronized (IPttSSCMPool.class) {
            sscm = ((IPttSSCMPool) QRoute.api(IPttSSCMPool.class)).getSSCM();
        }
        this.sscmObject = sscm;
        AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
        this.messageObserver = ((IPttTransferTempApi) QRoute.api(IPttTransferTempApi.class)).getC2CPttUploadProcessorMsgObserver(this);
    }

    private RichProto.RichProtoReq.PttUpReq makePttUpReq() {
        RichProto.RichProtoReq.PttUpReq pttUpReq = new RichProto.RichProtoReq.PttUpReq();
        TransferRequest transferRequest = this.mUiRequest;
        pttUpReq.selfUin = transferRequest.mSelfUin;
        pttUpReq.peerUin = transferRequest.mPeerUin;
        pttUpReq.secondUin = transferRequest.mSecondId;
        pttUpReq.uinType = transferRequest.mUinType;
        pttUpReq.fileName = this.mFileName;
        pttUpReq.fileSize = (int) this.mFileSize;
        pttUpReq.md5 = this.mLocalMd5;
        MessageForPtt messageForPtt = (MessageForPtt) transferRequest.mRec;
        if (messageForPtt != null) {
            pttUpReq.voiceType = messageForPtt.voiceType;
            pttUpReq.voiceLength = messageForPtt.voiceLength;
            pttUpReq.autoToText = messageForPtt.autoToText;
        }
        pttUpReq.audioPanelType = transferRequest.mPttUploadPanel;
        return pttUpReq;
    }

    private boolean needChangeToText(MessageForPtt messageForPtt) {
        WeakReference<AppInterface> weakReference = this.app;
        if (weakReference != null && weakReference.get() != null && ((ISttManagerService) this.app.get().getRuntimeService(ISttManagerService.class, "all")).needAuotoChange(messageForPtt)) {
            return true;
        }
        return false;
    }

    public byte[] c2cConstructPTTExtraInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return ((IMessageForPttUtilsApi) QRoute.api(IMessageForPttUtilsApi.class)).c2cConstructPTTExtraInfo((MessageForPtt) this.mUiRequest.mRec);
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        AppNetConnInfo.unregisterNetEventHandler(this);
        return super.cancel();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        super.checkParam();
        if (!this.mUiRequest.mPttCompressFinish) {
            return 0;
        }
        return doCheckParam();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public HttpNetReq constructHttpNetReq(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (HttpNetReq) iPatchRedirector.redirect((short) 21, (Object) this, (Object) bArr);
        }
        HttpNetReq constructHttpNetReq = super.constructHttpNetReq(bArr);
        constructHttpNetReq.mUseCmwapConnectionTypeFromDpc = true;
        return constructHttpNetReq;
    }

    protected im_msg_body$RichText constructPTTRichText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (im_msg_body$RichText) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        try {
            if (this.mUiRequest.mUinType == 0) {
                im_msg_body$Ptt im_msg_body_ptt = new im_msg_body$Ptt();
                im_msg_body_ptt.uint32_file_type.set(4);
                im_msg_body_ptt.uint64_src_uin.set(Long.parseLong(this.mUiRequest.mSelfUin));
                ArrayList<ServerAddr> arrayList = this.mIpList;
                if (arrayList != null && arrayList.size() > 0) {
                    ServerAddr serverAddr = this.mIpList.get(0);
                    im_msg_body_ptt.uint32_server_ip.set(BaseUploadProcessor.ipToLong(serverAddr.mIp));
                    im_msg_body_ptt.uint32_server_port.set(serverAddr.port);
                }
                im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                im_msg_body$ElemFlags2 im_msg_body_elemflags2 = new im_msg_body$ElemFlags2();
                WeakReference<AppInterface> weakReference = this.app;
                if (weakReference != null && weakReference.get() != null) {
                    im_msg_body_elemflags2.uint32_vip_status.set(((IPttTempApi) QRoute.api(IPttTempApi.class)).getPttVipFlag(this.app.get(), this.app.get().getCurrentAccountUin()));
                }
                im_msg_body_elem.elem_flags2.set(im_msg_body_elemflags2);
                im_msg_body_ptt.bool_valid.set(true);
                im_msg_body_ptt.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
                im_msg_body_ptt.bytes_file_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
                im_msg_body_ptt.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mFileName));
                im_msg_body_ptt.uint32_file_size.set((int) this.mFileSize);
                byte[] c2cConstructPTTExtraInfo = c2cConstructPTTExtraInfo();
                if (c2cConstructPTTExtraInfo != null) {
                    im_msg_body_ptt.bytes_reserve.set(ByteStringMicro.copyFrom(c2cConstructPTTExtraInfo));
                }
                im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
                im_msg_body_richtext.ptt.set(im_msg_body_ptt);
                im_msg_body_richtext.elems.add(im_msg_body_elem);
                return im_msg_body_richtext;
            }
            im_msg_body$TmpPtt im_msg_body_tmpptt = new im_msg_body$TmpPtt();
            im_msg_body_tmpptt.uint32_file_type.set(4);
            im_msg_body_tmpptt.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
            im_msg_body_tmpptt.bytes_file_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
            im_msg_body_tmpptt.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mFileName));
            im_msg_body_tmpptt.uint32_file_size.set((int) this.mFileSize);
            WeakReference<AppInterface> weakReference2 = this.app;
            if (weakReference2 != null && weakReference2.get() != null) {
                im_msg_body_tmpptt.uint32_user_type.set(((IPttTempApi) QRoute.api(IPttTempApi.class)).getPttVipFlag(this.app.get(), this.app.get().getCurrentAccountUin()));
            }
            im_msg_body_tmpptt.uint64_ptt_times.set(((IQQRecorderTempApi) QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(this.mUiRequest.mRec));
            if (this.mUiRequest.mUinType == 1008) {
                im_msg_body_tmpptt.uint32_busi_type.set(3);
            }
            byte[] c2cConstructPttReserveInfo = ((IMessageForPttUtilsApi) QRoute.api(IMessageForPttUtilsApi.class)).c2cConstructPttReserveInfo((MessageForPtt) this.mUiRequest.mRec);
            if (c2cConstructPttReserveInfo != null) {
                im_msg_body_tmpptt.bytes_pb_reserve.set(ByteStringMicro.copyFrom(c2cConstructPttReserveInfo));
            }
            if (c2cConstructPttReserveInfo != null) {
                im_msg_body_tmpptt.bytes_pb_reserve.set(ByteStringMicro.copyFrom(c2cConstructPttReserveInfo));
            }
            im_msg_body$RichText im_msg_body_richtext2 = new im_msg_body$RichText();
            im_msg_body_richtext2.tmp_ptt.set(im_msg_body_tmpptt);
            return im_msg_body_richtext2;
        } catch (Exception e16) {
            QLog.w("C2CPicUploadProcessor", 1, "Construct richtext error");
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.transfile.IC2CPttUploadProcessor
    public void copyStatisInfo(StepInfo stepInfo, boolean z16, boolean z17, StatictisInfo statictisInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, stepInfo, Boolean.valueOf(z16), Boolean.valueOf(z17), statictisInfo);
        } else {
            this.mProcessorReport.copyStatisInfo(stepInfo, z16, z17, statictisInfo);
        }
    }

    int doCheckParam() {
        logRichMediaEvent("uiParam", this.mUiRequest.toString());
        String str = this.mUiRequest.mLocalPath;
        if (str != null && !"".equals(str)) {
            this.mPttFilePath = str;
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

    public void doOnSendSuc(byte[] bArr, HashMap<String, String> hashMap, long j3) {
        cmd0x346$ApplyUploadRsp cmd0x346_applyuploadrsp;
        PBBytesField pBBytesField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, bArr, hashMap, Long.valueOf(j3));
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            cmd0x346$RspBody mergeFrom = new cmd0x346$RspBody().mergeFrom(bArr);
            cmd0x346$ApplyUploadRsp cmd0x346_applyuploadrsp2 = mergeFrom.msg_apply_upload_rsp;
            if (cmd0x346_applyuploadrsp2 != null && cmd0x346_applyuploadrsp2.get() != null && (pBBytesField = (cmd0x346_applyuploadrsp = mergeFrom.msg_apply_upload_rsp.get()).bytes_uuid) != null && pBBytesField.get() != null) {
                String stringUtf8 = cmd0x346_applyuploadrsp.bytes_uuid.get().toStringUtf8();
                if (stringUtf8.length() > 0) {
                    this.mResid = stringUtf8;
                    if (QLog.isColorLevel()) {
                        QLog.d("C2CPicUploadProcessor", 2, "set uuid from BDH ");
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("C2CPicUploadProcessor", 2, "get uuid from BDH error", e16);
            }
        }
        QLog.i("C2CPicUploadProcessor", 1, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (uptimeMillis - j3) + "ms ,fileSize:" + this.file.fileSize + " transInfo:" + hashMap.get(TransReport.rep_bdhTrans));
        addBDHReportInfo(hashMap);
        this.mProcessorReport.mStepTrans.logFinishTime();
        this.mProcessorReport.mStepTrans.result = 1;
        this.mTransferedSize = this.mFileSize;
        synchronized (this) {
            TransferRequest transferRequest = this.mUiRequest;
            if (transferRequest.mIsPttPreSend && !transferRequest.mCanSendMsg) {
                transferRequest.mCanSendMsg = true;
                if (QLog.isDevelopLevel()) {
                    QLog.d("C2CPicUploadProcessor", 4, "presend file success, wait for send msg");
                }
            }
            sendProgressMessage();
            sendMsg();
            if (this.mUiRequest.mIsPttPreSend) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("C2CPicUploadProcessor", 4, "presend file success, can send msg, direct send");
                }
                WeakReference<AppInterface> weakReference = this.app;
                if (weakReference != null && weakReference.get() != null) {
                    ((IPttPreSendService) this.app.get().getRuntimeService(IPttPreSendService.class, "all")).doOnPreSendEnd(getKey());
                }
            }
        }
        this.file.closeInputStream();
        if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
        }
        String str = hashMap.get("ip");
        String str2 = hashMap.get("port");
        String str3 = this.mMd5Str;
        String str4 = this.mResid;
        if (str4 == null) {
            str4 = this.mUuid;
        }
        reportForServerMonitor(RMServMonitorReport.REPORT_NAME_NM_PTTUP, true, 0, str, str2, str3, str4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        synchronized (IPttSSCMPool.class) {
            ((IPttSSCMPool) QRoute.api(IPttSSCMPool.class)).returnObject(this.sscmObject);
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
                    processorReport.mEndTime = System.currentTimeMillis();
                    long nanoTime = System.nanoTime();
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    long j3 = processorReport2.mStartTime;
                    long j16 = (nanoTime - j3) / 1000000;
                    if (this.mUiRequest.mIsPttPreSend) {
                        processorReport2.mStepUrl.fixAtPttPreSend(j3);
                        ProcessorReport processorReport3 = this.mProcessorReport;
                        processorReport3.mStepTrans.fixAtPttPreSend(processorReport3.mStartTime);
                    }
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_STEP_INFO, this.mProcessorReport.mStepUrl.getReportInfo(1) + ";" + this.mProcessorReport.mStepTrans.getReportInfo(2) + ";" + this.mProcessorReport.mStepMsg.getReportInfo(3));
                    HashMap<String, String> hashMap = this.mProcessorReport.mReportInfo;
                    String str = this.mResid;
                    if (str == null) {
                        str = this.mUuid;
                    }
                    hashMap.put(ReportConstant.KEY_UUID, str);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_TO_UIN, this.mUiRequest.mPeerUin);
                    this.mProcessorReport.mReportInfo.put(QQNotificationManager.PARAM_UINTYPE, String.valueOf(this.mUiRequest.mUinType));
                    ProcessorReport processorReport4 = this.mProcessorReport;
                    processorReport4.mReportInfo.put(ReportConstant.KEY_SENDBY_QUICK_HTTP, String.valueOf(processorReport4.mSendByQuickHttp));
                    WeakReference<AppInterface> weakReference = this.app;
                    if (weakReference != null && weakReference.get() != null) {
                        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PTT_OPT, String.valueOf(((IPttOptimizeParams) QRoute.api(IPttOptimizeParams.class)).getOptString(this.app.get(), false)));
                    }
                    if (this.netDown) {
                        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PTT_NET_DOWN, String.valueOf(this.netDownTime / 1000000));
                        if (QLog.isColorLevel()) {
                            QLog.d("weak_net", 2, String.valueOf(this.netDownTime / 1000000));
                        }
                    }
                    ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportPttUploadType(z16, this.mUiRequest.mUinType, j16, this.mFileSize);
                    if (z16) {
                        this.mProcessorReport.mReportInfo.put("param_isSuccess", "1");
                        this.mProcessorReport.reportForIpv6(true, j16, true, getReportTAG());
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, j16, this.mFileSize, this.mProcessorReport.mReportInfo, "");
                    } else {
                        ProcessorReport processorReport5 = this.mProcessorReport;
                        if (processorReport5.errCode != -9527) {
                            processorReport5.mReportInfo.remove("param_rspHeader");
                        }
                        ProcessorReport processorReport6 = this.mProcessorReport;
                        processorReport6.mReportInfo.put("param_FailCode", String.valueOf(processorReport6.errCode));
                        ProcessorReport processorReport7 = this.mProcessorReport;
                        processorReport7.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport7.errDesc);
                        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.mFileSize));
                        this.mProcessorReport.mReportInfo.put("param_isSuccess", "0");
                        this.mProcessorReport.reportForIpv6(false, j16, true, getReportTAG());
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, j16, this.mFileSize, this.mProcessorReport.mReportInfo, "");
                    }
                    setReportFlag();
                    AppNetConnInfo.unregisterNetEventHandler(this);
                }
            }
        }
    }

    void doStart(boolean z16) {
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
        sendFileByBDH();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public long getFileStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        if (this.mUiRequest.mPttCompressFinish) {
            return super.getFileStatus();
        }
        return 7000L;
    }

    protected MessageRecord getMessageRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        IPttTempApi iPttTempApi = (IPttTempApi) QRoute.api(IPttTempApi.class);
        AppInterface appInterface = this.app.get();
        TransferRequest transferRequest = this.mUiRequest;
        return iPttTempApi.getMsgItemByUniseq(appInterface, transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return StatisticCollector.C2C_PTT_UPLOAD_STATISTIC_TAG;
    }

    @Override // com.tencent.mobileqq.transfile.IC2CPttUploadProcessor
    public StepInfo getStepMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (StepInfo) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mProcessorReport.mStepMsg;
    }

    @Override // com.tencent.mobileqq.voicechange.IVoiceChangeHelper.a
    public void onCompressFinished(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        synchronized (this) {
            TransferRequest transferRequest = this.mUiRequest;
            transferRequest.mPttCompressFinish = true;
            MessageForPtt messageForPtt = (MessageForPtt) transferRequest.mRec;
            messageForPtt.voiceLength = i16;
            messageForPtt.voiceType = i3;
            if (!this.mHasVirtualStarted) {
                if (doCheckParam() == 0) {
                    doStart(false);
                }
            } else if (doCheckParam() == 0) {
                doStart(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
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
        WeakReference<AppInterface> weakReference = this.app;
        if (weakReference != null && weakReference.get() != null && this.mUiRequest.mIsPttPreSend) {
            ((IPttPreSendService) this.app.get().getRuntimeService(IPttPreSendService.class, "all")).doOnPreSendEnd(getKey());
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
    public void onNetChangeEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onSuccess();
        updateMessageDataBaseContent(true);
        sendMessageToUpdate(1003);
    }

    protected boolean queryStateByPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).queryStateByPath(this.mUiRequest.mLocalPath, this);
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest.mIsPttPreSend && transferRequest.mCanSendMsg) {
            sendProgressMessage();
            sendMsg();
        }
        return super.resume();
    }

    public void sendFileByBDH() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
        }
        this.mProcessorReport.mStepTrans.logStartTime();
        if (this.mTrans != null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        RichProto.RichProtoReq.PttUpReq makePttUpReq = makePttUpReq();
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.uint32_cmd.set(500);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i3 = s0x346Seq;
        s0x346Seq = i3 + 1;
        pBUInt32Field.set(i3);
        cmd0x346_reqbody.uint32_business_id.set(17);
        cmd0x346_reqbody.uint32_client_type.set(104);
        cmd0x346$ApplyUploadReq cmd0x346_applyuploadreq = new cmd0x346$ApplyUploadReq();
        cmd0x346_applyuploadreq.uint64_sender_uin.set(Long.parseLong(makePttUpReq.selfUin));
        try {
            String str = makePttUpReq.peerUin;
            if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                str = str.substring(1);
            }
            cmd0x346_applyuploadreq.uint64_recver_uin.set(Long.valueOf(str).longValue());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        cmd0x346_applyuploadreq.uint32_file_type.set(2);
        cmd0x346_applyuploadreq.str_file_name.set(makePttUpReq.fileName);
        cmd0x346_applyuploadreq.uint64_file_size.set(makePttUpReq.fileSize);
        cmd0x346_applyuploadreq.bytes_10m_md5.set(ByteStringMicro.copyFrom(makePttUpReq.md5));
        cmd0x346_reqbody.msg_apply_upload_req.set(cmd0x346_applyuploadreq);
        cmd0x346$ExtensionReq cmd0x346_extensionreq = new cmd0x346$ExtensionReq();
        cmd0x346_extensionreq.uint64_id.set(3L);
        cmd0x346_extensionreq.uint32_ptt_format.set(GroupPttUploadProcessor.modifyVoiceType(makePttUpReq.voiceType));
        cmd0x346_extensionreq.uint32_ptt_time.set(makePttUpReq.voiceLength);
        int handlerNetType = BaseHandler.getHandlerNetType();
        cmd0x346_extensionreq.uint32_net_type.set(handlerNetType);
        cmd0x346_extensionreq.uint32_voice_type.set(makePttUpReq.audioPanelType);
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "C2CPttUp: panel[" + makePttUpReq.audioPanelType + "] type[" + makePttUpReq.voiceType + "] length[" + makePttUpReq.voiceLength + "] size[" + makePttUpReq.fileSize + "]");
            if (QLog.isColorLevel()) {
                QLog.d("RecordParams", 2, "C2CPttUp: net[" + handlerNetType + "]");
            }
        }
        setUinType(makePttUpReq, cmd0x346_extensionreq);
        int i16 = makePttUpReq.uinType;
        if (i16 == 1008) {
            cmd0x346_extensionreq.uint32_file_type.set(3);
        } else if (i16 == 9999) {
            cmd0x346_extensionreq.uint32_file_type.set(102);
        }
        cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
        this.mTrans = new Transaction(this.app.get().getCurrentAccountUin(), 26, this.mPttFilePath, (int) this.mStartOffset, this.mLocalMd5, new ITransactionCallback(uptimeMillis) { // from class: com.tencent.mobileqq.transfile.C2CPttUploadProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = uptimeMillis;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, C2CPttUploadProcessor.this, Long.valueOf(uptimeMillis));
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onFailed(int i17, byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(i17), bArr, hashMap);
                    return;
                }
                QLog.i("C2CPicUploadProcessor", 1, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (SystemClock.uptimeMillis() - this.val$startTime) + "ms");
                C2CPttUploadProcessor.this.addBDHReportInfo(hashMap);
                C2CPttUploadProcessor.this.onError();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) bArr, (Object) hashMap);
                } else {
                    C2CPttUploadProcessor.this.doOnSendSuc(bArr, hashMap, this.val$startTime);
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
                C2CPttUploadProcessor.this.log("<BDH_LOG> onSwitch2BackupChannel()");
                C2CPttUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SWITCH_CHNL, String.valueOf(uptimeMillis2 - this.val$startTime));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                C2CPttUploadProcessor.this.log("<BDH_LOG> onTransStart()");
                StepInfo stepInfo = C2CPttUploadProcessor.this.mProcessorReport.mStepTrans;
                stepInfo.startTime = 0L;
                stepInfo.logStartTime();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i17) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i17);
                    return;
                }
                C2CPttUploadProcessor c2CPttUploadProcessor = C2CPttUploadProcessor.this;
                long j3 = i17;
                c2CPttUploadProcessor.file.transferedSize = j3;
                c2CPttUploadProcessor.mTransferedSize = j3;
                if (j3 < c2CPttUploadProcessor.mFileSize && !c2CPttUploadProcessor.mIsCancel && !c2CPttUploadProcessor.mIsPause) {
                    c2CPttUploadProcessor.sendProgressMessage();
                }
            }
        }, cmd0x346_reqbody.toByteArray(), false);
        this.mTrans.cbForReport = new ITransCallbackForReport() { // from class: com.tencent.mobileqq.transfile.C2CPttUploadProcessor.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CPttUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransCallbackForReport
            public void onFailed(int i17, String str2, String str3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i17), str2, str3);
                    return;
                }
                C2CPttUploadProcessor c2CPttUploadProcessor = C2CPttUploadProcessor.this;
                String str4 = c2CPttUploadProcessor.mMd5Str;
                String str5 = c2CPttUploadProcessor.mResid;
                if (str5 == null) {
                    str5 = c2CPttUploadProcessor.mUuid;
                }
                c2CPttUploadProcessor.reportForServerMonitor(RMServMonitorReport.REPORT_NAME_NM_PTTUP, false, i17, str2, str3, str4, str5, null);
            }
        };
        int submitTransactionTask = this.app.get().getHwEngine().submitTransactionTask(this.mTrans);
        QLog.i("C2CPicUploadProcessor", 1, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:26");
        if (submitTransactionTask != 0) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(submitTransactionTask, "sendFileByBDH SubmitError.", "", processorReport.mStepTrans);
            onError();
        }
    }

    protected void sendMessageInner(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageRecord);
        } else {
            ((IPttTempApi) QRoute.api(IPttTempApi.class)).sendMessage(this.app.get(), messageRecord, this.messageObserver);
        }
    }

    void sendMsg() {
        if (!canDoNextStep()) {
            return;
        }
        this.mProcessorReport.mStepMsg.logStartTime();
        im_msg_body$RichText constructPTTRichText = constructPTTRichText();
        if (constructPTTRichText == null) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_UNKOWN_EXCEPTION, "constructpberror", null, processorReport.mStepMsg);
            onError();
            return;
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord == null) {
            WeakReference<AppInterface> weakReference = this.app;
            if (weakReference != null && weakReference.get() != null) {
                messageRecord = getMessageRecord();
                logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
            } else {
                return;
            }
        }
        if (!(messageRecord instanceof MessageForPtt)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("accost_ptt", 4, "mr not ptt?......");
            }
            ProcessorReport processorReport2 = this.mProcessorReport;
            processorReport2.setError(AppConstants.RichMediaErrorCode.ERROR_UNKOWN_EXCEPTION, "constructpberror", null, processorReport2.mStepMsg);
            onError();
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("accost_ptt", 4, "mr is ptt......");
        }
        MessageForPtt messageForPtt = (MessageForPtt) messageRecord;
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "<---sendC2CMsg voiceType\uff1a" + messageForPtt.voiceType + " voiceLength:" + messageForPtt.voiceLength);
        }
        messageForPtt.richText = constructPTTRichText;
        if (!isAppValid()) {
            ProcessorReport processorReport3 = this.mProcessorReport;
            processorReport3.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport3.mStepMsg);
            onError();
        } else {
            if (this.mUiRequest.mUpCallBack != null) {
                updateMessageDataBaseContent(true);
                this.mUiRequest.mUpCallBack.g(constructPTTRichText);
                return;
            }
            WeakReference<AppInterface> weakReference2 = this.app;
            if (weakReference2 != null && weakReference2.get() != null) {
                sendMessageInner(messageRecord);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void setMtype() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        NetReq netReq = this.mNetReq;
        if (netReq != null && (netReq instanceof HttpNetReq)) {
            ((HttpNetReq) netReq).mReqUrl = MsfSdkUtils.insertMtype(AppConstants.HTTP_TYPE_PTT_CU, ((HttpNetReq) netReq).mReqUrl);
        }
    }

    public void setUinType(RichProto.RichProtoReq.PttUpReq pttUpReq, cmd0x346$ExtensionReq cmd0x346_extensionreq) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) pttUpReq, (Object) cmd0x346_extensionreq);
            return;
        }
        int i16 = pttUpReq.uinType;
        if (i16 != 0) {
            if (i16 != 1004) {
                if (i16 != 1006) {
                    i3 = 104;
                    if (i16 != 1020) {
                        if (i16 != 9999) {
                            if (i16 != 10002 && i16 != 10004) {
                                if (i16 != 1000) {
                                    if (i16 != 1001) {
                                        if (i16 != 1008) {
                                            if (i16 == 1009) {
                                                i3 = 103;
                                            }
                                            i3 = 0;
                                        } else {
                                            i3 = 101;
                                        }
                                    }
                                }
                            }
                            i3 = 100;
                        } else {
                            i3 = 114;
                        }
                    }
                } else {
                    cmd0x346_extensionreq.str_dst_phonenum.set(pttUpReq.peerUin);
                    i3 = 102;
                }
            } else {
                i3 = 105;
            }
            cmd0x346_extensionreq.uint64_type.set(i3);
        }
        if (pttUpReq.forceViaOffline) {
            i3 = 500;
            cmd0x346_extensionreq.uint64_type.set(i3);
        }
        i3 = 0;
        cmd0x346_extensionreq.uint64_type.set(i3);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        boolean queryStateByPath;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord == null) {
            WeakReference<AppInterface> weakReference = this.app;
            if (weakReference != null && weakReference.get() != null) {
                messageRecord = getMessageRecord();
                logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
            } else {
                return;
            }
        }
        if (messageRecord == null) {
            logRichMediaEvent("updateDb", "msg null");
            return;
        }
        if (messageRecord instanceof MessageForPtt) {
            MessageForPtt messageForPtt = messageRecord;
            TransferRequest transferRequest = this.mUiRequest;
            if (!transferRequest.mIsPttPreSend) {
                messageForPtt.url = MessageForPtt.getMsgFilePath(messageForPtt.voiceType, transferRequest.mLocalPath);
            }
            messageForPtt.fileSize = this.mFileSize;
            messageForPtt.urlAtServer = this.mResid;
            messageForPtt.itemType = 2;
            messageForPtt.md5 = this.mMd5Str;
            messageForPtt.serial();
            WeakReference<AppInterface> weakReference2 = this.app;
            if (weakReference2 != null && weakReference2.get() != null) {
                IPttTempApi iPttTempApi = (IPttTempApi) QRoute.api(IPttTempApi.class);
                AppInterface appInterface = this.app.get();
                TransferRequest transferRequest2 = this.mUiRequest;
                iPttTempApi.updateMsgContentByUniseq(appInterface, transferRequest2.mPeerUin, transferRequest2.mUinType, messageRecord.uniseq, messageForPtt.msgData);
            }
            if (needChangeToText(messageForPtt)) {
                ReportController.o(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
                WeakReference<AppInterface> weakReference3 = this.app;
                if (weakReference3 != null && weakReference3.get() != null) {
                    ((ISttManagerService) this.app.get().getRuntimeService(ISttManagerService.class, "all")).translate(messageForPtt, 2);
                }
            }
        }
    }
}
