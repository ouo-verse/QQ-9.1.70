package com.tencent.mobileqq.highway.transaction;

import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DataTransInfo {
    static IPatchRedirector $redirector_;
    public int bitmapE;
    public int bitmapS;
    public String errString;
    public int errno;
    public int fileSize;
    public int length;
    public byte[] md5;
    public String md5Str;
    public int offset;
    public Transaction parent;
    public int retryTimes;
    public long timeCost_cache;
    public long timeCost_hw;
    public long timeCost_req;

    public DataTransInfo(Transaction transaction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) transaction);
            return;
        }
        this.timeCost_req = 0L;
        this.timeCost_hw = 0L;
        this.timeCost_cache = 0L;
        this.retryTimes = 0;
        this.parent = transaction;
    }

    public byte[] getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        byte[] data = this.parent.getData(this);
        if (data != null) {
            byte[] encode = BdhUtils.encode(data);
            this.md5 = encode;
            this.md5Str = BdhUtils.bytes2HexStr(encode);
        }
        return data;
    }

    public void handleCancle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        byte[] bArr = this.parent.bitmap;
        for (int i3 = this.bitmapS; i3 <= this.bitmapE; i3++) {
            bArr[i3] = 0;
        }
    }
}
