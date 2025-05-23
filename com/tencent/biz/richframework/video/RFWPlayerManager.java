package com.tencent.biz.richframework.video;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes5.dex */
public class RFWPlayerManager implements IProcessStateChangeCallback {
    private static volatile RFWPlayerManager sInstance;
    private final ConcurrentHashMap<String, RFWPlayer> mPlayersMap = new ConcurrentHashMap<>();
    private final CopyOnWriteArraySet<String> mStopPlayers = new CopyOnWriteArraySet<>();
    private final boolean mNeedCheckBackgroundState = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("CHECK_BACKGROUND_PLAY", true);
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final Runnable mCheckPlayingInBackgroundTask = new Runnable() { // from class: com.tencent.biz.richframework.video.e
        @Override // java.lang.Runnable
        public final void run() {
            RFWPlayerManager.this.lambda$new$0();
        }
    };

    RFWPlayerManager() {
        initPlay();
        RFWLifecycleHelper.getInstance().registerProcessChangeListener(this);
    }

    public static RFWPlayerManager g() {
        if (sInstance == null) {
            synchronized (RFWPlayerManager.class) {
                if (sInstance == null) {
                    sInstance = new RFWPlayerManager();
                }
            }
        }
        return sInstance;
    }

    private void initPlay() {
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            try {
                QQVideoPlaySDKManager.initSDKAsync(RFWApplication.getApplication(), new SDKInitListener() { // from class: com.tencent.biz.richframework.video.RFWPlayerManager.1
                    @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                    public void onSDKInited(boolean z16) {
                        if (!z16) {
                            QLog.e("RFWPlayerManager", 1, "onSDKInited failed");
                        }
                    }
                });
            } catch (RuntimeException e16) {
                QLog.e("RFWPlayerManager", 1, e16.getMessage(), e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        Set<Map.Entry<String, RFWPlayer>> entrySet = this.mPlayersMap.entrySet();
        QLog.d("RFWPlayerManager", 1, "mCheckPlayingInBackgroundTask player size:" + entrySet.size());
        for (Map.Entry<String, RFWPlayer> entry : entrySet) {
            RFWPlayer value = entry.getValue();
            if (value != null && value.isPlaying()) {
                QLog.d("RFWPlayerManager", 1, "find player play in background stop it:" + entry.getKey());
                value.stop();
                this.mStopPlayers.add(entry.getKey());
            }
        }
    }

    private void releaseAllPlay() {
        this.mStopPlayers.clear();
        if (this.mPlayersMap.size() > 0) {
            Iterator<String> it = this.mPlayersMap.keySet().iterator();
            while (it.hasNext()) {
                this.mPlayersMap.remove(it.next()).release();
            }
        }
    }

    public RFWPlayer getPlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.mPlayersMap.containsKey(str)) {
            return this.mPlayersMap.get(str);
        }
        QLog.d("RFWPlayerManager", 1, "getPlayer null ");
        return null;
    }

    public synchronized RFWPlayer obtainNewPlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QLog.d("RFWPlayerManager", 1, "when obtainNewPlayer release players, size:" + this.mPlayersMap.size());
        releaseAllPlay();
        RFWPlayer rFWPlayer = new RFWPlayer();
        this.mPlayersMap.put(str, rFWPlayer);
        return rFWPlayer;
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public void onProcessBackground() {
        if (this.mNeedCheckBackgroundState) {
            this.mMainHandler.postDelayed(this.mCheckPlayingInBackgroundTask, 1000L);
        }
    }

    @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
    public void onProcessForeground() {
        if (this.mNeedCheckBackgroundState) {
            this.mMainHandler.removeCallbacks(this.mCheckPlayingInBackgroundTask);
        }
    }

    public void releasePlayer(String str) {
        RFWPlayer player = getPlayer(str);
        if (player == null) {
            QLog.d("RFWPlayerManager", 1, "releasePlayer is null:" + str);
            return;
        }
        QLog.d("RFWPlayerManager", 1, "releasePlayer :" + str);
        this.mPlayersMap.remove(str);
        this.mStopPlayers.remove(str);
        player.release();
    }
}
