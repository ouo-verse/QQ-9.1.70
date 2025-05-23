package com.tencent.mobileqq.timiqqid.constants;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQIDConstants {
    public static final String QQID_INTRODUCE_PAGE_SCHEME = "mqqapi://miniapp/open?_atype=0&_mappid=1112117033&_miniapptype=1&_mvid=&_path=%2Fpackage-setting%2Fpages%2Fqq-notice%2Findex&_vt=3&via=test&_sig=4147691083";
    public static final String QQID_INTRODUCE_PAGE_SCHEME_TEST = "mqqapi://miniapp/open?_atype=0&_mappid=1112191268&_miniapptype=1&_mvid=&_path=%2Fpackage-setting%2Fpages%2Fqq-notice%2Findex&_vt=1&via=test&_sig=4224825683";
    public static final String QQID_MAIN_PAGE_SCHEME = "mqqapi://miniapp/open?_atype=0&_mappid=1112117033&_miniapptype=1&_mvid=&_vt=3&via=test&_sig=4147691083";
    public static final String QQID_MAIN_PAGE_SCHEME_TEST = "mqqapi://miniapp/open?_atype=0&_mappid=1112191268&_miniapptype=1&_mvid=&_vt=1&via=test&_sig=924436662";
    public static final String QQID_MINI_APP_ID = "1112117033";
    public static final String QQID_MINI_APP_ID_3 = "1112132161";
    public static final String QQID_MINI_APP_ID_TEST = "1112191268";
    public static final String QQID_QR_URL_KEY = "qqidguide";
    public static final String QQID_QR_URL_VALUE = "10023E2B7ADA9FC4542168B587F47577";

    public static boolean isWhiteAppId(String str) {
        if (!QQID_MINI_APP_ID.equals(str) && !QQID_MINI_APP_ID_TEST.equals(str) && !QQID_MINI_APP_ID_3.equals(str)) {
            return false;
        }
        return true;
    }
}
