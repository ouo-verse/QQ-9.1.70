package com.tencent.mobileqq.qwallet;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletPreferenceApi extends QRouteApi {
    public static final String KEY_BIRTHDAY_HB = "birthdayHB";
    public static final String KEY_BIRTHDAY_HB_INVALID_SPACE = "birthdayHB_invalidSpace_";
    public static final String KEY_BIRTHDAY_HB_SKIN_LIST = "birthdayHB_skinList_";
    public static final String KEY_BIRTHDAY_HB_SKIN_LIST_PRE_ARC_COLOR = "preArcColor";
    public static final String KEY_BIRTHDAY_HB_THEME_LIST = "birthdayHB_themeList_";
    public static final String KEY_BIRTHDAY_HB_WISH_MAX_LEN = "birthdayHB_wishMaxLen_";
    public static final String KEY_BIRTHDAY_HB_WISH_PLACEHOLDER = "birthdayHB_wishPlaceholder_";
    public static final String KEY_F2F_REDPACK_ENTRY = "F2FRedpackEntry";
    public static final String KEY_HB_SKIN_ATLAS_ENTRY = "skinAtlasEntry";
    public static final String KEY_HB_SKIN_ATLAS_ENTRY_NAME = "skinAtlasEntry_name";
    public static final String KEY_HB_SKIN_ATLAS_ENTRY_URL = "skinAtlasEntry_url";
    public static final String KEY_HB_SKIN_ATLAS_NAME = "name";
    public static final String KEY_HB_SKIN_ATLAS_URL = "url";
    public static final String KEY_HB_ZPALN = "zplanHBEntry";
    public static final String KEY_HB_ZPALN_ICON_URL = "zplanHBEntry_bgURL";
    public static final String KEY_HB_ZPALN_NAME = "zplanHBEntry_name";
    public static final String KEY_HB_ZPALN_SUPPORT_SHARPP = "zplanHBEntry_supportSharpP";
    public static final String KEY_ICON_URL = "bgURL";
    public static final String KEY_INVALID_SPACE = "invalidSpace";
    public static final String KEY_NAME = "name";
    public static final String KEY_REDPACK_POPWND_BEGIN_TIME = "redpack_popwnd_begin_time_";
    public static final String KEY_REDPACK_POPWND_CURRENT = "redpack_popwnd_current_";
    public static final String KEY_REDPACK_POPWND_END_TIME = "redpack_popwnd_end_time_";
    public static final String KEY_REDPACK_POPWND_FREQ = "redpack_popwnd_freq_";
    public static final String KEY_REDPACK_POPWND_GROUP_TYPE = "redpack_popwnd_group_type_";
    public static final String KEY_REDPACK_POPWND_ID = "redpack_popwnd_id";
    public static final String KEY_REDPACK_POPWND_LAST_SHOW_TIME = "redpack_popwnd_last_show_time_";
    public static final String KEY_REDPACK_POPWND_NETWORK = "redpack_popwnd_network_";
    public static final String KEY_REDPACK_POPWND_STATE = "redpack_popwnd_state_";
    public static final String KEY_REDPACK_POPWND_TOTAL = "redpack_popwnd_total_";
    public static final String KEY_REDPACK_POPWND_URL = "redpack_popwnd_url_";
    public static final String KEY_SKIN_ENRTY_ERROR_TIPS = "skin_entry_error_tips";
    public static final String KEY_SKIN_LIST = "skinList";
    public static final String KEY_STRANGER_CHAT_EXT = "strangerchat_ext";
    public static final String KEY_SUPPORT_SHARPP = "supportSharpP";
    public static final String KEY_THEME_LIST = "themeList";
    public static final String KEY_TITLE = "title";
    public static final String KEY_WALLET_APPLIST_CONFIG = "qqwallet_entry_applist_config";
    public static final String KEY_WALLET_APPLIST_CONFIG_NUM_COLS = "num_cols";
    public static final String KEY_WALLET_PUB_MSG_TAIL = "walletPubMsgTail";
    public static final String KEY_WALLET_PUB_MSG_TAIL_BUSI_TYPE = "walletPubMsgTail_busiType";
    public static final String KEY_WALLET_PUB_MSG_TAIL_IMG_URL = "walletPubMsgTail_imgURL";
    public static final String KEY_WALLET_PUB_MSG_TAIL_JUMP_URL = "walletPubMsgTail_jumpURL";
    public static final String KEY_WALLET_PUB_MSG_TAIL_TITLE = "walletPubMsgTail_title";
    public static final String KEY_WISH_MAX_LEN = "wishMaxLen";
    public static final String KEY_WISH_PLACEHOLDER = "wishPlaceholder";

    void clearSp(String str);

    boolean getBoolean(String str, String str2, String str3, boolean z16);

    boolean getBoolean(String str, String str2, boolean z16);

    boolean getBooleanFromSp(String str, String str2, boolean z16);

    int getInt(String str, int i3);

    int getInt(String str, String str2, int i3);

    int getIntFromSp(String str, String str2, int i3);

    long getLong(String str, String str2, long j3);

    long getLongFromSp(String str, String str2, long j3);

    String getString(String str, String str2, String str3);

    String getStringFromSp(String str, String str2, String str3);

    boolean isShowF2FRedpackEntryColor(String str);

    void putBoolean(String str, String str2, String str3, boolean z16);

    void putBoolean(String str, String str2, boolean z16);

    void putBooleanToSp(String str, String str2, boolean z16);

    void putInt(String str, int i3);

    void putInt(String str, String str2, int i3);

    void putIntToSp(String str, String str2, int i3);

    void putLong(String str, String str2, long j3);

    void putLongToSp(String str, String str2, long j3);

    void putString(String str, String str2, String str3);

    void putStringToSp(String str, String str2, String str3);

    void removeSp(String str, String str2);
}
