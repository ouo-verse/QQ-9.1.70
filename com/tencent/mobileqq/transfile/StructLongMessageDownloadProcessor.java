package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.mp.mobileqq_mp$RetInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.message.v;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.longconn.longmsg.LongMsg$MsgDownRsp;
import tencent.im.longconn.longmsg.LongMsg$RspBody;
import tencent.im.msg.im_msg_head$Head;

/* loaded from: classes19.dex */
public class StructLongMessageDownloadProcessor extends BaseDownloadProcessor implements Runnable {
    static IPatchRedirector $redirector_ = null;
    private static final ArrayList<TransferRequest> DOWN_LOAD_TRANSFER_REQUESTS;
    private static final int IP_SOURCE_DIRECT = 5;
    private static final int IP_SOURCE_REUSE = 10;
    private static final int IP_SOURCE_SSO_DIRECT_INVALID = 7;
    private static final int IP_SOURCE_SSO_DIRECT_NO_DATA = 6;
    private static final int IP_SOURCE_SSO_DIRECT_PARSE_ERROR = 9;
    private static final int IP_SOURCE_SSO_DIRECT_RETRY = 8;
    private static final int IP_SOURCE_SSO_DIRECT_TIMEOUT = 13;
    private static final int IP_SOURCE_SSO_NETCHANGE = 15;
    private static final int IP_SOURCE_SSO_REUSE_PARSE_ERROR = 12;
    private static final int IP_SOURCE_SSO_REUSE_RETRY = 11;
    private static final int IP_SOURCE_SSO_REUSE_TIMEOUT = 14;
    public static final int LONG_MESSAGE_ERROR_CODE_CANCEL = 2;
    public static final int LONG_MESSAGE_ERROR_CODE_CANCEL_ACCOUNT_CHANGE = 7;
    public static final int LONG_MESSAGE_ERROR_CODE_CANCEL_BACKGROUND = 9;
    public static final int LONG_MESSAGE_ERROR_CODE_CANCEL_CRASH = 6;
    public static final int LONG_MESSAGE_ERROR_CODE_CANCEL_FORCE_OFFLINE = 8;
    public static final int LONG_MESSAGE_ERROR_CODE_CANCEL_TERMINATE = 5;
    public static final int LONG_MESSAGE_ERROR_CODE_DATA_PARSE_ERROR = 12;
    public static final int LONG_MESSAGE_ERROR_CODE_DOWNLOAD_ERROR_NO_TIMEOUT_ERROR = 14;
    public static final int LONG_MESSAGE_ERROR_CODE_EXPIRED = 3;
    public static final int LONG_MESSAGE_ERROR_CODE_ILLEGAL_APP = 16;
    public static final int LONG_MESSAGE_ERROR_CODE_OTHER = 4;
    public static final int LONG_MESSAGE_ERROR_CODE_RESID_ERROR = 13;
    public static final int LONG_MESSAGE_ERROR_CODE_SSO_FAIL = 1;
    public static final int LONG_MESSAGE_ERROR_CODE_STOP_DELETE_MSG = 10;
    public static final int LONG_MESSAGE_ERROR_CODE_STOP_UNFOLLOW = 11;
    public static final int LONG_MESSAGE_ERROR_CODE_STRUCTMESSAGE_NULL = 15;
    public static final int LONG_MESSAGE_ERROR_CODE_SUCCESS = 0;
    public static final int LONG_MSG_STATE_FAILED = 2;
    public static final int LONG_MSG_STATE_LOADING = 1;
    public static final int LONG_MSG_STATE_TIMEOUT = 3;
    public static final int LONG_MSG_STATE_UNKNOWN = 0;
    public static final String PA_OLD_LONG_MSG_TAG = "PaOldLongMsg";
    public static final String REPORTTAG = "StructLongMessageDownloadProcessorForReport";
    public static final String TAG = "StructLongMessageDownloadProcessor";
    static ConcurrentHashMap<Long, HttpNetReq> downloadList;
    QQAppInterface app;
    private int connectionFlag;
    boolean directDownload;
    private int directDownloadFlag;
    int errorCode;
    int httpErrorCode;
    private long mDownloadStartTime;
    private byte[] mMsgKey;
    private long mSSOStartTime;
    AbsStructMsg mStructingMsg;
    String pUin;
    String selfUin;
    String url;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76024);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            DOWN_LOAD_TRANSFER_REQUESTS = new ArrayList<>();
            downloadList = new ConcurrentHashMap<>();
        }
    }

    public StructLongMessageDownloadProcessor(TransFileControllerImpl transFileControllerImpl, TransferRequest transferRequest) {
        super(transFileControllerImpl, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) transFileControllerImpl, (Object) transferRequest);
            return;
        }
        this.directDownload = true;
        this.directDownloadFlag = 5;
        this.connectionFlag = 0;
        this.errorCode = 4;
        this.httpErrorCode = 200;
        this.url = "";
        this.selfUin = "";
        this.pUin = "";
        this.app = (QQAppInterface) super.app;
    }

    public static String bytesToHexString(byte[] bArr) {
        return v.a(bArr);
    }

    public static void cancelPALongMsgTask(QQAppInterface qQAppInterface, String str, long j3) {
        Iterator<Map.Entry<String, IHttpCommunicatorListener>> it = ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).getProcessMap().entrySet().iterator();
        while (it.hasNext()) {
            IHttpCommunicatorListener value = it.next().getValue();
            if (isPALongMsg(value)) {
                ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor) value);
                BaseTransProcessor baseTransProcessor = (BaseTransProcessor) value;
                if (str.equals(baseTransProcessor.mUiRequest.mPeerUin) && j3 == baseTransProcessor.mUiRequest.mUniseq) {
                    baseTransProcessor.cancel();
                    if (QLog.isColorLevel()) {
                        QLog.d("cancelpic", 2, "cancel PALongMsg:" + baseTransProcessor.mUiRequest.mUniseq);
                    }
                }
            }
        }
    }

    private boolean checkDataValid(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            int length = bArr.length;
            if (bArr[0] == 40 && bArr[length - 1] == 41) {
                return true;
            }
            String obj = bArr.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("unexpected body data, len=" + length + ", data=");
            if (obj.length() > 20) {
                obj = obj.substring(0, 20);
            }
            sb5.append(obj);
            QLog.d(TAG, 1, "parseOldLongMsgContent->" + sb5.toString());
            return false;
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.d(TAG, 2, "parseOldLongMsgContent->null bodyData");
        return false;
    }

    public static void deleteTask(QQAppInterface qQAppInterface, String str) {
        ArrayList<TransferRequest> arrayList = DOWN_LOAD_TRANSFER_REQUESTS;
        synchronized (arrayList) {
            if (arrayList != null) {
                if (arrayList.size() != 0 && str != null && qQAppInterface != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "deleteAllTask uin" + str);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)) != null) {
                        Iterator<TransferRequest> it = arrayList.iterator();
                        while (it.hasNext()) {
                            TransferRequest next = it.next();
                            if (str.equalsIgnoreCase(next.mPeerUin)) {
                                cancelPALongMsgTask(qQAppInterface, next.mPeerUin, next.mUniseq);
                                arrayList2.add(next);
                                doReportForDelete(true, next.mSelfUin, next.mPeerUin, next.mUniseq, next);
                            }
                        }
                    }
                    DOWN_LOAD_TRANSFER_REQUESTS.removeAll(arrayList2);
                }
            }
        }
    }

    private boolean directDownloadIfCan() {
        this.directDownload = true;
        this.directDownloadFlag = 5;
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord == null) {
            return false;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("pub_long_msg_url");
        String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
        this.selfUin = messageRecord.selfuin;
        this.pUin = messageRecord.frienduin;
        if (extInfoFromExtStr != null && !"".equals(extInfoFromExtStr) && extInfoFromExtStr2 != null && !"".equals(extInfoFromExtStr2)) {
            String str = extInfoFromExtStr + "&rkey=" + extInfoFromExtStr2;
            String srvAddrForPttDownload = FMTSrvAddrProvider.getInstance().getSrvAddrForPttDownload();
            if (srvAddrForPttDownload == null) {
                srvAddrForPttDownload = FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().getIp();
                this.directDownloadFlag = 10;
                this.connectionFlag = FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().getConnectionFlag();
            }
            if (srvAddrForPttDownload != null && srvAddrForPttDownload.length() != 0) {
                String str2 = srvAddrForPttDownload + str;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "directUrl = " + str + ",url:" + str2);
                }
                receiveFile(messageRecord.uniseq, str2);
                ThreadManager.getSubThreadHandler().postDelayed(this, 30000L);
                return true;
            }
            if (FMTSrvAddrProvider.getInstance().getState() != 1) {
                this.directDownloadFlag = 7;
            } else {
                this.directDownloadFlag = 6;
            }
        }
        return false;
    }

    private void doReportForCancel() {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "LongMessage Download Beacon Report Cancel");
            if (isOldLongMsg(this.mUiRequest.mRec)) {
                QLog.d(PA_OLD_LONG_MSG_TAG, 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", cancle download task!");
            }
        }
        if (isOldLongMsg(this.mUiRequest.mRec)) {
            str = StatisticCollector.PA_OLD_LONGMSG_DOWNLOAD;
        } else {
            str = StatisticCollector.PA_LONGMSG_DOWNLOAD;
        }
        String str2 = str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_uin", this.selfUin);
        hashMap.put(ReportConstant.KEY_LONG_MSG_PUIN, this.pUin);
        hashMap.put(ReportConstant.KEY_LONG_MSG_CHANNEL, "0");
        hashMap.put(ReportConstant.KEY_LONG_MSG_ERROR_CODE, String.valueOf(7));
        hashMap.put("param_url", this.url);
        if (QLog.isColorLevel()) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                QLog.d(REPORTTAG, 2, entry.getKey() + entry.getValue());
            }
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, str2, false, 0L, 0L, hashMap, "", true);
    }

    private static void doReportForDelete(boolean z16, String str, String str2, long j3, TransferRequest transferRequest) {
        String str3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "LongMessage Download Beacon Report Cancel");
            if (isOldLongMsg(transferRequest.mRec)) {
                QLog.d(PA_OLD_LONG_MSG_TAG, 2, "msgId=uniseq:" + transferRequest.mRec.uniseq + ", delete download task!");
            }
        }
        if (isOldLongMsg(transferRequest.mRec)) {
            str3 = StatisticCollector.PA_OLD_LONGMSG_DOWNLOAD;
        } else {
            str3 = StatisticCollector.PA_LONGMSG_DOWNLOAD;
        }
        String str4 = str3;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_uin", str);
        hashMap.put(ReportConstant.KEY_LONG_MSG_PUIN, str2);
        hashMap.put(ReportConstant.KEY_LONG_MSG_CHANNEL, "0");
        if (z16) {
            hashMap.put(ReportConstant.KEY_LONG_MSG_ERROR_CODE, String.valueOf(11));
        } else {
            hashMap.put(ReportConstant.KEY_LONG_MSG_ERROR_CODE, String.valueOf(10));
        }
        hashMap.put(ReportConstant.KEY_LONG_MSG_RESID, "" + j3);
        if (QLog.isColorLevel()) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                QLog.d(REPORTTAG, 2, entry.getKey() + entry.getValue());
            }
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, str4, false, 0L, 0L, hashMap, "", true);
    }

    public static void getStructLongMessage(AppInterface appInterface, MessageRecord messageRecord) {
        ArrayList<TransferRequest> arrayList = DOWN_LOAD_TRANSFER_REQUESTS;
        synchronized (arrayList) {
            Iterator<TransferRequest> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().mUniseq == messageRecord.uniseq) {
                    return;
                }
            }
            TransferRequest transferRequest = new TransferRequest();
            transferRequest.mIsUp = false;
            transferRequest.mPeerUin = messageRecord.frienduin;
            transferRequest.mBusiType = 131079;
            transferRequest.mFileType = 131079;
            transferRequest.mUniseq = messageRecord.uniseq;
            transferRequest.mRec = messageRecord;
            transferRequest.mSelfUin = messageRecord.selfuin;
            if (((ITransFileController) appInterface.getRuntimeService(ITransFileController.class, "")).transferAsync(transferRequest)) {
                DOWN_LOAD_TRANSFER_REQUESTS.add(transferRequest);
            }
            if (QLog.isColorLevel()) {
                if (isOldLongMsg(messageRecord)) {
                    QLog.d(TAG, 2, "getStructLongMessage(oldLongMsg) , messageRecord,msgid= " + messageRecord.uniseq);
                    QLog.d(PA_OLD_LONG_MSG_TAG, 2, "msgId=uniseq:" + messageRecord.uniseq + ", getStructLongMessage");
                } else {
                    QLog.d(TAG, 2, "getStructLongMessage , messageRecord,msgid= " + messageRecord.uniseq);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "LongMessage Download time start: " + System.currentTimeMillis());
            }
        }
    }

    public static boolean isOldLongMsg(MessageRecord messageRecord) {
        if (messageRecord == null || StringUtil.isEmpty(messageRecord.getExtInfoFromExtStr("pub_old_long_msg"))) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isOldLongMsg , messageRecord,msgid= " + messageRecord.msgId + " uid= " + messageRecord.msgUid + " msgseq= " + messageRecord.msgseq + " uniseq=" + messageRecord.uniseq);
            return true;
        }
        return true;
    }

    public static boolean isPALongMsg(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return false;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("pub_long_msg_url");
        String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("pub_long_msg_download_key");
        String extInfoFromExtStr3 = messageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
        if (StringUtil.isEmpty(extInfoFromExtStr) || StringUtil.isEmpty(extInfoFromExtStr2) || StringUtil.isEmpty(extInfoFromExtStr3)) {
            return false;
        }
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.d(TAG, 2, "isPALongMsg , messageRecord,msgid= " + messageRecord.msgId + " uid= " + messageRecord.msgUid + " msgseq= " + messageRecord.msgseq + " uniseq=" + messageRecord.uniseq);
        return true;
    }

    public static boolean needFetchOldLongMsg(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return false;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("pub_old_long_msg");
        String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
        String extInfoFromExtStr3 = messageRecord.getExtInfoFromExtStr("longMsg_State");
        if (StringUtil.isEmpty(extInfoFromExtStr) || StringUtil.isEmpty(extInfoFromExtStr3) || StringUtil.isEmpty(extInfoFromExtStr2)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "needFetchOldLongMsg , messageRecord,msgid= " + messageRecord.msgId + " uid= " + messageRecord.msgUid + " msgseq= " + messageRecord.msgseq + " uniseq=" + messageRecord.uniseq);
            return true;
        }
        return true;
    }

    private byte[] parseOldLongMsgContent(byte[] bArr) {
        int i3;
        if (!checkDataValid(bArr)) {
            return null;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            dataInputStream.readByte();
            int readInt = dataInputStream.readInt();
            int readInt2 = dataInputStream.readInt();
            if (readInt > 0) {
                byte[] bArr2 = new byte[readInt];
                dataInputStream.read(bArr2);
                im_msg_head$Head im_msg_head_head = new im_msg_head$Head();
                im_msg_head_head.mergeFrom(bArr2);
                i3 = im_msg_head_head.msg_httpconn_head.get().uint32_error_code.get();
            } else {
                i3 = 0;
            }
            if (readInt2 > 0 && i3 == 0) {
                byte[] bArr3 = new byte[readInt2];
                dataInputStream.read(bArr3);
                byte[] decrypt = new Cryptor().decrypt(bArr3, this.mMsgKey);
                LongMsg$RspBody longMsg$RspBody = new LongMsg$RspBody();
                longMsg$RspBody.mergeFrom(decrypt);
                LongMsg$MsgDownRsp longMsg$MsgDownRsp = longMsg$RspBody.rpt_msg_down_rsp.get(0);
                if (longMsg$MsgDownRsp.uint32_result.get() != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "parseOldLongMsgContent->uint32_result != 0");
                    }
                    return null;
                }
                byte[] byteArray = longMsg$MsgDownRsp.bytes_msg_content.get().toByteArray();
                if (byteArray != null && byteArray.length > 0) {
                    return byteArray;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "parseOldLongMsgContent->bytes_msg_content == null or empty");
                }
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parseOldLongMsgContent->bodyLen= " + readInt2 + " errCode= " + i3);
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d(TAG, 1, "parseOldLongMsgContent- exception" + e16);
            return null;
        }
    }

    private void removeMessage() {
        if (this.mUiRequest.mRec instanceof MessageForStructing) {
            ArrayList<TransferRequest> arrayList = DOWN_LOAD_TRANSFER_REQUESTS;
            synchronized (arrayList) {
                Iterator<TransferRequest> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TransferRequest next = it.next();
                    if (next.mUniseq == this.mUiRequest.mRec.uniseq) {
                        DOWN_LOAD_TRANSFER_REQUESTS.remove(next);
                        break;
                    }
                }
            }
        }
    }

    private void sendGetUrlReq() {
        this.directDownload = false;
        this.connectionFlag = 0;
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord == null) {
            this.errorCode = 15;
            onError();
            return;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("pub_long_msg_resid");
        if (extInfoFromExtStr != null && !extInfoFromExtStr.equals("")) {
            if (isOldLongMsg(messageRecord)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "sendGetUrlReq->oldLongMsg");
                    QLog.d(PA_OLD_LONG_MSG_TAG, 2, "msgId=uniseq:" + messageRecord.uniseq + ", sendGetUrlReq");
                }
                RichProto.RichProtoReq.MultiMsgDownReq multiMsgDownReq = new RichProto.RichProtoReq.MultiMsgDownReq();
                multiMsgDownReq.selfUin = messageRecord.selfuin;
                String str = messageRecord.frienduin;
                multiMsgDownReq.peerUin = str;
                multiMsgDownReq.secondUin = str;
                multiMsgDownReq.uinType = messageRecord.istroop;
                multiMsgDownReq.msgResId = extInfoFromExtStr.getBytes();
                RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
                richProtoReq.callback = this;
                richProtoReq.protoKey = RichProtoProc.MULTI_MSG_DW;
                richProtoReq.reqs.add(multiMsgDownReq);
                richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
                if (!isAppValid()) {
                    ProcessorReport processorReport = this.mProcessorReport;
                    processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
                    this.errorCode = 16;
                    onError();
                    return;
                }
                if (!canDoNextStep()) {
                    return;
                }
                this.mRichProtoReq = richProtoReq;
                RichProtoProc.procRichProtoReq(richProtoReq);
            } else {
                RichProto.RichProtoReq richProtoReq2 = new RichProto.RichProtoReq();
                richProtoReq2.callback = this;
                richProtoReq2.protoKey = RichProtoProc.PA_LONG_MESSAGE;
                richProtoReq2.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
                if (!isAppValid()) {
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    processorReport2.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport2.mStepUrl);
                    this.errorCode = 16;
                    onError();
                    return;
                }
                if (!canDoNextStep()) {
                    return;
                }
                this.mRichProtoReq = richProtoReq2;
                RichProto.RichProtoReq.LongStructMessageDownReq longStructMessageDownReq = new RichProto.RichProtoReq.LongStructMessageDownReq();
                longStructMessageDownReq.strFileid = extInfoFromExtStr;
                longStructMessageDownReq.peerUin = messageRecord.frienduin;
                richProtoReq2.reqs.add(longStructMessageDownReq);
                RichProtoProc.procRichProtoReq(richProtoReq2);
            }
            this.mSSOStartTime = System.nanoTime();
            return;
        }
        if (!isPALongMsg(messageRecord) && !isOldLongMsg(messageRecord)) {
            return;
        }
        this.errorCode = 13;
        onError();
    }

    private void updateMessageDataBaseContent(int i3) {
        MessageForStructing messageForStructing;
        long j3;
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if ((messageRecord instanceof MessageForStructing) && (messageForStructing = (MessageForStructing) messageRecord) != null) {
            if (i3 == 2003) {
                messageForStructing.removeExtInfoToExtStr("pub_long_msg_url");
                messageForStructing.removeExtInfoToExtStr("pub_long_msg_download_key");
                messageForStructing.removeExtInfoToExtStr("pub_long_msg_resid");
                AbsStructMsg absStructMsg = this.mStructingMsg;
                if (absStructMsg instanceof StructMsgForGeneralShare) {
                    String str = ((StructMsgForGeneralShare) absStructMsg).mWarningTips;
                    if (!TextUtils.isEmpty(str)) {
                        messageForStructing.saveExtInfoToExtStr("pa_phone_msg_tip", str);
                    }
                }
                AbsStructMsg absStructMsg2 = messageForStructing.structingMsg;
                if (absStructMsg2 != null) {
                    j3 = absStructMsg2.msgId;
                } else {
                    j3 = 0;
                }
                AbsStructMsg absStructMsg3 = this.mStructingMsg;
                messageForStructing.structingMsg = absStructMsg3;
                absStructMsg3.msgId = j3;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "LongMessage data size: " + this.mStructingMsg.getBytes().length);
                }
                messageForStructing.msgData = this.mStructingMsg.getBytes();
                QQMessageFacade messageFacade = this.app.getMessageFacade();
                TransferRequest transferRequest = this.mUiRequest;
                messageFacade.Y0(transferRequest.mPeerUin, transferRequest.mUinType, messageForStructing.uniseq, messageForStructing.msgData);
                QQMessageFacade messageFacade2 = this.app.getMessageFacade();
                TransferRequest transferRequest2 = this.mUiRequest;
                messageFacade2.a1(transferRequest2.mPeerUin, transferRequest2.mUinType, messageForStructing.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageForStructing.extStr);
                this.app.getMsgHandler().notifyUI(999, true, this.mUiRequest.mPeerUin);
                return;
            }
            if (i3 == 2005) {
                messageForStructing.saveExtInfoToExtStr("longMsg_State", String.valueOf(2));
                messageForStructing.structingMsg.mMsgBrief = HardCodeUtil.qqStr(R.string.tvs);
                messageForStructing.msgData = messageForStructing.structingMsg.getBytes();
                QQMessageFacade messageFacade3 = this.app.getMessageFacade();
                TransferRequest transferRequest3 = this.mUiRequest;
                messageFacade3.Y0(transferRequest3.mPeerUin, transferRequest3.mUinType, messageForStructing.uniseq, messageForStructing.msgData);
                QQMessageFacade messageFacade4 = this.app.getMessageFacade();
                TransferRequest transferRequest4 = this.mUiRequest;
                messageFacade4.a1(transferRequest4.mPeerUin, transferRequest4.mUinType, messageForStructing.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageForStructing.extStr);
                this.app.getMsgHandler().notifyUI(999, true, this.mUiRequest.mPeerUin);
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseDownloadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void accountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        cancelTask(this.mUiRequest.mUniseq);
        this.errorCode = 7;
        notifyCancelTask();
    }

    public void cancelTask(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
            return;
        }
        ArrayList<TransferRequest> arrayList = DOWN_LOAD_TRANSFER_REQUESTS;
        synchronized (arrayList) {
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "cancelAllTask msgid" + j3);
                    }
                    if (((ITransFileController) this.app.getRuntimeService(ITransFileController.class)) != null) {
                        Iterator<TransferRequest> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            TransferRequest next = it.next();
                            long j16 = next.mUniseq;
                            if (j16 == j3) {
                                cancelPALongMsgTask(this.app, next.mPeerUin, j16);
                                DOWN_LOAD_TRANSFER_REQUESTS.remove(next);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return super.checkParam();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        int i3 = 1;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("LongMessage Download Beacon Report ErrCode=%d mReportedFlag=%x ", Integer.valueOf(this.errorCode), Integer.valueOf(this.mProcessorReport.mReportedFlag)) + hashCode());
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (!processorReport.mIsOldDbRec) {
            if (!z16 || (processorReport.mReportedFlag & 2) <= 0) {
                if (z16 || (processorReport.mReportedFlag & 1) <= 0) {
                    int i16 = processorReport.mReportedFlag;
                    if (z16) {
                        i3 = 2;
                    }
                    processorReport.mReportedFlag = i3 | i16;
                    if (isOldLongMsg(this.mUiRequest.mRec)) {
                        str = StatisticCollector.PA_OLD_LONGMSG_DOWNLOAD;
                    } else {
                        str = StatisticCollector.PA_LONGMSG_DOWNLOAD;
                    }
                    String str2 = str;
                    this.mProcessorReport.mEndTime = System.currentTimeMillis();
                    long nanoTime = System.nanoTime();
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    long j3 = (nanoTime - processorReport2.mStartTime) / 1000000;
                    processorReport2.mReportInfo.put("param_uin", this.mUiRequest.mRec.selfuin);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_LONG_MSG_PUIN, this.mUiRequest.mRec.senderuin);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_LONG_MSG_RESID, this.mUiRequest.mRec.getExtInfoFromExtStr("pub_long_msg_resid"));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_LONG_MSG_IP_SOURCE, "" + this.directDownloadFlag);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_LONG_MSG_CHANNEL, "0");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_LONG_MSG_ERROR_CODE, String.valueOf(this.errorCode));
                    this.mProcessorReport.mReportInfo.put("param_url", this.url);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_LONG_MSG_HTTP_ERROR_CODE, String.valueOf(this.httpErrorCode));
                    ProcessorReport processorReport3 = this.mProcessorReport;
                    processorReport3.mReportInfo.put(ReportConstant.KEY_LONG_MSG_ANDROID_ERR_CODE, String.valueOf(processorReport3.errCode));
                    if (QLog.isColorLevel()) {
                        for (Map.Entry<String, String> entry : this.mProcessorReport.mReportInfo.entrySet()) {
                            QLog.d(REPORTTAG, 2, entry.getKey() + entry.getValue());
                        }
                    }
                    if (z16) {
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, str2, true, j3, this.mTotolLen, this.mProcessorReport.mReportInfo, "", true);
                    } else {
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, str2, false, j3, 0L, this.mProcessorReport.mReportInfo, "", true);
                    }
                    setReportFlag();
                }
            }
        }
    }

    public void doReportForExpired(int i3, MessageRecord messageRecord) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3, (Object) messageRecord);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "LongMessage Download Beacon Report Expired");
            if (isOldLongMsg(this.mUiRequest.mRec)) {
                QLog.d(PA_OLD_LONG_MSG_TAG, 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", resource expired!");
            }
        }
        if (isOldLongMsg(this.mUiRequest.mRec)) {
            str = StatisticCollector.PA_OLD_LONGMSG_DOWNLOAD;
        } else {
            str = StatisticCollector.PA_LONGMSG_DOWNLOAD;
        }
        String str2 = str;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_uin", messageRecord.selfuin);
        hashMap.put(ReportConstant.KEY_LONG_MSG_PUIN, messageRecord.frienduin);
        hashMap.put(ReportConstant.KEY_LONG_MSG_RESID, messageRecord.getExtInfoFromExtStr("pub_long_msg_resid"));
        hashMap.put(ReportConstant.KEY_LONG_MSG_CHANNEL, "0");
        hashMap.put(ReportConstant.KEY_LONG_MSG_ERROR_CODE, String.valueOf(i3));
        hashMap.put("param_url", this.url);
        if (QLog.isColorLevel()) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                QLog.d(REPORTTAG, 2, entry.getKey() + entry.getValue());
            }
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, str2, false, 0L, 0L, hashMap, "", true);
    }

    void handleReq(NetResp netResp) {
        if (netResp.mReq instanceof HttpNetReq) {
            logRichMediaEvent("onResp", "result:" + netResp.mResult + " errCode:" + netResp.mHttpCode + " errDesc:" + netResp.mErrDesc);
            this.httpErrorCode = netResp.mHttpCode;
            HttpNetReq httpNetReq = (HttpNetReq) netResp.mReq;
            if (httpNetReq.mReqUrl != null) {
                for (Map.Entry<Long, HttpNetReq> entry : downloadList.entrySet()) {
                    if (httpNetReq.mReqUrl.equals(entry.getValue().mReqUrl)) {
                        downloadList.remove(entry.getKey());
                    }
                }
            }
        }
    }

    void handleRespError(NetResp netResp) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        String str = this.url;
        if (str != null && !"".equals(str)) {
            FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().deleteIp(TransFileUtil.getIpAndPortFromUrl(this.url));
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if ((messageRecord instanceof MessageForStructing) && isResourceIDOutofDate(messageRecord) && 399 < (i17 = this.httpErrorCode) && i17 < 500) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            notifyResourceExpired(this.mUiRequest.mRec);
            return;
        }
        if (netResp.mErrCode == 9364 && (i16 = this.mNetworkChgRetryCount) < 3) {
            this.mNetworkChgRetryCount = i16 + 1;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "LongMessage Download Fail. Net Changed. Retry " + this.mNetworkChgRetryCount);
            }
            clearReprotInfo();
            this.directDownloadFlag = 15;
            sendGetUrlReq();
            return;
        }
        if (this.directDownload) {
            if (this.directDownloadFlag == 5) {
                i3 = 8;
            } else {
                i3 = 11;
            }
            this.directDownloadFlag = i3;
            requestUrlWhileDirectFailed();
            return;
        }
        this.errorCode = 14;
        onError();
    }

    void handleRespSucess(NetResp netResp) {
        byte[] bArr = netResp.mRespData;
        this.mTotolLen = bArr.length;
        handleStructMsg(bArr);
        if (this.mStructingMsg != null) {
            this.errorCode = 0;
            onSuccess();
            if (isOldLongMsg(this.mUiRequest.mRec)) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.PA_OLD_LONGMSG_TIME_DOWNLOAD, true, (System.nanoTime() - this.mDownloadStartTime) / 1000000, 0L, (HashMap<String, String>) null, "", true);
                return;
            } else {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.PA_LONGMSG_TIME_DOWNLOAD, true, (System.nanoTime() - this.mDownloadStartTime) / 1000000, 0L, (HashMap<String, String>) null, "", true);
                return;
            }
        }
        String str = this.url;
        if (str != null && !"".equals(str)) {
            FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().deleteIp(TransFileUtil.getIpAndPortFromUrl(this.url));
        }
        int i3 = 12;
        if (this.directDownload) {
            if (this.directDownloadFlag == 5) {
                i3 = 9;
            }
            this.directDownloadFlag = i3;
            requestUrlWhileDirectFailed();
            return;
        }
        this.errorCode = 12;
        onError();
    }

    protected void handleStructMsg(byte[] bArr) {
        AbsStructMsg absStructMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr);
            return;
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord instanceof MessageForStructing) {
            if (isOldLongMsg(messageRecord)) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onResp->oldLongMsg");
                        QLog.d(PA_OLD_LONG_MSG_TAG, 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", onResp->getStructMsgFromXmlBuff");
                    }
                    this.mStructingMsg = i.g(parseOldLongMsgContent(bArr), -1);
                } catch (Exception e16) {
                    QLog.d(TAG, 1, e16, new Object[0]);
                }
            } else {
                this.mStructingMsg = i.g(bArr, -1);
            }
            if (this.mUiRequest.mRec.istroop == 1008 && (absStructMsg = this.mStructingMsg) != null) {
                if (TextUtils.isEmpty(absStructMsg.mMsgBrief) || this.mStructingMsg.mEmptyMsgBriefModified) {
                    this.mStructingMsg.mMsgBrief = AbsStructMsg.PA_DEFAULT_MSG_BRIEF;
                }
            }
        }
    }

    public boolean isResourceIDOutofDate(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord == null) {
            return false;
        }
        if (messageRecord.time >= NetConnInfoCenter.getServerTime() - JoinTimeType.SEVEN_DAY) {
            return false;
        }
        return true;
    }

    public void notifyCancelTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            doReportForCancel();
        }
    }

    public void notifyResourceExpired(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) messageRecord);
            return;
        }
        this.errorCode = 3;
        messageRecord.saveExtInfoToExtStr("longMsg_State", String.valueOf(3));
        if (messageRecord instanceof MessageForStructing) {
            MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
            messageForStructing.structingMsg.mMsgBrief = HardCodeUtil.qqStr(R.string.tvr);
            messageForStructing.msgData = messageForStructing.structingMsg.getBytes();
            QQMessageFacade messageFacade = this.app.getMessageFacade();
            TransferRequest transferRequest = this.mUiRequest;
            messageFacade.Y0(transferRequest.mPeerUin, transferRequest.mUinType, messageForStructing.uniseq, messageForStructing.msgData);
            QQMessageFacade messageFacade2 = this.app.getMessageFacade();
            TransferRequest transferRequest2 = this.mUiRequest;
            messageFacade2.a1(transferRequest2.mPeerUin, transferRequest2.mUinType, messageForStructing.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageForStructing.extStr);
            this.app.getMsgHandler().notifyUI(999, true, this.mUiRequest.mPeerUin);
        }
        removeMessage();
        doReportForExpired(this.errorCode, messageRecord);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        List<RichProto.RichProtoResp.RespCommon> list;
        List<RichProto.RichProtoResp.RespCommon> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        if (richProtoResp != null && (list2 = richProtoResp.resps) != null && list2.size() > 0 && (richProtoResp.resps.get(0) instanceof RichProto.RichProtoResp.LongStructMessageDownResp)) {
            RichProto.RichProtoResp.LongStructMessageDownResp longStructMessageDownResp = (RichProto.RichProtoResp.LongStructMessageDownResp) richProtoResp.resps.get(0);
            mobileqq_mp$RetInfo mobileqq_mp_retinfo = longStructMessageDownResp.retInfo;
            if (mobileqq_mp_retinfo != null && mobileqq_mp_retinfo.ret_code.get() == 0) {
                receiveFile(this.mUiRequest.mRec.uniseq, longStructMessageDownResp.strUrl);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.PA_LONGMSG_TIME_SSO, true, (System.nanoTime() - this.mSSOStartTime) / 1000000, 0L, (HashMap<String, String>) null, "", true);
                return;
            } else {
                this.errorCode = 1;
                onError();
                return;
            }
        }
        if (richProtoResp != null && (list = richProtoResp.resps) != null && list.size() > 0 && (richProtoResp.resps.get(0) instanceof RichProto.RichProtoResp.MultiMsgDownResp)) {
            RichProto.RichProtoResp.MultiMsgDownResp multiMsgDownResp = (RichProto.RichProtoResp.MultiMsgDownResp) richProtoResp.resps.get(0);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onBusiProtoResp->oldLongMsg procUrl:" + multiMsgDownResp.toString());
                QLog.d(PA_OLD_LONG_MSG_TAG, 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", onBusiProtoResp->oldLongMsg procUrl:" + multiMsgDownResp.toString());
            }
            if (multiMsgDownResp.result == 0) {
                int i3 = multiMsgDownResp.mChannelType;
                String str = "http://";
                if (i3 != 0 && i3 == 2) {
                    str = "https://";
                }
                ServerAddr serverAddr = multiMsgDownResp.ipList.get(0);
                String str2 = str + serverAddr.mIp;
                if (serverAddr.port != 80) {
                    str2 = str2 + ":" + serverAddr.port;
                }
                String str3 = str2 + multiMsgDownResp.urlParam;
                this.mMsgKey = multiMsgDownResp.msgkey;
                receiveFile(this.mUiRequest.mRec.uniseq, str3);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, StatisticCollector.PA_OLD_LONGMSG_TIME_SSO, true, (System.nanoTime() - this.mSSOStartTime) / 1000000, 0L, (HashMap<String, String>) null, "", true);
                return;
            }
            this.errorCode = 1;
            onError();
            return;
        }
        this.errorCode = 1;
        onError();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onError();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "msgId=" + this.mUiRequest.mRec.uniseq + ", receiveError");
            if (isOldLongMsg(this.mUiRequest.mRec)) {
                QLog.d(PA_OLD_LONG_MSG_TAG, 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", receiveError");
            }
        }
        updateMessageDataBaseContent(2005);
        sendMessageToUpdate(2005);
        removeMessage();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) netResp);
            return;
        }
        if (this.directDownload) {
            ThreadManager.getSubThreadHandler().removeCallbacks(this);
        }
        if (netResp == null) {
            return;
        }
        super.onResp(netResp);
        this.mProcessorReport.errCode = netResp.mErrCode;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "LongMessage Download time end: " + System.currentTimeMillis());
        }
        handleReq(netResp);
        NetReq netReq = this.mNetReq;
        if (netReq != null) {
            netReq.mCallback = null;
        }
        this.mNetReq = null;
        if (netResp.mResult == 0 && (bArr = netResp.mRespData) != null && bArr.length > 0) {
            handleRespSucess(netResp);
        } else {
            handleRespError(netResp);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onSuccess();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "msgId=" + this.mUiRequest.mRec.uniseq + ", receiveSuccess");
            if (isOldLongMsg(this.mUiRequest.mRec)) {
                QLog.d(PA_OLD_LONG_MSG_TAG, 2, "msgId=uniseq:" + this.mUiRequest.mRec.uniseq + ", receiveSuccess");
            }
        }
        updateMessageDataBaseContent(2003);
        sendMessageToUpdate(2003);
        removeMessage();
    }

    protected void receiveFile(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), str);
            return;
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = this;
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mServerList = this.mIpList;
        this.mNetEngine.sendReq(httpNetReq);
        downloadList.put(Long.valueOf(j3), httpNetReq);
        this.mNetReq = httpNetReq;
        FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().saveIp(TransFileUtil.getIpAndPortFromUrl(str));
        this.url = str;
        this.mDownloadStartTime = System.nanoTime();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "receiveFile->msgid:" + j3 + ", url:" + str);
            if (isOldLongMsg(this.mUiRequest.mRec)) {
                QLog.d(PA_OLD_LONG_MSG_TAG, 2, "msgId=uniseq:" + j3 + ", receiveFile->url:" + str);
            }
        }
    }

    void requestUrlWhileDirectFailed() {
        sendGetUrlReq();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (this.mNetReq != null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "Direct download failed timeout");
            }
            this.mNetEngine.cancelReq(this.mNetReq);
            this.mNetReq = null;
        }
        if (this.directDownloadFlag == 5) {
            i3 = 13;
        } else {
            i3 = 14;
        }
        this.directDownloadFlag = i3;
        String str = this.url;
        if (str != null && !"".equals(str)) {
            FMTSrvAddrProvider.getInstance().getLongMsgIpSaver().deleteIp(TransFileUtil.getIpAndPortFromUrl(this.url));
        }
        sendGetUrlReq();
    }

    @Override // com.tencent.mobileqq.transfile.BaseDownloadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.start();
        if (!directDownloadIfCan()) {
            sendGetUrlReq();
        }
    }

    private static boolean isPALongMsg(IHttpCommunicatorListener iHttpCommunicatorListener) {
        return (iHttpCommunicatorListener == null || !(iHttpCommunicatorListener instanceof StructLongMessageDownloadProcessor) || ((BaseTransProcessor) iHttpCommunicatorListener).getFileStatus() == 2003) ? false : true;
    }

    public StructLongMessageDownloadProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.directDownload = true;
        this.directDownloadFlag = 5;
        this.connectionFlag = 0;
        this.errorCode = 4;
        this.httpErrorCode = 200;
        this.url = "";
        this.selfUin = "";
        this.pUin = "";
    }

    public static void deleteTask(QQAppInterface qQAppInterface, long j3) {
        ArrayList<TransferRequest> arrayList = DOWN_LOAD_TRANSFER_REQUESTS;
        synchronized (arrayList) {
            if (arrayList != null) {
                if (arrayList.size() != 0 && qQAppInterface != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "deleteAllTask msgid" + j3);
                    }
                    if (((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)) != null) {
                        Iterator<TransferRequest> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            TransferRequest next = it.next();
                            long j16 = next.mUniseq;
                            if (j16 == j3) {
                                cancelPALongMsgTask(qQAppInterface, next.mPeerUin, j16);
                                DOWN_LOAD_TRANSFER_REQUESTS.remove(next);
                                doReportForDelete(false, next.mSelfUin, next.mPeerUin, next.mUniseq, next);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
