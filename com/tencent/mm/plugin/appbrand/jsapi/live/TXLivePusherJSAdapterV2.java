package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter;
import com.tencent.luggage.wxa.ff.h;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class TXLivePusherJSAdapterV2 implements com.tencent.luggage.wxa.ff.b {

    @NonNull
    protected final V2TXLivePusherJSAdapter mPusherAdapter;
    private boolean mPushingBeforeEnterBackground = false;
    private boolean mForceStop = false;

    public TXLivePusherJSAdapterV2(Context context) {
        this.mPusherAdapter = new V2TXLivePusherJSAdapter(context);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void enableCustomVideoCapture(boolean z16) {
        this.mPusherAdapter.enableCustomVideoCapture(z16);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public h enterBackground(boolean z16) {
        boolean isPushing = this.mPusherAdapter.isPushing();
        this.mPushingBeforeEnterBackground = isPushing;
        if (isPushing) {
            this.mForceStop = z16;
            if (z16) {
                return operateLivePusher("stop", null);
            }
            return operateLivePusher("pause", null);
        }
        return new h();
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public h enterForeground() {
        if (this.mPushingBeforeEnterBackground) {
            if (this.mForceStop) {
                return operateLivePusher("start", null);
            }
            return operateLivePusher("resume", null);
        }
        return new h();
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public h initLivePusher(TXCloudVideoView tXCloudVideoView, Bundle bundle) {
        return new h(this.mPusherAdapter.initLivePusher(tXCloudVideoView, bundle));
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void notifyOrientationChanged(int i3) {
        this.mPusherAdapter.notifyOrientationChanged(i3);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public h operateLivePusher(String str, JSONObject jSONObject) {
        return new h(this.mPusherAdapter.operateLivePusher(str, jSONObject));
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void sendCustomVideoFrame(@NonNull V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        this.mPusherAdapter.sendCustomVideoFrame(v2TXLiveVideoFrame);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mPusherAdapter.setAudioVolumeListener(iTXAudioVolumeEvaluationListener);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setBGMNotifyListener(TXLivePusher.OnBGMNotify onBGMNotify) {
        this.mPusherAdapter.setBGMNotifyListener(onBGMNotify);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        this.mPusherAdapter.setPushListener(iTXLivePushListener);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public void setSnapshotListener(TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        this.mPusherAdapter.setSnapshotListener(iTXSnapshotListener);
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public h unInitLivePusher() {
        return new h(this.mPusherAdapter.unInitLivePusher());
    }

    @Override // com.tencent.luggage.wxa.ff.b
    public h updateLivePusher(Bundle bundle) {
        return new h(this.mPusherAdapter.updateLivePusher(bundle));
    }
}
