package com.tencent.mobileqq.kandian.biz.video.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeController;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeController$a;", "listener", "", "addEventListener", "removeEventListener", "Landroid/content/Context;", "context", "inKandianModule", "outKandianModule", "", "isFocus", "", "what", "requestOrAbandonAudioFocus", "", "streamType", "getStreamMaxVolume", "a", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVideoVolumeController extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeController$a;", "", "", "onPhoneCome", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "onSystemVolumeChanged", "", "on", "onHeadsetStateChanged", "onFocusLoss", "onFocusGain", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface a {
        void onFocusGain();

        void onFocusLoss();

        void onHeadsetStateChanged(boolean on5);

        void onPhoneCome();

        void onSystemVolumeChanged(int volume);
    }

    void addEventListener(@Nullable a listener);

    int getStreamMaxVolume(int streamType);

    void inKandianModule(@Nullable Context context);

    void outKandianModule(@Nullable Context context);

    void removeEventListener(@Nullable a listener);

    void requestOrAbandonAudioFocus(boolean isFocus, @Nullable String what);
}
