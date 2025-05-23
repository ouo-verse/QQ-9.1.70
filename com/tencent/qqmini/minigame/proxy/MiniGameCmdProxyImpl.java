package com.tencent.qqmini.minigame.proxy;

import android.os.Bundle;
import com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.CmdProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;

@ProxyService(proxy = CmdProxy.class)
/* loaded from: classes23.dex */
public class MiniGameCmdProxyImpl implements CmdProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.CmdProxy
    public void handleMiniAppCmd(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        if (IPCConst.CMD_QUEUE_MINI_PROCESS_LOAD_APKG.equals(str) || IPCConst.CMD_REMOVE_MINI_PROCESS_LOAD_APKG.equals(str) || IPCConst.CMD_MAIN_PROCESS_LOAD_PKG.equals(str) || "cmd_update_triton_engine".equals(str) || IPCConst.CMD_DOWNLOAD_GAME_PKG.equals(str) || IPCConst.CMD_DOWNLOAD_GAME_SUB_PKG.equals(str) || IPCConst.CMD_CONSOLE_LOG.equals(str)) {
            ApkgMainProcessManager.handleMiniAppCmd(str, bundle, miniCmdCallback);
        }
    }
}
