package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* compiled from: P */
@ProxyService(proxy = IWXLivePlayerProxy.class)
/* loaded from: classes23.dex */
public class i implements IWXLivePlayerProxy {

    /* renamed from: a, reason: collision with root package name */
    private Object f348063a;

    /* renamed from: b, reason: collision with root package name */
    private Object f348064b;

    /* renamed from: c, reason: collision with root package name */
    private Object f348065c;

    /* renamed from: d, reason: collision with root package name */
    private String f348066d;

    /* renamed from: e, reason: collision with root package name */
    private InvocationHandler f348067e;

    private void a() {
        try {
            JarReflectUtil.callSpecifiedStaticMethod("com.tencent.rtmp.TXLiveBase", "setLibraryPath", false, JarReflectUtil.getParamsClass(String.class), this.f348066d);
            JarReflectUtil.callSpecifiedStaticMethod("com.tencent.rtmp.TXLiveBase", "setListener", false, JarReflectUtil.getParamsClass(Class.forName("com.tencent.rtmp.ITXLiveBaseListener")), Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{Class.forName("com.tencent.rtmp.ITXLiveBaseListener")}, this.f348067e));
        } catch (ClassNotFoundException e16) {
            QMLog.e("TRTCDynamicProxy", "TXLiveBase.setListener failed:", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void hookListenerAndGoOn(String str, InvocationHandler invocationHandler) {
        a();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void init(Context context, InvocationHandler invocationHandler, InvocationHandler invocationHandler2) {
        this.f348063a = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.WXLivePlayConfig", null, new Object[0]);
        this.f348064b = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.WXLivePlayer", JarReflectUtil.getParamsClass(Context.class), context);
        txLivePlayer_enableHardwareDecode(Boolean.TRUE);
        try {
            JarReflectUtil.callSpecifiedMethod(this.f348064b, "setConfig", false, JarReflectUtil.getParamsClass(Class.forName("com.tencent.rtmp.WXLivePlayConfig")), this.f348063a);
            txLivePlayer_setPlayListener(Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{ITXLivePlayListener.class}, invocationHandler));
            txLivePlayer_setAudioVolumeEvaluationListener(Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{TXLivePlayer.ITXAudioVolumeEvaluationListener.class}, invocationHandler2));
        } catch (ClassNotFoundException e16) {
            QMLog.e("TRTCDynamicProxy", "bind InnerTXLivePlayListenerImpl failed, e" + e16.toString());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void initLivePlayer(Object obj, Bundle bundle) {
        this.f348065c = obj;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public boolean needLoadAvJar() {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txCloudVideoView_disableLog(Boolean bool) {
        JarReflectUtil.callSpecifiedMethod(this.f348065c, "disableLog", false, JarReflectUtil.getParamsClass(Boolean.TYPE), bool);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txCloudVideoView_showLog(Boolean bool) {
        JarReflectUtil.callSpecifiedMethod(this.f348065c, "showLog", false, JarReflectUtil.getParamsClass(Boolean.TYPE), bool);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayConfig_setAutoAdjustCacheTime(Boolean bool) {
        JarReflectUtil.callSpecifiedMethod(this.f348063a, "setAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(Boolean.TYPE), bool);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayConfig_setCacheTime(float f16) {
        JarReflectUtil.callSpecifiedMethod(this.f348063a, "setCacheTime", false, JarReflectUtil.getParamsClass(Float.TYPE), Float.valueOf(f16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayConfig_setEnableMetaData(Boolean bool) {
        JarReflectUtil.callSpecifiedMethod(this.f348063a, "setEnableMetaData", false, JarReflectUtil.getParamsClass(Boolean.TYPE), bool);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayConfig_setMaxAutoAdjustCacheTime(float f16) {
        JarReflectUtil.callSpecifiedMethod(this.f348063a, "setMaxAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(Float.TYPE), Float.valueOf(f16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayConfig_setMinAutoAdjustCacheTime(float f16) {
        JarReflectUtil.callSpecifiedMethod(this.f348063a, "setMinAutoAdjustCacheTime", false, JarReflectUtil.getParamsClass(Float.TYPE), Float.valueOf(f16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlay_snapshot(InvocationHandler invocationHandler) {
        try {
            JarReflectUtil.callSpecifiedMethod(this.f348064b, "snapshot", false, JarReflectUtil.getParamsClass(TXLivePlayer.ITXSnapshotListener.class), Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{TXLivePlayer.ITXSnapshotListener.class}, invocationHandler));
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_enableAudioVolumeEvaluation(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348064b, "enableAudioVolumeEvaluation", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_enableHardwareDecode(Boolean bool) {
        JarReflectUtil.callSpecifiedMethod(this.f348064b, "enableHardwareDecode", false, JarReflectUtil.getParamsClass(Boolean.TYPE), bool);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public boolean txLivePlayer_isPlaying() {
        Object callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(this.f348064b, "isPlaying", false, null, new Object[0]);
        if (callSpecifiedMethod == null) {
            return false;
        }
        return ((Boolean) callSpecifiedMethod).booleanValue();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_muteAudio(Boolean bool) {
        JarReflectUtil.callSpecifiedMethod(this.f348064b, "muteAudio", false, JarReflectUtil.getParamsClass(Boolean.TYPE), bool);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_muteVideo(Boolean bool) {
        JarReflectUtil.callSpecifiedMethod(this.f348064b, "muteVideo", false, JarReflectUtil.getParamsClass(Boolean.TYPE), bool);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_pause() {
        JarReflectUtil.callSpecifiedMethod(this.f348064b, "pause", false, null, new Object[0]);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_resume() {
        JarReflectUtil.callSpecifiedMethod(this.f348064b, "resume", false, null, new Object[0]);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setAudioRoute(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348064b, V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute, false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setAudioVolumeEvaluationListener(Object obj) {
        try {
            JarReflectUtil.callSpecifiedMethod(this.f348064b, "setAudioVolumeEvaluationListener", false, JarReflectUtil.getParamsClass(TXLivePlayer.ITXAudioVolumeEvaluationListener.class), obj);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setConfig() {
        try {
            JarReflectUtil.callSpecifiedMethod(this.f348064b, "setConfig", false, JarReflectUtil.getParamsClass(Class.forName("com.tencent.rtmp.WXLivePlayConfig")), this.f348063a);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setPlayListener(Object obj) {
        try {
            JarReflectUtil.callSpecifiedMethod(this.f348064b, "setPlayListener", false, JarReflectUtil.getParamsClass(ITXLivePlayListener.class), obj);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setPlayerView(Object obj) {
        this.f348065c = null;
        try {
            Object obj2 = this.f348064b;
            int i3 = TXCloudVideoView.f368796m;
            JarReflectUtil.callSpecifiedMethod(obj2, "setPlayerView", false, JarReflectUtil.getParamsClass(TXCloudVideoView.class), obj);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setRenderMode(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348064b, "setRenderMode", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setRenderRotation(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348064b, "setRenderRotation", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setSurface(Surface surface) {
        JarReflectUtil.callSpecifiedMethod(this.f348064b, V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, false, JarReflectUtil.getParamsClass(Surface.class), surface);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_setSurfaceSize(int i3, int i16) {
        Object obj = this.f348064b;
        Class cls = Integer.TYPE;
        JarReflectUtil.callSpecifiedMethod(obj, V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize, false, JarReflectUtil.getParamsClass(cls, cls), Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txLivePlayer_showDebugLog(Boolean bool) {
        JarReflectUtil.callSpecifiedMethod(this.f348064b, "showDebugLog", false, JarReflectUtil.getParamsClass(Boolean.TYPE), bool);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public int txLivePlayer_startPlay(String str, int i3) {
        Object callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(this.f348064b, "startPlay", false, JarReflectUtil.getParamsClass(String.class, Integer.TYPE), str, Integer.valueOf(i3));
        if (callSpecifiedMethod != null) {
            return ((Integer) callSpecifiedMethod).intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public int txLivePlayer_stopPlay(Boolean bool) {
        Object callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(this.f348064b, QZoneJsConstants.METHOD_RECORDER_STOP_PLAY, false, JarReflectUtil.getParamsClass(Boolean.TYPE), bool);
        if (callSpecifiedMethod != null) {
            return ((Integer) callSpecifiedMethod).intValue();
        }
        return -1;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void txPlayConfig_setEnableMessage(Boolean bool) {
        JarReflectUtil.callSpecifiedMethod(this.f348063a, "setEnableMessage", false, JarReflectUtil.getParamsClass(Boolean.TYPE), bool);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
    public void updateLivePlayer(Bundle bundle) {
    }
}
