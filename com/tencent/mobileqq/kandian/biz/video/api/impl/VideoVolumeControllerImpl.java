package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0013\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u001b\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0001\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoVolumeControllerImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeController;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeController$a;", "listener", "", "addEventListener", "", "streamType", "getStreamMaxVolume", "Landroid/content/Context;", "context", "inKandianModule", "outKandianModule", "removeEventListener", "", "isFocus", "", "what", "requestOrAbandonAudioFocus", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class VideoVolumeControllerImpl implements IVideoVolumeController {
    private final /* synthetic */ VideoVolumeController $$delegate_0 = VideoVolumeController.getInstance();

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
    public void addEventListener(IVideoVolumeController.a listener) {
        this.$$delegate_0.addEventListener(listener);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
    public int getStreamMaxVolume(int streamType) {
        return this.$$delegate_0.getStreamMaxVolume(streamType);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
    public void inKandianModule(Context context) {
        this.$$delegate_0.inKandianModule(context);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
    public void outKandianModule(Context context) {
        this.$$delegate_0.outKandianModule(context);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
    public void removeEventListener(IVideoVolumeController.a listener) {
        this.$$delegate_0.removeEventListener(listener);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
    public void requestOrAbandonAudioFocus(boolean isFocus, String what) {
        this.$$delegate_0.requestOrAbandonAudioFocus(isFocus, what);
    }
}
