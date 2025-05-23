package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.HwNetworkCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RequestInfoQuery extends HwRequest {
    static IPatchRedirector $redirector_;
    public Transaction mTrans;
    public byte[] sentBitmap;

    public RequestInfoQuery(String str, String str2, int i3, byte[] bArr, Transaction transaction, long j3, byte[] bArr2) {
        super(str, str2, i3, bArr, transaction.getTransationId(), j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), bArr, transaction, Long.valueOf(j3), bArr2);
            return;
        }
        this.sentBitmap = bArr2;
        this.mTrans = transaction;
        this.isOpenUpEnable = transaction.isOpenUpEnable;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public String dumpBaseInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "DUMP_REQ [TYPE_INFOQUERY] Info: " + super.dumpBaseInfo();
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public byte[] getExtendInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mTrans.extendInfo;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public CSDataHighwayHead.LoginSigHead getLoginSigHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CSDataHighwayHead.LoginSigHead) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mTrans.loginSigHead;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public CSDataHighwayHead.SegHead getSegmentHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CSDataHighwayHead.SegHead) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        CSDataHighwayHead.SegHead segHead = new CSDataHighwayHead.SegHead();
        if (this.ticket != null && getTicket().length > 0) {
            segHead.bytes_serviceticket.set(ByteStringMicro.copyFrom(this.ticket));
        }
        byte[] bArr = this.mTrans.MD5;
        if (bArr != null) {
            segHead.bytes_file_md5.set(ByteStringMicro.copyFrom(bArr));
        }
        segHead.uint64_filesize.set(this.mTrans.totalLength);
        writeCacheIp(segHead, this.mTrans);
        return segHead;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onCancle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.mTrans.TRACKER.logStep(Tracker.CANCL, " Query Seq:" + getHwSeq());
        this.mTrans.onQuertHoleError(this.sentBitmap);
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onError(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        this.mTrans.onQuertHoleError(this.sentBitmap);
        this.mTrans.TRACKER.logStep(Tracker.SND_E, " Query Seq:" + getHwSeq() + " Code:" + i3);
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onResponse(RequestWorker requestWorker, HwResponse hwResponse, HwRequest hwRequest) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, requestWorker, hwResponse, hwRequest);
            return;
        }
        if (hwResponse.segmentResp.has() && hwResponse.segmentResp.uint32_flag.has()) {
            if ((hwResponse.segmentResp.uint32_flag.get() & 1) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            hwResponse.isFinish = z16;
        }
        this.mTrans.TRACKER.logStep(Tracker.RESPN, " Query Seq:" + getHwSeq() + " RetCode:" + hwResponse.retCode + " isFinish:" + hwResponse.isFinish);
        BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "QueryDebug Query HandleResponse : retResp.hwRetCode:" + hwResponse.retCode + " : TransId:" + this.mTrans.getTransationId() + " CopyBitmap:" + Arrays.toString(this.sentBitmap) + " CurrentBitmap:" + Arrays.toString(this.mTrans.bitmap));
        if (this.endpoint != null) {
            this.mTrans.mTransReport.netType = HwNetworkCenter.getInstance(requestWorker.engine.getAppContext()).getNetType();
            this.mTrans.mTransReport.connNum = requestWorker.engine.mConnManager.getCurrentConnNum();
            TransReport transReport = this.mTrans.mTransReport;
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
            if (hwResponse.isFinish) {
                this.mTrans.onTransSuccess(null, hwResponse.mBuExtendinfo);
            } else {
                byte[] bArr = hwResponse.mRespData;
                CSDataHighwayHead.RspBody rspBody = new CSDataHighwayHead.RspBody();
                try {
                    rspBody.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException unused) {
                    BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "HandleResp ParseError.");
                }
                this.mTrans.onQueryHoleResp(rspBody.msg_query_hole_rsp.get(), this.sentBitmap, false, hwResponse, (RequestInfoQuery) hwRequest);
            }
            checkCacheIp(hwResponse, this.mTrans);
            return;
        }
        this.mTrans.onQuertHoleError(this.sentBitmap);
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onRetry(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        this.mTrans.TRACKER.logStep(Tracker.SND_R, " Query Seq:" + getHwSeq() + " Code:" + i3);
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onSendBegin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.mTrans.TRACKER.logStep(Tracker.SND_S, " Query Seq:" + getHwSeq());
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onSendEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.mTrans.TRACKER.logStep(Tracker.SND_F, " Query Seq:" + getHwSeq());
    }
}
