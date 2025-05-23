package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.ark.module.f;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkModuleAPIAuthority extends QRouteApi {
    public static final String ARK_AUTHORITY_API_LOCATION = "ark_authority_api_location";
    public static final String ARK_AUTHORITY_API_LOGIN = "ark_authority_api_login";
    public static final String ARK_AUTHORITY_API_PHONENUMBER = "ark_authority_api_phone_number";
    public static final String ARK_AUTHORITY_API_RELATIONSHIP = "ark_authority_api_relationship";
    public static final String ARK_AUTHORITY_API_USER_INFO = "ark_authority_api_user_info";
    public static final int ARK_AUTHORITY_STATE_DISABLE = 2;
    public static final int ARK_AUTHORITY_STATE_ENABLE = 1;
    public static final int ARK_AUTHORITY_STATE_NONE = 0;
    public static final String SP_ARK_AUTHORITY = "sp_ark_authority";

    ArrayList<String> getArkAuthorityAppList(String str);

    int getArkAuthorityInfo(String str, String str2, String str3);

    void showAuthDialog(String str, String str2, String str3, String str4, String str5, f fVar);

    void updateArkAuthorityAppList(String str, String str2);

    void updateArkAuthorityInfo(String str, String str2, String str3, int i3);
}
