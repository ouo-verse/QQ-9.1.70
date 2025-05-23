package com.tencent.luggage.wxa.d8;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.luggage.wxa.ff.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.jsapi.live.TXLivePlayerJSAdapterV2;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends TXLivePlayerJSAdapterV2 implements a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f124133a = "TXLivePlayerJSAdapterV2SameLayerSupport";

    public c(Context context) {
        super(context);
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public h a(Bundle bundle) {
        b(bundle);
        return new h(this.mWXLiveJSPlayerAdapter.initLivePlayer(bundle));
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public boolean b() {
        return this.mWXLiveJSPlayerAdapter.isMuted();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.live.TXLivePlayerJSAdapterV2, com.tencent.luggage.wxa.ff.a
    public h enterForeground() {
        return operateLivePlayer("play", null);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.live.TXLivePlayerJSAdapterV2, com.tencent.luggage.wxa.ff.a
    public h initLivePlayer(TXCloudVideoView tXCloudVideoView, Bundle bundle) {
        b(bundle);
        return super.initLivePlayer(tXCloudVideoView, bundle);
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public boolean isPlaying() {
        return this.mWXLiveJSPlayerAdapter.isPlaying();
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public void sendHandupStop() {
        ITXLivePlayListener iTXLivePlayListener = this.mLivePlayListener;
        if (iTXLivePlayListener != null) {
            iTXLivePlayListener.onPlayEvent(6000, new Bundle());
        }
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public void sendWeChatStop() {
        ITXLivePlayListener iTXLivePlayListener = this.mLivePlayListener;
        if (iTXLivePlayListener != null) {
            iTXLivePlayListener.onPlayEvent(6001, new Bundle());
        }
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public h setSurface(Surface surface) {
        return new h(this.mWXLiveJSPlayerAdapter.setSurface(surface));
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public h setSurfaceSize(int i3, int i16) {
        return new h(this.mWXLiveJSPlayerAdapter.setSurfaceSize(i3, i16));
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.live.TXLivePlayerJSAdapterV2, com.tencent.luggage.wxa.ff.a
    public h updateLivePlayer(Bundle bundle) {
        b(bundle);
        return super.updateLivePlayer(bundle);
    }

    private void b(@Nullable Bundle bundle) {
        if (bundle == null || bundle.containsKey(V2TXJSAdapterConstants.PLAYER_KEY_CAN_AUTO_PLAY)) {
            return;
        }
        w.d(f124133a, "canStartPlayWorkaround, put true");
        bundle.putBoolean(V2TXJSAdapterConstants.PLAYER_KEY_CAN_AUTO_PLAY, true);
    }

    @Override // com.tencent.luggage.wxa.d8.a
    public h a() {
        if (this.mWXLiveJSPlayerAdapter.isPlaying()) {
            return operateLivePlayer("stop", null);
        }
        return new h();
    }
}
