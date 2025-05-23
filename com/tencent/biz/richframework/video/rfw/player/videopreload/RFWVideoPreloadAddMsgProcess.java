package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPCDNRecorderManager;
import com.tencent.biz.richframework.video.rfw.RFWVideoUrlBackUpUtils;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerP2PParams;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

/* loaded from: classes5.dex */
public class RFWVideoPreloadAddMsgProcess extends RFWVideoPreloadBaseMsgProcess {
    public RFWVideoPreloadAddMsgProcess(int i3) {
        super(i3);
    }

    private boolean handlerPreloadAdd(Message message) {
        int i3;
        RFWVideoPreloadBean recordFormMsg = getRecordFormMsg(message);
        if (recordFormMsg == null) {
            RFWLog.e("QFSVideoPreload_QFSVideoPreloadAddMsgProcess", RFWLog.USR, "handlerAdd error msg");
            return false;
        }
        recordFormMsg.setPreloadSelectedUrl(recordFormMsg.getPreloadSelectedUrl());
        SuperPlayerVideoInfo createSuperVideoInfo = RFWVideoUtils.createSuperVideoInfo(recordFormMsg.getVid(), recordFormMsg.getPreloadSelectedUrl(), RFWVideoUrlBackUpUtils.getBackUpVideoUrl(recordFormMsg.getPlayerOptions()), recordFormMsg.getPlayerOptions().getHost(), recordFormMsg.getVideoDuration(), recordFormMsg.getPlayerOptions().getVideoFormat(), recordFormMsg.getPlayerOptions());
        if (createSuperVideoInfo == null) {
            RFWLog.e("QFSVideoPreload_QFSVideoPreloadAddMsgProcess", RFWLog.USR, "doStartPreloadInner error,invalid params!");
            return false;
        }
        SuperPlayerDownOption obtain = SuperPlayerDownOption.obtain();
        RFWPlayerP2PParams rFWPlayerP2PParams = new RFWPlayerP2PParams();
        if (rFWPlayerP2PParams.isEnablePreloadP2P()) {
            obtain.enableP2P = rFWPlayerP2PParams.isEnableP2P();
        }
        if (rFWPlayerP2PParams.isEnablePreloadPCDN(RFWVideoUtils.getUrlHost(createSuperVideoInfo.getPlayUrl())) && RFWPCDNRecorderManager.g().enablePCDN(createSuperVideoInfo.getFileId())) {
            obtain.enablePcdn = true;
        }
        if (recordFormMsg.isQUIC()) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        obtain.quicEnableMode = i3;
        if (TextUtils.equals(recordFormMsg.getPlayerOptions().getPreloadSourceType(), "enter_page")) {
            RFWLog.d("QFSVideoPreload_QFSVideoPreloadAddMsgProcess", RFWLog.USR, recordFormMsg.getPreTag() + " disable preload limit speed");
            obtain.enablePreloadLimitSpeed = false;
        }
        int startPreDownload = RFWVideoPreloadManager.g(this.mSceneId).getPreLoader().startPreDownload(createSuperVideoInfo, recordFormMsg.getVideoDuration(), recordFormMsg.getPreloadDuration(), obtain);
        recordFormMsg.setPreloadTaskId(startPreDownload).setPreloadStatus(0);
        RFWVideoPreloadManager.g(this.mSceneId).getPreloadMap().put(Integer.valueOf(startPreDownload), recordFormMsg);
        RFWVideoPreloadManager.g(this.mSceneId).getHistoryMap().put(Integer.valueOf(startPreDownload), recordFormMsg);
        RFWLog.d("QFSVideoPreload_QFSVideoPreloadAddMsgProcess", RFWLog.USR, recordFormMsg.getPreTag() + "add to download success");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBaseMsgProcess
    public boolean handlerMsg(Message message) {
        return handlerPreloadAdd(message);
    }
}
