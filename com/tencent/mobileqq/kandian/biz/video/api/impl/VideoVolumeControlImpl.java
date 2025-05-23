package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import j62.b;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0096\u0001J#\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0096\u0001J\u001b\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0007H\u0096\u0001\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoVolumeControlImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeControl;", "Landroid/content/Context;", "context", "", "isInPhoneCall", "shouldMute", "", "saveConfig", "mute", "", "reason", "", "what", "setMute", "Lj62/b;", "manager", "setMuteForce", "shouldMuteInReadInJoy", "startAudioPlay", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class VideoVolumeControlImpl implements IVideoVolumeControl {
    private final /* synthetic */ VideoVolumeControl $$delegate_0 = VideoVolumeControl.getInstance();

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public boolean isInPhoneCall(Context context) {
        return this.$$delegate_0.isInPhoneCall(context);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public void saveConfig(boolean shouldMute) {
        this.$$delegate_0.saveConfig(shouldMute);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public void setMute(boolean mute, String reason, int what) {
        this.$$delegate_0.setMute(mute, reason, what);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public void setMuteForce(b manager, boolean mute) {
        this.$$delegate_0.setMuteForce(manager, mute);
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public boolean shouldMuteInReadInJoy() {
        return this.$$delegate_0.shouldMuteInReadInJoy();
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
    public void startAudioPlay() {
        this.$$delegate_0.startAudioPlay();
    }
}
