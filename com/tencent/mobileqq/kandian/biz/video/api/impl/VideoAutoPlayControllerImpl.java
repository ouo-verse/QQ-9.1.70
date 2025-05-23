package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0096\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001J\t\u0010\n\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u0096\u0001J\t\u0010\f\u001a\u00020\u0004H\u0096\u0001J\t\u0010\r\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0096\u0001\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoAutoPlayControllerImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoAutoPlayController;", "()V", "canAutoPlayVideo", "", "initVideoPlaySetting", "", "p0", "", "kotlin.jvm.PlatformType", "isNeedNetWorkAlert", "isNeedNetWorkAlertForIPC", "isRefreshingList", "isWifi", "setChannelFrom", "", "setChannelId", "", "setIsRefreshingList", "updateNetworkChange", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class VideoAutoPlayControllerImpl implements IVideoAutoPlayController {
    private final /* synthetic */ VideoAutoPlayController $$delegate_0 = VideoAutoPlayController.getInstance();

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public boolean canAutoPlayVideo() {
        return this.$$delegate_0.canAutoPlayVideo();
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public void initVideoPlaySetting(String p06) {
        this.$$delegate_0.initVideoPlaySetting(p06);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public boolean isNeedNetWorkAlert() {
        return this.$$delegate_0.isNeedNetWorkAlert();
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public boolean isNeedNetWorkAlertForIPC() {
        return this.$$delegate_0.isNeedNetWorkAlertForIPC();
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public boolean isRefreshingList() {
        return this.$$delegate_0.isRefreshingList();
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public boolean isWifi() {
        return this.$$delegate_0.isWifi();
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public void setChannelFrom(long p06) {
        this.$$delegate_0.setChannelFrom(p06);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public void setChannelId(int p06) {
        this.$$delegate_0.setChannelId(p06);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public void setIsRefreshingList(boolean p06) {
        this.$$delegate_0.setIsRefreshingList(p06);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public void updateNetworkChange(boolean p06) {
        this.$$delegate_0.updateNetworkChange(p06);
    }
}
