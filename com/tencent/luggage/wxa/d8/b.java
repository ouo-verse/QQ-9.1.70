package com.tencent.luggage.wxa.d8;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.luggage.wxa.ff.f;
import com.tencent.luggage.wxa.ff.h;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.xd.d;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0001\u00a2\u0006\u0004\b/\u00100J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u001b\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\t\u0010\t\u001a\u00020\u0002H\u0096\u0001J\u0013\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u001d\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u000fH\u0096\u0001J\u001d\u0010\u0016\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0017H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0017H\u0096\u0001J\u0013\u0010\u001c\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0001J\u0013\u0010\u001e\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J\u0013\u0010 \u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001fH\u0096\u0001J\u0013\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0001J\u0019\u0010'\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0096\u0001J\u001b\u0010)\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001fH\u0096\u0001J\t\u0010*\u001a\u00020\u0002H\u0096\u0001J\u0013\u0010+\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0001\u00a8\u00061"}, d2 = {"Lcom/tencent/luggage/wxa/d8/b;", "Lcom/tencent/luggage/wxa/d8/a;", "Lcom/tencent/luggage/wxa/ff/h;", "a", "Lcom/tencent/luggage/wxa/xd/d;", MosaicConstants$JsProperty.PROP_ENV, "Lcom/tencent/luggage/wxa/ic/e$d;", "pauseType", "enterBackground", "enterForeground", "Landroid/os/Bundle;", "params", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "videoView", "initLivePlayer", "", "b", "isPlaying", "", "operateName", "Lorg/json/JSONObject;", "param", com.tencent.luggage.wxa.ff.c.NAME, "", "sendHandupStop", "sendWeChatStop", "Lcom/tencent/rtmp/TXLivePlayer$ITXAudioVolumeEvaluationListener;", "listener", "setAudioVolumeListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "setPlayListener", "Lcom/tencent/rtmp/TXLivePlayer$ITXSnapshotListener;", "setSnapshotListener", "Landroid/view/Surface;", "surface", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, "", "width", "height", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize, "needCompress", "takePhoto", "uninitLivePlayer", f.NAME, "Landroid/content/Context;", "context", "realJsAdapter", "<init>", "(Landroid/content/Context;Lcom/tencent/luggage/wxa/d8/a;)V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ a f124132a;

    @JvmOverloads
    public b(@Nullable Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.luggage.wxa.d8.a
    @NotNull
    public h a() {
        return this.f124132a.a();
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public boolean b() {
        return this.f124132a.b();
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h enterBackground(@Nullable d env, @NotNull e.d pauseType) {
        Intrinsics.checkNotNullParameter(pauseType, "pauseType");
        return this.f124132a.enterBackground(env, pauseType);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h enterForeground() {
        return this.f124132a.enterForeground();
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h initLivePlayer(@Nullable TXCloudVideoView videoView, @Nullable Bundle params) {
        return this.f124132a.initLivePlayer(videoView, params);
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public boolean isPlaying() {
        return this.f124132a.isPlaying();
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h operateLivePlayer(@Nullable String operateName, @Nullable JSONObject param) {
        return this.f124132a.operateLivePlayer(operateName, param);
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public void sendHandupStop() {
        this.f124132a.sendHandupStop();
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public void sendWeChatStop() {
        this.f124132a.sendWeChatStop();
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void setAudioVolumeListener(@Nullable TXLivePlayer.ITXAudioVolumeEvaluationListener listener) {
        this.f124132a.setAudioVolumeListener(listener);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void setPlayListener(@Nullable ITXLivePlayListener listener) {
        this.f124132a.setPlayListener(listener);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void setSnapshotListener(@Nullable TXLivePlayer.ITXSnapshotListener listener) {
        this.f124132a.setSnapshotListener(listener);
    }

    @Override // com.tencent.luggage.wxa.d8.a
    @NotNull
    public h setSurface(@Nullable Surface surface) {
        return this.f124132a.setSurface(surface);
    }

    @Override // com.tencent.luggage.wxa.d8.a
    @NotNull
    public h setSurfaceSize(int width, int height) {
        return this.f124132a.setSurfaceSize(width, height);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void takePhoto(boolean needCompress, @Nullable TXLivePlayer.ITXSnapshotListener listener) {
        this.f124132a.takePhoto(needCompress, listener);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h uninitLivePlayer() {
        return this.f124132a.uninitLivePlayer();
    }

    @Override // com.tencent.luggage.wxa.ff.a
    @NotNull
    public h updateLivePlayer(@Nullable Bundle params) {
        return this.f124132a.updateLivePlayer(params);
    }

    @JvmOverloads
    public b(@Nullable Context context, @NotNull a realJsAdapter) {
        Intrinsics.checkNotNullParameter(realJsAdapter, "realJsAdapter");
        this.f124132a = realJsAdapter;
    }

    @Override // com.tencent.luggage.wxa.d8.a
    @NotNull
    public h a(@Nullable Bundle params) {
        return this.f124132a.a(params);
    }

    public /* synthetic */ b(Context context, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? new c(context) : aVar);
    }
}
