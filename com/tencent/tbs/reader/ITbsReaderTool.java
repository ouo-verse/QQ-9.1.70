package com.tencent.tbs.reader;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ITbsReaderTool {
    public static final String API_NAME_IMGS_TO_PDF = "imagesToPdf";
    public static final int CALL_HOST_ABILITY_BEACON = 32001;
    public static final int CALL_HOST_ABILITY_JUMP2BROWSER = 32002;
    public static final int CALL_HOST_ABILITY_LOG = 32003;
    public static final int CALL_HOST_API = 31001;
    public static final int CALL_READER_API = 31002;
    public static final int HOST_TOOL_FULL_SCREEN = 50004;
    public static final int HOST_TOOL_GET_FILES_BY_EXT = 50010;
    public static final int HOST_TOOL_HIDE_ACTION_BAR = 50015;
    public static final int HOST_TOOL_IMPORT_FILE = 50007;
    public static final int HOST_TOOL_OPEN_FILE = 50008;
    public static final int HOST_TOOL_OPEN_FILE_CENTER = 50014;
    public static final int HOST_TOOL_OPEN_WEB_PAGE = 50012;
    public static final int HOST_TOOL_READ_KV = 50018;
    public static final int HOST_TOOL_REQUEST_ORIENTATION = 50005;
    public static final int HOST_TOOL_SAVE_KV = 50017;
    public static final int HOST_TOOL_SAVE_TO_FILE_CENTER = 50001;
    public static final int HOST_TOOL_SHARE = 50002;
    public static final int HOST_TOOL_SHOW_ACTION_BAR = 50016;
    public static final int HOST_TOOL_SHOW_DOCUMENT_SHARE_MENU = 50011;
    public static final int HOST_TOOL_SHOW_TIPS = 50009;
    public static final int HOST_TOOL_START_INTENT = 50013;
    public static final int HOST_TOOL_TENCENT_DOC = 50003;
    public static final int HOST_TOOL_UPLOAD_TO_WEI_YUN = 50006;
    public static final String TBS_PLUGIN_BRIDGE_KEY_API_NAME = "tbs_plugin_bridge_apiName";
    public static final int TBS_TOOL_IS_WASM_ENABLE = 10001;

    public static boolean isTbsReaderTool(int i3) {
        if (i3 == 31001 || i3 == 5001 || i3 == 5002) {
            return true;
        }
        if (i3 >= 50001 && i3 <= 50018) {
            return true;
        }
        return false;
    }
}
