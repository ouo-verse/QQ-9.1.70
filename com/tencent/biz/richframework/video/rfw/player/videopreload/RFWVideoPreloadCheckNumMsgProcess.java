package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Message;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.Map;

/* loaded from: classes5.dex */
public class RFWVideoPreloadCheckNumMsgProcess extends RFWVideoPreloadBaseMsgProcess {
    public RFWVideoPreloadCheckNumMsgProcess(int i3) {
        super(i3);
    }

    private void cancelRunningTaskFromCheckNum(int i3) {
        int i16 = i3 - RFWVideoPreloadManager.sPreloadMaxCount;
        for (int i17 = 0; i17 <= i16; i17++) {
            Map.Entry<Integer, RFWVideoPreloadBean> firstEntry = RFWVideoPreloadManager.g(this.mSceneId).getPreloadMap().firstEntry();
            if (firstEntry != null) {
                RFWVideoPreloadManager.g(this.mSceneId).getPreloadMap().remove(firstEntry.getKey());
                RFWVideoPreloadManager.g(this.mSceneId).sendMsg(3, firstEntry.getValue());
                RFWLog.d("QFSVideoPreload_QFSVideoPreloadCheckNumMsgProcess", RFWLog.USR, firstEntry.getValue().getPreTag() + " begin to cancel fromCheckNum | current preloadCount:" + i3);
            } else {
                return;
            }
        }
    }

    private boolean handlerCheckPreloadNum(Message message) {
        RFWVideoPreloadBean recordFormMsg = getRecordFormMsg(message);
        if (recordFormMsg == null) {
            return false;
        }
        int size = RFWVideoPreloadManager.g(this.mSceneId).getPreloadMap().size();
        if (size >= RFWVideoPreloadManager.sPreloadMaxCount) {
            cancelRunningTaskFromCheckNum(size);
        }
        RFWVideoPreloadManager.g(this.mSceneId).sendMsg(2, recordFormMsg);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBaseMsgProcess
    public boolean handlerMsg(Message message) {
        return handlerCheckPreloadNum(message);
    }
}
