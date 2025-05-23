package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.wxa.ff.f;
import com.tencent.luggage.wxa.ff.h;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0001\u00a2\u0006\u0004\b#\u0010$J\u001b\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\t\u0010\b\u001a\u00020\u0006H\u0096\u0001J\u001d\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u001d\u0010\u0012\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u0013\u0010\u0018\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0017H\u0096\u0001J\u0013\u0010\u001a\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0019H\u0096\u0001J\u001b\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0019H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u0006H\u0096\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001\u00a8\u0006%"}, d2 = {"Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXLivePlayerJSAdapter;", "Lcom/tencent/luggage/wxa/ff/a;", "Lcom/tencent/luggage/wxa/xd/d;", MosaicConstants$JsProperty.PROP_ENV, "Lcom/tencent/luggage/wxa/ic/e$d;", "pauseType", "Lcom/tencent/luggage/wxa/ff/h;", "enterBackground", "enterForeground", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "videoView", "Landroid/os/Bundle;", "params", "initLivePlayer", "", "operateName", "Lorg/json/JSONObject;", "param", com.tencent.luggage.wxa.ff.c.NAME, "Lcom/tencent/rtmp/TXLivePlayer$ITXAudioVolumeEvaluationListener;", "listener", "", "setAudioVolumeListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "setPlayListener", "Lcom/tencent/rtmp/TXLivePlayer$ITXSnapshotListener;", "setSnapshotListener", "", "needCompress", "takePhoto", "uninitLivePlayer", f.NAME, "Landroid/content/Context;", "context", "realJsAdapter", "<init>", "(Landroid/content/Context;Lcom/tencent/luggage/wxa/ff/a;)V", "luggage-qcloud-live-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class TXLivePlayerJSAdapter implements com.tencent.luggage.wxa.ff.a {
    private final /* synthetic */ com.tencent.luggage.wxa.ff.a $$delegate_0;

    @JvmOverloads
    public TXLivePlayerJSAdapter(@Nullable Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h enterBackground(@Nullable com.tencent.luggage.wxa.xd.d env, @NotNull e.d pauseType) {
        Intrinsics.checkNotNullParameter(pauseType, "pauseType");
        return this.$$delegate_0.enterBackground(env, pauseType);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h enterForeground() {
        return this.$$delegate_0.enterForeground();
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h initLivePlayer(@Nullable TXCloudVideoView videoView, @Nullable Bundle params) {
        return this.$$delegate_0.initLivePlayer(videoView, params);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h operateLivePlayer(@Nullable String operateName, @Nullable JSONObject param) {
        return this.$$delegate_0.operateLivePlayer(operateName, param);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void setAudioVolumeListener(@Nullable TXLivePlayer.ITXAudioVolumeEvaluationListener listener) {
        this.$$delegate_0.setAudioVolumeListener(listener);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void setPlayListener(@Nullable ITXLivePlayListener listener) {
        this.$$delegate_0.setPlayListener(listener);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void setSnapshotListener(@Nullable TXLivePlayer.ITXSnapshotListener listener) {
        this.$$delegate_0.setSnapshotListener(listener);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void takePhoto(boolean needCompress, @Nullable TXLivePlayer.ITXSnapshotListener listener) {
        this.$$delegate_0.takePhoto(needCompress, listener);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h uninitLivePlayer() {
        return this.$$delegate_0.uninitLivePlayer();
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h updateLivePlayer(@Nullable Bundle params) {
        return this.$$delegate_0.updateLivePlayer(params);
    }

    @JvmOverloads
    public TXLivePlayerJSAdapter(@Nullable Context context, @NotNull com.tencent.luggage.wxa.ff.a realJsAdapter) {
        Intrinsics.checkNotNullParameter(realJsAdapter, "realJsAdapter");
        this.$$delegate_0 = realJsAdapter;
    }

    public /* synthetic */ TXLivePlayerJSAdapter(Context context, com.tencent.luggage.wxa.ff.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? new TXLivePlayerJSAdapterV2(context) : aVar);
    }
}
