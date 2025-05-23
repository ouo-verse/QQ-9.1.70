package com.tencent.xweb;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Debug;
import android.os.Process;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.apache.httpcore.message.TokenParser;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileReaderHelper {
    public static final int CAN_EXPLICIT_INSTALL_FALSE_FORBID_DOWNLOAD = -2;
    public static final int CAN_EXPLICIT_INSTALL_FALSE_FORBID_EXPLICIT_DOWNLOAD = -3;
    public static final int CAN_EXPLICIT_INSTALL_FALSE_PARAM_INVALID = -1;
    public static final int CAN_EXPLICIT_INSTALL_TRUE_CAN_DOWNLOAD = 1;
    public static final int CAN_EXPLICIT_INSTALL_TRUE_FORBID_DOWNLOAD_CAN_TRY_EMBED = 2;
    public static final int CAN_EXPLICIT_INSTALL_TRUE_FORBID_EXPLICIT_DOWNLOAD_CAN_TRY_EMBED = 3;
    public static final String ERROR_MSG_DISABLE_PASSWORD = "disable_password";
    public static final String ERROR_MSG_DOWNLOAD_CANCEL = "download_cancel";
    public static final String ERROR_MSG_DOWNLOAD_CONFIG_DOWNLOAD_FAILED = "download_config_download_failed";
    public static final String ERROR_MSG_DOWNLOAD_CONFIG_PARSE_FAILED = "download_config_parse_failed";
    public static final String ERROR_MSG_DOWNLOAD_NO_AVAILABLE_UPDATE = "download_no_available_update";
    public static final String ERROR_MSG_DOWNLOAD_NO_NEED_TO_FETCH_CONFIG = "download_no_need_to_fetch_config";
    public static final String ERROR_MSG_DOWNLOAD_NO_NETWORK = "download_no_network";
    public static final String ERROR_MSG_DOWNLOAD_NO_PLUGIN_IN_CONFIG = "download_no_plugin_in_config";
    public static final String ERROR_MSG_DOWNLOAD_OTHERS_IS_UPDATING = "download_others_is_updating";
    public static final String ERROR_MSG_DOWNLOAD_PLUGIN_ONLY_DOWNLOAD_ERROR = "download_plugin_only_download_error";
    public static final String ERROR_MSG_DOWNLOAD_PLUGIN_ONLY_INSTALL_ERROR = "download_plugin_only_install_error";
    public static final String ERROR_MSG_DOWNLOAD_PLUGIN_UPDATE_ERROR = "download_plugin_update_error";
    public static final String ERROR_MSG_DOWNLOAD_START_FAILED = "download_start_failed";
    public static final String ERROR_MSG_FILE_NOT_EXIST = "file_not_exist";
    public static final String ERROR_MSG_FILE_NOT_SUPPORT = "file_not_support";
    public static final String ERROR_MSG_FORBID_DOWNLOAD_CODE = "forbid_download_code";
    public static final String ERROR_MSG_INIT_ERROR = "init_error";
    public static final String ERROR_MSG_INVOKE_ERROR = "invoke_error";
    public static final String ERROR_MSG_MINIQB_INIT_ERROR_DEFAULT = "miniqb_init_error_default";
    public static final String ERROR_MSG_MINIQB_INIT_ERROR_DISABLE = "miniqb_init_error_disable";
    public static final String ERROR_MSG_MINIQB_INIT_ERROR_FAILED = "miniqb_init_error_failed";
    public static final String ERROR_MSG_MINIQB_INIT_ERROR_NOT_SUPPORT = "miniqb_init_error_not_support";
    public static final String ERROR_MSG_MINIQB_INIT_ERROR_NOT_SUPPORT_64 = "miniqb_init_error_not_support_64";
    public static final String ERROR_MSG_MINIQB_INIT_ERROR_PARAM = "miniqb_init_error_param";
    public static final String ERROR_MSG_MINIQB_OPEN_ERROR = "miniqb_open_error";
    public static final String ERROR_MSG_PASSWORD_ERROR = "password_error";
    public static final String ERROR_MSG_PLUGIN_NOT_INSTALLED = "plugin_not_installed";
    public static final String ERROR_MSG_QB_ERROR = "qb_error";
    public static final String ERROR_MSG_SO_ERROR = "so_error";
    public static final String ERROR_MSG_SUCCESS = "success";
    public static final String ERROR_MSG_TASK_EXIST = "task_exist";
    public static final String ERROR_MSG_TASK_PREPARE_ERROR = "task_prepare_error";
    public static final String ERROR_MSG_TASK_RUN_ERROR = "task_run_error";
    public static final String ERROR_MSG_THIRD_ERROR = "third_error";
    public static final String ERROR_MSG_UNKNOWN = "unknown";
    public static final String ERROR_MSG_VERSION_TOO_OLD = "version_too_old";
    public static final String ERROR_MSG_VIEW_DESTROY = "view_destroy";
    public static final String ERROR_MSG_WRONG_PARAM = "wrong_param";
    public static final int ERR_CANT_OPEN = -102;
    public static final int ERR_NONE = 0;
    public static final String EXPLICIT_DOWNLOAD_SCENE_INVOKE_ERROR = "invoke_error";
    public static final String EXPLICIT_DOWNLOAD_SCENE_NONE = "none";
    public static final String EXPLICIT_DOWNLOAD_SCENE_NOT_INSTALL = "not_install";
    public static final String EXPLICIT_DOWNLOAD_SCENE_SO_ERROR = "so_error";
    public static final String OPEN_FILE_FROM_CMD = "cmd";
    public static final String OPEN_FILE_FROM_DEFAULT = "default";
    public static final String OPEN_FILE_FROM_FORCE = "force";
    public static final String OPEN_FILE_FROM_HARDCODE = "hardcode";
    public static final String OPEN_FILE_FROM_MINIQB_ERROR = "miniqb_error";
    public static final String OPEN_FILE_FROM_UNKNOWN = "unknown";
    public static final String OPEN_FILE_FROM_XFILE_CONTEXT_ERROR = "xfile_context_error";
    public static final String OPEN_FILE_FROM_XFILE_FORBID_DOWNLOAD = "xfile_forbid_download";
    public static final String OPEN_FILE_FROM_XFILE_INNER_ERROR = "xfile_inner_error";
    public static final String OPEN_FILE_FROM_XFILE_NOT_INSTALLED = "xfile_not_installed";
    public static final String OPEN_FILE_FROM_XFILE_NOT_SUPPORT = "xfile_not_support";
    public static final String OPEN_FILE_FROM_XFILE_RECENT_CRASH = "xfile_recent_crash";
    public static final String OPEN_FILE_FROM_XFILE_TOO_OLD = "xfile_too_old";
    public static String OPEN_X5_SCENE_STR = "open_x5_from_scene";
    public static final String QQ_BROWSER = "QQBROWSER";
    public static final String READER_TYPE_MINIQB = "miniqb";
    public static final String READER_TYPE_QB = "qb";
    public static final String READER_TYPE_THIRD_PREFIX = "third_";
    public static final String READER_TYPE_UNKNOWN = "unknown";
    public static final String READER_TYPE_XFilesAudioPlayer = "XFilesAudioPlayer";
    public static final String THIRD_APP = "THIRDAPP";
    public static final String PPT_EXT = "ppt";
    public static final String PPTX_EXT = "pptx";
    public static final String XLS_EXT = "xls";
    public static final String XLSX_EXT = "xlsx";
    public static final String DOC_EXT = "doc";
    public static final String DOCX_EXT = "docx";
    public static final String WPS_EXT = "wps";
    public static final String ET_EXT = "et";
    public static final String DPS_EXT = "dps";
    public static final String PDF_EXT = "pdf";
    public static final String TXT_EXT = "txt";
    public static final String MP3_EXT = "mp3";
    public static final String M4A_EXT = "m4a";
    public static final String WAV_EXT = "wav";
    public static final String AAC_EXT = "aac";
    public static final String[] ALL_FILE_FORMATS = {PPT_EXT, PPTX_EXT, XLS_EXT, XLSX_EXT, DOC_EXT, DOCX_EXT, WPS_EXT, ET_EXT, DPS_EXT, PDF_EXT, TXT_EXT, MP3_EXT, M4A_EXT, WAV_EXT, AAC_EXT};
    public static final String[] AUDIO_FILE_FORMATS = {MP3_EXT, M4A_EXT, WAV_EXT, AAC_EXT};
    public static final String[] OFFICE_READER_FORMATS = {PPT_EXT, PPTX_EXT, XLS_EXT, XLSX_EXT, DOC_EXT, DOCX_EXT, WPS_EXT, ET_EXT, DPS_EXT};

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum AudioPlayerStrategy {
        auto,
        tponly,
        tpfirst,
        sysonly,
        sysfirst
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum ReaderType {
        NONE,
        XWEB,
        X5
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ReportTarget {

        /* renamed from: a, reason: collision with root package name */
        public int f384899a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f384900b;

        public ReportTarget(int i3, boolean z16) {
            this.f384899a = i3;
            this.f384900b = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum UseOfficeReader {
        none,
        yes,
        no
    }

    public static void a(Intent intent, int i3) {
        if (intent != null) {
            intent.putExtra(OPEN_X5_SCENE_STR, i3);
        }
    }

    public static boolean b(String str) {
        if (str != null && !str.isEmpty()) {
            for (String str2 : ALL_FILE_FORMATS) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int canExplicitInstall(XWalkReaderBasePlugin xWalkReaderBasePlugin, boolean z16, int i3) {
        boolean z17;
        if (xWalkReaderBasePlugin == null) {
            x0.c("XFilesReaderHelper", "canExplicitInstall error, readerPlugin is null");
            return -1;
        }
        if (xWalkReaderBasePlugin.hasEmbed() && xWalkReaderBasePlugin.getEmbedVersion() >= i3) {
            z17 = true;
        } else {
            z17 = false;
        }
        x0.d("XFilesReaderHelper", "canExplicitInstall plugin:" + xWalkReaderBasePlugin.getPluginName() + ", curVersion: " + xWalkReaderBasePlugin.getAvailableVersion() + ", require: " + i3 + ", embedVersion: " + xWalkReaderBasePlugin.getEmbedVersion() + ", canTryEmbed: " + z17 + ", canExplicitDownload: " + z16);
        if (XWebEmbedSetting.getForbidDownloadCode() && !xWalkReaderBasePlugin.isIgnoreForbidDownloadCode()) {
            x0.d("XFilesReaderHelper", "canExplicitInstall forbid download code");
            if (z17) {
                x0.d("XFilesReaderHelper", "canExplicitInstall can try embed");
                return 2;
            }
            x0.d("XFilesReaderHelper", "canExplicitInstall no embed");
            return -2;
        }
        if (!z16) {
            x0.d("XFilesReaderHelper", "canExplicitInstall can not explicit download");
            if (z17) {
                x0.d("XFilesReaderHelper", "canExplicitInstall can try embed");
                return 3;
            }
            x0.d("XFilesReaderHelper", "canExplicitInstall no embed");
            return -3;
        }
        x0.d("XFilesReaderHelper", "canExplicitInstall can download");
        return 1;
    }

    public static String convertOpenFileFrom(int i3) {
        if (i3 == 40) {
            return OPEN_FILE_FROM_HARDCODE;
        }
        if (i3 == 41) {
            return OPEN_FILE_FROM_FORCE;
        }
        if (i3 == 42) {
            return "cmd";
        }
        if (i3 == 43) {
            return OPEN_FILE_FROM_XFILE_RECENT_CRASH;
        }
        if (i3 == 44) {
            return OPEN_FILE_FROM_XFILE_FORBID_DOWNLOAD;
        }
        if (i3 == 45) {
            return OPEN_FILE_FROM_XFILE_NOT_INSTALLED;
        }
        if (i3 == 46) {
            return OPEN_FILE_FROM_XFILE_TOO_OLD;
        }
        if (i3 == 47) {
            return OPEN_FILE_FROM_XFILE_NOT_SUPPORT;
        }
        if (i3 == 48) {
            return OPEN_FILE_FROM_XFILE_CONTEXT_ERROR;
        }
        if (i3 == 49) {
            return OPEN_FILE_FROM_XFILE_INNER_ERROR;
        }
        if (i3 == 50) {
            return OPEN_FILE_FROM_MINIQB_ERROR;
        }
        return "unknown";
    }

    public static String convertX5ErrorCodeToMsg(int i3, boolean z16) {
        if (i3 == 0) {
            return "success";
        }
        if (z16) {
            if (i3 == -100001) {
                return ERROR_MSG_MINIQB_INIT_ERROR_PARAM;
            }
            if (i3 == -100002) {
                return ERROR_MSG_MINIQB_INIT_ERROR_NOT_SUPPORT;
            }
            if (i3 == -100003) {
                return ERROR_MSG_MINIQB_INIT_ERROR_FAILED;
            }
            if (i3 == -100004) {
                return ERROR_MSG_MINIQB_INIT_ERROR_NOT_SUPPORT_64;
            }
            if (i3 == -100005) {
                return ERROR_MSG_MINIQB_INIT_ERROR_DISABLE;
            }
            return ERROR_MSG_MINIQB_INIT_ERROR_DEFAULT;
        }
        return ERROR_MSG_MINIQB_OPEN_ERROR;
    }

    public static String convertXWebErrorCodeToMsg(int i3) {
        if (i3 == 0) {
            return "success";
        }
        if (i3 == -1) {
            return ERROR_MSG_FORBID_DOWNLOAD_CODE;
        }
        if (i3 == -2) {
            return ERROR_MSG_PLUGIN_NOT_INSTALLED;
        }
        if (i3 == -3) {
            return "invoke_error";
        }
        if (i3 == -4) {
            return ERROR_MSG_INIT_ERROR;
        }
        if (i3 == -5) {
            return ERROR_MSG_WRONG_PARAM;
        }
        if (i3 == -6) {
            return ERROR_MSG_FILE_NOT_EXIST;
        }
        if (i3 == -7) {
            return ERROR_MSG_FILE_NOT_SUPPORT;
        }
        if (i3 == -8) {
            return ERROR_MSG_TASK_EXIST;
        }
        if (i3 == -9) {
            return ERROR_MSG_TASK_PREPARE_ERROR;
        }
        if (i3 == -10) {
            return ERROR_MSG_TASK_RUN_ERROR;
        }
        if (i3 == -11) {
            return ERROR_MSG_VERSION_TOO_OLD;
        }
        if (i3 == -12) {
            return ERROR_MSG_PASSWORD_ERROR;
        }
        if (i3 == -13) {
            return "so_error";
        }
        if (i3 == -14) {
            return ERROR_MSG_VIEW_DESTROY;
        }
        if (i3 == -15) {
            return ERROR_MSG_DOWNLOAD_CANCEL;
        }
        if (i3 == -18) {
            return ERROR_MSG_DOWNLOAD_START_FAILED;
        }
        if (i3 == -19) {
            return ERROR_MSG_DOWNLOAD_NO_NETWORK;
        }
        if (i3 == -20) {
            return ERROR_MSG_DOWNLOAD_NO_NEED_TO_FETCH_CONFIG;
        }
        if (i3 == -21) {
            return ERROR_MSG_DOWNLOAD_OTHERS_IS_UPDATING;
        }
        if (i3 == -22) {
            return ERROR_MSG_DOWNLOAD_CONFIG_DOWNLOAD_FAILED;
        }
        if (i3 == -23) {
            return ERROR_MSG_DOWNLOAD_CONFIG_PARSE_FAILED;
        }
        if (i3 == -24) {
            return ERROR_MSG_DOWNLOAD_NO_PLUGIN_IN_CONFIG;
        }
        if (i3 == -25) {
            return ERROR_MSG_DOWNLOAD_NO_AVAILABLE_UPDATE;
        }
        if (i3 == -26) {
            return ERROR_MSG_DOWNLOAD_PLUGIN_UPDATE_ERROR;
        }
        if (i3 == -27) {
            return ERROR_MSG_DOWNLOAD_PLUGIN_ONLY_DOWNLOAD_ERROR;
        }
        if (i3 == -28) {
            return ERROR_MSG_DOWNLOAD_PLUGIN_ONLY_INSTALL_ERROR;
        }
        if (i3 == -17) {
            return ERROR_MSG_DISABLE_PASSWORD;
        }
        x0.c("XFilesReaderHelper", "convertXWebErrorCodeToMsg unknown code: " + i3);
        return "unknown";
    }

    public static long getCurrentProcessMemory(Context context) {
        x0.d("XFilesReaderHelper", "getCurrentProcessMemory start");
        try {
            if (context == null) {
                x0.c("XFilesReaderHelper", "getCurrentProcessMemory failed, context is null");
                return 0L;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager == null) {
                x0.c("XFilesReaderHelper", "getCurrentProcessMemory failed, activityManager is null");
                return 0L;
            }
            Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo(activityManager, new int[]{Process.myPid()});
            if (processMemoryInfo != null && processMemoryInfo.length > 0) {
                long totalPrivateClean = (processMemoryInfo[0].getTotalPrivateClean() + processMemoryInfo[0].getTotalPrivateDirty()) / 1024;
                x0.d("XFilesReaderHelper", "getCurrentProcessMemory " + totalPrivateClean);
                return totalPrivateClean;
            }
            x0.c("XFilesReaderHelper", "getCurrentProcessMemory failed, memoryInfo is empty");
            return 0L;
        } catch (Throwable th5) {
            x0.c("XFilesReaderHelper", "getCurrentProcessMemory error, msg:" + th5.getMessage());
            return 0L;
        }
    }

    public static int getOpenFileFrom(HashMap<String, String> hashMap) {
        try {
            if (hashMap == null) {
                x0.c("XFilesReaderHelper", "getOpenFileFrom failed, extra params is null");
                return 0;
            }
            String str = hashMap.get(XFileSdk.PARAM_KEY_EXTRA_PARAM_OPEN_FILE_FROM);
            if (str != null && !str.isEmpty()) {
                return Integer.parseInt(str);
            }
            x0.c("XFilesReaderHelper", "getOpenFileFrom failed, strScene is empty");
            return 0;
        } catch (Exception e16) {
            x0.c("XFilesReaderHelper", "getOpenFileFrom error: " + e16.getMessage());
            return 0;
        }
    }

    public static int getOpenFileScene(HashMap<String, String> hashMap) {
        try {
            if (hashMap == null) {
                x0.c("XFilesReaderHelper", "getOpenFileScene failed, extra params is null");
                return 0;
            }
            String str = hashMap.get(XFileSdk.PARAM_KEY_EXTRA_PARAM_OPEN_FILE_SCENE);
            if (str != null && !str.isEmpty()) {
                return Integer.parseInt(str);
            }
            x0.c("XFilesReaderHelper", "getOpenFileScene failed, strScene is empty");
            return 0;
        } catch (Exception e16) {
            x0.c("XFilesReaderHelper", "getOpenFileScene error: " + e16.getMessage());
            return 0;
        }
    }

    public static XWalkPlugin getPlugin(String str) {
        if (str == null) {
            return null;
        }
        if (!str.equalsIgnoreCase(PPT_EXT) && !str.equalsIgnoreCase(PPTX_EXT) && !str.equalsIgnoreCase(DPS_EXT)) {
            if (str.equalsIgnoreCase(PDF_EXT)) {
                return XWalkPluginManager.getPlugin(XWalkPluginManager.XWALK_PLUGIN_NAME_PDF);
            }
            if (!str.equalsIgnoreCase(DOC_EXT) && !str.equalsIgnoreCase(DOCX_EXT) && !str.equalsIgnoreCase(WPS_EXT)) {
                if (!str.equalsIgnoreCase(XLS_EXT) && !str.equalsIgnoreCase(XLSX_EXT) && !str.equalsIgnoreCase(ET_EXT)) {
                    if (!str.equalsIgnoreCase(TXT_EXT)) {
                        return null;
                    }
                    return XWalkPluginManager.getPlugin(XWalkPluginManager.XWALK_PLUGIN_NAME_TXT);
                }
                if (getUseOfficeReader(str, true)) {
                    return XWalkPluginManager.getPlugin(XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE);
                }
                return XWalkPluginManager.getPlugin(XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL);
            }
            if (getUseOfficeReader(str, true)) {
                return XWalkPluginManager.getPlugin(XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE);
            }
            return XWalkPluginManager.getPlugin(XWalkPluginManager.XWALK_PLUGIN_NAME_WORD);
        }
        if (getUseOfficeReader(str, true)) {
            return XWalkPluginManager.getPlugin(XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE);
        }
        return XWalkPluginManager.getPlugin(XWalkPluginManager.XWALK_PLUGIN_NAME_PPT);
    }

    public static ReaderType getReaderType(String str, boolean z16, Intent intent) {
        boolean z17;
        int canExplicitInstall;
        int i3;
        a(intent, 40);
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase();
            ReaderType fileReaderType = CommandCfgPlugin.getInstance().getFileReaderType(lowerCase);
            x0.d("XFilesReaderHelper", "getReaderType cmd type: " + fileReaderType.toString());
            a(intent, 42);
            ReaderType readerType = ReaderType.X5;
            if (fileReaderType == readerType) {
                x0.d("XFilesReaderHelper", "getReaderType use x5");
                return readerType;
            }
            if (!b(lowerCase)) {
                x0.d("XFilesReaderHelper", "getReaderType not support " + lowerCase + ", use x5");
                a(intent, 47);
                return readerType;
            }
            if (WebDebugCfg.getInst() != null) {
                z17 = WebDebugCfg.getInst().getDisableFileReaderCrashDetect();
            } else {
                z17 = false;
            }
            if (!z17 && FileReaderCrashDetector.isRecentCrashed(lowerCase)) {
                x0.d("XFilesReaderHelper", "getReaderType recent crashed, use x5");
                a(intent, 43);
                return readerType;
            }
            if (isAudioFormat(lowerCase)) {
                x0.d("XFilesReaderHelper", "getReaderType is supported audio file, use xweb");
                return ReaderType.XWEB;
            }
            if (!z16) {
                x0.d("XFilesReaderHelper", "getReaderType skip check plugin, use xweb");
                return ReaderType.XWEB;
            }
            XWalkPlugin plugin = getPlugin(lowerCase);
            if (!(plugin instanceof XWalkReaderBasePlugin)) {
                x0.d("XFilesReaderHelper", "getReaderType can not find plugin, not support " + lowerCase + ", use x5");
                a(intent, 47);
                return readerType;
            }
            XWalkReaderBasePlugin xWalkReaderBasePlugin = (XWalkReaderBasePlugin) plugin;
            int availableVersion = xWalkReaderBasePlugin.getAvailableVersion(true);
            int minSupportRuntimeVersion = xWalkReaderBasePlugin.getMinSupportRuntimeVersion(0);
            if ((availableVersion <= 0 || availableVersion < minSupportRuntimeVersion) && (canExplicitInstall = canExplicitInstall(xWalkReaderBasePlugin, CommandCfgPlugin.getInstance().canDownloadWhenNotInstall(true), minSupportRuntimeVersion)) <= 0) {
                x0.d("XFilesReaderHelper", "getReaderType can not explicit install, use x5");
                if (canExplicitInstall == -2) {
                    a(intent, 44);
                } else if (canExplicitInstall == -3) {
                    if (availableVersion <= 0) {
                        i3 = 45;
                    } else {
                        i3 = 46;
                    }
                    a(intent, i3);
                }
                return readerType;
            }
            x0.d("XFilesReaderHelper", "getReaderType version support, use xweb");
            return ReaderType.XWEB;
        }
        x0.c("XFilesReaderHelper", "getReaderType fileExt is empty, use x5");
        return ReaderType.X5;
    }

    public static boolean getUseOfficeReader(String str, boolean z16) {
        UseOfficeReader useOfficeReader;
        UseOfficeReader useOfficeReader2 = UseOfficeReader.none;
        if (WebDebugCfg.getInst() != null) {
            useOfficeReader = WebDebugCfg.getInst().getForceUseOfficeReader(str);
            if (z16) {
                x0.d("XFilesReaderHelper", "getUseOfficeReader force = " + useOfficeReader.toString());
            }
        } else {
            if (z16) {
                x0.c("XFilesReaderHelper", "getUseOfficeReader WebDebugCfg is null, skip force");
            }
            useOfficeReader = useOfficeReader2;
        }
        if (useOfficeReader == useOfficeReader2) {
            useOfficeReader = CommandCfgPlugin.getInstance().getCmdUseOfficeReader(str);
            if (z16) {
                x0.d("XFilesReaderHelper", "getUseOfficeReader cmd = " + useOfficeReader.toString());
            }
        }
        if (useOfficeReader != UseOfficeReader.no) {
            return true;
        }
        return false;
    }

    public static boolean isAudioFormat(String str) {
        if (str != null && !str.isEmpty()) {
            for (String str2 : AUDIO_FILE_FORMATS) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void reportDownloadErrorCode(String str, int i3) {
        int i16;
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase();
            ReportTarget a16 = a(lowerCase);
            if (a16 == null) {
                x0.b("XFilesReaderHelper", "reportDownloadErrorCode skip " + lowerCase);
                return;
            }
            if (i3 == 0) {
                i16 = 79;
            } else if (i3 == -1) {
                i16 = 81;
            } else if (i3 == -2) {
                i16 = 82;
            } else if (i3 == -3) {
                i16 = 83;
            } else if (i3 == -4) {
                i16 = 84;
            } else if (i3 == -5) {
                i16 = 85;
            } else if (i3 == -6) {
                i16 = 86;
            } else if (i3 == -7) {
                i16 = 87;
            } else if (i3 == -8) {
                i16 = 88;
            } else if (i3 == -9) {
                i16 = 89;
            } else if (i3 == -10) {
                i16 = 90;
            } else if (i3 == -11) {
                i16 = 91;
            } else {
                x0.c("XFilesReaderHelper", "reportDownloadErrorCode idkey unknown ret: " + i3);
                return;
            }
            x0.b("XFilesReaderHelper", "reportDownloadErrorCode idkey id:" + a16.f384899a + ", key:" + i16);
            n0.a((long) a16.f384899a, (long) i16, 1L);
            return;
        }
        x0.c("XFilesReaderHelper", "reportDownloadErrorCode param is null");
    }

    public static void reportException(String str, int i3, String str2, Throwable th5) {
        if (str != null && !str.isEmpty() && str2 != null && th5 != null) {
            try {
                StringWriter stringWriter = new StringWriter();
                th5.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                boolean isEmpty = stringWriter2.isEmpty();
                String str3 = GlobalUtil.DEF_STRING;
                if (isEmpty) {
                    stringWriter2 = GlobalUtil.DEF_STRING;
                }
                String replace = stringWriter2.substring(0, Math.min(stringWriter2.length(), 1000)).replace(',', TokenParser.SP).replace(':', TokenParser.SP);
                String str4 = str2 + " " + th5.getMessage();
                if (!str4.isEmpty()) {
                    str3 = str4;
                }
                String str5 = i3 + "," + str + "," + replace + "," + str3.substring(0, Math.min(str3.length(), 1000)).replace(',', TokenParser.SP).replace(':', TokenParser.SP);
                x0.b("XFilesReaderHelper", "reportException kv key:17565, val:" + str5);
                n0.a(17565, str5);
                return;
            } catch (Throwable th6) {
                x0.a("XFilesReaderHelper", "reportException error", th6);
                return;
            }
        }
        x0.c("XFilesReaderHelper", "reportException wrong param");
    }

    public static void reportExplicitInstall(String str) {
        a(str, 78);
    }

    public static void reportExplicitInstallStartFailed(String str) {
        a(str, 80);
    }

    public static long reportFileSize(String str, String str2) {
        String str3;
        int i3;
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            String lowerCase = str2.toLowerCase();
            File file = new File(str);
            if (!file.exists()) {
                x0.c("XFilesReaderHelper", "reportFileSize file not exist");
                return 0L;
            }
            long length = file.length() / 1048576;
            if (length == 0) {
                length++;
            }
            if (lowerCase.length() > 50) {
                str3 = lowerCase.substring(0, 50);
            } else {
                str3 = lowerCase;
            }
            String str4 = str3 + "," + length;
            x0.b("XFilesReaderHelper", "reportFileSize kv key:17562, val:" + str4);
            n0.a(17562, str4);
            ReportTarget a16 = a(lowerCase);
            if (a16 == null) {
                x0.b("XFilesReaderHelper", "reportFileSize idkey skip " + lowerCase);
                return length;
            }
            if (length <= 10) {
                if (a16.f384900b) {
                    i3 = 24;
                } else {
                    i3 = 20;
                }
            } else if (length <= 20) {
                if (a16.f384900b) {
                    i3 = 25;
                } else {
                    i3 = 21;
                }
            } else if (length <= 50) {
                if (a16.f384900b) {
                    i3 = 26;
                } else {
                    i3 = 22;
                }
            } else if (a16.f384900b) {
                i3 = 27;
            } else {
                i3 = 23;
            }
            x0.b("XFilesReaderHelper", "reportFileSize idkey id:" + a16.f384899a + ", key:" + i3);
            n0.a((long) a16.f384899a, (long) i3, 1L);
            return length;
        }
        x0.c("XFilesReaderHelper", "reportFileSize param is null");
        return 0L;
    }

    public static void reportOpenFile(OpenFileReportData openFileReportData) {
        if (openFileReportData == null) {
            x0.c("XFilesReaderHelper", "reportOpenFile failed, data is null");
            return;
        }
        String stringOpenFile = openFileReportData.getStringOpenFile();
        if (stringOpenFile != null && !stringOpenFile.isEmpty()) {
            x0.d("XFilesReaderHelper", "reportOpenFile kv key:25414, val:" + stringOpenFile);
            n0.a(25414, stringOpenFile);
            return;
        }
        x0.c("XFilesReaderHelper", "reportOpenFile failed, reportVal is empty");
    }

    public static void reportOpenFileRet(OpenFileReportData openFileReportData) {
        if (openFileReportData == null) {
            x0.c("XFilesReaderHelper", "reportOpenFileRet failed, data is null");
            return;
        }
        String stringOpenFileRet = openFileReportData.getStringOpenFileRet();
        if (stringOpenFileRet != null && !stringOpenFileRet.isEmpty()) {
            x0.d("XFilesReaderHelper", "reportOpenFileRet kv key:25415, val:" + stringOpenFileRet);
            n0.a(25415, stringOpenFileRet);
            return;
        }
        x0.c("XFilesReaderHelper", "reportOpenFileRet failed, reportVal is empty");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static void reportPVUV(String str, String str2) {
        ?? r65;
        int i3;
        ?? r66;
        boolean z16;
        int i16;
        boolean z17;
        ?? r67;
        String str3;
        boolean z18;
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            String lowerCase = str.toLowerCase();
            ReportTarget a16 = a(lowerCase);
            if (a16 == null) {
                x0.b("XFilesReaderHelper", "reportPVUV skip " + lowerCase + ", " + str2);
                return;
            }
            if (ReaderType.XWEB.name().equalsIgnoreCase(str2)) {
                z17 = a16.f384900b;
                if (z17) {
                    i16 = 3;
                } else {
                    i16 = 2;
                }
            } else {
                if (ReaderType.X5.name().equalsIgnoreCase(str2)) {
                    boolean z19 = a16.f384900b;
                    if (z19) {
                        r67 = 5;
                    } else {
                        r67 = 4;
                    }
                    if (z19) {
                        i3 = 7;
                        z16 = r67;
                    } else {
                        i3 = 6;
                        z16 = r67;
                    }
                } else if (QQ_BROWSER.equalsIgnoreCase(str2)) {
                    boolean z26 = a16.f384900b;
                    if (z26) {
                        r66 = 17;
                    } else {
                        r66 = 16;
                    }
                    if (z26) {
                        i3 = 19;
                        z16 = r66;
                    } else {
                        i3 = 18;
                        z16 = r66;
                    }
                } else if (THIRD_APP.equalsIgnoreCase(str2)) {
                    boolean z27 = a16.f384900b;
                    if (z27) {
                        r65 = 9;
                    } else {
                        r65 = 8;
                    }
                    if (z27) {
                        i3 = 11;
                        z16 = r65;
                    } else {
                        i3 = 10;
                        z16 = r65;
                    }
                } else {
                    x0.c("XFilesReaderHelper", "reportPVUV unknown type, skip");
                    return;
                }
                boolean z28 = z16;
                i16 = i3;
                z17 = z28;
            }
            int i17 = i16;
            boolean z29 = z17;
            try {
                str3 = new SimpleDateFormat(DateUtil.DATE_FORMAT_8).format(new Date());
            } catch (Throwable th5) {
                x0.c("XFilesReaderHelper", "reportPVUV get cur date error: " + th5.getMessage());
                str3 = "";
            }
            String str4 = lowerCase + "_" + str2 + "__report_uv_date";
            SharedPreferences l3 = y0.l();
            if (l3 != null) {
                z18 = !l3.getString(str4, "").equals(str3);
            } else {
                x0.c("XFilesReaderHelper", "reportPVUV sp is null, skip uv report");
                z18 = false;
            }
            x0.b("XFilesReaderHelper", "reportPV id:" + a16.f384899a + ", key:" + (z29 ? 1 : 0));
            n0.a((long) a16.f384899a, z29 ? 1L : 0L, 1L);
            if (z18) {
                x0.b("XFilesReaderHelper", "reportUV id:" + a16.f384899a + ", key:" + i17);
                n0.a((long) a16.f384899a, (long) i17, 1L);
                SharedPreferences.Editor edit = l3.edit();
                if (edit != null) {
                    edit.putString(str4, str3);
                    edit.commit();
                    return;
                } else {
                    x0.c("XFilesReaderHelper", "reportPVUV editor is null, skip");
                    return;
                }
            }
            return;
        }
        x0.c("XFilesReaderHelper", "reportPVUV param is null");
    }

    public static void reportReadByX5Scene(String str, int i3) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase();
            ReportTarget a16 = a(lowerCase);
            if (a16 == null) {
                x0.b("XFilesReaderHelper", "reportReadByX5Scene idkey skip " + lowerCase);
                return;
            }
            String str2 = lowerCase + "," + i3;
            x0.b("XFilesReaderHelper", "reportReadByX5Scene kv key:17563, val:" + str2);
            n0.a(17563, str2);
            x0.b("XFilesReaderHelper", "reportReadByX5Scene idkey id:" + a16.f384899a + ", key:" + i3);
            n0.a((long) a16.f384899a, (long) i3, 1L);
            return;
        }
        x0.c("XFilesReaderHelper", "reportReadByX5Scene param is null");
    }

    public static void reportX5ErrorCode(String str, int i3, boolean z16, int i16, Context context, OpenFileReportData openFileReportData) {
        int i17;
        int i18;
        String str2;
        if (openFileReportData != null) {
            openFileReportData.markEnd(context, i3, convertX5ErrorCodeToMsg(i3, z16));
            reportOpenFileRet(openFileReportData);
        }
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase();
            ReportTarget a16 = a(lowerCase);
            if (a16 == null) {
                x0.b("XFilesReaderHelper", "reportX5ErrorCode skip " + lowerCase);
                return;
            }
            if (i3 != 0) {
                if (z16) {
                    str2 = "-1," + lowerCase + "," + i3 + ",x5init";
                } else {
                    str2 = "-1," + lowerCase + "," + i3 + ",x5";
                }
                x0.b("XFilesReaderHelper", "reportX5ErrorCode kv key:17566, val:" + str2);
                n0.a(17566, str2);
            }
            if (z16 || i3 == -102) {
                if (a16.f384900b) {
                    i17 = 15;
                } else {
                    i17 = 14;
                }
                x0.b("XFilesReaderHelper", "reportX5ErrorCode idkey id:" + a16.f384899a + ", key:" + i17);
                n0.a((long) a16.f384899a, (long) i17, 1L);
                if (i16 == 49) {
                    if (a16.f384900b) {
                        i18 = 39;
                    } else {
                        i18 = 38;
                    }
                    x0.b("XFilesReaderHelper", "reportX5ErrorCode XWeb and X5 All failed id:" + a16.f384899a + ", key:" + i18);
                    n0.a((long) a16.f384899a, (long) i18, 1L);
                    return;
                }
                return;
            }
            return;
        }
        x0.c("XFilesReaderHelper", "reportX5ErrorCode param is null");
    }

    public static void reportXWebErrorCode(String str, int i3, int i16, Context context, OpenFileReportData openFileReportData) {
        int i17;
        int i18;
        if (openFileReportData != null) {
            openFileReportData.markEnd(context, i16, convertXWebErrorCodeToMsg(i16));
            reportOpenFileRet(openFileReportData);
        }
        if (str != null && !str.isEmpty()) {
            if (i16 == 0) {
                return;
            }
            String lowerCase = str.toLowerCase();
            ReportTarget a16 = a(lowerCase);
            if (a16 == null) {
                x0.b("XFilesReaderHelper", "reportXWebErrorCode skip " + lowerCase);
                return;
            }
            String str2 = i3 + "," + lowerCase + "," + i16 + ",xweb";
            x0.b("XFilesReaderHelper", "reportXWebErrorCode kv key:17566, val:" + str2);
            n0.a(17566, str2);
            if (a16.f384900b) {
                i17 = 13;
            } else {
                i17 = 12;
            }
            x0.b("XFilesReaderHelper", "reportXWebErrorCode first idkey id:" + a16.f384899a + ", key:" + i17);
            n0.a((long) a16.f384899a, (long) i17, 1L);
            if (i16 == -1) {
                i18 = 151;
            } else if (i16 == -2) {
                i18 = 152;
            } else if (i16 == -3) {
                i18 = 153;
            } else if (i16 == -4) {
                i18 = 154;
            } else if (i16 == -5) {
                i18 = 155;
            } else if (i16 == -6) {
                i18 = 156;
            } else if (i16 == -7) {
                i18 = 157;
            } else if (i16 == -8) {
                i18 = 158;
            } else if (i16 == -9) {
                i18 = 159;
            } else if (i16 == -10) {
                i18 = 160;
            } else if (i16 == -11) {
                i18 = 161;
            } else if (i16 == -12) {
                i18 = 162;
            } else if (i16 == -13) {
                i18 = 163;
            } else if (i16 == -14) {
                i18 = 164;
            } else if (i16 == -15) {
                i18 = 165;
            } else if (i16 != -18 && i16 != -19 && i16 != -20 && i16 != -21 && i16 != -22 && i16 != -23 && i16 != -24 && i16 != -25 && i16 != -26 && i16 != -27 && i16 != -28) {
                if (i16 == -17) {
                    i18 = 167;
                } else {
                    x0.c("XFilesReaderHelper", "reportXWebErrorCode idkey unknown ret: " + i16);
                    return;
                }
            } else {
                i18 = 166;
            }
            x0.b("XFilesReaderHelper", "reportXWebErrorCode second idkey id:" + a16.f384899a + ", key:" + i18);
            n0.a((long) a16.f384899a, (long) i18, 1L);
            return;
        }
        x0.c("XFilesReaderHelper", "reportXWebErrorCode param is null");
    }

    public static ReportTarget a(String str) {
        if (str != null && !str.isEmpty()) {
            if (str.equalsIgnoreCase(PPT_EXT)) {
                return new ReportTarget(getUseOfficeReader(str, false) ? 1880 : 1068, false);
            }
            if (str.equalsIgnoreCase(PPTX_EXT)) {
                return new ReportTarget(getUseOfficeReader(str, false) ? 1880 : 1068, true);
            }
            if (str.equalsIgnoreCase(XLS_EXT)) {
                return new ReportTarget(getUseOfficeReader(str, false) ? 1879 : 1070, false);
            }
            if (str.equalsIgnoreCase(XLSX_EXT)) {
                return new ReportTarget(getUseOfficeReader(str, false) ? 1879 : 1070, true);
            }
            if (str.equalsIgnoreCase(DOC_EXT)) {
                return new ReportTarget(getUseOfficeReader(str, false) ? 1891 : 1069, false);
            }
            if (str.equalsIgnoreCase(DOCX_EXT)) {
                return new ReportTarget(getUseOfficeReader(str, false) ? 1891 : 1069, true);
            }
            if (str.equalsIgnoreCase(PDF_EXT)) {
                return new ReportTarget(1071, false);
            }
            if (str.equalsIgnoreCase(TXT_EXT)) {
                return new ReportTarget(1889, false);
            }
            if (isAudioFormat(str)) {
                return new ReportTarget(1900, false);
            }
            return null;
        }
        x0.c("XFilesReaderHelper", "getReportTarget fileExt is null");
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class OpenFileReportData {
        public String fileExt;
        public long fileSizeMB;
        public String from;
        public String module;
        public String readerType;
        public int scene;
        public int version;
        public String platform = "android";
        public long memoryStart = -1;
        public long memoryEnd = -1;
        public long memoryCost = -1;
        public long timeCost = -1;
        public int errorCode = 0;
        public String errorMsg = "unknown";
        public String explicitDownloadScene = "none";
        public long timeStart = -1;
        public long timeEnd = -1;

        public OpenFileReportData(int i3, String str, long j3, String str2, int i16, String str3) {
            this.module = "";
            this.scene = -1;
            this.fileExt = "";
            this.fileSizeMB = -1L;
            this.readerType = "";
            this.version = -1;
            this.from = "";
            this.module = XWalkEnvironment.getSafeModuleName("unknown");
            this.scene = i3;
            this.fileExt = str;
            this.fileSizeMB = j3;
            this.readerType = str2;
            this.version = i16;
            this.from = str3;
        }

        public final String a(String str) {
            if (str != null && !str.isEmpty()) {
                try {
                    return str.substring(0, Math.min(str.length(), 150)).replace(',', TokenParser.SP).replace(':', TokenParser.SP);
                } catch (Throwable th5) {
                    x0.c("XFilesReaderHelper", "getSafeMsg error: " + th5.getMessage());
                }
            }
            return "unknown";
        }

        public String getStringOpenFile() {
            return this.platform + "," + this.module + "," + this.scene + "," + this.fileExt + "," + this.fileSizeMB + "," + this.readerType + "," + this.version + "," + this.from + "," + this.memoryStart;
        }

        public String getStringOpenFileRet() {
            return this.platform + "," + this.module + "," + this.scene + "," + this.fileExt + "," + this.fileSizeMB + "," + this.readerType + "," + this.version + "," + this.from + "," + this.memoryStart + "," + this.memoryEnd + "," + this.memoryCost + "," + this.timeCost + "," + this.errorCode + "," + a(this.errorMsg) + "," + this.explicitDownloadScene;
        }

        public void markEnd(Context context, int i3, String str) {
            markEnd(FileReaderHelper.getCurrentProcessMemory(context), System.currentTimeMillis(), i3, str);
        }

        public void markStart(Context context) {
            markStart(FileReaderHelper.getCurrentProcessMemory(context), System.currentTimeMillis());
        }

        public void markEnd(long j3, long j16, int i3, String str) {
            this.memoryEnd = j3;
            this.timeEnd = j16;
            this.memoryCost = j3 - this.memoryStart;
            this.timeCost = j16 - this.timeStart;
            this.errorCode = i3;
            this.errorMsg = str;
        }

        public void markStart(long j3, long j16) {
            this.memoryStart = j3;
            this.timeStart = j16;
        }
    }

    public static void a(String str, int i3) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase();
            ReportTarget a16 = a(lowerCase);
            if (a16 == null) {
                x0.b("XFilesReaderHelper", "reportIDKeyByFileExt skip " + lowerCase);
                return;
            }
            x0.b("XFilesReaderHelper", "reportIDKeyByFileExt id:" + a16.f384899a + ", key:" + i3);
            n0.a((long) a16.f384899a, (long) i3, 1L);
            return;
        }
        x0.c("XFilesReaderHelper", "reportIDKeyByFileExt param is null");
    }
}
