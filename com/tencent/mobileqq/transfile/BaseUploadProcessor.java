package com.tencent.mobileqq.transfile;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes19.dex */
public class BaseUploadProcessor extends BaseTransProcessor {
    static IPatchRedirector $redirector_ = null;
    static final int MAX_PKG_SIZE = 131072;
    static final int SPAN_SSCM_SLICE_SIZE = 14600;
    static final int TRY_SPAN_SIZE = 32768;
    long mBlockSize;
    protected int mChannelStatus;
    public long mEnterAioTime;
    String mExtName;
    String mFileName;
    long mFileSize;
    int mHeight;
    ArrayList<ServerAddr> mIpList;
    boolean mIsPicSecondTransfered;
    protected byte[] mLocalMd5;
    String mMd5Str;
    public int mPicType;
    RandomAccessFile mRaf;
    int mReqUrlCount;
    String mResid;
    boolean mSSCMSpanned;
    int mServerRollbackCount;
    protected byte[] mSessionKey;
    protected byte[] mSigSession;
    long mStartOffset;
    protected Transaction mTrans;
    long mTransferedSize;
    int mTryCount;
    String mUkey;
    String mUuid;
    int mWidth;
    protected boolean needSendMsg;
    public int shouldMsgReportSucc;
    com.tencent.wstt.SSCM.a sscmObject;
    boolean useServerInitSize;

    /* loaded from: classes19.dex */
    public interface ChannelStatus {
        public static final int BDH = 1;
        public static final int HTTP = 2;
        public static final int INIT = 0;
    }

    public BaseUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.needSendMsg = true;
        this.mIpList = new ArrayList<>();
        this.mReqUrlCount = 0;
        this.mTransferedSize = 0L;
        this.mTryCount = 0;
        this.mServerRollbackCount = 0;
        this.mBlockSize = 20480L;
        this.sscmObject = new com.tencent.wstt.SSCM.a();
        this.mSSCMSpanned = false;
        this.useServerInitSize = false;
        this.mIsPicSecondTransfered = false;
        this.mPicType = -1;
        this.shouldMsgReportSucc = -1;
        this.mChannelStatus = 0;
        this.mTrans = null;
        setKey(transferRequest.mPeerUin + transferRequest.mUniseq);
        this.needSendMsg = transferRequest.needSendMsg;
    }

    public static int ipToLong(String str) {
        if (str == null) {
            return 0;
        }
        byte[] bArr = new byte[4];
        try {
            String[] split = str.split("\\.");
            bArr[0] = (byte) (Integer.parseInt(split[0]) & 255);
            bArr[1] = (byte) (Integer.parseInt(split[1]) & 255);
            bArr[2] = (byte) (Integer.parseInt(split[2]) & 255);
            byte parseInt = (byte) (Integer.parseInt(split[3]) & 255);
            bArr[3] = parseInt;
            return (parseInt & 255) | ((bArr[2] << 8) & 65280) | ((bArr[1] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((bArr[0] << 24) & (-16777216));
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    static boolean isValidMd5(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b16 : bArr) {
            if (b16 != 0) {
                return true;
            }
        }
        return false;
    }

    public void addBDHReportInfo(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) hashMap);
            return;
        }
        String str = hashMap.get(TransReport.rep_time_cache);
        String str2 = hashMap.get(TransReport.rep_bdhTrans);
        String str3 = hashMap.get(TransReport.rep_segsPerConn);
        String str4 = hashMap.get(TransReport.rep_confSegSize);
        String str5 = hashMap.get(TransReport.rep_confSegNum);
        String str6 = hashMap.get(TransReport.rep_confMaxConn);
        String str7 = hashMap.get(TransReport.rep_finLost);
        this.mProcessorReport.mReportInfo.put("serverip", hashMap.get("ip"));
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_BDHSRV_PORT, hashMap.get("port"));
        this.mProcessorReport.mReportInfo.put("X-piccachetime", str);
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_BDHTRANS_INFO, str2);
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SEG_PER_CNT, str3);
        this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegSize, str4);
        this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegNum, str5);
        this.mProcessorReport.mReportInfo.put(TransReport.rep_confMaxConn, str6);
        this.mProcessorReport.mReportInfo.put(TransReport.rep_finLost, str7);
        this.mProcessorReport.mReportInfo.put(TransReport.rep_retry_seg_count, hashMap.get(TransReport.rep_retry_seg_count));
        this.mProcessorReport.mReportInfo.put(TransReport.rep_retry_max, hashMap.get(TransReport.rep_retry_max));
        this.mProcessorReport.mReportInfo.put(TransReport.rep_retry_total, hashMap.get(TransReport.rep_retry_total));
        this.mProcessorReport.mReportInfo.put(TransReport.rep_retry_code, hashMap.get(TransReport.rep_retry_code));
        this.mProcessorReport.mReportInfo.put(TransReport.rep_heart_resp, hashMap.get(TransReport.rep_heart_resp));
        this.mProcessorReport.mReportInfo.put(TransReport.rep_Ip_Index, hashMap.get(TransReport.rep_Ip_Index));
        this.mProcessorReport.mReportInfo.put(TransReport.rep_Ip_ConnCost, hashMap.get(TransReport.rep_Ip_ConnCost));
        this.mRSMReporter.mConnCost = hashMap.get(TransReport.rep_Ip_ConnCost);
        this.mProcessorReport.mReportInfo.put(TransReport.rep_BDH_Cache_Diff, hashMap.get(TransReport.rep_BDH_Cache_Diff));
        this.mProcessorReport.mReportInfo.put(TransReport.rep_is_ipv6, hashMap.get(TransReport.rep_is_ipv6));
        this.mProcessorReport.mReportInfo.put(TransReport.rep_has_ipv6_list, hashMap.get(TransReport.rep_has_ipv6_list));
        this.mProcessorReport.mReportInfo.put(TransReport.rep_ipv6_first, hashMap.get(TransReport.rep_ipv6_first));
        TransReport transReport = this.mTrans.mTransReport;
        this.reportTimeHt = transReport.timeCost_Ht;
        this.reportTimePicCache = transReport.timeCost_Cache;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int cancel = super.cancel();
        recycleFD();
        return cancel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void collectChnlCostReport() {
        Transaction transaction;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (this.mChannelStatus == 1 && (transaction = this.mTrans) != null) {
            this.mProcessorReport.mReportInfo.put("X-piccachetime", String.valueOf(transaction.mTransReport.timeCost_Cache));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpNetReq constructHttpNetReq(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (HttpNetReq) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = this;
        httpNetReq.mReqUrl = getConnUrl(bArr);
        httpNetReq.mHttpMethod = 1;
        httpNetReq.mSendData = bArr;
        httpNetReq.mServerList = this.mIpList;
        httpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
        TransferRequest transferRequest = this.mUiRequest;
        httpNetReq.mBusiProtoType = transferRequest.mUinType;
        httpNetReq.mFileType = transferRequest.mFileType;
        httpNetReq.mIsNetChgAsError = true;
        httpNetReq.mReqProperties.put("Range", "bytes=" + this.mTransferedSize + "-");
        httpNetReq.mReqProperties.put("Accept-Encoding", "identity");
        return httpNetReq;
    }

    protected long getBlockSize(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, j3)).longValue();
        }
        return Math.min(this.mBlockSize, this.mFileSize - j3);
    }

    protected String getConnUrl(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getFileMd5(String str, long j3) {
        FileInputStream fileInputStream;
        byte[] mD5Byte;
        File file = new File(str);
        if (!file.exists()) {
            QLog.w(BaseTransProcessor.TAG, 1, "getFileMd5, file not exist, path is " + str);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                mD5Byte = MD5.toMD5Byte(fileInputStream, j3);
            } finally {
            }
        } catch (IOException e16) {
            QLog.w(BaseTransProcessor.TAG, 1, "getFileMd5, IOException: " + e16);
            analysisIOProblem(e16);
            return null;
        } catch (UnsatisfiedLinkError e17) {
            QLog.w(BaseTransProcessor.TAG, 1, "getFileMd5, UnsatisfiedLinkError: " + e17);
        }
        if (isValidMd5(mD5Byte)) {
            fileInputStream.close();
            return mD5Byte;
        }
        fileInputStream.close();
        QLog.i(BaseTransProcessor.TAG, 1, "MD5.toMD5Byte Failed, try again");
        try {
            String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
            if (d16 == null) {
                QLog.i(BaseTransProcessor.TAG, 1, "getFileMD5String FAILED");
                return null;
            }
            return HexUtil.hexStr2Bytes(d16);
        } catch (IOException e18) {
            QLog.w(BaseTransProcessor.TAG, 1, "getFileMd5, exception: " + e18);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getMd5() {
        String str = this.mUiRequest.mLocalPath;
        byte[] fileMd5 = getFileMd5(str, this.file.fileSize);
        this.mLocalMd5 = fileMd5;
        if (fileMd5 == null) {
            QLog.w(BaseTransProcessor.TAG, 1, "FAILED to get file md5, path is " + str);
            return false;
        }
        String bytes2HexStr = HexUtil.bytes2HexStr(fileMd5);
        this.mFileName = bytes2HexStr;
        this.mMd5Str = bytes2HexStr;
        this.file.fileMd5 = bytes2HexStr;
        this.mFileName += "." + this.mExtName;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getStreamData(int i3, int i16) {
        try {
            this.mRaf.seek(i3);
            byte[] bArr = new byte[i16];
            int i17 = 0;
            int i18 = i16;
            while (i17 < i16) {
                int read = this.mRaf.read(bArr, i17, i18);
                if (read == -1) {
                    this.mProcessorReport.setError(9303, "fileSize not enough", null, null);
                    this.mProcessorReport.mStepTrans.logFinishTime();
                    return null;
                }
                i17 += read;
                i18 -= read;
            }
            return bArr;
        } catch (IOException e16) {
            analysisIOProblem(e16);
            e16.printStackTrace();
            return null;
        }
    }

    protected boolean isNetworkAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        HwNetworkCenter.getInstance(BaseApplication.getContext()).updateNetInfo(BaseApplication.getContext());
        if (HwNetworkCenter.getInstance(BaseApplication.getContext()).getNetType() == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void log(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.d(BaseTransProcessor.TAG, 2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        recycleFD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        recycleFD();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.pause();
        if (!this.mIsPause) {
            this.mIsPause = true;
            if (QLog.isColorLevel()) {
                logRichMediaEvent("pause", "");
            }
            sendMessageToUpdate(1004);
            RichProto.RichProtoReq richProtoReq = this.mRichProtoReq;
            if (richProtoReq != null) {
                RichProtoProc.cancelRichProtoReq(richProtoReq);
                this.mRichProtoReq = null;
            }
            NetReq netReq = this.mNetReq;
            if (netReq != null) {
                this.mNetEngine.cancelReq(netReq);
                this.mNetReq = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recycleFD() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        RandomAccessFile randomAccessFile = this.mRaf;
        if (randomAccessFile != null) {
            try {
                try {
                    randomAccessFile.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            } finally {
                this.mRaf = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportForServerMonitor(String str, boolean z16, int i3, String str2, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), str2, str3, str4, str5, str6);
            return;
        }
        RMServMonitorReport rMServMonitorReport = this.mRSMReporter;
        rMServMonitorReport.mMD5 = str4;
        rMServMonitorReport.mUUID = str5;
        rMServMonitorReport.mBusiType = str6;
        rMServMonitorReport.mFailCode = String.valueOf(i3);
        RMServMonitorReport rMServMonitorReport2 = this.mRSMReporter;
        rMServMonitorReport2.mServerIp = str2;
        rMServMonitorReport2.mServerPort = str3;
        rMServMonitorReport2.mFileSize = this.mFileSize;
        ProcessorReport processorReport = this.mProcessorReport;
        String str7 = processorReport.reason;
        String str8 = processorReport.errDesc;
        TransferRequest transferRequest = this.mUiRequest;
        rMServMonitorReport2.doReportForServerMonitor(str, z16, str7, str8, transferRequest.mUinType, transferRequest.mPeerUin, true, processorReport.mStepTrans);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return super.resume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
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

    public BaseUploadProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.needSendMsg = true;
        this.mIpList = new ArrayList<>();
        this.mReqUrlCount = 0;
        this.mTransferedSize = 0L;
        this.mTryCount = 0;
        this.mServerRollbackCount = 0;
        this.mBlockSize = 20480L;
        this.sscmObject = new com.tencent.wstt.SSCM.a();
        this.mSSCMSpanned = false;
        this.useServerInitSize = false;
        this.mIsPicSecondTransfered = false;
        this.mPicType = -1;
        this.shouldMsgReportSucc = -1;
        this.mChannelStatus = 0;
        this.mTrans = null;
    }
}
