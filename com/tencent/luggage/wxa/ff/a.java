package com.tencent.luggage.wxa.ff;

import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u001c\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0016\u001a\u00020\u000eH&J\b\u0010\u0017\u001a\u00020\u000eH&J\u001a\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH&J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006 \u00c0\u0006\u0001"}, d2 = {"Lcom/tencent/luggage/wxa/ff/a;", "", "Lcom/tencent/rtmp/ITXLivePlayListener;", "listener", "", "setPlayListener", "Lcom/tencent/rtmp/TXLivePlayer$ITXSnapshotListener;", "setSnapshotListener", "Lcom/tencent/rtmp/TXLivePlayer$ITXAudioVolumeEvaluationListener;", "setAudioVolumeListener", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "videoView", "Landroid/os/Bundle;", "params", "Lcom/tencent/luggage/wxa/ff/h;", "initLivePlayer", f.NAME, "", "operateName", "Lorg/json/JSONObject;", "param", c.NAME, "uninitLivePlayer", "enterForeground", "Lcom/tencent/luggage/wxa/xd/d;", MosaicConstants$JsProperty.PROP_ENV, "Lcom/tencent/luggage/wxa/ic/e$d;", "pauseType", "enterBackground", "", "needCompress", "takePhoto", "luggage-qcloud-live-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public interface a {
    @NotNull
    h enterBackground(@Nullable com.tencent.luggage.wxa.xd.d env, @NotNull e.d pauseType);

    @NotNull
    h enterForeground();

    @NotNull
    h initLivePlayer(@Nullable TXCloudVideoView videoView, @Nullable Bundle params);

    @NotNull
    h operateLivePlayer(@Nullable String operateName, @Nullable JSONObject param);

    void setAudioVolumeListener(@Nullable TXLivePlayer.ITXAudioVolumeEvaluationListener listener);

    void setPlayListener(@Nullable ITXLivePlayListener listener);

    void setSnapshotListener(@Nullable TXLivePlayer.ITXSnapshotListener listener);

    void takePhoto(boolean needCompress, @Nullable TXLivePlayer.ITXSnapshotListener listener);

    @NotNull
    h uninitLivePlayer();

    @NotNull
    h updateLivePlayer(@Nullable Bundle params);
}
