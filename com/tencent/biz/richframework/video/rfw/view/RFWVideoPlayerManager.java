package com.tencent.biz.richframework.video.rfw.view;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWVideoPlayerManager extends RFWBasePlayerManager {
    private static volatile RFWVideoPlayerManager sInstance;
    private ConcurrentHashMap<String, RFWPlayer> mVideoPlayerMap = new ConcurrentHashMap<>();

    RFWVideoPlayerManager() {
        initPlay();
    }

    public static RFWVideoPlayerManager getInstance() {
        if (sInstance == null) {
            synchronized (RFWVideoPlayerManager.class) {
                if (sInstance == null) {
                    sInstance = new RFWVideoPlayerManager();
                }
            }
        }
        return sInstance;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public RFWPlayer getPlayer(String str) {
        if (this.mVideoPlayerMap.containsKey(str)) {
            return this.mVideoPlayerMap.get(str);
        }
        if (!o.O0()) {
            return null;
        }
        Iterator<String> it = this.mVideoPlayerMap.keySet().iterator();
        while (it.hasNext()) {
            RFWPlayer rFWPlayer = this.mVideoPlayerMap.get(it.next());
            if (rFWPlayer != null && rFWPlayer.getRFWPlayerOptions() != null && rFWPlayer.getRFWPlayerOptions().getFileId().equals(str)) {
                QLog.d("QFSVideoPlayerManager", 1, "getPlayer reuse = " + str);
                return rFWPlayer;
            }
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized RFWPlayer newAQCirclePlayer(String str) {
        RFWPlayer rFWPlayer;
        rFWPlayer = new RFWPlayer();
        this.mVideoPlayerMap.put(str, rFWPlayer);
        return rFWPlayer;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public void putPlayer(String str, RFWPlayer rFWPlayer) {
        RFWPlayer rFWPlayer2 = this.mVideoPlayerMap.get(str);
        if (rFWPlayer2 != null) {
            rFWPlayer2.release(RFWPlayer.RELEASE_FROM_PLAYER_MANGER);
            this.mVideoPlayerMap.remove(str);
            QLog.d("QFSVideoPlayerManager", 1, "putPlayer has old view :" + str);
        }
        this.mVideoPlayerMap.put(str, rFWPlayer);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public void putReusePlayer(String str, RFWPlayer rFWPlayer) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && rFWPlayer != null) {
            String valueOf = String.valueOf(rFWPlayer.hashCode());
            try {
                Iterator<Map.Entry<String, RFWPlayer>> it = this.mVideoPlayerMap.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (TextUtils.equals(valueOf, String.valueOf(it.next().getValue().hashCode()))) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    this.mVideoPlayerMap.put(str, rFWPlayer);
                    QLog.d("QFSVideoPlayerManager", 1, "putReusePlayer to manger  ");
                }
            } catch (Exception e16) {
                QLog.d("QFSVideoPlayerManager", 1, "putReusePlayer to manger e ", e16);
            }
        }
    }

    public synchronized void releaseAll() {
        ConcurrentHashMap<String, RFWPlayer> concurrentHashMap = this.mVideoPlayerMap;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            iteratorRelease(this.mVideoPlayerMap.entrySet().iterator());
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized boolean releasePlayer(String str) {
        RFWPlayer rFWPlayer = this.mVideoPlayerMap.get(str);
        if (rFWPlayer != null) {
            rFWPlayer.release(RFWPlayer.RELEASE_FROM_VIDEO_VIEW);
            this.mVideoPlayerMap.remove(str);
            QLog.d("QFSVideoPlayerManager", 1, "releasePlayer success = " + str);
            return true;
        }
        QLog.d("QFSVideoPlayerManager", 1, "releasePlayer is null = " + str);
        return false;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public void removeReUsePlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Iterator<Map.Entry<String, RFWPlayer>> it = this.mVideoPlayerMap.entrySet().iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(str, String.valueOf(it.next().getValue().hashCode()))) {
                    it.remove();
                    QLog.d("QFSVideoPlayerManager", 1, "removePlayer from manger " + str);
                }
            }
        } catch (Exception e16) {
            QLog.d("QFSVideoPlayerManager", 1, "removePlayer from manger e ", e16);
        }
    }
}
