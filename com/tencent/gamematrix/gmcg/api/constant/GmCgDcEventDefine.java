package com.tencent.gamematrix.gmcg.api.constant;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgDcEventDefine {
    public static final String APP_STATUS_EVENT_APP_ANR = "APP_ANR";
    public static final String APP_STATUS_EVENT_APP_BACK = "APP_BACK";
    public static final String APP_STATUS_EVENT_APP_DEAD = "APP_DEAD";
    public static final String APP_STATUS_EVENT_APP_NOT_TOP = "APP_NOT_TOP";
    public static final String APP_STATUS_EVENT_QQ_POP = "QQ_POP";
    public static final String APP_STATUS_EVENT_WECHAT_POP = "WECHAT_POP";
    public static final String CGSDK_LOGIN_RESPONSE = "CGSDK_LOGIN_RESPONSE";
    public static final String CMD_ANDROID_EVENT = "CMD_ANDROID_EVENT";
    public static final String CMD_APP_LAUNCH_EVENT = "CMD_APP_LAUNCH_EVENT";
    public static final String CMD_APP_LIVE_MONITOR_REQ = "CMD_APP_LIVE_MONITOR_REQ";
    public static final String CMD_APP_STATUS_EVENT = "CMD_APP_STATUS_EVENT";
    public static final String CMD_COMMON_NOTIFY_EVENT = "CMD_COMMON_NOTIFY_EVENT";
    public static final Map<String, String> CMD_FIELD_MAP = new HashMap<String, String>() { // from class: com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine.1
        {
            put(GmCgDcEventDefine.CMD_APP_LIVE_MONITOR_REQ, "monitorAppReq");
            put(GmCgDcEventDefine.CMD_APP_STATUS_EVENT, "appStatus");
            put(GmCgDcEventDefine.CMD_APP_LAUNCH_EVENT, "launchEvent");
            put(GmCgDcEventDefine.CMD_SCENE_CHECK_REQ, "sceneCheckReq");
            put(GmCgDcEventDefine.CMD_SCENE_CHECK_EVENT, "sceneCheckEvent");
            put(GmCgDcEventDefine.CMD_SHARE_EVENT_FROM_GAME, "shareEventFromGame");
            put(GmCgDcEventDefine.CMD_SHARE_RESULT_TO_GAME, "shareResultToGame");
            put(GmCgDcEventDefine.CMD_SWITCH_INFO_LAYER, "switchInfoLayerReq");
            put(GmCgDcEventDefine.CMD_GAME_PLAY_MONITOR_REQ, "gamePlayMonitorReq");
            put(GmCgDcEventDefine.CMD_GAME_PLAY_EVENT, "gamePlayEvent");
            put(GmCgDcEventDefine.CMD_ANDROID_EVENT, "androidEvent");
            put(GmCgDcEventDefine.CMD_COMMON_NOTIFY_EVENT, "commonNotifyEvent");
            put(GmCgDcEventDefine.CMD_MIDAS_PAY_EVENT_FROM_GAME, "midasPayEventFromGame");
            put(GmCgDcEventDefine.CMD_MIDAS_PAY_EVENT_TO_GAME, "midasPayEventToGame");
            put(GmCgDcEventDefine.CMD_MIDAS_PAY_EVENT_ACK, "midasPayEventAck");
            put(GmCgDcEventDefine.CMD_RESTART_GAME, "restartGame");
            put(GmCgDcEventDefine.CMD_LOGIN_REQUEST, "loginRequest");
            put(GmCgDcEventDefine.CMD_GAME_START, "gameStart");
            put(GmCgDcEventDefine.CMD_SCENE_MONITOR, "sceneMonitor");
        }
    };
    public static final String CMD_GAME_PLAY_EVENT = "CMD_GAME_PLAY_EVENT";
    public static final String CMD_GAME_PLAY_MONITOR_REQ = "CMD_GAME_PLAY_MONITOR_REQ";
    public static final String CMD_GAME_START = "CMD_GAME_START";
    public static final String CMD_GAME_TIME_INFORMATION = "CMD_GAME_TIME_INFORMATION";
    public static final String CMD_LOGIN_REQUEST = "CMD_LOGIN_REQUEST";
    public static final String CMD_LOGIN_RESULT = "CMD_LOGIN_RESULT";
    public static final String CMD_MIDAS_PAY_EVENT_ACK = "CMD_MIDAS_PAY_EVENT_ACK";
    public static final String CMD_MIDAS_PAY_EVENT_FROM_GAME = "CMD_MIDAS_PAY_EVENT_FROM_GAME";
    public static final String CMD_MIDAS_PAY_EVENT_TO_GAME = "CMD_MIDAS_PAY_EVENT_TO_GAME";
    public static final String CMD_OBTAIN_MIDAS_CONFIG = "CMD_OBTAIN_MIDAS_CONFIG";
    public static final String CMD_PLAYER_CONNECT = "CMD_PLAYER_CONNECT";
    public static final String CMD_RESTART_GAME = "CMD_RESTART_GAME";
    public static final String CMD_ROOM_ENTER = "CMD_ROOM_ENTER";
    public static final String CMD_SCENE_CHECK_EVENT = "CMD_SCENE_CHECK_EVENT";
    public static final String CMD_SCENE_CHECK_REQ = "CMD_SCENE_CHECK_REQ";
    public static final String CMD_SCENE_MONITOR = "CMD_SCENE_MONITOR";
    public static final String CMD_SCREEN_ROTATE = "CMD_SCREEN_ROTATE";
    public static final String CMD_SHARE_EVENT_FROM_GAME = "CMD_SHARE_EVENT_FROM_GAME";
    public static final String CMD_SHARE_EVENT_INFO_FROM_GAME = "CMD_SHARE_EVENT_INFO_FROM_GAME";
    public static final String CMD_SHARE_RESULT_TO_GAME = "CMD_SHARE_RESULT_TO_GAME";
    public static final String CMD_SWITCH_INFO_LAYER = "CMD_SWITCH_INFO_LAYER";
    public static final String HK_EVENT_CLIENT_NOTIFY = "CGSDK_NOTIFY_CLIENT_EVENT";
    public static final String HK_EVENT_GAME_NOTIFY = "CGSDK_NOTIFY_GAME_EVENT";
    public static final String HK_EVENT_MIDGAME_ABNORMAL = "CG_GAME_EVENT_MIDGAME_ABNORMAL";
    public static final String HK_EVENT_MIDGAME_ACK = "CG_GAME_EVENT_RELIABLE_ACK";
    public static final String HK_EVENT_MIDGAME_BEGIN = "CG_GAME_EVENT_MIDGAME_BEGIN";
    public static final String HK_EVENT_MIDGAME_END = "CG_GAME_EVENT_MIDGAME_END";
}
