package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.VideoEventReporter;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.PageContext;
import com.tencent.qqlive.module.videoreport.page.PageContextManager;
import com.tencent.qqlive.module.videoreport.page.PageFinder;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes22.dex */
public class VideoPageReporter implements PageManager.IPageListener {
    private static final String TAG = "video.VideoPageListener";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final VideoPageReporter INSTANCE;

        static {
            VideoPageReporter videoPageReporter = new VideoPageReporter();
            INSTANCE = videoPageReporter;
            videoPageReporter.init();
        }

        InstanceHolder() {
        }
    }

    private void forceReportStashStart() {
        if (!isStartOpen()) {
            return;
        }
        Map<Integer, VideoReportFlowInfo> playerToFlowMap = VideoReportManager.getInstance().getPlayerToFlowMap();
        if (playerToFlowMap.isEmpty()) {
            Log.w(TAG, "playerInfoMap is empty!");
            return;
        }
        Collection<VideoReportFlowInfo> values = playerToFlowMap.values();
        if (values.isEmpty()) {
            return;
        }
        Iterator<VideoReportFlowInfo> it = values.iterator();
        while (it.hasNext()) {
            VideoSession videoSession = it.next().getVideoSession();
            if (videoSession == null) {
                Log.w(TAG, "session is null!");
            } else if (videoSession.hasStashStart()) {
                forceReportStartEvent(null, videoSession);
            }
        }
    }

    public static VideoPageReporter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        PageManager.getInstance().register(this);
    }

    private boolean isEndOpen() {
        int videoPageSwitch = VideoReportInner.getInstance().getConfiguration().getVideoPageSwitch();
        if (videoPageSwitch != 3 && videoPageSwitch != 2) {
            return false;
        }
        return true;
    }

    private boolean isStartOpen() {
        int videoPageSwitch = VideoReportInner.getInstance().getConfiguration().getVideoPageSwitch();
        if (videoPageSwitch == 3 || videoPageSwitch == 1) {
            return true;
        }
        return false;
    }

    private boolean needPageForEnd(@NonNull VideoSession videoSession) {
        if (isEndOpen() && videoSession.getVideoView() != null) {
            return true;
        }
        return false;
    }

    public void forceReportStartEvent(Object obj, @NonNull VideoSession videoSession) {
        if (needPageForStart(videoSession)) {
            Map<String, Object> curPage = videoSession.getCurPage();
            if (curPage == null) {
                curPage = getCurPageInfo("dt_video_start", videoSession);
            }
            videoSession.setCurPage(curPage);
        }
        Map<String, Object> startParams = videoSession.getStartParams();
        if (startParams != null) {
            VideoEventReporter.setCurPageParam(startParams, videoSession);
            VideoEventReporter.reportVideoStart(obj, startParams);
        } else {
            VideoEventReporter.reportVideoStart(obj, videoSession);
        }
        videoSession.setStartParams(null);
    }

    public Map<String, Object> getCurPageInfo(String str, @NonNull VideoSession videoSession) {
        long currentTimeMillis = System.currentTimeMillis();
        View videoView = videoSession.getVideoView();
        if (videoView == null) {
            Log.w(TAG, "getCurPageInfo, videoView is not set, ignore get page info!");
            return null;
        }
        PageInfo findOwnerPage = PageFinder.findOwnerPage(videoView);
        if (findOwnerPage == null) {
            Log.w(TAG, "getCurPageInfo, not found owner page of the videoView!");
            return null;
        }
        PageContext pageContext = PageContextManager.getInstance().get(findOwnerPage.getPageHashCode());
        if (pageContext != null && !pageContext.isDisappear) {
            Map<String, Object> pageInfo = PageUtils.getPageInfo(str, findOwnerPage.getPage(), findOwnerPage.getPageHashCode());
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (VideoReportInner.getInstance().isDebugMode()) {
                Log.i(TAG, "getCurPageInfo, cost time:" + currentTimeMillis2 + ", result is: " + pageInfo);
            }
            return pageInfo;
        }
        Log.w(TAG, "getCurPageInfo, the owner page of the videoView is not ready yet!");
        return null;
    }

    public boolean needPageForStart(@NonNull VideoSession videoSession) {
        if (isStartOpen() && videoSession.getVideoView() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageIn(@NonNull PageInfo pageInfo, @NonNull Set<PageInfo> set, int i3) {
        Log.d(TAG, "onPageIn");
        forceReportStashStart();
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageUpdate(PageInfo pageInfo, int i3) {
        Log.d(TAG, "onPageUpdate");
        forceReportStashStart();
    }

    public void reportEndEvent(Object obj, @NonNull VideoSession videoSession) {
        if (!needPageForEnd(videoSession)) {
            videoSession.setCurPage(null);
        }
        VideoEventReporter.reportVideoEnd(obj, videoSession);
        videoSession.setCurPage(null);
    }

    public void stashEndEvent(Object obj, @NonNull VideoSession videoSession) {
        if (needPageForEnd(videoSession)) {
            Map<String, Object> curPage = videoSession.getCurPage();
            if (curPage == null) {
                curPage = getCurPageInfo("dt_video_end", videoSession);
            }
            videoSession.setCurPage(curPage);
        }
        VideoEventReporter.stashVideoEnd(obj, videoSession);
    }

    public void stashStartEvent(Object obj, @NonNull VideoSession videoSession) {
        Map<String, Object> curPageInfo;
        if (needPageForStart(videoSession) && (curPageInfo = getCurPageInfo("dt_video_start", videoSession)) != null) {
            videoSession.setCurPage(curPageInfo);
        }
        VideoEventReporter.stashVideoStart(obj, videoSession);
    }

    public void tryReportStartEvent(Object obj, @NonNull VideoSession videoSession) {
        if (!needPageForStart(videoSession)) {
            VideoEventReporter.reportVideoStart(obj, videoSession);
            return;
        }
        Map<String, Object> curPageInfo = getCurPageInfo("dt_video_start", videoSession);
        if (curPageInfo == null) {
            if (!videoSession.hasStashStart()) {
                videoSession.setStartParams(VideoEventReporter.prepareStartParams(videoSession));
                return;
            }
            return;
        }
        videoSession.setCurPage(curPageInfo);
        Map<String, Object> startParams = videoSession.getStartParams();
        if (startParams == null) {
            VideoEventReporter.reportVideoStart(obj, videoSession);
        } else {
            VideoEventReporter.setCurPageParam(startParams, videoSession);
            VideoEventReporter.reportVideoStart(obj, startParams);
        }
        videoSession.setStartParams(null);
    }

    VideoPageReporter() {
    }

    @Override // com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener
    public void onPageOut(@NonNull PageInfo pageInfo, DataEntity dataEntity, @NonNull Set<PageInfo> set, boolean z16) {
    }
}
