package com.tencent.biz.richframework.video.rfw.player.optionsprocess;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBean;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.mobileqq.engineering.preload.PreLoader;

/* loaded from: classes5.dex */
public class RFWPlayerOptionPreloadCheckProcess implements IRFWPlayerOptionsProcess {
    public static String DEFAULT_PROCESS_PRELOAD_CHECK = "DEFAULT_PROCESS_PRELOAD_CHECK";

    public /* synthetic */ String a(RFWPlayerOptions rFWPlayerOptions) {
        return a.a(this, rFWPlayerOptions);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public String getProcessKey() {
        return DEFAULT_PROCESS_PRELOAD_CHECK;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public void onProcess(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        boolean z16;
        boolean z17;
        if (rFWPlayerOptions != null && iProcessCallBack != null) {
            String fileId = rFWPlayerOptions.getFileId();
            RFWVideoPreloadBean preloadRecord = RFWVideoPreloadManager.g(rFWPlayerOptions.getSceneId()).getPreloadRecord(fileId);
            if (preloadRecord != null && !TextUtils.isEmpty(preloadRecord.getPreloadSelectedUrl())) {
                rFWPlayerOptions.setRealPlayUrl(preloadRecord.getPreloadSelectedUrl()).setPlayUrl(preloadRecord.getPlayerOptions().getPlayUrl()).setPredictSpeed(preloadRecord.getPlayerOptions().getPredictSpeed()).setRealPlayBean(preloadRecord.getPlayerOptions().getRealPlayBean()).setVecUrlBean(preloadRecord.getPlayerOptions().getVecUrlBean()).setServerPlayBean(preloadRecord.getPlayerOptions().getServerPlayBean()).setTargetIPURl(preloadRecord.getPlayerOptions().getTargetIPURL()).setHasHitPreLoadCache(true).setPreDownloadTag(preloadRecord.getPlayerOptions().tag());
            }
            rFWPlayerOptions.setHasReusePlayer(RFWPlayerReuseUtils.hasReusePlayer(fileId));
            if (PreLoader.exists(fileId) && RFWPlayerPreRenderHelper.getInstance().isPreRender(fileId) && !rFWPlayerOptions.isPreloadPlayer()) {
                z16 = true;
            } else {
                z16 = false;
            }
            rFWPlayerOptions.setHasPreLoadPlayer(z16);
            if (!rFWPlayerOptions.hitPreloadCache() && !rFWPlayerOptions.hasPreLoadPlayer() && !rFWPlayerOptions.hasReusePlayer()) {
                z17 = true;
            } else {
                z17 = false;
            }
            RFWLog.d(a(rFWPlayerOptions), RFWLog.USR, "QFSPlayerPreloadChekProcess()| hasPreloadPlayer:" + rFWPlayerOptions.hasPreLoadPlayer() + " | hitPreloadCache:" + rFWPlayerOptions.hitPreloadCache() + " | hasReusePlayer:" + rFWPlayerOptions.hasReusePlayer() + " | continueNext:" + iProcessCallBack);
            iProcessCallBack.onFinish(rFWPlayerOptions, z17);
        }
    }
}
