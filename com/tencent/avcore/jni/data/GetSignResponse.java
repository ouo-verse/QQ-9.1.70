package com.tencent.avcore.jni.data;

import com.tencent.avcore.jni.data.MavAccountInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GetSignResponse {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GetSignResponse";

    /* renamed from: msg, reason: collision with root package name */
    public String f77478msg;
    public long ret;
    public String sign;

    public GetSignResponse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static GetSignResponse getGetSignResponseByPbBuffer(byte[] bArr) {
        if (bArr == null) {
            AVCoreLog.e(TAG, "getGetSignResponseByPbBuffer empty buffer");
            return null;
        }
        MavAccountInfo.MavGetSignResponse mavGetSignResponse = new MavAccountInfo.MavGetSignResponse();
        try {
            mavGetSignResponse.mergeFrom(bArr);
            GetSignResponse getSignResponse = new GetSignResponse();
            getSignResponse.ret = mavGetSignResponse.ret.get();
            getSignResponse.f77478msg = mavGetSignResponse.f77479msg.get();
            getSignResponse.sign = mavGetSignResponse.sign.get();
            return getSignResponse;
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            AVCoreLog.e(TAG, "getGetSignResponseByPbBuffer decode pb failed");
            return null;
        }
    }
}
