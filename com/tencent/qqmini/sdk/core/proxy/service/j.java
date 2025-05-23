package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.TXLivePushListenerReflect;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.JarReflectUtil;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* compiled from: P */
@ProxyService(proxy = IWXLivePusherProxy.class)
/* loaded from: classes23.dex */
public class j implements IWXLivePusherProxy {

    /* renamed from: a, reason: collision with root package name */
    private Object f348068a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f348069b = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.WXLivePushConfig", null, new Object[0]);

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void enableAGC(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "enableAGC", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void enableANS(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "enableANS", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void enableAudioEarMonitoring(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "enableAudioEarMonitoring", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void enablePureAudioPush(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "enablePureAudioPush", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void initInstance(Context context) {
        this.f348068a = JarReflectUtil.creatSpecifiedObject("com.tencent.rtmp.WXLivePusher", JarReflectUtil.getParamsClass(Context.class), context);
        setConfig();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean isPushing() {
        Boolean bool = (Boolean) JarReflectUtil.callSpecifiedMethod(this.f348068a, "isPushing", false, null, new Object[0]);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public Object newITXLivePushListener(TXLivePushListenerReflect.ITXLivePushListener iTXLivePushListener) {
        try {
            return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{ITXLivePushListener.class}, new TXLivePushListenerReflect.TXLivePushListenerInvocationHandler(iTXLivePushListener));
        } catch (ClassNotFoundException e16) {
            QMLog.e("WXLivePusherReflect", "newInstance", e16);
            return null;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public Object newITXSnapshotListener(TXLivePushListenerReflect.ITXSnapshotListener iTXSnapshotListener) {
        try {
            return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{TXLivePusher.ITXSnapshotListener.class}, new TXLivePushListenerReflect.ITXSnapshotListenerInvocationHandler(iTXSnapshotListener));
        } catch (ClassNotFoundException e16) {
            QMLog.e("WXLivePusherReflect", "newInstance", e16);
            return null;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public Object newOnBGMNotify(TXLivePushListenerReflect.OnBGMNotify onBGMNotify) {
        try {
            return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{TXLivePusher.OnBGMNotify.class}, new TXLivePushListenerReflect.OnBGMNotifyInvocationHandler(onBGMNotify));
        } catch (ClassNotFoundException e16) {
            QMLog.e("WXLivePusherReflect", "newInstance", e16);
            return null;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean pauseBGM() {
        Object callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(this.f348068a, "pauseBGM", false, null, new Object[0]);
        if (!(callSpecifiedMethod instanceof Boolean) || !((Boolean) callSpecifiedMethod).booleanValue()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void pausePusher() {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "pausePusher", false, null, new Object[0]);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean playBGM(String str) {
        Object callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(this.f348068a, com.tencent.luggage.wxa.c8.c.f123373g0, false, JarReflectUtil.getParamsClass(String.class), str);
        if ((callSpecifiedMethod instanceof Boolean) && ((Boolean) callSpecifiedMethod).booleanValue()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean resumeBGM() {
        Object callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(this.f348068a, "resumeBGM", false, null, new Object[0]);
        if (!(callSpecifiedMethod instanceof Boolean) || !((Boolean) callSpecifiedMethod).booleanValue()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void resumePusher() {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "resumePusher", false, null, new Object[0]);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean sendMessageEx(byte[] bArr) {
        Boolean bool = (Boolean) JarReflectUtil.callSpecifiedMethod(this.f348068a, "sendMessageEx", false, JarReflectUtil.getParamsClass(byte[].class), bArr);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setAudioSampleRate(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setAudioSampleRate", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setBGMNofify(Object obj) {
        try {
            JarReflectUtil.callSpecifiedMethod(this.f348068a, "setBGMNofify", false, JarReflectUtil.getParamsClass(TXLivePusher.OnBGMNotify.class), obj);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setBGMPosition(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "setBGMPosition", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean setBGMVolume(float f16) {
        Object callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(this.f348068a, "setBGMVolume", false, JarReflectUtil.getParamsClass(Float.TYPE), Float.valueOf(f16));
        if ((callSpecifiedMethod instanceof Boolean) && ((Boolean) callSpecifiedMethod).booleanValue()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setBeautyFilter(int i3, int i16, int i17, int i18) {
        Object obj = this.f348068a;
        Class cls = Integer.TYPE;
        JarReflectUtil.callSpecifiedMethod(obj, "setBeautyFilter", false, JarReflectUtil.getParamsClass(cls, cls, cls, cls), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setConfig() {
        try {
            JarReflectUtil.callSpecifiedMethod(this.f348068a, "setConfig", false, JarReflectUtil.getParamsClass(Class.forName("com.tencent.rtmp.WXLivePushConfig")), this.f348069b);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setEnableCamera(JSONObject jSONObject, Object obj) {
        if (jSONObject != null && jSONObject.optBoolean("enable-camera", true)) {
            JarReflectUtil.callSpecifiedMethod(this.f348068a, "startCameraPreview", false, JarReflectUtil.getParamsClass(obj.getClass()), obj);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setEnableZoom(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setEnableZoom", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setFrontCamera(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setFrontCamera", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setHomeOrientation(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setHomeOrientation", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setLocalVideoMirrorType(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setLocalVideoMirrorType", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMaxVideoBitrate(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setMaxVideoBitrate", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMicVolume(float f16) {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "setMicVolume", false, JarReflectUtil.getParamsClass(Float.TYPE), Float.valueOf(f16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMinVideoBitrate(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setMinVideoBitrate", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMirror(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "setMirror", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMode(JSONObject jSONObject) {
        String str;
        if (jSONObject != null) {
            String optString = jSONObject.optString("mode", "RTC");
            if ("SD".equals(optString)) {
                str = "VIDEO_QUALITY_STANDARD_DEFINITION";
            } else if ("HD".equals(optString)) {
                str = "VIDEO_QUALITY_HIGH_DEFINITION";
            } else if ("FHD".equals(optString)) {
                str = "VIDEO_QUALITY_SUPER_DEFINITION";
            } else {
                QMLog.w("WXLivePusherReflect", "setMode unknown mode " + optString);
                str = "VIDEO_QUALITY_REALTIEM_VIDEOCHAT";
            }
            Object staticField = JarReflectUtil.getStaticField("com.tencent.rtmp.TXLiveConstants", str);
            if (staticField instanceof Integer) {
                Object obj = this.f348068a;
                Class cls = Boolean.TYPE;
                Class[] paramsClass = JarReflectUtil.getParamsClass(Integer.TYPE, cls, cls);
                Boolean bool = Boolean.TRUE;
                JarReflectUtil.callSpecifiedMethod(obj, "setVideoQuality", false, paramsClass, staticField, bool, bool);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setMuted(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "setMute", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setPauseFlag(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setPauseFlag", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setPushListener(Object obj) {
        try {
            JarReflectUtil.callSpecifiedMethod(this.f348068a, "setPushListener", false, JarReflectUtil.getParamsClass(ITXLivePushListener.class), obj);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setPusherUrl(String str) {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "setPusherUrl", false, JarReflectUtil.getParamsClass(String.class), str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setRenderRotation(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "setRenderRotation", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setReverb(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "setReverb", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setSurface(Surface surface) {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurface, false, JarReflectUtil.getParamsClass(Surface.class), surface);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setSurfaceSize(int i3, int i16) {
        Object obj = this.f348068a;
        Class cls = Integer.TYPE;
        JarReflectUtil.callSpecifiedMethod(obj, V2TXLiveDefInner.TXLivePropertyKey.kV2SetSurfaceSize, false, JarReflectUtil.getParamsClass(cls, cls), Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setTouchFocus(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setTouchFocus", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setVideoEncodeGop(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setVideoEncodeGop", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setVideoQuality(int i3, boolean z16, boolean z17) {
        Object obj = this.f348068a;
        Class cls = Boolean.TYPE;
        JarReflectUtil.callSpecifiedMethod(obj, "setVideoQuality", false, JarReflectUtil.getParamsClass(Integer.TYPE, cls, cls), Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setVideoResolution(int i3, int i16) {
        Object obj = this.f348069b;
        Class cls = Integer.TYPE;
        JarReflectUtil.callSpecifiedMethod(obj, "setVideoResolution", false, JarReflectUtil.getParamsClass(cls, cls), Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setVolumeType(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setVolumeType", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void showDebugLog(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "showDebugLog", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void snapshot(Object obj) {
        try {
            JarReflectUtil.callSpecifiedMethod(this.f348068a, "snapshot", false, JarReflectUtil.getParamsClass(TXLivePusher.ITXSnapshotListener.class), obj);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void startAudioRecord() {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "startAudioRecord", false, null, new Object[0]);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void startCameraPreview(Object obj) {
        try {
            Object obj2 = this.f348068a;
            int i3 = TXCloudVideoView.f368796m;
            JarReflectUtil.callSpecifiedMethod(obj2, "startCameraPreview", false, JarReflectUtil.getParamsClass(TXCloudVideoView.class), obj);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public int startDumpAudioData(String str) {
        Integer num = (Integer) JarReflectUtil.callSpecifiedMethod(this.f348068a, "startDumpAudioData", false, JarReflectUtil.getParamsClass(String.class), str);
        if (num != null) {
            return num.intValue();
        }
        return -10;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean startPusher(String str) {
        Object callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(this.f348068a, "startPusher", false, JarReflectUtil.getParamsClass(String.class), str);
        if ((callSpecifiedMethod instanceof Integer) && ((Integer) callSpecifiedMethod).intValue() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void stopAudioRecord() {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "stopAudioRecord", false, null, new Object[0]);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean stopBGM() {
        Object callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(this.f348068a, "stopBGM", false, null, new Object[0]);
        if (!(callSpecifiedMethod instanceof Boolean) || !((Boolean) callSpecifiedMethod).booleanValue()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void stopCameraPreview(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "stopCameraPreview", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void stopDumpAudioData() {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "stopDumpAudioData", false, null, new Object[0]);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void stopPusher() {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "stopPusher", false, null, new Object[0]);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void switchCamera() {
        JarReflectUtil.callSpecifiedMethod(this.f348068a, "switchCamera", false, null, new Object[0]);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void toggleTorch(Object obj) {
        QMLog.w("WXLivePusherReflect", "toggleTorch: not implement");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public boolean turnOnFlashLight(boolean z16) {
        Boolean bool = (Boolean) JarReflectUtil.callSpecifiedMethod(this.f348068a, "turnOnFlashLight", false, JarReflectUtil.getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void txCloudVideoView_disableLog(Boolean bool, Object obj) {
        JarReflectUtil.callSpecifiedMethod(obj, "disableLog", false, JarReflectUtil.getParamsClass(Boolean.TYPE), bool);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void txLivePlayer_setVisibility(int i3, Object obj) {
        JarReflectUtil.callSpecifiedMethod(obj, "setVisibility", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setVideoResolution(int i3) {
        JarReflectUtil.callSpecifiedMethod(this.f348069b, "setVideoResolution", false, JarReflectUtil.getParamsClass(Integer.TYPE), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setPauseImg(String str) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void updateLivePusher(Bundle bundle) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void initLivePusher(Object obj, Bundle bundle) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePusherProxy
    public void setWatermark(String str, float f16, float f17, float f18) {
    }
}
