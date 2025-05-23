package com.tencent.gamecenter.wadl.sdk.ipc;

import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface WadlHandlerInterface {
    void clearAllTask();

    void handleRemoteActionNotify(WadlRequest wadlRequest);

    boolean isActive(boolean z16);

    void notifyEventObserver(int i3, boolean z16, WadlTask wadlTask);

    void onCreate();

    void onDestroy();

    void pauseAllDownloadTask(boolean z16);

    void refreshLastActiveTime();

    void resumeAllDownloadTask();
}
