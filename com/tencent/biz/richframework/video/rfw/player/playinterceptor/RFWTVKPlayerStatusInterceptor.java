package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.player.events.RFWTVKPlayerStatusEvent;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerOption;

/* loaded from: classes5.dex */
public class RFWTVKPlayerStatusInterceptor extends RFWPlayerBaseInterceptor {
    public RFWTVKPlayerStatusInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void afterOpenMedia(SuperPlayerOption superPlayerOption, ISuperPlayer iSuperPlayer) {
        super.afterOpenMedia(superPlayerOption, iSuperPlayer);
        SimpleEventBus.getInstance().dispatchEvent(new RFWTVKPlayerStatusEvent(1));
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        SimpleEventBus.getInstance().dispatchEvent(new RFWTVKPlayerStatusEvent(8));
        return super.onError(iSuperPlayer, i3, i16, i17, str);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPause() {
        super.onPause();
        SimpleEventBus.getInstance().dispatchEvent(new RFWTVKPlayerStatusEvent(5));
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPermissionTimeout(ISuperPlayer iSuperPlayer) {
        super.onPermissionTimeout(iSuperPlayer);
        SimpleEventBus.getInstance().dispatchEvent(new RFWTVKPlayerStatusEvent(9));
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onPlayerInfoFirstVideoFrameRendered() {
        super.onPlayerInfoFirstVideoFrameRendered();
        SimpleEventBus.getInstance().dispatchEvent(new RFWTVKPlayerStatusEvent(3));
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStart() {
        super.onStart();
        SimpleEventBus.getInstance().dispatchEvent(new RFWTVKPlayerStatusEvent(4));
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onStop() {
        super.onStop();
        SimpleEventBus.getInstance().dispatchEvent(new RFWTVKPlayerStatusEvent(6));
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public void onVideoPrepare() {
        super.onVideoPrepare();
        SimpleEventBus.getInstance().dispatchEvent(new RFWTVKPlayerStatusEvent(2));
    }
}
