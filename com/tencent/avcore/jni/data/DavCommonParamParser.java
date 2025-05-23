package com.tencent.avcore.jni.data;

import com.tencent.avcore.jni.data.DavPBCommonParam;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class DavCommonParamParser {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DavCommonParamParser";

    public DavCommonParamParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static DavPBCommonParam.CommonParam parseBufferToCommonParam(byte[] bArr) {
        if (bArr == null) {
            AVCoreLog.e(TAG, "parseBufferToCommonParam empty buffer");
            return null;
        }
        DavPBCommonParam.CommonParam commonParam = new DavPBCommonParam.CommonParam();
        try {
            commonParam.mergeFrom(bArr);
            return commonParam;
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            AVCoreLog.e(TAG, "parseBufferToCommonParam decode pb failed");
            return null;
        }
    }
}
