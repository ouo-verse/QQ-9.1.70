package com.tencent.qqmini.sdk.launcher.ipc;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqmini/sdk/launcher/ipc/GamePkgIPCConst;", "", "()V", "CMD_DOWNLOAD_FAIL", "", "CMD_DOWNLOAD_SUCCESS", "CMD_PROGRESS", "KEY_CMD", "", "KEY_ERROR_MSG", "KEY_GAME_CONFIG", "KEY_GAME_SUB_PKG_INFO", "KEY_GAME_SUB_PKG_ROOT", "KEY_IGNORE_PROGRESS", "KEY_PROGRESS", "KEY_SUB_PKG_PATH", "KEY_TOTAL_FILE_SIZE", "lib_minilauncher_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class GamePkgIPCConst {
    public static final int CMD_DOWNLOAD_FAIL = 2;
    public static final int CMD_DOWNLOAD_SUCCESS = 3;
    public static final int CMD_PROGRESS = 1;
    public static final GamePkgIPCConst INSTANCE = new GamePkgIPCConst();

    @NotNull
    public static final String KEY_CMD = "game_package_key";

    @NotNull
    public static final String KEY_ERROR_MSG = "game_package_error_msg";

    @NotNull
    public static final String KEY_GAME_CONFIG = "game_package_app_info";

    @NotNull
    public static final String KEY_GAME_SUB_PKG_INFO = "game_sub_package_info";

    @NotNull
    public static final String KEY_GAME_SUB_PKG_ROOT = "game_sub_package_root";

    @NotNull
    public static final String KEY_IGNORE_PROGRESS = "game_package_ignore_progress";

    @NotNull
    public static final String KEY_PROGRESS = "game_package_progress";

    @NotNull
    public static final String KEY_SUB_PKG_PATH = "game_package_sub_package_path";

    @NotNull
    public static final String KEY_TOTAL_FILE_SIZE = "game_package_file_size";

    GamePkgIPCConst() {
    }
}
