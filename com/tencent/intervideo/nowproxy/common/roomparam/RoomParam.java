package com.tencent.intervideo.nowproxy.common.roomparam;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.InitData;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public class RoomParam {
    static IPatchRedirector $redirector_;

    public RoomParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getClientType(int i3) {
        return (i3 * 16) + 2;
    }

    public static Bundle getEnterRoomParam(long j3, String str, String str2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("roomid", String.valueOf(j3));
        bundle.putString("vid", str);
        bundle.putString("fromid", str2);
        bundle.putInt(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, i3);
        return bundle;
    }

    public static Bundle getRoomInitParam(InitData initData) {
        Bundle bundle = new Bundle();
        bundle.putString("appid", initData.mAppID);
        bundle.putString("hostVersion", initData.mSourceVersion);
        bundle.putString("clientType", String.valueOf(initData.mClientType));
        bundle.putBoolean("is_cpu_64bit", initData.mIsCpu64bit);
        if (!TextUtils.isEmpty(initData.mGuid)) {
            bundle.putString("guid", initData.mGuid);
        }
        if (!TextUtils.isEmpty(initData.mQUA)) {
            bundle.putString("qua", initData.mQUA);
        }
        if (!TextUtils.isEmpty(initData.mQBID)) {
            bundle.putString("qbid", initData.mQBID);
        }
        if (!TextUtils.isEmpty(initData.mSourceUid)) {
            bundle.putString("uid", initData.mSourceUid);
        }
        return bundle;
    }

    public static Bundle getRoomLoginTicket(LoginData loginData) {
        Bundle bundle = new Bundle();
        if (loginData == null) {
            return bundle;
        }
        Bundle loginBundle = LoginData.getLoginBundle(loginData);
        loginBundle.putString("uid", loginData.getUserId());
        return loginBundle;
    }
}
