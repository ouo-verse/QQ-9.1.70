package com.tencent.biz.richframework.video.rfw.view;

import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class RFWAudioPlayerManager extends RFWBasePlayerManager {
    private static volatile RFWAudioPlayerManager sInstance;
    private ConcurrentHashMap<String, RFWPlayer> mAudioPlayerMap = new ConcurrentHashMap<>();

    RFWAudioPlayerManager() {
        initPlay();
    }

    public static RFWAudioPlayerManager getInstance() {
        if (sInstance == null) {
            synchronized (RFWVideoPlayerManager.class) {
                if (sInstance == null) {
                    sInstance = new RFWAudioPlayerManager();
                }
            }
        }
        return sInstance;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public RFWPlayer getPlayer(String str) {
        if (this.mAudioPlayerMap.containsKey(str)) {
            return this.mAudioPlayerMap.get(str);
        }
        QLog.d("QFSAudioPlayerManager", 1, "getPlayer is null = " + str);
        return null;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized RFWPlayer newAQCirclePlayer(String str) {
        RFWPlayer rFWPlayer;
        rFWPlayer = new RFWPlayer();
        this.mAudioPlayerMap.put(str, rFWPlayer);
        return rFWPlayer;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public void putPlayer(String str, RFWPlayer rFWPlayer) {
        if (this.mAudioPlayerMap.containsKey(str)) {
            this.mAudioPlayerMap.remove(str);
        }
        this.mAudioPlayerMap.put(str, rFWPlayer);
    }

    public synchronized void releaseAll() {
        ConcurrentHashMap<String, RFWPlayer> concurrentHashMap = this.mAudioPlayerMap;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            iteratorRelease(this.mAudioPlayerMap.entrySet().iterator());
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized boolean releasePlayer(String str) {
        if (this.mAudioPlayerMap.containsKey(str)) {
            this.mAudioPlayerMap.get(str).release(RFWPlayer.RELEASE_FROM_VIDEO_VIEW);
            this.mAudioPlayerMap.remove(str);
            return true;
        }
        QLog.d("QFSAudioPlayerManager", 1, "releasePlayer is null:" + str);
        return false;
    }
}
