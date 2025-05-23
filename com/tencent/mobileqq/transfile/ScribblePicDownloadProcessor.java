package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.IScribbleDownloader;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils;
import com.tencent.mobileqq.scribble.e;
import com.tencent.mobileqq.scribble.f;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes19.dex */
public class ScribblePicDownloadProcessor extends BaseDownloadProcessor {
    static IPatchRedirector $redirector_ = null;
    private static final String MD5_DIGITS = "0123456789abcdef";
    public static final String TAG = "ScribblePicDownloadProcessor";
    private ArrayList<String> ipListFromInnerDns;
    private int mIpIndex;
    MessageForScribble mMsg;
    private int mTotalRetryTime;
    String url;

    public ScribblePicDownloadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.url = "";
        this.mIpIndex = 0;
        this.mTotalRetryTime = 0;
    }

    private boolean checkMD5Valid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i16 = i3 + 1;
            if (!MD5_DIGITS.contains(str.substring(i3, i16).toLowerCase())) {
                return false;
            }
            i3 = i16;
        }
        return true;
    }

    private void spliteCombineFile() {
        if (this.mMsg == null) {
            return;
        }
        String b16 = f.b(this.mUiRequest.mOutFilePath);
        if (b16.equalsIgnoreCase(this.mMsg.combineFileMd5)) {
            MessageForScribble messageForScribble = this.mMsg;
            if (messageForScribble != null) {
                messageForScribble.mExistInfo.mCombineFileExist = true;
            }
            int splitPureDataFromCombineFile = ((IScribbleMsgUtils) QRoute.api(IScribbleMsgUtils.class)).splitPureDataFromCombineFile(this.mMsg);
            if (splitPureDataFromCombineFile == e.f282561d) {
                MessageForScribble messageForScribble2 = this.mMsg;
                if (messageForScribble2 != null) {
                    MessageForScribble.FileExistInfo fileExistInfo = messageForScribble2.mExistInfo;
                    fileExistInfo.mDataFileExist = true;
                    fileExistInfo.mInit = true;
                }
                onSuccess();
                return;
            }
            MessageForScribble messageForScribble3 = this.mMsg;
            if (messageForScribble3 != null) {
                MessageForScribble.FileExistInfo fileExistInfo2 = messageForScribble3.mExistInfo;
                fileExistInfo2.mDataFileExist = false;
                fileExistInfo2.mInit = true;
            }
            this.mProcessorReport.setError(9303, BaseTransProcessor.getExpStackString(new Exception("SpliteCombineFile illegal result: " + splitPureDataFromCombineFile)), null, null);
            onError();
            return;
        }
        MessageForScribble messageForScribble4 = this.mMsg;
        if (messageForScribble4 != null) {
            MessageForScribble.FileExistInfo fileExistInfo3 = messageForScribble4.mExistInfo;
            fileExistInfo3.mDataFileExist = false;
            fileExistInfo3.mCombineFileExist = false;
            fileExistInfo3.mInit = true;
        }
        this.mProcessorReport.setError(9041, BaseTransProcessor.getExpStackString(new Exception("SpliteCombineFile illegal md5String: " + b16 + "  msg.combineFileMd5:  " + this.mMsg.combineFileMd5)), null, null);
        onError();
    }

    private void updateMsg(MessageForScribble messageForScribble) {
        if (messageForScribble != null) {
            messageForScribble.prewrite();
            ((IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(messageForScribble.frienduin, messageForScribble.istroop, messageForScribble.uniseq, messageForScribble.msgData);
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
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord != null && (messageRecord instanceof MessageForScribble)) {
            MessageForScribble messageForScribble = (MessageForScribble) messageRecord;
            this.mMsg = messageForScribble;
            this.url = messageForScribble.combineFileUrl;
        }
        MessageForScribble messageForScribble2 = this.mMsg;
        if (messageForScribble2 != null && !messageForScribble2.combineFileUrl.equals("") && this.mMsg.combineFileUrl.startsWith("http")) {
            this.mUiRequest.mOutFilePath = ((IScribbleMsgUtils) QRoute.api(IScribbleMsgUtils.class)).getScribbleCombineFile(this.mMsg);
            if (TextUtils.isEmpty(this.mUiRequest.mOutFilePath)) {
                this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("combineFileMd5 illegal " + this.mMsg.combineFileMd5)), null, null);
                onError();
                return -1;
            }
            if (!checkMD5Valid(this.mMsg.combineFileMd5)) {
                this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("checkPathValid, combineFileMd5 illegal " + this.mMsg.combineFileMd5)), null, null);
                onError();
                return -1;
            }
            return 0;
        }
        this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("combineFileUrl illegal " + this.url)), null, null);
        onError();
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        MessageForScribble messageForScribble;
        super.onError();
        MessageForScribble messageForScribble2 = this.mMsg;
        if (messageForScribble2 != null) {
            messageForScribble2.fileDownloadStatus = 2;
        }
        updateMsg(messageForScribble2);
        sendMessageToUpdate(2005);
        IScribbleDownloader iScribbleDownloader = (IScribbleDownloader) this.app.getRuntimeService(IScribbleDownloader.class, "");
        if (iScribbleDownloader != null && (messageForScribble = this.mMsg) != null) {
            iScribbleDownloader.removeDownloadedMsg(messageForScribble);
        }
        ReportController.o(this.app, "CliOper", "", "", "0X800945B", "0X800945B", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) netResp);
            return;
        }
        super.onResp(netResp);
        this.mNetReq = null;
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
        StepInfo stepInfo = processorReport.mStepTrans;
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
        QLog.i(TAG, 2, "scribble download onResp resp.mResult = " + netResp.mResult);
        if (netResp.mResult == 0) {
            MessageForScribble messageForScribble = this.mMsg;
            if (messageForScribble != null) {
                messageForScribble.mExistInfo.mCombineFileExist = true;
            }
            spliteCombineFile();
            return;
        }
        MessageForScribble messageForScribble2 = this.mMsg;
        if (messageForScribble2 != null) {
            MessageForScribble.FileExistInfo fileExistInfo = messageForScribble2.mExistInfo;
            fileExistInfo.mCombineFileExist = false;
            fileExistInfo.mDataFileExist = false;
            fileExistInfo.mInit = true;
        }
        int i3 = this.mTotalRetryTime;
        if (i3 < 5) {
            this.mTotalRetryTime = i3 + 1;
            ArrayList<String> arrayList = this.ipListFromInnerDns;
            if (arrayList != null && !arrayList.isEmpty() && this.mIpIndex < this.ipListFromInnerDns.size()) {
                QLog.e(TAG, 2, "scribble download  retry by changeIp");
                clearReprotInfo();
                InnerDns.getInstance().reportBadIp(InnerDns.getHostFromUrl(this.url), this.ipListFromInnerDns.get(this.mIpIndex), 1018);
                this.mIpIndex++;
                recieveFile();
                return;
            }
            if (netResp.mErrCode == 9364 && this.mNetworkChgRetryCount < 3) {
                logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
                QLog.e(TAG, 2, "scribble download  retry");
                this.mNetworkChgRetryCount++;
                clearReprotInfo();
                recieveFile();
                return;
            }
        }
        onError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        MessageForScribble messageForScribble;
        super.onSuccess();
        MessageForScribble messageForScribble2 = this.mMsg;
        if (messageForScribble2 != null) {
            messageForScribble2.fileDownloadStatus = 1;
        }
        updateMsg(messageForScribble2);
        sendMessageToUpdate(2003);
        IScribbleDownloader iScribbleDownloader = (IScribbleDownloader) this.app.getRuntimeService(IScribbleDownloader.class, "");
        if (iScribbleDownloader != null && (messageForScribble = this.mMsg) != null) {
            iScribbleDownloader.removeDownloadedMsg(messageForScribble);
        }
        ReportController.o(this.app, "CliOper", "", "", "0X800945C", "0X800945C", 0, 0, "", "", "", "");
    }

    void recieveFile() {
        String str;
        MessageForScribble messageForScribble = this.mMsg;
        boolean z16 = false;
        if (messageForScribble != null && checkMD5Valid(messageForScribble.combineFileMd5)) {
            QLog.i(TAG, 2, "scribble download start ");
            this.mProcessorReport.mStepTrans.logStartTime();
            String str2 = this.url;
            sendMessageToUpdate(2001);
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mCallback = this;
            httpNetReq.mReqUrl = str2;
            httpNetReq.mHttpMethod = 0;
            TransferRequest transferRequest = this.mUiRequest;
            httpNetReq.mOutPath = transferRequest.mOutFilePath;
            httpNetReq.mMsgId = String.valueOf(transferRequest.mUniseq);
            TransferRequest transferRequest2 = this.mUiRequest;
            httpNetReq.mBusiProtoType = transferRequest2.mUinType;
            httpNetReq.mFileType = transferRequest2.mFileType;
            httpNetReq.mStartDownOffset = 0L;
            httpNetReq.mIsNetChgAsError = true;
            httpNetReq.mCanPrintUrl = true;
            ArrayList<String> arrayList = this.ipListFromInnerDns;
            if (arrayList != null && !arrayList.isEmpty() && this.mIpIndex < this.ipListFromInnerDns.size()) {
                String replaceDomainWithIp = InnerDns.replaceDomainWithIp(httpNetReq.mReqUrl, this.ipListFromInnerDns.get(this.mIpIndex));
                if (replaceDomainWithIp != null && !replaceDomainWithIp.equals(httpNetReq.mReqUrl)) {
                    httpNetReq.mReqUrl = replaceDomainWithIp;
                    z16 = true;
                }
            }
            if (z16) {
                ReportController.o(this.app, "CliOper", "", "", "0X800945D", "0X800945D", 0, 0, "", "", "", "");
            } else {
                ReportController.o(this.app, "CliOper", "", "", "0X800945E", "0X800945E", 0, 0, "", "", "", "");
            }
            String ipOrDomainFromURL = TransFileUtil.getIpOrDomainFromURL(str2);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "httpDownRespDomain: " + ipOrDomainFromURL + "reqUrl : " + str2 + " " + httpNetReq.mReqUrl + " uuid:" + this.mUiRequest.mServerPath + " downOffset:" + httpNetReq.mStartDownOffset);
            }
            QLog.i(TAG, 2, "index:" + this.mIpIndex + str2);
            if (!canDoNextStep()) {
                return;
            }
            this.mNetReq = httpNetReq;
            setMtype();
            this.mNetEngine.sendReq(httpNetReq);
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = "receiveFile, checkPathValid error : ";
        MessageForScribble messageForScribble2 = this.mMsg;
        if (messageForScribble2 == null) {
            str = "msg null";
        } else {
            str = messageForScribble2.combineFileMd5;
        }
        objArr[1] = str;
        QLog.e(TAG, 1, objArr);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "resume()");
        }
        if (this.mIsPause) {
            this.mIsPause = false;
            this.mIsCancel = false;
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.errCode = 0;
            processorReport.errDesc = "";
            this.mController.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScribblePicDownloadProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ScribblePicDownloadProcessor.this.recieveFile();
                    }
                }
            });
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.BaseDownloadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.start();
        MessageForScribble messageForScribble = this.mMsg;
        if (messageForScribble != null) {
            messageForScribble.fileDownloadStatus = 3;
        }
        String str = this.url;
        if (str != null && !str.startsWith("https")) {
            this.ipListFromInnerDns = InnerDns.getInstance().reqDnsForIpList(InnerDns.getHostFromUrl(this.url), 1018);
        }
        ArrayList<String> arrayList = this.ipListFromInnerDns;
        if (arrayList != null && !arrayList.isEmpty()) {
            String str2 = "ipListFromInnerDns : ";
            for (int i3 = 0; i3 < this.ipListFromInnerDns.size(); i3++) {
                str2 = str2 + " " + this.ipListFromInnerDns.get(i3);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, str2);
            }
        }
        ReportController.o(this.app, "CliOper", "", "", "0X800945A", "0X800945A", 0, 0, "", "", "", "");
        recieveFile();
    }
}
