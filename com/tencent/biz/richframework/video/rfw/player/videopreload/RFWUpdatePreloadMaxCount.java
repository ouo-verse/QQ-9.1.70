package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Message;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* loaded from: classes5.dex */
public class RFWUpdatePreloadMaxCount extends RFWVideoPreloadBaseMsgProcess {
    public RFWUpdatePreloadMaxCount(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBaseMsgProcess
    public boolean handlerMsg(Message message) {
        int taskIdFromMsg = getTaskIdFromMsg(message);
        if (taskIdFromMsg > 0) {
            RFWVideoPreloadManager.sPreloadMaxCount = taskIdFromMsg;
            RFWLog.d("QFSVideoPreload_QFSUpdatePreloadMaxCount", RFWLog.USR, "update current preloadCount:" + RFWVideoPreloadManager.sPreloadMaxCount);
        }
        return true;
    }
}
