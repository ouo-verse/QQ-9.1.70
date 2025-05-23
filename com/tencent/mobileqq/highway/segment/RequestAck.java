package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.api.IRequestCallback;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RequestAck extends HwRequest {
    static IPatchRedirector $redirector_ = null;
    public static final int mContinuErrorLimit = 1;
    public int cacheIp_send;

    /* renamed from: cb, reason: collision with root package name */
    IRequestCallback f236838cb;
    byte[] extendInfo;
    CSDataHighwayHead.LoginSigHead loginSigHead;
    byte[] md5;

    public RequestAck(String str, int i3, byte[] bArr, long j3, IRequestCallback iRequestCallback, byte[] bArr2, byte[] bArr3, int i16) {
        super(str, "PicUp.DataUp", i3, bArr, 0, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), bArr, Long.valueOf(j3), iRequestCallback, bArr2, bArr3, Integer.valueOf(i16));
            return;
        }
        this.f236838cb = iRequestCallback;
        this.extendInfo = bArr2;
        this.md5 = bArr3;
        this.cacheIp_send = i16;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public String dumpBaseInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "DUMP_REQ [TYPE_ACK] Info: " + super.dumpBaseInfo() + " extendInfo: " + this.extendInfo;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public byte[] getExtendInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.extendInfo;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public CSDataHighwayHead.LoginSigHead getLoginSigHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CSDataHighwayHead.LoginSigHead) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.loginSigHead;
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
        byte[] bArr = this.md5;
        if (bArr != null) {
            segHead.bytes_file_md5.set(ByteStringMicro.copyFrom(bArr));
        }
        int i3 = this.cacheIp_send;
        if (i3 != 0) {
            segHead.uint32_cache_addr.set(i3);
            BdhLogUtil.LogEvent(BdhLogUtil.LogTag.Tag_Req, "RequestAck getSegmentHead : cache_addr send to server is : " + this.cacheIp_send + " ( " + HwRequest.intToIP(this.cacheIp_send) + " ) Seq:" + getHwSeq());
        }
        return segHead;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onCancle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onError(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f236838cb.onFailed(i3);
        }
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onResponse(RequestWorker requestWorker, HwResponse hwResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) requestWorker, (Object) hwResponse);
        } else {
            this.f236838cb.onResponse(hwResponse);
        }
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onRetry(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onSendBegin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onSendEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }
}
