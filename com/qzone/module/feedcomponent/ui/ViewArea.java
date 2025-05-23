package com.qzone.module.feedcomponent.ui;

import com.qzone.proxy.feedcomponent.text.TextCell;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface ViewArea {
    public static final int ADV_STYLE_2 = 66;
    public static final int MORE_FRIENDS_AVATAR_AREA = 55;
    public static final int MORE_RECOMMEND_FRIENDS_LIST_ITEM_AREA = 54;
    public static final int RECOMMEND_FRIENDS_AVATAR_AREA = 48;
    public static final int RECOMMEND_FRIENDS_DESCRIPTION_AREA = 50;
    public static final int RECOMMEND_FRIENDS_LIST_ITEM_AREA = 53;
    public static final int RECOMMEND_FRIENDS_NICKNAME_AREA = 49;
    public static final int RECOMMEND_FRIENDS_STATEIMAGE_AREA = 51;
    public static final int RECOMMEND_FRIENDS_STATETEXT_AREA = 52;
    public static final int RECOMMEND_HEADER_MORE_RECOMMEND_FRIENDS_TEXT_AREA = 47;
    public static final int TYPE_ACTION_AREA = 4;
    public static final int TYPE_ACTIVEADC_TITLE = 40;
    public static final int TYPE_ADD_FRIEND = 67;
    public static final int TYPE_ATTENTION_AREA = 63;
    public static final int TYPE_AVATAR = 17;
    public static final int TYPE_AVATAR_DECORATION_AREA = 48;
    public static final int TYPE_BIZ_SUMMARY = 60;
    public static final int TYPE_BULLET = 37;
    public static final int TYPE_BUTTON = 23;
    public static final int TYPE_CAMPUS_CONTENT = 83;
    public static final int TYPE_CANFOLLOW_ICON_AREA = 51;
    public static final int TYPE_COMMENT = 1;
    public static final int TYPE_COMMENTCOUNT_AREA = 78;
    public static final int TYPE_COMMON_LINE_AREA = 58;
    public static final int TYPE_DELETE_BUTTON = 18;
    public static final int TYPE_DROPDOWN_BUTTON = 59;
    public static final int TYPE_DROPDOWN_BUTTON_AND_TEXT = 60;
    public static final int TYPE_DYNAMIC_ALBUM_PIC = 57;
    public static final int TYPE_EVENT_TAG_AREA = 79;
    public static final int TYPE_FAMOUS_ICON_AREA = 47;
    public static final int TYPE_FORWARD_LIST = 76;
    public static final int TYPE_FRIENDBIRTHDAY_CLOSE_BUTTON = 70;
    public static final int TYPE_HABITED_AREA = 35;
    public static final int TYPE_HABITED_AREA_RIGHT = 61;
    public static final int TYPE_HIGH_FIVE_CLICKED_BUTTON = 85;
    public static final int TYPE_HIGH_FIVE_NORMAL_BUTTON = 84;
    public static final int TYPE_LBS_AREA = 64;
    public static final int TYPE_LEFT_THUMB_PIC = 26;
    public static final int TYPE_LEFT_THUMB_SUMMARY = 9;
    public static final int TYPE_LEFT_THUMB_TITLE = 8;
    public static final int TYPE_LIKE_FRIEND_CONTAINER_TITLE_PLAY_COUNT = 49;
    public static final int TYPE_LIVEMEDAL_AREA = 77;
    public static final int TYPE_LOCAL_AD_TITLE_AREA_INFO = 50;
    public static final int TYPE_LOCATION_AREA = 62;
    public static final int TYPE_LOVERZONE_AREA = 46;
    public static final int TYPE_MULTI_PIC = 21;
    public static final int TYPE_NICKNAME = 16;
    public static final int TYPE_NON_CLICKABLE = 0;
    public static final int TYPE_NORMAL_PICTURE_INFO = 7;
    public static final int TYPE_NORMAL_SUMMARY = 6;
    public static final int TYPE_NORMAL_TITLE = 5;
    public static final int TYPE_NO_PIC = 38;
    public static final int TYPE_PASSIVE_ACTION = 22;
    public static final int TYPE_PASSIVE_LIKE_LIST = 28;
    public static final int TYPE_PERMISSION = 15;
    public static final int TYPE_PIC = 3;
    public static final int TYPE_PLAY_BAR_USER = 33;
    public static final int TYPE_PLAY_DESC = 34;
    public static final int TYPE_PLAY_GAME_NAME = 32;
    public static final int TYPE_PLAY_PIC = 31;
    public static final int TYPE_PRAISE_AVATARS = 36;
    public static final int TYPE_PRAISE_LIST = 25;
    public static final int TYPE_QBOSS_PSV_ADV_BUTTON = 73;
    public static final int TYPE_QBOSS_PSV_ADV_COUNTDOWN = 74;
    public static final int TYPE_QBOSS_PSV_ADV_DELETE = 75;
    public static final int TYPE_QBOSS_PSV_ADV_SUMMARY = 72;
    public static final int TYPE_QBOSS_PSV_ADV_TITLE = 71;
    public static final int TYPE_RAPID_COMMENT_IMMEDIATELY_AREA = 41;
    public static final int TYPE_RECOMMEND_FOLLOW_VERTICAL = 82;
    public static final int TYPE_RECOMM_CORNER = 19;
    public static final int TYPE_RECOMM_SUMMARY = 24;
    public static final int TYPE_RECOM_AREA = 45;
    public static final int TYPE_REDPOCKET_LIST = 65;
    public static final int TYPE_REFER = 12;
    public static final int TYPE_REMARK = 10;
    public static final int TYPE_REPLY = 2;
    public static final int TYPE_REPLY_MORE = 27;
    public static final int TYPE_SHOOT_INFO = 11;
    public static final int TYPE_SINGLE_PIC = 20;
    public static final int TYPE_SPACEREDPOCKET_LIST = 68;
    public static final int TYPE_SPACEREDPOCKET_PIC_INFO = 69;
    public static final int TYPE_STANDALONE_AREA = 39;
    public static final int TYPE_STAR_VIP_AREA = 44;
    public static final int TYPE_STATE = 14;
    public static final int TYPE_SUPER_LIKE = 42;
    public static final int TYPE_TEMPLATE_SHUOSHUO_AREA = 80;
    public static final int TYPE_THEME_ALBUM_PIC = 56;
    public static final int TYPE_TIME_LBS = 13;
    public static final int TYPE_TODAY_IN_HISTORY = 29;
    public static final int TYPE_VIDEO_ORIGINAL_AREA = 81;
    public static final int TYPE_VISIT_LIST = 30;
    public static final int TYPE_VISIT_RETURN = 86;
    public static final int TYPE_YELLOW_VIP_AREA = 43;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnAreaClickedListener {
        void onAreaClicked(ViewArea viewArea, TextCell textCell);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnAreaLongClickedListener {
        void onLongClicked(ViewArea viewArea);
    }

    void clearTouchingEvent();

    Object getData();

    int getHeight();

    int getType();

    int getWidth();

    void measure(int i3, int i16);

    void setMaxWidth(int i3);
}
