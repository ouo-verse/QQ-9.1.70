package com.tencent.biz.richframework.video.rfw.player.optionsprocess;

import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;

/* loaded from: classes5.dex */
public interface IRFWPlayerOptionsProcess {
    String getProcessKey();

    void onProcess(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack);
}
