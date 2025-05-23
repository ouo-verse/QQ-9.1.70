package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWLowDeviceRenderExp;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWPostAtFrontUtils;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerManger;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionH264ReSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionPreloadCheckProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionURLSelectedProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerPlayerDirectIPProcess;
import com.tencent.biz.richframework.video.rfw.player.playerprender.RFWPlayerPreRenderBean;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWPlayerPreRenderHelper {
    private static volatile RFWPlayerPreRenderHelper sPlayerRenderHelper;
    private int mPreRenderSwitchValue;
    private final ConcurrentHashMap<String, QFSPlayerPreloadTask> mRenderPlayerMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, QFSPlayerPreloadTask> mClickRenderPlayerMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<QFSPlayerPreloadTask, QFSPlayerPreloadTask> mWaitForReleaseMap = new ConcurrentHashMap<>();
    private final List<OnPrerenderListener> prerenderListeners = new LinkedList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class AttachRunnable implements Runnable {
        private static final HashSet<String> BLACK_SET = new HashSet<>();
        private final WeakReference<ViewGroup> mDecorView;
        private final RFWPlayerOptions mOption;
        private final WeakReference<View> mVideoView;

        public AttachRunnable(ViewGroup viewGroup, View view, RFWPlayerOptions rFWPlayerOptions) {
            this.mDecorView = new WeakReference<>(viewGroup);
            this.mVideoView = new WeakReference<>(view);
            this.mOption = rFWPlayerOptions;
        }

        private void addViewBySize(ViewGroup viewGroup, View view) {
            RFWPlayerOptions rFWPlayerOptions;
            if (viewGroup != null && view != null && (rFWPlayerOptions = this.mOption) != null && rFWPlayerOptions.getStVideo() != null) {
                int screenWidth = ScreenUtils.getScreenWidth(view.getContext());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(screenWidth, (int) ((screenWidth / this.mOption.getStVideo().getWidth()) * this.mOption.getStVideo().getHeight()));
                layoutParams.setMargins(-screenWidth, 0, 0, 0);
                viewGroup.addView(view, layoutParams);
                RFWLog.d("RFWPlayerPreRenderHelper" + this.mOption.tag(), RFWLog.USR, "av1 add to target decorView by size");
            }
        }

        private String getBlackList() {
            try {
                return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_pre_render_attach_black_list", "V2055A|V1962A|PD2230B|V2158A|V2158A|V2158A|V2123A|PD2230Q|V1911A|PD2230C|V2238A|V2156A|V2057A|VIVO");
            } catch (Exception e16) {
                RFWLog.e("RFWPlayerPreRenderHelper", RFWLog.USR, e16);
                return "V2055A|V1962A|PD2230B|V2158A|V2158A|V2158A|V2123A|PD2230Q|V1911A|PD2230C|V2238A|V2156A|V2057A|VIVO";
            }
        }

        private boolean isEnableModel() {
            String manufacturer = QCircleDeviceInfoUtils.getManufacturer();
            String mobileModel = QCircleDeviceInfoUtils.getMobileModel();
            HashSet<String> hashSet = BLACK_SET;
            if (!hashSet.isEmpty()) {
                if (!hashSet.contains(mobileModel.toLowerCase()) && !hashSet.contains(manufacturer.toLowerCase())) {
                    return true;
                }
                return false;
            }
            try {
                String blackList = getBlackList();
                if (!TextUtils.isEmpty(blackList)) {
                    QLog.d("RFWPlayerPreRenderHelper", 2, "mobileModel:" + mobileModel + " |mobileManufacturer:" + manufacturer);
                    String[] split = blackList.split("\\|");
                    int length = split.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        BLACK_SET.add(split[i3].toLowerCase());
                    }
                }
            } catch (Exception e16) {
                RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.CLR, e16);
            }
            HashSet<String> hashSet2 = BLACK_SET;
            if (!hashSet2.contains(mobileModel.toLowerCase()) && !hashSet2.contains(manufacturer.toLowerCase())) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = this.mDecorView.get();
            View view = this.mVideoView.get();
            if (viewGroup != null && view != null && this.mOption != null && view.getParent() == null) {
                if (uq3.c.L() && RFWVideoUtils.isAV1(this.mOption.getRealPlayBean()) && this.mOption.getTVKPlayerOption() == null && isEnableModel()) {
                    addViewBySize(viewGroup, view);
                    return;
                }
                viewGroup.addView(view, 0, 0);
                RFWLog.d("RFWPlayerPreRenderHelper" + this.mOption.tag(), RFWLog.USR, "add to target decorView");
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface OnPrerenderListener {
        @MainThread
        void onPrerenderFinish(boolean z16, @Nullable String str, int i3);
    }

    /* loaded from: classes5.dex */
    public static class QFSPlayerPreloadResult {
        private RFWPlayer mPlayer;
        private boolean mPreloadError;
        private boolean mPromisedPlayer;

        QFSPlayerPreloadResult() {
        }

        public RFWPlayer getPlayer() {
            return this.mPlayer;
        }

        public boolean isPreloadError() {
            return this.mPreloadError;
        }

        public boolean isPromisedPlayer() {
            return this.mPromisedPlayer;
        }

        public void setPlayer(RFWPlayer rFWPlayer) {
            this.mPlayer = rFWPlayer;
        }

        public void setPreloadError(boolean z16) {
            this.mPreloadError = z16;
        }

        public void setPromised(boolean z16) {
            this.mPromisedPlayer = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class RemoveRunnable implements Runnable {
        private final WeakReference<ViewGroup> mDecorView;
        private final RFWPlayerOptions mOption;
        private final WeakReference<View> mVideoView;

        public RemoveRunnable(ViewGroup viewGroup, View view, RFWPlayerOptions rFWPlayerOptions) {
            this.mDecorView = new WeakReference<>(viewGroup);
            this.mVideoView = new WeakReference<>(view);
            this.mOption = rFWPlayerOptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = this.mDecorView.get();
            View view = this.mVideoView.get();
            if (viewGroup != null && view != 0 && this.mOption != null && view.getParent() == viewGroup) {
                if (view instanceof ISPlayerVideoView) {
                    ((ISPlayerVideoView) view).disableViewCallback();
                } else if (view instanceof TVKPlayerVideoView) {
                    ((TVKPlayerVideoView) view).storeSurfaceTexture();
                }
                viewGroup.removeView(view);
                RFWLog.d("RFWPlayerPreRenderHelper_" + this.mOption.tag(), RFWLog.USR, "remove from target decorView");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SdkInitListener implements IRFWPlayerSdkInitListener {
        private final WeakReference<Activity> mActivity;
        private final RFWPlayerOptions mOptions;
        private final WeakReference<QFSPlayerPreloadTask> mPreloadTask;

        SdkInitListener(Activity activity, QFSPlayerPreloadTask qFSPlayerPreloadTask, RFWPlayerOptions rFWPlayerOptions) {
            this.mActivity = new WeakReference<>(activity);
            this.mPreloadTask = new WeakReference<>(qFSPlayerPreloadTask);
            this.mOptions = rFWPlayerOptions;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
        public void onInitSuccess(RFWPlayer rFWPlayer) {
            Activity activity = this.mActivity.get();
            QFSPlayerPreloadTask qFSPlayerPreloadTask = this.mPreloadTask.get();
            if (activity != null && qFSPlayerPreloadTask != null) {
                qFSPlayerPreloadTask.preloadAddPlayToView(activity, rFWPlayer, this.mOptions);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class VideoCallBack implements ISPlayerVideoView.IVideoViewCallBack, ITVKVideoViewBase.IVideoViewCallback {
        private final WeakReference<Runnable> mRemoveRunnable;

        public VideoCallBack(Runnable runnable) {
            this.mRemoveRunnable = new WeakReference<>(runnable);
        }

        private void doOnSurfaceCreated() {
            Runnable runnable = this.mRemoveRunnable.get();
            if (runnable == null) {
                return;
            }
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_prerender_remove_view_dely", true)) {
                RFWThreadManager.getUIHandler().postDelayed(runnable, 500L);
            } else {
                RFWPostAtFrontUtils.post(RFWThreadManager.getUIHandler(), runnable);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase.IVideoViewCallback
        public void onSurfaceChanged(ITVKVideoViewBase iTVKVideoViewBase, Surface surface, int i3, int i16) {
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceCreated(Object obj) {
            doOnSurfaceCreated();
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceChanged(Object obj) {
        }

        @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase.IVideoViewCallback
        public void onSurfaceCreated(ITVKVideoViewBase iTVKVideoViewBase, Surface surface) {
            doOnSurfaceCreated();
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceDestroy(Object obj) {
        }

        @Override // com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase.IVideoViewCallback
        public void onSurfaceDestroyed(ITVKVideoViewBase iTVKVideoViewBase, Surface surface) {
        }
    }

    RFWPlayerPreRenderHelper() {
        this.mPreRenderSwitchValue = uq3.c.X0("qqcircle", "qqcircle_player_pre_render", 1).intValue();
        if (QCircleVideoDeviceInfoUtils.isLowDevice()) {
            this.mPreRenderSwitchValue = 0;
            RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.USR, "QFSPlayerRenderHelper close");
        }
    }

    private void cleaOldPreloadPlayer(String str, String str2, boolean z16) {
        ConcurrentHashMap<String, QFSPlayerPreloadTask> concurrentHashMap;
        if (z16) {
            concurrentHashMap = this.mClickRenderPlayerMap;
        } else {
            concurrentHashMap = this.mRenderPlayerMap;
        }
        cleanPlayWithOutKey(str, str2, concurrentHashMap);
    }

    private void cleanPlayWithOutKey(String str, String str2, ConcurrentHashMap concurrentHashMap) {
        Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            final Map.Entry entry = (Map.Entry) it.next();
            if (!((String) entry.getKey()).equals(str2) && !((String) entry.getKey()).equals(str)) {
                final String str3 = (String) entry.getKey();
                final QFSPlayerPreloadTask qFSPlayerPreloadTask = (QFSPlayerPreloadTask) entry.getValue();
                RFWPlayer rFWPlayer = qFSPlayerPreloadTask.mPlayer;
                if (rFWPlayer != null) {
                    rFWPlayer.release(RFWPlayer.RELEASE_FROM_PRELOAD);
                    qFSPlayerPreloadTask.release();
                    PreLoader.remove(str3);
                    RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.USR, "clean preLoad view ready:" + ((String) entry.getKey()));
                } else if (PreLoader.exists(str3)) {
                    this.mWaitForReleaseMap.put(qFSPlayerPreloadTask, qFSPlayerPreloadTask);
                    RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.USR, "clean preLoad view wait for result:" + ((String) entry.getKey()));
                    PreLoader.addListener(str3, new OnTaskListener<QFSPlayerPreloadResult>() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper.1
                        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
                        public void onComplete(QFSPlayerPreloadResult... qFSPlayerPreloadResultArr) {
                            if (qFSPlayerPreloadResultArr.length > 0 && qFSPlayerPreloadResultArr[0].getPlayer() != null) {
                                qFSPlayerPreloadResultArr[0].getPlayer().release(RFWPlayer.RELEASE_FROM_PRELOAD_TASK_COMPLETE);
                                RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.USR, "clean preLoad view callback ready:" + ((String) entry.getKey()));
                            }
                            qFSPlayerPreloadTask.release();
                            RFWPlayerPreRenderHelper.this.mWaitForReleaseMap.remove(qFSPlayerPreloadTask);
                            PreLoader.remove(str3);
                        }
                    });
                }
                RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.USR, "clean preLoad player entry:" + ((String) entry.getKey()));
                it.remove();
            }
        }
        verifyWaitForReleaseTask();
    }

    private void createRender(final RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        RFWPostAtFrontUtils.post(RFWThreadManager.getInstance().getVideoHandler(), new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.g
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerPreRenderHelper.this.lambda$createRender$2(rFWPlayerPreRenderBean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doCreateRenderInner, reason: merged with bridge method [inline-methods] */
    public void lambda$createRender$2(RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        RFWPlayerOptions playerOptions = rFWPlayerPreRenderBean.getPlayerOptions();
        RFWStVideo stVideo = playerOptions.getStVideo();
        String realPlayUrl = playerOptions.getRealPlayUrl();
        if ((stVideo == null || TextUtils.isEmpty(realPlayUrl)) && playerOptions.getTVKPlayerOption() == null) {
            RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.DEV, "[doCreateRenderInner] error params!");
            notifyPrerenderFinish(false, rFWPlayerPreRenderBean.getPreloadVideo(), -1);
            return;
        }
        String renderKey = getRenderKey(playerOptions.getFileId());
        if (TextUtils.isEmpty(renderKey)) {
            RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.DEV, "[doCreateRenderInner] renderKey is empty");
            notifyPrerenderFinish(false, rFWPlayerPreRenderBean.getPreloadVideo(), -1);
            return;
        }
        boolean isJumpTrigger = rFWPlayerPreRenderBean.isJumpTrigger();
        cleaOldPreloadPlayer(renderKey, getCurrentVideoRenderKey(rFWPlayerPreRenderBean), isJumpTrigger);
        if (hasSameRenderAndReady(renderKey)) {
            notifyPrerenderFinish(true, rFWPlayerPreRenderBean.getPreloadVideo(), 0);
            return;
        }
        RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.USR, "[doCreateRenderInner] renderKey: " + renderKey);
        QFSPlayerPreloadTask qFSPlayerPreloadTask = new QFSPlayerPreloadTask(rFWPlayerPreRenderBean.getActivity(), rFWPlayerPreRenderBean.getPreloadOriginData(), playerOptions);
        if (isJumpTrigger) {
            this.mClickRenderPlayerMap.put(renderKey, qFSPlayerPreloadTask);
        } else {
            this.mRenderPlayerMap.put(renderKey, qFSPlayerPreloadTask);
        }
        try {
            PreLoader.preLoad(renderKey, qFSPlayerPreloadTask);
        } catch (Exception e16) {
            RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.USR, e16);
        }
    }

    private void exchangeVideoUrl(final RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        if (rFWPlayerPreRenderBean.getPlayerOptions() == null) {
            QLog.d("RFWPlayerPreRenderHelper", 1, "exchangeVideoUrl error ,no player options");
            return;
        }
        LinkedList<String> processOrder = rFWPlayerPreRenderBean.getProcessOrder();
        if (processOrder == null || processOrder.isEmpty()) {
            processOrder = getDefaultOrder();
            QLog.d("RFWPlayerPreRenderHelper", 1, "exchangeVideoUrl use default order");
        }
        RFWPlayerOptionsProcessManager.g().startProcess(processOrder, rFWPlayerPreRenderBean.getPlayerOptions(), new RFWPlayerOptionsProcessManager.IProcessCallBack() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.e
            @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager.IProcessCallBack
            public final void onFinish(RFWPlayerOptions rFWPlayerOptions, boolean z16) {
                RFWPlayerPreRenderHelper.this.lambda$exchangeVideoUrl$1(rFWPlayerPreRenderBean, rFWPlayerOptions, z16);
            }
        });
    }

    private String getCurrentVideoRenderKey(RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        if (rFWPlayerPreRenderBean != null && rFWPlayerPreRenderBean.getCurrentVideo() != null) {
            return rFWPlayerPreRenderBean.getCurrentVideo().getFileId();
        }
        RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.CLR, "currentVideoRenderKey is default");
        return "-1";
    }

    private LinkedList getDefaultOrder() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(RFWPlayerOptionPreloadCheckProcess.DEFAULT_PROCESS_PRELOAD_CHECK);
        linkedList.add(RFWPlayerOptionURLSelectedProcess.DEFAULT_PROCESS_URL_SELECTED);
        linkedList.add(RFWPlayerOptionH264ReSelectedProcess.DEFAULT_PROCESS_URL_H264_RE_SELECTED);
        linkedList.add(RFWPlayerPlayerDirectIPProcess.DEFAULT_PROCESS_URL_DIRECT_IP);
        return linkedList;
    }

    public static RFWPlayerPreRenderHelper getInstance() {
        if (sPlayerRenderHelper == null) {
            synchronized (RFWPlayerPreRenderHelper.class) {
                if (sPlayerRenderHelper == null) {
                    sPlayerRenderHelper = new RFWPlayerPreRenderHelper();
                }
            }
        }
        return sPlayerRenderHelper;
    }

    private String getRenderKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    private boolean isPublishFeedForLocalVideo(RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        String fileId;
        RFWStVideo preloadVideo = rFWPlayerPreRenderBean.getPreloadVideo();
        if (preloadVideo == null) {
            fileId = null;
        } else {
            fileId = preloadVideo.getFileId();
        }
        if (fileId == null || RFWPlayerManger.g(rFWPlayerPreRenderBean.getSceneId()).getConfig() == null || RFWPlayerManger.g(rFWPlayerPreRenderBean.getSceneId()).getConfig().getFieldToLocalPath() == null) {
            return false;
        }
        String localPath = RFWPlayerManger.g(rFWPlayerPreRenderBean.getSceneId()).getConfig().getFieldToLocalPath().getLocalPath(fileId);
        if (TextUtils.isEmpty(localPath)) {
            return false;
        }
        boolean exists = new File(localPath).exists();
        QLog.d("RFWPlayerPreRenderHelper", 1, "[isPublishFeedVideo] fileId: " + fileId + " | localPath: " + localPath + " | isExistsFile: " + exists);
        return exists;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$exchangeVideoUrl$1(RFWPlayerPreRenderBean rFWPlayerPreRenderBean, RFWPlayerOptions rFWPlayerOptions, boolean z16) {
        lambda$createRender$2(rFWPlayerPreRenderBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyPrerenderFinish$0(boolean z16, String str, int i3) {
        Iterator<OnPrerenderListener> it = this.prerenderListeners.iterator();
        while (it.hasNext()) {
            it.next().onPrerenderFinish(z16, str, i3);
        }
    }

    private void verifyWaitForReleaseTask() {
        if (!uq3.c.X()) {
            return;
        }
        Iterator<QFSPlayerPreloadTask> it = this.mWaitForReleaseMap.keySet().iterator();
        while (it.hasNext()) {
            QFSPlayerPreloadTask next = it.next();
            RFWPlayer rFWPlayer = next.mPlayer;
            if (rFWPlayer != null && rFWPlayer.getRFWPlayerOptions() != null) {
                next.mPlayer.release(RFWPlayer.RELEASE_FROM_PRELOAD);
                next.release();
                it.remove();
                RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.USR, "verifyWaitForReleaseTask release: |tag:" + rFWPlayer.getRFWPlayerOptions().tag() + " |key:" + rFWPlayer.getRFWPlayerOptions().getFileId());
            }
        }
    }

    public boolean hasSameRenderAndReady(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!this.mRenderPlayerMap.containsKey(str) && !this.mClickRenderPlayerMap.containsKey(str)) {
            return false;
        }
        return true;
    }

    public boolean isPreRender(String str) {
        if (TextUtils.isEmpty(str)) {
            RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.USR, "[Preload] error video");
            return false;
        }
        String renderKey = getRenderKey(str);
        QFSPlayerPreloadTask qFSPlayerPreloadTask = this.mRenderPlayerMap.get(renderKey);
        if (qFSPlayerPreloadTask == null) {
            qFSPlayerPreloadTask = this.mClickRenderPlayerMap.get(renderKey);
            RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.USR, "[Preload] find from clickMap");
        }
        if (qFSPlayerPreloadTask != null) {
            return true;
        }
        return false;
    }

    public boolean isPreRenderOpen() {
        if (RFWLowDeviceRenderExp.shouldPreRender()) {
            return true;
        }
        if (this.mPreRenderSwitchValue != 0 && (QQVideoPlaySDKManager.isSDKReady() || uq3.c.r0())) {
            return true;
        }
        return false;
    }

    void notifyPrerenderFinish(boolean z16, RFWStVideo rFWStVideo, int i3) {
        notifyPrerenderFinish(z16, rFWStVideo != null ? rFWStVideo.getFileId() : null, i3);
    }

    @MainThread
    public void playerRender(RFWPlayerPreRenderBean rFWPlayerPreRenderBean) {
        boolean z16 = false;
        if (rFWPlayerPreRenderBean == null) {
            notifyPrerenderFinish(false, (String) null, -1);
            return;
        }
        if (!isPreRenderOpen() && !rFWPlayerPreRenderBean.isForceRender()) {
            notifyPrerenderFinish(false, rFWPlayerPreRenderBean.getPreloadVideo(), -1);
            RFWLowDeviceRenderExp.reportRender(false);
            return;
        }
        RFWLowDeviceRenderExp.reportRender(true);
        RFWStVideo preloadVideo = rFWPlayerPreRenderBean.getPreloadVideo();
        if (preloadVideo == null) {
            notifyPrerenderFinish(false, (String) null, -1);
            return;
        }
        if (isPublishFeedForLocalVideo(rFWPlayerPreRenderBean)) {
            notifyPrerenderFinish(false, preloadVideo, -1);
            return;
        }
        RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.CLR, "playerRenderBean" + rFWPlayerPreRenderBean);
        if (rFWPlayerPreRenderBean.getSceneId() == 137) {
            z16 = true;
        }
        if (z16) {
            createRender(rFWPlayerPreRenderBean);
        } else {
            exchangeVideoUrl(rFWPlayerPreRenderBean);
        }
    }

    public void registerPrerenderListener(OnPrerenderListener onPrerenderListener) {
        if (onPrerenderListener != null && !this.prerenderListeners.contains(onPrerenderListener)) {
            this.prerenderListeners.add(onPrerenderListener);
        }
    }

    public void releaseClickRender() {
        cleanPlayWithOutKey("-1", "-1", this.mClickRenderPlayerMap);
    }

    @MainThread
    public void releaseRender() {
        RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.CLR, "releaseRender,map size: ", this.mRenderPlayerMap.size() + "|" + this.mClickRenderPlayerMap.size());
        cleanPlayWithOutKey("-1", "-1", this.mRenderPlayerMap);
        cleanPlayWithOutKey("-1", "-1", this.mClickRenderPlayerMap);
    }

    public void removeKey(String str) {
        RFWLog.d("RFWPlayerPreRenderHelper", RFWLog.USR, "[removeKey] remove render player key: " + str);
        this.mRenderPlayerMap.remove(getRenderKey(str));
        this.mClickRenderPlayerMap.remove(getRenderKey(str));
        PreLoader.remove(getRenderKey(str));
    }

    public void unregisterPrerenderListener(OnPrerenderListener onPrerenderListener) {
        if (onPrerenderListener != null) {
            this.prerenderListeners.remove(onPrerenderListener);
        }
    }

    void notifyPrerenderFinish(final boolean z16, final String str, final int i3) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.f
            @Override // java.lang.Runnable
            public final void run() {
                RFWPlayerPreRenderHelper.this.lambda$notifyPrerenderFinish$0(z16, str, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class QFSPlayerPreloadTask extends BasePreLoadTask<QFSPlayerPreloadResult> {
        WeakReference<Activity> mActivity;
        Runnable mAddToDecoderRunnable;
        RFWPlayerOptions mOptions;
        RFWPlayer mPlayer;
        RFWPlayerReportInfo mPreloadData;
        Runnable mRemoveViewRunnable;
        boolean mShouldPromised;

        public QFSPlayerPreloadTask(Activity activity, RFWPlayerReportInfo rFWPlayerReportInfo, @NonNull RFWPlayerOptions rFWPlayerOptions) {
            boolean z16;
            this.mPreloadExpiredTime = -1L;
            this.mIsOnlyRunOnce = false;
            this.mActivity = new WeakReference<>(activity);
            if (activity != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mShouldPromised = z16;
            this.mPreloadData = rFWPlayerReportInfo;
            this.mOptions = rFWPlayerOptions;
            RFWLog.d("RFWPlayerPreRenderHelper_" + rFWPlayerOptions.tag(), RFWLog.USR, "create new player promised:" + this.mShouldPromised);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void addViewToActivity(Activity activity, View view, RFWPlayerOptions rFWPlayerOptions) {
            if (activity != null && !activity.isFinishing()) {
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                RemoveRunnable removeRunnable = new RemoveRunnable(viewGroup, view, this.mOptions);
                this.mRemoveViewRunnable = removeRunnable;
                if (view instanceof ISPlayerVideoView) {
                    ((ISPlayerVideoView) view).addViewCallBack(new VideoCallBack(removeRunnable));
                } else if (view instanceof TVKPlayerVideoView) {
                    ((TVKPlayerVideoView) view).addViewCallback(new VideoCallBack(removeRunnable));
                }
                this.mAddToDecoderRunnable = new AttachRunnable(viewGroup, view, this.mOptions);
                RFWPostAtFrontUtils.post(RFWThreadManager.getUIHandler(), this.mAddToDecoderRunnable);
            }
        }

        private void initCallback(Activity activity, final RFWPlayerOptions rFWPlayerOptions, final QFSPlayerPreloadResult qFSPlayerPreloadResult) {
            rFWPlayerOptions.getListenerSet().addSDKInitListeners(new SdkInitListener(activity, this, this.mOptions));
            rFWPlayerOptions.setPlayIOC(new RFWPlayerIOC() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper.QFSPlayerPreloadTask.1
                @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
                public RFWPlayerReportInfo getBusinessReportInfo() {
                    return QFSPlayerPreloadTask.this.mPreloadData;
                }

                @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
                public boolean isPreloadTask() {
                    return true;
                }

                @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
                public boolean isValid() {
                    return false;
                }
            });
            rFWPlayerOptions.getListenerSet().addPrepareListeners(new IRFWPlayerPrepareListener() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper.QFSPlayerPreloadTask.3
                @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
                public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
                    RFWLog.d("RFWPlayerPreRenderHelper_" + rFWPlayerOptions.tag(), RFWLog.USR, "onFirstFrameRendered");
                    rFWPlayerOptions.setFirstFramePreRenderSucceed(true);
                    RFWPlayerPreRenderHelper.getInstance().notifyPrerenderFinish(true, rFWPlayerOptions.getFileId(), 0);
                }

                @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
                public void onVideoPrepared(RFWPlayer rFWPlayer) {
                    RFWLog.d("RFWPlayerPreRenderHelper_" + rFWPlayerOptions.tag(), RFWLog.USR, "onVideoPrepared");
                }
            }).addErrorStatusListener(new IRFWPlayErrorStatusListener() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper.QFSPlayerPreloadTask.2
                @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
                public void onVideoPlayError(int i3, int i16, int i17, String str) {
                    RFWLog.d("RFWPlayerPreRenderHelper_" + rFWPlayerOptions.tag(), RFWLog.USR, "onVideoPlayError remove preload record:");
                    qFSPlayerPreloadResult.setPreloadError(true);
                    QFSPlayerPreloadTask.this.mPlayer.release(RFWPlayer.RELEASE_FROM_PRELOAD);
                    RFWPlayerPreRenderHelper.getInstance().removeKey(rFWPlayerOptions.getFileId());
                    RFWPlayerPreRenderHelper.getInstance().notifyPrerenderFinish(false, rFWPlayerOptions.getFileId(), i17);
                }
            });
            if (o.U0()) {
                rFWPlayerOptions.getListenerSet().addLifeCycleListeners(new IRFWPlayerLifeCycle() { // from class: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper.QFSPlayerPreloadTask.4
                    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
                    public void onDeInit(RFWPlayer rFWPlayer) {
                        RFWLog.d("RFWPlayerPreRenderHelper_" + rFWPlayerOptions.tag(), RFWLog.USR, "onDeInit remove preload record:");
                        qFSPlayerPreloadResult.setPreloadError(true);
                        QFSPlayerPreloadTask.this.mPlayer.release(RFWPlayer.RELEASE_FROM_PRELOAD);
                        RFWPlayerPreRenderHelper.getInstance().removeKey(rFWPlayerOptions.getFileId());
                        RFWPlayerPreRenderHelper.getInstance().notifyPrerenderFinish(false, rFWPlayerOptions.getFileId(), -1);
                    }

                    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
                    public /* synthetic */ void onPause(RFWPlayer rFWPlayer) {
                        re0.a.b(this, rFWPlayer);
                    }

                    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
                    public /* synthetic */ void onRelease(RFWPlayer rFWPlayer) {
                        re0.a.c(this, rFWPlayer);
                    }

                    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
                    public /* synthetic */ void onStart(RFWPlayer rFWPlayer) {
                        re0.a.d(this, rFWPlayer);
                    }

                    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLifeCycle
                    public /* synthetic */ void onStop(RFWPlayer rFWPlayer) {
                        re0.a.e(this, rFWPlayer);
                    }
                });
            }
        }

        private QFSPlayerPreloadResult initRenderPlayer(Activity activity, RFWPlayerOptions rFWPlayerOptions) {
            RFWPlayer rFWPlayer = new RFWPlayer();
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_pre_render_player_loop_back", true)) {
                rFWPlayer.setLoopback(true);
            }
            QFSPlayerPreloadResult qFSPlayerPreloadResult = new QFSPlayerPreloadResult();
            qFSPlayerPreloadResult.setPlayer(rFWPlayer);
            qFSPlayerPreloadResult.setPromised(this.mShouldPromised);
            rFWPlayer.setEnablePerfReport(false);
            initCallback(activity, rFWPlayerOptions, qFSPlayerPreloadResult);
            rFWPlayer.loadPlayOptions(rFWPlayerOptions);
            this.mPlayer = rFWPlayer;
            return qFSPlayerPreloadResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void preloadAddPlayToView(Activity activity, RFWPlayer rFWPlayer, RFWPlayerOptions rFWPlayerOptions) {
            if (!uq3.c.b()) {
                RFWLog.d("RFWPlayerPreRenderHelper_" + rFWPlayerOptions.tag(), RFWLog.USR, "WNS close preload view to activity");
                return;
            }
            if (activity != null && rFWPlayer != null && activity.getWindow().getDecorView() != null) {
                View videoView = rFWPlayer.getVideoView();
                if (videoView != null && videoView.getParent() == null) {
                    if (!(videoView instanceof ISPlayerVideoView) && !(videoView instanceof TVKPlayerVideoView)) {
                        return;
                    }
                    addViewToActivity(activity, videoView, rFWPlayerOptions);
                    return;
                }
                RFWLog.d("RFWPlayerPreRenderHelper_" + rFWPlayerOptions.tag(), RFWLog.USR, "init render to view return :" + rFWPlayerOptions.getRealPlayUrl());
                return;
            }
            RFWLog.d("RFWPlayerPreRenderHelper_" + rFWPlayerOptions.tag(), RFWLog.USR, "init render to view return");
        }

        public void release() {
            if (this.mAddToDecoderRunnable != null) {
                RFWThreadManager.getInstance().remove(this.mAddToDecoderRunnable);
            }
            if (this.mRemoveViewRunnable != null) {
                RFWThreadManager.getUIHandler().removeCallbacks(this.mRemoveViewRunnable);
            }
        }

        @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
        public void startLoadData(OnPreLoadListener<QFSPlayerPreloadResult> onPreLoadListener) {
            onPreLoadListener.onLoaded(initRenderPlayer(this.mActivity.get(), this.mOptions));
        }

        @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
        public void onRemove() {
        }
    }
}
