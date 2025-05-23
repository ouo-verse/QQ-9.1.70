package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Message;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* loaded from: classes5.dex */
public class RFWVideoPreloadProgressMsgProcess extends RFWVideoPreloadBaseMsgProcess {
    public RFWVideoPreloadProgressMsgProcess(int i3) {
        super(i3);
    }

    private boolean handlePreloadProgress(Message message) {
        int taskIdFromMsg = getTaskIdFromMsg(message);
        if (taskIdFromMsg <= 0) {
            return false;
        }
        RFWVideoPreloadBean rFWVideoPreloadBean = RFWVideoPreloadManager.g(this.mSceneId).getHistoryMap().get(Integer.valueOf(taskIdFromMsg));
        if (rFWVideoPreloadBean == null) {
            RFWLog.d("QFSVideoPreload_QFSVideoPreloadProgressMsgProcess", RFWLog.CLR, "handlerSuccess no record error,taskId:" + taskIdFromMsg);
            return false;
        }
        rFWVideoPreloadBean.setPreloadStatus(1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBaseMsgProcess
    public boolean handlerMsg(Message message) {
        return handlePreloadProgress(message);
    }
}
