package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Proxy;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.LightConstants;

/* compiled from: P */
@ProxyService(proxy = IWXLivePusherProxy.class)
/* loaded from: classes34.dex */
public class cd implements IWXLivePusherProxy {

    /* renamed from: b, reason: collision with root package name */
    private static volatile Boolean f347892b = Boolean.FALSE;

    /* renamed from: a, reason: collision with root package name */
    private V2TXLivePusherJSAdapter f347893a;

    public cd() {
        QMLog.i("WXLivePusherApiProxy", "WXLivePusherApiProxy()");
    }

    private boolean a() {
        if (f347892b.booleanValue()) {
            return true;
        }
        f347892b = Boolean.valueOf(cf.c());
        return f347892b.booleanValue();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void enableAGC(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("enableAGC", z16);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void enableANS(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("enableANS", z16);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void enableAudioEarMonitoring(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("enableEarMonitor", z16);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void enablePureAudioPush(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("autopush", z16);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void initInstance(Context context) {
        QMLog.i("WXLivePusherApiProxy", "initInstance()");
        synchronized (IWXLivePlayerProxy.class) {
            if (!a()) {
                QMLog.i("WXLivePusherApiProxy", "initNativeEnv() fail");
            } else {
                this.f347893a = new V2TXLivePusherJSAdapter(context);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void initLivePusher(Object obj, Bundle bundle) {
        if (this.f347893a == null) {
            QMLog.e("WXLivePusherApiProxy", "initLivePusher mLivePusher is null!");
            return;
        }
        QMLog.i("WXLivePusherApiProxy", "initLivePusher() videoView = " + obj + " , params = " + bundle);
        if (obj != null && (obj instanceof TXCloudVideoView)) {
            this.f347893a.initLivePusher((TXCloudVideoView) obj, bundle);
        } else {
            this.f347893a.initLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean isPushing() {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            return v2TXLivePusherJSAdapter.isPushing();
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public Object newITXLivePushListener(TXLivePushListenerReflect.ITXLivePushListener iTXLivePushListener) {
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{ITXLivePushListener.class}, new TXLivePushListenerReflect.TXLivePushListenerInvocationHandler(iTXLivePushListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public Object newITXSnapshotListener(TXLivePushListenerReflect.ITXSnapshotListener iTXSnapshotListener) {
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{TXLivePusher.ITXSnapshotListener.class}, new TXLivePushListenerReflect.ITXSnapshotListenerInvocationHandler(iTXSnapshotListener));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public Object newOnBGMNotify(TXLivePushListenerReflect.OnBGMNotify onBGMNotify) {
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{TXLivePusher.OnBGMNotify.class}, new TXLivePushListenerReflect.OnBGMNotifyInvocationHandler(onBGMNotify));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean pauseBGM() {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        return v2TXLivePusherJSAdapter != null && v2TXLivePusherJSAdapter.operateLivePusher("pauseBGM", null).errorCode == 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void pausePusher() {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.operateLivePusher("pause", null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean playBGM(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("BGMFilePath", str);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        return v2TXLivePusherJSAdapter != null && v2TXLivePusherJSAdapter.operateLivePusher(com.tencent.luggage.wxa.c8.c.f123373g0, jSONObject).errorCode == 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean resumeBGM() {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        return v2TXLivePusherJSAdapter != null && v2TXLivePusherJSAdapter.operateLivePusher("resumeBGM", null).errorCode == 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void resumePusher() {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.operateLivePusher("resume", null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean sendMessageEx(byte[] bArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg", new String(bArr, "UTF-8"));
        } catch (UnsupportedEncodingException | JSONException e16) {
            e16.printStackTrace();
        }
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        return v2TXLivePusherJSAdapter != null && v2TXLivePusherJSAdapter.operateLivePusher("sendMessage", jSONObject).errorCode == 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setBGMNofify(Object obj) {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter;
        if (!(obj instanceof TXLivePusher.OnBGMNotify) || (v2TXLivePusherJSAdapter = this.f347893a) == null) {
            return;
        }
        v2TXLivePusherJSAdapter.setBGMNotifyListener((TXLivePusher.OnBGMNotify) obj);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean setBGMVolume(float f16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, f16);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        return v2TXLivePusherJSAdapter != null && v2TXLivePusherJSAdapter.operateLivePusher("setBGMVolume", jSONObject).errorCode == 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setBeautyFilter(int i3, int i16, int i17, int i18) {
        String str;
        Bundle bundle = new Bundle();
        if (i3 == 1) {
            str = "nature";
        } else {
            str = LightConstants.DowngradeStrategyKey.SMOOTH;
        }
        bundle.putString(V2TXJSAdapterConstants.PUSHER_KEY_BEAUTY_STYLE, str);
        bundle.putInt("beauty", i16);
        bundle.putInt("whiteness", i17);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setEnableZoom(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("zoom", z16);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setFrontCamera(boolean z16) {
        String str;
        Bundle bundle = new Bundle();
        if (z16) {
            str = "front";
        } else {
            str = "back";
        }
        bundle.putString("devicePosition", str);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setLocalVideoMirrorType(int i3) {
        Bundle bundle = new Bundle();
        String str = "auto";
        if (i3 != 0) {
            if (i3 == 1) {
                str = "enable";
            } else if (i3 == 2) {
                str = "disable";
            }
        }
        bundle.putString("localMirror", str);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMaxVideoBitrate(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("maxBitrate", i3);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMicVolume(float f16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, f16);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.operateLivePusher("setMICVolume", jSONObject);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMinVideoBitrate(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("minBitrate", i3);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMirror(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("mirror", z16);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMuted(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("muted", z16);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setPauseImg(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("backgroundImage", str);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setPushListener(Object obj) {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter;
        if (!(obj instanceof ITXLivePushListener) || (v2TXLivePusherJSAdapter = this.f347893a) == null) {
            return;
        }
        v2TXLivePusherJSAdapter.setPushListener((ITXLivePushListener) obj);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setPusherUrl(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("pushUrl", str);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setReverb(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("audioReverbType", i3);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setSurface(Surface surface) {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.setSurface(surface);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setSurfaceSize(int i3, int i16) {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.setSurfaceSize(i3, i16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setTouchFocus(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putInt("focusMode", !z16 ? 1 : 0);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setVideoResolution(int i3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setWatermark(String str, float f16, float f17, float f18) {
        Bundle bundle = new Bundle();
        bundle.putString("watermarkImage", str);
        bundle.putFloat("watermarkLeft", f16);
        bundle.putFloat("watermarkTop", f17);
        bundle.putFloat("watermarkWidth", f18);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void showDebugLog(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("debug", z16);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void snapshot(Object obj) {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter;
        if (!(obj instanceof TXLivePusher.ITXSnapshotListener) || (v2TXLivePusherJSAdapter = this.f347893a) == null) {
            return;
        }
        v2TXLivePusherJSAdapter.setSnapshotListener((TXLivePusher.ITXSnapshotListener) obj);
        this.f347893a.operateLivePusher("snapshot", null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void startCameraPreview(Object obj) {
        QMLog.d("WXLivePusherApiProxy", "startCameraPreview: " + obj);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.operateLivePusher("startPreview", null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public int startDumpAudioData(String str) {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean startPusher(String str) {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        return v2TXLivePusherJSAdapter != null && v2TXLivePusherJSAdapter.operateLivePusher("start", null).errorCode == 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean stopBGM() {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        return v2TXLivePusherJSAdapter != null && v2TXLivePusherJSAdapter.operateLivePusher("stopBGM", null).errorCode == 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void stopCameraPreview(boolean z16) {
        QMLog.e("WXLivePusherApiProxy", "stopCameraPreview: " + z16);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.operateLivePusher("stopPreview", null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void stopPusher() {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.operateLivePusher("stop", null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void switchCamera() {
        QMLog.e("WXLivePusherApiProxy", "switchCamera...");
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.operateLivePusher("switchCamera", null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void toggleTorch(Object obj) {
        QMLog.w("WXLivePusherApiProxy", "toggleTorch: not implement");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean turnOnFlashLight(boolean z16) {
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        return v2TXLivePusherJSAdapter != null && v2TXLivePusherJSAdapter.operateLivePusher("toggleTorch", null).errorCode == 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void txCloudVideoView_disableLog(Boolean bool, Object obj) {
        if (obj instanceof TXCloudVideoView) {
            ((TXCloudVideoView) obj).disableLog(bool.booleanValue());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void txLivePlayer_setVisibility(int i3, Object obj) {
        if (obj instanceof View) {
            ((View) obj).setVisibility(i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void updateLivePusher(Bundle bundle) {
        QMLog.i("WXLivePusherApiProxy", "updateLivePusher params = " + bundle);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        } else {
            QMLog.e("WXLivePusherApiProxy", "updateLivePusher mLivePusher is null ");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setHomeOrientation(int i3) {
        String str = "vertical";
        if (i3 != 1 && i3 != 3 && (i3 == 0 || i3 == 2)) {
            str = "horizontal";
        }
        Bundle bundle = new Bundle();
        bundle.putString("orientation", str);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setVideoResolution(int i3, int i16) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setEnableCamera(JSONObject jSONObject, Object obj) {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("enable-camera", true);
            Bundle bundle = new Bundle();
            bundle.putBoolean("enableCamera", optBoolean);
            V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
            if (v2TXLivePusherJSAdapter != null) {
                v2TXLivePusherJSAdapter.updateLivePusher(bundle);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMode(JSONObject jSONObject) {
        int i3;
        if (jSONObject != null) {
            String optString = jSONObject.optString("mode", "RTC");
            if ("SD".equals(optString)) {
                i3 = 1;
            } else if ("HD".equals(optString)) {
                i3 = 2;
            } else if ("FHD".equals(optString)) {
                i3 = 3;
            } else {
                QMLog.w("WXLivePusherApiProxy", "setMode unknown mode " + optString);
                i3 = 6;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("mode", i3);
            V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
            if (v2TXLivePusherJSAdapter != null) {
                v2TXLivePusherJSAdapter.updateLivePusher(bundle);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setAudioSampleRate(int i3) {
        String str;
        if (i3 == 16000) {
            str = HippyImageInfo.QUALITY_LOW;
        } else {
            str = "high";
        }
        Bundle bundle = new Bundle();
        bundle.putString("audioQuality", str);
        V2TXLivePusherJSAdapter v2TXLivePusherJSAdapter = this.f347893a;
        if (v2TXLivePusherJSAdapter != null) {
            v2TXLivePusherJSAdapter.updateLivePusher(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setConfig() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void startAudioRecord() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void stopAudioRecord() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void stopDumpAudioData() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setBGMPosition(int i3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setPauseFlag(int i3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setRenderRotation(int i3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setVideoEncodeGop(int i3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setVolumeType(int i3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setVideoQuality(int i3, boolean z16, boolean z17) {
    }
}
