package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Message;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;

/* loaded from: classes5.dex */
public class RFWVideoPreloadSuccessMsgProcess extends RFWVideoPreloadBaseMsgProcess {
    public RFWVideoPreloadSuccessMsgProcess(int i3) {
        super(i3);
    }

    private float getCacheTimeS(RFWVideoPreloadBean rFWVideoPreloadBean) {
        if (rFWVideoPreloadBean.getPreloadSelectedUrl() != null && rFWVideoPreloadBean.getPlayerOptions() != null && rFWVideoPreloadBean.getPlayerOptions().getFileId() != null && rFWVideoPreloadBean.getPlayerOptions().getRealPlayBean() != null) {
            return RFWVideoUtils.computeCacheTimeS(this.mSceneId, rFWVideoPreloadBean.getPreloadSelectedUrl(), rFWVideoPreloadBean.getPlayerOptions().getFileId(), rFWVideoPreloadBean.getPlayerOptions().getRealPlayBean().mRate);
        }
        return 0.0f;
    }

    private boolean handlerPreloadSuccess(Message message) {
        int taskIdFromMsg = getTaskIdFromMsg(message);
        if (taskIdFromMsg <= 0) {
            return false;
        }
        RFWVideoPreloadBean rFWVideoPreloadBean = RFWVideoPreloadManager.g(this.mSceneId).getHistoryMap().get(Integer.valueOf(taskIdFromMsg));
        if (rFWVideoPreloadBean == null) {
            RFWLog.d("QFSVideoPreload_QFSVideoPreloadSuccessMsgProcess", RFWLog.CLR, "handlerSuccess no record error,taskId:" + taskIdFromMsg);
            return false;
        }
        RFWVideoPreloadManager.g(this.mSceneId).getPreloadMap().remove(Integer.valueOf(taskIdFromMsg), rFWVideoPreloadBean);
        rFWVideoPreloadBean.setPreloadStatus(2);
        RFWVideoPreloadManager.g(this.mSceneId).onPreloadFinish(rFWVideoPreloadBean);
        float cacheTimeS = getCacheTimeS(rFWVideoPreloadBean);
        RFWLog.d("QFSVideoPreload_QFSVideoPreloadSuccessMsgProcess", RFWLog.USR, "handlerPreloadSuccess:\u9884\u4e0b\u8f7d\u65f6\u957f\uff1a" + cacheTimeS + " |" + rFWVideoPreloadBean.getPreTag());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBaseMsgProcess
    public boolean handlerMsg(Message message) {
        return handlerPreloadSuccess(message);
    }
}
