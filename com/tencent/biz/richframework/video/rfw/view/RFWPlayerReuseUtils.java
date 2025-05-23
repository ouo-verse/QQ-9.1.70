package com.tencent.biz.richframework.video.rfw.view;

import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerListenerSet;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.view.ISPlayerVideoView;
import mqq.util.WeakReference;
import uq3.o;

/* loaded from: classes5.dex */
public class RFWPlayerReuseUtils {
    private static WeakReference<RFWPlayer> sReusePlayer;

    public static RFWPlayer getReusePlayer(String str) {
        WeakReference<RFWPlayer> weakReference;
        RFWPlayer rFWPlayer;
        RFWPlayerOptions rFWPlayerOptions;
        if (!o.O0() || (weakReference = sReusePlayer) == null || (rFWPlayer = weakReference.get()) == null || (rFWPlayerOptions = rFWPlayer.getRFWPlayerOptions()) == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str) && str.equals(rFWPlayerOptions.getFileId())) {
            rFWPlayerOptions.setOffSetBySeek(false);
            sReusePlayer = null;
            return rFWPlayer;
        }
        rFWPlayer.release(RFWPlayer.RELEASE_BY_REUSE);
        return null;
    }

    public static boolean hasReusePlayer(String str) {
        WeakReference<RFWPlayer> weakReference;
        RFWPlayer rFWPlayer;
        RFWPlayerOptions rFWPlayerOptions;
        if (o.O0() && (weakReference = sReusePlayer) != null && (rFWPlayer = weakReference.get()) != null && (rFWPlayerOptions = rFWPlayer.getRFWPlayerOptions()) != null && !TextUtils.isEmpty(str) && str.equals(rFWPlayerOptions.getFileId())) {
            ISuperPlayer realPlayer = rFWPlayer.getRealPlayer();
            if (!rFWPlayer.isRelease() && !rFWPlayer.isError() && !rFWPlayer.isDeInit() && realPlayer != null && realPlayer.isLoopBack()) {
                return true;
            }
            rFWPlayer.release(RFWPlayer.RELEASE_BY_REUSE);
            RFWLog.d("RFWPlayerReuseUtils", RFWLog.USR, "hasReusePlayer player error status:" + rFWPlayer.getRFWPlayerOptions().tag());
        }
        return false;
    }

    public static void prepareToReusePlayer(RFWVideoView rFWVideoView) {
        RFWPlayer rFWPlayer;
        if (!o.O0()) {
            return;
        }
        Looper.getMainLooper().isCurrentThread();
        if (rFWVideoView == null) {
            return;
        }
        RFWPlayer qCirclePlayer = rFWVideoView.getQCirclePlayer();
        if (qCirclePlayer == null) {
            QLog.d("RFWPlayerReuseUtils", 1, "reusePlayer error no player");
            return;
        }
        WeakReference<RFWPlayer> weakReference = sReusePlayer;
        if (weakReference != null) {
            rFWPlayer = weakReference.get();
        } else {
            rFWPlayer = null;
        }
        if (rFWPlayer != null && rFWPlayer != qCirclePlayer) {
            rFWPlayer.release(RFWPlayer.RELEASE_BY_REUSE);
        }
        sReusePlayer = new WeakReference<>(qCirclePlayer);
        rFWVideoView.onPlayerBeReused(qCirclePlayer);
        qCirclePlayer.getRFWPlayerOptions().setPlayIOC(null);
        qCirclePlayer.getRFWPlayerOptions().replaceListenerSet(new RFWPlayerListenerSet());
        qCirclePlayer.setLoopback(true);
        KeyEvent.Callback videoView = qCirclePlayer.getVideoView();
        if (videoView instanceof ISPlayerVideoView) {
            ((ISPlayerVideoView) videoView).disableViewCallback();
        } else if (videoView instanceof TVKPlayerVideoView) {
            ((TVKPlayerVideoView) videoView).storeSurfaceTexture();
        }
        rFWVideoView.setTag(R.id.f74103vc, qCirclePlayer.getVideoView());
        QLog.d("RFWPlayerReuseUtils", 1, "try to prepare reusePlayer:" + qCirclePlayer.getRFWPlayerOptions().tag());
    }
}
