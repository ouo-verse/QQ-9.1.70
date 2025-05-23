package com.tencent.mobileqq.app;

import android.content.Context;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xd55$RspBody;

/* loaded from: classes11.dex */
public class ForwardMiniAppThirdPartyHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ForwardMiniAppThirdPartyHelper";
    public static final String THIRD_PARTY_PULL_UP_MINI_APP_FAIL = "0X800A51B";
    public static final String THIRD_PARTY_PULL_UP_MINI_APP_SUCCESS = "0X800A51A";
    public static final String THIRD_PARTY_PULL_UP_MINI_APP_TYPE_DEFAULT = "release";
    public static final String THIRD_PARTY_TRY_PULL_UP_MINI_APP = "0X800A519";

    public ForwardMiniAppThirdPartyHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getSSOErrorStringWithData(byte[] bArr) {
        if (bArr == null) {
            QLog.e(TAG, 1, "Data is null");
            return "";
        }
        oidb_0xd55$RspBody oidb_0xd55_rspbody = new oidb_0xd55$RspBody();
        try {
            oidb_0xd55_rspbody.mergeFrom(bArr);
            if (!oidb_0xd55_rspbody.wording.has()) {
                return "";
            }
            return oidb_0xd55_rspbody.wording.get();
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(TAG, 1, "oidb_0xd55_RspBody merge fail:" + e16.getMessage());
            return "";
        }
    }

    public static void launchMiniApp(Context context, String str, String str2, String str3) {
        try {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppById(context, str, str2, null, str3, null, 1069, null);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }
}
