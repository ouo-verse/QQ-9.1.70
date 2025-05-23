package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;

/* loaded from: classes23.dex */
public interface CmdProxy {
    void handleMiniAppCmd(String str, Bundle bundle, MiniCmdCallback miniCmdCallback);
}
