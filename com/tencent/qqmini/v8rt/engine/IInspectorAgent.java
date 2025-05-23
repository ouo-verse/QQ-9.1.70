package com.tencent.qqmini.v8rt.engine;

import com.tencent.qqmini.v8rt.anno.NotNull;
import com.tencent.qqmini.v8rt.anno.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IInspectorAgent {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IDebuggerMessageListener {
        void sendMessageToEngine(@NotNull String str);
    }

    boolean isWaitForDebugger();

    void sendMessageToDebugger(@NotNull String str);

    void setOnDebuggerMessageListener(@Nullable IDebuggerMessageListener iDebuggerMessageListener);

    void stop();
}
