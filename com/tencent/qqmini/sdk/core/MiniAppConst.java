package com.tencent.qqmini.sdk.core;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppConst {
    public static final int APP_LIFECYCLE_BACKGROUND = 3;
    public static final int APP_LIFECYCLE_DESTROY = 4;
    public static final int APP_LIFECYCLE_FOREGROUND = 2;
    public static final int APP_LIFECYCLE_START = 1;
    public static final String MENU_STYLE_DARK = "dark";
    public static final String MENU_STYLE_LIGHT = "light";
    public static final String MINI_ACTION_PROCESS = "mini_action_process";
    public static final int MINI_CMD_ON_PROCESS_BACKGROUND = 4;
    public static final int MINI_CMD_ON_PROCESS_DESTROY = 2;
    public static final int MINI_CMD_ON_PROCESS_FOREGROUND = 3;
    public static final int MINI_CMD_ON_PROCESS_START = 1;
    public static final String MINI_KEY_APPINFO = "mini_appinfo";
    public static final String MINI_KEY_CMD = "mini_cmd";
    public static final String MINI_KEY_EXTRA = "mini_process_extra";
    public static final String MINI_KEY_PRELOAD_RUNTIME_TYPE = "mini_key_preload_runtime_type";
    public static final String MINI_KEY_PRELOAD_TYPE = "mini_key_preload_type";
    public static final String MINI_KEY_PROCESS = "mini_process_name";
    public static final String MINI_KEY_RECEIVER = "receiver";
    public static final String PRELOAD_TYPE_APP = "preload_app";
    public static final String PRELOAD_TYPE_GAME = "preload_game";
    public static final String PRELOAD_TYPE_UNITY = "preload_unity";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum RuntimeCloseType {
        CLOSE_BUTTON,
        NAVIGATE_BACK_MINI_PROGRAM,
        EXIT_MINI_PROGRAM,
        TRITON_ERROR,
        YUN_GAME_EXIT,
        RESTART_ACTION,
        FREE_CACHE,
        RUNTIME_DESTROY
    }
}
