package com.tencent.biz.richframework.video.rfw.player.optionsprocess;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerConfig;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerManger;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.mobileqq.utils.FileUtils;

/* loaded from: classes5.dex */
public class RFWPlayerOptionsLocalPathProcess implements IRFWPlayerOptionsProcess {
    public static String DEFAULT_PROCESS_LOCAL = "DEFAULT_PROCESS_LOCAL";

    private String getLocalPath(RFWPlayerOptions rFWPlayerOptions) {
        RFWPlayerConfig config = RFWPlayerManger.g(rFWPlayerOptions.getSceneId()).getConfig();
        if (config != null && config.getFieldToLocalPath() != null) {
            return config.getFieldToLocalPath().getLocalPath(rFWPlayerOptions.getFileId());
        }
        return "";
    }

    public /* synthetic */ String a(RFWPlayerOptions rFWPlayerOptions) {
        return a.a(this, rFWPlayerOptions);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public String getProcessKey() {
        return DEFAULT_PROCESS_LOCAL;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.IRFWPlayerOptionsProcess
    public void onProcess(RFWPlayerOptions rFWPlayerOptions, RFWPlayerOptionsProcessManager.IProcessCallBack iProcessCallBack) {
        if (rFWPlayerOptions != null && iProcessCallBack != null) {
            String playUrl = rFWPlayerOptions.getPlayUrl();
            if (FileUtils.fileExists(playUrl)) {
                rFWPlayerOptions.setRealPlayUrl(playUrl);
                rFWPlayerOptions.setIsLocalVideo(true);
                iProcessCallBack.onFinish(rFWPlayerOptions, false);
                return;
            }
            String fileId = rFWPlayerOptions.getFileId();
            String localPath = getLocalPath(rFWPlayerOptions);
            if (FileUtils.fileExists(localPath)) {
                RFWLog.d(a(rFWPlayerOptions), RFWLog.USR, "QFSPlayerOptionsLocalPathProcess()|play local video, videoPath:" + localPath + " \uff5c filedId: " + fileId);
                rFWPlayerOptions.setRealPlayUrl(localPath);
                rFWPlayerOptions.setIsLocalVideo(true);
                iProcessCallBack.onFinish(rFWPlayerOptions, false);
                return;
            }
            RFWLog.d(a(rFWPlayerOptions), RFWLog.USR, "QFSPlayerOptionsLocalPathProcess()|play remote video url:" + rFWPlayerOptions.getPlayUrl() + " | filedId: " + fileId);
            iProcessCallBack.onFinish(rFWPlayerOptions, true);
        }
    }
}
