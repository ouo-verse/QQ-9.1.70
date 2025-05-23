package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RequestHeartBreak extends HwRequest {
    static IPatchRedirector $redirector_;
    public int connId;
    public boolean isUrgent;

    public RequestHeartBreak(String str, String str2, int i3, long j3, int i16, boolean z16) {
        super(str, str2, i3, null, -1, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.connId = i16;
        this.isUrgent = z16;
        if (z16) {
            this.timeOut = 10000L;
        }
        this.isOpenUpEnable = OpenUpConfig.isOpenUpEnable;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public String dumpBaseInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("DUMP_REQ [TYPE_HEARTBREAK] Info: ");
        sb5.append(super.dumpBaseInfo());
        sb5.append(" ConnId:" + this.connId);
        sb5.append(" Urgent:" + this.isUrgent);
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public byte[] getRequestBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return super.getRequestBody();
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public CSDataHighwayHead.SegHead getSegmentHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CSDataHighwayHead.SegHead) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.highway.segment.HwRequest
    public void onResponse(RequestWorker requestWorker, HwResponse hwResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) requestWorker, (Object) hwResponse);
        } else {
            requestWorker.engine.mConnManager.onHeartBreakResp(this.sendConnId, this.endpoint, this.isUrgent);
        }
    }
}
