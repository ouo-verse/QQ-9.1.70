package com.tencent.qqperf.monitor.dropframe.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IDropFrameMonitor extends QRouteApi {
    public static final String QCIRCLE_ALL_PUSH_TAB_PAGE = "qcircle_all_push_tab_page";
    public static final String QCIRCLE_CHAT_LIST = "qcircle_chat_list";
    public static final String QCIRCLE_COMMENT_PAGE = "qcircle_comment_page";
    public static final String QCIRCLE_CONTENT_PAGE = "qcircle_content_page";
    public static final String QCIRCLE_FOLLOW_TAB_PAGE = "qcircle_follow_tab_page";
    public static final String QCIRCLE_FOLLOW_TAG_LIST = "qcircle_follow_tag_list";
    public static final String QCIRCLE_FOLLOW_USER_LIST = "qcircle_follow_user_list";
    public static final String QCIRCLE_IMMERSIVE_ALL_PUSH_PAGE = "qcircle_immersive_all_push_page";
    public static final String QCIRCLE_IMMERSIVE_COMMENT_LIST = "qcircle_immersive_comment_list";
    public static final String QCIRCLE_IMMERSIVE_FEED_LAYER_PAGE = "qcircle_immersive_feed_layer_page";
    public static final String QCIRCLE_IMMERSIVE_FOLLOW_PAGE = "qcircle_immersive_follow_page";
    public static final String QCIRCLE_IMMERSIVE_LOCATION_POLYMERIZATION_PAGE = "qcircle_immersive_location_polymerization_page";
    public static final String QCIRCLE_IMMERSIVE_MESSAGE_BOX_PAGE = "qcircle_immersive_message_box_page";
    public static final String QCIRCLE_IMMERSIVE_MESSAGE_PAGE = "qcircle_immersive_message_page";
    public static final String QCIRCLE_IMMERSIVE_MUSIC_POLYMERIZATION_PAGE = "qcircle_immersive_music_polymerization_page";
    public static final String QCIRCLE_IMMERSIVE_NEARBY_PAGE = "qcircle_immersive_nearby_page";
    public static final String QCIRCLE_IMMERSIVE_PERSONAGE_PAGE = "qcircle_immersive_personage_page";
    public static final String QCIRCLE_IMMERSIVE_PRIVATE_CHAT_PAGE = "qcircle_immersive_private_chat_page";
    public static final String QCIRCLE_IMMERSIVE_TOPIC_POLYMERIZATION_PAGE = "qcircle_immersive_topic_polymerization_page";
    public static final String QCIRCLE_MESSAGE_NOTICE = "qcircle_message_notice_page";
    public static final String QCIRCLE_PERSONAL_DETAIL_PAGE = "qcircle_personal_detail_page";
    public static final String QCIRCLE_POLYMERIZATION_PAGE = "qcircle_polymerization_page";
    public static final String QCIRCLE_SPECIAL_FOLLOW_LIST = "qcircle_special_follow_list";
    public static final String QCIRCLE_TAG_PAGE = "qcircle_tag_page";
    public static final String QCIRLE_BLACK_LIST_PAGE = "qcircle_black_list";
    public static final String QCIRLE_LIKE_LIST_PAGE = "qcircle_like_page";
    public static final String QQWINK_PHOTO_LIST_ALL_PAGE = "qqwink_photo_list_all_page";
    public static final String QQWINK_PHOTO_LIST_PHOTO_PAGE = "qqwink_photo_list_photo_page";
    public static final String QQWINK_PHOTO_LIST_QZONE_PAGE = "qqwink_photo_list_qzone_page";
    public static final String QQWINK_PHOTO_LIST_VIDEO_PAGE = "qqwink_photo_list_video_page";

    void startMonitorScene(String str);

    void stopMonitorScene(String str, boolean z16);
}
