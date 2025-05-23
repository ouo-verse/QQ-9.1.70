package com.tencent.mobileqq.gamecenter.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.mobileqq.gamecenter.data.GameInfo;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b-\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003CDEB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0019X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0019X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0019X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0019X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/IYunGameConstant;", "", "()V", "CMD_CHANGE_CLARITY", "", "CMD_ERROR", "CMD_EXIT_BACKGROUND", "CMD_GAMEACTIVITY_ONPAUSE", "CMD_GAMEACTIVITY_ONRESUME", "CMD_GAMEACTIVITY_ONSTART", "CMD_GAMEACTIVITY_ONSTOP", "CMD_GAME_DESTORY", "CMD_GAME_STATUS_CHANGE", "CMD_GET_GAME_TOGGLE", "CMD_NOTIFY_USER_FEEDBACK", "CMD_OPEN_MENU", "CMD_PUSH", GmCgDcEventDefine.CMD_RESTART_GAME, "CMD_SERVICE_START", "CMD_SHOW_TIPS", "CMD_START_GAME", "CMD_STOP_GAME", "CMD_USER_DESTORY", "FILE_COMMON", "FROM_SERVICE_START", "", "GAME_ACTIVITY_STATUS_NONE", "GAME_ACTIVITY_STATUS_RESUME", "GAME_CENTER_DOMAIN", "HEART_BEAT_INTERVAL", "HEART_BEAT_TIME_OUT", "IPC_NAME", "KEY_AUTH_ID", "KEY_AUTH_KEY", "KEY_CLARITY", "KEY_CMD", "KEY_GAME_INFO", "KEY_OAID_CFG", "KEY_PARAM_APPID", "KEY_PARAM_CALLBACK_ID", "KEY_PARAM_CMD", "KEY_PARAM_DATA", "KEY_PARAM_GAME_ID", "KEY_PARAM_MSG", "KEY_PARAM_QUEUE_INFO", "KEY_PARAM_RET", "KEY_PARAM_URL", "KEY_PUSH_DATA", "KEY_QUALITY_CFG", "KEY_SCREEN_CFG", "KEY_TOGGLE_ALLOW", "KEY_TOGGLE_URL", "KEY_USER_ID", "KEY_YUNGAME_ENV_CFG", "MIDAS_FLATFORM_TYPE", "MIDAS_OFFER_ID", "MIDAS_PLATFORM_ID", "MODULE_ID", "PLUGIN_PROCESS_NAME", "SERVICES_RESTART_COUNT", "SERVICE_LOGIN_TIME_OUT", "SERVICE_NAME", "START_SERVICE_DELAY_TIME", "START_SERVICE_DELAY_TIME_DEBUG", "SUB_MODULE", "YUN_GAME_BROADCAST_CLIENT_ACTION", "YUN_GAME_BROADCAST_SERVICE_ACTION", "GameStatusInfo", "PluginsStatus", "ResultCode", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class IYunGameConstant {

    @NotNull
    public static final String CMD_CHANGE_CLARITY = "cmd_change_clarity";

    @NotNull
    public static final String CMD_ERROR = "cmd_error";

    @NotNull
    public static final String CMD_EXIT_BACKGROUND = "cmd_exit_background";

    @NotNull
    public static final String CMD_GAMEACTIVITY_ONPAUSE = "cmd_game_activity_onPause";

    @NotNull
    public static final String CMD_GAMEACTIVITY_ONRESUME = "cmd_game_activity_onResume";

    @NotNull
    public static final String CMD_GAMEACTIVITY_ONSTART = "cmd_game_activity_onStart";

    @NotNull
    public static final String CMD_GAMEACTIVITY_ONSTOP = "cmd_game_activity_onStop";

    @NotNull
    public static final String CMD_GAME_DESTORY = "cmd_game_destory";

    @NotNull
    public static final String CMD_GAME_STATUS_CHANGE = "cmd_game_status_change";

    @NotNull
    public static final String CMD_GET_GAME_TOGGLE = "cmd_get_game_toggle";

    @NotNull
    public static final String CMD_NOTIFY_USER_FEEDBACK = "cmd_notify_user_feedback";

    @NotNull
    public static final String CMD_OPEN_MENU = "cmd_open_menu";

    @NotNull
    public static final String CMD_PUSH = "cmd_push";

    @NotNull
    public static final String CMD_RESTART_GAME = "cmd_restart_game";

    @NotNull
    public static final String CMD_SERVICE_START = "cmd_service_start";

    @NotNull
    public static final String CMD_SHOW_TIPS = "cmd_show_tips";

    @NotNull
    public static final String CMD_START_GAME = "cmd_start_game";

    @NotNull
    public static final String CMD_STOP_GAME = "cmd_stop_game";

    @NotNull
    public static final String CMD_USER_DESTORY = "cmd_user_destory";

    @NotNull
    public static final String FILE_COMMON = "common_mmkv_configurations";
    private static final int FROM_SERVICE_START = 3;
    public static final int GAME_ACTIVITY_STATUS_NONE = 0;
    public static final int GAME_ACTIVITY_STATUS_RESUME = 1;

    @NotNull
    public static final String GAME_CENTER_DOMAIN = "gamecenter.qq.com";
    public static final int HEART_BEAT_INTERVAL = 3000;
    public static final int HEART_BEAT_TIME_OUT = 6000;

    @NotNull
    public static final IYunGameConstant INSTANCE = new IYunGameConstant();

    @NotNull
    public static final String IPC_NAME = "YUNGAME_IPC";

    @NotNull
    public static final String KEY_AUTH_ID = "key_auth_id";

    @NotNull
    public static final String KEY_AUTH_KEY = "key_auth_key";

    @NotNull
    public static final String KEY_CLARITY = "key_clarity";

    @NotNull
    public static final String KEY_CMD = "key_cmd";

    @NotNull
    public static final String KEY_GAME_INFO = "key_game_info";

    @NotNull
    public static final String KEY_OAID_CFG = "key_oaid_cfg";

    @NotNull
    public static final String KEY_PARAM_APPID = "key_param_appId";

    @NotNull
    public static final String KEY_PARAM_CALLBACK_ID = "key_callback_id";

    @NotNull
    public static final String KEY_PARAM_CMD = "key_cmd";

    @NotNull
    public static final String KEY_PARAM_DATA = "key_data";

    @NotNull
    public static final String KEY_PARAM_GAME_ID = "key_game_id";

    @NotNull
    public static final String KEY_PARAM_MSG = "key_param_msg";

    @NotNull
    public static final String KEY_PARAM_QUEUE_INFO = "key_param_queue_info";

    @NotNull
    public static final String KEY_PARAM_RET = "key_param_ret";

    @NotNull
    public static final String KEY_PARAM_URL = "key_param_url";

    @NotNull
    public static final String KEY_PUSH_DATA = "key_push_data";

    @NotNull
    public static final String KEY_QUALITY_CFG = "key_quality_cfg";

    @NotNull
    public static final String KEY_SCREEN_CFG = "key_screen_cfg";

    @NotNull
    public static final String KEY_TOGGLE_ALLOW = "key_toggle_allow";

    @NotNull
    public static final String KEY_TOGGLE_URL = "key_toggle_url";

    @NotNull
    public static final String KEY_USER_ID = "key_user_id";

    @NotNull
    public static final String KEY_YUNGAME_ENV_CFG = "key_yungame_env_config";

    @NotNull
    public static final String MIDAS_FLATFORM_TYPE = "PHONE";

    @NotNull
    public static final String MIDAS_OFFER_ID = "1450023385";

    @NotNull
    public static final String MIDAS_PLATFORM_ID = "qqcloudgame";

    @NotNull
    public static final String MODULE_ID = "yungame.apk";

    @NotNull
    public static final String PLUGIN_PROCESS_NAME = "com.tencent.mobileqq:plugins";
    public static final int SERVICES_RESTART_COUNT = 3;
    public static final int SERVICE_LOGIN_TIME_OUT = 5000;

    @NotNull
    public static final String SERVICE_NAME = "com.tencent.mobileqq.yungame.YunGameService";
    public static final int START_SERVICE_DELAY_TIME = 5000;
    public static final int START_SERVICE_DELAY_TIME_DEBUG = 15000;

    @NotNull
    public static final String SUB_MODULE = "yungame-plugin";

    @NotNull
    public static final String YUN_GAME_BROADCAST_CLIENT_ACTION = "com.tencent.mobileqq.shadow.yungame.client.broadcast_action";

    @NotNull
    public static final String YUN_GAME_BROADCAST_SERVICE_ACTION = "com.tencent.mobileqq.shadow.yungame.service.broadcast_action";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/IYunGameConstant$PluginsStatus;", "", "()V", "INSTALLED", "", "NOT_INSTALLED", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class PluginsStatus {
        public static final int INSTALLED = 0;

        @NotNull
        public static final PluginsStatus INSTANCE = new PluginsStatus();
        public static final int NOT_INSTALLED = -1;

        PluginsStatus() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/IYunGameConstant$ResultCode;", "", "()V", "RESULT_ALLOCATE_DEVICE", "", "RESULT_ALLOCATOR_FAILED", "RESULT_GAME_ERR", "RESULT_GAME_EXIST", "RESULT_GET_AUTH_FAILED", "RESULT_LOGIN_FAILED", "RESULT_NOT_INSTALL_PLUGIN", "RESULT_NO_GAME", "RESULT_OK", "RESULT_PARAM_ERR", "RESULT_QUEUEING", "RESULT_QUEUE_FAILED", "RESULT_RUNNING", "RESULT_START_SERVICE_FAILED", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class ResultCode {

        @NotNull
        public static final ResultCode INSTANCE = new ResultCode();
        public static final int RESULT_ALLOCATE_DEVICE = 3;
        public static final int RESULT_ALLOCATOR_FAILED = -3;
        public static final int RESULT_GAME_ERR = -10;
        public static final int RESULT_GAME_EXIST = -6;
        public static final int RESULT_GET_AUTH_FAILED = -1;
        public static final int RESULT_LOGIN_FAILED = -2;
        public static final int RESULT_NOT_INSTALL_PLUGIN = -9;
        public static final int RESULT_NO_GAME = -8;
        public static final int RESULT_OK = 0;
        public static final int RESULT_PARAM_ERR = -5;
        public static final int RESULT_QUEUEING = 2;
        public static final int RESULT_QUEUE_FAILED = -7;
        public static final int RESULT_RUNNING = 1;
        public static final int RESULT_START_SERVICE_FAILED = -4;

        ResultCode() {
        }
    }

    IYunGameConstant() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010$\u001a\u00020\rH\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/IYunGameConstant$GameStatusInfo;", "Landroid/os/Parcelable;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "gameInfo", "Lcom/tencent/mobileqq/gamecenter/data/GameInfo;", "getGameInfo", "()Lcom/tencent/mobileqq/gamecenter/data/GameInfo;", "setGameInfo", "(Lcom/tencent/mobileqq/gamecenter/data/GameInfo;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "msg", "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "startQueueTime", "", "getStartQueueTime", "()J", "setStartQueueTime", "(J)V", "status", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "setStatus", "total", "getTotal", "setTotal", "describeContents", "writeToParcel", "", "dest", WadlProxyConsts.FLAGS, "CREATOR", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class GameStatusInfo implements Parcelable {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @Nullable
        private GameInfo gameInfo;
        private int index;

        @Nullable
        private String msg;
        private long startQueueTime;
        private int status;
        private int total;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/IYunGameConstant$GameStatusInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/gamecenter/api/IYunGameConstant$GameStatusInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mobileqq/gamecenter/api/IYunGameConstant$GameStatusInfo;", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.gamecenter.api.IYunGameConstant$GameStatusInfo$CREATOR, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
        public static final class Companion implements Parcelable.Creator<GameStatusInfo> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public GameStatusInfo createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new GameStatusInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public GameStatusInfo[] newArray(int size) {
                return new GameStatusInfo[size];
            }
        }

        public GameStatusInfo() {
            this.msg = "";
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public GameInfo getGameInfo() {
            return this.gameInfo;
        }

        public int getIndex() {
            return this.index;
        }

        @Nullable
        public String getMsg() {
            return this.msg;
        }

        public long getStartQueueTime() {
            return this.startQueueTime;
        }

        public int getStatus() {
            return this.status;
        }

        public int getTotal() {
            return this.total;
        }

        public void setGameInfo(@Nullable GameInfo gameInfo) {
            this.gameInfo = gameInfo;
        }

        public void setIndex(int i3) {
            this.index = i3;
        }

        public void setMsg(@Nullable String str) {
            this.msg = str;
        }

        public void setStartQueueTime(long j3) {
            this.startQueueTime = j3;
        }

        public void setStatus(int i3) {
            this.status = i3;
        }

        public void setTotal(int i3) {
            this.total = i3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(getStatus());
            dest.writeInt(getIndex());
            dest.writeInt(getTotal());
            dest.writeString(getMsg());
            dest.writeLong(getStartQueueTime());
            dest.writeParcelable(getGameInfo(), flags);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public GameStatusInfo(@NotNull Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            setStatus(parcel.readInt());
            setIndex(parcel.readInt());
            setTotal(parcel.readInt());
            setMsg(parcel.readString());
            setStartQueueTime(parcel.readLong());
            setGameInfo((GameInfo) parcel.readParcelable(GameInfo.class.getClassLoader()));
        }
    }
}
