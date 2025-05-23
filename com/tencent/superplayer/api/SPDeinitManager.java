package com.tencent.superplayer.api;

import android.view.Surface;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.player.SuperPlayerMgr;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import yc4.a;

/* loaded from: classes26.dex */
public class SPDeinitManager {
    private static final String TAG = "Super-DeinitedPlayerPool";
    private final Map<String, DeinitPlayerInfo> tokenPlayerInfoMaps = new HashMap();

    /* loaded from: classes26.dex */
    public static class DeinitPlayerInfo {
        public long duration;
        public boolean loopback;
        public MediaInfo mediaInfo;
        public boolean needRecover;
        public boolean outputMuted;
        public String playerTag;
        public long position;
        public int serviceType;
        public float speedRatio;
        public int state;
        public WeakReference<Surface> surface;
        public String token;
        public WeakReference<ISPlayerVideoView> videoView;
        public int xyAxis;
        public boolean isPreplay = false;
        public boolean stopPlayerInBackground = true;
        public boolean quickStopPlayerInBackground = false;
    }

    public static DeinitPlayerInfo getDeinitPlayerInfo(ISuperPlayer iSuperPlayer) {
        if (iSuperPlayer instanceof SuperPlayerMgr) {
            return ((SuperPlayerMgr) iSuperPlayer).getDeinitPlayerInfo();
        }
        if (iSuperPlayer instanceof a) {
            return ((a) iSuperPlayer).k();
        }
        return new DeinitPlayerInfo();
    }

    private void notifyEvent(ISuperPlayer iSuperPlayer, int i3) {
        if (iSuperPlayer instanceof SuperPlayerMgr) {
            ((SuperPlayerMgr) iSuperPlayer).notifyCustomInfoEvent(i3, 0L, 0L, null);
        } else if (iSuperPlayer instanceof a) {
            ((a) iSuperPlayer).o(i3, 0, 0, null);
        }
    }

    public synchronized boolean deinitAllRunningPlayer(ISuperPlayerPool iSuperPlayerPool, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        z17 = true;
        for (Map.Entry<String, ISuperPlayer> entry : iSuperPlayerPool.getAllPlayer().entrySet()) {
            ISuperPlayer value = entry.getValue();
            if (getState(value.getToken()) == null) {
                int currentPlayerState = value.getCurrentPlayerState();
                String token = value.getToken();
                DeinitPlayerInfo deinitPlayerInfo = getDeinitPlayerInfo(value);
                if ((z16 && deinitPlayerInfo.quickStopPlayerInBackground) || (!z16 && deinitPlayerInfo.stopPlayerInBackground)) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (currentPlayerState >= 1 && currentPlayerState <= 7) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z18) {
                    if (z19) {
                        deinitPlayerInfo.needRecover = true;
                        this.tokenPlayerInfoMaps.put(token, deinitPlayerInfo);
                        value.stop();
                        value.reset();
                        notifyEvent(value, 253);
                        LogUtil.d(TAG, "deinitAllRunningPlayer: player[" + entry.getKey() + "] need resume after foreground, state=" + currentPlayerState);
                    } else {
                        deinitPlayerInfo.needRecover = false;
                        this.tokenPlayerInfoMaps.put(token, deinitPlayerInfo);
                    }
                } else {
                    LogUtil.d(TAG, "deinitAllRunningPlayer: player[" + entry.getKey() + "] can not deinit, state=" + currentPlayerState);
                    z17 = false;
                }
            }
        }
        return z17;
    }

    public DeinitPlayerInfo getState(String str) {
        return this.tokenPlayerInfoMaps.get(str);
    }

    public void setPlayerActive(ISuperPlayer iSuperPlayer) {
        DeinitPlayerInfo remove = this.tokenPlayerInfoMaps.remove(iSuperPlayer.getToken());
        if (remove != null) {
            CommonUtil.j(remove.serviceType);
            if (remove.needRecover) {
                ISPlayerVideoView iSPlayerVideoView = remove.videoView.get();
                Surface surface = remove.surface.get();
                if (iSuperPlayer.getVideoView() == null && iSPlayerVideoView != null) {
                    iSuperPlayer.updatePlayerVideoView(iSPlayerVideoView);
                } else if (iSuperPlayer instanceof SuperPlayerMgr) {
                    if (((SuperPlayerMgr) iSuperPlayer).getSurface() == null && surface != null) {
                        iSuperPlayer.setSurface(surface);
                    } else {
                        LogUtil.e(TAG, "setPlayerActive error, can not recover videoview \uff0cplayer[" + iSuperPlayer.getToken() + "]");
                    }
                } else if (iSuperPlayer instanceof a) {
                    if (((a) iSuperPlayer).m() == null && surface != null) {
                        iSuperPlayer.setSurface(surface);
                    } else {
                        LogUtil.e(TAG, "setPlayerActive error, can not recover videoview \uff0cplayer[" + iSuperPlayer.getToken() + "]");
                    }
                }
                iSuperPlayer.setXYaxis(remove.xyAxis);
                float f16 = remove.speedRatio;
                if (f16 != 1.0f) {
                    iSuperPlayer.setPlaySpeedRatio(f16);
                }
                iSuperPlayer.setOutputMute(remove.outputMuted);
                iSuperPlayer.setLoopback(remove.loopback);
                notifyEvent(iSuperPlayer, 254);
            }
            LogUtil.d(TAG, "setPlayerActive: player[" + iSuperPlayer.getToken() + "], state.needRecover=" + remove.needRecover);
        }
    }
}
