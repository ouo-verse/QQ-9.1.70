package com.tencent.mobileqq.transfile;

import QQService.StreamData;
import QQService.StreamInfo;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.heytap.databaseengine.utils.DateUtil;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.facade.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.service.message.k;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: classes19.dex */
public class BuddyTransfileProcessor extends BaseTransProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final int C2CPIC_TRANSTYPE_OFFLINE = 2;
    public static final int C2CPIC_TRANSTYPE_ONLINE = 1;
    public static final int C2CPIC_TRANSTYPE_UNKNOWN = 0;
    private static final String FILE_OFFFILE_DIR = "file/";
    public static boolean PbOn = false;
    public static final String STORAGE_FTN = "ftn";
    public static final String STORAGE_PIC_PLATFORM = "picplatform";
    public static final String STORAGE_PTT_CENTER = "pttcenter";
    public static final String STREAM_TAG_R = "streamptt.recv";
    public static final String STREAM_TAG_S = "streamptt.send";
    public static final String TAG = "streamptt";
    private static List<String> streamStreamDuplicateList;
    protected QQAppInterface app;
    private String friendUin;
    public boolean isPause;
    public boolean isRawPic;
    public boolean isStop;
    boolean isStreamPttSuccess;
    private boolean mOldPttData;
    bs messageObserver;
    private int msgseq;
    private String peerUin;
    long pttTimeStamp;
    private long random;
    int respCode;
    private String selfUin;
    int sendSeqMax;
    boolean setPttRecordFinishTime;
    int severAckSlice;
    private ExecutorService streamEs;
    int streamPttFlag;
    int streamPttTimeoutRetryCount;
    int voiceLength;
    int voiceType;

    /* loaded from: classes19.dex */
    public static class A9Message {
        static IPatchRedirector $redirector_;
        public String serverPath;
        public byte type;

        public A9Message() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes19.dex */
    public static class C2CPicMsgParseResult {
        static IPatchRedirector $redirector_;
        public String actionUrl;
        public byte[] dSig;
        public String fileName;
        public long fileSize;
        public String msgContent;
        public int repeatIndex;
        public byte[] sNote;
        public byte[] sUUID;
        public String serverPath;
        public int type;

        public C2CPicMsgParseResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.repeatIndex = -1;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75944);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            PbOn = true;
            streamStreamDuplicateList = new ArrayList();
        }
    }

    public BuddyTransfileProcessor(String str, String str2, boolean z16, String str3, String str4, int i3, int i16, boolean z17, TransFileControllerImpl transFileControllerImpl, long j3) {
        super(str, str2, z16, transFileControllerImpl);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Boolean.valueOf(z16), str3, str4, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17), transFileControllerImpl, Long.valueOf(j3));
            return;
        }
        this.isRawPic = false;
        this.isPause = false;
        this.mOldPttData = false;
        this.streamPttTimeoutRetryCount = 0;
        this.severAckSlice = 1;
        this.sendSeqMax = 0;
        this.isStreamPttSuccess = false;
        this.streamPttFlag = -1;
        this.pttTimeStamp = -1L;
        this.respCode = -1;
        this.messageObserver = new bs() { // from class: com.tencent.mobileqq.transfile.BuddyTransfileProcessor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyTransfileProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.app.bs
            protected void onUpdateUploadStreamFinished(boolean z18, k.d dVar) {
                String str5;
                FileMsg fileMsg;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z18), dVar);
                    return;
                }
                if (dVar != null && QLog.isColorLevel()) {
                    QLog.e(BuddyTransfileProcessor.STREAM_TAG_S, 2, "onUpdateUploadStreamFinished Key:" + dVar.f286312a + " seq:" + ((int) dVar.f286313b) + " Layer:" + dVar.f286314c + " RespCode:" + dVar.f286316e);
                }
                if (BuddyTransfileProcessor.this.file != null && QLog.isColorLevel()) {
                    QLog.e(BuddyTransfileProcessor.STREAM_TAG_S, 2, "isSuccess:" + z18 + "\u3000FilePath:" + BuddyTransfileProcessor.this.file.filePath + " isStreamPttSuccess:" + BuddyTransfileProcessor.this.isStreamPttSuccess);
                }
                if (dVar != null && (str5 = dVar.f286312a) != null && (fileMsg = BuddyTransfileProcessor.this.file) != null && str5.equalsIgnoreCase(fileMsg.filePath)) {
                    if (!z18) {
                        BuddyTransfileProcessor.this.handleUploadStreamPttFinished(false, dVar);
                    } else {
                        BuddyTransfileProcessor.this.handleUploadStreamPttFinished(true, dVar);
                    }
                }
            }
        };
        this.setPttRecordFinishTime = false;
        this.voiceType = 0;
        this.voiceLength = 0;
        QQAppInterface qQAppInterface = (QQAppInterface) super.app;
        this.app = qQAppInterface;
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        this.selfUin = currentAccountUin;
        int i17 = i3;
        if (i17 == 131075) {
            this.isRawPic = true;
            i17 = 1;
        }
        this.friendUin = str;
        FileMsg fileMsg = this.file;
        fileMsg.peerUin = str;
        fileMsg.selfUin = currentAccountUin;
        if (!z16 && z17) {
            fileMsg.mUin = currentAccountUin;
            fileMsg.friendUin = str;
            this.peerUin = currentAccountUin;
        } else {
            this.peerUin = str;
        }
        setFakeProgressCapable(false);
        setTransType(i17);
        this.file.uinType = 0;
        if (FileUtils.isLocalPath(str3)) {
            this.file.filePath = str3;
        }
        if (str4 != null && !FileUtils.isLocalPath(str4)) {
            this.file.serverPath = str4;
        }
        if (i17 == 65538) {
            FileMsg fileMsg2 = this.file;
            fileMsg2.fileMd5 = fileMsg2.filePath;
            fileMsg2.suffixType = "gif";
        }
        if (i17 == 2 && z16) {
            MessageRecord P = this.app.getMessageFacade().P(this.peerUin, 0, j3);
            if (P != null) {
                this.random = s.e(P.msgUid);
                this.msgseq = (int) P.shmsgseq;
            }
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "random:" + this.random + " msgseq:" + this.msgseq);
            }
        }
    }

    public static A9Message analysisOffLineFileMsg(byte[] bArr, long[] jArr) {
        String str;
        A9Message a9Message = new A9Message();
        String.valueOf(jArr[0]);
        if (bArr[0] == 1) {
            a9Message.type = bArr[1];
            int shortData = 4 + PkgTools.getShortData(bArr, 2);
            int i3 = bArr[shortData];
            if (i3 < 0) {
                i3 += 256;
            }
            int i16 = shortData + 1;
            byte[] bArr2 = new byte[i3];
            PkgTools.copyData(bArr2, 0, bArr, i16, i3);
            int i17 = i16 + i3;
            long longData = PkgTools.getLongData(bArr, i17 + 2 + PkgTools.getShortData(bArr, i17));
            if (longData > 10000) {
                jArr[0] = longData;
            }
            str = new String(bArr2);
        } else {
            str = null;
        }
        a9Message.serverPath = str;
        return a9Message;
    }

    public static C2CPicMsgParseResult analysisTransFileMsg(byte[] bArr, short s16, long[] jArr) {
        byte b16;
        byte b17;
        long j3;
        if (bArr != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getFileUuid msgHex:" + HexUtil.bytes2HexStr(bArr));
            }
            C2CPicMsgParseResult c2CPicMsgParseResult = new C2CPicMsgParseResult();
            if (s16 == 169) {
                c2CPicMsgParseResult.type = 1;
                if (bArr[0] == 1) {
                    byte b18 = bArr[1];
                    int shortData = PkgTools.getShortData(bArr, 2);
                    byte[] bArr2 = new byte[shortData];
                    c2CPicMsgParseResult.dSig = bArr2;
                    PkgTools.copyData(bArr2, 0, bArr, 4, shortData);
                    int i3 = 4 + shortData;
                    int i16 = bArr[i3];
                    int i17 = i3 + 1;
                    byte[] bArr3 = new byte[i16];
                    c2CPicMsgParseResult.sUUID = bArr3;
                    PkgTools.copyData(bArr3, 0, bArr, i17, i16);
                    int i18 = i17 + i16;
                    int shortData2 = PkgTools.getShortData(bArr, i18);
                    int i19 = i18 + 2;
                    byte[] bArr4 = new byte[shortData2];
                    c2CPicMsgParseResult.sNote = bArr4;
                    PkgTools.copyData(bArr4, 0, bArr, i19, shortData2);
                    j3 = PkgTools.getLongData(bArr, i19 + shortData2);
                    b17 = b18;
                } else {
                    b17 = 0;
                    j3 = 0;
                }
                byte[] bArr5 = c2CPicMsgParseResult.sUUID;
                if (bArr5 != null) {
                    c2CPicMsgParseResult.fileSize = 0L;
                    if (j3 > 10000) {
                        jArr[0] = j3;
                    }
                    c2CPicMsgParseResult.serverPath = new String(bArr5);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "analysisFileC2cMsg  dwReserved: " + j3 + " serverPath:" + c2CPicMsgParseResult.serverPath);
                    }
                    b16 = b17;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "analysisFileC2cMsg fail");
                    }
                    return null;
                }
            } else {
                if (bArr[0] == 22 && bArr[1] == 32) {
                    return decodeOffLinePic(bArr, false);
                }
                b16 = 0;
            }
            String str = c2CPicMsgParseResult.serverPath;
            if (str != null) {
                c2CPicMsgParseResult.msgContent = TransfileUtile.makeTransFileProtocolData(str, c2CPicMsgParseResult.fileSize, b16, false, str);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getFriendPhotoMsg serverPath:" + c2CPicMsgParseResult.msgContent);
                }
            }
            return c2CPicMsgParseResult;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getFriendPhotoMsg vMsg is null");
        }
        return null;
    }

    public static C2CPicMsgParseResult decodeOffLinePic(byte[] bArr, boolean z16) {
        String str;
        String str2;
        C2CPicMsgParseResult c2CPicMsgParseResult = new C2CPicMsgParseResult();
        c2CPicMsgParseResult.type = 2;
        PkgTools.ascByteToLong(bArr, 2, 3).longValue();
        if (bArr[5] == 49 && bArr[6] == 48) {
            PkgTools.ascByteToLong(bArr, 7, 3).longValue();
            byte b16 = bArr[10];
            int i3 = 11;
            if (b16 == 50) {
                c2CPicMsgParseResult.repeatIndex = bArr[11] - 65;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getFriendPhotoMsg offline file path repeat");
                }
                str2 = "utf-8";
            } else if (b16 != 49) {
                str2 = "utf-8";
                i3 = 10;
            } else {
                byte b17 = bArr[11];
                i3 = 12;
                byte b18 = bArr[12];
                if (b18 - 65 == 0) {
                    str2 = "utf-8";
                    c2CPicMsgParseResult.fileSize = PkgTools.ascByteToLong(bArr, 13, 10).longValue();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getFriendPhotoMsg offline file path fail");
                    }
                    i3 = 23;
                } else {
                    str2 = "utf-8";
                    if (b18 - 65 == 1) {
                        c2CPicMsgParseResult.fileSize = PkgTools.ascByteToLong(bArr, 13, 10).longValue();
                        int i16 = bArr[23] - 65;
                        byte[] bArr2 = new byte[i16];
                        PkgTools.copyData(bArr2, 0, bArr, 24, i16);
                        c2CPicMsgParseResult.fileName = new String(bArr2);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "<---decodeOffLinePic : ret.fileName:" + c2CPicMsgParseResult.fileName);
                        }
                        int i17 = 24 + i16;
                        int i18 = bArr[i17] - 65;
                        int i19 = i17 + 1;
                        byte[] bArr3 = new byte[i18];
                        PkgTools.copyData(bArr3, 0, bArr, i19, i18);
                        i3 = i19 + i18;
                        try {
                            c2CPicMsgParseResult.serverPath = new String(bArr3, str2);
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "getFriendPhotoMsg serverPath:" + c2CPicMsgParseResult.serverPath);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (bArr[i3] == 65) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "parse down file path success");
                }
                int i26 = i3 + 1;
                if (bArr.length > i26 && bArr[i26] == 10) {
                    try {
                        c2CPicMsgParseResult.actionUrl = new String(bArr, str2).substring(i3 + 2);
                    } catch (Exception unused2) {
                        QLog.w(TAG, 2, "buddy_mixed, decode action error");
                    }
                }
            }
        }
        if (c2CPicMsgParseResult.serverPath != null) {
            if (c2CPicMsgParseResult.fileName.length() > 0) {
                str = c2CPicMsgParseResult.fileName.split("\\.")[0];
            } else {
                str = null;
            }
            String str3 = c2CPicMsgParseResult.serverPath;
            c2CPicMsgParseResult.msgContent = TransfileUtile.makeTransFileProtocolData(str3, c2CPicMsgParseResult.fileSize, 1, false, str3, str, null);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "<---decodeOffLinePic : md5Str:" + str + ",afterDecode:" + TransfileUtile.getPicMD5ByMsgContent(c2CPicMsgParseResult.msgContent));
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getFriendPhotoMsg serverPath:" + c2CPicMsgParseResult.msgContent);
            }
        }
        return c2CPicMsgParseResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUploadStreamPttFinished(boolean z16, k.d dVar) {
        long j3;
        long j16;
        short s16 = dVar.f286313b;
        short s17 = (short) dVar.f286314c;
        String str = dVar.f286312a;
        int i3 = 0;
        if (z16) {
            int i16 = dVar.f286316e;
            if (i16 != 0) {
                this.respCode = i16;
                updateSendMessageErrorDb(this.friendUin, 0, this.file.uniseq, i16);
                onError();
                com.tencent.mobileqq.streamtransfile.b.i(str);
                ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(str);
                if (dVar.f286316e == 58) {
                    insertFriendShieldTips();
                }
                if (QLog.isColorLevel()) {
                    QLog.e(STREAM_TAG_S, 2, "respCode = " + this.respCode);
                    return;
                }
                return;
            }
            if (s16 == -1) {
                this.isStreamPttSuccess = true;
                this.file.stepTrans.extraInfo.put(ReportConstant.KEY_SLICE_NUM, String.valueOf((int) com.tencent.mobileqq.streamtransfile.b.o(str)));
                this.file.fileSize = new File(this.file.filePath).length();
                ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(str);
                FileMsg fileMsg = this.file;
                StreamInfo streamInfo = dVar.f286315d;
                fileMsg.serverPath = streamInfo.fileKey;
                if (streamInfo.pttTransFlag == 1) {
                    i3 = 1;
                }
                this.streamPttFlag = i3;
                this.pttTimeStamp = streamInfo.msgTime;
                onSuccess();
                return;
            }
            if (this.isStreamPttSuccess) {
                return;
            }
            short m3 = com.tencent.mobileqq.streamtransfile.b.m(str);
            if (m3 > 10) {
                if (QLog.isColorLevel()) {
                    QLog.d(STREAM_TAG_S, 2, "handleUploadStreamPttFinished: preLayer > 10");
                }
                onError();
                com.tencent.mobileqq.streamtransfile.b.i(str);
                ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(str);
                return;
            }
            int q16 = com.tencent.mobileqq.streamtransfile.b.q(str);
            short o16 = com.tencent.mobileqq.streamtransfile.b.o(str);
            this.severAckSlice = s16;
            if (QLog.isColorLevel()) {
                QLog.d(STREAM_TAG_S, 2, "server reset.ResetSeq: " + ((int) s16) + " packnum: " + ((int) o16) + ",slices:" + q16 + " uniseq:" + this.file.uniseq + ",flowLayer:" + ((int) s17) + ",prelayer:" + ((int) m3));
            }
            if (m3 >= s17) {
                return;
            }
            com.tencent.mobileqq.streamtransfile.b.A(str, s17);
            MessageRecord P = this.app.getMessageFacade().P(this.friendUin, 0, this.file.uniseq);
            Bundle bundle = new Bundle();
            if (P != null) {
                long j17 = P.vipSubBubbleId;
                bundle.putInt("DiyTextId", P.vipBubbleDiyTextId);
                j16 = j17;
            } else {
                j16 = 0;
            }
            startSendRangeStreamPack(true, s16, (short) q16, j16, bundle);
            this.file.logEvent(2, 2);
            return;
        }
        if (this.isStreamPttSuccess) {
            return;
        }
        int q17 = com.tencent.mobileqq.streamtransfile.b.q(str);
        short m16 = com.tencent.mobileqq.streamtransfile.b.m(str);
        if (dVar.f286314c < m16) {
            if (QLog.isColorLevel()) {
                QLog.d(STREAM_TAG_S, 2, "handleUploadStreamPttFinished: info.layer < flowlayer");
                return;
            }
            return;
        }
        if (this.sendSeqMax == s16) {
            int i17 = this.streamPttTimeoutRetryCount;
            if (i17 < 8) {
                this.streamPttTimeoutRetryCount = i17 + 1;
                this.sendSeqMax = 0;
                if (QLog.isColorLevel()) {
                    QLog.d(STREAM_TAG_S, 2, "client check timeout.retry:severAckSlice:" + this.severAckSlice + " packnum: " + q17 + " maxSendSeq:" + this.sendSeqMax + " uniseq:" + this.file.uniseq + ",retryCount:" + this.streamPttTimeoutRetryCount + ",flowLayer:" + ((int) m16));
                }
                MessageRecord P2 = this.app.getMessageFacade().P(this.friendUin, 0, this.file.uniseq);
                Bundle bundle2 = new Bundle();
                if (P2 != null) {
                    long j18 = P2.vipSubBubbleId;
                    bundle2.putInt("DiyTextId", P2.vipBubbleDiyTextId);
                    j3 = j18;
                } else {
                    j3 = 0;
                }
                startSendRangeStreamPack(true, (short) this.severAckSlice, (short) q17, j3, bundle2);
                return;
            }
            onError();
            ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(STREAM_TAG_S, 2, "handleUploadStreamPttFinished: sendSeqMax != shResetSeq");
        }
    }

    private void insertFriendShieldTips() {
        String currentAccountUin = this.app.getCurrentAccountUin();
        String qqStr = HardCodeUtil.qqStr(R.string.k48);
        long K0 = e.K0();
        MessageRecord d16 = q.d(MessageRecord.MSG_TYPE_SHIELD_MSG);
        d16.init(currentAccountUin, this.friendUin, currentAccountUin, qqStr, K0, 0, 0, K0);
        d16.msgtype = MessageRecord.MSG_TYPE_SHIELD_MSG;
        d16.isread = true;
        this.app.getMessageFacade().c(d16, currentAccountUin);
    }

    private boolean stopSendStreamPtt(String str, long j3) {
        ITransFileController iTransFileController = (ITransFileController) this.app.getRuntimeService(ITransFileController.class);
        String str2 = str + j3;
        if (iTransFileController.containsProcessor(str, j3)) {
            ((BuddyTransfileProcessor) iTransFileController.findProcessor(str2)).stop();
            iTransFileController.removeProcessor(str2);
            return true;
        }
        return false;
    }

    private void updateSendMessageErrorDb(String str, int i3, long j3, int i16) {
        Message lastMessage = this.app.getMessageFacade().getLastMessage(str, i3);
        this.app.getMsgCache().G1(str, i3, j3);
        if (lastMessage != null && lastMessage.uniseq == j3) {
            lastMessage.extraflag = 32768;
        }
        this.app.getMessageFacade().Z0(str, i3, j3, 32768, i16);
    }

    public MessageRecord createMessageDataBaseContent(long j3, StreamInfo streamInfo, long j16, Bundle bundle) {
        int i3;
        String str;
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), streamInfo, Long.valueOf(j16), bundle);
        }
        PkgTools.intToAscString(this.file.serverPath.length(), new byte[3], 0, 3, "utf-8");
        MessageForPtt messageForPtt = (MessageForPtt) q.d(-2002);
        messageForPtt.voiceType = (int) streamInfo.pttFormat;
        messageForPtt.voiceLength = (int) streamInfo.pttTime;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "voiceLength createMessageDataBaseContent " + messageForPtt.voiceLength);
        }
        messageForPtt.selfuin = this.selfUin;
        messageForPtt.frienduin = this.friendUin;
        messageForPtt.senderuin = this.file.mUin;
        messageForPtt.isread = false;
        messageForPtt.time = streamInfo.msgTime;
        messageForPtt.setPttStreamFlag(10001);
        messageForPtt.msgtype = -2002;
        messageForPtt.istroop = 0;
        FileMsg fileMsg = this.file;
        messageForPtt.urlAtServer = fileMsg.serverPath;
        messageForPtt.url = MessageForPtt.getMsgFilePath(messageForPtt.voiceType, fileMsg.filePath);
        File file = new File(this.file.filePath);
        if (file.exists()) {
            messageForPtt.fileSize = file.length();
            ReportController.o(this.app, "CliOper", "", "", "0X800610E", "0X800610E", 1, 0, "", "", "", AppSetting.f99551k);
        } else {
            messageForPtt.fileSize = 1000L;
            ReportController.o(this.app, "CliOper", "", "", "0X800610E", "0X800610E", 2, 0, "", "", "", AppSetting.f99551k);
        }
        messageForPtt.itemType = 2;
        messageForPtt.isread = false;
        messageForPtt.shmsgseq = (short) streamInfo.msgSeq;
        messageForPtt.msgUid = s.f((int) streamInfo.random);
        if (streamInfo.pttTransFlag != 1 && !((ISttManagerApi) QRoute.api(ISttManagerApi.class)).getSttAbility(this.app)) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        messageForPtt.sttAbility = i3;
        QQAppInterface qQAppInterface = this.app;
        if (messageForPtt.isSend()) {
            str = this.selfUin;
        } else {
            str = this.friendUin;
        }
        messageForPtt.longPttVipFlag = ff.n(qQAppInterface, str);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j18 = messageForPtt.time;
        messageForPtt.msgRecTime = currentTimeMillis;
        messageForPtt.msgTime = j18;
        messageForPtt.vipSubBubbleId = (int) j16;
        messageForPtt.vipBubbleDiyTextId = bundle.getInt("DiyTextId", 0);
        int i16 = bundle.getInt("DiyPendantId", 0);
        if (i16 > 0) {
            messageForPtt.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i16));
        }
        messageForPtt.serial();
        if (j3 == 4294967295L) {
            j17 = i.a(this.app, messageForPtt.frienduin);
            if (QLog.isColorLevel()) {
                QLog.e(STREAM_TAG_R, 2, "Stream ptt:createMessageDataBaseContent: invalid bubbleID 0xffffffff. get one from cache:" + j17);
            }
        } else {
            j17 = j3;
        }
        messageForPtt.vipBubbleID = j17;
        if (QLog.isColorLevel()) {
            QLog.e(STREAM_TAG_R, 2, "Stream ptt:createMessageDataBaseContent:time" + messageForPtt.time + " urlAtServer:" + messageForPtt.urlAtServer + " bubbleId:" + j17 + " msgseq:" + messageForPtt.shmsgseq + " msgUid:" + messageForPtt.msgUid);
        }
        List<MessageRecord> Q = this.app.getMessageFacade().Q(messageForPtt.frienduin, messageForPtt.istroop);
        if (Q != null && Q.size() > 0) {
            Iterator<MessageRecord> it = Q.iterator();
            while (it.hasNext()) {
                if (ad.b(it.next(), messageForPtt, true)) {
                    if (QLog.isColorLevel()) {
                        QLog.w(TAG, 2, "same Ptt :" + messageForPtt.getBaseInfoString());
                        return null;
                    }
                    return null;
                }
            }
        }
        this.app.getMessageFacade().c(messageForPtt, this.selfUin);
        this.file.setFileId(messageForPtt.uniseq);
        return messageForPtt;
    }

    public void createStreamThreadPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.streamEs = ProxyExecutors.newSingleThreadExecutor();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        if (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode) || this.file.fileType != 2 || this.mOldPttData || RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
            return;
        }
        long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
        HashMap<String, String> hashMap = new HashMap<>();
        if (!this.file.stepTrans.isStream) {
            hashMap.put(ReportConstant.KEY_STEP_INFO, this.file.stepUrl.getStepReportInfo(1) + ";" + this.file.stepTrans.getStepReportInfo(2) + ";" + this.file.stepNotify.getStepReportInfo(3));
        }
        if (z16) {
            if (this.file.actionType == 0) {
                hashMap.put(ReportConstant.KEY_TO_UIN, this.peerUin);
                hashMap.putAll(this.file.stepTrans.extraInfo);
                str = StatisticCollector.C2C_STREAM_PTT_UP_STATISTIC_TAG;
            } else {
                str = StatisticCollector.C2C_STREAM_PTT_DOWN_STATISTIC_TAG;
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, nanoTime, this.file.fileSize, hashMap, "");
            return;
        }
        if (this.file.actionType == 0) {
            if (!ProcessorReport.adjustErrorCode(this.mProcessorReport.errCode, hashMap)) {
                hashMap.put("param_FailCode", Integer.toString(this.mProcessorReport.errCode));
                ProcessorReport processorReport = this.mProcessorReport;
                int i3 = processorReport.errCode;
                if (i3 != -9527 && i3 != 9311 && i3 != 9044 && i3 != 9350 && i3 != 9351) {
                    hashMap.put(ReportConstant.KEY_ERR_DESC, processorReport.errDesc);
                } else {
                    hashMap.put(ReportConstant.KEY_REASON, processorReport.errDesc);
                }
            } else {
                ProcessorReport processorReport2 = this.mProcessorReport;
                processorReport2.errCode = AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE;
                hashMap.put(ReportConstant.KEY_ERR_DESC, processorReport2.errDesc);
            }
            hashMap.put(ReportConstant.KEY_TO_UIN, this.peerUin);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.C2C_STREAM_PTT_UP_STATISTIC_TAG, false, nanoTime, this.file.fileSize, hashMap, "");
            return;
        }
        hashMap.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        hashMap.put(ReportConstant.KEY_ERR_DESC, this.mProcessorReport.errDesc);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.C2C_STREAM_PTT_DOWN_STATISTIC_TAG, false, nanoTime, this.file.fileSize, hashMap, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        String str;
        ExecutorService executorService = this.streamEs;
        if (executorService != null) {
            executorService.shutdown();
        }
        long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
        if (!this.app.isLogin() || !this.app.isRunning()) {
            this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "account switch", null, null);
        }
        if (this.file.actionType == 0) {
            str = STREAM_TAG_S;
        } else {
            str = STREAM_TAG_R;
        }
        QLog.d(str, 2, "onError elapsed:" + nanoTime + " errCode:" + this.mProcessorReport.errCode + " errDesc:" + this.mProcessorReport.errDesc + " reason:" + this.mProcessorReport.mReportInfo.get(ReportConstant.KEY_REASON) + " uniseq:" + this.file.uniseq);
        this.app.removeObserver(this.messageObserver);
        doReport(false);
        if (this.file.actionType == 0) {
            sendMessageToUpdate(1005);
            stopSendStreamPtt(this.friendUin, this.file.uniseq);
        } else {
            sendMessageToUpdate(2005);
            String str2 = this.friendUin;
            FileMsg fileMsg = this.file;
            stopReceiveStreamPtt(str2, fileMsg.serverPath, fileMsg.uniseq);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        String str;
        ExecutorService executorService = this.streamEs;
        if (executorService != null) {
            executorService.shutdown();
        }
        long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
        if (this.file.actionType == 0) {
            str = STREAM_TAG_S;
        } else {
            str = STREAM_TAG_R;
        }
        QLog.d(str, 2, "onSuccess elapsed:" + nanoTime + " uniseq:" + this.file.uniseq);
        doReport(true);
        this.app.removeObserver(this.messageObserver);
        if (this.file.actionType == 0) {
            updateMessageDataBaseContent(true);
        }
        if (this.file.actionType == 0) {
            sendMessageToUpdate(1003);
            FileMsg fileMsg = this.file;
            stopSendStreamPtt(fileMsg.mUin, fileMsg.uniseq);
            return;
        }
        sendMessageToUpdate(2003);
        String str2 = this.friendUin;
        FileMsg fileMsg2 = this.file;
        stopReceiveStreamPtt(str2, fileMsg2.serverPath, fileMsg2.uniseq);
        MessageForPtt messageForPtt = (MessageForPtt) this.app.getMessageFacade().P(this.friendUin, 0, this.file.uniseq);
        if (messageForPtt != null && ((ISttManagerService) this.app.getRuntimeService(ISttManagerService.class)).needAuotoChange(messageForPtt)) {
            ((ISttManagerService) this.app.getRuntimeService(ISttManagerService.class)).translate(messageForPtt, 2);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public void startReceiveOneStreamPack(StreamInfo streamInfo, StreamData streamData, long j3, long j16, long j17, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, streamInfo, streamData, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), bundle);
            return;
        }
        this.file.stepTrans.isStream = true;
        this.isStop = false;
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "startReceiveOneStreamPack:" + streamInfo.pttFormat + ", " + streamInfo.pttTime);
        }
        this.file.logEvent(4, streamData.vData.length);
        if (this.file.fileType != 2) {
            return;
        }
        if (Environment.getExternalStorageState().equals("mounted") && new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() >= 1) {
            short m3 = com.tencent.mobileqq.streamtransfile.b.m(this.file.serverPath);
            if (QLog.isColorLevel()) {
                QLog.d(STREAM_TAG_R, 2, "curFlowLayer: " + ((int) m3) + " received shFlowLayer:" + ((int) streamInfo.shFlowLayer) + ",seq" + ((int) streamData.shPackSeq) + ",packNum:" + ((int) streamInfo.shPackNum) + " lkey:" + j3);
            }
            com.tencent.mobileqq.streamtransfile.b.D(this.file.serverPath, j3);
            if (m3 != streamInfo.shFlowLayer) {
                MessageHandler msgHandler = this.app.getMsgHandler();
                String str = this.selfUin;
                String str2 = this.peerUin;
                String str3 = this.file.serverPath;
                msgHandler.T4(str, str2, str3, com.tencent.mobileqq.streamtransfile.b.u(str3), j3);
                return;
            }
            if (com.tencent.mobileqq.streamtransfile.b.a(this.file.serverPath, streamData.shPackSeq)) {
                this.file.logEvent(2, 2);
                short m16 = (short) (com.tencent.mobileqq.streamtransfile.b.m(this.file.serverPath) + 1);
                com.tencent.mobileqq.streamtransfile.b.A(this.file.serverPath, m16);
                if (QLog.isColorLevel()) {
                    QLog.d(STREAM_TAG_R, 2, "startReceiveOneStreamPack JudgeReceiveError flowLayer: " + ((int) m16));
                }
                MessageHandler msgHandler2 = this.app.getMsgHandler();
                String str4 = this.selfUin;
                String str5 = this.peerUin;
                String str6 = this.file.serverPath;
                msgHandler2.T4(str4, str5, str6, com.tencent.mobileqq.streamtransfile.b.u(str6), j3);
                return;
            }
            if (streamInfo.oprType == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d(STREAM_TAG_R, 2, "cancelled:" + this.file.serverPath);
                }
                String str7 = this.friendUin;
                FileMsg fileMsg = this.file;
                stopReceiveStreamPtt(str7, fileMsg.serverPath, fileMsg.uniseq);
                com.tencent.mobileqq.streamtransfile.b.j(this.file.serverPath, true);
                ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(this.file.serverPath);
                return;
            }
            com.tencent.mobileqq.streamtransfile.b.A(this.file.serverPath, streamInfo.shFlowLayer);
            String str8 = this.file.serverPath;
            byte[] bArr = streamData.vData;
            com.tencent.mobileqq.streamtransfile.b.e(str8, bArr, bArr.length, streamData.shPackSeq);
            if (streamInfo.shPackNum > 0) {
                String str9 = this.friendUin;
                FileMsg fileMsg2 = this.file;
                stopReceiveStreamPtt(str9, fileMsg2.serverPath, fileMsg2.uniseq);
                com.tencent.mobileqq.streamtransfile.b.j(this.file.serverPath, false);
                ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(this.file.serverPath);
                String str10 = this.selfUin + "_" + this.peerUin + "_" + streamInfo.iMsgId;
                if (streamStreamDuplicateList.contains(str10)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(STREAM_TAG_R, 2, "find stream stream duplicate,discard it ,key:" + str10);
                        return;
                    }
                    return;
                }
                streamStreamDuplicateList.add(str10);
                String str11 = this.peerUin + "_" + new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date(streamInfo.iSendTime * 1000));
                if (QLog.isColorLevel()) {
                    QLog.d(STREAM_TAG_R, 2, "stream duplicateKey:" + str11);
                }
                if (com.tencent.mobileqq.streamtransfile.b.k(str11)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(STREAM_TAG_R, 2, "find stream offline duplicate,stop stream recv");
                        return;
                    }
                    return;
                }
                com.tencent.mobileqq.streamtransfile.b.g(str11);
                if (QLog.isColorLevel()) {
                    QLog.d(STREAM_TAG_R, 2, "startReceiveOneStreamPack received success path: " + this.file.serverPath);
                }
                this.app.getMsgHandler().T4(this.selfUin, this.peerUin, this.file.serverPath, (short) -1, j3);
                FileMsg fileMsg3 = this.file;
                fileMsg3.isStreamMode = true;
                fileMsg3.serverPath = streamInfo.fileKey;
                this.streamPttFlag = streamInfo.pttTransFlag == 1 ? 1 : 0;
                if (createMessageDataBaseContent(j16, streamInfo, j17, bundle) != null) {
                    this.app.handleReceivedMessage(1, true, true);
                }
                onSuccess();
                ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportPTTPV(this.app, 1, true, 3);
                ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportPTTPV(this.app, 1, true, 2);
                return;
            }
            return;
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            this.mProcessorReport.setError(9039, "not mounted", null, null);
        } else {
            this.mProcessorReport.setError(9040, "no enough storage", null, null);
        }
        SharedPreferences.Editor edit = this.app.getPreferences().edit();
        edit.putBoolean("sdcard_related_download_failed", true);
        edit.commit();
        onError();
    }

    public void startSendOneStreamPack(short s16, boolean z16, int i3, int i16, long j3, Bundle bundle) {
        String str;
        ExecutorService executorService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Short.valueOf(s16), Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), bundle);
            return;
        }
        this.voiceType = i16;
        this.voiceLength = i3;
        if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "startSendOneStreamPack:" + i16 + ", " + i3 + ", " + ((int) s16) + ", subBubbleId=" + j3);
        }
        this.file.stepTrans.isStream = true;
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null && "0".equals(qQAppInterface.getCurrentAccountUin())) {
            return;
        }
        this.file.status = 1001;
        this.isStop = false;
        QQAppInterface qQAppInterface2 = this.app;
        if (qQAppInterface2 != null) {
            str = qQAppInterface2.getCurrentAccountUin();
            this.app.addObserver(this.messageObserver);
        } else {
            str = "";
        }
        String str2 = str;
        if (s16 > this.sendSeqMax) {
            this.sendSeqMax = s16;
        }
        if (this.file.fileType == 2 && (executorService = this.streamEs) != null && !executorService.isShutdown()) {
            this.streamEs.execute(new Runnable(str2, s16, j3, bundle, z16) { // from class: com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$isresend;
                final /* synthetic */ Bundle val$params;
                final /* synthetic */ String val$selfUin;
                final /* synthetic */ short val$shPackSeq;
                final /* synthetic */ long val$subBubbleId;

                {
                    this.val$selfUin = str2;
                    this.val$shPackSeq = s16;
                    this.val$subBubbleId = j3;
                    this.val$params = bundle;
                    this.val$isresend = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BuddyTransfileProcessor.this, str2, Short.valueOf(s16), Long.valueOf(j3), bundle, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (com.tencent.mobileqq.streamtransfile.b.o(BuddyTransfileProcessor.this.file.filePath) != 0) {
                        BuddyTransfileProcessor buddyTransfileProcessor = BuddyTransfileProcessor.this;
                        if (!buddyTransfileProcessor.setPttRecordFinishTime) {
                            FileMsg fileMsg = buddyTransfileProcessor.file;
                            ProcessorReport processorReport = buddyTransfileProcessor.mProcessorReport;
                            long nanoTime = System.nanoTime();
                            processorReport.mStartTime = nanoTime;
                            fileMsg.startTime = nanoTime;
                            BuddyTransfileProcessor.this.setPttRecordFinishTime = true;
                        }
                    }
                    MessageHandler msgHandler = BuddyTransfileProcessor.this.app.getMsgHandler();
                    String str3 = this.val$selfUin;
                    String str4 = BuddyTransfileProcessor.this.peerUin;
                    BuddyTransfileProcessor buddyTransfileProcessor2 = BuddyTransfileProcessor.this;
                    String str5 = buddyTransfileProcessor2.file.filePath;
                    short s17 = this.val$shPackSeq;
                    int i17 = buddyTransfileProcessor2.msgseq;
                    long j16 = BuddyTransfileProcessor.this.random;
                    BuddyTransfileProcessor buddyTransfileProcessor3 = BuddyTransfileProcessor.this;
                    msgHandler.k5(str3, str4, str5, s17, i17, j16, buddyTransfileProcessor3.voiceType, buddyTransfileProcessor3.voiceLength, this.val$subBubbleId, this.val$params);
                    if (!this.val$isresend) {
                        BuddyTransfileProcessor.this.file.transferedSize += com.tencent.mobileqq.streamtransfile.b.r(r1.filePath, this.val$shPackSeq);
                    }
                }
            });
        }
    }

    public void startSendRangeStreamPack(boolean z16, short s16, short s17, long j3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Short.valueOf(s16), Short.valueOf(s17), Long.valueOf(j3), bundle);
            return;
        }
        for (int i3 = s16; i3 <= s17; i3++) {
            startSendOneStreamPack((short) i3, true, this.voiceLength, this.voiceType, j3, bundle);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "startSendRangeStreamPack, from slice " + ((int) s16) + " to slice " + ((int) s17) + ", subBubbleId=" + j3);
        }
    }

    public boolean stopReceiveStreamPtt(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, str, str2, Long.valueOf(j3))).booleanValue();
        }
        ITransFileController iTransFileController = (ITransFileController) this.app.getRuntimeService(ITransFileController.class);
        String str3 = str + str2 + j3;
        if (!iTransFileController.containsProcessor(str, j3)) {
            return false;
        }
        ((BuddyTransfileProcessor) iTransFileController.findProcessor(str3)).stop();
        iTransFileController.removeProcessor(str3);
        return true;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void updateMessageDataBaseContent(boolean z16) {
        boolean z17;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        try {
            if (this.file.fileType == 2) {
                MessageForPtt messageForPtt = (MessageForPtt) this.app.getMessageFacade().P(this.friendUin, 0, this.file.uniseq);
                FileMsg fileMsg = this.file;
                messageForPtt.url = fileMsg.filePath;
                messageForPtt.fileSize = fileMsg.transferedSize;
                messageForPtt.itemType = fileMsg.fileType;
                if (fileMsg.isRead == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                messageForPtt.isread = z17;
                messageForPtt.urlAtServer = fileMsg.serverPath;
                if (((ISttManagerApi) QRoute.api(ISttManagerApi.class)).getSttAbility(this.app)) {
                    messageForPtt.sttAbility = 1;
                } else {
                    messageForPtt.sttAbility = this.streamPttFlag;
                }
                QQAppInterface qQAppInterface = this.app;
                if (messageForPtt.isSend()) {
                    str = this.selfUin;
                } else {
                    str = this.friendUin;
                }
                messageForPtt.longPttVipFlag = ff.n(qQAppInterface, str);
                messageForPtt.serial();
                if (QLog.isColorLevel()) {
                    QLog.e(STREAM_TAG_S, 2, "Stream ptt:updataMessageDataBaseContent:time" + messageForPtt.time + " urlAtServer:" + messageForPtt.urlAtServer);
                }
                this.app.getMessageFacade().Y0(this.friendUin, 0, this.file.uniseq, messageForPtt.msgData);
                messageForPtt.time = this.pttTimeStamp;
                this.app.getMessageFacade().V0(this.friendUin, 0, this.file.uniseq, this.pttTimeStamp);
                Message lastMessage = this.app.getMessageFacade().getLastMessage(this.friendUin, 0);
                if (lastMessage != null && (str2 = this.file.serverPath) != null && str2.equals(lastMessage.pttUrl)) {
                    lastMessage.pttUrl = messageForPtt.url;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
