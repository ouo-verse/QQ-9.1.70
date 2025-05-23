package com.tencent.biz.richframework.video.rfw.drive;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.RFWTVKPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerConfig;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerManger;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionH264ReSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionPreloadCheckProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionURLSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerPlayerDirectIPProcess;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBean;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import java.util.LinkedList;

/* loaded from: classes5.dex */
public class RFWLayerVideoPreloadScroller extends RFWLayerBaseScroller {
    private static final int PRELOAD_DEFAULT_COUNT = uq3.c.D0();
    private final IRFWViewPager2AdapterDrive mAdapter;
    private boolean mHasPreloadOnce;
    private String mLastLogMsg;
    private int mScrollRecordSelectedPoi = -1;
    private PreLoadBean mPreLoadBean = new PreLoadBean();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class PreLoadBean {
        private boolean mIsOnScreen;
        private int mPreListSize;
        private int mPrePos;

        PreLoadBean() {
        }

        public boolean getIsOnScreen() {
            return this.mIsOnScreen;
        }

        public int getPreListSize() {
            return this.mPreListSize;
        }

        public int getPrePos() {
            return this.mPrePos;
        }

        public void setIsOnScreen(boolean z16) {
            this.mIsOnScreen = z16;
        }

        public void setPreListSize(int i3) {
            this.mPreListSize = i3;
        }

        public void setPrePos(int i3) {
            this.mPrePos = i3;
        }
    }

    public RFWLayerVideoPreloadScroller(IRFWViewPager2AdapterDrive iRFWViewPager2AdapterDrive) {
        this.mAdapter = iRFWViewPager2AdapterDrive;
    }

    private void bindRFWOptions(RFWPlayerPreRenderBean rFWPlayerPreRenderBean, boolean z16) {
        RFWPlayerOptions obtain = RFWPlayerOptions.obtain(rFWPlayerPreRenderBean.getSceneId());
        rFWPlayerPreRenderBean.setPlayerOptions(obtain);
        obtain.setStVideo(rFWPlayerPreRenderBean.getPreloadVideo()).setFromType(rFWPlayerPreRenderBean.getFromType()).setPreloadSourceType(rFWPlayerPreRenderBean.getSourceType()).setFileId(rFWPlayerPreRenderBean.getPreloadVideo().getFileId()).setPlayUrl(rFWPlayerPreRenderBean.getPreloadVideo().getPlayUrl());
        if (obtain.getStartOffset() <= 0) {
            obtain.setStartOffset(getCurrentHistoryPosition(rFWPlayerPreRenderBean.getPreloadVideo()));
        }
        if (z16 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fluency_9055", true)) {
            obtain.setOffSetBySeek(true);
        }
        rFWPlayerPreRenderBean.setProcessOrder(getProcessOrder(rFWPlayerPreRenderBean));
    }

    private RFWPlayerPreRenderBean bindRenderOptions(RFWPlayerPreRenderBean rFWPlayerPreRenderBean, boolean z16) {
        if (rFWPlayerPreRenderBean.getSceneId() == 137) {
            bindTVKOptions(rFWPlayerPreRenderBean);
        } else {
            bindRFWOptions(rFWPlayerPreRenderBean, z16);
        }
        return rFWPlayerPreRenderBean;
    }

    private static void bindTVKOptions(RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        RFWPlayerOptions obtain = RFWPlayerOptions.obtain(rFWPlayerPreRenderBean.getSceneId());
        rFWPlayerPreRenderBean.setPlayerOptions(obtain);
        RFWTVKPlayerOptions tvkPlayerOptions = getTvkPlayerOptions(rFWPlayerPreRenderBean);
        if (tvkPlayerOptions == null) {
            return;
        }
        obtain.setFileId(rFWPlayerPreRenderBean.getPreloadVideo().getFileId()).setFromType(rFWPlayerPreRenderBean.getFromType()).setPreloadSourceType(rFWPlayerPreRenderBean.getSourceType()).setTVKPlayerOption(tvkPlayerOptions);
    }

    private long getCurrentHistoryPosition(RFWStVideo rFWStVideo) {
        RFWPlayerConfig config = RFWPlayerManger.g(this.mAdapter.getSceneId()).getConfig();
        if (config != null && config.getVideoPoiFetch() != null) {
            return config.getVideoPoiFetch().getHistoryPoi(rFWStVideo);
        }
        return 0L;
    }

    private int getLoadVideoCount(int i3) {
        int i16;
        int i17;
        RFWStVideo preloadVideo = getPreloadVideo(i3);
        if (preloadVideo.getVideoRate() == 0) {
            int i18 = i3 + 1;
            if (this.mAdapter.getDataList().size() > i18) {
                preloadVideo = getPreloadVideo(i18);
            }
            if (preloadVideo.getVideoRate() == 0 && this.mAdapter.getDataList().size() > i3 - 1 && i17 >= 0) {
                preloadVideo = getPreloadVideo(i17);
            }
        }
        long predictSpeedWithOutDownGrade = RFWVideoUtils.getPredictSpeedWithOutDownGrade(this.mAdapter.getSceneId());
        long videoRate = (preloadVideo.getVideoRate() / 1000) / 8;
        if (predictSpeedWithOutDownGrade > 4 * videoRate) {
            i16 = 4;
        } else if (predictSpeedWithOutDownGrade > 2 * videoRate) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        QLog.d("QFSLayerVideoPreloadScroller", 2, "getLoadVideoCount:" + i16 + " |preDictSpeed:" + predictSpeedWithOutDownGrade + "KB/s |videoBitRate:" + videoRate + "KB/s");
        return i16;
    }

    private RFWStVideo getPreloadVideo(int i3) {
        if (this.mAdapter.getDataList().size() > i3 && i3 >= 0) {
            Object obj = this.mAdapter.getDataList().get(i3);
            RFWPlayerConfig config = RFWPlayerManger.g(this.mAdapter.getSceneId()).getConfig();
            if (config != null && config.getFeedConvert() != null) {
                return config.getFeedConvert().convertFeedToStVideo(obj);
            }
            QLog.d("QFSLayerVideoPreloadScroller", 1, "convertToRRFStVideo error,no init");
            return new RFWStVideo();
        }
        return new RFWStVideo();
    }

    private LinkedList<String> getProcessOrder(RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        RFWPlayerConfig config = RFWPlayerManger.g(rFWPlayerPreRenderBean.getSceneId()).getConfig();
        if (config != null && config.getProcessOrder() != null) {
            return config.getProcessOrder().getPlayFormalOrder();
        }
        QLog.d("QFSLayerVideoPreloadScroller", 1, rFWPlayerPreRenderBean.getSceneId() + "is not init return default process");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(RFWPlayerOptionPreloadCheckProcess.DEFAULT_PROCESS_PRELOAD_CHECK);
        linkedList.add(RFWPlayerOptionURLSelectedProcess.DEFAULT_PROCESS_URL_SELECTED);
        linkedList.add(RFWPlayerOptionH264ReSelectedProcess.DEFAULT_PROCESS_URL_H264_RE_SELECTED);
        linkedList.add(RFWPlayerPlayerDirectIPProcess.DEFAULT_PROCESS_URL_DIRECT_IP);
        return linkedList;
    }

    private RFWPlayerReportInfo getReportInfo(int i3) {
        Object obj = this.mAdapter.getDataList().get(i3);
        RFWPlayerConfig config = RFWPlayerManger.g(this.mAdapter.getSceneId()).getConfig();
        if (config != null && config.getFeedConvert() != null) {
            return RFWPlayerManger.g(this.mAdapter.getSceneId()).getConfig().getFeedConvert().convertToReportInfo(obj).addReportElement("link_redirect_count", String.valueOf(i3));
        }
        QLog.d("QFSLayerVideoPreloadScroller", 1, "getReportInfo error,no init");
        return new RFWPlayerReportInfo(obj);
    }

    private static RFWTVKPlayerOptions getTvkPlayerOptions(RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        RFWPlayerConfig config = RFWPlayerManger.g(rFWPlayerPreRenderBean.getSceneId()).getConfig();
        if (config != null && config.getTVKVideoPlayerOptionFetch() != null) {
            return config.getTVKVideoPlayerOptionFetch().getTVKPlayerOption(rFWPlayerPreRenderBean.getPreloadOriginData().getOriginBusinessData());
        }
        QLog.d("QFSLayerVideoPreloadScroller", 1, rFWPlayerPreRenderBean.getSceneId() + ",getTvkPlayerOptions failed business may not init");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isFloatingEnable(View view) {
        if ((view instanceof IRFWLayerItemViewScrollerStatus) && ((IRFWLayerItemViewScrollerStatus) view).isFloatingView() && RFWLifecycleHelper.getInstance().isRunningInBackground()) {
            return true;
        }
        return false;
    }

    private boolean needPreload(View view, int i3) {
        PreLoadBean preLoadBean;
        if (view != null && (preLoadBean = this.mPreLoadBean) != null && this.mAdapter != null) {
            if (i3 == preLoadBean.getPrePos() && this.mAdapter.getDataList().size() == this.mPreLoadBean.getPreListSize()) {
                isPresenterOnScreen();
                this.mPreLoadBean.getIsOnScreen();
            }
            return true;
        }
        QLog.e("QFSLayerVideoPreloadScroller", 1, "input values is null");
        return false;
    }

    private void onNotifyScreenFeedChange(Object obj) {
        RFWPlayerConfig config = RFWPlayerManger.g(this.mAdapter.getSceneId()).getConfig();
        if (config != null && config.getPlayerPreRenderCallBack() != null) {
            config.getPlayerPreRenderCallBack().onNotifyScreenFeedChange(obj);
        } else {
            QLog.d("QFSLayerVideoPreloadScroller", 1, "onNotifyScreenFeedChange error,no init");
        }
    }

    private void onPreloadVideo(Object obj) {
        RFWPlayerConfig config = RFWPlayerManger.g(this.mAdapter.getSceneId()).getConfig();
        if (config != null && config.getPlayerPreRenderCallBack() != null) {
            config.getPlayerPreRenderCallBack().onPreloadVideo(obj);
        } else {
            QLog.d("QFSLayerVideoPreloadScroller", 1, "onPreloadVideo error,no init");
        }
    }

    private void preloadPreVideo(int i3, boolean z16) {
        int i16;
        if (this.mAdapter.mayPreloadPreVideo() && i3 != 0) {
            if (!z16 && this.mHasPreloadOnce) {
                return;
            }
            if (!this.mHasPreloadOnce) {
                i16 = i3 - 1;
            } else {
                i16 = i3 - 2;
            }
            this.mHasPreloadOnce = true;
            RFWVideoPreloadManager.g(this.mAdapter.getSceneId()).preloadVideo(createPreloadBean(i16), this.mAdapter.getSourceType());
            onPreloadVideo(RFSafeListUtils.get(this.mAdapter.getDataList(), i16));
            String str = "preloadPreVideo, current pos = " + i3 + "|prePos:" + i16;
            if (!TextUtils.equals(str, this.mLastLogMsg)) {
                this.mLastLogMsg = str;
                QLog.d("QFSLayerVideoPreloadScroller", 1, str);
            }
        }
    }

    private void triggerPreloadByScroll(int i3, boolean z16) {
        IRFWViewPager2AdapterDrive iRFWViewPager2AdapterDrive;
        int i16;
        RecyclerView.ViewHolder finViewHolderByPos;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_player_slid_back_render", true) && (iRFWViewPager2AdapterDrive = this.mAdapter) != null && iRFWViewPager2AdapterDrive.getDataList() != null && this.mAdapter.getDataList().size() > i3) {
            if (z16) {
                i16 = i3 - 1;
            } else {
                i16 = i3 + 1;
            }
            if (i16 < 0) {
                return;
            }
            if (RFWPlayerPreRenderHelper.getInstance().hasSameRenderAndReady(getPreloadVideo(i16).getFileId()) || (finViewHolderByPos = this.mAdapter.finViewHolderByPos(i3)) == null) {
                return;
            }
            triggerPreloadVideo(finViewHolderByPos.itemView, i3, z16);
        }
    }

    private void triggerPreloadVideo(View view, int i3, boolean z16) {
        int i16;
        Activity activity;
        IRFWViewPager2AdapterDrive iRFWViewPager2AdapterDrive = this.mAdapter;
        if (iRFWViewPager2AdapterDrive != null && iRFWViewPager2AdapterDrive.getDataList() != null && this.mAdapter.getDataList().size() > i3) {
            this.mPreLoadBean.setPrePos(i3);
            this.mPreLoadBean.setPreListSize(this.mAdapter.getDataList().size());
            this.mPreLoadBean.setIsOnScreen(isPresenterOnScreen());
            int loadVideoCount = getLoadVideoCount(i3);
            RFWVideoPreloadManager.g(this.mAdapter.getSceneId()).updateMaxPreloadCount(loadVideoCount);
            RFWVideoPreloadManager.g(this.mAdapter.getSceneId()).stopPreload(getPreloadVideo(i3).getFileId());
            if (z16) {
                i16 = i3 - 1;
            } else {
                i16 = i3 + 1;
            }
            int min = Math.min(loadVideoCount + i3, this.mAdapter.getDataList().size());
            if ((isPresenterOnScreen() || isFloatingEnable(view)) && i16 < min && RFWPlayerPreRenderHelper.getInstance().isPreRenderOpen()) {
                RFWPlayerPreRenderHelper rFWPlayerPreRenderHelper = RFWPlayerPreRenderHelper.getInstance();
                RFWPlayerPreRenderBean rFWPlayerPreRenderBean = new RFWPlayerPreRenderBean(this.mAdapter.getSceneId(), 10001);
                if (view.getContext() instanceof Activity) {
                    activity = (Activity) view.getContext();
                } else {
                    activity = null;
                }
                rFWPlayerPreRenderHelper.playerRender(bindRenderOptions(rFWPlayerPreRenderBean.setActivity(activity).setSourceType(this.mAdapter.getSourceType()).setPreloadVideo(getPreloadVideo(i16)).setPreloadOriginData(getReportInfo(i16)).setCurrentPlayVideo(getPreloadVideo(i3)).setMultiLevel(true), z16));
                i16++;
            }
            int min2 = Math.min(PRELOAD_DEFAULT_COUNT + i16, min);
            onNotifyScreenFeedChange(RFSafeListUtils.get(this.mAdapter.getDataList(), i3));
            while (i16 < min2) {
                RFWVideoPreloadManager.g(this.mAdapter.getSceneId()).preloadVideo(createPreloadBean(i16), this.mAdapter.getSourceType());
                onPreloadVideo(RFSafeListUtils.get(this.mAdapter.getDataList(), i16));
                i16++;
            }
            preloadPreVideo(i3, z16);
            return;
        }
        QLog.d("QFSLayerVideoPreloadScroller", 1, "triggerPreloadVideo return error params");
    }

    public RFWVideoPreloadBean createPreloadBean(int i3) {
        boolean z16;
        RFWStVideo preloadVideo = getPreloadVideo(i3);
        RFWVideoPreloadBean obtainBean = RFWVideoPreloadBean.obtainBean(this.mAdapter.getSceneId());
        if (preloadVideo.isQuic() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        return obtainBean.setIsQUIC(z16).setIsMultiLevel(true).setIsSimpleFeed(this.mAdapter.isSimpleFeed(i3)).setPreloadVideo(preloadVideo);
    }

    protected boolean isPresenterOnScreen() {
        if (this.mAdapter.getHostFragment() != null && this.mAdapter.getHostFragment().isResumed()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWLayerBaseScroller
    public boolean needReceiveSelectedAnyWay() {
        return true;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWLayerBaseScroller
    public void notifyIdle(int i3) {
        super.notifyIdle(i3);
        if (i3 == this.mScrollRecordSelectedPoi) {
            triggerPreloadByScroll(i3, false);
        }
        this.mScrollRecordSelectedPoi = -1;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWLayerBaseScroller
    public void notifyPageScrolledWithSelectedPos(int i3, float f16, int i16, int i17) {
        super.notifyPageScrolledWithSelectedPos(i3, f16, i16, i17);
        if (f16 != 0.0f && i16 != 0) {
            if (this.mScrollRecordSelectedPoi == -1) {
                this.mScrollRecordSelectedPoi = i17;
            }
            if (this.mScrollRecordSelectedPoi != i17) {
                return;
            }
            if (i17 > i3) {
                if (f16 < 1.0f) {
                    triggerPreloadByScroll(i17, true);
                }
            } else if (f16 > 0.0f) {
                triggerPreloadByScroll(i17, false);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWLayerBaseScroller
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onResumed(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo.getSelectedHolder() != null) {
            triggerPreloadVideo(rFWFeedSelectInfo.getSelectedHolder().itemView, rFWFeedSelectInfo.getPosition(), false);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWLayerBaseScroller
    public void onSelected(RFWFeedSelectInfo rFWFeedSelectInfo, RecyclerView.ViewHolder viewHolder) {
        super.onSelected(rFWFeedSelectInfo, viewHolder);
        if (needPreload(viewHolder.itemView, rFWFeedSelectInfo.getPosition())) {
            triggerPreloadVideo(viewHolder.itemView, rFWFeedSelectInfo.getPosition(), false);
        }
    }
}
