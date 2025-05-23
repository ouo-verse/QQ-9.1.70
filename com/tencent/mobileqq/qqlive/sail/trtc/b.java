package com.tencent.mobileqq.qqlive.sail.trtc;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/trtc/b;", "", "", "qualityType", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "closeMic", WidgetCacheConstellationData.INTERVAL, "enableAudioVolumeEvaluation", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setAudioVolume", "Lcom/tencent/mobileqq/qqlive/api/audio/audioeffect/IRTCMusicAccompany;", "createMusicAccompany", "", "mute", "e", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface b {
    void closeMic();

    @Nullable
    IRTCMusicAccompany createMusicAccompany();

    void e(boolean mute);

    void enableAudioVolumeEvaluation(int interval);

    void m(int qualityType);

    void setAudioVolume(int volume);
}
