package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u00019B\u001d\b\u0007\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\u0001\u00a2\u0006\u0004\b7\u00108J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0001J\t\u0010\t\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001J\u001d\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nH\u0096\u0001J\u001d\u0010\u0017\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u0016H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0004H\u0096\u0001J\u0013\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0096\u0001J\u0013\u0010!\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010 H\u0096\u0001J\u0019\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0096\u0001J\u0013\u0010'\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010&H\u0096\u0001J\u0013\u0010)\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010(H\u0096\u0001J\u0013\u0010,\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010*H\u0096\u0001J\u0019\u0010/\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0096\u0001J\u0011\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\nH\u0096\u0001J\t\u00102\u001a\u00020\u0007H\u0096\u0001J\u0013\u00103\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001\u00a8\u0006:"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/TXLivePusherJSAdapter;", "Lcom/tencent/luggage/wxa/f8/m;", "", "enable", "", "enableCustomVideoCapture", "forceStop", "Lcom/tencent/luggage/wxa/ff/h;", "enterBackground", "enterForeground", "", "getMaxZoom", "Landroid/os/Bundle;", "params", "initLivePusher", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "videoView", "isPushing", "angle", "notifyOrientationChanged", "", "operateName", "Lorg/json/JSONObject;", com.tencent.mm.plugin.appbrand.jsapi.live.c.NAME, "Lcom/tencent/live2/V2TXLiveDef$V2TXLiveVideoFrame;", "videoFrame", "sendCustomVideoFrame", "sendHandupStop", "sendWeChatStop", "Lcom/tencent/rtmp/TXLivePusher$ITXAudioVolumeEvaluationListener;", "listener", "setAudioVolumeListener", "Lcom/tencent/rtmp/TXLivePusher$OnBGMNotify;", "setBGMNotifyListener", "", HippyTKDListViewAdapter.X, "y", "setFocusPosition", "Lcom/tencent/rtmp/ITXLivePushListener;", "setPushListener", "Lcom/tencent/rtmp/TXLivePusher$ITXSnapshotListener;", "setSnapshotListener", "Landroid/view/Surface;", "surface", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, "width", "height", V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize, "value", "setZoom", "unInitLivePusher", com.tencent.mm.plugin.appbrand.jsapi.live.d.NAME, "Landroid/content/Context;", "context", "realJsAdapter", "<init>", "(Landroid/content/Context;Lcom/tencent/luggage/wxa/f8/m;)V", "Companion", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class TXLivePusherJSAdapter implements com.tencent.luggage.wxa.f8.m {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final /* synthetic */ com.tencent.luggage.wxa.f8.m $$delegate_0;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/TXLivePusherJSAdapter$Companion;", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/b$b;", "weEffectFactory", "", "setWeEffectManagerFactory", "<init>", "()V", "luggage-xweb-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void setWeEffectManagerFactory(@NotNull b.InterfaceC7005b weEffectFactory) {
            Intrinsics.checkNotNullParameter(weEffectFactory, "weEffectFactory");
            TXLivePusherJSAdapterV2SameLayerSupport.setWeEffectManagerFactory(weEffectFactory);
        }
    }

    @JvmOverloads
    public TXLivePusherJSAdapter(@Nullable Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    @JvmStatic
    public static final void setWeEffectManagerFactory(@NotNull b.InterfaceC7005b interfaceC7005b) {
        INSTANCE.setWeEffectManagerFactory(interfaceC7005b);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void enableCustomVideoCapture(boolean enable) {
        this.$$delegate_0.enableCustomVideoCapture(enable);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public com.tencent.luggage.wxa.ff.h enterBackground(boolean forceStop) {
        return this.$$delegate_0.enterBackground(forceStop);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public com.tencent.luggage.wxa.ff.h enterForeground() {
        return this.$$delegate_0.enterForeground();
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public int getMaxZoom() {
        return this.$$delegate_0.getMaxZoom();
    }

    @Override // com.tencent.luggage.wxa.f8.m
    @NotNull
    public com.tencent.luggage.wxa.ff.h initLivePusher(@Nullable Bundle params) {
        return this.$$delegate_0.initLivePusher(params);
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public boolean isPushing() {
        return this.$$delegate_0.isPushing();
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void notifyOrientationChanged(int angle) {
        this.$$delegate_0.notifyOrientationChanged(angle);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public com.tencent.luggage.wxa.ff.h operateLivePusher(@Nullable String operateName, @Nullable JSONObject params) {
        return this.$$delegate_0.operateLivePusher(operateName, params);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void sendCustomVideoFrame(@NotNull V2TXLiveDef.V2TXLiveVideoFrame videoFrame) {
        Intrinsics.checkNotNullParameter(videoFrame, "videoFrame");
        this.$$delegate_0.sendCustomVideoFrame(videoFrame);
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public void sendHandupStop() {
        this.$$delegate_0.sendHandupStop();
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public void sendWeChatStop() {
        this.$$delegate_0.sendWeChatStop();
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setAudioVolumeListener(@Nullable TXLivePusher.ITXAudioVolumeEvaluationListener listener) {
        this.$$delegate_0.setAudioVolumeListener(listener);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setBGMNotifyListener(@Nullable TXLivePusher.OnBGMNotify listener) {
        this.$$delegate_0.setBGMNotifyListener(listener);
    }

    @Override // com.tencent.luggage.wxa.f8.m
    @NotNull
    public com.tencent.luggage.wxa.ff.h setFocusPosition(float x16, float y16) {
        return this.$$delegate_0.setFocusPosition(x16, y16);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setPushListener(@Nullable ITXLivePushListener listener) {
        this.$$delegate_0.setPushListener(listener);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setSnapshotListener(@Nullable TXLivePusher.ITXSnapshotListener listener) {
        this.$$delegate_0.setSnapshotListener(listener);
    }

    @Override // com.tencent.luggage.wxa.f8.m
    @NotNull
    public com.tencent.luggage.wxa.ff.h setSurface(@Nullable Surface surface) {
        return this.$$delegate_0.setSurface(surface);
    }

    @Override // com.tencent.luggage.wxa.f8.m
    @NotNull
    public com.tencent.luggage.wxa.ff.h setSurfaceSize(int width, int height) {
        return this.$$delegate_0.setSurfaceSize(width, height);
    }

    @Override // com.tencent.luggage.wxa.f8.m
    @NotNull
    public com.tencent.luggage.wxa.ff.h setZoom(int value) {
        return this.$$delegate_0.setZoom(value);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public com.tencent.luggage.wxa.ff.h unInitLivePusher() {
        return this.$$delegate_0.unInitLivePusher();
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public com.tencent.luggage.wxa.ff.h updateLivePusher(@Nullable Bundle params) {
        return this.$$delegate_0.updateLivePusher(params);
    }

    @JvmOverloads
    public TXLivePusherJSAdapter(@Nullable Context context, @NotNull com.tencent.luggage.wxa.f8.m realJsAdapter) {
        Intrinsics.checkNotNullParameter(realJsAdapter, "realJsAdapter");
        this.$$delegate_0 = realJsAdapter;
    }

    @Override // com.tencent.luggage.wxa.ff.b
    @NotNull
    public com.tencent.luggage.wxa.ff.h initLivePusher(@Nullable TXCloudVideoView videoView, @Nullable Bundle params) {
        return this.$$delegate_0.initLivePusher(videoView, params);
    }

    public /* synthetic */ TXLivePusherJSAdapter(Context context, com.tencent.luggage.wxa.f8.m mVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? new TXLivePusherJSAdapterV2SameLayerSupport(context) : mVar);
    }
}
