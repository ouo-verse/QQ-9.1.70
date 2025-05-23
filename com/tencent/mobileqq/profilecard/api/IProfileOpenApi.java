package com.tencent.mobileqq.profilecard.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.HashMap;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileOpenApi extends QRouteApi {

    /* loaded from: classes16.dex */
    public interface ProfileServiceCallback {
        public static final int ERROR_CODE_FAIL_BUSINESS = 1000;
        public static final int ERROR_CODE_FAIL_DEFAULT = 1;
        public static final int ERROR_CODE_FAIL_NETWORK = 2;
        public static final int ERROR_CODE_SUCCESS = 0;
        public static final String PROFILE_NICK = "profile_nick";
        public static final String PROFILE_NICK_MAP = "profile_nick_map";

        void onResult(int i3, String str, Bundle bundle);
    }

    @Deprecated
    String getNick(String str, String str2, ProfileServiceCallback profileServiceCallback);

    HashMap<String, String> getNick(ArrayList<String> arrayList, String str, ProfileServiceCallback profileServiceCallback);
}
