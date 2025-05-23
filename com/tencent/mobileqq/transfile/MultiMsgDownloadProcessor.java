package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.multimsg.i;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.j;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.oskplayer.util.apache.InetAddressValidator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.java_websocket.WebSocketImpl;
import tencent.im.longconn.longmsg.LongMsg$MsgDownRsp;
import tencent.im.longconn.longmsg.LongMsg$RspBody;
import tencent.im.msg.im_msg_head$Head;

/* loaded from: classes19.dex */
public class MultiMsgDownloadProcessor extends BaseDownloadProcessor {
    static IPatchRedirector $redirector_;
    QQAppInterface app;
    private int mChannelType;
    private byte[] mContent;
    private int mErrorCode;
    private byte[] mMsgKey;
    private byte[] mMsgResId;
    private String mOutFilePath;
    private int mUinType;

    public MultiMsgDownloadProcessor(TransFileControllerImpl transFileControllerImpl, TransferRequest transferRequest) {
        super(transFileControllerImpl, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) transFileControllerImpl, (Object) transferRequest);
            return;
        }
        this.app = (QQAppInterface) super.app;
        this.mMsgResId = this.mUiRequest.resIdStr.getBytes();
        this.mUinType = this.mUiRequest.mUinType;
    }

    @Nullable
    private ServerAddr checkServerAddr(ServerAddr serverAddr) {
        if (serverAddr != null && i.i()) {
            if (!TextUtils.isEmpty(serverAddr.mIp) && InetAddressValidator.getInstance().isValid(serverAddr.mIp)) {
                boolean z16 = serverAddr.isIpv6;
                serverAddr.isIpv6 = !InetAddressValidator.getInstance().isValidInet4Address(serverAddr.mIp);
                QLog.i("MultiMsg_TAG", 1, "Multimsg do check ip valid. curIp=" + serverAddr.mIp + ", isIpv6Before=" + z16 + ", newCheckIs=" + serverAddr.isIpv6);
                return serverAddr;
            }
            QLog.i("MultiMsg_TAG", 1, "Multimsg do check ip not valid. curIp=" + serverAddr.mIp);
            return null;
        }
        return serverAddr;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00ea: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:235), block:B:63:0x00ea */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] getBodyData(String str) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        RandomAccessFile randomAccessFile2;
        int i3;
        int length;
        String obj;
        RandomAccessFile randomAccessFile3 = null;
        if (!new File(str).exists()) {
            logRichMediaEvent("parseDownloadMsg", "File NOT exists, path= " + str);
            return null;
        }
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    bArr = new byte[(int) randomAccessFile.length()];
                } catch (FileNotFoundException e16) {
                    e = e16;
                    bArr = null;
                } catch (IOException e17) {
                    e = e17;
                    bArr = null;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
                randomAccessFile = null;
                bArr = null;
            } catch (IOException e19) {
                e = e19;
                randomAccessFile = null;
                bArr = null;
            } catch (Throwable th5) {
                th = th5;
                if (randomAccessFile3 != null) {
                }
                throw th;
            }
            try {
                i3 = randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                    logRichMediaEvent("parseDownloadMsg", e26.getMessage());
                }
            } catch (FileNotFoundException e27) {
                e = e27;
                e.printStackTrace();
                logRichMediaEvent("parseDownloadMsg", "File NOT exists, path= " + str);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e28) {
                        e = e28;
                        e.printStackTrace();
                        logRichMediaEvent("parseDownloadMsg", e.getMessage());
                        i3 = 0;
                        if (bArr == null) {
                        }
                        if (bArr == null) {
                        }
                        if (bArr == null) {
                        }
                        if (obj.length() > 20) {
                        }
                        logRichMediaEvent("parseDownloadMsg", "bodyData == null || bodyData.length <= 0 || n <= 0)unexpected body data, len=" + length + ", data=" + obj);
                        return null;
                    }
                }
                i3 = 0;
                if (bArr == null) {
                }
                if (bArr == null) {
                }
                if (bArr == null) {
                }
                if (obj.length() > 20) {
                }
                logRichMediaEvent("parseDownloadMsg", "bodyData == null || bodyData.length <= 0 || n <= 0)unexpected body data, len=" + length + ", data=" + obj);
                return null;
            } catch (IOException e29) {
                e = e29;
                logRichMediaEvent("parseDownloadMsg", "faild to read file");
                e.printStackTrace();
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e36) {
                        e = e36;
                        e.printStackTrace();
                        logRichMediaEvent("parseDownloadMsg", e.getMessage());
                        i3 = 0;
                        if (bArr == null) {
                        }
                        if (bArr == null) {
                        }
                        if (bArr == null) {
                        }
                        if (obj.length() > 20) {
                        }
                        logRichMediaEvent("parseDownloadMsg", "bodyData == null || bodyData.length <= 0 || n <= 0)unexpected body data, len=" + length + ", data=" + obj);
                        return null;
                    }
                }
                i3 = 0;
                if (bArr == null) {
                }
                if (bArr == null) {
                }
                if (bArr == null) {
                }
                if (obj.length() > 20) {
                }
                logRichMediaEvent("parseDownloadMsg", "bodyData == null || bodyData.length <= 0 || n <= 0)unexpected body data, len=" + length + ", data=" + obj);
                return null;
            }
            if (bArr == null && bArr.length > 0 && i3 > 0 && bArr[0] == 40 && bArr[bArr.length - 1] == 41) {
                return bArr;
            }
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            if (bArr == null) {
                obj = "";
            } else {
                obj = bArr.toString();
            }
            if (obj.length() > 20) {
                obj = obj.substring(0, 20);
            }
            logRichMediaEvent("parseDownloadMsg", "bodyData == null || bodyData.length <= 0 || n <= 0)unexpected body data, len=" + length + ", data=" + obj);
            return null;
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile3 = randomAccessFile2;
            if (randomAccessFile3 != null) {
                try {
                    randomAccessFile3.close();
                } catch (IOException e37) {
                    e37.printStackTrace();
                    logRichMediaEvent("parseDownloadMsg", e37.getMessage());
                }
            }
            throw th;
        }
    }

    private boolean parseDownloadMsg(String str) {
        byte[] bodyData = getBodyData(str);
        if (bodyData == null) {
            return false;
        }
        return parsePBData(bodyData);
    }

    private void recieveFile() {
        ServerAddr serverAddr;
        String str;
        String str2;
        HttpNetReq httpNetReq = new HttpNetReq();
        if (this.mIpList.size() > 0) {
            serverAddr = this.mIpList.get(0);
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("MultiMsg_TAG", 2, "Multimsg download recieveFile  ipListSize = 0 ");
            }
            serverAddr = null;
        }
        ServerAddr checkServerAddr = checkServerAddr(serverAddr);
        if (this.mChannelType == 2) {
            httpNetReq.mIsHttps = true;
            if (checkServerAddr != null) {
                httpNetReq.mIsHostIP = true;
                if (checkServerAddr.isIpv6) {
                    httpNetReq.mHostForHttpsVerify = "sslv6.htdata.qq.com";
                } else {
                    httpNetReq.mHostForHttpsVerify = "ssl.htdata.qq.com";
                }
            } else {
                httpNetReq.mHostForHttpsVerify = "sslv6.htdata.qq.com";
            }
            ServerAddr serverAddr2 = new ServerAddr();
            serverAddr2.mIp = httpNetReq.mHostForHttpsVerify;
            serverAddr2.port = WebSocketImpl.DEFAULT_WSS_PORT;
            if (checkServerAddr == null) {
                checkServerAddr = serverAddr2;
            }
            this.mIpList.add(serverAddr2);
            str = "https://";
        } else {
            str = "http://";
            if (checkServerAddr == null) {
                checkServerAddr = new ServerAddr();
                checkServerAddr.mIp = "sslv6.htdata.qq.com";
                checkServerAddr.port = 8080;
                this.mIpList.add(checkServerAddr);
            }
        }
        if (checkServerAddr.isIpv6 && !checkServerAddr.mIp.startsWith("[")) {
            str2 = str + "[" + checkServerAddr.mIp + "]";
        } else {
            str2 = str + checkServerAddr.mIp;
        }
        if (checkServerAddr.port != 80) {
            str2 = str2 + ":" + checkServerAddr.port;
        }
        String str3 = str2 + this.mUrlPath;
        logRichMediaEvent("MultimsgDownload.recieveFile", " url:" + str3);
        if (i.k()) {
            QLog.d("MultiMsg_TAG", 1, "Multimsg download recieveFile  url=" + str3);
        }
        String filePath = AbsDownloader.getFilePath(str3);
        this.mOutFilePath = filePath;
        httpNetReq.mCallback = this;
        httpNetReq.mReqUrl = str3;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mServerList = this.mIpList;
        httpNetReq.mOutPath = filePath;
        httpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
        TransferRequest transferRequest = this.mUiRequest;
        httpNetReq.mBusiProtoType = transferRequest.mUinType;
        httpNetReq.mFileType = transferRequest.mFileType;
        httpNetReq.mStartDownOffset = 0L;
        httpNetReq.mIsNetChgAsError = true;
        httpNetReq.mReqProperties.put("Accept-Encoding", "identity");
        logRichMediaEvent("httpDown", "url:" + str3 + ",downOffset:" + httpNetReq.mStartDownOffset);
        if (!canDoNextStep()) {
            return;
        }
        this.mNetReq = httpNetReq;
        setMtype();
        this.mNetEngine.sendReq(httpNetReq);
    }

    private void sendReqest() {
        this.mProcessorReport.mStepUrl.logStartTime();
        RichProto.RichProtoReq.MultiMsgDownReq multiMsgDownReq = new RichProto.RichProtoReq.MultiMsgDownReq();
        TransferRequest transferRequest = this.mUiRequest;
        multiMsgDownReq.selfUin = transferRequest.mSelfUin;
        multiMsgDownReq.peerUin = transferRequest.mPeerUin;
        multiMsgDownReq.secondUin = transferRequest.mSecondId;
        multiMsgDownReq.uinType = transferRequest.mUinType;
        multiMsgDownReq.msgResId = this.mMsgResId;
        multiMsgDownReq.multiMsgType = transferRequest.multiMsgType;
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.MULTI_MSG_DW;
        richProtoReq.reqs.add(multiMsgDownReq);
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

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (i.k()) {
            QLog.i("MultiMsg_TAG", 1, "[checkParam]: " + this.mUiRequest.toString());
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        int i3;
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
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_STEP_INFO, this.mProcessorReport.mStepUrl.getReportInfo(1) + ";" + this.mProcessorReport.mStepTrans.getReportInfo(2) + ";" + this.mProcessorReport.mStepMsg.getReportInfo(3));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_GROUP_ID, this.mUiRequest.mPeerUin);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_UUID, this.mUiRequest.mServerPath);
                    if (z16) {
                        if (j.a(this.app, 1000)) {
                            reportForIpv6(true, nanoTime);
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, nanoTime, this.mTotolLen, this.mProcessorReport.mReportInfo, "");
                        }
                    } else {
                        ProcessorReport processorReport2 = this.mProcessorReport;
                        if (processorReport2.errCode != -9527) {
                            processorReport2.mReportInfo.remove("param_rspHeader");
                        }
                        ProcessorReport processorReport3 = this.mProcessorReport;
                        processorReport3.mReportInfo.put("param_FailCode", String.valueOf(processorReport3.errCode));
                        ProcessorReport processorReport4 = this.mProcessorReport;
                        processorReport4.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport4.errDesc);
                        if (j.a(this.app, 1000)) {
                            reportForIpv6(false, nanoTime);
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, nanoTime, 0L, this.mProcessorReport.mReportInfo, "");
                        }
                    }
                    setReportFlag();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return StatisticCollector.MULTIMSG_DOWNLOAD_STATISTIC_TAG;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp == null) {
            onError();
            return;
        }
        for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
            RichProto.RichProtoResp.MultiMsgDownResp multiMsgDownResp = (RichProto.RichProtoResp.MultiMsgDownResp) richProtoResp.resps.get(i3);
            if (i.k()) {
                QLog.i("MultiMsg_TAG", 1, "[onBusiProtoResp] procUrl: " + multiMsgDownResp.toString());
            }
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.copyRespCommon(processorReport.mStepUrl, multiMsgDownResp);
            if (multiMsgDownResp.result == 0) {
                this.mIpList = selectIpList(multiMsgDownResp.mIpv6List, multiMsgDownResp.ipList);
                this.mUrlPath = multiMsgDownResp.urlParam;
                this.mMsgKey = multiMsgDownResp.msgkey;
                this.mChannelType = multiMsgDownResp.mChannelType;
                recieveFile();
            } else {
                onError();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        if (this.mUiRequest.mDownCallBack != null) {
            c.a aVar = new c.a();
            aVar.f258655b = -1;
            m.a aVar2 = new m.a();
            aVar.f258657d = aVar2;
            aVar2.f258737b = "[MultiMsgDownloadProcessor] download failed";
            aVar.f258659f = null;
            aVar.f258656c = Integer.toString(this.mErrorCode);
            this.mUiRequest.mDownCallBack.h(aVar);
        }
        this.mContent = null;
        sendMessageToUpdate(2005);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) netResp);
            return;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        StepInfo stepInfo = processorReport.mStepTrans;
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        processorReport.copyStaticsInfoFromNetResp(stepInfo, netResp, z16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" result:");
        if (netResp.mResult == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        logRichMediaEvent("onHttpResp", sb5.toString());
        long j3 = netResp.mTotalFileLen;
        this.mTotolLen = j3;
        this.mNetReq = null;
        if (j3 <= 0) {
            this.mTotolLen = netResp.mTotalBlockLen + netResp.mReq.mStartDownOffset;
        }
        this.file.stepTrans.respHeader = netResp.mRespProperties.get("param_rspHeader");
        if (i.k()) {
            QLog.i("MultiMsg_TAG", 1, "onHttpResp multimsg: result=" + netResp.mResult + ", httpCode=" + netResp.mHttpCode + ", errCode=" + netResp.mErrCode + ", mNetworkChgRetryCount=" + this.mNetworkChgRetryCount);
        }
        if (netResp.mResult == 0 && parseDownloadMsg(this.mOutFilePath)) {
            try {
                byte[] bArr = FileUtils.getByte(new File(this.mOutFilePath));
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("{");
                for (byte b16 : bArr) {
                    stringBuffer.append((int) b16);
                    stringBuffer.append(",");
                }
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                stringBuffer.append("}");
                logRichMediaEvent("onHttpResp", " multimsg_filedata:" + stringBuffer.toString());
            } catch (Exception e16) {
                if (i.k()) {
                    QLog.i("MultiMsg_TAG", 1, "onHttpResp multimsg: err=", e16);
                }
            }
            onSuccess();
            return;
        }
        if (netResp.mErrCode == 9364 && this.mNetworkChgRetryCount < 3) {
            logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
            this.mNetworkChgRetryCount++;
            clearReprotInfo();
            sendReqest();
            return;
        }
        onError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
    }

    protected boolean parsePBData(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr)).booleanValue();
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            dataInputStream.readByte();
            int readInt = dataInputStream.readInt();
            int readInt2 = dataInputStream.readInt();
            byte[] bArr2 = new byte[readInt];
            dataInputStream.read(bArr2);
            im_msg_head$Head im_msg_head_head = new im_msg_head$Head();
            im_msg_head_head.mergeFrom(bArr2);
            int i3 = im_msg_head_head.msg_httpconn_head.get().uint32_error_code.get();
            if (readInt2 > 0 && i3 == 0) {
                byte[] bArr3 = new byte[readInt2];
                dataInputStream.read(bArr3);
                byte[] decrypt = new Cryptor().decrypt(bArr3, this.mMsgKey);
                LongMsg$RspBody longMsg$RspBody = new LongMsg$RspBody();
                longMsg$RspBody.mergeFrom(decrypt);
                LongMsg$MsgDownRsp longMsg$MsgDownRsp = longMsg$RspBody.rpt_msg_down_rsp.get(0);
                if (longMsg$MsgDownRsp.uint32_result.get() != 0) {
                    logRichMediaEvent("parseDownloadMsg", "uint32_result != 0");
                    return false;
                }
                this.mContent = longMsg$MsgDownRsp.bytes_msg_content.get().toByteArray();
                logRichMediaEvent("parseDownloadMsg", "crypted data == " + HexUtil.bytes2HexStr(bArr3));
                logRichMediaEvent("parseDownloadMsg", "crypted data length == " + readInt2);
                logRichMediaEvent("parseDownloadMsg", "decrypted data == " + HexUtil.bytes2HexStr(this.mContent));
                logRichMediaEvent("parseDownloadMsg", "decrypted data length == " + this.mContent.length);
                return true;
            }
            this.mErrorCode = i3;
            logRichMediaEvent("parseDownloadMsg", "bodyLen= " + readInt2 + " errCode= " + i3);
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            logRichMediaEvent("parseDownloadMsg", " Exception:" + e16.getMessage());
            return false;
        }
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
                str = AppConstants.HTTP_TYPE_MULTIMSG_CD;
            } else if (this.mUinType == 1) {
                str = AppConstants.HTTP_TYPE_MULTIMSG_GD;
            } else {
                str = AppConstants.HTTP_TYPE_MULTIMSG_DD;
            }
            NetReq netReq2 = this.mNetReq;
            ((HttpNetReq) netReq2).mReqUrl = MsfSdkUtils.insertMtype(str, ((HttpNetReq) netReq2).mReqUrl);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseDownloadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        sendMessageToUpdate(1000);
        sendMessageToUpdate(2001);
        sendReqest();
    }

    public MultiMsgDownloadProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
