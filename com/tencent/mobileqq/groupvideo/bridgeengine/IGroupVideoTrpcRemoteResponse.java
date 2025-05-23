package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class IGroupVideoTrpcRemoteResponse {
    static IPatchRedirector $redirector_;
    public int channelCode;
    public String channelMsg;
    public int code;
    public byte[] data;

    /* renamed from: msg, reason: collision with root package name */
    public String f213713msg;

    public IGroupVideoTrpcRemoteResponse(int i3, String str, byte[] bArr, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, bArr, Integer.valueOf(i16), str2);
            return;
        }
        this.code = i3;
        this.f213713msg = str;
        this.data = bArr;
        this.channelCode = i16;
        this.channelMsg = str2;
    }
}
