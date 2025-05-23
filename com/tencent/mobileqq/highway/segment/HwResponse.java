package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HwResponse {
    static IPatchRedirector $redirector_;
    public int buzRetCode;
    public long cacheCost;
    public String cmd;
    public int errCode;
    public String errDesc;
    public long htCost;
    public int hwSeq;
    public boolean isFinish;
    public boolean isIpv6;
    public int mBuCmdId;
    public byte[] mBuExtendinfo;
    public byte[] mRespData;
    public int mTransId;
    public boolean needReUpload;
    public int range;
    public long recvTime;
    public long reqCost;
    public int respLength;
    public int retCode;
    public CSDataHighwayHead.SegHead segmentResp;
    public boolean shouldRetry;
    public long switchCost;

    public HwResponse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.hwSeq = -1;
        this.cmd = null;
        this.mBuCmdId = -1;
        this.mTransId = -1;
        this.errCode = 0;
        this.retCode = 0;
        this.buzRetCode = 0;
        this.errDesc = null;
        this.segmentResp = null;
        this.respLength = 0;
        this.isFinish = false;
        this.shouldRetry = false;
        this.needReUpload = false;
    }

    public String dumpRespInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return " REQTRACE_RSP B_ID:" + this.mBuCmdId + " T_ID:" + this.mTransId + " Seq:" + this.hwSeq + " Cmd:" + this.cmd + " Err_C:" + this.errCode + " Err_B:" + this.buzRetCode + " Err_H:" + this.retCode + " COST_Switch:" + this.switchCost + "ms COST_REQ:" + this.reqCost + "ms COST_HT:" + this.htCost + "ms COST_CACHE:" + this.cacheCost + "ms FIN:" + this.isFinish + " Retry:" + this.shouldRetry + " RespLen:" + this.respLength + " isIpv6:" + this.isIpv6;
    }

    public void setErrorCode(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        this.errCode = i3;
        this.retCode = i16;
        this.errDesc = str;
    }
}
