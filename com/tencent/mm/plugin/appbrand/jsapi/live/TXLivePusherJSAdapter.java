package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.luggage.wxa.ff.h;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0001\u00a2\u0006\u0004\b'\u0010(J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0001J\t\u0010\t\u001a\u00020\u0007H\u0096\u0001J\u001d\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u001d\u0010\u0015\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0096\u0001J\u0013\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0001J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001cH\u0096\u0001J\u0013\u0010\u001f\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\u0013\u0010!\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010 H\u0096\u0001J\t\u0010\"\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001\u00a8\u0006)"}, d2 = {"Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXLivePusherJSAdapter;", "Lcom/tencent/luggage/wxa/ff/b;", "", "enable", "", "enableCustomVideoCapture", "forceStop", "Lcom/tencent/luggage/wxa/ff/h;", "enterBackground", "enterForeground", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "videoView", "Landroid/os/Bundle;", "params", "initLivePusher", "", "angle", "notifyOrientationChanged", "", "operateName", "Lorg/json/JSONObject;", c.NAME, "Lcom/tencent/live2/V2TXLiveDef$V2TXLiveVideoFrame;", "videoFrame", "sendCustomVideoFrame", "Lcom/tencent/rtmp/TXLivePusher$ITXAudioVolumeEvaluationListener;", "listener", "setAudioVolumeListener", "Lcom/tencent/rtmp/TXLivePusher$OnBGMNotify;", "setBGMNotifyListener", "Lcom/tencent/rtmp/ITXLivePushListener;", "setPushListener", "Lcom/tencent/rtmp/TXLivePusher$ITXSnapshotListener;", "setSnapshotListener", "unInitLivePusher", d.NAME, "Landroid/content/Context;", "context", "realJsAdapter", "<init>", "(Landroid/content/Context;Lcom/tencent/luggage/wxa/ff/b;)V", "luggage-qcloud-live-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class TXLivePusherJSAdapter implements com.tencent.luggage.wxa.ff.b {
    private final /* synthetic */ com.tencent.luggage.wxa.ff.b $$delegate_0;

    @JvmOverloads
    public TXLivePusherJSAdapter(@Nullable Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void enableCustomVideoCapture(boolean enable) {
        this.$$delegate_0.enableCustomVideoCapture(enable);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public h enterBackground(boolean forceStop) {
        return this.$$delegate_0.enterBackground(forceStop);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public h enterForeground() {
        return this.$$delegate_0.enterForeground();
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public h initLivePusher(@Nullable TXCloudVideoView videoView, @Nullable Bundle params) {
        return this.$$delegate_0.initLivePusher(videoView, params);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void notifyOrientationChanged(int angle) {
        this.$$delegate_0.notifyOrientationChanged(angle);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public h operateLivePusher(@Nullable String operateName, @Nullable JSONObject params) {
        return this.$$delegate_0.operateLivePusher(operateName, params);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void sendCustomVideoFrame(@NotNull V2TXLiveDef.V2TXLiveVideoFrame videoFrame) {
        Intrinsics.checkNotNullParameter(videoFrame, "videoFrame");
        this.$$delegate_0.sendCustomVideoFrame(videoFrame);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setAudioVolumeListener(@Nullable TXLivePusher.ITXAudioVolumeEvaluationListener listener) {
        this.$$delegate_0.setAudioVolumeListener(listener);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setBGMNotifyListener(@Nullable TXLivePusher.OnBGMNotify listener) {
        this.$$delegate_0.setBGMNotifyListener(listener);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setPushListener(@Nullable ITXLivePushListener listener) {
        this.$$delegate_0.setPushListener(listener);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setSnapshotListener(@Nullable TXLivePusher.ITXSnapshotListener listener) {
        this.$$delegate_0.setSnapshotListener(listener);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public h unInitLivePusher() {
        return this.$$delegate_0.unInitLivePusher();
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public h updateLivePusher(@Nullable Bundle params) {
        return this.$$delegate_0.updateLivePusher(params);
    }

    @JvmOverloads
    public TXLivePusherJSAdapter(@Nullable Context context, @NotNull com.tencent.luggage.wxa.ff.b realJsAdapter) {
        Intrinsics.checkNotNullParameter(realJsAdapter, "realJsAdapter");
        this.$$delegate_0 = realJsAdapter;
    }

    public /* synthetic */ TXLivePusherJSAdapter(Context context, com.tencent.luggage.wxa.ff.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? new TXLivePusherJSAdapterV2(context) : bVar);
    }
}
