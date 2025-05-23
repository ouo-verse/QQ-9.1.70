package com.tencent.qqlive.tvkplayer.qqliveasset.player.message;

import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKAssetPlayerMsgMap;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKMessageUtil;
import com.tencent.thumbplayer.api.common.TPOnInfoID;

/* loaded from: classes23.dex */
public class TVKQQLiveAssetPlayerMsg {

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 67)
    public static final int PLAYER_INFO_ADAPTIVE_SWITCH_DEFINITION_END = 512;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 68)
    public static final int PLAYER_INFO_ADAPTIVE_SWITCH_DEFINITION_FAILED = 513;
    public static final int PLAYER_INFO_ADAPTIVE_SWITCH_DEFINITION_SET_TO_PLAYER_START = 534;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 66)
    public static final int PLAYER_INFO_ADAPTIVE_SWITCH_DEFINITION_START = 511;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 83)
    public static final int PLAYER_INFO_ADAPTIVE_SWITCH_DEFINITION_SUCCESS = 535;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 80000)
    public static final int PLAYER_INFO_ALL_DOWNLOAD_FINISH = 201;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 203)
    public static final int PLAYER_INFO_AUDIO_DECODER_TYPE = 114;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 22, tpOnInfoID = 201)
    public static final int PLAYER_INFO_BUFFERING_END = 113;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 21, tpOnInfoID = 200)
    public static final int PLAYER_INFO_BUFFERING_START = 112;
    public static final int PLAYER_INFO_CGI_REQUEST = 520;
    public static final int PLAYER_INFO_CGI_RESPONSE = 521;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 153)
    public static final int PLAYER_INFO_CLIP_EOS = 109;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 55, tpOnInfoID = 151)
    public static final int PLAYER_INFO_CURRENT_LOOP_END = 108;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 56, tpOnInfoID = 150)
    public static final int PLAYER_INFO_CURRENT_LOOP_START = 107;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 58)
    public static final int PLAYER_INFO_CURRENT_VID_DOWNLOAD_FIN = 510;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = TPOnInfoID.TP_ONINFO_ID_LONG1_OBJ_DATA_TRANSPORT_INFO)
    public static final int PLAYER_INFO_DATA_TRANSPORT_INFO = 215;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 13)
    public static final int PLAYER_INFO_DESELECT_TRACK_ERROR = 134;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 12)
    public static final int PLAYER_INFO_DESELECT_TRACK_SUCCESS = 133;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 89)
    public static final int PLAYER_INFO_DETECTED_MULTI_NETWORK_CARD_AND_LOW_SPEED = 538;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 27)
    public static final int PLAYER_INFO_DOLBY_DECODE_FAIL = 501;
    public static final int PLAYER_INFO_DOLBY_VISION_SOFT_RENDER = 601;
    public static final int PLAYER_INFO_DOWNLOAD_STATUS_UPDATE = 206;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 34)
    public static final int PLAYER_INFO_END_GET_VINFO = 503;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 36)
    public static final int PLAYER_INFO_FETCH_NEXT_VIDEO_INFO = 505;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 103)
    public static final int PLAYER_INFO_FIRST_AUDIO_DECODER_START = 102;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 63, tpOnInfoID = 105)
    public static final int PLAYER_INFO_FIRST_AUDIO_FRAME_RENDERED = 104;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 101)
    public static final int PLAYER_INFO_FIRST_CLIP_OPENED = 100;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 107)
    public static final int PLAYER_INFO_FIRST_PACKET_READ = 106;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 104)
    public static final int PLAYER_INFO_FIRST_VIDEO_DECODER_START = 103;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 62, tpOnInfoID = 106)
    public static final int PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED = 105;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 95, tpOnInfoID = 602)
    public static final int PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED_AFTER_UPDATE_RENDER_TARGET = 546;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 69)
    public static final int PLAYER_INFO_INTERACTIVE_EOF = 514;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 70)
    public static final int PLAYER_INFO_INTERACTIVE_START = 515;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 50003)
    public static final int PLAYER_INFO_LONG1_IS_USE_PROXY = 210;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 257)
    public static final int PLAYER_INFO_LONG1_MEDIA_LAB_VR_LATENCY_MS = 216;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 261)
    public static final int PLAYER_INFO_LONG2_RENDER_TIMEOUT = 135;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 258)
    public static final int PLAYER_INFO_LONG2_VIDEO_HDR_INFO_CHANGED = 217;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 255)
    public static final int PLAYER_INFO_LONG2_VIDEO_HIGH_FRAME_DROP_RATE_ALERT = 213;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 256)
    public static final int PLAYER_INFO_LONG2_VIDEO_LOW_FRAME_RATE_ALERT = 214;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 38)
    public static final int PLAYER_INFO_LOOP_VIDEO_START = 506;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 500)
    public static final int PLAYER_INFO_MEDIACODEC_VIDEO_CROP = 122;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 90)
    public static final int PLAYER_INFO_MULTI_NETWORK_CARD_STATUS_CHANGE = 539;
    public static final int PLAYER_INFO_NEED_TO_ROTATE_SURFACE = 121;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 35)
    public static final int PLAYER_INFO_NEXT_NET_VINFO = 504;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 84)
    public static final int PLAYER_INFO_OBJECT_AB_TEST_INFO = 212;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 80001)
    public static final int PLAYER_INFO_OBJECT_DOWNLOAD_PROGRESS_UPDATE = 207;
    public static final int PLAYER_INFO_OBJECT_PLAY_CDN_INFO_UPDATE = 204;
    public static final int PLAYER_INFO_OBJECT_VIDEO_METADATA_CHANGED = 136;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 42)
    public static final int PLAYER_INFO_OFFLINE_2_ONLINE = 517;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 39)
    public static final int PLAYER_INFO_OFFLINE_VIDEO_NO_MORE_CACHE = 209;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 79)
    public static final int PLAYER_INFO_ON_RICH_MEDIA_PREPARED = 531;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 80)
    public static final int PLAYER_INFO_ON_RICH_MEDIA_PREPARE_FAILED = 532;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 31, tpOnInfoID = 50002)
    public static final int PLAYER_INFO_PLAYER_TYPE = 124;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 53, tpOnInfoID = 501)
    public static final int PLAYER_INFO_PRIVATE_HLS_TAG = 123;
    public static final int PLAYER_INFO_PROTOCOL_UPDATE = 205;
    public static final int PLAYER_INFO_PROXY_AUTHENTICATION_FAILED = 545;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 94)
    public static final int PLAYER_INFO_QUICK_PLAY_WITH_OFFLINE_RESOURCE = 544;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 77)
    public static final int PLAYER_INFO_REFRESH_PLAYER_END = 529;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 76)
    public static final int PLAYER_INFO_REFRESH_PLAYER_START = 528;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 87)
    public static final int PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_END = 537;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 86)
    public static final int PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_START = 536;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 96)
    public static final int PLAYER_INFO_REQUEST_UPDATE_USER_INFO = 547;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 29)
    public static final int PLAYER_INFO_RETRY_PLAYER = 200;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 47)
    public static final int PLAYER_INFO_RETRY_PLAYER_DONE = 508;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 11)
    public static final int PLAYER_INFO_SELECT_TRACK_ERROR = 130;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 10)
    public static final int PLAYER_INFO_SELECT_TRACK_SUCCESS = 129;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 81)
    public static final int PLAYER_INFO_SET_VIEW_SECURE_FAILED = 533;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 98)
    public static final int PLAYER_INFO_SIMULATED_LIVE_BEGINNING_OF_VID = 549;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 33)
    public static final int PLAYER_INFO_START_GET_VINFO = 502;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 72)
    public static final int PLAYER_INFO_SUBTITLE_FIRST_LOAD = 516;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 65)
    public static final int PLAYER_INFO_SUBTITLE_SEL_END = 128;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 64)
    public static final int PLAYER_INFO_SUBTITLE_SEL_START = 127;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 93)
    public static final int PLAYER_INFO_SURFACE_DESTROYED_ASYNC_RESOURCE_RELEASED = 543;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 60)
    public static final int PLAYER_INFO_SWITCH_AUDIOTRACK_DONE = 126;
    public static final int PLAYER_INFO_SWITCH_AUDIOTRACK_SET_URL_TO_PLAYER_START = 525;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 59)
    public static final int PLAYER_INFO_SWITCH_AUDIOTRACK_USER_SWITCH_START = 524;
    public static final int PLAYER_INFO_SWITCH_DEFINITION_END = 111;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 80002)
    public static final int PLAYER_INFO_SWITCH_DEFINITION_SELF_ADAPTION = 211;
    public static final int PLAYER_INFO_SWITCH_DEFINITION_SET_TO_PLAYER_START = 523;
    public static final int PLAYER_INFO_SWITCH_DEFINITION_START = 522;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 54)
    public static final int PLAYER_INFO_TV_TEST_CDN_URL = 509;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 20, tpOnInfoID = -1)
    public static final int PLAYER_INFO_UNKNOWN = 0;
    public static final int PLAYER_INFO_UPDATE_ADAPTIVE_DEFINITION_STATE = 542;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 88)
    public static final int PLAYER_INFO_VIDEOFX_WARNING = 600;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 204)
    public static final int PLAYER_INFO_VIDEO_DECODER_TYPE = 115;

    @TVKAssetPlayerMsgMap.MapMsgInfo(tpOnInfoID = 102)
    public static final int PLAYER_INFO_VIDEO_KEY_PACKET_READ = 131;

    @TVKAssetPlayerMsgMap.MapMsgInfo(msg = 82, tpOnInfoID = 503)
    public static final int PLAYER_INFO_VIDEO_SEI = 132;

    /* loaded from: classes23.dex */
    public static class TVKAssetPlayerMsgParams {
        public long arg1;
        public long arg2;
        public Object extra;
        public int what;

        public TVKAssetPlayerMsgParams(int i3, long j3, long j16, Object obj) {
            this.what = i3;
            this.arg1 = j3;
            this.arg2 = j16;
            this.extra = obj;
        }
    }

    public static String stringDefine(int i3) {
        return TVKMessageUtil.getMessageName(TVKQQLiveAssetPlayerMsg.class, i3).toLowerCase();
    }
}
