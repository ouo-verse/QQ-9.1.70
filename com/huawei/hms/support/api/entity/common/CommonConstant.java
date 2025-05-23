package com.huawei.hms.support.api.entity.common;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CommonConstant {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ACTION {
        public static final String HWID_SCHEME_URL = "android.intent.action.VIEW";
        public static final String STARTUP_FOR_LOGIN = "com.huawei.hwid.ACTION_START_FOR_GOTO_ACCOUNTCENTER";
        public static final String WEB_AUTH = "com.huawei.hwid.ACTION.WEBAUTH";
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class IdTokenSupportAlg {
        public static final int PS256_ID_TOKEN_ALG = 1;
        public static final int RS256_ID_TOKEN_ALG = 2;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class IncludeGranted {
        public static final String NON_INCLUDE_GRANTED = "https://www.huawei.com/auth/account/nonincludegranted";
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class LocalPermission {
        public static final String ACCESS_TOKEN = "https://www.huawei.com/auth/account/base.profile/accesstoken";
        public static final String CARRIER_ID = "https://www.huawei.com/auth/account/carrierid";
        public static final String SERVICE_AUTH_CODE = "https://www.huawei.com/auth/account/base.profile/serviceauthcode";
        public static final String SETDIALOGAUTH = "setDialogAuth";
        public static final String SETFORCELOGOUT = "setForceLogout";
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class PERMISSION {
        public static final String AGE_RANGE = "com.huawei.hms.account.ageRange";
        public static final String ASSIST_TOKEN = "com.huawei.hms.account.getAssistToken";
        public static final String BASE_PROFILE = "com.huawei.android.hms.account.getBaseProfile";
        public static final String COUNTRY = "com.huawei.android.hms.account.getCountry";
        public static final String HOME_ZONE = "com.huawei.android.hms.account.getHomeZone";
        public static final String IDTOKEN = "idtoken";
        public static final String LOGIN_QR = "com.huawei.android.hms.account.startQrLogin";
        public static final String MOBILE_NUMBER = "com.huawei.android.hms.account.getMobileNumber";
        public static final String OPENID = "com.huawei.android.hms.account.getOpenID";
        public static final String SHIPPING_ADDRESS = "com.huawei.android.hms.account.getShippingAddress";
        public static final String UID = "com.huawei.android.hms.account.getUID";
        public static final String UNIONID = "com.huawei.android.hms.account.getUnionId";
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class RETCODE {
        public static final int CANCELAUTHORIZATION_SUCCESS = 0;
        public static final int CLEAR_ACCESSTOKEN_FAIL_NOT_MATCH = 2010;
        public static final int CLEAR_TOKEN_SUCCESS = 0;
        public static final int GET_ACCOUNT_UNKNOWN_ERROR = 2005;
        public static final int GET_RESULT_SUCCESS = 0;
        public static final int INDEPENDENT_AUTH_NOT_ALLOW = 2026;
        public static final int INVALID_AT_ERROR = 2008;
        public static final int LOGOUT_REQUEST_SUCCESS = 2031;
        public static final int NEED_UPDATE_STATICKIT = 1212;
        public static final int RESPONSE_RESULT_OK = 0;
        public static final int SIGN_IN_AUTH = 2002;
        public static final int SIGN_IN_AUTH_SERVER_FAILED = 2009;
        public static final int SIGN_IN_CANCELLED = 2012;
        public static final int SIGN_IN_CHECK_PASSWORD = 2004;
        public static final int SIGN_IN_EXECUTING = 2013;
        public static final int SIGN_IN_FAILED = 2014;
        public static final int SIGN_IN_NETWORK_ERROR = 2005;
        public static final int SIGN_IN_NETWORK_UNDER_CONTROLED = 2007;
        public static final int SIGN_IN_PARAMS_ERROR = 2003;
        public static final int SIGN_IN_REQUEST_CONTROLLED_ERROR = 2030;
        public static final int SIGN_IN_SDK_INNER_ERROR = 2015;
        public static final int SIGN_IN_SUCCESS = 0;
        public static final int SIGN_IN_UNLOGIN = 2001;
        public static final String SMS_PARAM_ERROR = "sms param is invalid";
        public static final int SMS_RETRIEVER_PARAM_FAILED = 2020;
        public static final int ST_VALID = 0;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class RETKEY {
        public static final String ACCESS_TOKEN = "ACCESSTOKEN";
        public static final String AGE_RANGE = "AGE_RANGE";
        public static final String COUNTRYCODE = "COUNTRY_CODE";
        public static final String DISPLAYNAME = "DISPLAY_NAME";
        public static final String EMAIL = "EMAIL";
        public static final String FAMILY_NAME = "FAMILY_NAME";
        public static final String GENDER = "GENDER";
        public static final String GIVEN_NAME = "GIVEN_NAME";
        public static final String HOME_ZONE = "HOME_ZONE";
        public static final String ID_TOKEN = "ID_TOKEN";
        public static final String OPENID = "OPEN_ID";
        public static final String PHOTOURL = "PHOTO_URL";
        public static final String QR_CODE = "QR_CODE";
        public static final String QR_SITEID = "QR_SITEID";
        public static final String RETCODE = "RET_CODE";
        public static final String SCOPE = "SCOPE";
        public static final String SERVICEAUTHCODE = "SERVICE_AUTH_CODE";
        public static final String SERVICECOUNTRYCODE = "SERVICE_COUNTRY_CODE";
        public static final String SHIPPING_ADDRESS = "SHIPPING_ADDRESS";
        public static final String STATUS = "STATUS";
        public static final String UNIONID = "UNION_ID";
        public static final String USERID = "USER_ID";
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ReqAccessTokenParam {
        public static final String CLIENT_ID = "client_id";
        public static final String DISPLAY_LABEL = "display";
        public static final String HMS_REDIRECT_URI = "hms://redirect_url";
        public static final String LANGUAGE_LABEL = "lang";
        public static final String PACKAGE_NAME = "packageName";
        public static final String PERMISSION_INFO_LABEL = "permission_info";
        public static final String REDIRECT_URI = "redirect_uri";
        public static final String RESPONSE_TYPE = "response_type";
        public static final String SCOPE_LABEL = "scope";
        public static final String STATE_LABEL = "state";
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class RequestParams {
        public static final String IS_FULL_SCREEN = "intent.extra.isfullscreen";
        public static final String KEY_ID_TOKEN_SIGN_ALG = "idTokenSignAlg";
        public static final String KEY_SESSION_ID = "sessionId";
        public static final String KEY_SIGN_IN_PARAMS = "signInParams";
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SCOPE {
        public static final String ACCOUNT_BASEPROFILE = "https://www.huawei.com/auth/account/base.profile";
        public static final String SCOPE_ACCOUNT_COUNTRY = "https://www.huawei.com/auth/account/country";
        public static final String SCOPE_ACCOUNT_EMAIL = "email";
        public static final String SCOPE_ACCOUNT_GAME = "https://www.huawei.com/auth/games";
        public static final String SCOPE_ACCOUNT_OPENID = "openid";
        public static final String SCOPE_ACCOUNT_PROFILE = "profile";
        public static final String SCOPE_ACCOUNT_SHIPPING_ADDRESS = "https://www.huawei.com/auth/account/shipping.address";
        public static final String SCOPE_AGE_RANGE = "https://www.huawei.com/auth/account/age.range";
        public static final String SCOPE_ASSIST_TOKEN = "https://www.huawei.com/auth/account/assisttoken";
        public static final String SCOPE_HOME_ZONE = "https://www.huawei.com/auth/account/homezone";
        public static final String SCOPE_IS_ADULT = "https://www.huawei.com/auth/account/age.groupflag";
        public static final String SCOPE_MOBILE_FLAG = "https://www.huawei.com/auth/account/mobile.flag";
        public static final String SCOPE_MOBILE_NUMBER = "https://www.huawei.com/auth/account/mobile.number";
        public static final String SCOPE_REALNAME_ANONYMOUS = "https://www.huawei.com/auth/account/realname.anonymous";
    }
}
