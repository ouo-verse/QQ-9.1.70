package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Message;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* loaded from: classes5.dex */
public class RFWVideoPreloadStopAllProcess extends RFWVideoPreloadBaseMsgProcess {
    public RFWVideoPreloadStopAllProcess(int i3) {
        super(i3);
    }

    private boolean handlerStopAll() {
        RFWVideoPreloadManager.g(this.mSceneId).getPreLoader().stopAllPreDownload();
        RFWVideoPreloadManager.g(this.mSceneId).getPreloadMap().clear();
        RFWLog.d("QFSVideoPreload_QFSVideoPreloadStopAllProcess", RFWLog.USR, "handlerStopAll success");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBaseMsgProcess
    public boolean handlerMsg(Message message) {
        return handlerStopAll();
    }
}
