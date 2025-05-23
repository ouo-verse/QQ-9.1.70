package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.transaction.CacheIpInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class HwRequest {
    static IPatchRedirector $redirector_ = null;
    public static final int REQ_2SEND = 2;
    public static final int REQ_FINISHED = 4;
    public static final int REQ_INITED = 1;
    public static final int REQ_SENDING = 3;
    public static final int buzTryCountLimit = 3;
    public static final int fixTryCountLimit = 5;
    public static final int mContinuErrorLimit = 10;
    public static final int mContinueConnClosedLimit = 3;
    public static final long mExcuteTimeLimit = 600000;
    public String account;
    public int appid;
    public int bodyLength;
    public int buzRetryCount;
    public int continueConnClose;
    public int continueErrCount;
    public int dataFlag;
    public EndPoint endpoint;
    public int headLength;
    public String hwCmd;
    private int hwSeq;
    public AtomicBoolean isCancel;
    public boolean isOpenUpEnable;
    public long lastSendStartTime;
    public String lastUseAddress;
    public int localeId;
    public int mBuCmdId;
    public int protoType;
    public IRequestListener reqListener;
    public int retryCount;
    public long sendComsume;
    public int sendConnId;
    public long sendTime;
    public AtomicInteger status;
    protected byte[] ticket;
    public long timeComsume;
    public long timeOut;
    public int timeOutCount;
    public int transId;

    public HwRequest(String str, String str2, int i3, byte[] bArr, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), bArr, Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        this.hwSeq = -1;
        this.mBuCmdId = -1;
        this.hwCmd = null;
        this.dataFlag = 4096;
        this.continueErrCount = 0;
        this.continueConnClose = 0;
        this.headLength = 0;
        this.bodyLength = 0;
        this.lastUseAddress = null;
        this.endpoint = null;
        this.protoType = 1;
        this.isCancel = new AtomicBoolean(false);
        this.status = new AtomicInteger(1);
        this.isOpenUpEnable = false;
        this.appid = 4660;
        this.account = str;
        this.hwCmd = str2;
        this.ticket = bArr;
        this.transId = i16;
        this.mBuCmdId = i3;
        this.hwSeq = RequestWorker.getNextSeq();
        this.appid = HwEngine.appId;
        this.localeId = HwEngine.localeId;
        if (j3 == -1) {
            this.timeOut = 30000L;
        } else {
            this.timeOut = j3;
        }
    }

    public static String intToIP(int i3) {
        return (i3 & 255) + "." + ((i3 >>> 8) & 255) + "." + ((i3 >>> 16) & 255) + "." + ((i3 >>> 24) & 255);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkCacheIp(HwResponse hwResponse, Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) hwResponse, (Object) transaction);
            return;
        }
        if (transaction.cacheIpInfo == null) {
            transaction.cacheIpInfo = new CacheIpInfo(hwResponse, this);
        }
        transaction.cacheIpInfo.checkCacheIp(hwResponse, this);
    }

    public String dumpBaseInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return " REQTRACE_REQ  B_ID:" + this.mBuCmdId + " T_ID:" + this.transId + " Seq:" + this.hwSeq + " Cmd:" + this.hwCmd + " Uin:" + this.account + " TimeOut:" + this.timeOut + " RetryNum:" + this.retryCount + " Comsume:" + this.timeComsume + " SendCost:" + this.sendComsume + " ContinueErr:" + this.continueErrCount + " Status:" + this.status.get() + " Cancel:" + this.isCancel.get() + " HeadLen:" + this.headLength + " BodyLen:" + this.bodyLength;
    }

    public byte[] getExtendInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return null;
    }

    public int getHwSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.hwSeq;
    }

    public CSDataHighwayHead.LoginSigHead getLoginSigHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (CSDataHighwayHead.LoginSigHead) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    public byte[] getRequestBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    public abstract CSDataHighwayHead.SegHead getSegmentHead();

    public byte[] getTicket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.ticket;
    }

    public boolean hasRequestBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    public void onCancle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    public void onError(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
    }

    public void onResponse(RequestWorker requestWorker, HwResponse hwResponse, HwRequest hwRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, this, requestWorker, hwResponse, hwRequest);
    }

    public void onRetry(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
    }

    public void onSendBegin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    public void onSendEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    public void setHwSeq(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.hwSeq = i3;
        }
    }

    public void updateStaus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.status.set(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeCacheIp(CSDataHighwayHead.SegHead segHead, Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) segHead, (Object) transaction);
            return;
        }
        CacheIpInfo cacheIpInfo = transaction.cacheIpInfo;
        if (cacheIpInfo != null) {
            cacheIpInfo.writeHeadCacheIp(segHead, this);
        } else {
            segHead.uint32_cache_addr.set(0);
            segHead.uint32_cache_port.set(0);
        }
    }

    public void onResponse(RequestWorker requestWorker, HwResponse hwResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            onResponse(requestWorker, hwResponse, this);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) requestWorker, (Object) hwResponse);
        }
    }
}
