package com.tencent.qqlive.common.report.constant;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqlive/common/report/constant/QQLiveReportConstants;", "", "()V", "AttaColumn", "Code", "Companion", "Event", "Scene", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class QQLiveReportConstants {
    public static final int ATTAID = 11012;

    @NotNull
    public static final String INTENT_TRACE_ID = "key_intent_traceid";

    @NotNull
    public static final String VALUE_APPID = "100036";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqlive/common/report/constant/QQLiveReportConstants$AttaColumn;", "", "()V", "Companion", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class AttaColumn {

        @NotNull
        public static final String APPID = "appid";

        @NotNull
        public static final String ATTACH_INFO = "attach_info";

        @NotNull
        public static final String CLIENT_TIME = "client_time";

        @NotNull
        public static final String DESC_MSG = "desc_msg";

        @NotNull
        public static final String DEVICE_MODEL = "device_model";

        @NotNull
        public static final String DEVICE_OS_VER = "device_os_ver";

        @NotNull
        public static final String EXT1 = "ext1";

        @NotNull
        public static final String EXT10 = "ext10";

        @NotNull
        public static final String EXT11 = "ext11";

        @NotNull
        public static final String EXT12 = "ext12";

        @NotNull
        public static final String EXT13 = "ext13";

        @NotNull
        public static final String EXT14 = "ext14";

        @NotNull
        public static final String EXT15 = "ext15";

        @NotNull
        public static final String EXT16 = "ext16";

        @NotNull
        public static final String EXT17 = "ext17";

        @NotNull
        public static final String EXT18 = "ext18";

        @NotNull
        public static final String EXT19 = "ext19";

        @NotNull
        public static final String EXT2 = "ext2";

        @NotNull
        public static final String EXT3 = "ext3";

        @NotNull
        public static final String EXT4 = "ext4";

        @NotNull
        public static final String EXT5 = "ext5";

        @NotNull
        public static final String EXT6 = "ext6";

        @NotNull
        public static final String EXT7 = "ext7";

        @NotNull
        public static final String EXT8 = "ext8";

        @NotNull
        public static final String EXT9 = "ext9";

        @NotNull
        public static final String INDEX = "index";

        @NotNull
        public static final String JSON_EXT = "json_ext";

        @NotNull
        public static final String KEY_EVENT_ID = "event_id";

        @NotNull
        public static final String KEY_HOST_UIN = "host_uin";

        @NotNull
        public static final String KEY_QUA = "qua";

        @NotNull
        public static final String KEY_RET_CODE = "ret_code";

        @NotNull
        public static final String LIVE_APPID = "live_appid";

        @NotNull
        public static final String NETWORK_TYPE = "network_type";

        @NotNull
        public static final String TRACEID = "traceid";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqlive/common/report/constant/QQLiveReportConstants$Code;", "", "()V", "Companion", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class Code {

        @NotNull
        public static final String RESULT_FAIL = "-1";
        public static final long RESULT_FAIL_LONG = -1;

        @NotNull
        public static final String RESULT_OK = "0";
        public static final long RESULT_OK_LONG = 0;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqlive/common/report/constant/QQLiveReportConstants$Event;", "", "()V", "Companion", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class Event {

        @NotNull
        public static final String E_ANCHOR_CHANGE_PUSH_ENCODE_PARAMS = "E_ANCHOR_CHANGE_PUSH_ENCODE_PARAMS";

        @NotNull
        public static final String E_ANCHOR_EXIT_ROOM_RESULT = "E_ANCHOR_EXIT_ROOM_RESULT";

        @NotNull
        public static final String E_ANCHOR_HEARTBEAT_FAILED = "E_ANCHOR_HEARTBEAT_FAILED";

        @NotNull
        public static final String E_ANCHOR_LIVE_ROOM_PREPARED = "E_ANCHOR_LIVE_ROOM_PREPARED";

        @NotNull
        public static final String E_ANCHOR_PUBLISH_STREAM = "E_ANCHOR_PUBLISH_STREAM";

        @NotNull
        public static final String E_ANCHOR_RECONNECT_OBS_ROOM = "E_ANCHOR_RECONNECT_OBS_ROOM";

        @NotNull
        public static final String E_ANCHOR_ROOM_PERFORMANCE = "E_ANCHOR_ROOM_PERFORMANCE";

        @NotNull
        public static final String E_ANCHOR_START_PUSH_ENCODE_PARAMS = "E_ANCHOR_START_PUSH_ENCODE_PARAMS";

        @NotNull
        public static final String E_AUDIENCE_GIFTCOMBO_RESOURCE_INVALID = "E_AUDIENCE_GIFTCOMBO_RESOURCE_INVALID";

        @NotNull
        public static final String E_AUDIENCE_ON_BACKGROUND = "E_AUDIENCE_ON_BACKGROUND";

        @NotNull
        public static final String E_AUDIENCE_ON_FOREGROUND = "E_AUDIENCE_ON_FOREGROUND";

        @NotNull
        public static final String E_AUDIENCE_PLAYER_ERROR = "E_AUDIENCE_PLAYER_ERROR";

        @NotNull
        public static final String E_AUDIENCE_PLAYER_PREPARE = "E_AUDIENCE_PLAYER_PREPARE";

        @NotNull
        public static final String E_BEFORE_START_LIVE_FAIL_REASON = "E_BEFORE_START_LIVE_FAIL_REASON";

        @NotNull
        public static final String E_BEGIN_START_LIVE = "E_BEGIN_START_LIVE";

        @NotNull
        public static final String E_ENTER_ROOM_BREAK = "E_ENTER_ROOM_BREAK";

        @NotNull
        public static final String E_ENTER_ROOM_CLICKED = "E_ENTER_ROOM_CLICKED";

        @NotNull
        public static final String E_ENTER_ROOM_FIRST_FRAME_PULLED = "E_ENTER_ROOM_FIRST_FRAME_PULLED";

        @NotNull
        public static final String E_ENTER_ROOM_PAGE_IN = "E_ENTER_ROOM_PAGE_IN";

        @NotNull
        public static final String E_ENTER_ROOM_STEP = "E_ENTER_ROOM_STEP";

        @NotNull
        public static final String E_EXIT_LIVE = "E_EXIT_LIVE";

        @NotNull
        public static final String E_JUMP_INTO_ANCHOR_LIVE_PREPARE_ROOM = "E_JUMP_INTO_ANCHOR_LIVE_PREPARE_ROOM";

        @NotNull
        public static final String E_JUMP_INTO_QQ_LIVE_PREPARE_ROOM = "E_JUMP_INTO_QQ_LIVE_PREPARE_ROOM";

        @NotNull
        public static final String E_JUMP_INTO_RTMP_PREPARE_ROOM = "E_JUMP_INTO_RTMP_PREPARE_ROOM";

        @NotNull
        public static final String E_JUMP_INTO_STUDY_MODE = "E_JUMP_INTO_STUDY_MODE";

        @NotNull
        public static final String E_LOGIN = "E_LOGIN";

        @NotNull
        public static final String E_MONITOR_LOG_REPORT = "E_MONITOR_LOG_REPORT";

        @NotNull
        public static final String E_ON_TRIM_MEMORY = "E_ON_TRIM_MEMORY";

        @NotNull
        public static final String E_PRELOAD_PROCESS = "E_PRELOAD_PROCESS";

        @NotNull
        public static final String E_PRE_EXIT_PROCESS = "E_PRE_EXIT_PROCESS";

        @NotNull
        public static final String E_QQ_LIVE_AV_BLOCK = "E_QQ_LIVE_AV_BLOCK";

        @NotNull
        public static final String E_QQ_LIVE_END_BUFFER = "E_QQ_LIVE_END_BUFFER";

        @NotNull
        public static final String E_QQ_LIVE_END_PLAY = "E_QQ_LIVE_END_PLAY";

        @NotNull
        public static final String E_QQ_LIVE_ROOM_PREPARED = "E_QQ_LIVE_ROOM_PREPARED";

        @NotNull
        public static final String E_QQ_LIVE_SHOW_SWITCH_DEFINITION_TIPS = "E_QQ_LIVE_SHOW_SWITCH_DEFINITION_TIPS";

        @NotNull
        public static final String E_START_LIVE_PERMISSION_CHECKED = "E_START_LIVE_PERMISSION_CHECKED";

        @NotNull
        public static final String E_START_LIVE_SCREEN_CAPTURE_STARTED = "E_START_LIVE_SCREEN_CAPTURE_STARTED";

        @NotNull
        public static final String E_START_UPLOAD_COVER = "E_START_UPLOAD_COVER";

        @NotNull
        public static final String E_SUCCESS_START_LIVE = "E_SUCCESS_START_LIVE";

        @NotNull
        public static final String E_SUCCESS_UPLOAD_COVER = "E_SUCCESS_UPLOAD_COVER";

        @NotNull
        public static final String P_QQ_LIVE_ALL_COST = "P_QQ_LIVE_ALL_COST";

        @NotNull
        public static final String T_CATCH_IMPORTANT_INFO = "T_CATCH_IMPORTANT_INFO";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqlive/common/report/constant/QQLiveReportConstants$Scene;", "", "()V", "Companion", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class Scene {

        @NotNull
        public static final String SCENE_EFFECT_GIFT_COMBO = "SCENE_EFFECT_GIFT_COMBO";

        @NotNull
        public static final String SCENE_EXCEPTION_ANCHOR_RECORD = "SCENE_EXCEPTION_ANCHOR_RECORD";

        @NotNull
        public static final String SCENE_LIVE_HALL_ENTRANCE = "SCENE_LIVE_HALL_ENTRANCE";

        @NotNull
        public static final String SCENE_QFS_FEED_ENTRANCE = "SCENE_QFS_FEED_ENTRANCE";

        @NotNull
        public static final String SCENE_QFS_FOLLOW_ENTRANCE = "SCENE_QFS_FOLLOW_ENTRANCE";

        @NotNull
        public static final String SCENE_QFS_TAB_ENTRANCE = "SCENE_QFS_TAB_ENTRANCE";

        @NotNull
        public static final String SCENE_QUICK_GIFT_COMBO = "SCENE_QUICK_GIFT_COMBO";

        @NotNull
        public static final String SCENE_START_ANCHOR_LIVE = "SCENE_START_ANCHOR_LIVE";

        @NotNull
        public static final String SCENE_START_QQ_LIVE = "SCENE_START_QQ_LIVE";

        @NotNull
        public static final String SCENE_START_RTMP_LIVE = "SCENE_START_RTMP_LIVE";

        @NotNull
        public static final String SCENE_TEST = "SCENE_TEST";

        @NotNull
        public static final String SCENE_USE_REMOTE_PLAYER = "SCENE_USE_REMOTE_PLAYER";
    }
}
