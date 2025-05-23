package com.tencent.biz.richframework.video.rfw.view;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes5.dex */
public class RFWPlayerManagerProxy extends RFWBasePlayerManager {
    private int mPlayerType;

    public RFWPlayerManagerProxy(boolean z16) {
        this.mPlayerType = z16 ? 1 : 0;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public RFWPlayer getPlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QLog.d("QCircleVideoManager", 1, "getPlayer uniquekey = " + str + ", playerType = " + this.mPlayerType);
        int i3 = this.mPlayerType;
        if (i3 == 0) {
            return RFWVideoPlayerManager.getInstance().getPlayer(str);
        }
        if (i3 != 1) {
            return null;
        }
        return RFWAudioPlayerManager.getInstance().getPlayer(str);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized RFWPlayer newAQCirclePlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QLog.d("QCircleVideoManager", 1, "new circle player, uniqueKey = " + str + ", playerType = " + this.mPlayerType);
        releaseAll();
        int i3 = this.mPlayerType;
        if (i3 == 0) {
            return RFWVideoPlayerManager.getInstance().newAQCirclePlayer(str);
        }
        if (i3 != 1) {
            return null;
        }
        return RFWAudioPlayerManager.getInstance().newAQCirclePlayer(str);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public void putPlayer(String str, RFWPlayer rFWPlayer) {
        if (rFWPlayer == null) {
            return;
        }
        releaseAll();
        int i3 = this.mPlayerType;
        if (i3 == 0) {
            RFWVideoPlayerManager.getInstance().putPlayer(str, rFWPlayer);
        } else if (i3 == 1) {
            RFWAudioPlayerManager.getInstance().putPlayer(str, rFWPlayer);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public void putReusePlayer(String str, RFWPlayer rFWPlayer) {
        int i3 = this.mPlayerType;
        if (i3 == 0) {
            RFWVideoPlayerManager.getInstance().putReusePlayer(str, rFWPlayer);
        } else if (i3 == 1) {
            RFWAudioPlayerManager.getInstance().putReusePlayer(str, rFWPlayer);
        }
    }

    public void releaseAll() {
        QLog.d("QCircleVideoManager", 1, "release all");
        RFWVideoPlayerManager.getInstance().releaseAll();
        RFWAudioPlayerManager.getInstance().releaseAll();
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized boolean releasePlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        QLog.d("QCircleVideoManager", 2, "releasePlayer uniquekey = " + str + ", playerType = " + this.mPlayerType);
        int i3 = this.mPlayerType;
        if (i3 == 0) {
            return RFWVideoPlayerManager.getInstance().releasePlayer(str);
        }
        if (i3 != 1) {
            return false;
        }
        return RFWAudioPlayerManager.getInstance().releasePlayer(str);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public void removeReUsePlayer(String str) {
        int i3 = this.mPlayerType;
        if (i3 == 0) {
            RFWVideoPlayerManager.getInstance().removeReUsePlayer(str);
        } else if (i3 == 1) {
            RFWAudioPlayerManager.getInstance().removeReUsePlayer(str);
        }
    }
}
