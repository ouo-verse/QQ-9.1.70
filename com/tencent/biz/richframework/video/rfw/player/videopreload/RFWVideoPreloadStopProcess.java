package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Message;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
public class RFWVideoPreloadStopProcess extends RFWVideoPreloadBaseMsgProcess {
    public RFWVideoPreloadStopProcess(int i3) {
        super(i3);
    }

    private boolean handlerStop(Message message) {
        if (!isValidFeedSelectedMsg(message)) {
            return false;
        }
        String str = (String) ((Object[]) message.obj)[0];
        Iterator<Map.Entry<Integer, RFWVideoPreloadBean>> it = RFWVideoPreloadManager.g(this.mSceneId).getHistoryMap().entrySet().iterator();
        while (it.hasNext()) {
            RFWVideoPreloadBean value = it.next().getValue();
            if (str.equals(value.getVid())) {
                RFWVideoPreloadManager.g(this.mSceneId).getPreLoader().stopPreDownload(value.getPreloadTaskId());
                RFWVideoPreloadManager.g(this.mSceneId).getPreloadMap().remove(Integer.valueOf(value.getPreloadTaskId()), value);
                RFWLog.d("QFSVideoPreload_QFSVideoPreloadStopProcess", RFWLog.USR, value.getPreTag() + "handlerFeedSelected success");
                return true;
            }
        }
        return false;
    }

    private boolean isValidFeedSelectedMsg(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Object[])) {
            return false;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length < 1 || !(objArr[0] instanceof String)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBaseMsgProcess
    public boolean handlerMsg(Message message) {
        return handlerStop(message);
    }
}
