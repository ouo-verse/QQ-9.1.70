package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.IInject;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.transaction.DataTransInfo;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RequestDataTrans extends HwRequest {
    static IPatchRedirector $redirector_;
    public DataTransInfo mInfo;

    public RequestDataTrans(String str, String str2, int i3, DataTransInfo dataTransInfo, byte[] bArr, int i16, long j3) {
        super(str, str2, i3, bArr, i16, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), dataTransInfo, bArr, Integer.valueOf(i16), Long.valueOf(j3));
        } else {
            this.mInfo = dataTransInfo;
            this.isOpenUpEnable = dataTransInfo.parent.isOpenUpEnable;
        }
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public String dumpBaseInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "DUMP_REQ [TYPE_DATA] Info: " + super.dumpBaseInfo() + "\tFsize:" + this.mInfo.fileSize + "\tOffset:" + this.mInfo.offset + "\tBitS:" + this.mInfo.bitmapS + "\tBitE:" + this.mInfo.bitmapE + "\tLen:" + this.mInfo.length + "\tMD5:" + this.mInfo.md5Str;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public byte[] getExtendInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mInfo.parent.extendInfo;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public CSDataHighwayHead.LoginSigHead getLoginSigHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CSDataHighwayHead.LoginSigHead) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mInfo.parent.loginSigHead;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public byte[] getRequestBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mInfo.getData();
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public CSDataHighwayHead.SegHead getSegmentHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CSDataHighwayHead.SegHead) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        CSDataHighwayHead.SegHead segHead = new CSDataHighwayHead.SegHead();
        segHead.uint32_datalength.set(this.mInfo.length);
        segHead.uint64_dataoffset.set(this.mInfo.offset);
        segHead.uint64_filesize.set(this.mInfo.fileSize);
        if (this.ticket != null && getTicket().length > 0) {
            segHead.bytes_serviceticket.set(ByteStringMicro.copyFrom(this.ticket));
        }
        byte[] bArr = this.mInfo.md5;
        if (bArr != null) {
            segHead.bytes_md5.set(ByteStringMicro.copyFrom(bArr));
        }
        byte[] bArr2 = this.mInfo.parent.MD5;
        if (bArr2 != null) {
            segHead.bytes_file_md5.set(ByteStringMicro.copyFrom(bArr2));
        }
        writeCacheIp(segHead, this.mInfo.parent);
        return segHead;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public boolean hasRequestBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onCancle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.mInfo.parent.TRACKER.logStep(Tracker.CANCL, " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq());
        this.mInfo.handleCancle();
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onError(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        this.mInfo.parent.TRACKER.logStep(Tracker.SND_E, " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + i3);
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onResponse(RequestWorker requestWorker, HwResponse hwResponse) {
        IInject iInject;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) requestWorker, (Object) hwResponse);
            return;
        }
        this.mInfo.parent.TRACKER.logStep(Tracker.RESPN, " Data Resp Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + hwResponse.retCode);
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, " Data Resp Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + hwResponse.retCode);
        Transaction transactionById = requestWorker.engine.mTransWorker.getTransactionById(this.transId);
        if (transactionById != null) {
            DataTransInfo dataTransInfo = this.mInfo;
            dataTransInfo.timeCost_req = hwResponse.reqCost;
            dataTransInfo.timeCost_hw = hwResponse.htCost;
            dataTransInfo.timeCost_cache = hwResponse.cacheCost;
            dataTransInfo.retryTimes = this.retryCount;
            String str2 = "TCP";
            boolean z16 = true;
            if (this.endpoint != null) {
                transactionById.mTransReport.netType = HwNetworkCenter.getInstance(requestWorker.engine.getAppContext()).getNetType();
                transactionById.mTransReport.connNum = requestWorker.engine.mConnManager.getCurrentConnNum();
                TransReport transReport = transactionById.mTransReport;
                if (this.protoType == 1) {
                    str = "TCP";
                } else {
                    str = "HTTP";
                }
                transReport.protoType = str;
                transReport.ipIndex = this.endpoint.ipIndex;
                transReport.isIpv6 = hwResponse.isIpv6;
                ConnManager connManager = requestWorker.engine.mConnManager;
                transReport.mHasIpv6List = connManager.mHasIpv6List;
                transReport.mIPv6Fast = connManager.isIpv6Fast();
            }
            if (hwResponse.retCode == 0) {
                if (hwResponse.segmentResp.uint32_flag.has()) {
                    if ((hwResponse.segmentResp.uint32_flag.get() & 1) != 1) {
                        z16 = false;
                    }
                    hwResponse.isFinish = z16;
                }
                checkCacheIp(hwResponse, this.mInfo.parent);
                if (this.mInfo.bitmapS == 0) {
                    transactionById.mTransReport.firstRange = hwResponse.range;
                }
                if (hwResponse.needReUpload) {
                    if (!transactionById.reUploadTransaction) {
                        transactionById.onTransReUpload(getHwSeq());
                        return;
                    }
                    BdhLogUtil.LogEvent("T", "B_ID:" + transactionById.mBuzCmdId + "\tT_ID:" + transactionById.getTransationId() + " ReUpload twice,transaction fail");
                    transactionById.TRACKER.logStep(Tracker.REUPLOAD, "ReUpload twice");
                    transactionById.onTransFailed(9304, "ReUpload twice", hwResponse.retCode, hwResponse.buzRetCode, this.retryCount, hwResponse.mBuExtendinfo);
                    return;
                }
                if (hwResponse.range > transactionById.transferedSizeBDH && getHwSeq() > transactionById.reUploadHwSeq) {
                    int i3 = hwResponse.range;
                    if (i3 > transactionById.totalLength) {
                        BdhLogUtil.LogEvent("T", "B_ID:" + transactionById.mBuzCmdId + "\tT_ID:" + transactionById.getTransationId() + " ReturnServerRangeError");
                        transactionById.transferedSizeBDH = 0;
                    } else {
                        transactionById.transferedSizeBDH = i3;
                    }
                }
                if (hwResponse.isFinish) {
                    transactionById.onTransSuccess(this.mInfo, hwResponse.mBuExtendinfo);
                    return;
                } else {
                    transactionById.onTransProgress(this, hwResponse);
                    return;
                }
            }
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "HandleResp : RespError :" + dumpBaseInfo());
            if (hwResponse.retCode == 67) {
                QLog.d(BdhLogUtil.Tag, 1, "session error,re pull session. transactionBuzId:" + transactionById.mBuzCmdId + " id:" + transactionById.getTransationId());
                HwEngine hwEngine = requestWorker.engine;
                if (hwEngine != null && (iInject = hwEngine.injectHelper) != null && hwEngine.currentUin != null) {
                    HwServlet.getConfig(iInject.getRuntime(), hwEngine.currentUin);
                }
            }
            TransReport transReport2 = transactionById.mTransReport;
            if (this.protoType != 1) {
                str2 = "HTTP";
            }
            transReport2.protoType = str2;
            transactionById.onTransFailed(0, "BadResponse", hwResponse.retCode, hwResponse.buzRetCode, this.retryCount, hwResponse.mBuExtendinfo);
        }
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onRetry(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        Transaction transaction = this.mInfo.parent;
        transaction.mTransReport.mRetryCode = i3;
        transaction.TRACKER.logStep(Tracker.SND_R, " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq() + " Code:" + i3);
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onSendBegin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mInfo.parent.TRACKER.logStep(Tracker.SND_S, " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq());
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onSendEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mInfo.parent.TRACKER.logStep(Tracker.SND_F, " Data Start:" + this.mInfo.bitmapS + " End:" + this.mInfo.bitmapE + " Seq:" + getHwSeq());
    }
}
