package com.tencent.biz.richframework.video.rfw.player.playinterceptor.tvkplayer;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.RFWPlayerListenerDispatchUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.RFWTVKPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBackGroundInterceptor;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerStatusInterceptor;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWTVKPlayerStatusInterceptor;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.mobileqq.qcircle.api.IQCircleTVKApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.MD5Utils;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnNetVideoInfoListener;
import com.tencent.superplayer.tvkplayer.listener.ITVKOnPermissionTimeoutListener;
import com.tencent.superplayer.view.ISPlayerVideoView;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes5.dex */
public class RFWTVKPlayerInterceptorController extends RFWBaseInterceptorController implements ITVKOnNetVideoInfoListener, ITVKOnPermissionTimeoutListener {
    public RFWTVKPlayerInterceptorController(@NonNull RFWPlayer rFWPlayer) {
        super(rFWPlayer);
    }

    private void openPlayerByUrl(ISuperPlayer iSuperPlayer, RFWTVKPlayerOptions rFWTVKPlayerOptions) {
        iSuperPlayer.openTVKPlayerByUrl(RFWApplication.getApplication(), rFWTVKPlayerOptions.getUrl(), MD5Utils.encodeHexStr(rFWTVKPlayerOptions.getUrl()), rFWTVKPlayerOptions.getStartPositionMilSec(), rFWTVKPlayerOptions.getSkipEndMilSec());
    }

    private void openPlayerByVid(@NotNull ISuperPlayer iSuperPlayer, RFWTVKPlayerOptions rFWTVKPlayerOptions) {
        TVKPlayerVideoInfo tVKPlayerVideoInfo;
        String definition;
        if (rFWTVKPlayerOptions.getTVKUserInfo() == null) {
            TVKUserInfo tVKUserInfo = new TVKUserInfo();
            tVKUserInfo.setLoginType(TVKUserInfo.LoginType.LOGIN_QQ);
            tVKUserInfo.setUin(RFWApplication.getAccountId());
            tVKUserInfo.setLoginCookie(((IQCircleTVKApi) QRoute.api(IQCircleTVKApi.class)).getPlayerCookie() + rFWTVKPlayerOptions.getBusinessCookie());
            rFWTVKPlayerOptions.setTVKUserInfo(tVKUserInfo);
        }
        if (rFWTVKPlayerOptions.getTVKPlayerVideoInfo() != null) {
            tVKPlayerVideoInfo = rFWTVKPlayerOptions.getTVKPlayerVideoInfo();
        } else {
            TVKPlayerVideoInfo tVKPlayerVideoInfo2 = new TVKPlayerVideoInfo(TVKAssetFactory.createOnlineVodVidAsset(rFWTVKPlayerOptions.getVid(), rFWTVKPlayerOptions.getVid()));
            tVKPlayerVideoInfo2.setPlayType(rFWTVKPlayerOptions.getTVKPlayerType());
            tVKPlayerVideoInfo = tVKPlayerVideoInfo2;
        }
        Application application = RFWApplication.getApplication();
        TVKUserInfo tVKUserInfo2 = rFWTVKPlayerOptions.getTVKUserInfo();
        if (TextUtils.isEmpty(rFWTVKPlayerOptions.getDefinition())) {
            definition = "";
        } else {
            definition = rFWTVKPlayerOptions.getDefinition();
        }
        iSuperPlayer.openTVKPlayer(application, tVKUserInfo2, tVKPlayerVideoInfo, definition, rFWTVKPlayerOptions.getStartPositionMilSec(), rFWTVKPlayerOptions.getSkipEndMilSec());
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController
    public void assembleInterceptor() {
        this.mInterceptorList.add(new RFWPlayerStatusInterceptor(this));
        this.mInterceptorList.add(new RFWTVKPlayerCommonInterceptor(this));
        this.mInterceptorList.add(new RFWTVKPlayerStatusInterceptor(this));
        this.mInterceptorList.add(new RFWPlayerBackGroundInterceptor(this));
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.IRFWPlayerAction
    public ISPlayerVideoView createPlayerVideoView() {
        return SuperPlayerFactory.createPlayerVideoView(RFWApplication.getApplication(), true, 1);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.IRFWPlayerAction
    public ISuperPlayer ensureSuperPlayer(ISPlayerVideoView iSPlayerVideoView) {
        ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(RFWApplication.getApplication(), getPlayerSceneId(), iSPlayerVideoView, 1);
        createMediaPlayer.setOnTVKNetVideoInfoListener(this);
        createMediaPlayer.setOnPermissionTimeoutListener(this);
        return createMediaPlayer;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController
    public void onNetVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        super.onNetVideoInfo(tVKNetVideoInfo);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController, com.tencent.superplayer.tvkplayer.listener.ITVKOnPermissionTimeoutListener
    public void onPermissionTimeout(ISuperPlayer iSuperPlayer) {
        if (this.mPlayer == null) {
            return;
        }
        super.onPermissionTimeout(iSuperPlayer);
        RFWPlayerListenerDispatchUtils.onPermissionTimeout(this.mPlayer.getRFWPlayerOptions(), iSuperPlayer);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.IRFWPlayerAction
    public void tryToOpenMediaPlayer(@NonNull ISuperPlayer iSuperPlayer, SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerOption superPlayerOption) {
        RFWPlayer rFWPlayer = this.mPlayer;
        if (rFWPlayer != null && rFWPlayer.getRFWPlayerOptions() != null) {
            RFWPlayerOptions rFWPlayerOptions = this.mPlayer.getRFWPlayerOptions();
            RFWTVKPlayerOptions tVKPlayerOption = rFWPlayerOptions.getTVKPlayerOption();
            if (tVKPlayerOption == null) {
                RFWLog.d(rFWPlayerOptions.tag(), RFWLog.USR, "tvkOption error params");
            } else if (tVKPlayerOption.getVid() == null && tVKPlayerOption.getTVKPlayerVideoInfo() == null && tVKPlayerOption.getUrl() != null) {
                openPlayerByUrl(iSuperPlayer, tVKPlayerOption);
            } else {
                openPlayerByVid(iSuperPlayer, tVKPlayerOption);
            }
        }
    }

    @Override // com.tencent.superplayer.tvkplayer.listener.ITVKOnNetVideoInfoListener
    public void onNetVideoInfo(ISuperPlayer iSuperPlayer, TVKNetVideoInfo tVKNetVideoInfo) {
        if (this.mPlayer == null) {
            return;
        }
        super.onNetVideoInfo(tVKNetVideoInfo);
        RFWPlayerListenerDispatchUtils.onNetVideoInfo(this.mPlayer.getRFWPlayerOptions(), tVKNetVideoInfo);
    }
}
