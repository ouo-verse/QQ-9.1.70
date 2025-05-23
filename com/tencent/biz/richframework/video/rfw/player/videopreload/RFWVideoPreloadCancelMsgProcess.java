package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Message;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.report.RFWPlayerNetFlowReporter;

/* loaded from: classes5.dex */
public class RFWVideoPreloadCancelMsgProcess extends RFWVideoPreloadBaseMsgProcess {
    public RFWVideoPreloadCancelMsgProcess(int i3) {
        super(i3);
    }

    private boolean handlerPreloadCancel(Message message) {
        RFWVideoPreloadBean recordFormMsg = getRecordFormMsg(message);
        if (recordFormMsg == null) {
            RFWLog.e("QFSVideoPreload_QFSVideoPreloadCancelMsgProcess", RFWLog.USR, "handlerPreloadCancel no record");
            return false;
        }
        RFWVideoPreloadManager.g(this.mSceneId).getPreLoader().stopPreDownload(recordFormMsg.getPreloadTaskId());
        RFWVideoPreloadManager.g(this.mSceneId).getPreloadMap().remove(Integer.valueOf(recordFormMsg.getPreloadTaskId()), recordFormMsg);
        RFWPlayerNetFlowReporter.reportPlayerNetFlow(String.valueOf(recordFormMsg.getPreloadTaskId()));
        RFWLog.d("QFSVideoPreload_QFSVideoPreloadCancelMsgProcess", RFWLog.USR, recordFormMsg.getPreTag() + "handler cancel success");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBaseMsgProcess
    public boolean handlerMsg(Message message) {
        return handlerPreloadCancel(message);
    }
}
