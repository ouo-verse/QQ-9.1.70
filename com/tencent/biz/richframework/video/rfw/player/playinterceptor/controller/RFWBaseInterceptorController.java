package com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller;

import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerConfig;
import com.tencent.biz.richframework.video.rfw.player.init.RFWPlayerManger;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class RFWBaseInterceptorController implements IRFWPlayerAction {
    protected final LinkedList<RFWPlayerBaseInterceptor> mInterceptorList = new LinkedList<>();
    protected RFWPlayer mPlayer;

    public RFWBaseInterceptorController(RFWPlayer rFWPlayer) {
        this.mPlayer = rFWPlayer;
        assembleInterceptor();
        addConfigInterceptor();
        bindPlayer();
    }

    private void addConfigInterceptor() {
        RFWPlayerConfig config = RFWPlayerManger.g(this.mPlayer.getRFWPlayerOptions().getSceneId()).getConfig();
        if (config != null && config.getInterceptor() != null) {
            try {
                Iterator<Class<RFWPlayerBaseInterceptor>> it = config.getInterceptor().iterator();
                while (it.hasNext()) {
                    RFWPlayerBaseInterceptor newInstance = it.next().newInstance();
                    newInstance.bindController(this);
                    this.mInterceptorList.add(newInstance);
                }
            } catch (Exception e16) {
                RFWLog.d(this.mPlayer.getRFWPlayerOptions().tag(), RFWLog.USR, "inject class interceptor failed", e16);
            }
        }
    }

    private void bindPlayer() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().bindPlayer(this.mPlayer);
        }
    }

    public void afterCreateView() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().afterCreateView();
        }
    }

    public void afterOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().afterOpenMedia(superPlayerOption, iSuperPlayer);
        }
    }

    public abstract void assembleInterceptor();

    public Surface beforeCreateView() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            Surface beforeCreateView = it.next().beforeCreateView();
            if (beforeCreateView != null) {
                return beforeCreateView;
            }
        }
        return null;
    }

    public void beforeOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().beforeOpenMedia(superPlayerOption, iSuperPlayer);
        }
    }

    public void downloadComplete() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().downloadComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPlayerSceneId() {
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null && rFWPlayer.getRFWPlayerOptions() != null) {
            return this.mPlayer.getRFWPlayerOptions().getSceneId();
        }
        return 126;
    }

    public <T> T getTargetIntercept(@NonNull Class<T> cls) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            T t16 = (T) ((RFWPlayerBaseInterceptor) it.next());
            if (t16.getClass().getCanonicalName().equals(cls.getCanonicalName())) {
                return t16;
            }
        }
        return null;
    }

    public void onCompletion(ISuperPlayer iSuperPlayer) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onCompletion(iSuperPlayer);
        }
    }

    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onError(iSuperPlayer, i3, i16, i17, str);
        }
        return false;
    }

    public void onInfo(int i3, long j3, long j16, Object obj) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onInfo(i3, j3, j16, obj);
        }
    }

    public void onNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onNetVideoInfo(tVKNetVideoInfo);
        }
    }

    public void onPause() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    public void onPermissionTimeout(ISuperPlayer iSuperPlayer) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPermissionTimeout(iSuperPlayer);
        }
    }

    public void onPlayerActive(SuperPlayerOption superPlayerOption) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPlayerActive(superPlayerOption);
        }
    }

    public void onPlayerCDNInfoUpdate(Object obj) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPlayerCDNInfoUpdate(obj);
        }
    }

    public void onPlayerCurrentLoopStart() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPlayerCurrentLoopStart();
        }
    }

    public void onPlayerDeInit() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPlayerDeInit();
        }
    }

    public void onPlayerInfoBufferingEnd() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPlayerInfoBufferingEnd();
        }
    }

    public void onPlayerInfoBufferingStart() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPlayerInfoBufferingStart();
        }
    }

    public void onPlayerInfoCurrentLoopEnd() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPlayerInfoCurrentLoopEnd();
        }
    }

    public void onPlayerInfoDownloadProgressUpdate(ISuperPlayer iSuperPlayer, Object obj) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPlayerInfoDownloadProgressUpdate(iSuperPlayer, obj);
        }
    }

    public void onPlayerInfoFirstVideoFrameRendered() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPlayerInfoFirstVideoFrameRendered();
        }
    }

    public void onPlayerParamsReset() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPlayerParamsReset();
        }
    }

    public void onPlayerQUICUpdate(Object obj) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onPlayerQUICUpdate(obj);
        }
    }

    public void onRelease(int i3) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onRelease(i3);
        }
    }

    public void onSeekComplete(ISuperPlayer iSuperPlayer) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onSeekComplete(iSuperPlayer);
        }
    }

    public void onStart() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    public void onStartTrackingTouch(int i3, int i16) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onStartTrackingTouch(i3, i16);
        }
    }

    public void onStop() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    public void onStopTrackingTouch(int i3, int i16) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onStopTrackingTouch(i3, i16);
        }
    }

    public void onUpdateProgress(int i3, int i16) {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onUpdateProgress(i3, i16);
        }
    }

    public void onVideoPrepare() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().onVideoPrepare();
        }
    }

    public void playerStartPlayState() {
        Iterator<RFWPlayerBaseInterceptor> it = this.mInterceptorList.iterator();
        while (it.hasNext()) {
            it.next().playerStartPlayState();
        }
    }
}
