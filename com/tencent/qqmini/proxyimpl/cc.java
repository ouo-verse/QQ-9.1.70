package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.live2.jsplugin.player.V2TXLivePlayerJSAdapter;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* compiled from: P */
@ProxyService(proxy = IWXLivePlayerProxy.class)
/* loaded from: classes34.dex */
public class cc implements IWXLivePlayerProxy {

    /* renamed from: d, reason: collision with root package name */
    private static volatile Boolean f347888d = Boolean.FALSE;

    /* renamed from: a, reason: collision with root package name */
    private TXCloudVideoView f347889a;

    /* renamed from: b, reason: collision with root package name */
    private V2TXLivePlayerJSAdapter f347890b;

    /* renamed from: c, reason: collision with root package name */
    private TXLivePlayer.ITXAudioVolumeEvaluationListener f347891c;

    public cc() {
        cf.b();
    }

    private boolean a() {
        if (f347888d.booleanValue()) {
            return true;
        }
        f347888d = Boolean.valueOf(cf.c());
        return f347888d.booleanValue();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void init(Context context, InvocationHandler invocationHandler, InvocationHandler invocationHandler2) {
        Log.d("WXLivePlayerApiProxy", "WXLivePlayerApiProxy.init");
        synchronized (IWXLivePlayerProxy.class) {
            if (!a()) {
                QMLog.i("WXLivePlayerApiProxy", "initNativeEnv() fail");
                return;
            }
            this.f347890b = new V2TXLivePlayerJSAdapter(context);
            try {
                txLivePlayer_setPlayListener((ITXLivePlayListener) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{ITXLivePlayListener.class}, invocationHandler));
                txLivePlayer_setAudioVolumeEvaluationListener((TXLivePlayer.ITXAudioVolumeEvaluationListener) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{TXLivePlayer.ITXAudioVolumeEvaluationListener.class}, invocationHandler2));
            } catch (Exception e16) {
                QMLog.e("WXLivePlayerApiProxy", "bind InnerTXLivePlayListenerImpl failed, e" + e16.toString());
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void initLivePlayer(Object obj, Bundle bundle) {
        QMLog.i("WXLivePlayerApiProxy", "initLivePlayer view: " + obj + " , params = " + bundle);
        if (obj != null && (obj instanceof TXCloudVideoView)) {
            TXCloudVideoView tXCloudVideoView = (TXCloudVideoView) obj;
            this.f347889a = tXCloudVideoView;
            V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
            if (v2TXLivePlayerJSAdapter != null) {
                v2TXLivePlayerJSAdapter.initLivePlayer(tXCloudVideoView, bundle);
                return;
            }
            return;
        }
        this.f347889a = null;
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter2 = this.f347890b;
        if (v2TXLivePlayerJSAdapter2 != null) {
            v2TXLivePlayerJSAdapter2.initLivePlayer(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public boolean needLoadAvJar() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txCloudVideoView_disableLog(Boolean bool) {
        TXCloudVideoView tXCloudVideoView = this.f347889a;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.disableLog(bool.booleanValue());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txCloudVideoView_showLog(Boolean bool) {
        TXCloudVideoView tXCloudVideoView = this.f347889a;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.showLog(bool.booleanValue());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayConfig_setMaxAutoAdjustCacheTime(float f16) {
        Bundle bundle = new Bundle();
        bundle.putFloat("maxCache", f16);
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.updateLivePlayer(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayConfig_setMinAutoAdjustCacheTime(float f16) {
        Bundle bundle = new Bundle();
        bundle.putFloat("minCache", f16);
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.updateLivePlayer(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlay_snapshot(InvocationHandler invocationHandler) {
        Object newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{TXLivePlayer.ITXSnapshotListener.class}, invocationHandler);
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.setSnapshotListener((TXLivePlayer.ITXSnapshotListener) newProxyInstance);
            this.f347890b.operateLivePlayer("snapshot", null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_enableAudioVolumeEvaluation(int i3) {
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            if (i3 == 0) {
                v2TXLivePlayerJSAdapter.setAudioVolumeListener(null);
            } else {
                v2TXLivePlayerJSAdapter.setAudioVolumeListener(this.f347891c);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public boolean txLivePlayer_isPlaying() {
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            return v2TXLivePlayerJSAdapter.isPlaying();
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_muteAudio(Boolean bool) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("muteAudio", bool.booleanValue());
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.updateLivePlayer(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_muteVideo(Boolean bool) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("muteVideo", bool.booleanValue());
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.updateLivePlayer(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_pause() {
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.operateLivePlayer("pause", null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_resume() {
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.operateLivePlayer("resume", null);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setAudioRoute(int i3) {
        Bundle bundle = new Bundle();
        if (i3 == 0) {
            bundle.putString("soundMode", "speaker");
        } else if (i3 == 1) {
            bundle.putString("soundMode", "ear");
        }
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.updateLivePlayer(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setAudioVolumeEvaluationListener(Object obj) {
        TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener = (TXLivePlayer.ITXAudioVolumeEvaluationListener) obj;
        this.f347891c = iTXAudioVolumeEvaluationListener;
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.setAudioVolumeListener(iTXAudioVolumeEvaluationListener);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setConfig() {
        QMLog.i("WXLivePlayerApiProxy", "no surpport txLivePlayer_setConfig");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setPlayListener(Object obj) {
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.setPlayListener((ITXLivePlayListener) obj);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setPlayerView(Object obj) {
        QMLog.i("WXLivePlayerApiProxy", "no surpport txLivePlayer_setPlayerView");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setRenderMode(int i3) {
        Bundle bundle = new Bundle();
        if (i3 == 0) {
            bundle.putString("objectFit", "fillCrop");
        } else if (i3 == 1) {
            bundle.putString("objectFit", HVideoConstants.ResizeType.RESIZE_CONTAIN);
        }
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.updateLivePlayer(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setRenderRotation(int i3) {
        Bundle bundle = new Bundle();
        if (i3 == 270) {
            bundle.putString("orientation", "horizontal");
        } else if (i3 == 0) {
            bundle.putString("orientation", "vertical");
        }
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.updateLivePlayer(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setSurface(Surface surface) {
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.setSurface(surface);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setSurfaceSize(int i3, int i16) {
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.setSurfaceSize(i3, i16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_showDebugLog(Boolean bool) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("debug", bool.booleanValue());
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.updateLivePlayer(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public int txLivePlayer_startPlay(String str, int i3) {
        QMLog.d("WXLivePlayerApiProxy", "txLivePlayer_startPlay: url = " + str);
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            return v2TXLivePlayerJSAdapter.operateLivePlayer("play", null).errorCode;
        }
        return -1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public int txLivePlayer_stopPlay(Boolean bool) {
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            return v2TXLivePlayerJSAdapter.operateLivePlayer("stop", null).errorCode;
        }
        return -1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txPlayConfig_setEnableMessage(Boolean bool) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("enableRecvMessage", bool.booleanValue());
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.updateLivePlayer(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void updateLivePlayer(Bundle bundle) {
        QMLog.i("WXLivePlayerApiProxy", "updateLivePlayer, params = " + bundle);
        V2TXLivePlayerJSAdapter v2TXLivePlayerJSAdapter = this.f347890b;
        if (v2TXLivePlayerJSAdapter != null) {
            v2TXLivePlayerJSAdapter.updateLivePlayer(bundle);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayConfig_setAutoAdjustCacheTime(Boolean bool) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayConfig_setCacheTime(float f16) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayConfig_setEnableMetaData(Boolean bool) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_enableHardwareDecode(Boolean bool) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void hookListenerAndGoOn(String str, InvocationHandler invocationHandler) {
    }
}
