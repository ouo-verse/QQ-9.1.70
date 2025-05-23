package com.tencent.superplayer.preload;

import android.app.Activity;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.player.SuperPlayerWrapper;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.SPlayerVideoView;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes26.dex */
public class PreloadPlayerMgr implements IPreloadPlayerMgr {
    private static final String TAG = "PreloadPlayerMgr";
    private static PreloadPlayerMgr sInstance;
    private AtomicInteger mTaskIdIncreaser = new AtomicInteger(1);
    private final Map<Integer, PreloadPlayerInfo> mPreloadTaskMap = new ConcurrentHashMap();

    PreloadPlayerMgr() {
    }

    public static synchronized PreloadPlayerMgr getInstance() {
        PreloadPlayerMgr preloadPlayerMgr;
        synchronized (PreloadPlayerMgr.class) {
            if (sInstance == null) {
                sInstance = new PreloadPlayerMgr();
            }
            preloadPlayerMgr = sInstance;
        }
        return preloadPlayerMgr;
    }

    private PreloadPlayerInfo getWrapperFromPlayerInfo(final PreloadPlayerInfo preloadPlayerInfo) {
        SPlayerVideoView sPlayerVideoView;
        if (preloadPlayerInfo.player != null && (sPlayerVideoView = preloadPlayerInfo.videoView) != null) {
            if (sPlayerVideoView.isSurfaceReady()) {
                return preloadPlayerInfo;
            }
            ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.preload.PreloadPlayerMgr.3
                @Override // java.lang.Runnable
                public void run() {
                    SuperPlayerWrapper superPlayerWrapper = preloadPlayerInfo.player;
                    if (superPlayerWrapper != null) {
                        superPlayerWrapper.release();
                    }
                }
            });
        }
        return null;
    }

    private void preloadPlayerAsync(final Activity activity, final int i3, final SuperPlayerVideoInfo superPlayerVideoInfo, final int i16) {
        ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.preload.PreloadPlayerMgr.1
            @Override // java.lang.Runnable
            public void run() {
                String str = CommonUtil.f() + "-PreLoading";
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread(LogUtil.TAG + str);
                baseHandlerThread.start();
                try {
                    final SuperPlayerWrapper superPlayerWrapper = new SuperPlayerWrapper(activity.getApplicationContext(), i3, str, baseHandlerThread.getLooper(), null);
                    final SPlayerVideoView sPlayerVideoView = (SPlayerVideoView) PreloadUtils.createCleanTextureView(activity);
                    sPlayerVideoView.addViewCallBack(new ISPlayerVideoView.IVideoViewCallBack() { // from class: com.tencent.superplayer.preload.PreloadPlayerMgr.1.1
                        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
                        public void onSurfaceCreated(Object obj) {
                            superPlayerWrapper.setSurface(sPlayerVideoView.getSurface());
                        }

                        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
                        public void onSurfaceChanged(Object obj) {
                        }

                        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
                        public void onSurfaceDestroy(Object obj) {
                        }
                    });
                    superPlayerWrapper.setSurface(sPlayerVideoView.getSurface());
                    SuperPlayerOption obtain = SuperPlayerOption.obtain();
                    obtain.isPrePlay = true;
                    superPlayerWrapper.openMediaPlayer(activity, superPlayerVideoInfo, 0L, obtain);
                    superPlayerWrapper.updateIsPreloadingStatus(true);
                    synchronized (PreloadPlayerMgr.this.mPreloadTaskMap) {
                        PreloadPlayerInfo preloadPlayerInfo = (PreloadPlayerInfo) PreloadPlayerMgr.this.mPreloadTaskMap.get(Integer.valueOf(i16));
                        if (preloadPlayerInfo != null) {
                            preloadPlayerInfo.player = superPlayerWrapper;
                            preloadPlayerInfo.videoView = sPlayerVideoView;
                        } else {
                            superPlayerWrapper.release();
                        }
                    }
                } catch (TPLoadLibraryException e16) {
                    LogUtil.e(PreloadPlayerMgr.TAG, e16);
                }
            }
        });
    }

    @Override // com.tencent.superplayer.preload.IPreloadPlayerMgr
    public PreloadPlayerInfo getPlayerFromPool(int i3, SuperPlayerVideoInfo superPlayerVideoInfo) {
        synchronized (this.mPreloadTaskMap) {
            Iterator<Map.Entry<Integer, PreloadPlayerInfo>> it = this.mPreloadTaskMap.entrySet().iterator();
            while (it.hasNext()) {
                PreloadPlayerInfo value = it.next().getValue();
                if (value.sceneId == i3 && value.videoInfo.equals(superPlayerVideoInfo)) {
                    it.remove();
                    return getWrapperFromPlayerInfo(value);
                }
            }
            return null;
        }
    }

    @Override // com.tencent.superplayer.preload.IPreloadPlayerMgr
    public int startPreloadTask(Activity activity, int i3, SuperPlayerVideoInfo superPlayerVideoInfo) {
        int andAdd = this.mTaskIdIncreaser.getAndAdd(1);
        PreloadPlayerInfo preloadPlayerInfo = new PreloadPlayerInfo();
        preloadPlayerInfo.sceneId = i3;
        preloadPlayerInfo.videoInfo = superPlayerVideoInfo;
        this.mPreloadTaskMap.put(Integer.valueOf(andAdd), preloadPlayerInfo);
        preloadPlayerAsync(activity, i3, superPlayerVideoInfo, andAdd);
        return andAdd;
    }

    @Override // com.tencent.superplayer.preload.IPreloadPlayerMgr
    public void stopPreloadTask(int i3) {
        synchronized (this.mPreloadTaskMap) {
            final PreloadPlayerInfo remove = this.mPreloadTaskMap.remove(Integer.valueOf(i3));
            if (remove != null) {
                ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.preload.PreloadPlayerMgr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SuperPlayerWrapper superPlayerWrapper = remove.player;
                        if (superPlayerWrapper != null) {
                            superPlayerWrapper.release();
                        }
                    }
                });
            }
        }
    }
}
