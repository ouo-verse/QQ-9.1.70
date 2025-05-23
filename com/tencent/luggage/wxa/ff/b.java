package com.tencent.luggage.wxa.ff;

import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\u0014\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u001c\u0010\u0019\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u001a\u001a\u00020\u0013H&J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001bH&J\b\u0010\u001e\u001a\u00020\u0013H&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001bH&J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006$\u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/luggage/wxa/ff/b;", "", "", "angle", "", "notifyOrientationChanged", "Lcom/tencent/rtmp/ITXLivePushListener;", "listener", "setPushListener", "Lcom/tencent/rtmp/TXLivePusher$OnBGMNotify;", "setBGMNotifyListener", "Lcom/tencent/rtmp/TXLivePusher$ITXAudioVolumeEvaluationListener;", "setAudioVolumeListener", "Lcom/tencent/rtmp/TXLivePusher$ITXSnapshotListener;", "setSnapshotListener", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "videoView", "Landroid/os/Bundle;", "params", "Lcom/tencent/luggage/wxa/ff/h;", "initLivePusher", com.tencent.mm.plugin.appbrand.jsapi.live.d.NAME, "", "operateName", "Lorg/json/JSONObject;", com.tencent.mm.plugin.appbrand.jsapi.live.c.NAME, "unInitLivePusher", "", "forceStop", "enterBackground", "enterForeground", "enable", "enableCustomVideoCapture", "Lcom/tencent/live2/V2TXLiveDef$V2TXLiveVideoFrame;", "videoFrame", "sendCustomVideoFrame", "luggage-qcloud-live-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public interface b {
    void enableCustomVideoCapture(boolean enable);

    @NotNull
    h enterBackground(boolean forceStop);

    @NotNull
    h enterForeground();

    @NotNull
    h initLivePusher(@Nullable TXCloudVideoView videoView, @Nullable Bundle params);

    void notifyOrientationChanged(int angle);

    @NotNull
    h operateLivePusher(@Nullable String operateName, @Nullable JSONObject params);

    void sendCustomVideoFrame(@NotNull V2TXLiveDef.V2TXLiveVideoFrame videoFrame);

    void setAudioVolumeListener(@Nullable TXLivePusher.ITXAudioVolumeEvaluationListener listener);

    void setBGMNotifyListener(@Nullable TXLivePusher.OnBGMNotify listener);

    void setPushListener(@Nullable ITXLivePushListener listener);

    void setSnapshotListener(@Nullable TXLivePusher.ITXSnapshotListener listener);

    @NotNull
    h unInitLivePusher();

    @NotNull
    h updateLivePusher(@Nullable Bundle params);
}
