package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b;
import com.tencent.mm.plugin.appbrand.jsapi.live.TXLivePusherJSAdapterV2;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class TXLivePusherJSAdapterV2SameLayerSupport extends TXLivePusherJSAdapterV2 implements com.tencent.luggage.wxa.f8.m {
    private static final String TAG = "TXLivePusherJSAdapterV2SameLayerSupport";
    private ITXLivePushListener mLivePushListener;

    @NonNull
    private final d mWeEffectJSAdapter;

    public TXLivePusherJSAdapterV2SameLayerSupport(Context context) {
        super(context);
        this.mWeEffectJSAdapter = new d(this.mPusherAdapter);
    }

    public static void setWeEffectManagerFactory(@NonNull b.InterfaceC7005b interfaceC7005b) {
        d.a(interfaceC7005b);
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public int getMaxZoom() {
        return this.mPusherAdapter.getMaxZoom();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.live.TXLivePusherJSAdapterV2, com.tencent.luggage.wxa.ff.b
    public com.tencent.luggage.wxa.ff.h initLivePusher(TXCloudVideoView tXCloudVideoView, Bundle bundle) {
        com.tencent.luggage.wxa.ff.h initLivePusher = super.initLivePusher(tXCloudVideoView, bundle);
        this.mWeEffectJSAdapter.a(tXCloudVideoView, bundle);
        return initLivePusher;
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public boolean isPushing() {
        return this.mPusherAdapter.isPushing();
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.live.TXLivePusherJSAdapterV2, com.tencent.luggage.wxa.ff.b
    public com.tencent.luggage.wxa.ff.h operateLivePusher(String str, JSONObject jSONObject) {
        com.tencent.luggage.wxa.ff.h operateLivePusher = super.operateLivePusher(str, jSONObject);
        if (-4 == operateLivePusher.f126108a) {
            return this.mWeEffectJSAdapter.a(str, jSONObject);
        }
        return operateLivePusher;
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public void sendHandupStop() {
        if (this.mLivePushListener != null) {
            com.tencent.luggage.wxa.tn.w.d(TAG, "sendHandupStop, send event 5000");
            this.mLivePushListener.onPushEvent(5000, new Bundle());
        }
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public void sendWeChatStop() {
        if (this.mLivePushListener != null) {
            com.tencent.luggage.wxa.tn.w.d(TAG, "sendWeChatStop, send event 5001");
            this.mLivePushListener.onPushEvent(5001, new Bundle());
        }
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public com.tencent.luggage.wxa.ff.h setFocusPosition(float f16, float f17) {
        return new com.tencent.luggage.wxa.ff.h(this.mPusherAdapter.setFocusPosition(f16, f17));
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.live.TXLivePusherJSAdapterV2, com.tencent.luggage.wxa.ff.b
    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        super.setPushListener(iTXLivePushListener);
        this.mLivePushListener = iTXLivePushListener;
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public com.tencent.luggage.wxa.ff.h setSurface(Surface surface) {
        return new com.tencent.luggage.wxa.ff.h(this.mPusherAdapter.setSurface(surface));
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public com.tencent.luggage.wxa.ff.h setSurfaceSize(int i3, int i16) {
        return new com.tencent.luggage.wxa.ff.h(this.mPusherAdapter.setSurfaceSize(i3, i16));
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public com.tencent.luggage.wxa.ff.h setZoom(int i3) {
        return new com.tencent.luggage.wxa.ff.h(this.mPusherAdapter.setZoom(i3));
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.live.TXLivePusherJSAdapterV2, com.tencent.luggage.wxa.ff.b
    public com.tencent.luggage.wxa.ff.h unInitLivePusher() {
        com.tencent.luggage.wxa.ff.h unInitLivePusher = super.unInitLivePusher();
        this.mWeEffectJSAdapter.e();
        return unInitLivePusher;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.live.TXLivePusherJSAdapterV2, com.tencent.luggage.wxa.ff.b
    public com.tencent.luggage.wxa.ff.h updateLivePusher(Bundle bundle) {
        com.tencent.luggage.wxa.ff.h updateLivePusher = super.updateLivePusher(bundle);
        this.mWeEffectJSAdapter.f(bundle);
        return updateLivePusher;
    }

    @Override // com.tencent.luggage.wxa.f8.m
    public com.tencent.luggage.wxa.ff.h initLivePusher(Bundle bundle) {
        V2TXJSAdapterError initLivePusher = this.mPusherAdapter.initLivePusher(bundle);
        this.mWeEffectJSAdapter.e(bundle);
        return new com.tencent.luggage.wxa.ff.h(initLivePusher);
    }
}
