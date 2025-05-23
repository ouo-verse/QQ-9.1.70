package com.tencent.qqmini.minigame.action;

import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.debug.QQDebugWebSocket;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DebugSocketAction implements Action<Boolean> {
    public static final int QUIT_DEBUG_SOCKET = 2;
    public static final int SEND_DEBUG_MSG = 1;
    private int action;
    private String cmd;
    private String data;
    private IMiniAppContext miniAppContext;

    public static DebugSocketAction obtain(IMiniAppContext iMiniAppContext) {
        DebugSocketAction debugSocketAction = new DebugSocketAction();
        debugSocketAction.miniAppContext = iMiniAppContext;
        return debugSocketAction;
    }

    public void quitDebugSocket() {
        this.action = 2;
        this.miniAppContext.performAction(this);
    }

    public void sendQQDebugMethodMsg(String str, String str2) {
        this.action = 1;
        this.cmd = str;
        this.data = str2;
        this.miniAppContext.performAction(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        if (!(baseRuntime instanceof GameRuntime)) {
            return Boolean.FALSE;
        }
        QQDebugWebSocket qQDebugSocket = ((GameRuntime) baseRuntime).getQQDebugSocket();
        if (qQDebugSocket == null) {
            QMLog.w(Action.TAG, "QQDebugWebSocket is null");
            return Boolean.FALSE;
        }
        int i3 = this.action;
        if (i3 == 1) {
            qQDebugSocket.sendQQDebugMethodMsg(this.cmd, this.data);
        } else if (i3 == 2) {
            qQDebugSocket.sendQuitDebugMsgInfo();
        }
        return Boolean.TRUE;
    }
}
