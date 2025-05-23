package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import com.tencent.live2.jsplugin.player.V2TXLivePlayerJSAdapter;
import com.tencent.luggage.wxa.ff.h;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.p004if.g;
import com.tencent.luggage.wxa.p004if.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class TXLivePlayerJSAdapterV2 implements com.tencent.luggage.wxa.ff.a {
    private static final String TAG = "TXLivePlayerJSAdapterV2";
    protected ITXLivePlayListener mLivePlayListener;
    protected V2TXLivePlayerJSAdapter mWXLiveJSPlayerAdapter;
    private boolean mPlayingBeforeEnterBackground = false;
    private boolean mNeedEvent = false;
    private boolean mAutoPauseIfNavigate = true;
    private boolean mAutoPauseIfOpenNative = true;

    public TXLivePlayerJSAdapterV2(Context context) {
        this.mWXLiveJSPlayerAdapter = new V2TXLivePlayerJSAdapter(context);
    }

    private void parseAndApplyParams(Bundle bundle, boolean z16) {
        this.mNeedEvent = bundle.getBoolean("needEvent", this.mNeedEvent);
        this.mAutoPauseIfNavigate = bundle.getBoolean("autoPauseIfNavigate", this.mAutoPauseIfNavigate);
        this.mAutoPauseIfOpenNative = bundle.getBoolean("autoPauseIfOpenNative", this.mAutoPauseIfOpenNative);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public h enterBackground(@Nullable com.tencent.luggage.wxa.xd.d dVar, @NonNull e.d dVar2) {
        ITXLivePlayListener iTXLivePlayListener;
        w.d(TAG, "enterBackground, pauseType: %s", dVar2);
        r a16 = g.f130201b.a(this.mAutoPauseIfNavigate, this.mAutoPauseIfOpenNative);
        w.d(TAG, "enterBackground, autoPauseStrategy: %s", a16);
        if (!a16.a(dVar, dVar2)) {
            this.mPlayingBeforeEnterBackground = false;
            return new h();
        }
        boolean isPlaying = this.mWXLiveJSPlayerAdapter.isPlaying();
        this.mPlayingBeforeEnterBackground = isPlaying;
        if (isPlaying) {
            if (this.mNeedEvent && (iTXLivePlayListener = this.mLivePlayListener) != null) {
                iTXLivePlayListener.onPlayEvent(6000, new Bundle());
            }
            return operateLivePlayer("stop", null);
        }
        return new h();
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public h enterForeground() {
        if (this.mPlayingBeforeEnterBackground) {
            return operateLivePlayer("play", null);
        }
        return new h();
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public h initLivePlayer(TXCloudVideoView tXCloudVideoView, Bundle bundle) {
        V2TXJSAdapterError initLivePlayer = this.mWXLiveJSPlayerAdapter.initLivePlayer(tXCloudVideoView, bundle);
        if (-1 != initLivePlayer.errorCode) {
            parseAndApplyParams(bundle, true);
        }
        return new h(initLivePlayer);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public h operateLivePlayer(String str, JSONObject jSONObject) {
        return new h(this.mWXLiveJSPlayerAdapter.operateLivePlayer(str, jSONObject));
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mWXLiveJSPlayerAdapter.setAudioVolumeListener(iTXAudioVolumeEvaluationListener);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mLivePlayListener = iTXLivePlayListener;
        this.mWXLiveJSPlayerAdapter.setPlayListener(iTXLivePlayListener);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void setSnapshotListener(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        this.mWXLiveJSPlayerAdapter.setSnapshotListener(iTXSnapshotListener);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public void takePhoto(boolean z16, TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        this.mWXLiveJSPlayerAdapter.takePhoto(z16, iTXSnapshotListener);
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public h uninitLivePlayer() {
        return new h(this.mWXLiveJSPlayerAdapter.uninitLivePlayer());
    }

    @Override // com.tencent.luggage.wxa.ff.a
    public h updateLivePlayer(Bundle bundle) {
        V2TXJSAdapterError updateLivePlayer = this.mWXLiveJSPlayerAdapter.updateLivePlayer(bundle);
        int i3 = updateLivePlayer.errorCode;
        if (-1 != i3 && -3 != i3) {
            parseAndApplyParams(bundle, true);
        }
        return new h(updateLivePlayer);
    }
}
