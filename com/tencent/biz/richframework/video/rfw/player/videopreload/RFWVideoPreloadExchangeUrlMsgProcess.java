package com.tencent.biz.richframework.video.rfw.player.videopreload;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerConfig;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerManger;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.LinkedList;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWVideoPreloadExchangeUrlMsgProcess extends RFWVideoPreloadBaseMsgProcess {
    public RFWVideoPreloadExchangeUrlMsgProcess(int i3) {
        super(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createRecordToCheckPreloadNum(RFWVideoPreloadBean rFWVideoPreloadBean, RFWPlayerOptions rFWPlayerOptions) {
        int preloadDuration;
        String targetIPURL;
        if (rFWVideoPreloadBean.isMultiLevel()) {
            preloadDuration = getPreloadDuration(true, RFWVideoPreloadManager.PRELOAD_DURATION);
        } else if (rFWVideoPreloadBean.isSimpleFeed()) {
            preloadDuration = getPreloadDuration(true, uq3.c.X0("qqcircle", "qqcircle_video_preload_duration_simple_feed", 3000).intValue());
        } else {
            preloadDuration = getPreloadDuration(false, uq3.c.X0("qqcircle", "qqcircle_video_preload_duration_prefetch_feed", 3000).intValue());
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_use_ip_url_back_up", true)) {
            if (TextUtils.isEmpty(rFWPlayerOptions.getRealPlayUrl())) {
                targetIPURL = rFWPlayerOptions.getTargetIPURL();
            } else {
                targetIPURL = rFWPlayerOptions.getRealPlayUrl();
            }
        } else if (TextUtils.isEmpty(rFWPlayerOptions.getTargetIPURL())) {
            targetIPURL = rFWPlayerOptions.getRealPlayUrl();
        } else {
            targetIPURL = rFWPlayerOptions.getTargetIPURL();
        }
        RFWLog.d(rFWPlayerOptions.tag(), RFWLog.USR, "FeedLine_createRecordToCheckPreloadNum preloadDuration:" + preloadDuration + " | preloadUrl: " + targetIPURL);
        rFWVideoPreloadBean.setPreloadTime(System.currentTimeMillis()).setPreloadSelectedUrl(targetIPURL).setVid(rFWPlayerOptions.getStVideo().getFileId()).setPreloadDuration(preloadDuration).setVideoDuration(rFWPlayerOptions.getStVideo().getDuration());
        RFWVideoPreloadManager.g(this.mSceneId).beforePreloadStart(rFWVideoPreloadBean);
        RFWVideoPreloadManager.g(this.mSceneId).sendMsg(1, rFWVideoPreloadBean);
        RFWLog.d(rFWPlayerOptions.tag(), RFWLog.USR, rFWVideoPreloadBean.getPreTag() + " createRecordToCheckPreloadNum success");
    }

    private void exchangeVideoUrl(final RFWVideoPreloadBean rFWVideoPreloadBean, String str) {
        RFWStVideo preloadVideo = rFWVideoPreloadBean.getPreloadVideo();
        RFWPlayerOptions stVideo = RFWPlayerOptions.obtain(this.mSceneId).setFileId(preloadVideo.getFileId()).setFromType(10000).setPlayUrl(preloadVideo.getPlayUrl()).setPreloadSourceType(str).setRealPlayBean(new RFWVideoUrlBean(preloadVideo)).setStVideo(preloadVideo);
        rFWVideoPreloadBean.setPreloadOptions(stVideo);
        RFWPlayerOptionsProcessManager.g().startProcess(getProcessOrder(rFWVideoPreloadBean, str), stVideo, new RFWPlayerOptionsProcessManager.IProcessCallBack() { // from class: com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadExchangeUrlMsgProcess.1
            @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager.IProcessCallBack
            public void onFinish(RFWPlayerOptions rFWPlayerOptions, boolean z16) {
                RFWLog.d(rFWPlayerOptions.tag(), RFWLog.USR, "preloadDownLoadExchangeUrl finish result:" + rFWPlayerOptions);
                RFWVideoPreloadExchangeUrlMsgProcess.this.createRecordToCheckPreloadNum(rFWVideoPreloadBean, rFWPlayerOptions);
            }
        });
    }

    private int getPreloadDuration(boolean z16, int i3) {
        if (!com.tencent.mobileqq.qcircle.api.utils.c.h()) {
            return i3;
        }
        if (o.a2()) {
            return o.n0();
        }
        return i3;
    }

    private LinkedList<String> getProcessOrder(RFWVideoPreloadBean rFWVideoPreloadBean, String str) {
        RFWPlayerConfig config = RFWPlayerManger.g(this.mSceneId).getConfig();
        if (config != null && config.getProcessOrder() != null) {
            return config.getProcessOrder().getPreloadVideoOrder(rFWVideoPreloadBean, str);
        }
        RFWLog.d("QFSVideoPreload_QFSVideoPreloadExchangeUrlMsgProcess", RFWLog.USR, "preloadDownLoadExchangeUrl no order:" + this.mSceneId);
        return new LinkedList<>();
    }

    private boolean handlerExchangeURL(Message message) {
        if (!isValidExChangeUrlMsg(message)) {
            return false;
        }
        Object[] objArr = (Object[]) message.obj;
        RFWVideoPreloadBean rFWVideoPreloadBean = (RFWVideoPreloadBean) objArr[0];
        if (rFWVideoPreloadBean.getPreloadVideo() == null) {
            RFWLog.d("QFSVideoPreload_QFSVideoPreloadExchangeUrlMsgProcess", RFWLog.USR, "handlerExchangeURL return has not video");
            return false;
        }
        RFWVideoPreloadBean preloadRecord = RFWVideoPreloadManager.g(this.mSceneId).getPreloadRecord(rFWVideoPreloadBean.getPreloadVideo().getFileId(), false);
        if (preloadRecord != null) {
            RFWLog.d("QFSVideoPreload_QFSVideoPreloadExchangeUrlMsgProcess", RFWLog.USR, preloadRecord.getPreTag() + "handlerExchangeURL return has preload");
            return false;
        }
        exchangeVideoUrl(rFWVideoPreloadBean, (String) objArr[1]);
        return true;
    }

    private boolean isValidExChangeUrlMsg(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Object[])) {
            return false;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length < 2 || !(objArr[0] instanceof RFWVideoPreloadBean) || !(objArr[1] instanceof String)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBaseMsgProcess
    public boolean handlerMsg(Message message) {
        return handlerExchangeURL(message);
    }
}
