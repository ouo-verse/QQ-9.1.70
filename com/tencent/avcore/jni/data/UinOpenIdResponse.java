package com.tencent.avcore.jni.data;

import com.tencent.avcore.jni.data.MavAccountInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class UinOpenIdResponse {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "UinOpenIdResponse";

    /* renamed from: msg, reason: collision with root package name */
    public String f77482msg;
    public HashMap<Long, String> pairs;
    public long ret;

    public UinOpenIdResponse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static UinOpenIdResponse getUinOpenIdResponseByPbBuffer(byte[] bArr) {
        if (bArr == null) {
            AVCoreLog.e(TAG, "getUinOpenIdResponseByPbBuffer empty buffer");
            return null;
        }
        MavAccountInfo.MavUinOpenIdResponse mavUinOpenIdResponse = new MavAccountInfo.MavUinOpenIdResponse();
        try {
            mavUinOpenIdResponse.mergeFrom(bArr);
            UinOpenIdResponse uinOpenIdResponse = new UinOpenIdResponse();
            uinOpenIdResponse.ret = mavUinOpenIdResponse.ret.get();
            uinOpenIdResponse.f77482msg = mavUinOpenIdResponse.f77480msg.get();
            uinOpenIdResponse.pairs = new HashMap<>();
            for (int i3 = 0; i3 < mavUinOpenIdResponse.pairs.size(); i3++) {
                uinOpenIdResponse.pairs.put(Long.valueOf(mavUinOpenIdResponse.pairs.get(i3).account.get()), mavUinOpenIdResponse.pairs.get(i3).open_id.get());
            }
            return uinOpenIdResponse;
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            AVCoreLog.e(TAG, "getUinOpenIdResponseByPbBuffer decode pb failed");
            return null;
        }
    }
}
