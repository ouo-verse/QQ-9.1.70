package com.tencent.mobileqq.vas.vipav.api;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VipFunCallConstants {
    public static final String BUNDLE_KEY_SUB_CMD = "funCallSubCMD";
    public static final String CMD_FUN_CALL_SVR = "FunCallSvr.call";
    public static final long DEFAULT_AV_ID = 0;
    public static final int DOWNLOAD_DONE = 3;
    public static final int DOWNLOAD_PROGRESS = 2;
    public static final int DOWNLOAD_START = 1;
    public static final String FUN_CALL_ID = "fun_call_id";
    public static final String FUN_CALL_SP_FILE = "fun_call_sp_file";
    public static final String KEY_BOO_RESULT = "result_boo";
    public static final String KEY_BUNDLE = "bundle";
    public static final String KEY_DEAL_TYPE = "dealType";
    public static final String KEY_EXISTS = "isExists";
    public static final String KEY_FEET_TYPE = "feeType";
    public static final String KEY_FROM = "from";
    public static final String KEY_GROUP = "group";
    public static final String KEY_GROUP_ONE = "group_";
    public static final String KEY_ID = "callId";
    public static final String KEY_IS_IPC = "isIPC";
    public static final String KEY_LOCAL_VERSION = "local_version";
    public static final String KEY_MSG = "message";
    public static final String KEY_NAME = "name";
    public static final String KEY_PATH = "path";
    public static final String KEY_PROGRESS = "progress";
    public static final String KEY_RESULT = "result";
    public static final String KEY_RES_TYPE = "resourceType";
    public static final String KEY_RING_ID = "ringId";
    public static final String KEY_SRC_TYPE = "srcType";
    public static final String KEY_STATUSE = "fcStatus";
    public static final String KEY_SV_ACTSTR = "svr_actStr";
    public static final String KEY_SV_URL = "svr_url";
    public static final String KEY_TO_UIN = "key_to_uin";
    public static final String KEY_UPDATE_TIME = "update_time";
    public static final String KEY_URL_CALL_THUM = "url_call_thum";
    public static final String KEY_URL_FUZZPIC = "url_Fuzz";
    public static final String KEY_URL_PICTURE = "url_Picture";
    public static final String KEY_URL_RING = "url_Ring";
    public static final String KEY_URL_VIDEO = "url_Video";
    public static final String LAST_FUN_CALL_PLAY_ID = "last_fun_call_play_id";
    public static final int MAX_FUNCALL_RESOURCE_SIZE = 5242880;
    public static final int MM_APPID = 1000277;
    public static final String SEP_GROUP_DATA = ",";
    public static final String SEP_GROUP_UIN = "-";
    public static final String SEP_KEY_RES_URL = "_";
    public static final int SET_DATA_DELET_GROUP = 2;
    public static final int SET_DATA_SAVE_GROUP = 1;
    public static final int SET_DATA_SAVE_NORMAL = 0;
    public static final String SP_KEY_FUN_CALL_BUFF = "key_fun_call_buff";
    public static final String SP_KEY_FUN_CALL_CONF_URL = "key_fun_call_conf_url";
    public static final String SP_KEY_FUN_CALL_INTERV = "key_fun_call_interv";
    public static final String SP_KEY_FUN_CALL_SOUND = "key_fun_call_soundon";
    public static final String SP_KEY_FUN_CALL_VERSION = "key_fun_call_version";
    public static final int SP_TYPE_APP = 0;
    public static final int SP_TYPE_UIN = 1;
    public static final int SUB_CMD_DEL_MY_GROUP_FC = 5;
    public static final int SUB_CMD_GET_FRIEND_FC = 2;
    public static final int SUB_CMD_GET_MY_FC = 1;
    public static final int SUB_CMD_SET_MY_DEFAULT_FC = 3;
    public static final int SUB_CMD_SET_MY_GROUP_FC = 4;
    public static final String TAG = "VipFunCallConstants";
    public static final int TYPE_FUZZPIC = 9;
    public static final int TYPE_OBSERVER_SET = 1;
    public static final int TYPE_PICTURE = 7;
    public static final int TYPE_RING = 3;
    public static final int TYPE_THUMBNAIL = 8;
    public static final int TYPE_VIDEO = 6;
    public static final String UIN_FUN_CALL_ID_CHANGE = "uin_fun_call_id_change";
    public static final int UIN_FUN_CALL_ID_CHANGE_NONE = 0;
    public static final int UIN_FUN_CALL_ID_CHANGE_SET = 2;
    public static final int UIN_FUN_CALL_ID_CHANGE_UPDATE = 1;
    public static final int UIN_RES_ID_NONE = 0;
    public static final String FUNCALL_CONFIG_FILE = VipFunCallUtil.getFunCallPath() + "config.json";
    public static int SETFUNCALL_ERR_ERRID = -3;
    public static int SETFUNCALL_ERR_DISKHASFULL = -6;
    public static int SETFUNCALL_ERR_NOSDCARD = -7;
    public static String FLOW_TYPE = "Vip_FunCall";
    public static JSONObject mConfig = null;
    public static int mResType = -1;
}
