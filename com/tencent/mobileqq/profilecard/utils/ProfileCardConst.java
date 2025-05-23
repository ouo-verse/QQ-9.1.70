package com.tencent.mobileqq.profilecard.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileCardConst {
    static IPatchRedirector $redirector_ = null;
    public static final String ENTER_PAGE_GRP_ID = "enter_page_grp_id";
    public static final String ENTER_PAGE_OPEN_STAND_IN_PAD = "enter_page_open_stand_in_pad";
    public static final String ENTER_PAGE_SOURCE_ID = "enter_page_sourceid";
    public static final String ENTER_PAGE_SUB_SOURCE_ID = "enter_page_subsourceid";
    public static final int FROM_C2C_AIO = 2;
    public static final int FROM_CONDITION_SEARCH = 9;
    public static final int FROM_CONTACTS_TAB = 5;
    public static final int FROM_FACE_2_FACE_ADD_FRIEND = 11;
    public static final int FROM_FLOCK = 13;
    public static final int FROM_MAYKNOW_FRIEND = 3;
    public static final int FROM_QCIRCLE = 4;
    public static final int FROM_QQ_TROOP = 1;
    public static final int FROM_QZONE = 7;
    public static final int FROM_SCAN = 6;
    public static final int FROM_SEARCH = 8;
    public static final int FROM_SETTING_ME = 12;
    public static final int FROM_SHARE_CARD = 10;
    public static final int FROM_ZPLAN = 14;
    public static final String GROUP_ID = "group_id";
    public static final String IS_BLACK_LIST = "is_blacklist_user_profile";
    public static final String PARAM_EXT = "ext";
    public static final int PROFILE_CARD_IS_BLACK = 2;
    public static final int PROFILE_CARD_IS_BLACKED = 1;
    public static final int PROFILE_CARD_NOT_BLACK = 3;
    public static final int SUB_FROM_C2C_AIO = 21;
    public static final int SUB_FROM_C2C_INTERACTIVE_LOGO = 25;
    public static final int SUB_FROM_C2C_LEFT_SLIDE = 23;
    public static final int SUB_FROM_C2C_OTHER = 24;
    public static final int SUB_FROM_C2C_SETTING = 22;
    public static final int SUB_FROM_C2C_TOFU = 26;
    public static final int SUB_FROM_CONDITION_SEARCH_OTHER = 99;
    public static final int SUB_FROM_CONDITION_SEARCH_RESULT = 91;
    public static final int SUB_FROM_CONTACTS_FRIEND_TAB = 51;
    public static final int SUB_FROM_CONTACTS_TAB = 55;
    public static final int SUB_FROM_FACE_2_FACE_ADD_FRIEND_RESULT_AVATAR = 111;
    public static final int SUB_FROM_FACE_2_FACE_OTHER = 119;
    public static final int SUB_FROM_FLOCK_OTHER = 42;
    public static final int SUB_FROM_FLOCK_PROFILE = 41;
    public static final int SUB_FROM_FRIEND_APPLY = 56;
    public static final int SUB_FROM_FRIEND_NOTIFY_MORE = 57;
    public static final int SUB_FROM_FRIEND_NOTIFY_TAB = 54;
    public static final int SUB_FROM_GROUPING_TAB = 52;
    public static final int SUB_FROM_MAYKNOW_FRIEND_CONTACT_TAB = 31;
    public static final int SUB_FROM_MAYKNOW_FRIEND_CONTACT_TAB_MORE = 37;
    public static final int SUB_FROM_MAYKNOW_FRIEND_FIND_PEOPLE = 34;
    public static final int SUB_FROM_MAYKNOW_FRIEND_FIND_PEOPLE_MORE = 39;
    public static final int SUB_FROM_MAYKNOW_FRIEND_FIND_PEOPLE_SEARCH = 36;
    public static final int SUB_FROM_MAYKNOW_FRIEND_NEW_FRIEND_PAGE = 32;
    public static final int SUB_FROM_MAYKNOW_FRIEND_OTHER = 35;
    public static final int SUB_FROM_MAYKNOW_FRIEND_SEARCH = 33;
    public static final int SUB_FROM_MAYKNOW_FRIEND_SEARCH_MORE = 38;
    public static final int SUB_FROM_MINI_HOME_CONNECT = 43;
    public static final int SUB_FROM_PHONE_LIST_TAB = 53;
    public static final int SUB_FROM_QCIRCLE_OTHER = 42;
    public static final int SUB_FROM_QCIRCLE_PROFILE = 41;
    public static final int SUB_FROM_QQ_TROOP_ACTIVE_MEMBER = 15;
    public static final int SUB_FROM_QQ_TROOP_ADMIN = 16;
    public static final int SUB_FROM_QQ_TROOP_AIO = 11;
    public static final int SUB_FROM_QQ_TROOP_MEMBER = 12;
    public static final int SUB_FROM_QQ_TROOP_OTHER = 14;
    public static final int SUB_FROM_QQ_TROOP_SETTING_MEMBER_LIST = 17;
    public static final int SUB_FROM_QQ_TROOP_TEMP_SESSION = 13;
    public static final int SUB_FROM_QRCODE_SCAN_AIGC = 65;
    public static final int SUB_FROM_QRCODE_SCAN_DRAWER = 64;
    public static final int SUB_FROM_QRCODE_SCAN_NEW = 61;
    public static final int SUB_FROM_QRCODE_SCAN_OLD = 62;
    public static final int SUB_FROM_QRCODE_SCAN_OTHER = 69;
    public static final int SUB_FROM_QRCODE_SCAN_PROFILE = 63;
    public static final int SUB_FROM_QZONE_HOME = 71;
    public static final int SUB_FROM_QZONE_OTHER = 79;
    public static final int SUB_FROM_SEARCH_CONTACT_TAB_MORE_FIND_PROFILE = 83;
    public static final int SUB_FROM_SEARCH_FIND_PROFILE_TAB = 82;
    public static final int SUB_FROM_SEARCH_MESSAGE_TAB_MORE_FIND_PROFILE = 84;
    public static final int SUB_FROM_SEARCH_NEW_FRIEND_MORE_FIND_PROFILE = 85;
    public static final int SUB_FROM_SEARCH_OTHER = 89;
    public static final int SUB_FROM_SEARCH_TAB = 81;
    public static final int SUB_FROM_SETTING_ME_AVATAR = 121;
    public static final int SUB_FROM_SETTING_ME_OTHER = 129;
    public static final int SUB_FROM_SHARE_CARD_C2C = 101;
    public static final int SUB_FROM_SHARE_CARD_OTHER = 109;
    public static final int SUB_FROM_SHARE_CARD_TROOP = 102;
    public static final int SUB_FROM_TYPE_DEFAULT = 0;
    public static final int SUB_FROM_UNITED_SEARCH_FIND_USER_BUTTON = 86;

    public ProfileCardConst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
