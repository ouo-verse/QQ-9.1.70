package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopTrpcRemoteResponse implements Serializable {
    static IPatchRedirector $redirector_;
    public int channelCode;
    public String channelMsg;
    public int code;
    public String compressRatio;
    public int compressType;
    public byte[] data;

    /* renamed from: msg, reason: collision with root package name */
    public String f293941msg;
    public int unCompressSucceed;
    public long unCompressTimeCost;

    public TroopTrpcRemoteResponse(int i3, String str, byte[] bArr, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, bArr, Integer.valueOf(i16), str2);
            return;
        }
        this.code = i3;
        this.f293941msg = str;
        this.data = bArr;
        this.channelCode = i16;
        this.channelMsg = str2;
    }
}
