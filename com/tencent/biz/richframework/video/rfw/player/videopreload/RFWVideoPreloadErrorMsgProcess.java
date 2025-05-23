package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Message;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* loaded from: classes5.dex */
public class RFWVideoPreloadErrorMsgProcess extends RFWVideoPreloadBaseMsgProcess {
    public RFWVideoPreloadErrorMsgProcess(int i3) {
        super(i3);
    }

    private boolean handlerPreloadError(Message message) {
        int taskIdFromMsg = getTaskIdFromMsg(message);
        if (taskIdFromMsg <= 0) {
            return false;
        }
        RFWVideoPreloadBean rFWVideoPreloadBean = RFWVideoPreloadManager.g(this.mSceneId).getHistoryMap().get(Integer.valueOf(taskIdFromMsg));
        if (rFWVideoPreloadBean == null) {
            RFWLog.d("QFSVideoPreload_QFSVideoPreloadErrorMsgProcess", RFWLog.CLR, "handlerError no record error,taskId:" + taskIdFromMsg);
            return false;
        }
        RFWVideoPreloadManager.g(this.mSceneId).getPreloadMap().remove(Integer.valueOf(taskIdFromMsg), rFWVideoPreloadBean);
        RFWVideoPreloadManager.g(this.mSceneId).getHistoryMap().remove(Integer.valueOf(taskIdFromMsg), rFWVideoPreloadBean);
        rFWVideoPreloadBean.setPreloadStatus(3);
        RFWVideoPreloadManager.g(this.mSceneId).onPreloadFinish(rFWVideoPreloadBean);
        RFWLog.d("QFSVideoPreload_QFSVideoPreloadErrorMsgProcess", RFWLog.USR, rFWVideoPreloadBean.getPreTag() + "handlerPreloadError");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBaseMsgProcess
    public boolean handlerMsg(Message message) {
        return handlerPreloadError(message);
    }
}
