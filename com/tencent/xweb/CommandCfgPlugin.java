package com.tencent.xweb;

import android.content.SharedPreferences;
import com.tencent.luggage.wxa.ar.h;
import com.tencent.luggage.wxa.ar.j;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.FileReaderHelper;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public class CommandCfgPlugin extends CommandCfg {
    public static final String C_STR_CMD_AUDIO_PLAYER_STRATEGY_PREFIX = "audio_player_strategy_";
    public static final String C_STR_CMD_DISABLE_FILE_READER_X_5_PREFIX = "disable_fr_x5_";
    public static final String C_STR_CMD_DOWNLOAD_WHEN_NOT_INSTALL = "download_when_not_install";
    public static final String C_STR_CMD_DOWNLOAD_WHEN_PLUGIN_ERROR = "download_when_plugin_error";
    public static final String C_STR_CMD_DOWNLOAD_WHEN_X_5_FAIL = "download_when_x5_fail";
    public static final String C_STR_CMD_FILE_READER_PREFIX = "fr_";
    public static final String C_STR_CMD_MAX_DOWNLOAD_COUNT_WHEN_PLUGIN_ERROR = "max_download_count_when_plugin_error";
    public static final String C_STR_CMD_PLUGIN_PARAM_PREFIX = "param_";
    public static final String C_STR_CMD_SET_PLUGIN_CONFIG_PERIOD = "setPluginConfigPeriod";
    public static final String C_STR_CMD_USE_OFFICE_READER_PREFIX = "use_office_reader_";
    public static final String C_STR_CMD_X_FILES_HIDE_BOTTOM_BAR = "xfiles_hide_bottom_bar";
    public static final String C_STR_CMD_X_FILES_HIDE_CUSTOM_MENU = "xfiles_hide_custom_menu";
    public static final int DEFAULT_MAX_DOWNLOAD_COUNT_WHEN_PLUGIN_ERROR = 2;

    /* renamed from: e, reason: collision with root package name */
    public static CommandCfgPlugin f384892e;

    public static FileReaderHelper.ReaderType convertFileReader(String str) {
        FileReaderHelper.ReaderType readerType = FileReaderHelper.ReaderType.NONE;
        if (str != null && !str.isEmpty()) {
            try {
                return FileReaderHelper.ReaderType.valueOf(str);
            } catch (Throwable unused) {
                return FileReaderHelper.ReaderType.NONE;
            }
        }
        return readerType;
    }

    public static FileReaderHelper.UseOfficeReader convertUseOfficeReader(String str) {
        FileReaderHelper.UseOfficeReader useOfficeReader = FileReaderHelper.UseOfficeReader.none;
        if (str != null && !str.isEmpty()) {
            try {
                return FileReaderHelper.UseOfficeReader.valueOf(str);
            } catch (Throwable unused) {
                return FileReaderHelper.UseOfficeReader.none;
            }
        }
        return useOfficeReader;
    }

    public static synchronized CommandCfgPlugin getInstance() {
        CommandCfgPlugin commandCfgPlugin;
        synchronized (CommandCfgPlugin.class) {
            if (f384892e == null) {
                CommandCfgPlugin commandCfgPlugin2 = new CommandCfgPlugin();
                f384892e = commandCfgPlugin2;
                commandCfgPlugin2.initCommandConfigs();
            }
            commandCfgPlugin = f384892e;
        }
        return commandCfgPlugin;
    }

    public static synchronized void resetCommandCfgPlugin() {
        synchronized (CommandCfgPlugin.class) {
            x0.d("CommandCfgPlugin", "resetCommandCfg, module: " + XWalkEnvironment.getSafeModuleName(""));
            f384892e = null;
            getInstance();
        }
    }

    @Override // com.tencent.xweb.CommandCfg
    public void a(j[] jVarArr, String str, boolean z16) {
        String str2;
        if (str == null) {
            x0.d(b(), "applyCommandInternal, invalid configVersion");
            return;
        }
        x0.d(b(), "applyCommandInternal, configVersion:" + str + ", isRecheck:" + z16);
        a();
        HashMap hashMap = new HashMap();
        if (jVarArr != null && jVarArr.length != 0) {
            for (int i3 = 0; i3 < jVarArr.length; i3++) {
                j jVar = jVarArr[i3];
                if (jVar != null && (!z16 || !d(jVar.f121670b))) {
                    x0.d(b(), ">>> applyCommand, command[" + i3 + "]:" + jVarArr[i3]);
                    if (jVarArr[i3].f121669a.a(false, false, "CommandCfgPlugin")) {
                        CommandCfg.CmdHandleRet a16 = h.a(jVarArr[i3]);
                        if (a16 != null && a16.handled) {
                            x0.d(b(), "<<< applyCommand, command[" + i3 + "] handled");
                        } else {
                            j jVar2 = jVarArr[i3];
                            if (jVar2.f121671c != null && (str2 = jVar2.f121672d) != null && !str2.isEmpty()) {
                                boolean a17 = a(jVarArr[i3], hashMap, jVarArr[i3].f121672d.split(","));
                                x0.f(b(), "<<< applyCommand, apply command[" + i3 + "]:" + a17);
                            }
                        }
                    } else {
                        x0.f(b(), "<<< applyCommand, command[" + i3 + "] not match");
                    }
                }
            }
            b(str, hashMap);
            return;
        }
        x0.f(b(), "applyCommandInternal, empty new command configs");
        b(str, hashMap);
    }

    @Override // com.tencent.xweb.CommandCfg
    public String b() {
        return "CommandCfgPlugin";
    }

    public final String c() {
        if ("appbrand".equalsIgnoreCase(XWalkEnvironment.getSafeModuleName("tools"))) {
            x0.d(b(), "getSafeModuleForFileReader, use module appbrand");
            return "appbrand";
        }
        x0.d(b(), "getSafeModuleForFileReader, use module tools");
        return "tools";
    }

    public boolean canDownloadWhenNotInstall(boolean z16) {
        try {
            String cmd = getCmd(C_STR_CMD_DOWNLOAD_WHEN_NOT_INSTALL, c());
            if (cmd != null && !cmd.isEmpty()) {
                return Boolean.parseBoolean(cmd);
            }
            x0.d("CommandCfgPlugin", "canDownloadWhenNotInstall cmd is empty, return defValue = " + z16);
            return z16;
        } catch (Throwable th5) {
            x0.c(b(), "canDownloadWhenNotInstall error, return defValue = " + z16 + ", errorMsg = " + th5.getMessage());
            return z16;
        }
    }

    public boolean canDownloadWhenPluginError(boolean z16) {
        try {
            String cmd = getCmd(C_STR_CMD_DOWNLOAD_WHEN_PLUGIN_ERROR, c());
            if (cmd != null && !cmd.isEmpty()) {
                return Boolean.parseBoolean(cmd);
            }
            x0.d("CommandCfgPlugin", "canDownloadWhenPluginError cmd is empty, return defValue = " + z16);
            return z16;
        } catch (Throwable th5) {
            x0.c(b(), "canDownloadWhenPluginError error, return defValue = " + z16 + ", errorMsg = " + th5.getMessage());
            return z16;
        }
    }

    public boolean canDownloadWhenX5Fail(boolean z16) {
        try {
            String cmd = getCmd(C_STR_CMD_DOWNLOAD_WHEN_X_5_FAIL, c());
            if (cmd != null && !cmd.isEmpty()) {
                return Boolean.parseBoolean(cmd);
            }
            x0.d("CommandCfgPlugin", "canDownloadWhenX5Fail cmd is empty, return defValue = " + z16);
            return z16;
        } catch (Throwable th5) {
            x0.c(b(), "canDownloadWhenX5Fail error, return defValue = " + z16 + ", errorMsg = " + th5.getMessage());
            return z16;
        }
    }

    public FileReaderHelper.AudioPlayerStrategy getAudioPlayerStrategy(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    String cmd = getCmd(C_STR_CMD_AUDIO_PLAYER_STRATEGY_PREFIX + str.toLowerCase(), c());
                    if (cmd != null && !cmd.isEmpty()) {
                        return FileReaderHelper.AudioPlayerStrategy.valueOf(cmd);
                    }
                    return FileReaderHelper.AudioPlayerStrategy.auto;
                }
            } catch (Throwable th5) {
                x0.c(b(), "getAudioPlayerStrategy error:" + th5.getMessage());
                return FileReaderHelper.AudioPlayerStrategy.auto;
            }
        }
        return FileReaderHelper.AudioPlayerStrategy.auto;
    }

    public HashMap<String, String> getCmdPluginParam(String str) {
        String[] split;
        String[] split2;
        try {
            String cmd = getCmd(C_STR_CMD_PLUGIN_PARAM_PREFIX + str, "tools");
            if (cmd == null || cmd.isEmpty() || (split = cmd.split(",")) == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            for (String str2 : split) {
                if (str2 != null && !str2.isEmpty() && (split2 = str2.split("_")) != null && split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            return hashMap;
        } catch (Throwable th5) {
            x0.a(b(), "getCmdPluginParam error", th5);
            return null;
        }
    }

    public int getCmdPluginUpdatePeriod() {
        try {
            String cmd = getCmd(C_STR_CMD_SET_PLUGIN_CONFIG_PERIOD, "tools");
            if (cmd != null && !cmd.isEmpty()) {
                int parseInt = Integer.parseInt(cmd);
                if (parseInt < 30) {
                    return -1;
                }
                return parseInt * 60 * 1000;
            }
            return -1;
        } catch (Throwable th5) {
            x0.a(b(), "getCmdPluginUpdatePeriod error", th5);
            return -1;
        }
    }

    public FileReaderHelper.UseOfficeReader getCmdUseOfficeReader(String str, String str2) {
        return convertUseOfficeReader(getCmd(C_STR_CMD_USE_OFFICE_READER_PREFIX + str.toLowerCase(), str2));
    }

    public FileReaderHelper.ReaderType getFileReaderType(String str, String str2) {
        return convertFileReader(getCmd(C_STR_CMD_FILE_READER_PREFIX + str.toLowerCase(), str2));
    }

    public int getMaxDownloadCountWhenPluginError() {
        try {
            String cmd = getCmd(C_STR_CMD_MAX_DOWNLOAD_COUNT_WHEN_PLUGIN_ERROR, c());
            if (cmd != null && !cmd.isEmpty()) {
                int parseInt = Integer.parseInt(cmd);
                if (parseInt < 0) {
                    return 2;
                }
                return parseInt;
            }
            return 2;
        } catch (Throwable th5) {
            x0.a(b(), "getMaxDownloadCountWhenPluginError error", th5);
            return 2;
        }
    }

    @Override // com.tencent.xweb.CommandCfg
    public SharedPreferences getSharePreferenceForCommandConfig() {
        return y0.d();
    }

    @Override // com.tencent.xweb.CommandCfg
    public SharedPreferences getSharePreferenceForCommandConfigLatest() {
        return y0.e();
    }

    public boolean isDisableFileReaderX5(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    String cmd = getCmd(C_STR_CMD_DISABLE_FILE_READER_X_5_PREFIX + str.toLowerCase(), c());
                    if (cmd != null && !cmd.isEmpty()) {
                        return Boolean.parseBoolean(cmd);
                    }
                    return false;
                }
            } catch (Throwable th5) {
                x0.a(b(), "isDisableFileReaderX5 error", th5);
            }
        }
        return false;
    }

    public boolean isXFilesHideBottomBar() {
        try {
            String cmd = getCmd(C_STR_CMD_X_FILES_HIDE_BOTTOM_BAR, c());
            if (cmd != null && !cmd.isEmpty()) {
                return Boolean.parseBoolean(cmd);
            }
            return false;
        } catch (Throwable th5) {
            x0.a(b(), "isXFilesHideBottomBar error", th5);
            return false;
        }
    }

    public boolean isXFilesHideCustomMenu() {
        try {
            String cmd = getCmd(C_STR_CMD_X_FILES_HIDE_CUSTOM_MENU, c());
            if (cmd != null && !cmd.isEmpty()) {
                return Boolean.parseBoolean(cmd);
            }
            return false;
        } catch (Throwable th5) {
            x0.a(b(), "isXFilesHideCustomMenu error", th5);
            return false;
        }
    }

    public FileReaderHelper.UseOfficeReader getCmdUseOfficeReader(String str) {
        return getCmdUseOfficeReader(str, XWalkEnvironment.getSafeModuleName("tools"));
    }

    public FileReaderHelper.ReaderType getFileReaderType(String str) {
        return getFileReaderType(str, c());
    }
}
